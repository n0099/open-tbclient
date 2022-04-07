package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.eh5;
import com.repackage.fh5;
import com.repackage.gh5;
import com.repackage.hh5;
import com.repackage.ih5;
import com.repackage.jh5;
import com.repackage.mh5;
import com.repackage.nh5;
import com.repackage.wo;
import com.repackage.yg5;
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
        public class C0177a implements yg5.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0177a(a aVar) {
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

            @Override // com.repackage.yg5.a
            public void a(hh5 hh5Var, View view2) {
                gh5 a;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(1048576, this, hh5Var, view2) == null) || (a = mh5.a(hh5Var)) == null) {
                    return;
                }
                eh5 eh5Var = new eh5();
                eh5Var.a = 2;
                eh5Var.b(view2);
                a.dispatchInjectPluginMessage(eh5Var);
            }

            @Override // com.repackage.yg5.a
            public void b(hh5 hh5Var, View view2) {
                gh5 a;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hh5Var, view2) == null) || (a = mh5.a(hh5Var)) == null) {
                    return;
                }
                eh5 eh5Var = new eh5();
                eh5Var.a = 3;
                eh5Var.b(view2);
                a.dispatchInjectPluginMessage(eh5Var);
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
            nh5 nh5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof nh5) && (b = (nh5Var = (nh5) customResponsedMessage.getData()).b()) != null && (b.getPageActivity() instanceof gh5)) {
                gh5 gh5Var = (gh5) b.getPageActivity();
                fh5 injectPlugin = gh5Var.getInjectPlugin(2);
                if (injectPlugin == null) {
                    ih5 a = jh5.b().a(2);
                    if (a == null) {
                        return;
                    }
                    injectPlugin = a.a();
                    gh5Var.setInjectPlugin(2, injectPlugin);
                    injectPlugin.n(new hh5(b));
                    if (!(injectPlugin instanceof yg5)) {
                        return;
                    }
                    ((yg5) injectPlugin).f(new C0177a(this));
                }
                if (injectPlugin instanceof yg5) {
                    yg5 yg5Var = (yg5) injectPlugin;
                    if (nh5Var.a() == 1) {
                        yg5Var.setParams(nh5Var.g());
                        yg5Var.b(nh5Var.d());
                        yg5Var.h();
                    } else if (nh5Var.a() == 2) {
                        yg5Var.j(nh5Var.f());
                    } else if (nh5Var.a() == 3) {
                        wo e = nh5Var.e();
                        if (e == null || yg5Var.getView() == null) {
                            return;
                        }
                        e.removeHeaderView(yg5Var.getView());
                    } else if (nh5Var.a() == 4) {
                        yg5Var.a(nh5Var.h());
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
