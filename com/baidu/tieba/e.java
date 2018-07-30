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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes.dex */
public class e extends Dialog {
    private LinearLayout bkA;
    private TextView bkB;
    private TextView bkC;
    private TextView bkD;
    private View bkE;
    private LinearLayout bkF;
    private a bkG;
    private View.OnClickListener bkH;
    private View.OnClickListener bkI;
    private boolean bkJ;
    private boolean bkK;
    private VersionData bki;
    private CombineDownload bkj;
    private boolean bkk;
    private boolean bkl;
    private boolean bkm;
    private boolean bkn;
    private LinearLayout bko;
    private TextView bkp;
    private TextView bkq;
    private TextView bkr;
    private String bks;
    private TextView bkt;
    private TextView bku;
    private TextView bkv;
    private View bkw;
    private TextView bkx;
    private TextView bky;
    private View bkz;
    private Context mContext;

    /* loaded from: classes.dex */
    interface a {
        void PO();

        void PP();

        void cu(boolean z);

        void cv(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.bkk = false;
        this.bkl = true;
        this.bkm = false;
        this.bkn = false;
        this.bkJ = true;
        this.bkK = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.app_download_dialog);
        this.bko = (LinearLayout) findViewById(d.g.app_info);
        this.bkp = (TextView) findViewById(d.g.app_version_and_size);
        this.bkq = (TextView) findViewById(d.g.app_description);
        this.bkv = (TextView) findViewById(d.g.fullsize_download_button);
        this.bku = (TextView) findViewById(d.g.cancel_download_button);
        this.bkw = findViewById(d.g.divider_line);
        this.bkr = (TextView) findViewById(d.g.download_process);
        this.bkx = (TextView) findViewById(d.g.incremental_download_button);
        this.bky = (TextView) findViewById(d.g.not_install_as_tip);
        this.bkz = findViewById(d.g.incremental_download_layout);
        this.bkt = (TextView) findViewById(d.g.other_app_recommend);
        this.bkE = findViewById(d.g.divider_under_button);
        this.bkF = (LinearLayout) findViewById(d.g.cancel_confirm_ll);
        this.bks = this.bkr.getText().toString();
        this.bkA = (LinearLayout) findViewById(d.g.cancel_dialog);
        this.bkC = (TextView) findViewById(d.g.sure_cancel);
        this.bkD = (TextView) findViewById(d.g.cancel_button);
        this.bkB = (TextView) findViewById(d.g.cancel_tip);
        this.bkC.setOnClickListener(this.bkH);
        this.bkD.setOnClickListener(this.bkI);
        if (com.baidu.adp.lib.b.d.hv().ax("android_shouzhu_update") == 1) {
            this.bkJ = true;
        } else {
            this.bkJ = false;
        }
        String size = this.bki.getSize();
        String newVersion = this.bki.getNewVersion();
        String newVersionDesc = this.bki.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.c(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.bkp.setText(sb.toString());
        this.bkq.setText(newVersionDesc);
        if (this.bki.forceUpdate()) {
            this.bkn = true;
            this.bku.setText(this.mContext.getString(d.j.quit));
        } else {
            this.bku.setText(this.mContext.getString(d.j.update_after));
        }
        if (this.bkj != null && this.bkj.showCombineDownload() && !TextUtils.isEmpty(this.bkj.getApkMD5RSA())) {
            this.bkt.setText(this.bkj.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.bkj.getAppProc()) && !TextUtils.isEmpty(this.bkj.getAppUrl())) {
                this.bkt.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.bkt.setCompoundDrawables(drawable, null, null, null);
                this.bkk = true;
            } else {
                this.bkt.setVisibility(8);
                this.bkk = false;
            }
        } else {
            this.bkt.setVisibility(8);
            this.bkk = false;
        }
        cs(this.bkJ);
        this.bkv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.bkm = true;
                if (e.this.bkl) {
                    Drawable drawable2 = am.getDrawable(d.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.bkt.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.bkG.cu(e.this.bkl);
            }
        });
        this.bkx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bkK) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.bkx.setEnabled(false);
                e.this.bkG.cv(e.this.bkl);
            }
        });
        this.bku.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bkG.PO();
            }
        });
        this.bkt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.bkm) {
                    if (e.this.bkl) {
                        Drawable drawable2 = am.getDrawable(d.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.bkt.setCompoundDrawables(drawable2, null, null, null);
                        e.this.bkk = false;
                        e.this.bkl = false;
                        return;
                    }
                    Drawable drawable3 = am.getDrawable(d.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.bkt.setCompoundDrawables(drawable3, null, null, null);
                    e.this.bkk = true;
                    e.this.bkl = true;
                }
            }
        });
        PM();
    }

    private void PM() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void cs(boolean z) {
        if (g.b(this.mContext.getPackageManager())) {
            this.bky.setVisibility(8);
        } else {
            this.bky.setVisibility(0);
        }
        if (z) {
            if (this.bki == null || TextUtils.isEmpty(this.bki.getPatch()) || this.bki.getNewVersionCode() < 0) {
                this.bkz.setVisibility(0);
                this.bkx.setText(d.j.super_update);
                am.i(this.bkx, d.f.dialog_middle_item_bg_selector);
                this.bkF.setVisibility(0);
                this.bkK = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.bkz.setVisibility(0);
            this.bkx.setText(d.j.incremental_update);
            am.i(this.bkx, d.f.dialog_single_button_bg_selector);
            this.bkE.setVisibility(8);
            this.bkF.setVisibility(8);
            this.bkK = true;
            TiebaStatic.log("c10002");
        } else if (this.bki == null || TextUtils.isEmpty(this.bki.getPatch()) || this.bki.getNewVersionCode() < 0) {
            this.bkz.setVisibility(8);
            this.bkF.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.bkz.setVisibility(0);
            am.i(this.bkx, d.f.dialog_middle_item_bg_selector);
            this.bkx.setText(d.j.incremental_update);
            this.bkF.setVisibility(0);
            this.bkK = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void go(int i) {
        this.bkv.setVisibility(8);
        this.bkz.setVisibility(8);
        this.bku.setVisibility(8);
        this.bkw.setVisibility(8);
        this.bkm = true;
        this.bkF.setVisibility(0);
        this.bkr.setVisibility(0);
        this.bkr.setText(this.bks + i + "%");
    }

    public void ct(boolean z) {
        this.bkv.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.bkm) {
            this.bkG.stopService();
            this.bko.setVisibility(8);
            if (this.bkn) {
                this.bkB.setText(getContext().getString(d.j.download_exit));
            }
            this.bkA.setVisibility(0);
            return;
        }
        this.bkG.PP();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.bki = versionData;
        this.bkj = combineDownload;
        this.bkG = aVar;
    }

    public void PN() {
        this.bkA.setVisibility(8);
        this.bko.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.bkH = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.bkI = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(d.g.app_download_dialog_layout));
        }
    }
}
