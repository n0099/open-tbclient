package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes3.dex */
public class di4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile di4 m;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public final HashSet<String> b;
    public final HashSet<String> c;
    public final HashSet<String> d;
    public final HashSet<String> e;
    public final HashMap<String, String> f;
    public final HashMap<String, String> g;
    public final HashMap<String, hi4> h;
    public final HashSet<String> i;
    public int j;
    public int k;
    public int l;

    public di4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new HashSet<>();
        this.c = new HashSet<>();
        this.d = new HashSet<>();
        this.e = new HashSet<>();
        this.f = new HashMap<>();
        this.g = new HashMap<>();
        this.h = new HashMap<>();
        this.i = new HashSet<>();
    }

    public static di4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (m == null) {
                synchronized (di4.class) {
                    if (m == null) {
                        m = new di4();
                    }
                }
            }
            return m;
        }
        return (di4) invokeV.objValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.d.contains(str) : invokeL.booleanValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (ei4.g().r()) {
                return true;
            }
            return this.c.contains(str);
        }
        return invokeL.booleanValue;
    }

    public boolean c(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i)) == null) {
            if (this.b.contains(str)) {
                return false;
            }
            if ((i & 16) == 0 && (i & 32) == 0) {
                return true;
            }
            return this.e.contains(str);
        }
        return invokeLI.booleanValue;
    }

    public String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.g.containsKey(str) ? this.g.get(str) : "" : (String) invokeL.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : invokeV.intValue;
    }

    public int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (ei4.g().q() || TextUtils.isEmpty(str) || !this.f.containsKey(str)) {
                return 0;
            }
            return Integer.parseInt(this.f.get(str));
        }
        return invokeL.intValue;
    }

    public String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? (TextUtils.isEmpty(str) || !this.i.contains(str)) ? "0" : "1" : (String) invokeL.objValue;
    }

    public void k(ci4 ci4Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, ci4Var, context) == null) {
            this.a = context;
            this.j = 360000;
            ti4 f = ti4.f();
            this.k = f.getInt("ubc_data_expire_time", 259200000);
            this.l = f.getInt("ubc_database_limit", 4000);
            ci4Var.e().w(this.b, this.e, this.c, this.d, this.f, this.g, this.h, this.i);
        }
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            hi4 hi4Var = this.h.get(str);
            return hi4Var != null && hi4Var.b();
        }
        return invokeL.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            hi4 hi4Var = this.h.get(str);
            return hi4Var != null && hi4Var.c();
        }
        return invokeL.booleanValue;
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || i < this.k) {
            return;
        }
        this.k = i;
        ti4.f().putInt("ubc_data_expire_time", i);
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || i < this.l) {
            return;
        }
        this.l = i;
        ti4.f().putInt("ubc_database_limit", i);
    }

    public void p(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i) == null) || (i2 = i * 60000) < this.j) {
            return;
        }
        this.j = i2;
    }

    public void q(List<gi4> list) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            for (gi4 gi4Var : list) {
                if ("0".equals(gi4Var.b)) {
                    this.b.add(gi4Var.a);
                } else {
                    this.b.remove(gi4Var.a);
                }
                if ("1".equals(gi4Var.c)) {
                    this.c.add(gi4Var.a);
                } else {
                    this.c.remove(gi4Var.a);
                }
                if ("1".equals(gi4Var.f)) {
                    this.d.add(gi4Var.a);
                } else {
                    this.d.remove(gi4Var.a);
                }
                int i2 = gi4Var.g;
                if (i2 >= 1 && i2 <= 100) {
                    this.f.put(gi4Var.a, String.valueOf(i2));
                } else {
                    this.f.remove(gi4Var.a);
                }
                if (!TextUtils.isEmpty(gi4Var.h)) {
                    this.g.put(gi4Var.a, gi4Var.h);
                } else {
                    this.g.remove(gi4Var.a);
                }
                int i3 = gi4Var.j;
                if (i3 != 0 && (i = gi4Var.i) != 0) {
                    hi4 hi4Var = new hi4(gi4Var.a, i3, i);
                    this.h.put(hi4Var.a(), hi4Var);
                }
                if (TextUtils.equals(gi4Var.k, "1")) {
                    this.i.add(gi4Var.a);
                } else {
                    this.i.remove(gi4Var.a);
                }
            }
        }
    }
}
