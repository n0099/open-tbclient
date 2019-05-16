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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes.dex */
public class d extends Dialog {
    private VersionData cSB;
    private CombineDownload cSC;
    private boolean cSD;
    private boolean cSE;
    private boolean cSF;
    private boolean cSG;
    private LinearLayout cSH;
    private TextView cSI;
    private TextView cSJ;
    private TextView cSK;
    private String cSL;
    private TextView cSM;
    private TextView cSN;
    private TextView cSO;
    private TextView cSP;
    private ImageView cSQ;
    private TextView cSR;
    private TextView cSS;
    private View cST;
    private LinearLayout cSU;
    private TextView cSV;
    private TextView cSW;
    private TextView cSX;
    private View cSY;
    private LinearLayout cSZ;
    private a cTa;
    private View.OnClickListener cTb;
    private View.OnClickListener cTc;
    private boolean cTd;
    private boolean cTe;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    interface a {
        void aAu();

        void aAv();

        void gd(boolean z);

        void ge(boolean z);

        void stopService();
    }

    public d(Context context, int i) {
        super(context, i);
        this.cSD = false;
        this.cSE = true;
        this.cSF = false;
        this.cSG = false;
        this.cTd = true;
        this.cTe = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.this.cSO.getId()) {
                    d.this.cTa.aAu();
                    d.this.cU(d.this.mContext);
                } else if (view.getId() == d.this.cSQ.getId()) {
                    d.this.cTa.aAu();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.cSH = (LinearLayout) findViewById(R.id.app_info);
        this.cSI = (TextView) findViewById(R.id.app_version_and_size);
        this.cSJ = (TextView) findViewById(R.id.app_description);
        this.cSP = (TextView) findViewById(R.id.fullsize_download_button);
        this.cSN = (TextView) findViewById(R.id.cancel_download_button);
        this.cSO = (TextView) findViewById(R.id.btn_update_save_flow);
        this.cSQ = (ImageView) findViewById(R.id.img_close);
        this.cSO.setOnClickListener(this.mOnClickListener);
        this.cSQ.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.cSK = (TextView) findViewById(R.id.download_process);
        this.cSR = (TextView) findViewById(R.id.incremental_download_button);
        this.cSS = (TextView) findViewById(R.id.not_install_as_tip);
        this.cST = findViewById(R.id.incremental_download_layout);
        this.cSM = (TextView) findViewById(R.id.other_app_recommend);
        this.cSY = findViewById(R.id.divider_under_button);
        this.cSZ = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.cSL = this.cSK.getText().toString();
        this.cSU = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.cSW = (TextView) findViewById(R.id.sure_cancel);
        this.cSX = (TextView) findViewById(R.id.cancel_button);
        this.cSV = (TextView) findViewById(R.id.cancel_tip);
        this.cSW.setOnClickListener(this.cTb);
        this.cSX.setOnClickListener(this.cTc);
        if (com.baidu.adp.lib.b.d.hI().ay("android_shouzhu_update") == 1) {
            this.cTd = true;
        } else {
            this.cTd = false;
        }
        String size = this.cSB.getSize();
        String newVersion = this.cSB.getNewVersion();
        String newVersionDesc = this.cSB.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.c(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.cSI.setText(sb.toString());
        this.cSJ.setText(newVersionDesc);
        if (this.cSB.forceUpdate()) {
            this.cSG = true;
            this.cSN.setText(this.mContext.getString(R.string.quit));
            this.cSO.setVisibility(8);
            this.cSQ.setVisibility(8);
        } else if (this.cSB.isOfficialVersion() && l.F(this.mContext, "com.tencent.android.qqdownloader")) {
            this.cSN.setVisibility(8);
        } else {
            this.cSN.setText(this.mContext.getString(R.string.update_after));
            this.cSO.setVisibility(8);
            this.cSQ.setVisibility(8);
        }
        if (this.cSC != null && this.cSC.showCombineDownload() && !TextUtils.isEmpty(this.cSC.getApkMD5RSA())) {
            this.cSM.setText(this.cSC.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.cSC.getAppProc()) && !TextUtils.isEmpty(this.cSC.getAppUrl())) {
                this.cSM.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.cSM.setCompoundDrawables(drawable, null, null, null);
                this.cSD = true;
            } else {
                this.cSM.setVisibility(8);
                this.cSD = false;
            }
        } else {
            this.cSM.setVisibility(8);
            this.cSD = false;
        }
        gb(this.cTd);
        this.cSP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                d.this.cSF = true;
                if (d.this.cSE) {
                    Drawable drawable2 = al.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    d.this.cSM.setCompoundDrawables(drawable2, null, null, null);
                }
                d.this.cTa.gd(d.this.cSE);
            }
        });
        this.cSR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cTe) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                d.this.cSR.setEnabled(false);
                d.this.cTa.ge(d.this.cSE);
            }
        });
        this.cSN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.cTa.aAu();
            }
        });
        this.cSM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.cSF) {
                    if (d.this.cSE) {
                        Drawable drawable2 = al.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        d.this.cSM.setCompoundDrawables(drawable2, null, null, null);
                        d.this.cSD = false;
                        d.this.cSE = false;
                        return;
                    }
                    Drawable drawable3 = al.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    d.this.cSM.setCompoundDrawables(drawable3, null, null, null);
                    d.this.cSD = true;
                    d.this.cSE = true;
                }
            }
        });
        aAs();
    }

    private void aAs() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void gb(boolean z) {
        if (f.a(this.mContext.getPackageManager())) {
            this.cSS.setVisibility(8);
        } else {
            this.cSS.setVisibility(0);
        }
        if (z) {
            if (this.cSB == null || TextUtils.isEmpty(this.cSB.getPatch()) || this.cSB.getNewVersionCode() < 0) {
                this.cST.setVisibility(0);
                this.cSR.setText(R.string.super_update);
                al.k(this.cSR, R.drawable.dialog_middle_item_bg_selector);
                this.cSZ.setVisibility(0);
                this.cTe = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.cST.setVisibility(0);
            this.cSR.setText(R.string.incremental_update);
            al.k(this.cSR, R.drawable.dialog_single_button_bg_selector);
            this.cSY.setVisibility(8);
            this.cSZ.setVisibility(8);
            this.cTe = true;
            TiebaStatic.log("c10002");
        } else if (this.cSB == null || TextUtils.isEmpty(this.cSB.getPatch()) || this.cSB.getNewVersionCode() < 0) {
            this.cST.setVisibility(8);
            this.cSZ.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.cST.setVisibility(0);
            al.k(this.cSR, R.drawable.dialog_middle_item_bg_selector);
            this.cSR.setText(R.string.incremental_update);
            this.cSZ.setVisibility(0);
            this.cTe = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void updateProgress(int i) {
        this.cSP.setVisibility(8);
        this.cST.setVisibility(8);
        this.cSN.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.cSF = true;
        this.cSZ.setVisibility(0);
        this.cSK.setVisibility(0);
        this.cSK.setText(this.cSL + i + "%");
        this.cSQ.setVisibility(8);
        this.cSO.setVisibility(8);
    }

    public void gc(boolean z) {
        this.cSP.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.cSF) {
            this.cTa.stopService();
            this.cSH.setVisibility(8);
            if (this.cSG) {
                this.cSV.setText(getContext().getString(R.string.download_exit));
            }
            this.cSU.setVisibility(0);
            return;
        }
        this.cTa.aAv();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.cSB = versionData;
        this.cSC = combineDownload;
        this.cTa = aVar;
    }

    public void aAt() {
        this.cSU.setVisibility(8);
        this.cSH.setVisibility(0);
    }

    public void g(View.OnClickListener onClickListener) {
        this.cTb = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.cTc = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        al.c(this.cSQ, (int) R.drawable.write_close_selector);
    }

    public void cU(Context context) {
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
