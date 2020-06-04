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
    private VersionData eKW;
    private CombineDownload eKX;
    private boolean eKY;
    private boolean eKZ;
    private LinearLayout eLa;
    private TextView eLb;
    private TextView eLc;
    private TextView eLd;
    private String eLe;
    private TextView eLf;
    private TextView eLg;
    private TextView eLh;
    private TextView eLi;
    private ImageView eLj;
    private TextView eLk;
    private TextView eLl;
    private View eLm;
    private LinearLayout eLn;
    private TextView eLo;
    private TextView eLp;
    private TextView eLq;
    private View eLr;
    private LinearLayout eLs;
    private a eLt;
    private View.OnClickListener eLu;
    private View.OnClickListener eLv;
    private boolean eLw;
    private boolean eLx;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void bll();

        void blm();

        void iV(boolean z);

        void iW(boolean z);

        void stopService();
    }

    public e(Context context, int i) {
        super(context, i);
        this.eKY = false;
        this.mOtherApkSelected = true;
        this.dtd = false;
        this.eKZ = false;
        this.eLw = true;
        this.eLx = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.this.eLh.getId()) {
                    e.this.eLt.bll();
                    e.this.ef(e.this.mContext);
                } else if (view.getId() == e.this.eLj.getId()) {
                    e.this.eLt.bll();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.eLa = (LinearLayout) findViewById(R.id.app_info);
        this.eLb = (TextView) findViewById(R.id.app_version_and_size);
        this.eLc = (TextView) findViewById(R.id.app_description);
        this.eLi = (TextView) findViewById(R.id.fullsize_download_button);
        this.eLg = (TextView) findViewById(R.id.cancel_download_button);
        this.eLh = (TextView) findViewById(R.id.btn_update_save_flow);
        this.eLj = (ImageView) findViewById(R.id.img_close);
        this.eLh.setOnClickListener(this.mOnClickListener);
        this.eLj.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.eLd = (TextView) findViewById(R.id.download_process);
        this.eLk = (TextView) findViewById(R.id.incremental_download_button);
        this.eLl = (TextView) findViewById(R.id.not_install_as_tip);
        this.eLm = findViewById(R.id.incremental_download_layout);
        this.eLf = (TextView) findViewById(R.id.other_app_recommend);
        this.eLr = findViewById(R.id.divider_under_button);
        this.eLs = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.eLe = this.eLd.getText().toString();
        this.eLn = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.eLp = (TextView) findViewById(R.id.sure_cancel);
        this.eLq = (TextView) findViewById(R.id.cancel_button);
        this.eLo = (TextView) findViewById(R.id.cancel_tip);
        this.eLp.setOnClickListener(this.eLu);
        this.eLq.setOnClickListener(this.eLv);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.eLw = true;
        } else {
            this.eLw = false;
        }
        String size = this.eKW.getSize();
        String newVersion = this.eKW.getNewVersion();
        String newVersionDesc = this.eKW.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.eLb.setText(sb.toString());
        this.eLc.setText(newVersionDesc);
        if (this.eKW.forceUpdate()) {
            this.eKZ = true;
            this.eLg.setText(this.mContext.getString(R.string.quit));
            this.eLh.setVisibility(8);
            this.eLj.setVisibility(8);
        } else if (this.eKW.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.eLg.setVisibility(8);
        } else {
            this.eLg.setText(this.mContext.getString(R.string.update_after));
            this.eLh.setVisibility(8);
            this.eLj.setVisibility(8);
        }
        if (this.eKX != null && this.eKX.showCombineDownload() && !TextUtils.isEmpty(this.eKX.getApkMD5RSA())) {
            this.eLf.setText(this.eKX.getAppName());
            if (!x.isInstalledPackage(this.mContext, this.eKX.getAppProc()) && !TextUtils.isEmpty(this.eKX.getAppUrl())) {
                this.eLf.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.eLf.setCompoundDrawables(drawable, null, null, null);
                this.eKY = true;
            } else {
                this.eLf.setVisibility(8);
                this.eKY = false;
            }
        } else {
            this.eLf.setVisibility(8);
            this.eKY = false;
        }
        iT(this.eLw);
        this.eLi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                e.this.dtd = true;
                if (e.this.mOtherApkSelected) {
                    Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    e.this.eLf.setCompoundDrawables(drawable2, null, null, null);
                }
                e.this.eLt.iV(e.this.mOtherApkSelected);
            }
        });
        this.eLk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.eLx) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                e.this.eLk.setEnabled(false);
                e.this.eLt.iW(e.this.mOtherApkSelected);
            }
        });
        this.eLg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.eLt.bll();
            }
        });
        this.eLf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.this.dtd) {
                    if (e.this.mOtherApkSelected) {
                        Drawable drawable2 = am.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        e.this.eLf.setCompoundDrawables(drawable2, null, null, null);
                        e.this.eKY = false;
                        e.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = am.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    e.this.eLf.setCompoundDrawables(drawable3, null, null, null);
                    e.this.eKY = true;
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
            this.eLl.setVisibility(8);
        } else {
            this.eLl.setVisibility(0);
        }
        if (z) {
            if (this.eKW == null || TextUtils.isEmpty(this.eKW.getPatch()) || this.eKW.getNewVersionCode() < 0) {
                this.eLm.setVisibility(0);
                this.eLk.setText(R.string.super_update);
                am.setBackgroundResource(this.eLk, R.drawable.dialog_middle_item_bg_selector);
                this.eLs.setVisibility(0);
                this.eLx = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.eLm.setVisibility(0);
            this.eLk.setText(R.string.incremental_update);
            am.setBackgroundResource(this.eLk, R.drawable.dialog_single_button_bg_selector);
            this.eLr.setVisibility(8);
            this.eLs.setVisibility(8);
            this.eLx = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.eKW == null || TextUtils.isEmpty(this.eKW.getPatch()) || this.eKW.getNewVersionCode() < 0) {
            this.eLm.setVisibility(8);
            this.eLs.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.eLm.setVisibility(0);
            am.setBackgroundResource(this.eLk, R.drawable.dialog_middle_item_bg_selector);
            this.eLk.setText(R.string.incremental_update);
            this.eLs.setVisibility(0);
            this.eLx = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.eLi.setVisibility(8);
        this.eLm.setVisibility(8);
        this.eLg.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.dtd = true;
        this.eLs.setVisibility(0);
        this.eLd.setVisibility(0);
        this.eLd.setText(this.eLe + i + "%");
        this.eLj.setVisibility(8);
        this.eLh.setVisibility(8);
    }

    public void iU(boolean z) {
        this.eLi.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.dtd) {
            this.eLt.stopService();
            this.eLa.setVisibility(8);
            if (this.eKZ) {
                this.eLo.setText(getContext().getString(R.string.download_exit));
            }
            this.eLn.setVisibility(0);
            return;
        }
        this.eLt.blm();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.eKW = versionData;
        this.eKX = combineDownload;
        this.eLt = aVar;
    }

    public void blk() {
        this.eLn.setVisibility(8);
        this.eLa.setVisibility(0);
    }

    public void i(View.OnClickListener onClickListener) {
        this.eLu = onClickListener;
    }

    public void j(View.OnClickListener onClickListener) {
        this.eLv = onClickListener;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        am.setImageResource(this.eLj, R.drawable.write_close_selector);
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
