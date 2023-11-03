package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.b06;
import com.baidu.tieba.c06;
import com.baidu.tieba.d06;
import com.baidu.tieba.g06;
import com.baidu.tieba.h06;
import com.baidu.tieba.i06;
import com.baidu.tieba.j06;
import com.baidu.tieba.k06;
import com.baidu.tieba.oi;
import com.baidu.tieba.p06;
import com.baidu.tieba.u26;
import com.baidu.tieba.uca;
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
            p06 p06Var;
            h06 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof p06) || (c = (p06Var = (p06) customResponsedMessage.getData()).c()) == null || !(c instanceof uca)) {
                return;
            }
            uca ucaVar = (uca) c;
            g06 H1 = c.H1(1);
            if (H1 == null) {
                j06 a = k06.b().a(1);
                if (a == null) {
                    return;
                }
                H1 = a.a();
                c.Z0(1, H1);
                H1.f(new i06(ucaVar), p06Var.i());
            }
            if (!(H1 instanceof d06)) {
                return;
            }
            d06 d06Var = (d06) H1;
            if (p06Var.a() == 1) {
                List list = (List) p06Var.f();
                b06.b(d06Var.d());
                for (BdUniqueId bdUniqueId : b06.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(ucaVar, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(ucaVar.H());
                    list.add(frsFeedAdAdapter);
                }
            } else if (p06Var.a() == 2) {
                d06Var.k(p06Var.d());
            } else if (p06Var.a() == 3) {
                List<oi> o = p06Var.o();
                List<c06> d = FrsFeedAdStatic.d(o);
                if (p06Var.q()) {
                    d06Var.o(d, FrsFeedAdStatic.d(p06Var.l()), p06Var.p(), p06Var.e());
                } else {
                    d06Var.i(d, p06Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, p06Var.i()));
            } else if (p06Var.a() == 4) {
                d06Var.a(p06Var.n());
            } else if (p06Var.a() == 5) {
                d06Var.e(FrsFeedAdStatic.d(p06Var.o()), p06Var.h(), p06Var.g(), p06Var.m(), p06Var.j(), p06Var.r(), p06Var.k());
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

    public static List<oi> c(List<c06> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (c06 c06Var : list) {
                    if (c06Var.c() == 3) {
                        b06 b06Var = new b06();
                        b06Var.f(c06Var.a());
                        b06Var.g(c06Var.b());
                        arrayList.add(b06Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (c06Var.a() instanceof oi) {
                        arrayList.add((oi) c06Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<c06> d(List<oi> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (oi oiVar : list) {
                c06 c06Var = new c06();
                if (oiVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) oiVar;
                    if (threadData.getIs_top() == 1) {
                        c06Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        c06Var.f(2);
                    } else {
                        c06Var.f(4);
                    }
                    c06Var.d(oiVar);
                } else if (oiVar instanceof b06) {
                    c06Var.f(3);
                    b06 b06Var = (b06) oiVar;
                    c06Var.e(b06Var.d());
                    c06Var.d(b06Var.a());
                } else {
                    c06Var.f(4);
                    c06Var.d(oiVar);
                }
                arrayList.add(c06Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<oi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (u26.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    u26.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && u26.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                u26.i().n(list, -1, 2);
            }
        }
    }
}
