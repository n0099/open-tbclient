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
/* loaded from: classes5.dex */
public final class e22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public tk3 a;
    @NonNull
    public ArrayMap<String, f12> b;
    @NonNull
    public ArrayMap<String, List<f12>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947682372, "Lcom/baidu/tieba/e22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947682372, "Lcom/baidu/tieba/e22;");
                return;
            }
        }
        d = am1.a;
    }

    public e22(@NonNull tk3 tk3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tk3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tk3Var;
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
            f12 f12Var = this.b.get(str);
            if (f12Var == null) {
                p22.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return f12Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(f12 f12Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f12Var)) == null) {
            if (f12Var == null) {
                i22.a("Component-Container", "insert component with a null component");
                return false;
            }
            g12 n = f12Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = f12Var.o();
            SwanAppComponentContainerView m = f12Var.m();
            if (m == null) {
                i22.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                p22.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                i22.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            vv2 vv2Var = n.h;
            if (vv2Var == null) {
                i22.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!vv2Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                i22.a("Component-Container", sb.toString());
                n.h = new vv2();
            }
            if (!d22.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        p22.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        i22.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = d22.b(this, n, m);
                if (!b) {
                    i22.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, f12Var);
                if (f12Var.s(2)) {
                    p22.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<f12> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(f12Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        f12 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, f12> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.z();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull f12 f12Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull g12 g12Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, f12Var, swanAppComponentContainerView, g12Var)) == null) {
            String o = f12Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            vv2 vv2Var = g12Var.h;
            if (vv2Var != null && vv2Var.h()) {
                if (d22.c(g12Var) && !d22.e(this, g12Var, swanAppComponentContainerView)) {
                    i22.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = g12Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, g12Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    p22.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, g12Var.b());
                    return true;
                } else {
                    i22.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = g12Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            i22.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(f12 f12Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, f12Var)) == null) {
            boolean z = false;
            if (f12Var == null) {
                i22.a("Component-Container", "remove component with a null component");
                return false;
            }
            g12 n = f12Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = f12Var.o();
            SwanAppComponentContainerView m = f12Var.m();
            if (m == null) {
                i22.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                i22.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!d22.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            p22.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            i22.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = d22.g(this, n, m);
                    if (!z) {
                        i22.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || f12Var.s(1)) {
                    this.b.remove(str2);
                    if (f12Var.s(2)) {
                        p22.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<f12> list = this.c.get(str);
                        if (list != null) {
                            list.remove(f12Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(f12 f12Var, @NonNull h22 h22Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, f12Var, h22Var)) == null) {
            if (f12Var == null) {
                i22.a("Component-Container", "update component with a null component");
                return false;
            }
            g12 n = f12Var.n();
            String o = f12Var.o();
            SwanAppComponentContainerView m = f12Var.m();
            if (m == null) {
                i22.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                p22.c("Component-Container", "don't insert" + o);
            }
            if (f12Var instanceof w12) {
                if (h22Var.a(7)) {
                    boolean d2 = d22.d(this, f12Var, n, m, h22Var);
                    if (!d2) {
                        i22.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (h22Var.a(8)) {
                    d22.f(this, f12Var, n, m, h22Var);
                }
            }
            if (h22Var.a(3) && !d(f12Var, m, n)) {
                p22.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (f12Var instanceof d12) {
                d12 d12Var = (d12) f12Var;
                if (d12Var.L()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (!d12Var.O()) {
                        p22.c("Component-Container", o + " perform position update with animation fail");
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
