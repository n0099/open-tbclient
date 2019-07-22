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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes.dex */
public class d extends Dialog {
    private VersionData cTZ;
    private View.OnClickListener cUA;
    private boolean cUB;
    private boolean cUC;
    private CombineDownload cUa;
    private boolean cUb;
    private boolean cUc;
    private boolean cUd;
    private boolean cUe;
    private LinearLayout cUf;
    private TextView cUg;
    private TextView cUh;
    private TextView cUi;
    private String cUj;
    private TextView cUk;
    private TextView cUl;
    private TextView cUm;
    private TextView cUn;
    private ImageView cUo;
    private TextView cUp;
    private TextView cUq;
    private View cUr;
    private LinearLayout cUs;
    private TextView cUt;
    private TextView cUu;
    private TextView cUv;
    private View cUw;
    private LinearLayout cUx;
    private a cUy;
    private View.OnClickListener cUz;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    interface a {
        void aBM();

        void aBN();

        void gh(boolean z);

        void gi(boolean z);

        void stopService();
    }

    public d(Context context, int i) {
        super(context, i);
        this.cUb = false;
        this.cUc = true;
        this.cUd = false;
        this.cUe = false;
        this.cUB = true;
        this.cUC = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.this.cUm.getId()) {
                    d.this.cUy.aBM();
                    d.this.cV(d.this.mContext);
                } else if (view.getId() == d.this.cUo.getId()) {
                    d.this.cUy.aBM();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.cUf = (LinearLayout) findViewById(R.id.app_info);
        this.cUg = (TextView) findViewById(R.id.app_version_and_size);
        this.cUh = (TextView) findViewById(R.id.app_description);
        this.cUn = (TextView) findViewById(R.id.fullsize_download_button);
        this.cUl = (TextView) findViewById(R.id.cancel_download_button);
        this.cUm = (TextView) findViewById(R.id.btn_update_save_flow);
        this.cUo = (ImageView) findViewById(R.id.img_close);
        this.cUm.setOnClickListener(this.mOnClickListener);
        this.cUo.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.cUi = (TextView) findViewById(R.id.download_process);
        this.cUp = (TextView) findViewById(R.id.incremental_download_button);
        this.cUq = (TextView) findViewById(R.id.not_install_as_tip);
        this.cUr = findViewById(R.id.incremental_download_layout);
        this.cUk = (TextView) findViewById(R.id.other_app_recommend);
        this.cUw = findViewById(R.id.divider_under_button);
        this.cUx = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.cUj = this.cUi.getText().toString();
        this.cUs = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.cUu = (TextView) findViewById(R.id.sure_cancel);
        this.cUv = (TextView) findViewById(R.id.cancel_button);
        this.cUt = (TextView) findViewById(R.id.cancel_tip);
        this.cUu.setOnClickListener(this.cUz);
        this.cUv.setOnClickListener(this.cUA);
        if (com.baidu.adp.lib.b.d.hS().az("android_shouzhu_update") == 1) {
            this.cUB = true;
        } else {
            this.cUB = false;
        }
        String size = this.cTZ.getSize();
        String newVersion = this.cTZ.getNewVersion();
        String newVersionDesc = this.cTZ.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.c(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.cUg.setText(sb.toString());
        this.cUh.setText(newVersionDesc);
        if (this.cTZ.forceUpdate()) {
            this.cUe = true;
            this.cUl.setText(this.mContext.getString(R.string.quit));
            this.cUm.setVisibility(8);
            this.cUo.setVisibility(8);
        } else if (this.cTZ.isOfficialVersion() && l.F(this.mContext, "com.tencent.android.qqdownloader")) {
            this.cUl.setVisibility(8);
        } else {
            this.cUl.setText(this.mContext.getString(R.string.update_after));
            this.cUm.setVisibility(8);
            this.cUo.setVisibility(8);
        }
        if (this.cUa != null && this.cUa.showCombineDownload() && !TextUtils.isEmpty(this.cUa.getApkMD5RSA())) {
            this.cUk.setText(this.cUa.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.cUa.getAppProc()) && !TextUtils.isEmpty(this.cUa.getAppUrl())) {
                this.cUk.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.cUk.setCompoundDrawables(drawable, null, null, null);
                this.cUb = true;
            } else {
                this.cUk.setVisibility(8);
                this.cUb = false;
            }
        } else {
            this.cUk.setVisibility(8);
            this.cUb = false;
        }
        gf(this.cUB);
        this.cUn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                d.this.cUd = true;
                if (d.this.cUc) {
                    Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    d.this.cUk.setCompoundDrawables(drawable2, null, null, null);
                }
                d.this.cUy.gh(d.this.cUc);
            }
        });
        this.cUp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cUC) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                d.this.cUp.setEnabled(false);
                d.this.cUy.gi(d.this.cUc);
            }
        });
        this.cUl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.cUy.aBM();
            }
        });
        this.cUk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.cUd) {
                    if (d.this.cUc) {
                        Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        d.this.cUk.setCompoundDrawables(drawable2, null, null, null);
                        d.this.cUb = false;
                        d.this.cUc = false;
                        return;
                    }
                    Drawable drawable3 = am.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    d.this.cUk.setCompoundDrawables(drawable3, null, null, null);
                    d.this.cUb = true;
                    d.this.cUc = true;
                }
            }
        });
        aBK();
    }

    private void aBK() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void gf(boolean z) {
        if (f.a(this.mContext.getPackageManager())) {
            this.cUq.setVisibility(8);
        } else {
            this.cUq.setVisibility(0);
        }
        if (z) {
            if (this.cTZ == null || TextUtils.isEmpty(this.cTZ.getPatch()) || this.cTZ.getNewVersionCode() < 0) {
                this.cUr.setVisibility(0);
                this.cUp.setText(R.string.super_update);
                am.k(this.cUp, R.drawable.dialog_middle_item_bg_selector);
                this.cUx.setVisibility(0);
                this.cUC = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.cUr.setVisibility(0);
            this.cUp.setText(R.string.incremental_update);
            am.k(this.cUp, R.drawable.dialog_single_button_bg_selector);
            this.cUw.setVisibility(8);
            this.cUx.setVisibility(8);
            this.cUC = true;
            TiebaStatic.log("c10002");
        } else if (this.cTZ == null || TextUtils.isEmpty(this.cTZ.getPatch()) || this.cTZ.getNewVersionCode() < 0) {
            this.cUr.setVisibility(8);
            this.cUx.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.cUr.setVisibility(0);
            am.k(this.cUp, R.drawable.dialog_middle_item_bg_selector);
            this.cUp.setText(R.string.incremental_update);
            this.cUx.setVisibility(0);
            this.cUC = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void updateProgress(int i) {
        this.cUn.setVisibility(8);
        this.cUr.setVisibility(8);
        this.cUl.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.cUd = true;
        this.cUx.setVisibility(0);
        this.cUi.setVisibility(0);
        this.cUi.setText(this.cUj + i + "%");
        this.cUo.setVisibility(8);
        this.cUm.setVisibility(8);
    }

    public void gg(boolean z) {
        this.cUn.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.cUd) {
            this.cUy.stopService();
            this.cUf.setVisibility(8);
            if (this.cUe) {
                this.cUt.setText(getContext().getString(R.string.download_exit));
            }
            this.cUs.setVisibility(0);
            return;
        }
        this.cUy.aBN();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.cTZ = versionData;
        this.cUa = combineDownload;
        this.cUy = aVar;
    }

    public void aBL() {
        this.cUs.setVisibility(8);
        this.cUf.setVisibility(0);
    }

    public void g(View.OnClickListener onClickListener) {
        this.cUz = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.cUA = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        am.c(this.cUo, (int) R.drawable.write_close_selector);
    }

    public void cV(Context context) {
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
