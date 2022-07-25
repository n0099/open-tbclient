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
import com.repackage.aj5;
import com.repackage.li5;
import com.repackage.pn;
import com.repackage.ri5;
import com.repackage.si5;
import com.repackage.ti5;
import com.repackage.ui5;
import com.repackage.vi5;
import com.repackage.wi5;
import com.repackage.zi5;
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
        public class C0196a implements li5.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0196a(a aVar) {
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

            @Override // com.repackage.li5.a
            public void a(ui5 ui5Var, View view2) {
                ti5 a;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(1048576, this, ui5Var, view2) == null) || (a = zi5.a(ui5Var)) == null) {
                    return;
                }
                ri5 ri5Var = new ri5();
                ri5Var.a = 2;
                ri5Var.b(view2);
                a.L(ri5Var);
            }

            @Override // com.repackage.li5.a
            public void b(ui5 ui5Var, View view2) {
                ti5 a;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ui5Var, view2) == null) || (a = zi5.a(ui5Var)) == null) {
                    return;
                }
                ri5 ri5Var = new ri5();
                ri5Var.a = 3;
                ri5Var.b(view2);
                a.L(ri5Var);
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
            aj5 aj5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof aj5) && (b = (aj5Var = (aj5) customResponsedMessage.getData()).b()) != null && (b.getPageActivity() instanceof ti5)) {
                ti5 ti5Var = (ti5) b.getPageActivity();
                si5 R0 = ti5Var.R0(2);
                if (R0 == null) {
                    vi5 a = wi5.b().a(2);
                    if (a == null) {
                        return;
                    }
                    R0 = a.a();
                    ti5Var.q0(2, R0);
                    R0.o(new ui5(b));
                    if (!(R0 instanceof li5)) {
                        return;
                    }
                    ((li5) R0).g(new C0196a(this));
                }
                if (R0 instanceof li5) {
                    li5 li5Var = (li5) R0;
                    if (aj5Var.a() == 1) {
                        li5Var.b(aj5Var.g());
                        li5Var.c(aj5Var.d());
                        li5Var.i();
                    } else if (aj5Var.a() == 2) {
                        li5Var.k(aj5Var.f());
                    } else if (aj5Var.a() == 3) {
                        pn e = aj5Var.e();
                        if (e == null || li5Var.getView() == null) {
                            return;
                        }
                        e.removeHeaderView(li5Var.getView());
                    } else if (aj5Var.a() == 4) {
                        li5Var.a(aj5Var.h());
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
