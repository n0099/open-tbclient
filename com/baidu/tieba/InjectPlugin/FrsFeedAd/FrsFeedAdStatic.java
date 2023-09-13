package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.c46;
import com.baidu.tieba.cn;
import com.baidu.tieba.d46;
import com.baidu.tieba.e3a;
import com.baidu.tieba.e46;
import com.baidu.tieba.f46;
import com.baidu.tieba.g46;
import com.baidu.tieba.l46;
import com.baidu.tieba.q66;
import com.baidu.tieba.x36;
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
            l46 l46Var;
            d46 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof l46) || (c = (l46Var = (l46) customResponsedMessage.getData()).c()) == null || !(c instanceof e3a)) {
                return;
            }
            e3a e3aVar = (e3a) c;
            c46 o1 = c.o1(1);
            if (o1 == null) {
                f46 a = g46.b().a(1);
                if (a == null) {
                    return;
                }
                o1 = a.a();
                c.J0(1, o1);
                o1.f(new e46(e3aVar), l46Var.i());
            }
            if (!(o1 instanceof z36)) {
                return;
            }
            z36 z36Var = (z36) o1;
            if (l46Var.a() == 1) {
                List list = (List) l46Var.f();
                x36.b(z36Var.d());
                for (BdUniqueId bdUniqueId : x36.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(e3aVar, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(e3aVar.u());
                    list.add(frsFeedAdAdapter);
                }
            } else if (l46Var.a() == 2) {
                z36Var.k(l46Var.d());
            } else if (l46Var.a() == 3) {
                List<cn> o = l46Var.o();
                List<y36> d = FrsFeedAdStatic.d(o);
                if (l46Var.q()) {
                    z36Var.o(d, FrsFeedAdStatic.d(l46Var.l()), l46Var.p(), l46Var.e());
                } else {
                    z36Var.i(d, l46Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, l46Var.i()));
            } else if (l46Var.a() == 4) {
                z36Var.a(l46Var.n());
            } else if (l46Var.a() == 5) {
                z36Var.e(FrsFeedAdStatic.d(l46Var.o()), l46Var.h(), l46Var.g(), l46Var.m(), l46Var.j(), l46Var.r(), l46Var.k());
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

    public static List<cn> c(List<y36> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (y36 y36Var : list) {
                    if (y36Var.c() == 3) {
                        x36 x36Var = new x36();
                        x36Var.f(y36Var.a());
                        x36Var.g(y36Var.b());
                        arrayList.add(x36Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (y36Var.a() instanceof cn) {
                        arrayList.add((cn) y36Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<y36> d(List<cn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (cn cnVar : list) {
                y36 y36Var = new y36();
                if (cnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) cnVar;
                    if (threadData.getIs_top() == 1) {
                        y36Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        y36Var.f(2);
                    } else {
                        y36Var.f(4);
                    }
                    y36Var.d(cnVar);
                } else if (cnVar instanceof x36) {
                    y36Var.f(3);
                    x36 x36Var = (x36) cnVar;
                    y36Var.e(x36Var.d());
                    y36Var.d(x36Var.a());
                } else {
                    y36Var.f(4);
                    y36Var.d(cnVar);
                }
                arrayList.add(y36Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<cn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (q66.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    q66.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && q66.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                q66.i().n(list, -1, 2);
            }
        }
    }
}
