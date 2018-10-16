package com.baidu.tieba;

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
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes.dex */
public class f extends Dialog {
    private TextView buA;
    private TextView buB;
    private View buC;
    private LinearLayout buD;
    private TextView buE;
    private TextView buF;
    private TextView buG;
    private View buH;
    private LinearLayout buI;
    private a buJ;
    private View.OnClickListener buK;
    private View.OnClickListener buL;
    private boolean buM;
    private boolean buN;
    private VersionData buk;
    private CombineDownload bul;
    private boolean bum;
    private boolean bun;
    private boolean buo;
    private boolean bup;
    private LinearLayout buq;
    private TextView bur;
    private TextView bus;
    private TextView but;
    private String buu;
    private TextView buv;
    private TextView buw;
    private TextView bux;
    private TextView buy;
    private ImageView buz;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    interface a {
        void TE();

        void TF();

        void cV(boolean z);

        void cW(boolean z);

        void stopService();
    }

    public f(Context context, int i) {
        super(context, i);
        this.bum = false;
        this.bun = true;
        this.buo = false;
        this.bup = false;
        this.buM = true;
        this.buN = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == f.this.bux.getId()) {
                    f.this.buJ.TE();
                    f.this.bX(f.this.mContext);
                } else if (view.getId() == f.this.buz.getId()) {
                    f.this.buJ.TE();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.app_download_dialog);
        this.buq = (LinearLayout) findViewById(e.g.app_info);
        this.bur = (TextView) findViewById(e.g.app_version_and_size);
        this.bus = (TextView) findViewById(e.g.app_description);
        this.buy = (TextView) findViewById(e.g.fullsize_download_button);
        this.buw = (TextView) findViewById(e.g.cancel_download_button);
        this.bux = (TextView) findViewById(e.g.btn_update_save_flow);
        this.buz = (ImageView) findViewById(e.g.img_close);
        this.bux.setOnClickListener(this.mOnClickListener);
        this.buz.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(e.g.divider_line);
        this.but = (TextView) findViewById(e.g.download_process);
        this.buA = (TextView) findViewById(e.g.incremental_download_button);
        this.buB = (TextView) findViewById(e.g.not_install_as_tip);
        this.buC = findViewById(e.g.incremental_download_layout);
        this.buv = (TextView) findViewById(e.g.other_app_recommend);
        this.buH = findViewById(e.g.divider_under_button);
        this.buI = (LinearLayout) findViewById(e.g.cancel_confirm_ll);
        this.buu = this.but.getText().toString();
        this.buD = (LinearLayout) findViewById(e.g.cancel_dialog);
        this.buF = (TextView) findViewById(e.g.sure_cancel);
        this.buG = (TextView) findViewById(e.g.cancel_button);
        this.buE = (TextView) findViewById(e.g.cancel_tip);
        this.buF.setOnClickListener(this.buK);
        this.buG.setOnClickListener(this.buL);
        if (com.baidu.adp.lib.b.d.iR().aO("android_shouzhu_update") == 1) {
            this.buM = true;
        } else {
            this.buM = false;
        }
        String size = this.buk.getSize();
        String newVersion = this.buk.getNewVersion();
        String newVersionDesc = this.buk.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(e.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.c(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.bur.setText(sb.toString());
        this.bus.setText(newVersionDesc);
        if (this.buk.forceUpdate()) {
            this.bup = true;
            this.buw.setText(this.mContext.getString(e.j.quit));
            this.bux.setVisibility(8);
            this.buz.setVisibility(8);
        } else if (this.buk.isOfficialVersion() && l.T(this.mContext, "com.tencent.android.qqdownloader")) {
            this.buw.setVisibility(8);
        } else {
            this.buw.setText(this.mContext.getString(e.j.update_after));
            this.bux.setVisibility(8);
            this.buz.setVisibility(8);
        }
        if (this.bul != null && this.bul.showCombineDownload() && !TextUtils.isEmpty(this.bul.getApkMD5RSA())) {
            this.buv.setText(this.bul.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.bul.getAppProc()) && !TextUtils.isEmpty(this.bul.getAppUrl())) {
                this.buv.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(e.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.buv.setCompoundDrawables(drawable, null, null, null);
                this.bum = true;
            } else {
                this.buv.setVisibility(8);
                this.bum = false;
            }
        } else {
            this.buv.setVisibility(8);
            this.bum = false;
        }
        cT(this.buM);
        this.buy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                f.this.buo = true;
                if (f.this.bun) {
                    Drawable drawable2 = al.getDrawable(e.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    f.this.buv.setCompoundDrawables(drawable2, null, null, null);
                }
                f.this.buJ.cV(f.this.bun);
            }
        });
        this.buA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.buN) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                f.this.buA.setEnabled(false);
                f.this.buJ.cW(f.this.bun);
            }
        });
        this.buw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.buJ.TE();
            }
        });
        this.buv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.buo) {
                    if (f.this.bun) {
                        Drawable drawable2 = al.getDrawable(e.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        f.this.buv.setCompoundDrawables(drawable2, null, null, null);
                        f.this.bum = false;
                        f.this.bun = false;
                        return;
                    }
                    Drawable drawable3 = al.getDrawable(e.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    f.this.buv.setCompoundDrawables(drawable3, null, null, null);
                    f.this.bum = true;
                    f.this.bun = true;
                }
            }
        });
        TC();
    }

    private void TC() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void cT(boolean z) {
        if (h.a(this.mContext.getPackageManager())) {
            this.buB.setVisibility(8);
        } else {
            this.buB.setVisibility(0);
        }
        if (z) {
            if (this.buk == null || TextUtils.isEmpty(this.buk.getPatch()) || this.buk.getNewVersionCode() < 0) {
                this.buC.setVisibility(0);
                this.buA.setText(e.j.super_update);
                al.i(this.buA, e.f.dialog_middle_item_bg_selector);
                this.buI.setVisibility(0);
                this.buN = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.buC.setVisibility(0);
            this.buA.setText(e.j.incremental_update);
            al.i(this.buA, e.f.dialog_single_button_bg_selector);
            this.buH.setVisibility(8);
            this.buI.setVisibility(8);
            this.buN = true;
            TiebaStatic.log("c10002");
        } else if (this.buk == null || TextUtils.isEmpty(this.buk.getPatch()) || this.buk.getNewVersionCode() < 0) {
            this.buC.setVisibility(8);
            this.buI.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.buC.setVisibility(0);
            al.i(this.buA, e.f.dialog_middle_item_bg_selector);
            this.buA.setText(e.j.incremental_update);
            this.buI.setVisibility(0);
            this.buN = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void updateProgress(int i) {
        this.buy.setVisibility(8);
        this.buC.setVisibility(8);
        this.buw.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.buo = true;
        this.buI.setVisibility(0);
        this.but.setVisibility(0);
        this.but.setText(this.buu + i + "%");
        this.buz.setVisibility(8);
        this.bux.setVisibility(8);
    }

    public void cU(boolean z) {
        this.buy.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.buo) {
            this.buJ.stopService();
            this.buq.setVisibility(8);
            if (this.bup) {
                this.buE.setText(getContext().getString(e.j.download_exit));
            }
            this.buD.setVisibility(0);
            return;
        }
        this.buJ.TF();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.buk = versionData;
        this.bul = combineDownload;
        this.buJ = aVar;
    }

    public void TD() {
        this.buD.setVisibility(8);
        this.buq.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.buK = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.buL = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(e.g.app_download_dialog_layout));
        }
        al.c(this.buz, e.f.write_close_selector);
    }

    public void bX(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + context.getPackageName()));
        try {
            intent.setClassName("com.tencent.android.qqdownloader", "com.tencent.pangu.link.LinkProxyActivity");
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }
}
