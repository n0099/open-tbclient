package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.bn5;
import com.baidu.tieba.fo;
import com.baidu.tieba.gn5;
import com.baidu.tieba.hn5;
import com.baidu.tieba.in5;
import com.baidu.tieba.jn5;
import com.baidu.tieba.kn5;
import com.baidu.tieba.ln5;
import com.baidu.tieba.on5;
import com.baidu.tieba.pn5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
        public class C0194a implements bn5.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0194a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.bn5.a
            public void a(jn5 jn5Var, View view2) {
                in5 a;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(1048576, this, jn5Var, view2) == null) || (a = on5.a(jn5Var)) == null) {
                    return;
                }
                gn5 gn5Var = new gn5();
                gn5Var.a = 2;
                gn5Var.b(view2);
                a.M(gn5Var);
            }

            @Override // com.baidu.tieba.bn5.a
            public void b(jn5 jn5Var, View view2) {
                in5 a;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jn5Var, view2) == null) || (a = on5.a(jn5Var)) == null) {
                    return;
                }
                gn5 gn5Var = new gn5();
                gn5Var.a = 3;
                gn5Var.b(view2);
                a.M(gn5Var);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super(2016516);
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
            pn5 pn5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof pn5) && (b = (pn5Var = (pn5) customResponsedMessage.getData()).b()) != null && (b.getPageActivity() instanceof in5)) {
                in5 in5Var = (in5) b.getPageActivity();
                hn5 P0 = in5Var.P0(2);
                if (P0 == null) {
                    kn5 a = ln5.b().a(2);
                    if (a == null) {
                        return;
                    }
                    P0 = a.a();
                    in5Var.o0(2, P0);
                    P0.f(new jn5(b), null);
                    if (!(P0 instanceof bn5)) {
                        return;
                    }
                    ((bn5) P0).h(new C0194a(this));
                }
                if (P0 instanceof bn5) {
                    bn5 bn5Var = (bn5) P0;
                    if (pn5Var.a() == 1) {
                        bn5Var.b(pn5Var.g());
                        bn5Var.c(pn5Var.d());
                        bn5Var.j();
                    } else if (pn5Var.a() == 2) {
                        bn5Var.l(pn5Var.f());
                    } else if (pn5Var.a() == 3) {
                        fo e = pn5Var.e();
                        if (e == null || bn5Var.getView() == null) {
                            return;
                        }
                        e.removeHeaderView(bn5Var.getView());
                    } else if (pn5Var.a() == 4) {
                        bn5Var.a(pn5Var.h());
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
