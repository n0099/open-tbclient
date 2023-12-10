package com.baidu.tieba;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.o53;
import com.baidu.tieba.pb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.client.methods.HttpDelete;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cn1 extends ou1 {
    public static /* synthetic */ Interceptable $ic;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ou1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? "Bookshelf" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? "SwanAppBookshelfApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class b extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ w72 b;
        public final /* synthetic */ cn1 c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c63.a();
                }
            }
        }

        /* renamed from: com.baidu.tieba.cn1$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0240b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0240b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c63.f(rp2.c(), R.string.obfuscated_res_0x7f0f1532).G();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public c(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c63.a();
                }
            }
        }

        public b(cn1 cn1Var, boolean z, w72 w72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cn1Var, Boolean.valueOf(z), w72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cn1Var;
            this.a = z;
            this.b = w72Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (this.a) {
                    ek3.e0(new c(this));
                }
                cn1 cn1Var = this.c;
                w72 w72Var = this.b;
                cn1Var.O(w72Var, 1001, "operation fail, msg = " + exc.getMessage(), this.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (this.a) {
                    ek3.e0(new a(this));
                }
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt != 0) {
                        if (this.a) {
                            ek3.e0(new RunnableC0240b(this));
                        }
                        this.c.O(this.b, optInt, jSONObject.optString("errmsg"), false);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        this.c.P(this.b, optJSONObject, this.a);
                        return;
                    } else {
                        this.c.O(this.b, 0, jSONObject.optString("errmsg"), this.a);
                        return;
                    }
                }
                this.c.O(this.b, 1001, "server response fail", this.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                if (response != null && response.body() != null) {
                    return kj3.d(response.body().string());
                }
                return null;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONArray a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ cn1 d;

        /* loaded from: classes5.dex */
        public class a implements w72<ly1> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.w72
            /* renamed from: b */
            public void a(ly1 ly1Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ly1Var) == null) {
                    f fVar = this.a;
                    fVar.d.d(fVar.c, ly1Var);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public b(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c63.f(this.a.d.i(), R.string.obfuscated_res_0x7f0f1530).G();
                }
            }
        }

        public f(cn1 cn1Var, JSONArray jSONArray, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cn1Var, jSONArray, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = cn1Var;
            this.a = jSONArray;
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (ib3.h(nb3Var)) {
                    int w1 = j63.K().q().X().w1();
                    String x1 = j63.K().q().X().x1();
                    String P = j63.K().q().P();
                    HashMap hashMap = new HashMap();
                    hashMap.put("appKey", P);
                    hashMap.put("contentIds", this.a);
                    hashMap.put("category", this.b);
                    hashMap.put("pkg_type", Integer.valueOf(w1));
                    hashMap.put("version_code", x1);
                    this.d.X("INSERT", hashMap, new a(this));
                    return;
                }
                this.d.d(this.c, new ly1(nb3Var.b(), ib3.f(nb3Var.b())));
                ek3.e0(new b(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONArray a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ cn1 d;

        /* loaded from: classes5.dex */
        public class a implements w72<ly1> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.w72
            /* renamed from: b */
            public void a(ly1 ly1Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ly1Var) == null) {
                    g gVar = this.a;
                    gVar.d.d(gVar.c, ly1Var);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public b(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c63.f(this.a.d.i(), R.string.obfuscated_res_0x7f0f1530).G();
                }
            }
        }

        public g(cn1 cn1Var, JSONArray jSONArray, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cn1Var, jSONArray, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = cn1Var;
            this.a = jSONArray;
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (ib3.h(nb3Var)) {
                    int w1 = j63.K().q().X().w1();
                    String x1 = j63.K().q().X().x1();
                    String P = j63.K().q().P();
                    HashMap hashMap = new HashMap();
                    hashMap.put("appKey", P);
                    hashMap.put("contentIds", this.a);
                    hashMap.put("category", this.b);
                    hashMap.put("pkg_type", Integer.valueOf(w1));
                    hashMap.put("version_code", x1);
                    this.d.X(HttpDelete.METHOD_NAME, hashMap, new a(this));
                    return;
                }
                this.d.d(this.c, new ly1(nb3Var.b(), ib3.f(nb3Var.b())));
                ek3.e0(new b(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ cn1 e;

        /* loaded from: classes5.dex */
        public class a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                }
            }

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    j63.K().q().f0().E();
                }
            }
        }

        public l(cn1 cn1Var, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cn1Var, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = cn1Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o53.a aVar = new o53.a(this.e.i());
                aVar.V(this.a);
                aVar.x(this.b);
                aVar.y();
                aVar.n(new sl3());
                aVar.m(false);
                aVar.P(this.c, new b(this));
                aVar.C(this.d, new a(this));
                aVar.X();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cn1 a;

        public a(cn1 cn1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cn1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cn1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c63 f = c63.f(this.a.i(), R.string.obfuscated_res_0x7f0f1531);
                f.l(10);
                f.s(false);
                f.z();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public c(cn1 cn1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cn1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c63.g(rp2.c(), this.a).G();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cn1 a;

        public d(cn1 cn1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cn1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cn1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c63.f(this.a.i(), R.string.obfuscated_res_0x7f0f01d7).G();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cn1 a;

        public e(cn1 cn1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cn1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cn1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c63.f(this.a.i(), R.string.obfuscated_res_0x7f0f01d7).G();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements w72<ly1> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ cn1 b;

        public h(cn1 cn1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cn1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cn1Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.w72
        /* renamed from: b */
        public void a(ly1 ly1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ly1Var) == null) {
                this.b.d(this.a, ly1Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements w72<ly1> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ cn1 b;

        public i(cn1 cn1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cn1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cn1Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.w72
        /* renamed from: b */
        public void a(ly1 ly1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ly1Var) == null) {
                this.b.d(this.a, ly1Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements xm1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cn1 c;

        public j(cn1 cn1Var, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cn1Var, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cn1Var;
            this.a = z;
            this.b = str;
        }

        @Override // com.baidu.tieba.xm1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    if (!this.a) {
                        dd3.S("fail", 10, "api");
                    }
                    this.c.d(this.b, new ly1(1001, "user is not login"));
                    return;
                }
                if (!this.a) {
                    dd3.S("success", 10, "api");
                }
                this.c.T(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements CallbackHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ cn1 b;

        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
        public String getCurrentPageUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        public k(cn1 cn1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cn1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cn1Var;
            this.a = str;
        }

        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
        public void handleSchemeDispatchCallback(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) != null) {
                return;
            }
            this.b.R(str2, this.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cn1(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((mu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            k63 q = j63.K().q();
            q.N().f(q.w(), null, new j(this, q.N().e(i()), str));
        }
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            rp2.l0().d(new k(this, str));
        }
    }

    public final void J(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, jSONArray, str, str2) == null) {
            j63.K().q().f0().g(i(), "scope_insert_bookshelf", new g(this, jSONArray, str, str2));
        }
    }

    public final void K(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray, str, str2) == null) {
            j63.K().q().f0().g(i(), "scope_insert_bookshelf", new f(this, jSONArray, str, str2));
        }
    }

    public final void P(w72<ly1> w72Var, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, w72Var, jSONObject, z) == null) {
            if (w72Var != null && jSONObject != null) {
                w72Var.a(new ly1(0, jSONObject));
            }
            if (z) {
                rp2.l0().b(i());
            }
        }
    }

    public ly1 L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#deleteBookshelf", false);
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            JSONObject jSONObject = (JSONObject) t.second;
            if (ly1Var.isSuccess() && jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    String optString = jSONObject.optString("category");
                    if (TextUtils.isEmpty(optString)) {
                        return new ly1(201, "category is invalid");
                    }
                    String optString2 = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString2)) {
                        return new ly1(202, "cb is invalid");
                    }
                    if (!SwanAppNetworkUtils.i(i())) {
                        ek3.e0(new e(this));
                        return new ly1(1001, "network is not connected");
                    } else if (S()) {
                        N();
                        return new ly1(10003, ib3.f(10003));
                    } else {
                        J(optJSONArray, optString, optString2);
                        return ly1.f();
                    }
                }
                return new ly1(201, "contentIds is invalid");
            }
            return ly1Var;
        }
        return (ly1) invokeL.objValue;
    }

    public ly1 Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            r("#insertBookshelf", false);
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            JSONObject jSONObject = (JSONObject) t.second;
            if (ly1Var.isSuccess() && jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    String optString = jSONObject.optString("category");
                    f = optString;
                    if (TextUtils.isEmpty(optString)) {
                        return new ly1(201, "category is invalid");
                    }
                    String optString2 = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString2)) {
                        return new ly1(202, "cb is invalid");
                    }
                    if (!SwanAppNetworkUtils.i(i())) {
                        ek3.e0(new d(this));
                        return new ly1(1001, "network is not connected");
                    } else if (S()) {
                        N();
                        return new ly1(10003, ib3.f(10003));
                    } else {
                        K(optJSONArray, f, optString2);
                        return ly1.f();
                    }
                }
                return new ly1(201, "contentIds is invalid");
            }
            return ly1Var;
        }
        return (ly1) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final String M(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            switch (str.hashCode()) {
                case -2130463047:
                    if (str.equals("INSERT")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 77406376:
                    if (str.equals("QUERY")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1020968928:
                    if (str.equals("UPDATE_READ_TIME")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2012838315:
                    if (str.equals(HttpDelete.METHOD_NAME)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            return null;
                        }
                        return rp2.o().H();
                    }
                    return rp2.o().y();
                }
                return rp2.o().h();
            }
            return rp2.o().w();
        }
        return (String) invokeL.objValue;
    }

    public ly1 V(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            r("#navigateToBookshelf", false);
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            JSONObject jSONObject = (JSONObject) t.second;
            if (ly1Var.isSuccess() && jSONObject != null) {
                f = jSONObject.optString("category");
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new ly1(202, "cb is invalid");
                }
                if (!j63.K().q().N().e(i())) {
                    dd3.S("show", 10, "api");
                    U(optString);
                    return ly1.f();
                }
                T(optString);
                return ly1.f();
            }
            return ly1Var;
        }
        return (ly1) invokeL.objValue;
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ek3.e0(new l(this, i().getString(R.string.obfuscated_res_0x7f0f1534), i().getString(R.string.obfuscated_res_0x7f0f1533), i().getString(R.string.obfuscated_res_0x7f0f15ce), i().getString(R.string.obfuscated_res_0x7f0f156a)));
        }
    }

    public final void O(w72<ly1> w72Var, int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{w72Var, Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            if (w72Var != null) {
                w72Var.a(new ly1(i2, str));
            }
            if (z) {
                ek3.e0(new c(this, str));
            }
        }
    }

    public final void R(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            int i2 = 1001;
            if (TextUtils.isEmpty(str)) {
                d(str2, new ly1(1001, "navigateToBookshelf fail"));
            }
            try {
                i2 = new JSONObject(str).optInt("status", 1001);
            } catch (JSONException e2) {
                q("json put data fail", e2, false);
            }
            if (i2 == 0) {
                d(str2, new ly1(i2, "navigateToBookshelf success"));
            } else {
                d(str2, new ly1(i2, "navigateToBookshelf fail"));
            }
        }
    }

    public final boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            kb3 kb3Var = iy2.g(true).get("scope_insert_bookshelf");
            if (kb3Var == null) {
                return true;
            }
            if (kb3Var.j < 0 && !kb3Var.d) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ly1 W(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            r("#queryBookshelf", false);
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            JSONObject jSONObject = (JSONObject) t.second;
            if (ly1Var.isSuccess() && jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    String optString = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        return new ly1(202, "cb is invalid");
                    }
                    if (!SwanAppNetworkUtils.i(i())) {
                        return new ly1(1001, "network is not connected");
                    }
                    if (!j63.K().q().N().e(i())) {
                        return new ly1(1001, "user is not login");
                    }
                    Object P = j63.K().q().P();
                    int w1 = j63.K().q().X().w1();
                    Object x1 = j63.K().q().X().x1();
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("appKey", P);
                    hashMap.put("contentIds", optJSONArray);
                    hashMap.put("pkg_type", Integer.valueOf(w1));
                    hashMap.put("version_code", x1);
                    X("QUERY", hashMap, new h(this, optString));
                    return ly1.f();
                }
                return new ly1(201, "contentIds is invalid");
            }
            return ly1Var;
        }
        return (ly1) invokeL.objValue;
    }

    public ly1 Y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            r("#updateBookshelfReadTime", false);
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            JSONObject jSONObject = (JSONObject) t.second;
            if (ly1Var.isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("contentId");
                if (TextUtils.isEmpty(optString)) {
                    return new ly1(201, "contentId is invalid");
                }
                String optString2 = jSONObject.optString("category");
                if (TextUtils.isEmpty(optString2)) {
                    return new ly1(201, "category is invalid");
                }
                String optString3 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString3)) {
                    return new ly1(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(i())) {
                    return new ly1(1001, "network is not connected");
                }
                if (!j63.K().q().N().e(i())) {
                    return new ly1(1001, "user is not login");
                }
                Object P = j63.K().q().P();
                int w1 = j63.K().q().X().w1();
                Object x1 = j63.K().q().X().x1();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("appKey", P);
                hashMap.put("contentId", optString);
                hashMap.put("category", optString2);
                hashMap.put("pkg_type", Integer.valueOf(w1));
                hashMap.put("version_code", x1);
                X("UPDATE_READ_TIME", hashMap, new i(this, optString3));
                return ly1.f();
            }
            return ly1Var;
        }
        return (ly1) invokeL.objValue;
    }

    public final void X(String str, HashMap<String, Object> hashMap, w72<ly1> w72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, str, hashMap, w72Var) == null) {
            boolean equals = TextUtils.equals(str, "INSERT");
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception unused) {
            }
            RequestBody create = RequestBody.create(rx2.a, jSONObject.toString());
            String M = M(str);
            if (TextUtils.isEmpty(M)) {
                O(w72Var, 1001, "operation fail, msg = url is null", equals);
                return;
            }
            if (equals) {
                ek3.e0(new a(this));
            }
            nd4 nd4Var = new nd4(M, create, new b(this, equals, w72Var));
            if (od4.g().c()) {
                nd4Var.f = true;
            }
            nd4Var.g = true;
            od4.g().e(nd4Var);
        }
    }
}
