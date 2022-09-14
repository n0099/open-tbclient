package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.bn5;
import com.baidu.tieba.cn5;
import com.baidu.tieba.fo;
import com.baidu.tieba.om5;
import com.baidu.tieba.tm5;
import com.baidu.tieba.um5;
import com.baidu.tieba.vm5;
import com.baidu.tieba.wm5;
import com.baidu.tieba.xm5;
import com.baidu.tieba.ym5;
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
        public class C0197a implements om5.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0197a(a aVar) {
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

            @Override // com.baidu.tieba.om5.a
            public void a(wm5 wm5Var, View view2) {
                vm5 a;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(1048576, this, wm5Var, view2) == null) || (a = bn5.a(wm5Var)) == null) {
                    return;
                }
                tm5 tm5Var = new tm5();
                tm5Var.a = 2;
                tm5Var.b(view2);
                a.M(tm5Var);
            }

            @Override // com.baidu.tieba.om5.a
            public void b(wm5 wm5Var, View view2) {
                vm5 a;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wm5Var, view2) == null) || (a = bn5.a(wm5Var)) == null) {
                    return;
                }
                tm5 tm5Var = new tm5();
                tm5Var.a = 3;
                tm5Var.b(view2);
                a.M(tm5Var);
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
            cn5 cn5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof cn5) && (b = (cn5Var = (cn5) customResponsedMessage.getData()).b()) != null && (b.getPageActivity() instanceof vm5)) {
                vm5 vm5Var = (vm5) b.getPageActivity();
                um5 P0 = vm5Var.P0(2);
                if (P0 == null) {
                    xm5 a = ym5.b().a(2);
                    if (a == null) {
                        return;
                    }
                    P0 = a.a();
                    vm5Var.o0(2, P0);
                    P0.f(new wm5(b), null);
                    if (!(P0 instanceof om5)) {
                        return;
                    }
                    ((om5) P0).h(new C0197a(this));
                }
                if (P0 instanceof om5) {
                    om5 om5Var = (om5) P0;
                    if (cn5Var.a() == 1) {
                        om5Var.b(cn5Var.g());
                        om5Var.c(cn5Var.d());
                        om5Var.j();
                    } else if (cn5Var.a() == 2) {
                        om5Var.l(cn5Var.f());
                    } else if (cn5Var.a() == 3) {
                        fo e = cn5Var.e();
                        if (e == null || om5Var.getView() == null) {
                            return;
                        }
                        e.removeHeaderView(om5Var.getView());
                    } else if (cn5Var.a() == 4) {
                        om5Var.a(cn5Var.h());
                    }
                }
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
