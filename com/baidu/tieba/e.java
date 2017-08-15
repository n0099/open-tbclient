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
    private TextView aVB;
    private View aVC;
    private LinearLayout aVD;
    private a aVE;
    private View.OnClickListener aVF;
    private View.OnClickListener aVG;
    private boolean aVH;
    private boolean aVI;
    private VersionData aVg;
    private CombineDownload aVh;
    private boolean aVi;
    private boolean aVj;
    private boolean aVk;
    private boolean aVl;
    private LinearLayout aVm;
    private TextView aVn;
    private TextView aVo;
    private TextView aVp;
    private String aVq;
    private TextView aVr;
    private TextView aVs;
    private TextView aVt;
    private View aVu;
    private TextView aVv;
    private TextView aVw;
    private View aVx;
    private LinearLayout aVy;
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
        this.aVi = false;
        this.aVj = true;
        this.aVk = false;
        this.aVl = false;
        this.aVH = true;
        this.aVI = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.app_download_dialog);
        this.aVm = (LinearLayout) findViewById(d.h.app_info);
        this.aVn = (TextView) findViewById(d.h.app_version_and_size);
        this.aVo = (TextView) findViewById(d.h.app_description);
        this.aVt = (TextView) findViewById(d.h.fullsize_download_button);
        this.aVs = (TextView) findViewById(d.h.cancel_download_button);
        this.aVu = findViewById(d.h.divider_line);
        this.aVp = (TextView) findViewById(d.h.download_process);
        this.aVv = (TextView) findViewById(d.h.incremental_download_button);
        this.aVw = (TextView) findViewById(d.h.not_install_as_tip);
        this.aVx = findViewById(d.h.incremental_download_layout);
        this.aVr = (TextView) findViewById(d.h.other_app_recommend);
        this.aVC = findViewById(d.h.divider_under_button);
        this.aVD = (LinearLayout) findViewById(d.h.cancel_confirm_ll);
        this.aVq = this.aVp.getText().toString();
        this.aVy = (LinearLayout) findViewById(d.h.cancel_dialog);
        this.aVA = (TextView) findViewById(d.h.sure_cancel);
        this.aVB = (TextView) findViewById(d.h.cancel_button);
        this.aVz = (TextView) findViewById(d.h.cancel_tip);
        this.aVA.setOnClickListener(this.aVF);
        this.aVB.setOnClickListener(this.aVG);
        if (com.baidu.adp.lib.b.d.fh().al("android_shouzhu_update") == 1) {
            this.aVH = true;
        } else {
            this.aVH = false;
        }
        String size = this.aVg.getSize();
        String newVersion = this.aVg.getNewVersion();
        String newVersionDesc = this.aVg.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.l.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aVn.setText(sb.toString());
        this.aVo.setText(newVersionDesc);
        if (this.aVg.forceUpdate()) {
            this.aVl = true;
            this.aVs.setText(this.mContext.getString(d.l.quit));
        } else {
            this.aVs.setText(this.mContext.getString(d.l.update_after));
        }
        if (this.aVh != null && this.aVh.showCombineDownload() && !TextUtils.isEmpty(this.aVh.getApkMD5RSA())) {
            this.aVr.setText(this.aVh.getAppName());
            if (!s.isInstalledPackage(this.mContext, this.aVh.getAppProc()) && !TextUtils.isEmpty(this.aVh.getAppUrl())) {
                this.aVr.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.g.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aVr.setCompoundDrawables(drawable, null, null, null);
                this.aVi = true;
            } else {
                this.aVr.setVisibility(8);
                this.aVi = false;
            }
        } else {
            this.aVr.setVisibility(8);
            this.aVi = false;
        }
        cm(this.aVH);
        this.aVt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.aVt.setEnabled(false);
                e.this.aVk = true;
                if (e.this.aVj) {
                    Drawable drawable2 = ai.getDrawable(d.g.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.aVr.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.aVE.cn(e.this.aVj);
            }
        });
        this.aVv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aVI) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.aVv.setEnabled(false);
                e.this.aVE.co(e.this.aVj);
            }
        });
        this.aVs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aVE.Kg();
            }
        });
        this.aVr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.aVk) {
                    if (e.this.aVj) {
                        Drawable drawable2 = ai.getDrawable(d.g.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.aVr.setCompoundDrawables(drawable2, null, null, null);
                        e.this.aVi = false;
                        e.this.aVj = false;
                        return;
                    }
                    Drawable drawable3 = ai.getDrawable(d.g.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.aVr.setCompoundDrawables(drawable3, null, null, null);
                    e.this.aVi = true;
                    e.this.aVj = true;
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
            this.aVw.setVisibility(8);
        } else {
            this.aVw.setVisibility(0);
        }
        if (z) {
            if (this.aVg == null || TextUtils.isEmpty(this.aVg.getPatch()) || this.aVg.getNewVersionCode() < 0) {
                this.aVx.setVisibility(0);
                this.aVv.setText(d.l.super_update);
                ai.j(this.aVv, d.g.dialog_middle_item_bg_selector);
                this.aVD.setVisibility(0);
                this.aVI = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aVx.setVisibility(0);
            this.aVv.setText(d.l.incremental_update);
            ai.j(this.aVv, d.g.dialog_single_button_bg_selector);
            this.aVC.setVisibility(8);
            this.aVD.setVisibility(8);
            this.aVI = true;
            TiebaStatic.log("c10002");
        } else if (this.aVg == null || TextUtils.isEmpty(this.aVg.getPatch()) || this.aVg.getNewVersionCode() < 0) {
            this.aVx.setVisibility(8);
            this.aVD.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aVx.setVisibility(0);
            ai.j(this.aVv, d.g.dialog_middle_item_bg_selector);
            this.aVv.setText(d.l.incremental_update);
            this.aVD.setVisibility(0);
            this.aVI = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void fN(int i) {
        this.aVt.setVisibility(8);
        this.aVx.setVisibility(8);
        this.aVs.setVisibility(8);
        this.aVu.setVisibility(8);
        this.aVk = true;
        this.aVD.setVisibility(0);
        this.aVp.setVisibility(0);
        this.aVp.setText(this.aVq + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aVk) {
            this.aVE.stopService();
            this.aVm.setVisibility(8);
            if (this.aVl) {
                this.aVz.setText(getContext().getString(d.l.download_exit));
            }
            this.aVy.setVisibility(0);
            return;
        }
        this.aVE.Kh();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aVg = versionData;
        this.aVh = combineDownload;
        this.aVE = aVar;
    }

    public void Kf() {
        this.aVy.setVisibility(8);
        this.aVm.setVisibility(0);
    }

    public void i(View.OnClickListener onClickListener) {
        this.aVF = onClickListener;
    }

    public void j(View.OnClickListener onClickListener) {
        this.aVG = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ah(i == 1);
            tbPageContext.getLayoutMode().t(findViewById(d.h.app_download_dialog_layout));
        }
    }
}
