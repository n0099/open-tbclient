package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.a46;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.b46;
import com.baidu.tieba.c46;
import com.baidu.tieba.h46;
import com.baidu.tieba.m66;
import com.baidu.tieba.t36;
import com.baidu.tieba.u36;
import com.baidu.tieba.v36;
import com.baidu.tieba.wn;
import com.baidu.tieba.xn9;
import com.baidu.tieba.y36;
import com.baidu.tieba.z36;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsFeedAdStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
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
            h46 h46Var;
            z36 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof h46) || (c = (h46Var = (h46) customResponsedMessage.getData()).c()) == null || !(c instanceof xn9)) {
                return;
            }
            xn9 xn9Var = (xn9) c;
            y36 d1 = c.d1(1);
            if (d1 == null) {
                b46 a = c46.b().a(1);
                if (a == null) {
                    return;
                }
                d1 = a.a();
                c.A0(1, d1);
                d1.f(new a46(xn9Var), h46Var.i());
            }
            if (!(d1 instanceof v36)) {
                return;
            }
            v36 v36Var = (v36) d1;
            if (h46Var.a() == 1) {
                List list = (List) h46Var.f();
                t36.b(v36Var.d());
                for (BdUniqueId bdUniqueId : t36.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(xn9Var, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(xn9Var.t());
                    list.add(frsFeedAdAdapter);
                }
            } else if (h46Var.a() == 2) {
                v36Var.k(h46Var.d());
            } else if (h46Var.a() == 3) {
                List<wn> o = h46Var.o();
                List<u36> d = FrsFeedAdStatic.d(o);
                if (h46Var.q()) {
                    v36Var.o(d, FrsFeedAdStatic.d(h46Var.l()), h46Var.p(), h46Var.e());
                } else {
                    v36Var.i(d, h46Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, h46Var.i()));
            } else if (h46Var.a() == 4) {
                v36Var.a(h46Var.n());
            } else if (h46Var.a() == 5) {
                v36Var.e(FrsFeedAdStatic.d(h46Var.o()), h46Var.h(), h46Var.g(), h46Var.m(), h46Var.j(), h46Var.r(), h46Var.k());
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

    public static List<wn> c(List<u36> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (u36 u36Var : list) {
                    if (u36Var.c() == 3) {
                        t36 t36Var = new t36();
                        t36Var.f(u36Var.a());
                        t36Var.h(u36Var.b());
                        arrayList.add(t36Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (u36Var.a() instanceof wn) {
                        arrayList.add((wn) u36Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<u36> d(List<wn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (wn wnVar : list) {
                u36 u36Var = new u36();
                if (wnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) wnVar;
                    if (threadData.getIs_top() == 1) {
                        u36Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        u36Var.f(2);
                    } else {
                        u36Var.f(4);
                    }
                    u36Var.d(wnVar);
                } else if (wnVar instanceof t36) {
                    u36Var.f(3);
                    t36 t36Var = (t36) wnVar;
                    u36Var.e(t36Var.d());
                    u36Var.d(t36Var.a());
                } else {
                    u36Var.f(4);
                    u36Var.d(wnVar);
                }
                arrayList.add(u36Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<wn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (m66.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    m66.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && m66.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                m66.i().n(list, -1, 2);
            }
        }
    }
}
