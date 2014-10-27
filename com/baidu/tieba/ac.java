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
    private VersionData acQ;
    private CombineDownload acR;
    private boolean acS;
    private boolean acT;
    private boolean acU;
    private boolean acV;
    private LinearLayout acW;
    private TextView acX;
    private TextView acY;
    private TextView acZ;
    private String ada;
    private TextView adb;
    private TextView adc;
    private TextView ade;
    private TextView adf;
    private View adg;
    private LinearLayout adh;
    private TextView adi;
    private TextView adj;
    private TextView adk;
    private ah adl;
    private View.OnClickListener adm;
    private View.OnClickListener adn;
    private Context mContext;

    public ac(Context context, int i) {
        super(context, i);
        this.acS = false;
        this.acT = true;
        this.acU = false;
        this.acV = false;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.app_download_dialog);
        this.acW = (LinearLayout) findViewById(v.app_info);
        this.acX = (TextView) findViewById(v.app_version_and_size);
        this.acY = (TextView) findViewById(v.app_description);
        this.ade = (TextView) findViewById(v.fullsize_download_button);
        this.adc = (TextView) findViewById(v.cancel_download_button);
        this.acZ = (TextView) findViewById(v.download_process);
        this.adf = (TextView) findViewById(v.incremental_download_button);
        this.adg = findViewById(v.incremental_download_layout);
        this.adb = (TextView) findViewById(v.other_app_recommend);
        this.ada = this.acZ.getText().toString();
        this.adh = (LinearLayout) findViewById(v.cancel_dialog);
        this.adj = (TextView) findViewById(v.sure_cancel);
        this.adk = (TextView) findViewById(v.cancel_button);
        this.adi = (TextView) findViewById(v.cancel_tip);
        this.adj.setOnClickListener(this.adm);
        this.adk.setOnClickListener(this.adn);
        String size = this.acQ.getSize();
        String newVersion = this.acQ.getNewVersion();
        String newVersionDesc = this.acQ.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getString(y.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.g.c.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.acX.setText(sb.toString());
        this.acY.setText(newVersionDesc);
        if (this.acQ.forceUpdate()) {
            this.acV = true;
            this.adc.setText(this.mContext.getString(y.quit));
        } else {
            this.adc.setText(this.mContext.getString(y.update_after));
        }
        if (this.acR != null && this.acR.showCombineDownload()) {
            this.adb.setText(this.acR.getAppName());
            if (!com.baidu.tieba.d.b.E(this.mContext, this.acR.getAppProc()) && !TextUtils.isEmpty(this.acR.getAppUrl())) {
                this.adb.setVisibility(0);
                Drawable drawable = this.mContext.getResources().getDrawable(u.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.adb.setCompoundDrawables(drawable, null, null, null);
                this.acS = true;
            } else {
                this.adb.setVisibility(8);
                this.acS = false;
            }
        } else {
            this.adb.setVisibility(8);
            this.acS = false;
        }
        if (this.acQ == null || TextUtils.isEmpty(this.acQ.getPatch()) || this.acQ.getNewVersionCode() < 0) {
            this.adg.setVisibility(8);
        } else {
            this.adg.setVisibility(0);
        }
        this.ade.setOnClickListener(new ad(this));
        this.adf.setOnClickListener(new ae(this));
        this.adc.setOnClickListener(new af(this));
        this.adb.setOnClickListener(new ag(this));
    }

    public void dy(int i) {
        this.ade.setVisibility(8);
        this.adf.setVisibility(8);
        this.adc.setVisibility(8);
        this.acZ.setVisibility(0);
        this.acZ.setText(String.valueOf(this.ada) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.acU) {
            this.adl.stopService();
            this.acW.setVisibility(8);
            if (this.acV) {
                this.adi.setText(getContext().getString(y.download_exit));
            }
            this.adh.setVisibility(0);
            return;
        }
        this.adl.we();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, ah ahVar) {
        this.acQ = versionData;
        this.acR = combineDownload;
        this.adl = ahVar;
    }

    public void wc() {
        this.adh.setVisibility(8);
        this.acW.setVisibility(0);
    }

    public void d(View.OnClickListener onClickListener) {
        this.adm = onClickListener;
    }

    public void e(View.OnClickListener onClickListener) {
        this.adn = onClickListener;
    }

    public void changeSkinType(int i) {
        if (this.mContext instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.mContext;
            baseActivity.getLayoutMode().L(i == 1);
            baseActivity.getLayoutMode().h(findViewById(v.app_download_dialog_layout));
            if (this.acQ == null || TextUtils.isEmpty(this.acQ.getPatch()) || this.acQ.getNewVersionCode() < 0) {
                this.ade.setBackgroundResource(u.update_button);
                com.baidu.tbadk.core.util.aw.b(this.ade, s.cp_cont_g, 1);
                return;
            }
            com.baidu.tbadk.core.util.aw.h((View) this.ade, u.cancel_button);
            com.baidu.tbadk.core.util.aw.b(this.ade, s.cp_cont_b, 1);
        }
    }
}
