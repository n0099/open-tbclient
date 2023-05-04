package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.dy5;
import com.baidu.tieba.ey5;
import com.baidu.tieba.fy5;
import com.baidu.tieba.gy5;
import com.baidu.tieba.hy5;
import com.baidu.tieba.iy5;
import com.baidu.tieba.kn;
import com.baidu.tieba.ly5;
import com.baidu.tieba.my5;
import com.baidu.tieba.yx5;
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
        public class C0205a implements yx5.a {
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

            @Override // com.baidu.tieba.yx5.a
            public void a(gy5 gy5Var, View view2) {
                fy5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, gy5Var, view2) == null) && (a = ly5.a(gy5Var)) != null) {
                    dy5 dy5Var = new dy5();
                    dy5Var.a = 2;
                    dy5Var.b(view2);
                    a.T(dy5Var);
                }
            }

            @Override // com.baidu.tieba.yx5.a
            public void b(gy5 gy5Var, View view2) {
                fy5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gy5Var, view2) == null) && (a = ly5.a(gy5Var)) != null) {
                    dy5 dy5Var = new dy5();
                    dy5Var.a = 3;
                    dy5Var.b(view2);
                    a.T(dy5Var);
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
            my5 my5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof my5) || (b = (my5Var = (my5) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof fy5)) {
                return;
            }
            fy5 fy5Var = (fy5) b.getPageActivity();
            ey5 b1 = fy5Var.b1(2);
            if (b1 == null) {
                hy5 a = iy5.b().a(2);
                if (a == null) {
                    return;
                }
                b1 = a.a();
                fy5Var.B0(2, b1);
                b1.f(new gy5(b), null);
                if (!(b1 instanceof yx5)) {
                    return;
                }
                ((yx5) b1).h(new C0205a(this));
            }
            if (!(b1 instanceof yx5)) {
                return;
            }
            yx5 yx5Var = (yx5) b1;
            if (my5Var.a() == 1) {
                yx5Var.b(my5Var.g());
                yx5Var.c(my5Var.d());
                yx5Var.j();
            } else if (my5Var.a() == 2) {
                yx5Var.l(my5Var.f());
            } else if (my5Var.a() == 3) {
                kn e = my5Var.e();
                if (e != null && yx5Var.getView() != null) {
                    e.removeHeaderView(yx5Var.getView());
                }
            } else if (my5Var.a() == 4) {
                yx5Var.a(my5Var.h());
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
