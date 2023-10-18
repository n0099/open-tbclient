package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.a16;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.hy5;
import com.baidu.tieba.iy5;
import com.baidu.tieba.jy5;
import com.baidu.tieba.my5;
import com.baidu.tieba.ny5;
import com.baidu.tieba.oy5;
import com.baidu.tieba.py5;
import com.baidu.tieba.pz9;
import com.baidu.tieba.qy5;
import com.baidu.tieba.vy5;
import com.baidu.tieba.yh;
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
            vy5 vy5Var;
            ny5 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof vy5) || (c = (vy5Var = (vy5) customResponsedMessage.getData()).c()) == null || !(c instanceof pz9)) {
                return;
            }
            pz9 pz9Var = (pz9) c;
            my5 t1 = c.t1(1);
            if (t1 == null) {
                py5 a = qy5.b().a(1);
                if (a == null) {
                    return;
                }
                t1 = a.a();
                c.Q0(1, t1);
                t1.f(new oy5(pz9Var), vy5Var.i());
            }
            if (!(t1 instanceof jy5)) {
                return;
            }
            jy5 jy5Var = (jy5) t1;
            if (vy5Var.a() == 1) {
                List list = (List) vy5Var.f();
                hy5.b(jy5Var.d());
                for (BdUniqueId bdUniqueId : hy5.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(pz9Var, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(pz9Var.D());
                    list.add(frsFeedAdAdapter);
                }
            } else if (vy5Var.a() == 2) {
                jy5Var.k(vy5Var.d());
            } else if (vy5Var.a() == 3) {
                List<yh> o = vy5Var.o();
                List<iy5> d = FrsFeedAdStatic.d(o);
                if (vy5Var.q()) {
                    jy5Var.o(d, FrsFeedAdStatic.d(vy5Var.l()), vy5Var.p(), vy5Var.e());
                } else {
                    jy5Var.i(d, vy5Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, vy5Var.i()));
            } else if (vy5Var.a() == 4) {
                jy5Var.a(vy5Var.n());
            } else if (vy5Var.a() == 5) {
                jy5Var.e(FrsFeedAdStatic.d(vy5Var.o()), vy5Var.h(), vy5Var.g(), vy5Var.m(), vy5Var.j(), vy5Var.r(), vy5Var.k());
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

    public static List<yh> c(List<iy5> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (iy5 iy5Var : list) {
                    if (iy5Var.c() == 3) {
                        hy5 hy5Var = new hy5();
                        hy5Var.f(iy5Var.a());
                        hy5Var.g(iy5Var.b());
                        arrayList.add(hy5Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (iy5Var.a() instanceof yh) {
                        arrayList.add((yh) iy5Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<iy5> d(List<yh> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (yh yhVar : list) {
                iy5 iy5Var = new iy5();
                if (yhVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) yhVar;
                    if (threadData.getIs_top() == 1) {
                        iy5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        iy5Var.f(2);
                    } else {
                        iy5Var.f(4);
                    }
                    iy5Var.d(yhVar);
                } else if (yhVar instanceof hy5) {
                    iy5Var.f(3);
                    hy5 hy5Var = (hy5) yhVar;
                    iy5Var.e(hy5Var.d());
                    iy5Var.d(hy5Var.a());
                } else {
                    iy5Var.f(4);
                    iy5Var.d(yhVar);
                }
                arrayList.add(iy5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<yh> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (a16.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    a16.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && a16.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                a16.i().n(list, -1, 2);
            }
        }
    }
}
