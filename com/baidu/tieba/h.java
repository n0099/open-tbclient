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
    private VersionData geX;
    private CombineDownload geY;
    private boolean geZ;
    private boolean gfa;
    private boolean gfb;
    private LinearLayout gfc;
    private TextView gfd;
    private TextView gfe;
    private TextView gff;
    private String gfg;
    private TextView gfh;
    private TextView gfi;
    private TextView gfj;
    private TextView gfk;
    private ImageView gfl;
    private TextView gfm;
    private TextView gfn;
    private View gfo;
    private LinearLayout gfp;
    private TextView gfq;
    private TextView gfr;
    private TextView gfs;
    private View gft;
    private LinearLayout gfu;
    private a gfv;
    private View.OnClickListener gfw;
    private boolean gfx;
    private boolean gfy;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private boolean mOtherApkSelected;

    /* loaded from: classes.dex */
    interface a {
        void bKE();

        void bKF();

        void ma(boolean z);

        void mb(boolean z);

        void stopService();
    }

    public h(Context context, int i) {
        super(context, i);
        this.geZ = false;
        this.mOtherApkSelected = true;
        this.gfa = false;
        this.gfb = false;
        this.gfx = true;
        this.gfy = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.h.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == h.this.gfj.getId()) {
                    h.this.gfv.bKE();
                    h.this.fD(h.this.mContext);
                } else if (view.getId() == h.this.gfl.getId()) {
                    h.this.gfv.bKE();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_download_dialog);
        this.gfc = (LinearLayout) findViewById(R.id.app_info);
        this.gfd = (TextView) findViewById(R.id.app_version_and_size);
        this.gfe = (TextView) findViewById(R.id.app_description);
        this.gfk = (TextView) findViewById(R.id.fullsize_download_button);
        this.gfi = (TextView) findViewById(R.id.cancel_download_button);
        this.gfj = (TextView) findViewById(R.id.btn_update_save_flow);
        this.gfl = (ImageView) findViewById(R.id.img_close);
        this.gfj.setOnClickListener(this.mOnClickListener);
        this.gfl.setOnClickListener(this.mOnClickListener);
        this.dividerLine = findViewById(R.id.divider_line);
        this.gff = (TextView) findViewById(R.id.download_process);
        this.gfm = (TextView) findViewById(R.id.incremental_download_button);
        this.gfn = (TextView) findViewById(R.id.not_install_as_tip);
        this.gfo = findViewById(R.id.incremental_download_layout);
        this.gfh = (TextView) findViewById(R.id.other_app_recommend);
        this.gft = findViewById(R.id.divider_under_button);
        this.gfu = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
        this.gfg = this.gff.getText().toString();
        this.gfp = (LinearLayout) findViewById(R.id.cancel_dialog);
        this.gfr = (TextView) findViewById(R.id.sure_cancel);
        this.gfs = (TextView) findViewById(R.id.cancel_button);
        this.gfq = (TextView) findViewById(R.id.cancel_tip);
        this.gfr.setOnClickListener(this.eKr);
        this.gfs.setOnClickListener(this.gfw);
        if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
            this.gfx = true;
        } else {
            this.gfx = false;
        }
        String size = this.geX.getSize();
        String newVersion = this.geX.getNewVersion();
        String newVersionDesc = this.geX.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(R.string.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.gfd.setText(sb.toString());
        this.gfe.setText(newVersionDesc);
        if (this.geX.forceUpdate()) {
            this.gfb = true;
            this.gfi.setText(this.mContext.getString(R.string.quit));
            this.gfj.setVisibility(8);
            this.gfl.setVisibility(8);
        } else if (this.geX.isOfficialVersion() && l.hasInstallApp(this.mContext, "com.tencent.android.qqdownloader")) {
            this.gfi.setVisibility(8);
        } else {
            this.gfi.setText(this.mContext.getString(R.string.update_after));
            this.gfj.setVisibility(8);
            this.gfl.setVisibility(8);
        }
        if (this.geY != null && this.geY.showCombineDownload() && !TextUtils.isEmpty(this.geY.getApkMD5RSA())) {
            this.gfh.setText(this.geY.getAppName());
            if (!z.isInstalledPackage(this.mContext, this.geY.getAppProc()) && !TextUtils.isEmpty(this.geY.getAppUrl())) {
                this.gfh.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.gfh.setCompoundDrawables(drawable, null, null, null);
                this.geZ = true;
            } else {
                this.gfh.setVisibility(8);
                this.geZ = false;
            }
        } else {
            this.gfh.setVisibility(8);
            this.geZ = false;
        }
        lY(this.gfx);
        this.gfk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                h.this.gfa = true;
                if (h.this.mOtherApkSelected) {
                    Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    h.this.gfh.setCompoundDrawables(drawable2, null, null, null);
                }
                h.this.gfv.ma(h.this.mOtherApkSelected);
            }
        });
        this.gfm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.gfy) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                h.this.gfm.setEnabled(false);
                h.this.gfv.mb(h.this.mOtherApkSelected);
            }
        });
        this.gfi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.gfv.bKE();
            }
        });
        this.gfh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!h.this.gfa) {
                    if (h.this.mOtherApkSelected) {
                        Drawable drawable2 = ap.getDrawable(R.drawable.btn_dailog_choose_n);
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        h.this.gfh.setCompoundDrawables(drawable2, null, null, null);
                        h.this.geZ = false;
                        h.this.mOtherApkSelected = false;
                        return;
                    }
                    Drawable drawable3 = ap.getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                    h.this.gfh.setCompoundDrawables(drawable3, null, null, null);
                    h.this.geZ = true;
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
            this.gfn.setVisibility(8);
        } else {
            this.gfn.setVisibility(0);
        }
        if (z) {
            if (this.geX == null || TextUtils.isEmpty(this.geX.getPatch()) || this.geX.getNewVersionCode() < 0) {
                this.gfo.setVisibility(0);
                this.gfm.setText(R.string.super_update);
                ap.setBackgroundResource(this.gfm, R.drawable.dialog_middle_item_bg_selector);
                this.gfu.setVisibility(0);
                this.gfy = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.gfo.setVisibility(0);
            this.gfm.setText(R.string.incremental_update);
            ap.setBackgroundResource(this.gfm, R.drawable.dialog_single_button_bg_selector);
            this.gft.setVisibility(8);
            this.gfu.setVisibility(8);
            this.gfy = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
        } else if (this.geX == null || TextUtils.isEmpty(this.geX.getPatch()) || this.geX.getNewVersionCode() < 0) {
            this.gfo.setVisibility(8);
            this.gfu.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        } else {
            this.gfo.setVisibility(0);
            ap.setBackgroundResource(this.gfm, R.drawable.dialog_middle_item_bg_selector);
            this.gfm.setText(R.string.incremental_update);
            this.gfu.setVisibility(0);
            this.gfy = true;
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void updateProgress(int i) {
        this.gfk.setVisibility(8);
        this.gfo.setVisibility(8);
        this.gfi.setVisibility(8);
        this.dividerLine.setVisibility(8);
        this.gfa = true;
        this.gfu.setVisibility(0);
        this.gff.setVisibility(0);
        this.gff.setText(this.gfg + i + "%");
        this.gfl.setVisibility(8);
        this.gfj.setVisibility(8);
    }

    public void lZ(boolean z) {
        this.gfk.setEnabled(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.gfa) {
            this.gfv.stopService();
            this.gfc.setVisibility(8);
            if (this.gfb) {
                this.gfq.setText(getContext().getString(R.string.download_exit));
            }
            this.gfp.setVisibility(0);
            return;
        }
        this.gfv.bKF();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, a aVar) {
        this.geX = versionData;
        this.geY = combineDownload;
        this.gfv = aVar;
    }

    public void bKD() {
        this.gfp.setVisibility(8);
        this.gfc.setVisibility(0);
    }

    public void l(View.OnClickListener onClickListener) {
        this.eKr = onClickListener;
    }

    public void m(View.OnClickListener onClickListener) {
        this.gfw = onClickListener;
    }

    public void f(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
        }
        ap.setImageResource(this.gfl, R.drawable.write_close_selector);
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
