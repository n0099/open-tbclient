package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.c56;
import com.baidu.tieba.d56;
import com.baidu.tieba.e56;
import com.baidu.tieba.h56;
import com.baidu.tieba.i56;
import com.baidu.tieba.j56;
import com.baidu.tieba.k56;
import com.baidu.tieba.l56;
import com.baidu.tieba.q56;
import com.baidu.tieba.qy9;
import com.baidu.tieba.v76;
import com.baidu.tieba.yn;
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
            q56 q56Var;
            i56 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof q56) || (c = (q56Var = (q56) customResponsedMessage.getData()).c()) == null || !(c instanceof qy9)) {
                return;
            }
            qy9 qy9Var = (qy9) c;
            h56 d1 = c.d1(1);
            if (d1 == null) {
                k56 a = l56.b().a(1);
                if (a == null) {
                    return;
                }
                d1 = a.a();
                c.A0(1, d1);
                d1.f(new j56(qy9Var), q56Var.i());
            }
            if (!(d1 instanceof e56)) {
                return;
            }
            e56 e56Var = (e56) d1;
            if (q56Var.a() == 1) {
                List list = (List) q56Var.f();
                c56.b(e56Var.d());
                for (BdUniqueId bdUniqueId : c56.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(qy9Var, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(qy9Var.t());
                    list.add(frsFeedAdAdapter);
                }
            } else if (q56Var.a() == 2) {
                e56Var.k(q56Var.d());
            } else if (q56Var.a() == 3) {
                List<yn> o = q56Var.o();
                List<d56> d = FrsFeedAdStatic.d(o);
                if (q56Var.q()) {
                    e56Var.o(d, FrsFeedAdStatic.d(q56Var.l()), q56Var.p(), q56Var.e());
                } else {
                    e56Var.i(d, q56Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, q56Var.i()));
            } else if (q56Var.a() == 4) {
                e56Var.a(q56Var.n());
            } else if (q56Var.a() == 5) {
                e56Var.e(FrsFeedAdStatic.d(q56Var.o()), q56Var.h(), q56Var.g(), q56Var.m(), q56Var.j(), q56Var.r(), q56Var.k());
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

    public static List<yn> c(List<d56> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (d56 d56Var : list) {
                    if (d56Var.c() == 3) {
                        c56 c56Var = new c56();
                        c56Var.f(d56Var.a());
                        c56Var.g(d56Var.b());
                        arrayList.add(c56Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (d56Var.a() instanceof yn) {
                        arrayList.add((yn) d56Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<d56> d(List<yn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (yn ynVar : list) {
                d56 d56Var = new d56();
                if (ynVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) ynVar;
                    if (threadData.getIs_top() == 1) {
                        d56Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        d56Var.f(2);
                    } else {
                        d56Var.f(4);
                    }
                    d56Var.d(ynVar);
                } else if (ynVar instanceof c56) {
                    d56Var.f(3);
                    c56 c56Var = (c56) ynVar;
                    d56Var.e(c56Var.d());
                    d56Var.d(c56Var.a());
                } else {
                    d56Var.f(4);
                    d56Var.d(ynVar);
                }
                arrayList.add(d56Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<yn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (v76.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    v76.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && v76.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                v76.i().n(list, -1, 2);
            }
        }
    }
}
