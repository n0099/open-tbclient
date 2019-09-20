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
public class e extends Dialog {
    private VersionData cUZ;
    private View.OnClickListener cVA;
    private boolean cVB;
    private boolean cVC;
    private CombineDownload cVa;
    private boolean cVb;
    private boolean cVc;
    private boolean cVd;
    private boolean cVe;
    private LinearLayout cVf;
    private TextView cVg;
    private TextView cVh;
    private TextView cVi;
    private String cVj;
    private TextView cVk;
    private TextView cVl;
    private TextView cVm;
    private TextView cVn;
    private ImageView cVo;
    private TextView cVp;
    private TextView cVq;
    private View cVr;
    private LinearLayout cVs;
    private TextView cVt;
    private TextView cVu;
    private TextView cVv;
    private View cVw;
    private LinearLayout cVx;
    private a cVy;
    private View.OnClickListener cVz;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    interface a {
        void aCc();

        void aCd();

        void gk(boolean z);

        void gl(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.cVb = false;
        this.cVc = true;
        this.cVd = false;
        this.cVe = false;
        this.cVB = true;
        this.cVC = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.this.cVm.getId()) {
                    e.this.cVy.aCc();
                    e.this.cV(e.this.mContext);
                } else if (view.getId() == e.this.cVo.getId()) {
                    e.this.cVy.aCc();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.cVf = (LinearLayout) findViewById(R.id.app_info);
        this.cVg = (TextView) findViewById(R.id.app_version_and_size);
        this.cVh = (TextView) findViewById(R.id.app_description);
        this.cVn = (TextView) findViewById(R.id.fullsize_download_button);
        this.cVl = (TextView) findViewById(R.id.cancel_download_button);
        this.cVm = (TextView) findViewById(R.id.btn_update_save_flow);
        this.cVo = (ImageView) findViewById(R.id.img_close);
        this.cVm.setOnClickListener(this.mOnClickListener);
        this.cVo.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.cVi = (TextView) findViewById(R.id.download_process);
        this.cVp = (TextView) findViewById(R.id.incremental_download_button);
        this.cVq = (TextView) findViewById(R.id.not_install_as_tip);
        this.cVr = findViewById(R.id.incremental_download_layout);
        this.cVk = (TextView) findViewById(R.id.other_app_recommend);
        this.cVw = findViewById(R.id.divider_under_button);
        this.cVx = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.cVj = this.cVi.getText().toString();
        this.cVs = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.cVu = (TextView) findViewById(R.id.sure_cancel);
        this.cVv = (TextView) findViewById(R.id.cancel_button);
        this.cVt = (TextView) findViewById(R.id.cancel_tip);
        this.cVu.setOnClickListener(this.cVz);
        this.cVv.setOnClickListener(this.cVA);
        if (com.baidu.adp.lib.b.d.hS().az("android_shouzhu_update") == 1) {
            this.cVB = true;
        } else {
            this.cVB = false;
        }
        String size = this.cUZ.getSize();
        String newVersion = this.cUZ.getNewVersion();
        String newVersionDesc = this.cUZ.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.c(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.cVg.setText(sb.toString());
        this.cVh.setText(newVersionDesc);
        if (this.cUZ.forceUpdate()) {
            this.cVe = true;
            this.cVl.setText(this.mContext.getString(R.string.quit));
            this.cVm.setVisibility(8);
            this.cVo.setVisibility(8);
        } else if (this.cUZ.isOfficialVersion() && l.F(this.mContext, "com.tencent.android.qqdownloader")) {
            this.cVl.setVisibility(8);
        } else {
            this.cVl.setText(this.mContext.getString(R.string.update_after));
            this.cVm.setVisibility(8);
            this.cVo.setVisibility(8);
        }
        if (this.cVa != null && this.cVa.showCombineDownload() && !TextUtils.isEmpty(this.cVa.getApkMD5RSA())) {
            this.cVk.setText(this.cVa.getAppName());
            if (!w.isInstalledPackage(this.mContext, this.cVa.getAppProc()) && !TextUtils.isEmpty(this.cVa.getAppUrl())) {
                this.cVk.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.cVk.setCompoundDrawables(drawable, null, null, null);
                this.cVb = true;
            } else {
                this.cVk.setVisibility(8);
                this.cVb = false;
            }
        } else {
            this.cVk.setVisibility(8);
            this.cVb = false;
        }
        gi(this.cVB);
        this.cVn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                e.this.cVd = true;
                if (e.this.cVc) {
                    Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.cVk.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.cVy.gk(e.this.cVc);
            }
        });
        this.cVp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cVC) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                e.this.cVp.setEnabled(false);
                e.this.cVy.gl(e.this.cVc);
            }
        });
        this.cVl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cVy.aCc();
            }
        });
        this.cVk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.cVd) {
                    if (e.this.cVc) {
                        Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.cVk.setCompoundDrawables(drawable2, null, null, null);
                        e.this.cVb = false;
                        e.this.cVc = false;
                        return;
                    }
                    Drawable drawable3 = am.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.cVk.setCompoundDrawables(drawable3, null, null, null);
                    e.this.cVb = true;
                    e.this.cVc = true;
                }
            }
        });
        aCa();
    }

    private void aCa() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void gi(boolean z) {
        if (g.a(this.mContext.getPackageManager())) {
            this.cVq.setVisibility(8);
        } else {
            this.cVq.setVisibility(0);
        }
        if (z) {
            if (this.cUZ == null || TextUtils.isEmpty(this.cUZ.getPatch()) || this.cUZ.getNewVersionCode() < 0) {
                this.cVr.setVisibility(0);
                this.cVp.setText(R.string.super_update);
                am.k(this.cVp, R.drawable.dialog_middle_item_bg_selector);
                this.cVx.setVisibility(0);
                this.cVC = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.cVr.setVisibility(0);
            this.cVp.setText(R.string.incremental_update);
            am.k(this.cVp, R.drawable.dialog_single_button_bg_selector);
            this.cVw.setVisibility(8);
            this.cVx.setVisibility(8);
            this.cVC = true;
            TiebaStatic.log("c10002");
        } else if (this.cUZ == null || TextUtils.isEmpty(this.cUZ.getPatch()) || this.cUZ.getNewVersionCode() < 0) {
            this.cVr.setVisibility(8);
            this.cVx.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.cVr.setVisibility(0);
            am.k(this.cVp, R.drawable.dialog_middle_item_bg_selector);
            this.cVp.setText(R.string.incremental_update);
            this.cVx.setVisibility(0);
            this.cVC = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void updateProgress(int i) {
        this.cVn.setVisibility(8);
        this.cVr.setVisibility(8);
        this.cVl.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.cVd = true;
        this.cVx.setVisibility(0);
        this.cVi.setVisibility(0);
        this.cVi.setText(this.cVj + i + "%");
        this.cVo.setVisibility(8);
        this.cVm.setVisibility(8);
    }

    public void gj(boolean z) {
        this.cVn.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.cVd) {
            this.cVy.stopService();
            this.cVf.setVisibility(8);
            if (this.cVe) {
                this.cVt.setText(getContext().getString(R.string.download_exit));
            }
            this.cVs.setVisibility(0);
            return;
        }
        this.cVy.aCd();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.cUZ = versionData;
        this.cVa = combineDownload;
        this.cVy = aVar;
    }

    public void aCb() {
        this.cVs.setVisibility(8);
        this.cVf.setVisibility(0);
    }

    public void g(View.OnClickListener onClickListener) {
        this.cVz = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.cVA = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        am.c(this.cVo, (int) R.drawable.write_close_selector);
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
