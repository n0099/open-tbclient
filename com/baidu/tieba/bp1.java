package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bp1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bp1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public bp1(Context context) {
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

    public static bp1 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (b == null) {
                synchronized (bp1.class) {
                    if (b == null) {
                        b = new bp1(context);
                    }
                }
            }
            return b;
        }
        return (bp1) invokeL.objValue;
    }

    public String b(JSONObject jSONObject, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, jSONObject, j)) == null) {
            if (jSONObject != null) {
                try {
                    if (jSONObject.length() != 0) {
                        String d = new xp1(this.a, null).d(jSONObject, j);
                        if (!TextUtils.isEmpty(d)) {
                            return d;
                        }
                    }
                } catch (Throwable th) {
                    pq1.d(th);
                }
            }
            return "";
        }
        return (String) invokeLJ.objValue;
    }

    public String f(JSONObject jSONObject, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, jSONObject, j)) == null) {
            if (jSONObject != null) {
                try {
                    if (jSONObject.length() != 0) {
                        String i = new xp1(this.a, null).i(jSONObject, j);
                        if (!TextUtils.isEmpty(i)) {
                            return i;
                        }
                    }
                } catch (Throwable th) {
                    pq1.d(th);
                }
            }
            return "";
        }
        return (String) invokeLJ.objValue;
    }

    public final void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("1");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    zo1.g(this.a).l("k_retry_code_cm", optJSONArray.toString());
                } else {
                    zo1.g(this.a).l("k_retry_code_cm", "");
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("2");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    zo1.g(this.a).l("k_retry_code_cu", optJSONArray2.toString());
                } else {
                    zo1.g(this.a).l("k_retry_code_cu", "");
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("3");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    zo1.g(this.a).l("k_retry_code_ct", optJSONArray3.toString());
                    return;
                } else {
                    zo1.g(this.a).l("k_retry_code_ct", "");
                    return;
                }
            }
            zo1.g(this.a).l("k_retry_code_cm", "");
            zo1.g(this.a).l("k_retry_code_cu", "");
            zo1.g(this.a).l("k_retry_code_ct", "");
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                if (System.currentTimeMillis() - zo1.g(this.a).k0() > zo1.g(this.a).y()) {
                    return false;
                }
                String p0 = zo1.g(this.a).p0();
                String K = zo1.g(this.a).K();
                String g0 = zo1.g(this.a).g0();
                if (TextUtils.isEmpty(p0) && TextUtils.isEmpty(K) && TextUtils.isEmpty(g0)) {
                    return false;
                }
                if (!TextUtils.isEmpty(p0)) {
                    JSONObject jSONObject = new JSONObject(p0);
                    String string = jSONObject.getString("app_id");
                    String string2 = jSONObject.getString(GameGuideConfigInfo.KEY_APP_KEY);
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        kp1.k(FunAdSdk.PLATFORM_CM, string, string2);
                    }
                }
                if (!TextUtils.isEmpty(K)) {
                    JSONObject jSONObject2 = new JSONObject(K);
                    String string3 = jSONObject2.getString("app_id");
                    String string4 = jSONObject2.getString(GameGuideConfigInfo.KEY_APP_KEY);
                    if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                        kp1.k(Config.EXCEPTION_CRASH_TYPE, string3, string4);
                    }
                }
                if (!TextUtils.isEmpty(g0)) {
                    JSONObject jSONObject3 = new JSONObject(g0);
                    String optString = jSONObject3.optString("app_id");
                    String optString2 = jSONObject3.optString(GameGuideConfigInfo.KEY_APP_KEY);
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        kp1.k("cu", optString, optString2);
                        return true;
                    }
                    return true;
                }
                return true;
            } catch (Throwable th) {
                pq1.d(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0062 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064 A[Catch: all -> 0x002a, TRY_ENTER, TryCatch #1 {all -> 0x002a, blocks: (B:7:0x0009, B:9:0x0022, B:14:0x0030, B:18:0x0038, B:22:0x004e, B:25:0x0059, B:26:0x005c, B:30:0x0064, B:32:0x0073, B:37:0x008c, B:41:0x0096, B:43:0x009f, B:45:0x00b1, B:47:0x00b7, B:48:0x00bc, B:50:0x00c5, B:53:0x00da, B:52:0x00d1, B:54:0x00e7, B:56:0x00ef, B:58:0x0101, B:60:0x0107, B:61:0x010c, B:63:0x0115, B:66:0x012a, B:65:0x0121, B:67:0x0137, B:69:0x013f, B:71:0x0151, B:73:0x0157, B:74:0x015c, B:76:0x0165, B:79:0x017a, B:78:0x0171, B:80:0x0187, B:82:0x018f, B:84:0x01a6, B:86:0x01ac, B:87:0x01b9, B:89:0x01d2, B:90:0x022f, B:33:0x007d), top: B:107:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean e(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            synchronized (this) {
                if (z) {
                    try {
                        if (System.currentTimeMillis() - zo1.g(this.a).W() < oq1.c * 5) {
                            tq1.b("pullConfig->force pull");
                            z2 = true;
                            if (z2 && d()) {
                                return true;
                            }
                            xp1 xp1Var = new xp1(this.a, null);
                            b2 = xp1Var.b();
                            if (TextUtils.isEmpty(b2)) {
                                for (int i = 0; i < 3; i++) {
                                    b2 = xp1Var.b();
                                    if (!TextUtils.isEmpty(b2)) {
                                        break;
                                    }
                                }
                            }
                            if (!TextUtils.isEmpty(b2)) {
                                return false;
                            }
                            JSONObject jSONObject = new JSONObject(b2);
                            int optInt = jSONObject.optInt("0", -1);
                            if (optInt == 2) {
                                zo1.g(this.a).V(false);
                            } else {
                                zo1.g(this.a).V(true);
                            }
                            if (optInt != 1 && optInt != 3) {
                                JSONObject optJSONObject = jSONObject.optJSONObject("1");
                                if (optJSONObject == null) {
                                    return false;
                                }
                                JSONObject optJSONObject2 = optJSONObject.optJSONObject("yd_config");
                                if (optJSONObject2 != null) {
                                    String optString = optJSONObject2.optString("app_id");
                                    String optString2 = optJSONObject2.optString(GameGuideConfigInfo.KEY_APP_KEY);
                                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                                        kp1.k(FunAdSdk.PLATFORM_CM, optString, optString2);
                                    }
                                    int optInt2 = optJSONObject2.optInt("status", -1);
                                    if (optInt2 == 1) {
                                        zo1.g(this.a).m(true);
                                    } else if (optInt2 == 2) {
                                        zo1.g(this.a).m(false);
                                    }
                                    zo1.g(this.a).Y(optJSONObject2.toString());
                                }
                                JSONObject optJSONObject3 = optJSONObject.optJSONObject("dx_config");
                                if (optJSONObject3 != null) {
                                    String optString3 = optJSONObject3.optString("app_id");
                                    String optString4 = optJSONObject3.optString(GameGuideConfigInfo.KEY_APP_KEY);
                                    if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                                        kp1.k(Config.EXCEPTION_CRASH_TYPE, optString3, optString4);
                                    }
                                    int optInt3 = optJSONObject3.optInt("status", -1);
                                    if (optInt3 == 1) {
                                        zo1.g(this.a).x(true);
                                    } else if (optInt3 == 2) {
                                        zo1.g(this.a).x(false);
                                    }
                                    zo1.g(this.a).k(optJSONObject3.toString());
                                }
                                JSONObject optJSONObject4 = optJSONObject.optJSONObject("lt_config");
                                if (optJSONObject4 != null) {
                                    String optString5 = optJSONObject4.optString("app_id");
                                    String optString6 = optJSONObject4.optString(GameGuideConfigInfo.KEY_APP_KEY);
                                    if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                                        kp1.k("cu", optString5, optString6);
                                    }
                                    int optInt4 = optJSONObject4.optInt("status", -1);
                                    if (optInt4 == 1) {
                                        zo1.g(this.a).E(true);
                                    } else if (optInt4 == 2) {
                                        zo1.g(this.a).E(false);
                                    }
                                    zo1.g(this.a).H(optJSONObject4.toString());
                                }
                                JSONObject optJSONObject5 = optJSONObject.optJSONObject("auto_config");
                                if (optJSONObject5 != null) {
                                    String optString7 = optJSONObject5.optString(GameGuideConfigInfo.KEY_APP_KEY, "");
                                    String optString8 = optJSONObject5.optString("secret_key", "");
                                    if (!TextUtils.isEmpty(optString7) && !TextUtils.isEmpty(optString8)) {
                                        yo1.b = optString7;
                                        yo1.c = optString8;
                                        zo1.g(this.a).v(optString7, optString8);
                                    }
                                }
                                zo1.g(this.a).Q(optJSONObject.optString("encrypt_key", ""));
                                JSONObject optJSONObject6 = jSONObject.optJSONObject("a_setting");
                                if (optJSONObject6 != null) {
                                    zo1.g(this.a).J("1".equals(optJSONObject6.optString("1", "1")));
                                    zo1.g(this.a).A(optJSONObject6.optInt("2"));
                                    zo1.g(this.a).R("1".equals(optJSONObject6.optString("3", "0")));
                                    c(optJSONObject6.optJSONObject("4"));
                                    zo1.g(this.a).N("1".equals(optJSONObject6.optString("5", "1")));
                                }
                                zo1.g(this.a).j(jSONObject.optLong("3", 300L) * 1000);
                                zo1.g(this.a).T(System.currentTimeMillis());
                                return true;
                            }
                            return true;
                        }
                    } catch (Throwable th) {
                        pq1.d(th);
                        return false;
                    }
                }
                z2 = false;
                if (z2) {
                }
                xp1 xp1Var2 = new xp1(this.a, null);
                b2 = xp1Var2.b();
                if (TextUtils.isEmpty(b2)) {
                }
                if (!TextUtils.isEmpty(b2)) {
                }
            }
        } else {
            return invokeZ.booleanValue;
        }
    }
}
