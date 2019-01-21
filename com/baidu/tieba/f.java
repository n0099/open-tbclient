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
    private TextView bzB;
    private View bzC;
    private LinearLayout bzD;
    private TextView bzE;
    private TextView bzF;
    private TextView bzG;
    private View bzH;
    private LinearLayout bzI;
    private a bzJ;
    private View.OnClickListener bzK;
    private View.OnClickListener bzL;
    private boolean bzM;
    private boolean bzN;
    private VersionData bzk;
    private CombineDownload bzl;
    private boolean bzm;
    private boolean bzn;
    private boolean bzo;
    private boolean bzp;
    private LinearLayout bzq;
    private TextView bzr;
    private TextView bzs;
    private TextView bzt;
    private String bzu;
    private TextView bzv;
    private TextView bzw;
    private TextView bzx;
    private TextView bzy;
    private ImageView bzz;
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
        this.bzm = false;
        this.bzn = true;
        this.bzo = false;
        this.bzp = false;
        this.bzM = true;
        this.bzN = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == f.this.bzx.getId()) {
                    f.this.bzJ.Vr();
                    f.this.bX(f.this.mContext);
                } else if (view.getId() == f.this.bzz.getId()) {
                    f.this.bzJ.Vr();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.app_download_dialog);
        this.bzq = (LinearLayout) findViewById(e.g.app_info);
        this.bzr = (TextView) findViewById(e.g.app_version_and_size);
        this.bzs = (TextView) findViewById(e.g.app_description);
        this.bzy = (TextView) findViewById(e.g.fullsize_download_button);
        this.bzw = (TextView) findViewById(e.g.cancel_download_button);
        this.bzx = (TextView) findViewById(e.g.btn_update_save_flow);
        this.bzz = (ImageView) findViewById(e.g.img_close);
        this.bzx.setOnClickListener(this.mOnClickListener);
        this.bzz.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(e.g.divider_line);
        this.bzt = (TextView) findViewById(e.g.download_process);
        this.bzA = (TextView) findViewById(e.g.incremental_download_button);
        this.bzB = (TextView) findViewById(e.g.not_install_as_tip);
        this.bzC = findViewById(e.g.incremental_download_layout);
        this.bzv = (TextView) findViewById(e.g.other_app_recommend);
        this.bzH = findViewById(e.g.divider_under_button);
        this.bzI = (LinearLayout) findViewById(e.g.cancel_confirm_ll);
        this.bzu = this.bzt.getText().toString();
        this.bzD = (LinearLayout) findViewById(e.g.cancel_dialog);
        this.bzF = (TextView) findViewById(e.g.sure_cancel);
        this.bzG = (TextView) findViewById(e.g.cancel_button);
        this.bzE = (TextView) findViewById(e.g.cancel_tip);
        this.bzF.setOnClickListener(this.bzK);
        this.bzG.setOnClickListener(this.bzL);
        if (com.baidu.adp.lib.b.d.iQ().aO("android_shouzhu_update") == 1) {
            this.bzM = true;
        } else {
            this.bzM = false;
        }
        String size = this.bzk.getSize();
        String newVersion = this.bzk.getNewVersion();
        String newVersionDesc = this.bzk.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(e.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.c(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.bzr.setText(sb.toString());
        this.bzs.setText(newVersionDesc);
        if (this.bzk.forceUpdate()) {
            this.bzp = true;
            this.bzw.setText(this.mContext.getString(e.j.quit));
            this.bzx.setVisibility(8);
            this.bzz.setVisibility(8);
        } else if (this.bzk.isOfficialVersion() && l.T(this.mContext, "com.tencent.android.qqdownloader")) {
            this.bzw.setVisibility(8);
        } else {
            this.bzw.setText(this.mContext.getString(e.j.update_after));
            this.bzx.setVisibility(8);
            this.bzz.setVisibility(8);
        }
        if (this.bzl != null && this.bzl.showCombineDownload() && !TextUtils.isEmpty(this.bzl.getApkMD5RSA())) {
            this.bzv.setText(this.bzl.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.bzl.getAppProc()) && !TextUtils.isEmpty(this.bzl.getAppUrl())) {
                this.bzv.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(e.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.bzv.setCompoundDrawables(drawable, null, null, null);
                this.bzm = true;
            } else {
                this.bzv.setVisibility(8);
                this.bzm = false;
            }
        } else {
            this.bzv.setVisibility(8);
            this.bzm = false;
        }
        m19do(this.bzM);
        this.bzy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                f.this.bzo = true;
                if (f.this.bzn) {
                    Drawable drawable2 = al.getDrawable(e.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    f.this.bzv.setCompoundDrawables(drawable2, null, null, null);
                }
                f.this.bzJ.dq(f.this.bzn);
            }
        });
        this.bzA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bzN) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                f.this.bzA.setEnabled(false);
                f.this.bzJ.dr(f.this.bzn);
            }
        });
        this.bzw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bzJ.Vr();
            }
        });
        this.bzv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.bzo) {
                    if (f.this.bzn) {
                        Drawable drawable2 = al.getDrawable(e.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        f.this.bzv.setCompoundDrawables(drawable2, null, null, null);
                        f.this.bzm = false;
                        f.this.bzn = false;
                        return;
                    }
                    Drawable drawable3 = al.getDrawable(e.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    f.this.bzv.setCompoundDrawables(drawable3, null, null, null);
                    f.this.bzm = true;
                    f.this.bzn = true;
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
            this.bzB.setVisibility(8);
        } else {
            this.bzB.setVisibility(0);
        }
        if (z) {
            if (this.bzk == null || TextUtils.isEmpty(this.bzk.getPatch()) || this.bzk.getNewVersionCode() < 0) {
                this.bzC.setVisibility(0);
                this.bzA.setText(e.j.super_update);
                al.i(this.bzA, e.f.dialog_middle_item_bg_selector);
                this.bzI.setVisibility(0);
                this.bzN = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.bzC.setVisibility(0);
            this.bzA.setText(e.j.incremental_update);
            al.i(this.bzA, e.f.dialog_single_button_bg_selector);
            this.bzH.setVisibility(8);
            this.bzI.setVisibility(8);
            this.bzN = true;
            TiebaStatic.log("c10002");
        } else if (this.bzk == null || TextUtils.isEmpty(this.bzk.getPatch()) || this.bzk.getNewVersionCode() < 0) {
            this.bzC.setVisibility(8);
            this.bzI.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.bzC.setVisibility(0);
            al.i(this.bzA, e.f.dialog_middle_item_bg_selector);
            this.bzA.setText(e.j.incremental_update);
            this.bzI.setVisibility(0);
            this.bzN = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void updateProgress(int i) {
        this.bzy.setVisibility(8);
        this.bzC.setVisibility(8);
        this.bzw.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.bzo = true;
        this.bzI.setVisibility(0);
        this.bzt.setVisibility(0);
        this.bzt.setText(this.bzu + i + "%");
        this.bzz.setVisibility(8);
        this.bzx.setVisibility(8);
    }

    public void dp(boolean z) {
        this.bzy.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.bzo) {
            this.bzJ.stopService();
            this.bzq.setVisibility(8);
            if (this.bzp) {
                this.bzE.setText(getContext().getString(e.j.download_exit));
            }
            this.bzD.setVisibility(0);
            return;
        }
        this.bzJ.Vs();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.bzk = versionData;
        this.bzl = combineDownload;
        this.bzJ = aVar;
    }

    public void Vq() {
        this.bzD.setVisibility(8);
        this.bzq.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.bzK = onClickListener;
    }

    public void g(View.OnClickListener onClickListener) {
        this.bzL = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(e.g.app_download_dialog_layout));
        }
        al.c(this.bzz, e.f.write_close_selector);
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
