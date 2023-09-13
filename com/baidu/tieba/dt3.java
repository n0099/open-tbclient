package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.LoginAndGetMobileActivity;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dt3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public Bundle a;

    /* loaded from: classes5.dex */
    public class a implements nt3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ tr1 b;
        public final /* synthetic */ dt3 c;

        /* renamed from: com.baidu.tieba.dt3$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0262a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0262a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    pa3.d(this.a.a);
                }
            }
        }

        public a(dt3 dt3Var, ViewGroup viewGroup, tr1 tr1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dt3Var, viewGroup, tr1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dt3Var;
            this.a = viewGroup;
            this.b = tr1Var;
        }

        @Override // com.baidu.tieba.nt3
        public void a(QuickLoginInfo quickLoginInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, quickLoginInfo) == null) {
                ViewGroup viewGroup = this.a;
                if (viewGroup != null) {
                    viewGroup.post(new RunnableC0262a(this));
                }
                if (this.c.i(quickLoginInfo)) {
                    this.c.a.putParcelable("quick_login_info", quickLoginInfo);
                }
                String T2 = gb3.K().q().W().T();
                String appId = gb3.K().getAppId();
                this.c.a.putString("app_name", gb3.K().q().Z());
                this.c.a.putString("appid", appId);
                this.c.a.putString("launch_from", T2);
                if (dt3.b) {
                    Log.d("LoginAndGetMobile", "onQueryResult: mParams: " + this.c.a.toString());
                }
                gt3.a("show", "login", null, T2, appId);
                this.c.f(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tr1 a;

        public b(dt3 dt3Var, tr1 tr1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dt3Var, tr1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tr1Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                if (delegateResult.isOk()) {
                    this.a.onResult(delegateResult.mResult.getInt("loginStatusCode"));
                    return;
                }
                this.a.onResult(-2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947716038, "Lcom/baidu/tieba/dt3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947716038, "Lcom/baidu/tieba/dt3;");
                return;
            }
        }
        b = rr1.a;
    }

    public dt3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new Bundle();
    }

    public final void f(tr1 tr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tr1Var) == null) {
            if (ProcessUtils.isMainProcess()) {
                e(tr1Var);
            } else {
                g(tr1Var);
            }
        }
    }

    public final void g(tr1 tr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tr1Var) == null) {
            DelegateUtils.callOnMainWithActivity(uw2.T().getActivity(), PluginDelegateActivity.class, et3.class, this.a, new b(this, tr1Var));
        }
    }

    public final boolean i(QuickLoginInfo quickLoginInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, quickLoginInfo)) == null) {
            if (quickLoginInfo != null && quickLoginInfo.supportQuickLogin) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void e(tr1 tr1Var) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, tr1Var) != null) || (activity = uw2.T().getActivity()) == null) {
            return;
        }
        Intent intent = new Intent(activity, LoginAndGetMobileActivity.class);
        intent.putExtras(this.a);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.obfuscated_res_0x7f0100b7, 0);
        ft3.c(tr1Var);
    }

    public void h(tr1 tr1Var) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tr1Var) == null) {
            SwanAppActivity w = gb3.K().w();
            if (w != null && !w.isFinishing()) {
                viewGroup = (ViewGroup) w.findViewById(16908290);
                pa3.h(w, viewGroup, w.getResources().getString(R.string.obfuscated_res_0x7f0f1556));
            } else {
                viewGroup = null;
            }
            qt3.b(new a(this, viewGroup, tr1Var));
        }
    }
}
