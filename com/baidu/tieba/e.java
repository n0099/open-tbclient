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
    private TextView aVC;
    private View aVD;
    private LinearLayout aVE;
    private a aVF;
    private View.OnClickListener aVG;
    private View.OnClickListener aVH;
    private boolean aVI;
    private boolean aVJ;
    private VersionData aVh;
    private CombineDownload aVi;
    private boolean aVj;
    private boolean aVk;
    private boolean aVl;
    private boolean aVm;
    private LinearLayout aVn;
    private TextView aVo;
    private TextView aVp;
    private TextView aVq;
    private String aVr;
    private TextView aVs;
    private TextView aVt;
    private TextView aVu;
    private View aVv;
    private TextView aVw;
    private TextView aVx;
    private View aVy;
    private LinearLayout aVz;
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
        this.aVj = false;
        this.aVk = true;
        this.aVl = false;
        this.aVm = false;
        this.aVI = true;
        this.aVJ = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.app_download_dialog);
        this.aVn = (LinearLayout) findViewById(d.h.app_info);
        this.aVo = (TextView) findViewById(d.h.app_version_and_size);
        this.aVp = (TextView) findViewById(d.h.app_description);
        this.aVu = (TextView) findViewById(d.h.fullsize_download_button);
        this.aVt = (TextView) findViewById(d.h.cancel_download_button);
        this.aVv = findViewById(d.h.divider_line);
        this.aVq = (TextView) findViewById(d.h.download_process);
        this.aVw = (TextView) findViewById(d.h.incremental_download_button);
        this.aVx = (TextView) findViewById(d.h.not_install_as_tip);
        this.aVy = findViewById(d.h.incremental_download_layout);
        this.aVs = (TextView) findViewById(d.h.other_app_recommend);
        this.aVD = findViewById(d.h.divider_under_button);
        this.aVE = (LinearLayout) findViewById(d.h.cancel_confirm_ll);
        this.aVr = this.aVq.getText().toString();
        this.aVz = (LinearLayout) findViewById(d.h.cancel_dialog);
        this.aVB = (TextView) findViewById(d.h.sure_cancel);
        this.aVC = (TextView) findViewById(d.h.cancel_button);
        this.aVA = (TextView) findViewById(d.h.cancel_tip);
        this.aVB.setOnClickListener(this.aVG);
        this.aVC.setOnClickListener(this.aVH);
        if (com.baidu.adp.lib.b.d.fh().am("android_shouzhu_update") == 1) {
            this.aVI = true;
        } else {
            this.aVI = false;
        }
        String size = this.aVh.getSize();
        String newVersion = this.aVh.getNewVersion();
        String newVersionDesc = this.aVh.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.l.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.b(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aVo.setText(sb.toString());
        this.aVp.setText(newVersionDesc);
        if (this.aVh.forceUpdate()) {
            this.aVm = true;
            this.aVt.setText(this.mContext.getString(d.l.quit));
        } else {
            this.aVt.setText(this.mContext.getString(d.l.update_after));
        }
        if (this.aVi != null && this.aVi.showCombineDownload() && !TextUtils.isEmpty(this.aVi.getApkMD5RSA())) {
            this.aVs.setText(this.aVi.getAppName());
            if (!s.isInstalledPackage(this.mContext, this.aVi.getAppProc()) && !TextUtils.isEmpty(this.aVi.getAppUrl())) {
                this.aVs.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.g.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aVs.setCompoundDrawables(drawable, null, null, null);
                this.aVj = true;
            } else {
                this.aVs.setVisibility(8);
                this.aVj = false;
            }
        } else {
            this.aVs.setVisibility(8);
            this.aVj = false;
        }
        cm(this.aVI);
        this.aVu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.aVu.setEnabled(false);
                e.this.aVl = true;
                if (e.this.aVk) {
                    Drawable drawable2 = ai.getDrawable(d.g.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.aVs.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.aVF.cn(e.this.aVk);
            }
        });
        this.aVw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aVJ) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.aVw.setEnabled(false);
                e.this.aVF.co(e.this.aVk);
            }
        });
        this.aVt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aVF.Kg();
            }
        });
        this.aVs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.aVl) {
                    if (e.this.aVk) {
                        Drawable drawable2 = ai.getDrawable(d.g.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.aVs.setCompoundDrawables(drawable2, null, null, null);
                        e.this.aVj = false;
                        e.this.aVk = false;
                        return;
                    }
                    Drawable drawable3 = ai.getDrawable(d.g.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.aVs.setCompoundDrawables(drawable3, null, null, null);
                    e.this.aVj = true;
                    e.this.aVk = true;
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
            this.aVx.setVisibility(8);
        } else {
            this.aVx.setVisibility(0);
        }
        if (z) {
            if (this.aVh == null || TextUtils.isEmpty(this.aVh.getPatch()) || this.aVh.getNewVersionCode() < 0) {
                this.aVy.setVisibility(0);
                this.aVw.setText(d.l.super_update);
                ai.j(this.aVw, d.g.dialog_middle_item_bg_selector);
                this.aVE.setVisibility(0);
                this.aVJ = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aVy.setVisibility(0);
            this.aVw.setText(d.l.incremental_update);
            ai.j(this.aVw, d.g.dialog_single_button_bg_selector);
            this.aVD.setVisibility(8);
            this.aVE.setVisibility(8);
            this.aVJ = true;
            TiebaStatic.log("c10002");
        } else if (this.aVh == null || TextUtils.isEmpty(this.aVh.getPatch()) || this.aVh.getNewVersionCode() < 0) {
            this.aVy.setVisibility(8);
            this.aVE.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aVy.setVisibility(0);
            ai.j(this.aVw, d.g.dialog_middle_item_bg_selector);
            this.aVw.setText(d.l.incremental_update);
            this.aVE.setVisibility(0);
            this.aVJ = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void fN(int i) {
        this.aVu.setVisibility(8);
        this.aVy.setVisibility(8);
        this.aVt.setVisibility(8);
        this.aVv.setVisibility(8);
        this.aVl = true;
        this.aVE.setVisibility(0);
        this.aVq.setVisibility(0);
        this.aVq.setText(this.aVr + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aVl) {
            this.aVF.stopService();
            this.aVn.setVisibility(8);
            if (this.aVm) {
                this.aVA.setText(getContext().getString(d.l.download_exit));
            }
            this.aVz.setVisibility(0);
            return;
        }
        this.aVF.Kh();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aVh = versionData;
        this.aVi = combineDownload;
        this.aVF = aVar;
    }

    public void Kf() {
        this.aVz.setVisibility(8);
        this.aVn.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.aVG = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.aVH = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ah(i == 1);
            tbPageContext.getLayoutMode().t(findViewById(d.h.app_download_dialog_layout));
        }
    }
}
