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
    private TextView aCF;
    private TextView aCG;
    private TextView aCH;
    private com.baidu.adp.plugin.packageManager.a.a aCI;
    private View ajA;
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
            this.aCI = (com.baidu.adp.plugin.packageManager.a.a) com.baidu.adp.plugin.packageManager.a.a.objectWithJsonStr(getIntent().getStringExtra(com.baidu.adp.plugin.packageManager.a.a.class.getName()), com.baidu.adp.plugin.packageManager.a.a.class);
        } else {
            this.aCI = (com.baidu.adp.plugin.packageManager.a.a) com.baidu.adp.plugin.packageManager.a.a.objectWithJsonStr(bundle.getString(com.baidu.adp.plugin.packageManager.a.a.class.getName()), com.baidu.adp.plugin.packageManager.a.a.class);
        }
        if (this.aCI == null) {
            finish();
            return;
        }
        setContentView(t.h.plugin_error_tip_activity);
        pU();
    }

    protected void pU() {
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.ajA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.ajA.setOnClickListener(this);
        this.mNavigationBar.setTitleText(t.j.pluginstatus_tip_title);
        this.aCF = (TextView) findViewById(t.g.plugin_error_tip_msg);
        this.aCG = (TextView) findViewById(t.g.plugin_error_tip_resolve);
        this.aCH = (TextView) findViewById(t.g.plugin_error_btn);
        this.aCH.setOnClickListener(this);
        this.aCF.setText(this.aCI.getErrorMsg());
        this.aCG.setText(this.aCI.lZ());
        if (this.aCI.getErrorCode() == 5 || this.aCI.getErrorCode() == 1 || this.aCI.getErrorCode() == 100) {
            this.aCH.setText(t.j.pluginstatus_btn_restartapp);
            this.aCH.setVisibility(0);
            return;
        }
        this.aCH.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String jsonStrWithObject = com.baidu.adp.plugin.packageManager.a.a.jsonStrWithObject(this.aCI);
        if (jsonStrWithObject != null) {
            bundle.putString(com.baidu.adp.plugin.packageManager.a.a.class.getName(), jsonStrWithObject);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ajA) {
            finish();
        } else if (view == this.aCH) {
            if (this.aCI != null && this.aCI.getErrorCode() == 100) {
                com.baidu.adp.plugin.b.a.lf().H(true);
            }
            showLoadingDialog(getResources().getString(t.j.waiting));
            h.hx().postDelayed(new a(this), 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
