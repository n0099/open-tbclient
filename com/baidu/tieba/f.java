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
    private TextView byA;
    private TextView byB;
    private String byC;
    private TextView byD;
    private TextView byE;
    private TextView byF;
    private TextView byG;
    private ImageView byH;
    private TextView byI;
    private TextView byJ;
    private View byK;
    private LinearLayout byL;
    private TextView byM;
    private TextView byN;
    private TextView byO;
    private View byP;
    private LinearLayout byQ;
    private a byR;
    private View.OnClickListener byS;
    private View.OnClickListener byT;
    private boolean byU;
    private boolean byV;
    private VersionData bys;
    private CombineDownload byt;
    private boolean byu;
    private boolean byv;
    private boolean byw;
    private boolean byx;
    private LinearLayout byy;
    private TextView byz;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    interface a {
        void UT();

        void UU();

        void dn(boolean z);

        /* renamed from: do */
        void mo18do(boolean z);

        void stopService();
    }

    public f(Context context, int i) {
        super(context, i);
        this.byu = false;
        this.byv = true;
        this.byw = false;
        this.byx = false;
        this.byU = true;
        this.byV = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == f.this.byF.getId()) {
                    f.this.byR.UT();
                    f.this.bX(f.this.mContext);
                } else if (view.getId() == f.this.byH.getId()) {
                    f.this.byR.UT();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.app_download_dialog);
        this.byy = (LinearLayout) findViewById(e.g.app_info);
        this.byz = (TextView) findViewById(e.g.app_version_and_size);
        this.byA = (TextView) findViewById(e.g.app_description);
        this.byG = (TextView) findViewById(e.g.fullsize_download_button);
        this.byE = (TextView) findViewById(e.g.cancel_download_button);
        this.byF = (TextView) findViewById(e.g.btn_update_save_flow);
        this.byH = (ImageView) findViewById(e.g.img_close);
        this.byF.setOnClickListener(this.mOnClickListener);
        this.byH.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(e.g.divider_line);
        this.byB = (TextView) findViewById(e.g.download_process);
        this.byI = (TextView) findViewById(e.g.incremental_download_button);
        this.byJ = (TextView) findViewById(e.g.not_install_as_tip);
        this.byK = findViewById(e.g.incremental_download_layout);
        this.byD = (TextView) findViewById(e.g.other_app_recommend);
        this.byP = findViewById(e.g.divider_under_button);
        this.byQ = (LinearLayout) findViewById(e.g.cancel_confirm_ll);
        this.byC = this.byB.getText().toString();
        this.byL = (LinearLayout) findViewById(e.g.cancel_dialog);
        this.byN = (TextView) findViewById(e.g.sure_cancel);
        this.byO = (TextView) findViewById(e.g.cancel_button);
        this.byM = (TextView) findViewById(e.g.cancel_tip);
        this.byN.setOnClickListener(this.byS);
        this.byO.setOnClickListener(this.byT);
        if (com.baidu.adp.lib.b.d.iQ().aO("android_shouzhu_update") == 1) {
            this.byU = true;
        } else {
            this.byU = false;
        }
        String size = this.bys.getSize();
        String newVersion = this.bys.getNewVersion();
        String newVersionDesc = this.bys.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(e.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.c(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.byz.setText(sb.toString());
        this.byA.setText(newVersionDesc);
        if (this.bys.forceUpdate()) {
            this.byx = true;
            this.byE.setText(this.mContext.getString(e.j.quit));
            this.byF.setVisibility(8);
            this.byH.setVisibility(8);
        } else if (this.bys.isOfficialVersion() && l.T(this.mContext, "com.tencent.android.qqdownloader")) {
            this.byE.setVisibility(8);
        } else {
            this.byE.setText(this.mContext.getString(e.j.update_after));
            this.byF.setVisibility(8);
            this.byH.setVisibility(8);
        }
        if (this.byt != null && this.byt.showCombineDownload() && !TextUtils.isEmpty(this.byt.getApkMD5RSA())) {
            this.byD.setText(this.byt.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.byt.getAppProc()) && !TextUtils.isEmpty(this.byt.getAppUrl())) {
                this.byD.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(e.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.byD.setCompoundDrawables(drawable, null, null, null);
                this.byu = true;
            } else {
                this.byD.setVisibility(8);
                this.byu = false;
            }
        } else {
            this.byD.setVisibility(8);
            this.byu = false;
        }
        dl(this.byU);
        this.byG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                f.this.byw = true;
                if (f.this.byv) {
                    Drawable drawable2 = al.getDrawable(e.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    f.this.byD.setCompoundDrawables(drawable2, null, null, null);
                }
                f.this.byR.dn(f.this.byv);
            }
        });
        this.byI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.byV) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                f.this.byI.setEnabled(false);
                f.this.byR.mo18do(f.this.byv);
            }
        });
        this.byE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.byR.UT();
            }
        });
        this.byD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.byw) {
                    if (f.this.byv) {
                        Drawable drawable2 = al.getDrawable(e.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        f.this.byD.setCompoundDrawables(drawable2, null, null, null);
                        f.this.byu = false;
                        f.this.byv = false;
                        return;
                    }
                    Drawable drawable3 = al.getDrawable(e.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    f.this.byD.setCompoundDrawables(drawable3, null, null, null);
                    f.this.byu = true;
                    f.this.byv = true;
                }
            }
        });
        UR();
    }

    private void UR() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void dl(boolean z) {
        if (h.a(this.mContext.getPackageManager())) {
            this.byJ.setVisibility(8);
        } else {
            this.byJ.setVisibility(0);
        }
        if (z) {
            if (this.bys == null || TextUtils.isEmpty(this.bys.getPatch()) || this.bys.getNewVersionCode() < 0) {
                this.byK.setVisibility(0);
                this.byI.setText(e.j.super_update);
                al.i(this.byI, e.f.dialog_middle_item_bg_selector);
                this.byQ.setVisibility(0);
                this.byV = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.byK.setVisibility(0);
            this.byI.setText(e.j.incremental_update);
            al.i(this.byI, e.f.dialog_single_button_bg_selector);
            this.byP.setVisibility(8);
            this.byQ.setVisibility(8);
            this.byV = true;
            TiebaStatic.log("c10002");
        } else if (this.bys == null || TextUtils.isEmpty(this.bys.getPatch()) || this.bys.getNewVersionCode() < 0) {
            this.byK.setVisibility(8);
            this.byQ.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.byK.setVisibility(0);
            al.i(this.byI, e.f.dialog_middle_item_bg_selector);
            this.byI.setText(e.j.incremental_update);
            this.byQ.setVisibility(0);
            this.byV = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void updateProgress(int i) {
        this.byG.setVisibility(8);
        this.byK.setVisibility(8);
        this.byE.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.byw = true;
        this.byQ.setVisibility(0);
        this.byB.setVisibility(0);
        this.byB.setText(this.byC + i + "%");
        this.byH.setVisibility(8);
        this.byF.setVisibility(8);
    }

    public void dm(boolean z) {
        this.byG.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.byw) {
            this.byR.stopService();
            this.byy.setVisibility(8);
            if (this.byx) {
                this.byM.setText(getContext().getString(e.j.download_exit));
            }
            this.byL.setVisibility(0);
            return;
        }
        this.byR.UU();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.bys = versionData;
        this.byt = combineDownload;
        this.byR = aVar;
    }

    public void US() {
        this.byL.setVisibility(8);
        this.byy.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.byS = onClickListener;
    }

    public void g(View.OnClickListener onClickListener) {
        this.byT = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(e.g.app_download_dialog_layout));
        }
        al.c(this.byH, e.f.write_close_selector);
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
