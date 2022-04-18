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
import com.repackage.ah5;
import com.repackage.bh5;
import com.repackage.ch5;
import com.repackage.fh5;
import com.repackage.gh5;
import com.repackage.hh5;
import com.repackage.ia8;
import com.repackage.ih5;
import com.repackage.jh5;
import com.repackage.oh5;
import com.repackage.uo;
import com.repackage.zg5;
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
            oh5 oh5Var;
            gh5 c;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof oh5) && (c = (oh5Var = (oh5) customResponsedMessage.getData()).c()) != null && (c instanceof ia8)) {
                ia8 ia8Var = (ia8) c;
                fh5 injectPlugin = c.getInjectPlugin(1);
                if (injectPlugin == null) {
                    ih5 a = jh5.b().a(1);
                    if (a == null) {
                        return;
                    }
                    injectPlugin = a.a();
                    c.setInjectPlugin(1, injectPlugin);
                    injectPlugin.n(new hh5(ia8Var));
                }
                if (injectPlugin instanceof ch5) {
                    ch5 ch5Var = (ch5) injectPlugin;
                    if (oh5Var.a() == 1) {
                        List list = (List) oh5Var.f();
                        ah5.b(ch5Var.c());
                        for (BdUniqueId bdUniqueId : ah5.e()) {
                            zg5 zg5Var = new zg5(ia8Var, bdUniqueId);
                            zg5Var.Z(ia8Var.i());
                            list.add(zg5Var);
                        }
                    } else if (oh5Var.a() == 2) {
                        ch5Var.i(oh5Var.d());
                    } else if (oh5Var.a() == 3) {
                        List<uo> n = oh5Var.n();
                        List<bh5> d = FrsFeedAdStatic.d(n);
                        if (oh5Var.p()) {
                            ch5Var.m(d, FrsFeedAdStatic.d(oh5Var.k()), oh5Var.o(), oh5Var.e());
                        } else {
                            ch5Var.g(d, oh5Var.e());
                        }
                        n.clear();
                        n.addAll(FrsFeedAdStatic.c(d));
                    } else if (oh5Var.a() == 4) {
                        ch5Var.a(oh5Var.m());
                    } else if (oh5Var.a() == 5) {
                        ch5Var.d(FrsFeedAdStatic.d(oh5Var.n()), oh5Var.h(), oh5Var.g(), oh5Var.l(), oh5Var.i(), oh5Var.q(), oh5Var.j());
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

    public static List<uo> c(List<bh5> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (bh5 bh5Var : list) {
                if (bh5Var.c() == 3) {
                    ah5 ah5Var = new ah5();
                    ah5Var.i(bh5Var.a());
                    ah5Var.j(bh5Var.b());
                    arrayList.add(ah5Var);
                } else if (bh5Var.a() instanceof uo) {
                    arrayList.add((uo) bh5Var.a());
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<bh5> d(List<uo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (uo uoVar : list) {
                bh5 bh5Var = new bh5();
                if (uoVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) uoVar;
                    if (threadData.getIs_top() == 1) {
                        bh5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        bh5Var.f(2);
                    } else {
                        bh5Var.f(4);
                    }
                    bh5Var.d(uoVar);
                } else if (uoVar instanceof ah5) {
                    bh5Var.f(3);
                    ah5 ah5Var = (ah5) uoVar;
                    bh5Var.e(ah5Var.f());
                    bh5Var.d(ah5Var.a());
                } else {
                    bh5Var.f(4);
                    bh5Var.d(uoVar);
                }
                arrayList.add(bh5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
