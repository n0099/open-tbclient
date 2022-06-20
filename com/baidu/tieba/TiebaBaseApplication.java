package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.npsplugin.LayoutInflaterFixer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.NPSHookManager;
import com.baidu.nps.main.manager.Configurations;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.performance.speed.SpeedRuntime;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.searchbox.performance.speed.task.BaseTaskPool;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskSchedule;
import com.baidu.searchbox.preload.AppRuntimePreloader;
import com.baidu.searchbox.taskmanager.ApplicationTaskPool;
import com.baidu.searchbox.taskmanager.PBTaskPool;
import com.baidu.searchbox.taskmanager.TaskManagerLaunchFetchListener;
import com.baidu.swan.facade.init.SwanAppInitHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.switchs.LaunchUpApplicationSwitch;
import com.baidu.tbadk.switchs.LaunchUpSpeedSwitch;
import com.baidu.tbadk.switchs.PreInitMainTabViewSwitch;
import com.baidu.tbadk.util.AppLaunchInfoFetcher;
import com.baidu.titan.sdk.initer.TitanIniter;
import com.baidu.titan.sdk.loader.LoaderManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ch0;
import com.repackage.f9;
import com.repackage.hb1;
import com.repackage.hi;
import com.repackage.ht4;
import com.repackage.q85;
import com.repackage.tr4;
import com.repackage.ur4;
import com.repackage.vr4;
import com.repackage.wr4;
import com.repackage.zf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
/* loaded from: classes3.dex */
public class TiebaBaseApplication extends TbadkApplication {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TiebaBaseApplication() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void a() {
        int i;
        BaseTaskPool applicationTaskPool;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (isMainProcess(false)) {
                i = 1;
            } else if (isRemoteProcess()) {
                i = 16;
            } else {
                i = isYunPushProcess() ? 256 : LaunchTaskConstants.OTHER_PROCESS;
            }
            HashSet<String> hashSet = new HashSet<>();
            if (SpeedRuntime.getSpeedContext().isMainProcess()) {
                String q = ht4.k().q("key_sync_task_switch", "");
                if (!StringUtils.isNull(q) && (split = q.split("_")) != null && split.length > 0) {
                    Collections.addAll(hashSet, split);
                }
            }
            if (wr4.a().a) {
                applicationTaskPool = new PBTaskPool();
            } else {
                applicationTaskPool = new ApplicationTaskPool();
            }
            LaunchTaskSchedule.getInstance().init(i, applicationTaskPool, hashSet);
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
            if (PreInitMainTabViewSwitch.getIsOn()) {
                LaunchTaskSchedule.getInstance().startTaskInSingleThread(4);
            }
            LaunchTaskSchedule.getInstance().start(2);
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                LaunchTaskSchedule.getInstance().start(3);
            }
        }
    }

    @Override // com.baidu.tbadk.TbadkApplication, com.baidu.tbadk.core.TbadkCoreApplication, com.baidu.adp.base.BdBaseApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            TbadkApplication.sApp = this;
            SpeedStatsManager.getInstance().setMainProcessFlag(isMainProcess(false, context));
            SpeedStatsManager.getInstance().addStatsTimeStamp(1000);
            SpeedStatsManager.getInstance().addStatsTimeStamp(1002);
            super.attachBaseContext(context);
            this.mContext = context;
            AppConfig.init(false, false, false, false);
            AppRuntimeInit.onApplicationattachBaseContext(this);
            AppRuntimePreloader.preload(isMainProcess(false, context));
            if (!LaunchUpApplicationSwitch.getIsOn()) {
                fixOppoTimeout();
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(1003);
            if (!LaunchUpApplicationSwitch.getIsOn()) {
                SwanAppInitHelper.initContext(this);
            }
            hb1.b(this);
            if (isMainProcess(false, context)) {
                tr4.b(context);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(1004);
            e();
            SpeedStatsManager.getInstance().addStatsTimeStamp(1011);
            TitanIniter.init(this);
            LoaderManager.getInstance().load();
            SpeedStatsManager.getInstance().addStatsTimeStamp(1012);
            ch0.b(this);
            SpeedStatsManager.getInstance().addStatsTimeStamp(1010);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && isMainProcess(false) && PermissionUtil.isAgreePrivacyPolicy()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new TaskManagerLaunchFetchListener());
            arrayList.add(new vr4());
            arrayList.add(new ur4());
            AppLaunchInfoFetcher.e(this, arrayList);
        }
    }

    public final void c(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, application) == null) {
            this.mContext = application;
            f();
            d();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            hi.d().e(this.mContext);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            NPSHookManager.init(this);
            Configurations.Builder builder = new Configurations.Builder();
            builder.debug(false);
            NPSManager.getInstance().init(this, builder.build(), false);
            LayoutInflaterFixer.a();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if ((this.mContext.getApplicationInfo().flags & 2) == 0) {
                this.mIsDebugMode = false;
            } else {
                this.mIsDebugMode = true;
            }
        }
    }

    @Override // com.baidu.tbadk.TbadkApplication, com.baidu.tbadk.core.TbadkCoreApplication, com.baidu.adp.base.BdBaseApplication, android.app.Application
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.processCreateTime = System.currentTimeMillis();
            SpeedStats.getInstance().setContext(this);
            SpeedStatsManager.getInstance().addStatsTimeStamp(2000);
            TbadkApplication.sApp = this;
            if (isMainProcess(false)) {
                tr4.a();
            }
            f9.a().b(super.getResources());
            c(this);
            super.onCreate();
            SpeedStatsManager.getInstance().addStatsTimeStamp(2001);
            initSpeedInstallStatus();
            b();
            SpeedStatsManager.getInstance().addStatsTimeStamp(2002);
            a();
            SpeedStatsManager.getInstance().addStatsTimeStamp(2003);
            q85.b().F(System.currentTimeMillis());
            if (isMainProcess(false)) {
                tr4.j();
            }
            zf.a().b();
            SpeedStatsManager.getInstance().addStatsTimeStamp(2004);
            SpeedStats.getInstance().onAppCreateEnd();
        }
    }
}
