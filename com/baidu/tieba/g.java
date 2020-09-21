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
public class g extends Dialog {
    private View dividerLine;
    private String fpA;
    private TextView fpB;
    private TextView fpC;
    private TextView fpD;
    private TextView fpE;
    private ImageView fpF;
    private TextView fpG;
    private TextView fpH;
    private View fpI;
    private LinearLayout fpJ;
    private TextView fpK;
    private TextView fpL;
    private TextView fpM;
    private View fpN;
    private LinearLayout fpO;
    private a fpP;
    private View.OnClickListener fpQ;
    private View.OnClickListener fpR;
    private boolean fpS;
    private boolean fpT;
    private VersionData fpq;
    private CombineDownload fpr;
    private boolean fpt;
    private boolean fpu;
    private boolean fpv;
    private LinearLayout fpw;
    private TextView fpx;
    private TextView fpy;
    private TextView fpz;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void bBC();

        void bBD();

        void kn(boolean z);

        void ko(boolean z);

        void stopService();
    }

    public g(Context context, int i) {
        super(context, i);
        this.fpt = false;
        this.mOtherApkSelected = true;
        this.fpu = false;
        this.fpv = false;
        this.fpS = true;
        this.fpT = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == g.this.fpD.getId()) {
                    g.this.fpP.bBC();
                    g.this.ez(g.this.mContext);
                } else if (view.getId() == g.this.fpF.getId()) {
                    g.this.fpP.bBC();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.fpw = (LinearLayout) findViewById(R.id.app_info);
        this.fpx = (TextView) findViewById(R.id.app_version_and_size);
        this.fpy = (TextView) findViewById(R.id.app_description);
        this.fpE = (TextView) findViewById(R.id.fullsize_download_button);
        this.fpC = (TextView) findViewById(R.id.cancel_download_button);
        this.fpD = (TextView) findViewById(R.id.btn_update_save_flow);
        this.fpF = (ImageView) findViewById(R.id.img_close);
        this.fpD.setOnClickListener(this.mOnClickListener);
        this.fpF.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.fpz = (TextView) findViewById(R.id.download_process);
        this.fpG = (TextView) findViewById(R.id.incremental_download_button);
        this.fpH = (TextView) findViewById(R.id.not_install_as_tip);
        this.fpI = findViewById(R.id.incremental_download_layout);
        this.fpB = (TextView) findViewById(R.id.other_app_recommend);
        this.fpN = findViewById(R.id.divider_under_button);
        this.fpO = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.fpA = this.fpz.getText().toString();
        this.fpJ = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.fpL = (TextView) findViewById(R.id.sure_cancel);
        this.fpM = (TextView) findViewById(R.id.cancel_button);
        this.fpK = (TextView) findViewById(R.id.cancel_tip);
        this.fpL.setOnClickListener(this.fpQ);
        this.fpM.setOnClickListener(this.fpR);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.fpS = true;
        } else {
            this.fpS = false;
        }
        String size = this.fpq.getSize();
        String newVersion = this.fpq.getNewVersion();
        String newVersionDesc = this.fpq.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.fpx.setText(sb.toString());
        this.fpy.setText(newVersionDesc);
        if (this.fpq.forceUpdate()) {
            this.fpv = true;
            this.fpC.setText(this.mContext.getString(R.string.quit));
            this.fpD.setVisibility(8);
            this.fpF.setVisibility(8);
        } else if (this.fpq.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.fpC.setVisibility(8);
        } else {
            this.fpC.setText(this.mContext.getString(R.string.update_after));
            this.fpD.setVisibility(8);
            this.fpF.setVisibility(8);
        }
        if (this.fpr != null && this.fpr.showCombineDownload() && !TextUtils.isEmpty(this.fpr.getApkMD5RSA())) {
            this.fpB.setText(this.fpr.getAppName());
            if (!y.isInstalledPackage(this.mContext, this.fpr.getAppProc()) && !TextUtils.isEmpty(this.fpr.getAppUrl())) {
                this.fpB.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.fpB.setCompoundDrawables(drawable, null, null, null);
                this.fpt = true;
            } else {
                this.fpB.setVisibility(8);
                this.fpt = false;
            }
        } else {
            this.fpB.setVisibility(8);
            this.fpt = false;
        }
        kl(this.fpS);
        this.fpE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                g.this.fpu = true;
                if (g.this.mOtherApkSelected) {
                    Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    g.this.fpB.setCompoundDrawables(drawable2, null, null, null);
                }
                g.this.fpP.kn(g.this.mOtherApkSelected);
            }
        });
        this.fpG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.fpT) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                g.this.fpG.setEnabled(false);
                g.this.fpP.ko(g.this.mOtherApkSelected);
            }
        });
        this.fpC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.fpP.bBC();
            }
        });
        this.fpB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.fpu) {
                    if (g.this.mOtherApkSelected) {
                        Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        g.this.fpB.setCompoundDrawables(drawable2, null, null, null);
                        g.this.fpt = false;
                        g.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = ap.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    g.this.fpB.setCompoundDrawables(drawable3, null, null, null);
                    g.this.fpt = true;
                    g.this.mOtherApkSelected = true;
                }
            }
        });
        Nb();
    }

    private void Nb() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void kl(boolean z) {
        if (i.a(this.mContext.getPackageManager())) {
            this.fpH.setVisibility(8);
        } else {
            this.fpH.setVisibility(0);
        }
        if (z) {
            if (this.fpq == null || TextUtils.isEmpty(this.fpq.getPatch()) || this.fpq.getNewVersionCode() < 0) {
                this.fpI.setVisibility(0);
                this.fpG.setText(R.string.super_update);
                ap.setBackgroundResource(this.fpG, R.drawable.dialog_middle_item_bg_selector);
                this.fpO.setVisibility(0);
                this.fpT = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.fpI.setVisibility(0);
            this.fpG.setText(R.string.incremental_update);
            ap.setBackgroundResource(this.fpG, R.drawable.dialog_single_button_bg_selector);
            this.fpN.setVisibility(8);
            this.fpO.setVisibility(8);
            this.fpT = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.fpq == null || TextUtils.isEmpty(this.fpq.getPatch()) || this.fpq.getNewVersionCode() < 0) {
            this.fpI.setVisibility(8);
            this.fpO.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.fpI.setVisibility(0);
            ap.setBackgroundResource(this.fpG, R.drawable.dialog_middle_item_bg_selector);
            this.fpG.setText(R.string.incremental_update);
            this.fpO.setVisibility(0);
            this.fpT = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.fpE.setVisibility(8);
        this.fpI.setVisibility(8);
        this.fpC.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.fpu = true;
        this.fpO.setVisibility(0);
        this.fpz.setVisibility(0);
        this.fpz.setText(this.fpA + i + "%");
        this.fpF.setVisibility(8);
        this.fpD.setVisibility(8);
    }

    public void km(boolean z) {
        this.fpE.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.fpu) {
            this.fpP.stopService();
            this.fpw.setVisibility(8);
            if (this.fpv) {
                this.fpK.setText(getContext().getString(R.string.download_exit));
            }
            this.fpJ.setVisibility(0);
            return;
        }
        this.fpP.bBD();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.fpq = versionData;
        this.fpr = combineDownload;
        this.fpP = aVar;
    }

    public void bBB() {
        this.fpJ.setVisibility(8);
        this.fpw.setVisibility(0);
    }

    public void j(View.OnClickListener onClickListener) {
        this.fpQ = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.fpR = onClickListener;
    }

    public void f(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        ap.setImageResource(this.fpF, R.drawable.write_close_selector);
    }

    public void ez(Context context) {
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
