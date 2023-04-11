package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.cx5;
import com.baidu.tieba.dx5;
import com.baidu.tieba.ex5;
import com.baidu.tieba.fx5;
import com.baidu.tieba.gx5;
import com.baidu.tieba.hx5;
import com.baidu.tieba.jn;
import com.baidu.tieba.kx5;
import com.baidu.tieba.lx5;
import com.baidu.tieba.xw5;
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
        public class C0205a implements xw5.a {
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

            @Override // com.baidu.tieba.xw5.a
            public void a(fx5 fx5Var, View view2) {
                ex5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, fx5Var, view2) == null) && (a = kx5.a(fx5Var)) != null) {
                    cx5 cx5Var = new cx5();
                    cx5Var.a = 2;
                    cx5Var.b(view2);
                    a.T(cx5Var);
                }
            }

            @Override // com.baidu.tieba.xw5.a
            public void b(fx5 fx5Var, View view2) {
                ex5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fx5Var, view2) == null) && (a = kx5.a(fx5Var)) != null) {
                    cx5 cx5Var = new cx5();
                    cx5Var.a = 3;
                    cx5Var.b(view2);
                    a.T(cx5Var);
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
            lx5 lx5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof lx5) || (b = (lx5Var = (lx5) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof ex5)) {
                return;
            }
            ex5 ex5Var = (ex5) b.getPageActivity();
            dx5 b1 = ex5Var.b1(2);
            if (b1 == null) {
                gx5 a = hx5.b().a(2);
                if (a == null) {
                    return;
                }
                b1 = a.a();
                ex5Var.A0(2, b1);
                b1.f(new fx5(b), null);
                if (!(b1 instanceof xw5)) {
                    return;
                }
                ((xw5) b1).h(new C0205a(this));
            }
            if (!(b1 instanceof xw5)) {
                return;
            }
            xw5 xw5Var = (xw5) b1;
            if (lx5Var.a() == 1) {
                xw5Var.b(lx5Var.g());
                xw5Var.c(lx5Var.d());
                xw5Var.j();
            } else if (lx5Var.a() == 2) {
                xw5Var.l(lx5Var.f());
            } else if (lx5Var.a() == 3) {
                jn e = lx5Var.e();
                if (e != null && xw5Var.getView() != null) {
                    e.removeHeaderView(xw5Var.getView());
                }
            } else if (lx5Var.a() == 4) {
                xw5Var.a(lx5Var.h());
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
