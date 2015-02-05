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
    private CombineDownload alA;
    private boolean alB;
    private boolean alC;
    private boolean alD;
    private boolean alE;
    private LinearLayout alF;
    private TextView alG;
    private TextView alH;
    private TextView alI;
    private String alJ;
    private TextView alK;
    private TextView alL;
    private TextView alM;
    private TextView alN;
    private View alO;
    private LinearLayout alP;
    private TextView alQ;
    private TextView alR;
    private TextView alS;
    private an alT;
    private View.OnClickListener alU;
    private View.OnClickListener alV;
    private VersionData alz;
    private Context mContext;

    public ai(Context context, int i) {
        super(context, i);
        this.alB = false;
        this.alC = true;
        this.alD = false;
        this.alE = false;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.app_download_dialog);
        this.alF = (LinearLayout) findViewById(w.app_info);
        this.alG = (TextView) findViewById(w.app_version_and_size);
        this.alH = (TextView) findViewById(w.app_description);
        this.alM = (TextView) findViewById(w.fullsize_download_button);
        this.alL = (TextView) findViewById(w.cancel_download_button);
        this.alI = (TextView) findViewById(w.download_process);
        this.alN = (TextView) findViewById(w.incremental_download_button);
        this.alO = findViewById(w.incremental_download_layout);
        this.alK = (TextView) findViewById(w.other_app_recommend);
        this.alJ = this.alI.getText().toString();
        this.alP = (LinearLayout) findViewById(w.cancel_dialog);
        this.alR = (TextView) findViewById(w.sure_cancel);
        this.alS = (TextView) findViewById(w.cancel_button);
        this.alQ = (TextView) findViewById(w.cancel_tip);
        this.alR.setOnClickListener(this.alU);
        this.alS.setOnClickListener(this.alV);
        String size = this.alz.getSize();
        String newVersion = this.alz.getNewVersion();
        String newVersionDesc = this.alz.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(z.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.c.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.alG.setText(sb.toString());
        this.alH.setText(newVersionDesc);
        if (this.alz.forceUpdate()) {
            this.alE = true;
            this.alL.setText(this.mContext.getString(z.quit));
        } else {
            this.alL.setText(this.mContext.getString(z.update_after));
        }
        if (this.alA != null && this.alA.showCombineDownload()) {
            this.alK.setText(this.alA.getAppName());
            if (!com.baidu.tieba.tbadkCore.ar.isInstalledPackage(this.mContext, this.alA.getAppProc()) && !TextUtils.isEmpty(this.alA.getAppUrl())) {
                this.alK.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(v.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.alK.setCompoundDrawables(drawable, null, null, null);
                this.alB = true;
            } else {
                this.alK.setVisibility(8);
                this.alB = false;
            }
        } else {
            this.alK.setVisibility(8);
            this.alB = false;
        }
        if (this.alz == null || TextUtils.isEmpty(this.alz.getPatch()) || this.alz.getNewVersionCode() < 0) {
            this.alO.setVisibility(8);
        } else {
            this.alO.setVisibility(0);
        }
        this.alM.setOnClickListener(new aj(this));
        this.alN.setOnClickListener(new ak(this));
        this.alL.setOnClickListener(new al(this));
        this.alK.setOnClickListener(new am(this));
    }

    public void updateProgress(int i) {
        this.alM.setVisibility(8);
        this.alO.setVisibility(8);
        this.alL.setVisibility(8);
        this.alI.setVisibility(0);
        this.alI.setText(String.valueOf(this.alJ) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.alD) {
            this.alT.stopService();
            this.alF.setVisibility(8);
            if (this.alE) {
                this.alQ.setText(getContext().getString(z.download_exit));
            }
            this.alP.setVisibility(0);
            return;
        }
        this.alT.AH();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, an anVar) {
        this.alz = versionData;
        this.alA = combineDownload;
        this.alT = anVar;
    }

    public void AF() {
        this.alP.setVisibility(8);
        this.alF.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.alU = onClickListener;
    }

    public void g(View.OnClickListener onClickListener) {
        this.alV = onClickListener;
    }

    public void b(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ab(i == 1);
            tbPageContext.getLayoutMode().h(findViewById(w.app_download_dialog_layout));
            if (this.alz == null || TextUtils.isEmpty(this.alz.getPatch()) || this.alz.getNewVersionCode() < 0) {
                this.alM.setBackgroundResource(v.update_button);
                com.baidu.tbadk.core.util.bc.b(this.alM, t.cp_cont_g, 1);
                return;
            }
            com.baidu.tbadk.core.util.bc.i((View) this.alM, v.cancel_button);
            com.baidu.tbadk.core.util.bc.b(this.alM, t.cp_cont_b, 1);
        }
    }
}
