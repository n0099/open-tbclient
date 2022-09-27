package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.io2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ia3 extends or1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ia3 b;

        public a(ia3 ia3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ia3Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.z(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public b(ia3 ia3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia3Var, str, str2};
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
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.equals(this.a, "671")) {
                    l02.k("ubcAndCeresStatisticEvent", "671 event=" + this.b);
                }
                try {
                    s93.m(this.a, new JSONObject(this.b));
                } catch (JSONException e) {
                    l02.k("ubcAndCeresStatisticEvent", e.toString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;

        public c(ia3 ia3Var, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia3Var, str, jSONObject};
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
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ri4.l(this.a, this.b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ia3(@NonNull mr1 mr1Var) {
        super(mr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mr1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        io2.a W = k33.K().q().W();
        lg3.f(jSONObject, "launchId", W.V());
        lg3.f(jSONObject, "scheme", W.W());
        lg3.f(jSONObject, "packageVersion", W.v1());
        da3.a(jSONObject);
    }

    public lv1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!yo2.U().N() && mx2.e()) {
                ex2.e().d(new a(this, str), "ubcAndCeresStatistic", false);
                return lv1.f();
            }
            return z(str);
        }
        return (lv1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.or1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "StatisticEvent" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.or1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "UbcAndCeresStatisticEventApi" : (String) invokeV.objValue;
    }

    public final lv1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (x93.b(str)) {
                return new lv1(202, "the params is over max limit");
            }
            Pair<lv1, JSONObject> s = s(str);
            lv1 lv1Var = (lv1) s.first;
            if (lv1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("ubcId");
                String optString2 = jSONObject.optString("bizId");
                JSONObject optJSONObject = jSONObject.optJSONObject("content");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && optJSONObject != null) {
                    lg3.f(optJSONObject, "source", k33.K().q().W().T());
                    y(optJSONObject.optJSONObject("ext"));
                    ex2.e().d(new b(this, optString, optJSONObject.toString()), "UbcAndCeresStatisticEventApi", true);
                    yw2.h().g().b(jSONObject);
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("content");
                    String str2 = null;
                    if (optJSONObject2 != null) {
                        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("ext");
                        String optString3 = optJSONObject2.optString("type");
                        optJSONObject2.remove("type");
                        optJSONObject2.remove("from");
                        y(optJSONObject3);
                        str2 = optString3;
                    }
                    jSONObject.remove("ubcId");
                    try {
                        jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
                        jSONObject.putOpt("eventType", "0");
                        jSONObject.putOpt("propagation", lg3.f(jSONObject.optJSONObject("propagation"), "source", k33.K().q().W().T()));
                        jSONObject.put("eventName", str2);
                    } catch (JSONException unused) {
                    }
                    l02.i("UbcAndCeresStatisticEventApi", "OpenStat : " + jSONObject);
                    ex2.e().d(new c(this, optString2, jSONObject), "OpenStatisticEvent", true);
                    return lv1.f();
                }
                return new lv1(202);
            }
            return lv1Var;
        }
        return (lv1) invokeL.objValue;
    }
}
