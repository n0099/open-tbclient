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
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
/* loaded from: classes.dex */
public class ai extends Dialog {
    private VersionData alC;
    private CombineDownload alD;
    private boolean alE;
    private boolean alF;
    private boolean alG;
    private boolean alH;
    private LinearLayout alI;
    private TextView alJ;
    private TextView alK;
    private TextView alL;
    private String alM;
    private TextView alN;
    private TextView alO;
    private TextView alP;
    private TextView alQ;
    private View alR;
    private LinearLayout alS;
    private TextView alT;
    private TextView alU;
    private TextView alV;
    private an alW;
    private View.OnClickListener alX;
    private View.OnClickListener alY;
    private Context mContext;

    public ai(Context context, int i) {
        super(context, i);
        this.alE = false;
        this.alF = true;
        this.alG = false;
        this.alH = false;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.app_download_dialog);
        this.alI = (LinearLayout) findViewById(w.app_info);
        this.alJ = (TextView) findViewById(w.app_version_and_size);
        this.alK = (TextView) findViewById(w.app_description);
        this.alP = (TextView) findViewById(w.fullsize_download_button);
        this.alO = (TextView) findViewById(w.cancel_download_button);
        this.alL = (TextView) findViewById(w.download_process);
        this.alQ = (TextView) findViewById(w.incremental_download_button);
        this.alR = findViewById(w.incremental_download_layout);
        this.alN = (TextView) findViewById(w.other_app_recommend);
        this.alM = this.alL.getText().toString();
        this.alS = (LinearLayout) findViewById(w.cancel_dialog);
        this.alU = (TextView) findViewById(w.sure_cancel);
        this.alV = (TextView) findViewById(w.cancel_button);
        this.alT = (TextView) findViewById(w.cancel_tip);
        this.alU.setOnClickListener(this.alX);
        this.alV.setOnClickListener(this.alY);
        String size = this.alC.getSize();
        String newVersion = this.alC.getNewVersion();
        String newVersionDesc = this.alC.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(z.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.c.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.alJ.setText(sb.toString());
        this.alK.setText(newVersionDesc);
        if (this.alC.forceUpdate()) {
            this.alH = true;
            this.alO.setText(this.mContext.getString(z.quit));
        } else {
            this.alO.setText(this.mContext.getString(z.update_after));
        }
        if (this.alD != null && this.alD.showCombineDownload()) {
            this.alN.setText(this.alD.getAppName());
            if (!com.baidu.tieba.tbadkCore.ar.isInstalledPackage(this.mContext, this.alD.getAppProc()) && !TextUtils.isEmpty(this.alD.getAppUrl())) {
                this.alN.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(v.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.alN.setCompoundDrawables(drawable, null, null, null);
                this.alE = true;
            } else {
                this.alN.setVisibility(8);
                this.alE = false;
            }
        } else {
            this.alN.setVisibility(8);
            this.alE = false;
        }
        if (this.alC == null || TextUtils.isEmpty(this.alC.getPatch()) || this.alC.getNewVersionCode() < 0) {
            this.alR.setVisibility(8);
        } else {
            this.alR.setVisibility(0);
        }
        this.alP.setOnClickListener(new aj(this));
        this.alQ.setOnClickListener(new ak(this));
        this.alO.setOnClickListener(new al(this));
        this.alN.setOnClickListener(new am(this));
    }

    public void updateProgress(int i) {
        this.alP.setVisibility(8);
        this.alR.setVisibility(8);
        this.alO.setVisibility(8);
        this.alL.setVisibility(0);
        this.alL.setText(String.valueOf(this.alM) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.alG) {
            this.alW.stopService();
            this.alI.setVisibility(8);
            if (this.alH) {
                this.alT.setText(getContext().getString(z.download_exit));
            }
            this.alS.setVisibility(0);
            return;
        }
        this.alW.AN();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, an anVar) {
        this.alC = versionData;
        this.alD = combineDownload;
        this.alW = anVar;
    }

    public void AL() {
        this.alS.setVisibility(8);
        this.alI.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.alX = onClickListener;
    }

    public void g(View.OnClickListener onClickListener) {
        this.alY = onClickListener;
    }

    public void b(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ab(i == 1);
            tbPageContext.getLayoutMode().h(findViewById(w.app_download_dialog_layout));
            if (this.alC == null || TextUtils.isEmpty(this.alC.getPatch()) || this.alC.getNewVersionCode() < 0) {
                this.alP.setBackgroundResource(v.update_button);
                com.baidu.tbadk.core.util.bc.b(this.alP, t.cp_cont_g, 1);
                return;
            }
            com.baidu.tbadk.core.util.bc.i((View) this.alP, v.cancel_button);
            com.baidu.tbadk.core.util.bc.b(this.alP, t.cp_cont_b, 1);
        }
    }
}
