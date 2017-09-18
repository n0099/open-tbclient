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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes.dex */
public class e extends Dialog {
    private VersionData aUN;
    private CombineDownload aUO;
    private boolean aUP;
    private boolean aUQ;
    private boolean aUR;
    private boolean aUS;
    private LinearLayout aUT;
    private TextView aUU;
    private TextView aUV;
    private TextView aUW;
    private String aUX;
    private TextView aUY;
    private TextView aUZ;
    private TextView aVa;
    private View aVb;
    private TextView aVc;
    private TextView aVd;
    private View aVe;
    private LinearLayout aVf;
    private TextView aVg;
    private TextView aVh;
    private TextView aVi;
    private View aVj;
    private LinearLayout aVk;
    private a aVl;
    private View.OnClickListener aVm;
    private View.OnClickListener aVn;
    private boolean aVo;
    private boolean aVp;
    private Context mContext;

    /* loaded from: classes.dex */
    interface a {
        void Kp();

        void Kq();

        void co(boolean z);

        void cp(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.aUP = false;
        this.aUQ = true;
        this.aUR = false;
        this.aUS = false;
        this.aVo = true;
        this.aVp = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.app_download_dialog);
        this.aUT = (LinearLayout) findViewById(d.h.app_info);
        this.aUU = (TextView) findViewById(d.h.app_version_and_size);
        this.aUV = (TextView) findViewById(d.h.app_description);
        this.aVa = (TextView) findViewById(d.h.fullsize_download_button);
        this.aUZ = (TextView) findViewById(d.h.cancel_download_button);
        this.aVb = findViewById(d.h.divider_line);
        this.aUW = (TextView) findViewById(d.h.download_process);
        this.aVc = (TextView) findViewById(d.h.incremental_download_button);
        this.aVd = (TextView) findViewById(d.h.not_install_as_tip);
        this.aVe = findViewById(d.h.incremental_download_layout);
        this.aUY = (TextView) findViewById(d.h.other_app_recommend);
        this.aVj = findViewById(d.h.divider_under_button);
        this.aVk = (LinearLayout) findViewById(d.h.cancel_confirm_ll);
        this.aUX = this.aUW.getText().toString();
        this.aVf = (LinearLayout) findViewById(d.h.cancel_dialog);
        this.aVh = (TextView) findViewById(d.h.sure_cancel);
        this.aVi = (TextView) findViewById(d.h.cancel_button);
        this.aVg = (TextView) findViewById(d.h.cancel_tip);
        this.aVh.setOnClickListener(this.aVm);
        this.aVi.setOnClickListener(this.aVn);
        if (com.baidu.adp.lib.b.d.eW().af("android_shouzhu_update") == 1) {
            this.aVo = true;
        } else {
            this.aVo = false;
        }
        String size = this.aUN.getSize();
        String newVersion = this.aUN.getNewVersion();
        String newVersionDesc = this.aUN.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.l.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aUU.setText(sb.toString());
        this.aUV.setText(newVersionDesc);
        if (this.aUN.forceUpdate()) {
            this.aUS = true;
            this.aUZ.setText(this.mContext.getString(d.l.quit));
        } else {
            this.aUZ.setText(this.mContext.getString(d.l.update_after));
        }
        if (this.aUO != null && this.aUO.showCombineDownload() && !TextUtils.isEmpty(this.aUO.getApkMD5RSA())) {
            this.aUY.setText(this.aUO.getAppName());
            if (!s.isInstalledPackage(this.mContext, this.aUO.getAppProc()) && !TextUtils.isEmpty(this.aUO.getAppUrl())) {
                this.aUY.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.g.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aUY.setCompoundDrawables(drawable, null, null, null);
                this.aUP = true;
            } else {
                this.aUY.setVisibility(8);
                this.aUP = false;
            }
        } else {
            this.aUY.setVisibility(8);
            this.aUP = false;
        }
        cn(this.aVo);
        this.aVa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.aVa.setEnabled(false);
                e.this.aUR = true;
                if (e.this.aUQ) {
                    Drawable drawable2 = aj.getDrawable(d.g.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.aUY.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.aVl.co(e.this.aUQ);
            }
        });
        this.aVc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aVp) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.aVc.setEnabled(false);
                e.this.aVl.cp(e.this.aUQ);
            }
        });
        this.aUZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aVl.Kp();
            }
        });
        this.aUY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.aUR) {
                    if (e.this.aUQ) {
                        Drawable drawable2 = aj.getDrawable(d.g.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.aUY.setCompoundDrawables(drawable2, null, null, null);
                        e.this.aUP = false;
                        e.this.aUQ = false;
                        return;
                    }
                    Drawable drawable3 = aj.getDrawable(d.g.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.aUY.setCompoundDrawables(drawable3, null, null, null);
                    e.this.aUP = true;
                    e.this.aUQ = true;
                }
            }
        });
        Kn();
    }

    private void Kn() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void cn(boolean z) {
        if (g.b(this.mContext.getPackageManager())) {
            this.aVd.setVisibility(8);
        } else {
            this.aVd.setVisibility(0);
        }
        if (z) {
            if (this.aUN == null || TextUtils.isEmpty(this.aUN.getPatch()) || this.aUN.getNewVersionCode() < 0) {
                this.aVe.setVisibility(0);
                this.aVc.setText(d.l.super_update);
                aj.j(this.aVc, d.g.dialog_middle_item_bg_selector);
                this.aVk.setVisibility(0);
                this.aVp = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aVe.setVisibility(0);
            this.aVc.setText(d.l.incremental_update);
            aj.j(this.aVc, d.g.dialog_single_button_bg_selector);
            this.aVj.setVisibility(8);
            this.aVk.setVisibility(8);
            this.aVp = true;
            TiebaStatic.log("c10002");
        } else if (this.aUN == null || TextUtils.isEmpty(this.aUN.getPatch()) || this.aUN.getNewVersionCode() < 0) {
            this.aVe.setVisibility(8);
            this.aVk.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aVe.setVisibility(0);
            aj.j(this.aVc, d.g.dialog_middle_item_bg_selector);
            this.aVc.setText(d.l.incremental_update);
            this.aVk.setVisibility(0);
            this.aVp = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void fO(int i) {
        this.aVa.setVisibility(8);
        this.aVe.setVisibility(8);
        this.aUZ.setVisibility(8);
        this.aVb.setVisibility(8);
        this.aUR = true;
        this.aVk.setVisibility(0);
        this.aUW.setVisibility(0);
        this.aUW.setText(this.aUX + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aUR) {
            this.aVl.stopService();
            this.aUT.setVisibility(8);
            if (this.aUS) {
                this.aVg.setText(getContext().getString(d.l.download_exit));
            }
            this.aVf.setVisibility(0);
            return;
        }
        this.aVl.Kq();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aUN = versionData;
        this.aUO = combineDownload;
        this.aVl = aVar;
    }

    public void Ko() {
        this.aVf.setVisibility(8);
        this.aUT.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.aVm = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.aVn = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ah(i == 1);
            tbPageContext.getLayoutMode().t(findViewById(d.h.app_download_dialog_layout));
        }
    }
}
