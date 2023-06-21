package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.a46;
import com.baidu.tieba.b46;
import com.baidu.tieba.c46;
import com.baidu.tieba.f46;
import com.baidu.tieba.g46;
import com.baidu.tieba.s36;
import com.baidu.tieba.x36;
import com.baidu.tieba.y36;
import com.baidu.tieba.yn;
import com.baidu.tieba.z36;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FrsBannerAdStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.InjectPlugin.FrsBannerAd.FrsBannerAdStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0231a implements s36.a {
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

            @Override // com.baidu.tieba.s36.a
            public void a(a46 a46Var, View view2) {
                z36 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, a46Var, view2) == null) && (a = f46.a(a46Var)) != null) {
                    x36 x36Var = new x36();
                    x36Var.a = 2;
                    x36Var.b(view2);
                    a.T(x36Var);
                }
            }

            @Override // com.baidu.tieba.s36.a
            public void b(a46 a46Var, View view2) {
                z36 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a46Var, view2) == null) && (a = f46.a(a46Var)) != null) {
                    x36 x36Var = new x36();
                    x36Var.a = 3;
                    x36Var.b(view2);
                    a.T(x36Var);
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
            g46 g46Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof g46) || (b = (g46Var = (g46) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof z36)) {
                return;
            }
            z36 z36Var = (z36) b.getPageActivity();
            y36 d1 = z36Var.d1(2);
            if (d1 == null) {
                b46 a = c46.b().a(2);
                if (a == null) {
                    return;
                }
                d1 = a.a();
                z36Var.A0(2, d1);
                d1.f(new a46(b), null);
                if (!(d1 instanceof s36)) {
                    return;
                }
                ((s36) d1).h(new C0231a(this));
            }
            if (!(d1 instanceof s36)) {
                return;
            }
            s36 s36Var = (s36) d1;
            if (g46Var.a() == 1) {
                s36Var.b(g46Var.g());
                s36Var.c(g46Var.d());
                s36Var.j();
            } else if (g46Var.a() == 2) {
                s36Var.l(g46Var.f());
            } else if (g46Var.a() == 3) {
                yn e = g46Var.e();
                if (e != null && s36Var.getView() != null) {
                    e.removeHeaderView(s36Var.getView());
                }
            } else if (g46Var.a() == 4) {
                s36Var.a(g46Var.h());
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
