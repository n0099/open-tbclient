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
import com.baidu.adp.lib.g.e;
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
    private TextView cMA;
    private TextView cMB;
    private PluginStatus cMC;
    private ShadowLayout cMD;
    private ImageView cMx;
    private TextView cMy;
    private View cMz;
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
            this.cMC = (PluginStatus) PluginStatus.objectWithJsonStr(getIntent().getStringExtra(PluginStatus.class.getName()), PluginStatus.class);
        } else {
            this.cMC = (PluginStatus) PluginStatus.objectWithJsonStr(bundle.getString(PluginStatus.class.getName()), PluginStatus.class);
        }
        if (this.cMC == null) {
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
        this.cMx = (ImageView) findViewById(R.id.plugin_error_tip_image);
        this.cMy = (TextView) findViewById(R.id.plugin_error_install_fail);
        this.cMA = (TextView) findViewById(R.id.plugin_error_tip_resolve);
        this.cMz = findViewById(R.id.plugin_error_parent);
        this.cMD = (ShadowLayout) findViewById(R.id.plugin_error_shadow_layout);
        this.cMB = (TextView) findViewById(R.id.plugin_error_btn);
        this.cMB.setOnClickListener(this);
        this.cMA.setText(getString(R.string.plugin_error_tips, new Object[]{this.cMC.getErrorMsg(), this.cMC.ju()}));
        if (this.cMC.getErrorCode() == 5 || this.cMC.getErrorCode() == 1 || this.cMC.getErrorCode() == 100) {
            this.cMB.setText(R.string.pluginstatus_btn_restartapp);
            this.cMB.setVisibility(0);
            return;
        }
        this.cMB.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String jsonStrWithObject = PluginStatus.jsonStrWithObject(this.cMC);
        if (jsonStrWithObject != null) {
            bundle.putString(PluginStatus.class.getName(), jsonStrWithObject);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mBack) {
            finish();
        } else if (view == this.cMB) {
            if (this.cMC != null && this.cMC.getErrorCode() == 100) {
                com.baidu.adp.plugin.b.a.iv().K(true);
            }
            showLoadingDialog(getResources().getString(R.string.waiting));
            e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tbadk.plugin.PluginErrorTipActivity.1
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
        am.setImageResource(this.cMx, R.drawable.new_pic_emotion_05);
        am.setViewTextColor(this.cMy, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.cMz, R.color.cp_bg_line_d);
        am.setViewTextColor(this.cMA, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.cMB, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.cMB, R.drawable.selector_blue_gradient_button);
        this.cMD.setShadowColor(R.color.plugin_button_shadow_blue);
    }
}
