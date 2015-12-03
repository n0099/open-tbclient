package com.baidu.tbadk.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.h.h;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PluginErrorTipActivity extends BaseActivity<PluginErrorTipActivity> {
    private TextView azp;
    private TextView azq;
    private TextView azr;
    private com.baidu.adp.plugin.packageManager.a.a azs;
    private View mBack;
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
            this.azs = (com.baidu.adp.plugin.packageManager.a.a) com.baidu.adp.plugin.packageManager.a.a.objectWithJsonStr(getIntent().getStringExtra(com.baidu.adp.plugin.packageManager.a.a.class.getName()), com.baidu.adp.plugin.packageManager.a.a.class);
        } else {
            this.azs = (com.baidu.adp.plugin.packageManager.a.a) com.baidu.adp.plugin.packageManager.a.a.objectWithJsonStr(bundle.getString(com.baidu.adp.plugin.packageManager.a.a.class.getName()), com.baidu.adp.plugin.packageManager.a.a.class);
        }
        if (this.azs == null) {
            finish();
            return;
        }
        setContentView(n.g.plugin_error_tip_activity);
        initUI();
    }

    protected void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(n.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mBack.setOnClickListener(this);
        this.mNavigationBar.setTitleText(n.i.pluginstatus_tip_title);
        this.azp = (TextView) findViewById(n.f.plugin_error_tip_msg);
        this.azq = (TextView) findViewById(n.f.plugin_error_tip_resolve);
        this.azr = (TextView) findViewById(n.f.plugin_error_btn);
        this.azr.setOnClickListener(this);
        this.azp.setText(this.azs.getErrorMsg());
        this.azq.setText(this.azs.mw());
        if (this.azs.getErrorCode() == 5 || this.azs.getErrorCode() == 1 || this.azs.getErrorCode() == 100) {
            this.azr.setText(n.i.pluginstatus_btn_restartapp);
            this.azr.setVisibility(0);
            return;
        }
        this.azr.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String jsonStrWithObject = com.baidu.adp.plugin.packageManager.a.a.jsonStrWithObject(this.azs);
        if (jsonStrWithObject != null) {
            bundle.putString(com.baidu.adp.plugin.packageManager.a.a.class.getName(), jsonStrWithObject);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mBack) {
            finish();
        } else if (view == this.azr) {
            if (this.azs != null && this.azs.getErrorCode() == 100) {
                com.baidu.adp.plugin.b.a.lI().M(true);
            }
            showLoadingDialog(getResources().getString(n.i.waiting));
            h.hj().postDelayed(new a(this), 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
