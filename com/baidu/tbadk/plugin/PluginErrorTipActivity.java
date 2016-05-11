package com.baidu.tbadk.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.h.h;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PluginErrorTipActivity extends BaseActivity<PluginErrorTipActivity> {
    private View afm;
    private TextView ayI;
    private TextView ayJ;
    private TextView ayK;
    private com.baidu.adp.plugin.packageManager.a.a ayL;
    private NavigationBar mNavigationBar;

    public static final void a(Context context, com.baidu.adp.plugin.packageManager.a.a aVar) {
        if (context != null && aVar != null) {
            Intent intent = new Intent(context, PluginErrorTipActivity.class);
            String jsonStrWithObject = com.baidu.adp.plugin.packageManager.a.a.jsonStrWithObject(aVar);
            if (jsonStrWithObject != null) {
                intent.putExtra(com.baidu.adp.plugin.packageManager.a.a.class.getName(), jsonStrWithObject);
                context.startActivity(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.ayL = (com.baidu.adp.plugin.packageManager.a.a) com.baidu.adp.plugin.packageManager.a.a.objectWithJsonStr(getIntent().getStringExtra(com.baidu.adp.plugin.packageManager.a.a.class.getName()), com.baidu.adp.plugin.packageManager.a.a.class);
        } else {
            this.ayL = (com.baidu.adp.plugin.packageManager.a.a) com.baidu.adp.plugin.packageManager.a.a.objectWithJsonStr(bundle.getString(com.baidu.adp.plugin.packageManager.a.a.class.getName()), com.baidu.adp.plugin.packageManager.a.a.class);
        }
        if (this.ayL == null) {
            finish();
            return;
        }
        setContentView(t.h.plugin_error_tip_activity);
        nq();
    }

    protected void nq() {
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.afm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.afm.setOnClickListener(this);
        this.mNavigationBar.setTitleText(t.j.pluginstatus_tip_title);
        this.ayI = (TextView) findViewById(t.g.plugin_error_tip_msg);
        this.ayJ = (TextView) findViewById(t.g.plugin_error_tip_resolve);
        this.ayK = (TextView) findViewById(t.g.plugin_error_btn);
        this.ayK.setOnClickListener(this);
        this.ayI.setText(this.ayL.getErrorMsg());
        this.ayJ.setText(this.ayL.in());
        if (this.ayL.getErrorCode() == 5 || this.ayL.getErrorCode() == 1 || this.ayL.getErrorCode() == 100) {
            this.ayK.setText(t.j.pluginstatus_btn_restartapp);
            this.ayK.setVisibility(0);
            return;
        }
        this.ayK.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String jsonStrWithObject = com.baidu.adp.plugin.packageManager.a.a.jsonStrWithObject(this.ayL);
        if (jsonStrWithObject != null) {
            bundle.putString(com.baidu.adp.plugin.packageManager.a.a.class.getName(), jsonStrWithObject);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.afm) {
            finish();
        } else if (view == this.ayK) {
            if (this.ayL != null && this.ayL.getErrorCode() == 100) {
                com.baidu.adp.plugin.b.a.hs().H(true);
            }
            showLoadingDialog(getResources().getString(t.j.waiting));
            h.dL().postDelayed(new a(this), 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
