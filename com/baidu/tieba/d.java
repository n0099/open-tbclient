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
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes.dex */
public class d extends Dialog {
    private LinearLayout deA;
    private TextView deB;
    private TextView deC;
    private TextView deD;
    private String deE;
    private TextView deF;
    private TextView deG;
    private TextView deH;
    private TextView deI;
    private ImageView deJ;
    private TextView deK;
    private TextView deL;
    private View deM;
    private LinearLayout deN;
    private TextView deO;
    private TextView deP;
    private TextView deQ;
    private View deR;
    private LinearLayout deS;
    private a deT;
    private View.OnClickListener deU;
    private View.OnClickListener deV;
    private boolean deW;
    private boolean deX;
    private VersionData dev;
    private CombineDownload dew;
    private boolean dex;
    private boolean dey;
    private boolean dez;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void aCl();

        void aCm();

        void fZ(boolean z);

        void ga(boolean z);

        void stopService();
    }

    public d(Context context, int i) {
        super(context, i);
        this.dex = false;
        this.mOtherApkSelected = true;
        this.dey = false;
        this.dez = false;
        this.deW = true;
        this.deX = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.this.deH.getId()) {
                    d.this.deT.aCl();
                    d.this.cH(d.this.mContext);
                } else if (view.getId() == d.this.deJ.getId()) {
                    d.this.deT.aCl();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.deA = (LinearLayout) findViewById(R.id.app_info);
        this.deB = (TextView) findViewById(R.id.app_version_and_size);
        this.deC = (TextView) findViewById(R.id.app_description);
        this.deI = (TextView) findViewById(R.id.fullsize_download_button);
        this.deG = (TextView) findViewById(R.id.cancel_download_button);
        this.deH = (TextView) findViewById(R.id.btn_update_save_flow);
        this.deJ = (ImageView) findViewById(R.id.img_close);
        this.deH.setOnClickListener(this.mOnClickListener);
        this.deJ.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.deD = (TextView) findViewById(R.id.download_process);
        this.deK = (TextView) findViewById(R.id.incremental_download_button);
        this.deL = (TextView) findViewById(R.id.not_install_as_tip);
        this.deM = findViewById(R.id.incremental_download_layout);
        this.deF = (TextView) findViewById(R.id.other_app_recommend);
        this.deR = findViewById(R.id.divider_under_button);
        this.deS = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.deE = this.deD.getText().toString();
        this.deN = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.deP = (TextView) findViewById(R.id.sure_cancel);
        this.deQ = (TextView) findViewById(R.id.cancel_button);
        this.deO = (TextView) findViewById(R.id.cancel_tip);
        this.deP.setOnClickListener(this.deU);
        this.deQ.setOnClickListener(this.deV);
        if (com.baidu.adp.lib.b.d.ft().af("android_shouzhu_update") == 1) {
            this.deW = true;
        } else {
            this.deW = false;
        }
        String size = this.dev.getSize();
        String newVersion = this.dev.getNewVersion();
        String newVersionDesc = this.dev.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.deB.setText(sb.toString());
        this.deC.setText(newVersionDesc);
        if (this.dev.forceUpdate()) {
            this.dez = true;
            this.deG.setText(this.mContext.getString(R.string.quit));
            this.deH.setVisibility(8);
            this.deJ.setVisibility(8);
        } else if (this.dev.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.deG.setVisibility(8);
        } else {
            this.deG.setText(this.mContext.getString(R.string.update_after));
            this.deH.setVisibility(8);
            this.deJ.setVisibility(8);
        }
        if (this.dew != null && this.dew.showCombineDownload() && !TextUtils.isEmpty(this.dew.getApkMD5RSA())) {
            this.deF.setText(this.dew.getAppName());
            if (!w.isInstalledPackage(this.mContext, this.dew.getAppProc()) && !TextUtils.isEmpty(this.dew.getAppUrl())) {
                this.deF.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.deF.setCompoundDrawables(drawable, null, null, null);
                this.dex = true;
            } else {
                this.deF.setVisibility(8);
                this.dex = false;
            }
        } else {
            this.deF.setVisibility(8);
            this.dex = false;
        }
        fX(this.deW);
        this.deI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                d.this.dey = true;
                if (d.this.mOtherApkSelected) {
                    Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    d.this.deF.setCompoundDrawables(drawable2, null, null, null);
                }
                d.this.deT.fZ(d.this.mOtherApkSelected);
            }
        });
        this.deK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.deX) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                d.this.deK.setEnabled(false);
                d.this.deT.ga(d.this.mOtherApkSelected);
            }
        });
        this.deG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.deT.aCl();
            }
        });
        this.deF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.dey) {
                    if (d.this.mOtherApkSelected) {
                        Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        d.this.deF.setCompoundDrawables(drawable2, null, null, null);
                        d.this.dex = false;
                        d.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = am.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    d.this.deF.setCompoundDrawables(drawable3, null, null, null);
                    d.this.dex = true;
                    d.this.mOtherApkSelected = true;
                }
            }
        });
        wC();
    }

    private void wC() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void fX(boolean z) {
        if (f.a(this.mContext.getPackageManager())) {
            this.deL.setVisibility(8);
        } else {
            this.deL.setVisibility(0);
        }
        if (z) {
            if (this.dev == null || TextUtils.isEmpty(this.dev.getPatch()) || this.dev.getNewVersionCode() < 0) {
                this.deM.setVisibility(0);
                this.deK.setText(R.string.super_update);
                am.setBackgroundResource(this.deK, R.drawable.dialog_middle_item_bg_selector);
                this.deS.setVisibility(0);
                this.deX = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.deM.setVisibility(0);
            this.deK.setText(R.string.incremental_update);
            am.setBackgroundResource(this.deK, R.drawable.dialog_single_button_bg_selector);
            this.deR.setVisibility(8);
            this.deS.setVisibility(8);
            this.deX = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.dev == null || TextUtils.isEmpty(this.dev.getPatch()) || this.dev.getNewVersionCode() < 0) {
            this.deM.setVisibility(8);
            this.deS.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.deM.setVisibility(0);
            am.setBackgroundResource(this.deK, R.drawable.dialog_middle_item_bg_selector);
            this.deK.setText(R.string.incremental_update);
            this.deS.setVisibility(0);
            this.deX = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.deI.setVisibility(8);
        this.deM.setVisibility(8);
        this.deG.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.dey = true;
        this.deS.setVisibility(0);
        this.deD.setVisibility(0);
        this.deD.setText(this.deE + i + "%");
        this.deJ.setVisibility(8);
        this.deH.setVisibility(8);
    }

    public void fY(boolean z) {
        this.deI.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.dey) {
            this.deT.stopService();
            this.deA.setVisibility(8);
            if (this.dez) {
                this.deO.setText(getContext().getString(R.string.download_exit));
            }
            this.deN.setVisibility(0);
            return;
        }
        this.deT.aCm();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.dev = versionData;
        this.dew = combineDownload;
        this.deT = aVar;
    }

    public void aCk() {
        this.deN.setVisibility(8);
        this.deA.setVisibility(0);
    }

    public void h(View.OnClickListener onClickListener) {
        this.deU = onClickListener;
    }

    public void i(View.OnClickListener onClickListener) {
        this.deV = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        am.setImageResource(this.deJ, R.drawable.write_close_selector);
    }

    public void cH(Context context) {
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
