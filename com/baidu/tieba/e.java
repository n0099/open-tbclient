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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes.dex */
public class e extends Dialog {
    private VersionData aZR;
    private CombineDownload aZS;
    private boolean aZT;
    private boolean aZU;
    private boolean aZV;
    private boolean aZW;
    private LinearLayout aZX;
    private TextView aZY;
    private TextView aZZ;
    private TextView baa;
    private String bab;
    private TextView bac;
    private TextView bad;
    private TextView bae;
    private View baf;
    private TextView bag;
    private TextView bah;
    private View bai;
    private LinearLayout baj;
    private TextView bak;
    private TextView bal;
    private TextView bam;
    private View ban;
    private LinearLayout bao;
    private a bap;
    private View.OnClickListener baq;
    private View.OnClickListener bas;
    private boolean bat;
    private boolean bau;
    private Context mContext;

    /* loaded from: classes.dex */
    interface a {
        void LM();

        void LN();

        void cl(boolean z);

        void cm(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.aZT = false;
        this.aZU = true;
        this.aZV = false;
        this.aZW = false;
        this.bat = true;
        this.bau = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.app_download_dialog);
        this.aZX = (LinearLayout) findViewById(d.g.app_info);
        this.aZY = (TextView) findViewById(d.g.app_version_and_size);
        this.aZZ = (TextView) findViewById(d.g.app_description);
        this.bae = (TextView) findViewById(d.g.fullsize_download_button);
        this.bad = (TextView) findViewById(d.g.cancel_download_button);
        this.baf = findViewById(d.g.divider_line);
        this.baa = (TextView) findViewById(d.g.download_process);
        this.bag = (TextView) findViewById(d.g.incremental_download_button);
        this.bah = (TextView) findViewById(d.g.not_install_as_tip);
        this.bai = findViewById(d.g.incremental_download_layout);
        this.bac = (TextView) findViewById(d.g.other_app_recommend);
        this.ban = findViewById(d.g.divider_under_button);
        this.bao = (LinearLayout) findViewById(d.g.cancel_confirm_ll);
        this.bab = this.baa.getText().toString();
        this.baj = (LinearLayout) findViewById(d.g.cancel_dialog);
        this.bal = (TextView) findViewById(d.g.sure_cancel);
        this.bam = (TextView) findViewById(d.g.cancel_button);
        this.bak = (TextView) findViewById(d.g.cancel_tip);
        this.bal.setOnClickListener(this.baq);
        this.bam.setOnClickListener(this.bas);
        if (com.baidu.adp.lib.b.d.eE().ak("android_shouzhu_update") == 1) {
            this.bat = true;
        } else {
            this.bat = false;
        }
        String size = this.aZR.getSize();
        String newVersion = this.aZR.getNewVersion();
        String newVersionDesc = this.aZR.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.k.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aZY.setText(sb.toString());
        this.aZZ.setText(newVersionDesc);
        if (this.aZR.forceUpdate()) {
            this.aZW = true;
            this.bad.setText(this.mContext.getString(d.k.quit));
        } else {
            this.bad.setText(this.mContext.getString(d.k.update_after));
        }
        if (this.aZS != null && this.aZS.showCombineDownload() && !TextUtils.isEmpty(this.aZS.getApkMD5RSA())) {
            this.bac.setText(this.aZS.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.aZS.getAppProc()) && !TextUtils.isEmpty(this.aZS.getAppUrl())) {
                this.bac.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.bac.setCompoundDrawables(drawable, null, null, null);
                this.aZT = true;
            } else {
                this.bac.setVisibility(8);
                this.aZT = false;
            }
        } else {
            this.bac.setVisibility(8);
            this.aZT = false;
        }
        cj(this.bat);
        this.bae.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log("c10003");
                e.this.aZV = true;
                if (e.this.aZU) {
                    Drawable drawable2 = ak.getDrawable(d.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.bac.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.bap.cl(e.this.aZU);
            }
        });
        this.bag.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.bau) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.bag.setEnabled(false);
                e.this.bap.cm(e.this.aZU);
            }
        });
        this.bad.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.bap.LM();
            }
        });
        this.bac.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!e.this.aZV) {
                    if (e.this.aZU) {
                        Drawable drawable2 = ak.getDrawable(d.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.bac.setCompoundDrawables(drawable2, null, null, null);
                        e.this.aZT = false;
                        e.this.aZU = false;
                        return;
                    }
                    Drawable drawable3 = ak.getDrawable(d.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.bac.setCompoundDrawables(drawable3, null, null, null);
                    e.this.aZT = true;
                    e.this.aZU = true;
                }
            }
        });
        LK();
    }

    private void LK() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void cj(boolean z) {
        if (g.b(this.mContext.getPackageManager())) {
            this.bah.setVisibility(8);
        } else {
            this.bah.setVisibility(0);
        }
        if (z) {
            if (this.aZR == null || TextUtils.isEmpty(this.aZR.getPatch()) || this.aZR.getNewVersionCode() < 0) {
                this.bai.setVisibility(0);
                this.bag.setText(d.k.super_update);
                ak.i(this.bag, d.f.dialog_middle_item_bg_selector);
                this.bao.setVisibility(0);
                this.bau = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.bai.setVisibility(0);
            this.bag.setText(d.k.incremental_update);
            ak.i(this.bag, d.f.dialog_single_button_bg_selector);
            this.ban.setVisibility(8);
            this.bao.setVisibility(8);
            this.bau = true;
            TiebaStatic.log("c10002");
        } else if (this.aZR == null || TextUtils.isEmpty(this.aZR.getPatch()) || this.aZR.getNewVersionCode() < 0) {
            this.bai.setVisibility(8);
            this.bao.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.bai.setVisibility(0);
            ak.i(this.bag, d.f.dialog_middle_item_bg_selector);
            this.bag.setText(d.k.incremental_update);
            this.bao.setVisibility(0);
            this.bau = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void gh(int i) {
        this.bae.setVisibility(8);
        this.bai.setVisibility(8);
        this.bad.setVisibility(8);
        this.baf.setVisibility(8);
        this.aZV = true;
        this.bao.setVisibility(0);
        this.baa.setVisibility(0);
        this.baa.setText(this.bab + i + "%");
    }

    public void ck(boolean z) {
        this.bae.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aZV) {
            this.bap.stopService();
            this.aZX.setVisibility(8);
            if (this.aZW) {
                this.bak.setText(getContext().getString(d.k.download_exit));
            }
            this.baj.setVisibility(0);
            return;
        }
        this.bap.LN();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aZR = versionData;
        this.aZS = combineDownload;
        this.bap = aVar;
    }

    public void LL() {
        this.baj.setVisibility(8);
        this.aZX.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.baq = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.bas = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().u(findViewById(d.g.app_download_dialog_layout));
        }
    }
}
