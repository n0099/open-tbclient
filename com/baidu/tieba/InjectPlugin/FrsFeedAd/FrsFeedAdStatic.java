package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.Cdo;
import com.baidu.tieba.cn5;
import com.baidu.tieba.dn5;
import com.baidu.tieba.en5;
import com.baidu.tieba.hn5;
import com.baidu.tieba.in5;
import com.baidu.tieba.jn5;
import com.baidu.tieba.kn5;
import com.baidu.tieba.ln5;
import com.baidu.tieba.qn5;
import com.baidu.tieba.yd8;
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
            qn5 qn5Var;
            in5 c;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof qn5) && (c = (qn5Var = (qn5) customResponsedMessage.getData()).c()) != null && (c instanceof yd8)) {
                yd8 yd8Var = (yd8) c;
                hn5 P0 = c.P0(1);
                if (P0 == null) {
                    kn5 a = ln5.b().a(1);
                    if (a == null) {
                        return;
                    }
                    P0 = a.a();
                    c.o0(1, P0);
                    P0.f(new jn5(yd8Var), qn5Var.i());
                }
                if (P0 instanceof en5) {
                    en5 en5Var = (en5) P0;
                    if (qn5Var.a() == 1) {
                        List list = (List) qn5Var.f();
                        cn5.b(en5Var.d());
                        for (BdUniqueId bdUniqueId : cn5.c()) {
                            FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(yd8Var, bdUniqueId);
                            frsFeedAdAdapter.setPageContext(yd8Var.o());
                            list.add(frsFeedAdAdapter);
                        }
                    } else if (qn5Var.a() == 2) {
                        en5Var.k(qn5Var.d());
                    } else if (qn5Var.a() == 3) {
                        List<Cdo> o = qn5Var.o();
                        List<dn5> d = FrsFeedAdStatic.d(o);
                        if (qn5Var.q()) {
                            en5Var.o(d, FrsFeedAdStatic.d(qn5Var.l()), qn5Var.p(), qn5Var.e());
                        } else {
                            en5Var.i(d, qn5Var.e());
                        }
                        o.clear();
                        o.addAll(FrsFeedAdStatic.c(d));
                    } else if (qn5Var.a() == 4) {
                        en5Var.a(qn5Var.n());
                    } else if (qn5Var.a() == 5) {
                        en5Var.e(FrsFeedAdStatic.d(qn5Var.o()), qn5Var.h(), qn5Var.g(), qn5Var.m(), qn5Var.j(), qn5Var.r(), qn5Var.k());
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

    public static List<Cdo> c(List<dn5> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (dn5 dn5Var : list) {
                if (dn5Var.c() == 3) {
                    cn5 cn5Var = new cn5();
                    cn5Var.h(dn5Var.a());
                    cn5Var.j(dn5Var.b());
                    arrayList.add(cn5Var);
                } else if (dn5Var.a() instanceof Cdo) {
                    arrayList.add((Cdo) dn5Var.a());
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<dn5> d(List<Cdo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Cdo cdo : list) {
                dn5 dn5Var = new dn5();
                if (cdo instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) cdo;
                    if (threadData.getIs_top() == 1) {
                        dn5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        dn5Var.f(2);
                    } else {
                        dn5Var.f(4);
                    }
                    dn5Var.d(cdo);
                } else if (cdo instanceof cn5) {
                    dn5Var.f(3);
                    cn5 cn5Var = (cn5) cdo;
                    dn5Var.e(cn5Var.f());
                    dn5Var.d(cn5Var.a());
                } else {
                    dn5Var.f(4);
                    dn5Var.d(cdo);
                }
                arrayList.add(dn5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
