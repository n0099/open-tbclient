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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.switchs.UpdateDialogStyleSyncSwitch;
import com.baidu.tieba.tbadkCore.z;
/* loaded from: classes.dex */
public class g extends Dialog {
    private View dividerLine;
    private View.OnClickListener eIl;
    private VersionData gcI;
    private CombineDownload gcJ;
    private boolean gcK;
    private boolean gcL;
    private boolean gcM;
    private LinearLayout gcN;
    private TextView gcO;
    private TextView gcP;
    private TextView gcQ;
    private String gcR;
    private TextView gcS;
    private TextView gcT;
    private TextView gcU;
    private TextView gcV;
    private ImageView gcW;
    private TextView gcX;
    private TextView gcY;
    private View gcZ;
    private LinearLayout gda;
    private TextView gdb;
    private TextView gdc;
    private TextView gdd;
    private View gde;
    private LinearLayout gdf;
    private a gdg;
    private View.OnClickListener gdh;
    private boolean gdi;
    private boolean gdj;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void bKk();

        void bKl();

        void lW(boolean z);

        void lX(boolean z);

        void stopService();
    }

    public g(Context context, int i) {
        super(context, i);
        this.gcK = false;
        this.mOtherApkSelected = true;
        this.gcL = false;
        this.gcM = false;
        this.gdi = true;
        this.gdj = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == g.this.gcU.getId()) {
                    g.this.gdg.bKk();
                    g.this.fE(g.this.mContext);
                } else if (view.getId() == g.this.gcW.getId()) {
                    g.this.gdg.bKk();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.gcN = (LinearLayout) findViewById(R.id.app_info);
        this.gcO = (TextView) findViewById(R.id.app_version_and_size);
        this.gcP = (TextView) findViewById(R.id.app_description);
        this.gcV = (TextView) findViewById(R.id.fullsize_download_button);
        this.gcT = (TextView) findViewById(R.id.cancel_download_button);
        this.gcU = (TextView) findViewById(R.id.btn_update_save_flow);
        this.gcW = (ImageView) findViewById(R.id.img_close);
        this.gcU.setOnClickListener(this.mOnClickListener);
        this.gcW.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.gcQ = (TextView) findViewById(R.id.download_process);
        this.gcX = (TextView) findViewById(R.id.incremental_download_button);
        this.gcY = (TextView) findViewById(R.id.not_install_as_tip);
        this.gcZ = findViewById(R.id.incremental_download_layout);
        this.gcS = (TextView) findViewById(R.id.other_app_recommend);
        this.gde = findViewById(R.id.divider_under_button);
        this.gdf = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.gcR = this.gcQ.getText().toString();
        this.gda = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.gdc = (TextView) findViewById(R.id.sure_cancel);
        this.gdd = (TextView) findViewById(R.id.cancel_button);
        this.gdb = (TextView) findViewById(R.id.cancel_tip);
        this.gdc.setOnClickListener(this.eIl);
        this.gdd.setOnClickListener(this.gdh);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.gdi = true;
        } else {
            this.gdi = false;
        }
        String size = this.gcI.getSize();
        String newVersion = this.gcI.getNewVersion();
        String newVersionDesc = this.gcI.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.gcO.setText(sb.toString());
        this.gcP.setText(newVersionDesc);
        if (this.gcI.forceUpdate()) {
            this.gcM = true;
            this.gcT.setText(this.mContext.getString(R.string.quit));
            this.gcU.setVisibility(8);
            this.gcW.setVisibility(8);
        } else if (this.gcI.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.gcT.setVisibility(8);
        } else {
            this.gcT.setText(this.mContext.getString(R.string.update_after));
            this.gcU.setVisibility(8);
            this.gcW.setVisibility(8);
        }
        if (this.gcJ != null && this.gcJ.showCombineDownload() && !TextUtils.isEmpty(this.gcJ.getApkMD5RSA())) {
            this.gcS.setText(this.gcJ.getAppName());
            if (!z.isInstalledPackage(this.mContext, this.gcJ.getAppProc()) && !TextUtils.isEmpty(this.gcJ.getAppUrl())) {
                this.gcS.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.gcS.setCompoundDrawables(drawable, null, null, null);
                this.gcK = true;
            } else {
                this.gcS.setVisibility(8);
                this.gcK = false;
            }
        } else {
            this.gcS.setVisibility(8);
            this.gcK = false;
        }
        lU(this.gdi);
        this.gcV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                g.this.gcL = true;
                if (g.this.mOtherApkSelected) {
                    Drawable drawable2 = ao.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    g.this.gcS.setCompoundDrawables(drawable2, null, null, null);
                }
                g.this.gdg.lW(g.this.mOtherApkSelected);
            }
        });
        this.gcX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.gdj) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                g.this.gcX.setEnabled(false);
                g.this.gdg.lX(g.this.mOtherApkSelected);
            }
        });
        this.gcT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gdg.bKk();
            }
        });
        this.gcS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.gcL) {
                    if (g.this.mOtherApkSelected) {
                        Drawable drawable2 = ao.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        g.this.gcS.setCompoundDrawables(drawable2, null, null, null);
                        g.this.gcK = false;
                        g.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = ao.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    g.this.gcS.setCompoundDrawables(drawable3, null, null, null);
                    g.this.gcK = true;
                    g.this.mOtherApkSelected = true;
                }
            }
        });
        FP();
    }

    private void FP() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void lU(boolean z) {
        if (i.a(this.mContext.getPackageManager())) {
            this.gcY.setVisibility(8);
        } else {
            this.gcY.setVisibility(0);
        }
        if (z) {
            if (this.gcI == null || TextUtils.isEmpty(this.gcI.getPatch()) || this.gcI.getNewVersionCode() < 0) {
                this.gcZ.setVisibility(0);
                this.gcX.setText(R.string.super_update);
                ao.setBackgroundResource(this.gcX, R.drawable.dialog_middle_item_bg_selector);
                this.gdf.setVisibility(0);
                this.gdj = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.gcZ.setVisibility(0);
            this.gcX.setText(R.string.incremental_update);
            ao.setBackgroundResource(this.gcX, R.drawable.dialog_single_button_bg_selector);
            this.gde.setVisibility(8);
            this.gdf.setVisibility(8);
            this.gdj = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.gcI == null || TextUtils.isEmpty(this.gcI.getPatch()) || this.gcI.getNewVersionCode() < 0) {
            this.gcZ.setVisibility(8);
            this.gdf.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.gcZ.setVisibility(0);
            ao.setBackgroundResource(this.gcX, R.drawable.dialog_middle_item_bg_selector);
            this.gcX.setText(R.string.incremental_update);
            this.gdf.setVisibility(0);
            this.gdj = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.gcV.setVisibility(8);
        this.gcZ.setVisibility(8);
        this.gcT.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.gcL = true;
        this.gdf.setVisibility(0);
        this.gcQ.setVisibility(0);
        this.gcQ.setText(this.gcR + i + "%");
        this.gcW.setVisibility(8);
        this.gcU.setVisibility(8);
    }

    public void lV(boolean z) {
        this.gcV.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.gcL) {
            this.gdg.stopService();
            this.gcN.setVisibility(8);
            if (this.gcM) {
                this.gdb.setText(getContext().getString(R.string.download_exit));
            }
            this.gda.setVisibility(0);
            return;
        }
        this.gdg.bKl();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.gcI = versionData;
        this.gcJ = combineDownload;
        this.gdg = aVar;
    }

    public void bKj() {
        this.gda.setVisibility(8);
        this.gcN.setVisibility(0);
    }

    public void l(View.OnClickListener onClickListener) {
        this.eIl = onClickListener;
    }

    public void m(View.OnClickListener onClickListener) {
        this.gdh = onClickListener;
    }

    public void f(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        ao.setImageResource(this.gcW, R.drawable.write_close_selector);
    }

    public void fE(Context context) {
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
