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
    private View cDw;
    private boolean dfk;
    private View dividerLine;
    private a ewA;
    private View.OnClickListener ewB;
    private View.OnClickListener ewC;
    private boolean ewD;
    private boolean ewE;
    private VersionData ewe;
    private CombineDownload ewf;
    private boolean ewg;
    private boolean ewh;
    private LinearLayout ewi;
    private TextView ewj;
    private TextView ewk;
    private TextView ewl;
    private String ewm;
    private TextView ewn;
    private TextView ewo;
    private TextView ewp;
    private TextView ewq;
    private ImageView ewr;
    private TextView ews;
    private TextView ewt;
    private View ewu;
    private LinearLayout ewv;
    private TextView eww;
    private TextView ewx;
    private TextView ewy;
    private LinearLayout ewz;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void beZ();

        void bfa();

        void iy(boolean z);

        void iz(boolean z);

        void stopService();
    }

    public d(Context context, int i) {
        super(context, i);
        this.ewg = false;
        this.mOtherApkSelected = true;
        this.dfk = false;
        this.ewh = false;
        this.ewD = true;
        this.ewE = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.this.ewp.getId()) {
                    d.this.ewA.beZ();
                    d.this.ea(d.this.mContext);
                } else if (view.getId() == d.this.ewr.getId()) {
                    d.this.ewA.beZ();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.ewi = (LinearLayout) findViewById(R.id.app_info);
        this.ewj = (TextView) findViewById(R.id.app_version_and_size);
        this.ewk = (TextView) findViewById(R.id.app_description);
        this.ewq = (TextView) findViewById(R.id.fullsize_download_button);
        this.ewo = (TextView) findViewById(R.id.cancel_download_button);
        this.ewp = (TextView) findViewById(R.id.btn_update_save_flow);
        this.ewr = (ImageView) findViewById(R.id.img_close);
        this.ewp.setOnClickListener(this.mOnClickListener);
        this.ewr.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.ewl = (TextView) findViewById(R.id.download_process);
        this.ews = (TextView) findViewById(R.id.incremental_download_button);
        this.ewt = (TextView) findViewById(R.id.not_install_as_tip);
        this.ewu = findViewById(R.id.incremental_download_layout);
        this.ewn = (TextView) findViewById(R.id.other_app_recommend);
        this.cDw = findViewById(R.id.divider_under_button);
        this.ewz = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.ewm = this.ewl.getText().toString();
        this.ewv = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.ewx = (TextView) findViewById(R.id.sure_cancel);
        this.ewy = (TextView) findViewById(R.id.cancel_button);
        this.eww = (TextView) findViewById(R.id.cancel_tip);
        this.ewx.setOnClickListener(this.ewB);
        this.ewy.setOnClickListener(this.ewC);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.ewD = true;
        } else {
            this.ewD = false;
        }
        String size = this.ewe.getSize();
        String newVersion = this.ewe.getNewVersion();
        String newVersionDesc = this.ewe.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.ewj.setText(sb.toString());
        this.ewk.setText(newVersionDesc);
        if (this.ewe.forceUpdate()) {
            this.ewh = true;
            this.ewo.setText(this.mContext.getString(R.string.quit));
            this.ewp.setVisibility(8);
            this.ewr.setVisibility(8);
        } else if (this.ewe.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.ewo.setVisibility(8);
        } else {
            this.ewo.setText(this.mContext.getString(R.string.update_after));
            this.ewp.setVisibility(8);
            this.ewr.setVisibility(8);
        }
        if (this.ewf != null && this.ewf.showCombineDownload() && !TextUtils.isEmpty(this.ewf.getApkMD5RSA())) {
            this.ewn.setText(this.ewf.getAppName());
            if (!x.isInstalledPackage(this.mContext, this.ewf.getAppProc()) && !TextUtils.isEmpty(this.ewf.getAppUrl())) {
                this.ewn.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.ewn.setCompoundDrawables(drawable, null, null, null);
                this.ewg = true;
            } else {
                this.ewn.setVisibility(8);
                this.ewg = false;
            }
        } else {
            this.ewn.setVisibility(8);
            this.ewg = false;
        }
        iw(this.ewD);
        this.ewq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                d.this.dfk = true;
                if (d.this.mOtherApkSelected) {
                    Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    d.this.ewn.setCompoundDrawables(drawable2, null, null, null);
                }
                d.this.ewA.iy(d.this.mOtherApkSelected);
            }
        });
        this.ews.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ewE) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                d.this.ews.setEnabled(false);
                d.this.ewA.iz(d.this.mOtherApkSelected);
            }
        });
        this.ewo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.ewA.beZ();
            }
        });
        this.ewn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.dfk) {
                    if (d.this.mOtherApkSelected) {
                        Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        d.this.ewn.setCompoundDrawables(drawable2, null, null, null);
                        d.this.ewg = false;
                        d.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = am.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    d.this.ewn.setCompoundDrawables(drawable3, null, null, null);
                    d.this.ewg = true;
                    d.this.mOtherApkSelected = true;
                }
            }
        });
        Di();
    }

    private void Di() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void iw(boolean z) {
        if (f.a(this.mContext.getPackageManager())) {
            this.ewt.setVisibility(8);
        } else {
            this.ewt.setVisibility(0);
        }
        if (z) {
            if (this.ewe == null || TextUtils.isEmpty(this.ewe.getPatch()) || this.ewe.getNewVersionCode() < 0) {
                this.ewu.setVisibility(0);
                this.ews.setText(R.string.super_update);
                am.setBackgroundResource(this.ews, R.drawable.dialog_middle_item_bg_selector);
                this.ewz.setVisibility(0);
                this.ewE = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.ewu.setVisibility(0);
            this.ews.setText(R.string.incremental_update);
            am.setBackgroundResource(this.ews, R.drawable.dialog_single_button_bg_selector);
            this.cDw.setVisibility(8);
            this.ewz.setVisibility(8);
            this.ewE = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.ewe == null || TextUtils.isEmpty(this.ewe.getPatch()) || this.ewe.getNewVersionCode() < 0) {
            this.ewu.setVisibility(8);
            this.ewz.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.ewu.setVisibility(0);
            am.setBackgroundResource(this.ews, R.drawable.dialog_middle_item_bg_selector);
            this.ews.setText(R.string.incremental_update);
            this.ewz.setVisibility(0);
            this.ewE = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.ewq.setVisibility(8);
        this.ewu.setVisibility(8);
        this.ewo.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.dfk = true;
        this.ewz.setVisibility(0);
        this.ewl.setVisibility(0);
        this.ewl.setText(this.ewm + i + "%");
        this.ewr.setVisibility(8);
        this.ewp.setVisibility(8);
    }

    public void ix(boolean z) {
        this.ewq.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.dfk) {
            this.ewA.stopService();
            this.ewi.setVisibility(8);
            if (this.ewh) {
                this.eww.setText(getContext().getString(R.string.download_exit));
            }
            this.ewv.setVisibility(0);
            return;
        }
        this.ewA.bfa();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.ewe = versionData;
        this.ewf = combineDownload;
        this.ewA = aVar;
    }

    public void beY() {
        this.ewv.setVisibility(8);
        this.ewi.setVisibility(0);
    }

    public void i(View.OnClickListener onClickListener) {
        this.ewB = onClickListener;
    }

    public void j(View.OnClickListener onClickListener) {
        this.ewC = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        am.setImageResource(this.ewr, R.drawable.write_close_selector);
    }

    public void ea(Context context) {
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
