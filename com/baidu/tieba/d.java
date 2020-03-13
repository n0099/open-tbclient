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
    private boolean cFY;
    private View cen;
    private VersionData dVP;
    private CombineDownload dVQ;
    private boolean dVR;
    private boolean dVS;
    private LinearLayout dVT;
    private TextView dVU;
    private TextView dVV;
    private TextView dVW;
    private String dVX;
    private TextView dVY;
    private TextView dVZ;
    private TextView dWa;
    private TextView dWb;
    private ImageView dWc;
    private TextView dWd;
    private TextView dWe;
    private View dWf;
    private LinearLayout dWg;
    private TextView dWh;
    private TextView dWi;
    private TextView dWj;
    private LinearLayout dWk;
    private a dWl;
    private View.OnClickListener dWm;
    private View.OnClickListener dWn;
    private boolean dWo;
    private boolean dWp;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void aWP();

        void aWQ();

        void hA(boolean z);

        void hz(boolean z);

        void stopService();
    }

    public d(Context context, int i) {
        super(context, i);
        this.dVR = false;
        this.mOtherApkSelected = true;
        this.cFY = false;
        this.dVS = false;
        this.dWo = true;
        this.dWp = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.this.dWa.getId()) {
                    d.this.dWl.aWP();
                    d.this.en(d.this.mContext);
                } else if (view.getId() == d.this.dWc.getId()) {
                    d.this.dWl.aWP();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.dVT = (LinearLayout) findViewById(R.id.app_info);
        this.dVU = (TextView) findViewById(R.id.app_version_and_size);
        this.dVV = (TextView) findViewById(R.id.app_description);
        this.dWb = (TextView) findViewById(R.id.fullsize_download_button);
        this.dVZ = (TextView) findViewById(R.id.cancel_download_button);
        this.dWa = (TextView) findViewById(R.id.btn_update_save_flow);
        this.dWc = (ImageView) findViewById(R.id.img_close);
        this.dWa.setOnClickListener(this.mOnClickListener);
        this.dWc.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dVW = (TextView) findViewById(R.id.download_process);
        this.dWd = (TextView) findViewById(R.id.incremental_download_button);
        this.dWe = (TextView) findViewById(R.id.not_install_as_tip);
        this.dWf = findViewById(R.id.incremental_download_layout);
        this.dVY = (TextView) findViewById(R.id.other_app_recommend);
        this.cen = findViewById(R.id.divider_under_button);
        this.dWk = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.dVX = this.dVW.getText().toString();
        this.dWg = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.dWi = (TextView) findViewById(R.id.sure_cancel);
        this.dWj = (TextView) findViewById(R.id.cancel_button);
        this.dWh = (TextView) findViewById(R.id.cancel_tip);
        this.dWi.setOnClickListener(this.dWm);
        this.dWj.setOnClickListener(this.dWn);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.dWo = true;
        } else {
            this.dWo = false;
        }
        String size = this.dVP.getSize();
        String newVersion = this.dVP.getNewVersion();
        String newVersionDesc = this.dVP.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.dVU.setText(sb.toString());
        this.dVV.setText(newVersionDesc);
        if (this.dVP.forceUpdate()) {
            this.dVS = true;
            this.dVZ.setText(this.mContext.getString(R.string.quit));
            this.dWa.setVisibility(8);
            this.dWc.setVisibility(8);
        } else if (this.dVP.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.dVZ.setVisibility(8);
        } else {
            this.dVZ.setText(this.mContext.getString(R.string.update_after));
            this.dWa.setVisibility(8);
            this.dWc.setVisibility(8);
        }
        if (this.dVQ != null && this.dVQ.showCombineDownload() && !TextUtils.isEmpty(this.dVQ.getApkMD5RSA())) {
            this.dVY.setText(this.dVQ.getAppName());
            if (!w.isInstalledPackage(this.mContext, this.dVQ.getAppProc()) && !TextUtils.isEmpty(this.dVQ.getAppUrl())) {
                this.dVY.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.dVY.setCompoundDrawables(drawable, null, null, null);
                this.dVR = true;
            } else {
                this.dVY.setVisibility(8);
                this.dVR = false;
            }
        } else {
            this.dVY.setVisibility(8);
            this.dVR = false;
        }
        hx(this.dWo);
        this.dWb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                d.this.cFY = true;
                if (d.this.mOtherApkSelected) {
                    Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    d.this.dVY.setCompoundDrawables(drawable2, null, null, null);
                }
                d.this.dWl.hz(d.this.mOtherApkSelected);
            }
        });
        this.dWd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dWp) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                d.this.dWd.setEnabled(false);
                d.this.dWl.hA(d.this.mOtherApkSelected);
            }
        });
        this.dVZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dWl.aWP();
            }
        });
        this.dVY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.cFY) {
                    if (d.this.mOtherApkSelected) {
                        Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        d.this.dVY.setCompoundDrawables(drawable2, null, null, null);
                        d.this.dVR = false;
                        d.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = am.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    d.this.dVY.setCompoundDrawables(drawable3, null, null, null);
                    d.this.dVR = true;
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

    public void hx(boolean z) {
        if (g.a(this.mContext.getPackageManager())) {
            this.dWe.setVisibility(8);
        } else {
            this.dWe.setVisibility(0);
        }
        if (z) {
            if (this.dVP == null || TextUtils.isEmpty(this.dVP.getPatch()) || this.dVP.getNewVersionCode() < 0) {
                this.dWf.setVisibility(0);
                this.dWd.setText(R.string.super_update);
                am.setBackgroundResource(this.dWd, R.drawable.dialog_middle_item_bg_selector);
                this.dWk.setVisibility(0);
                this.dWp = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.dWf.setVisibility(0);
            this.dWd.setText(R.string.incremental_update);
            am.setBackgroundResource(this.dWd, R.drawable.dialog_single_button_bg_selector);
            this.cen.setVisibility(8);
            this.dWk.setVisibility(8);
            this.dWp = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.dVP == null || TextUtils.isEmpty(this.dVP.getPatch()) || this.dVP.getNewVersionCode() < 0) {
            this.dWf.setVisibility(8);
            this.dWk.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.dWf.setVisibility(0);
            am.setBackgroundResource(this.dWd, R.drawable.dialog_middle_item_bg_selector);
            this.dWd.setText(R.string.incremental_update);
            this.dWk.setVisibility(0);
            this.dWp = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.dWb.setVisibility(8);
        this.dWf.setVisibility(8);
        this.dVZ.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.cFY = true;
        this.dWk.setVisibility(0);
        this.dVW.setVisibility(0);
        this.dVW.setText(this.dVX + i + "%");
        this.dWc.setVisibility(8);
        this.dWa.setVisibility(8);
    }

    public void hy(boolean z) {
        this.dWb.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.cFY) {
            this.dWl.stopService();
            this.dVT.setVisibility(8);
            if (this.dVS) {
                this.dWh.setText(getContext().getString(R.string.download_exit));
            }
            this.dWg.setVisibility(0);
            return;
        }
        this.dWl.aWQ();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.dVP = versionData;
        this.dVQ = combineDownload;
        this.dWl = aVar;
    }

    public void aWO() {
        this.dWg.setVisibility(8);
        this.dVT.setVisibility(0);
    }

    public void i(View.OnClickListener onClickListener) {
        this.dWm = onClickListener;
    }

    public void j(View.OnClickListener onClickListener) {
        this.dWn = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        am.setImageResource(this.dWc, R.drawable.write_close_selector);
    }

    public void en(Context context) {
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
