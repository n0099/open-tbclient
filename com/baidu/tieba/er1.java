package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.api.module.subscription.SubscribeHelper;
import com.baidu.tieba.f63;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class er1 extends dr1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int f;
    public String g;

    /* loaded from: classes3.dex */
    public class a implements SubscribeHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ er1 a;

        public a(er1 er1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {er1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = er1Var;
        }

        @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.k
        public void a(int i, @NonNull String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, jSONObject) == null) {
                this.a.f = i;
                this.a.g = str;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements tf3<d63<f63.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a13 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ SubscribeHelper d;
        public final /* synthetic */ er1 e;

        /* loaded from: classes3.dex */
        public class a implements SubscribeHelper.k {
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

            @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.k
            public void a(int i, @NonNull String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, jSONObject) == null) {
                    if (jSONObject == null) {
                        b bVar = this.a;
                        bVar.e.d(bVar.c, new at1(i, str));
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    b bVar2 = this.a;
                    bVar2.e.D(jSONObject, jSONObject2, bVar2.d);
                    b bVar3 = this.a;
                    bVar3.e.d(bVar3.c, new at1(i, str, jSONObject2));
                }
            }
        }

        public b(er1 er1Var, a13 a13Var, String str, String str2, SubscribeHelper subscribeHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {er1Var, a13Var, str, str2, subscribeHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = er1Var;
            this.a = a13Var;
            this.b = str;
            this.c = str2;
            this.d = subscribeHelper;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tf3
        /* renamed from: b */
        public void a(d63<f63.e> d63Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d63Var) == null) {
                if (!y53.h(d63Var)) {
                    this.e.C(this.a, this.b, this.c, this.d);
                } else {
                    this.d.o(this.b, new a(this));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements SubscribeHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ SubscribeHelper b;
        public final /* synthetic */ er1 c;

        public c(er1 er1Var, String str, SubscribeHelper subscribeHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {er1Var, str, subscribeHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = er1Var;
            this.a = str;
            this.b = subscribeHelper;
        }

        @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.k
        public void a(int i, @NonNull String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, jSONObject) == null) {
                if (jSONObject == null) {
                    this.c.d(this.a, new at1(i, str));
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                this.c.D(jSONObject, jSONObject2, this.b);
                this.c.d(this.a, new at1(i, str, jSONObject2));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public er1(@NonNull bp1 bp1Var) {
        super(bp1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bp1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((bp1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void B(a13 a13Var, String str, String str2, SubscribeHelper subscribeHelper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, a13Var, str, str2, subscribeHelper) == null) {
            a13Var.e0().g(getContext(), "mapp_request_subscribe_message", new b(this, a13Var, str, str2, subscribeHelper));
        }
    }

    public final void C(a13 a13Var, String str, String str2, SubscribeHelper subscribeHelper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a13Var, str, str2, subscribeHelper) == null) {
            if (TextUtils.equals(ue3.n().e(), se3.g(a13Var.W().e0())) && TextUtils.equals("1", a13Var.W().i0())) {
                subscribeHelper.o(str, new c(this, str2, subscribeHelper));
            } else {
                d(str2, new at1(500107, "不符合使用条件"));
            }
        }
    }

    public final void D(JSONObject jSONObject, JSONObject jSONObject2, SubscribeHelper subscribeHelper) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, jSONObject2, subscribeHelper) == null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("list")) == null) {
                    return;
                }
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    if (optJSONObject2 != null && (optJSONArray2 = optJSONObject2.optJSONArray("sub_info")) != null) {
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                            if (optJSONObject3 != null) {
                                jSONObject2.put(optJSONObject3.optString("template_id"), optJSONObject3.optString("formid"));
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                p("#parseDate put json data error", e, false);
            }
        }
    }

    public at1 E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#requestSubscribeFormId params=" + str, false);
            a13 b0 = a13.b0();
            if (b0 == null) {
                return new at1(202, "swan app is null");
            }
            String O = b0.O();
            if (TextUtils.isEmpty(O)) {
                return new at1(202, "appKey is empty");
            }
            Pair<at1, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((at1) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new at1(202, "cb is invalid");
                }
                SubscribeHelper subscribeHelper = new SubscribeHelper();
                if (!subscribeHelper.n(getContext(), b0, O, jSONObject, SubscribeHelper.invokeSubscribeFrom.REQUEST_SUBSCRIBE_FORM_ID_API, new a(this))) {
                    return new at1(this.f, this.g);
                }
                B(b0, O, optString, subscribeHelper);
                return at1.f();
            }
            return new at1(202);
        }
        return (at1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.dp1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "RequestSubscribeFormIdApi" : (String) invokeV.objValue;
    }
}
