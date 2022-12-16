package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.eq5;
import com.baidu.tieba.hs5;
import com.baidu.tieba.qp5;
import com.baidu.tieba.rp5;
import com.baidu.tieba.sp5;
import com.baidu.tieba.vp5;
import com.baidu.tieba.wi8;
import com.baidu.tieba.wp5;
import com.baidu.tieba.xn;
import com.baidu.tieba.xp5;
import com.baidu.tieba.yp5;
import com.baidu.tieba.zp5;
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
            eq5 eq5Var;
            wp5 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof eq5) || (c = (eq5Var = (eq5) customResponsedMessage.getData()).c()) == null || !(c instanceof wi8)) {
                return;
            }
            wi8 wi8Var = (wi8) c;
            vp5 T0 = c.T0(1);
            if (T0 == null) {
                yp5 a = zp5.b().a(1);
                if (a == null) {
                    return;
                }
                T0 = a.a();
                c.t0(1, T0);
                T0.f(new xp5(wi8Var), eq5Var.i());
            }
            if (!(T0 instanceof sp5)) {
                return;
            }
            sp5 sp5Var = (sp5) T0;
            if (eq5Var.a() == 1) {
                List list = (List) eq5Var.f();
                qp5.b(sp5Var.d());
                for (BdUniqueId bdUniqueId : qp5.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(wi8Var, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(wi8Var.p());
                    list.add(frsFeedAdAdapter);
                }
            } else if (eq5Var.a() == 2) {
                sp5Var.k(eq5Var.d());
            } else if (eq5Var.a() == 3) {
                List<xn> o = eq5Var.o();
                List<rp5> d = FrsFeedAdStatic.d(o);
                if (eq5Var.q()) {
                    sp5Var.o(d, FrsFeedAdStatic.d(eq5Var.l()), eq5Var.p(), eq5Var.e());
                } else {
                    sp5Var.i(d, eq5Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, eq5Var.i()));
            } else if (eq5Var.a() == 4) {
                sp5Var.a(eq5Var.n());
            } else if (eq5Var.a() == 5) {
                sp5Var.e(FrsFeedAdStatic.d(eq5Var.o()), eq5Var.h(), eq5Var.g(), eq5Var.m(), eq5Var.j(), eq5Var.r(), eq5Var.k());
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

    public static List<xn> c(List<rp5> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (rp5 rp5Var : list) {
                    if (rp5Var.c() == 3) {
                        qp5 qp5Var = new qp5();
                        qp5Var.h(rp5Var.a());
                        qp5Var.i(rp5Var.b());
                        arrayList.add(qp5Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (rp5Var.a() instanceof xn) {
                        arrayList.add((xn) rp5Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<rp5> d(List<xn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (xn xnVar : list) {
                rp5 rp5Var = new rp5();
                if (xnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) xnVar;
                    if (threadData.getIs_top() == 1) {
                        rp5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        rp5Var.f(2);
                    } else {
                        rp5Var.f(4);
                    }
                    rp5Var.d(xnVar);
                } else if (xnVar instanceof qp5) {
                    rp5Var.f(3);
                    qp5 qp5Var = (qp5) xnVar;
                    rp5Var.e(qp5Var.f());
                    rp5Var.d(qp5Var.a());
                } else {
                    rp5Var.f(4);
                    rp5Var.d(xnVar);
                }
                arrayList.add(rp5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (hs5.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    hs5.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && hs5.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                hs5.i().n(list, -1, 2);
            }
        }
    }
}
