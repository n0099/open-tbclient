package com.baidu.tbadk.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.h.h;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PluginErrorTipActivity extends BaseActivity<PluginErrorTipActivity> {
    private View afN;
    private TextView azA;
    private com.baidu.adp.plugin.packageManager.a.a azB;
    private TextView azy;
    private TextView azz;
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
            this.azB = (com.baidu.adp.plugin.packageManager.a.a) com.baidu.adp.plugin.packageManager.a.a.objectWithJsonStr(getIntent().getStringExtra(com.baidu.adp.plugin.packageManager.a.a.class.getName()), com.baidu.adp.plugin.packageManager.a.a.class);
        } else {
            this.azB = (com.baidu.adp.plugin.packageManager.a.a) com.baidu.adp.plugin.packageManager.a.a.objectWithJsonStr(bundle.getString(com.baidu.adp.plugin.packageManager.a.a.class.getName()), com.baidu.adp.plugin.packageManager.a.a.class);
        }
        if (this.azB == null) {
            finish();
            return;
        }
        setContentView(u.h.plugin_error_tip_activity);
        nl();
    }

    protected void nl() {
        this.mNavigationBar = (NavigationBar) findViewById(u.g.view_navigation_bar);
        this.afN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.afN.setOnClickListener(this);
        this.mNavigationBar.setTitleText(u.j.pluginstatus_tip_title);
        this.azy = (TextView) findViewById(u.g.plugin_error_tip_msg);
        this.azz = (TextView) findViewById(u.g.plugin_error_tip_resolve);
        this.azA = (TextView) findViewById(u.g.plugin_error_btn);
        this.azA.setOnClickListener(this);
        this.azy.setText(this.azB.getErrorMsg());
        this.azz.setText(this.azB.iq());
        if (this.azB.getErrorCode() == 5 || this.azB.getErrorCode() == 1 || this.azB.getErrorCode() == 100) {
            this.azA.setText(u.j.pluginstatus_btn_restartapp);
            this.azA.setVisibility(0);
            return;
        }
        this.azA.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String jsonStrWithObject = com.baidu.adp.plugin.packageManager.a.a.jsonStrWithObject(this.azB);
        if (jsonStrWithObject != null) {
            bundle.putString(com.baidu.adp.plugin.packageManager.a.a.class.getName(), jsonStrWithObject);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.afN) {
            finish();
        } else if (view == this.azA) {
            if (this.azB != null && this.azB.getErrorCode() == 100) {
                com.baidu.adp.plugin.b.a.hu().H(true);
            }
            showLoadingDialog(getResources().getString(u.j.waiting));
            h.dM().postDelayed(new a(this), 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
