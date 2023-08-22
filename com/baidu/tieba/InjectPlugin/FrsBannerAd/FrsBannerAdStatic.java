package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.a36;
import com.baidu.tieba.dn;
import com.baidu.tieba.f36;
import com.baidu.tieba.g36;
import com.baidu.tieba.h36;
import com.baidu.tieba.i36;
import com.baidu.tieba.j36;
import com.baidu.tieba.k36;
import com.baidu.tieba.n36;
import com.baidu.tieba.o36;
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
        public class C0232a implements a36.a {
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

            @Override // com.baidu.tieba.a36.a
            public void a(i36 i36Var, View view2) {
                h36 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, i36Var, view2) == null) && (a = n36.a(i36Var)) != null) {
                    f36 f36Var = new f36();
                    f36Var.a = 2;
                    f36Var.b(view2);
                    a.Y(f36Var);
                }
            }

            @Override // com.baidu.tieba.a36.a
            public void b(i36 i36Var, View view2) {
                h36 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i36Var, view2) == null) && (a = n36.a(i36Var)) != null) {
                    f36 f36Var = new f36();
                    f36Var.a = 3;
                    f36Var.b(view2);
                    a.Y(f36Var);
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
            o36 o36Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof o36) || (b = (o36Var = (o36) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof h36)) {
                return;
            }
            h36 h36Var = (h36) b.getPageActivity();
            g36 n1 = h36Var.n1(2);
            if (n1 == null) {
                j36 a = k36.b().a(2);
                if (a == null) {
                    return;
                }
                n1 = a.a();
                h36Var.I0(2, n1);
                n1.f(new i36(b), null);
                if (!(n1 instanceof a36)) {
                    return;
                }
                ((a36) n1).h(new C0232a(this));
            }
            if (!(n1 instanceof a36)) {
                return;
            }
            a36 a36Var = (a36) n1;
            if (o36Var.a() == 1) {
                a36Var.b(o36Var.g());
                a36Var.c(o36Var.d());
                a36Var.j();
            } else if (o36Var.a() == 2) {
                a36Var.l(o36Var.f());
            } else if (o36Var.a() == 3) {
                dn e = o36Var.e();
                if (e != null && a36Var.getView() != null) {
                    e.removeHeaderView(a36Var.getView());
                }
            } else if (o36Var.a() == 4) {
                a36Var.a(o36Var.h());
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
