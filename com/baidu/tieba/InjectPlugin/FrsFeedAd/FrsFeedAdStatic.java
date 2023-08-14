package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.d56;
import com.baidu.tieba.ix9;
import com.baidu.tieba.k26;
import com.baidu.tieba.l26;
import com.baidu.tieba.m26;
import com.baidu.tieba.p26;
import com.baidu.tieba.q26;
import com.baidu.tieba.r26;
import com.baidu.tieba.s26;
import com.baidu.tieba.t26;
import com.baidu.tieba.y26;
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
            y26 y26Var;
            q26 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof y26) || (c = (y26Var = (y26) customResponsedMessage.getData()).c()) == null || !(c instanceof ix9)) {
                return;
            }
            ix9 ix9Var = (ix9) c;
            p26 e1 = c.e1(1);
            if (e1 == null) {
                s26 a = t26.b().a(1);
                if (a == null) {
                    return;
                }
                e1 = a.a();
                c.B0(1, e1);
                e1.f(new r26(ix9Var), y26Var.i());
            }
            if (!(e1 instanceof m26)) {
                return;
            }
            m26 m26Var = (m26) e1;
            if (y26Var.a() == 1) {
                List list = (List) y26Var.f();
                k26.b(m26Var.d());
                for (BdUniqueId bdUniqueId : k26.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(ix9Var, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(ix9Var.u());
                    list.add(frsFeedAdAdapter);
                }
            } else if (y26Var.a() == 2) {
                m26Var.k(y26Var.d());
            } else if (y26Var.a() == 3) {
                List<ym> o = y26Var.o();
                List<l26> d = FrsFeedAdStatic.d(o);
                if (y26Var.q()) {
                    m26Var.o(d, FrsFeedAdStatic.d(y26Var.l()), y26Var.p(), y26Var.e());
                } else {
                    m26Var.i(d, y26Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, y26Var.i()));
            } else if (y26Var.a() == 4) {
                m26Var.a(y26Var.n());
            } else if (y26Var.a() == 5) {
                m26Var.e(FrsFeedAdStatic.d(y26Var.o()), y26Var.h(), y26Var.g(), y26Var.m(), y26Var.j(), y26Var.r(), y26Var.k());
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

    public static List<ym> c(List<l26> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (l26 l26Var : list) {
                    if (l26Var.c() == 3) {
                        k26 k26Var = new k26();
                        k26Var.f(l26Var.a());
                        k26Var.g(l26Var.b());
                        arrayList.add(k26Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (l26Var.a() instanceof ym) {
                        arrayList.add((ym) l26Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<l26> d(List<ym> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (ym ymVar : list) {
                l26 l26Var = new l26();
                if (ymVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) ymVar;
                    if (threadData.getIs_top() == 1) {
                        l26Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        l26Var.f(2);
                    } else {
                        l26Var.f(4);
                    }
                    l26Var.d(ymVar);
                } else if (ymVar instanceof k26) {
                    l26Var.f(3);
                    k26 k26Var = (k26) ymVar;
                    l26Var.e(k26Var.d());
                    l26Var.d(k26Var.a());
                } else {
                    l26Var.f(4);
                    l26Var.d(ymVar);
                }
                arrayList.add(l26Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<ym> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (d56.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    d56.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && d56.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                d56.i().n(list, -1, 2);
            }
        }
    }
}
