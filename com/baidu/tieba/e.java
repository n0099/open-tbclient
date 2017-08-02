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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes.dex */
public class e extends Dialog {
    private VersionData aTT;
    private CombineDownload aTU;
    private boolean aTV;
    private boolean aTW;
    private boolean aTX;
    private boolean aTY;
    private LinearLayout aTZ;
    private TextView aUa;
    private TextView aUb;
    private TextView aUc;
    private String aUd;
    private TextView aUe;
    private TextView aUf;
    private TextView aUg;
    private View aUh;
    private TextView aUi;
    private TextView aUj;
    private View aUk;
    private LinearLayout aUl;
    private TextView aUm;
    private TextView aUn;
    private TextView aUo;
    private View aUp;
    private LinearLayout aUq;
    private a aUr;
    private View.OnClickListener aUs;
    private View.OnClickListener aUt;
    private boolean aUu;
    private boolean aUv;
    private Context mContext;

    /* loaded from: classes.dex */
    interface a {
        void Ka();

        void Kb();

        void cn(boolean z);

        void co(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.aTV = false;
        this.aTW = true;
        this.aTX = false;
        this.aTY = false;
        this.aUu = true;
        this.aUv = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.app_download_dialog);
        this.aTZ = (LinearLayout) findViewById(d.h.app_info);
        this.aUa = (TextView) findViewById(d.h.app_version_and_size);
        this.aUb = (TextView) findViewById(d.h.app_description);
        this.aUg = (TextView) findViewById(d.h.fullsize_download_button);
        this.aUf = (TextView) findViewById(d.h.cancel_download_button);
        this.aUh = findViewById(d.h.divider_line);
        this.aUc = (TextView) findViewById(d.h.download_process);
        this.aUi = (TextView) findViewById(d.h.incremental_download_button);
        this.aUj = (TextView) findViewById(d.h.not_install_as_tip);
        this.aUk = findViewById(d.h.incremental_download_layout);
        this.aUe = (TextView) findViewById(d.h.other_app_recommend);
        this.aUp = findViewById(d.h.divider_under_button);
        this.aUq = (LinearLayout) findViewById(d.h.cancel_confirm_ll);
        this.aUd = this.aUc.getText().toString();
        this.aUl = (LinearLayout) findViewById(d.h.cancel_dialog);
        this.aUn = (TextView) findViewById(d.h.sure_cancel);
        this.aUo = (TextView) findViewById(d.h.cancel_button);
        this.aUm = (TextView) findViewById(d.h.cancel_tip);
        this.aUn.setOnClickListener(this.aUs);
        this.aUo.setOnClickListener(this.aUt);
        if (com.baidu.adp.lib.b.d.eW().af("android_shouzhu_update") == 1) {
            this.aUu = true;
        } else {
            this.aUu = false;
        }
        String size = this.aTT.getSize();
        String newVersion = this.aTT.getNewVersion();
        String newVersionDesc = this.aTT.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.l.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aUa.setText(sb.toString());
        this.aUb.setText(newVersionDesc);
        if (this.aTT.forceUpdate()) {
            this.aTY = true;
            this.aUf.setText(this.mContext.getString(d.l.quit));
        } else {
            this.aUf.setText(this.mContext.getString(d.l.update_after));
        }
        if (this.aTU != null && this.aTU.showCombineDownload() && !TextUtils.isEmpty(this.aTU.getApkMD5RSA())) {
            this.aUe.setText(this.aTU.getAppName());
            if (!s.isInstalledPackage(this.mContext, this.aTU.getAppProc()) && !TextUtils.isEmpty(this.aTU.getAppUrl())) {
                this.aUe.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.g.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aUe.setCompoundDrawables(drawable, null, null, null);
                this.aTV = true;
            } else {
                this.aUe.setVisibility(8);
                this.aTV = false;
            }
        } else {
            this.aUe.setVisibility(8);
            this.aTV = false;
        }
        cm(this.aUu);
        this.aUg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.aUg.setEnabled(false);
                e.this.aTX = true;
                if (e.this.aTW) {
                    Drawable drawable2 = ai.getDrawable(d.g.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.aUe.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.aUr.cn(e.this.aTW);
            }
        });
        this.aUi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aUv) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.aUi.setEnabled(false);
                e.this.aUr.co(e.this.aTW);
            }
        });
        this.aUf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aUr.Ka();
            }
        });
        this.aUe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.aTX) {
                    if (e.this.aTW) {
                        Drawable drawable2 = ai.getDrawable(d.g.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.aUe.setCompoundDrawables(drawable2, null, null, null);
                        e.this.aTV = false;
                        e.this.aTW = false;
                        return;
                    }
                    Drawable drawable3 = ai.getDrawable(d.g.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.aUe.setCompoundDrawables(drawable3, null, null, null);
                    e.this.aTV = true;
                    e.this.aTW = true;
                }
            }
        });
        JY();
    }

    private void JY() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void cm(boolean z) {
        if (g.b(this.mContext.getPackageManager())) {
            this.aUj.setVisibility(8);
        } else {
            this.aUj.setVisibility(0);
        }
        if (z) {
            if (this.aTT == null || TextUtils.isEmpty(this.aTT.getPatch()) || this.aTT.getNewVersionCode() < 0) {
                this.aUk.setVisibility(0);
                this.aUi.setText(d.l.super_update);
                ai.j(this.aUi, d.g.dialog_middle_item_bg_selector);
                this.aUq.setVisibility(0);
                this.aUv = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aUk.setVisibility(0);
            this.aUi.setText(d.l.incremental_update);
            ai.j(this.aUi, d.g.dialog_single_button_bg_selector);
            this.aUp.setVisibility(8);
            this.aUq.setVisibility(8);
            this.aUv = true;
            TiebaStatic.log("c10002");
        } else if (this.aTT == null || TextUtils.isEmpty(this.aTT.getPatch()) || this.aTT.getNewVersionCode() < 0) {
            this.aUk.setVisibility(8);
            this.aUq.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aUk.setVisibility(0);
            ai.j(this.aUi, d.g.dialog_middle_item_bg_selector);
            this.aUi.setText(d.l.incremental_update);
            this.aUq.setVisibility(0);
            this.aUv = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void fL(int i) {
        this.aUg.setVisibility(8);
        this.aUk.setVisibility(8);
        this.aUf.setVisibility(8);
        this.aUh.setVisibility(8);
        this.aTX = true;
        this.aUq.setVisibility(0);
        this.aUc.setVisibility(0);
        this.aUc.setText(this.aUd + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aTX) {
            this.aUr.stopService();
            this.aTZ.setVisibility(8);
            if (this.aTY) {
                this.aUm.setText(getContext().getString(d.l.download_exit));
            }
            this.aUl.setVisibility(0);
            return;
        }
        this.aUr.Kb();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aTT = versionData;
        this.aTU = combineDownload;
        this.aUr = aVar;
    }

    public void JZ() {
        this.aUl.setVisibility(8);
        this.aTZ.setVisibility(0);
    }

    public void i(View.OnClickListener onClickListener) {
        this.aUs = onClickListener;
    }

    public void j(View.OnClickListener onClickListener) {
        this.aUt = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ah(i == 1);
            tbPageContext.getLayoutMode().t(findViewById(d.h.app_download_dialog_layout));
        }
    }
}
