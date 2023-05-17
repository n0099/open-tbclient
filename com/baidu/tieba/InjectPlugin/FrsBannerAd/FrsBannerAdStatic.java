package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.kz5;
import com.baidu.tieba.pz5;
import com.baidu.tieba.qz5;
import com.baidu.tieba.rz5;
import com.baidu.tieba.sz5;
import com.baidu.tieba.tn;
import com.baidu.tieba.tz5;
import com.baidu.tieba.uz5;
import com.baidu.tieba.xz5;
import com.baidu.tieba.yz5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FrsBannerAdStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.InjectPlugin.FrsBannerAd.FrsBannerAdStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0217a implements kz5.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0217a(a aVar) {
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

            @Override // com.baidu.tieba.kz5.a
            public void a(sz5 sz5Var, View view2) {
                rz5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, sz5Var, view2) == null) && (a = xz5.a(sz5Var)) != null) {
                    pz5 pz5Var = new pz5();
                    pz5Var.a = 2;
                    pz5Var.b(view2);
                    a.T(pz5Var);
                }
            }

            @Override // com.baidu.tieba.kz5.a
            public void b(sz5 sz5Var, View view2) {
                rz5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sz5Var, view2) == null) && (a = xz5.a(sz5Var)) != null) {
                    pz5 pz5Var = new pz5();
                    pz5Var.a = 3;
                    pz5Var.b(view2);
                    a.T(pz5Var);
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
            yz5 yz5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof yz5) || (b = (yz5Var = (yz5) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof rz5)) {
                return;
            }
            rz5 rz5Var = (rz5) b.getPageActivity();
            qz5 c1 = rz5Var.c1(2);
            if (c1 == null) {
                tz5 a = uz5.b().a(2);
                if (a == null) {
                    return;
                }
                c1 = a.a();
                rz5Var.A0(2, c1);
                c1.f(new sz5(b), null);
                if (!(c1 instanceof kz5)) {
                    return;
                }
                ((kz5) c1).h(new C0217a(this));
            }
            if (!(c1 instanceof kz5)) {
                return;
            }
            kz5 kz5Var = (kz5) c1;
            if (yz5Var.a() == 1) {
                kz5Var.b(yz5Var.g());
                kz5Var.c(yz5Var.d());
                kz5Var.j();
            } else if (yz5Var.a() == 2) {
                kz5Var.l(yz5Var.f());
            } else if (yz5Var.a() == 3) {
                tn e = yz5Var.e();
                if (e != null && kz5Var.getView() != null) {
                    e.removeHeaderView(kz5Var.getView());
                }
            } else if (yz5Var.a() == 4) {
                kz5Var.a(yz5Var.h());
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
