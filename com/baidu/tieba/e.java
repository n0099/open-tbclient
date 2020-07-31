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
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes.dex */
public class e extends Dialog {
    private boolean dDJ;
    private View dividerLine;
    private VersionData faP;
    private CombineDownload faQ;
    private boolean faR;
    private boolean faS;
    private LinearLayout faT;
    private TextView faU;
    private TextView faV;
    private TextView faW;
    private String faX;
    private TextView faY;
    private TextView faZ;
    private TextView fba;
    private TextView fbb;
    private ImageView fbc;
    private TextView fbd;
    private TextView fbe;
    private View fbf;
    private LinearLayout fbg;
    private TextView fbh;
    private TextView fbi;
    private TextView fbj;
    private View fbk;
    private LinearLayout fbl;
    private a fbm;
    private View.OnClickListener fbn;
    private View.OnClickListener fbo;
    private boolean fbp;
    private boolean fbq;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void brs();

        void brt();

        void jM(boolean z);

        void jN(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.faR = false;
        this.mOtherApkSelected = true;
        this.dDJ = false;
        this.faS = false;
        this.fbp = true;
        this.fbq = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.this.fba.getId()) {
                    e.this.fbm.brs();
                    e.this.el(e.this.mContext);
                } else if (view.getId() == e.this.fbc.getId()) {
                    e.this.fbm.brs();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.faT = (LinearLayout) findViewById(R.id.app_info);
        this.faU = (TextView) findViewById(R.id.app_version_and_size);
        this.faV = (TextView) findViewById(R.id.app_description);
        this.fbb = (TextView) findViewById(R.id.fullsize_download_button);
        this.faZ = (TextView) findViewById(R.id.cancel_download_button);
        this.fba = (TextView) findViewById(R.id.btn_update_save_flow);
        this.fbc = (ImageView) findViewById(R.id.img_close);
        this.fba.setOnClickListener(this.mOnClickListener);
        this.fbc.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.faW = (TextView) findViewById(R.id.download_process);
        this.fbd = (TextView) findViewById(R.id.incremental_download_button);
        this.fbe = (TextView) findViewById(R.id.not_install_as_tip);
        this.fbf = findViewById(R.id.incremental_download_layout);
        this.faY = (TextView) findViewById(R.id.other_app_recommend);
        this.fbk = findViewById(R.id.divider_under_button);
        this.fbl = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.faX = this.faW.getText().toString();
        this.fbg = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.fbi = (TextView) findViewById(R.id.sure_cancel);
        this.fbj = (TextView) findViewById(R.id.cancel_button);
        this.fbh = (TextView) findViewById(R.id.cancel_tip);
        this.fbi.setOnClickListener(this.fbn);
        this.fbj.setOnClickListener(this.fbo);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.fbp = true;
        } else {
            this.fbp = false;
        }
        String size = this.faP.getSize();
        String newVersion = this.faP.getNewVersion();
        String newVersionDesc = this.faP.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.faU.setText(sb.toString());
        this.faV.setText(newVersionDesc);
        if (this.faP.forceUpdate()) {
            this.faS = true;
            this.faZ.setText(this.mContext.getString(R.string.quit));
            this.fba.setVisibility(8);
            this.fbc.setVisibility(8);
        } else if (this.faP.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.faZ.setVisibility(8);
        } else {
            this.faZ.setText(this.mContext.getString(R.string.update_after));
            this.fba.setVisibility(8);
            this.fbc.setVisibility(8);
        }
        if (this.faQ != null && this.faQ.showCombineDownload() && !TextUtils.isEmpty(this.faQ.getApkMD5RSA())) {
            this.faY.setText(this.faQ.getAppName());
            if (!x.isInstalledPackage(this.mContext, this.faQ.getAppProc()) && !TextUtils.isEmpty(this.faQ.getAppUrl())) {
                this.faY.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.faY.setCompoundDrawables(drawable, null, null, null);
                this.faR = true;
            } else {
                this.faY.setVisibility(8);
                this.faR = false;
            }
        } else {
            this.faY.setVisibility(8);
            this.faR = false;
        }
        jK(this.fbp);
        this.fbb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                e.this.dDJ = true;
                if (e.this.mOtherApkSelected) {
                    Drawable drawable2 = ao.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.faY.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.fbm.jM(e.this.mOtherApkSelected);
            }
        });
        this.fbd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.fbq) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                e.this.fbd.setEnabled(false);
                e.this.fbm.jN(e.this.mOtherApkSelected);
            }
        });
        this.faZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.fbm.brs();
            }
        });
        this.faY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.dDJ) {
                    if (e.this.mOtherApkSelected) {
                        Drawable drawable2 = ao.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.faY.setCompoundDrawables(drawable2, null, null, null);
                        e.this.faR = false;
                        e.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = ao.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.faY.setCompoundDrawables(drawable3, null, null, null);
                    e.this.faR = true;
                    e.this.mOtherApkSelected = true;
                }
            }
        });
        GH();
    }

    private void GH() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void jK(boolean z) {
        if (g.a(this.mContext.getPackageManager())) {
            this.fbe.setVisibility(8);
        } else {
            this.fbe.setVisibility(0);
        }
        if (z) {
            if (this.faP == null || TextUtils.isEmpty(this.faP.getPatch()) || this.faP.getNewVersionCode() < 0) {
                this.fbf.setVisibility(0);
                this.fbd.setText(R.string.super_update);
                ao.setBackgroundResource(this.fbd, R.drawable.dialog_middle_item_bg_selector);
                this.fbl.setVisibility(0);
                this.fbq = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.fbf.setVisibility(0);
            this.fbd.setText(R.string.incremental_update);
            ao.setBackgroundResource(this.fbd, R.drawable.dialog_single_button_bg_selector);
            this.fbk.setVisibility(8);
            this.fbl.setVisibility(8);
            this.fbq = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.faP == null || TextUtils.isEmpty(this.faP.getPatch()) || this.faP.getNewVersionCode() < 0) {
            this.fbf.setVisibility(8);
            this.fbl.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.fbf.setVisibility(0);
            ao.setBackgroundResource(this.fbd, R.drawable.dialog_middle_item_bg_selector);
            this.fbd.setText(R.string.incremental_update);
            this.fbl.setVisibility(0);
            this.fbq = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.fbb.setVisibility(8);
        this.fbf.setVisibility(8);
        this.faZ.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.dDJ = true;
        this.fbl.setVisibility(0);
        this.faW.setVisibility(0);
        this.faW.setText(this.faX + i + "%");
        this.fbc.setVisibility(8);
        this.fba.setVisibility(8);
    }

    public void jL(boolean z) {
        this.fbb.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.dDJ) {
            this.fbm.stopService();
            this.faT.setVisibility(8);
            if (this.faS) {
                this.fbh.setText(getContext().getString(R.string.download_exit));
            }
            this.fbg.setVisibility(0);
            return;
        }
        this.fbm.brt();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.faP = versionData;
        this.faQ = combineDownload;
        this.fbm = aVar;
    }

    public void brr() {
        this.fbg.setVisibility(8);
        this.faT.setVisibility(0);
    }

    public void j(View.OnClickListener onClickListener) {
        this.fbn = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.fbo = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        ao.setImageResource(this.fbc, R.drawable.write_close_selector);
    }

    public void el(Context context) {
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
