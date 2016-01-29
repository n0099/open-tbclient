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
    private TextView aBH;
    private TextView aBI;
    private TextView aBJ;
    private com.baidu.adp.plugin.packageManager.a.a aBK;
    private View ajk;
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
            this.aBK = (com.baidu.adp.plugin.packageManager.a.a) com.baidu.adp.plugin.packageManager.a.a.objectWithJsonStr(getIntent().getStringExtra(com.baidu.adp.plugin.packageManager.a.a.class.getName()), com.baidu.adp.plugin.packageManager.a.a.class);
        } else {
            this.aBK = (com.baidu.adp.plugin.packageManager.a.a) com.baidu.adp.plugin.packageManager.a.a.objectWithJsonStr(bundle.getString(com.baidu.adp.plugin.packageManager.a.a.class.getName()), com.baidu.adp.plugin.packageManager.a.a.class);
        }
        if (this.aBK == null) {
            finish();
            return;
        }
        setContentView(t.h.plugin_error_tip_activity);
        qD();
    }

    protected void qD() {
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.ajk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.ajk.setOnClickListener(this);
        this.mNavigationBar.setTitleText(t.j.pluginstatus_tip_title);
        this.aBH = (TextView) findViewById(t.g.plugin_error_tip_msg);
        this.aBI = (TextView) findViewById(t.g.plugin_error_tip_resolve);
        this.aBJ = (TextView) findViewById(t.g.plugin_error_btn);
        this.aBJ.setOnClickListener(this);
        this.aBH.setText(this.aBK.getErrorMsg());
        this.aBI.setText(this.aBK.mh());
        if (this.aBK.getErrorCode() == 5 || this.aBK.getErrorCode() == 1 || this.aBK.getErrorCode() == 100) {
            this.aBJ.setText(t.j.pluginstatus_btn_restartapp);
            this.aBJ.setVisibility(0);
            return;
        }
        this.aBJ.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String jsonStrWithObject = com.baidu.adp.plugin.packageManager.a.a.jsonStrWithObject(this.aBK);
        if (jsonStrWithObject != null) {
            bundle.putString(com.baidu.adp.plugin.packageManager.a.a.class.getName(), jsonStrWithObject);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ajk) {
            finish();
        } else if (view == this.aBJ) {
            if (this.aBK != null && this.aBK.getErrorCode() == 100) {
                com.baidu.adp.plugin.b.a.lq().I(true);
            }
            showLoadingDialog(getResources().getString(t.j.waiting));
            h.hr().postDelayed(new a(this), 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
