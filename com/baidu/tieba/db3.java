package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tieba.aw1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class db3 extends wy1 {
    public static /* synthetic */ Interceptable $ic;
    public static df2 f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.aw1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "PreloadPackageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements aw1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db3 a;

        /* renamed from: com.baidu.tieba.db3$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0240a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONObject a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ a d;

            /* renamed from: com.baidu.tieba.db3$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0241a implements mf4 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ RunnableC0240a b;

                public C0241a(RunnableC0240a runnableC0240a, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0240a, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = runnableC0240a;
                    this.a = str;
                }

                @Override // com.baidu.tieba.mf4
                public void a(@Nullable Map<String, String> map) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
                        if (map == null) {
                            x42.c("PreloadPackageApi", "preloadPackage keyMap null");
                            return;
                        }
                        RunnableC0240a runnableC0240a = this.b;
                        runnableC0240a.d.a.z(map.get(this.b.b), this.a, runnableC0240a.c);
                    }
                }

                @Override // com.baidu.tieba.mf4
                public void onFail(Exception exc) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                        x42.c("PreloadPackageApi", "preloadPackage transform openBundleId fail");
                    }
                }
            }

            public RunnableC0240a(a aVar, JSONObject jSONObject, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jSONObject, str, str2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = aVar;
                this.a = jSONObject;
                this.b = str;
                this.c = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    boolean g = mk4.e().g(!rl3.G());
                    String optString = this.a.optString(PrefetchEvent.EVENT_KEY_PAGE_URL);
                    if (g) {
                        hf4.e(Collections.singletonList(this.b), db3.f.c(), new C0241a(this, optString));
                    } else {
                        this.d.a.z(this.b, optString, this.c);
                    }
                }
            }
        }

        public a(db3 db3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db3Var;
        }

        @Override // com.baidu.tieba.aw1.a
        public xz1 a(x73 x73Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, x73Var, jSONObject, str)) == null) {
                String optString = jSONObject.optString("appKey");
                if (TextUtils.isEmpty(optString)) {
                    return new xz1(202, "appKey must not empty");
                }
                if (!db3.f.a(1)) {
                    return new xz1(402, "over single max limit");
                }
                rk3.h().execute(new RunnableC0240a(this, jSONObject, optString, str), "PreloadPackageApi");
                return xz1.f();
            }
            return (xz1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                String string = bundle.getString("appKey");
                String e1 = vs2.e1(string, bundle.getString(PrefetchEvent.EVENT_KEY_PAGE_URL), 0, null);
                PrefetchEvent.b bVar = new PrefetchEvent.b();
                bVar.e("show");
                bVar.d(e1);
                bVar.c("10");
                bVar.a(string);
                wb2.g().f(bVar.b());
                return null;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public db3(@NonNull yv1 yv1Var) {
        super(yv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yv1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((yv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public xz1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#preloadPackage", false);
            String a2 = zz1.a(w73.K().getAppId());
            if (TextUtils.isEmpty(a2)) {
                return new xz1(101, "runtime parameter error");
            }
            df2 df2Var = f;
            if (df2Var == null || !df2Var.d(a2)) {
                f = new df2(a2, jk4.b(a2));
            }
            if (f.e()) {
                return new xz1(402, "over max limit");
            }
            if (!f.b()) {
                return new xz1(402, "over time interval limit");
            }
            return l(str, false, new a(this));
        }
        return (xz1) invokeL.objValue;
    }

    public final void z(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("appKey", str);
            bundle.putString(PrefetchEvent.EVENT_KEY_PAGE_URL, str2);
            k43.b(b.class, bundle);
        }
    }
}
