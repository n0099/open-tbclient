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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class PluginErrorTipActivity extends BaseActivity<PluginErrorTipActivity> {
    private View bVZ;
    private ImageView crD;
    private TextView crE;
    private View crF;
    private TextView crG;
    private TextView crH;
    private PluginStatus crI;
    private ShadowLayout crJ;
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
            this.crI = (PluginStatus) PluginStatus.objectWithJsonStr(getIntent().getStringExtra(PluginStatus.class.getName()), PluginStatus.class);
        } else {
            this.crI = (PluginStatus) PluginStatus.objectWithJsonStr(bundle.getString(PluginStatus.class.getName()), PluginStatus.class);
        }
        if (this.crI == null) {
            finish();
            return;
        }
        setContentView(d.h.plugin_error_tip_activity);
        initUI();
    }

    protected void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.bVZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.bVZ.setOnClickListener(this);
        this.mNavigationBar.setTitleText(d.j.pluginstatus_tip_title);
        this.crD = (ImageView) findViewById(d.g.plugin_error_tip_image);
        this.crE = (TextView) findViewById(d.g.plugin_error_install_fail);
        this.crG = (TextView) findViewById(d.g.plugin_error_tip_resolve);
        this.crF = findViewById(d.g.plugin_error_parent);
        this.crJ = (ShadowLayout) findViewById(d.g.plugin_error_shadow_layout);
        this.crH = (TextView) findViewById(d.g.plugin_error_btn);
        this.crH.setOnClickListener(this);
        this.crG.setText(getString(d.j.plugin_error_tips, new Object[]{this.crI.getErrorMsg(), this.crI.nR()}));
        if (this.crI.getErrorCode() == 5 || this.crI.getErrorCode() == 1 || this.crI.getErrorCode() == 100) {
            this.crH.setText(d.j.pluginstatus_btn_restartapp);
            this.crH.setVisibility(0);
            return;
        }
        this.crH.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String jsonStrWithObject = PluginStatus.jsonStrWithObject(this.crI);
        if (jsonStrWithObject != null) {
            bundle.putString(PluginStatus.class.getName(), jsonStrWithObject);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bVZ) {
            finish();
        } else if (view == this.crH) {
            if (this.crI != null && this.crI.getErrorCode() == 100) {
                com.baidu.adp.plugin.b.a.mS().ap(true);
            }
            showLoadingDialog(getResources().getString(d.j.waiting));
            e.jH().postDelayed(new Runnable() { // from class: com.baidu.tbadk.plugin.PluginErrorTipActivity.1
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
        al.c(this.crD, d.f.new_pic_emotion_05);
        al.j(this.crE, d.C0277d.cp_cont_c);
        al.l(this.crF, d.C0277d.cp_bg_line_d);
        al.j(this.crG, d.C0277d.cp_cont_b);
        al.j(this.crH, d.C0277d.cp_cont_g);
        al.k(this.crH, d.f.selector_blue_gradient_button);
        this.crJ.setShadowColor(d.C0277d.plugin_button_shadow_blue);
    }
}
