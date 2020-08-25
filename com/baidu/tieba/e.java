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
/* loaded from: classes2.dex */
public class e extends Dialog {
    private View dividerLine;
    private LinearLayout fmA;
    private TextView fmB;
    private TextView fmC;
    private TextView fmD;
    private View fmE;
    private LinearLayout fmF;
    private a fmG;
    private View.OnClickListener fmH;
    private View.OnClickListener fmI;
    private boolean fmJ;
    private boolean fmK;
    private VersionData fmh;
    private CombineDownload fmi;
    private boolean fmj;
    private boolean fmk;
    private boolean fml;
    private LinearLayout fmm;
    private TextView fmn;
    private TextView fmo;
    private TextView fmq;
    private String fmr;
    private TextView fms;
    private TextView fmt;
    private TextView fmu;
    private TextView fmv;
    private ImageView fmw;
    private TextView fmx;
    private TextView fmy;
    private View fmz;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes2.dex */
    interface a {
        void bAp();

        void bAq();

        void kk(boolean z);

        void kl(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.fmj = false;
        this.mOtherApkSelected = true;
        this.fmk = false;
        this.fml = false;
        this.fmJ = true;
        this.fmK = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.this.fmu.getId()) {
                    e.this.fmG.bAp();
                    e.this.et(e.this.mContext);
                } else if (view.getId() == e.this.fmw.getId()) {
                    e.this.fmG.bAp();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.fmm = (LinearLayout) findViewById(R.id.app_info);
        this.fmn = (TextView) findViewById(R.id.app_version_and_size);
        this.fmo = (TextView) findViewById(R.id.app_description);
        this.fmv = (TextView) findViewById(R.id.fullsize_download_button);
        this.fmt = (TextView) findViewById(R.id.cancel_download_button);
        this.fmu = (TextView) findViewById(R.id.btn_update_save_flow);
        this.fmw = (ImageView) findViewById(R.id.img_close);
        this.fmu.setOnClickListener(this.mOnClickListener);
        this.fmw.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.fmq = (TextView) findViewById(R.id.download_process);
        this.fmx = (TextView) findViewById(R.id.incremental_download_button);
        this.fmy = (TextView) findViewById(R.id.not_install_as_tip);
        this.fmz = findViewById(R.id.incremental_download_layout);
        this.fms = (TextView) findViewById(R.id.other_app_recommend);
        this.fmE = findViewById(R.id.divider_under_button);
        this.fmF = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.fmr = this.fmq.getText().toString();
        this.fmA = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.fmC = (TextView) findViewById(R.id.sure_cancel);
        this.fmD = (TextView) findViewById(R.id.cancel_button);
        this.fmB = (TextView) findViewById(R.id.cancel_tip);
        this.fmC.setOnClickListener(this.fmH);
        this.fmD.setOnClickListener(this.fmI);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.fmJ = true;
        } else {
            this.fmJ = false;
        }
        String size = this.fmh.getSize();
        String newVersion = this.fmh.getNewVersion();
        String newVersionDesc = this.fmh.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.fmn.setText(sb.toString());
        this.fmo.setText(newVersionDesc);
        if (this.fmh.forceUpdate()) {
            this.fml = true;
            this.fmt.setText(this.mContext.getString(R.string.quit));
            this.fmu.setVisibility(8);
            this.fmw.setVisibility(8);
        } else if (this.fmh.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.fmt.setVisibility(8);
        } else {
            this.fmt.setText(this.mContext.getString(R.string.update_after));
            this.fmu.setVisibility(8);
            this.fmw.setVisibility(8);
        }
        if (this.fmi != null && this.fmi.showCombineDownload() && !TextUtils.isEmpty(this.fmi.getApkMD5RSA())) {
            this.fms.setText(this.fmi.getAppName());
            if (!y.isInstalledPackage(this.mContext, this.fmi.getAppProc()) && !TextUtils.isEmpty(this.fmi.getAppUrl())) {
                this.fms.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.fms.setCompoundDrawables(drawable, null, null, null);
                this.fmj = true;
            } else {
                this.fms.setVisibility(8);
                this.fmj = false;
            }
        } else {
            this.fms.setVisibility(8);
            this.fmj = false;
        }
        ki(this.fmJ);
        this.fmv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                e.this.fmk = true;
                if (e.this.mOtherApkSelected) {
                    Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.fms.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.fmG.kk(e.this.mOtherApkSelected);
            }
        });
        this.fmx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.fmK) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                e.this.fmx.setEnabled(false);
                e.this.fmG.kl(e.this.mOtherApkSelected);
            }
        });
        this.fmt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.fmG.bAp();
            }
        });
        this.fms.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.fmk) {
                    if (e.this.mOtherApkSelected) {
                        Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.fms.setCompoundDrawables(drawable2, null, null, null);
                        e.this.fmj = false;
                        e.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = ap.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.fms.setCompoundDrawables(drawable3, null, null, null);
                    e.this.fmj = true;
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

    public void ki(boolean z) {
        if (g.a(this.mContext.getPackageManager())) {
            this.fmy.setVisibility(8);
        } else {
            this.fmy.setVisibility(0);
        }
        if (z) {
            if (this.fmh == null || TextUtils.isEmpty(this.fmh.getPatch()) || this.fmh.getNewVersionCode() < 0) {
                this.fmz.setVisibility(0);
                this.fmx.setText(R.string.super_update);
                ap.setBackgroundResource(this.fmx, R.drawable.dialog_middle_item_bg_selector);
                this.fmF.setVisibility(0);
                this.fmK = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.fmz.setVisibility(0);
            this.fmx.setText(R.string.incremental_update);
            ap.setBackgroundResource(this.fmx, R.drawable.dialog_single_button_bg_selector);
            this.fmE.setVisibility(8);
            this.fmF.setVisibility(8);
            this.fmK = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.fmh == null || TextUtils.isEmpty(this.fmh.getPatch()) || this.fmh.getNewVersionCode() < 0) {
            this.fmz.setVisibility(8);
            this.fmF.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.fmz.setVisibility(0);
            ap.setBackgroundResource(this.fmx, R.drawable.dialog_middle_item_bg_selector);
            this.fmx.setText(R.string.incremental_update);
            this.fmF.setVisibility(0);
            this.fmK = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.fmv.setVisibility(8);
        this.fmz.setVisibility(8);
        this.fmt.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.fmk = true;
        this.fmF.setVisibility(0);
        this.fmq.setVisibility(0);
        this.fmq.setText(this.fmr + i + "%");
        this.fmw.setVisibility(8);
        this.fmu.setVisibility(8);
    }

    public void kj(boolean z) {
        this.fmv.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.fmk) {
            this.fmG.stopService();
            this.fmm.setVisibility(8);
            if (this.fml) {
                this.fmB.setText(getContext().getString(R.string.download_exit));
            }
            this.fmA.setVisibility(0);
            return;
        }
        this.fmG.bAq();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.fmh = versionData;
        this.fmi = combineDownload;
        this.fmG = aVar;
    }

    public void bAo() {
        this.fmA.setVisibility(8);
        this.fmm.setVisibility(0);
    }

    public void j(View.OnClickListener onClickListener) {
        this.fmH = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.fmI = onClickListener;
    }

    public void f(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        ap.setImageResource(this.fmw, R.drawable.write_close_selector);
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
