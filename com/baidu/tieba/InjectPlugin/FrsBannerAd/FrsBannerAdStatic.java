package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.av5;
import com.baidu.tieba.bv5;
import com.baidu.tieba.cv5;
import com.baidu.tieba.dv5;
import com.baidu.tieba.ev5;
import com.baidu.tieba.fo;
import com.baidu.tieba.hv5;
import com.baidu.tieba.iv5;
import com.baidu.tieba.uu5;
import com.baidu.tieba.zu5;
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
        public class C0218a implements uu5.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0218a(a aVar) {
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

            @Override // com.baidu.tieba.uu5.a
            public void a(cv5 cv5Var, View view2) {
                bv5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, cv5Var, view2) == null) && (a = hv5.a(cv5Var)) != null) {
                    zu5 zu5Var = new zu5();
                    zu5Var.a = 2;
                    zu5Var.b(view2);
                    a.Q(zu5Var);
                }
            }

            @Override // com.baidu.tieba.uu5.a
            public void b(cv5 cv5Var, View view2) {
                bv5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cv5Var, view2) == null) && (a = hv5.a(cv5Var)) != null) {
                    zu5 zu5Var = new zu5();
                    zu5Var.a = 3;
                    zu5Var.b(view2);
                    a.Q(zu5Var);
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
            iv5 iv5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof iv5) || (b = (iv5Var = (iv5) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof bv5)) {
                return;
            }
            bv5 bv5Var = (bv5) b.getPageActivity();
            av5 Z0 = bv5Var.Z0(2);
            if (Z0 == null) {
                dv5 a = ev5.b().a(2);
                if (a == null) {
                    return;
                }
                Z0 = a.a();
                bv5Var.x0(2, Z0);
                Z0.f(new cv5(b), null);
                if (!(Z0 instanceof uu5)) {
                    return;
                }
                ((uu5) Z0).h(new C0218a(this));
            }
            if (!(Z0 instanceof uu5)) {
                return;
            }
            uu5 uu5Var = (uu5) Z0;
            if (iv5Var.a() == 1) {
                uu5Var.b(iv5Var.g());
                uu5Var.c(iv5Var.d());
                uu5Var.j();
            } else if (iv5Var.a() == 2) {
                uu5Var.l(iv5Var.f());
            } else if (iv5Var.a() == 3) {
                fo e = iv5Var.e();
                if (e != null && uu5Var.getView() != null) {
                    e.removeHeaderView(uu5Var.getView());
                }
            } else if (iv5Var.a() == 4) {
                uu5Var.a(iv5Var.h());
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
