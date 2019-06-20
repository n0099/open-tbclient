package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes.dex */
public class d extends Dialog {
    private VersionData cSD;
    private CombineDownload cSE;
    private boolean cSF;
    private boolean cSG;
    private boolean cSH;
    private boolean cSI;
    private LinearLayout cSJ;
    private TextView cSK;
    private TextView cSL;
    private TextView cSM;
    private String cSN;
    private TextView cSO;
    private TextView cSP;
    private TextView cSQ;
    private TextView cSR;
    private ImageView cSS;
    private TextView cST;
    private TextView cSU;
    private View cSV;
    private LinearLayout cSW;
    private TextView cSX;
    private TextView cSY;
    private TextView cSZ;
    private View cTa;
    private LinearLayout cTb;
    private a cTc;
    private View.OnClickListener cTd;
    private View.OnClickListener cTe;
    private boolean cTf;
    private boolean cTg;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    interface a {
        void aAx();

        void aAy();

        void gd(boolean z);

        void ge(boolean z);

        void stopService();
    }

    public d(Context context, int i) {
        super(context, i);
        this.cSF = false;
        this.cSG = true;
        this.cSH = false;
        this.cSI = false;
        this.cTf = true;
        this.cTg = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.this.cSQ.getId()) {
                    d.this.cTc.aAx();
                    d.this.cU(d.this.mContext);
                } else if (view.getId() == d.this.cSS.getId()) {
                    d.this.cTc.aAx();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.cSJ = (LinearLayout) findViewById(R.id.app_info);
        this.cSK = (TextView) findViewById(R.id.app_version_and_size);
        this.cSL = (TextView) findViewById(R.id.app_description);
        this.cSR = (TextView) findViewById(R.id.fullsize_download_button);
        this.cSP = (TextView) findViewById(R.id.cancel_download_button);
        this.cSQ = (TextView) findViewById(R.id.btn_update_save_flow);
        this.cSS = (ImageView) findViewById(R.id.img_close);
        this.cSQ.setOnClickListener(this.mOnClickListener);
        this.cSS.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.cSM = (TextView) findViewById(R.id.download_process);
        this.cST = (TextView) findViewById(R.id.incremental_download_button);
        this.cSU = (TextView) findViewById(R.id.not_install_as_tip);
        this.cSV = findViewById(R.id.incremental_download_layout);
        this.cSO = (TextView) findViewById(R.id.other_app_recommend);
        this.cTa = findViewById(R.id.divider_under_button);
        this.cTb = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.cSN = this.cSM.getText().toString();
        this.cSW = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.cSY = (TextView) findViewById(R.id.sure_cancel);
        this.cSZ = (TextView) findViewById(R.id.cancel_button);
        this.cSX = (TextView) findViewById(R.id.cancel_tip);
        this.cSY.setOnClickListener(this.cTd);
        this.cSZ.setOnClickListener(this.cTe);
        if (com.baidu.adp.lib.b.d.hI().ay("android_shouzhu_update") == 1) {
            this.cTf = true;
        } else {
            this.cTf = false;
        }
        String size = this.cSD.getSize();
        String newVersion = this.cSD.getNewVersion();
        String newVersionDesc = this.cSD.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.c(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.cSK.setText(sb.toString());
        this.cSL.setText(newVersionDesc);
        if (this.cSD.forceUpdate()) {
            this.cSI = true;
            this.cSP.setText(this.mContext.getString(R.string.quit));
            this.cSQ.setVisibility(8);
            this.cSS.setVisibility(8);
        } else if (this.cSD.isOfficialVersion() && l.F(this.mContext, "com.tencent.android.qqdownloader")) {
            this.cSP.setVisibility(8);
        } else {
            this.cSP.setText(this.mContext.getString(R.string.update_after));
            this.cSQ.setVisibility(8);
            this.cSS.setVisibility(8);
        }
        if (this.cSE != null && this.cSE.showCombineDownload() && !TextUtils.isEmpty(this.cSE.getApkMD5RSA())) {
            this.cSO.setText(this.cSE.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.cSE.getAppProc()) && !TextUtils.isEmpty(this.cSE.getAppUrl())) {
                this.cSO.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.cSO.setCompoundDrawables(drawable, null, null, null);
                this.cSF = true;
            } else {
                this.cSO.setVisibility(8);
                this.cSF = false;
            }
        } else {
            this.cSO.setVisibility(8);
            this.cSF = false;
        }
        gb(this.cTf);
        this.cSR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                d.this.cSH = true;
                if (d.this.cSG) {
                    Drawable drawable2 = al.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    d.this.cSO.setCompoundDrawables(drawable2, null, null, null);
                }
                d.this.cTc.gd(d.this.cSG);
            }
        });
        this.cST.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cTg) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                d.this.cST.setEnabled(false);
                d.this.cTc.ge(d.this.cSG);
            }
        });
        this.cSP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.cTc.aAx();
            }
        });
        this.cSO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.cSH) {
                    if (d.this.cSG) {
                        Drawable drawable2 = al.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        d.this.cSO.setCompoundDrawables(drawable2, null, null, null);
                        d.this.cSF = false;
                        d.this.cSG = false;
                        return;
                    }
                    Drawable drawable3 = al.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    d.this.cSO.setCompoundDrawables(drawable3, null, null, null);
                    d.this.cSF = true;
                    d.this.cSG = true;
                }
            }
        });
        aAv();
    }

    private void aAv() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void gb(boolean z) {
        if (f.a(this.mContext.getPackageManager())) {
            this.cSU.setVisibility(8);
        } else {
            this.cSU.setVisibility(0);
        }
        if (z) {
            if (this.cSD == null || TextUtils.isEmpty(this.cSD.getPatch()) || this.cSD.getNewVersionCode() < 0) {
                this.cSV.setVisibility(0);
                this.cST.setText(R.string.super_update);
                al.k(this.cST, R.drawable.dialog_middle_item_bg_selector);
                this.cTb.setVisibility(0);
                this.cTg = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.cSV.setVisibility(0);
            this.cST.setText(R.string.incremental_update);
            al.k(this.cST, R.drawable.dialog_single_button_bg_selector);
            this.cTa.setVisibility(8);
            this.cTb.setVisibility(8);
            this.cTg = true;
            TiebaStatic.log("c10002");
        } else if (this.cSD == null || TextUtils.isEmpty(this.cSD.getPatch()) || this.cSD.getNewVersionCode() < 0) {
            this.cSV.setVisibility(8);
            this.cTb.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.cSV.setVisibility(0);
            al.k(this.cST, R.drawable.dialog_middle_item_bg_selector);
            this.cST.setText(R.string.incremental_update);
            this.cTb.setVisibility(0);
            this.cTg = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void updateProgress(int i) {
        this.cSR.setVisibility(8);
        this.cSV.setVisibility(8);
        this.cSP.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.cSH = true;
        this.cTb.setVisibility(0);
        this.cSM.setVisibility(0);
        this.cSM.setText(this.cSN + i + "%");
        this.cSS.setVisibility(8);
        this.cSQ.setVisibility(8);
    }

    public void gc(boolean z) {
        this.cSR.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.cSH) {
            this.cTc.stopService();
            this.cSJ.setVisibility(8);
            if (this.cSI) {
                this.cSX.setText(getContext().getString(R.string.download_exit));
            }
            this.cSW.setVisibility(0);
            return;
        }
        this.cTc.aAy();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.cSD = versionData;
        this.cSE = combineDownload;
        this.cTc = aVar;
    }

    public void aAw() {
        this.cSW.setVisibility(8);
        this.cSJ.setVisibility(0);
    }

    public void g(View.OnClickListener onClickListener) {
        this.cTd = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.cTe = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        al.c(this.cSS, (int) R.drawable.write_close_selector);
    }

    public void cU(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + context.getPackageName()));
        try {
            intent.setClassName("com.tencent.android.qqdownloader", "com.tencent.pangu.link.LinkProxyActivity");
            if (!(context instanceof Activity) && intent != null) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }
}
