package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tieba.i04;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.Response;
/* loaded from: classes5.dex */
public class f04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public tz3 b;
    public boolean c;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k04 a;
        public final /* synthetic */ yz3 b;
        public final /* synthetic */ f04 c;

        /* renamed from: com.baidu.tieba.f04$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0275a extends ResponseCallback<AdResponseInfo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public final /* synthetic */ a b;

            /* renamed from: com.baidu.tieba.f04$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC0276a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdElementInfo a;
                public final /* synthetic */ C0275a b;

                public RunnableC0276a(C0275a c0275a, AdElementInfo adElementInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0275a, adElementInfo};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = c0275a;
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

            public C0275a(a aVar) {
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
                            w04.c(new RunnableC0276a(this, adResponseInfo.getPrimaryAdInstanceInfo()));
                            return;
                        }
                        if (!this.b.c.c) {
                            a aVar2 = this.b;
                            aVar2.c.j(aVar2.a, "requestNoAd", aVar2.b);
                        }
                        if (this.a == 1 && this.b.a.i.c() == "video" && b14.h()) {
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

        public a(f04 f04Var, k04 k04Var, yz3 yz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f04Var, k04Var, yz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = f04Var;
            this.a = k04Var;
            this.b = yz3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            k04 k04Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (k04Var = this.a) != null && k04Var.i != null) {
                C0275a c0275a = new C0275a(this);
                if (NetworkUtils.f(this.c.a)) {
                    if (this.c.c) {
                        k04 k04Var2 = this.a;
                        if (k04Var2 instanceof l04) {
                            l04 l04Var = (l04) k04Var2;
                            if (this.b != null && l04Var.i() != null) {
                                this.b.a(l04Var.g(), l04Var.i(), c0275a);
                                return;
                            }
                            return;
                        }
                    }
                    this.c.c = false;
                    String g = this.a.g();
                    yz3 yz3Var = this.b;
                    if (yz3Var != null) {
                        yz3Var.f(g, c0275a);
                    }
                    this.c.j(this.a, "request", this.b);
                    return;
                }
                this.c.g("3010003");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ f04 b;

        public b(f04 f04Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f04Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f04Var;
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

    public f04(Context context) {
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
            w04.c(new b(this, str));
        }
    }

    public void k(tz3 tz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tz3Var) == null) {
            this.b = tz3Var;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f04(Context context, boolean z) {
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

    public void i(k04 k04Var, yz3 yz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, k04Var, yz3Var) == null) {
            v04.d(new a(this, k04Var, yz3Var), "execAdRequest");
        }
    }

    public void h(yz3 yz3Var, k04 k04Var, ResponseCallback<AdResponseInfo> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yz3Var, k04Var, responseCallback) == null) {
            if (NetworkUtils.f(this.a)) {
                this.c = true;
                if (k04Var instanceof l04) {
                    l04 l04Var = (l04) k04Var;
                    if (yz3Var != null && l04Var.i() != null) {
                        yz3Var.a(l04Var.g(), l04Var.i(), responseCallback);
                        return;
                    }
                    return;
                }
                i04.b bVar = new i04.b();
                bVar.m(b14.c());
                bVar.j(b14.d());
                bVar.o(k04Var.i.g());
                bVar.l(a14.i(this.a));
                bVar.i(a14.h(this.a));
                l04 l04Var2 = new l04(this.a, bVar.h(), 5, 5);
                if (yz3Var != null && l04Var2.i() != null) {
                    yz3Var.a(l04Var2.g(), l04Var2.i(), responseCallback);
                    return;
                }
                return;
            }
            g("3010003");
        }
    }

    public final void j(k04 k04Var, String str, yz3 yz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, k04Var, str, yz3Var) == null) {
            q04.n(str, q04.a(k04Var.i.c(), k04Var.i.f(), k04Var.i.e(), k04Var.i.b(), false), yz3Var);
        }
    }
}
