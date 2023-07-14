package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.zb3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public final class h83 extends dc3 implements f83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> b;
    public final HashMap<String, g83> c;

    /* loaded from: classes6.dex */
    public class a implements oq3<zb3.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h83 a;

        public a(h83 h83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h83Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(zb3.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (h83.d) {
                    h83 h83Var = this.a;
                    h83Var.T("onEventCallback msg" + aVar);
                }
                this.a.V(aVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements oq3<zb3.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h83 a;

        public b(h83 h83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h83Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(zb3.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (h83.d) {
                    h83 h83Var = this.a;
                    h83Var.T("onEventCallback msg" + aVar);
                }
                this.a.W(aVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static h83 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-791542169, "Lcom/baidu/tieba/h83$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-791542169, "Lcom/baidu/tieba/h83$c;");
                    return;
                }
            }
            a = new h83(ub3.K());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947777542, "Lcom/baidu/tieba/h83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947777542, "Lcom/baidu/tieba/h83;");
                return;
            }
        }
        d = fs1.a;
    }

    public static h83 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return c.a;
        }
        return (h83) invokeV.objValue;
    }

    public static void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            R();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h83(yb3 yb3Var) {
        super(yb3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yb3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((yb3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new HashMap<>();
        this.c = new HashMap<>();
        if (d) {
            T("SwanIpc");
        }
        sb3 sb3Var = new sb3();
        sb3Var.f(new b(this), "event_messenger_call_out");
        sb3Var.f(new a(this), "event_messenger_call_in");
        u(sb3Var);
    }

    public static synchronized boolean J(@NonNull Bundle bundle, @NonNull String str) {
        InterceptResult invokeLL;
        boolean L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bundle, str)) == null) {
            synchronized (h83.class) {
                L = R().L(Z(bundle), str);
            }
            return L;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized boolean K(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        boolean L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            synchronized (h83.class) {
                L = R().L(a0(str), str2);
            }
            return L;
        }
        return invokeLL.booleanValue;
    }

    public final synchronized boolean I(@NonNull g83 g83Var, @NonNull Bundle bundle) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, g83Var, bundle)) == null) {
            synchronized (this) {
                if (g83Var.Z()) {
                    if (L(g83Var, bundle.getString("ipc_topic", ""))) {
                        z = true;
                    }
                }
                z = false;
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public final void U(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            T(str + ": " + str2);
        }
    }

    public h83 b0(g83 g83Var, Exception exc) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, g83Var, exc)) == null) {
            if (g83Var != null) {
                synchronized (this.c) {
                    g83Var.M(exc);
                    this.c.remove(g83Var.Q());
                }
            }
            return this;
        }
        return (h83) invokeLL.objValue;
    }

    public static synchronized g83 Q(@NonNull String str) {
        InterceptResult invokeL;
        g83 e0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            synchronized (h83.class) {
                e0 = R().e0(str);
            }
            return e0;
        }
        return (g83) invokeL.objValue;
    }

    public static synchronized g83 Z(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        g83 c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bundle)) == null) {
            synchronized (h83.class) {
                c0 = R().c0(bundle);
            }
            return c0;
        }
        return (g83) invokeL.objValue;
    }

    public static synchronized g83 a0(@NonNull String str) {
        InterceptResult invokeL;
        g83 d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            synchronized (h83.class) {
                d0 = R().d0(str, null);
            }
            return d0;
        }
        return (g83) invokeL.objValue;
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && d) {
            Log.i("SwanIpc", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    public String X(@NonNull g83 g83Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, g83Var)) == null) {
            return Y(g83Var.Q());
        }
        return (String) invokeL.objValue;
    }

    public String Y(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return this.b.get(str);
        }
        return (String) invokeL.objValue;
    }

    public final synchronized g83 c0(Bundle bundle) {
        InterceptResult invokeL;
        String string;
        g83 d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bundle)) == null) {
            synchronized (this) {
                if (bundle == null) {
                    string = null;
                } else {
                    string = bundle.getString("ipc_session_id");
                }
                d0 = d0(string, bundle);
            }
            return d0;
        }
        return (g83) invokeL.objValue;
    }

    public final synchronized boolean L(@NonNull g83 g83Var, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g83Var, str)) == null) {
            synchronized (this) {
                boolean z = false;
                if (!g83Var.Z()) {
                    return false;
                }
                String Q = g83Var.Q();
                String str2 = this.b.get(Q);
                boolean z2 = !TextUtils.isEmpty(str2);
                z = (!z2 || TextUtils.equals(str2, str)) ? true : true;
                if (z && !z2 && !TextUtils.isEmpty(str)) {
                    this.b.put(Q, str);
                }
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void V(zb3.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (d) {
                U("onCallIn", "msg=" + aVar);
            }
            if (aVar != null) {
                Bundle D = aVar.D();
                zb3.a aVar2 = new zb3.a("event_messenger_call", D);
                g83 Z = Z(D);
                if (!I(Z, D) || !Z.X(aVar2)) {
                    ub3.K().A(aVar2);
                }
            }
        }
    }

    public final void W(zb3.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (d) {
                U("onCallOut", "msg=" + aVar);
            }
            if (aVar != null) {
                Z(aVar.D()).call();
            }
        }
    }

    public final synchronized g83 e0(String str) {
        InterceptResult invokeL;
        g83 c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            synchronized (this) {
                c0 = c0(null);
                L(c0, str);
                if (d) {
                    U("topic", str + " session=" + c0);
                }
            }
            return c0;
        }
        return (g83) invokeL.objValue;
    }

    public final synchronized g83 d0(String str, Bundle bundle) {
        InterceptResult invokeLL;
        g83 g83Var;
        boolean z;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bundle)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    g83Var = null;
                } else {
                    g83Var = this.c.get(str);
                }
                if (g83Var == null || !g83Var.Z()) {
                    b0(g83Var, new IllegalStateException("invalid session"));
                    g83Var = new g83(this, str);
                    this.c.put(g83Var.Q(), g83Var);
                }
                if (bundle != null && I(g83Var, bundle)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    int i = bundle.getInt("ipc_session_repal", SwanAppProcessInfo.UNKNOWN.index);
                    if (SwanAppProcessInfo.checkProcessId(i)) {
                        g83Var.I(i);
                    } else if (SwanAppProcessInfo.SERVICE.index == i) {
                        g83Var.K(true);
                    }
                }
                if (z) {
                    j = bundle.getLong("ipc_session_timeout");
                } else {
                    j = f83.o0;
                }
                g83Var.S(j);
                if (d) {
                    U("session", "id=" + str + " session=" + bundle + " session=" + g83Var);
                }
            }
            return g83Var;
        }
        return (g83) invokeLL.objValue;
    }
}
