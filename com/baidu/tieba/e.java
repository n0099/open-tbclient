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
    private VersionData bPR;
    private CombineDownload bPS;
    private boolean bPT;
    private boolean bPU;
    private boolean bPV;
    private boolean bPW;
    private LinearLayout bPX;
    private TextView bPY;
    private TextView bPZ;
    private TextView bQa;
    private String bQb;
    private TextView bQc;
    private TextView bQd;
    private TextView bQe;
    private View bQf;
    private TextView bQg;
    private TextView bQh;
    private View bQi;
    private LinearLayout bQj;
    private TextView bQk;
    private TextView bQl;
    private TextView bQm;
    private View bQn;
    private LinearLayout bQo;
    private a bQp;
    private View.OnClickListener bQq;
    private View.OnClickListener bQr;
    private boolean bQs;
    private boolean bQt;
    private Context mContext;

    /* loaded from: classes.dex */
    interface a {
        void Tq();

        void Tr();

        void cU(boolean z);

        void cV(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.bPT = false;
        this.bPU = true;
        this.bPV = false;
        this.bPW = false;
        this.bQs = true;
        this.bQt = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.app_download_dialog);
        this.bPX = (LinearLayout) findViewById(d.g.app_info);
        this.bPY = (TextView) findViewById(d.g.app_version_and_size);
        this.bPZ = (TextView) findViewById(d.g.app_description);
        this.bQe = (TextView) findViewById(d.g.fullsize_download_button);
        this.bQd = (TextView) findViewById(d.g.cancel_download_button);
        this.bQf = findViewById(d.g.divider_line);
        this.bQa = (TextView) findViewById(d.g.download_process);
        this.bQg = (TextView) findViewById(d.g.incremental_download_button);
        this.bQh = (TextView) findViewById(d.g.not_install_as_tip);
        this.bQi = findViewById(d.g.incremental_download_layout);
        this.bQc = (TextView) findViewById(d.g.other_app_recommend);
        this.bQn = findViewById(d.g.divider_under_button);
        this.bQo = (LinearLayout) findViewById(d.g.cancel_confirm_ll);
        this.bQb = this.bQa.getText().toString();
        this.bQj = (LinearLayout) findViewById(d.g.cancel_dialog);
        this.bQl = (TextView) findViewById(d.g.sure_cancel);
        this.bQm = (TextView) findViewById(d.g.cancel_button);
        this.bQk = (TextView) findViewById(d.g.cancel_tip);
        this.bQl.setOnClickListener(this.bQq);
        this.bQm.setOnClickListener(this.bQr);
        if (com.baidu.adp.lib.b.d.mA().an("android_shouzhu_update") == 1) {
            this.bQs = true;
        } else {
            this.bQs = false;
        }
        String size = this.bPR.getSize();
        String newVersion = this.bPR.getNewVersion();
        String newVersionDesc = this.bPR.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.bPY.setText(sb.toString());
        this.bPZ.setText(newVersionDesc);
        if (this.bPR.forceUpdate()) {
            this.bPW = true;
            this.bQd.setText(this.mContext.getString(d.j.quit));
        } else {
            this.bQd.setText(this.mContext.getString(d.j.update_after));
        }
        if (this.bPS != null && this.bPS.showCombineDownload() && !TextUtils.isEmpty(this.bPS.getApkMD5RSA())) {
            this.bQc.setText(this.bPS.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.bPS.getAppProc()) && !TextUtils.isEmpty(this.bPS.getAppUrl())) {
                this.bQc.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.bQc.setCompoundDrawables(drawable, null, null, null);
                this.bPT = true;
            } else {
                this.bQc.setVisibility(8);
                this.bPT = false;
            }
        } else {
            this.bQc.setVisibility(8);
            this.bPT = false;
        }
        cS(this.bQs);
        this.bQe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.bPV = true;
                if (e.this.bPU) {
                    Drawable drawable2 = aj.getDrawable(d.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.bQc.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.bQp.cU(e.this.bPU);
            }
        });
        this.bQg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bQt) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.bQg.setEnabled(false);
                e.this.bQp.cV(e.this.bPU);
            }
        });
        this.bQd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bQp.Tq();
            }
        });
        this.bQc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.bPV) {
                    if (e.this.bPU) {
                        Drawable drawable2 = aj.getDrawable(d.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.bQc.setCompoundDrawables(drawable2, null, null, null);
                        e.this.bPT = false;
                        e.this.bPU = false;
                        return;
                    }
                    Drawable drawable3 = aj.getDrawable(d.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.bQc.setCompoundDrawables(drawable3, null, null, null);
                    e.this.bPT = true;
                    e.this.bPU = true;
                }
            }
        });
        To();
    }

    private void To() {
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
            this.bQh.setVisibility(8);
        } else {
            this.bQh.setVisibility(0);
        }
        if (z) {
            if (this.bPR == null || TextUtils.isEmpty(this.bPR.getPatch()) || this.bPR.getNewVersionCode() < 0) {
                this.bQi.setVisibility(0);
                this.bQg.setText(d.j.super_update);
                aj.s(this.bQg, d.f.dialog_middle_item_bg_selector);
                this.bQo.setVisibility(0);
                this.bQt = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.bQi.setVisibility(0);
            this.bQg.setText(d.j.incremental_update);
            aj.s(this.bQg, d.f.dialog_single_button_bg_selector);
            this.bQn.setVisibility(8);
            this.bQo.setVisibility(8);
            this.bQt = true;
            TiebaStatic.log("c10002");
        } else if (this.bPR == null || TextUtils.isEmpty(this.bPR.getPatch()) || this.bPR.getNewVersionCode() < 0) {
            this.bQi.setVisibility(8);
            this.bQo.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.bQi.setVisibility(0);
            aj.s(this.bQg, d.f.dialog_middle_item_bg_selector);
            this.bQg.setText(d.j.incremental_update);
            this.bQo.setVisibility(0);
            this.bQt = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void ji(int i) {
        this.bQe.setVisibility(8);
        this.bQi.setVisibility(8);
        this.bQd.setVisibility(8);
        this.bQf.setVisibility(8);
        this.bPV = true;
        this.bQo.setVisibility(0);
        this.bQa.setVisibility(0);
        this.bQa.setText(this.bQb + i + "%");
    }

    public void cT(boolean z) {
        this.bQe.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.bPV) {
            this.bQp.stopService();
            this.bPX.setVisibility(8);
            if (this.bPW) {
                this.bQk.setText(getContext().getString(d.j.download_exit));
            }
            this.bQj.setVisibility(0);
            return;
        }
        this.bQp.Tr();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.bPR = versionData;
        this.bPS = combineDownload;
        this.bQp = aVar;
    }

    public void Tp() {
        this.bQj.setVisibility(8);
        this.bPX.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.bQq = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.bQr = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().aQ(i == 1);
            tbPageContext.getLayoutMode().aM(findViewById(d.g.app_download_dialog_layout));
        }
    }
}
