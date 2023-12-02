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
/* loaded from: classes6.dex */
public class hw4 {
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

    public hw4() {
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
            if (p16.a().b("ad_feature_strict_mode_check_switch", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean a(hw4 hw4Var) {
        InterceptResult invokeL;
        c cVar;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hw4Var)) == null) {
            if (hw4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(hw4Var.f) && TextUtils.isEmpty(hw4Var.d) && (((cVar = hw4Var.g) == null || TextUtils.isEmpty(cVar.a)) && ((bVar = hw4Var.h) == null || TextUtils.isEmpty(bVar.a)))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public static hw4 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            hw4 hw4Var = new hw4();
            hw4Var.a = TextUtils.equals(jSONObject.optString("strict_mode", "1"), "1");
            hw4Var.b = jSONObject.optString("app_icon");
            hw4Var.c = jSONObject.optString("app_name");
            hw4Var.d = jSONObject.optString("developer_name");
            hw4Var.f = jSONObject.optString("version");
            hw4Var.g = c.a(jSONObject.optJSONObject("privacy"));
            hw4Var.h = b.a(jSONObject.optJSONObject(ShareLoginStat.GetShareListStat.KEY_PERMISSION));
            hw4Var.i = a.a(jSONObject.optJSONObject("feature"));
            hw4Var.j = jSONObject.optString("apk_size");
            hw4Var.k = jSONObject.optString("apk_url");
            try {
                float parseFloat = Float.parseFloat(jSONObject.optString("score"));
                if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                    hw4Var.e = parseFloat;
                } else {
                    hw4Var.e = -1.0f;
                }
            } catch (NumberFormatException unused) {
                hw4Var.e = -1.0f;
            }
            return hw4Var;
        }
        return (hw4) invokeL.objValue;
    }

    public static boolean c(hw4 hw4Var) {
        InterceptResult invokeL;
        c cVar;
        b bVar;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, hw4Var)) == null) {
            if (hw4Var == null || !hw4Var.a) {
                return true;
            }
            if (!TextUtils.isEmpty(hw4Var.f) && !TextUtils.isEmpty(hw4Var.d) && (cVar = hw4Var.g) != null && !TextUtils.isEmpty(cVar.b) && (bVar = hw4Var.h) != null && !TextUtils.isEmpty(bVar.b)) {
                a aVar = hw4Var.i;
                if (aVar != null && !TextUtils.isEmpty(aVar.b)) {
                    return true;
                }
                if (f() && (advertAppInfo = hw4Var.l) != null) {
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
            dz0.e(clogBuilder);
        }
    }

    public void e(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, advertAppInfo) == null) {
            this.l = advertAppInfo;
        }
    }
}
