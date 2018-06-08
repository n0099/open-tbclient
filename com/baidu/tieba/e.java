package com.baidu.tieba;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes.dex */
public class e extends Dialog {
    private LinearLayout biA;
    private a biB;
    private View.OnClickListener biC;
    private View.OnClickListener biD;
    private boolean biE;
    private boolean biF;
    private VersionData bib;
    private CombineDownload bic;
    private boolean bie;
    private boolean bif;
    private boolean bih;
    private boolean bii;
    private LinearLayout bij;
    private TextView bik;
    private TextView bil;
    private TextView bim;
    private String bin;
    private TextView bio;
    private TextView bip;
    private TextView biq;
    private View bir;
    private TextView bis;
    private TextView bit;
    private View biu;
    private LinearLayout biv;
    private TextView biw;
    private TextView bix;
    private TextView biy;
    private View biz;
    private Context mContext;

    /* loaded from: classes.dex */
    interface a {
        void Pl();

        void Pm();

        void cq(boolean z);

        void cr(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.bie = false;
        this.bif = true;
        this.bih = false;
        this.bii = false;
        this.biE = true;
        this.biF = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.app_download_dialog);
        this.bij = (LinearLayout) findViewById(d.g.app_info);
        this.bik = (TextView) findViewById(d.g.app_version_and_size);
        this.bil = (TextView) findViewById(d.g.app_description);
        this.biq = (TextView) findViewById(d.g.fullsize_download_button);
        this.bip = (TextView) findViewById(d.g.cancel_download_button);
        this.bir = findViewById(d.g.divider_line);
        this.bim = (TextView) findViewById(d.g.download_process);
        this.bis = (TextView) findViewById(d.g.incremental_download_button);
        this.bit = (TextView) findViewById(d.g.not_install_as_tip);
        this.biu = findViewById(d.g.incremental_download_layout);
        this.bio = (TextView) findViewById(d.g.other_app_recommend);
        this.biz = findViewById(d.g.divider_under_button);
        this.biA = (LinearLayout) findViewById(d.g.cancel_confirm_ll);
        this.bin = this.bim.getText().toString();
        this.biv = (LinearLayout) findViewById(d.g.cancel_dialog);
        this.bix = (TextView) findViewById(d.g.sure_cancel);
        this.biy = (TextView) findViewById(d.g.cancel_button);
        this.biw = (TextView) findViewById(d.g.cancel_tip);
        this.bix.setOnClickListener(this.biC);
        this.biy.setOnClickListener(this.biD);
        if (com.baidu.adp.lib.b.d.hv().aw("android_shouzhu_update") == 1) {
            this.biE = true;
        } else {
            this.biE = false;
        }
        String size = this.bib.getSize();
        String newVersion = this.bib.getNewVersion();
        String newVersionDesc = this.bib.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.k.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.c(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.bik.setText(sb.toString());
        this.bil.setText(newVersionDesc);
        if (this.bib.forceUpdate()) {
            this.bii = true;
            this.bip.setText(this.mContext.getString(d.k.quit));
        } else {
            this.bip.setText(this.mContext.getString(d.k.update_after));
        }
        if (this.bic != null && this.bic.showCombineDownload() && !TextUtils.isEmpty(this.bic.getApkMD5RSA())) {
            this.bio.setText(this.bic.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.bic.getAppProc()) && !TextUtils.isEmpty(this.bic.getAppUrl())) {
                this.bio.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.bio.setCompoundDrawables(drawable, null, null, null);
                this.bie = true;
            } else {
                this.bio.setVisibility(8);
                this.bie = false;
            }
        } else {
            this.bio.setVisibility(8);
            this.bie = false;
        }
        co(this.biE);
        this.biq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.bih = true;
                if (e.this.bif) {
                    Drawable drawable2 = al.getDrawable(d.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.bio.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.biB.cq(e.this.bif);
            }
        });
        this.bis.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.biF) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.bis.setEnabled(false);
                e.this.biB.cr(e.this.bif);
            }
        });
        this.bip.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.biB.Pl();
            }
        });
        this.bio.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.bih) {
                    if (e.this.bif) {
                        Drawable drawable2 = al.getDrawable(d.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.bio.setCompoundDrawables(drawable2, null, null, null);
                        e.this.bie = false;
                        e.this.bif = false;
                        return;
                    }
                    Drawable drawable3 = al.getDrawable(d.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.bio.setCompoundDrawables(drawable3, null, null, null);
                    e.this.bie = true;
                    e.this.bif = true;
                }
            }
        });
        Pj();
    }

    private void Pj() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void co(boolean z) {
        if (g.b(this.mContext.getPackageManager())) {
            this.bit.setVisibility(8);
        } else {
            this.bit.setVisibility(0);
        }
        if (z) {
            if (this.bib == null || TextUtils.isEmpty(this.bib.getPatch()) || this.bib.getNewVersionCode() < 0) {
                this.biu.setVisibility(0);
                this.bis.setText(d.k.super_update);
                al.i(this.bis, d.f.dialog_middle_item_bg_selector);
                this.biA.setVisibility(0);
                this.biF = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.biu.setVisibility(0);
            this.bis.setText(d.k.incremental_update);
            al.i(this.bis, d.f.dialog_single_button_bg_selector);
            this.biz.setVisibility(8);
            this.biA.setVisibility(8);
            this.biF = true;
            TiebaStatic.log("c10002");
        } else if (this.bib == null || TextUtils.isEmpty(this.bib.getPatch()) || this.bib.getNewVersionCode() < 0) {
            this.biu.setVisibility(8);
            this.biA.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.biu.setVisibility(0);
            al.i(this.bis, d.f.dialog_middle_item_bg_selector);
            this.bis.setText(d.k.incremental_update);
            this.biA.setVisibility(0);
            this.biF = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void gi(int i) {
        this.biq.setVisibility(8);
        this.biu.setVisibility(8);
        this.bip.setVisibility(8);
        this.bir.setVisibility(8);
        this.bih = true;
        this.biA.setVisibility(0);
        this.bim.setVisibility(0);
        this.bim.setText(this.bin + i + "%");
    }

    public void cp(boolean z) {
        this.biq.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.bih) {
            this.biB.stopService();
            this.bij.setVisibility(8);
            if (this.bii) {
                this.biw.setText(getContext().getString(d.k.download_exit));
            }
            this.biv.setVisibility(0);
            return;
        }
        this.biB.Pm();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.bib = versionData;
        this.bic = combineDownload;
        this.biB = aVar;
    }

    public void Pk() {
        this.biv.setVisibility(8);
        this.bij.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.biC = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.biD = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(d.g.app_download_dialog_layout));
        }
    }
}
