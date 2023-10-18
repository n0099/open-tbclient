package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ai;
import com.baidu.tieba.gy5;
import com.baidu.tieba.ly5;
import com.baidu.tieba.my5;
import com.baidu.tieba.ny5;
import com.baidu.tieba.oy5;
import com.baidu.tieba.py5;
import com.baidu.tieba.qy5;
import com.baidu.tieba.ty5;
import com.baidu.tieba.uy5;
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
        public class C0223a implements gy5.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0223a(a aVar) {
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

            @Override // com.baidu.tieba.gy5.a
            public void a(oy5 oy5Var, View view2) {
                ny5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, oy5Var, view2) == null) && (a = ty5.a(oy5Var)) != null) {
                    ly5 ly5Var = new ly5();
                    ly5Var.a = 2;
                    ly5Var.b(view2);
                    a.g0(ly5Var);
                }
            }

            @Override // com.baidu.tieba.gy5.a
            public void b(oy5 oy5Var, View view2) {
                ny5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oy5Var, view2) == null) && (a = ty5.a(oy5Var)) != null) {
                    ly5 ly5Var = new ly5();
                    ly5Var.a = 3;
                    ly5Var.b(view2);
                    a.g0(ly5Var);
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
            uy5 uy5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof uy5) || (b = (uy5Var = (uy5) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof ny5)) {
                return;
            }
            ny5 ny5Var = (ny5) b.getPageActivity();
            my5 t1 = ny5Var.t1(2);
            if (t1 == null) {
                py5 a = qy5.b().a(2);
                if (a == null) {
                    return;
                }
                t1 = a.a();
                ny5Var.Q0(2, t1);
                t1.f(new oy5(b), null);
                if (!(t1 instanceof gy5)) {
                    return;
                }
                ((gy5) t1).h(new C0223a(this));
            }
            if (!(t1 instanceof gy5)) {
                return;
            }
            gy5 gy5Var = (gy5) t1;
            if (uy5Var.a() == 1) {
                gy5Var.b(uy5Var.g());
                gy5Var.c(uy5Var.d());
                gy5Var.j();
            } else if (uy5Var.a() == 2) {
                gy5Var.l(uy5Var.f());
            } else if (uy5Var.a() == 3) {
                ai e = uy5Var.e();
                if (e != null && gy5Var.getView() != null) {
                    e.removeHeaderView(gy5Var.getView());
                }
            } else if (uy5Var.a() == 4) {
                gy5Var.a(uy5Var.h());
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
