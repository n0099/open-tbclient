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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.switchs.UpdateDialogStyleSyncSwitch;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes.dex */
public class d extends Dialog {
    private View bZT;
    private boolean cBN;
    private ImageView dRA;
    private TextView dRB;
    private TextView dRC;
    private View dRD;
    private LinearLayout dRE;
    private TextView dRF;
    private TextView dRG;
    private TextView dRH;
    private LinearLayout dRI;
    private a dRJ;
    private View.OnClickListener dRK;
    private View.OnClickListener dRL;
    private boolean dRM;
    private boolean dRN;
    private VersionData dRn;
    private CombineDownload dRo;
    private boolean dRp;
    private boolean dRq;
    private LinearLayout dRr;
    private TextView dRs;
    private TextView dRt;
    private TextView dRu;
    private String dRv;
    private TextView dRw;
    private TextView dRx;
    private TextView dRy;
    private TextView dRz;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void aUc();

        void aUd();

        void hn(boolean z);

        void ho(boolean z);

        void stopService();
    }

    public d(Context context, int i) {
        super(context, i);
        this.dRp = false;
        this.mOtherApkSelected = true;
        this.cBN = false;
        this.dRq = false;
        this.dRM = true;
        this.dRN = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.this.dRy.getId()) {
                    d.this.dRJ.aUc();
                    d.this.ek(d.this.mContext);
                } else if (view.getId() == d.this.dRA.getId()) {
                    d.this.dRJ.aUc();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.dRr = (LinearLayout) findViewById(R.id.app_info);
        this.dRs = (TextView) findViewById(R.id.app_version_and_size);
        this.dRt = (TextView) findViewById(R.id.app_description);
        this.dRz = (TextView) findViewById(R.id.fullsize_download_button);
        this.dRx = (TextView) findViewById(R.id.cancel_download_button);
        this.dRy = (TextView) findViewById(R.id.btn_update_save_flow);
        this.dRA = (ImageView) findViewById(R.id.img_close);
        this.dRy.setOnClickListener(this.mOnClickListener);
        this.dRA.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dRu = (TextView) findViewById(R.id.download_process);
        this.dRB = (TextView) findViewById(R.id.incremental_download_button);
        this.dRC = (TextView) findViewById(R.id.not_install_as_tip);
        this.dRD = findViewById(R.id.incremental_download_layout);
        this.dRw = (TextView) findViewById(R.id.other_app_recommend);
        this.bZT = findViewById(R.id.divider_under_button);
        this.dRI = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.dRv = this.dRu.getText().toString();
        this.dRE = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.dRG = (TextView) findViewById(R.id.sure_cancel);
        this.dRH = (TextView) findViewById(R.id.cancel_button);
        this.dRF = (TextView) findViewById(R.id.cancel_tip);
        this.dRG.setOnClickListener(this.dRK);
        this.dRH.setOnClickListener(this.dRL);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.dRM = true;
        } else {
            this.dRM = false;
        }
        String size = this.dRn.getSize();
        String newVersion = this.dRn.getNewVersion();
        String newVersionDesc = this.dRn.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.dRs.setText(sb.toString());
        this.dRt.setText(newVersionDesc);
        if (this.dRn.forceUpdate()) {
            this.dRq = true;
            this.dRx.setText(this.mContext.getString(R.string.quit));
            this.dRy.setVisibility(8);
            this.dRA.setVisibility(8);
        } else if (this.dRn.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.dRx.setVisibility(8);
        } else {
            this.dRx.setText(this.mContext.getString(R.string.update_after));
            this.dRy.setVisibility(8);
            this.dRA.setVisibility(8);
        }
        if (this.dRo != null && this.dRo.showCombineDownload() && !TextUtils.isEmpty(this.dRo.getApkMD5RSA())) {
            this.dRw.setText(this.dRo.getAppName());
            if (!w.isInstalledPackage(this.mContext, this.dRo.getAppProc()) && !TextUtils.isEmpty(this.dRo.getAppUrl())) {
                this.dRw.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.dRw.setCompoundDrawables(drawable, null, null, null);
                this.dRp = true;
            } else {
                this.dRw.setVisibility(8);
                this.dRp = false;
            }
        } else {
            this.dRw.setVisibility(8);
            this.dRp = false;
        }
        hl(this.dRM);
        this.dRz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                d.this.cBN = true;
                if (d.this.mOtherApkSelected) {
                    Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    d.this.dRw.setCompoundDrawables(drawable2, null, null, null);
                }
                d.this.dRJ.hn(d.this.mOtherApkSelected);
            }
        });
        this.dRB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dRN) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                d.this.dRB.setEnabled(false);
                d.this.dRJ.ho(d.this.mOtherApkSelected);
            }
        });
        this.dRx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dRJ.aUc();
            }
        });
        this.dRw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.cBN) {
                    if (d.this.mOtherApkSelected) {
                        Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        d.this.dRw.setCompoundDrawables(drawable2, null, null, null);
                        d.this.dRp = false;
                        d.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = am.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    d.this.dRw.setCompoundDrawables(drawable3, null, null, null);
                    d.this.dRp = true;
                    d.this.mOtherApkSelected = true;
                }
            }
        });
        initWindow();
    }

    private void initWindow() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void hl(boolean z) {
        if (g.a(this.mContext.getPackageManager())) {
            this.dRC.setVisibility(8);
        } else {
            this.dRC.setVisibility(0);
        }
        if (z) {
            if (this.dRn == null || TextUtils.isEmpty(this.dRn.getPatch()) || this.dRn.getNewVersionCode() < 0) {
                this.dRD.setVisibility(0);
                this.dRB.setText(R.string.super_update);
                am.setBackgroundResource(this.dRB, R.drawable.dialog_middle_item_bg_selector);
                this.dRI.setVisibility(0);
                this.dRN = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.dRD.setVisibility(0);
            this.dRB.setText(R.string.incremental_update);
            am.setBackgroundResource(this.dRB, R.drawable.dialog_single_button_bg_selector);
            this.bZT.setVisibility(8);
            this.dRI.setVisibility(8);
            this.dRN = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.dRn == null || TextUtils.isEmpty(this.dRn.getPatch()) || this.dRn.getNewVersionCode() < 0) {
            this.dRD.setVisibility(8);
            this.dRI.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.dRD.setVisibility(0);
            am.setBackgroundResource(this.dRB, R.drawable.dialog_middle_item_bg_selector);
            this.dRB.setText(R.string.incremental_update);
            this.dRI.setVisibility(0);
            this.dRN = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.dRz.setVisibility(8);
        this.dRD.setVisibility(8);
        this.dRx.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.cBN = true;
        this.dRI.setVisibility(0);
        this.dRu.setVisibility(0);
        this.dRu.setText(this.dRv + i + "%");
        this.dRA.setVisibility(8);
        this.dRy.setVisibility(8);
    }

    public void hm(boolean z) {
        this.dRz.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.cBN) {
            this.dRJ.stopService();
            this.dRr.setVisibility(8);
            if (this.dRq) {
                this.dRF.setText(getContext().getString(R.string.download_exit));
            }
            this.dRE.setVisibility(0);
            return;
        }
        this.dRJ.aUd();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.dRn = versionData;
        this.dRo = combineDownload;
        this.dRJ = aVar;
    }

    public void aUb() {
        this.dRE.setVisibility(8);
        this.dRr.setVisibility(0);
    }

    public void j(View.OnClickListener onClickListener) {
        this.dRK = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.dRL = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        am.setImageResource(this.dRA, R.drawable.write_close_selector);
    }

    public void ek(Context context) {
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
