package com.baidu.tieba;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.VersionData;
/* loaded from: classes.dex */
public class ac extends Dialog {
    private VersionData acV;
    private CombineDownload acW;
    private boolean acX;
    private boolean acY;
    private boolean acZ;
    private boolean ada;
    private LinearLayout adb;
    private TextView adc;
    private TextView ade;
    private TextView adf;
    private String adg;
    private TextView adh;
    private TextView adi;
    private TextView adj;
    private TextView adk;
    private View adl;
    private LinearLayout adm;
    private TextView adn;
    private TextView ado;
    private TextView adp;
    private ah adq;
    private View.OnClickListener adr;
    private View.OnClickListener ads;
    private Context mContext;

    public ac(Context context, int i) {
        super(context, i);
        this.acX = false;
        this.acY = true;
        this.acZ = false;
        this.ada = false;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.app_download_dialog);
        this.adb = (LinearLayout) findViewById(v.app_info);
        this.adc = (TextView) findViewById(v.app_version_and_size);
        this.ade = (TextView) findViewById(v.app_description);
        this.adj = (TextView) findViewById(v.fullsize_download_button);
        this.adi = (TextView) findViewById(v.cancel_download_button);
        this.adf = (TextView) findViewById(v.download_process);
        this.adk = (TextView) findViewById(v.incremental_download_button);
        this.adl = findViewById(v.incremental_download_layout);
        this.adh = (TextView) findViewById(v.other_app_recommend);
        this.adg = this.adf.getText().toString();
        this.adm = (LinearLayout) findViewById(v.cancel_dialog);
        this.ado = (TextView) findViewById(v.sure_cancel);
        this.adp = (TextView) findViewById(v.cancel_button);
        this.adn = (TextView) findViewById(v.cancel_tip);
        this.ado.setOnClickListener(this.adr);
        this.adp.setOnClickListener(this.ads);
        String size = this.acV.getSize();
        String newVersion = this.acV.getNewVersion();
        String newVersionDesc = this.acV.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(y.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.c.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.adc.setText(sb.toString());
        this.ade.setText(newVersionDesc);
        if (this.acV.forceUpdate()) {
            this.ada = true;
            this.adi.setText(this.mContext.getString(y.quit));
        } else {
            this.adi.setText(this.mContext.getString(y.update_after));
        }
        if (this.acW != null && this.acW.showCombineDownload()) {
            this.adh.setText(this.acW.getAppName());
            if (!com.baidu.tieba.d.b.E(this.mContext, this.acW.getAppProc()) && !TextUtils.isEmpty(this.acW.getAppUrl())) {
                this.adh.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(u.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.adh.setCompoundDrawables(drawable, null, null, null);
                this.acX = true;
            } else {
                this.adh.setVisibility(8);
                this.acX = false;
            }
        } else {
            this.adh.setVisibility(8);
            this.acX = false;
        }
        if (this.acV == null || TextUtils.isEmpty(this.acV.getPatch()) || this.acV.getNewVersionCode() < 0) {
            this.adl.setVisibility(8);
        } else {
            this.adl.setVisibility(0);
        }
        this.adj.setOnClickListener(new ad(this));
        this.adk.setOnClickListener(new ae(this));
        this.adi.setOnClickListener(new af(this));
        this.adh.setOnClickListener(new ag(this));
    }

    public void dy(int i) {
        this.adj.setVisibility(8);
        this.adk.setVisibility(8);
        this.adi.setVisibility(8);
        this.adf.setVisibility(0);
        this.adf.setText(String.valueOf(this.adg) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.acZ) {
            this.adq.stopService();
            this.adb.setVisibility(8);
            if (this.ada) {
                this.adn.setText(getContext().getString(y.download_exit));
            }
            this.adm.setVisibility(0);
            return;
        }
        this.adq.wg();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, ah ahVar) {
        this.acV = versionData;
        this.acW = combineDownload;
        this.adq = ahVar;
    }

    public void we() {
        this.adm.setVisibility(8);
        this.adb.setVisibility(0);
    }

    public void d(View.OnClickListener onClickListener) {
        this.adr = onClickListener;
    }

    public void e(View.OnClickListener onClickListener) {
        this.ads = onClickListener;
    }

    public void changeSkinType(int i) {
        if (this.mContext instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.mContext;
            baseActivity.getLayoutMode().L(i == 1);
            baseActivity.getLayoutMode().h(findViewById(v.app_download_dialog_layout));
            if (this.acV == null || TextUtils.isEmpty(this.acV.getPatch()) || this.acV.getNewVersionCode() < 0) {
                this.adj.setBackgroundResource(u.update_button);
                com.baidu.tbadk.core.util.aw.b(this.adj, s.cp_cont_g, 1);
                return;
            }
            com.baidu.tbadk.core.util.aw.h((View) this.adj, u.cancel_button);
            com.baidu.tbadk.core.util.aw.b(this.adj, s.cp_cont_b, 1);
        }
    }
}
