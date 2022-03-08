package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.h;
import c.a.d.f.p.f;
import c.a.d.i.c;
import c.a.i0.b.a.e;
import c.a.q0.c1.y;
import c.a.q0.r.j0.b;
import c.a.q0.r0.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.NPSHookManager;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.performance.speed.SpeedRuntime;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.searchbox.performance.speed.task.LaunchTaskSchedule;
import com.baidu.searchbox.taskmanager.ApplicationTaskPool;
import com.baidu.swan.facade.init.SwanAppInitHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.switchs.LaunchUpSpeedSwitch;
import com.baidu.titan.sdk.initer.TitanIniter;
import com.baidu.titan.sdk.loader.LoaderManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.HashSet;
/* loaded from: classes5.dex */
public class TiebaBaseApplication extends TbadkApplication {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaBaseApplication a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TiebaBaseApplication tiebaBaseApplication, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaBaseApplication, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tiebaBaseApplication;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                this.a.handleInitMessage(message);
            }
        }
    }

    public TiebaBaseApplication() {
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

    private void initAndStartLaunchTaskSchedule() {
        int i2;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (isMainProcess(false)) {
                i2 = 1;
            } else if (isRemoteProcess()) {
                i2 = 16;
            } else {
                i2 = isYunPushProcess() ? 256 : 268435456;
            }
            HashSet<String> hashSet = new HashSet<>();
            if (SpeedRuntime.getSpeedContext().isMainProcess()) {
                String q = b.k().q("key_sync_task_switch", "");
                if (!StringUtils.isNull(q) && (split = q.split("_")) != null && split.length > 0) {
                    Collections.addAll(hashSet, split);
                }
            }
            LaunchTaskSchedule.getInstance().init(i2, new ApplicationTaskPool(), hashSet);
            if (!LaunchUpSpeedSwitch.getIsOn()) {
                LaunchTaskSchedule.getInstance().startTask(1);
                LaunchTaskSchedule.getInstance().startTask(2);
                if (PermissionUtil.isAgreePrivacyPolicy()) {
                    LaunchTaskSchedule.getInstance().startTask(3);
                    return;
                }
                return;
            }
            LaunchTaskSchedule.getInstance().start(1);
            LaunchTaskSchedule.getInstance().start(2);
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                LaunchTaskSchedule.getInstance().start(3);
            }
        }
    }

    private void initBdBaseApp(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, application) == null) {
            this.mContext = application;
            initWorkMode();
            initBitmapHelper();
        }
    }

    private void initBitmapHelper() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            f.d().f(this.mContext);
        }
    }

    private void initIdleLaunchTaskManager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            boolean z = false;
            if (isMainProcess(false) && PermissionUtil.isAgreePrivacyPolicy()) {
                z = y.a(this);
            }
            if (z) {
                return;
            }
            c.a.d.e.a.b().d();
        }
    }

    private void initWorkMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            if ((this.mContext.getApplicationInfo().flags & 2) == 0) {
                this.mIsDebugMode = false;
            } else {
                this.mIsDebugMode = true;
            }
        }
    }

    @Override // com.baidu.tbadk.TbadkApplication, com.baidu.tbadk.core.TbadkCoreApplication, com.baidu.adp.base.BdBaseApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            TbadkApplication.sApp = this;
            SpeedStatsManager.getInstance().setMainProcessFlag(isMainProcess(false, context));
            SpeedStatsManager.getInstance().addStatsTimeStamp(1000);
            SpeedStatsManager.getInstance().addStatsTimeStamp(1002);
            super.attachBaseContext(context);
            this.mContext = context;
            AppConfig.init(false, false, false, false);
            fixOppoTimeout();
            SpeedStatsManager.getInstance().addStatsTimeStamp(1003);
            SwanAppInitHelper.initContext(this);
            AppRuntimeInit.onApplicationattachBaseContext(this);
            e.b(this);
            if (isMainProcess(false, context)) {
                c.a.q0.r.a0.a.b(context);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(1004);
            NPSHookManager.init(this);
            c.e().g(this);
            SpeedStatsManager.getInstance().addStatsTimeStamp(1011);
            TitanIniter.init(this);
            LoaderManager.getInstance().load();
            SpeedStatsManager.getInstance().addStatsTimeStamp(1012);
            c.a.b0.h.b.b(this);
            SpeedStatsManager.getInstance().addStatsTimeStamp(1010);
        }
    }

    @Override // com.baidu.tbadk.TbadkApplication, com.baidu.tbadk.core.TbadkCoreApplication, com.baidu.adp.base.BdBaseApplication, android.app.Application
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.processCreateTime = System.currentTimeMillis();
            SpeedStats.getInstance().setContext(this);
            SpeedStatsManager.getInstance().addStatsTimeStamp(2000);
            TbadkApplication.sApp = this;
            if (isMainProcess(false)) {
                c.a.q0.r.a0.a.a();
            }
            this.mAppInitHandler = new a(this, Looper.getMainLooper());
            h.a().c(super.getResources());
            initBdBaseApp(this);
            super.onCreate();
            SpeedStatsManager.getInstance().addStatsTimeStamp(2001);
            initIdleLaunchTaskManager();
            SpeedStatsManager.getInstance().addStatsTimeStamp(2002);
            initAndStartLaunchTaskSchedule();
            SpeedStatsManager.getInstance().addStatsTimeStamp(2003);
            initSpeedInstallStatus();
            if (isMainProcess(false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921659));
            }
            k.b().G(System.currentTimeMillis());
            if (isMainProcess(false)) {
                c.a.q0.r.a0.a.i();
            }
            c.a.d.f.j.b.m.a.a().b();
            SpeedStatsManager.getInstance().addStatsTimeStamp(2004);
            SpeedStats.getInstance().onAppCreateEnd();
        }
    }
}
