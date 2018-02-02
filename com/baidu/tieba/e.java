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
    private VersionData bNW;
    private CombineDownload bNX;
    private boolean bNY;
    private boolean bNZ;
    private boolean bOa;
    private boolean bOb;
    private LinearLayout bOc;
    private TextView bOd;
    private TextView bOe;
    private TextView bOf;
    private String bOg;
    private TextView bOh;
    private TextView bOi;
    private TextView bOj;
    private View bOk;
    private TextView bOl;
    private TextView bOm;
    private View bOn;
    private LinearLayout bOo;
    private TextView bOp;
    private TextView bOq;
    private TextView bOr;
    private View bOs;
    private LinearLayout bOt;
    private a bOu;
    private View.OnClickListener bOv;
    private View.OnClickListener bOw;
    private boolean bOx;
    private boolean bOy;
    private Context mContext;

    /* loaded from: classes.dex */
    interface a {
        void SI();

        void SJ();

        void cQ(boolean z);

        void cR(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.bNY = false;
        this.bNZ = true;
        this.bOa = false;
        this.bOb = false;
        this.bOx = true;
        this.bOy = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.app_download_dialog);
        this.bOc = (LinearLayout) findViewById(d.g.app_info);
        this.bOd = (TextView) findViewById(d.g.app_version_and_size);
        this.bOe = (TextView) findViewById(d.g.app_description);
        this.bOj = (TextView) findViewById(d.g.fullsize_download_button);
        this.bOi = (TextView) findViewById(d.g.cancel_download_button);
        this.bOk = findViewById(d.g.divider_line);
        this.bOf = (TextView) findViewById(d.g.download_process);
        this.bOl = (TextView) findViewById(d.g.incremental_download_button);
        this.bOm = (TextView) findViewById(d.g.not_install_as_tip);
        this.bOn = findViewById(d.g.incremental_download_layout);
        this.bOh = (TextView) findViewById(d.g.other_app_recommend);
        this.bOs = findViewById(d.g.divider_under_button);
        this.bOt = (LinearLayout) findViewById(d.g.cancel_confirm_ll);
        this.bOg = this.bOf.getText().toString();
        this.bOo = (LinearLayout) findViewById(d.g.cancel_dialog);
        this.bOq = (TextView) findViewById(d.g.sure_cancel);
        this.bOr = (TextView) findViewById(d.g.cancel_button);
        this.bOp = (TextView) findViewById(d.g.cancel_tip);
        this.bOq.setOnClickListener(this.bOv);
        this.bOr.setOnClickListener(this.bOw);
        if (com.baidu.adp.lib.b.d.mA().an("android_shouzhu_update") == 1) {
            this.bOx = true;
        } else {
            this.bOx = false;
        }
        String size = this.bNW.getSize();
        String newVersion = this.bNW.getNewVersion();
        String newVersionDesc = this.bNW.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.bOd.setText(sb.toString());
        this.bOe.setText(newVersionDesc);
        if (this.bNW.forceUpdate()) {
            this.bOb = true;
            this.bOi.setText(this.mContext.getString(d.j.quit));
        } else {
            this.bOi.setText(this.mContext.getString(d.j.update_after));
        }
        if (this.bNX != null && this.bNX.showCombineDownload() && !TextUtils.isEmpty(this.bNX.getApkMD5RSA())) {
            this.bOh.setText(this.bNX.getAppName());
            if (!v.isInstalledPackage(this.mContext, this.bNX.getAppProc()) && !TextUtils.isEmpty(this.bNX.getAppUrl())) {
                this.bOh.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.bOh.setCompoundDrawables(drawable, null, null, null);
                this.bNY = true;
            } else {
                this.bOh.setVisibility(8);
                this.bNY = false;
            }
        } else {
            this.bOh.setVisibility(8);
            this.bNY = false;
        }
        cO(this.bOx);
        this.bOj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.bOa = true;
                if (e.this.bNZ) {
                    Drawable drawable2 = aj.getDrawable(d.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.bOh.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.bOu.cQ(e.this.bNZ);
            }
        });
        this.bOl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bOy) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.bOl.setEnabled(false);
                e.this.bOu.cR(e.this.bNZ);
            }
        });
        this.bOi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bOu.SI();
            }
        });
        this.bOh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.bOa) {
                    if (e.this.bNZ) {
                        Drawable drawable2 = aj.getDrawable(d.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.bOh.setCompoundDrawables(drawable2, null, null, null);
                        e.this.bNY = false;
                        e.this.bNZ = false;
                        return;
                    }
                    Drawable drawable3 = aj.getDrawable(d.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.bOh.setCompoundDrawables(drawable3, null, null, null);
                    e.this.bNY = true;
                    e.this.bNZ = true;
                }
            }
        });
        SG();
    }

    private void SG() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void cO(boolean z) {
        if (g.b(this.mContext.getPackageManager())) {
            this.bOm.setVisibility(8);
        } else {
            this.bOm.setVisibility(0);
        }
        if (z) {
            if (this.bNW == null || TextUtils.isEmpty(this.bNW.getPatch()) || this.bNW.getNewVersionCode() < 0) {
                this.bOn.setVisibility(0);
                this.bOl.setText(d.j.super_update);
                aj.s(this.bOl, d.f.dialog_middle_item_bg_selector);
                this.bOt.setVisibility(0);
                this.bOy = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.bOn.setVisibility(0);
            this.bOl.setText(d.j.incremental_update);
            aj.s(this.bOl, d.f.dialog_single_button_bg_selector);
            this.bOs.setVisibility(8);
            this.bOt.setVisibility(8);
            this.bOy = true;
            TiebaStatic.log("c10002");
        } else if (this.bNW == null || TextUtils.isEmpty(this.bNW.getPatch()) || this.bNW.getNewVersionCode() < 0) {
            this.bOn.setVisibility(8);
            this.bOt.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.bOn.setVisibility(0);
            aj.s(this.bOl, d.f.dialog_middle_item_bg_selector);
            this.bOl.setText(d.j.incremental_update);
            this.bOt.setVisibility(0);
            this.bOy = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void jm(int i) {
        this.bOj.setVisibility(8);
        this.bOn.setVisibility(8);
        this.bOi.setVisibility(8);
        this.bOk.setVisibility(8);
        this.bOa = true;
        this.bOt.setVisibility(0);
        this.bOf.setVisibility(0);
        this.bOf.setText(this.bOg + i + "%");
    }

    public void cP(boolean z) {
        this.bOj.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.bOa) {
            this.bOu.stopService();
            this.bOc.setVisibility(8);
            if (this.bOb) {
                this.bOp.setText(getContext().getString(d.j.download_exit));
            }
            this.bOo.setVisibility(0);
            return;
        }
        this.bOu.SJ();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.bNW = versionData;
        this.bNX = combineDownload;
        this.bOu = aVar;
    }

    public void SH() {
        this.bOo.setVisibility(8);
        this.bOc.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.bOv = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.bOw = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().aN(i == 1);
            tbPageContext.getLayoutMode().aM(findViewById(d.g.app_download_dialog_layout));
        }
    }
}
