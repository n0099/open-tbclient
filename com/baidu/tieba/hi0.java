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
public class hi0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<ji0> d;
    public static final List<li0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, ji0> a;
    public final Map<String, li0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947824538, "Lcom/baidu/tieba/hi0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947824538, "Lcom/baidu/tieba/hi0;");
                return;
            }
        }
        si0 si0Var = new si0();
        d = si0Var.a.getList();
        e = si0Var.b.getList();
    }

    public hi0() {
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
        synchronized (hi0.class) {
            if (d != null && this.a.isEmpty()) {
                for (ji0 ji0Var : d) {
                    if (ji0Var != null) {
                        if (yz0.b(this.a, ji0Var.a()) == null) {
                            yz0.e(this.a, ji0Var.a(), ji0Var);
                        }
                        if (!TextUtils.isEmpty(ji0Var.a())) {
                            wz0.b(this.c, ji0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (li0 li0Var : e) {
                    this.b.put(li0Var.b(), li0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull ni0 ni0Var, @Nullable Map<String, Object> map, @Nullable ri0 ri0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, ni0Var, map, ri0Var)) == null) {
            if (b(context, ni0Var, map, ri0Var)) {
                wi0.b(ri0Var, ni0Var, 403, false);
                return false;
            }
            ji0 ji0Var = wi0.f(ni0Var.a()) ? (ji0) yz0.b(this.a, ni0Var.a()) : null;
            if (wi0.g(ni0Var.c()) && ji0Var != null) {
                ni0Var.f();
                return ji0Var.b(context, ni0Var, map, ri0Var);
            }
            return oi0.a().a(context, ni0Var.b(), map, ri0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, ni0 ni0Var, @Nullable Map<String, Object> map, @Nullable ri0 ri0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ni0Var, map, ri0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            li0 li0Var = null;
            try {
                for (Map.Entry<String, li0> entry : this.b.entrySet()) {
                    String a2 = ni0Var.a();
                    if (entry == null || ((li0Var = entry.getValue()) != null && (a = li0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (li0Var != null && li0Var.c(context, ni0Var, map, ri0Var)) {
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
