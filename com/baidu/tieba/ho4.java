package com.baidu.tieba;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public interface ho4 {
    String a(String str);

    WebResourceResponse b(Uri uri);

    <Target> Target c(WebResourceResponse webResourceResponse, Function1<? super WebResourceResponse, ? extends Target> function1);

    /* loaded from: classes6.dex */
    public static class a implements ho4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ho4 a;

        @Override // com.baidu.tieba.ho4
        public String a(String url) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, url)) == null) {
                Intrinsics.checkNotNullParameter(url, "url");
                return this.a.a(url);
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ho4
        public WebResourceResponse b(Uri url) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, url)) == null) {
                Intrinsics.checkNotNullParameter(url, "url");
                return this.a.b(url);
            }
            return (WebResourceResponse) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ho4
        public <Target> Target c(WebResourceResponse webResourceResponse, Function1<? super WebResourceResponse, ? extends Target> transform) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webResourceResponse, transform)) == null) {
                Intrinsics.checkNotNullParameter(transform, "transform");
                return (Target) this.a.c(webResourceResponse, transform);
            }
            return (Target) invokeLL.objValue;
        }

        public a(ho4 delegation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {delegation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(delegation, "delegation");
            this.a = delegation;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Inject
        public sf1<ho4> a;

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                qf1 b = qf1.b();
                this.a = b;
                b.a(new io4());
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            b();
        }

        public final sf1<ho4> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                sf1<ho4> sf1Var = this.a;
                if (sf1Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                }
                return sf1Var;
            }
            return (sf1) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public c(b ioc) {
            super(r7);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ioc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ho4) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(ioc, "ioc");
            ho4 ho4Var = ioc.a().get();
            Intrinsics.checkNotNullExpressionValue(ho4Var, "ioc.impl.get()");
        }
    }
}
