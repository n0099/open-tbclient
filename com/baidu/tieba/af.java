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
public class af extends Dialog {
    private VersionData akI;
    private CombineDownload akJ;
    private boolean akK;
    private boolean akL;
    private boolean akM;
    private boolean akN;
    private LinearLayout akO;
    private TextView akP;
    private TextView akQ;
    private TextView akR;
    private String akS;
    private TextView akT;
    private TextView akU;
    private TextView akV;
    private TextView akW;
    private View akX;
    private LinearLayout akY;
    private TextView akZ;
    private TextView ala;
    private TextView alb;
    private ak alc;
    private View.OnClickListener ald;
    private View.OnClickListener ale;
    private Context mContext;

    public af(Context context, int i) {
        super(context, i);
        this.akK = false;
        this.akL = true;
        this.akM = false;
        this.akN = false;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.app_download_dialog);
        this.akO = (LinearLayout) findViewById(w.app_info);
        this.akP = (TextView) findViewById(w.app_version_and_size);
        this.akQ = (TextView) findViewById(w.app_description);
        this.akV = (TextView) findViewById(w.fullsize_download_button);
        this.akU = (TextView) findViewById(w.cancel_download_button);
        this.akR = (TextView) findViewById(w.download_process);
        this.akW = (TextView) findViewById(w.incremental_download_button);
        this.akX = findViewById(w.incremental_download_layout);
        this.akT = (TextView) findViewById(w.other_app_recommend);
        this.akS = this.akR.getText().toString();
        this.akY = (LinearLayout) findViewById(w.cancel_dialog);
        this.ala = (TextView) findViewById(w.sure_cancel);
        this.alb = (TextView) findViewById(w.cancel_button);
        this.akZ = (TextView) findViewById(w.cancel_tip);
        this.ala.setOnClickListener(this.ald);
        this.alb.setOnClickListener(this.ale);
        String size = this.akI.getSize();
        String newVersion = this.akI.getNewVersion();
        String newVersionDesc = this.akI.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(z.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.c.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.akP.setText(sb.toString());
        this.akQ.setText(newVersionDesc);
        if (this.akI.forceUpdate()) {
            this.akN = true;
            this.akU.setText(this.mContext.getString(z.quit));
        } else {
            this.akU.setText(this.mContext.getString(z.update_after));
        }
        if (this.akJ != null && this.akJ.showCombineDownload()) {
            this.akT.setText(this.akJ.getAppName());
            if (!com.baidu.tieba.tbadkCore.ar.isInstalledPackage(this.mContext, this.akJ.getAppProc()) && !TextUtils.isEmpty(this.akJ.getAppUrl())) {
                this.akT.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(v.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.akT.setCompoundDrawables(drawable, null, null, null);
                this.akK = true;
            } else {
                this.akT.setVisibility(8);
                this.akK = false;
            }
        } else {
            this.akT.setVisibility(8);
            this.akK = false;
        }
        if (this.akI == null || TextUtils.isEmpty(this.akI.getPatch()) || this.akI.getNewVersionCode() < 0) {
            this.akX.setVisibility(8);
        } else {
            this.akX.setVisibility(0);
        }
        this.akV.setOnClickListener(new ag(this));
        this.akW.setOnClickListener(new ah(this));
        this.akU.setOnClickListener(new ai(this));
        this.akT.setOnClickListener(new aj(this));
    }

    public void updateProgress(int i) {
        this.akV.setVisibility(8);
        this.akX.setVisibility(8);
        this.akU.setVisibility(8);
        this.akR.setVisibility(0);
        this.akR.setText(String.valueOf(this.akS) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.akM) {
            this.alc.stopService();
            this.akO.setVisibility(8);
            if (this.akN) {
                this.akZ.setText(getContext().getString(z.download_exit));
            }
            this.akY.setVisibility(0);
            return;
        }
        this.alc.Ap();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, ak akVar) {
        this.akI = versionData;
        this.akJ = combineDownload;
        this.alc = akVar;
    }

    public void An() {
        this.akY.setVisibility(8);
        this.akO.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.ald = onClickListener;
    }

    public void f(View.OnClickListener onClickListener) {
        this.ale = onClickListener;
    }

    public void b(TbPageContext<?> tbPageContext, int i) {
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ab(i == 1);
            tbPageContext.getLayoutMode().h(findViewById(w.app_download_dialog_layout));
            if (this.akI == null || TextUtils.isEmpty(this.akI.getPatch()) || this.akI.getNewVersionCode() < 0) {
                this.akV.setBackgroundResource(v.update_button);
                com.baidu.tbadk.core.util.ax.b(this.akV, t.cp_cont_g, 1);
                return;
            }
            com.baidu.tbadk.core.util.ax.i((View) this.akV, v.cancel_button);
            com.baidu.tbadk.core.util.ax.b(this.akV, t.cp_cont_b, 1);
        }
    }
}
