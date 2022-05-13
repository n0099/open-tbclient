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
import com.repackage.ai5;
import com.repackage.bi5;
import com.repackage.ci5;
import com.repackage.ga8;
import com.repackage.hi5;
import com.repackage.ro;
import com.repackage.sh5;
import com.repackage.th5;
import com.repackage.uh5;
import com.repackage.vh5;
import com.repackage.yh5;
import com.repackage.zh5;
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
            hi5 hi5Var;
            zh5 c;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof hi5) && (c = (hi5Var = (hi5) customResponsedMessage.getData()).c()) != null && (c instanceof ga8)) {
                ga8 ga8Var = (ga8) c;
                yh5 injectPlugin = c.getInjectPlugin(1);
                if (injectPlugin == null) {
                    bi5 a = ci5.b().a(1);
                    if (a == null) {
                        return;
                    }
                    injectPlugin = a.a();
                    c.setInjectPlugin(1, injectPlugin);
                    injectPlugin.n(new ai5(ga8Var));
                }
                if (injectPlugin instanceof vh5) {
                    vh5 vh5Var = (vh5) injectPlugin;
                    if (hi5Var.a() == 1) {
                        List list = (List) hi5Var.f();
                        th5.b(vh5Var.c());
                        for (BdUniqueId bdUniqueId : th5.e()) {
                            sh5 sh5Var = new sh5(ga8Var, bdUniqueId);
                            sh5Var.Z(ga8Var.i());
                            list.add(sh5Var);
                        }
                    } else if (hi5Var.a() == 2) {
                        vh5Var.i(hi5Var.d());
                    } else if (hi5Var.a() == 3) {
                        List<ro> n = hi5Var.n();
                        List<uh5> d = FrsFeedAdStatic.d(n);
                        if (hi5Var.p()) {
                            vh5Var.m(d, FrsFeedAdStatic.d(hi5Var.k()), hi5Var.o(), hi5Var.e());
                        } else {
                            vh5Var.g(d, hi5Var.e());
                        }
                        n.clear();
                        n.addAll(FrsFeedAdStatic.c(d));
                    } else if (hi5Var.a() == 4) {
                        vh5Var.a(hi5Var.m());
                    } else if (hi5Var.a() == 5) {
                        vh5Var.d(FrsFeedAdStatic.d(hi5Var.n()), hi5Var.h(), hi5Var.g(), hi5Var.l(), hi5Var.i(), hi5Var.q(), hi5Var.j());
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

    public static List<ro> c(List<uh5> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (uh5 uh5Var : list) {
                if (uh5Var.c() == 3) {
                    th5 th5Var = new th5();
                    th5Var.i(uh5Var.a());
                    th5Var.j(uh5Var.b());
                    arrayList.add(th5Var);
                } else if (uh5Var.a() instanceof ro) {
                    arrayList.add((ro) uh5Var.a());
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<uh5> d(List<ro> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (ro roVar : list) {
                uh5 uh5Var = new uh5();
                if (roVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) roVar;
                    if (threadData.getIs_top() == 1) {
                        uh5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        uh5Var.f(2);
                    } else {
                        uh5Var.f(4);
                    }
                    uh5Var.d(roVar);
                } else if (roVar instanceof th5) {
                    uh5Var.f(3);
                    th5 th5Var = (th5) roVar;
                    uh5Var.e(th5Var.f());
                    uh5Var.d(th5Var.a());
                } else {
                    uh5Var.f(4);
                    uh5Var.d(roVar);
                }
                arrayList.add(uh5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
