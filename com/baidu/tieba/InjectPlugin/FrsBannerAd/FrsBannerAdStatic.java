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
import com.repackage.ih5;
import com.repackage.oh5;
import com.repackage.ph5;
import com.repackage.pn;
import com.repackage.qh5;
import com.repackage.rh5;
import com.repackage.sh5;
import com.repackage.th5;
import com.repackage.wh5;
import com.repackage.xh5;
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
        public class C0180a implements ih5.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0180a(a aVar) {
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

            @Override // com.repackage.ih5.a
            public void a(rh5 rh5Var, View view2) {
                qh5 a;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(1048576, this, rh5Var, view2) == null) || (a = wh5.a(rh5Var)) == null) {
                    return;
                }
                oh5 oh5Var = new oh5();
                oh5Var.a = 2;
                oh5Var.b(view2);
                a.L(oh5Var);
            }

            @Override // com.repackage.ih5.a
            public void b(rh5 rh5Var, View view2) {
                qh5 a;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rh5Var, view2) == null) || (a = wh5.a(rh5Var)) == null) {
                    return;
                }
                oh5 oh5Var = new oh5();
                oh5Var.a = 3;
                oh5Var.b(view2);
                a.L(oh5Var);
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
            xh5 xh5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof xh5) && (b = (xh5Var = (xh5) customResponsedMessage.getData()).b()) != null && (b.getPageActivity() instanceof qh5)) {
                qh5 qh5Var = (qh5) b.getPageActivity();
                ph5 Q0 = qh5Var.Q0(2);
                if (Q0 == null) {
                    sh5 a = th5.b().a(2);
                    if (a == null) {
                        return;
                    }
                    Q0 = a.a();
                    qh5Var.p0(2, Q0);
                    Q0.n(new rh5(b));
                    if (!(Q0 instanceof ih5)) {
                        return;
                    }
                    ((ih5) Q0).f(new C0180a(this));
                }
                if (Q0 instanceof ih5) {
                    ih5 ih5Var = (ih5) Q0;
                    if (xh5Var.a() == 1) {
                        ih5Var.setParams(xh5Var.g());
                        ih5Var.b(xh5Var.d());
                        ih5Var.h();
                    } else if (xh5Var.a() == 2) {
                        ih5Var.j(xh5Var.f());
                    } else if (xh5Var.a() == 3) {
                        pn e = xh5Var.e();
                        if (e == null || ih5Var.getView() == null) {
                            return;
                        }
                        e.removeHeaderView(ih5Var.getView());
                    } else if (xh5Var.a() == 4) {
                        ih5Var.a(xh5Var.h());
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
