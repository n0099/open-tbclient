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
    private boolean byA;
    private LinearLayout byB;
    private TextView byC;
    private TextView byD;
    private TextView byE;
    private String byF;
    private TextView byG;
    private TextView byH;
    private TextView byI;
    private TextView byJ;
    private ImageView byK;
    private TextView byL;
    private TextView byM;
    private View byN;
    private LinearLayout byO;
    private TextView byP;
    private TextView byQ;
    private TextView byR;
    private View byS;
    private LinearLayout byT;
    private a byU;
    private View.OnClickListener byV;
    private View.OnClickListener byW;
    private boolean byX;
    private boolean byY;
    private VersionData byv;
    private CombineDownload byw;
    private boolean byx;
    private boolean byy;
    private boolean byz;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    interface a {
        void UV();

        void UW();

        void dn(boolean z);

        /* renamed from: do */
        void mo18do(boolean z);

        void stopService();
    }

    public f(Context context, int i) {
        super(context, i);
        this.byx = false;
        this.byy = true;
        this.byz = false;
        this.byA = false;
        this.byX = true;
        this.byY = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == f.this.byI.getId()) {
                    f.this.byU.UV();
                    f.this.bX(f.this.mContext);
                } else if (view.getId() == f.this.byK.getId()) {
                    f.this.byU.UV();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.app_download_dialog);
        this.byB = (LinearLayout) findViewById(e.g.app_info);
        this.byC = (TextView) findViewById(e.g.app_version_and_size);
        this.byD = (TextView) findViewById(e.g.app_description);
        this.byJ = (TextView) findViewById(e.g.fullsize_download_button);
        this.byH = (TextView) findViewById(e.g.cancel_download_button);
        this.byI = (TextView) findViewById(e.g.btn_update_save_flow);
        this.byK = (ImageView) findViewById(e.g.img_close);
        this.byI.setOnClickListener(this.mOnClickListener);
        this.byK.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(e.g.divider_line);
        this.byE = (TextView) findViewById(e.g.download_process);
        this.byL = (TextView) findViewById(e.g.incremental_download_button);
        this.byM = (TextView) findViewById(e.g.not_install_as_tip);
        this.byN = findViewById(e.g.incremental_download_layout);
        this.byG = (TextView) findViewById(e.g.other_app_recommend);
        this.byS = findViewById(e.g.divider_under_button);
        this.byT = (LinearLayout) findViewById(e.g.cancel_confirm_ll);
        this.byF = this.byE.getText().toString();
        this.byO = (LinearLayout) findViewById(e.g.cancel_dialog);
        this.byQ = (TextView) findViewById(e.g.sure_cancel);
        this.byR = (TextView) findViewById(e.g.cancel_button);
        this.byP = (TextView) findViewById(e.g.cancel_tip);
        this.byQ.setOnClickListener(this.byV);
        this.byR.setOnClickListener(this.byW);
        if (com.baidu.adp.lib.b.d.iQ().aO("android_shouzhu_update") == 1) {
            this.byX = true;
        } else {
            this.byX = false;
        }
        String size = this.byv.getSize();
        String newVersion = this.byv.getNewVersion();
        String newVersionDesc = this.byv.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(e.j.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.c(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.byC.setText(sb.toString());
        this.byD.setText(newVersionDesc);
        if (this.byv.forceUpdate()) {
            this.byA = true;
            this.byH.setText(this.mContext.getString(e.j.quit));
            this.byI.setVisibility(8);
            this.byK.setVisibility(8);
        } else if (this.byv.isOfficialVersion() && l.T(this.mContext, "com.tencent.android.qqdownloader")) {
            this.byH.setVisibility(8);
        } else {
            this.byH.setText(this.mContext.getString(e.j.update_after));
            this.byI.setVisibility(8);
            this.byK.setVisibility(8);
        }
        if (this.byw != null && this.byw.showCombineDownload() && !TextUtils.isEmpty(this.byw.getApkMD5RSA())) {
            this.byG.setText(this.byw.getAppName());
            if (!u.isInstalledPackage(this.mContext, this.byw.getAppProc()) && !TextUtils.isEmpty(this.byw.getAppUrl())) {
                this.byG.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(e.f.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.byG.setCompoundDrawables(drawable, null, null, null);
                this.byx = true;
            } else {
                this.byG.setVisibility(8);
                this.byx = false;
            }
        } else {
            this.byG.setVisibility(8);
            this.byx = false;
        }
        dl(this.byX);
        this.byJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10003");
                f.this.byz = true;
                if (f.this.byy) {
                    Drawable drawable2 = al.getDrawable(e.f.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    f.this.byG.setCompoundDrawables(drawable2, null, null, null);
                }
                f.this.byU.dn(f.this.byy);
            }
        });
        this.byL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.byY) {
                    TiebaStatic.log("c10001");
                } else {
                    TiebaStatic.log("c10009");
                }
                f.this.byL.setEnabled(false);
                f.this.byU.mo18do(f.this.byy);
            }
        });
        this.byH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.byU.UV();
            }
        });
        this.byG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.byz) {
                    if (f.this.byy) {
                        Drawable drawable2 = al.getDrawable(e.f.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        f.this.byG.setCompoundDrawables(drawable2, null, null, null);
                        f.this.byx = false;
                        f.this.byy = false;
                        return;
                    }
                    Drawable drawable3 = al.getDrawable(e.f.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    f.this.byG.setCompoundDrawables(drawable3, null, null, null);
                    f.this.byx = true;
                    f.this.byy = true;
                }
            }
        });
        UT();
    }

    private void UT() {
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
            this.byM.setVisibility(8);
        } else {
            this.byM.setVisibility(0);
        }
        if (z) {
            if (this.byv == null || TextUtils.isEmpty(this.byv.getPatch()) || this.byv.getNewVersionCode() < 0) {
                this.byN.setVisibility(0);
                this.byL.setText(e.j.super_update);
                al.i(this.byL, e.f.dialog_middle_item_bg_selector);
                this.byT.setVisibility(0);
                this.byY = false;
                TiebaStatic.log("c10008");
                TiebaStatic.log("c10010");
                return;
            }
            this.byN.setVisibility(0);
            this.byL.setText(e.j.incremental_update);
            al.i(this.byL, e.f.dialog_single_button_bg_selector);
            this.byS.setVisibility(8);
            this.byT.setVisibility(8);
            this.byY = true;
            TiebaStatic.log("c10002");
        } else if (this.byv == null || TextUtils.isEmpty(this.byv.getPatch()) || this.byv.getNewVersionCode() < 0) {
            this.byN.setVisibility(8);
            this.byT.setVisibility(0);
            TiebaStatic.log("c10010");
        } else {
            this.byN.setVisibility(0);
            al.i(this.byL, e.f.dialog_middle_item_bg_selector);
            this.byL.setText(e.j.incremental_update);
            this.byT.setVisibility(0);
            this.byY = true;
            TiebaStatic.log("c10002");
            TiebaStatic.log("c10010");
        }
    }

    public void updateProgress(int i) {
        this.byJ.setVisibility(8);
        this.byN.setVisibility(8);
        this.byH.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.byz = true;
        this.byT.setVisibility(0);
        this.byE.setVisibility(0);
        this.byE.setText(this.byF + i + "%");
        this.byK.setVisibility(8);
        this.byI.setVisibility(8);
    }

    public void dm(boolean z) {
        this.byJ.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.byz) {
            this.byU.stopService();
            this.byB.setVisibility(8);
            if (this.byA) {
                this.byP.setText(getContext().getString(e.j.download_exit));
            }
            this.byO.setVisibility(0);
            return;
        }
        this.byU.UW();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.byv = versionData;
        this.byw = combineDownload;
        this.byU = aVar;
    }

    public void UU() {
        this.byO.setVisibility(8);
        this.byB.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.byV = onClickListener;
    }

    public void g(View.OnClickListener onClickListener) {
        this.byW = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(e.g.app_download_dialog_layout));
        }
        al.c(this.byK, e.f.write_close_selector);
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
