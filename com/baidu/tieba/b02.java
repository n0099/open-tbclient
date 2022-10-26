package com.baidu.tieba;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
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
public final class b02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public qi3 a;
    public ArrayMap b;
    public ArrayMap c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947591077, "Lcom/baidu/tieba/b02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947591077, "Lcom/baidu/tieba/b02;");
                return;
            }
        }
        d = wj1.a;
    }

    public b02(qi3 qi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qi3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = qi3Var;
        this.b = new ArrayMap();
        this.c = new ArrayMap();
    }

    public SwanAppComponentContainerView a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            bz1 bz1Var = (bz1) this.b.get(str);
            if (bz1Var == null) {
                m02.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return bz1Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    public boolean b(bz1 bz1Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bz1Var)) == null) {
            if (bz1Var == null) {
                f02.a("Component-Container", "insert component with a null component");
                return false;
            }
            cz1 n = bz1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = bz1Var.o();
            SwanAppComponentContainerView m = bz1Var.m();
            if (m == null) {
                f02.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                m02.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                f02.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            st2 st2Var = n.h;
            if (st2Var == null) {
                f02.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!st2Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                f02.a("Component-Container", sb.toString());
                n.h = new st2();
            }
            if (!a02.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        m02.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        f02.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = a02.b(this, n, m);
                if (!b) {
                    f02.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, bz1Var);
                if (bz1Var.s(2)) {
                    m02.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List list = (List) this.c.get(str);
                    if (list == null) {
                        list = new ArrayList();
                        this.c.put(str, list);
                    }
                    list.add(bz1Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        bz1 bz1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry entry : this.b.entrySet()) {
                if (entry != null && (bz1Var = (bz1) entry.getValue()) != null) {
                    bz1Var.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(bz1 bz1Var, SwanAppComponentContainerView swanAppComponentContainerView, cz1 cz1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, bz1Var, swanAppComponentContainerView, cz1Var)) == null) {
            String o = bz1Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            st2 st2Var = cz1Var.h;
            if (st2Var != null && st2Var.h()) {
                if (a02.c(cz1Var) && !a02.e(this, cz1Var, swanAppComponentContainerView)) {
                    f02.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = cz1Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, cz1Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    m02.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, cz1Var.b());
                    return true;
                } else {
                    f02.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = cz1Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            f02.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public boolean e(bz1 bz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bz1Var)) == null) {
            boolean z = false;
            if (bz1Var == null) {
                f02.a("Component-Container", "remove component with a null component");
                return false;
            }
            cz1 n = bz1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = bz1Var.o();
            SwanAppComponentContainerView m = bz1Var.m();
            if (m == null) {
                f02.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                f02.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!a02.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            m02.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            f02.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = a02.g(this, n, m);
                    if (!z) {
                        f02.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || bz1Var.s(1)) {
                    this.b.remove(str2);
                    if (bz1Var.s(2)) {
                        m02.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List list = (List) this.c.get(str);
                        if (list != null) {
                            list.remove(bz1Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean f(bz1 bz1Var, e02 e02Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bz1Var, e02Var)) == null) {
            if (bz1Var == null) {
                f02.a("Component-Container", "update component with a null component");
                return false;
            }
            cz1 n = bz1Var.n();
            String o = bz1Var.o();
            SwanAppComponentContainerView m = bz1Var.m();
            if (m == null) {
                f02.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                m02.c("Component-Container", "don't insert" + o);
            }
            if (bz1Var instanceof tz1) {
                if (e02Var.a(7)) {
                    boolean d2 = a02.d(this, bz1Var, n, m, e02Var);
                    if (!d2) {
                        f02.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (e02Var.a(8)) {
                    a02.f(this, bz1Var, n, m, e02Var);
                }
            }
            if (e02Var.a(3) && !d(bz1Var, m, n)) {
                m02.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (bz1Var instanceof zy1) {
                zy1 zy1Var = (zy1) bz1Var;
                if (zy1Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (!zy1Var.M()) {
                        m02.c("Component-Container", o + " perform position update with animation fail");
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
