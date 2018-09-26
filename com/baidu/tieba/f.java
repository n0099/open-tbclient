package com.baidu.tieba;

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
    private a bqA;
    private View.OnClickListener bqB;
    private View.OnClickListener bqC;
    private boolean bqD;
    private boolean bqE;
    private VersionData bqb;
    private CombineDownload bqc;
    private boolean bqd;
    private boolean bqe;
    private boolean bqf;
    private boolean bqg;
    private LinearLayout bqh;
    private TextView bqi;
    private TextView bqj;
    private TextView bqk;
    private String bql;
    private TextView bqm;
    private TextView bqn;
    private TextView bqo;
    private TextView bqp;
    private ImageView bqq;
    private TextView bqr;
    private TextView bqs;
    private View bqt;
    private LinearLayout bqu;
    private TextView bqv;
    private TextView bqw;
    private TextView bqx;
    private View bqy;
    private LinearLayout bqz;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    interface a {
        void RI();

        void RJ();

        void cM(boolean z);

        void cN(boolean z);

        void stopService();
    }

    public f(Context context, int i) {
        super(context, i);
        this.bqd = false;
        this.bqe = true;
        this.bqf = false;
        this.bqg = false;
        this.bqD = true;
        this.bqE = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == f.this.bqo.getId()) {
                    f.this.bqA.RI();
                    f.this.bP(f.this.mContext);
                } else if (view.getId() == f.this.bqq.getId()) {
                    f.this.bqA.RI();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.app_download_dialog);
        this.bqh = (LinearLayout) findViewById(e.g.app_info);
        this.bqi = (TextView) findViewById(e.g.app_version_and_size);
        this.bqj = (TextView) findViewById(e.g.app_description);
        this.bqp = (TextView) findViewById(e.g.fullsize_download_button);
        this.bqn = (TextView) findViewById(e.g.cancel_download_button);
        this.bqo = (TextView) findViewById(e.g.btn_update_save_flow);
        this.bqq = (ImageView) findViewById(e.g.img_close);
        this.bqo.setOnClickListener(this.mOnClickListener);
        this.bqq.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(e.g.divider_line);
        this.bqk = (TextView) findViewById(e.g.download_process);
        this.bqr = (TextView) findViewById(e.g.incremental_download_button);
        this.bqs = (TextView) findViewById(e.g.not_install_as_tip);
        this.bqt = findViewById(e.g.incremental_download_layout);
        this.bqm = (TextView) findViewById(e.g.other_app_recommend);
        this.bqy = findViewById(e.g.divider_under_button);
        this.bqz = (LinearLayout) findViewById(e.g.cancel_confirm_ll);
        this.bql = this.bqk.getText().toString();
        this.bqu = (LinearLayout) findViewById(e.g.cancel_dialog);
        this.bqw = (TextView) findViewById(e.g.sure_cancel);
        this.bqx = (TextView) findViewById(e.g.cancel_button);
        this.bqv = (TextView) findViewById(e.g.cancel_tip);
        this.bqw.setOnClickListener(this.bqB);
        this.bqx.setOnClickListener(this.bqC);
        if (com.baidu.adp.lib.b.d.iB().aO("android_shouzhu_update") == 1) {
            this.bqD = true;
        } else {
            this.bqD = false;
        }
        String size = this.bqb.getSize();
        String newVersion = this.bqb.getNewVersion();
        String newVersionDesc = this.bqb.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(e.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.c(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.bqi.setText(sb.toString());
        this.bqj.setText(newVersionDesc);
        if (this.bqb.forceUpdate()) {
            this.bqg = true;
            this.bqn.setText(this.mContext.getString(e.j.quit));
            this.bqo.setVisibility(8);
            this.bqq.setVisibility(8);
        } else if (l.T(this.mContext, "com.tencent.android.qqdownloader")) {
            this.bqn.setVisibility(8);
        } else {
            this.bqn.setText(this.mContext.getString(e.j.update_after));
            this.bqo.setVisibility(8);
            this.bqq.setVisibility(8);
        }
        if (this.bqc != null && this.bqc.showCombineDownload() && !TextUtils.isEmpty(this.bqc.getApkMD5RSA())) {
            this.bqm.setText(this.bqc.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.bqc.getAppProc()) && !TextUtils.isEmpty(this.bqc.getAppUrl())) {
                this.bqm.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(e.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.bqm.setCompoundDrawables(drawable, null, null, null);
                this.bqd = true;
            } else {
                this.bqm.setVisibility(8);
                this.bqd = false;
            }
        } else {
            this.bqm.setVisibility(8);
            this.bqd = false;
        }
        cK(this.bqD);
        this.bqp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                f.this.bqf = true;
                if (f.this.bqe) {
                    Drawable drawable2 = al.getDrawable(e.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    f.this.bqm.setCompoundDrawables(drawable2, null, null, null);
                }
                f.this.bqA.cM(f.this.bqe);
            }
        });
        this.bqr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bqE) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                f.this.bqr.setEnabled(false);
                f.this.bqA.cN(f.this.bqe);
            }
        });
        this.bqn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bqA.RI();
            }
        });
        this.bqm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.bqf) {
                    if (f.this.bqe) {
                        Drawable drawable2 = al.getDrawable(e.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        f.this.bqm.setCompoundDrawables(drawable2, null, null, null);
                        f.this.bqd = false;
                        f.this.bqe = false;
                        return;
                    }
                    Drawable drawable3 = al.getDrawable(e.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    f.this.bqm.setCompoundDrawables(drawable3, null, null, null);
                    f.this.bqd = true;
                    f.this.bqe = true;
                }
            }
        });
        RG();
    }

    private void RG() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void cK(boolean z) {
        if (h.a(this.mContext.getPackageManager())) {
            this.bqs.setVisibility(8);
        } else {
            this.bqs.setVisibility(0);
        }
        if (z) {
            if (this.bqb == null || TextUtils.isEmpty(this.bqb.getPatch()) || this.bqb.getNewVersionCode() < 0) {
                this.bqt.setVisibility(0);
                this.bqr.setText(e.j.super_update);
                al.i(this.bqr, e.f.dialog_middle_item_bg_selector);
                this.bqz.setVisibility(0);
                this.bqE = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.bqt.setVisibility(0);
            this.bqr.setText(e.j.incremental_update);
            al.i(this.bqr, e.f.dialog_single_button_bg_selector);
            this.bqy.setVisibility(8);
            this.bqz.setVisibility(8);
            this.bqE = true;
            TiebaStatic.log("c10002");
        } else if (this.bqb == null || TextUtils.isEmpty(this.bqb.getPatch()) || this.bqb.getNewVersionCode() < 0) {
            this.bqt.setVisibility(8);
            this.bqz.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.bqt.setVisibility(0);
            al.i(this.bqr, e.f.dialog_middle_item_bg_selector);
            this.bqr.setText(e.j.incremental_update);
            this.bqz.setVisibility(0);
            this.bqE = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void updateProgress(int i) {
        this.bqp.setVisibility(8);
        this.bqt.setVisibility(8);
        this.bqn.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.bqf = true;
        this.bqz.setVisibility(0);
        this.bqk.setVisibility(0);
        this.bqk.setText(this.bql + i + "%");
    }

    public void cL(boolean z) {
        this.bqp.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.bqf) {
            this.bqA.stopService();
            this.bqh.setVisibility(8);
            if (this.bqg) {
                this.bqv.setText(getContext().getString(e.j.download_exit));
            }
            this.bqu.setVisibility(0);
            return;
        }
        this.bqA.RJ();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.bqb = versionData;
        this.bqc = combineDownload;
        this.bqA = aVar;
    }

    public void RH() {
        this.bqu.setVisibility(8);
        this.bqh.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.bqB = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.bqC = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(e.g.app_download_dialog_layout));
        }
        al.c(this.bqq, e.f.write_close_selector);
    }

    public void bP(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + context.getPackageName()));
        try {
            intent.setClassName("com.tencent.android.qqdownloader", "com.tencent.pangu.link.LinkProxyActivity");
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }
}
