package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.b46;
import com.baidu.tieba.c46;
import com.baidu.tieba.d46;
import com.baidu.tieba.e46;
import com.baidu.tieba.en;
import com.baidu.tieba.f46;
import com.baidu.tieba.g46;
import com.baidu.tieba.j46;
import com.baidu.tieba.k46;
import com.baidu.tieba.w36;
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
        public class C0221a implements w36.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0221a(a aVar) {
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

            @Override // com.baidu.tieba.w36.a
            public void a(e46 e46Var, View view2) {
                d46 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, e46Var, view2) == null) && (a = j46.a(e46Var)) != null) {
                    b46 b46Var = new b46();
                    b46Var.a = 2;
                    b46Var.b(view2);
                    a.Z(b46Var);
                }
            }

            @Override // com.baidu.tieba.w36.a
            public void b(e46 e46Var, View view2) {
                d46 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e46Var, view2) == null) && (a = j46.a(e46Var)) != null) {
                    b46 b46Var = new b46();
                    b46Var.a = 3;
                    b46Var.b(view2);
                    a.Z(b46Var);
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
            k46 k46Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof k46) || (b = (k46Var = (k46) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof d46)) {
                return;
            }
            d46 d46Var = (d46) b.getPageActivity();
            c46 o1 = d46Var.o1(2);
            if (o1 == null) {
                f46 a = g46.b().a(2);
                if (a == null) {
                    return;
                }
                o1 = a.a();
                d46Var.J0(2, o1);
                o1.f(new e46(b), null);
                if (!(o1 instanceof w36)) {
                    return;
                }
                ((w36) o1).h(new C0221a(this));
            }
            if (!(o1 instanceof w36)) {
                return;
            }
            w36 w36Var = (w36) o1;
            if (k46Var.a() == 1) {
                w36Var.b(k46Var.g());
                w36Var.c(k46Var.d());
                w36Var.j();
            } else if (k46Var.a() == 2) {
                w36Var.l(k46Var.f());
            } else if (k46Var.a() == 3) {
                en e = k46Var.e();
                if (e != null && w36Var.getView() != null) {
                    e.removeHeaderView(w36Var.getView());
                }
            } else if (k46Var.a() == 4) {
                w36Var.a(k46Var.h());
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
