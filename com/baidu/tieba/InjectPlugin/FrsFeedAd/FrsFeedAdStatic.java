package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.c36;
import com.baidu.tieba.j06;
import com.baidu.tieba.k06;
import com.baidu.tieba.l06;
import com.baidu.tieba.nha;
import com.baidu.tieba.o06;
import com.baidu.tieba.p06;
import com.baidu.tieba.pi;
import com.baidu.tieba.q06;
import com.baidu.tieba.r06;
import com.baidu.tieba.s06;
import com.baidu.tieba.x06;
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
            x06 x06Var;
            p06 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof x06) || (c = (x06Var = (x06) customResponsedMessage.getData()).c()) == null || !(c instanceof nha)) {
                return;
            }
            nha nhaVar = (nha) c;
            o06 T1 = c.T1(1);
            if (T1 == null) {
                r06 a = s06.b().a(1);
                if (a == null) {
                    return;
                }
                T1 = a.a();
                c.f1(1, T1);
                T1.f(new q06(nhaVar), x06Var.i());
            }
            if (!(T1 instanceof l06)) {
                return;
            }
            l06 l06Var = (l06) T1;
            if (x06Var.a() == 1) {
                List list = (List) x06Var.f();
                j06.b(l06Var.d());
                for (BdUniqueId bdUniqueId : j06.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(nhaVar, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(nhaVar.I());
                    list.add(frsFeedAdAdapter);
                }
            } else if (x06Var.a() == 2) {
                l06Var.k(x06Var.d());
            } else if (x06Var.a() == 3) {
                List<pi> o = x06Var.o();
                List<k06> d = FrsFeedAdStatic.d(o);
                if (x06Var.q()) {
                    l06Var.o(d, FrsFeedAdStatic.d(x06Var.l()), x06Var.p(), x06Var.e());
                } else {
                    l06Var.i(d, x06Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, x06Var.i()));
            } else if (x06Var.a() == 4) {
                l06Var.a(x06Var.n());
            } else if (x06Var.a() == 5) {
                l06Var.e(FrsFeedAdStatic.d(x06Var.o()), x06Var.h(), x06Var.g(), x06Var.m(), x06Var.j(), x06Var.r(), x06Var.k());
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

    public static List<pi> c(List<k06> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (k06 k06Var : list) {
                    if (k06Var.c() == 3) {
                        j06 j06Var = new j06();
                        j06Var.f(k06Var.a());
                        j06Var.g(k06Var.b());
                        arrayList.add(j06Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (k06Var.a() instanceof pi) {
                        arrayList.add((pi) k06Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<k06> d(List<pi> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (pi piVar : list) {
                k06 k06Var = new k06();
                if (piVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) piVar;
                    if (threadData.getIs_top() == 1) {
                        k06Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        k06Var.f(2);
                    } else {
                        k06Var.f(4);
                    }
                    k06Var.d(piVar);
                } else if (piVar instanceof j06) {
                    k06Var.f(3);
                    j06 j06Var = (j06) piVar;
                    k06Var.e(j06Var.d());
                    k06Var.d(j06Var.a());
                } else {
                    k06Var.f(4);
                    k06Var.d(piVar);
                }
                arrayList.add(k06Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (c36.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    c36.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && c36.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                c36.i().n(list, -1, 2);
            }
        }
    }
}
