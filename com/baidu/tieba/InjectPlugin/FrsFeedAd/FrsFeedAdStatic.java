package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.ay5;
import com.baidu.tieba.by5;
import com.baidu.tieba.ey5;
import com.baidu.tieba.fy5;
import com.baidu.tieba.gy5;
import com.baidu.tieba.hy5;
import com.baidu.tieba.in;
import com.baidu.tieba.iy5;
import com.baidu.tieba.ny5;
import com.baidu.tieba.s06;
import com.baidu.tieba.wd9;
import com.baidu.tieba.zx5;
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
            ny5 ny5Var;
            fy5 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof ny5) || (c = (ny5Var = (ny5) customResponsedMessage.getData()).c()) == null || !(c instanceof wd9)) {
                return;
            }
            wd9 wd9Var = (wd9) c;
            ey5 b1 = c.b1(1);
            if (b1 == null) {
                hy5 a = iy5.b().a(1);
                if (a == null) {
                    return;
                }
                b1 = a.a();
                c.B0(1, b1);
                b1.f(new gy5(wd9Var), ny5Var.i());
            }
            if (!(b1 instanceof by5)) {
                return;
            }
            by5 by5Var = (by5) b1;
            if (ny5Var.a() == 1) {
                List list = (List) ny5Var.f();
                zx5.b(by5Var.d());
                for (BdUniqueId bdUniqueId : zx5.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(wd9Var, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(wd9Var.t());
                    list.add(frsFeedAdAdapter);
                }
            } else if (ny5Var.a() == 2) {
                by5Var.k(ny5Var.d());
            } else if (ny5Var.a() == 3) {
                List<in> o = ny5Var.o();
                List<ay5> d = FrsFeedAdStatic.d(o);
                if (ny5Var.q()) {
                    by5Var.o(d, FrsFeedAdStatic.d(ny5Var.l()), ny5Var.p(), ny5Var.e());
                } else {
                    by5Var.i(d, ny5Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, ny5Var.i()));
            } else if (ny5Var.a() == 4) {
                by5Var.a(ny5Var.n());
            } else if (ny5Var.a() == 5) {
                by5Var.e(FrsFeedAdStatic.d(ny5Var.o()), ny5Var.h(), ny5Var.g(), ny5Var.m(), ny5Var.j(), ny5Var.r(), ny5Var.k());
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

    public static List<in> c(List<ay5> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (ay5 ay5Var : list) {
                    if (ay5Var.c() == 3) {
                        zx5 zx5Var = new zx5();
                        zx5Var.f(ay5Var.a());
                        zx5Var.g(ay5Var.b());
                        arrayList.add(zx5Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (ay5Var.a() instanceof in) {
                        arrayList.add((in) ay5Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<ay5> d(List<in> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (in inVar : list) {
                ay5 ay5Var = new ay5();
                if (inVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) inVar;
                    if (threadData.getIs_top() == 1) {
                        ay5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        ay5Var.f(2);
                    } else {
                        ay5Var.f(4);
                    }
                    ay5Var.d(inVar);
                } else if (inVar instanceof zx5) {
                    ay5Var.f(3);
                    zx5 zx5Var = (zx5) inVar;
                    ay5Var.e(zx5Var.d());
                    ay5Var.d(zx5Var.a());
                } else {
                    ay5Var.f(4);
                    ay5Var.d(inVar);
                }
                arrayList.add(ay5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<in> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (s06.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    s06.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && s06.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                s06.i().n(list, -1, 2);
            }
        }
    }
}
