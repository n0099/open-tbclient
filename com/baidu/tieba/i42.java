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
/* loaded from: classes4.dex */
public final class i42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public xm3 a;
    @NonNull
    public ArrayMap<String, i32> b;
    @NonNull
    public ArrayMap<String, List<i32>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947803458, "Lcom/baidu/tieba/i42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947803458, "Lcom/baidu/tieba/i42;");
                return;
            }
        }
        d = do1.a;
    }

    public i42(@NonNull xm3 xm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xm3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = xm3Var;
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
            i32 i32Var = this.b.get(str);
            if (i32Var == null) {
                t42.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return i32Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(i32 i32Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i32Var)) == null) {
            if (i32Var == null) {
                m42.a("Component-Container", "insert component with a null component");
                return false;
            }
            j32 n = i32Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = i32Var.o();
            SwanAppComponentContainerView m = i32Var.m();
            if (m == null) {
                m42.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                t42.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                m42.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            zx2 zx2Var = n.h;
            if (zx2Var == null) {
                m42.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!zx2Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                m42.a("Component-Container", sb.toString());
                n.h = new zx2();
            }
            if (!h42.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        t42.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        m42.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = h42.b(this, n, m);
                if (!b) {
                    m42.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, i32Var);
                if (i32Var.s(2)) {
                    t42.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<i32> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(i32Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        i32 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, i32> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull i32 i32Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull j32 j32Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, i32Var, swanAppComponentContainerView, j32Var)) == null) {
            String o = i32Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            zx2 zx2Var = j32Var.h;
            if (zx2Var != null && zx2Var.h()) {
                if (h42.c(j32Var) && !h42.e(this, j32Var, swanAppComponentContainerView)) {
                    m42.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = j32Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, j32Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    t42.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, j32Var.b());
                    return true;
                } else {
                    m42.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = j32Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            m42.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(i32 i32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, i32Var)) == null) {
            boolean z = false;
            if (i32Var == null) {
                m42.a("Component-Container", "remove component with a null component");
                return false;
            }
            j32 n = i32Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = i32Var.o();
            SwanAppComponentContainerView m = i32Var.m();
            if (m == null) {
                m42.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                m42.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!h42.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            t42.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            m42.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = h42.g(this, n, m);
                    if (!z) {
                        m42.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || i32Var.s(1)) {
                    this.b.remove(str2);
                    if (i32Var.s(2)) {
                        t42.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<i32> list = this.c.get(str);
                        if (list != null) {
                            list.remove(i32Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(i32 i32Var, @NonNull l42 l42Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, i32Var, l42Var)) == null) {
            if (i32Var == null) {
                m42.a("Component-Container", "update component with a null component");
                return false;
            }
            j32 n = i32Var.n();
            String o = i32Var.o();
            SwanAppComponentContainerView m = i32Var.m();
            if (m == null) {
                m42.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                t42.c("Component-Container", "don't insert" + o);
            }
            if (i32Var instanceof a42) {
                if (l42Var.a(7)) {
                    boolean d2 = h42.d(this, i32Var, n, m, l42Var);
                    if (!d2) {
                        m42.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (l42Var.a(8)) {
                    h42.f(this, i32Var, n, m, l42Var);
                }
            }
            if (l42Var.a(3) && !d(i32Var, m, n)) {
                t42.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (i32Var instanceof g32) {
                g32 g32Var = (g32) i32Var;
                if (g32Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (!g32Var.M()) {
                        t42.c("Component-Container", o + " perform position update with animation fail");
                        return false;
                    }
                    return true;
                }
                return true;
            } else {
                return true;
            }
        }
        return invokeLL.booleanValue;
    }
}
