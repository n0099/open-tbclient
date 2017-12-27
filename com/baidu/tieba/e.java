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
    private VersionData bNG;
    private CombineDownload bNH;
    private boolean bNI;
    private boolean bNJ;
    private boolean bNK;
    private boolean bNL;
    private LinearLayout bNM;
    private TextView bNN;
    private TextView bNO;
    private TextView bNP;
    private String bNQ;
    private TextView bNR;
    private TextView bNS;
    private TextView bNT;
    private View bNU;
    private TextView bNV;
    private TextView bNW;
    private View bNX;
    private LinearLayout bNY;
    private TextView bNZ;
    private TextView bOa;
    private TextView bOb;
    private View bOc;
    private LinearLayout bOd;
    private a bOe;
    private View.OnClickListener bOf;
    private View.OnClickListener bOg;
    private boolean bOh;
    private boolean bOi;
    private Context mContext;

    /* loaded from: classes.dex */
    interface a {
        void SS();

        void ST();

        void cQ(boolean z);

        void cR(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.bNI = false;
        this.bNJ = true;
        this.bNK = false;
        this.bNL = false;
        this.bOh = true;
        this.bOi = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.app_download_dialog);
        this.bNM = (LinearLayout) findViewById(d.g.app_info);
        this.bNN = (TextView) findViewById(d.g.app_version_and_size);
        this.bNO = (TextView) findViewById(d.g.app_description);
        this.bNT = (TextView) findViewById(d.g.fullsize_download_button);
        this.bNS = (TextView) findViewById(d.g.cancel_download_button);
        this.bNU = findViewById(d.g.divider_line);
        this.bNP = (TextView) findViewById(d.g.download_process);
        this.bNV = (TextView) findViewById(d.g.incremental_download_button);
        this.bNW = (TextView) findViewById(d.g.not_install_as_tip);
        this.bNX = findViewById(d.g.incremental_download_layout);
        this.bNR = (TextView) findViewById(d.g.other_app_recommend);
        this.bOc = findViewById(d.g.divider_under_button);
        this.bOd = (LinearLayout) findViewById(d.g.cancel_confirm_ll);
        this.bNQ = this.bNP.getText().toString();
        this.bNY = (LinearLayout) findViewById(d.g.cancel_dialog);
        this.bOa = (TextView) findViewById(d.g.sure_cancel);
        this.bOb = (TextView) findViewById(d.g.cancel_button);
        this.bNZ = (TextView) findViewById(d.g.cancel_tip);
        this.bOa.setOnClickListener(this.bOf);
        this.bOb.setOnClickListener(this.bOg);
        if (com.baidu.adp.lib.b.d.mz().an("android_shouzhu_update") == 1) {
            this.bOh = true;
        } else {
            this.bOh = false;
        }
        String size = this.bNG.getSize();
        String newVersion = this.bNG.getNewVersion();
        String newVersionDesc = this.bNG.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.bNN.setText(sb.toString());
        this.bNO.setText(newVersionDesc);
        if (this.bNG.forceUpdate()) {
            this.bNL = true;
            this.bNS.setText(this.mContext.getString(d.j.quit));
        } else {
            this.bNS.setText(this.mContext.getString(d.j.update_after));
        }
        if (this.bNH != null && this.bNH.showCombineDownload() && !TextUtils.isEmpty(this.bNH.getApkMD5RSA())) {
            this.bNR.setText(this.bNH.getAppName());
            if (!v.isInstalledPackage(this.mContext, this.bNH.getAppProc()) && !TextUtils.isEmpty(this.bNH.getAppUrl())) {
                this.bNR.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.bNR.setCompoundDrawables(drawable, null, null, null);
                this.bNI = true;
            } else {
                this.bNR.setVisibility(8);
                this.bNI = false;
            }
        } else {
            this.bNR.setVisibility(8);
            this.bNI = false;
        }
        cP(this.bOh);
        this.bNT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.bNT.setEnabled(false);
                e.this.bNK = true;
                if (e.this.bNJ) {
                    Drawable drawable2 = aj.getDrawable(d.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.bNR.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.bOe.cQ(e.this.bNJ);
            }
        });
        this.bNV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bOi) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.bNV.setEnabled(false);
                e.this.bOe.cR(e.this.bNJ);
            }
        });
        this.bNS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bOe.SS();
            }
        });
        this.bNR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.bNK) {
                    if (e.this.bNJ) {
                        Drawable drawable2 = aj.getDrawable(d.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.bNR.setCompoundDrawables(drawable2, null, null, null);
                        e.this.bNI = false;
                        e.this.bNJ = false;
                        return;
                    }
                    Drawable drawable3 = aj.getDrawable(d.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.bNR.setCompoundDrawables(drawable3, null, null, null);
                    e.this.bNI = true;
                    e.this.bNJ = true;
                }
            }
        });
        SQ();
    }

    private void SQ() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void cP(boolean z) {
        if (g.b(this.mContext.getPackageManager())) {
            this.bNW.setVisibility(8);
        } else {
            this.bNW.setVisibility(0);
        }
        if (z) {
            if (this.bNG == null || TextUtils.isEmpty(this.bNG.getPatch()) || this.bNG.getNewVersionCode() < 0) {
                this.bNX.setVisibility(0);
                this.bNV.setText(d.j.super_update);
                aj.s(this.bNV, d.f.dialog_middle_item_bg_selector);
                this.bOd.setVisibility(0);
                this.bOi = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.bNX.setVisibility(0);
            this.bNV.setText(d.j.incremental_update);
            aj.s(this.bNV, d.f.dialog_single_button_bg_selector);
            this.bOc.setVisibility(8);
            this.bOd.setVisibility(8);
            this.bOi = true;
            TiebaStatic.log("c10002");
        } else if (this.bNG == null || TextUtils.isEmpty(this.bNG.getPatch()) || this.bNG.getNewVersionCode() < 0) {
            this.bNX.setVisibility(8);
            this.bOd.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.bNX.setVisibility(0);
            aj.s(this.bNV, d.f.dialog_middle_item_bg_selector);
            this.bNV.setText(d.j.incremental_update);
            this.bOd.setVisibility(0);
            this.bOi = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void jq(int i) {
        this.bNT.setVisibility(8);
        this.bNX.setVisibility(8);
        this.bNS.setVisibility(8);
        this.bNU.setVisibility(8);
        this.bNK = true;
        this.bOd.setVisibility(0);
        this.bNP.setVisibility(0);
        this.bNP.setText(this.bNQ + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.bNK) {
            this.bOe.stopService();
            this.bNM.setVisibility(8);
            if (this.bNL) {
                this.bNZ.setText(getContext().getString(d.j.download_exit));
            }
            this.bNY.setVisibility(0);
            return;
        }
        this.bOe.ST();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.bNG = versionData;
        this.bNH = combineDownload;
        this.bOe = aVar;
    }

    public void SR() {
        this.bNY.setVisibility(8);
        this.bNM.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.bOf = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.bOg = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().aM(i == 1);
            tbPageContext.getLayoutMode().aM(findViewById(d.g.app_download_dialog_layout));
        }
    }
}
