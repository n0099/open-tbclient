package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.go;
import com.baidu.tieba.in5;
import com.baidu.tieba.nn5;
import com.baidu.tieba.on5;
import com.baidu.tieba.pn5;
import com.baidu.tieba.qn5;
import com.baidu.tieba.rn5;
import com.baidu.tieba.sn5;
import com.baidu.tieba.vn5;
import com.baidu.tieba.wn5;
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
        public class C0194a implements in5.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0194a(a aVar) {
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

            @Override // com.baidu.tieba.in5.a
            public void a(qn5 qn5Var, View view2) {
                pn5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, qn5Var, view2) == null) && (a = vn5.a(qn5Var)) != null) {
                    nn5 nn5Var = new nn5();
                    nn5Var.a = 2;
                    nn5Var.b(view2);
                    a.M(nn5Var);
                }
            }

            @Override // com.baidu.tieba.in5.a
            public void b(qn5 qn5Var, View view2) {
                pn5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qn5Var, view2) == null) && (a = vn5.a(qn5Var)) != null) {
                    nn5 nn5Var = new nn5();
                    nn5Var.a = 3;
                    nn5Var.b(view2);
                    a.M(nn5Var);
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
            wn5 wn5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof wn5) || (b = (wn5Var = (wn5) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof pn5)) {
                return;
            }
            pn5 pn5Var = (pn5) b.getPageActivity();
            on5 P0 = pn5Var.P0(2);
            if (P0 == null) {
                rn5 a = sn5.b().a(2);
                if (a == null) {
                    return;
                }
                P0 = a.a();
                pn5Var.o0(2, P0);
                P0.f(new qn5(b), null);
                if (!(P0 instanceof in5)) {
                    return;
                }
                ((in5) P0).h(new C0194a(this));
            }
            if (!(P0 instanceof in5)) {
                return;
            }
            in5 in5Var = (in5) P0;
            if (wn5Var.a() == 1) {
                in5Var.b(wn5Var.g());
                in5Var.c(wn5Var.d());
                in5Var.j();
            } else if (wn5Var.a() == 2) {
                in5Var.l(wn5Var.f());
            } else if (wn5Var.a() == 3) {
                go e = wn5Var.e();
                if (e != null && in5Var.getView() != null) {
                    e.removeHeaderView(in5Var.getView());
                }
            } else if (wn5Var.a() == 4) {
                in5Var.a(wn5Var.h());
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
