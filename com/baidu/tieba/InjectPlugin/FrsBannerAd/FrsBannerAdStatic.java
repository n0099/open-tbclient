package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.hk5;
import com.baidu.tieba.mk5;
import com.baidu.tieba.nk5;
import com.baidu.tieba.ok5;
import com.baidu.tieba.pk5;
import com.baidu.tieba.qk5;
import com.baidu.tieba.rk5;
import com.baidu.tieba.rn;
import com.baidu.tieba.uk5;
import com.baidu.tieba.vk5;
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
        public class C0198a implements hk5.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0198a(a aVar) {
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

            @Override // com.baidu.tieba.hk5.a
            public void a(pk5 pk5Var, View view2) {
                ok5 a;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(1048576, this, pk5Var, view2) == null) || (a = uk5.a(pk5Var)) == null) {
                    return;
                }
                mk5 mk5Var = new mk5();
                mk5Var.a = 2;
                mk5Var.b(view2);
                a.M(mk5Var);
            }

            @Override // com.baidu.tieba.hk5.a
            public void b(pk5 pk5Var, View view2) {
                ok5 a;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pk5Var, view2) == null) || (a = uk5.a(pk5Var)) == null) {
                    return;
                }
                mk5 mk5Var = new mk5();
                mk5Var.a = 3;
                mk5Var.b(view2);
                a.M(mk5Var);
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
            vk5 vk5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof vk5) && (b = (vk5Var = (vk5) customResponsedMessage.getData()).b()) != null && (b.getPageActivity() instanceof ok5)) {
                ok5 ok5Var = (ok5) b.getPageActivity();
                nk5 Q0 = ok5Var.Q0(2);
                if (Q0 == null) {
                    qk5 a = rk5.b().a(2);
                    if (a == null) {
                        return;
                    }
                    Q0 = a.a();
                    ok5Var.p0(2, Q0);
                    Q0.f(new pk5(b), null);
                    if (!(Q0 instanceof hk5)) {
                        return;
                    }
                    ((hk5) Q0).h(new C0198a(this));
                }
                if (Q0 instanceof hk5) {
                    hk5 hk5Var = (hk5) Q0;
                    if (vk5Var.a() == 1) {
                        hk5Var.b(vk5Var.g());
                        hk5Var.c(vk5Var.d());
                        hk5Var.j();
                    } else if (vk5Var.a() == 2) {
                        hk5Var.l(vk5Var.f());
                    } else if (vk5Var.a() == 3) {
                        rn e = vk5Var.e();
                        if (e == null || hk5Var.getView() == null) {
                            return;
                        }
                        e.removeHeaderView(hk5Var.getView());
                    } else if (vk5Var.a() == 4) {
                        hk5Var.a(vk5Var.h());
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
