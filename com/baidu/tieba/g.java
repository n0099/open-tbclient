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
import com.baidu.tieba.tbadkCore.z;
/* loaded from: classes.dex */
public class g extends Dialog {
    private View dividerLine;
    private VersionData fXH;
    private CombineDownload fXI;
    private boolean fXJ;
    private boolean fXK;
    private boolean fXL;
    private LinearLayout fXM;
    private TextView fXN;
    private TextView fXO;
    private TextView fXP;
    private String fXQ;
    private TextView fXR;
    private TextView fXS;
    private TextView fXT;
    private TextView fXU;
    private ImageView fXV;
    private TextView fXW;
    private TextView fXX;
    private View fXY;
    private LinearLayout fXZ;
    private TextView fYa;
    private TextView fYb;
    private TextView fYc;
    private View fYd;
    private LinearLayout fYe;
    private a fYf;
    private View.OnClickListener fYg;
    private View.OnClickListener fYh;
    private boolean fYi;
    private boolean fYj;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void bLI();

        void bLJ();

        void lD(boolean z);

        void lE(boolean z);

        void stopService();
    }

    public g(Context context, int i) {
        super(context, i);
        this.fXJ = false;
        this.mOtherApkSelected = true;
        this.fXK = false;
        this.fXL = false;
        this.fYi = true;
        this.fYj = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == g.this.fXT.getId()) {
                    g.this.fYf.bLI();
                    g.this.fm(g.this.mContext);
                } else if (view.getId() == g.this.fXV.getId()) {
                    g.this.fYf.bLI();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.fXM = (LinearLayout) findViewById(R.id.app_info);
        this.fXN = (TextView) findViewById(R.id.app_version_and_size);
        this.fXO = (TextView) findViewById(R.id.app_description);
        this.fXU = (TextView) findViewById(R.id.fullsize_download_button);
        this.fXS = (TextView) findViewById(R.id.cancel_download_button);
        this.fXT = (TextView) findViewById(R.id.btn_update_save_flow);
        this.fXV = (ImageView) findViewById(R.id.img_close);
        this.fXT.setOnClickListener(this.mOnClickListener);
        this.fXV.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.fXP = (TextView) findViewById(R.id.download_process);
        this.fXW = (TextView) findViewById(R.id.incremental_download_button);
        this.fXX = (TextView) findViewById(R.id.not_install_as_tip);
        this.fXY = findViewById(R.id.incremental_download_layout);
        this.fXR = (TextView) findViewById(R.id.other_app_recommend);
        this.fYd = findViewById(R.id.divider_under_button);
        this.fYe = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.fXQ = this.fXP.getText().toString();
        this.fXZ = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.fYb = (TextView) findViewById(R.id.sure_cancel);
        this.fYc = (TextView) findViewById(R.id.cancel_button);
        this.fYa = (TextView) findViewById(R.id.cancel_tip);
        this.fYb.setOnClickListener(this.fYg);
        this.fYc.setOnClickListener(this.fYh);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.fYi = true;
        } else {
            this.fYi = false;
        }
        String size = this.fXH.getSize();
        String newVersion = this.fXH.getNewVersion();
        String newVersionDesc = this.fXH.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.fXN.setText(sb.toString());
        this.fXO.setText(newVersionDesc);
        if (this.fXH.forceUpdate()) {
            this.fXL = true;
            this.fXS.setText(this.mContext.getString(R.string.quit));
            this.fXT.setVisibility(8);
            this.fXV.setVisibility(8);
        } else if (this.fXH.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.fXS.setVisibility(8);
        } else {
            this.fXS.setText(this.mContext.getString(R.string.update_after));
            this.fXT.setVisibility(8);
            this.fXV.setVisibility(8);
        }
        if (this.fXI != null && this.fXI.showCombineDownload() && !TextUtils.isEmpty(this.fXI.getApkMD5RSA())) {
            this.fXR.setText(this.fXI.getAppName());
            if (!z.isInstalledPackage(this.mContext, this.fXI.getAppProc()) && !TextUtils.isEmpty(this.fXI.getAppUrl())) {
                this.fXR.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.fXR.setCompoundDrawables(drawable, null, null, null);
                this.fXJ = true;
            } else {
                this.fXR.setVisibility(8);
                this.fXJ = false;
            }
        } else {
            this.fXR.setVisibility(8);
            this.fXJ = false;
        }
        lB(this.fYi);
        this.fXU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                g.this.fXK = true;
                if (g.this.mOtherApkSelected) {
                    Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    g.this.fXR.setCompoundDrawables(drawable2, null, null, null);
                }
                g.this.fYf.lD(g.this.mOtherApkSelected);
            }
        });
        this.fXW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.fYj) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                g.this.fXW.setEnabled(false);
                g.this.fYf.lE(g.this.mOtherApkSelected);
            }
        });
        this.fXS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.fYf.bLI();
            }
        });
        this.fXR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.fXK) {
                    if (g.this.mOtherApkSelected) {
                        Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        g.this.fXR.setCompoundDrawables(drawable2, null, null, null);
                        g.this.fXJ = false;
                        g.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = ap.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    g.this.fXR.setCompoundDrawables(drawable3, null, null, null);
                    g.this.fXJ = true;
                    g.this.mOtherApkSelected = true;
                }
            }
        });
        Ki();
    }

    private void Ki() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void lB(boolean z) {
        if (i.a(this.mContext.getPackageManager())) {
            this.fXX.setVisibility(8);
        } else {
            this.fXX.setVisibility(0);
        }
        if (z) {
            if (this.fXH == null || TextUtils.isEmpty(this.fXH.getPatch()) || this.fXH.getNewVersionCode() < 0) {
                this.fXY.setVisibility(0);
                this.fXW.setText(R.string.super_update);
                ap.setBackgroundResource(this.fXW, R.drawable.dialog_middle_item_bg_selector);
                this.fYe.setVisibility(0);
                this.fYj = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.fXY.setVisibility(0);
            this.fXW.setText(R.string.incremental_update);
            ap.setBackgroundResource(this.fXW, R.drawable.dialog_single_button_bg_selector);
            this.fYd.setVisibility(8);
            this.fYe.setVisibility(8);
            this.fYj = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.fXH == null || TextUtils.isEmpty(this.fXH.getPatch()) || this.fXH.getNewVersionCode() < 0) {
            this.fXY.setVisibility(8);
            this.fYe.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.fXY.setVisibility(0);
            ap.setBackgroundResource(this.fXW, R.drawable.dialog_middle_item_bg_selector);
            this.fXW.setText(R.string.incremental_update);
            this.fYe.setVisibility(0);
            this.fYj = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.fXU.setVisibility(8);
        this.fXY.setVisibility(8);
        this.fXS.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.fXK = true;
        this.fYe.setVisibility(0);
        this.fXP.setVisibility(0);
        this.fXP.setText(this.fXQ + i + "%");
        this.fXV.setVisibility(8);
        this.fXT.setVisibility(8);
    }

    public void lC(boolean z) {
        this.fXU.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.fXK) {
            this.fYf.stopService();
            this.fXM.setVisibility(8);
            if (this.fXL) {
                this.fYa.setText(getContext().getString(R.string.download_exit));
            }
            this.fXZ.setVisibility(0);
            return;
        }
        this.fYf.bLJ();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.fXH = versionData;
        this.fXI = combineDownload;
        this.fYf = aVar;
    }

    public void bLH() {
        this.fXZ.setVisibility(8);
        this.fXM.setVisibility(0);
    }

    public void k(View.OnClickListener onClickListener) {
        this.fYg = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.fYh = onClickListener;
    }

    public void f(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        ap.setImageResource(this.fXV, R.drawable.write_close_selector);
    }

    public void fm(Context context) {
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
