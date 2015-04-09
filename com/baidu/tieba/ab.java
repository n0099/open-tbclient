package com.baidu.tieba;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.tbadkCore.au;
/* loaded from: classes.dex */
public class ab extends Dialog {
    private VersionData atM;
    private CombineDownload atN;
    private boolean atO;
    private boolean atP;
    private boolean atQ;
    private boolean atR;
    private LinearLayout atS;
    private TextView atT;
    private TextView atU;
    private TextView atV;
    private String atW;
    private TextView atX;
    private TextView atY;
    private TextView atZ;
    private TextView aua;
    private TextView aub;
    private View auc;
    private LinearLayout aud;
    private TextView aue;
    private TextView auf;
    private TextView aug;
    private ag auh;
    private View.OnClickListener aui;
    private View.OnClickListener auj;
    private Context mContext;

    public ab(Context context, int i) {
        super(context, i);
        this.atO = false;
        this.atP = true;
        this.atQ = false;
        this.atR = false;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.app_download_dialog);
        this.atS = (LinearLayout) findViewById(v.app_info);
        this.atT = (TextView) findViewById(v.app_version_and_size);
        this.atU = (TextView) findViewById(v.app_description);
        this.atZ = (TextView) findViewById(v.fullsize_download_button);
        this.atY = (TextView) findViewById(v.cancel_download_button);
        this.atV = (TextView) findViewById(v.download_process);
        this.aua = (TextView) findViewById(v.incremental_download_button);
        this.aub = (TextView) findViewById(v.not_install_as_tip);
        this.auc = findViewById(v.incremental_download_layout);
        this.atX = (TextView) findViewById(v.other_app_recommend);
        this.atW = this.atV.getText().toString();
        this.aud = (LinearLayout) findViewById(v.cancel_dialog);
        this.auf = (TextView) findViewById(v.sure_cancel);
        this.aug = (TextView) findViewById(v.cancel_button);
        this.aue = (TextView) findViewById(v.cancel_tip);
        this.auf.setOnClickListener(this.aui);
        this.aug.setOnClickListener(this.auj);
        String size = this.atM.getSize();
        String newVersion = this.atM.getNewVersion();
        String newVersionDesc = this.atM.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(y.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.c.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.atT.setText(sb.toString());
        this.atU.setText(newVersionDesc);
        if (this.atM.forceUpdate()) {
            this.atR = true;
            this.atY.setText(this.mContext.getString(y.quit));
        } else {
            this.atY.setText(this.mContext.getString(y.update_after));
        }
        if (this.atN != null && this.atN.showCombineDownload()) {
            this.atX.setText(this.atN.getAppName());
            if (!au.isInstalledPackage(this.mContext, this.atN.getAppProc()) && !TextUtils.isEmpty(this.atN.getAppUrl())) {
                this.atX.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(u.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.atX.setCompoundDrawables(drawable, null, null, null);
                this.atO = true;
            } else {
                this.atX.setVisibility(8);
                this.atO = false;
            }
        } else {
            this.atX.setVisibility(8);
            this.atO = false;
        }
        if (this.atM == null || TextUtils.isEmpty(this.atM.getPatch()) || this.atM.getNewVersionCode() < 0) {
            this.auc.setVisibility(8);
        } else {
            this.auc.setVisibility(0);
            if (ao.a(this.mContext.getPackageManager())) {
                this.aub.setVisibility(8);
            } else {
                this.aub.setVisibility(0);
            }
        }
        this.atZ.setOnClickListener(new ac(this));
        this.aua.setOnClickListener(new ad(this));
        this.atY.setOnClickListener(new ae(this));
        this.atX.setOnClickListener(new af(this));
    }

    public void updateProgress(int i) {
        this.atZ.setVisibility(8);
        this.auc.setVisibility(8);
        this.atY.setVisibility(8);
        this.atV.setVisibility(0);
        this.atV.setText(String.valueOf(this.atW) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.atQ) {
            this.auh.stopService();
            this.atS.setVisibility(8);
            if (this.atR) {
                this.aue.setText(getContext().getString(y.download_exit));
            }
            this.aud.setVisibility(0);
            return;
        }
        this.auh.Ee();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, ag agVar) {
        this.atM = versionData;
        this.atN = combineDownload;
        this.auh = agVar;
    }

    public void Ec() {
        this.aud.setVisibility(8);
        this.atS.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.aui = onClickListener;
    }

    public void g(View.OnClickListener onClickListener) {
        this.auj = onClickListener;
    }

    public void b(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().X(i == 1);
            tbPageContext.getLayoutMode().h(findViewById(v.app_download_dialog_layout));
            if (this.atM == null || TextUtils.isEmpty(this.atM.getPatch()) || this.atM.getNewVersionCode() < 0) {
                this.atZ.setBackgroundResource(u.update_button);
                ba.b(this.atZ, s.cp_cont_g, 1);
                return;
            }
            ba.i((View) this.atZ, u.cancel_button);
            ba.b(this.atZ, s.cp_cont_b, 1);
        }
    }
}
