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
    private VersionData fPP;
    private CombineDownload fPQ;
    private boolean fPR;
    private boolean fPS;
    private boolean fPT;
    private LinearLayout fPU;
    private TextView fPV;
    private TextView fPW;
    private TextView fPX;
    private String fPY;
    private TextView fPZ;
    private TextView fQa;
    private TextView fQb;
    private TextView fQc;
    private ImageView fQd;
    private TextView fQe;
    private TextView fQf;
    private View fQg;
    private LinearLayout fQh;
    private TextView fQi;
    private TextView fQj;
    private TextView fQk;
    private View fQl;
    private LinearLayout fQm;
    private a fQn;
    private View.OnClickListener fQo;
    private View.OnClickListener fQp;
    private boolean fQq;
    private boolean fQr;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void bIG();

        void bIH();

        void lh(boolean z);

        void li(boolean z);

        void stopService();
    }

    public g(Context context, int i) {
        super(context, i);
        this.fPR = false;
        this.mOtherApkSelected = true;
        this.fPS = false;
        this.fPT = false;
        this.fQq = true;
        this.fQr = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == g.this.fQb.getId()) {
                    g.this.fQn.bIG();
                    g.this.eG(g.this.mContext);
                } else if (view.getId() == g.this.fQd.getId()) {
                    g.this.fQn.bIG();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.fPU = (LinearLayout) findViewById(R.id.app_info);
        this.fPV = (TextView) findViewById(R.id.app_version_and_size);
        this.fPW = (TextView) findViewById(R.id.app_description);
        this.fQc = (TextView) findViewById(R.id.fullsize_download_button);
        this.fQa = (TextView) findViewById(R.id.cancel_download_button);
        this.fQb = (TextView) findViewById(R.id.btn_update_save_flow);
        this.fQd = (ImageView) findViewById(R.id.img_close);
        this.fQb.setOnClickListener(this.mOnClickListener);
        this.fQd.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.fPX = (TextView) findViewById(R.id.download_process);
        this.fQe = (TextView) findViewById(R.id.incremental_download_button);
        this.fQf = (TextView) findViewById(R.id.not_install_as_tip);
        this.fQg = findViewById(R.id.incremental_download_layout);
        this.fPZ = (TextView) findViewById(R.id.other_app_recommend);
        this.fQl = findViewById(R.id.divider_under_button);
        this.fQm = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.fPY = this.fPX.getText().toString();
        this.fQh = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.fQj = (TextView) findViewById(R.id.sure_cancel);
        this.fQk = (TextView) findViewById(R.id.cancel_button);
        this.fQi = (TextView) findViewById(R.id.cancel_tip);
        this.fQj.setOnClickListener(this.fQo);
        this.fQk.setOnClickListener(this.fQp);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.fQq = true;
        } else {
            this.fQq = false;
        }
        String size = this.fPP.getSize();
        String newVersion = this.fPP.getNewVersion();
        String newVersionDesc = this.fPP.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.fPV.setText(sb.toString());
        this.fPW.setText(newVersionDesc);
        if (this.fPP.forceUpdate()) {
            this.fPT = true;
            this.fQa.setText(this.mContext.getString(R.string.quit));
            this.fQb.setVisibility(8);
            this.fQd.setVisibility(8);
        } else if (this.fPP.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.fQa.setVisibility(8);
        } else {
            this.fQa.setText(this.mContext.getString(R.string.update_after));
            this.fQb.setVisibility(8);
            this.fQd.setVisibility(8);
        }
        if (this.fPQ != null && this.fPQ.showCombineDownload() && !TextUtils.isEmpty(this.fPQ.getApkMD5RSA())) {
            this.fPZ.setText(this.fPQ.getAppName());
            if (!y.isInstalledPackage(this.mContext, this.fPQ.getAppProc()) && !TextUtils.isEmpty(this.fPQ.getAppUrl())) {
                this.fPZ.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.fPZ.setCompoundDrawables(drawable, null, null, null);
                this.fPR = true;
            } else {
                this.fPZ.setVisibility(8);
                this.fPR = false;
            }
        } else {
            this.fPZ.setVisibility(8);
            this.fPR = false;
        }
        lf(this.fQq);
        this.fQc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                g.this.fPS = true;
                if (g.this.mOtherApkSelected) {
                    Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    g.this.fPZ.setCompoundDrawables(drawable2, null, null, null);
                }
                g.this.fQn.lh(g.this.mOtherApkSelected);
            }
        });
        this.fQe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.fQr) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                g.this.fQe.setEnabled(false);
                g.this.fQn.li(g.this.mOtherApkSelected);
            }
        });
        this.fQa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.fQn.bIG();
            }
        });
        this.fPZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.fPS) {
                    if (g.this.mOtherApkSelected) {
                        Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        g.this.fPZ.setCompoundDrawables(drawable2, null, null, null);
                        g.this.fPR = false;
                        g.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = ap.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    g.this.fPZ.setCompoundDrawables(drawable3, null, null, null);
                    g.this.fPR = true;
                    g.this.mOtherApkSelected = true;
                }
            }
        });
        Pe();
    }

    private void Pe() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void lf(boolean z) {
        if (i.a(this.mContext.getPackageManager())) {
            this.fQf.setVisibility(8);
        } else {
            this.fQf.setVisibility(0);
        }
        if (z) {
            if (this.fPP == null || TextUtils.isEmpty(this.fPP.getPatch()) || this.fPP.getNewVersionCode() < 0) {
                this.fQg.setVisibility(0);
                this.fQe.setText(R.string.super_update);
                ap.setBackgroundResource(this.fQe, R.drawable.dialog_middle_item_bg_selector);
                this.fQm.setVisibility(0);
                this.fQr = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.fQg.setVisibility(0);
            this.fQe.setText(R.string.incremental_update);
            ap.setBackgroundResource(this.fQe, R.drawable.dialog_single_button_bg_selector);
            this.fQl.setVisibility(8);
            this.fQm.setVisibility(8);
            this.fQr = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.fPP == null || TextUtils.isEmpty(this.fPP.getPatch()) || this.fPP.getNewVersionCode() < 0) {
            this.fQg.setVisibility(8);
            this.fQm.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.fQg.setVisibility(0);
            ap.setBackgroundResource(this.fQe, R.drawable.dialog_middle_item_bg_selector);
            this.fQe.setText(R.string.incremental_update);
            this.fQm.setVisibility(0);
            this.fQr = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.fQc.setVisibility(8);
        this.fQg.setVisibility(8);
        this.fQa.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.fPS = true;
        this.fQm.setVisibility(0);
        this.fPX.setVisibility(0);
        this.fPX.setText(this.fPY + i + "%");
        this.fQd.setVisibility(8);
        this.fQb.setVisibility(8);
    }

    public void lg(boolean z) {
        this.fQc.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.fPS) {
            this.fQn.stopService();
            this.fPU.setVisibility(8);
            if (this.fPT) {
                this.fQi.setText(getContext().getString(R.string.download_exit));
            }
            this.fQh.setVisibility(0);
            return;
        }
        this.fQn.bIH();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.fPP = versionData;
        this.fPQ = combineDownload;
        this.fQn = aVar;
    }

    public void bIF() {
        this.fQh.setVisibility(8);
        this.fPU.setVisibility(0);
    }

    public void k(View.OnClickListener onClickListener) {
        this.fQo = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.fQp = onClickListener;
    }

    public void f(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        ap.setImageResource(this.fQd, R.drawable.write_close_selector);
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
