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
    private boolean cFW;
    private View cel;
    private VersionData dVB;
    private CombineDownload dVC;
    private boolean dVD;
    private boolean dVE;
    private LinearLayout dVF;
    private TextView dVG;
    private TextView dVH;
    private TextView dVI;
    private String dVJ;
    private TextView dVK;
    private TextView dVL;
    private TextView dVM;
    private TextView dVN;
    private ImageView dVO;
    private TextView dVP;
    private TextView dVQ;
    private View dVR;
    private LinearLayout dVS;
    private TextView dVT;
    private TextView dVU;
    private TextView dVV;
    private LinearLayout dVW;
    private a dVX;
    private View.OnClickListener dVY;
    private View.OnClickListener dVZ;
    private boolean dWa;
    private boolean dWb;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void aWM();

        void aWN();

        void hA(boolean z);

        void hz(boolean z);

        void stopService();
    }

    public d(Context context, int i) {
        super(context, i);
        this.dVD = false;
        this.mOtherApkSelected = true;
        this.cFW = false;
        this.dVE = false;
        this.dWa = true;
        this.dWb = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.this.dVM.getId()) {
                    d.this.dVX.aWM();
                    d.this.en(d.this.mContext);
                } else if (view.getId() == d.this.dVO.getId()) {
                    d.this.dVX.aWM();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.dVF = (LinearLayout) findViewById(R.id.app_info);
        this.dVG = (TextView) findViewById(R.id.app_version_and_size);
        this.dVH = (TextView) findViewById(R.id.app_description);
        this.dVN = (TextView) findViewById(R.id.fullsize_download_button);
        this.dVL = (TextView) findViewById(R.id.cancel_download_button);
        this.dVM = (TextView) findViewById(R.id.btn_update_save_flow);
        this.dVO = (ImageView) findViewById(R.id.img_close);
        this.dVM.setOnClickListener(this.mOnClickListener);
        this.dVO.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dVI = (TextView) findViewById(R.id.download_process);
        this.dVP = (TextView) findViewById(R.id.incremental_download_button);
        this.dVQ = (TextView) findViewById(R.id.not_install_as_tip);
        this.dVR = findViewById(R.id.incremental_download_layout);
        this.dVK = (TextView) findViewById(R.id.other_app_recommend);
        this.cel = findViewById(R.id.divider_under_button);
        this.dVW = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.dVJ = this.dVI.getText().toString();
        this.dVS = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.dVU = (TextView) findViewById(R.id.sure_cancel);
        this.dVV = (TextView) findViewById(R.id.cancel_button);
        this.dVT = (TextView) findViewById(R.id.cancel_tip);
        this.dVU.setOnClickListener(this.dVY);
        this.dVV.setOnClickListener(this.dVZ);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.dWa = true;
        } else {
            this.dWa = false;
        }
        String size = this.dVB.getSize();
        String newVersion = this.dVB.getNewVersion();
        String newVersionDesc = this.dVB.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.dVG.setText(sb.toString());
        this.dVH.setText(newVersionDesc);
        if (this.dVB.forceUpdate()) {
            this.dVE = true;
            this.dVL.setText(this.mContext.getString(R.string.quit));
            this.dVM.setVisibility(8);
            this.dVO.setVisibility(8);
        } else if (this.dVB.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.dVL.setVisibility(8);
        } else {
            this.dVL.setText(this.mContext.getString(R.string.update_after));
            this.dVM.setVisibility(8);
            this.dVO.setVisibility(8);
        }
        if (this.dVC != null && this.dVC.showCombineDownload() && !TextUtils.isEmpty(this.dVC.getApkMD5RSA())) {
            this.dVK.setText(this.dVC.getAppName());
            if (!w.isInstalledPackage(this.mContext, this.dVC.getAppProc()) && !TextUtils.isEmpty(this.dVC.getAppUrl())) {
                this.dVK.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.dVK.setCompoundDrawables(drawable, null, null, null);
                this.dVD = true;
            } else {
                this.dVK.setVisibility(8);
                this.dVD = false;
            }
        } else {
            this.dVK.setVisibility(8);
            this.dVD = false;
        }
        hx(this.dWa);
        this.dVN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                d.this.cFW = true;
                if (d.this.mOtherApkSelected) {
                    Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    d.this.dVK.setCompoundDrawables(drawable2, null, null, null);
                }
                d.this.dVX.hz(d.this.mOtherApkSelected);
            }
        });
        this.dVP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dWb) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                d.this.dVP.setEnabled(false);
                d.this.dVX.hA(d.this.mOtherApkSelected);
            }
        });
        this.dVL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dVX.aWM();
            }
        });
        this.dVK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.cFW) {
                    if (d.this.mOtherApkSelected) {
                        Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        d.this.dVK.setCompoundDrawables(drawable2, null, null, null);
                        d.this.dVD = false;
                        d.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = am.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    d.this.dVK.setCompoundDrawables(drawable3, null, null, null);
                    d.this.dVD = true;
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
            this.dVQ.setVisibility(8);
        } else {
            this.dVQ.setVisibility(0);
        }
        if (z) {
            if (this.dVB == null || TextUtils.isEmpty(this.dVB.getPatch()) || this.dVB.getNewVersionCode() < 0) {
                this.dVR.setVisibility(0);
                this.dVP.setText(R.string.super_update);
                am.setBackgroundResource(this.dVP, R.drawable.dialog_middle_item_bg_selector);
                this.dVW.setVisibility(0);
                this.dWb = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.dVR.setVisibility(0);
            this.dVP.setText(R.string.incremental_update);
            am.setBackgroundResource(this.dVP, R.drawable.dialog_single_button_bg_selector);
            this.cel.setVisibility(8);
            this.dVW.setVisibility(8);
            this.dWb = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.dVB == null || TextUtils.isEmpty(this.dVB.getPatch()) || this.dVB.getNewVersionCode() < 0) {
            this.dVR.setVisibility(8);
            this.dVW.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.dVR.setVisibility(0);
            am.setBackgroundResource(this.dVP, R.drawable.dialog_middle_item_bg_selector);
            this.dVP.setText(R.string.incremental_update);
            this.dVW.setVisibility(0);
            this.dWb = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.dVN.setVisibility(8);
        this.dVR.setVisibility(8);
        this.dVL.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.cFW = true;
        this.dVW.setVisibility(0);
        this.dVI.setVisibility(0);
        this.dVI.setText(this.dVJ + i + "%");
        this.dVO.setVisibility(8);
        this.dVM.setVisibility(8);
    }

    public void hy(boolean z) {
        this.dVN.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.cFW) {
            this.dVX.stopService();
            this.dVF.setVisibility(8);
            if (this.dVE) {
                this.dVT.setText(getContext().getString(R.string.download_exit));
            }
            this.dVS.setVisibility(0);
            return;
        }
        this.dVX.aWN();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.dVB = versionData;
        this.dVC = combineDownload;
        this.dVX = aVar;
    }

    public void aWL() {
        this.dVS.setVisibility(8);
        this.dVF.setVisibility(0);
    }

    public void i(View.OnClickListener onClickListener) {
        this.dVY = onClickListener;
    }

    public void j(View.OnClickListener onClickListener) {
        this.dVZ = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        am.setImageResource(this.dVO, R.drawable.write_close_selector);
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
