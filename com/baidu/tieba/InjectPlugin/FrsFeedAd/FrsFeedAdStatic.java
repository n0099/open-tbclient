package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.Cdo;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.av5;
import com.baidu.tieba.bv5;
import com.baidu.tieba.cv5;
import com.baidu.tieba.dv5;
import com.baidu.tieba.ev5;
import com.baidu.tieba.jv5;
import com.baidu.tieba.ns8;
import com.baidu.tieba.nx5;
import com.baidu.tieba.vu5;
import com.baidu.tieba.wu5;
import com.baidu.tieba.xu5;
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
            jv5 jv5Var;
            bv5 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof jv5) || (c = (jv5Var = (jv5) customResponsedMessage.getData()).c()) == null || !(c instanceof ns8)) {
                return;
            }
            ns8 ns8Var = (ns8) c;
            av5 Y0 = c.Y0(1);
            if (Y0 == null) {
                dv5 a = ev5.b().a(1);
                if (a == null) {
                    return;
                }
                Y0 = a.a();
                c.x0(1, Y0);
                Y0.f(new cv5(ns8Var), jv5Var.i());
            }
            if (!(Y0 instanceof xu5)) {
                return;
            }
            xu5 xu5Var = (xu5) Y0;
            if (jv5Var.a() == 1) {
                List list = (List) jv5Var.f();
                vu5.b(xu5Var.d());
                for (BdUniqueId bdUniqueId : vu5.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(ns8Var, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(ns8Var.p());
                    list.add(frsFeedAdAdapter);
                }
            } else if (jv5Var.a() == 2) {
                xu5Var.k(jv5Var.d());
            } else if (jv5Var.a() == 3) {
                List<Cdo> o = jv5Var.o();
                List<wu5> d = FrsFeedAdStatic.d(o);
                if (jv5Var.q()) {
                    xu5Var.o(d, FrsFeedAdStatic.d(jv5Var.l()), jv5Var.p(), jv5Var.e());
                } else {
                    xu5Var.i(d, jv5Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, jv5Var.i()));
            } else if (jv5Var.a() == 4) {
                xu5Var.a(jv5Var.n());
            } else if (jv5Var.a() == 5) {
                xu5Var.e(FrsFeedAdStatic.d(jv5Var.o()), jv5Var.h(), jv5Var.g(), jv5Var.m(), jv5Var.j(), jv5Var.r(), jv5Var.k());
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

    public static List<Cdo> c(List<wu5> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (wu5 wu5Var : list) {
                    if (wu5Var.c() == 3) {
                        vu5 vu5Var = new vu5();
                        vu5Var.h(wu5Var.a());
                        vu5Var.i(wu5Var.b());
                        arrayList.add(vu5Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (wu5Var.a() instanceof Cdo) {
                        arrayList.add((Cdo) wu5Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<wu5> d(List<Cdo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Cdo cdo : list) {
                wu5 wu5Var = new wu5();
                if (cdo instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) cdo;
                    if (threadData.getIs_top() == 1) {
                        wu5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        wu5Var.f(2);
                    } else {
                        wu5Var.f(4);
                    }
                    wu5Var.d(cdo);
                } else if (cdo instanceof vu5) {
                    wu5Var.f(3);
                    vu5 vu5Var = (vu5) cdo;
                    wu5Var.e(vu5Var.f());
                    wu5Var.d(vu5Var.a());
                } else {
                    wu5Var.f(4);
                    wu5Var.d(cdo);
                }
                arrayList.add(wu5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (nx5.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    nx5.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && nx5.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                nx5.i().n(list, -1, 2);
            }
        }
    }
}
