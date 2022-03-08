package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import c.a.d.o.e.p;
import c.a.r0.h.a.a;
import c.a.r0.h.d;
import c.a.r0.h.e.b;
import c.a.r0.h.e.c;
import c.a.r0.h.e.e;
import c.a.r0.h.e.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsBannerAdStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.InjectPlugin.FrsBannerAd.FrsBannerAdStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1893a implements a.InterfaceC1111a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1893a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.r0.h.a.a.InterfaceC1111a
            public void a(c cVar, View view) {
                b a;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(1048576, this, cVar, view) == null) || (a = h.a(cVar)) == null) {
                    return;
                }
                d dVar = new d();
                dVar.a = 2;
                dVar.b(view);
                a.dispatchInjectPluginMessage(dVar);
            }

            @Override // c.a.r0.h.a.a.InterfaceC1111a
            public void b(c cVar, View view) {
                b a;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, view) == null) || (a = h.a(cVar)) == null) {
                    return;
                }
                d dVar = new d();
                dVar.a = 3;
                dVar.b(view);
                a.dispatchInjectPluginMessage(dVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super(2016516);
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
            c.a.r0.h.f.a aVar;
            TbPageContext b2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.r0.h.f.a) && (b2 = (aVar = (c.a.r0.h.f.a) customResponsedMessage.getData()).b()) != null && (b2.getPageActivity() instanceof b)) {
                b bVar = (b) b2.getPageActivity();
                c.a.r0.h.e.a injectPlugin = bVar.getInjectPlugin(2);
                if (injectPlugin == null) {
                    c.a.r0.h.e.d a = e.b().a(2);
                    if (a == null) {
                        return;
                    }
                    injectPlugin = a.a();
                    bVar.setInjectPlugin(2, injectPlugin);
                    injectPlugin.n(new c(b2));
                    if (!(injectPlugin instanceof c.a.r0.h.a.a)) {
                        return;
                    }
                    ((c.a.r0.h.a.a) injectPlugin).f(new C1893a(this));
                }
                if (injectPlugin instanceof c.a.r0.h.a.a) {
                    c.a.r0.h.a.a aVar2 = (c.a.r0.h.a.a) injectPlugin;
                    if (aVar.a() == 1) {
                        aVar2.setParams(aVar.g());
                        aVar2.b(aVar.d());
                        aVar2.h();
                    } else if (aVar.a() == 2) {
                        aVar2.j(aVar.f());
                    } else if (aVar.a() == 3) {
                        p e2 = aVar.e();
                        if (e2 == null || aVar2.getView() == null) {
                            return;
                        }
                        e2.removeHeaderView(aVar2.getView());
                    } else if (aVar.a() == 4) {
                        aVar2.a(aVar.h());
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2090574029, "Lcom/baidu/tieba/InjectPlugin/FrsBannerAd/FrsBannerAdStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2090574029, "Lcom/baidu/tieba/InjectPlugin/FrsBannerAd/FrsBannerAdStatic;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new a());
    }

    public FrsBannerAdStatic() {
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
}
