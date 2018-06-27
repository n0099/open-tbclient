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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes.dex */
public class e extends Dialog {
    private VersionData bjD;
    private CombineDownload bjE;
    private boolean bjF;
    private boolean bjG;
    private boolean bjH;
    private boolean bjI;
    private LinearLayout bjJ;
    private TextView bjK;
    private TextView bjL;
    private TextView bjM;
    private String bjN;
    private TextView bjO;
    private TextView bjP;
    private TextView bjQ;
    private View bjR;
    private TextView bjS;
    private TextView bjT;
    private View bjU;
    private LinearLayout bjV;
    private TextView bjW;
    private TextView bjX;
    private TextView bjY;
    private View bjZ;
    private LinearLayout bka;
    private a bkb;
    private View.OnClickListener bkc;
    private View.OnClickListener bkd;
    private boolean bke;
    private boolean bkf;
    private Context mContext;

    /* loaded from: classes.dex */
    interface a {
        void PI();

        void PJ();

        void cu(boolean z);

        void cv(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.bjF = false;
        this.bjG = true;
        this.bjH = false;
        this.bjI = false;
        this.bke = true;
        this.bkf = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.app_download_dialog);
        this.bjJ = (LinearLayout) findViewById(d.g.app_info);
        this.bjK = (TextView) findViewById(d.g.app_version_and_size);
        this.bjL = (TextView) findViewById(d.g.app_description);
        this.bjQ = (TextView) findViewById(d.g.fullsize_download_button);
        this.bjP = (TextView) findViewById(d.g.cancel_download_button);
        this.bjR = findViewById(d.g.divider_line);
        this.bjM = (TextView) findViewById(d.g.download_process);
        this.bjS = (TextView) findViewById(d.g.incremental_download_button);
        this.bjT = (TextView) findViewById(d.g.not_install_as_tip);
        this.bjU = findViewById(d.g.incremental_download_layout);
        this.bjO = (TextView) findViewById(d.g.other_app_recommend);
        this.bjZ = findViewById(d.g.divider_under_button);
        this.bka = (LinearLayout) findViewById(d.g.cancel_confirm_ll);
        this.bjN = this.bjM.getText().toString();
        this.bjV = (LinearLayout) findViewById(d.g.cancel_dialog);
        this.bjX = (TextView) findViewById(d.g.sure_cancel);
        this.bjY = (TextView) findViewById(d.g.cancel_button);
        this.bjW = (TextView) findViewById(d.g.cancel_tip);
        this.bjX.setOnClickListener(this.bkc);
        this.bjY.setOnClickListener(this.bkd);
        if (com.baidu.adp.lib.b.d.hv().aw("android_shouzhu_update") == 1) {
            this.bke = true;
        } else {
            this.bke = false;
        }
        String size = this.bjD.getSize();
        String newVersion = this.bjD.getNewVersion();
        String newVersionDesc = this.bjD.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.k.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.c(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.bjK.setText(sb.toString());
        this.bjL.setText(newVersionDesc);
        if (this.bjD.forceUpdate()) {
            this.bjI = true;
            this.bjP.setText(this.mContext.getString(d.k.quit));
        } else {
            this.bjP.setText(this.mContext.getString(d.k.update_after));
        }
        if (this.bjE != null && this.bjE.showCombineDownload() && !TextUtils.isEmpty(this.bjE.getApkMD5RSA())) {
            this.bjO.setText(this.bjE.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.bjE.getAppProc()) && !TextUtils.isEmpty(this.bjE.getAppUrl())) {
                this.bjO.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.bjO.setCompoundDrawables(drawable, null, null, null);
                this.bjF = true;
            } else {
                this.bjO.setVisibility(8);
                this.bjF = false;
            }
        } else {
            this.bjO.setVisibility(8);
            this.bjF = false;
        }
        cs(this.bke);
        this.bjQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.bjH = true;
                if (e.this.bjG) {
                    Drawable drawable2 = am.getDrawable(d.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.bjO.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.bkb.cu(e.this.bjG);
            }
        });
        this.bjS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bkf) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.bjS.setEnabled(false);
                e.this.bkb.cv(e.this.bjG);
            }
        });
        this.bjP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bkb.PI();
            }
        });
        this.bjO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.bjH) {
                    if (e.this.bjG) {
                        Drawable drawable2 = am.getDrawable(d.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.bjO.setCompoundDrawables(drawable2, null, null, null);
                        e.this.bjF = false;
                        e.this.bjG = false;
                        return;
                    }
                    Drawable drawable3 = am.getDrawable(d.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.bjO.setCompoundDrawables(drawable3, null, null, null);
                    e.this.bjF = true;
                    e.this.bjG = true;
                }
            }
        });
        PG();
    }

    private void PG() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void cs(boolean z) {
        if (g.b(this.mContext.getPackageManager())) {
            this.bjT.setVisibility(8);
        } else {
            this.bjT.setVisibility(0);
        }
        if (z) {
            if (this.bjD == null || TextUtils.isEmpty(this.bjD.getPatch()) || this.bjD.getNewVersionCode() < 0) {
                this.bjU.setVisibility(0);
                this.bjS.setText(d.k.super_update);
                am.i(this.bjS, d.f.dialog_middle_item_bg_selector);
                this.bka.setVisibility(0);
                this.bkf = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.bjU.setVisibility(0);
            this.bjS.setText(d.k.incremental_update);
            am.i(this.bjS, d.f.dialog_single_button_bg_selector);
            this.bjZ.setVisibility(8);
            this.bka.setVisibility(8);
            this.bkf = true;
            TiebaStatic.log("c10002");
        } else if (this.bjD == null || TextUtils.isEmpty(this.bjD.getPatch()) || this.bjD.getNewVersionCode() < 0) {
            this.bjU.setVisibility(8);
            this.bka.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.bjU.setVisibility(0);
            am.i(this.bjS, d.f.dialog_middle_item_bg_selector);
            this.bjS.setText(d.k.incremental_update);
            this.bka.setVisibility(0);
            this.bkf = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void gj(int i) {
        this.bjQ.setVisibility(8);
        this.bjU.setVisibility(8);
        this.bjP.setVisibility(8);
        this.bjR.setVisibility(8);
        this.bjH = true;
        this.bka.setVisibility(0);
        this.bjM.setVisibility(0);
        this.bjM.setText(this.bjN + i + "%");
    }

    public void ct(boolean z) {
        this.bjQ.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.bjH) {
            this.bkb.stopService();
            this.bjJ.setVisibility(8);
            if (this.bjI) {
                this.bjW.setText(getContext().getString(d.k.download_exit));
            }
            this.bjV.setVisibility(0);
            return;
        }
        this.bkb.PJ();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.bjD = versionData;
        this.bjE = combineDownload;
        this.bkb = aVar;
    }

    public void PH() {
        this.bjV.setVisibility(8);
        this.bjJ.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.bkc = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.bkd = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(d.g.app_download_dialog_layout));
        }
    }
}
