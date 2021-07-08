package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
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
import d.a.c.k.e.p;
import d.a.p0.e.a.a;
import d.a.p0.e.d;
import d.a.p0.e.e.b;
import d.a.p0.e.e.c;
import d.a.p0.e.e.e;
import d.a.p0.e.e.h;
/* loaded from: classes3.dex */
public class FrsBannerAdStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.InjectPlugin.FrsBannerAd.FrsBannerAdStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0189a implements a.InterfaceC1321a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0189a(a aVar) {
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

            @Override // d.a.p0.e.a.a.InterfaceC1321a
            public void a(c cVar, View view) {
                b a2;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(1048576, this, cVar, view) == null) || (a2 = h.a(cVar)) == null) {
                    return;
                }
                d dVar = new d();
                dVar.f55006a = 2;
                dVar.b(view);
                a2.dispatchInjectPluginMessage(dVar);
            }

            @Override // d.a.p0.e.a.a.InterfaceC1321a
            public void b(c cVar, View view) {
                b a2;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, view) == null) || (a2 = h.a(cVar)) == null) {
                    return;
                }
                d dVar = new d();
                dVar.f55006a = 3;
                dVar.b(view);
                a2.dispatchInjectPluginMessage(dVar);
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
            d.a.p0.e.f.a aVar;
            TbPageContext b2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.p0.e.f.a) && (b2 = (aVar = (d.a.p0.e.f.a) customResponsedMessage.getData()).b()) != null && (b2.getPageActivity() instanceof b)) {
                b bVar = (b) b2.getPageActivity();
                d.a.p0.e.e.a injectPlugin = bVar.getInjectPlugin(2);
                if (injectPlugin == null) {
                    d.a.p0.e.e.d a2 = e.b().a(2);
                    if (a2 == null) {
                        return;
                    }
                    injectPlugin = a2.a();
                    bVar.setInjectPlugin(2, injectPlugin);
                    injectPlugin.o(new c(b2));
                    if (!(injectPlugin instanceof d.a.p0.e.a.a)) {
                        return;
                    }
                    ((d.a.p0.e.a.a) injectPlugin).g(new C0189a(this));
                }
                if (injectPlugin instanceof d.a.p0.e.a.a) {
                    d.a.p0.e.a.a aVar2 = (d.a.p0.e.a.a) injectPlugin;
                    if (aVar.a() == 1) {
                        aVar2.b(aVar.g());
                        aVar2.c(aVar.d());
                        aVar2.i();
                    } else if (aVar.a() == 2) {
                        aVar2.k(aVar.f());
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
