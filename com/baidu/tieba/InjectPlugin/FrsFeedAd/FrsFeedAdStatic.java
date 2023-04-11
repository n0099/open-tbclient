package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.ax5;
import com.baidu.tieba.dx5;
import com.baidu.tieba.ex5;
import com.baidu.tieba.fx5;
import com.baidu.tieba.gx5;
import com.baidu.tieba.hn;
import com.baidu.tieba.hx5;
import com.baidu.tieba.mx5;
import com.baidu.tieba.qz5;
import com.baidu.tieba.sa9;
import com.baidu.tieba.yw5;
import com.baidu.tieba.zw5;
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
            mx5 mx5Var;
            ex5 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof mx5) || (c = (mx5Var = (mx5) customResponsedMessage.getData()).c()) == null || !(c instanceof sa9)) {
                return;
            }
            sa9 sa9Var = (sa9) c;
            dx5 b1 = c.b1(1);
            if (b1 == null) {
                gx5 a = hx5.b().a(1);
                if (a == null) {
                    return;
                }
                b1 = a.a();
                c.A0(1, b1);
                b1.f(new fx5(sa9Var), mx5Var.i());
            }
            if (!(b1 instanceof ax5)) {
                return;
            }
            ax5 ax5Var = (ax5) b1;
            if (mx5Var.a() == 1) {
                List list = (List) mx5Var.f();
                yw5.b(ax5Var.d());
                for (BdUniqueId bdUniqueId : yw5.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(sa9Var, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(sa9Var.q());
                    list.add(frsFeedAdAdapter);
                }
            } else if (mx5Var.a() == 2) {
                ax5Var.k(mx5Var.d());
            } else if (mx5Var.a() == 3) {
                List<hn> o = mx5Var.o();
                List<zw5> d = FrsFeedAdStatic.d(o);
                if (mx5Var.q()) {
                    ax5Var.o(d, FrsFeedAdStatic.d(mx5Var.l()), mx5Var.p(), mx5Var.e());
                } else {
                    ax5Var.i(d, mx5Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, mx5Var.i()));
            } else if (mx5Var.a() == 4) {
                ax5Var.a(mx5Var.n());
            } else if (mx5Var.a() == 5) {
                ax5Var.e(FrsFeedAdStatic.d(mx5Var.o()), mx5Var.h(), mx5Var.g(), mx5Var.m(), mx5Var.j(), mx5Var.r(), mx5Var.k());
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

    public static List<hn> c(List<zw5> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (zw5 zw5Var : list) {
                    if (zw5Var.c() == 3) {
                        yw5 yw5Var = new yw5();
                        yw5Var.f(zw5Var.a());
                        yw5Var.h(zw5Var.b());
                        arrayList.add(yw5Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (zw5Var.a() instanceof hn) {
                        arrayList.add((hn) zw5Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<zw5> d(List<hn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (hn hnVar : list) {
                zw5 zw5Var = new zw5();
                if (hnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) hnVar;
                    if (threadData.getIs_top() == 1) {
                        zw5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        zw5Var.f(2);
                    } else {
                        zw5Var.f(4);
                    }
                    zw5Var.d(hnVar);
                } else if (hnVar instanceof yw5) {
                    zw5Var.f(3);
                    yw5 yw5Var = (yw5) hnVar;
                    zw5Var.e(yw5Var.d());
                    zw5Var.d(yw5Var.a());
                } else {
                    zw5Var.f(4);
                    zw5Var.d(hnVar);
                }
                arrayList.add(zw5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<hn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (qz5.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    qz5.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && qz5.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                qz5.i().n(list, -1, 2);
            }
        }
    }
}
