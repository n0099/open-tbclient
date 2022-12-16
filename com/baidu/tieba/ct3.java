package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tieba.ft3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.Response;
/* loaded from: classes4.dex */
public class ct3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public qs3 b;
    public boolean c;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ht3 a;
        public final /* synthetic */ vs3 b;
        public final /* synthetic */ ct3 c;

        /* renamed from: com.baidu.tieba.ct3$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0241a extends ResponseCallback<AdResponseInfo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public final /* synthetic */ a b;

            /* renamed from: com.baidu.tieba.ct3$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0242a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdElementInfo a;
                public final /* synthetic */ C0241a b;

                public RunnableC0242a(C0241a c0241a, AdElementInfo adElementInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0241a, adElementInfo};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = c0241a;
                    this.a = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.b.c.b != null) {
                        this.b.b.c.b.c(this.a);
                    }
                }
            }

            public C0241a(a aVar) {
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
                        return;
                    }
                }
                this.b = aVar;
                this.a = 0;
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) != null) {
                    return;
                }
                this.b.c.g("3010002");
                a aVar = this.b;
                aVar.c.j(aVar.a, "requestFail", aVar.b);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, adResponseInfo, i) == null) {
                    a aVar = this.b;
                    aVar.c.j(aVar.a, "requestSuccess", aVar.b);
                    if (adResponseInfo != null) {
                        if (adResponseInfo.getAdInstanceList().size() > 0) {
                            tt3.c(new RunnableC0242a(this, adResponseInfo.getPrimaryAdInstanceInfo()));
                            return;
                        }
                        if (!this.b.c.c) {
                            a aVar2 = this.b;
                            aVar2.c.j(aVar2.a, "requestNoAd", aVar2.b);
                        }
                        if (this.a == 1 && this.b.a.i.c() == "video" && yt3.h()) {
                            a aVar3 = this.b;
                            aVar3.c.h(aVar3.b, aVar3.a, this);
                            return;
                        }
                        this.a = 0;
                        String errorCode = adResponseInfo.getErrorCode();
                        if (errorCode.equals("0")) {
                            errorCode = "201000";
                        }
                        this.b.c.g(errorCode);
                        return;
                    }
                    this.b.c.g("200000");
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public AdResponseInfo parseResponse(Response response, int i) {
                InterceptResult invokeLI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                    if (response != null && response.body() != null) {
                        this.a++;
                        if (!response.isSuccessful()) {
                            return null;
                        }
                        try {
                            String string = response.body().string();
                            if (!TextUtils.isEmpty(string)) {
                                if (this.b.c.c) {
                                    return new AdResponseInfo(string, this.b.c.c);
                                }
                                return new AdResponseInfo(string);
                            }
                        } catch (Exception | OutOfMemoryError unused) {
                        }
                    }
                    return null;
                }
                return (AdResponseInfo) invokeLI.objValue;
            }
        }

        public a(ct3 ct3Var, ht3 ht3Var, vs3 vs3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ct3Var, ht3Var, vs3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ct3Var;
            this.a = ht3Var;
            this.b = vs3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            ht3 ht3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ht3Var = this.a) != null && ht3Var.i != null) {
                C0241a c0241a = new C0241a(this);
                if (NetworkUtils.f(this.c.a)) {
                    if (this.c.c) {
                        ht3 ht3Var2 = this.a;
                        if (ht3Var2 instanceof it3) {
                            it3 it3Var = (it3) ht3Var2;
                            if (this.b != null && it3Var.i() != null) {
                                this.b.a(it3Var.g(), it3Var.i(), c0241a);
                                return;
                            }
                            return;
                        }
                    }
                    this.c.c = false;
                    String g = this.a.g();
                    vs3 vs3Var = this.b;
                    if (vs3Var != null) {
                        vs3Var.f(g, c0241a);
                    }
                    this.c.j(this.a, "request", this.b);
                    return;
                }
                this.c.g("3010003");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ct3 b;

        public b(ct3 ct3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ct3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ct3Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.b != null) {
                this.b.b.a(this.a);
            }
        }
    }

    public ct3(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            tt3.c(new b(this, str));
        }
    }

    public void k(qs3 qs3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, qs3Var) == null) {
            this.b = qs3Var;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ct3(Context context, boolean z) {
        this(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = z;
    }

    public void i(ht3 ht3Var, vs3 vs3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ht3Var, vs3Var) == null) {
            st3.d(new a(this, ht3Var, vs3Var), "execAdRequest");
        }
    }

    public void h(vs3 vs3Var, ht3 ht3Var, ResponseCallback<AdResponseInfo> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vs3Var, ht3Var, responseCallback) == null) {
            if (NetworkUtils.f(this.a)) {
                this.c = true;
                if (ht3Var instanceof it3) {
                    it3 it3Var = (it3) ht3Var;
                    if (vs3Var != null && it3Var.i() != null) {
                        vs3Var.a(it3Var.g(), it3Var.i(), responseCallback);
                        return;
                    }
                    return;
                }
                ft3.b bVar = new ft3.b();
                bVar.m(yt3.c());
                bVar.j(yt3.d());
                bVar.o(ht3Var.i.g());
                bVar.l(xt3.i(this.a));
                bVar.i(xt3.h(this.a));
                it3 it3Var2 = new it3(this.a, bVar.h(), 5, 5);
                if (vs3Var != null && it3Var2.i() != null) {
                    vs3Var.a(it3Var2.g(), it3Var2.i(), responseCallback);
                    return;
                }
                return;
            }
            g("3010003");
        }
    }

    public final void j(ht3 ht3Var, String str, vs3 vs3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, ht3Var, str, vs3Var) == null) {
            nt3.n(str, nt3.a(ht3Var.i.c(), ht3Var.i.f(), ht3Var.i.e(), ht3Var.i.b(), false), vs3Var);
        }
    }
}
