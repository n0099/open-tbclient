package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ao;
import com.baidu.tieba.jq5;
import com.baidu.tieba.oq5;
import com.baidu.tieba.pq5;
import com.baidu.tieba.qq5;
import com.baidu.tieba.rq5;
import com.baidu.tieba.sq5;
import com.baidu.tieba.tq5;
import com.baidu.tieba.wq5;
import com.baidu.tieba.xq5;
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
        public class C0216a implements jq5.a {
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

            @Override // com.baidu.tieba.jq5.a
            public void a(rq5 rq5Var, View view2) {
                qq5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, rq5Var, view2) == null) && (a = wq5.a(rq5Var)) != null) {
                    oq5 oq5Var = new oq5();
                    oq5Var.a = 2;
                    oq5Var.b(view2);
                    a.O(oq5Var);
                }
            }

            @Override // com.baidu.tieba.jq5.a
            public void b(rq5 rq5Var, View view2) {
                qq5 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rq5Var, view2) == null) && (a = wq5.a(rq5Var)) != null) {
                    oq5 oq5Var = new oq5();
                    oq5Var.a = 3;
                    oq5Var.b(view2);
                    a.O(oq5Var);
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
            xq5 xq5Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof xq5) || (b = (xq5Var = (xq5) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof qq5)) {
                return;
            }
            qq5 qq5Var = (qq5) b.getPageActivity();
            pq5 Y0 = qq5Var.Y0(2);
            if (Y0 == null) {
                sq5 a = tq5.b().a(2);
                if (a == null) {
                    return;
                }
                Y0 = a.a();
                qq5Var.v0(2, Y0);
                Y0.f(new rq5(b), null);
                if (!(Y0 instanceof jq5)) {
                    return;
                }
                ((jq5) Y0).h(new C0216a(this));
            }
            if (!(Y0 instanceof jq5)) {
                return;
            }
            jq5 jq5Var = (jq5) Y0;
            if (xq5Var.a() == 1) {
                jq5Var.b(xq5Var.g());
                jq5Var.c(xq5Var.d());
                jq5Var.j();
            } else if (xq5Var.a() == 2) {
                jq5Var.l(xq5Var.f());
            } else if (xq5Var.a() == 3) {
                ao e = xq5Var.e();
                if (e != null && jq5Var.getView() != null) {
                    e.removeHeaderView(jq5Var.getView());
                }
            } else if (xq5Var.a() == 4) {
                jq5Var.a(xq5Var.h());
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
