package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.Cdo;
import com.baidu.tieba.dn5;
import com.baidu.tieba.jd8;
import com.baidu.tieba.pm5;
import com.baidu.tieba.qm5;
import com.baidu.tieba.rm5;
import com.baidu.tieba.um5;
import com.baidu.tieba.vm5;
import com.baidu.tieba.wm5;
import com.baidu.tieba.xm5;
import com.baidu.tieba.ym5;
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
            dn5 dn5Var;
            vm5 c;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof dn5) && (c = (dn5Var = (dn5) customResponsedMessage.getData()).c()) != null && (c instanceof jd8)) {
                jd8 jd8Var = (jd8) c;
                um5 P0 = c.P0(1);
                if (P0 == null) {
                    xm5 a = ym5.b().a(1);
                    if (a == null) {
                        return;
                    }
                    P0 = a.a();
                    c.o0(1, P0);
                    P0.f(new wm5(jd8Var), dn5Var.i());
                }
                if (P0 instanceof rm5) {
                    rm5 rm5Var = (rm5) P0;
                    if (dn5Var.a() == 1) {
                        List list = (List) dn5Var.f();
                        pm5.b(rm5Var.d());
                        for (BdUniqueId bdUniqueId : pm5.c()) {
                            FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(jd8Var, bdUniqueId);
                            frsFeedAdAdapter.setPageContext(jd8Var.o());
                            list.add(frsFeedAdAdapter);
                        }
                    } else if (dn5Var.a() == 2) {
                        rm5Var.k(dn5Var.d());
                    } else if (dn5Var.a() == 3) {
                        List<Cdo> o = dn5Var.o();
                        List<qm5> d = FrsFeedAdStatic.d(o);
                        if (dn5Var.q()) {
                            rm5Var.o(d, FrsFeedAdStatic.d(dn5Var.l()), dn5Var.p(), dn5Var.e());
                        } else {
                            rm5Var.i(d, dn5Var.e());
                        }
                        o.clear();
                        o.addAll(FrsFeedAdStatic.c(d));
                    } else if (dn5Var.a() == 4) {
                        rm5Var.a(dn5Var.n());
                    } else if (dn5Var.a() == 5) {
                        rm5Var.e(FrsFeedAdStatic.d(dn5Var.o()), dn5Var.h(), dn5Var.g(), dn5Var.m(), dn5Var.j(), dn5Var.r(), dn5Var.k());
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

    public static List<Cdo> c(List<qm5> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (qm5 qm5Var : list) {
                if (qm5Var.c() == 3) {
                    pm5 pm5Var = new pm5();
                    pm5Var.h(qm5Var.a());
                    pm5Var.j(qm5Var.b());
                    arrayList.add(pm5Var);
                } else if (qm5Var.a() instanceof Cdo) {
                    arrayList.add((Cdo) qm5Var.a());
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<qm5> d(List<Cdo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Cdo cdo : list) {
                qm5 qm5Var = new qm5();
                if (cdo instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) cdo;
                    if (threadData.getIs_top() == 1) {
                        qm5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        qm5Var.f(2);
                    } else {
                        qm5Var.f(4);
                    }
                    qm5Var.d(cdo);
                } else if (cdo instanceof pm5) {
                    qm5Var.f(3);
                    pm5 pm5Var = (pm5) cdo;
                    qm5Var.e(pm5Var.f());
                    qm5Var.d(pm5Var.a());
                } else {
                    qm5Var.f(4);
                    qm5Var.d(cdo);
                }
                arrayList.add(qm5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
