package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.a46;
import com.baidu.tieba.b46;
import com.baidu.tieba.n36;
import com.baidu.tieba.s36;
import com.baidu.tieba.t36;
import com.baidu.tieba.u36;
import com.baidu.tieba.v36;
import com.baidu.tieba.w36;
import com.baidu.tieba.x36;
import com.baidu.tieba.xn;
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
        public class C0231a implements n36.a {
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

            @Override // com.baidu.tieba.n36.a
            public void a(v36 v36Var, View view2) {
                u36 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, v36Var, view2) == null) && (a = a46.a(v36Var)) != null) {
                    s36 s36Var = new s36();
                    s36Var.a = 2;
                    s36Var.b(view2);
                    a.T(s36Var);
                }
            }

            @Override // com.baidu.tieba.n36.a
            public void b(v36 v36Var, View view2) {
                u36 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v36Var, view2) == null) && (a = a46.a(v36Var)) != null) {
                    s36 s36Var = new s36();
                    s36Var.a = 3;
                    s36Var.b(view2);
                    a.T(s36Var);
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
            b46 b46Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof b46) || (b = (b46Var = (b46) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof u36)) {
                return;
            }
            u36 u36Var = (u36) b.getPageActivity();
            t36 d1 = u36Var.d1(2);
            if (d1 == null) {
                w36 a = x36.b().a(2);
                if (a == null) {
                    return;
                }
                d1 = a.a();
                u36Var.A0(2, d1);
                d1.f(new v36(b), null);
                if (!(d1 instanceof n36)) {
                    return;
                }
                ((n36) d1).h(new C0231a(this));
            }
            if (!(d1 instanceof n36)) {
                return;
            }
            n36 n36Var = (n36) d1;
            if (b46Var.a() == 1) {
                n36Var.b(b46Var.g());
                n36Var.c(b46Var.d());
                n36Var.j();
            } else if (b46Var.a() == 2) {
                n36Var.l(b46Var.f());
            } else if (b46Var.a() == 3) {
                xn e = b46Var.e();
                if (e != null && n36Var.getView() != null) {
                    e.removeHeaderView(n36Var.getView());
                }
            } else if (b46Var.a() == 4) {
                n36Var.a(b46Var.h());
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
