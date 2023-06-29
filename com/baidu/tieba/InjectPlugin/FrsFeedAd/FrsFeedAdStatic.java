package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.a46;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.d46;
import com.baidu.tieba.e46;
import com.baidu.tieba.f46;
import com.baidu.tieba.g46;
import com.baidu.tieba.h46;
import com.baidu.tieba.js9;
import com.baidu.tieba.m46;
import com.baidu.tieba.r66;
import com.baidu.tieba.xn;
import com.baidu.tieba.y36;
import com.baidu.tieba.z36;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsFeedAdStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super(2016515);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m46 m46Var;
            e46 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof m46) || (c = (m46Var = (m46) customResponsedMessage.getData()).c()) == null || !(c instanceof js9)) {
                return;
            }
            js9 js9Var = (js9) c;
            d46 d1 = c.d1(1);
            if (d1 == null) {
                g46 a = h46.b().a(1);
                if (a == null) {
                    return;
                }
                d1 = a.a();
                c.A0(1, d1);
                d1.f(new f46(js9Var), m46Var.i());
            }
            if (!(d1 instanceof a46)) {
                return;
            }
            a46 a46Var = (a46) d1;
            if (m46Var.a() == 1) {
                List list = (List) m46Var.f();
                y36.b(a46Var.d());
                for (BdUniqueId bdUniqueId : y36.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(js9Var, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(js9Var.t());
                    list.add(frsFeedAdAdapter);
                }
            } else if (m46Var.a() == 2) {
                a46Var.k(m46Var.d());
            } else if (m46Var.a() == 3) {
                List<xn> o = m46Var.o();
                List<z36> d = FrsFeedAdStatic.d(o);
                if (m46Var.q()) {
                    a46Var.o(d, FrsFeedAdStatic.d(m46Var.l()), m46Var.p(), m46Var.e());
                } else {
                    a46Var.i(d, m46Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, m46Var.i()));
            } else if (m46Var.a() == 4) {
                a46Var.a(m46Var.n());
            } else if (m46Var.a() == 5) {
                a46Var.e(FrsFeedAdStatic.d(m46Var.o()), m46Var.h(), m46Var.g(), m46Var.m(), m46Var.j(), m46Var.r(), m46Var.k());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1910716457, "Lcom/baidu/tieba/InjectPlugin/FrsFeedAd/FrsFeedAdStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1910716457, "Lcom/baidu/tieba/InjectPlugin/FrsFeedAd/FrsFeedAdStatic;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new a());
    }

    public FrsFeedAdStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static List<xn> c(List<z36> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (z36 z36Var : list) {
                    if (z36Var.c() == 3) {
                        y36 y36Var = new y36();
                        y36Var.f(z36Var.a());
                        y36Var.h(z36Var.b());
                        arrayList.add(y36Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (z36Var.a() instanceof xn) {
                        arrayList.add((xn) z36Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<z36> d(List<xn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (xn xnVar : list) {
                z36 z36Var = new z36();
                if (xnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) xnVar;
                    if (threadData.getIs_top() == 1) {
                        z36Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        z36Var.f(2);
                    } else {
                        z36Var.f(4);
                    }
                    z36Var.d(xnVar);
                } else if (xnVar instanceof y36) {
                    z36Var.f(3);
                    y36 y36Var = (y36) xnVar;
                    z36Var.e(y36Var.d());
                    z36Var.d(y36Var.a());
                } else {
                    z36Var.f(4);
                    z36Var.d(xnVar);
                }
                arrayList.add(z36Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (r66.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    r66.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && r66.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                r66.i().n(list, -1, 2);
            }
        }
    }
}
