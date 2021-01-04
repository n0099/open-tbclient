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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.switchs.UpdateDialogStyleSyncSwitch;
import com.baidu.tieba.tbadkCore.z;
/* loaded from: classes.dex */
public class g extends Dialog {
    private View dividerLine;
    private View.OnClickListener eMW;
    private TextView ghA;
    private TextView ghB;
    private TextView ghC;
    private TextView ghD;
    private ImageView ghE;
    private TextView ghF;
    private TextView ghG;
    private View ghH;
    private LinearLayout ghI;
    private TextView ghJ;
    private TextView ghK;
    private TextView ghL;
    private View ghM;
    private LinearLayout ghN;
    private a ghO;
    private View.OnClickListener ghP;
    private boolean ghQ;
    private boolean ghR;
    private VersionData ghq;
    private CombineDownload ghr;
    private boolean ghs;
    private boolean ght;
    private boolean ghu;
    private LinearLayout ghv;
    private TextView ghw;
    private TextView ghx;
    private TextView ghy;
    private String ghz;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void bOb();

        void bOc();

        void ma(boolean z);

        void mb(boolean z);

        void stopService();
    }

    public g(Context context, int i) {
        super(context, i);
        this.ghs = false;
        this.mOtherApkSelected = true;
        this.ght = false;
        this.ghu = false;
        this.ghQ = true;
        this.ghR = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == g.this.ghC.getId()) {
                    g.this.ghO.bOb();
                    g.this.fG(g.this.mContext);
                } else if (view.getId() == g.this.ghE.getId()) {
                    g.this.ghO.bOb();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.ghv = (LinearLayout) findViewById(R.id.app_info);
        this.ghw = (TextView) findViewById(R.id.app_version_and_size);
        this.ghx = (TextView) findViewById(R.id.app_description);
        this.ghD = (TextView) findViewById(R.id.fullsize_download_button);
        this.ghB = (TextView) findViewById(R.id.cancel_download_button);
        this.ghC = (TextView) findViewById(R.id.btn_update_save_flow);
        this.ghE = (ImageView) findViewById(R.id.img_close);
        this.ghC.setOnClickListener(this.mOnClickListener);
        this.ghE.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.ghy = (TextView) findViewById(R.id.download_process);
        this.ghF = (TextView) findViewById(R.id.incremental_download_button);
        this.ghG = (TextView) findViewById(R.id.not_install_as_tip);
        this.ghH = findViewById(R.id.incremental_download_layout);
        this.ghA = (TextView) findViewById(R.id.other_app_recommend);
        this.ghM = findViewById(R.id.divider_under_button);
        this.ghN = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.ghz = this.ghy.getText().toString();
        this.ghI = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.ghK = (TextView) findViewById(R.id.sure_cancel);
        this.ghL = (TextView) findViewById(R.id.cancel_button);
        this.ghJ = (TextView) findViewById(R.id.cancel_tip);
        this.ghK.setOnClickListener(this.eMW);
        this.ghL.setOnClickListener(this.ghP);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.ghQ = true;
        } else {
            this.ghQ = false;
        }
        String size = this.ghq.getSize();
        String newVersion = this.ghq.getNewVersion();
        String newVersionDesc = this.ghq.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.ghw.setText(sb.toString());
        this.ghx.setText(newVersionDesc);
        if (this.ghq.forceUpdate()) {
            this.ghu = true;
            this.ghB.setText(this.mContext.getString(R.string.quit));
            this.ghC.setVisibility(8);
            this.ghE.setVisibility(8);
        } else if (this.ghq.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.ghB.setVisibility(8);
        } else {
            this.ghB.setText(this.mContext.getString(R.string.update_after));
            this.ghC.setVisibility(8);
            this.ghE.setVisibility(8);
        }
        if (this.ghr != null && this.ghr.showCombineDownload() && !TextUtils.isEmpty(this.ghr.getApkMD5RSA())) {
            this.ghA.setText(this.ghr.getAppName());
            if (!z.isInstalledPackage(this.mContext, this.ghr.getAppProc()) && !TextUtils.isEmpty(this.ghr.getAppUrl())) {
                this.ghA.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.ghA.setCompoundDrawables(drawable, null, null, null);
                this.ghs = true;
            } else {
                this.ghA.setVisibility(8);
                this.ghs = false;
            }
        } else {
            this.ghA.setVisibility(8);
            this.ghs = false;
        }
        lY(this.ghQ);
        this.ghD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                g.this.ght = true;
                if (g.this.mOtherApkSelected) {
                    Drawable drawable2 = ao.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    g.this.ghA.setCompoundDrawables(drawable2, null, null, null);
                }
                g.this.ghO.ma(g.this.mOtherApkSelected);
            }
        });
        this.ghF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.ghR) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                g.this.ghF.setEnabled(false);
                g.this.ghO.mb(g.this.mOtherApkSelected);
            }
        });
        this.ghB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ghO.bOb();
            }
        });
        this.ghA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.ght) {
                    if (g.this.mOtherApkSelected) {
                        Drawable drawable2 = ao.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        g.this.ghA.setCompoundDrawables(drawable2, null, null, null);
                        g.this.ghs = false;
                        g.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = ao.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    g.this.ghA.setCompoundDrawables(drawable3, null, null, null);
                    g.this.ghs = true;
                    g.this.mOtherApkSelected = true;
                }
            }
        });
        JK();
    }

    private void JK() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void lY(boolean z) {
        if (i.a(this.mContext.getPackageManager())) {
            this.ghG.setVisibility(8);
        } else {
            this.ghG.setVisibility(0);
        }
        if (z) {
            if (this.ghq == null || TextUtils.isEmpty(this.ghq.getPatch()) || this.ghq.getNewVersionCode() < 0) {
                this.ghH.setVisibility(0);
                this.ghF.setText(R.string.super_update);
                ao.setBackgroundResource(this.ghF, R.drawable.dialog_middle_item_bg_selector);
                this.ghN.setVisibility(0);
                this.ghR = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.ghH.setVisibility(0);
            this.ghF.setText(R.string.incremental_update);
            ao.setBackgroundResource(this.ghF, R.drawable.dialog_single_button_bg_selector);
            this.ghM.setVisibility(8);
            this.ghN.setVisibility(8);
            this.ghR = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.ghq == null || TextUtils.isEmpty(this.ghq.getPatch()) || this.ghq.getNewVersionCode() < 0) {
            this.ghH.setVisibility(8);
            this.ghN.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.ghH.setVisibility(0);
            ao.setBackgroundResource(this.ghF, R.drawable.dialog_middle_item_bg_selector);
            this.ghF.setText(R.string.incremental_update);
            this.ghN.setVisibility(0);
            this.ghR = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.ghD.setVisibility(8);
        this.ghH.setVisibility(8);
        this.ghB.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.ght = true;
        this.ghN.setVisibility(0);
        this.ghy.setVisibility(0);
        this.ghy.setText(this.ghz + i + "%");
        this.ghE.setVisibility(8);
        this.ghC.setVisibility(8);
    }

    public void lZ(boolean z) {
        this.ghD.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.ght) {
            this.ghO.stopService();
            this.ghv.setVisibility(8);
            if (this.ghu) {
                this.ghJ.setText(getContext().getString(R.string.download_exit));
            }
            this.ghI.setVisibility(0);
            return;
        }
        this.ghO.bOc();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.ghq = versionData;
        this.ghr = combineDownload;
        this.ghO = aVar;
    }

    public void bOa() {
        this.ghI.setVisibility(8);
        this.ghv.setVisibility(0);
    }

    public void l(View.OnClickListener onClickListener) {
        this.eMW = onClickListener;
    }

    public void m(View.OnClickListener onClickListener) {
        this.ghP = onClickListener;
    }

    public void f(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        ao.setImageResource(this.ghE, R.drawable.write_close_selector);
    }

    public void fG(Context context) {
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
