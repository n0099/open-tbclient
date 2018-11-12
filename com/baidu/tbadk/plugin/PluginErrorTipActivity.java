package com.baidu.tbadk.plugin;

import android.app.Activity;
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
    private View aJu;
    private TextView bdA;
    private TextView bdB;
    private TextView bdC;
    private PluginStatus bdD;
    private NavigationBar mNavigationBar;

    public static final void a(Context context, PluginStatus pluginStatus) {
        if (context != null && pluginStatus != null) {
            Intent intent = new Intent(context, PluginErrorTipActivity.class);
            String jsonStrWithObject = PluginStatus.jsonStrWithObject(pluginStatus);
            if (jsonStrWithObject != null) {
                intent.putExtra(PluginStatus.class.getName(), jsonStrWithObject);
                if (!(context instanceof Activity) && intent != null) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.bdD = (PluginStatus) PluginStatus.objectWithJsonStr(getIntent().getStringExtra(PluginStatus.class.getName()), PluginStatus.class);
        } else {
            this.bdD = (PluginStatus) PluginStatus.objectWithJsonStr(bundle.getString(PluginStatus.class.getName()), PluginStatus.class);
        }
        if (this.bdD == null) {
            finish();
            return;
        }
        setContentView(e.h.plugin_error_tip_activity);
        initUI();
    }

    protected void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.aJu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.aJu.setOnClickListener(this);
        this.mNavigationBar.setTitleText(e.j.pluginstatus_tip_title);
        this.bdA = (TextView) findViewById(e.g.plugin_error_tip_msg);
        this.bdB = (TextView) findViewById(e.g.plugin_error_tip_resolve);
        this.bdC = (TextView) findViewById(e.g.plugin_error_btn);
        this.bdC.setOnClickListener(this);
        this.bdA.setText(this.bdD.getErrorMsg());
        this.bdB.setText(this.bdD.nJ());
        if (this.bdD.getErrorCode() == 5 || this.bdD.getErrorCode() == 1 || this.bdD.getErrorCode() == 100) {
            this.bdC.setText(e.j.pluginstatus_btn_restartapp);
            this.bdC.setVisibility(0);
            return;
        }
        this.bdC.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String jsonStrWithObject = PluginStatus.jsonStrWithObject(this.bdD);
        if (jsonStrWithObject != null) {
            bundle.putString(PluginStatus.class.getName(), jsonStrWithObject);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aJu) {
            finish();
        } else if (view == this.bdC) {
            if (this.bdD != null && this.bdD.getErrorCode() == 100) {
                com.baidu.adp.plugin.b.a.mO().ao(true);
            }
            showLoadingDialog(getResources().getString(e.j.waiting));
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tbadk.plugin.PluginErrorTipActivity.1
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
