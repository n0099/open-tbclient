package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.switchs.UpdateDialogStyleSyncSwitch;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes.dex */
public class e extends Dialog {
    private View dividerLine;
    private ImageView fmA;
    private TextView fmB;
    private TextView fmC;
    private View fmD;
    private LinearLayout fmE;
    private TextView fmF;
    private TextView fmG;
    private TextView fmH;
    private View fmI;
    private LinearLayout fmJ;
    private a fmK;
    private View.OnClickListener fmL;
    private View.OnClickListener fmM;
    private boolean fmN;
    private boolean fmO;
    private VersionData fml;
    private CombineDownload fmm;
    private boolean fmn;
    private boolean fmo;
    private boolean fmq;
    private LinearLayout fmr;
    private TextView fms;
    private TextView fmt;
    private TextView fmu;
    private String fmv;
    private TextView fmw;
    private TextView fmx;
    private TextView fmy;
    private TextView fmz;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void bAq();

        void bAr();

        void km(boolean z);

        void kn(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.fmn = false;
        this.mOtherApkSelected = true;
        this.fmo = false;
        this.fmq = false;
        this.fmN = true;
        this.fmO = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.this.fmy.getId()) {
                    e.this.fmK.bAq();
                    e.this.et(e.this.mContext);
                } else if (view.getId() == e.this.fmA.getId()) {
                    e.this.fmK.bAq();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.fmr = (LinearLayout) findViewById(R.id.app_info);
        this.fms = (TextView) findViewById(R.id.app_version_and_size);
        this.fmt = (TextView) findViewById(R.id.app_description);
        this.fmz = (TextView) findViewById(R.id.fullsize_download_button);
        this.fmx = (TextView) findViewById(R.id.cancel_download_button);
        this.fmy = (TextView) findViewById(R.id.btn_update_save_flow);
        this.fmA = (ImageView) findViewById(R.id.img_close);
        this.fmy.setOnClickListener(this.mOnClickListener);
        this.fmA.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.fmu = (TextView) findViewById(R.id.download_process);
        this.fmB = (TextView) findViewById(R.id.incremental_download_button);
        this.fmC = (TextView) findViewById(R.id.not_install_as_tip);
        this.fmD = findViewById(R.id.incremental_download_layout);
        this.fmw = (TextView) findViewById(R.id.other_app_recommend);
        this.fmI = findViewById(R.id.divider_under_button);
        this.fmJ = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.fmv = this.fmu.getText().toString();
        this.fmE = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.fmG = (TextView) findViewById(R.id.sure_cancel);
        this.fmH = (TextView) findViewById(R.id.cancel_button);
        this.fmF = (TextView) findViewById(R.id.cancel_tip);
        this.fmG.setOnClickListener(this.fmL);
        this.fmH.setOnClickListener(this.fmM);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.fmN = true;
        } else {
            this.fmN = false;
        }
        String size = this.fml.getSize();
        String newVersion = this.fml.getNewVersion();
        String newVersionDesc = this.fml.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.fms.setText(sb.toString());
        this.fmt.setText(newVersionDesc);
        if (this.fml.forceUpdate()) {
            this.fmq = true;
            this.fmx.setText(this.mContext.getString(R.string.quit));
            this.fmy.setVisibility(8);
            this.fmA.setVisibility(8);
        } else if (this.fml.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.fmx.setVisibility(8);
        } else {
            this.fmx.setText(this.mContext.getString(R.string.update_after));
            this.fmy.setVisibility(8);
            this.fmA.setVisibility(8);
        }
        if (this.fmm != null && this.fmm.showCombineDownload() && !TextUtils.isEmpty(this.fmm.getApkMD5RSA())) {
            this.fmw.setText(this.fmm.getAppName());
            if (!y.isInstalledPackage(this.mContext, this.fmm.getAppProc()) && !TextUtils.isEmpty(this.fmm.getAppUrl())) {
                this.fmw.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.fmw.setCompoundDrawables(drawable, null, null, null);
                this.fmn = true;
            } else {
                this.fmw.setVisibility(8);
                this.fmn = false;
            }
        } else {
            this.fmw.setVisibility(8);
            this.fmn = false;
        }
        kk(this.fmN);
        this.fmz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                e.this.fmo = true;
                if (e.this.mOtherApkSelected) {
                    Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.fmw.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.fmK.km(e.this.mOtherApkSelected);
            }
        });
        this.fmB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.fmO) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                e.this.fmB.setEnabled(false);
                e.this.fmK.kn(e.this.mOtherApkSelected);
            }
        });
        this.fmx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.fmK.bAq();
            }
        });
        this.fmw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.fmo) {
                    if (e.this.mOtherApkSelected) {
                        Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.fmw.setCompoundDrawables(drawable2, null, null, null);
                        e.this.fmn = false;
                        e.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = ap.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.fmw.setCompoundDrawables(drawable3, null, null, null);
                    e.this.fmn = true;
                    e.this.mOtherApkSelected = true;
                }
            }
        });
        Mt();
    }

    private void Mt() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void kk(boolean z) {
        if (g.a(this.mContext.getPackageManager())) {
            this.fmC.setVisibility(8);
        } else {
            this.fmC.setVisibility(0);
        }
        if (z) {
            if (this.fml == null || TextUtils.isEmpty(this.fml.getPatch()) || this.fml.getNewVersionCode() < 0) {
                this.fmD.setVisibility(0);
                this.fmB.setText(R.string.super_update);
                ap.setBackgroundResource(this.fmB, R.drawable.dialog_middle_item_bg_selector);
                this.fmJ.setVisibility(0);
                this.fmO = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.fmD.setVisibility(0);
            this.fmB.setText(R.string.incremental_update);
            ap.setBackgroundResource(this.fmB, R.drawable.dialog_single_button_bg_selector);
            this.fmI.setVisibility(8);
            this.fmJ.setVisibility(8);
            this.fmO = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.fml == null || TextUtils.isEmpty(this.fml.getPatch()) || this.fml.getNewVersionCode() < 0) {
            this.fmD.setVisibility(8);
            this.fmJ.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.fmD.setVisibility(0);
            ap.setBackgroundResource(this.fmB, R.drawable.dialog_middle_item_bg_selector);
            this.fmB.setText(R.string.incremental_update);
            this.fmJ.setVisibility(0);
            this.fmO = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.fmz.setVisibility(8);
        this.fmD.setVisibility(8);
        this.fmx.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.fmo = true;
        this.fmJ.setVisibility(0);
        this.fmu.setVisibility(0);
        this.fmu.setText(this.fmv + i + "%");
        this.fmA.setVisibility(8);
        this.fmy.setVisibility(8);
    }

    public void kl(boolean z) {
        this.fmz.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.fmo) {
            this.fmK.stopService();
            this.fmr.setVisibility(8);
            if (this.fmq) {
                this.fmF.setText(getContext().getString(R.string.download_exit));
            }
            this.fmE.setVisibility(0);
            return;
        }
        this.fmK.bAr();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.fml = versionData;
        this.fmm = combineDownload;
        this.fmK = aVar;
    }

    public void bAp() {
        this.fmE.setVisibility(8);
        this.fmr.setVisibility(0);
    }

    public void j(View.OnClickListener onClickListener) {
        this.fmL = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.fmM = onClickListener;
    }

    public void f(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        ap.setImageResource(this.fmA, R.drawable.write_close_selector);
    }

    public void et(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + context.getPackageName()));
        try {
            intent.setClassName("com.tencent.android.qqdownloader", "com.tencent.pangu.link.LinkProxyActivity");
            if (!(context instanceof Activity) && intent != null) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }
}
