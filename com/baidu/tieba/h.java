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
import com.baidu.tieba.tbadkCore.z;
/* loaded from: classes.dex */
public class h extends Dialog {
    private View dividerLine;
    private View.OnClickListener eKr;
    private a gfA;
    private View.OnClickListener gfB;
    private boolean gfC;
    private boolean gfD;
    private VersionData gfc;
    private CombineDownload gfd;
    private boolean gfe;
    private boolean gff;
    private boolean gfg;
    private LinearLayout gfh;
    private TextView gfi;
    private TextView gfj;
    private TextView gfk;
    private String gfl;
    private TextView gfm;
    private TextView gfn;
    private TextView gfo;
    private TextView gfp;
    private ImageView gfq;
    private TextView gfr;
    private TextView gfs;
    private View gft;
    private LinearLayout gfu;
    private TextView gfv;
    private TextView gfw;
    private TextView gfx;
    private View gfy;
    private LinearLayout gfz;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void bKJ();

        void bKK();

        void ma(boolean z);

        void mb(boolean z);

        void stopService();
    }

    public h(Context context, int i) {
        super(context, i);
        this.gfe = false;
        this.mOtherApkSelected = true;
        this.gff = false;
        this.gfg = false;
        this.gfC = true;
        this.gfD = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.h.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == h.this.gfo.getId()) {
                    h.this.gfA.bKJ();
                    h.this.fD(h.this.mContext);
                } else if (view.getId() == h.this.gfq.getId()) {
                    h.this.gfA.bKJ();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.gfh = (LinearLayout) findViewById(R.id.app_info);
        this.gfi = (TextView) findViewById(R.id.app_version_and_size);
        this.gfj = (TextView) findViewById(R.id.app_description);
        this.gfp = (TextView) findViewById(R.id.fullsize_download_button);
        this.gfn = (TextView) findViewById(R.id.cancel_download_button);
        this.gfo = (TextView) findViewById(R.id.btn_update_save_flow);
        this.gfq = (ImageView) findViewById(R.id.img_close);
        this.gfo.setOnClickListener(this.mOnClickListener);
        this.gfq.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.gfk = (TextView) findViewById(R.id.download_process);
        this.gfr = (TextView) findViewById(R.id.incremental_download_button);
        this.gfs = (TextView) findViewById(R.id.not_install_as_tip);
        this.gft = findViewById(R.id.incremental_download_layout);
        this.gfm = (TextView) findViewById(R.id.other_app_recommend);
        this.gfy = findViewById(R.id.divider_under_button);
        this.gfz = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.gfl = this.gfk.getText().toString();
        this.gfu = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.gfw = (TextView) findViewById(R.id.sure_cancel);
        this.gfx = (TextView) findViewById(R.id.cancel_button);
        this.gfv = (TextView) findViewById(R.id.cancel_tip);
        this.gfw.setOnClickListener(this.eKr);
        this.gfx.setOnClickListener(this.gfB);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.gfC = true;
        } else {
            this.gfC = false;
        }
        String size = this.gfc.getSize();
        String newVersion = this.gfc.getNewVersion();
        String newVersionDesc = this.gfc.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.gfi.setText(sb.toString());
        this.gfj.setText(newVersionDesc);
        if (this.gfc.forceUpdate()) {
            this.gfg = true;
            this.gfn.setText(this.mContext.getString(R.string.quit));
            this.gfo.setVisibility(8);
            this.gfq.setVisibility(8);
        } else if (this.gfc.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.gfn.setVisibility(8);
        } else {
            this.gfn.setText(this.mContext.getString(R.string.update_after));
            this.gfo.setVisibility(8);
            this.gfq.setVisibility(8);
        }
        if (this.gfd != null && this.gfd.showCombineDownload() && !TextUtils.isEmpty(this.gfd.getApkMD5RSA())) {
            this.gfm.setText(this.gfd.getAppName());
            if (!z.isInstalledPackage(this.mContext, this.gfd.getAppProc()) && !TextUtils.isEmpty(this.gfd.getAppUrl())) {
                this.gfm.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.gfm.setCompoundDrawables(drawable, null, null, null);
                this.gfe = true;
            } else {
                this.gfm.setVisibility(8);
                this.gfe = false;
            }
        } else {
            this.gfm.setVisibility(8);
            this.gfe = false;
        }
        lY(this.gfC);
        this.gfp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                h.this.gff = true;
                if (h.this.mOtherApkSelected) {
                    Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    h.this.gfm.setCompoundDrawables(drawable2, null, null, null);
                }
                h.this.gfA.ma(h.this.mOtherApkSelected);
            }
        });
        this.gfr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.gfD) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                h.this.gfr.setEnabled(false);
                h.this.gfA.mb(h.this.mOtherApkSelected);
            }
        });
        this.gfn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.gfA.bKJ();
            }
        });
        this.gfm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!h.this.gff) {
                    if (h.this.mOtherApkSelected) {
                        Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        h.this.gfm.setCompoundDrawables(drawable2, null, null, null);
                        h.this.gfe = false;
                        h.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = ap.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    h.this.gfm.setCompoundDrawables(drawable3, null, null, null);
                    h.this.gfe = true;
                    h.this.mOtherApkSelected = true;
                }
            }
        });
        Hf();
    }

    private void Hf() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void lY(boolean z) {
        if (j.a(this.mContext.getPackageManager())) {
            this.gfs.setVisibility(8);
        } else {
            this.gfs.setVisibility(0);
        }
        if (z) {
            if (this.gfc == null || TextUtils.isEmpty(this.gfc.getPatch()) || this.gfc.getNewVersionCode() < 0) {
                this.gft.setVisibility(0);
                this.gfr.setText(R.string.super_update);
                ap.setBackgroundResource(this.gfr, R.drawable.dialog_middle_item_bg_selector);
                this.gfz.setVisibility(0);
                this.gfD = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.gft.setVisibility(0);
            this.gfr.setText(R.string.incremental_update);
            ap.setBackgroundResource(this.gfr, R.drawable.dialog_single_button_bg_selector);
            this.gfy.setVisibility(8);
            this.gfz.setVisibility(8);
            this.gfD = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.gfc == null || TextUtils.isEmpty(this.gfc.getPatch()) || this.gfc.getNewVersionCode() < 0) {
            this.gft.setVisibility(8);
            this.gfz.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.gft.setVisibility(0);
            ap.setBackgroundResource(this.gfr, R.drawable.dialog_middle_item_bg_selector);
            this.gfr.setText(R.string.incremental_update);
            this.gfz.setVisibility(0);
            this.gfD = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.gfp.setVisibility(8);
        this.gft.setVisibility(8);
        this.gfn.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.gff = true;
        this.gfz.setVisibility(0);
        this.gfk.setVisibility(0);
        this.gfk.setText(this.gfl + i + "%");
        this.gfq.setVisibility(8);
        this.gfo.setVisibility(8);
    }

    public void lZ(boolean z) {
        this.gfp.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.gff) {
            this.gfA.stopService();
            this.gfh.setVisibility(8);
            if (this.gfg) {
                this.gfv.setText(getContext().getString(R.string.download_exit));
            }
            this.gfu.setVisibility(0);
            return;
        }
        this.gfA.bKK();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.gfc = versionData;
        this.gfd = combineDownload;
        this.gfA = aVar;
    }

    public void bKI() {
        this.gfu.setVisibility(8);
        this.gfh.setVisibility(0);
    }

    public void l(View.OnClickListener onClickListener) {
        this.eKr = onClickListener;
    }

    public void m(View.OnClickListener onClickListener) {
        this.gfB = onClickListener;
    }

    public void f(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        ap.setImageResource(this.gfq, R.drawable.write_close_selector);
    }

    public void fD(Context context) {
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
