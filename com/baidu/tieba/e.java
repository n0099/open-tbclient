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
public class e extends Dialog {
    private View dividerLine;
    private boolean dtd;
    private VersionData eKL;
    private CombineDownload eKM;
    private boolean eKN;
    private boolean eKO;
    private LinearLayout eKP;
    private TextView eKQ;
    private TextView eKR;
    private TextView eKS;
    private String eKT;
    private TextView eKU;
    private TextView eKV;
    private TextView eKW;
    private TextView eKX;
    private ImageView eKY;
    private TextView eKZ;
    private TextView eLa;
    private View eLb;
    private LinearLayout eLc;
    private TextView eLd;
    private TextView eLe;
    private TextView eLf;
    private View eLg;
    private LinearLayout eLh;
    private a eLi;
    private View.OnClickListener eLj;
    private View.OnClickListener eLk;
    private boolean eLl;
    private boolean eLm;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void blj();

        void blk();

        void iV(boolean z);

        void iW(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.eKN = false;
        this.mOtherApkSelected = true;
        this.dtd = false;
        this.eKO = false;
        this.eLl = true;
        this.eLm = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.this.eKW.getId()) {
                    e.this.eLi.blj();
                    e.this.ef(e.this.mContext);
                } else if (view.getId() == e.this.eKY.getId()) {
                    e.this.eLi.blj();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.eKP = (LinearLayout) findViewById(R.id.app_info);
        this.eKQ = (TextView) findViewById(R.id.app_version_and_size);
        this.eKR = (TextView) findViewById(R.id.app_description);
        this.eKX = (TextView) findViewById(R.id.fullsize_download_button);
        this.eKV = (TextView) findViewById(R.id.cancel_download_button);
        this.eKW = (TextView) findViewById(R.id.btn_update_save_flow);
        this.eKY = (ImageView) findViewById(R.id.img_close);
        this.eKW.setOnClickListener(this.mOnClickListener);
        this.eKY.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.eKS = (TextView) findViewById(R.id.download_process);
        this.eKZ = (TextView) findViewById(R.id.incremental_download_button);
        this.eLa = (TextView) findViewById(R.id.not_install_as_tip);
        this.eLb = findViewById(R.id.incremental_download_layout);
        this.eKU = (TextView) findViewById(R.id.other_app_recommend);
        this.eLg = findViewById(R.id.divider_under_button);
        this.eLh = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.eKT = this.eKS.getText().toString();
        this.eLc = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.eLe = (TextView) findViewById(R.id.sure_cancel);
        this.eLf = (TextView) findViewById(R.id.cancel_button);
        this.eLd = (TextView) findViewById(R.id.cancel_tip);
        this.eLe.setOnClickListener(this.eLj);
        this.eLf.setOnClickListener(this.eLk);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.eLl = true;
        } else {
            this.eLl = false;
        }
        String size = this.eKL.getSize();
        String newVersion = this.eKL.getNewVersion();
        String newVersionDesc = this.eKL.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.eKQ.setText(sb.toString());
        this.eKR.setText(newVersionDesc);
        if (this.eKL.forceUpdate()) {
            this.eKO = true;
            this.eKV.setText(this.mContext.getString(R.string.quit));
            this.eKW.setVisibility(8);
            this.eKY.setVisibility(8);
        } else if (this.eKL.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.eKV.setVisibility(8);
        } else {
            this.eKV.setText(this.mContext.getString(R.string.update_after));
            this.eKW.setVisibility(8);
            this.eKY.setVisibility(8);
        }
        if (this.eKM != null && this.eKM.showCombineDownload() && !TextUtils.isEmpty(this.eKM.getApkMD5RSA())) {
            this.eKU.setText(this.eKM.getAppName());
            if (!x.isInstalledPackage(this.mContext, this.eKM.getAppProc()) && !TextUtils.isEmpty(this.eKM.getAppUrl())) {
                this.eKU.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.eKU.setCompoundDrawables(drawable, null, null, null);
                this.eKN = true;
            } else {
                this.eKU.setVisibility(8);
                this.eKN = false;
            }
        } else {
            this.eKU.setVisibility(8);
            this.eKN = false;
        }
        iT(this.eLl);
        this.eKX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                e.this.dtd = true;
                if (e.this.mOtherApkSelected) {
                    Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.eKU.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.eLi.iV(e.this.mOtherApkSelected);
            }
        });
        this.eKZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.eLm) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                e.this.eKZ.setEnabled(false);
                e.this.eLi.iW(e.this.mOtherApkSelected);
            }
        });
        this.eKV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.eLi.blj();
            }
        });
        this.eKU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.dtd) {
                    if (e.this.mOtherApkSelected) {
                        Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.eKU.setCompoundDrawables(drawable2, null, null, null);
                        e.this.eKN = false;
                        e.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = am.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.eKU.setCompoundDrawables(drawable3, null, null, null);
                    e.this.eKN = true;
                    e.this.mOtherApkSelected = true;
                }
            }
        });
        EF();
    }

    private void EF() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void iT(boolean z) {
        if (g.a(this.mContext.getPackageManager())) {
            this.eLa.setVisibility(8);
        } else {
            this.eLa.setVisibility(0);
        }
        if (z) {
            if (this.eKL == null || TextUtils.isEmpty(this.eKL.getPatch()) || this.eKL.getNewVersionCode() < 0) {
                this.eLb.setVisibility(0);
                this.eKZ.setText(R.string.super_update);
                am.setBackgroundResource(this.eKZ, R.drawable.dialog_middle_item_bg_selector);
                this.eLh.setVisibility(0);
                this.eLm = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.eLb.setVisibility(0);
            this.eKZ.setText(R.string.incremental_update);
            am.setBackgroundResource(this.eKZ, R.drawable.dialog_single_button_bg_selector);
            this.eLg.setVisibility(8);
            this.eLh.setVisibility(8);
            this.eLm = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.eKL == null || TextUtils.isEmpty(this.eKL.getPatch()) || this.eKL.getNewVersionCode() < 0) {
            this.eLb.setVisibility(8);
            this.eLh.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.eLb.setVisibility(0);
            am.setBackgroundResource(this.eKZ, R.drawable.dialog_middle_item_bg_selector);
            this.eKZ.setText(R.string.incremental_update);
            this.eLh.setVisibility(0);
            this.eLm = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.eKX.setVisibility(8);
        this.eLb.setVisibility(8);
        this.eKV.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.dtd = true;
        this.eLh.setVisibility(0);
        this.eKS.setVisibility(0);
        this.eKS.setText(this.eKT + i + "%");
        this.eKY.setVisibility(8);
        this.eKW.setVisibility(8);
    }

    public void iU(boolean z) {
        this.eKX.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.dtd) {
            this.eLi.stopService();
            this.eKP.setVisibility(8);
            if (this.eKO) {
                this.eLd.setText(getContext().getString(R.string.download_exit));
            }
            this.eLc.setVisibility(0);
            return;
        }
        this.eLi.blk();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.eKL = versionData;
        this.eKM = combineDownload;
        this.eLi = aVar;
    }

    public void bli() {
        this.eLc.setVisibility(8);
        this.eKP.setVisibility(0);
    }

    public void i(View.OnClickListener onClickListener) {
        this.eLj = onClickListener;
    }

    public void j(View.OnClickListener onClickListener) {
        this.eLk = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        am.setImageResource(this.eKY, R.drawable.write_close_selector);
    }

    public void ef(Context context) {
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
