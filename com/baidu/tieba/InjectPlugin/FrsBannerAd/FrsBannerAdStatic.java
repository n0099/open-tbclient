package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.cq5;
import com.baidu.tieba.dq5;
import com.baidu.tieba.pp5;
import com.baidu.tieba.up5;
import com.baidu.tieba.vp5;
import com.baidu.tieba.wp5;
import com.baidu.tieba.xp5;
import com.baidu.tieba.yp5;
import com.baidu.tieba.zn;
import com.baidu.tieba.zp5;
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
        public class C0216a implements pp5.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0216a(a aVar) {
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

            @Override // com.baidu.tieba.pp5.a
            public void a(xp5 xp5Var, View view2) {
                wp5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, xp5Var, view2) == null) && (a = cq5.a(xp5Var)) != null) {
                    up5 up5Var = new up5();
                    up5Var.a = 2;
                    up5Var.b(view2);
                    a.O(up5Var);
                }
            }

            @Override // com.baidu.tieba.pp5.a
            public void b(xp5 xp5Var, View view2) {
                wp5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xp5Var, view2) == null) && (a = cq5.a(xp5Var)) != null) {
                    up5 up5Var = new up5();
                    up5Var.a = 3;
                    up5Var.b(view2);
                    a.O(up5Var);
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
            dq5 dq5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof dq5) || (b = (dq5Var = (dq5) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof wp5)) {
                return;
            }
            wp5 wp5Var = (wp5) b.getPageActivity();
            vp5 T0 = wp5Var.T0(2);
            if (T0 == null) {
                yp5 a = zp5.b().a(2);
                if (a == null) {
                    return;
                }
                T0 = a.a();
                wp5Var.t0(2, T0);
                T0.f(new xp5(b), null);
                if (!(T0 instanceof pp5)) {
                    return;
                }
                ((pp5) T0).h(new C0216a(this));
            }
            if (!(T0 instanceof pp5)) {
                return;
            }
            pp5 pp5Var = (pp5) T0;
            if (dq5Var.a() == 1) {
                pp5Var.b(dq5Var.g());
                pp5Var.c(dq5Var.d());
                pp5Var.j();
            } else if (dq5Var.a() == 2) {
                pp5Var.l(dq5Var.f());
            } else if (dq5Var.a() == 3) {
                zn e = dq5Var.e();
                if (e != null && pp5Var.getView() != null) {
                    e.removeHeaderView(pp5Var.getView());
                }
            } else if (dq5Var.a() == 4) {
                pp5Var.a(dq5Var.h());
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
