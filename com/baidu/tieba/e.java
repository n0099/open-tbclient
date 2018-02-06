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
    private View bQA;
    private LinearLayout bQB;
    private a bQC;
    private View.OnClickListener bQD;
    private View.OnClickListener bQE;
    private boolean bQF;
    private boolean bQG;
    private VersionData bQe;
    private CombineDownload bQf;
    private boolean bQg;
    private boolean bQh;
    private boolean bQi;
    private boolean bQj;
    private LinearLayout bQk;
    private TextView bQl;
    private TextView bQm;
    private TextView bQn;
    private String bQo;
    private TextView bQp;
    private TextView bQq;
    private TextView bQr;
    private View bQs;
    private TextView bQt;
    private TextView bQu;
    private View bQv;
    private LinearLayout bQw;
    private TextView bQx;
    private TextView bQy;
    private TextView bQz;
    private Context mContext;

    /* loaded from: classes.dex */
    interface a {
        void Tr();

        void Ts();

        void cU(boolean z);

        void cV(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.bQg = false;
        this.bQh = true;
        this.bQi = false;
        this.bQj = false;
        this.bQF = true;
        this.bQG = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.app_download_dialog);
        this.bQk = (LinearLayout) findViewById(d.g.app_info);
        this.bQl = (TextView) findViewById(d.g.app_version_and_size);
        this.bQm = (TextView) findViewById(d.g.app_description);
        this.bQr = (TextView) findViewById(d.g.fullsize_download_button);
        this.bQq = (TextView) findViewById(d.g.cancel_download_button);
        this.bQs = findViewById(d.g.divider_line);
        this.bQn = (TextView) findViewById(d.g.download_process);
        this.bQt = (TextView) findViewById(d.g.incremental_download_button);
        this.bQu = (TextView) findViewById(d.g.not_install_as_tip);
        this.bQv = findViewById(d.g.incremental_download_layout);
        this.bQp = (TextView) findViewById(d.g.other_app_recommend);
        this.bQA = findViewById(d.g.divider_under_button);
        this.bQB = (LinearLayout) findViewById(d.g.cancel_confirm_ll);
        this.bQo = this.bQn.getText().toString();
        this.bQw = (LinearLayout) findViewById(d.g.cancel_dialog);
        this.bQy = (TextView) findViewById(d.g.sure_cancel);
        this.bQz = (TextView) findViewById(d.g.cancel_button);
        this.bQx = (TextView) findViewById(d.g.cancel_tip);
        this.bQy.setOnClickListener(this.bQD);
        this.bQz.setOnClickListener(this.bQE);
        if (com.baidu.adp.lib.b.d.mA().an("android_shouzhu_update") == 1) {
            this.bQF = true;
        } else {
            this.bQF = false;
        }
        String size = this.bQe.getSize();
        String newVersion = this.bQe.getNewVersion();
        String newVersionDesc = this.bQe.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.bQl.setText(sb.toString());
        this.bQm.setText(newVersionDesc);
        if (this.bQe.forceUpdate()) {
            this.bQj = true;
            this.bQq.setText(this.mContext.getString(d.j.quit));
        } else {
            this.bQq.setText(this.mContext.getString(d.j.update_after));
        }
        if (this.bQf != null && this.bQf.showCombineDownload() && !TextUtils.isEmpty(this.bQf.getApkMD5RSA())) {
            this.bQp.setText(this.bQf.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.bQf.getAppProc()) && !TextUtils.isEmpty(this.bQf.getAppUrl())) {
                this.bQp.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.bQp.setCompoundDrawables(drawable, null, null, null);
                this.bQg = true;
            } else {
                this.bQp.setVisibility(8);
                this.bQg = false;
            }
        } else {
            this.bQp.setVisibility(8);
            this.bQg = false;
        }
        cS(this.bQF);
        this.bQr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.bQi = true;
                if (e.this.bQh) {
                    Drawable drawable2 = aj.getDrawable(d.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.bQp.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.bQC.cU(e.this.bQh);
            }
        });
        this.bQt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bQG) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.bQt.setEnabled(false);
                e.this.bQC.cV(e.this.bQh);
            }
        });
        this.bQq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bQC.Tr();
            }
        });
        this.bQp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.bQi) {
                    if (e.this.bQh) {
                        Drawable drawable2 = aj.getDrawable(d.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.bQp.setCompoundDrawables(drawable2, null, null, null);
                        e.this.bQg = false;
                        e.this.bQh = false;
                        return;
                    }
                    Drawable drawable3 = aj.getDrawable(d.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.bQp.setCompoundDrawables(drawable3, null, null, null);
                    e.this.bQg = true;
                    e.this.bQh = true;
                }
            }
        });
        Tp();
    }

    private void Tp() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void cS(boolean z) {
        if (g.b(this.mContext.getPackageManager())) {
            this.bQu.setVisibility(8);
        } else {
            this.bQu.setVisibility(0);
        }
        if (z) {
            if (this.bQe == null || TextUtils.isEmpty(this.bQe.getPatch()) || this.bQe.getNewVersionCode() < 0) {
                this.bQv.setVisibility(0);
                this.bQt.setText(d.j.super_update);
                aj.s(this.bQt, d.f.dialog_middle_item_bg_selector);
                this.bQB.setVisibility(0);
                this.bQG = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.bQv.setVisibility(0);
            this.bQt.setText(d.j.incremental_update);
            aj.s(this.bQt, d.f.dialog_single_button_bg_selector);
            this.bQA.setVisibility(8);
            this.bQB.setVisibility(8);
            this.bQG = true;
            TiebaStatic.log("c10002");
        } else if (this.bQe == null || TextUtils.isEmpty(this.bQe.getPatch()) || this.bQe.getNewVersionCode() < 0) {
            this.bQv.setVisibility(8);
            this.bQB.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.bQv.setVisibility(0);
            aj.s(this.bQt, d.f.dialog_middle_item_bg_selector);
            this.bQt.setText(d.j.incremental_update);
            this.bQB.setVisibility(0);
            this.bQG = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void ji(int i) {
        this.bQr.setVisibility(8);
        this.bQv.setVisibility(8);
        this.bQq.setVisibility(8);
        this.bQs.setVisibility(8);
        this.bQi = true;
        this.bQB.setVisibility(0);
        this.bQn.setVisibility(0);
        this.bQn.setText(this.bQo + i + "%");
    }

    public void cT(boolean z) {
        this.bQr.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.bQi) {
            this.bQC.stopService();
            this.bQk.setVisibility(8);
            if (this.bQj) {
                this.bQx.setText(getContext().getString(d.j.download_exit));
            }
            this.bQw.setVisibility(0);
            return;
        }
        this.bQC.Ts();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.bQe = versionData;
        this.bQf = combineDownload;
        this.bQC = aVar;
    }

    public void Tq() {
        this.bQw.setVisibility(8);
        this.bQk.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.bQD = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.bQE = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().aQ(i == 1);
            tbPageContext.getLayoutMode().aM(findViewById(d.g.app_download_dialog_layout));
        }
    }
}
