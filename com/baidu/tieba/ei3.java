package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ew2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ei3 extends kz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kz1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "StatisticEvent" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "UbcAndCeresStatisticEventApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ei3 b;

        public a(ei3 ei3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ei3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ei3Var;
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

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public b(ei3 ei3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ei3Var, str, str2};
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
                    h82.k("ubcAndCeresStatisticEvent", "671 event=" + this.b);
                }
                try {
                    oh3.m(this.a, new JSONObject(this.b));
                } catch (JSONException e) {
                    h82.k("ubcAndCeresStatisticEvent", e.toString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;

        public c(ei3 ei3Var, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ei3Var, str, jSONObject};
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
                nq4.l(this.a, this.b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ei3(@NonNull iz1 iz1Var) {
        super(iz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, jSONObject) != null) || jSONObject == null) {
            return;
        }
        ew2.a W = gb3.K().q().W();
        ho3.f(jSONObject, "launchId", W.V());
        ho3.f(jSONObject, "scheme", W.W());
        ho3.f(jSONObject, "packageVersion", W.v1());
        zh3.a(jSONObject);
    }

    public h32 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!uw2.T().M() && i53.e()) {
                a53.e().d(new a(this, str), "ubcAndCeresStatistic", false);
                return h32.f();
            }
            return z(str);
        }
        return (h32) invokeL.objValue;
    }

    public final h32 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (th3.b(str)) {
                return new h32(202, "the params is over max limit");
            }
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (!h32Var.isSuccess()) {
                return h32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("ubcId");
            String optString2 = jSONObject.optString("bizId");
            JSONObject optJSONObject = jSONObject.optJSONObject("content");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && optJSONObject != null) {
                ho3.f(optJSONObject, "source", gb3.K().q().W().T());
                y(optJSONObject.optJSONObject("ext"));
                a53.e().d(new b(this, optString, optJSONObject.toString()), "UbcAndCeresStatisticEventApi", true);
                u43.h().g().b(jSONObject);
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
                    jSONObject.putOpt("propagation", ho3.f(jSONObject.optJSONObject("propagation"), "source", gb3.K().q().W().T()));
                    jSONObject.put("eventName", str2);
                } catch (JSONException unused) {
                }
                h82.i("UbcAndCeresStatisticEventApi", "OpenStat : " + jSONObject);
                a53.e().d(new c(this, optString2, jSONObject), "OpenStatisticEvent", true);
                return h32.f();
            }
            return new h32(202);
        }
        return (h32) invokeL.objValue;
    }
}
