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
    private VersionData bNO;
    private CombineDownload bNP;
    private boolean bNQ;
    private boolean bNR;
    private boolean bNS;
    private boolean bNT;
    private LinearLayout bNU;
    private TextView bNV;
    private TextView bNW;
    private TextView bNX;
    private String bNY;
    private TextView bNZ;
    private TextView bOa;
    private TextView bOb;
    private View bOc;
    private TextView bOd;
    private TextView bOe;
    private View bOf;
    private LinearLayout bOg;
    private TextView bOh;
    private TextView bOi;
    private TextView bOj;
    private View bOk;
    private LinearLayout bOl;
    private a bOm;
    private View.OnClickListener bOn;
    private View.OnClickListener bOo;
    private boolean bOp;
    private boolean bOq;
    private Context mContext;

    /* loaded from: classes.dex */
    interface a {
        void SG();

        void SH();

        void cO(boolean z);

        void cP(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.bNQ = false;
        this.bNR = true;
        this.bNS = false;
        this.bNT = false;
        this.bOp = true;
        this.bOq = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.app_download_dialog);
        this.bNU = (LinearLayout) findViewById(d.g.app_info);
        this.bNV = (TextView) findViewById(d.g.app_version_and_size);
        this.bNW = (TextView) findViewById(d.g.app_description);
        this.bOb = (TextView) findViewById(d.g.fullsize_download_button);
        this.bOa = (TextView) findViewById(d.g.cancel_download_button);
        this.bOc = findViewById(d.g.divider_line);
        this.bNX = (TextView) findViewById(d.g.download_process);
        this.bOd = (TextView) findViewById(d.g.incremental_download_button);
        this.bOe = (TextView) findViewById(d.g.not_install_as_tip);
        this.bOf = findViewById(d.g.incremental_download_layout);
        this.bNZ = (TextView) findViewById(d.g.other_app_recommend);
        this.bOk = findViewById(d.g.divider_under_button);
        this.bOl = (LinearLayout) findViewById(d.g.cancel_confirm_ll);
        this.bNY = this.bNX.getText().toString();
        this.bOg = (LinearLayout) findViewById(d.g.cancel_dialog);
        this.bOi = (TextView) findViewById(d.g.sure_cancel);
        this.bOj = (TextView) findViewById(d.g.cancel_button);
        this.bOh = (TextView) findViewById(d.g.cancel_tip);
        this.bOi.setOnClickListener(this.bOn);
        this.bOj.setOnClickListener(this.bOo);
        if (com.baidu.adp.lib.b.d.mz().an("android_shouzhu_update") == 1) {
            this.bOp = true;
        } else {
            this.bOp = false;
        }
        String size = this.bNO.getSize();
        String newVersion = this.bNO.getNewVersion();
        String newVersionDesc = this.bNO.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.bNV.setText(sb.toString());
        this.bNW.setText(newVersionDesc);
        if (this.bNO.forceUpdate()) {
            this.bNT = true;
            this.bOa.setText(this.mContext.getString(d.j.quit));
        } else {
            this.bOa.setText(this.mContext.getString(d.j.update_after));
        }
        if (this.bNP != null && this.bNP.showCombineDownload() && !TextUtils.isEmpty(this.bNP.getApkMD5RSA())) {
            this.bNZ.setText(this.bNP.getAppName());
            if (!v.isInstalledPackage(this.mContext, this.bNP.getAppProc()) && !TextUtils.isEmpty(this.bNP.getAppUrl())) {
                this.bNZ.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.bNZ.setCompoundDrawables(drawable, null, null, null);
                this.bNQ = true;
            } else {
                this.bNZ.setVisibility(8);
                this.bNQ = false;
            }
        } else {
            this.bNZ.setVisibility(8);
            this.bNQ = false;
        }
        cN(this.bOp);
        this.bOb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.bOb.setEnabled(false);
                e.this.bNS = true;
                if (e.this.bNR) {
                    Drawable drawable2 = aj.getDrawable(d.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.bNZ.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.bOm.cO(e.this.bNR);
            }
        });
        this.bOd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bOq) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.bOd.setEnabled(false);
                e.this.bOm.cP(e.this.bNR);
            }
        });
        this.bOa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bOm.SG();
            }
        });
        this.bNZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.bNS) {
                    if (e.this.bNR) {
                        Drawable drawable2 = aj.getDrawable(d.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.bNZ.setCompoundDrawables(drawable2, null, null, null);
                        e.this.bNQ = false;
                        e.this.bNR = false;
                        return;
                    }
                    Drawable drawable3 = aj.getDrawable(d.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.bNZ.setCompoundDrawables(drawable3, null, null, null);
                    e.this.bNQ = true;
                    e.this.bNR = true;
                }
            }
        });
        SE();
    }

    private void SE() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void cN(boolean z) {
        if (g.b(this.mContext.getPackageManager())) {
            this.bOe.setVisibility(8);
        } else {
            this.bOe.setVisibility(0);
        }
        if (z) {
            if (this.bNO == null || TextUtils.isEmpty(this.bNO.getPatch()) || this.bNO.getNewVersionCode() < 0) {
                this.bOf.setVisibility(0);
                this.bOd.setText(d.j.super_update);
                aj.s(this.bOd, d.f.dialog_middle_item_bg_selector);
                this.bOl.setVisibility(0);
                this.bOq = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.bOf.setVisibility(0);
            this.bOd.setText(d.j.incremental_update);
            aj.s(this.bOd, d.f.dialog_single_button_bg_selector);
            this.bOk.setVisibility(8);
            this.bOl.setVisibility(8);
            this.bOq = true;
            TiebaStatic.log("c10002");
        } else if (this.bNO == null || TextUtils.isEmpty(this.bNO.getPatch()) || this.bNO.getNewVersionCode() < 0) {
            this.bOf.setVisibility(8);
            this.bOl.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.bOf.setVisibility(0);
            aj.s(this.bOd, d.f.dialog_middle_item_bg_selector);
            this.bOd.setText(d.j.incremental_update);
            this.bOl.setVisibility(0);
            this.bOq = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void jm(int i) {
        this.bOb.setVisibility(8);
        this.bOf.setVisibility(8);
        this.bOa.setVisibility(8);
        this.bOc.setVisibility(8);
        this.bNS = true;
        this.bOl.setVisibility(0);
        this.bNX.setVisibility(0);
        this.bNX.setText(this.bNY + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.bNS) {
            this.bOm.stopService();
            this.bNU.setVisibility(8);
            if (this.bNT) {
                this.bOh.setText(getContext().getString(d.j.download_exit));
            }
            this.bOg.setVisibility(0);
            return;
        }
        this.bOm.SH();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.bNO = versionData;
        this.bNP = combineDownload;
        this.bOm = aVar;
    }

    public void SF() {
        this.bOg.setVisibility(8);
        this.bNU.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.bOn = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.bOo = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().aM(i == 1);
            tbPageContext.getLayoutMode().aM(findViewById(d.g.app_download_dialog_layout));
        }
    }
}
