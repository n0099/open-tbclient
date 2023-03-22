package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.aw5;
import com.baidu.tieba.bw5;
import com.baidu.tieba.ew5;
import com.baidu.tieba.fw5;
import com.baidu.tieba.in;
import com.baidu.tieba.rv5;
import com.baidu.tieba.wv5;
import com.baidu.tieba.xv5;
import com.baidu.tieba.yv5;
import com.baidu.tieba.zv5;
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
        public class C0205a implements rv5.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0205a(a aVar) {
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

            @Override // com.baidu.tieba.rv5.a
            public void a(zv5 zv5Var, View view2) {
                yv5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, zv5Var, view2) == null) && (a = ew5.a(zv5Var)) != null) {
                    wv5 wv5Var = new wv5();
                    wv5Var.a = 2;
                    wv5Var.b(view2);
                    a.S(wv5Var);
                }
            }

            @Override // com.baidu.tieba.rv5.a
            public void b(zv5 zv5Var, View view2) {
                yv5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zv5Var, view2) == null) && (a = ew5.a(zv5Var)) != null) {
                    wv5 wv5Var = new wv5();
                    wv5Var.a = 3;
                    wv5Var.b(view2);
                    a.S(wv5Var);
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
            fw5 fw5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof fw5) || (b = (fw5Var = (fw5) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof yv5)) {
                return;
            }
            yv5 yv5Var = (yv5) b.getPageActivity();
            xv5 Z0 = yv5Var.Z0(2);
            if (Z0 == null) {
                aw5 a = bw5.b().a(2);
                if (a == null) {
                    return;
                }
                Z0 = a.a();
                yv5Var.z0(2, Z0);
                Z0.f(new zv5(b), null);
                if (!(Z0 instanceof rv5)) {
                    return;
                }
                ((rv5) Z0).h(new C0205a(this));
            }
            if (!(Z0 instanceof rv5)) {
                return;
            }
            rv5 rv5Var = (rv5) Z0;
            if (fw5Var.a() == 1) {
                rv5Var.b(fw5Var.g());
                rv5Var.c(fw5Var.d());
                rv5Var.j();
            } else if (fw5Var.a() == 2) {
                rv5Var.l(fw5Var.f());
            } else if (fw5Var.a() == 3) {
                in e = fw5Var.e();
                if (e != null && rv5Var.getView() != null) {
                    e.removeHeaderView(rv5Var.getView());
                }
            } else if (fw5Var.a() == 4) {
                rv5Var.a(fw5Var.h());
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
