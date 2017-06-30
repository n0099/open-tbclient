package com.baidu.tbadk.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.g.h;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PluginErrorTipActivity extends BaseActivity<PluginErrorTipActivity> {
    private TextView aIP;
    private TextView aIQ;
    private TextView aIR;
    private PluginStatus aIS;
    private View apb;
    private NavigationBar mNavigationBar;

    public static final void a(Context context, PluginStatus pluginStatus) {
        if (context != null && pluginStatus != null) {
            Intent intent = new Intent(context, PluginErrorTipActivity.class);
            String jsonStrWithObject = PluginStatus.jsonStrWithObject(pluginStatus);
            if (jsonStrWithObject != null) {
                intent.putExtra(PluginStatus.class.getName(), jsonStrWithObject);
                context.startActivity(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.aIS = (PluginStatus) PluginStatus.objectWithJsonStr(getIntent().getStringExtra(PluginStatus.class.getName()), PluginStatus.class);
        } else {
            this.aIS = (PluginStatus) PluginStatus.objectWithJsonStr(bundle.getString(PluginStatus.class.getName()), PluginStatus.class);
        }
        if (this.aIS == null) {
            finish();
            return;
        }
        setContentView(w.j.plugin_error_tip_activity);
        initUI();
    }

    protected void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.apb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.apb.setOnClickListener(this);
        this.mNavigationBar.setTitleText(w.l.pluginstatus_tip_title);
        this.aIP = (TextView) findViewById(w.h.plugin_error_tip_msg);
        this.aIQ = (TextView) findViewById(w.h.plugin_error_tip_resolve);
        this.aIR = (TextView) findViewById(w.h.plugin_error_btn);
        this.aIR.setOnClickListener(this);
        this.aIP.setText(this.aIS.getErrorMsg());
        this.aIQ.setText(this.aIS.ke());
        if (this.aIS.getErrorCode() == 5 || this.aIS.getErrorCode() == 1 || this.aIS.getErrorCode() == 100) {
            this.aIR.setText(w.l.pluginstatus_btn_restartapp);
            this.aIR.setVisibility(0);
            return;
        }
        this.aIR.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String jsonStrWithObject = PluginStatus.jsonStrWithObject(this.aIS);
        if (jsonStrWithObject != null) {
            bundle.putString(PluginStatus.class.getName(), jsonStrWithObject);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.apb) {
            finish();
        } else if (view == this.aIR) {
            if (this.aIS != null && this.aIS.getErrorCode() == 100) {
                com.baidu.adp.plugin.b.a.jj().M(true);
            }
            showLoadingDialog(getResources().getString(w.l.waiting));
            h.fR().postDelayed(new a(this), 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
