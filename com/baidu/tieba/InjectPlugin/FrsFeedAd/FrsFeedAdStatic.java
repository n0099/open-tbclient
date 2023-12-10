package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.b16;
import com.baidu.tieba.g36;
import com.baidu.tieba.n06;
import com.baidu.tieba.o06;
import com.baidu.tieba.p06;
import com.baidu.tieba.pi;
import com.baidu.tieba.s06;
import com.baidu.tieba.sha;
import com.baidu.tieba.t06;
import com.baidu.tieba.u06;
import com.baidu.tieba.v06;
import com.baidu.tieba.w06;
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
            b16 b16Var;
            t06 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof b16) || (c = (b16Var = (b16) customResponsedMessage.getData()).c()) == null || !(c instanceof sha)) {
                return;
            }
            sha shaVar = (sha) c;
            s06 T1 = c.T1(1);
            if (T1 == null) {
                v06 a = w06.b().a(1);
                if (a == null) {
                    return;
                }
                T1 = a.a();
                c.f1(1, T1);
                T1.f(new u06(shaVar), b16Var.i());
            }
            if (!(T1 instanceof p06)) {
                return;
            }
            p06 p06Var = (p06) T1;
            if (b16Var.a() == 1) {
                List list = (List) b16Var.f();
                n06.b(p06Var.d());
                for (BdUniqueId bdUniqueId : n06.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(shaVar, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(shaVar.I());
                    list.add(frsFeedAdAdapter);
                }
            } else if (b16Var.a() == 2) {
                p06Var.k(b16Var.d());
            } else if (b16Var.a() == 3) {
                List<pi> o = b16Var.o();
                List<o06> d = FrsFeedAdStatic.d(o);
                if (b16Var.q()) {
                    p06Var.o(d, FrsFeedAdStatic.d(b16Var.l()), b16Var.p(), b16Var.e());
                } else {
                    p06Var.i(d, b16Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, b16Var.i()));
            } else if (b16Var.a() == 4) {
                p06Var.a(b16Var.n());
            } else if (b16Var.a() == 5) {
                p06Var.e(FrsFeedAdStatic.d(b16Var.o()), b16Var.h(), b16Var.g(), b16Var.m(), b16Var.j(), b16Var.r(), b16Var.k());
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

    public static List<pi> c(List<o06> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (o06 o06Var : list) {
                    if (o06Var.c() == 3) {
                        n06 n06Var = new n06();
                        n06Var.f(o06Var.a());
                        n06Var.g(o06Var.b());
                        arrayList.add(n06Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (o06Var.a() instanceof pi) {
                        arrayList.add((pi) o06Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<o06> d(List<pi> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (pi piVar : list) {
                o06 o06Var = new o06();
                if (piVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) piVar;
                    if (threadData.getIs_top() == 1) {
                        o06Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        o06Var.f(2);
                    } else {
                        o06Var.f(4);
                    }
                    o06Var.d(piVar);
                } else if (piVar instanceof n06) {
                    o06Var.f(3);
                    n06 n06Var = (n06) piVar;
                    o06Var.e(n06Var.d());
                    o06Var.d(n06Var.a());
                } else {
                    o06Var.f(4);
                    o06Var.d(piVar);
                }
                arrayList.add(o06Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (g36.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    g36.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && g36.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                g36.i().n(list, -1, 2);
            }
        }
    }
}
