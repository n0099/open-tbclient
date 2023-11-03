package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.a06;
import com.baidu.tieba.f06;
import com.baidu.tieba.g06;
import com.baidu.tieba.h06;
import com.baidu.tieba.i06;
import com.baidu.tieba.j06;
import com.baidu.tieba.k06;
import com.baidu.tieba.n06;
import com.baidu.tieba.o06;
import com.baidu.tieba.qi;
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
        public class C0225a implements a06.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0225a(a aVar) {
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

            @Override // com.baidu.tieba.a06.a
            public void a(i06 i06Var, View view2) {
                h06 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, i06Var, view2) == null) && (a = n06.a(i06Var)) != null) {
                    f06 f06Var = new f06();
                    f06Var.a = 2;
                    f06Var.b(view2);
                    a.l0(f06Var);
                }
            }

            @Override // com.baidu.tieba.a06.a
            public void b(i06 i06Var, View view2) {
                h06 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i06Var, view2) == null) && (a = n06.a(i06Var)) != null) {
                    f06 f06Var = new f06();
                    f06Var.a = 3;
                    f06Var.b(view2);
                    a.l0(f06Var);
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
            o06 o06Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof o06) || (b = (o06Var = (o06) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof h06)) {
                return;
            }
            h06 h06Var = (h06) b.getPageActivity();
            g06 H1 = h06Var.H1(2);
            if (H1 == null) {
                j06 a = k06.b().a(2);
                if (a == null) {
                    return;
                }
                H1 = a.a();
                h06Var.Z0(2, H1);
                H1.f(new i06(b), null);
                if (!(H1 instanceof a06)) {
                    return;
                }
                ((a06) H1).h(new C0225a(this));
            }
            if (!(H1 instanceof a06)) {
                return;
            }
            a06 a06Var = (a06) H1;
            if (o06Var.a() == 1) {
                a06Var.b(o06Var.g());
                a06Var.c(o06Var.d());
                a06Var.j();
            } else if (o06Var.a() == 2) {
                a06Var.l(o06Var.f());
            } else if (o06Var.a() == 3) {
                qi e = o06Var.e();
                if (e != null && a06Var.getView() != null) {
                    e.removeHeaderView(a06Var.getView());
                }
            } else if (o06Var.a() == 4) {
                a06Var.a(o06Var.h());
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
