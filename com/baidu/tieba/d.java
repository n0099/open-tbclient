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
    private VersionData cSC;
    private CombineDownload cSD;
    private boolean cSE;
    private boolean cSF;
    private boolean cSG;
    private boolean cSH;
    private LinearLayout cSI;
    private TextView cSJ;
    private TextView cSK;
    private TextView cSL;
    private String cSM;
    private TextView cSN;
    private TextView cSO;
    private TextView cSP;
    private TextView cSQ;
    private ImageView cSR;
    private TextView cSS;
    private TextView cST;
    private View cSU;
    private LinearLayout cSV;
    private TextView cSW;
    private TextView cSX;
    private TextView cSY;
    private View cSZ;
    private LinearLayout cTa;
    private a cTb;
    private View.OnClickListener cTc;
    private View.OnClickListener cTd;
    private boolean cTe;
    private boolean cTf;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    interface a {
        void aAx();

        void aAy();

        void gd(boolean z);

        void ge(boolean z);

        void stopService();
    }

    public d(Context context, int i) {
        super(context, i);
        this.cSE = false;
        this.cSF = true;
        this.cSG = false;
        this.cSH = false;
        this.cTe = true;
        this.cTf = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.this.cSP.getId()) {
                    d.this.cTb.aAx();
                    d.this.cU(d.this.mContext);
                } else if (view.getId() == d.this.cSR.getId()) {
                    d.this.cTb.aAx();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.cSI = (LinearLayout) findViewById(R.id.app_info);
        this.cSJ = (TextView) findViewById(R.id.app_version_and_size);
        this.cSK = (TextView) findViewById(R.id.app_description);
        this.cSQ = (TextView) findViewById(R.id.fullsize_download_button);
        this.cSO = (TextView) findViewById(R.id.cancel_download_button);
        this.cSP = (TextView) findViewById(R.id.btn_update_save_flow);
        this.cSR = (ImageView) findViewById(R.id.img_close);
        this.cSP.setOnClickListener(this.mOnClickListener);
        this.cSR.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.cSL = (TextView) findViewById(R.id.download_process);
        this.cSS = (TextView) findViewById(R.id.incremental_download_button);
        this.cST = (TextView) findViewById(R.id.not_install_as_tip);
        this.cSU = findViewById(R.id.incremental_download_layout);
        this.cSN = (TextView) findViewById(R.id.other_app_recommend);
        this.cSZ = findViewById(R.id.divider_under_button);
        this.cTa = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.cSM = this.cSL.getText().toString();
        this.cSV = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.cSX = (TextView) findViewById(R.id.sure_cancel);
        this.cSY = (TextView) findViewById(R.id.cancel_button);
        this.cSW = (TextView) findViewById(R.id.cancel_tip);
        this.cSX.setOnClickListener(this.cTc);
        this.cSY.setOnClickListener(this.cTd);
        if (com.baidu.adp.lib.b.d.hI().ay("android_shouzhu_update") == 1) {
            this.cTe = true;
        } else {
            this.cTe = false;
        }
        String size = this.cSC.getSize();
        String newVersion = this.cSC.getNewVersion();
        String newVersionDesc = this.cSC.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.c(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.cSJ.setText(sb.toString());
        this.cSK.setText(newVersionDesc);
        if (this.cSC.forceUpdate()) {
            this.cSH = true;
            this.cSO.setText(this.mContext.getString(R.string.quit));
            this.cSP.setVisibility(8);
            this.cSR.setVisibility(8);
        } else if (this.cSC.isOfficialVersion() && l.F(this.mContext, "com.tencent.android.qqdownloader")) {
            this.cSO.setVisibility(8);
        } else {
            this.cSO.setText(this.mContext.getString(R.string.update_after));
            this.cSP.setVisibility(8);
            this.cSR.setVisibility(8);
        }
        if (this.cSD != null && this.cSD.showCombineDownload() && !TextUtils.isEmpty(this.cSD.getApkMD5RSA())) {
            this.cSN.setText(this.cSD.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.cSD.getAppProc()) && !TextUtils.isEmpty(this.cSD.getAppUrl())) {
                this.cSN.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.cSN.setCompoundDrawables(drawable, null, null, null);
                this.cSE = true;
            } else {
                this.cSN.setVisibility(8);
                this.cSE = false;
            }
        } else {
            this.cSN.setVisibility(8);
            this.cSE = false;
        }
        gb(this.cTe);
        this.cSQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                d.this.cSG = true;
                if (d.this.cSF) {
                    Drawable drawable2 = al.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    d.this.cSN.setCompoundDrawables(drawable2, null, null, null);
                }
                d.this.cTb.gd(d.this.cSF);
            }
        });
        this.cSS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cTf) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                d.this.cSS.setEnabled(false);
                d.this.cTb.ge(d.this.cSF);
            }
        });
        this.cSO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.cTb.aAx();
            }
        });
        this.cSN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.cSG) {
                    if (d.this.cSF) {
                        Drawable drawable2 = al.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        d.this.cSN.setCompoundDrawables(drawable2, null, null, null);
                        d.this.cSE = false;
                        d.this.cSF = false;
                        return;
                    }
                    Drawable drawable3 = al.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    d.this.cSN.setCompoundDrawables(drawable3, null, null, null);
                    d.this.cSE = true;
                    d.this.cSF = true;
                }
            }
        });
        aAv();
    }

    private void aAv() {
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
            this.cST.setVisibility(8);
        } else {
            this.cST.setVisibility(0);
        }
        if (z) {
            if (this.cSC == null || TextUtils.isEmpty(this.cSC.getPatch()) || this.cSC.getNewVersionCode() < 0) {
                this.cSU.setVisibility(0);
                this.cSS.setText(R.string.super_update);
                al.k(this.cSS, R.drawable.dialog_middle_item_bg_selector);
                this.cTa.setVisibility(0);
                this.cTf = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.cSU.setVisibility(0);
            this.cSS.setText(R.string.incremental_update);
            al.k(this.cSS, R.drawable.dialog_single_button_bg_selector);
            this.cSZ.setVisibility(8);
            this.cTa.setVisibility(8);
            this.cTf = true;
            TiebaStatic.log("c10002");
        } else if (this.cSC == null || TextUtils.isEmpty(this.cSC.getPatch()) || this.cSC.getNewVersionCode() < 0) {
            this.cSU.setVisibility(8);
            this.cTa.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.cSU.setVisibility(0);
            al.k(this.cSS, R.drawable.dialog_middle_item_bg_selector);
            this.cSS.setText(R.string.incremental_update);
            this.cTa.setVisibility(0);
            this.cTf = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void updateProgress(int i) {
        this.cSQ.setVisibility(8);
        this.cSU.setVisibility(8);
        this.cSO.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.cSG = true;
        this.cTa.setVisibility(0);
        this.cSL.setVisibility(0);
        this.cSL.setText(this.cSM + i + "%");
        this.cSR.setVisibility(8);
        this.cSP.setVisibility(8);
    }

    public void gc(boolean z) {
        this.cSQ.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.cSG) {
            this.cTb.stopService();
            this.cSI.setVisibility(8);
            if (this.cSH) {
                this.cSW.setText(getContext().getString(R.string.download_exit));
            }
            this.cSV.setVisibility(0);
            return;
        }
        this.cTb.aAy();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.cSC = versionData;
        this.cSD = combineDownload;
        this.cTb = aVar;
    }

    public void aAw() {
        this.cSV.setVisibility(8);
        this.cSI.setVisibility(0);
    }

    public void g(View.OnClickListener onClickListener) {
        this.cTc = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.cTd = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        al.c(this.cSR, (int) R.drawable.write_close_selector);
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
