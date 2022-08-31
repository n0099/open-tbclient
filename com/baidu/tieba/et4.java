package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class et4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public int c;
    public String d;
    public boolean e;
    public Handler f;

    /* loaded from: classes3.dex */
    public class a implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        public a(et4 et4Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et4Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i = et4.a().c == 1 ? 8 : -1;
                if (et4.a().c == 2) {
                    i = 9;
                }
                if (this.a.getClass().getSimpleName().equals("PbActivity")) {
                    return false;
                }
                SpeedStats.getInstance().onSchemeOrPushStatsEnd(this.a, i, et4.a().d);
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MessageQueue.IdleHandler a;
        public final /* synthetic */ et4 b;

        public b(et4 et4Var, MessageQueue.IdleHandler idleHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et4Var, idleHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = et4Var;
            this.a = idleHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.d(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final et4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-821988571, "Lcom/baidu/tieba/et4$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-821988571, "Lcom/baidu/tieba/et4$c;");
                    return;
                }
            }
            a = new et4();
        }
    }

    public et4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.e = false;
    }

    public static et4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a : (et4) invokeV.objValue;
    }

    public final Handler b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f == null) {
                this.f = new Handler(Looper.getMainLooper());
            }
            return this.f;
        }
        return (Handler) invokeV.objValue;
    }

    public void c(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(false) || intent == null || intent.getComponent() == null) {
                return;
            }
            String dataString = intent.getDataString();
            String className = intent.getComponent().getClassName();
            if ("com.baidu.tieba.tblauncher.SchemaRouteActivity".equals(className)) {
                this.c = !qi.isEmpty(dataString) ? 1 : 0;
                this.d = dataString;
            } else if (SpeedStats.PUSH_ACTIVITY.equals(className)) {
                this.c = qi.isEmpty(dataString) ? 0 : 2;
                this.d = dataString;
            } else {
                this.c = 0;
            }
        }
    }

    public void d(MessageQueue.IdleHandler idleHandler) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, idleHandler) == null) || idleHandler == null || this.e) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            b().post(new b(this, idleHandler));
            return;
        }
        Looper.myQueue().addIdleHandler(idleHandler);
        this.e = true;
    }

    public void e(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, activity) == null) || activity == null) {
            return;
        }
        if (a().c == 1 || a().c == 2) {
            String name = activity.getClass().getName();
            if (!ft4.a().d() || SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(name) || SpeedStats.PUSH_ACTIVITY.equals(name) || "com.baidu.tieba.tblauncher.SchemaRouteActivity".equals(name)) {
                return;
            }
            if (!SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(name) || SchemeActionHelper.isToMaintab(activity.getIntent())) {
                a().d(new a(this, activity));
            }
        }
    }
}
