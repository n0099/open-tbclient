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
import com.repackage.bh5;
import com.repackage.jn;
import com.repackage.mg5;
import com.repackage.n78;
import com.repackage.ng5;
import com.repackage.og5;
import com.repackage.pg5;
import com.repackage.sg5;
import com.repackage.tg5;
import com.repackage.ug5;
import com.repackage.vg5;
import com.repackage.wg5;
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
            bh5 bh5Var;
            tg5 c;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh5) && (c = (bh5Var = (bh5) customResponsedMessage.getData()).c()) != null && (c instanceof n78)) {
                n78 n78Var = (n78) c;
                sg5 injectPlugin = c.getInjectPlugin(1);
                if (injectPlugin == null) {
                    vg5 a = wg5.b().a(1);
                    if (a == null) {
                        return;
                    }
                    injectPlugin = a.a();
                    c.setInjectPlugin(1, injectPlugin);
                    injectPlugin.n(new ug5(n78Var));
                }
                if (injectPlugin instanceof pg5) {
                    pg5 pg5Var = (pg5) injectPlugin;
                    if (bh5Var.a() == 1) {
                        List list = (List) bh5Var.f();
                        ng5.b(pg5Var.c());
                        for (BdUniqueId bdUniqueId : ng5.e()) {
                            mg5 mg5Var = new mg5(n78Var, bdUniqueId);
                            mg5Var.Z(n78Var.i());
                            list.add(mg5Var);
                        }
                    } else if (bh5Var.a() == 2) {
                        pg5Var.i(bh5Var.d());
                    } else if (bh5Var.a() == 3) {
                        List<jn> n = bh5Var.n();
                        List<og5> d = FrsFeedAdStatic.d(n);
                        if (bh5Var.p()) {
                            pg5Var.m(d, FrsFeedAdStatic.d(bh5Var.k()), bh5Var.o(), bh5Var.e());
                        } else {
                            pg5Var.g(d, bh5Var.e());
                        }
                        n.clear();
                        n.addAll(FrsFeedAdStatic.c(d));
                    } else if (bh5Var.a() == 4) {
                        pg5Var.a(bh5Var.m());
                    } else if (bh5Var.a() == 5) {
                        pg5Var.d(FrsFeedAdStatic.d(bh5Var.n()), bh5Var.h(), bh5Var.g(), bh5Var.l(), bh5Var.i(), bh5Var.q(), bh5Var.j());
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

    public static List<jn> c(List<og5> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (og5 og5Var : list) {
                if (og5Var.c() == 3) {
                    ng5 ng5Var = new ng5();
                    ng5Var.i(og5Var.a());
                    ng5Var.j(og5Var.b());
                    arrayList.add(ng5Var);
                } else if (og5Var.a() instanceof jn) {
                    arrayList.add((jn) og5Var.a());
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<og5> d(List<jn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (jn jnVar : list) {
                og5 og5Var = new og5();
                if (jnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) jnVar;
                    if (threadData.getIs_top() == 1) {
                        og5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        og5Var.f(2);
                    } else {
                        og5Var.f(4);
                    }
                    og5Var.d(jnVar);
                } else if (jnVar instanceof ng5) {
                    og5Var.f(3);
                    ng5 ng5Var = (ng5) jnVar;
                    og5Var.e(ng5Var.f());
                    og5Var.d(ng5Var.a());
                } else {
                    og5Var.f(4);
                    og5Var.d(jnVar);
                }
                arrayList.add(og5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
