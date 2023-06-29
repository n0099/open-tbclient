package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.c46;
import com.baidu.tieba.d46;
import com.baidu.tieba.e46;
import com.baidu.tieba.f46;
import com.baidu.tieba.g46;
import com.baidu.tieba.h46;
import com.baidu.tieba.k46;
import com.baidu.tieba.l46;
import com.baidu.tieba.x36;
import com.baidu.tieba.zn;
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
        public class C0231a implements x36.a {
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

            @Override // com.baidu.tieba.x36.a
            public void a(f46 f46Var, View view2) {
                e46 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, f46Var, view2) == null) && (a = k46.a(f46Var)) != null) {
                    c46 c46Var = new c46();
                    c46Var.a = 2;
                    c46Var.b(view2);
                    a.T(c46Var);
                }
            }

            @Override // com.baidu.tieba.x36.a
            public void b(f46 f46Var, View view2) {
                e46 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f46Var, view2) == null) && (a = k46.a(f46Var)) != null) {
                    c46 c46Var = new c46();
                    c46Var.a = 3;
                    c46Var.b(view2);
                    a.T(c46Var);
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
            l46 l46Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof l46) || (b = (l46Var = (l46) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof e46)) {
                return;
            }
            e46 e46Var = (e46) b.getPageActivity();
            d46 d1 = e46Var.d1(2);
            if (d1 == null) {
                g46 a = h46.b().a(2);
                if (a == null) {
                    return;
                }
                d1 = a.a();
                e46Var.A0(2, d1);
                d1.f(new f46(b), null);
                if (!(d1 instanceof x36)) {
                    return;
                }
                ((x36) d1).h(new C0231a(this));
            }
            if (!(d1 instanceof x36)) {
                return;
            }
            x36 x36Var = (x36) d1;
            if (l46Var.a() == 1) {
                x36Var.b(l46Var.g());
                x36Var.c(l46Var.d());
                x36Var.j();
            } else if (l46Var.a() == 2) {
                x36Var.l(l46Var.f());
            } else if (l46Var.a() == 3) {
                zn e = l46Var.e();
                if (e != null && x36Var.getView() != null) {
                    e.removeHeaderView(x36Var.getView());
                }
            } else if (l46Var.a() == 4) {
                x36Var.a(l46Var.h());
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
