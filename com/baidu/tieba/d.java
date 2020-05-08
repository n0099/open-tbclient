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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.switchs.UpdateDialogStyleSyncSwitch;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes.dex */
public class d extends Dialog {
    private View cDC;
    private boolean dfp;
    private View dividerLine;
    private LinearLayout ewA;
    private TextView ewB;
    private TextView ewC;
    private TextView ewD;
    private LinearLayout ewE;
    private a ewF;
    private View.OnClickListener ewG;
    private View.OnClickListener ewH;
    private boolean ewI;
    private boolean ewJ;
    private VersionData ewj;
    private CombineDownload ewk;
    private boolean ewl;
    private boolean ewm;
    private LinearLayout ewn;
    private TextView ewo;
    private TextView ewp;
    private TextView ewq;
    private String ewr;
    private TextView ews;
    private TextView ewt;
    private TextView ewu;
    private TextView ewv;
    private ImageView eww;
    private TextView ewx;
    private TextView ewy;
    private View ewz;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void beX();

        void beY();

        void iy(boolean z);

        void iz(boolean z);

        void stopService();
    }

    public d(Context context, int i) {
        super(context, i);
        this.ewl = false;
        this.mOtherApkSelected = true;
        this.dfp = false;
        this.ewm = false;
        this.ewI = true;
        this.ewJ = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.this.ewu.getId()) {
                    d.this.ewF.beX();
                    d.this.dO(d.this.mContext);
                } else if (view.getId() == d.this.eww.getId()) {
                    d.this.ewF.beX();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.ewn = (LinearLayout) findViewById(R.id.app_info);
        this.ewo = (TextView) findViewById(R.id.app_version_and_size);
        this.ewp = (TextView) findViewById(R.id.app_description);
        this.ewv = (TextView) findViewById(R.id.fullsize_download_button);
        this.ewt = (TextView) findViewById(R.id.cancel_download_button);
        this.ewu = (TextView) findViewById(R.id.btn_update_save_flow);
        this.eww = (ImageView) findViewById(R.id.img_close);
        this.ewu.setOnClickListener(this.mOnClickListener);
        this.eww.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.ewq = (TextView) findViewById(R.id.download_process);
        this.ewx = (TextView) findViewById(R.id.incremental_download_button);
        this.ewy = (TextView) findViewById(R.id.not_install_as_tip);
        this.ewz = findViewById(R.id.incremental_download_layout);
        this.ews = (TextView) findViewById(R.id.other_app_recommend);
        this.cDC = findViewById(R.id.divider_under_button);
        this.ewE = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.ewr = this.ewq.getText().toString();
        this.ewA = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.ewC = (TextView) findViewById(R.id.sure_cancel);
        this.ewD = (TextView) findViewById(R.id.cancel_button);
        this.ewB = (TextView) findViewById(R.id.cancel_tip);
        this.ewC.setOnClickListener(this.ewG);
        this.ewD.setOnClickListener(this.ewH);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.ewI = true;
        } else {
            this.ewI = false;
        }
        String size = this.ewj.getSize();
        String newVersion = this.ewj.getNewVersion();
        String newVersionDesc = this.ewj.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.ewo.setText(sb.toString());
        this.ewp.setText(newVersionDesc);
        if (this.ewj.forceUpdate()) {
            this.ewm = true;
            this.ewt.setText(this.mContext.getString(R.string.quit));
            this.ewu.setVisibility(8);
            this.eww.setVisibility(8);
        } else if (this.ewj.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.ewt.setVisibility(8);
        } else {
            this.ewt.setText(this.mContext.getString(R.string.update_after));
            this.ewu.setVisibility(8);
            this.eww.setVisibility(8);
        }
        if (this.ewk != null && this.ewk.showCombineDownload() && !TextUtils.isEmpty(this.ewk.getApkMD5RSA())) {
            this.ews.setText(this.ewk.getAppName());
            if (!x.isInstalledPackage(this.mContext, this.ewk.getAppProc()) && !TextUtils.isEmpty(this.ewk.getAppUrl())) {
                this.ews.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.ews.setCompoundDrawables(drawable, null, null, null);
                this.ewl = true;
            } else {
                this.ews.setVisibility(8);
                this.ewl = false;
            }
        } else {
            this.ews.setVisibility(8);
            this.ewl = false;
        }
        iw(this.ewI);
        this.ewv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                d.this.dfp = true;
                if (d.this.mOtherApkSelected) {
                    Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    d.this.ews.setCompoundDrawables(drawable2, null, null, null);
                }
                d.this.ewF.iy(d.this.mOtherApkSelected);
            }
        });
        this.ewx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ewJ) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                d.this.ewx.setEnabled(false);
                d.this.ewF.iz(d.this.mOtherApkSelected);
            }
        });
        this.ewt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.ewF.beX();
            }
        });
        this.ews.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.dfp) {
                    if (d.this.mOtherApkSelected) {
                        Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        d.this.ews.setCompoundDrawables(drawable2, null, null, null);
                        d.this.ewl = false;
                        d.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = am.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    d.this.ews.setCompoundDrawables(drawable3, null, null, null);
                    d.this.ewl = true;
                    d.this.mOtherApkSelected = true;
                }
            }
        });
        Dh();
    }

    private void Dh() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void iw(boolean z) {
        if (f.a(this.mContext.getPackageManager())) {
            this.ewy.setVisibility(8);
        } else {
            this.ewy.setVisibility(0);
        }
        if (z) {
            if (this.ewj == null || TextUtils.isEmpty(this.ewj.getPatch()) || this.ewj.getNewVersionCode() < 0) {
                this.ewz.setVisibility(0);
                this.ewx.setText(R.string.super_update);
                am.setBackgroundResource(this.ewx, R.drawable.dialog_middle_item_bg_selector);
                this.ewE.setVisibility(0);
                this.ewJ = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.ewz.setVisibility(0);
            this.ewx.setText(R.string.incremental_update);
            am.setBackgroundResource(this.ewx, R.drawable.dialog_single_button_bg_selector);
            this.cDC.setVisibility(8);
            this.ewE.setVisibility(8);
            this.ewJ = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.ewj == null || TextUtils.isEmpty(this.ewj.getPatch()) || this.ewj.getNewVersionCode() < 0) {
            this.ewz.setVisibility(8);
            this.ewE.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.ewz.setVisibility(0);
            am.setBackgroundResource(this.ewx, R.drawable.dialog_middle_item_bg_selector);
            this.ewx.setText(R.string.incremental_update);
            this.ewE.setVisibility(0);
            this.ewJ = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.ewv.setVisibility(8);
        this.ewz.setVisibility(8);
        this.ewt.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.dfp = true;
        this.ewE.setVisibility(0);
        this.ewq.setVisibility(0);
        this.ewq.setText(this.ewr + i + "%");
        this.eww.setVisibility(8);
        this.ewu.setVisibility(8);
    }

    public void ix(boolean z) {
        this.ewv.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.dfp) {
            this.ewF.stopService();
            this.ewn.setVisibility(8);
            if (this.ewm) {
                this.ewB.setText(getContext().getString(R.string.download_exit));
            }
            this.ewA.setVisibility(0);
            return;
        }
        this.ewF.beY();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.ewj = versionData;
        this.ewk = combineDownload;
        this.ewF = aVar;
    }

    public void beW() {
        this.ewA.setVisibility(8);
        this.ewn.setVisibility(0);
    }

    public void i(View.OnClickListener onClickListener) {
        this.ewG = onClickListener;
    }

    public void j(View.OnClickListener onClickListener) {
        this.ewH = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        am.setImageResource(this.eww, R.drawable.write_close_selector);
    }

    public void dO(Context context) {
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
