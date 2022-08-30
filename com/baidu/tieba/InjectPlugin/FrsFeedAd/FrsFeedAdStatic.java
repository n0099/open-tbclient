package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.dc8;
import com.baidu.tieba.ik5;
import com.baidu.tieba.jk5;
import com.baidu.tieba.kk5;
import com.baidu.tieba.nk5;
import com.baidu.tieba.ok5;
import com.baidu.tieba.pk5;
import com.baidu.tieba.pn;
import com.baidu.tieba.qk5;
import com.baidu.tieba.rk5;
import com.baidu.tieba.wk5;
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
            wk5 wk5Var;
            ok5 c;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof wk5) && (c = (wk5Var = (wk5) customResponsedMessage.getData()).c()) != null && (c instanceof dc8)) {
                dc8 dc8Var = (dc8) c;
                nk5 Q0 = c.Q0(1);
                if (Q0 == null) {
                    qk5 a = rk5.b().a(1);
                    if (a == null) {
                        return;
                    }
                    Q0 = a.a();
                    c.p0(1, Q0);
                    Q0.f(new pk5(dc8Var), wk5Var.i());
                }
                if (Q0 instanceof kk5) {
                    kk5 kk5Var = (kk5) Q0;
                    if (wk5Var.a() == 1) {
                        List list = (List) wk5Var.f();
                        ik5.b(kk5Var.d());
                        for (BdUniqueId bdUniqueId : ik5.c()) {
                            FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(dc8Var, bdUniqueId);
                            frsFeedAdAdapter.setPageContext(dc8Var.o());
                            list.add(frsFeedAdAdapter);
                        }
                    } else if (wk5Var.a() == 2) {
                        kk5Var.k(wk5Var.d());
                    } else if (wk5Var.a() == 3) {
                        List<pn> o = wk5Var.o();
                        List<jk5> d = FrsFeedAdStatic.d(o);
                        if (wk5Var.q()) {
                            kk5Var.o(d, FrsFeedAdStatic.d(wk5Var.l()), wk5Var.p(), wk5Var.e());
                        } else {
                            kk5Var.i(d, wk5Var.e());
                        }
                        o.clear();
                        o.addAll(FrsFeedAdStatic.c(d));
                    } else if (wk5Var.a() == 4) {
                        kk5Var.a(wk5Var.n());
                    } else if (wk5Var.a() == 5) {
                        kk5Var.e(FrsFeedAdStatic.d(wk5Var.o()), wk5Var.h(), wk5Var.g(), wk5Var.m(), wk5Var.j(), wk5Var.r(), wk5Var.k());
                    }
                }
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

    public static List<pn> c(List<jk5> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (jk5 jk5Var : list) {
                if (jk5Var.c() == 3) {
                    ik5 ik5Var = new ik5();
                    ik5Var.h(jk5Var.a());
                    ik5Var.j(jk5Var.b());
                    arrayList.add(ik5Var);
                } else if (jk5Var.a() instanceof pn) {
                    arrayList.add((pn) jk5Var.a());
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<jk5> d(List<pn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (pn pnVar : list) {
                jk5 jk5Var = new jk5();
                if (pnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) pnVar;
                    if (threadData.getIs_top() == 1) {
                        jk5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        jk5Var.f(2);
                    } else {
                        jk5Var.f(4);
                    }
                    jk5Var.d(pnVar);
                } else if (pnVar instanceof ik5) {
                    jk5Var.f(3);
                    ik5 ik5Var = (ik5) pnVar;
                    jk5Var.e(ik5Var.f());
                    jk5Var.d(ik5Var.a());
                } else {
                    jk5Var.f(4);
                    jk5Var.d(pnVar);
                }
                arrayList.add(jk5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
