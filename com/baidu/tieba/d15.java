package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public String c;
    public String d;
    public float e;
    public String f;
    @Nullable
    public c g;
    @Nullable
    public b h;
    @Nullable
    public a i;
    public String j;
    public String k;
    public AdvertAppInfo l;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;

        public a() {
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

        @Nullable
        public static a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                a aVar = new a();
                aVar.a = jSONObject.optString("desc", "功能");
                String optString = jSONObject.optString("url");
                aVar.b = optString;
                if (TextUtils.isEmpty(optString)) {
                    aVar.b = jSONObject.optString("cmd");
                }
                aVar.c = jSONObject.optString("cmd");
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;

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

        @Nullable
        public static b a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                b bVar = new b();
                bVar.a = jSONObject.optString("desc", "权限");
                String optString = jSONObject.optString("url");
                bVar.b = optString;
                if (TextUtils.isEmpty(optString)) {
                    bVar.b = jSONObject.optString("cmd");
                }
                bVar.c = jSONObject.optString("cmd");
                return bVar;
            }
            return (b) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;

        public c() {
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

        @Nullable
        public static c a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                c cVar = new c();
                cVar.a = jSONObject.optString("desc", "隐私");
                String optString = jSONObject.optString("url");
                cVar.b = optString;
                if (TextUtils.isEmpty(optString)) {
                    cVar.b = jSONObject.optString("cmd");
                }
                cVar.c = jSONObject.optString("cmd");
                return cVar;
            }
            return (c) invokeL.objValue;
        }
    }

    public d15() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = -1.0f;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (a56.a().b("ad_feature_strict_mode_check_switch", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean a(d15 d15Var) {
        InterceptResult invokeL;
        c cVar;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, d15Var)) == null) {
            if (d15Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(d15Var.f) && TextUtils.isEmpty(d15Var.d) && (((cVar = d15Var.g) == null || TextUtils.isEmpty(cVar.a)) && ((bVar = d15Var.h) == null || TextUtils.isEmpty(bVar.a)))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public static d15 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            d15 d15Var = new d15();
            d15Var.a = TextUtils.equals(jSONObject.optString("strict_mode", "1"), "1");
            d15Var.b = jSONObject.optString("app_icon");
            d15Var.c = jSONObject.optString("app_name");
            d15Var.d = jSONObject.optString("developer_name");
            d15Var.f = jSONObject.optString("version");
            d15Var.g = c.a(jSONObject.optJSONObject("privacy"));
            d15Var.h = b.a(jSONObject.optJSONObject(ShareLoginStat.GetShareListStat.KEY_PERMISSION));
            d15Var.i = a.a(jSONObject.optJSONObject("feature"));
            d15Var.j = jSONObject.optString("apk_size");
            d15Var.k = jSONObject.optString("apk_url");
            try {
                float parseFloat = Float.parseFloat(jSONObject.optString("score"));
                if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                    d15Var.e = parseFloat;
                } else {
                    d15Var.e = -1.0f;
                }
            } catch (NumberFormatException unused) {
                d15Var.e = -1.0f;
            }
            return d15Var;
        }
        return (d15) invokeL.objValue;
    }

    public static boolean c(d15 d15Var) {
        InterceptResult invokeL;
        c cVar;
        b bVar;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, d15Var)) == null) {
            if (d15Var == null || !d15Var.a) {
                return true;
            }
            if (!TextUtils.isEmpty(d15Var.f) && !TextUtils.isEmpty(d15Var.d) && (cVar = d15Var.g) != null && !TextUtils.isEmpty(cVar.b) && (bVar = d15Var.h) != null && !TextUtils.isEmpty(bVar.b)) {
                a aVar = d15Var.i;
                if (aVar != null && !TextUtils.isEmpty(aVar.b)) {
                    return true;
                }
                if (f() && (advertAppInfo = d15Var.l) != null) {
                    d(ClogBuilder.LogType.CHECK, advertAppInfo.g, PayUVEventType.PAY_WALLET_BANNER_SHOW, "20001");
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void d(@NonNull ClogBuilder.LogType logType, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, logType, str, str2, str3) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(logType).p(str).k(str2).l(str3);
            w31.e(clogBuilder);
        }
    }

    public void e(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, advertAppInfo) == null) {
            this.l = advertAppInfo;
        }
    }
}
