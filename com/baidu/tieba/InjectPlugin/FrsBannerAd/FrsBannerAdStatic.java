package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.fo;
import com.baidu.tieba.lw5;
import com.baidu.tieba.qw5;
import com.baidu.tieba.rw5;
import com.baidu.tieba.sw5;
import com.baidu.tieba.tw5;
import com.baidu.tieba.uw5;
import com.baidu.tieba.vw5;
import com.baidu.tieba.yw5;
import com.baidu.tieba.zw5;
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
        public class C0206a implements lw5.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0206a(a aVar) {
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

            @Override // com.baidu.tieba.lw5.a
            public void a(tw5 tw5Var, View view2) {
                sw5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, tw5Var, view2) == null) && (a = yw5.a(tw5Var)) != null) {
                    qw5 qw5Var = new qw5();
                    qw5Var.a = 2;
                    qw5Var.b(view2);
                    a.Q(qw5Var);
                }
            }

            @Override // com.baidu.tieba.lw5.a
            public void b(tw5 tw5Var, View view2) {
                sw5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tw5Var, view2) == null) && (a = yw5.a(tw5Var)) != null) {
                    qw5 qw5Var = new qw5();
                    qw5Var.a = 3;
                    qw5Var.b(view2);
                    a.Q(qw5Var);
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
            zw5 zw5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof zw5) || (b = (zw5Var = (zw5) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof sw5)) {
                return;
            }
            sw5 sw5Var = (sw5) b.getPageActivity();
            rw5 Y0 = sw5Var.Y0(2);
            if (Y0 == null) {
                uw5 a = vw5.b().a(2);
                if (a == null) {
                    return;
                }
                Y0 = a.a();
                sw5Var.x0(2, Y0);
                Y0.f(new tw5(b), null);
                if (!(Y0 instanceof lw5)) {
                    return;
                }
                ((lw5) Y0).h(new C0206a(this));
            }
            if (!(Y0 instanceof lw5)) {
                return;
            }
            lw5 lw5Var = (lw5) Y0;
            if (zw5Var.a() == 1) {
                lw5Var.b(zw5Var.g());
                lw5Var.c(zw5Var.d());
                lw5Var.j();
            } else if (zw5Var.a() == 2) {
                lw5Var.l(zw5Var.f());
            } else if (zw5Var.a() == 3) {
                fo e = zw5Var.e();
                if (e != null && lw5Var.getView() != null) {
                    e.removeHeaderView(lw5Var.getView());
                }
            } else if (zw5Var.a() == 4) {
                lw5Var.a(zw5Var.h());
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
