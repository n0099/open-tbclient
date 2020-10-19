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
    private VersionData fBE;
    private CombineDownload fBF;
    private boolean fBG;
    private boolean fBH;
    private boolean fBI;
    private LinearLayout fBJ;
    private TextView fBK;
    private TextView fBL;
    private TextView fBM;
    private String fBN;
    private TextView fBO;
    private TextView fBP;
    private TextView fBQ;
    private TextView fBR;
    private ImageView fBS;
    private TextView fBT;
    private TextView fBU;
    private View fBV;
    private LinearLayout fBW;
    private TextView fBX;
    private TextView fBY;
    private TextView fBZ;
    private View fCa;
    private LinearLayout fCb;
    private a fCc;
    private View.OnClickListener fCd;
    private View.OnClickListener fCe;
    private boolean fCf;
    private boolean fCg;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void bEo();

        void bEp();

        void kL(boolean z);

        void kM(boolean z);

        void stopService();
    }

    public g(Context context, int i) {
        super(context, i);
        this.fBG = false;
        this.mOtherApkSelected = true;
        this.fBH = false;
        this.fBI = false;
        this.fCf = true;
        this.fCg = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == g.this.fBQ.getId()) {
                    g.this.fCc.bEo();
                    g.this.eG(g.this.mContext);
                } else if (view.getId() == g.this.fBS.getId()) {
                    g.this.fCc.bEo();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.fBJ = (LinearLayout) findViewById(R.id.app_info);
        this.fBK = (TextView) findViewById(R.id.app_version_and_size);
        this.fBL = (TextView) findViewById(R.id.app_description);
        this.fBR = (TextView) findViewById(R.id.fullsize_download_button);
        this.fBP = (TextView) findViewById(R.id.cancel_download_button);
        this.fBQ = (TextView) findViewById(R.id.btn_update_save_flow);
        this.fBS = (ImageView) findViewById(R.id.img_close);
        this.fBQ.setOnClickListener(this.mOnClickListener);
        this.fBS.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.fBM = (TextView) findViewById(R.id.download_process);
        this.fBT = (TextView) findViewById(R.id.incremental_download_button);
        this.fBU = (TextView) findViewById(R.id.not_install_as_tip);
        this.fBV = findViewById(R.id.incremental_download_layout);
        this.fBO = (TextView) findViewById(R.id.other_app_recommend);
        this.fCa = findViewById(R.id.divider_under_button);
        this.fCb = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.fBN = this.fBM.getText().toString();
        this.fBW = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.fBY = (TextView) findViewById(R.id.sure_cancel);
        this.fBZ = (TextView) findViewById(R.id.cancel_button);
        this.fBX = (TextView) findViewById(R.id.cancel_tip);
        this.fBY.setOnClickListener(this.fCd);
        this.fBZ.setOnClickListener(this.fCe);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.fCf = true;
        } else {
            this.fCf = false;
        }
        String size = this.fBE.getSize();
        String newVersion = this.fBE.getNewVersion();
        String newVersionDesc = this.fBE.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.fBK.setText(sb.toString());
        this.fBL.setText(newVersionDesc);
        if (this.fBE.forceUpdate()) {
            this.fBI = true;
            this.fBP.setText(this.mContext.getString(R.string.quit));
            this.fBQ.setVisibility(8);
            this.fBS.setVisibility(8);
        } else if (this.fBE.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.fBP.setVisibility(8);
        } else {
            this.fBP.setText(this.mContext.getString(R.string.update_after));
            this.fBQ.setVisibility(8);
            this.fBS.setVisibility(8);
        }
        if (this.fBF != null && this.fBF.showCombineDownload() && !TextUtils.isEmpty(this.fBF.getApkMD5RSA())) {
            this.fBO.setText(this.fBF.getAppName());
            if (!y.isInstalledPackage(this.mContext, this.fBF.getAppProc()) && !TextUtils.isEmpty(this.fBF.getAppUrl())) {
                this.fBO.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.fBO.setCompoundDrawables(drawable, null, null, null);
                this.fBG = true;
            } else {
                this.fBO.setVisibility(8);
                this.fBG = false;
            }
        } else {
            this.fBO.setVisibility(8);
            this.fBG = false;
        }
        kJ(this.fCf);
        this.fBR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                g.this.fBH = true;
                if (g.this.mOtherApkSelected) {
                    Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    g.this.fBO.setCompoundDrawables(drawable2, null, null, null);
                }
                g.this.fCc.kL(g.this.mOtherApkSelected);
            }
        });
        this.fBT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.fCg) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                g.this.fBT.setEnabled(false);
                g.this.fCc.kM(g.this.mOtherApkSelected);
            }
        });
        this.fBP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.fCc.bEo();
            }
        });
        this.fBO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.fBH) {
                    if (g.this.mOtherApkSelected) {
                        Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        g.this.fBO.setCompoundDrawables(drawable2, null, null, null);
                        g.this.fBG = false;
                        g.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = ap.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    g.this.fBO.setCompoundDrawables(drawable3, null, null, null);
                    g.this.fBG = true;
                    g.this.mOtherApkSelected = true;
                }
            }
        });
        Og();
    }

    private void Og() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void kJ(boolean z) {
        if (i.a(this.mContext.getPackageManager())) {
            this.fBU.setVisibility(8);
        } else {
            this.fBU.setVisibility(0);
        }
        if (z) {
            if (this.fBE == null || TextUtils.isEmpty(this.fBE.getPatch()) || this.fBE.getNewVersionCode() < 0) {
                this.fBV.setVisibility(0);
                this.fBT.setText(R.string.super_update);
                ap.setBackgroundResource(this.fBT, R.drawable.dialog_middle_item_bg_selector);
                this.fCb.setVisibility(0);
                this.fCg = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.fBV.setVisibility(0);
            this.fBT.setText(R.string.incremental_update);
            ap.setBackgroundResource(this.fBT, R.drawable.dialog_single_button_bg_selector);
            this.fCa.setVisibility(8);
            this.fCb.setVisibility(8);
            this.fCg = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.fBE == null || TextUtils.isEmpty(this.fBE.getPatch()) || this.fBE.getNewVersionCode() < 0) {
            this.fBV.setVisibility(8);
            this.fCb.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.fBV.setVisibility(0);
            ap.setBackgroundResource(this.fBT, R.drawable.dialog_middle_item_bg_selector);
            this.fBT.setText(R.string.incremental_update);
            this.fCb.setVisibility(0);
            this.fCg = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.fBR.setVisibility(8);
        this.fBV.setVisibility(8);
        this.fBP.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.fBH = true;
        this.fCb.setVisibility(0);
        this.fBM.setVisibility(0);
        this.fBM.setText(this.fBN + i + "%");
        this.fBS.setVisibility(8);
        this.fBQ.setVisibility(8);
    }

    public void kK(boolean z) {
        this.fBR.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.fBH) {
            this.fCc.stopService();
            this.fBJ.setVisibility(8);
            if (this.fBI) {
                this.fBX.setText(getContext().getString(R.string.download_exit));
            }
            this.fBW.setVisibility(0);
            return;
        }
        this.fCc.bEp();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.fBE = versionData;
        this.fBF = combineDownload;
        this.fCc = aVar;
    }

    public void bEn() {
        this.fBW.setVisibility(8);
        this.fBJ.setVisibility(0);
    }

    public void j(View.OnClickListener onClickListener) {
        this.fCd = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.fCe = onClickListener;
    }

    public void f(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        ap.setImageResource(this.fBS, R.drawable.write_close_selector);
    }

    public void eG(Context context) {
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
