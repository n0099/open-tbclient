package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.ProbeTB;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i50 extends h50 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a b;
    public int c;

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str, int i);

        void b(int i, String str, int i2);
    }

    @Override // com.baidu.tieba.j50.b
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j50.b
    public String getMediaType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    public i50(Context context, a aVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = aVar;
        this.c = i;
    }

    @Override // com.baidu.tieba.j50.b
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int a2 = n50.a(this.a);
            if (a2 == 1) {
                return "http://rd-im-server.bcc-szth.baidu.com:8089/rest/5.0/generate_lcm_token";
            } else if (a2 == 2) {
                return "http://sz-shaheenv-al-b.bcc-szwg.baidu.com:8911/rest/5.0/generate_lcm_token";
            } else if (n50.b(this.a)) {
                return "http://rd-im-server.bcc-szth.baidu.com:8089/rest/5.0/generate_lcm_token";
            } else {
                return "https://pim.baidu.com/rest/5.0/generate_lcm_token";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j50.b
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                JSONObject jSONObject = (JSONObject) m50.b(this.a, true);
                if (jSONObject != null) {
                    return jSONObject.toString().getBytes();
                }
                return new byte[0];
            } catch (Exception unused) {
                return new byte[0];
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j50.d
    public void onFailure(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
            this.b.b(i, str, this.c);
        }
    }

    @Override // com.baidu.tieba.j50.d
    public void onSuccess(byte[] bArr) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bArr) == null) {
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                if (n50.a) {
                    o50.a("GetTokenRequest", "onSuccess :" + jSONObject.toString());
                }
                int optInt = jSONObject.optInt("error_code", -1);
                String optString = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                f40 g = e40.h(this.a).g(601110);
                g.c("token_end", System.currentTimeMillis());
                g.b("connect_state", 1);
                g.d("P2", jSONObject.toString());
                g.d("con_err_code", "P2");
                if (optInt == 0) {
                    boolean z = false;
                    p50.z(this.a, jSONObject.optBoolean("bddns_enable", false));
                    String optString2 = jSONObject.optString("token");
                    JSONArray jSONArray = jSONObject.getJSONArray(WebSocketRequest.PARAM_KEY_PROTOCOLS);
                    if (!TextUtils.isEmpty(optString2) && jSONArray != null && jSONArray.length() >= 1) {
                        p50.N(this.a, jSONArray.length());
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                            String optString3 = jSONObject2.optString(ProbeTB.PROTOCOL);
                            String optString4 = jSONObject2.optString("domain");
                            String optString5 = jSONObject2.optString(ClientCookie.PORT_ATTR);
                            if (!TextUtils.isEmpty(optString3) && TextUtils.equals(optString3, "quic")) {
                                str = optString3 + ":" + optString4 + ":" + optString5 + ":" + jSONObject2.optString("version");
                            } else {
                                str = optString3 + ":" + optString4 + ":" + optString5;
                            }
                            p50.M(this.a, str, i);
                        }
                        p50.B(this.a, jSONObject.optInt("ipv6_strategy", 3));
                        p50.O(this.a, optString2);
                        this.b.a(optString2, this.c);
                        try {
                            String optString6 = jSONObject.optString("client_log_config", "");
                            JSONObject jSONObject3 = new JSONObject(optString6);
                            if (!TextUtils.isEmpty(optString6)) {
                                i40.i(this.a, jSONObject3.optInt("client_upload_log_switch", 0));
                                JSONArray jSONArray2 = jSONObject3.getJSONArray("realtime_log_switch");
                                if (jSONArray2.length() <= 0) {
                                    return;
                                }
                                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                    JSONObject jSONObject4 = jSONArray2.getJSONObject(i2);
                                    if (jSONObject4 == null) {
                                        return;
                                    }
                                    i40.h(this.a, jSONObject4.optInt("id", 0), jSONObject4.optInt("switch", 0));
                                }
                                if (jSONObject3.optInt("client_ping_switch", 0) == 1) {
                                    z = true;
                                }
                                s40.d(this.a, z);
                                if (!z) {
                                    return;
                                }
                                String optString7 = jSONObject3.optString("client_ping_config", "");
                                if (!TextUtils.isEmpty(optString7)) {
                                    JSONObject jSONObject5 = new JSONObject(optString7);
                                    int optInt2 = jSONObject5.optInt("ping_times");
                                    int optInt3 = jSONObject5.optInt("ping_body_size");
                                    long optLong = jSONObject5.optLong("ping_timeout_ms");
                                    long optLong2 = jSONObject5.optLong("ping_interval_ms");
                                    long optLong3 = jSONObject5.optLong("ping_deadline_ms");
                                    String string = jSONObject5.getString("ping_target");
                                    s40.k(this.a, optInt2);
                                    s40.e(this.a, optInt3);
                                    s40.j(this.a, optLong);
                                    s40.h(this.a, optLong2);
                                    s40.g(this.a, optLong3);
                                    s40.i(this.a, string);
                                    i40.h(this.a, 601112, 1);
                                    if (n50.a) {
                                        o50.a("GetTokenRequest", "client_ping_switch pingTimes :" + optInt2 + ", pingTarget ：" + string);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Exception unused) {
                            if (n50.a) {
                                o50.b("GetTokenRequest", "client_log_config Json Exception");
                                return;
                            }
                            return;
                        }
                    }
                    this.b.b(10002, "token or protocol is empty", this.c);
                    return;
                }
                this.b.b(optInt, optString, this.c);
            } catch (JSONException e) {
                this.b.b(10001, "parse response exception ：" + e, this.c);
            }
        }
    }
}
