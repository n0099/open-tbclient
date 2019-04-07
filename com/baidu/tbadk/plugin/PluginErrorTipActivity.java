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
    private View bWb;
    private ImageView crF;
    private TextView crG;
    private View crH;
    private TextView crI;
    private TextView crJ;
    private PluginStatus crK;
    private ShadowLayout crL;
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
            this.crK = (PluginStatus) PluginStatus.objectWithJsonStr(getIntent().getStringExtra(PluginStatus.class.getName()), PluginStatus.class);
        } else {
            this.crK = (PluginStatus) PluginStatus.objectWithJsonStr(bundle.getString(PluginStatus.class.getName()), PluginStatus.class);
        }
        if (this.crK == null) {
            finish();
            return;
        }
        setContentView(d.h.plugin_error_tip_activity);
        initUI();
    }

    protected void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.bWb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.bWb.setOnClickListener(this);
        this.mNavigationBar.setTitleText(d.j.pluginstatus_tip_title);
        this.crF = (ImageView) findViewById(d.g.plugin_error_tip_image);
        this.crG = (TextView) findViewById(d.g.plugin_error_install_fail);
        this.crI = (TextView) findViewById(d.g.plugin_error_tip_resolve);
        this.crH = findViewById(d.g.plugin_error_parent);
        this.crL = (ShadowLayout) findViewById(d.g.plugin_error_shadow_layout);
        this.crJ = (TextView) findViewById(d.g.plugin_error_btn);
        this.crJ.setOnClickListener(this);
        this.crI.setText(getString(d.j.plugin_error_tips, new Object[]{this.crK.getErrorMsg(), this.crK.nR()}));
        if (this.crK.getErrorCode() == 5 || this.crK.getErrorCode() == 1 || this.crK.getErrorCode() == 100) {
            this.crJ.setText(d.j.pluginstatus_btn_restartapp);
            this.crJ.setVisibility(0);
            return;
        }
        this.crJ.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String jsonStrWithObject = PluginStatus.jsonStrWithObject(this.crK);
        if (jsonStrWithObject != null) {
            bundle.putString(PluginStatus.class.getName(), jsonStrWithObject);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bWb) {
            finish();
        } else if (view == this.crJ) {
            if (this.crK != null && this.crK.getErrorCode() == 100) {
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
        al.c(this.crF, d.f.new_pic_emotion_05);
        al.j(this.crG, d.C0277d.cp_cont_c);
        al.l(this.crH, d.C0277d.cp_bg_line_d);
        al.j(this.crI, d.C0277d.cp_cont_b);
        al.j(this.crJ, d.C0277d.cp_cont_g);
        al.k(this.crJ, d.f.selector_blue_gradient_button);
        this.crL.setShadowColor(d.C0277d.plugin_button_shadow_blue);
    }
}
