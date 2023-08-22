package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.b36;
import com.baidu.tieba.bn;
import com.baidu.tieba.c36;
import com.baidu.tieba.d36;
import com.baidu.tieba.g36;
import com.baidu.tieba.h36;
import com.baidu.tieba.i36;
import com.baidu.tieba.j36;
import com.baidu.tieba.k36;
import com.baidu.tieba.n1a;
import com.baidu.tieba.p36;
import com.baidu.tieba.u56;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class FrsFeedAdStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
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
            p36 p36Var;
            h36 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof p36) || (c = (p36Var = (p36) customResponsedMessage.getData()).c()) == null || !(c instanceof n1a)) {
                return;
            }
            n1a n1aVar = (n1a) c;
            g36 n1 = c.n1(1);
            if (n1 == null) {
                j36 a = k36.b().a(1);
                if (a == null) {
                    return;
                }
                n1 = a.a();
                c.I0(1, n1);
                n1.f(new i36(n1aVar), p36Var.i());
            }
            if (!(n1 instanceof d36)) {
                return;
            }
            d36 d36Var = (d36) n1;
            if (p36Var.a() == 1) {
                List list = (List) p36Var.f();
                b36.b(d36Var.d());
                for (BdUniqueId bdUniqueId : b36.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(n1aVar, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(n1aVar.u());
                    list.add(frsFeedAdAdapter);
                }
            } else if (p36Var.a() == 2) {
                d36Var.k(p36Var.d());
            } else if (p36Var.a() == 3) {
                List<bn> o = p36Var.o();
                List<c36> d = FrsFeedAdStatic.d(o);
                if (p36Var.q()) {
                    d36Var.o(d, FrsFeedAdStatic.d(p36Var.l()), p36Var.p(), p36Var.e());
                } else {
                    d36Var.i(d, p36Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, p36Var.i()));
            } else if (p36Var.a() == 4) {
                d36Var.a(p36Var.n());
            } else if (p36Var.a() == 5) {
                d36Var.e(FrsFeedAdStatic.d(p36Var.o()), p36Var.h(), p36Var.g(), p36Var.m(), p36Var.j(), p36Var.r(), p36Var.k());
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

    public static List<bn> c(List<c36> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (c36 c36Var : list) {
                    if (c36Var.c() == 3) {
                        b36 b36Var = new b36();
                        b36Var.f(c36Var.a());
                        b36Var.g(c36Var.b());
                        arrayList.add(b36Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (c36Var.a() instanceof bn) {
                        arrayList.add((bn) c36Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<c36> d(List<bn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (bn bnVar : list) {
                c36 c36Var = new c36();
                if (bnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) bnVar;
                    if (threadData.getIs_top() == 1) {
                        c36Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        c36Var.f(2);
                    } else {
                        c36Var.f(4);
                    }
                    c36Var.d(bnVar);
                } else if (bnVar instanceof b36) {
                    c36Var.f(3);
                    b36 b36Var = (b36) bnVar;
                    c36Var.e(b36Var.d());
                    c36Var.d(b36Var.a());
                } else {
                    c36Var.f(4);
                    c36Var.d(bnVar);
                }
                arrayList.add(c36Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<bn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (u56.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    u56.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && u56.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                u56.i().n(list, -1, 2);
            }
        }
    }
}
