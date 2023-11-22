package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.view.headcard.data.QuizCardRespondedMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class a7b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<BaseFragmentActivity> a;
    public FastRequest b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public z6b<QuizCardRespondedMessage.a> h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947569501, "Lcom/baidu/tieba/a7b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947569501, "Lcom/baidu/tieba/a7b;");
        }
    }

    /* loaded from: classes5.dex */
    public static final class a extends FastRequest.b<QuizCardRespondedMessage.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a7b d;

        public a(a7b a7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a7bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = a7bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: m */
        public void i(QuizCardRespondedMessage.a result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                z6b<QuizCardRespondedMessage.a> a = this.d.a();
                if (a != null) {
                    String errorMsg = a();
                    Intrinsics.checkNotNullExpressionValue(errorMsg, "errorMsg");
                    a.a(errorMsg);
                }
                super.i(result);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void e(int i, String errMsg, Exception exc, QuizCardRespondedMessage.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), errMsg, exc, aVar}) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                z6b<QuizCardRespondedMessage.a> a = this.d.a();
                if (a != null) {
                    a.b(errMsg, i, aVar);
                }
                super.f(i, errMsg, aVar);
            }
        }
    }

    public a7b(TbPageContext<BaseFragmentActivity> pageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        this.a = pageContext;
    }

    public final z6b<QuizCardRespondedMessage.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (z6b) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.b == null) {
                this.b = new FastRequest(this.a, CmdConfigHttp.CMD_HTTP_APPLY_MATCH_GUESS, "c/c/matchActivity/applyMatchGuessing");
            }
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                FastRequest fastRequest = this.b;
                Intrinsics.checkNotNull(fastRequest);
                fastRequest.P("product", Long.valueOf(this.c));
                fastRequest.P("user_id", Long.valueOf(this.d));
                fastRequest.P("quiz_id", Long.valueOf(this.e));
                fastRequest.P("pour_count", Long.valueOf(this.f));
                fastRequest.P("option_id", Long.valueOf(this.g));
                fastRequest.R(new a(this));
                fastRequest.Q();
            }
        }
    }

    public final void c(z6b<QuizCardRespondedMessage.a> z6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, z6bVar) == null) {
            this.h = z6bVar;
        }
    }

    public final void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.g = j;
        }
    }

    public final void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f = j;
        }
    }

    public final void f(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.c = j;
        }
    }

    public final void g(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.e = j;
        }
    }

    public final void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.d = j;
        }
    }
}
