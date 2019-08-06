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
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes.dex */
public class d extends Dialog {
    private TextView cUA;
    private TextView cUB;
    private TextView cUC;
    private View cUD;
    private LinearLayout cUE;
    private a cUF;
    private View.OnClickListener cUG;
    private View.OnClickListener cUH;
    private boolean cUI;
    private boolean cUJ;
    private VersionData cUg;
    private CombineDownload cUh;
    private boolean cUi;
    private boolean cUj;
    private boolean cUk;
    private boolean cUl;
    private LinearLayout cUm;
    private TextView cUn;
    private TextView cUo;
    private TextView cUp;
    private String cUq;
    private TextView cUr;
    private TextView cUs;
    private TextView cUt;
    private TextView cUu;
    private ImageView cUv;
    private TextView cUw;
    private TextView cUx;
    private View cUy;
    private LinearLayout cUz;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    interface a {
        void aBO();

        void aBP();

        void gh(boolean z);

        void gi(boolean z);

        void stopService();
    }

    public d(Context context, int i) {
        super(context, i);
        this.cUi = false;
        this.cUj = true;
        this.cUk = false;
        this.cUl = false;
        this.cUI = true;
        this.cUJ = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.this.cUt.getId()) {
                    d.this.cUF.aBO();
                    d.this.cV(d.this.mContext);
                } else if (view.getId() == d.this.cUv.getId()) {
                    d.this.cUF.aBO();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.cUm = (LinearLayout) findViewById(R.id.app_info);
        this.cUn = (TextView) findViewById(R.id.app_version_and_size);
        this.cUo = (TextView) findViewById(R.id.app_description);
        this.cUu = (TextView) findViewById(R.id.fullsize_download_button);
        this.cUs = (TextView) findViewById(R.id.cancel_download_button);
        this.cUt = (TextView) findViewById(R.id.btn_update_save_flow);
        this.cUv = (ImageView) findViewById(R.id.img_close);
        this.cUt.setOnClickListener(this.mOnClickListener);
        this.cUv.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.cUp = (TextView) findViewById(R.id.download_process);
        this.cUw = (TextView) findViewById(R.id.incremental_download_button);
        this.cUx = (TextView) findViewById(R.id.not_install_as_tip);
        this.cUy = findViewById(R.id.incremental_download_layout);
        this.cUr = (TextView) findViewById(R.id.other_app_recommend);
        this.cUD = findViewById(R.id.divider_under_button);
        this.cUE = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.cUq = this.cUp.getText().toString();
        this.cUz = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.cUB = (TextView) findViewById(R.id.sure_cancel);
        this.cUC = (TextView) findViewById(R.id.cancel_button);
        this.cUA = (TextView) findViewById(R.id.cancel_tip);
        this.cUB.setOnClickListener(this.cUG);
        this.cUC.setOnClickListener(this.cUH);
        if (com.baidu.adp.lib.b.d.hS().az("android_shouzhu_update") == 1) {
            this.cUI = true;
        } else {
            this.cUI = false;
        }
        String size = this.cUg.getSize();
        String newVersion = this.cUg.getNewVersion();
        String newVersionDesc = this.cUg.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.c(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.cUn.setText(sb.toString());
        this.cUo.setText(newVersionDesc);
        if (this.cUg.forceUpdate()) {
            this.cUl = true;
            this.cUs.setText(this.mContext.getString(R.string.quit));
            this.cUt.setVisibility(8);
            this.cUv.setVisibility(8);
        } else if (this.cUg.isOfficialVersion() && l.F(this.mContext, "com.tencent.android.qqdownloader")) {
            this.cUs.setVisibility(8);
        } else {
            this.cUs.setText(this.mContext.getString(R.string.update_after));
            this.cUt.setVisibility(8);
            this.cUv.setVisibility(8);
        }
        if (this.cUh != null && this.cUh.showCombineDownload() && !TextUtils.isEmpty(this.cUh.getApkMD5RSA())) {
            this.cUr.setText(this.cUh.getAppName());
            if (!w.isInstalledPackage(this.mContext, this.cUh.getAppProc()) && !TextUtils.isEmpty(this.cUh.getAppUrl())) {
                this.cUr.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.cUr.setCompoundDrawables(drawable, null, null, null);
                this.cUi = true;
            } else {
                this.cUr.setVisibility(8);
                this.cUi = false;
            }
        } else {
            this.cUr.setVisibility(8);
            this.cUi = false;
        }
        gf(this.cUI);
        this.cUu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                d.this.cUk = true;
                if (d.this.cUj) {
                    Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    d.this.cUr.setCompoundDrawables(drawable2, null, null, null);
                }
                d.this.cUF.gh(d.this.cUj);
            }
        });
        this.cUw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cUJ) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                d.this.cUw.setEnabled(false);
                d.this.cUF.gi(d.this.cUj);
            }
        });
        this.cUs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.cUF.aBO();
            }
        });
        this.cUr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.cUk) {
                    if (d.this.cUj) {
                        Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        d.this.cUr.setCompoundDrawables(drawable2, null, null, null);
                        d.this.cUi = false;
                        d.this.cUj = false;
                        return;
                    }
                    Drawable drawable3 = am.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    d.this.cUr.setCompoundDrawables(drawable3, null, null, null);
                    d.this.cUi = true;
                    d.this.cUj = true;
                }
            }
        });
        aBM();
    }

    private void aBM() {
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
            this.cUx.setVisibility(8);
        } else {
            this.cUx.setVisibility(0);
        }
        if (z) {
            if (this.cUg == null || TextUtils.isEmpty(this.cUg.getPatch()) || this.cUg.getNewVersionCode() < 0) {
                this.cUy.setVisibility(0);
                this.cUw.setText(R.string.super_update);
                am.k(this.cUw, R.drawable.dialog_middle_item_bg_selector);
                this.cUE.setVisibility(0);
                this.cUJ = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.cUy.setVisibility(0);
            this.cUw.setText(R.string.incremental_update);
            am.k(this.cUw, R.drawable.dialog_single_button_bg_selector);
            this.cUD.setVisibility(8);
            this.cUE.setVisibility(8);
            this.cUJ = true;
            TiebaStatic.log("c10002");
        } else if (this.cUg == null || TextUtils.isEmpty(this.cUg.getPatch()) || this.cUg.getNewVersionCode() < 0) {
            this.cUy.setVisibility(8);
            this.cUE.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.cUy.setVisibility(0);
            am.k(this.cUw, R.drawable.dialog_middle_item_bg_selector);
            this.cUw.setText(R.string.incremental_update);
            this.cUE.setVisibility(0);
            this.cUJ = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void updateProgress(int i) {
        this.cUu.setVisibility(8);
        this.cUy.setVisibility(8);
        this.cUs.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.cUk = true;
        this.cUE.setVisibility(0);
        this.cUp.setVisibility(0);
        this.cUp.setText(this.cUq + i + "%");
        this.cUv.setVisibility(8);
        this.cUt.setVisibility(8);
    }

    public void gg(boolean z) {
        this.cUu.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.cUk) {
            this.cUF.stopService();
            this.cUm.setVisibility(8);
            if (this.cUl) {
                this.cUA.setText(getContext().getString(R.string.download_exit));
            }
            this.cUz.setVisibility(0);
            return;
        }
        this.cUF.aBP();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.cUg = versionData;
        this.cUh = combineDownload;
        this.cUF = aVar;
    }

    public void aBN() {
        this.cUz.setVisibility(8);
        this.cUm.setVisibility(0);
    }

    public void g(View.OnClickListener onClickListener) {
        this.cUG = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.cUH = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        am.c(this.cUv, (int) R.drawable.write_close_selector);
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
