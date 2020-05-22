package com.baidu.tbadk.plugin;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class PluginErrorTipActivity extends BaseActivity<PluginErrorTipActivity> {
    private ImageView etp;
    private TextView etq;
    private View etr;
    private TextView ets;
    private TextView ett;
    private PluginStatus etu;
    private ShadowLayout etv;
    private View mBack;
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
            this.etu = (PluginStatus) PluginStatus.objectWithJsonStr(getIntent().getStringExtra(PluginStatus.class.getName()), PluginStatus.class);
        } else {
            this.etu = (PluginStatus) PluginStatus.objectWithJsonStr(bundle.getString(PluginStatus.class.getName()), PluginStatus.class);
        }
        if (this.etu == null) {
            finish();
            return;
        }
        setContentView(R.layout.plugin_error_tip_activity);
        initUI();
    }

    protected void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mBack.setOnClickListener(this);
        this.mNavigationBar.setTitleText(R.string.pluginstatus_tip_title);
        this.etp = (ImageView) findViewById(R.id.plugin_error_tip_image);
        this.etq = (TextView) findViewById(R.id.plugin_error_install_fail);
        this.ets = (TextView) findViewById(R.id.plugin_error_tip_resolve);
        this.etr = findViewById(R.id.plugin_error_parent);
        this.etv = (ShadowLayout) findViewById(R.id.plugin_error_shadow_layout);
        this.ett = (TextView) findViewById(R.id.plugin_error_btn);
        this.ett.setOnClickListener(this);
        this.ets.setText(getString(R.string.plugin_error_tips, new Object[]{this.etu.getErrorMsg(), this.etu.oF()}));
        if (this.etu.getErrorCode() == 5 || this.etu.getErrorCode() == 1 || this.etu.getErrorCode() == 100) {
            this.ett.setText(R.string.pluginstatus_btn_restartapp);
            this.ett.setVisibility(0);
            return;
        }
        this.ett.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String jsonStrWithObject = PluginStatus.jsonStrWithObject(this.etu);
        if (jsonStrWithObject != null) {
            bundle.putString(PluginStatus.class.getName(), jsonStrWithObject);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mBack) {
            finish();
        } else if (view == this.ett) {
            if (this.etu != null && this.etu.getErrorCode() == 100) {
                com.baidu.adp.plugin.b.a.nH().at(true);
            }
            showLoadingDialog(getResources().getString(R.string.waiting));
            e.ld().postDelayed(new Runnable() { // from class: com.baidu.tbadk.plugin.PluginErrorTipActivity.1
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
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setImageResource(this.etp, R.drawable.new_pic_emotion_05);
        am.setViewTextColor(this.etq, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.etr, R.color.cp_bg_line_d);
        am.setViewTextColor(this.ets, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.ett, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.ett, R.drawable.selector_blue_gradient_button);
        this.etv.setShadowColor(R.color.plugin_button_shadow_blue);
    }
}
