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
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.switchs.UpdateDialogStyleSyncSwitch;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes.dex */
public class e extends Dialog {
    private View dividerLine;
    private boolean dxN;
    private TextView eVA;
    private TextView eVB;
    private TextView eVC;
    private View eVD;
    private LinearLayout eVE;
    private a eVF;
    private View.OnClickListener eVG;
    private View.OnClickListener eVH;
    private boolean eVI;
    private boolean eVJ;
    private VersionData eVi;
    private CombineDownload eVj;
    private boolean eVk;
    private boolean eVl;
    private LinearLayout eVm;
    private TextView eVn;
    private TextView eVo;
    private TextView eVp;
    private String eVq;
    private TextView eVr;
    private TextView eVs;
    private TextView eVt;
    private TextView eVu;
    private ImageView eVv;
    private TextView eVw;
    private TextView eVx;
    private View eVy;
    private LinearLayout eVz;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void bnL();

        void bnM();

        void jh(boolean z);

        void ji(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.eVk = false;
        this.mOtherApkSelected = true;
        this.dxN = false;
        this.eVl = false;
        this.eVI = true;
        this.eVJ = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.this.eVt.getId()) {
                    e.this.eVF.bnL();
                    e.this.eg(e.this.mContext);
                } else if (view.getId() == e.this.eVv.getId()) {
                    e.this.eVF.bnL();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.eVm = (LinearLayout) findViewById(R.id.app_info);
        this.eVn = (TextView) findViewById(R.id.app_version_and_size);
        this.eVo = (TextView) findViewById(R.id.app_description);
        this.eVu = (TextView) findViewById(R.id.fullsize_download_button);
        this.eVs = (TextView) findViewById(R.id.cancel_download_button);
        this.eVt = (TextView) findViewById(R.id.btn_update_save_flow);
        this.eVv = (ImageView) findViewById(R.id.img_close);
        this.eVt.setOnClickListener(this.mOnClickListener);
        this.eVv.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.eVp = (TextView) findViewById(R.id.download_process);
        this.eVw = (TextView) findViewById(R.id.incremental_download_button);
        this.eVx = (TextView) findViewById(R.id.not_install_as_tip);
        this.eVy = findViewById(R.id.incremental_download_layout);
        this.eVr = (TextView) findViewById(R.id.other_app_recommend);
        this.eVD = findViewById(R.id.divider_under_button);
        this.eVE = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.eVq = this.eVp.getText().toString();
        this.eVz = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.eVB = (TextView) findViewById(R.id.sure_cancel);
        this.eVC = (TextView) findViewById(R.id.cancel_button);
        this.eVA = (TextView) findViewById(R.id.cancel_tip);
        this.eVB.setOnClickListener(this.eVG);
        this.eVC.setOnClickListener(this.eVH);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.eVI = true;
        } else {
            this.eVI = false;
        }
        String size = this.eVi.getSize();
        String newVersion = this.eVi.getNewVersion();
        String newVersionDesc = this.eVi.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.eVn.setText(sb.toString());
        this.eVo.setText(newVersionDesc);
        if (this.eVi.forceUpdate()) {
            this.eVl = true;
            this.eVs.setText(this.mContext.getString(R.string.quit));
            this.eVt.setVisibility(8);
            this.eVv.setVisibility(8);
        } else if (this.eVi.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.eVs.setVisibility(8);
        } else {
            this.eVs.setText(this.mContext.getString(R.string.update_after));
            this.eVt.setVisibility(8);
            this.eVv.setVisibility(8);
        }
        if (this.eVj != null && this.eVj.showCombineDownload() && !TextUtils.isEmpty(this.eVj.getApkMD5RSA())) {
            this.eVr.setText(this.eVj.getAppName());
            if (!x.isInstalledPackage(this.mContext, this.eVj.getAppProc()) && !TextUtils.isEmpty(this.eVj.getAppUrl())) {
                this.eVr.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.eVr.setCompoundDrawables(drawable, null, null, null);
                this.eVk = true;
            } else {
                this.eVr.setVisibility(8);
                this.eVk = false;
            }
        } else {
            this.eVr.setVisibility(8);
            this.eVk = false;
        }
        jf(this.eVI);
        this.eVu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                e.this.dxN = true;
                if (e.this.mOtherApkSelected) {
                    Drawable drawable2 = an.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.eVr.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.eVF.jh(e.this.mOtherApkSelected);
            }
        });
        this.eVw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.eVJ) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                e.this.eVw.setEnabled(false);
                e.this.eVF.ji(e.this.mOtherApkSelected);
            }
        });
        this.eVs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.eVF.bnL();
            }
        });
        this.eVr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.dxN) {
                    if (e.this.mOtherApkSelected) {
                        Drawable drawable2 = an.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.eVr.setCompoundDrawables(drawable2, null, null, null);
                        e.this.eVk = false;
                        e.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = an.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.eVr.setCompoundDrawables(drawable3, null, null, null);
                    e.this.eVk = true;
                    e.this.mOtherApkSelected = true;
                }
            }
        });
        Fj();
    }

    private void Fj() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void jf(boolean z) {
        if (g.a(this.mContext.getPackageManager())) {
            this.eVx.setVisibility(8);
        } else {
            this.eVx.setVisibility(0);
        }
        if (z) {
            if (this.eVi == null || TextUtils.isEmpty(this.eVi.getPatch()) || this.eVi.getNewVersionCode() < 0) {
                this.eVy.setVisibility(0);
                this.eVw.setText(R.string.super_update);
                an.setBackgroundResource(this.eVw, R.drawable.dialog_middle_item_bg_selector);
                this.eVE.setVisibility(0);
                this.eVJ = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.eVy.setVisibility(0);
            this.eVw.setText(R.string.incremental_update);
            an.setBackgroundResource(this.eVw, R.drawable.dialog_single_button_bg_selector);
            this.eVD.setVisibility(8);
            this.eVE.setVisibility(8);
            this.eVJ = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.eVi == null || TextUtils.isEmpty(this.eVi.getPatch()) || this.eVi.getNewVersionCode() < 0) {
            this.eVy.setVisibility(8);
            this.eVE.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.eVy.setVisibility(0);
            an.setBackgroundResource(this.eVw, R.drawable.dialog_middle_item_bg_selector);
            this.eVw.setText(R.string.incremental_update);
            this.eVE.setVisibility(0);
            this.eVJ = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.eVu.setVisibility(8);
        this.eVy.setVisibility(8);
        this.eVs.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.dxN = true;
        this.eVE.setVisibility(0);
        this.eVp.setVisibility(0);
        this.eVp.setText(this.eVq + i + "%");
        this.eVv.setVisibility(8);
        this.eVt.setVisibility(8);
    }

    public void jg(boolean z) {
        this.eVu.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.dxN) {
            this.eVF.stopService();
            this.eVm.setVisibility(8);
            if (this.eVl) {
                this.eVA.setText(getContext().getString(R.string.download_exit));
            }
            this.eVz.setVisibility(0);
            return;
        }
        this.eVF.bnM();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.eVi = versionData;
        this.eVj = combineDownload;
        this.eVF = aVar;
    }

    public void bnK() {
        this.eVz.setVisibility(8);
        this.eVm.setVisibility(0);
    }

    public void j(View.OnClickListener onClickListener) {
        this.eVG = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.eVH = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        an.setImageResource(this.eVv, R.drawable.write_close_selector);
    }

    public void eg(Context context) {
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
