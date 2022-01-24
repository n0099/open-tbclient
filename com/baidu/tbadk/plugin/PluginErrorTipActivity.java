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
import c.a.d.f.m.e;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class PluginErrorTipActivity extends BaseActivity<PluginErrorTipActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView btn;
    public ImageView errorImage;
    public TextView errorInstallFail;
    public View mBack;
    public NavigationBar mNavigationBar;
    public View parent;
    public TextView resolveMsgView;
    public ShadowLayout shadowLayout;
    public PluginStatus status;

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PluginErrorTipActivity f41104e;

        public a(PluginErrorTipActivity pluginErrorTipActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginErrorTipActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41104e = pluginErrorTipActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HashSet hashSet = new HashSet(10);
                HashSet hashSet2 = new HashSet(10);
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) BdBaseApplication.getInst().getContext().getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo != null && (str = runningAppProcessInfo.processName) != null && str.startsWith(this.f41104e.getApplication().getPackageName()) && runningAppProcessInfo.pid != Process.myPid() && hashSet.contains(runningAppProcessInfo.processName)) {
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
        }
    }

    public PluginErrorTipActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static final void startByPlugiStatus(Context context, PluginStatus pluginStatus) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, pluginStatus) == null) || context == null || pluginStatus == null) {
            return;
        }
        Intent intent = new Intent(context, PluginErrorTipActivity.class);
        String jsonStrWithObject = OrmObject.jsonStrWithObject(pluginStatus);
        if (jsonStrWithObject == null) {
            return;
        }
        intent.putExtra(PluginStatus.class.getName(), jsonStrWithObject);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
            this.mBack = addSystemImageButton;
            addSystemImageButton.setOnClickListener(this);
            this.mNavigationBar.setTitleText(R.string.pluginstatus_tip_title);
            this.errorImage = (ImageView) findViewById(R.id.plugin_error_tip_image);
            this.errorInstallFail = (TextView) findViewById(R.id.plugin_error_install_fail);
            this.resolveMsgView = (TextView) findViewById(R.id.plugin_error_tip_resolve);
            this.parent = findViewById(R.id.plugin_error_parent);
            this.shadowLayout = (ShadowLayout) findViewById(R.id.plugin_error_shadow_layout);
            TextView textView = (TextView) findViewById(R.id.plugin_error_btn);
            this.btn = textView;
            textView.setOnClickListener(this);
            this.resolveMsgView.setText(getString(R.string.plugin_error_tips, new Object[]{this.status.getErrorMsg(), this.status.w()}));
            if (this.status.getErrorCode() != 5 && this.status.getErrorCode() != 1 && this.status.getErrorCode() != 100) {
                this.btn.setVisibility(8);
                return;
            }
            this.btn.setText(R.string.pluginstatus_btn_restartapp);
            this.btn.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            SkinManager.setImageResource(this.errorImage, R.drawable.new_pic_emotion_05);
            SkinManager.setViewTextColor(this.errorInstallFail, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.parent, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.resolveMsgView, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.btn, R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.btn, R.drawable.selector_blue_gradient_button);
            this.shadowLayout.setShadowColor(R.color.plugin_button_shadow_blue);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            if (view == this.mBack) {
                finish();
            } else if (view == this.btn) {
                PluginStatus pluginStatus = this.status;
                if (pluginStatus != null && pluginStatus.getErrorCode() == 100) {
                    c.a.d.i.h.a.b().s(true);
                }
                showLoadingDialog(getResources().getString(R.string.waiting));
                e.a().postDelayed(new a(this), 2000L);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            if (getIntent() != null) {
                this.status = (PluginStatus) OrmObject.objectWithJsonStr(getIntent().getStringExtra(PluginStatus.class.getName()), PluginStatus.class);
            } else {
                this.status = (PluginStatus) OrmObject.objectWithJsonStr(bundle.getString(PluginStatus.class.getName()), PluginStatus.class);
            }
            if (this.status == null) {
                finish();
                return;
            }
            setContentView(R.layout.plugin_error_tip_activity);
            initUI();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            String jsonStrWithObject = OrmObject.jsonStrWithObject(this.status);
            if (jsonStrWithObject != null) {
                bundle.putString(PluginStatus.class.getName(), jsonStrWithObject);
            }
        }
    }
}
