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
    private VersionData atE;
    private CombineDownload atF;
    private boolean atG;
    private boolean atH;
    private boolean atI;
    private boolean atJ;
    private LinearLayout atK;
    private TextView atL;
    private TextView atM;
    private TextView atN;
    private String atO;
    private TextView atP;
    private TextView atQ;
    private TextView atR;
    private TextView atS;
    private TextView atT;
    private View atU;
    private LinearLayout atV;
    private TextView atW;
    private TextView atX;
    private TextView atY;
    private ag atZ;
    private View.OnClickListener aua;
    private View.OnClickListener aub;
    private Context mContext;

    public ab(Context context, int i) {
        super(context, i);
        this.atG = false;
        this.atH = true;
        this.atI = false;
        this.atJ = false;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.app_download_dialog);
        this.atK = (LinearLayout) findViewById(v.app_info);
        this.atL = (TextView) findViewById(v.app_version_and_size);
        this.atM = (TextView) findViewById(v.app_description);
        this.atR = (TextView) findViewById(v.fullsize_download_button);
        this.atQ = (TextView) findViewById(v.cancel_download_button);
        this.atN = (TextView) findViewById(v.download_process);
        this.atS = (TextView) findViewById(v.incremental_download_button);
        this.atT = (TextView) findViewById(v.not_install_as_tip);
        this.atU = findViewById(v.incremental_download_layout);
        this.atP = (TextView) findViewById(v.other_app_recommend);
        this.atO = this.atN.getText().toString();
        this.atV = (LinearLayout) findViewById(v.cancel_dialog);
        this.atX = (TextView) findViewById(v.sure_cancel);
        this.atY = (TextView) findViewById(v.cancel_button);
        this.atW = (TextView) findViewById(v.cancel_tip);
        this.atX.setOnClickListener(this.aua);
        this.atY.setOnClickListener(this.aub);
        String size = this.atE.getSize();
        String newVersion = this.atE.getNewVersion();
        String newVersionDesc = this.atE.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(y.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.c.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.atL.setText(sb.toString());
        this.atM.setText(newVersionDesc);
        if (this.atE.forceUpdate()) {
            this.atJ = true;
            this.atQ.setText(this.mContext.getString(y.quit));
        } else {
            this.atQ.setText(this.mContext.getString(y.update_after));
        }
        if (this.atF != null && this.atF.showCombineDownload()) {
            this.atP.setText(this.atF.getAppName());
            if (!au.isInstalledPackage(this.mContext, this.atF.getAppProc()) && !TextUtils.isEmpty(this.atF.getAppUrl())) {
                this.atP.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(u.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.atP.setCompoundDrawables(drawable, null, null, null);
                this.atG = true;
            } else {
                this.atP.setVisibility(8);
                this.atG = false;
            }
        } else {
            this.atP.setVisibility(8);
            this.atG = false;
        }
        if (this.atE == null || TextUtils.isEmpty(this.atE.getPatch()) || this.atE.getNewVersionCode() < 0) {
            this.atU.setVisibility(8);
        } else {
            this.atU.setVisibility(0);
            if (ao.a(this.mContext.getPackageManager())) {
                this.atT.setVisibility(8);
            } else {
                this.atT.setVisibility(0);
            }
        }
        this.atR.setOnClickListener(new ac(this));
        this.atS.setOnClickListener(new ad(this));
        this.atQ.setOnClickListener(new ae(this));
        this.atP.setOnClickListener(new af(this));
    }

    public void updateProgress(int i) {
        this.atR.setVisibility(8);
        this.atU.setVisibility(8);
        this.atQ.setVisibility(8);
        this.atN.setVisibility(0);
        this.atN.setText(String.valueOf(this.atO) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.atI) {
            this.atZ.stopService();
            this.atK.setVisibility(8);
            if (this.atJ) {
                this.atW.setText(getContext().getString(y.download_exit));
            }
            this.atV.setVisibility(0);
            return;
        }
        this.atZ.DY();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, ag agVar) {
        this.atE = versionData;
        this.atF = combineDownload;
        this.atZ = agVar;
    }

    public void DW() {
        this.atV.setVisibility(8);
        this.atK.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.aua = onClickListener;
    }

    public void g(View.OnClickListener onClickListener) {
        this.aub = onClickListener;
    }

    public void b(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().X(i == 1);
            tbPageContext.getLayoutMode().h(findViewById(v.app_download_dialog_layout));
            if (this.atE == null || TextUtils.isEmpty(this.atE.getPatch()) || this.atE.getNewVersionCode() < 0) {
                this.atR.setBackgroundResource(u.update_button);
                ba.b(this.atR, s.cp_cont_g, 1);
                return;
            }
            ba.i((View) this.atR, u.cancel_button);
            ba.b(this.atR, s.cp_cont_b, 1);
        }
    }
}
