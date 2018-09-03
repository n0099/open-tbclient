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
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes.dex */
public class g extends Dialog {
    private TextView bkA;
    private TextView bkB;
    private TextView bkC;
    private TextView bkD;
    private View bkE;
    private LinearLayout bkF;
    private TextView bkG;
    private TextView bkH;
    private TextView bkI;
    private View bkJ;
    private LinearLayout bkK;
    private a bkL;
    private View.OnClickListener bkM;
    private View.OnClickListener bkN;
    private boolean bkO;
    private boolean bkP;
    private VersionData bko;
    private CombineDownload bkp;
    private boolean bkq;
    private boolean bkr;
    private boolean bks;
    private boolean bkt;
    private LinearLayout bku;
    private TextView bkv;
    private TextView bkw;
    private TextView bkx;
    private String bky;
    private TextView bkz;
    private View dividerLine;
    private Context mContext;

    /* loaded from: classes.dex */
    interface a {
        void PU();

        void PV();

        void cv(boolean z);

        void cw(boolean z);

        void stopService();
    }

    public g(Context context, int i) {
        super(context, i);
        this.bkq = false;
        this.bkr = true;
        this.bks = false;
        this.bkt = false;
        this.bkO = true;
        this.bkP = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.h.app_download_dialog);
        this.bku = (LinearLayout) findViewById(f.g.app_info);
        this.bkv = (TextView) findViewById(f.g.app_version_and_size);
        this.bkw = (TextView) findViewById(f.g.app_description);
        this.bkB = (TextView) findViewById(f.g.fullsize_download_button);
        this.bkA = (TextView) findViewById(f.g.cancel_download_button);
        this.dividerLine = findViewById(f.g.divider_line);
        this.bkx = (TextView) findViewById(f.g.download_process);
        this.bkC = (TextView) findViewById(f.g.incremental_download_button);
        this.bkD = (TextView) findViewById(f.g.not_install_as_tip);
        this.bkE = findViewById(f.g.incremental_download_layout);
        this.bkz = (TextView) findViewById(f.g.other_app_recommend);
        this.bkJ = findViewById(f.g.divider_under_button);
        this.bkK = (LinearLayout) findViewById(f.g.cancel_confirm_ll);
        this.bky = this.bkx.getText().toString();
        this.bkF = (LinearLayout) findViewById(f.g.cancel_dialog);
        this.bkH = (TextView) findViewById(f.g.sure_cancel);
        this.bkI = (TextView) findViewById(f.g.cancel_button);
        this.bkG = (TextView) findViewById(f.g.cancel_tip);
        this.bkH.setOnClickListener(this.bkM);
        this.bkI.setOnClickListener(this.bkN);
        if (com.baidu.adp.lib.b.d.hv().ax("android_shouzhu_update") == 1) {
            this.bkO = true;
        } else {
            this.bkO = false;
        }
        String size = this.bko.getSize();
        String newVersion = this.bko.getNewVersion();
        String newVersionDesc = this.bko.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(f.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.c(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.bkv.setText(sb.toString());
        this.bkw.setText(newVersionDesc);
        if (this.bko.forceUpdate()) {
            this.bkt = true;
            this.bkA.setText(this.mContext.getString(f.j.quit));
        } else {
            this.bkA.setText(this.mContext.getString(f.j.update_after));
        }
        if (this.bkp != null && this.bkp.showCombineDownload() && !TextUtils.isEmpty(this.bkp.getApkMD5RSA())) {
            this.bkz.setText(this.bkp.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.bkp.getAppProc()) && !TextUtils.isEmpty(this.bkp.getAppUrl())) {
                this.bkz.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(f.C0146f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.bkz.setCompoundDrawables(drawable, null, null, null);
                this.bkq = true;
            } else {
                this.bkz.setVisibility(8);
                this.bkq = false;
            }
        } else {
            this.bkz.setVisibility(8);
            this.bkq = false;
        }
        ct(this.bkO);
        this.bkB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                g.this.bks = true;
                if (g.this.bkr) {
                    Drawable drawable2 = am.getDrawable(f.C0146f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    g.this.bkz.setCompoundDrawables(drawable2, null, null, null);
                }
                g.this.bkL.cv(g.this.bkr);
            }
        });
        this.bkC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.bkP) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                g.this.bkC.setEnabled(false);
                g.this.bkL.cw(g.this.bkr);
            }
        });
        this.bkA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.bkL.PU();
            }
        });
        this.bkz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.bks) {
                    if (g.this.bkr) {
                        Drawable drawable2 = am.getDrawable(f.C0146f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        g.this.bkz.setCompoundDrawables(drawable2, null, null, null);
                        g.this.bkq = false;
                        g.this.bkr = false;
                        return;
                    }
                    Drawable drawable3 = am.getDrawable(f.C0146f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    g.this.bkz.setCompoundDrawables(drawable3, null, null, null);
                    g.this.bkq = true;
                    g.this.bkr = true;
                }
            }
        });
        PS();
    }

    private void PS() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void ct(boolean z) {
        if (i.a(this.mContext.getPackageManager())) {
            this.bkD.setVisibility(8);
        } else {
            this.bkD.setVisibility(0);
        }
        if (z) {
            if (this.bko == null || TextUtils.isEmpty(this.bko.getPatch()) || this.bko.getNewVersionCode() < 0) {
                this.bkE.setVisibility(0);
                this.bkC.setText(f.j.super_update);
                am.i(this.bkC, f.C0146f.dialog_middle_item_bg_selector);
                this.bkK.setVisibility(0);
                this.bkP = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.bkE.setVisibility(0);
            this.bkC.setText(f.j.incremental_update);
            am.i(this.bkC, f.C0146f.dialog_single_button_bg_selector);
            this.bkJ.setVisibility(8);
            this.bkK.setVisibility(8);
            this.bkP = true;
            TiebaStatic.log("c10002");
        } else if (this.bko == null || TextUtils.isEmpty(this.bko.getPatch()) || this.bko.getNewVersionCode() < 0) {
            this.bkE.setVisibility(8);
            this.bkK.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.bkE.setVisibility(0);
            am.i(this.bkC, f.C0146f.dialog_middle_item_bg_selector);
            this.bkC.setText(f.j.incremental_update);
            this.bkK.setVisibility(0);
            this.bkP = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void gn(int i) {
        this.bkB.setVisibility(8);
        this.bkE.setVisibility(8);
        this.bkA.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.bks = true;
        this.bkK.setVisibility(0);
        this.bkx.setVisibility(0);
        this.bkx.setText(this.bky + i + "%");
    }

    public void cu(boolean z) {
        this.bkB.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.bks) {
            this.bkL.stopService();
            this.bku.setVisibility(8);
            if (this.bkt) {
                this.bkG.setText(getContext().getString(f.j.download_exit));
            }
            this.bkF.setVisibility(0);
            return;
        }
        this.bkL.PV();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.bko = versionData;
        this.bkp = combineDownload;
        this.bkL = aVar;
    }

    public void PT() {
        this.bkF.setVisibility(8);
        this.bku.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.bkM = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.bkN = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(f.g.app_download_dialog_layout));
        }
    }
}
