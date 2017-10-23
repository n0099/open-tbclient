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
    private TextView aWA;
    private TextView aWB;
    private View aWC;
    private TextView aWD;
    private TextView aWE;
    private View aWF;
    private LinearLayout aWG;
    private TextView aWH;
    private TextView aWI;
    private TextView aWJ;
    private View aWK;
    private LinearLayout aWL;
    private a aWM;
    private View.OnClickListener aWN;
    private View.OnClickListener aWO;
    private boolean aWP;
    private boolean aWQ;
    private VersionData aWo;
    private CombineDownload aWp;
    private boolean aWq;
    private boolean aWr;
    private boolean aWs;
    private boolean aWt;
    private LinearLayout aWu;
    private TextView aWv;
    private TextView aWw;
    private TextView aWx;
    private String aWy;
    private TextView aWz;
    private Context mContext;

    /* loaded from: classes.dex */
    interface a {
        void KB();

        void KC();

        void cm(boolean z);

        void cn(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.aWq = false;
        this.aWr = true;
        this.aWs = false;
        this.aWt = false;
        this.aWP = true;
        this.aWQ = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.app_download_dialog);
        this.aWu = (LinearLayout) findViewById(d.h.app_info);
        this.aWv = (TextView) findViewById(d.h.app_version_and_size);
        this.aWw = (TextView) findViewById(d.h.app_description);
        this.aWB = (TextView) findViewById(d.h.fullsize_download_button);
        this.aWA = (TextView) findViewById(d.h.cancel_download_button);
        this.aWC = findViewById(d.h.divider_line);
        this.aWx = (TextView) findViewById(d.h.download_process);
        this.aWD = (TextView) findViewById(d.h.incremental_download_button);
        this.aWE = (TextView) findViewById(d.h.not_install_as_tip);
        this.aWF = findViewById(d.h.incremental_download_layout);
        this.aWz = (TextView) findViewById(d.h.other_app_recommend);
        this.aWK = findViewById(d.h.divider_under_button);
        this.aWL = (LinearLayout) findViewById(d.h.cancel_confirm_ll);
        this.aWy = this.aWx.getText().toString();
        this.aWG = (LinearLayout) findViewById(d.h.cancel_dialog);
        this.aWI = (TextView) findViewById(d.h.sure_cancel);
        this.aWJ = (TextView) findViewById(d.h.cancel_button);
        this.aWH = (TextView) findViewById(d.h.cancel_tip);
        this.aWI.setOnClickListener(this.aWN);
        this.aWJ.setOnClickListener(this.aWO);
        if (com.baidu.adp.lib.b.d.eV().af("android_shouzhu_update") == 1) {
            this.aWP = true;
        } else {
            this.aWP = false;
        }
        String size = this.aWo.getSize();
        String newVersion = this.aWo.getNewVersion();
        String newVersionDesc = this.aWo.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.l.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aWv.setText(sb.toString());
        this.aWw.setText(newVersionDesc);
        if (this.aWo.forceUpdate()) {
            this.aWt = true;
            this.aWA.setText(this.mContext.getString(d.l.quit));
        } else {
            this.aWA.setText(this.mContext.getString(d.l.update_after));
        }
        if (this.aWp != null && this.aWp.showCombineDownload() && !TextUtils.isEmpty(this.aWp.getApkMD5RSA())) {
            this.aWz.setText(this.aWp.getAppName());
            if (!s.isInstalledPackage(this.mContext, this.aWp.getAppProc()) && !TextUtils.isEmpty(this.aWp.getAppUrl())) {
                this.aWz.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.g.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aWz.setCompoundDrawables(drawable, null, null, null);
                this.aWq = true;
            } else {
                this.aWz.setVisibility(8);
                this.aWq = false;
            }
        } else {
            this.aWz.setVisibility(8);
            this.aWq = false;
        }
        cl(this.aWP);
        this.aWB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.aWB.setEnabled(false);
                e.this.aWs = true;
                if (e.this.aWr) {
                    Drawable drawable2 = aj.getDrawable(d.g.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.aWz.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.aWM.cm(e.this.aWr);
            }
        });
        this.aWD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aWQ) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.aWD.setEnabled(false);
                e.this.aWM.cn(e.this.aWr);
            }
        });
        this.aWA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aWM.KB();
            }
        });
        this.aWz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.aWs) {
                    if (e.this.aWr) {
                        Drawable drawable2 = aj.getDrawable(d.g.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.aWz.setCompoundDrawables(drawable2, null, null, null);
                        e.this.aWq = false;
                        e.this.aWr = false;
                        return;
                    }
                    Drawable drawable3 = aj.getDrawable(d.g.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.aWz.setCompoundDrawables(drawable3, null, null, null);
                    e.this.aWq = true;
                    e.this.aWr = true;
                }
            }
        });
        Kz();
    }

    private void Kz() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void cl(boolean z) {
        if (g.b(this.mContext.getPackageManager())) {
            this.aWE.setVisibility(8);
        } else {
            this.aWE.setVisibility(0);
        }
        if (z) {
            if (this.aWo == null || TextUtils.isEmpty(this.aWo.getPatch()) || this.aWo.getNewVersionCode() < 0) {
                this.aWF.setVisibility(0);
                this.aWD.setText(d.l.super_update);
                aj.j(this.aWD, d.g.dialog_middle_item_bg_selector);
                this.aWL.setVisibility(0);
                this.aWQ = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aWF.setVisibility(0);
            this.aWD.setText(d.l.incremental_update);
            aj.j(this.aWD, d.g.dialog_single_button_bg_selector);
            this.aWK.setVisibility(8);
            this.aWL.setVisibility(8);
            this.aWQ = true;
            TiebaStatic.log("c10002");
        } else if (this.aWo == null || TextUtils.isEmpty(this.aWo.getPatch()) || this.aWo.getNewVersionCode() < 0) {
            this.aWF.setVisibility(8);
            this.aWL.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aWF.setVisibility(0);
            aj.j(this.aWD, d.g.dialog_middle_item_bg_selector);
            this.aWD.setText(d.l.incremental_update);
            this.aWL.setVisibility(0);
            this.aWQ = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void gb(int i) {
        this.aWB.setVisibility(8);
        this.aWF.setVisibility(8);
        this.aWA.setVisibility(8);
        this.aWC.setVisibility(8);
        this.aWs = true;
        this.aWL.setVisibility(0);
        this.aWx.setVisibility(0);
        this.aWx.setText(this.aWy + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aWs) {
            this.aWM.stopService();
            this.aWu.setVisibility(8);
            if (this.aWt) {
                this.aWH.setText(getContext().getString(d.l.download_exit));
            }
            this.aWG.setVisibility(0);
            return;
        }
        this.aWM.KC();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aWo = versionData;
        this.aWp = combineDownload;
        this.aWM = aVar;
    }

    public void KA() {
        this.aWG.setVisibility(8);
        this.aWu.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.aWN = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.aWO = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ah(i == 1);
            tbPageContext.getLayoutMode().t(findViewById(d.h.app_download_dialog_layout));
        }
    }
}
