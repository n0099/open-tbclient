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
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes.dex */
public class f extends Dialog {
    private TextView bzA;
    private View bzB;
    private LinearLayout bzC;
    private TextView bzD;
    private TextView bzE;
    private TextView bzF;
    private View bzG;
    private LinearLayout bzH;
    private a bzI;
    private View.OnClickListener bzJ;
    private View.OnClickListener bzK;
    private boolean bzL;
    private boolean bzM;
    private VersionData bzj;
    private CombineDownload bzk;
    private boolean bzl;
    private boolean bzm;
    private boolean bzn;
    private boolean bzo;
    private LinearLayout bzp;
    private TextView bzq;
    private TextView bzr;
    private TextView bzs;
    private String bzt;
    private TextView bzu;
    private TextView bzv;
    private TextView bzw;
    private TextView bzx;
    private ImageView bzy;
    private TextView bzz;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    interface a {
        void Vr();

        void Vs();

        void dq(boolean z);

        void dr(boolean z);

        void stopService();
    }

    public f(Context context, int i) {
        super(context, i);
        this.bzl = false;
        this.bzm = true;
        this.bzn = false;
        this.bzo = false;
        this.bzL = true;
        this.bzM = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == f.this.bzw.getId()) {
                    f.this.bzI.Vr();
                    f.this.bX(f.this.mContext);
                } else if (view.getId() == f.this.bzy.getId()) {
                    f.this.bzI.Vr();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.app_download_dialog);
        this.bzp = (LinearLayout) findViewById(e.g.app_info);
        this.bzq = (TextView) findViewById(e.g.app_version_and_size);
        this.bzr = (TextView) findViewById(e.g.app_description);
        this.bzx = (TextView) findViewById(e.g.fullsize_download_button);
        this.bzv = (TextView) findViewById(e.g.cancel_download_button);
        this.bzw = (TextView) findViewById(e.g.btn_update_save_flow);
        this.bzy = (ImageView) findViewById(e.g.img_close);
        this.bzw.setOnClickListener(this.mOnClickListener);
        this.bzy.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(e.g.divider_line);
        this.bzs = (TextView) findViewById(e.g.download_process);
        this.bzz = (TextView) findViewById(e.g.incremental_download_button);
        this.bzA = (TextView) findViewById(e.g.not_install_as_tip);
        this.bzB = findViewById(e.g.incremental_download_layout);
        this.bzu = (TextView) findViewById(e.g.other_app_recommend);
        this.bzG = findViewById(e.g.divider_under_button);
        this.bzH = (LinearLayout) findViewById(e.g.cancel_confirm_ll);
        this.bzt = this.bzs.getText().toString();
        this.bzC = (LinearLayout) findViewById(e.g.cancel_dialog);
        this.bzE = (TextView) findViewById(e.g.sure_cancel);
        this.bzF = (TextView) findViewById(e.g.cancel_button);
        this.bzD = (TextView) findViewById(e.g.cancel_tip);
        this.bzE.setOnClickListener(this.bzJ);
        this.bzF.setOnClickListener(this.bzK);
        if (com.baidu.adp.lib.b.d.iQ().aO("android_shouzhu_update") == 1) {
            this.bzL = true;
        } else {
            this.bzL = false;
        }
        String size = this.bzj.getSize();
        String newVersion = this.bzj.getNewVersion();
        String newVersionDesc = this.bzj.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(e.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.c(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.bzq.setText(sb.toString());
        this.bzr.setText(newVersionDesc);
        if (this.bzj.forceUpdate()) {
            this.bzo = true;
            this.bzv.setText(this.mContext.getString(e.j.quit));
            this.bzw.setVisibility(8);
            this.bzy.setVisibility(8);
        } else if (this.bzj.isOfficialVersion() && l.T(this.mContext, "com.tencent.android.qqdownloader")) {
            this.bzv.setVisibility(8);
        } else {
            this.bzv.setText(this.mContext.getString(e.j.update_after));
            this.bzw.setVisibility(8);
            this.bzy.setVisibility(8);
        }
        if (this.bzk != null && this.bzk.showCombineDownload() && !TextUtils.isEmpty(this.bzk.getApkMD5RSA())) {
            this.bzu.setText(this.bzk.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.bzk.getAppProc()) && !TextUtils.isEmpty(this.bzk.getAppUrl())) {
                this.bzu.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(e.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.bzu.setCompoundDrawables(drawable, null, null, null);
                this.bzl = true;
            } else {
                this.bzu.setVisibility(8);
                this.bzl = false;
            }
        } else {
            this.bzu.setVisibility(8);
            this.bzl = false;
        }
        m19do(this.bzL);
        this.bzx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                f.this.bzn = true;
                if (f.this.bzm) {
                    Drawable drawable2 = al.getDrawable(e.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    f.this.bzu.setCompoundDrawables(drawable2, null, null, null);
                }
                f.this.bzI.dq(f.this.bzm);
            }
        });
        this.bzz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bzM) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                f.this.bzz.setEnabled(false);
                f.this.bzI.dr(f.this.bzm);
            }
        });
        this.bzv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bzI.Vr();
            }
        });
        this.bzu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.bzn) {
                    if (f.this.bzm) {
                        Drawable drawable2 = al.getDrawable(e.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        f.this.bzu.setCompoundDrawables(drawable2, null, null, null);
                        f.this.bzl = false;
                        f.this.bzm = false;
                        return;
                    }
                    Drawable drawable3 = al.getDrawable(e.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    f.this.bzu.setCompoundDrawables(drawable3, null, null, null);
                    f.this.bzl = true;
                    f.this.bzm = true;
                }
            }
        });
        Vp();
    }

    private void Vp() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m19do(boolean z) {
        if (h.a(this.mContext.getPackageManager())) {
            this.bzA.setVisibility(8);
        } else {
            this.bzA.setVisibility(0);
        }
        if (z) {
            if (this.bzj == null || TextUtils.isEmpty(this.bzj.getPatch()) || this.bzj.getNewVersionCode() < 0) {
                this.bzB.setVisibility(0);
                this.bzz.setText(e.j.super_update);
                al.i(this.bzz, e.f.dialog_middle_item_bg_selector);
                this.bzH.setVisibility(0);
                this.bzM = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.bzB.setVisibility(0);
            this.bzz.setText(e.j.incremental_update);
            al.i(this.bzz, e.f.dialog_single_button_bg_selector);
            this.bzG.setVisibility(8);
            this.bzH.setVisibility(8);
            this.bzM = true;
            TiebaStatic.log("c10002");
        } else if (this.bzj == null || TextUtils.isEmpty(this.bzj.getPatch()) || this.bzj.getNewVersionCode() < 0) {
            this.bzB.setVisibility(8);
            this.bzH.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.bzB.setVisibility(0);
            al.i(this.bzz, e.f.dialog_middle_item_bg_selector);
            this.bzz.setText(e.j.incremental_update);
            this.bzH.setVisibility(0);
            this.bzM = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void updateProgress(int i) {
        this.bzx.setVisibility(8);
        this.bzB.setVisibility(8);
        this.bzv.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.bzn = true;
        this.bzH.setVisibility(0);
        this.bzs.setVisibility(0);
        this.bzs.setText(this.bzt + i + "%");
        this.bzy.setVisibility(8);
        this.bzw.setVisibility(8);
    }

    public void dp(boolean z) {
        this.bzx.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.bzn) {
            this.bzI.stopService();
            this.bzp.setVisibility(8);
            if (this.bzo) {
                this.bzD.setText(getContext().getString(e.j.download_exit));
            }
            this.bzC.setVisibility(0);
            return;
        }
        this.bzI.Vs();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.bzj = versionData;
        this.bzk = combineDownload;
        this.bzI = aVar;
    }

    public void Vq() {
        this.bzC.setVisibility(8);
        this.bzp.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.bzJ = onClickListener;
    }

    public void g(View.OnClickListener onClickListener) {
        this.bzK = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(e.g.app_download_dialog_layout));
        }
        al.c(this.bzy, e.f.write_close_selector);
    }

    public void bX(Context context) {
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
