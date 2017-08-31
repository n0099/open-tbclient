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
    private VersionData aUQ;
    private CombineDownload aUR;
    private boolean aUS;
    private boolean aUT;
    private boolean aUU;
    private boolean aUV;
    private LinearLayout aUW;
    private TextView aUX;
    private TextView aUY;
    private TextView aUZ;
    private String aVa;
    private TextView aVb;
    private TextView aVc;
    private TextView aVd;
    private View aVe;
    private TextView aVf;
    private TextView aVg;
    private View aVh;
    private LinearLayout aVi;
    private TextView aVj;
    private TextView aVk;
    private TextView aVl;
    private View aVm;
    private LinearLayout aVn;
    private a aVo;
    private View.OnClickListener aVp;
    private View.OnClickListener aVq;
    private boolean aVr;
    private boolean aVs;
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
        this.aUS = false;
        this.aUT = true;
        this.aUU = false;
        this.aUV = false;
        this.aVr = true;
        this.aVs = true;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.app_download_dialog);
        this.aUW = (LinearLayout) findViewById(d.h.app_info);
        this.aUX = (TextView) findViewById(d.h.app_version_and_size);
        this.aUY = (TextView) findViewById(d.h.app_description);
        this.aVd = (TextView) findViewById(d.h.fullsize_download_button);
        this.aVc = (TextView) findViewById(d.h.cancel_download_button);
        this.aVe = findViewById(d.h.divider_line);
        this.aUZ = (TextView) findViewById(d.h.download_process);
        this.aVf = (TextView) findViewById(d.h.incremental_download_button);
        this.aVg = (TextView) findViewById(d.h.not_install_as_tip);
        this.aVh = findViewById(d.h.incremental_download_layout);
        this.aVb = (TextView) findViewById(d.h.other_app_recommend);
        this.aVm = findViewById(d.h.divider_under_button);
        this.aVn = (LinearLayout) findViewById(d.h.cancel_confirm_ll);
        this.aVa = this.aUZ.getText().toString();
        this.aVi = (LinearLayout) findViewById(d.h.cancel_dialog);
        this.aVk = (TextView) findViewById(d.h.sure_cancel);
        this.aVl = (TextView) findViewById(d.h.cancel_button);
        this.aVj = (TextView) findViewById(d.h.cancel_tip);
        this.aVk.setOnClickListener(this.aVp);
        this.aVl.setOnClickListener(this.aVq);
        if (com.baidu.adp.lib.b.d.eW().af("android_shouzhu_update") == 1) {
            this.aVr = true;
        } else {
            this.aVr = false;
        }
        String size = this.aUQ.getSize();
        String newVersion = this.aUQ.getNewVersion();
        String newVersionDesc = this.aUQ.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(d.l.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.aUX.setText(sb.toString());
        this.aUY.setText(newVersionDesc);
        if (this.aUQ.forceUpdate()) {
            this.aUV = true;
            this.aVc.setText(this.mContext.getString(d.l.quit));
        } else {
            this.aVc.setText(this.mContext.getString(d.l.update_after));
        }
        if (this.aUR != null && this.aUR.showCombineDownload() && !TextUtils.isEmpty(this.aUR.getApkMD5RSA())) {
            this.aVb.setText(this.aUR.getAppName());
            if (!s.isInstalledPackage(this.mContext, this.aUR.getAppProc()) && !TextUtils.isEmpty(this.aUR.getAppUrl())) {
                this.aVb.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(d.g.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.aVb.setCompoundDrawables(drawable, null, null, null);
                this.aUS = true;
            } else {
                this.aVb.setVisibility(8);
                this.aUS = false;
            }
        } else {
            this.aVb.setVisibility(8);
            this.aUS = false;
        }
        cn(this.aVr);
        this.aVd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.aVd.setEnabled(false);
                e.this.aUU = true;
                if (e.this.aUT) {
                    Drawable drawable2 = aj.getDrawable(d.g.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.aVb.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.aVo.co(e.this.aUT);
            }
        });
        this.aVf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aVs) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.aVf.setEnabled(false);
                e.this.aVo.cp(e.this.aUT);
            }
        });
        this.aVc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aVo.Kp();
            }
        });
        this.aVb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.aUU) {
                    if (e.this.aUT) {
                        Drawable drawable2 = aj.getDrawable(d.g.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.aVb.setCompoundDrawables(drawable2, null, null, null);
                        e.this.aUS = false;
                        e.this.aUT = false;
                        return;
                    }
                    Drawable drawable3 = aj.getDrawable(d.g.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.aVb.setCompoundDrawables(drawable3, null, null, null);
                    e.this.aUS = true;
                    e.this.aUT = true;
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
            this.aVg.setVisibility(8);
        } else {
            this.aVg.setVisibility(0);
        }
        if (z) {
            if (this.aUQ == null || TextUtils.isEmpty(this.aUQ.getPatch()) || this.aUQ.getNewVersionCode() < 0) {
                this.aVh.setVisibility(0);
                this.aVf.setText(d.l.super_update);
                aj.j(this.aVf, d.g.dialog_middle_item_bg_selector);
                this.aVn.setVisibility(0);
                this.aVs = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.aVh.setVisibility(0);
            this.aVf.setText(d.l.incremental_update);
            aj.j(this.aVf, d.g.dialog_single_button_bg_selector);
            this.aVm.setVisibility(8);
            this.aVn.setVisibility(8);
            this.aVs = true;
            TiebaStatic.log("c10002");
        } else if (this.aUQ == null || TextUtils.isEmpty(this.aUQ.getPatch()) || this.aUQ.getNewVersionCode() < 0) {
            this.aVh.setVisibility(8);
            this.aVn.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.aVh.setVisibility(0);
            aj.j(this.aVf, d.g.dialog_middle_item_bg_selector);
            this.aVf.setText(d.l.incremental_update);
            this.aVn.setVisibility(0);
            this.aVs = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void fO(int i) {
        this.aVd.setVisibility(8);
        this.aVh.setVisibility(8);
        this.aVc.setVisibility(8);
        this.aVe.setVisibility(8);
        this.aUU = true;
        this.aVn.setVisibility(0);
        this.aUZ.setVisibility(0);
        this.aUZ.setText(this.aVa + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.aUU) {
            this.aVo.stopService();
            this.aUW.setVisibility(8);
            if (this.aUV) {
                this.aVj.setText(getContext().getString(d.l.download_exit));
            }
            this.aVi.setVisibility(0);
            return;
        }
        this.aVo.Kq();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.aUQ = versionData;
        this.aUR = combineDownload;
        this.aVo = aVar;
    }

    public void Ko() {
        this.aVi.setVisibility(8);
        this.aUW.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.aVp = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.aVq = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ah(i == 1);
            tbPageContext.getLayoutMode().t(findViewById(d.h.app_download_dialog_layout));
        }
    }
}
