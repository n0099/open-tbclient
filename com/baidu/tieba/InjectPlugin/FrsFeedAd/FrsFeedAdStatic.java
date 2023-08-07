package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.c56;
import com.baidu.tieba.hx9;
import com.baidu.tieba.j26;
import com.baidu.tieba.k26;
import com.baidu.tieba.l26;
import com.baidu.tieba.o26;
import com.baidu.tieba.p26;
import com.baidu.tieba.q26;
import com.baidu.tieba.r26;
import com.baidu.tieba.s26;
import com.baidu.tieba.x26;
import com.baidu.tieba.ym;
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
            x26 x26Var;
            p26 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof x26) || (c = (x26Var = (x26) customResponsedMessage.getData()).c()) == null || !(c instanceof hx9)) {
                return;
            }
            hx9 hx9Var = (hx9) c;
            o26 e1 = c.e1(1);
            if (e1 == null) {
                r26 a = s26.b().a(1);
                if (a == null) {
                    return;
                }
                e1 = a.a();
                c.B0(1, e1);
                e1.f(new q26(hx9Var), x26Var.i());
            }
            if (!(e1 instanceof l26)) {
                return;
            }
            l26 l26Var = (l26) e1;
            if (x26Var.a() == 1) {
                List list = (List) x26Var.f();
                j26.b(l26Var.d());
                for (BdUniqueId bdUniqueId : j26.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(hx9Var, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(hx9Var.u());
                    list.add(frsFeedAdAdapter);
                }
            } else if (x26Var.a() == 2) {
                l26Var.k(x26Var.d());
            } else if (x26Var.a() == 3) {
                List<ym> o = x26Var.o();
                List<k26> d = FrsFeedAdStatic.d(o);
                if (x26Var.q()) {
                    l26Var.o(d, FrsFeedAdStatic.d(x26Var.l()), x26Var.p(), x26Var.e());
                } else {
                    l26Var.i(d, x26Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, x26Var.i()));
            } else if (x26Var.a() == 4) {
                l26Var.a(x26Var.n());
            } else if (x26Var.a() == 5) {
                l26Var.e(FrsFeedAdStatic.d(x26Var.o()), x26Var.h(), x26Var.g(), x26Var.m(), x26Var.j(), x26Var.r(), x26Var.k());
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

    public static List<ym> c(List<k26> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (k26 k26Var : list) {
                    if (k26Var.c() == 3) {
                        j26 j26Var = new j26();
                        j26Var.f(k26Var.a());
                        j26Var.g(k26Var.b());
                        arrayList.add(j26Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (k26Var.a() instanceof ym) {
                        arrayList.add((ym) k26Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<k26> d(List<ym> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (ym ymVar : list) {
                k26 k26Var = new k26();
                if (ymVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) ymVar;
                    if (threadData.getIs_top() == 1) {
                        k26Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        k26Var.f(2);
                    } else {
                        k26Var.f(4);
                    }
                    k26Var.d(ymVar);
                } else if (ymVar instanceof j26) {
                    k26Var.f(3);
                    j26 j26Var = (j26) ymVar;
                    k26Var.e(j26Var.d());
                    k26Var.d(j26Var.a());
                } else {
                    k26Var.f(4);
                    k26Var.d(ymVar);
                }
                arrayList.add(k26Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<ym> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (c56.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    c56.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && c56.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                c56.i().n(list, -1, 2);
            }
        }
    }
}
