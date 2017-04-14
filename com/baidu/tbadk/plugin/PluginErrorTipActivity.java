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
    private TextView aHI;
    private TextView aHJ;
    private TextView aHK;
    private PluginStatus aHL;
    private View aom;
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
            this.aHL = (PluginStatus) PluginStatus.objectWithJsonStr(getIntent().getStringExtra(PluginStatus.class.getName()), PluginStatus.class);
        } else {
            this.aHL = (PluginStatus) PluginStatus.objectWithJsonStr(bundle.getString(PluginStatus.class.getName()), PluginStatus.class);
        }
        if (this.aHL == null) {
            finish();
            return;
        }
        setContentView(w.j.plugin_error_tip_activity);
        initUI();
    }

    protected void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.aom = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.aom.setOnClickListener(this);
        this.mNavigationBar.setTitleText(w.l.pluginstatus_tip_title);
        this.aHI = (TextView) findViewById(w.h.plugin_error_tip_msg);
        this.aHJ = (TextView) findViewById(w.h.plugin_error_tip_resolve);
        this.aHK = (TextView) findViewById(w.h.plugin_error_btn);
        this.aHK.setOnClickListener(this);
        this.aHI.setText(this.aHL.getErrorMsg());
        this.aHJ.setText(this.aHL.kg());
        if (this.aHL.getErrorCode() == 5 || this.aHL.getErrorCode() == 1 || this.aHL.getErrorCode() == 100) {
            this.aHK.setText(w.l.pluginstatus_btn_restartapp);
            this.aHK.setVisibility(0);
            return;
        }
        this.aHK.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String jsonStrWithObject = PluginStatus.jsonStrWithObject(this.aHL);
        if (jsonStrWithObject != null) {
            bundle.putString(PluginStatus.class.getName(), jsonStrWithObject);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aom) {
            finish();
        } else if (view == this.aHK) {
            if (this.aHL != null && this.aHL.getErrorCode() == 100) {
                com.baidu.adp.plugin.b.a.jk().M(true);
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
