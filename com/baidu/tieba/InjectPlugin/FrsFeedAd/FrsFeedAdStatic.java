package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.aw5;
import com.baidu.tieba.bw5;
import com.baidu.tieba.c19;
import com.baidu.tieba.gn;
import com.baidu.tieba.gw5;
import com.baidu.tieba.ky5;
import com.baidu.tieba.sv5;
import com.baidu.tieba.tv5;
import com.baidu.tieba.uv5;
import com.baidu.tieba.xv5;
import com.baidu.tieba.yv5;
import com.baidu.tieba.zv5;
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
            gw5 gw5Var;
            yv5 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof gw5) || (c = (gw5Var = (gw5) customResponsedMessage.getData()).c()) == null || !(c instanceof c19)) {
                return;
            }
            c19 c19Var = (c19) c;
            xv5 Z0 = c.Z0(1);
            if (Z0 == null) {
                aw5 a = bw5.b().a(1);
                if (a == null) {
                    return;
                }
                Z0 = a.a();
                c.z0(1, Z0);
                Z0.f(new zv5(c19Var), gw5Var.i());
            }
            if (!(Z0 instanceof uv5)) {
                return;
            }
            uv5 uv5Var = (uv5) Z0;
            if (gw5Var.a() == 1) {
                List list = (List) gw5Var.f();
                sv5.b(uv5Var.d());
                for (BdUniqueId bdUniqueId : sv5.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(c19Var, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(c19Var.n());
                    list.add(frsFeedAdAdapter);
                }
            } else if (gw5Var.a() == 2) {
                uv5Var.k(gw5Var.d());
            } else if (gw5Var.a() == 3) {
                List<gn> o = gw5Var.o();
                List<tv5> d = FrsFeedAdStatic.d(o);
                if (gw5Var.q()) {
                    uv5Var.o(d, FrsFeedAdStatic.d(gw5Var.l()), gw5Var.p(), gw5Var.e());
                } else {
                    uv5Var.i(d, gw5Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, gw5Var.i()));
            } else if (gw5Var.a() == 4) {
                uv5Var.a(gw5Var.n());
            } else if (gw5Var.a() == 5) {
                uv5Var.e(FrsFeedAdStatic.d(gw5Var.o()), gw5Var.h(), gw5Var.g(), gw5Var.m(), gw5Var.j(), gw5Var.r(), gw5Var.k());
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

    public static List<gn> c(List<tv5> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (tv5 tv5Var : list) {
                    if (tv5Var.c() == 3) {
                        sv5 sv5Var = new sv5();
                        sv5Var.h(tv5Var.a());
                        sv5Var.i(tv5Var.b());
                        arrayList.add(sv5Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (tv5Var.a() instanceof gn) {
                        arrayList.add((gn) tv5Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<tv5> d(List<gn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (gn gnVar : list) {
                tv5 tv5Var = new tv5();
                if (gnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) gnVar;
                    if (threadData.getIs_top() == 1) {
                        tv5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        tv5Var.f(2);
                    } else {
                        tv5Var.f(4);
                    }
                    tv5Var.d(gnVar);
                } else if (gnVar instanceof sv5) {
                    tv5Var.f(3);
                    sv5 sv5Var = (sv5) gnVar;
                    tv5Var.e(sv5Var.f());
                    tv5Var.d(sv5Var.a());
                } else {
                    tv5Var.f(4);
                    tv5Var.d(gnVar);
                }
                arrayList.add(tv5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<gn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (ky5.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    ky5.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && ky5.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                ky5.i().n(list, -1, 2);
            }
        }
    }
}
