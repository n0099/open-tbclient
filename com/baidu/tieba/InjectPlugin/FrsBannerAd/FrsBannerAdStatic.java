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
import com.repackage.ah5;
import com.repackage.lg5;
import com.repackage.ln;
import com.repackage.rg5;
import com.repackage.sg5;
import com.repackage.tg5;
import com.repackage.ug5;
import com.repackage.vg5;
import com.repackage.wg5;
import com.repackage.zg5;
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
        public class C0176a implements lg5.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0176a(a aVar) {
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

            @Override // com.repackage.lg5.a
            public void a(ug5 ug5Var, View view2) {
                tg5 a;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(1048576, this, ug5Var, view2) == null) || (a = zg5.a(ug5Var)) == null) {
                    return;
                }
                rg5 rg5Var = new rg5();
                rg5Var.a = 2;
                rg5Var.b(view2);
                a.dispatchInjectPluginMessage(rg5Var);
            }

            @Override // com.repackage.lg5.a
            public void b(ug5 ug5Var, View view2) {
                tg5 a;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ug5Var, view2) == null) || (a = zg5.a(ug5Var)) == null) {
                    return;
                }
                rg5 rg5Var = new rg5();
                rg5Var.a = 3;
                rg5Var.b(view2);
                a.dispatchInjectPluginMessage(rg5Var);
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
            ah5 ah5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ah5) && (b = (ah5Var = (ah5) customResponsedMessage.getData()).b()) != null && (b.getPageActivity() instanceof tg5)) {
                tg5 tg5Var = (tg5) b.getPageActivity();
                sg5 injectPlugin = tg5Var.getInjectPlugin(2);
                if (injectPlugin == null) {
                    vg5 a = wg5.b().a(2);
                    if (a == null) {
                        return;
                    }
                    injectPlugin = a.a();
                    tg5Var.setInjectPlugin(2, injectPlugin);
                    injectPlugin.n(new ug5(b));
                    if (!(injectPlugin instanceof lg5)) {
                        return;
                    }
                    ((lg5) injectPlugin).f(new C0176a(this));
                }
                if (injectPlugin instanceof lg5) {
                    lg5 lg5Var = (lg5) injectPlugin;
                    if (ah5Var.a() == 1) {
                        lg5Var.setParams(ah5Var.g());
                        lg5Var.b(ah5Var.d());
                        lg5Var.h();
                    } else if (ah5Var.a() == 2) {
                        lg5Var.j(ah5Var.f());
                    } else if (ah5Var.a() == 3) {
                        ln e = ah5Var.e();
                        if (e == null || lg5Var.getView() == null) {
                            return;
                        }
                        e.removeHeaderView(lg5Var.getView());
                    } else if (ah5Var.a() == 4) {
                        lg5Var.a(ah5Var.h());
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
