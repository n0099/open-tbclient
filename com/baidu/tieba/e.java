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
    private TextView aVA;
    private View aVB;
    private LinearLayout aVC;
    private a aVD;
    private View.OnClickListener aVE;
    private View.OnClickListener aVF;
    private boolean aVG;
    private boolean aVH;
    private VersionData aVf;
    private CombineDownload aVg;
    private boolean aVh;
    private boolean aVi;
    private boolean aVj;
    private boolean aVk;
    private LinearLayout aVl;
    private TextView aVm;
    private TextView aVn;
    private TextView aVo;
    private String aVp;
    private TextView aVq;
    private TextView aVr;
    private TextView aVs;
    private View aVt;
    private TextView aVu;
    private TextView aVv;
    private View aVw;
    private LinearLayout aVx;
    private TextView aVy;
    private TextView aVz;
    private Context mContext;

    /* loaded from: classes.dex */
    interface a {
        void Kg();

        void Kh();

        void cn(boolean z);

        void co(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.aVh = false;
        this.aVi = true;
        this.aVj = false;
        this.aVk = false;
        this.aVG = true;
        this.aVH = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.app_download_dialog);
        this.aVl = (LinearLayout) findViewById(d.h.app_info);
        this.aVm = (TextView) findViewById(d.h.app_version_and_size);
        this.aVn = (TextView) findViewById(d.h.app_description);
        this.aVs = (TextView) findViewById(d.h.fullsize_download_button);
        this.aVr = (TextView) findViewById(d.h.cancel_download_button);
        this.aVt = findViewById(d.h.divider_line);
        this.aVo = (TextView) findViewById(d.h.download_process);
        this.aVu = (TextView) findViewById(d.h.incremental_download_button);
        this.aVv = (TextView) findViewById(d.h.not_install_as_tip);
        this.aVw = findViewById(d.h.incremental_download_layout);
        this.aVq = (TextView) findViewById(d.h.other_app_recommend);
        this.aVB = findViewById(d.h.divider_under_button);
        this.aVC = (LinearLayout) findViewById(d.h.cancel_confirm_ll);
        this.aVp = this.aVo.getText().toString();
        this.aVx = (LinearLayout) findViewById(d.h.cancel_dialog);
        this.aVz = (TextView) findViewById(d.h.sure_cancel);
        this.aVA = (TextView) findViewById(d.h.cancel_button);
        this.aVy = (TextView) findViewById(d.h.cancel_tip);
        this.aVz.setOnClickListener(this.aVE);
        this.aVA.setOnClickListener(this.aVF);
        if (com.baidu.adp.lib.b.d.fh().al("android_shouzhu_update") == 1) {
            this.aVG = true;
        } else {
            this.aVG = false;
        }
        String size = this.aVf.getSize();
        String newVersion = this.aVf.getNewVersion();
        String newVersionDesc = this.aVf.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.l.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aVm.setText(sb.toString());
        this.aVn.setText(newVersionDesc);
        if (this.aVf.forceUpdate()) {
            this.aVk = true;
            this.aVr.setText(this.mContext.getString(d.l.quit));
        } else {
            this.aVr.setText(this.mContext.getString(d.l.update_after));
        }
        if (this.aVg != null && this.aVg.showCombineDownload() && !TextUtils.isEmpty(this.aVg.getApkMD5RSA())) {
            this.aVq.setText(this.aVg.getAppName());
            if (!s.isInstalledPackage(this.mContext, this.aVg.getAppProc()) && !TextUtils.isEmpty(this.aVg.getAppUrl())) {
                this.aVq.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.g.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aVq.setCompoundDrawables(drawable, null, null, null);
                this.aVh = true;
            } else {
                this.aVq.setVisibility(8);
                this.aVh = false;
            }
        } else {
            this.aVq.setVisibility(8);
            this.aVh = false;
        }
        cm(this.aVG);
        this.aVs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.aVs.setEnabled(false);
                e.this.aVj = true;
                if (e.this.aVi) {
                    Drawable drawable2 = ai.getDrawable(d.g.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.aVq.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.aVD.cn(e.this.aVi);
            }
        });
        this.aVu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aVH) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.aVu.setEnabled(false);
                e.this.aVD.co(e.this.aVi);
            }
        });
        this.aVr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aVD.Kg();
            }
        });
        this.aVq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.aVj) {
                    if (e.this.aVi) {
                        Drawable drawable2 = ai.getDrawable(d.g.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.aVq.setCompoundDrawables(drawable2, null, null, null);
                        e.this.aVh = false;
                        e.this.aVi = false;
                        return;
                    }
                    Drawable drawable3 = ai.getDrawable(d.g.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.aVq.setCompoundDrawables(drawable3, null, null, null);
                    e.this.aVh = true;
                    e.this.aVi = true;
                }
            }
        });
        Ke();
    }

    private void Ke() {
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
            this.aVv.setVisibility(8);
        } else {
            this.aVv.setVisibility(0);
        }
        if (z) {
            if (this.aVf == null || TextUtils.isEmpty(this.aVf.getPatch()) || this.aVf.getNewVersionCode() < 0) {
                this.aVw.setVisibility(0);
                this.aVu.setText(d.l.super_update);
                ai.j(this.aVu, d.g.dialog_middle_item_bg_selector);
                this.aVC.setVisibility(0);
                this.aVH = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aVw.setVisibility(0);
            this.aVu.setText(d.l.incremental_update);
            ai.j(this.aVu, d.g.dialog_single_button_bg_selector);
            this.aVB.setVisibility(8);
            this.aVC.setVisibility(8);
            this.aVH = true;
            TiebaStatic.log("c10002");
        } else if (this.aVf == null || TextUtils.isEmpty(this.aVf.getPatch()) || this.aVf.getNewVersionCode() < 0) {
            this.aVw.setVisibility(8);
            this.aVC.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aVw.setVisibility(0);
            ai.j(this.aVu, d.g.dialog_middle_item_bg_selector);
            this.aVu.setText(d.l.incremental_update);
            this.aVC.setVisibility(0);
            this.aVH = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void fN(int i) {
        this.aVs.setVisibility(8);
        this.aVw.setVisibility(8);
        this.aVr.setVisibility(8);
        this.aVt.setVisibility(8);
        this.aVj = true;
        this.aVC.setVisibility(0);
        this.aVo.setVisibility(0);
        this.aVo.setText(this.aVp + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aVj) {
            this.aVD.stopService();
            this.aVl.setVisibility(8);
            if (this.aVk) {
                this.aVy.setText(getContext().getString(d.l.download_exit));
            }
            this.aVx.setVisibility(0);
            return;
        }
        this.aVD.Kh();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aVf = versionData;
        this.aVg = combineDownload;
        this.aVD = aVar;
    }

    public void Kf() {
        this.aVx.setVisibility(8);
        this.aVl.setVisibility(0);
    }

    public void i(View.OnClickListener onClickListener) {
        this.aVE = onClickListener;
    }

    public void j(View.OnClickListener onClickListener) {
        this.aVF = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ah(i == 1);
            tbPageContext.getLayoutMode().t(findViewById(d.h.app_download_dialog_layout));
        }
    }
}
