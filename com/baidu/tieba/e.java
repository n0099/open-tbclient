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
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes.dex */
public class e extends Dialog {
    private VersionData aWB;
    private CombineDownload aWC;
    private boolean aWD;
    private boolean aWE;
    private boolean aWF;
    private boolean aWG;
    private LinearLayout aWH;
    private TextView aWI;
    private TextView aWJ;
    private TextView aWK;
    private String aWL;
    private TextView aWM;
    private TextView aWN;
    private TextView aWO;
    private View aWP;
    private TextView aWQ;
    private TextView aWR;
    private View aWS;
    private LinearLayout aWT;
    private TextView aWU;
    private TextView aWV;
    private TextView aWW;
    private View aWX;
    private LinearLayout aWY;
    private a aWZ;
    private View.OnClickListener aXa;
    private View.OnClickListener aXb;
    private boolean aXc;
    private boolean aXd;
    private Context mContext;

    /* loaded from: classes.dex */
    interface a {
        void KH();

        void KI();

        void cn(boolean z);

        void co(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.aWD = false;
        this.aWE = true;
        this.aWF = false;
        this.aWG = false;
        this.aXc = true;
        this.aXd = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.app_download_dialog);
        this.aWH = (LinearLayout) findViewById(d.h.app_info);
        this.aWI = (TextView) findViewById(d.h.app_version_and_size);
        this.aWJ = (TextView) findViewById(d.h.app_description);
        this.aWO = (TextView) findViewById(d.h.fullsize_download_button);
        this.aWN = (TextView) findViewById(d.h.cancel_download_button);
        this.aWP = findViewById(d.h.divider_line);
        this.aWK = (TextView) findViewById(d.h.download_process);
        this.aWQ = (TextView) findViewById(d.h.incremental_download_button);
        this.aWR = (TextView) findViewById(d.h.not_install_as_tip);
        this.aWS = findViewById(d.h.incremental_download_layout);
        this.aWM = (TextView) findViewById(d.h.other_app_recommend);
        this.aWX = findViewById(d.h.divider_under_button);
        this.aWY = (LinearLayout) findViewById(d.h.cancel_confirm_ll);
        this.aWL = this.aWK.getText().toString();
        this.aWT = (LinearLayout) findViewById(d.h.cancel_dialog);
        this.aWV = (TextView) findViewById(d.h.sure_cancel);
        this.aWW = (TextView) findViewById(d.h.cancel_button);
        this.aWU = (TextView) findViewById(d.h.cancel_tip);
        this.aWV.setOnClickListener(this.aXa);
        this.aWW.setOnClickListener(this.aXb);
        if (com.baidu.adp.lib.b.d.eV().af("android_shouzhu_update") == 1) {
            this.aXc = true;
        } else {
            this.aXc = false;
        }
        String size = this.aWB.getSize();
        String newVersion = this.aWB.getNewVersion();
        String newVersionDesc = this.aWB.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.l.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aWI.setText(sb.toString());
        this.aWJ.setText(newVersionDesc);
        if (this.aWB.forceUpdate()) {
            this.aWG = true;
            this.aWN.setText(this.mContext.getString(d.l.quit));
        } else {
            this.aWN.setText(this.mContext.getString(d.l.update_after));
        }
        if (this.aWC != null && this.aWC.showCombineDownload() && !TextUtils.isEmpty(this.aWC.getApkMD5RSA())) {
            this.aWM.setText(this.aWC.getAppName());
            if (!s.isInstalledPackage(this.mContext, this.aWC.getAppProc()) && !TextUtils.isEmpty(this.aWC.getAppUrl())) {
                this.aWM.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.g.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aWM.setCompoundDrawables(drawable, null, null, null);
                this.aWD = true;
            } else {
                this.aWM.setVisibility(8);
                this.aWD = false;
            }
        } else {
            this.aWM.setVisibility(8);
            this.aWD = false;
        }
        cm(this.aXc);
        this.aWO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.aWO.setEnabled(false);
                e.this.aWF = true;
                if (e.this.aWE) {
                    Drawable drawable2 = aj.getDrawable(d.g.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.aWM.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.aWZ.cn(e.this.aWE);
            }
        });
        this.aWQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aXd) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.aWQ.setEnabled(false);
                e.this.aWZ.co(e.this.aWE);
            }
        });
        this.aWN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aWZ.KH();
            }
        });
        this.aWM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.aWF) {
                    if (e.this.aWE) {
                        Drawable drawable2 = aj.getDrawable(d.g.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.aWM.setCompoundDrawables(drawable2, null, null, null);
                        e.this.aWD = false;
                        e.this.aWE = false;
                        return;
                    }
                    Drawable drawable3 = aj.getDrawable(d.g.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.aWM.setCompoundDrawables(drawable3, null, null, null);
                    e.this.aWD = true;
                    e.this.aWE = true;
                }
            }
        });
        KF();
    }

    private void KF() {
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
            this.aWR.setVisibility(8);
        } else {
            this.aWR.setVisibility(0);
        }
        if (z) {
            if (this.aWB == null || TextUtils.isEmpty(this.aWB.getPatch()) || this.aWB.getNewVersionCode() < 0) {
                this.aWS.setVisibility(0);
                this.aWQ.setText(d.l.super_update);
                aj.j(this.aWQ, d.g.dialog_middle_item_bg_selector);
                this.aWY.setVisibility(0);
                this.aXd = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aWS.setVisibility(0);
            this.aWQ.setText(d.l.incremental_update);
            aj.j(this.aWQ, d.g.dialog_single_button_bg_selector);
            this.aWX.setVisibility(8);
            this.aWY.setVisibility(8);
            this.aXd = true;
            TiebaStatic.log("c10002");
        } else if (this.aWB == null || TextUtils.isEmpty(this.aWB.getPatch()) || this.aWB.getNewVersionCode() < 0) {
            this.aWS.setVisibility(8);
            this.aWY.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aWS.setVisibility(0);
            aj.j(this.aWQ, d.g.dialog_middle_item_bg_selector);
            this.aWQ.setText(d.l.incremental_update);
            this.aWY.setVisibility(0);
            this.aXd = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void gc(int i) {
        this.aWO.setVisibility(8);
        this.aWS.setVisibility(8);
        this.aWN.setVisibility(8);
        this.aWP.setVisibility(8);
        this.aWF = true;
        this.aWY.setVisibility(0);
        this.aWK.setVisibility(0);
        this.aWK.setText(this.aWL + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aWF) {
            this.aWZ.stopService();
            this.aWH.setVisibility(8);
            if (this.aWG) {
                this.aWU.setText(getContext().getString(d.l.download_exit));
            }
            this.aWT.setVisibility(0);
            return;
        }
        this.aWZ.KI();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aWB = versionData;
        this.aWC = combineDownload;
        this.aWZ = aVar;
    }

    public void KG() {
        this.aWT.setVisibility(8);
        this.aWH.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.aXa = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.aXb = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ai(i == 1);
            tbPageContext.getLayoutMode().t(findViewById(d.h.app_download_dialog_layout));
        }
    }
}
