package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.b06;
import com.baidu.tieba.g06;
import com.baidu.tieba.h06;
import com.baidu.tieba.i06;
import com.baidu.tieba.j06;
import com.baidu.tieba.k06;
import com.baidu.tieba.l06;
import com.baidu.tieba.o06;
import com.baidu.tieba.p06;
import com.baidu.tieba.qi;
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
        public class C0225a implements b06.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0225a(a aVar) {
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

            @Override // com.baidu.tieba.b06.a
            public void a(j06 j06Var, View view2) {
                i06 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, j06Var, view2) == null) && (a = o06.a(j06Var)) != null) {
                    g06 g06Var = new g06();
                    g06Var.a = 2;
                    g06Var.b(view2);
                    a.l0(g06Var);
                }
            }

            @Override // com.baidu.tieba.b06.a
            public void b(j06 j06Var, View view2) {
                i06 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j06Var, view2) == null) && (a = o06.a(j06Var)) != null) {
                    g06 g06Var = new g06();
                    g06Var.a = 3;
                    g06Var.b(view2);
                    a.l0(g06Var);
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
            p06 p06Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof p06) || (b = (p06Var = (p06) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof i06)) {
                return;
            }
            i06 i06Var = (i06) b.getPageActivity();
            h06 H1 = i06Var.H1(2);
            if (H1 == null) {
                k06 a = l06.b().a(2);
                if (a == null) {
                    return;
                }
                H1 = a.a();
                i06Var.Z0(2, H1);
                H1.f(new j06(b), null);
                if (!(H1 instanceof b06)) {
                    return;
                }
                ((b06) H1).h(new C0225a(this));
            }
            if (!(H1 instanceof b06)) {
                return;
            }
            b06 b06Var = (b06) H1;
            if (p06Var.a() == 1) {
                b06Var.b(p06Var.g());
                b06Var.c(p06Var.d());
                b06Var.j();
            } else if (p06Var.a() == 2) {
                b06Var.l(p06Var.f());
            } else if (p06Var.a() == 3) {
                qi e = p06Var.e();
                if (e != null && b06Var.getView() != null) {
                    e.removeHeaderView(b06Var.getView());
                }
            } else if (p06Var.a() == 4) {
                b06Var.a(p06Var.h());
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
