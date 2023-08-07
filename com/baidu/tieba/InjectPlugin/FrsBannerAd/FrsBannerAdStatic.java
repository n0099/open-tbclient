package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.an;
import com.baidu.tieba.i26;
import com.baidu.tieba.n26;
import com.baidu.tieba.o26;
import com.baidu.tieba.p26;
import com.baidu.tieba.q26;
import com.baidu.tieba.r26;
import com.baidu.tieba.s26;
import com.baidu.tieba.v26;
import com.baidu.tieba.w26;
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
        public class C0232a implements i26.a {
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

            @Override // com.baidu.tieba.i26.a
            public void a(q26 q26Var, View view2) {
                p26 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, q26Var, view2) == null) && (a = v26.a(q26Var)) != null) {
                    n26 n26Var = new n26();
                    n26Var.a = 2;
                    n26Var.b(view2);
                    a.T(n26Var);
                }
            }

            @Override // com.baidu.tieba.i26.a
            public void b(q26 q26Var, View view2) {
                p26 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q26Var, view2) == null) && (a = v26.a(q26Var)) != null) {
                    n26 n26Var = new n26();
                    n26Var.a = 3;
                    n26Var.b(view2);
                    a.T(n26Var);
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
            w26 w26Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof w26) || (b = (w26Var = (w26) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof p26)) {
                return;
            }
            p26 p26Var = (p26) b.getPageActivity();
            o26 e1 = p26Var.e1(2);
            if (e1 == null) {
                r26 a = s26.b().a(2);
                if (a == null) {
                    return;
                }
                e1 = a.a();
                p26Var.B0(2, e1);
                e1.f(new q26(b), null);
                if (!(e1 instanceof i26)) {
                    return;
                }
                ((i26) e1).h(new C0232a(this));
            }
            if (!(e1 instanceof i26)) {
                return;
            }
            i26 i26Var = (i26) e1;
            if (w26Var.a() == 1) {
                i26Var.b(w26Var.g());
                i26Var.c(w26Var.d());
                i26Var.j();
            } else if (w26Var.a() == 2) {
                i26Var.l(w26Var.f());
            } else if (w26Var.a() == 3) {
                an e = w26Var.e();
                if (e != null && i26Var.getView() != null) {
                    e.removeHeaderView(i26Var.getView());
                }
            } else if (w26Var.a() == 4) {
                i26Var.a(w26Var.h());
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
