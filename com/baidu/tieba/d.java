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
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes.dex */
public class d extends Dialog {
    private boolean cGj;
    private View cey;
    private LinearLayout dWA;
    private a dWB;
    private View.OnClickListener dWC;
    private View.OnClickListener dWD;
    private boolean dWE;
    private boolean dWF;
    private VersionData dWf;
    private CombineDownload dWg;
    private boolean dWh;
    private boolean dWi;
    private LinearLayout dWj;
    private TextView dWk;
    private TextView dWl;
    private TextView dWm;
    private String dWn;
    private TextView dWo;
    private TextView dWp;
    private TextView dWq;
    private TextView dWr;
    private ImageView dWs;
    private TextView dWt;
    private TextView dWu;
    private View dWv;
    private LinearLayout dWw;
    private TextView dWx;
    private TextView dWy;
    private TextView dWz;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void aWT();

        void aWU();

        void hA(boolean z);

        void hB(boolean z);

        void stopService();
    }

    public d(Context context, int i) {
        super(context, i);
        this.dWh = false;
        this.mOtherApkSelected = true;
        this.cGj = false;
        this.dWi = false;
        this.dWE = true;
        this.dWF = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.this.dWq.getId()) {
                    d.this.dWB.aWT();
                    d.this.em(d.this.mContext);
                } else if (view.getId() == d.this.dWs.getId()) {
                    d.this.dWB.aWT();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.dWj = (LinearLayout) findViewById(R.id.app_info);
        this.dWk = (TextView) findViewById(R.id.app_version_and_size);
        this.dWl = (TextView) findViewById(R.id.app_description);
        this.dWr = (TextView) findViewById(R.id.fullsize_download_button);
        this.dWp = (TextView) findViewById(R.id.cancel_download_button);
        this.dWq = (TextView) findViewById(R.id.btn_update_save_flow);
        this.dWs = (ImageView) findViewById(R.id.img_close);
        this.dWq.setOnClickListener(this.mOnClickListener);
        this.dWs.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dWm = (TextView) findViewById(R.id.download_process);
        this.dWt = (TextView) findViewById(R.id.incremental_download_button);
        this.dWu = (TextView) findViewById(R.id.not_install_as_tip);
        this.dWv = findViewById(R.id.incremental_download_layout);
        this.dWo = (TextView) findViewById(R.id.other_app_recommend);
        this.cey = findViewById(R.id.divider_under_button);
        this.dWA = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.dWn = this.dWm.getText().toString();
        this.dWw = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.dWy = (TextView) findViewById(R.id.sure_cancel);
        this.dWz = (TextView) findViewById(R.id.cancel_button);
        this.dWx = (TextView) findViewById(R.id.cancel_tip);
        this.dWy.setOnClickListener(this.dWC);
        this.dWz.setOnClickListener(this.dWD);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.dWE = true;
        } else {
            this.dWE = false;
        }
        String size = this.dWf.getSize();
        String newVersion = this.dWf.getNewVersion();
        String newVersionDesc = this.dWf.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.dWk.setText(sb.toString());
        this.dWl.setText(newVersionDesc);
        if (this.dWf.forceUpdate()) {
            this.dWi = true;
            this.dWp.setText(this.mContext.getString(R.string.quit));
            this.dWq.setVisibility(8);
            this.dWs.setVisibility(8);
        } else if (this.dWf.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.dWp.setVisibility(8);
        } else {
            this.dWp.setText(this.mContext.getString(R.string.update_after));
            this.dWq.setVisibility(8);
            this.dWs.setVisibility(8);
        }
        if (this.dWg != null && this.dWg.showCombineDownload() && !TextUtils.isEmpty(this.dWg.getApkMD5RSA())) {
            this.dWo.setText(this.dWg.getAppName());
            if (!x.isInstalledPackage(this.mContext, this.dWg.getAppProc()) && !TextUtils.isEmpty(this.dWg.getAppUrl())) {
                this.dWo.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.dWo.setCompoundDrawables(drawable, null, null, null);
                this.dWh = true;
            } else {
                this.dWo.setVisibility(8);
                this.dWh = false;
            }
        } else {
            this.dWo.setVisibility(8);
            this.dWh = false;
        }
        hy(this.dWE);
        this.dWr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                d.this.cGj = true;
                if (d.this.mOtherApkSelected) {
                    Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    d.this.dWo.setCompoundDrawables(drawable2, null, null, null);
                }
                d.this.dWB.hA(d.this.mOtherApkSelected);
            }
        });
        this.dWt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dWF) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                d.this.dWt.setEnabled(false);
                d.this.dWB.hB(d.this.mOtherApkSelected);
            }
        });
        this.dWp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dWB.aWT();
            }
        });
        this.dWo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.cGj) {
                    if (d.this.mOtherApkSelected) {
                        Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        d.this.dWo.setCompoundDrawables(drawable2, null, null, null);
                        d.this.dWh = false;
                        d.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = am.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    d.this.dWo.setCompoundDrawables(drawable3, null, null, null);
                    d.this.dWh = true;
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

    public void hy(boolean z) {
        if (g.a(this.mContext.getPackageManager())) {
            this.dWu.setVisibility(8);
        } else {
            this.dWu.setVisibility(0);
        }
        if (z) {
            if (this.dWf == null || TextUtils.isEmpty(this.dWf.getPatch()) || this.dWf.getNewVersionCode() < 0) {
                this.dWv.setVisibility(0);
                this.dWt.setText(R.string.super_update);
                am.setBackgroundResource(this.dWt, R.drawable.dialog_middle_item_bg_selector);
                this.dWA.setVisibility(0);
                this.dWF = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.dWv.setVisibility(0);
            this.dWt.setText(R.string.incremental_update);
            am.setBackgroundResource(this.dWt, R.drawable.dialog_single_button_bg_selector);
            this.cey.setVisibility(8);
            this.dWA.setVisibility(8);
            this.dWF = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.dWf == null || TextUtils.isEmpty(this.dWf.getPatch()) || this.dWf.getNewVersionCode() < 0) {
            this.dWv.setVisibility(8);
            this.dWA.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.dWv.setVisibility(0);
            am.setBackgroundResource(this.dWt, R.drawable.dialog_middle_item_bg_selector);
            this.dWt.setText(R.string.incremental_update);
            this.dWA.setVisibility(0);
            this.dWF = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.dWr.setVisibility(8);
        this.dWv.setVisibility(8);
        this.dWp.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.cGj = true;
        this.dWA.setVisibility(0);
        this.dWm.setVisibility(0);
        this.dWm.setText(this.dWn + i + "%");
        this.dWs.setVisibility(8);
        this.dWq.setVisibility(8);
    }

    public void hz(boolean z) {
        this.dWr.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.cGj) {
            this.dWB.stopService();
            this.dWj.setVisibility(8);
            if (this.dWi) {
                this.dWx.setText(getContext().getString(R.string.download_exit));
            }
            this.dWw.setVisibility(0);
            return;
        }
        this.dWB.aWU();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.dWf = versionData;
        this.dWg = combineDownload;
        this.dWB = aVar;
    }

    public void aWS() {
        this.dWw.setVisibility(8);
        this.dWj.setVisibility(0);
    }

    public void i(View.OnClickListener onClickListener) {
        this.dWC = onClickListener;
    }

    public void j(View.OnClickListener onClickListener) {
        this.dWD = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        am.setImageResource(this.dWs, R.drawable.write_close_selector);
    }

    public void em(Context context) {
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
