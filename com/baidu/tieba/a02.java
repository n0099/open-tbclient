package com.baidu.tieba;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public final class a02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public pi3 a;
    @NonNull
    public ArrayMap<String, az1> b;
    @NonNull
    public ArrayMap<String, List<az1>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947561286, "Lcom/baidu/tieba/a02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947561286, "Lcom/baidu/tieba/a02;");
                return;
            }
        }
        d = vj1.a;
    }

    public a02(@NonNull pi3 pi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pi3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = pi3Var;
        this.b = new ArrayMap<>();
        this.c = new ArrayMap<>();
    }

    @Nullable
    public SwanAppComponentContainerView a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            az1 az1Var = this.b.get(str);
            if (az1Var == null) {
                l02.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return az1Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(az1 az1Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, az1Var)) == null) {
            if (az1Var == null) {
                e02.a("Component-Container", "insert component with a null component");
                return false;
            }
            bz1 n = az1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = az1Var.o();
            SwanAppComponentContainerView m = az1Var.m();
            if (m == null) {
                e02.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                l02.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                e02.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            rt2 rt2Var = n.h;
            if (rt2Var == null) {
                e02.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!rt2Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                e02.a("Component-Container", sb.toString());
                n.h = new rt2();
            }
            if (!zz1.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        l02.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        e02.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = zz1.b(this, n, m);
                if (!b) {
                    e02.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, az1Var);
                if (az1Var.s(2)) {
                    l02.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<az1> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(az1Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        az1 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, az1> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull az1 az1Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull bz1 bz1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, az1Var, swanAppComponentContainerView, bz1Var)) == null) {
            String o = az1Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            rt2 rt2Var = bz1Var.h;
            if (rt2Var != null && rt2Var.h()) {
                if (zz1.c(bz1Var) && !zz1.e(this, bz1Var, swanAppComponentContainerView)) {
                    e02.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = bz1Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, bz1Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    l02.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, bz1Var.b());
                    return true;
                } else {
                    e02.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = bz1Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            e02.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(az1 az1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, az1Var)) == null) {
            boolean z = false;
            if (az1Var == null) {
                e02.a("Component-Container", "remove component with a null component");
                return false;
            }
            bz1 n = az1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = az1Var.o();
            SwanAppComponentContainerView m = az1Var.m();
            if (m == null) {
                e02.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                e02.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!zz1.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            l02.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            e02.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = zz1.g(this, n, m);
                    if (!z) {
                        e02.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || az1Var.s(1)) {
                    this.b.remove(str2);
                    if (az1Var.s(2)) {
                        l02.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<az1> list = this.c.get(str);
                        if (list != null) {
                            list.remove(az1Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(az1 az1Var, @NonNull d02 d02Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, az1Var, d02Var)) == null) {
            if (az1Var == null) {
                e02.a("Component-Container", "update component with a null component");
                return false;
            }
            bz1 n = az1Var.n();
            String o = az1Var.o();
            SwanAppComponentContainerView m = az1Var.m();
            if (m == null) {
                e02.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                l02.c("Component-Container", "don't insert" + o);
            }
            if (az1Var instanceof sz1) {
                if (d02Var.a(7)) {
                    boolean d2 = zz1.d(this, az1Var, n, m, d02Var);
                    if (!d2) {
                        e02.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (d02Var.a(8)) {
                    zz1.f(this, az1Var, n, m, d02Var);
                }
            }
            if (d02Var.a(3) && !d(az1Var, m, n)) {
                l02.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (az1Var instanceof yy1) {
                yy1 yy1Var = (yy1) az1Var;
                if (yy1Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (yy1Var.M()) {
                        return true;
                    }
                    l02.c("Component-Container", o + " perform position update with animation fail");
                    return false;
                }
                return true;
            } else {
                return true;
            }
        }
        return invokeLL.booleanValue;
    }
}
