package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.npsplugin.LayoutInflaterFixer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.NPSHookManager;
import com.baidu.nps.main.manager.Configurations;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.appframework.GlobalActivityLifecycle;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.common.security.DeviceInfoManager;
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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.switchs.PreInitMainTabViewSwitch;
import com.baidu.tbadk.switchs.WindowGreySwitch;
import com.baidu.tbadk.util.AppLaunchInfoFetcher;
import com.baidu.titan.sdk.initer.TitanIniter;
import com.baidu.titan.sdk.loader.LoaderManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class TiebaBaseApplication extends TbadkApplication {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements aj {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaBaseApplication a;

        public a(TiebaBaseApplication tiebaBaseApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaBaseApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tiebaBaseApplication;
        }

        @Override // com.baidu.tieba.aj
        public boolean isAgreePrivacyPolicy() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return PermissionUtil.isAgreePrivacyPolicy();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.aj
        public boolean isBrowseMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return PermissionUtil.isBrowseMode();
            }
            return invokeV.booleanValue;
        }
    }

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

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            oi.d().e(this.mContext);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            DeviceInfoManager.INSTANCE.preInit(this, true);
            xi.m(new a(this));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            NPSHookManager.init(this);
            Configurations.Builder builder = new Configurations.Builder();
            builder.debug(false);
            NPSManager.getInstance().init(this, builder.build(), false);
            LayoutInflaterFixer.a();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if ((this.mContext.getApplicationInfo().flags & 2) == 0) {
                this.mIsDebugMode = false;
            } else {
                this.mIsDebugMode = true;
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
            } else if (isYunPushProcess()) {
                i = 256;
            } else {
                i = LaunchTaskConstants.OTHER_PROCESS;
            }
            HashSet<String> hashSet = new HashSet<>();
            if (SpeedRuntime.getSpeedContext().isMainProcess()) {
                String s = n95.m().s("key_sync_task_switch", "");
                if (!StringUtils.isNull(s) && (split = s.split("_")) != null && split.length > 0) {
                    Collections.addAll(hashSet, split);
                }
            }
            if (f85.a().a) {
                applicationTaskPool = new PBTaskPool();
            } else {
                applicationTaskPool = new ApplicationTaskPool();
            }
            try {
                LaunchTaskSchedule.getInstance().init(i, applicationTaskPool, hashSet);
                LaunchTaskSchedule.getInstance().start(1);
                if (PreInitMainTabViewSwitch.getIsOn()) {
                    LaunchTaskSchedule.getInstance().startTaskInSingleThread(4);
                }
                LaunchTaskSchedule.getInstance().start(2);
                if (PermissionUtil.isAgreePrivacyPolicy()) {
                    LaunchTaskSchedule.getInstance().start(3);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.TbadkApplication, com.baidu.tbadk.core.TbadkCoreApplication, com.baidu.adp.base.BdBaseApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            TbadkApplication.sApp = this;
            this.mContext = context;
            SpeedStatsManager.getInstance().addStatsTimeStamp(1000);
            SpeedStatsManager.getInstance().addStatsTimeStamp(1002);
            super.attachBaseContext(context);
            AppRuntimeInit.onApplicationattachBaseContext(this);
            ll1.b(this);
            AppConfig.init(false, false, false, false);
            SpeedStatsManager.getInstance().addStatsTimeStamp(1003);
            ola.b(this);
            SpeedStatsManager.getInstance().addStatsTimeStamp(1004);
            f();
            SpeedStatsManager.getInstance().addStatsTimeStamp(1011);
            TitanIniter.init(this);
            LoaderManager.getInstance().load();
            SpeedStatsManager.getInstance().addStatsTimeStamp(1012);
            lk0.b(this);
            BdBoxActivityManager.setMainGlobalActivityLifecycle(GlobalActivityLifecycle.getInstance());
            SpeedStatsManager.getInstance().addStatsTimeStamp(1010);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && isMainProcess(false) && PermissionUtil.isAgreePrivacyPolicy()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new TaskManagerLaunchFetchListener());
            arrayList.add(new e85());
            arrayList.add(new d85());
            AppLaunchInfoFetcher.e(this, arrayList);
        }
    }

    @Override // com.baidu.tbadk.TbadkApplication, com.baidu.tbadk.core.TbadkCoreApplication, com.baidu.adp.base.BdBaseApplication, android.app.Application
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            setPageStayOpen(true);
            doBeforeSuperOnCreate();
            super.onCreate();
            doAfterSuperOnCreate();
            if (!PermissionUtil.isAgreePrivacyPolicy()) {
                PermissionUtil.registerMutiProcessPrivacyPolicy();
                registerActivityLifecycleCallbacks(new k05());
            }
            registerActivityLifecycleCallbacks(new l05());
        }
    }

    public final void c(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, application) == null) {
            this.mContext = application;
            g();
            d();
            hm.d();
        }
    }

    @Override // com.baidu.tbadk.core.TbadkCoreApplication
    public void doAfterSuperOnCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (PermissionUtil.isBrowseMode()) {
                e();
                a();
            } else if (!PermissionUtil.isAgreePrivacyPolicy()) {
            } else {
                DeviceInfoManager.INSTANCE.preInit(this, true);
                SpeedStatsManager.getInstance().addStatsTimeStamp(2001);
                initSpeedInstallStatus();
                b();
                SpeedStatsManager.getInstance().addStatsTimeStamp(2002);
                a();
                SpeedStatsManager.getInstance().addStatsTimeStamp(2003);
                ss5.b().F(System.currentTimeMillis());
                if (isMainProcess(false)) {
                    c85.i();
                }
                if (WindowGreySwitch.getIsOn()) {
                    g9.f().q(true);
                }
                fg.a().b();
                SpeedStatsManager.getInstance().addStatsTimeStamp(2004);
                SpeedStats.getInstance().onAppCreateEnd();
            }
        }
    }

    @Override // com.baidu.tbadk.core.TbadkCoreApplication
    public void doBeforeSuperOnCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (PermissionUtil.isBrowseMode()) {
                m9.a().b(super.getResources());
            } else if (!PermissionUtil.isAgreePrivacyPolicy()) {
            } else {
                this.processCreateTime = System.currentTimeMillis();
                SpeedStatsManager.getInstance().setMainProcessFlag(isMainProcess(false, this));
                AppRuntimePreloader.preload(isMainProcess(false, this));
                if (isMainProcess(false, this)) {
                    c85.b(this);
                }
                SpeedStats.getInstance().setContext(this);
                SpeedStatsManager.getInstance().addStatsTimeStamp(2000);
                TbadkApplication.sApp = this;
                if (isMainProcess(false)) {
                    c85.a();
                }
                m9.a().b(super.getResources());
                c(this);
            }
        }
    }
}
