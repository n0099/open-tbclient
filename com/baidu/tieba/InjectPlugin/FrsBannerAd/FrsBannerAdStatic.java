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
import com.baidu.tieba.ep5;
import com.baidu.tieba.hp5;
import com.baidu.tieba.ip5;
import com.baidu.tieba.uo5;
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
        public class C0203a implements uo5.a {
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

            @Override // com.baidu.tieba.uo5.a
            public void a(cp5 cp5Var, View view2) {
                bp5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, cp5Var, view2) == null) && (a = hp5.a(cp5Var)) != null) {
                    zo5 zo5Var = new zo5();
                    zo5Var.a = 2;
                    zo5Var.b(view2);
                    a.M(zo5Var);
                }
            }

            @Override // com.baidu.tieba.uo5.a
            public void b(cp5 cp5Var, View view2) {
                bp5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cp5Var, view2) == null) && (a = hp5.a(cp5Var)) != null) {
                    zo5 zo5Var = new zo5();
                    zo5Var.a = 3;
                    zo5Var.b(view2);
                    a.M(zo5Var);
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
            ip5 ip5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof ip5) || (b = (ip5Var = (ip5) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof bp5)) {
                return;
            }
            bp5 bp5Var = (bp5) b.getPageActivity();
            ap5 P0 = bp5Var.P0(2);
            if (P0 == null) {
                dp5 a = ep5.b().a(2);
                if (a == null) {
                    return;
                }
                P0 = a.a();
                bp5Var.o0(2, P0);
                P0.f(new cp5(b), null);
                if (!(P0 instanceof uo5)) {
                    return;
                }
                ((uo5) P0).h(new C0203a(this));
            }
            if (!(P0 instanceof uo5)) {
                return;
            }
            uo5 uo5Var = (uo5) P0;
            if (ip5Var.a() == 1) {
                uo5Var.b(ip5Var.g());
                uo5Var.c(ip5Var.d());
                uo5Var.j();
            } else if (ip5Var.a() == 2) {
                uo5Var.l(ip5Var.f());
            } else if (ip5Var.a() == 3) {
                zn e = ip5Var.e();
                if (e != null && uo5Var.getView() != null) {
                    e.removeHeaderView(uo5Var.getView());
                }
            } else if (ip5Var.a() == 4) {
                uo5Var.a(ip5Var.h());
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
