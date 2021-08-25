package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.p0.s.q.c2;
import c.a.q0.f.e.c;
import c.a.q0.f.e.d;
import c.a.q0.f.e.e;
import c.a.q0.f.f.b;
import c.a.q0.x2.u;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class FrsFeedAdStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            b bVar;
            c.a.q0.f.e.b c2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b) && (c2 = (bVar = (b) customResponsedMessage.getData()).c()) != null && (c2 instanceof u)) {
                u uVar = (u) c2;
                c.a.q0.f.e.a injectPlugin = c2.getInjectPlugin(1);
                if (injectPlugin == null) {
                    d a2 = e.b().a(1);
                    if (a2 == null) {
                        return;
                    }
                    injectPlugin = a2.a();
                    c2.setInjectPlugin(1, injectPlugin);
                    injectPlugin.o(new c(uVar));
                }
                if (injectPlugin instanceof c.a.q0.f.b.d) {
                    c.a.q0.f.b.d dVar = (c.a.q0.f.b.d) injectPlugin;
                    if (bVar.a() == 1) {
                        List list = (List) bVar.f();
                        c.a.q0.f.b.b.c(dVar.d());
                        for (BdUniqueId bdUniqueId : c.a.q0.f.b.b.d()) {
                            c.a.q0.f.b.a aVar = new c.a.q0.f.b.a(uVar, bdUniqueId);
                            aVar.h0(uVar.getTbPageContext());
                            list.add(aVar);
                        }
                    } else if (bVar.a() == 2) {
                        dVar.j(bVar.d());
                    } else if (bVar.a() == 3) {
                        List<n> n = bVar.n();
                        List<c.a.q0.f.b.c> d2 = FrsFeedAdStatic.d(n);
                        if (bVar.p()) {
                            dVar.n(d2, FrsFeedAdStatic.d(bVar.k()), bVar.o(), bVar.e());
                        } else {
                            dVar.h(d2, bVar.e());
                        }
                        n.clear();
                        n.addAll(FrsFeedAdStatic.c(d2));
                    } else if (bVar.a() == 4) {
                        dVar.a(bVar.m());
                    } else if (bVar.a() == 5) {
                        dVar.e(FrsFeedAdStatic.d(bVar.n()), bVar.h(), bVar.g(), bVar.l(), bVar.i(), bVar.q(), bVar.j());
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static List<n> c(List<c.a.q0.f.b.c> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (c.a.q0.f.b.c cVar : list) {
                if (cVar.c() == 3) {
                    c.a.q0.f.b.b bVar = new c.a.q0.f.b.b();
                    bVar.i(cVar.a());
                    bVar.k(cVar.b());
                    arrayList.add(bVar);
                } else if (cVar.a() instanceof n) {
                    arrayList.add((n) cVar.a());
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<c.a.q0.f.b.c> d(List<n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (n nVar : list) {
                c.a.q0.f.b.c cVar = new c.a.q0.f.b.c();
                if (nVar instanceof c2) {
                    c2 c2Var = (c2) nVar;
                    if (c2Var.p0() == 1) {
                        cVar.f(1);
                    } else if (c2Var.p0() == 0) {
                        cVar.f(2);
                    } else {
                        cVar.f(4);
                    }
                    cVar.d(nVar);
                } else if (nVar instanceof c.a.q0.f.b.b) {
                    cVar.f(3);
                    c.a.q0.f.b.b bVar = (c.a.q0.f.b.b) nVar;
                    cVar.e(bVar.g());
                    cVar.d(bVar.b());
                } else {
                    cVar.f(4);
                    cVar.d(nVar);
                }
                arrayList.add(cVar);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
