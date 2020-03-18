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
    private ImageView dFp;
    private TextView dFq;
    private View dFr;
    private TextView dFs;
    private TextView dFt;
    private PluginStatus dFu;
    private ShadowLayout dFv;
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
            this.dFu = (PluginStatus) PluginStatus.objectWithJsonStr(getIntent().getStringExtra(PluginStatus.class.getName()), PluginStatus.class);
        } else {
            this.dFu = (PluginStatus) PluginStatus.objectWithJsonStr(bundle.getString(PluginStatus.class.getName()), PluginStatus.class);
        }
        if (this.dFu == null) {
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
        this.dFp = (ImageView) findViewById(R.id.plugin_error_tip_image);
        this.dFq = (TextView) findViewById(R.id.plugin_error_install_fail);
        this.dFs = (TextView) findViewById(R.id.plugin_error_tip_resolve);
        this.dFr = findViewById(R.id.plugin_error_parent);
        this.dFv = (ShadowLayout) findViewById(R.id.plugin_error_shadow_layout);
        this.dFt = (TextView) findViewById(R.id.plugin_error_btn);
        this.dFt.setOnClickListener(this);
        this.dFs.setText(getString(R.string.plugin_error_tips, new Object[]{this.dFu.getErrorMsg(), this.dFu.ka()}));
        if (this.dFu.getErrorCode() == 5 || this.dFu.getErrorCode() == 1 || this.dFu.getErrorCode() == 100) {
            this.dFt.setText(R.string.pluginstatus_btn_restartapp);
            this.dFt.setVisibility(0);
            return;
        }
        this.dFt.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String jsonStrWithObject = PluginStatus.jsonStrWithObject(this.dFu);
        if (jsonStrWithObject != null) {
            bundle.putString(PluginStatus.class.getName(), jsonStrWithObject);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mBack) {
            finish();
        } else if (view == this.dFt) {
            if (this.dFu != null && this.dFu.getErrorCode() == 100) {
                com.baidu.adp.plugin.b.a.jc().S(true);
            }
            showLoadingDialog(getResources().getString(R.string.waiting));
            e.gx().postDelayed(new Runnable() { // from class: com.baidu.tbadk.plugin.PluginErrorTipActivity.1
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
        am.setImageResource(this.dFp, R.drawable.new_pic_emotion_05);
        am.setViewTextColor(this.dFq, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.dFr, R.color.cp_bg_line_d);
        am.setViewTextColor(this.dFs, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dFt, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.dFt, R.drawable.selector_blue_gradient_button);
        this.dFv.setShadowColor(R.color.plugin_button_shadow_blue);
    }
}
