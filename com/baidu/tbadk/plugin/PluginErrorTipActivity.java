package com.baidu.tbadk.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.g.h;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PluginErrorTipActivity extends BaseActivity<PluginErrorTipActivity> {
    private TextView axk;
    private TextView axl;
    private TextView axm;
    private com.baidu.adp.plugin.packageManager.a.a axn;
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
            this.axn = (com.baidu.adp.plugin.packageManager.a.a) com.baidu.adp.plugin.packageManager.a.a.objectWithJsonStr(getIntent().getStringExtra(com.baidu.adp.plugin.packageManager.a.a.class.getName()), com.baidu.adp.plugin.packageManager.a.a.class);
        } else {
            this.axn = (com.baidu.adp.plugin.packageManager.a.a) com.baidu.adp.plugin.packageManager.a.a.objectWithJsonStr(bundle.getString(com.baidu.adp.plugin.packageManager.a.a.class.getName()), com.baidu.adp.plugin.packageManager.a.a.class);
        }
        if (this.axn == null) {
            finish();
            return;
        }
        setContentView(i.g.plugin_error_tip_activity);
        initUI();
    }

    protected void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mBack.setOnClickListener(this);
        this.mNavigationBar.setTitleText(i.h.pluginstatus_tip_title);
        this.axk = (TextView) findViewById(i.f.plugin_error_tip_msg);
        this.axl = (TextView) findViewById(i.f.plugin_error_tip_resolve);
        this.axm = (TextView) findViewById(i.f.plugin_error_btn);
        this.axm.setOnClickListener(this);
        this.axk.setText(this.axn.getErrorMsg());
        this.axl.setText(this.axn.mt());
        if (this.axn.getErrorCode() == 5 || this.axn.getErrorCode() == 1 || this.axn.getErrorCode() == 100) {
            this.axm.setText(i.h.pluginstatus_btn_restartapp);
            this.axm.setVisibility(0);
            return;
        }
        this.axm.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String jsonStrWithObject = com.baidu.adp.plugin.packageManager.a.a.jsonStrWithObject(this.axn);
        if (jsonStrWithObject != null) {
            bundle.putString(com.baidu.adp.plugin.packageManager.a.a.class.getName(), jsonStrWithObject);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mBack) {
            finish();
        } else if (view == this.axm) {
            if (this.axn != null && this.axn.getErrorCode() == 100) {
                com.baidu.adp.plugin.b.a.lG().M(true);
            }
            showLoadingDialog(getResources().getString(i.h.waiting));
            h.hh().postDelayed(new a(this), 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
