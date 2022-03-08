package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.q0.r.r.e2;
import c.a.r0.h.e.c;
import c.a.r0.h.e.d;
import c.a.r0.h.e.e;
import c.a.r0.h.f.b;
import c.a.r0.j3.v;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class FrsFeedAdStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
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
            c.a.r0.h.e.b c2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b) && (c2 = (bVar = (b) customResponsedMessage.getData()).c()) != null && (c2 instanceof v)) {
                v vVar = (v) c2;
                c.a.r0.h.e.a injectPlugin = c2.getInjectPlugin(1);
                if (injectPlugin == null) {
                    d a = e.b().a(1);
                    if (a == null) {
                        return;
                    }
                    injectPlugin = a.a();
                    c2.setInjectPlugin(1, injectPlugin);
                    injectPlugin.n(new c(vVar));
                }
                if (injectPlugin instanceof c.a.r0.h.b.d) {
                    c.a.r0.h.b.d dVar = (c.a.r0.h.b.d) injectPlugin;
                    if (bVar.a() == 1) {
                        List list = (List) bVar.f();
                        c.a.r0.h.b.b.d(dVar.c());
                        for (BdUniqueId bdUniqueId : c.a.r0.h.b.b.e()) {
                            c.a.r0.h.b.a aVar = new c.a.r0.h.b.a(vVar, bdUniqueId);
                            aVar.Z(vVar.getTbPageContext());
                            list.add(aVar);
                        }
                    } else if (bVar.a() == 2) {
                        dVar.i(bVar.d());
                    } else if (bVar.a() == 3) {
                        List<n> n = bVar.n();
                        List<c.a.r0.h.b.c> d2 = FrsFeedAdStatic.d(n);
                        if (bVar.p()) {
                            dVar.m(d2, FrsFeedAdStatic.d(bVar.k()), bVar.o(), bVar.e());
                        } else {
                            dVar.g(d2, bVar.e());
                        }
                        n.clear();
                        n.addAll(FrsFeedAdStatic.c(d2));
                    } else if (bVar.a() == 4) {
                        dVar.a(bVar.m());
                    } else if (bVar.a() == 5) {
                        dVar.d(FrsFeedAdStatic.d(bVar.n()), bVar.h(), bVar.g(), bVar.l(), bVar.i(), bVar.q(), bVar.j());
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

    public static List<n> c(List<c.a.r0.h.b.c> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (c.a.r0.h.b.c cVar : list) {
                if (cVar.c() == 3) {
                    c.a.r0.h.b.b bVar = new c.a.r0.h.b.b();
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

    public static List<c.a.r0.h.b.c> d(List<n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (n nVar : list) {
                c.a.r0.h.b.c cVar = new c.a.r0.h.b.c();
                if (nVar instanceof e2) {
                    e2 e2Var = (e2) nVar;
                    if (e2Var.t0() == 1) {
                        cVar.f(1);
                    } else if (e2Var.t0() == 0) {
                        cVar.f(2);
                    } else {
                        cVar.f(4);
                    }
                    cVar.d(nVar);
                } else if (nVar instanceof c.a.r0.h.b.b) {
                    cVar.f(3);
                    c.a.r0.h.b.b bVar = (c.a.r0.h.b.b) nVar;
                    cVar.e(bVar.g());
                    cVar.d(bVar.a());
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
