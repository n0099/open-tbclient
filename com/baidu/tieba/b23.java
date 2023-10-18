package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.t53;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class b23 extends x53 implements z13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> b;
    public final HashMap<String, a23> c;

    /* loaded from: classes5.dex */
    public class a implements ik3<t53.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b23 a;

        public a(b23 b23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b23Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b23Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(t53.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (b23.d) {
                    b23 b23Var = this.a;
                    b23Var.T("onEventCallback msg" + aVar);
                }
                this.a.V(aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ik3<t53.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b23 a;

        public b(b23 b23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b23Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b23Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(t53.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (b23.d) {
                    b23 b23Var = this.a;
                    b23Var.T("onEventCallback msg" + aVar);
                }
                this.a.W(aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static b23 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-968858201, "Lcom/baidu/tieba/b23$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-968858201, "Lcom/baidu/tieba/b23$c;");
                    return;
                }
            }
            a = new b23(o53.K());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947593030, "Lcom/baidu/tieba/b23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947593030, "Lcom/baidu/tieba/b23;");
                return;
            }
        }
        d = am1.a;
    }

    public static b23 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return c.a;
        }
        return (b23) invokeV.objValue;
    }

    public static void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            R();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b23(s53 s53Var) {
        super(s53Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s53Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((s53) newInitContext.callArgs[0]);
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
        m53 m53Var = new m53();
        m53Var.f(new b(this), "event_messenger_call_out");
        m53Var.f(new a(this), "event_messenger_call_in");
        u(m53Var);
    }

    public static synchronized boolean J(@NonNull Bundle bundle, @NonNull String str) {
        InterceptResult invokeLL;
        boolean L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bundle, str)) == null) {
            synchronized (b23.class) {
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
            synchronized (b23.class) {
                L = R().L(a0(str), str2);
            }
            return L;
        }
        return invokeLL.booleanValue;
    }

    public final synchronized boolean I(@NonNull a23 a23Var, @NonNull Bundle bundle) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, a23Var, bundle)) == null) {
            synchronized (this) {
                if (a23Var.c0()) {
                    if (L(a23Var, bundle.getString("ipc_topic", ""))) {
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

    public b23 b0(a23 a23Var, Exception exc) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, a23Var, exc)) == null) {
            if (a23Var != null) {
                synchronized (this.c) {
                    a23Var.P(exc);
                    this.c.remove(a23Var.T());
                }
            }
            return this;
        }
        return (b23) invokeLL.objValue;
    }

    public static synchronized a23 Q(@NonNull String str) {
        InterceptResult invokeL;
        a23 e0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            synchronized (b23.class) {
                e0 = R().e0(str);
            }
            return e0;
        }
        return (a23) invokeL.objValue;
    }

    public static synchronized a23 Z(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        a23 c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bundle)) == null) {
            synchronized (b23.class) {
                c0 = R().c0(bundle);
            }
            return c0;
        }
        return (a23) invokeL.objValue;
    }

    public static synchronized a23 a0(@NonNull String str) {
        InterceptResult invokeL;
        a23 d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            synchronized (b23.class) {
                d0 = R().d0(str, null);
            }
            return d0;
        }
        return (a23) invokeL.objValue;
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && d) {
            Log.i("SwanIpc", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    public String X(@NonNull a23 a23Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, a23Var)) == null) {
            return Y(a23Var.T());
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

    public final synchronized a23 c0(Bundle bundle) {
        InterceptResult invokeL;
        String string;
        a23 d0;
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
        return (a23) invokeL.objValue;
    }

    public final synchronized boolean L(@NonNull a23 a23Var, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a23Var, str)) == null) {
            synchronized (this) {
                boolean z = false;
                if (!a23Var.c0()) {
                    return false;
                }
                String T2 = a23Var.T();
                String str2 = this.b.get(T2);
                boolean z2 = !TextUtils.isEmpty(str2);
                z = (!z2 || TextUtils.equals(str2, str)) ? true : true;
                if (z && !z2 && !TextUtils.isEmpty(str)) {
                    this.b.put(T2, str);
                }
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void V(t53.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (d) {
                U("onCallIn", "msg=" + aVar);
            }
            if (aVar != null) {
                Bundle D = aVar.D();
                t53.a aVar2 = new t53.a("event_messenger_call", D);
                a23 Z = Z(D);
                if (!I(Z, D) || !Z.a0(aVar2)) {
                    o53.K().A(aVar2);
                }
            }
        }
    }

    public final void W(t53.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (d) {
                U("onCallOut", "msg=" + aVar);
            }
            if (aVar != null) {
                Z(aVar.D()).M();
            }
        }
    }

    public final synchronized a23 e0(String str) {
        InterceptResult invokeL;
        a23 c0;
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
        return (a23) invokeL.objValue;
    }

    public final synchronized a23 d0(String str, Bundle bundle) {
        InterceptResult invokeLL;
        a23 a23Var;
        boolean z;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bundle)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    a23Var = null;
                } else {
                    a23Var = this.c.get(str);
                }
                if (a23Var == null || !a23Var.c0()) {
                    b0(a23Var, new IllegalStateException("invalid session"));
                    a23Var = new a23(this, str);
                    this.c.put(a23Var.T(), a23Var);
                }
                if (bundle != null && I(a23Var, bundle)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    int i = bundle.getInt("ipc_session_repal", SwanAppProcessInfo.UNKNOWN.index);
                    if (SwanAppProcessInfo.checkProcessId(i)) {
                        a23Var.J(i);
                    } else if (SwanAppProcessInfo.SERVICE.index == i) {
                        a23Var.L(true);
                    }
                }
                if (z) {
                    j = bundle.getLong("ipc_session_timeout");
                } else {
                    j = z13.o0;
                }
                a23Var.V(j);
                if (d) {
                    U("session", "id=" + str + " session=" + bundle + " session=" + a23Var);
                }
            }
            return a23Var;
        }
        return (a23) invokeLL.objValue;
    }
}
