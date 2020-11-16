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
    private boolean fPA;
    private boolean fPB;
    private boolean fPC;
    private LinearLayout fPD;
    private TextView fPE;
    private TextView fPF;
    private TextView fPG;
    private String fPH;
    private TextView fPI;
    private TextView fPJ;
    private TextView fPK;
    private TextView fPL;
    private ImageView fPM;
    private TextView fPN;
    private TextView fPO;
    private View fPP;
    private LinearLayout fPQ;
    private TextView fPR;
    private TextView fPS;
    private TextView fPT;
    private View fPU;
    private LinearLayout fPV;
    private a fPW;
    private View.OnClickListener fPX;
    private View.OnClickListener fPY;
    private boolean fPZ;
    private VersionData fPy;
    private CombineDownload fPz;
    private boolean fQa;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void bIa();

        void bIb();

        void li(boolean z);

        void lj(boolean z);

        void stopService();
    }

    public g(Context context, int i) {
        super(context, i);
        this.fPA = false;
        this.mOtherApkSelected = true;
        this.fPB = false;
        this.fPC = false;
        this.fPZ = true;
        this.fQa = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == g.this.fPK.getId()) {
                    g.this.fPW.bIa();
                    g.this.eG(g.this.mContext);
                } else if (view.getId() == g.this.fPM.getId()) {
                    g.this.fPW.bIa();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.fPD = (LinearLayout) findViewById(R.id.app_info);
        this.fPE = (TextView) findViewById(R.id.app_version_and_size);
        this.fPF = (TextView) findViewById(R.id.app_description);
        this.fPL = (TextView) findViewById(R.id.fullsize_download_button);
        this.fPJ = (TextView) findViewById(R.id.cancel_download_button);
        this.fPK = (TextView) findViewById(R.id.btn_update_save_flow);
        this.fPM = (ImageView) findViewById(R.id.img_close);
        this.fPK.setOnClickListener(this.mOnClickListener);
        this.fPM.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.fPG = (TextView) findViewById(R.id.download_process);
        this.fPN = (TextView) findViewById(R.id.incremental_download_button);
        this.fPO = (TextView) findViewById(R.id.not_install_as_tip);
        this.fPP = findViewById(R.id.incremental_download_layout);
        this.fPI = (TextView) findViewById(R.id.other_app_recommend);
        this.fPU = findViewById(R.id.divider_under_button);
        this.fPV = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.fPH = this.fPG.getText().toString();
        this.fPQ = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.fPS = (TextView) findViewById(R.id.sure_cancel);
        this.fPT = (TextView) findViewById(R.id.cancel_button);
        this.fPR = (TextView) findViewById(R.id.cancel_tip);
        this.fPS.setOnClickListener(this.fPX);
        this.fPT.setOnClickListener(this.fPY);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.fPZ = true;
        } else {
            this.fPZ = false;
        }
        String size = this.fPy.getSize();
        String newVersion = this.fPy.getNewVersion();
        String newVersionDesc = this.fPy.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.fPE.setText(sb.toString());
        this.fPF.setText(newVersionDesc);
        if (this.fPy.forceUpdate()) {
            this.fPC = true;
            this.fPJ.setText(this.mContext.getString(R.string.quit));
            this.fPK.setVisibility(8);
            this.fPM.setVisibility(8);
        } else if (this.fPy.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.fPJ.setVisibility(8);
        } else {
            this.fPJ.setText(this.mContext.getString(R.string.update_after));
            this.fPK.setVisibility(8);
            this.fPM.setVisibility(8);
        }
        if (this.fPz != null && this.fPz.showCombineDownload() && !TextUtils.isEmpty(this.fPz.getApkMD5RSA())) {
            this.fPI.setText(this.fPz.getAppName());
            if (!y.isInstalledPackage(this.mContext, this.fPz.getAppProc()) && !TextUtils.isEmpty(this.fPz.getAppUrl())) {
                this.fPI.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.fPI.setCompoundDrawables(drawable, null, null, null);
                this.fPA = true;
            } else {
                this.fPI.setVisibility(8);
                this.fPA = false;
            }
        } else {
            this.fPI.setVisibility(8);
            this.fPA = false;
        }
        lg(this.fPZ);
        this.fPL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                g.this.fPB = true;
                if (g.this.mOtherApkSelected) {
                    Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    g.this.fPI.setCompoundDrawables(drawable2, null, null, null);
                }
                g.this.fPW.li(g.this.mOtherApkSelected);
            }
        });
        this.fPN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.fQa) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                g.this.fPN.setEnabled(false);
                g.this.fPW.lj(g.this.mOtherApkSelected);
            }
        });
        this.fPJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.fPW.bIa();
            }
        });
        this.fPI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.fPB) {
                    if (g.this.mOtherApkSelected) {
                        Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        g.this.fPI.setCompoundDrawables(drawable2, null, null, null);
                        g.this.fPA = false;
                        g.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = ap.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    g.this.fPI.setCompoundDrawables(drawable3, null, null, null);
                    g.this.fPA = true;
                    g.this.mOtherApkSelected = true;
                }
            }
        });
        Ov();
    }

    private void Ov() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void lg(boolean z) {
        if (i.a(this.mContext.getPackageManager())) {
            this.fPO.setVisibility(8);
        } else {
            this.fPO.setVisibility(0);
        }
        if (z) {
            if (this.fPy == null || TextUtils.isEmpty(this.fPy.getPatch()) || this.fPy.getNewVersionCode() < 0) {
                this.fPP.setVisibility(0);
                this.fPN.setText(R.string.super_update);
                ap.setBackgroundResource(this.fPN, R.drawable.dialog_middle_item_bg_selector);
                this.fPV.setVisibility(0);
                this.fQa = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.fPP.setVisibility(0);
            this.fPN.setText(R.string.incremental_update);
            ap.setBackgroundResource(this.fPN, R.drawable.dialog_single_button_bg_selector);
            this.fPU.setVisibility(8);
            this.fPV.setVisibility(8);
            this.fQa = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.fPy == null || TextUtils.isEmpty(this.fPy.getPatch()) || this.fPy.getNewVersionCode() < 0) {
            this.fPP.setVisibility(8);
            this.fPV.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.fPP.setVisibility(0);
            ap.setBackgroundResource(this.fPN, R.drawable.dialog_middle_item_bg_selector);
            this.fPN.setText(R.string.incremental_update);
            this.fPV.setVisibility(0);
            this.fQa = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.fPL.setVisibility(8);
        this.fPP.setVisibility(8);
        this.fPJ.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.fPB = true;
        this.fPV.setVisibility(0);
        this.fPG.setVisibility(0);
        this.fPG.setText(this.fPH + i + "%");
        this.fPM.setVisibility(8);
        this.fPK.setVisibility(8);
    }

    public void lh(boolean z) {
        this.fPL.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.fPB) {
            this.fPW.stopService();
            this.fPD.setVisibility(8);
            if (this.fPC) {
                this.fPR.setText(getContext().getString(R.string.download_exit));
            }
            this.fPQ.setVisibility(0);
            return;
        }
        this.fPW.bIb();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.fPy = versionData;
        this.fPz = combineDownload;
        this.fPW = aVar;
    }

    public void bHZ() {
        this.fPQ.setVisibility(8);
        this.fPD.setVisibility(0);
    }

    public void k(View.OnClickListener onClickListener) {
        this.fPX = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.fPY = onClickListener;
    }

    public void f(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        ap.setImageResource(this.fPM, R.drawable.write_close_selector);
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
