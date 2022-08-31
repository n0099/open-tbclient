package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.bc8;
import com.baidu.tieba.gk5;
import com.baidu.tieba.hk5;
import com.baidu.tieba.ik5;
import com.baidu.tieba.lk5;
import com.baidu.tieba.mk5;
import com.baidu.tieba.nk5;
import com.baidu.tieba.ok5;
import com.baidu.tieba.pk5;
import com.baidu.tieba.pn;
import com.baidu.tieba.uk5;
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
            uk5 uk5Var;
            mk5 c;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof uk5) && (c = (uk5Var = (uk5) customResponsedMessage.getData()).c()) != null && (c instanceof bc8)) {
                bc8 bc8Var = (bc8) c;
                lk5 Q0 = c.Q0(1);
                if (Q0 == null) {
                    ok5 a = pk5.b().a(1);
                    if (a == null) {
                        return;
                    }
                    Q0 = a.a();
                    c.p0(1, Q0);
                    Q0.f(new nk5(bc8Var), uk5Var.i());
                }
                if (Q0 instanceof ik5) {
                    ik5 ik5Var = (ik5) Q0;
                    if (uk5Var.a() == 1) {
                        List list = (List) uk5Var.f();
                        gk5.b(ik5Var.d());
                        for (BdUniqueId bdUniqueId : gk5.c()) {
                            FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(bc8Var, bdUniqueId);
                            frsFeedAdAdapter.setPageContext(bc8Var.o());
                            list.add(frsFeedAdAdapter);
                        }
                    } else if (uk5Var.a() == 2) {
                        ik5Var.k(uk5Var.d());
                    } else if (uk5Var.a() == 3) {
                        List<pn> o = uk5Var.o();
                        List<hk5> d = FrsFeedAdStatic.d(o);
                        if (uk5Var.q()) {
                            ik5Var.o(d, FrsFeedAdStatic.d(uk5Var.l()), uk5Var.p(), uk5Var.e());
                        } else {
                            ik5Var.i(d, uk5Var.e());
                        }
                        o.clear();
                        o.addAll(FrsFeedAdStatic.c(d));
                    } else if (uk5Var.a() == 4) {
                        ik5Var.a(uk5Var.n());
                    } else if (uk5Var.a() == 5) {
                        ik5Var.e(FrsFeedAdStatic.d(uk5Var.o()), uk5Var.h(), uk5Var.g(), uk5Var.m(), uk5Var.j(), uk5Var.r(), uk5Var.k());
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

    public static List<pn> c(List<hk5> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (hk5 hk5Var : list) {
                if (hk5Var.c() == 3) {
                    gk5 gk5Var = new gk5();
                    gk5Var.h(hk5Var.a());
                    gk5Var.j(hk5Var.b());
                    arrayList.add(gk5Var);
                } else if (hk5Var.a() instanceof pn) {
                    arrayList.add((pn) hk5Var.a());
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<hk5> d(List<pn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (pn pnVar : list) {
                hk5 hk5Var = new hk5();
                if (pnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) pnVar;
                    if (threadData.getIs_top() == 1) {
                        hk5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        hk5Var.f(2);
                    } else {
                        hk5Var.f(4);
                    }
                    hk5Var.d(pnVar);
                } else if (pnVar instanceof gk5) {
                    hk5Var.f(3);
                    gk5 gk5Var = (gk5) pnVar;
                    hk5Var.e(gk5Var.f());
                    hk5Var.d(gk5Var.a());
                } else {
                    hk5Var.f(4);
                    hk5Var.d(pnVar);
                }
                arrayList.add(hk5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
