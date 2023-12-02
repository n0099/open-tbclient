package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.a16;
import com.baidu.tieba.m06;
import com.baidu.tieba.r06;
import com.baidu.tieba.ri;
import com.baidu.tieba.s06;
import com.baidu.tieba.t06;
import com.baidu.tieba.u06;
import com.baidu.tieba.v06;
import com.baidu.tieba.w06;
import com.baidu.tieba.z06;
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
        public class C0225a implements m06.a {
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

            @Override // com.baidu.tieba.m06.a
            public void a(u06 u06Var, View view2) {
                t06 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, u06Var, view2) == null) && (a = z06.a(u06Var)) != null) {
                    r06 r06Var = new r06();
                    r06Var.a = 2;
                    r06Var.b(view2);
                    a.o0(r06Var);
                }
            }

            @Override // com.baidu.tieba.m06.a
            public void b(u06 u06Var, View view2) {
                t06 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u06Var, view2) == null) && (a = z06.a(u06Var)) != null) {
                    r06 r06Var = new r06();
                    r06Var.a = 3;
                    r06Var.b(view2);
                    a.o0(r06Var);
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
            a16 a16Var;
            TbPageContext b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof a16) || (b = (a16Var = (a16) customResponsedMessage.getData()).b()) == null || !(b.getPageActivity() instanceof t06)) {
                return;
            }
            t06 t06Var = (t06) b.getPageActivity();
            s06 T1 = t06Var.T1(2);
            if (T1 == null) {
                v06 a = w06.b().a(2);
                if (a == null) {
                    return;
                }
                T1 = a.a();
                t06Var.f1(2, T1);
                T1.f(new u06(b), null);
                if (!(T1 instanceof m06)) {
                    return;
                }
                ((m06) T1).h(new C0225a(this));
            }
            if (!(T1 instanceof m06)) {
                return;
            }
            m06 m06Var = (m06) T1;
            if (a16Var.a() == 1) {
                m06Var.b(a16Var.g());
                m06Var.c(a16Var.d());
                m06Var.j();
            } else if (a16Var.a() == 2) {
                m06Var.l(a16Var.f());
            } else if (a16Var.a() == 3) {
                ri e = a16Var.e();
                if (e != null && m06Var.getView() != null) {
                    e.removeHeaderView(m06Var.getView());
                }
            } else if (a16Var.a() == 4) {
                m06Var.a(a16Var.h());
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
