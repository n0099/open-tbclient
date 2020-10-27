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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.switchs.UpdateDialogStyleSyncSwitch;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes.dex */
public class g extends Dialog {
    private View dividerLine;
    private VersionData fJZ;
    private boolean fKA;
    private boolean fKB;
    private CombineDownload fKa;
    private boolean fKb;
    private boolean fKc;
    private boolean fKd;
    private LinearLayout fKe;
    private TextView fKf;
    private TextView fKg;
    private TextView fKh;
    private String fKi;
    private TextView fKj;
    private TextView fKk;
    private TextView fKl;
    private TextView fKm;
    private ImageView fKn;
    private TextView fKo;
    private TextView fKp;
    private View fKq;
    private LinearLayout fKr;
    private TextView fKs;
    private TextView fKt;
    private TextView fKu;
    private View fKv;
    private LinearLayout fKw;
    private a fKx;
    private View.OnClickListener fKy;
    private View.OnClickListener fKz;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void bGh();

        void bGi();

        void kY(boolean z);

        void kZ(boolean z);

        void stopService();
    }

    public g(Context context, int i) {
        super(context, i);
        this.fKb = false;
        this.mOtherApkSelected = true;
        this.fKc = false;
        this.fKd = false;
        this.fKA = true;
        this.fKB = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == g.this.fKl.getId()) {
                    g.this.fKx.bGh();
                    g.this.eG(g.this.mContext);
                } else if (view.getId() == g.this.fKn.getId()) {
                    g.this.fKx.bGh();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.fKe = (LinearLayout) findViewById(R.id.app_info);
        this.fKf = (TextView) findViewById(R.id.app_version_and_size);
        this.fKg = (TextView) findViewById(R.id.app_description);
        this.fKm = (TextView) findViewById(R.id.fullsize_download_button);
        this.fKk = (TextView) findViewById(R.id.cancel_download_button);
        this.fKl = (TextView) findViewById(R.id.btn_update_save_flow);
        this.fKn = (ImageView) findViewById(R.id.img_close);
        this.fKl.setOnClickListener(this.mOnClickListener);
        this.fKn.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.fKh = (TextView) findViewById(R.id.download_process);
        this.fKo = (TextView) findViewById(R.id.incremental_download_button);
        this.fKp = (TextView) findViewById(R.id.not_install_as_tip);
        this.fKq = findViewById(R.id.incremental_download_layout);
        this.fKj = (TextView) findViewById(R.id.other_app_recommend);
        this.fKv = findViewById(R.id.divider_under_button);
        this.fKw = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.fKi = this.fKh.getText().toString();
        this.fKr = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.fKt = (TextView) findViewById(R.id.sure_cancel);
        this.fKu = (TextView) findViewById(R.id.cancel_button);
        this.fKs = (TextView) findViewById(R.id.cancel_tip);
        this.fKt.setOnClickListener(this.fKy);
        this.fKu.setOnClickListener(this.fKz);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.fKA = true;
        } else {
            this.fKA = false;
        }
        String size = this.fJZ.getSize();
        String newVersion = this.fJZ.getNewVersion();
        String newVersionDesc = this.fJZ.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.fKf.setText(sb.toString());
        this.fKg.setText(newVersionDesc);
        if (this.fJZ.forceUpdate()) {
            this.fKd = true;
            this.fKk.setText(this.mContext.getString(R.string.quit));
            this.fKl.setVisibility(8);
            this.fKn.setVisibility(8);
        } else if (this.fJZ.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.fKk.setVisibility(8);
        } else {
            this.fKk.setText(this.mContext.getString(R.string.update_after));
            this.fKl.setVisibility(8);
            this.fKn.setVisibility(8);
        }
        if (this.fKa != null && this.fKa.showCombineDownload() && !TextUtils.isEmpty(this.fKa.getApkMD5RSA())) {
            this.fKj.setText(this.fKa.getAppName());
            if (!y.isInstalledPackage(this.mContext, this.fKa.getAppProc()) && !TextUtils.isEmpty(this.fKa.getAppUrl())) {
                this.fKj.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.fKj.setCompoundDrawables(drawable, null, null, null);
                this.fKb = true;
            } else {
                this.fKj.setVisibility(8);
                this.fKb = false;
            }
        } else {
            this.fKj.setVisibility(8);
            this.fKb = false;
        }
        kW(this.fKA);
        this.fKm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                g.this.fKc = true;
                if (g.this.mOtherApkSelected) {
                    Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    g.this.fKj.setCompoundDrawables(drawable2, null, null, null);
                }
                g.this.fKx.kY(g.this.mOtherApkSelected);
            }
        });
        this.fKo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.fKB) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                g.this.fKo.setEnabled(false);
                g.this.fKx.kZ(g.this.mOtherApkSelected);
            }
        });
        this.fKk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.fKx.bGh();
            }
        });
        this.fKj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.fKc) {
                    if (g.this.mOtherApkSelected) {
                        Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        g.this.fKj.setCompoundDrawables(drawable2, null, null, null);
                        g.this.fKb = false;
                        g.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = ap.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    g.this.fKj.setCompoundDrawables(drawable3, null, null, null);
                    g.this.fKb = true;
                    g.this.mOtherApkSelected = true;
                }
            }
        });
        OE();
    }

    private void OE() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void kW(boolean z) {
        if (i.a(this.mContext.getPackageManager())) {
            this.fKp.setVisibility(8);
        } else {
            this.fKp.setVisibility(0);
        }
        if (z) {
            if (this.fJZ == null || TextUtils.isEmpty(this.fJZ.getPatch()) || this.fJZ.getNewVersionCode() < 0) {
                this.fKq.setVisibility(0);
                this.fKo.setText(R.string.super_update);
                ap.setBackgroundResource(this.fKo, R.drawable.dialog_middle_item_bg_selector);
                this.fKw.setVisibility(0);
                this.fKB = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.fKq.setVisibility(0);
            this.fKo.setText(R.string.incremental_update);
            ap.setBackgroundResource(this.fKo, R.drawable.dialog_single_button_bg_selector);
            this.fKv.setVisibility(8);
            this.fKw.setVisibility(8);
            this.fKB = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.fJZ == null || TextUtils.isEmpty(this.fJZ.getPatch()) || this.fJZ.getNewVersionCode() < 0) {
            this.fKq.setVisibility(8);
            this.fKw.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.fKq.setVisibility(0);
            ap.setBackgroundResource(this.fKo, R.drawable.dialog_middle_item_bg_selector);
            this.fKo.setText(R.string.incremental_update);
            this.fKw.setVisibility(0);
            this.fKB = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.fKm.setVisibility(8);
        this.fKq.setVisibility(8);
        this.fKk.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.fKc = true;
        this.fKw.setVisibility(0);
        this.fKh.setVisibility(0);
        this.fKh.setText(this.fKi + i + "%");
        this.fKn.setVisibility(8);
        this.fKl.setVisibility(8);
    }

    public void kX(boolean z) {
        this.fKm.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.fKc) {
            this.fKx.stopService();
            this.fKe.setVisibility(8);
            if (this.fKd) {
                this.fKs.setText(getContext().getString(R.string.download_exit));
            }
            this.fKr.setVisibility(0);
            return;
        }
        this.fKx.bGi();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.fJZ = versionData;
        this.fKa = combineDownload;
        this.fKx = aVar;
    }

    public void bGg() {
        this.fKr.setVisibility(8);
        this.fKe.setVisibility(0);
    }

    public void j(View.OnClickListener onClickListener) {
        this.fKy = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.fKz = onClickListener;
    }

    public void f(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        ap.setImageResource(this.fKn, R.drawable.write_close_selector);
    }

    public void eG(Context context) {
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
