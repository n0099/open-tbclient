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
    private TextView cKA;
    private TextView cKB;
    private TextView cKC;
    private TextView cKD;
    private ImageView cKE;
    private TextView cKF;
    private TextView cKG;
    private View cKH;
    private LinearLayout cKI;
    private TextView cKJ;
    private TextView cKK;
    private TextView cKL;
    private View cKM;
    private LinearLayout cKN;
    private a cKO;
    private View.OnClickListener cKP;
    private View.OnClickListener cKQ;
    private boolean cKR;
    private boolean cKS;
    private VersionData cKp;
    private CombineDownload cKq;
    private boolean cKr;
    private boolean cKs;
    private boolean cKt;
    private boolean cKu;
    private LinearLayout cKv;
    private TextView cKw;
    private TextView cKx;
    private TextView cKy;
    private String cKz;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    interface a {
        void avo();

        void avp();

        void fG(boolean z);

        void fH(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.cKr = false;
        this.cKs = true;
        this.cKt = false;
        this.cKu = false;
        this.cKR = true;
        this.cKS = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.this.cKC.getId()) {
                    e.this.cKO.avo();
                    e.this.m20do(e.this.mContext);
                } else if (view.getId() == e.this.cKE.getId()) {
                    e.this.cKO.avo();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.app_download_dialog);
        this.cKv = (LinearLayout) findViewById(d.g.app_info);
        this.cKw = (TextView) findViewById(d.g.app_version_and_size);
        this.cKx = (TextView) findViewById(d.g.app_description);
        this.cKD = (TextView) findViewById(d.g.fullsize_download_button);
        this.cKB = (TextView) findViewById(d.g.cancel_download_button);
        this.cKC = (TextView) findViewById(d.g.btn_update_save_flow);
        this.cKE = (ImageView) findViewById(d.g.img_close);
        this.cKC.setOnClickListener(this.mOnClickListener);
        this.cKE.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(d.g.divider_line);
        this.cKy = (TextView) findViewById(d.g.download_process);
        this.cKF = (TextView) findViewById(d.g.incremental_download_button);
        this.cKG = (TextView) findViewById(d.g.not_install_as_tip);
        this.cKH = findViewById(d.g.incremental_download_layout);
        this.cKA = (TextView) findViewById(d.g.other_app_recommend);
        this.cKM = findViewById(d.g.divider_under_button);
        this.cKN = (LinearLayout) findViewById(d.g.cancel_confirm_ll);
        this.cKz = this.cKy.getText().toString();
        this.cKI = (LinearLayout) findViewById(d.g.cancel_dialog);
        this.cKK = (TextView) findViewById(d.g.sure_cancel);
        this.cKL = (TextView) findViewById(d.g.cancel_button);
        this.cKJ = (TextView) findViewById(d.g.cancel_tip);
        this.cKK.setOnClickListener(this.cKP);
        this.cKL.setOnClickListener(this.cKQ);
        if (com.baidu.adp.lib.b.d.iQ().aO("android_shouzhu_update") == 1) {
            this.cKR = true;
        } else {
            this.cKR = false;
        }
        String size = this.cKp.getSize();
        String newVersion = this.cKp.getNewVersion();
        String newVersionDesc = this.cKp.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.c(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.cKw.setText(sb.toString());
        this.cKx.setText(newVersionDesc);
        if (this.cKp.forceUpdate()) {
            this.cKu = true;
            this.cKB.setText(this.mContext.getString(d.j.quit));
            this.cKC.setVisibility(8);
            this.cKE.setVisibility(8);
        } else if (this.cKp.isOfficialVersion() && l.T(this.mContext, "com.tencent.android.qqdownloader")) {
            this.cKB.setVisibility(8);
        } else {
            this.cKB.setText(this.mContext.getString(d.j.update_after));
            this.cKC.setVisibility(8);
            this.cKE.setVisibility(8);
        }
        if (this.cKq != null && this.cKq.showCombineDownload() && !TextUtils.isEmpty(this.cKq.getApkMD5RSA())) {
            this.cKA.setText(this.cKq.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.cKq.getAppProc()) && !TextUtils.isEmpty(this.cKq.getAppUrl())) {
                this.cKA.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.cKA.setCompoundDrawables(drawable, null, null, null);
                this.cKr = true;
            } else {
                this.cKA.setVisibility(8);
                this.cKr = false;
            }
        } else {
            this.cKA.setVisibility(8);
            this.cKr = false;
        }
        fE(this.cKR);
        this.cKD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.cKt = true;
                if (e.this.cKs) {
                    Drawable drawable2 = al.getDrawable(d.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.cKA.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.cKO.fG(e.this.cKs);
            }
        });
        this.cKF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cKS) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.cKF.setEnabled(false);
                e.this.cKO.fH(e.this.cKs);
            }
        });
        this.cKB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cKO.avo();
            }
        });
        this.cKA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.cKt) {
                    if (e.this.cKs) {
                        Drawable drawable2 = al.getDrawable(d.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.cKA.setCompoundDrawables(drawable2, null, null, null);
                        e.this.cKr = false;
                        e.this.cKs = false;
                        return;
                    }
                    Drawable drawable3 = al.getDrawable(d.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.cKA.setCompoundDrawables(drawable3, null, null, null);
                    e.this.cKr = true;
                    e.this.cKs = true;
                }
            }
        });
        avm();
    }

    private void avm() {
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
            this.cKG.setVisibility(8);
        } else {
            this.cKG.setVisibility(0);
        }
        if (z) {
            if (this.cKp == null || TextUtils.isEmpty(this.cKp.getPatch()) || this.cKp.getNewVersionCode() < 0) {
                this.cKH.setVisibility(0);
                this.cKF.setText(d.j.super_update);
                al.k(this.cKF, d.f.dialog_middle_item_bg_selector);
                this.cKN.setVisibility(0);
                this.cKS = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.cKH.setVisibility(0);
            this.cKF.setText(d.j.incremental_update);
            al.k(this.cKF, d.f.dialog_single_button_bg_selector);
            this.cKM.setVisibility(8);
            this.cKN.setVisibility(8);
            this.cKS = true;
            TiebaStatic.log("c10002");
        } else if (this.cKp == null || TextUtils.isEmpty(this.cKp.getPatch()) || this.cKp.getNewVersionCode() < 0) {
            this.cKH.setVisibility(8);
            this.cKN.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.cKH.setVisibility(0);
            al.k(this.cKF, d.f.dialog_middle_item_bg_selector);
            this.cKF.setText(d.j.incremental_update);
            this.cKN.setVisibility(0);
            this.cKS = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void updateProgress(int i) {
        this.cKD.setVisibility(8);
        this.cKH.setVisibility(8);
        this.cKB.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.cKt = true;
        this.cKN.setVisibility(0);
        this.cKy.setVisibility(0);
        this.cKy.setText(this.cKz + i + "%");
        this.cKE.setVisibility(8);
        this.cKC.setVisibility(8);
    }

    public void fF(boolean z) {
        this.cKD.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.cKt) {
            this.cKO.stopService();
            this.cKv.setVisibility(8);
            if (this.cKu) {
                this.cKJ.setText(getContext().getString(d.j.download_exit));
            }
            this.cKI.setVisibility(0);
            return;
        }
        this.cKO.avp();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.cKp = versionData;
        this.cKq = combineDownload;
        this.cKO = aVar;
    }

    public void avn() {
        this.cKI.setVisibility(8);
        this.cKv.setVisibility(0);
    }

    public void g(View.OnClickListener onClickListener) {
        this.cKP = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.cKQ = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(d.g.app_download_dialog_layout));
        }
        al.c(this.cKE, d.f.write_close_selector);
    }

    /* renamed from: do  reason: not valid java name */
    public void m20do(Context context) {
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
