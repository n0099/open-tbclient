package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cr4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public String c;
    public String d;
    public float e;
    public String f;
    public b g;
    public a h;
    public String i;
    public String j;

    /* loaded from: classes3.dex */
    public class a {
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

        public static a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                a aVar = new a();
                aVar.a = jSONObject.optString("desc", "权限");
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

    /* loaded from: classes3.dex */
    public class b {
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

        public static b a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                b bVar = new b();
                bVar.a = jSONObject.optString("desc", "隐私");
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

    public cr4() {
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

    public static boolean a(cr4 cr4Var) {
        InterceptResult invokeL;
        b bVar;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cr4Var)) == null) {
            if (cr4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(cr4Var.f) && TextUtils.isEmpty(cr4Var.d) && (((bVar = cr4Var.g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = cr4Var.h) == null || TextUtils.isEmpty(aVar.a)))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static cr4 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            cr4 cr4Var = new cr4();
            cr4Var.a = TextUtils.equals(jSONObject.optString("strict_mode", "1"), "1");
            cr4Var.b = jSONObject.optString("app_icon");
            cr4Var.c = jSONObject.optString("app_name");
            cr4Var.d = jSONObject.optString("developer_name");
            cr4Var.f = jSONObject.optString("version");
            cr4Var.g = b.a(jSONObject.optJSONObject("privacy"));
            cr4Var.h = a.a(jSONObject.optJSONObject(ShareLoginStat.GetShareListStat.KEY_PERMISSION));
            cr4Var.i = jSONObject.optString("apk_size");
            cr4Var.j = jSONObject.optString("apk_url");
            try {
                float parseFloat = Float.parseFloat(jSONObject.optString("score"));
                if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                    cr4Var.e = parseFloat;
                } else {
                    cr4Var.e = -1.0f;
                }
            } catch (NumberFormatException unused) {
                cr4Var.e = -1.0f;
            }
            return cr4Var;
        }
        return (cr4) invokeL.objValue;
    }

    public static boolean c(cr4 cr4Var) {
        InterceptResult invokeL;
        b bVar;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cr4Var)) == null) {
            if (cr4Var == null || !cr4Var.a) {
                return true;
            }
            if (!TextUtils.isEmpty(cr4Var.f) && !TextUtils.isEmpty(cr4Var.d) && (bVar = cr4Var.g) != null && !TextUtils.isEmpty(bVar.b) && (aVar = cr4Var.h) != null && !TextUtils.isEmpty(aVar.b)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
