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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes.dex */
public class e extends Dialog {
    private VersionData aZV;
    private CombineDownload aZW;
    private boolean aZX;
    private boolean aZY;
    private boolean aZZ;
    private boolean baa;
    private LinearLayout bab;
    private TextView bac;
    private TextView bad;
    private TextView bae;
    private String baf;
    private TextView bag;
    private TextView bah;
    private TextView bai;
    private View baj;
    private TextView bak;
    private TextView bal;
    private View bam;
    private LinearLayout ban;
    private TextView bao;
    private TextView bap;
    private TextView baq;
    private View bas;
    private LinearLayout bat;
    private a bau;
    private View.OnClickListener bav;
    private View.OnClickListener baw;
    private boolean bax;
    private boolean bay;
    private Context mContext;

    /* loaded from: classes.dex */
    interface a {
        void Lt();

        void Lu();

        void cn(boolean z);

        void co(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.aZX = false;
        this.aZY = true;
        this.aZZ = false;
        this.baa = false;
        this.bax = true;
        this.bay = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.app_download_dialog);
        this.bab = (LinearLayout) findViewById(d.g.app_info);
        this.bac = (TextView) findViewById(d.g.app_version_and_size);
        this.bad = (TextView) findViewById(d.g.app_description);
        this.bai = (TextView) findViewById(d.g.fullsize_download_button);
        this.bah = (TextView) findViewById(d.g.cancel_download_button);
        this.baj = findViewById(d.g.divider_line);
        this.bae = (TextView) findViewById(d.g.download_process);
        this.bak = (TextView) findViewById(d.g.incremental_download_button);
        this.bal = (TextView) findViewById(d.g.not_install_as_tip);
        this.bam = findViewById(d.g.incremental_download_layout);
        this.bag = (TextView) findViewById(d.g.other_app_recommend);
        this.bas = findViewById(d.g.divider_under_button);
        this.bat = (LinearLayout) findViewById(d.g.cancel_confirm_ll);
        this.baf = this.bae.getText().toString();
        this.ban = (LinearLayout) findViewById(d.g.cancel_dialog);
        this.bap = (TextView) findViewById(d.g.sure_cancel);
        this.baq = (TextView) findViewById(d.g.cancel_button);
        this.bao = (TextView) findViewById(d.g.cancel_tip);
        this.bap.setOnClickListener(this.bav);
        this.baq.setOnClickListener(this.baw);
        if (com.baidu.adp.lib.b.d.eV().af("android_shouzhu_update") == 1) {
            this.bax = true;
        } else {
            this.bax = false;
        }
        String size = this.aZV.getSize();
        String newVersion = this.aZV.getNewVersion();
        String newVersionDesc = this.aZV.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.bac.setText(sb.toString());
        this.bad.setText(newVersionDesc);
        if (this.aZV.forceUpdate()) {
            this.baa = true;
            this.bah.setText(this.mContext.getString(d.j.quit));
        } else {
            this.bah.setText(this.mContext.getString(d.j.update_after));
        }
        if (this.aZW != null && this.aZW.showCombineDownload() && !TextUtils.isEmpty(this.aZW.getApkMD5RSA())) {
            this.bag.setText(this.aZW.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.aZW.getAppProc()) && !TextUtils.isEmpty(this.aZW.getAppUrl())) {
                this.bag.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.bag.setCompoundDrawables(drawable, null, null, null);
                this.aZX = true;
            } else {
                this.bag.setVisibility(8);
                this.aZX = false;
            }
        } else {
            this.bag.setVisibility(8);
            this.aZX = false;
        }
        cm(this.bax);
        this.bai.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.bai.setEnabled(false);
                e.this.aZZ = true;
                if (e.this.aZY) {
                    Drawable drawable2 = aj.getDrawable(d.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.bag.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.bau.cn(e.this.aZY);
            }
        });
        this.bak.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bay) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.bak.setEnabled(false);
                e.this.bau.co(e.this.aZY);
            }
        });
        this.bah.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bau.Lt();
            }
        });
        this.bag.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.aZZ) {
                    if (e.this.aZY) {
                        Drawable drawable2 = aj.getDrawable(d.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.bag.setCompoundDrawables(drawable2, null, null, null);
                        e.this.aZX = false;
                        e.this.aZY = false;
                        return;
                    }
                    Drawable drawable3 = aj.getDrawable(d.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.bag.setCompoundDrawables(drawable3, null, null, null);
                    e.this.aZX = true;
                    e.this.aZY = true;
                }
            }
        });
        Lr();
    }

    private void Lr() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void cm(boolean z) {
        if (g.b(this.mContext.getPackageManager())) {
            this.bal.setVisibility(8);
        } else {
            this.bal.setVisibility(0);
        }
        if (z) {
            if (this.aZV == null || TextUtils.isEmpty(this.aZV.getPatch()) || this.aZV.getNewVersionCode() < 0) {
                this.bam.setVisibility(0);
                this.bak.setText(d.j.super_update);
                aj.j(this.bak, d.f.dialog_middle_item_bg_selector);
                this.bat.setVisibility(0);
                this.bay = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.bam.setVisibility(0);
            this.bak.setText(d.j.incremental_update);
            aj.j(this.bak, d.f.dialog_single_button_bg_selector);
            this.bas.setVisibility(8);
            this.bat.setVisibility(8);
            this.bay = true;
            TiebaStatic.log("c10002");
        } else if (this.aZV == null || TextUtils.isEmpty(this.aZV.getPatch()) || this.aZV.getNewVersionCode() < 0) {
            this.bam.setVisibility(8);
            this.bat.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.bam.setVisibility(0);
            aj.j(this.bak, d.f.dialog_middle_item_bg_selector);
            this.bak.setText(d.j.incremental_update);
            this.bat.setVisibility(0);
            this.bay = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void gr(int i) {
        this.bai.setVisibility(8);
        this.bam.setVisibility(8);
        this.bah.setVisibility(8);
        this.baj.setVisibility(8);
        this.aZZ = true;
        this.bat.setVisibility(0);
        this.bae.setVisibility(0);
        this.bae.setText(this.baf + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aZZ) {
            this.bau.stopService();
            this.bab.setVisibility(8);
            if (this.baa) {
                this.bao.setText(getContext().getString(d.j.download_exit));
            }
            this.ban.setVisibility(0);
            return;
        }
        this.bau.Lu();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aZV = versionData;
        this.aZW = combineDownload;
        this.bau = aVar;
    }

    public void Ls() {
        this.ban.setVisibility(8);
        this.bab.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.bav = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.baw = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ag(i == 1);
            tbPageContext.getLayoutMode().t(findViewById(d.g.app_download_dialog_layout));
        }
    }
}
