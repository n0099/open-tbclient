package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.ap5;
import com.baidu.tieba.bp5;
import com.baidu.tieba.cp5;
import com.baidu.tieba.dg8;
import com.baidu.tieba.dp5;
import com.baidu.tieba.ip5;
import com.baidu.tieba.lr5;
import com.baidu.tieba.uo5;
import com.baidu.tieba.vo5;
import com.baidu.tieba.wo5;
import com.baidu.tieba.xn;
import com.baidu.tieba.zo5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsFeedAdStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
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
            ip5 ip5Var;
            ap5 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof ip5) || (c = (ip5Var = (ip5) customResponsedMessage.getData()).c()) == null || !(c instanceof dg8)) {
                return;
            }
            dg8 dg8Var = (dg8) c;
            zo5 P0 = c.P0(1);
            if (P0 == null) {
                cp5 a = dp5.b().a(1);
                if (a == null) {
                    return;
                }
                P0 = a.a();
                c.o0(1, P0);
                P0.f(new bp5(dg8Var), ip5Var.i());
            }
            if (!(P0 instanceof wo5)) {
                return;
            }
            wo5 wo5Var = (wo5) P0;
            if (ip5Var.a() == 1) {
                List list = (List) ip5Var.f();
                uo5.b(wo5Var.d());
                for (BdUniqueId bdUniqueId : uo5.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(dg8Var, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(dg8Var.o());
                    list.add(frsFeedAdAdapter);
                }
            } else if (ip5Var.a() == 2) {
                wo5Var.k(ip5Var.d());
            } else if (ip5Var.a() == 3) {
                List<xn> o = ip5Var.o();
                List<vo5> d = FrsFeedAdStatic.d(o);
                if (ip5Var.q()) {
                    wo5Var.o(d, FrsFeedAdStatic.d(ip5Var.l()), ip5Var.p(), ip5Var.e());
                } else {
                    wo5Var.i(d, ip5Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, ip5Var.i()));
            } else if (ip5Var.a() == 4) {
                wo5Var.a(ip5Var.n());
            } else if (ip5Var.a() == 5) {
                wo5Var.e(FrsFeedAdStatic.d(ip5Var.o()), ip5Var.h(), ip5Var.g(), ip5Var.m(), ip5Var.j(), ip5Var.r(), ip5Var.k());
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

    public static List<xn> c(List<vo5> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (vo5 vo5Var : list) {
                    if (vo5Var.c() == 3) {
                        uo5 uo5Var = new uo5();
                        uo5Var.h(vo5Var.a());
                        uo5Var.j(vo5Var.b());
                        arrayList.add(uo5Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (vo5Var.a() instanceof xn) {
                        arrayList.add((xn) vo5Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<vo5> d(List<xn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (xn xnVar : list) {
                vo5 vo5Var = new vo5();
                if (xnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) xnVar;
                    if (threadData.getIs_top() == 1) {
                        vo5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        vo5Var.f(2);
                    } else {
                        vo5Var.f(4);
                    }
                    vo5Var.d(xnVar);
                } else if (xnVar instanceof uo5) {
                    vo5Var.f(3);
                    uo5 uo5Var = (uo5) xnVar;
                    vo5Var.e(uo5Var.f());
                    vo5Var.d(uo5Var.a());
                } else {
                    vo5Var.f(4);
                    vo5Var.d(xnVar);
                }
                arrayList.add(vo5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (lr5.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    lr5.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && lr5.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                lr5.i().n(list, -1, 2);
            }
        }
    }
}
