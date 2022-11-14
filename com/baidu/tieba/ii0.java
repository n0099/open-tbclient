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
/* loaded from: classes4.dex */
public class ii0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<ki0> d;
    public static final List<mi0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, ki0> a;
    public final Map<String, mi0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947854329, "Lcom/baidu/tieba/ii0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947854329, "Lcom/baidu/tieba/ii0;");
                return;
            }
        }
        ti0 ti0Var = new ti0();
        d = ti0Var.a.getList();
        e = ti0Var.b.getList();
    }

    public ii0() {
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
        synchronized (ii0.class) {
            if (d != null && this.a.isEmpty()) {
                for (ki0 ki0Var : d) {
                    if (ki0Var != null) {
                        if (r01.b(this.a, ki0Var.a()) == null) {
                            r01.e(this.a, ki0Var.a(), ki0Var);
                        }
                        if (!TextUtils.isEmpty(ki0Var.a())) {
                            p01.b(this.c, ki0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (mi0 mi0Var : e) {
                    this.b.put(mi0Var.b(), mi0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull oi0 oi0Var, @Nullable Map<String, Object> map, @Nullable si0 si0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, oi0Var, map, si0Var)) == null) {
            if (b(context, oi0Var, map, si0Var)) {
                xi0.b(si0Var, oi0Var, 403, false);
                return false;
            }
            ki0 ki0Var = null;
            if (xi0.f(oi0Var.a())) {
                ki0Var = (ki0) r01.b(this.a, oi0Var.a());
            }
            if (xi0.g(oi0Var.c()) && ki0Var != null) {
                oi0Var.f();
                return ki0Var.b(context, oi0Var, map, si0Var);
            }
            return pi0.a().a(context, oi0Var.b(), map, si0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, oi0 oi0Var, @Nullable Map<String, Object> map, @Nullable si0 si0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, oi0Var, map, si0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            mi0 mi0Var = null;
            try {
                for (Map.Entry<String, mi0> entry : this.b.entrySet()) {
                    String a2 = oi0Var.a();
                    if (entry == null || ((mi0Var = entry.getValue()) != null && (a = mi0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (mi0Var != null && mi0Var.c(context, oi0Var, map, si0Var)) {
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
