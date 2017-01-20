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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PluginErrorTipActivity extends BaseActivity<PluginErrorTipActivity> {
    private TextView aCb;
    private TextView aCc;
    private TextView aCd;
    private PluginStatus aCe;
    private View aiC;
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
            this.aCe = (PluginStatus) PluginStatus.objectWithJsonStr(getIntent().getStringExtra(PluginStatus.class.getName()), PluginStatus.class);
        } else {
            this.aCe = (PluginStatus) PluginStatus.objectWithJsonStr(bundle.getString(PluginStatus.class.getName()), PluginStatus.class);
        }
        if (this.aCe == null) {
            finish();
            return;
        }
        setContentView(r.j.plugin_error_tip_activity);
        initUI();
    }

    protected void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(r.h.view_navigation_bar);
        this.aiC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.aiC.setOnClickListener(this);
        this.mNavigationBar.setTitleText(r.l.pluginstatus_tip_title);
        this.aCb = (TextView) findViewById(r.h.plugin_error_tip_msg);
        this.aCc = (TextView) findViewById(r.h.plugin_error_tip_resolve);
        this.aCd = (TextView) findViewById(r.h.plugin_error_btn);
        this.aCd.setOnClickListener(this);
        this.aCb.setText(this.aCe.getErrorMsg());
        this.aCc.setText(this.aCe.ji());
        if (this.aCe.getErrorCode() == 5 || this.aCe.getErrorCode() == 1 || this.aCe.getErrorCode() == 100) {
            this.aCd.setText(r.l.pluginstatus_btn_restartapp);
            this.aCd.setVisibility(0);
            return;
        }
        this.aCd.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String jsonStrWithObject = PluginStatus.jsonStrWithObject(this.aCe);
        if (jsonStrWithObject != null) {
            bundle.putString(PluginStatus.class.getName(), jsonStrWithObject);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aiC) {
            finish();
        } else if (view == this.aCd) {
            if (this.aCe != null && this.aCe.getErrorCode() == 100) {
                com.baidu.adp.plugin.b.a.im().L(true);
            }
            showLoadingDialog(getResources().getString(r.l.waiting));
            h.eE().postDelayed(new a(this), 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
