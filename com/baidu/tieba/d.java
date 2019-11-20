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
    private VersionData ddD;
    private CombineDownload ddE;
    private boolean ddF;
    private boolean ddG;
    private boolean ddH;
    private LinearLayout ddI;
    private TextView ddJ;
    private TextView ddK;
    private TextView ddL;
    private String ddM;
    private TextView ddN;
    private TextView ddO;
    private TextView ddP;
    private TextView ddQ;
    private ImageView ddR;
    private TextView ddS;
    private TextView ddT;
    private View ddU;
    private LinearLayout ddV;
    private TextView ddW;
    private TextView ddX;
    private TextView ddY;
    private View ddZ;
    private LinearLayout dea;
    private a deb;
    private View.OnClickListener dec;
    private View.OnClickListener ded;
    private boolean dee;
    private boolean def;
    private View dividerLine;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void aCj();

        void aCk();

        void fZ(boolean z);

        void ga(boolean z);

        void stopService();
    }

    public d(Context context, int i) {
        super(context, i);
        this.ddF = false;
        this.mOtherApkSelected = true;
        this.ddG = false;
        this.ddH = false;
        this.dee = true;
        this.def = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.this.ddP.getId()) {
                    d.this.deb.aCj();
                    d.this.cH(d.this.mContext);
                } else if (view.getId() == d.this.ddR.getId()) {
                    d.this.deb.aCj();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.ddI = (LinearLayout) findViewById(R.id.app_info);
        this.ddJ = (TextView) findViewById(R.id.app_version_and_size);
        this.ddK = (TextView) findViewById(R.id.app_description);
        this.ddQ = (TextView) findViewById(R.id.fullsize_download_button);
        this.ddO = (TextView) findViewById(R.id.cancel_download_button);
        this.ddP = (TextView) findViewById(R.id.btn_update_save_flow);
        this.ddR = (ImageView) findViewById(R.id.img_close);
        this.ddP.setOnClickListener(this.mOnClickListener);
        this.ddR.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.ddL = (TextView) findViewById(R.id.download_process);
        this.ddS = (TextView) findViewById(R.id.incremental_download_button);
        this.ddT = (TextView) findViewById(R.id.not_install_as_tip);
        this.ddU = findViewById(R.id.incremental_download_layout);
        this.ddN = (TextView) findViewById(R.id.other_app_recommend);
        this.ddZ = findViewById(R.id.divider_under_button);
        this.dea = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.ddM = this.ddL.getText().toString();
        this.ddV = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.ddX = (TextView) findViewById(R.id.sure_cancel);
        this.ddY = (TextView) findViewById(R.id.cancel_button);
        this.ddW = (TextView) findViewById(R.id.cancel_tip);
        this.ddX.setOnClickListener(this.dec);
        this.ddY.setOnClickListener(this.ded);
        if (com.baidu.adp.lib.b.d.ft().af("android_shouzhu_update") == 1) {
            this.dee = true;
        } else {
            this.dee = false;
        }
        String size = this.ddD.getSize();
        String newVersion = this.ddD.getNewVersion();
        String newVersionDesc = this.ddD.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.ddJ.setText(sb.toString());
        this.ddK.setText(newVersionDesc);
        if (this.ddD.forceUpdate()) {
            this.ddH = true;
            this.ddO.setText(this.mContext.getString(R.string.quit));
            this.ddP.setVisibility(8);
            this.ddR.setVisibility(8);
        } else if (this.ddD.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.ddO.setVisibility(8);
        } else {
            this.ddO.setText(this.mContext.getString(R.string.update_after));
            this.ddP.setVisibility(8);
            this.ddR.setVisibility(8);
        }
        if (this.ddE != null && this.ddE.showCombineDownload() && !TextUtils.isEmpty(this.ddE.getApkMD5RSA())) {
            this.ddN.setText(this.ddE.getAppName());
            if (!w.isInstalledPackage(this.mContext, this.ddE.getAppProc()) && !TextUtils.isEmpty(this.ddE.getAppUrl())) {
                this.ddN.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.ddN.setCompoundDrawables(drawable, null, null, null);
                this.ddF = true;
            } else {
                this.ddN.setVisibility(8);
                this.ddF = false;
            }
        } else {
            this.ddN.setVisibility(8);
            this.ddF = false;
        }
        fX(this.dee);
        this.ddQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                d.this.ddG = true;
                if (d.this.mOtherApkSelected) {
                    Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    d.this.ddN.setCompoundDrawables(drawable2, null, null, null);
                }
                d.this.deb.fZ(d.this.mOtherApkSelected);
            }
        });
        this.ddS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.def) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                d.this.ddS.setEnabled(false);
                d.this.deb.ga(d.this.mOtherApkSelected);
            }
        });
        this.ddO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.deb.aCj();
            }
        });
        this.ddN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.ddG) {
                    if (d.this.mOtherApkSelected) {
                        Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        d.this.ddN.setCompoundDrawables(drawable2, null, null, null);
                        d.this.ddF = false;
                        d.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = am.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    d.this.ddN.setCompoundDrawables(drawable3, null, null, null);
                    d.this.ddF = true;
                    d.this.mOtherApkSelected = true;
                }
            }
        });
        wD();
    }

    private void wD() {
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
            this.ddT.setVisibility(8);
        } else {
            this.ddT.setVisibility(0);
        }
        if (z) {
            if (this.ddD == null || TextUtils.isEmpty(this.ddD.getPatch()) || this.ddD.getNewVersionCode() < 0) {
                this.ddU.setVisibility(0);
                this.ddS.setText(R.string.super_update);
                am.setBackgroundResource(this.ddS, R.drawable.dialog_middle_item_bg_selector);
                this.dea.setVisibility(0);
                this.def = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.ddU.setVisibility(0);
            this.ddS.setText(R.string.incremental_update);
            am.setBackgroundResource(this.ddS, R.drawable.dialog_single_button_bg_selector);
            this.ddZ.setVisibility(8);
            this.dea.setVisibility(8);
            this.def = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.ddD == null || TextUtils.isEmpty(this.ddD.getPatch()) || this.ddD.getNewVersionCode() < 0) {
            this.ddU.setVisibility(8);
            this.dea.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.ddU.setVisibility(0);
            am.setBackgroundResource(this.ddS, R.drawable.dialog_middle_item_bg_selector);
            this.ddS.setText(R.string.incremental_update);
            this.dea.setVisibility(0);
            this.def = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.ddQ.setVisibility(8);
        this.ddU.setVisibility(8);
        this.ddO.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.ddG = true;
        this.dea.setVisibility(0);
        this.ddL.setVisibility(0);
        this.ddL.setText(this.ddM + i + "%");
        this.ddR.setVisibility(8);
        this.ddP.setVisibility(8);
    }

    public void fY(boolean z) {
        this.ddQ.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.ddG) {
            this.deb.stopService();
            this.ddI.setVisibility(8);
            if (this.ddH) {
                this.ddW.setText(getContext().getString(R.string.download_exit));
            }
            this.ddV.setVisibility(0);
            return;
        }
        this.deb.aCk();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.ddD = versionData;
        this.ddE = combineDownload;
        this.deb = aVar;
    }

    public void aCi() {
        this.ddV.setVisibility(8);
        this.ddI.setVisibility(0);
    }

    public void h(View.OnClickListener onClickListener) {
        this.dec = onClickListener;
    }

    public void i(View.OnClickListener onClickListener) {
        this.ded = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        am.setImageResource(this.ddR, R.drawable.write_close_selector);
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
