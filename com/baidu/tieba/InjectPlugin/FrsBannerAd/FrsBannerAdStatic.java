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
import com.repackage.ai5;
import com.repackage.bi5;
import com.repackage.ci5;
import com.repackage.fi5;
import com.repackage.gi5;
import com.repackage.rh5;
import com.repackage.to;
import com.repackage.xh5;
import com.repackage.yh5;
import com.repackage.zh5;
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
        public class C0177a implements rh5.a {
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

            @Override // com.repackage.rh5.a
            public void a(ai5 ai5Var, View view2) {
                zh5 a;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(1048576, this, ai5Var, view2) == null) || (a = fi5.a(ai5Var)) == null) {
                    return;
                }
                xh5 xh5Var = new xh5();
                xh5Var.a = 2;
                xh5Var.b(view2);
                a.dispatchInjectPluginMessage(xh5Var);
            }

            @Override // com.repackage.rh5.a
            public void b(ai5 ai5Var, View view2) {
                zh5 a;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ai5Var, view2) == null) || (a = fi5.a(ai5Var)) == null) {
                    return;
                }
                xh5 xh5Var = new xh5();
                xh5Var.a = 3;
                xh5Var.b(view2);
                a.dispatchInjectPluginMessage(xh5Var);
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
            gi5 gi5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof gi5) && (b = (gi5Var = (gi5) customResponsedMessage.getData()).b()) != null && (b.getPageActivity() instanceof zh5)) {
                zh5 zh5Var = (zh5) b.getPageActivity();
                yh5 injectPlugin = zh5Var.getInjectPlugin(2);
                if (injectPlugin == null) {
                    bi5 a = ci5.b().a(2);
                    if (a == null) {
                        return;
                    }
                    injectPlugin = a.a();
                    zh5Var.setInjectPlugin(2, injectPlugin);
                    injectPlugin.n(new ai5(b));
                    if (!(injectPlugin instanceof rh5)) {
                        return;
                    }
                    ((rh5) injectPlugin).f(new C0177a(this));
                }
                if (injectPlugin instanceof rh5) {
                    rh5 rh5Var = (rh5) injectPlugin;
                    if (gi5Var.a() == 1) {
                        rh5Var.setParams(gi5Var.g());
                        rh5Var.b(gi5Var.d());
                        rh5Var.h();
                    } else if (gi5Var.a() == 2) {
                        rh5Var.j(gi5Var.f());
                    } else if (gi5Var.a() == 3) {
                        to e = gi5Var.e();
                        if (e == null || rh5Var.getView() == null) {
                            return;
                        }
                        e.removeHeaderView(rh5Var.getView());
                    } else if (gi5Var.a() == 4) {
                        rh5Var.a(gi5Var.h());
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
