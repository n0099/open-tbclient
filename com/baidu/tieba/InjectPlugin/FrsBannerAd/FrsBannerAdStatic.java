package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ao;
import com.baidu.tieba.b56;
import com.baidu.tieba.g56;
import com.baidu.tieba.h56;
import com.baidu.tieba.i56;
import com.baidu.tieba.j56;
import com.baidu.tieba.k56;
import com.baidu.tieba.l56;
import com.baidu.tieba.o56;
import com.baidu.tieba.p56;
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
        public class C0231a implements b56.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0231a(a aVar) {
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

            @Override // com.baidu.tieba.b56.a
            public void a(j56 j56Var, View view2) {
                i56 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, j56Var, view2) == null) && (a = o56.a(j56Var)) != null) {
                    g56 g56Var = new g56();
                    g56Var.a = 2;
                    g56Var.b(view2);
                    a.S(g56Var);
                }
            }

            @Override // com.baidu.tieba.b56.a
            public void b(j56 j56Var, View view2) {
                i56 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j56Var, view2) == null) && (a = o56.a(j56Var)) != null) {
                    g56 g56Var = new g56();
                    g56Var.a = 3;
                    g56Var.b(view2);
                    a.S(g56Var);
                }
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
            p56 p56Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof p56) || (b = (p56Var = (p56) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof i56)) {
                return;
            }
            i56 i56Var = (i56) b.getPageActivity();
            h56 d1 = i56Var.d1(2);
            if (d1 == null) {
                k56 a = l56.b().a(2);
                if (a == null) {
                    return;
                }
                d1 = a.a();
                i56Var.A0(2, d1);
                d1.f(new j56(b), null);
                if (!(d1 instanceof b56)) {
                    return;
                }
                ((b56) d1).h(new C0231a(this));
            }
            if (!(d1 instanceof b56)) {
                return;
            }
            b56 b56Var = (b56) d1;
            if (p56Var.a() == 1) {
                b56Var.b(p56Var.g());
                b56Var.c(p56Var.d());
                b56Var.j();
            } else if (p56Var.a() == 2) {
                b56Var.l(p56Var.f());
            } else if (p56Var.a() == 3) {
                ao e = p56Var.e();
                if (e != null && b56Var.getView() != null) {
                    e.removeHeaderView(b56Var.getView());
                }
            } else if (p56Var.a() == 4) {
                b56Var.a(p56Var.h());
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
