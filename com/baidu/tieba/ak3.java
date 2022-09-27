package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tieba.q83;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ak3 extends q83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String v;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b extends k83 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ak3 c;

        /* loaded from: classes3.dex */
        public class a implements ei3<l83> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                        return;
                    }
                }
                this.a = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ei3
            /* renamed from: b */
            public void a(l83 l83Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l83Var) == null) {
                    if (i83.f) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("ListPreparation result: ");
                        sb.append(l83Var == null ? StringUtil.NULL_STRING : l83Var);
                        Log.i("aiapps-oauth", sb.toString());
                    }
                    this.a.c.r = l83Var;
                    if (l83Var == null) {
                        this.a.e(new Exception("no such scope"));
                        return;
                    }
                    if (l83Var.e() && !this.a.c.q) {
                        ak3 ak3Var = this.a.c;
                        ak3Var.h(new c(ak3Var, null));
                    } else {
                        ak3 ak3Var2 = this.a.c;
                        ak3Var2.h(new q83.b(ak3Var2));
                    }
                    this.a.d();
                }
            }
        }

        public b(ak3 ak3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ak3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ak3Var;
        }

        @Override // com.baidu.tieba.k83
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (TextUtils.isEmpty(this.c.s)) {
                    if (this.c.m.length <= 1) {
                        jv2.i(this.c.m[0], new a(this));
                        return false;
                    }
                    d();
                    return false;
                }
                d();
                return false;
            }
            return invokeV.booleanValue;
        }

        public /* synthetic */ b(ak3 ak3Var, a aVar) {
            this(ak3Var);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends k83 implements xj1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ak3 c;

        public c(ak3 ak3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ak3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ak3Var;
        }

        @Override // com.baidu.tieba.k83
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.c.q = true;
                if (this.c.M().N().e(this.c.n)) {
                    j83.k("LoginPreparation: isLogin true", Boolean.FALSE);
                    ak3 ak3Var = this.c;
                    ak3Var.h(new d(ak3Var, null));
                    return true;
                }
                l33 M = this.c.M();
                if (!M.n0()) {
                    if (this.c.n instanceof Activity) {
                        M.N().f((Activity) this.c.n, null, this);
                        return false;
                    }
                    j83.k("login error context is not activity.", Boolean.TRUE);
                    e(new OAuthException(10004));
                    return true;
                }
                j83.k("this operation does not supported when app is invisible.", Boolean.TRUE);
                e(new OAuthException(10004));
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.xj1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                j83.k("onResult :: " + i, Boolean.FALSE);
                if (i == -2) {
                    j83.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    e(new OAuthException(10004));
                } else if (i != 0) {
                    j83.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                    e(new OAuthException(10004));
                } else {
                    j83.k("Login Preparation ok, is already login", Boolean.FALSE);
                    ak3 ak3Var = this.c;
                    ak3Var.h(new d(ak3Var, null));
                    d();
                }
            }
        }

        public /* synthetic */ c(ak3 ak3Var, a aVar) {
            this(ak3Var);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends k83 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ak3 c;

        /* loaded from: classes3.dex */
        public class a implements ei3<Bundle> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ei3
            /* renamed from: b */
            public void a(Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                    if (bundle == null) {
                        this.a.e(new OAuthException("null stoken", 10001));
                        return;
                    }
                    String string = bundle.getString(BdZeusUtil.URL_KEY_MACHINE, "");
                    if (!TextUtils.isEmpty(string)) {
                        this.a.c.v = string;
                        ak3 ak3Var = this.a.c;
                        ak3Var.h(new b(ak3Var, null));
                        this.a.d();
                        return;
                    }
                    this.a.e(new OAuthException("empty stoken", 10001));
                }
            }
        }

        public d(ak3 ak3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ak3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ak3Var;
        }

        @Override // com.baidu.tieba.k83
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                mj3.t(this.c.n, new a(this), BdZeusUtil.URL_KEY_MACHINE);
                return false;
            }
            return invokeV.booleanValue;
        }

        public /* synthetic */ d(ak3 ak3Var, a aVar) {
            this(ak3Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak3(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        super(context, z, z2, strArr, str, z3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Boolean.valueOf(z2), strArr, str, Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue(), (String[]) objArr2[3], (String) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (z2) {
            y();
        }
    }

    @Override // com.baidu.tieba.q83, com.baidu.tieba.w83
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.I();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.q83, com.baidu.tieba.i83
    /* renamed from: Z */
    public q83.e m(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            Context context = this.n;
            if (context instanceof Activity) {
                mj3.D((Activity) context, jSONObject);
            } else if (i83.f) {
                Log.d("SearchBoxAuthorize", Log.getStackTraceString(new Exception("context is not activity.")));
            }
            return super.m(jSONObject);
        }
        return (q83.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.q83, com.baidu.tieba.i83
    public boolean j() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", M().O());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(GameGuideConfigInfo.KEY_APP_KEY, M().O());
                jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                jSONObject2.put("host_key_hash", j83.g());
                jSONObject2.put("stoken", this.v);
                String l = sm2.o().l();
                if (!TextUtils.isEmpty(l)) {
                    jSONObject2.put("host_api_key", l);
                }
                jSONObject.put("open", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                for (String str : this.m) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("permit", Boolean.toString(this.p));
                    jSONObject3.put(str, jSONObject4);
                }
                jSONObject.put("accredits", jSONObject3);
                if (!TextUtils.isEmpty(this.s)) {
                    jSONObject.put("provider_appkey", this.s);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            v("data", jSONObject.toString());
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q83, com.baidu.tieba.i83
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (M().N().e(this.n)) {
                h(new d(this, null));
                return true;
            }
            h(new b(this, null));
            return true;
        }
        return invokeV.booleanValue;
    }
}
