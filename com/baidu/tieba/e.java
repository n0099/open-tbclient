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
    private VersionData aWE;
    private CombineDownload aWF;
    private boolean aWG;
    private boolean aWH;
    private boolean aWI;
    private boolean aWJ;
    private LinearLayout aWK;
    private TextView aWL;
    private TextView aWM;
    private TextView aWN;
    private String aWO;
    private TextView aWP;
    private TextView aWQ;
    private TextView aWR;
    private View aWS;
    private TextView aWT;
    private TextView aWU;
    private View aWV;
    private LinearLayout aWW;
    private TextView aWX;
    private TextView aWY;
    private TextView aWZ;
    private View aXa;
    private LinearLayout aXb;
    private a aXc;
    private View.OnClickListener aXd;
    private View.OnClickListener aXe;
    private boolean aXf;
    private boolean aXg;
    private Context mContext;

    /* loaded from: classes.dex */
    interface a {
        void KK();

        void KL();

        void ci(boolean z);

        void cj(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.aWG = false;
        this.aWH = true;
        this.aWI = false;
        this.aWJ = false;
        this.aXf = true;
        this.aXg = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.app_download_dialog);
        this.aWK = (LinearLayout) findViewById(d.g.app_info);
        this.aWL = (TextView) findViewById(d.g.app_version_and_size);
        this.aWM = (TextView) findViewById(d.g.app_description);
        this.aWR = (TextView) findViewById(d.g.fullsize_download_button);
        this.aWQ = (TextView) findViewById(d.g.cancel_download_button);
        this.aWS = findViewById(d.g.divider_line);
        this.aWN = (TextView) findViewById(d.g.download_process);
        this.aWT = (TextView) findViewById(d.g.incremental_download_button);
        this.aWU = (TextView) findViewById(d.g.not_install_as_tip);
        this.aWV = findViewById(d.g.incremental_download_layout);
        this.aWP = (TextView) findViewById(d.g.other_app_recommend);
        this.aXa = findViewById(d.g.divider_under_button);
        this.aXb = (LinearLayout) findViewById(d.g.cancel_confirm_ll);
        this.aWO = this.aWN.getText().toString();
        this.aWW = (LinearLayout) findViewById(d.g.cancel_dialog);
        this.aWY = (TextView) findViewById(d.g.sure_cancel);
        this.aWZ = (TextView) findViewById(d.g.cancel_button);
        this.aWX = (TextView) findViewById(d.g.cancel_tip);
        this.aWY.setOnClickListener(this.aXd);
        this.aWZ.setOnClickListener(this.aXe);
        if (com.baidu.adp.lib.b.d.eV().af("android_shouzhu_update") == 1) {
            this.aXf = true;
        } else {
            this.aXf = false;
        }
        String size = this.aWE.getSize();
        String newVersion = this.aWE.getNewVersion();
        String newVersionDesc = this.aWE.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aWL.setText(sb.toString());
        this.aWM.setText(newVersionDesc);
        if (this.aWE.forceUpdate()) {
            this.aWJ = true;
            this.aWQ.setText(this.mContext.getString(d.j.quit));
        } else {
            this.aWQ.setText(this.mContext.getString(d.j.update_after));
        }
        if (this.aWF != null && this.aWF.showCombineDownload() && !TextUtils.isEmpty(this.aWF.getApkMD5RSA())) {
            this.aWP.setText(this.aWF.getAppName());
            if (!t.isInstalledPackage(this.mContext, this.aWF.getAppProc()) && !TextUtils.isEmpty(this.aWF.getAppUrl())) {
                this.aWP.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aWP.setCompoundDrawables(drawable, null, null, null);
                this.aWG = true;
            } else {
                this.aWP.setVisibility(8);
                this.aWG = false;
            }
        } else {
            this.aWP.setVisibility(8);
            this.aWG = false;
        }
        ch(this.aXf);
        this.aWR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.aWR.setEnabled(false);
                e.this.aWI = true;
                if (e.this.aWH) {
                    Drawable drawable2 = aj.getDrawable(d.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.aWP.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.aXc.ci(e.this.aWH);
            }
        });
        this.aWT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aXg) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.aWT.setEnabled(false);
                e.this.aXc.cj(e.this.aWH);
            }
        });
        this.aWQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aXc.KK();
            }
        });
        this.aWP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.aWI) {
                    if (e.this.aWH) {
                        Drawable drawable2 = aj.getDrawable(d.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.aWP.setCompoundDrawables(drawable2, null, null, null);
                        e.this.aWG = false;
                        e.this.aWH = false;
                        return;
                    }
                    Drawable drawable3 = aj.getDrawable(d.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.aWP.setCompoundDrawables(drawable3, null, null, null);
                    e.this.aWG = true;
                    e.this.aWH = true;
                }
            }
        });
        KI();
    }

    private void KI() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void ch(boolean z) {
        if (g.b(this.mContext.getPackageManager())) {
            this.aWU.setVisibility(8);
        } else {
            this.aWU.setVisibility(0);
        }
        if (z) {
            if (this.aWE == null || TextUtils.isEmpty(this.aWE.getPatch()) || this.aWE.getNewVersionCode() < 0) {
                this.aWV.setVisibility(0);
                this.aWT.setText(d.j.super_update);
                aj.j(this.aWT, d.f.dialog_middle_item_bg_selector);
                this.aXb.setVisibility(0);
                this.aXg = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aWV.setVisibility(0);
            this.aWT.setText(d.j.incremental_update);
            aj.j(this.aWT, d.f.dialog_single_button_bg_selector);
            this.aXa.setVisibility(8);
            this.aXb.setVisibility(8);
            this.aXg = true;
            TiebaStatic.log("c10002");
        } else if (this.aWE == null || TextUtils.isEmpty(this.aWE.getPatch()) || this.aWE.getNewVersionCode() < 0) {
            this.aWV.setVisibility(8);
            this.aXb.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aWV.setVisibility(0);
            aj.j(this.aWT, d.f.dialog_middle_item_bg_selector);
            this.aWT.setText(d.j.incremental_update);
            this.aXb.setVisibility(0);
            this.aXg = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void gk(int i) {
        this.aWR.setVisibility(8);
        this.aWV.setVisibility(8);
        this.aWQ.setVisibility(8);
        this.aWS.setVisibility(8);
        this.aWI = true;
        this.aXb.setVisibility(0);
        this.aWN.setVisibility(0);
        this.aWN.setText(this.aWO + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aWI) {
            this.aXc.stopService();
            this.aWK.setVisibility(8);
            if (this.aWJ) {
                this.aWX.setText(getContext().getString(d.j.download_exit));
            }
            this.aWW.setVisibility(0);
            return;
        }
        this.aXc.KL();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aWE = versionData;
        this.aWF = combineDownload;
        this.aXc = aVar;
    }

    public void KJ() {
        this.aWW.setVisibility(8);
        this.aWK.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.aXd = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.aXe = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ag(i == 1);
            tbPageContext.getLayoutMode().t(findViewById(d.g.app_download_dialog_layout));
        }
    }
}
