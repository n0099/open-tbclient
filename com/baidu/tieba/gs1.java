package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class gs1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public hs1 b;

    /* loaded from: classes4.dex */
    public interface b {
        void a(ew1 ew1Var);
    }

    @NonNull
    public abstract ew1 d(@NonNull JSONObject jSONObject, @NonNull b bVar);

    @NonNull
    public abstract ew1 e(@NonNull JSONObject jSONObject);

    public abstract boolean i();

    /* loaded from: classes4.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ gs1 b;

        public a(gs1 gs1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gs1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gs1Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.gs1.b
        public void a(ew1 ew1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ew1Var) == null) {
                if (gs1.c) {
                    Log.d("SwanAutoSyncApiHandler", this.b.a + " async callback: " + ew1Var.toString());
                }
                this.b.b.d(this.a, ew1Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947804388, "Lcom/baidu/tieba/gs1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947804388, "Lcom/baidu/tieba/gs1;");
                return;
            }
        }
        c = ok1.a;
    }

    public gs1(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
    }

    public ew1 f(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull hs1 hs1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str, hs1Var)) == null) {
            this.b = hs1Var;
            if (c) {
                Log.d("SwanAutoSyncApiHandler", this.a + " is called, can use sync mode: " + i() + ", params" + jSONObject.toString() + ", callback: " + str);
            }
            if (i()) {
                return h(jSONObject);
            }
            return g(jSONObject, str);
        }
        return (ew1) invokeLLL.objValue;
    }

    public final ew1 g(@NonNull JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, jSONObject, str)) == null) {
            if (c) {
                Log.d("SwanAutoSyncApiHandler", this.a + " start handle async");
            }
            ew1 d = d(jSONObject, new a(this, str));
            if (!d.h("isSync", Boolean.FALSE)) {
                if (c) {
                    Log.e("SwanAutoSyncApiHandler", this.a + " handleAsync encounter error, json exception");
                }
                return new ew1(1001, "make result json error");
            }
            if (c) {
                Log.d("SwanAutoSyncApiHandler", this.a + " end handle async, processing in other thread, sync result: " + d.toString());
            }
            return d;
        }
        return (ew1) invokeLL.objValue;
    }

    public final ew1 h(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            if (c) {
                Log.d("SwanAutoSyncApiHandler", this.a + " start handle sync");
            }
            ew1 e = e(jSONObject);
            if (!e.h("isSync", Boolean.TRUE)) {
                if (c) {
                    Log.e("SwanAutoSyncApiHandler", this.a + " handleSync encounter error, json exception");
                }
                return new ew1(1001, "make result json error");
            }
            if (c) {
                Log.d("SwanAutoSyncApiHandler", this.a + " end handle sync, result: " + e.toString());
            }
            return e;
        }
        return (ew1) invokeL.objValue;
    }
}
