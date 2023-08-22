package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class aj0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<cj0> d;
    public static final List<ej0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, cj0> a;
    public final Map<String, ej0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947616962, "Lcom/baidu/tieba/aj0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947616962, "Lcom/baidu/tieba/aj0;");
                return;
            }
        }
        lj0 lj0Var = new lj0();
        d = lj0Var.a.getList();
        e = lj0Var.b.getList();
    }

    public aj0() {
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
        this.a = new HashMap();
        this.b = Collections.synchronizedMap(new LinkedHashMap());
        this.c = new ArrayList<>();
        synchronized (aj0.class) {
            if (d != null && this.a.isEmpty()) {
                for (cj0 cj0Var : d) {
                    if (cj0Var != null) {
                        if (f31.b(this.a, cj0Var.a()) == null) {
                            f31.e(this.a, cj0Var.a(), cj0Var);
                        }
                        if (!TextUtils.isEmpty(cj0Var.a())) {
                            d31.b(this.c, cj0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (ej0 ej0Var : e) {
                    this.b.put(ej0Var.b(), ej0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull gj0 gj0Var, @Nullable Map<String, Object> map, @Nullable kj0 kj0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, gj0Var, map, kj0Var)) == null) {
            if (b(context, gj0Var, map, kj0Var)) {
                pj0.b(kj0Var, gj0Var, 0, true);
                return true;
            }
            cj0 cj0Var = null;
            if (pj0.f(gj0Var.a())) {
                cj0Var = (cj0) f31.b(this.a, gj0Var.a());
            }
            if (pj0.g(gj0Var.c()) && cj0Var != null) {
                gj0Var.f();
                return cj0Var.b(context, gj0Var, map, kj0Var);
            }
            return hj0.a().a(context, gj0Var.b(), map, kj0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, gj0 gj0Var, @Nullable Map<String, Object> map, @Nullable kj0 kj0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, gj0Var, map, kj0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            ej0 ej0Var = null;
            try {
                for (Map.Entry<String, ej0> entry : this.b.entrySet()) {
                    String a2 = gj0Var.a();
                    if (entry == null || ((ej0Var = entry.getValue()) != null && (a = ej0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (ej0Var != null && ej0Var.d(context, gj0Var, map, kj0Var)) {
                            return true;
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
