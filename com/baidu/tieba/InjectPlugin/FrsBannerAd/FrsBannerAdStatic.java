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
import com.repackage.ek5;
import com.repackage.fk5;
import com.repackage.gk5;
import com.repackage.hk5;
import com.repackage.ik5;
import com.repackage.jk5;
import com.repackage.mk5;
import com.repackage.nk5;
import com.repackage.qn;
import com.repackage.zj5;
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
        public class C0197a implements zj5.a {
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

            @Override // com.repackage.zj5.a
            public void a(hk5 hk5Var, View view2) {
                gk5 a;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(1048576, this, hk5Var, view2) == null) || (a = mk5.a(hk5Var)) == null) {
                    return;
                }
                ek5 ek5Var = new ek5();
                ek5Var.a = 2;
                ek5Var.b(view2);
                a.M(ek5Var);
            }

            @Override // com.repackage.zj5.a
            public void b(hk5 hk5Var, View view2) {
                gk5 a;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hk5Var, view2) == null) || (a = mk5.a(hk5Var)) == null) {
                    return;
                }
                ek5 ek5Var = new ek5();
                ek5Var.a = 3;
                ek5Var.b(view2);
                a.M(ek5Var);
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
            nk5 nk5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof nk5) && (b = (nk5Var = (nk5) customResponsedMessage.getData()).b()) != null && (b.getPageActivity() instanceof gk5)) {
                gk5 gk5Var = (gk5) b.getPageActivity();
                fk5 Q0 = gk5Var.Q0(2);
                if (Q0 == null) {
                    ik5 a = jk5.b().a(2);
                    if (a == null) {
                        return;
                    }
                    Q0 = a.a();
                    gk5Var.p0(2, Q0);
                    Q0.f(new hk5(b), null);
                    if (!(Q0 instanceof zj5)) {
                        return;
                    }
                    ((zj5) Q0).h(new C0197a(this));
                }
                if (Q0 instanceof zj5) {
                    zj5 zj5Var = (zj5) Q0;
                    if (nk5Var.a() == 1) {
                        zj5Var.b(nk5Var.g());
                        zj5Var.c(nk5Var.d());
                        zj5Var.j();
                    } else if (nk5Var.a() == 2) {
                        zj5Var.l(nk5Var.f());
                    } else if (nk5Var.a() == 3) {
                        qn e = nk5Var.e();
                        if (e == null || zj5Var.getView() == null) {
                            return;
                        }
                        e.removeHeaderView(zj5Var.getView());
                    } else if (nk5Var.a() == 4) {
                        zj5Var.a(nk5Var.h());
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
