package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.ab9;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.ax5;
import com.baidu.tieba.bx5;
import com.baidu.tieba.ex5;
import com.baidu.tieba.fx5;
import com.baidu.tieba.gx5;
import com.baidu.tieba.hx5;
import com.baidu.tieba.in;
import com.baidu.tieba.ix5;
import com.baidu.tieba.nx5;
import com.baidu.tieba.rz5;
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
            nx5 nx5Var;
            fx5 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof nx5) || (c = (nx5Var = (nx5) customResponsedMessage.getData()).c()) == null || !(c instanceof ab9)) {
                return;
            }
            ab9 ab9Var = (ab9) c;
            ex5 b1 = c.b1(1);
            if (b1 == null) {
                hx5 a = ix5.b().a(1);
                if (a == null) {
                    return;
                }
                b1 = a.a();
                c.A0(1, b1);
                b1.f(new gx5(ab9Var), nx5Var.i());
            }
            if (!(b1 instanceof bx5)) {
                return;
            }
            bx5 bx5Var = (bx5) b1;
            if (nx5Var.a() == 1) {
                List list = (List) nx5Var.f();
                zw5.b(bx5Var.d());
                for (BdUniqueId bdUniqueId : zw5.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(ab9Var, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(ab9Var.q());
                    list.add(frsFeedAdAdapter);
                }
            } else if (nx5Var.a() == 2) {
                bx5Var.k(nx5Var.d());
            } else if (nx5Var.a() == 3) {
                List<in> o = nx5Var.o();
                List<ax5> d = FrsFeedAdStatic.d(o);
                if (nx5Var.q()) {
                    bx5Var.o(d, FrsFeedAdStatic.d(nx5Var.l()), nx5Var.p(), nx5Var.e());
                } else {
                    bx5Var.i(d, nx5Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, nx5Var.i()));
            } else if (nx5Var.a() == 4) {
                bx5Var.a(nx5Var.n());
            } else if (nx5Var.a() == 5) {
                bx5Var.e(FrsFeedAdStatic.d(nx5Var.o()), nx5Var.h(), nx5Var.g(), nx5Var.m(), nx5Var.j(), nx5Var.r(), nx5Var.k());
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

    public static List<in> c(List<ax5> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (ax5 ax5Var : list) {
                    if (ax5Var.c() == 3) {
                        zw5 zw5Var = new zw5();
                        zw5Var.f(ax5Var.a());
                        zw5Var.h(ax5Var.b());
                        arrayList.add(zw5Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (ax5Var.a() instanceof in) {
                        arrayList.add((in) ax5Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<ax5> d(List<in> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (in inVar : list) {
                ax5 ax5Var = new ax5();
                if (inVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) inVar;
                    if (threadData.getIs_top() == 1) {
                        ax5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        ax5Var.f(2);
                    } else {
                        ax5Var.f(4);
                    }
                    ax5Var.d(inVar);
                } else if (inVar instanceof zw5) {
                    ax5Var.f(3);
                    zw5 zw5Var = (zw5) inVar;
                    ax5Var.e(zw5Var.d());
                    ax5Var.d(zw5Var.a());
                } else {
                    ax5Var.f(4);
                    ax5Var.d(inVar);
                }
                arrayList.add(ax5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<in> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (rz5.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    rz5.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && rz5.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                rz5.i().n(list, -1, 2);
            }
        }
    }
}
