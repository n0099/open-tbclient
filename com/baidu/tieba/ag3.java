package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class ag3<ResultDataT> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final gg3<ResultDataT> a;
    public final Set<wp3<gg3<ResultDataT>>> b;
    public final LinkedList<cg3> c;
    public boolean d;
    public boolean e;

    public abstract void i();

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public abstract ResultDataT m(JSONObject jSONObject) throws JSONException;

    public ag3<ResultDataT> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? this : (ag3) invokeL.objValue;
    }

    /* loaded from: classes5.dex */
    public class a extends cg3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ag3 c;

        public a(ag3 ag3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ag3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ag3Var;
        }

        @Override // com.baidu.tieba.cg3
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.c.k()) {
                    return true;
                }
                bg3.k("initialPrepare failed", Boolean.TRUE);
                throw new OAuthException(10001);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends cg3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ag3 c;

        public b(ag3 ag3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ag3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ag3Var;
        }

        @Override // com.baidu.tieba.cg3
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!this.c.j()) {
                    bg3.k("finalPrepare failed", Boolean.TRUE);
                    if (ag3.f) {
                        throw new OAuthException(10001);
                    }
                    return true;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp3 a;
        public final /* synthetic */ ag3 b;

        public c(ag3 ag3Var, wp3 wp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ag3Var, wp3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ag3Var;
            this.a = wp3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            wp3 wp3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (wp3Var = this.a) != null) {
                wp3Var.a(this.b.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947614172, "Lcom/baidu/tieba/ag3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947614172, "Lcom/baidu/tieba/ag3;");
                return;
            }
        }
        f = nr1.a;
    }

    public final synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                i();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b bVar = new b(this);
            bVar.h(this);
            bVar.g();
            this.e = true;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d(null);
        }
    }

    @NonNull
    public ag3 call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TaskState.INIT == e()) {
                s(TaskState.CALLING);
                n();
            }
            return this;
        }
        return (ag3) invokeV.objValue;
    }

    public TaskState e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.b;
        }
        return (TaskState) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a aVar = new a(this);
            aVar.h(this);
            aVar.g();
            this.d = true;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            for (wp3<gg3<ResultDataT>> wp3Var : this.b) {
                bg3.l(new c(this, wp3Var));
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.a.b = TaskState.INIT;
            this.d = false;
            this.e = false;
        }
    }

    public ag3() {
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
        this.a = new gg3<>();
        this.b = new HashSet();
        this.c = new LinkedList<>();
        this.d = false;
        this.e = false;
    }

    public void d(@Nullable Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            if (exc instanceof OAuthException) {
                this.a.c = (OAuthException) exc;
            } else if (exc != null) {
                bg3.t("OAuthTask#finish", exc.getMessage());
                this.a.c = new OAuthException(exc, 10001);
            }
            if (!this.a.c() && f && exc != null) {
                exc.printStackTrace();
            }
            s(TaskState.FINISHED);
            bg3.k(toString(), Boolean.FALSE);
            g();
            this.b.clear();
        }
    }

    public ag3 h(@NonNull cg3 cg3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cg3Var)) == null) {
            cg3Var.h(this);
            this.c.offer(cg3Var);
            return this;
        }
        return (ag3) invokeL.objValue;
    }

    public void l(cg3 cg3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cg3Var) == null) {
            if (cg3Var.c()) {
                n();
            } else {
                d(cg3Var.b());
            }
        }
    }

    public ag3<ResultDataT> o(wp3<gg3<ResultDataT>> wp3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, wp3Var)) == null) {
            if (this.a.b.isCallbackAvailable()) {
                this.b.add(wp3Var);
            }
            return this;
        }
        return (ag3) invokeL.objValue;
    }

    public void r(ResultDataT resultdatat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, resultdatat) == null) {
            this.a.a = resultdatat;
        }
    }

    public final void s(TaskState taskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, taskState) == null) {
            this.a.b = taskState;
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!TaskState.CALLING.equals(e())) {
                if (f) {
                    bg3.k("IllegalState on prepare", Boolean.FALSE);
                }
            } else if (!this.d) {
                f();
            } else if (!this.c.isEmpty()) {
                this.c.poll().g();
            } else if (!this.e) {
                b();
            } else {
                a();
            }
        }
    }
}
