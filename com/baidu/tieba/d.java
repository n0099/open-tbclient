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
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes.dex */
public class d extends Dialog {
    private boolean cBY;
    private View caf;
    private LinearLayout dRA;
    private TextView dRB;
    private TextView dRC;
    private TextView dRD;
    private String dRE;
    private TextView dRF;
    private TextView dRG;
    private TextView dRH;
    private TextView dRI;
    private ImageView dRJ;
    private TextView dRK;
    private TextView dRL;
    private View dRM;
    private LinearLayout dRN;
    private TextView dRO;
    private TextView dRP;
    private TextView dRQ;
    private LinearLayout dRR;
    private a dRS;
    private View.OnClickListener dRT;
    private View.OnClickListener dRU;
    private boolean dRV;
    private boolean dRW;
    private VersionData dRw;
    private CombineDownload dRx;
    private boolean dRy;
    private boolean dRz;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void aUw();

        void aUx();

        void hs(boolean z);

        void ht(boolean z);

        void stopService();
    }

    public d(Context context, int i) {
        super(context, i);
        this.dRy = false;
        this.mOtherApkSelected = true;
        this.cBY = false;
        this.dRz = false;
        this.dRV = true;
        this.dRW = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.this.dRH.getId()) {
                    d.this.dRS.aUw();
                    d.this.ek(d.this.mContext);
                } else if (view.getId() == d.this.dRJ.getId()) {
                    d.this.dRS.aUw();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.dRA = (LinearLayout) findViewById(R.id.app_info);
        this.dRB = (TextView) findViewById(R.id.app_version_and_size);
        this.dRC = (TextView) findViewById(R.id.app_description);
        this.dRI = (TextView) findViewById(R.id.fullsize_download_button);
        this.dRG = (TextView) findViewById(R.id.cancel_download_button);
        this.dRH = (TextView) findViewById(R.id.btn_update_save_flow);
        this.dRJ = (ImageView) findViewById(R.id.img_close);
        this.dRH.setOnClickListener(this.mOnClickListener);
        this.dRJ.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dRD = (TextView) findViewById(R.id.download_process);
        this.dRK = (TextView) findViewById(R.id.incremental_download_button);
        this.dRL = (TextView) findViewById(R.id.not_install_as_tip);
        this.dRM = findViewById(R.id.incremental_download_layout);
        this.dRF = (TextView) findViewById(R.id.other_app_recommend);
        this.caf = findViewById(R.id.divider_under_button);
        this.dRR = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.dRE = this.dRD.getText().toString();
        this.dRN = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.dRP = (TextView) findViewById(R.id.sure_cancel);
        this.dRQ = (TextView) findViewById(R.id.cancel_button);
        this.dRO = (TextView) findViewById(R.id.cancel_tip);
        this.dRP.setOnClickListener(this.dRT);
        this.dRQ.setOnClickListener(this.dRU);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.dRV = true;
        } else {
            this.dRV = false;
        }
        String size = this.dRw.getSize();
        String newVersion = this.dRw.getNewVersion();
        String newVersionDesc = this.dRw.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.dRB.setText(sb.toString());
        this.dRC.setText(newVersionDesc);
        if (this.dRw.forceUpdate()) {
            this.dRz = true;
            this.dRG.setText(this.mContext.getString(R.string.quit));
            this.dRH.setVisibility(8);
            this.dRJ.setVisibility(8);
        } else if (this.dRw.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.dRG.setVisibility(8);
        } else {
            this.dRG.setText(this.mContext.getString(R.string.update_after));
            this.dRH.setVisibility(8);
            this.dRJ.setVisibility(8);
        }
        if (this.dRx != null && this.dRx.showCombineDownload() && !TextUtils.isEmpty(this.dRx.getApkMD5RSA())) {
            this.dRF.setText(this.dRx.getAppName());
            if (!w.isInstalledPackage(this.mContext, this.dRx.getAppProc()) && !TextUtils.isEmpty(this.dRx.getAppUrl())) {
                this.dRF.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.dRF.setCompoundDrawables(drawable, null, null, null);
                this.dRy = true;
            } else {
                this.dRF.setVisibility(8);
                this.dRy = false;
            }
        } else {
            this.dRF.setVisibility(8);
            this.dRy = false;
        }
        hq(this.dRV);
        this.dRI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                d.this.cBY = true;
                if (d.this.mOtherApkSelected) {
                    Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    d.this.dRF.setCompoundDrawables(drawable2, null, null, null);
                }
                d.this.dRS.hs(d.this.mOtherApkSelected);
            }
        });
        this.dRK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dRW) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                d.this.dRK.setEnabled(false);
                d.this.dRS.ht(d.this.mOtherApkSelected);
            }
        });
        this.dRG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dRS.aUw();
            }
        });
        this.dRF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.cBY) {
                    if (d.this.mOtherApkSelected) {
                        Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        d.this.dRF.setCompoundDrawables(drawable2, null, null, null);
                        d.this.dRy = false;
                        d.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = am.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    d.this.dRF.setCompoundDrawables(drawable3, null, null, null);
                    d.this.dRy = true;
                    d.this.mOtherApkSelected = true;
                }
            }
        });
        initWindow();
    }

    private void initWindow() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void hq(boolean z) {
        if (g.a(this.mContext.getPackageManager())) {
            this.dRL.setVisibility(8);
        } else {
            this.dRL.setVisibility(0);
        }
        if (z) {
            if (this.dRw == null || TextUtils.isEmpty(this.dRw.getPatch()) || this.dRw.getNewVersionCode() < 0) {
                this.dRM.setVisibility(0);
                this.dRK.setText(R.string.super_update);
                am.setBackgroundResource(this.dRK, R.drawable.dialog_middle_item_bg_selector);
                this.dRR.setVisibility(0);
                this.dRW = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.dRM.setVisibility(0);
            this.dRK.setText(R.string.incremental_update);
            am.setBackgroundResource(this.dRK, R.drawable.dialog_single_button_bg_selector);
            this.caf.setVisibility(8);
            this.dRR.setVisibility(8);
            this.dRW = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.dRw == null || TextUtils.isEmpty(this.dRw.getPatch()) || this.dRw.getNewVersionCode() < 0) {
            this.dRM.setVisibility(8);
            this.dRR.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.dRM.setVisibility(0);
            am.setBackgroundResource(this.dRK, R.drawable.dialog_middle_item_bg_selector);
            this.dRK.setText(R.string.incremental_update);
            this.dRR.setVisibility(0);
            this.dRW = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.dRI.setVisibility(8);
        this.dRM.setVisibility(8);
        this.dRG.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.cBY = true;
        this.dRR.setVisibility(0);
        this.dRD.setVisibility(0);
        this.dRD.setText(this.dRE + i + "%");
        this.dRJ.setVisibility(8);
        this.dRH.setVisibility(8);
    }

    public void hr(boolean z) {
        this.dRI.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.cBY) {
            this.dRS.stopService();
            this.dRA.setVisibility(8);
            if (this.dRz) {
                this.dRO.setText(getContext().getString(R.string.download_exit));
            }
            this.dRN.setVisibility(0);
            return;
        }
        this.dRS.aUx();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.dRw = versionData;
        this.dRx = combineDownload;
        this.dRS = aVar;
    }

    public void aUv() {
        this.dRN.setVisibility(8);
        this.dRA.setVisibility(0);
    }

    public void i(View.OnClickListener onClickListener) {
        this.dRT = onClickListener;
    }

    public void j(View.OnClickListener onClickListener) {
        this.dRU = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        am.setImageResource(this.dRJ, R.drawable.write_close_selector);
    }

    public void ek(Context context) {
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
