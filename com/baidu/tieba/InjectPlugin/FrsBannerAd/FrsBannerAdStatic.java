package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ho5;
import com.baidu.tieba.mo5;
import com.baidu.tieba.no5;
import com.baidu.tieba.oo5;
import com.baidu.tieba.po5;
import com.baidu.tieba.qo5;
import com.baidu.tieba.ro5;
import com.baidu.tieba.uo5;
import com.baidu.tieba.vo5;
import com.baidu.tieba.yn;
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
        public class C0203a implements ho5.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0203a(a aVar) {
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

            @Override // com.baidu.tieba.ho5.a
            public void a(po5 po5Var, View view2) {
                oo5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, po5Var, view2) == null) && (a = uo5.a(po5Var)) != null) {
                    mo5 mo5Var = new mo5();
                    mo5Var.a = 2;
                    mo5Var.b(view2);
                    a.M(mo5Var);
                }
            }

            @Override // com.baidu.tieba.ho5.a
            public void b(po5 po5Var, View view2) {
                oo5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, po5Var, view2) == null) && (a = uo5.a(po5Var)) != null) {
                    mo5 mo5Var = new mo5();
                    mo5Var.a = 3;
                    mo5Var.b(view2);
                    a.M(mo5Var);
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
            vo5 vo5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof vo5) || (b = (vo5Var = (vo5) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof oo5)) {
                return;
            }
            oo5 oo5Var = (oo5) b.getPageActivity();
            no5 P0 = oo5Var.P0(2);
            if (P0 == null) {
                qo5 a = ro5.b().a(2);
                if (a == null) {
                    return;
                }
                P0 = a.a();
                oo5Var.o0(2, P0);
                P0.f(new po5(b), null);
                if (!(P0 instanceof ho5)) {
                    return;
                }
                ((ho5) P0).h(new C0203a(this));
            }
            if (!(P0 instanceof ho5)) {
                return;
            }
            ho5 ho5Var = (ho5) P0;
            if (vo5Var.a() == 1) {
                ho5Var.b(vo5Var.g());
                ho5Var.c(vo5Var.d());
                ho5Var.j();
            } else if (vo5Var.a() == 2) {
                ho5Var.l(vo5Var.f());
            } else if (vo5Var.a() == 3) {
                yn e = vo5Var.e();
                if (e != null && ho5Var.getView() != null) {
                    e.removeHeaderView(ho5Var.getView());
                }
            } else if (vo5Var.a() == 4) {
                ho5Var.a(vo5Var.h());
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
