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
import com.repackage.ak5;
import com.repackage.bk5;
import com.repackage.ck5;
import com.repackage.fk5;
import com.repackage.gk5;
import com.repackage.hk5;
import com.repackage.ik5;
import com.repackage.jk5;
import com.repackage.ok5;
import com.repackage.on;
import com.repackage.vb8;
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
            ok5 ok5Var;
            gk5 c;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ok5) && (c = (ok5Var = (ok5) customResponsedMessage.getData()).c()) != null && (c instanceof vb8)) {
                vb8 vb8Var = (vb8) c;
                fk5 Q0 = c.Q0(1);
                if (Q0 == null) {
                    ik5 a = jk5.b().a(1);
                    if (a == null) {
                        return;
                    }
                    Q0 = a.a();
                    c.p0(1, Q0);
                    Q0.f(new hk5(vb8Var), ok5Var.i());
                }
                if (Q0 instanceof ck5) {
                    ck5 ck5Var = (ck5) Q0;
                    if (ok5Var.a() == 1) {
                        List list = (List) ok5Var.f();
                        ak5.b(ck5Var.d());
                        for (BdUniqueId bdUniqueId : ak5.c()) {
                            FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(vb8Var, bdUniqueId);
                            frsFeedAdAdapter.setPageContext(vb8Var.o());
                            list.add(frsFeedAdAdapter);
                        }
                    } else if (ok5Var.a() == 2) {
                        ck5Var.k(ok5Var.d());
                    } else if (ok5Var.a() == 3) {
                        List<on> o = ok5Var.o();
                        List<bk5> d = FrsFeedAdStatic.d(o);
                        if (ok5Var.q()) {
                            ck5Var.o(d, FrsFeedAdStatic.d(ok5Var.l()), ok5Var.p(), ok5Var.e());
                        } else {
                            ck5Var.i(d, ok5Var.e());
                        }
                        o.clear();
                        o.addAll(FrsFeedAdStatic.c(d));
                    } else if (ok5Var.a() == 4) {
                        ck5Var.a(ok5Var.n());
                    } else if (ok5Var.a() == 5) {
                        ck5Var.e(FrsFeedAdStatic.d(ok5Var.o()), ok5Var.h(), ok5Var.g(), ok5Var.m(), ok5Var.j(), ok5Var.r(), ok5Var.k());
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

    public static List<on> c(List<bk5> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (bk5 bk5Var : list) {
                if (bk5Var.c() == 3) {
                    ak5 ak5Var = new ak5();
                    ak5Var.h(bk5Var.a());
                    ak5Var.j(bk5Var.b());
                    arrayList.add(ak5Var);
                } else if (bk5Var.a() instanceof on) {
                    arrayList.add((on) bk5Var.a());
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<bk5> d(List<on> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (on onVar : list) {
                bk5 bk5Var = new bk5();
                if (onVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) onVar;
                    if (threadData.getIs_top() == 1) {
                        bk5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        bk5Var.f(2);
                    } else {
                        bk5Var.f(4);
                    }
                    bk5Var.d(onVar);
                } else if (onVar instanceof ak5) {
                    bk5Var.f(3);
                    ak5 ak5Var = (ak5) onVar;
                    bk5Var.e(ak5Var.f());
                    bk5Var.d(ak5Var.a());
                } else {
                    bk5Var.f(4);
                    bk5Var.d(onVar);
                }
                arrayList.add(bk5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
