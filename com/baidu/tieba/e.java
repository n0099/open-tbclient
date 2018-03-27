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
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes.dex */
public class e extends Dialog {
    private VersionData bPU;
    private CombineDownload bPV;
    private boolean bPW;
    private boolean bPX;
    private boolean bPY;
    private boolean bPZ;
    private LinearLayout bQa;
    private TextView bQb;
    private TextView bQc;
    private TextView bQd;
    private String bQe;
    private TextView bQf;
    private TextView bQg;
    private TextView bQh;
    private View bQi;
    private TextView bQj;
    private TextView bQk;
    private View bQl;
    private LinearLayout bQm;
    private TextView bQn;
    private TextView bQo;
    private TextView bQp;
    private View bQq;
    private LinearLayout bQr;
    private a bQs;
    private View.OnClickListener bQt;
    private View.OnClickListener bQu;
    private boolean bQv;
    private boolean bQw;
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
        this.bPW = false;
        this.bPX = true;
        this.bPY = false;
        this.bPZ = false;
        this.bQv = true;
        this.bQw = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.app_download_dialog);
        this.bQa = (LinearLayout) findViewById(d.g.app_info);
        this.bQb = (TextView) findViewById(d.g.app_version_and_size);
        this.bQc = (TextView) findViewById(d.g.app_description);
        this.bQh = (TextView) findViewById(d.g.fullsize_download_button);
        this.bQg = (TextView) findViewById(d.g.cancel_download_button);
        this.bQi = findViewById(d.g.divider_line);
        this.bQd = (TextView) findViewById(d.g.download_process);
        this.bQj = (TextView) findViewById(d.g.incremental_download_button);
        this.bQk = (TextView) findViewById(d.g.not_install_as_tip);
        this.bQl = findViewById(d.g.incremental_download_layout);
        this.bQf = (TextView) findViewById(d.g.other_app_recommend);
        this.bQq = findViewById(d.g.divider_under_button);
        this.bQr = (LinearLayout) findViewById(d.g.cancel_confirm_ll);
        this.bQe = this.bQd.getText().toString();
        this.bQm = (LinearLayout) findViewById(d.g.cancel_dialog);
        this.bQo = (TextView) findViewById(d.g.sure_cancel);
        this.bQp = (TextView) findViewById(d.g.cancel_button);
        this.bQn = (TextView) findViewById(d.g.cancel_tip);
        this.bQo.setOnClickListener(this.bQt);
        this.bQp.setOnClickListener(this.bQu);
        if (com.baidu.adp.lib.b.d.mA().an("android_shouzhu_update") == 1) {
            this.bQv = true;
        } else {
            this.bQv = false;
        }
        String size = this.bPU.getSize();
        String newVersion = this.bPU.getNewVersion();
        String newVersionDesc = this.bPU.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.bQb.setText(sb.toString());
        this.bQc.setText(newVersionDesc);
        if (this.bPU.forceUpdate()) {
            this.bPZ = true;
            this.bQg.setText(this.mContext.getString(d.j.quit));
        } else {
            this.bQg.setText(this.mContext.getString(d.j.update_after));
        }
        if (this.bPV != null && this.bPV.showCombineDownload() && !TextUtils.isEmpty(this.bPV.getApkMD5RSA())) {
            this.bQf.setText(this.bPV.getAppName());
            if (!v.isInstalledPackage(this.mContext, this.bPV.getAppProc()) && !TextUtils.isEmpty(this.bPV.getAppUrl())) {
                this.bQf.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.bQf.setCompoundDrawables(drawable, null, null, null);
                this.bPW = true;
            } else {
                this.bQf.setVisibility(8);
                this.bPW = false;
            }
        } else {
            this.bQf.setVisibility(8);
            this.bPW = false;
        }
        cS(this.bQv);
        this.bQh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.bPY = true;
                if (e.this.bPX) {
                    Drawable drawable2 = aj.getDrawable(d.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.bQf.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.bQs.cU(e.this.bPX);
            }
        });
        this.bQj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bQw) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.bQj.setEnabled(false);
                e.this.bQs.cV(e.this.bPX);
            }
        });
        this.bQg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bQs.Tr();
            }
        });
        this.bQf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.bPY) {
                    if (e.this.bPX) {
                        Drawable drawable2 = aj.getDrawable(d.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.bQf.setCompoundDrawables(drawable2, null, null, null);
                        e.this.bPW = false;
                        e.this.bPX = false;
                        return;
                    }
                    Drawable drawable3 = aj.getDrawable(d.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.bQf.setCompoundDrawables(drawable3, null, null, null);
                    e.this.bPW = true;
                    e.this.bPX = true;
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
            this.bQk.setVisibility(8);
        } else {
            this.bQk.setVisibility(0);
        }
        if (z) {
            if (this.bPU == null || TextUtils.isEmpty(this.bPU.getPatch()) || this.bPU.getNewVersionCode() < 0) {
                this.bQl.setVisibility(0);
                this.bQj.setText(d.j.super_update);
                aj.s(this.bQj, d.f.dialog_middle_item_bg_selector);
                this.bQr.setVisibility(0);
                this.bQw = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.bQl.setVisibility(0);
            this.bQj.setText(d.j.incremental_update);
            aj.s(this.bQj, d.f.dialog_single_button_bg_selector);
            this.bQq.setVisibility(8);
            this.bQr.setVisibility(8);
            this.bQw = true;
            TiebaStatic.log("c10002");
        } else if (this.bPU == null || TextUtils.isEmpty(this.bPU.getPatch()) || this.bPU.getNewVersionCode() < 0) {
            this.bQl.setVisibility(8);
            this.bQr.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.bQl.setVisibility(0);
            aj.s(this.bQj, d.f.dialog_middle_item_bg_selector);
            this.bQj.setText(d.j.incremental_update);
            this.bQr.setVisibility(0);
            this.bQw = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void ji(int i) {
        this.bQh.setVisibility(8);
        this.bQl.setVisibility(8);
        this.bQg.setVisibility(8);
        this.bQi.setVisibility(8);
        this.bPY = true;
        this.bQr.setVisibility(0);
        this.bQd.setVisibility(0);
        this.bQd.setText(this.bQe + i + "%");
    }

    public void cT(boolean z) {
        this.bQh.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.bPY) {
            this.bQs.stopService();
            this.bQa.setVisibility(8);
            if (this.bPZ) {
                this.bQn.setText(getContext().getString(d.j.download_exit));
            }
            this.bQm.setVisibility(0);
            return;
        }
        this.bQs.Ts();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.bPU = versionData;
        this.bPV = combineDownload;
        this.bQs = aVar;
    }

    public void Tq() {
        this.bQm.setVisibility(8);
        this.bQa.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.bQt = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.bQu = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().aQ(i == 1);
            tbPageContext.getLayoutMode().aM(findViewById(d.g.app_download_dialog_layout));
        }
    }
}
