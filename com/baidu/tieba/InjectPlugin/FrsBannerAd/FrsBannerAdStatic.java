package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.an;
import com.baidu.tieba.j26;
import com.baidu.tieba.o26;
import com.baidu.tieba.p26;
import com.baidu.tieba.q26;
import com.baidu.tieba.r26;
import com.baidu.tieba.s26;
import com.baidu.tieba.t26;
import com.baidu.tieba.w26;
import com.baidu.tieba.x26;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsBannerAdStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.InjectPlugin.FrsBannerAd.FrsBannerAdStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0232a implements j26.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0232a(a aVar) {
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

            @Override // com.baidu.tieba.j26.a
            public void a(r26 r26Var, View view2) {
                q26 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, r26Var, view2) == null) && (a = w26.a(r26Var)) != null) {
                    o26 o26Var = new o26();
                    o26Var.a = 2;
                    o26Var.b(view2);
                    a.T(o26Var);
                }
            }

            @Override // com.baidu.tieba.j26.a
            public void b(r26 r26Var, View view2) {
                q26 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r26Var, view2) == null) && (a = w26.a(r26Var)) != null) {
                    o26 o26Var = new o26();
                    o26Var.a = 3;
                    o26Var.b(view2);
                    a.T(o26Var);
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
            x26 x26Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof x26) || (b = (x26Var = (x26) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof q26)) {
                return;
            }
            q26 q26Var = (q26) b.getPageActivity();
            p26 e1 = q26Var.e1(2);
            if (e1 == null) {
                s26 a = t26.b().a(2);
                if (a == null) {
                    return;
                }
                e1 = a.a();
                q26Var.B0(2, e1);
                e1.f(new r26(b), null);
                if (!(e1 instanceof j26)) {
                    return;
                }
                ((j26) e1).h(new C0232a(this));
            }
            if (!(e1 instanceof j26)) {
                return;
            }
            j26 j26Var = (j26) e1;
            if (x26Var.a() == 1) {
                j26Var.b(x26Var.g());
                j26Var.c(x26Var.d());
                j26Var.j();
            } else if (x26Var.a() == 2) {
                j26Var.l(x26Var.f());
            } else if (x26Var.a() == 3) {
                an e = x26Var.e();
                if (e != null && j26Var.getView() != null) {
                    e.removeHeaderView(j26Var.getView());
                }
            } else if (x26Var.a() == 4) {
                j26Var.a(x26Var.h());
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
