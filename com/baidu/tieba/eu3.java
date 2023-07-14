package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class eu3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bu3 a;

        public a(bu3 bu3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bu3Var;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
                super.unAvailable(oneKeyLoginResult);
                this.a.a(null);
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void available(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                if (oneKeyLoginResult == null) {
                    this.a.a(null);
                    return;
                }
                boolean z = oneKeyLoginResult.enable;
                String str = oneKeyLoginResult.operator;
                String str2 = oneKeyLoginResult.encryptPhoneNum;
                boolean z2 = oneKeyLoginResult.hasHistory;
                zt3 zt3Var = new zt3();
                zt3Var.j(z);
                zt3Var.k(str);
                zt3Var.g(str2);
                zt3Var.h(z2);
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 2154) {
                    if (hashCode != 2161) {
                        if (hashCode == 2162 && str.equals("CU")) {
                            c = 1;
                        }
                    } else if (str.equals("CT")) {
                        c = 2;
                    }
                } else if (str.equals("CM")) {
                    c = 0;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c == 2) {
                            zt3Var.i(14);
                        }
                    } else {
                        zt3Var.i(13);
                    }
                } else {
                    zt3Var.i(12);
                }
                this.a.a(QuickLoginInfo.parseQuickLoginInfo(zt3Var));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends b83 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bu3 c;

        public b(bu3 bu3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bu3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b83, com.baidu.tieba.c83, com.baidu.tieba.a83
        public void onEvent(@NonNull y73 y73Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y73Var) == null) {
                Bundle a = y73Var.a();
                if (a == null) {
                    this.c.a(null);
                    return;
                }
                a.setClassLoader(QuickLoginInfo.class.getClassLoader());
                QuickLoginInfo quickLoginInfo = (QuickLoginInfo) a.getParcelable("quick_login_info_result");
                if (quickLoginInfo == null) {
                    this.c.a(null);
                } else {
                    this.c.a(quickLoginInfo);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ du3 b;

        public c(Activity activity, du3 du3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, du3Var};
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
            this.b = du3Var;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void available(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                rs3.a().m(this.a, oneKeyLoginResult.sign, this.b);
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
                this.b.onResult(-1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ du3 a;

        public d(du3 du3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {du3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = du3Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                Bundle bundle = delegateResult.mResult;
                if (this.a != null) {
                    this.a.onResult(uo3.f(bundle, "quick_login", -1));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947746790, "Lcom/baidu/tieba/eu3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947746790, "Lcom/baidu/tieba/eu3;");
                return;
            }
        }
        boolean z = fs1.a;
    }

    public static void a(bu3 bu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, bu3Var) == null) {
            SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new a(bu3Var));
        }
    }

    public static void b(bu3 bu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bu3Var) == null) {
            if (ProcessUtils.isMainProcess()) {
                a(bu3Var);
            } else {
                c(bu3Var);
            }
        }
    }

    public static void c(bu3 bu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bu3Var) == null) {
            vb3 b0 = vb3.b0();
            if (b0 == null) {
                bu3Var.a(null);
                return;
            }
            q83 y = b0.y();
            if (y == null) {
                bu3Var.a(null);
            } else {
                y.X(null, au3.class, new b(bu3Var));
            }
        }
    }

    public static void d(Activity activity, int i, du3 du3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, i, du3Var) == null) {
            SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new c(activity, du3Var));
        }
    }

    public static void e(Activity activity, int i, du3 du3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65541, null, activity, i, du3Var) == null) {
            if (ProcessUtils.isMainProcess()) {
                d(activity, i, du3Var);
            } else {
                f(activity, i, du3Var);
            }
        }
    }

    public static void f(Activity activity, int i, du3 du3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65542, null, activity, i, du3Var) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("quick_login_mode", i);
            DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, cu3.class, bundle, new d(du3Var));
        }
    }
}
