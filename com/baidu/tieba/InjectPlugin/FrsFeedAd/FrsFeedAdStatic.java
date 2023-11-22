package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.c06;
import com.baidu.tieba.d06;
import com.baidu.tieba.e06;
import com.baidu.tieba.h06;
import com.baidu.tieba.i06;
import com.baidu.tieba.j06;
import com.baidu.tieba.k06;
import com.baidu.tieba.l06;
import com.baidu.tieba.oi;
import com.baidu.tieba.q06;
import com.baidu.tieba.v26;
import com.baidu.tieba.vca;
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
            q06 q06Var;
            i06 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof q06) || (c = (q06Var = (q06) customResponsedMessage.getData()).c()) == null || !(c instanceof vca)) {
                return;
            }
            vca vcaVar = (vca) c;
            h06 H1 = c.H1(1);
            if (H1 == null) {
                k06 a = l06.b().a(1);
                if (a == null) {
                    return;
                }
                H1 = a.a();
                c.Z0(1, H1);
                H1.f(new j06(vcaVar), q06Var.i());
            }
            if (!(H1 instanceof e06)) {
                return;
            }
            e06 e06Var = (e06) H1;
            if (q06Var.a() == 1) {
                List list = (List) q06Var.f();
                c06.b(e06Var.d());
                for (BdUniqueId bdUniqueId : c06.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(vcaVar, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(vcaVar.H());
                    list.add(frsFeedAdAdapter);
                }
            } else if (q06Var.a() == 2) {
                e06Var.k(q06Var.d());
            } else if (q06Var.a() == 3) {
                List<oi> o = q06Var.o();
                List<d06> d = FrsFeedAdStatic.d(o);
                if (q06Var.q()) {
                    e06Var.o(d, FrsFeedAdStatic.d(q06Var.l()), q06Var.p(), q06Var.e());
                } else {
                    e06Var.i(d, q06Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, q06Var.i()));
            } else if (q06Var.a() == 4) {
                e06Var.a(q06Var.n());
            } else if (q06Var.a() == 5) {
                e06Var.e(FrsFeedAdStatic.d(q06Var.o()), q06Var.h(), q06Var.g(), q06Var.m(), q06Var.j(), q06Var.r(), q06Var.k());
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

    public static List<oi> c(List<d06> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (d06 d06Var : list) {
                    if (d06Var.c() == 3) {
                        c06 c06Var = new c06();
                        c06Var.f(d06Var.a());
                        c06Var.g(d06Var.b());
                        arrayList.add(c06Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (d06Var.a() instanceof oi) {
                        arrayList.add((oi) d06Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<d06> d(List<oi> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (oi oiVar : list) {
                d06 d06Var = new d06();
                if (oiVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) oiVar;
                    if (threadData.getIs_top() == 1) {
                        d06Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        d06Var.f(2);
                    } else {
                        d06Var.f(4);
                    }
                    d06Var.d(oiVar);
                } else if (oiVar instanceof c06) {
                    d06Var.f(3);
                    c06 c06Var = (c06) oiVar;
                    d06Var.e(c06Var.d());
                    d06Var.d(c06Var.a());
                } else {
                    d06Var.f(4);
                    d06Var.d(oiVar);
                }
                arrayList.add(d06Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<oi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (v26.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    v26.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && v26.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                v26.i().n(list, -1, 2);
            }
        }
    }
}
