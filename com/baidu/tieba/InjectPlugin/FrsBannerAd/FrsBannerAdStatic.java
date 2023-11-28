package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i06;
import com.baidu.tieba.n06;
import com.baidu.tieba.o06;
import com.baidu.tieba.p06;
import com.baidu.tieba.q06;
import com.baidu.tieba.r06;
import com.baidu.tieba.ri;
import com.baidu.tieba.s06;
import com.baidu.tieba.v06;
import com.baidu.tieba.w06;
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
        public class C0225a implements i06.a {
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

            @Override // com.baidu.tieba.i06.a
            public void a(q06 q06Var, View view2) {
                p06 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, q06Var, view2) == null) && (a = v06.a(q06Var)) != null) {
                    n06 n06Var = new n06();
                    n06Var.a = 2;
                    n06Var.b(view2);
                    a.o0(n06Var);
                }
            }

            @Override // com.baidu.tieba.i06.a
            public void b(q06 q06Var, View view2) {
                p06 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q06Var, view2) == null) && (a = v06.a(q06Var)) != null) {
                    n06 n06Var = new n06();
                    n06Var.a = 3;
                    n06Var.b(view2);
                    a.o0(n06Var);
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
            w06 w06Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof w06) || (b = (w06Var = (w06) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof p06)) {
                return;
            }
            p06 p06Var = (p06) b.getPageActivity();
            o06 T1 = p06Var.T1(2);
            if (T1 == null) {
                r06 a = s06.b().a(2);
                if (a == null) {
                    return;
                }
                T1 = a.a();
                p06Var.f1(2, T1);
                T1.f(new q06(b), null);
                if (!(T1 instanceof i06)) {
                    return;
                }
                ((i06) T1).h(new C0225a(this));
            }
            if (!(T1 instanceof i06)) {
                return;
            }
            i06 i06Var = (i06) T1;
            if (w06Var.a() == 1) {
                i06Var.b(w06Var.g());
                i06Var.c(w06Var.d());
                i06Var.j();
            } else if (w06Var.a() == 2) {
                i06Var.l(w06Var.f());
            } else if (w06Var.a() == 3) {
                ri e = w06Var.e();
                if (e != null && i06Var.getView() != null) {
                    e.removeHeaderView(i06Var.getView());
                }
            } else if (w06Var.a() == 4) {
                i06Var.a(w06Var.h());
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
