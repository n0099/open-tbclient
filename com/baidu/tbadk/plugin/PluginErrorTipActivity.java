package com.baidu.tbadk.plugin;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class PluginErrorTipActivity extends BaseActivity<PluginErrorTipActivity> {
    private View aIE;
    private TextView bcN;
    private TextView bcO;
    private TextView bcP;
    private PluginStatus bcQ;
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
            this.bcQ = (PluginStatus) PluginStatus.objectWithJsonStr(getIntent().getStringExtra(PluginStatus.class.getName()), PluginStatus.class);
        } else {
            this.bcQ = (PluginStatus) PluginStatus.objectWithJsonStr(bundle.getString(PluginStatus.class.getName()), PluginStatus.class);
        }
        if (this.bcQ == null) {
            finish();
            return;
        }
        setContentView(e.h.plugin_error_tip_activity);
        initUI();
    }

    protected void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.aIE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.aIE.setOnClickListener(this);
        this.mNavigationBar.setTitleText(e.j.pluginstatus_tip_title);
        this.bcN = (TextView) findViewById(e.g.plugin_error_tip_msg);
        this.bcO = (TextView) findViewById(e.g.plugin_error_tip_resolve);
        this.bcP = (TextView) findViewById(e.g.plugin_error_btn);
        this.bcP.setOnClickListener(this);
        this.bcN.setText(this.bcQ.getErrorMsg());
        this.bcO.setText(this.bcQ.nL());
        if (this.bcQ.getErrorCode() == 5 || this.bcQ.getErrorCode() == 1 || this.bcQ.getErrorCode() == 100) {
            this.bcP.setText(e.j.pluginstatus_btn_restartapp);
            this.bcP.setVisibility(0);
            return;
        }
        this.bcP.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String jsonStrWithObject = PluginStatus.jsonStrWithObject(this.bcQ);
        if (jsonStrWithObject != null) {
            bundle.putString(PluginStatus.class.getName(), jsonStrWithObject);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aIE) {
            finish();
        } else if (view == this.bcP) {
            if (this.bcQ != null && this.bcQ.getErrorCode() == 100) {
                com.baidu.adp.plugin.b.a.mQ().aa(true);
            }
            showLoadingDialog(getResources().getString(e.j.waiting));
            com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tbadk.plugin.PluginErrorTipActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    HashSet hashSet = new HashSet(10);
                    HashSet hashSet2 = new HashSet(10);
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) BdBaseApplication.getInst().getContext().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
                    if (runningAppProcesses != null) {
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (runningAppProcessInfo != null && runningAppProcessInfo.processName != null && runningAppProcessInfo.processName.startsWith(PluginErrorTipActivity.this.getApplication().getPackageName()) && runningAppProcessInfo.pid != Process.myPid() && hashSet.contains(runningAppProcessInfo.processName)) {
                                hashSet2.add(Integer.valueOf(runningAppProcessInfo.pid));
                            }
                        }
                    }
                    Iterator it = hashSet2.iterator();
                    while (it.hasNext()) {
                        Process.killProcess(((Integer) it.next()).intValue());
                    }
                    Process.killProcess(Process.myPid());
                }
            }, SystemScreenshotManager.DELAY_TIME);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
