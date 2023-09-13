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
public class bj0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<dj0> d;
    public static final List<fj0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, dj0> a;
    public final Map<String, fj0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947646753, "Lcom/baidu/tieba/bj0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947646753, "Lcom/baidu/tieba/bj0;");
                return;
            }
        }
        mj0 mj0Var = new mj0();
        d = mj0Var.a.getList();
        e = mj0Var.b.getList();
    }

    public bj0() {
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
        synchronized (bj0.class) {
            if (d != null && this.a.isEmpty()) {
                for (dj0 dj0Var : d) {
                    if (dj0Var != null) {
                        if (j31.b(this.a, dj0Var.a()) == null) {
                            j31.e(this.a, dj0Var.a(), dj0Var);
                        }
                        if (!TextUtils.isEmpty(dj0Var.a())) {
                            h31.b(this.c, dj0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (fj0 fj0Var : e) {
                    this.b.put(fj0Var.b(), fj0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull hj0 hj0Var, @Nullable Map<String, Object> map, @Nullable lj0 lj0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, hj0Var, map, lj0Var)) == null) {
            if (b(context, hj0Var, map, lj0Var)) {
                qj0.b(lj0Var, hj0Var, 0, true);
                return true;
            }
            dj0 dj0Var = null;
            if (qj0.f(hj0Var.a())) {
                dj0Var = (dj0) j31.b(this.a, hj0Var.a());
            }
            if (qj0.g(hj0Var.c()) && dj0Var != null) {
                hj0Var.f();
                return dj0Var.b(context, hj0Var, map, lj0Var);
            }
            return ij0.a().a(context, hj0Var.b(), map, lj0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, hj0 hj0Var, @Nullable Map<String, Object> map, @Nullable lj0 lj0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hj0Var, map, lj0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            fj0 fj0Var = null;
            try {
                for (Map.Entry<String, fj0> entry : this.b.entrySet()) {
                    String a2 = hj0Var.a();
                    if (entry == null || ((fj0Var = entry.getValue()) != null && (a = fj0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (fj0Var != null && fj0Var.d(context, hj0Var, map, lj0Var)) {
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
