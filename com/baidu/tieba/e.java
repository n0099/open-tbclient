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
    private VersionData aZQ;
    private CombineDownload aZR;
    private boolean aZS;
    private boolean aZT;
    private boolean aZU;
    private boolean aZV;
    private LinearLayout aZW;
    private TextView aZX;
    private TextView aZY;
    private TextView aZZ;
    private String baa;
    private TextView bab;
    private TextView bac;
    private TextView bad;
    private View bae;
    private TextView baf;
    private TextView bag;
    private View bah;
    private LinearLayout bai;
    private TextView baj;
    private TextView bak;
    private TextView bal;
    private View bam;
    private LinearLayout ban;
    private a bao;
    private View.OnClickListener bap;
    private View.OnClickListener baq;
    private boolean bas;
    private boolean bat;
    private Context mContext;

    /* loaded from: classes.dex */
    interface a {
        void LO();

        void LP();

        void cl(boolean z);

        void cm(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.aZS = false;
        this.aZT = true;
        this.aZU = false;
        this.aZV = false;
        this.bas = true;
        this.bat = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.app_download_dialog);
        this.aZW = (LinearLayout) findViewById(d.g.app_info);
        this.aZX = (TextView) findViewById(d.g.app_version_and_size);
        this.aZY = (TextView) findViewById(d.g.app_description);
        this.bad = (TextView) findViewById(d.g.fullsize_download_button);
        this.bac = (TextView) findViewById(d.g.cancel_download_button);
        this.bae = findViewById(d.g.divider_line);
        this.aZZ = (TextView) findViewById(d.g.download_process);
        this.baf = (TextView) findViewById(d.g.incremental_download_button);
        this.bag = (TextView) findViewById(d.g.not_install_as_tip);
        this.bah = findViewById(d.g.incremental_download_layout);
        this.bab = (TextView) findViewById(d.g.other_app_recommend);
        this.bam = findViewById(d.g.divider_under_button);
        this.ban = (LinearLayout) findViewById(d.g.cancel_confirm_ll);
        this.baa = this.aZZ.getText().toString();
        this.bai = (LinearLayout) findViewById(d.g.cancel_dialog);
        this.bak = (TextView) findViewById(d.g.sure_cancel);
        this.bal = (TextView) findViewById(d.g.cancel_button);
        this.baj = (TextView) findViewById(d.g.cancel_tip);
        this.bak.setOnClickListener(this.bap);
        this.bal.setOnClickListener(this.baq);
        if (com.baidu.adp.lib.b.d.eE().ak("android_shouzhu_update") == 1) {
            this.bas = true;
        } else {
            this.bas = false;
        }
        String size = this.aZQ.getSize();
        String newVersion = this.aZQ.getNewVersion();
        String newVersionDesc = this.aZQ.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.k.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aZX.setText(sb.toString());
        this.aZY.setText(newVersionDesc);
        if (this.aZQ.forceUpdate()) {
            this.aZV = true;
            this.bac.setText(this.mContext.getString(d.k.quit));
        } else {
            this.bac.setText(this.mContext.getString(d.k.update_after));
        }
        if (this.aZR != null && this.aZR.showCombineDownload() && !TextUtils.isEmpty(this.aZR.getApkMD5RSA())) {
            this.bab.setText(this.aZR.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.aZR.getAppProc()) && !TextUtils.isEmpty(this.aZR.getAppUrl())) {
                this.bab.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.bab.setCompoundDrawables(drawable, null, null, null);
                this.aZS = true;
            } else {
                this.bab.setVisibility(8);
                this.aZS = false;
            }
        } else {
            this.bab.setVisibility(8);
            this.aZS = false;
        }
        cj(this.bas);
        this.bad.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log("c10003");
                e.this.aZU = true;
                if (e.this.aZT) {
                    Drawable drawable2 = ak.getDrawable(d.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.bab.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.bao.cl(e.this.aZT);
            }
        });
        this.baf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.bat) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.baf.setEnabled(false);
                e.this.bao.cm(e.this.aZT);
            }
        });
        this.bac.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.bao.LO();
            }
        });
        this.bab.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!e.this.aZU) {
                    if (e.this.aZT) {
                        Drawable drawable2 = ak.getDrawable(d.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.bab.setCompoundDrawables(drawable2, null, null, null);
                        e.this.aZS = false;
                        e.this.aZT = false;
                        return;
                    }
                    Drawable drawable3 = ak.getDrawable(d.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.bab.setCompoundDrawables(drawable3, null, null, null);
                    e.this.aZS = true;
                    e.this.aZT = true;
                }
            }
        });
        LM();
    }

    private void LM() {
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
            this.bag.setVisibility(8);
        } else {
            this.bag.setVisibility(0);
        }
        if (z) {
            if (this.aZQ == null || TextUtils.isEmpty(this.aZQ.getPatch()) || this.aZQ.getNewVersionCode() < 0) {
                this.bah.setVisibility(0);
                this.baf.setText(d.k.super_update);
                ak.i(this.baf, d.f.dialog_middle_item_bg_selector);
                this.ban.setVisibility(0);
                this.bat = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.bah.setVisibility(0);
            this.baf.setText(d.k.incremental_update);
            ak.i(this.baf, d.f.dialog_single_button_bg_selector);
            this.bam.setVisibility(8);
            this.ban.setVisibility(8);
            this.bat = true;
            TiebaStatic.log("c10002");
        } else if (this.aZQ == null || TextUtils.isEmpty(this.aZQ.getPatch()) || this.aZQ.getNewVersionCode() < 0) {
            this.bah.setVisibility(8);
            this.ban.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.bah.setVisibility(0);
            ak.i(this.baf, d.f.dialog_middle_item_bg_selector);
            this.baf.setText(d.k.incremental_update);
            this.ban.setVisibility(0);
            this.bat = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void gh(int i) {
        this.bad.setVisibility(8);
        this.bah.setVisibility(8);
        this.bac.setVisibility(8);
        this.bae.setVisibility(8);
        this.aZU = true;
        this.ban.setVisibility(0);
        this.aZZ.setVisibility(0);
        this.aZZ.setText(this.baa + i + "%");
    }

    public void ck(boolean z) {
        this.bad.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aZU) {
            this.bao.stopService();
            this.aZW.setVisibility(8);
            if (this.aZV) {
                this.baj.setText(getContext().getString(d.k.download_exit));
            }
            this.bai.setVisibility(0);
            return;
        }
        this.bao.LP();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aZQ = versionData;
        this.aZR = combineDownload;
        this.bao = aVar;
    }

    public void LN() {
        this.bai.setVisibility(8);
        this.aZW.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.bap = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.baq = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().u(findViewById(d.g.app_download_dialog_layout));
        }
    }
}
