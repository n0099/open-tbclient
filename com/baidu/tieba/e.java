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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes.dex */
public class e extends Dialog {
    private String cKA;
    private TextView cKB;
    private TextView cKC;
    private TextView cKD;
    private TextView cKE;
    private ImageView cKF;
    private TextView cKG;
    private TextView cKH;
    private View cKI;
    private LinearLayout cKJ;
    private TextView cKK;
    private TextView cKL;
    private TextView cKM;
    private View cKN;
    private LinearLayout cKO;
    private a cKP;
    private View.OnClickListener cKQ;
    private View.OnClickListener cKR;
    private boolean cKS;
    private boolean cKT;
    private VersionData cKq;
    private CombineDownload cKr;
    private boolean cKs;
    private boolean cKt;
    private boolean cKu;
    private boolean cKv;
    private LinearLayout cKw;
    private TextView cKx;
    private TextView cKy;
    private TextView cKz;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    interface a {
        void avr();

        void avs();

        void fG(boolean z);

        void fH(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.cKs = false;
        this.cKt = true;
        this.cKu = false;
        this.cKv = false;
        this.cKS = true;
        this.cKT = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.this.cKD.getId()) {
                    e.this.cKP.avr();
                    e.this.dp(e.this.mContext);
                } else if (view.getId() == e.this.cKF.getId()) {
                    e.this.cKP.avr();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.app_download_dialog);
        this.cKw = (LinearLayout) findViewById(d.g.app_info);
        this.cKx = (TextView) findViewById(d.g.app_version_and_size);
        this.cKy = (TextView) findViewById(d.g.app_description);
        this.cKE = (TextView) findViewById(d.g.fullsize_download_button);
        this.cKC = (TextView) findViewById(d.g.cancel_download_button);
        this.cKD = (TextView) findViewById(d.g.btn_update_save_flow);
        this.cKF = (ImageView) findViewById(d.g.img_close);
        this.cKD.setOnClickListener(this.mOnClickListener);
        this.cKF.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(d.g.divider_line);
        this.cKz = (TextView) findViewById(d.g.download_process);
        this.cKG = (TextView) findViewById(d.g.incremental_download_button);
        this.cKH = (TextView) findViewById(d.g.not_install_as_tip);
        this.cKI = findViewById(d.g.incremental_download_layout);
        this.cKB = (TextView) findViewById(d.g.other_app_recommend);
        this.cKN = findViewById(d.g.divider_under_button);
        this.cKO = (LinearLayout) findViewById(d.g.cancel_confirm_ll);
        this.cKA = this.cKz.getText().toString();
        this.cKJ = (LinearLayout) findViewById(d.g.cancel_dialog);
        this.cKL = (TextView) findViewById(d.g.sure_cancel);
        this.cKM = (TextView) findViewById(d.g.cancel_button);
        this.cKK = (TextView) findViewById(d.g.cancel_tip);
        this.cKL.setOnClickListener(this.cKQ);
        this.cKM.setOnClickListener(this.cKR);
        if (com.baidu.adp.lib.b.d.iQ().aO("android_shouzhu_update") == 1) {
            this.cKS = true;
        } else {
            this.cKS = false;
        }
        String size = this.cKq.getSize();
        String newVersion = this.cKq.getNewVersion();
        String newVersionDesc = this.cKq.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.c(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.cKx.setText(sb.toString());
        this.cKy.setText(newVersionDesc);
        if (this.cKq.forceUpdate()) {
            this.cKv = true;
            this.cKC.setText(this.mContext.getString(d.j.quit));
            this.cKD.setVisibility(8);
            this.cKF.setVisibility(8);
        } else if (this.cKq.isOfficialVersion() && l.T(this.mContext, "com.tencent.android.qqdownloader")) {
            this.cKC.setVisibility(8);
        } else {
            this.cKC.setText(this.mContext.getString(d.j.update_after));
            this.cKD.setVisibility(8);
            this.cKF.setVisibility(8);
        }
        if (this.cKr != null && this.cKr.showCombineDownload() && !TextUtils.isEmpty(this.cKr.getApkMD5RSA())) {
            this.cKB.setText(this.cKr.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.cKr.getAppProc()) && !TextUtils.isEmpty(this.cKr.getAppUrl())) {
                this.cKB.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.cKB.setCompoundDrawables(drawable, null, null, null);
                this.cKs = true;
            } else {
                this.cKB.setVisibility(8);
                this.cKs = false;
            }
        } else {
            this.cKB.setVisibility(8);
            this.cKs = false;
        }
        fE(this.cKS);
        this.cKE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.cKu = true;
                if (e.this.cKt) {
                    Drawable drawable2 = al.getDrawable(d.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.cKB.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.cKP.fG(e.this.cKt);
            }
        });
        this.cKG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cKT) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.cKG.setEnabled(false);
                e.this.cKP.fH(e.this.cKt);
            }
        });
        this.cKC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cKP.avr();
            }
        });
        this.cKB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.cKu) {
                    if (e.this.cKt) {
                        Drawable drawable2 = al.getDrawable(d.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.cKB.setCompoundDrawables(drawable2, null, null, null);
                        e.this.cKs = false;
                        e.this.cKt = false;
                        return;
                    }
                    Drawable drawable3 = al.getDrawable(d.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.cKB.setCompoundDrawables(drawable3, null, null, null);
                    e.this.cKs = true;
                    e.this.cKt = true;
                }
            }
        });
        avp();
    }

    private void avp() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void fE(boolean z) {
        if (g.a(this.mContext.getPackageManager())) {
            this.cKH.setVisibility(8);
        } else {
            this.cKH.setVisibility(0);
        }
        if (z) {
            if (this.cKq == null || TextUtils.isEmpty(this.cKq.getPatch()) || this.cKq.getNewVersionCode() < 0) {
                this.cKI.setVisibility(0);
                this.cKG.setText(d.j.super_update);
                al.k(this.cKG, d.f.dialog_middle_item_bg_selector);
                this.cKO.setVisibility(0);
                this.cKT = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.cKI.setVisibility(0);
            this.cKG.setText(d.j.incremental_update);
            al.k(this.cKG, d.f.dialog_single_button_bg_selector);
            this.cKN.setVisibility(8);
            this.cKO.setVisibility(8);
            this.cKT = true;
            TiebaStatic.log("c10002");
        } else if (this.cKq == null || TextUtils.isEmpty(this.cKq.getPatch()) || this.cKq.getNewVersionCode() < 0) {
            this.cKI.setVisibility(8);
            this.cKO.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.cKI.setVisibility(0);
            al.k(this.cKG, d.f.dialog_middle_item_bg_selector);
            this.cKG.setText(d.j.incremental_update);
            this.cKO.setVisibility(0);
            this.cKT = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void updateProgress(int i) {
        this.cKE.setVisibility(8);
        this.cKI.setVisibility(8);
        this.cKC.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.cKu = true;
        this.cKO.setVisibility(0);
        this.cKz.setVisibility(0);
        this.cKz.setText(this.cKA + i + "%");
        this.cKF.setVisibility(8);
        this.cKD.setVisibility(8);
    }

    public void fF(boolean z) {
        this.cKE.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.cKu) {
            this.cKP.stopService();
            this.cKw.setVisibility(8);
            if (this.cKv) {
                this.cKK.setText(getContext().getString(d.j.download_exit));
            }
            this.cKJ.setVisibility(0);
            return;
        }
        this.cKP.avs();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.cKq = versionData;
        this.cKr = combineDownload;
        this.cKP = aVar;
    }

    public void avq() {
        this.cKJ.setVisibility(8);
        this.cKw.setVisibility(0);
    }

    public void g(View.OnClickListener onClickListener) {
        this.cKQ = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.cKR = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(d.g.app_download_dialog_layout));
        }
        al.c(this.cKF, d.f.write_close_selector);
    }

    public void dp(Context context) {
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
