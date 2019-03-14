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
    private ImageView cKC;
    private TextView cKD;
    private TextView cKE;
    private View cKF;
    private LinearLayout cKG;
    private TextView cKH;
    private TextView cKI;
    private TextView cKJ;
    private View cKK;
    private LinearLayout cKL;
    private a cKM;
    private View.OnClickListener cKN;
    private View.OnClickListener cKO;
    private boolean cKP;
    private boolean cKQ;
    private VersionData cKn;
    private CombineDownload cKo;
    private boolean cKp;
    private boolean cKq;
    private boolean cKr;
    private boolean cKs;
    private LinearLayout cKt;
    private TextView cKu;
    private TextView cKv;
    private TextView cKw;
    private String cKx;
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
        this.cKp = false;
        this.cKq = true;
        this.cKr = false;
        this.cKs = false;
        this.cKP = true;
        this.cKQ = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.this.cKA.getId()) {
                    e.this.cKM.avr();
                    e.this.m20do(e.this.mContext);
                } else if (view.getId() == e.this.cKC.getId()) {
                    e.this.cKM.avr();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.app_download_dialog);
        this.cKt = (LinearLayout) findViewById(d.g.app_info);
        this.cKu = (TextView) findViewById(d.g.app_version_and_size);
        this.cKv = (TextView) findViewById(d.g.app_description);
        this.cKB = (TextView) findViewById(d.g.fullsize_download_button);
        this.cKz = (TextView) findViewById(d.g.cancel_download_button);
        this.cKA = (TextView) findViewById(d.g.btn_update_save_flow);
        this.cKC = (ImageView) findViewById(d.g.img_close);
        this.cKA.setOnClickListener(this.mOnClickListener);
        this.cKC.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(d.g.divider_line);
        this.cKw = (TextView) findViewById(d.g.download_process);
        this.cKD = (TextView) findViewById(d.g.incremental_download_button);
        this.cKE = (TextView) findViewById(d.g.not_install_as_tip);
        this.cKF = findViewById(d.g.incremental_download_layout);
        this.cKy = (TextView) findViewById(d.g.other_app_recommend);
        this.cKK = findViewById(d.g.divider_under_button);
        this.cKL = (LinearLayout) findViewById(d.g.cancel_confirm_ll);
        this.cKx = this.cKw.getText().toString();
        this.cKG = (LinearLayout) findViewById(d.g.cancel_dialog);
        this.cKI = (TextView) findViewById(d.g.sure_cancel);
        this.cKJ = (TextView) findViewById(d.g.cancel_button);
        this.cKH = (TextView) findViewById(d.g.cancel_tip);
        this.cKI.setOnClickListener(this.cKN);
        this.cKJ.setOnClickListener(this.cKO);
        if (com.baidu.adp.lib.b.d.iQ().aO("android_shouzhu_update") == 1) {
            this.cKP = true;
        } else {
            this.cKP = false;
        }
        String size = this.cKn.getSize();
        String newVersion = this.cKn.getNewVersion();
        String newVersionDesc = this.cKn.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.c(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.cKu.setText(sb.toString());
        this.cKv.setText(newVersionDesc);
        if (this.cKn.forceUpdate()) {
            this.cKs = true;
            this.cKz.setText(this.mContext.getString(d.j.quit));
            this.cKA.setVisibility(8);
            this.cKC.setVisibility(8);
        } else if (this.cKn.isOfficialVersion() && l.T(this.mContext, "com.tencent.android.qqdownloader")) {
            this.cKz.setVisibility(8);
        } else {
            this.cKz.setText(this.mContext.getString(d.j.update_after));
            this.cKA.setVisibility(8);
            this.cKC.setVisibility(8);
        }
        if (this.cKo != null && this.cKo.showCombineDownload() && !TextUtils.isEmpty(this.cKo.getApkMD5RSA())) {
            this.cKy.setText(this.cKo.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.cKo.getAppProc()) && !TextUtils.isEmpty(this.cKo.getAppUrl())) {
                this.cKy.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.cKy.setCompoundDrawables(drawable, null, null, null);
                this.cKp = true;
            } else {
                this.cKy.setVisibility(8);
                this.cKp = false;
            }
        } else {
            this.cKy.setVisibility(8);
            this.cKp = false;
        }
        fE(this.cKP);
        this.cKB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.cKr = true;
                if (e.this.cKq) {
                    Drawable drawable2 = al.getDrawable(d.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.cKy.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.cKM.fG(e.this.cKq);
            }
        });
        this.cKD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cKQ) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.cKD.setEnabled(false);
                e.this.cKM.fH(e.this.cKq);
            }
        });
        this.cKz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cKM.avr();
            }
        });
        this.cKy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.cKr) {
                    if (e.this.cKq) {
                        Drawable drawable2 = al.getDrawable(d.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.cKy.setCompoundDrawables(drawable2, null, null, null);
                        e.this.cKp = false;
                        e.this.cKq = false;
                        return;
                    }
                    Drawable drawable3 = al.getDrawable(d.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.cKy.setCompoundDrawables(drawable3, null, null, null);
                    e.this.cKp = true;
                    e.this.cKq = true;
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
            this.cKE.setVisibility(8);
        } else {
            this.cKE.setVisibility(0);
        }
        if (z) {
            if (this.cKn == null || TextUtils.isEmpty(this.cKn.getPatch()) || this.cKn.getNewVersionCode() < 0) {
                this.cKF.setVisibility(0);
                this.cKD.setText(d.j.super_update);
                al.k(this.cKD, d.f.dialog_middle_item_bg_selector);
                this.cKL.setVisibility(0);
                this.cKQ = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.cKF.setVisibility(0);
            this.cKD.setText(d.j.incremental_update);
            al.k(this.cKD, d.f.dialog_single_button_bg_selector);
            this.cKK.setVisibility(8);
            this.cKL.setVisibility(8);
            this.cKQ = true;
            TiebaStatic.log("c10002");
        } else if (this.cKn == null || TextUtils.isEmpty(this.cKn.getPatch()) || this.cKn.getNewVersionCode() < 0) {
            this.cKF.setVisibility(8);
            this.cKL.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.cKF.setVisibility(0);
            al.k(this.cKD, d.f.dialog_middle_item_bg_selector);
            this.cKD.setText(d.j.incremental_update);
            this.cKL.setVisibility(0);
            this.cKQ = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void updateProgress(int i) {
        this.cKB.setVisibility(8);
        this.cKF.setVisibility(8);
        this.cKz.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.cKr = true;
        this.cKL.setVisibility(0);
        this.cKw.setVisibility(0);
        this.cKw.setText(this.cKx + i + "%");
        this.cKC.setVisibility(8);
        this.cKA.setVisibility(8);
    }

    public void fF(boolean z) {
        this.cKB.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.cKr) {
            this.cKM.stopService();
            this.cKt.setVisibility(8);
            if (this.cKs) {
                this.cKH.setText(getContext().getString(d.j.download_exit));
            }
            this.cKG.setVisibility(0);
            return;
        }
        this.cKM.avs();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.cKn = versionData;
        this.cKo = combineDownload;
        this.cKM = aVar;
    }

    public void avq() {
        this.cKG.setVisibility(8);
        this.cKt.setVisibility(0);
    }

    public void g(View.OnClickListener onClickListener) {
        this.cKN = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.cKO = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(d.g.app_download_dialog_layout));
        }
        al.c(this.cKC, d.f.write_close_selector);
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
