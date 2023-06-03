package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.a46;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.am9;
import com.baidu.tieba.f66;
import com.baidu.tieba.m36;
import com.baidu.tieba.n36;
import com.baidu.tieba.o36;
import com.baidu.tieba.r36;
import com.baidu.tieba.s36;
import com.baidu.tieba.t36;
import com.baidu.tieba.u36;
import com.baidu.tieba.v36;
import com.baidu.tieba.vn;
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
            a46 a46Var;
            s36 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof a46) || (c = (a46Var = (a46) customResponsedMessage.getData()).c()) == null || !(c instanceof am9)) {
                return;
            }
            am9 am9Var = (am9) c;
            r36 d1 = c.d1(1);
            if (d1 == null) {
                u36 a = v36.b().a(1);
                if (a == null) {
                    return;
                }
                d1 = a.a();
                c.A0(1, d1);
                d1.f(new t36(am9Var), a46Var.i());
            }
            if (!(d1 instanceof o36)) {
                return;
            }
            o36 o36Var = (o36) d1;
            if (a46Var.a() == 1) {
                List list = (List) a46Var.f();
                m36.b(o36Var.d());
                for (BdUniqueId bdUniqueId : m36.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(am9Var, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(am9Var.t());
                    list.add(frsFeedAdAdapter);
                }
            } else if (a46Var.a() == 2) {
                o36Var.k(a46Var.d());
            } else if (a46Var.a() == 3) {
                List<vn> o = a46Var.o();
                List<n36> d = FrsFeedAdStatic.d(o);
                if (a46Var.q()) {
                    o36Var.o(d, FrsFeedAdStatic.d(a46Var.l()), a46Var.p(), a46Var.e());
                } else {
                    o36Var.i(d, a46Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, a46Var.i()));
            } else if (a46Var.a() == 4) {
                o36Var.a(a46Var.n());
            } else if (a46Var.a() == 5) {
                o36Var.e(FrsFeedAdStatic.d(a46Var.o()), a46Var.h(), a46Var.g(), a46Var.m(), a46Var.j(), a46Var.r(), a46Var.k());
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

    public static List<vn> c(List<n36> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (n36 n36Var : list) {
                    if (n36Var.c() == 3) {
                        m36 m36Var = new m36();
                        m36Var.f(n36Var.a());
                        m36Var.h(n36Var.b());
                        arrayList.add(m36Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (n36Var.a() instanceof vn) {
                        arrayList.add((vn) n36Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<n36> d(List<vn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (vn vnVar : list) {
                n36 n36Var = new n36();
                if (vnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) vnVar;
                    if (threadData.getIs_top() == 1) {
                        n36Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        n36Var.f(2);
                    } else {
                        n36Var.f(4);
                    }
                    n36Var.d(vnVar);
                } else if (vnVar instanceof m36) {
                    n36Var.f(3);
                    m36 m36Var = (m36) vnVar;
                    n36Var.e(m36Var.d());
                    n36Var.d(m36Var.a());
                } else {
                    n36Var.f(4);
                    n36Var.d(vnVar);
                }
                arrayList.add(n36Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<vn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (f66.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    f66.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && f66.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                f66.i().n(list, -1, 2);
            }
        }
    }
}
