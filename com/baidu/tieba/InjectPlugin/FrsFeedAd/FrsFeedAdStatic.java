package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bj5;
import com.repackage.mi5;
import com.repackage.ni5;
import com.repackage.nn;
import com.repackage.oi5;
import com.repackage.p98;
import com.repackage.pi5;
import com.repackage.si5;
import com.repackage.ti5;
import com.repackage.ui5;
import com.repackage.vi5;
import com.repackage.wi5;
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
            bj5 bj5Var;
            ti5 c;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj5) && (c = (bj5Var = (bj5) customResponsedMessage.getData()).c()) != null && (c instanceof p98)) {
                p98 p98Var = (p98) c;
                si5 R0 = c.R0(1);
                if (R0 == null) {
                    vi5 a = wi5.b().a(1);
                    if (a == null) {
                        return;
                    }
                    R0 = a.a();
                    c.q0(1, R0);
                    R0.o(new ui5(p98Var));
                }
                if (R0 instanceof pi5) {
                    pi5 pi5Var = (pi5) R0;
                    if (bj5Var.a() == 1) {
                        List list = (List) bj5Var.f();
                        ni5.b(pi5Var.d());
                        for (BdUniqueId bdUniqueId : ni5.c()) {
                            mi5 mi5Var = new mi5(p98Var, bdUniqueId);
                            mi5Var.Z(p98Var.o());
                            list.add(mi5Var);
                        }
                    } else if (bj5Var.a() == 2) {
                        pi5Var.j(bj5Var.d());
                    } else if (bj5Var.a() == 3) {
                        List<nn> n = bj5Var.n();
                        List<oi5> d = FrsFeedAdStatic.d(n);
                        if (bj5Var.p()) {
                            pi5Var.n(d, FrsFeedAdStatic.d(bj5Var.k()), bj5Var.o(), bj5Var.e());
                        } else {
                            pi5Var.h(d, bj5Var.e());
                        }
                        n.clear();
                        n.addAll(FrsFeedAdStatic.c(d));
                    } else if (bj5Var.a() == 4) {
                        pi5Var.a(bj5Var.m());
                    } else if (bj5Var.a() == 5) {
                        pi5Var.e(FrsFeedAdStatic.d(bj5Var.n()), bj5Var.h(), bj5Var.g(), bj5Var.l(), bj5Var.i(), bj5Var.q(), bj5Var.j());
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

    public static List<nn> c(List<oi5> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (oi5 oi5Var : list) {
                if (oi5Var.c() == 3) {
                    ni5 ni5Var = new ni5();
                    ni5Var.h(oi5Var.a());
                    ni5Var.i(oi5Var.b());
                    arrayList.add(ni5Var);
                } else if (oi5Var.a() instanceof nn) {
                    arrayList.add((nn) oi5Var.a());
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<oi5> d(List<nn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (nn nnVar : list) {
                oi5 oi5Var = new oi5();
                if (nnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) nnVar;
                    if (threadData.getIs_top() == 1) {
                        oi5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        oi5Var.f(2);
                    } else {
                        oi5Var.f(4);
                    }
                    oi5Var.d(nnVar);
                } else if (nnVar instanceof ni5) {
                    oi5Var.f(3);
                    ni5 ni5Var = (ni5) nnVar;
                    oi5Var.e(ni5Var.d());
                    oi5Var.d(ni5Var.a());
                } else {
                    oi5Var.f(4);
                    oi5Var.d(nnVar);
                }
                arrayList.add(oi5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
