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
import com.baidu.tieba.dp5;
import com.baidu.tieba.eg8;
import com.baidu.tieba.ep5;
import com.baidu.tieba.jp5;
import com.baidu.tieba.mr5;
import com.baidu.tieba.vo5;
import com.baidu.tieba.wo5;
import com.baidu.tieba.xn;
import com.baidu.tieba.xo5;
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
            jp5 jp5Var;
            bp5 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof jp5) || (c = (jp5Var = (jp5) customResponsedMessage.getData()).c()) == null || !(c instanceof eg8)) {
                return;
            }
            eg8 eg8Var = (eg8) c;
            ap5 P0 = c.P0(1);
            if (P0 == null) {
                dp5 a = ep5.b().a(1);
                if (a == null) {
                    return;
                }
                P0 = a.a();
                c.o0(1, P0);
                P0.f(new cp5(eg8Var), jp5Var.i());
            }
            if (!(P0 instanceof xo5)) {
                return;
            }
            xo5 xo5Var = (xo5) P0;
            if (jp5Var.a() == 1) {
                List list = (List) jp5Var.f();
                vo5.b(xo5Var.d());
                for (BdUniqueId bdUniqueId : vo5.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(eg8Var, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(eg8Var.o());
                    list.add(frsFeedAdAdapter);
                }
            } else if (jp5Var.a() == 2) {
                xo5Var.k(jp5Var.d());
            } else if (jp5Var.a() == 3) {
                List<xn> o = jp5Var.o();
                List<wo5> d = FrsFeedAdStatic.d(o);
                if (jp5Var.q()) {
                    xo5Var.o(d, FrsFeedAdStatic.d(jp5Var.l()), jp5Var.p(), jp5Var.e());
                } else {
                    xo5Var.i(d, jp5Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, jp5Var.i()));
            } else if (jp5Var.a() == 4) {
                xo5Var.a(jp5Var.n());
            } else if (jp5Var.a() == 5) {
                xo5Var.e(FrsFeedAdStatic.d(jp5Var.o()), jp5Var.h(), jp5Var.g(), jp5Var.m(), jp5Var.j(), jp5Var.r(), jp5Var.k());
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

    public static List<xn> c(List<wo5> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (wo5 wo5Var : list) {
                    if (wo5Var.c() == 3) {
                        vo5 vo5Var = new vo5();
                        vo5Var.h(wo5Var.a());
                        vo5Var.j(wo5Var.b());
                        arrayList.add(vo5Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (wo5Var.a() instanceof xn) {
                        arrayList.add((xn) wo5Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<wo5> d(List<xn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (xn xnVar : list) {
                wo5 wo5Var = new wo5();
                if (xnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) xnVar;
                    if (threadData.getIs_top() == 1) {
                        wo5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        wo5Var.f(2);
                    } else {
                        wo5Var.f(4);
                    }
                    wo5Var.d(xnVar);
                } else if (xnVar instanceof vo5) {
                    wo5Var.f(3);
                    vo5 vo5Var = (vo5) xnVar;
                    wo5Var.e(vo5Var.f());
                    wo5Var.d(vo5Var.a());
                } else {
                    wo5Var.f(4);
                    wo5Var.d(xnVar);
                }
                arrayList.add(wo5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (mr5.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    mr5.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && mr5.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                mr5.i().n(list, -1, 2);
            }
        }
    }
}
