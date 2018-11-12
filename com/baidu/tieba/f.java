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
    private VersionData buV;
    private CombineDownload buW;
    private boolean buX;
    private boolean buY;
    private boolean buZ;
    private boolean bva;
    private LinearLayout bvb;
    private TextView bvc;
    private TextView bvd;
    private TextView bve;
    private String bvf;
    private TextView bvg;
    private TextView bvh;
    private TextView bvi;
    private TextView bvj;
    private ImageView bvk;
    private TextView bvl;
    private TextView bvm;
    private View bvn;
    private LinearLayout bvo;
    private TextView bvp;
    private TextView bvq;
    private TextView bvr;
    private View bvs;
    private LinearLayout bvt;
    private a bvu;
    private View.OnClickListener bvv;
    private View.OnClickListener bvw;
    private boolean bvx;
    private boolean bvy;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    interface a {
        void TN();

        void TO();

        void dm(boolean z);

        void dn(boolean z);

        void stopService();
    }

    public f(Context context, int i) {
        super(context, i);
        this.buX = false;
        this.buY = true;
        this.buZ = false;
        this.bva = false;
        this.bvx = true;
        this.bvy = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == f.this.bvi.getId()) {
                    f.this.bvu.TN();
                    f.this.bU(f.this.mContext);
                } else if (view.getId() == f.this.bvk.getId()) {
                    f.this.bvu.TN();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.app_download_dialog);
        this.bvb = (LinearLayout) findViewById(e.g.app_info);
        this.bvc = (TextView) findViewById(e.g.app_version_and_size);
        this.bvd = (TextView) findViewById(e.g.app_description);
        this.bvj = (TextView) findViewById(e.g.fullsize_download_button);
        this.bvh = (TextView) findViewById(e.g.cancel_download_button);
        this.bvi = (TextView) findViewById(e.g.btn_update_save_flow);
        this.bvk = (ImageView) findViewById(e.g.img_close);
        this.bvi.setOnClickListener(this.mOnClickListener);
        this.bvk.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(e.g.divider_line);
        this.bve = (TextView) findViewById(e.g.download_process);
        this.bvl = (TextView) findViewById(e.g.incremental_download_button);
        this.bvm = (TextView) findViewById(e.g.not_install_as_tip);
        this.bvn = findViewById(e.g.incremental_download_layout);
        this.bvg = (TextView) findViewById(e.g.other_app_recommend);
        this.bvs = findViewById(e.g.divider_under_button);
        this.bvt = (LinearLayout) findViewById(e.g.cancel_confirm_ll);
        this.bvf = this.bve.getText().toString();
        this.bvo = (LinearLayout) findViewById(e.g.cancel_dialog);
        this.bvq = (TextView) findViewById(e.g.sure_cancel);
        this.bvr = (TextView) findViewById(e.g.cancel_button);
        this.bvp = (TextView) findViewById(e.g.cancel_tip);
        this.bvq.setOnClickListener(this.bvv);
        this.bvr.setOnClickListener(this.bvw);
        if (com.baidu.adp.lib.b.d.iQ().aO("android_shouzhu_update") == 1) {
            this.bvx = true;
        } else {
            this.bvx = false;
        }
        String size = this.buV.getSize();
        String newVersion = this.buV.getNewVersion();
        String newVersionDesc = this.buV.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(e.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.c(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.bvc.setText(sb.toString());
        this.bvd.setText(newVersionDesc);
        if (this.buV.forceUpdate()) {
            this.bva = true;
            this.bvh.setText(this.mContext.getString(e.j.quit));
            this.bvi.setVisibility(8);
            this.bvk.setVisibility(8);
        } else if (this.buV.isOfficialVersion() && l.T(this.mContext, "com.tencent.android.qqdownloader")) {
            this.bvh.setVisibility(8);
        } else {
            this.bvh.setText(this.mContext.getString(e.j.update_after));
            this.bvi.setVisibility(8);
            this.bvk.setVisibility(8);
        }
        if (this.buW != null && this.buW.showCombineDownload() && !TextUtils.isEmpty(this.buW.getApkMD5RSA())) {
            this.bvg.setText(this.buW.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.buW.getAppProc()) && !TextUtils.isEmpty(this.buW.getAppUrl())) {
                this.bvg.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(e.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.bvg.setCompoundDrawables(drawable, null, null, null);
                this.buX = true;
            } else {
                this.bvg.setVisibility(8);
                this.buX = false;
            }
        } else {
            this.bvg.setVisibility(8);
            this.buX = false;
        }
        dk(this.bvx);
        this.bvj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                f.this.buZ = true;
                if (f.this.buY) {
                    Drawable drawable2 = al.getDrawable(e.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    f.this.bvg.setCompoundDrawables(drawable2, null, null, null);
                }
                f.this.bvu.dm(f.this.buY);
            }
        });
        this.bvl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bvy) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                f.this.bvl.setEnabled(false);
                f.this.bvu.dn(f.this.buY);
            }
        });
        this.bvh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bvu.TN();
            }
        });
        this.bvg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.buZ) {
                    if (f.this.buY) {
                        Drawable drawable2 = al.getDrawable(e.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        f.this.bvg.setCompoundDrawables(drawable2, null, null, null);
                        f.this.buX = false;
                        f.this.buY = false;
                        return;
                    }
                    Drawable drawable3 = al.getDrawable(e.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    f.this.bvg.setCompoundDrawables(drawable3, null, null, null);
                    f.this.buX = true;
                    f.this.buY = true;
                }
            }
        });
        TL();
    }

    private void TL() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void dk(boolean z) {
        if (h.a(this.mContext.getPackageManager())) {
            this.bvm.setVisibility(8);
        } else {
            this.bvm.setVisibility(0);
        }
        if (z) {
            if (this.buV == null || TextUtils.isEmpty(this.buV.getPatch()) || this.buV.getNewVersionCode() < 0) {
                this.bvn.setVisibility(0);
                this.bvl.setText(e.j.super_update);
                al.i(this.bvl, e.f.dialog_middle_item_bg_selector);
                this.bvt.setVisibility(0);
                this.bvy = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.bvn.setVisibility(0);
            this.bvl.setText(e.j.incremental_update);
            al.i(this.bvl, e.f.dialog_single_button_bg_selector);
            this.bvs.setVisibility(8);
            this.bvt.setVisibility(8);
            this.bvy = true;
            TiebaStatic.log("c10002");
        } else if (this.buV == null || TextUtils.isEmpty(this.buV.getPatch()) || this.buV.getNewVersionCode() < 0) {
            this.bvn.setVisibility(8);
            this.bvt.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.bvn.setVisibility(0);
            al.i(this.bvl, e.f.dialog_middle_item_bg_selector);
            this.bvl.setText(e.j.incremental_update);
            this.bvt.setVisibility(0);
            this.bvy = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void updateProgress(int i) {
        this.bvj.setVisibility(8);
        this.bvn.setVisibility(8);
        this.bvh.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.buZ = true;
        this.bvt.setVisibility(0);
        this.bve.setVisibility(0);
        this.bve.setText(this.bvf + i + "%");
        this.bvk.setVisibility(8);
        this.bvi.setVisibility(8);
    }

    public void dl(boolean z) {
        this.bvj.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.buZ) {
            this.bvu.stopService();
            this.bvb.setVisibility(8);
            if (this.bva) {
                this.bvp.setText(getContext().getString(e.j.download_exit));
            }
            this.bvo.setVisibility(0);
            return;
        }
        this.bvu.TO();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.buV = versionData;
        this.buW = combineDownload;
        this.bvu = aVar;
    }

    public void TM() {
        this.bvo.setVisibility(8);
        this.bvb.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.bvv = onClickListener;
    }

    public void g(View.OnClickListener onClickListener) {
        this.bvw = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(e.g.app_download_dialog_layout));
        }
        al.c(this.bvk, e.f.write_close_selector);
    }

    public void bU(Context context) {
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
