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
    private ImageView cBc;
    private TextView cBd;
    private View cBe;
    private TextView cBf;
    private TextView cBg;
    private PluginStatus cBh;
    private ShadowLayout cBi;
    private View cfb;
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
            this.cBh = (PluginStatus) PluginStatus.objectWithJsonStr(getIntent().getStringExtra(PluginStatus.class.getName()), PluginStatus.class);
        } else {
            this.cBh = (PluginStatus) PluginStatus.objectWithJsonStr(bundle.getString(PluginStatus.class.getName()), PluginStatus.class);
        }
        if (this.cBh == null) {
            finish();
            return;
        }
        setContentView(R.layout.plugin_error_tip_activity);
        initUI();
    }

    protected void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.cfb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.cfb.setOnClickListener(this);
        this.mNavigationBar.setTitleText(R.string.pluginstatus_tip_title);
        this.cBc = (ImageView) findViewById(R.id.plugin_error_tip_image);
        this.cBd = (TextView) findViewById(R.id.plugin_error_install_fail);
        this.cBf = (TextView) findViewById(R.id.plugin_error_tip_resolve);
        this.cBe = findViewById(R.id.plugin_error_parent);
        this.cBi = (ShadowLayout) findViewById(R.id.plugin_error_shadow_layout);
        this.cBg = (TextView) findViewById(R.id.plugin_error_btn);
        this.cBg.setOnClickListener(this);
        this.cBf.setText(getString(R.string.plugin_error_tips, new Object[]{this.cBh.getErrorMsg(), this.cBh.nc()}));
        if (this.cBh.getErrorCode() == 5 || this.cBh.getErrorCode() == 1 || this.cBh.getErrorCode() == 100) {
            this.cBg.setText(R.string.pluginstatus_btn_restartapp);
            this.cBg.setVisibility(0);
            return;
        }
        this.cBg.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String jsonStrWithObject = PluginStatus.jsonStrWithObject(this.cBh);
        if (jsonStrWithObject != null) {
            bundle.putString(PluginStatus.class.getName(), jsonStrWithObject);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cfb) {
            finish();
        } else if (view == this.cBg) {
            if (this.cBh != null && this.cBh.getErrorCode() == 100) {
                com.baidu.adp.plugin.b.a.mc().aj(true);
            }
            showLoadingDialog(getResources().getString(R.string.waiting));
            e.iK().postDelayed(new Runnable() { // from class: com.baidu.tbadk.plugin.PluginErrorTipActivity.1
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
        am.c(this.cBc, (int) R.drawable.new_pic_emotion_05);
        am.j(this.cBd, R.color.cp_cont_c);
        am.l(this.cBe, R.color.cp_bg_line_d);
        am.j(this.cBf, R.color.cp_cont_b);
        am.j(this.cBg, R.color.cp_cont_g);
        am.k(this.cBg, R.drawable.selector_blue_gradient_button);
        this.cBi.setShadowColor(R.color.plugin_button_shadow_blue);
    }
}
