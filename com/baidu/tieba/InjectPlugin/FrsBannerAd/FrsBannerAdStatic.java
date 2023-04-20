package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.dx5;
import com.baidu.tieba.ex5;
import com.baidu.tieba.fx5;
import com.baidu.tieba.gx5;
import com.baidu.tieba.hx5;
import com.baidu.tieba.ix5;
import com.baidu.tieba.kn;
import com.baidu.tieba.lx5;
import com.baidu.tieba.mx5;
import com.baidu.tieba.yw5;
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
        public class C0205a implements yw5.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0205a(a aVar) {
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

            @Override // com.baidu.tieba.yw5.a
            public void a(gx5 gx5Var, View view2) {
                fx5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, gx5Var, view2) == null) && (a = lx5.a(gx5Var)) != null) {
                    dx5 dx5Var = new dx5();
                    dx5Var.a = 2;
                    dx5Var.b(view2);
                    a.T(dx5Var);
                }
            }

            @Override // com.baidu.tieba.yw5.a
            public void b(gx5 gx5Var, View view2) {
                fx5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gx5Var, view2) == null) && (a = lx5.a(gx5Var)) != null) {
                    dx5 dx5Var = new dx5();
                    dx5Var.a = 3;
                    dx5Var.b(view2);
                    a.T(dx5Var);
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
            mx5 mx5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof mx5) || (b = (mx5Var = (mx5) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof fx5)) {
                return;
            }
            fx5 fx5Var = (fx5) b.getPageActivity();
            ex5 b1 = fx5Var.b1(2);
            if (b1 == null) {
                hx5 a = ix5.b().a(2);
                if (a == null) {
                    return;
                }
                b1 = a.a();
                fx5Var.A0(2, b1);
                b1.f(new gx5(b), null);
                if (!(b1 instanceof yw5)) {
                    return;
                }
                ((yw5) b1).h(new C0205a(this));
            }
            if (!(b1 instanceof yw5)) {
                return;
            }
            yw5 yw5Var = (yw5) b1;
            if (mx5Var.a() == 1) {
                yw5Var.b(mx5Var.g());
                yw5Var.c(mx5Var.d());
                yw5Var.j();
            } else if (mx5Var.a() == 2) {
                yw5Var.l(mx5Var.f());
            } else if (mx5Var.a() == 3) {
                kn e = mx5Var.e();
                if (e != null && yw5Var.getView() != null) {
                    e.removeHeaderView(yw5Var.getView());
                }
            } else if (mx5Var.a() == 4) {
                yw5Var.a(mx5Var.h());
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
