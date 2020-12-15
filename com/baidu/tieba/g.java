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
    private VersionData fXJ;
    private CombineDownload fXK;
    private boolean fXL;
    private boolean fXM;
    private boolean fXN;
    private LinearLayout fXO;
    private TextView fXP;
    private TextView fXQ;
    private TextView fXR;
    private String fXS;
    private TextView fXT;
    private TextView fXU;
    private TextView fXV;
    private TextView fXW;
    private ImageView fXX;
    private TextView fXY;
    private TextView fXZ;
    private View fYa;
    private LinearLayout fYb;
    private TextView fYc;
    private TextView fYd;
    private TextView fYe;
    private View fYf;
    private LinearLayout fYg;
    private a fYh;
    private View.OnClickListener fYi;
    private View.OnClickListener fYj;
    private boolean fYk;
    private boolean fYl;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void bLJ();

        void bLK();

        void lD(boolean z);

        void lE(boolean z);

        void stopService();
    }

    public g(Context context, int i) {
        super(context, i);
        this.fXL = false;
        this.mOtherApkSelected = true;
        this.fXM = false;
        this.fXN = false;
        this.fYk = true;
        this.fYl = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == g.this.fXV.getId()) {
                    g.this.fYh.bLJ();
                    g.this.fm(g.this.mContext);
                } else if (view.getId() == g.this.fXX.getId()) {
                    g.this.fYh.bLJ();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.fXO = (LinearLayout) findViewById(R.id.app_info);
        this.fXP = (TextView) findViewById(R.id.app_version_and_size);
        this.fXQ = (TextView) findViewById(R.id.app_description);
        this.fXW = (TextView) findViewById(R.id.fullsize_download_button);
        this.fXU = (TextView) findViewById(R.id.cancel_download_button);
        this.fXV = (TextView) findViewById(R.id.btn_update_save_flow);
        this.fXX = (ImageView) findViewById(R.id.img_close);
        this.fXV.setOnClickListener(this.mOnClickListener);
        this.fXX.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.fXR = (TextView) findViewById(R.id.download_process);
        this.fXY = (TextView) findViewById(R.id.incremental_download_button);
        this.fXZ = (TextView) findViewById(R.id.not_install_as_tip);
        this.fYa = findViewById(R.id.incremental_download_layout);
        this.fXT = (TextView) findViewById(R.id.other_app_recommend);
        this.fYf = findViewById(R.id.divider_under_button);
        this.fYg = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.fXS = this.fXR.getText().toString();
        this.fYb = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.fYd = (TextView) findViewById(R.id.sure_cancel);
        this.fYe = (TextView) findViewById(R.id.cancel_button);
        this.fYc = (TextView) findViewById(R.id.cancel_tip);
        this.fYd.setOnClickListener(this.fYi);
        this.fYe.setOnClickListener(this.fYj);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.fYk = true;
        } else {
            this.fYk = false;
        }
        String size = this.fXJ.getSize();
        String newVersion = this.fXJ.getNewVersion();
        String newVersionDesc = this.fXJ.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.fXP.setText(sb.toString());
        this.fXQ.setText(newVersionDesc);
        if (this.fXJ.forceUpdate()) {
            this.fXN = true;
            this.fXU.setText(this.mContext.getString(R.string.quit));
            this.fXV.setVisibility(8);
            this.fXX.setVisibility(8);
        } else if (this.fXJ.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.fXU.setVisibility(8);
        } else {
            this.fXU.setText(this.mContext.getString(R.string.update_after));
            this.fXV.setVisibility(8);
            this.fXX.setVisibility(8);
        }
        if (this.fXK != null && this.fXK.showCombineDownload() && !TextUtils.isEmpty(this.fXK.getApkMD5RSA())) {
            this.fXT.setText(this.fXK.getAppName());
            if (!z.isInstalledPackage(this.mContext, this.fXK.getAppProc()) && !TextUtils.isEmpty(this.fXK.getAppUrl())) {
                this.fXT.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.fXT.setCompoundDrawables(drawable, null, null, null);
                this.fXL = true;
            } else {
                this.fXT.setVisibility(8);
                this.fXL = false;
            }
        } else {
            this.fXT.setVisibility(8);
            this.fXL = false;
        }
        lB(this.fYk);
        this.fXW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                g.this.fXM = true;
                if (g.this.mOtherApkSelected) {
                    Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    g.this.fXT.setCompoundDrawables(drawable2, null, null, null);
                }
                g.this.fYh.lD(g.this.mOtherApkSelected);
            }
        });
        this.fXY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.fYl) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                g.this.fXY.setEnabled(false);
                g.this.fYh.lE(g.this.mOtherApkSelected);
            }
        });
        this.fXU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.fYh.bLJ();
            }
        });
        this.fXT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.fXM) {
                    if (g.this.mOtherApkSelected) {
                        Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        g.this.fXT.setCompoundDrawables(drawable2, null, null, null);
                        g.this.fXL = false;
                        g.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = ap.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    g.this.fXT.setCompoundDrawables(drawable3, null, null, null);
                    g.this.fXL = true;
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
            this.fXZ.setVisibility(8);
        } else {
            this.fXZ.setVisibility(0);
        }
        if (z) {
            if (this.fXJ == null || TextUtils.isEmpty(this.fXJ.getPatch()) || this.fXJ.getNewVersionCode() < 0) {
                this.fYa.setVisibility(0);
                this.fXY.setText(R.string.super_update);
                ap.setBackgroundResource(this.fXY, R.drawable.dialog_middle_item_bg_selector);
                this.fYg.setVisibility(0);
                this.fYl = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.fYa.setVisibility(0);
            this.fXY.setText(R.string.incremental_update);
            ap.setBackgroundResource(this.fXY, R.drawable.dialog_single_button_bg_selector);
            this.fYf.setVisibility(8);
            this.fYg.setVisibility(8);
            this.fYl = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.fXJ == null || TextUtils.isEmpty(this.fXJ.getPatch()) || this.fXJ.getNewVersionCode() < 0) {
            this.fYa.setVisibility(8);
            this.fYg.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.fYa.setVisibility(0);
            ap.setBackgroundResource(this.fXY, R.drawable.dialog_middle_item_bg_selector);
            this.fXY.setText(R.string.incremental_update);
            this.fYg.setVisibility(0);
            this.fYl = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.fXW.setVisibility(8);
        this.fYa.setVisibility(8);
        this.fXU.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.fXM = true;
        this.fYg.setVisibility(0);
        this.fXR.setVisibility(0);
        this.fXR.setText(this.fXS + i + "%");
        this.fXX.setVisibility(8);
        this.fXV.setVisibility(8);
    }

    public void lC(boolean z) {
        this.fXW.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.fXM) {
            this.fYh.stopService();
            this.fXO.setVisibility(8);
            if (this.fXN) {
                this.fYc.setText(getContext().getString(R.string.download_exit));
            }
            this.fYb.setVisibility(0);
            return;
        }
        this.fYh.bLK();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.fXJ = versionData;
        this.fXK = combineDownload;
        this.fYh = aVar;
    }

    public void bLI() {
        this.fYb.setVisibility(8);
        this.fXO.setVisibility(0);
    }

    public void k(View.OnClickListener onClickListener) {
        this.fYi = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.fYj = onClickListener;
    }

    public void f(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        ap.setImageResource(this.fXX, R.drawable.write_close_selector);
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
