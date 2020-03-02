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
    private boolean cFX;
    private View cem;
    private VersionData dVC;
    private CombineDownload dVD;
    private boolean dVE;
    private boolean dVF;
    private LinearLayout dVG;
    private TextView dVH;
    private TextView dVI;
    private TextView dVJ;
    private String dVK;
    private TextView dVL;
    private TextView dVM;
    private TextView dVN;
    private TextView dVO;
    private ImageView dVP;
    private TextView dVQ;
    private TextView dVR;
    private View dVS;
    private LinearLayout dVT;
    private TextView dVU;
    private TextView dVV;
    private TextView dVW;
    private LinearLayout dVX;
    private a dVY;
    private View.OnClickListener dVZ;
    private View.OnClickListener dWa;
    private boolean dWb;
    private boolean dWc;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void aWO();

        void aWP();

        void hA(boolean z);

        void hz(boolean z);

        void stopService();
    }

    public d(Context context, int i) {
        super(context, i);
        this.dVE = false;
        this.mOtherApkSelected = true;
        this.cFX = false;
        this.dVF = false;
        this.dWb = true;
        this.dWc = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.this.dVN.getId()) {
                    d.this.dVY.aWO();
                    d.this.en(d.this.mContext);
                } else if (view.getId() == d.this.dVP.getId()) {
                    d.this.dVY.aWO();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.dVG = (LinearLayout) findViewById(R.id.app_info);
        this.dVH = (TextView) findViewById(R.id.app_version_and_size);
        this.dVI = (TextView) findViewById(R.id.app_description);
        this.dVO = (TextView) findViewById(R.id.fullsize_download_button);
        this.dVM = (TextView) findViewById(R.id.cancel_download_button);
        this.dVN = (TextView) findViewById(R.id.btn_update_save_flow);
        this.dVP = (ImageView) findViewById(R.id.img_close);
        this.dVN.setOnClickListener(this.mOnClickListener);
        this.dVP.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dVJ = (TextView) findViewById(R.id.download_process);
        this.dVQ = (TextView) findViewById(R.id.incremental_download_button);
        this.dVR = (TextView) findViewById(R.id.not_install_as_tip);
        this.dVS = findViewById(R.id.incremental_download_layout);
        this.dVL = (TextView) findViewById(R.id.other_app_recommend);
        this.cem = findViewById(R.id.divider_under_button);
        this.dVX = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.dVK = this.dVJ.getText().toString();
        this.dVT = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.dVV = (TextView) findViewById(R.id.sure_cancel);
        this.dVW = (TextView) findViewById(R.id.cancel_button);
        this.dVU = (TextView) findViewById(R.id.cancel_tip);
        this.dVV.setOnClickListener(this.dVZ);
        this.dVW.setOnClickListener(this.dWa);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.dWb = true;
        } else {
            this.dWb = false;
        }
        String size = this.dVC.getSize();
        String newVersion = this.dVC.getNewVersion();
        String newVersionDesc = this.dVC.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.dVH.setText(sb.toString());
        this.dVI.setText(newVersionDesc);
        if (this.dVC.forceUpdate()) {
            this.dVF = true;
            this.dVM.setText(this.mContext.getString(R.string.quit));
            this.dVN.setVisibility(8);
            this.dVP.setVisibility(8);
        } else if (this.dVC.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.dVM.setVisibility(8);
        } else {
            this.dVM.setText(this.mContext.getString(R.string.update_after));
            this.dVN.setVisibility(8);
            this.dVP.setVisibility(8);
        }
        if (this.dVD != null && this.dVD.showCombineDownload() && !TextUtils.isEmpty(this.dVD.getApkMD5RSA())) {
            this.dVL.setText(this.dVD.getAppName());
            if (!w.isInstalledPackage(this.mContext, this.dVD.getAppProc()) && !TextUtils.isEmpty(this.dVD.getAppUrl())) {
                this.dVL.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.dVL.setCompoundDrawables(drawable, null, null, null);
                this.dVE = true;
            } else {
                this.dVL.setVisibility(8);
                this.dVE = false;
            }
        } else {
            this.dVL.setVisibility(8);
            this.dVE = false;
        }
        hx(this.dWb);
        this.dVO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                d.this.cFX = true;
                if (d.this.mOtherApkSelected) {
                    Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    d.this.dVL.setCompoundDrawables(drawable2, null, null, null);
                }
                d.this.dVY.hz(d.this.mOtherApkSelected);
            }
        });
        this.dVQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dWc) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                d.this.dVQ.setEnabled(false);
                d.this.dVY.hA(d.this.mOtherApkSelected);
            }
        });
        this.dVM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dVY.aWO();
            }
        });
        this.dVL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.cFX) {
                    if (d.this.mOtherApkSelected) {
                        Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        d.this.dVL.setCompoundDrawables(drawable2, null, null, null);
                        d.this.dVE = false;
                        d.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = am.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    d.this.dVL.setCompoundDrawables(drawable3, null, null, null);
                    d.this.dVE = true;
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

    public void hx(boolean z) {
        if (g.a(this.mContext.getPackageManager())) {
            this.dVR.setVisibility(8);
        } else {
            this.dVR.setVisibility(0);
        }
        if (z) {
            if (this.dVC == null || TextUtils.isEmpty(this.dVC.getPatch()) || this.dVC.getNewVersionCode() < 0) {
                this.dVS.setVisibility(0);
                this.dVQ.setText(R.string.super_update);
                am.setBackgroundResource(this.dVQ, R.drawable.dialog_middle_item_bg_selector);
                this.dVX.setVisibility(0);
                this.dWc = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.dVS.setVisibility(0);
            this.dVQ.setText(R.string.incremental_update);
            am.setBackgroundResource(this.dVQ, R.drawable.dialog_single_button_bg_selector);
            this.cem.setVisibility(8);
            this.dVX.setVisibility(8);
            this.dWc = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.dVC == null || TextUtils.isEmpty(this.dVC.getPatch()) || this.dVC.getNewVersionCode() < 0) {
            this.dVS.setVisibility(8);
            this.dVX.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.dVS.setVisibility(0);
            am.setBackgroundResource(this.dVQ, R.drawable.dialog_middle_item_bg_selector);
            this.dVQ.setText(R.string.incremental_update);
            this.dVX.setVisibility(0);
            this.dWc = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.dVO.setVisibility(8);
        this.dVS.setVisibility(8);
        this.dVM.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.cFX = true;
        this.dVX.setVisibility(0);
        this.dVJ.setVisibility(0);
        this.dVJ.setText(this.dVK + i + "%");
        this.dVP.setVisibility(8);
        this.dVN.setVisibility(8);
    }

    public void hy(boolean z) {
        this.dVO.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.cFX) {
            this.dVY.stopService();
            this.dVG.setVisibility(8);
            if (this.dVF) {
                this.dVU.setText(getContext().getString(R.string.download_exit));
            }
            this.dVT.setVisibility(0);
            return;
        }
        this.dVY.aWP();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.dVC = versionData;
        this.dVD = combineDownload;
        this.dVY = aVar;
    }

    public void aWN() {
        this.dVT.setVisibility(8);
        this.dVG.setVisibility(0);
    }

    public void i(View.OnClickListener onClickListener) {
        this.dVZ = onClickListener;
    }

    public void j(View.OnClickListener onClickListener) {
        this.dWa = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        am.setImageResource(this.dVP, R.drawable.write_close_selector);
    }

    public void en(Context context) {
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
