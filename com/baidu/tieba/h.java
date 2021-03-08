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
public class h extends Dialog {
    private View dividerLine;
    private View.OnClickListener eLS;
    private VersionData ggF;
    private CombineDownload ggG;
    private boolean ggH;
    private boolean ggI;
    private boolean ggJ;
    private LinearLayout ggK;
    private TextView ggL;
    private TextView ggM;
    private TextView ggN;
    private String ggO;
    private TextView ggP;
    private TextView ggQ;
    private TextView ggR;
    private TextView ggS;
    private ImageView ggT;
    private TextView ggU;
    private TextView ggV;
    private View ggW;
    private LinearLayout ggX;
    private TextView ggY;
    private TextView ggZ;
    private TextView gha;
    private View ghb;
    private LinearLayout ghc;
    private a ghd;
    private View.OnClickListener ghe;
    private boolean ghf;
    private boolean ghg;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void bKN();

        void bKO();

        void ma(boolean z);

        void mb(boolean z);

        void stopService();
    }

    public h(Context context, int i) {
        super(context, i);
        this.ggH = false;
        this.mOtherApkSelected = true;
        this.ggI = false;
        this.ggJ = false;
        this.ghf = true;
        this.ghg = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.h.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == h.this.ggR.getId()) {
                    h.this.ghd.bKN();
                    h.this.fC(h.this.mContext);
                } else if (view.getId() == h.this.ggT.getId()) {
                    h.this.ghd.bKN();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.ggK = (LinearLayout) findViewById(R.id.app_info);
        this.ggL = (TextView) findViewById(R.id.app_version_and_size);
        this.ggM = (TextView) findViewById(R.id.app_description);
        this.ggS = (TextView) findViewById(R.id.fullsize_download_button);
        this.ggQ = (TextView) findViewById(R.id.cancel_download_button);
        this.ggR = (TextView) findViewById(R.id.btn_update_save_flow);
        this.ggT = (ImageView) findViewById(R.id.img_close);
        this.ggR.setOnClickListener(this.mOnClickListener);
        this.ggT.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.ggN = (TextView) findViewById(R.id.download_process);
        this.ggU = (TextView) findViewById(R.id.incremental_download_button);
        this.ggV = (TextView) findViewById(R.id.not_install_as_tip);
        this.ggW = findViewById(R.id.incremental_download_layout);
        this.ggP = (TextView) findViewById(R.id.other_app_recommend);
        this.ghb = findViewById(R.id.divider_under_button);
        this.ghc = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.ggO = this.ggN.getText().toString();
        this.ggX = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.ggZ = (TextView) findViewById(R.id.sure_cancel);
        this.gha = (TextView) findViewById(R.id.cancel_button);
        this.ggY = (TextView) findViewById(R.id.cancel_tip);
        this.ggZ.setOnClickListener(this.eLS);
        this.gha.setOnClickListener(this.ghe);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.ghf = true;
        } else {
            this.ghf = false;
        }
        String size = this.ggF.getSize();
        String newVersion = this.ggF.getNewVersion();
        String newVersionDesc = this.ggF.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.ggL.setText(sb.toString());
        this.ggM.setText(newVersionDesc);
        if (this.ggF.forceUpdate()) {
            this.ggJ = true;
            this.ggQ.setText(this.mContext.getString(R.string.quit));
            this.ggR.setVisibility(8);
            this.ggT.setVisibility(8);
        } else if (this.ggF.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.ggQ.setVisibility(8);
        } else {
            this.ggQ.setText(this.mContext.getString(R.string.update_after));
            this.ggR.setVisibility(8);
            this.ggT.setVisibility(8);
        }
        if (this.ggG != null && this.ggG.showCombineDownload() && !TextUtils.isEmpty(this.ggG.getApkMD5RSA())) {
            this.ggP.setText(this.ggG.getAppName());
            if (!z.isInstalledPackage(this.mContext, this.ggG.getAppProc()) && !TextUtils.isEmpty(this.ggG.getAppUrl())) {
                this.ggP.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.ggP.setCompoundDrawables(drawable, null, null, null);
                this.ggH = true;
            } else {
                this.ggP.setVisibility(8);
                this.ggH = false;
            }
        } else {
            this.ggP.setVisibility(8);
            this.ggH = false;
        }
        lY(this.ghf);
        this.ggS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                h.this.ggI = true;
                if (h.this.mOtherApkSelected) {
                    Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    h.this.ggP.setCompoundDrawables(drawable2, null, null, null);
                }
                h.this.ghd.ma(h.this.mOtherApkSelected);
            }
        });
        this.ggU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.ghg) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                h.this.ggU.setEnabled(false);
                h.this.ghd.mb(h.this.mOtherApkSelected);
            }
        });
        this.ggQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.ghd.bKN();
            }
        });
        this.ggP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!h.this.ggI) {
                    if (h.this.mOtherApkSelected) {
                        Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        h.this.ggP.setCompoundDrawables(drawable2, null, null, null);
                        h.this.ggH = false;
                        h.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = ap.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    h.this.ggP.setCompoundDrawables(drawable3, null, null, null);
                    h.this.ggH = true;
                    h.this.mOtherApkSelected = true;
                }
            }
        });
        Hi();
    }

    private void Hi() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void lY(boolean z) {
        if (j.a(this.mContext.getPackageManager())) {
            this.ggV.setVisibility(8);
        } else {
            this.ggV.setVisibility(0);
        }
        if (z) {
            if (this.ggF == null || TextUtils.isEmpty(this.ggF.getPatch()) || this.ggF.getNewVersionCode() < 0) {
                this.ggW.setVisibility(0);
                this.ggU.setText(R.string.super_update);
                ap.setBackgroundResource(this.ggU, R.drawable.dialog_middle_item_bg_selector);
                this.ghc.setVisibility(0);
                this.ghg = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.ggW.setVisibility(0);
            this.ggU.setText(R.string.incremental_update);
            ap.setBackgroundResource(this.ggU, R.drawable.dialog_single_button_bg_selector);
            this.ghb.setVisibility(8);
            this.ghc.setVisibility(8);
            this.ghg = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.ggF == null || TextUtils.isEmpty(this.ggF.getPatch()) || this.ggF.getNewVersionCode() < 0) {
            this.ggW.setVisibility(8);
            this.ghc.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.ggW.setVisibility(0);
            ap.setBackgroundResource(this.ggU, R.drawable.dialog_middle_item_bg_selector);
            this.ggU.setText(R.string.incremental_update);
            this.ghc.setVisibility(0);
            this.ghg = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.ggS.setVisibility(8);
        this.ggW.setVisibility(8);
        this.ggQ.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.ggI = true;
        this.ghc.setVisibility(0);
        this.ggN.setVisibility(0);
        this.ggN.setText(this.ggO + i + "%");
        this.ggT.setVisibility(8);
        this.ggR.setVisibility(8);
    }

    public void lZ(boolean z) {
        this.ggS.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.ggI) {
            this.ghd.stopService();
            this.ggK.setVisibility(8);
            if (this.ggJ) {
                this.ggY.setText(getContext().getString(R.string.download_exit));
            }
            this.ggX.setVisibility(0);
            return;
        }
        this.ghd.bKO();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.ggF = versionData;
        this.ggG = combineDownload;
        this.ghd = aVar;
    }

    public void bKM() {
        this.ggX.setVisibility(8);
        this.ggK.setVisibility(0);
    }

    public void l(View.OnClickListener onClickListener) {
        this.eLS = onClickListener;
    }

    public void m(View.OnClickListener onClickListener) {
        this.ghe = onClickListener;
    }

    public void f(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        ap.setImageResource(this.ggT, R.drawable.write_close_selector);
    }

    public void fC(Context context) {
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
