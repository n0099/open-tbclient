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
import com.baidu.tieba.tbadkCore.t;
/* loaded from: classes.dex */
public class e extends Dialog {
    private VersionData aWN;
    private CombineDownload aWO;
    private boolean aWP;
    private boolean aWQ;
    private boolean aWR;
    private boolean aWS;
    private LinearLayout aWT;
    private TextView aWU;
    private TextView aWV;
    private TextView aWW;
    private String aWX;
    private TextView aWY;
    private TextView aWZ;
    private TextView aXa;
    private View aXb;
    private TextView aXc;
    private TextView aXd;
    private View aXe;
    private LinearLayout aXf;
    private TextView aXg;
    private TextView aXh;
    private TextView aXi;
    private View aXj;
    private LinearLayout aXk;
    private a aXl;
    private View.OnClickListener aXm;
    private View.OnClickListener aXn;
    private boolean aXo;
    private boolean aXp;
    private Context mContext;

    /* loaded from: classes.dex */
    interface a {
        void KV();

        void KW();

        void cj(boolean z);

        void ck(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.aWP = false;
        this.aWQ = true;
        this.aWR = false;
        this.aWS = false;
        this.aXo = true;
        this.aXp = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.app_download_dialog);
        this.aWT = (LinearLayout) findViewById(d.g.app_info);
        this.aWU = (TextView) findViewById(d.g.app_version_and_size);
        this.aWV = (TextView) findViewById(d.g.app_description);
        this.aXa = (TextView) findViewById(d.g.fullsize_download_button);
        this.aWZ = (TextView) findViewById(d.g.cancel_download_button);
        this.aXb = findViewById(d.g.divider_line);
        this.aWW = (TextView) findViewById(d.g.download_process);
        this.aXc = (TextView) findViewById(d.g.incremental_download_button);
        this.aXd = (TextView) findViewById(d.g.not_install_as_tip);
        this.aXe = findViewById(d.g.incremental_download_layout);
        this.aWY = (TextView) findViewById(d.g.other_app_recommend);
        this.aXj = findViewById(d.g.divider_under_button);
        this.aXk = (LinearLayout) findViewById(d.g.cancel_confirm_ll);
        this.aWX = this.aWW.getText().toString();
        this.aXf = (LinearLayout) findViewById(d.g.cancel_dialog);
        this.aXh = (TextView) findViewById(d.g.sure_cancel);
        this.aXi = (TextView) findViewById(d.g.cancel_button);
        this.aXg = (TextView) findViewById(d.g.cancel_tip);
        this.aXh.setOnClickListener(this.aXm);
        this.aXi.setOnClickListener(this.aXn);
        if (com.baidu.adp.lib.b.d.eV().af("android_shouzhu_update") == 1) {
            this.aXo = true;
        } else {
            this.aXo = false;
        }
        String size = this.aWN.getSize();
        String newVersion = this.aWN.getNewVersion();
        String newVersionDesc = this.aWN.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aWU.setText(sb.toString());
        this.aWV.setText(newVersionDesc);
        if (this.aWN.forceUpdate()) {
            this.aWS = true;
            this.aWZ.setText(this.mContext.getString(d.j.quit));
        } else {
            this.aWZ.setText(this.mContext.getString(d.j.update_after));
        }
        if (this.aWO != null && this.aWO.showCombineDownload() && !TextUtils.isEmpty(this.aWO.getApkMD5RSA())) {
            this.aWY.setText(this.aWO.getAppName());
            if (!t.isInstalledPackage(this.mContext, this.aWO.getAppProc()) && !TextUtils.isEmpty(this.aWO.getAppUrl())) {
                this.aWY.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aWY.setCompoundDrawables(drawable, null, null, null);
                this.aWP = true;
            } else {
                this.aWY.setVisibility(8);
                this.aWP = false;
            }
        } else {
            this.aWY.setVisibility(8);
            this.aWP = false;
        }
        ci(this.aXo);
        this.aXa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.aXa.setEnabled(false);
                e.this.aWR = true;
                if (e.this.aWQ) {
                    Drawable drawable2 = aj.getDrawable(d.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.aWY.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.aXl.cj(e.this.aWQ);
            }
        });
        this.aXc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aXp) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.aXc.setEnabled(false);
                e.this.aXl.ck(e.this.aWQ);
            }
        });
        this.aWZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aXl.KV();
            }
        });
        this.aWY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.aWR) {
                    if (e.this.aWQ) {
                        Drawable drawable2 = aj.getDrawable(d.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.aWY.setCompoundDrawables(drawable2, null, null, null);
                        e.this.aWP = false;
                        e.this.aWQ = false;
                        return;
                    }
                    Drawable drawable3 = aj.getDrawable(d.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.aWY.setCompoundDrawables(drawable3, null, null, null);
                    e.this.aWP = true;
                    e.this.aWQ = true;
                }
            }
        });
        KT();
    }

    private void KT() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void ci(boolean z) {
        if (g.b(this.mContext.getPackageManager())) {
            this.aXd.setVisibility(8);
        } else {
            this.aXd.setVisibility(0);
        }
        if (z) {
            if (this.aWN == null || TextUtils.isEmpty(this.aWN.getPatch()) || this.aWN.getNewVersionCode() < 0) {
                this.aXe.setVisibility(0);
                this.aXc.setText(d.j.super_update);
                aj.j(this.aXc, d.f.dialog_middle_item_bg_selector);
                this.aXk.setVisibility(0);
                this.aXp = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aXe.setVisibility(0);
            this.aXc.setText(d.j.incremental_update);
            aj.j(this.aXc, d.f.dialog_single_button_bg_selector);
            this.aXj.setVisibility(8);
            this.aXk.setVisibility(8);
            this.aXp = true;
            TiebaStatic.log("c10002");
        } else if (this.aWN == null || TextUtils.isEmpty(this.aWN.getPatch()) || this.aWN.getNewVersionCode() < 0) {
            this.aXe.setVisibility(8);
            this.aXk.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aXe.setVisibility(0);
            aj.j(this.aXc, d.f.dialog_middle_item_bg_selector);
            this.aXc.setText(d.j.incremental_update);
            this.aXk.setVisibility(0);
            this.aXp = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void gj(int i) {
        this.aXa.setVisibility(8);
        this.aXe.setVisibility(8);
        this.aWZ.setVisibility(8);
        this.aXb.setVisibility(8);
        this.aWR = true;
        this.aXk.setVisibility(0);
        this.aWW.setVisibility(0);
        this.aWW.setText(this.aWX + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aWR) {
            this.aXl.stopService();
            this.aWT.setVisibility(8);
            if (this.aWS) {
                this.aXg.setText(getContext().getString(d.j.download_exit));
            }
            this.aXf.setVisibility(0);
            return;
        }
        this.aXl.KW();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aWN = versionData;
        this.aWO = combineDownload;
        this.aXl = aVar;
    }

    public void KU() {
        this.aXf.setVisibility(8);
        this.aWT.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.aXm = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.aXn = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ag(i == 1);
            tbPageContext.getLayoutMode().t(findViewById(d.g.app_download_dialog_layout));
        }
    }
}
