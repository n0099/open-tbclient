package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ap5;
import com.baidu.tieba.bp5;
import com.baidu.tieba.cp5;
import com.baidu.tieba.dp5;
import com.baidu.tieba.gp5;
import com.baidu.tieba.hp5;
import com.baidu.tieba.to5;
import com.baidu.tieba.yo5;
import com.baidu.tieba.zn;
import com.baidu.tieba.zo5;
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
        public class C0203a implements to5.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0203a(a aVar) {
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

            @Override // com.baidu.tieba.to5.a
            public void a(bp5 bp5Var, View view2) {
                ap5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, bp5Var, view2) == null) && (a = gp5.a(bp5Var)) != null) {
                    yo5 yo5Var = new yo5();
                    yo5Var.a = 2;
                    yo5Var.b(view2);
                    a.M(yo5Var);
                }
            }

            @Override // com.baidu.tieba.to5.a
            public void b(bp5 bp5Var, View view2) {
                ap5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bp5Var, view2) == null) && (a = gp5.a(bp5Var)) != null) {
                    yo5 yo5Var = new yo5();
                    yo5Var.a = 3;
                    yo5Var.b(view2);
                    a.M(yo5Var);
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
            hp5 hp5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof hp5) || (b = (hp5Var = (hp5) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof ap5)) {
                return;
            }
            ap5 ap5Var = (ap5) b.getPageActivity();
            zo5 P0 = ap5Var.P0(2);
            if (P0 == null) {
                cp5 a = dp5.b().a(2);
                if (a == null) {
                    return;
                }
                P0 = a.a();
                ap5Var.o0(2, P0);
                P0.f(new bp5(b), null);
                if (!(P0 instanceof to5)) {
                    return;
                }
                ((to5) P0).h(new C0203a(this));
            }
            if (!(P0 instanceof to5)) {
                return;
            }
            to5 to5Var = (to5) P0;
            if (hp5Var.a() == 1) {
                to5Var.b(hp5Var.g());
                to5Var.c(hp5Var.d());
                to5Var.j();
            } else if (hp5Var.a() == 2) {
                to5Var.l(hp5Var.f());
            } else if (hp5Var.a() == 3) {
                zn e = hp5Var.e();
                if (e != null && to5Var.getView() != null) {
                    e.removeHeaderView(to5Var.getView());
                }
            } else if (hp5Var.a() == 4) {
                to5Var.a(hp5Var.h());
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
