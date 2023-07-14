package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.UserSettingForceListListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i84 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public JSONObject c;
    public String d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947807364, "Lcom/baidu/tieba/i84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947807364, "Lcom/baidu/tieba/i84;");
                return;
            }
        }
        e = fs1.a;
    }

    public i84() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (vb3.M() != null && TextUtils.equals(vb3.g0(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So")) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public i84 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.a = false;
            this.b = false;
            this.d = null;
            this.c = c();
            boolean b = b();
            this.a = b;
            if (b) {
                return this;
            }
            this.b = a();
            return this;
        }
        return (i84) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!this.a && !this.b) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean a() {
        InterceptResult invokeV;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = this.c;
            boolean z3 = false;
            if (jSONObject == null) {
                return false;
            }
            int optInt = jSONObject.optInt("bbaspg_guide_count", 3);
            int optInt2 = this.c.optInt("bbaspg_guide_interval", 72);
            long optLong = this.c.optLong("bbaspg_guide_last_time", 0L);
            int optInt3 = this.c.optInt("bbaspg_guide_shown_count", 0);
            int optInt4 = this.c.optInt("bbaspg_guide_image_index", 0);
            if (System.currentTimeMillis() - optLong > optInt2 * 3600000) {
                z = true;
            } else {
                z = false;
            }
            String optString = this.c.optString("filter_channelid");
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split(",");
                String T2 = ub3.K().q().W().T();
                z2 = true;
                for (String str : split) {
                    if (TextUtils.equals(T2, str)) {
                        z2 = false;
                    }
                }
            } else {
                z2 = true;
            }
            if (optInt3 < optInt && z && z2) {
                z3 = true;
            }
            if (e) {
                Log.i("SwanGameGuideDialogChecker", "isShow:" + z3 + " maxCount" + optInt + " isOverInterval" + z + "imageUrl " + this.d + UserSettingForceListListener.FORCE_LIST_ITEM_SHOW_KEY + z3);
            }
            if (z3) {
                d(this.c, optInt4, "bbaspg_guide_images");
            }
            return z3;
        }
        return invokeV.booleanValue;
    }

    public final JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String string = jk3.a().getString("swan_game_guide_toast", "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    return new JSONObject(string);
                } catch (JSONException e2) {
                    if (fs1.a) {
                        e2.printStackTrace();
                        return null;
                    }
                    return null;
                }
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final int d(JSONObject jSONObject, int i, String str) {
        InterceptResult invokeLIL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, jSONObject, i, str)) == null) {
            if (jSONObject == null || i < 0 || TextUtils.isEmpty(str) || (optJSONArray = jSONObject.optJSONArray(str)) == null || optJSONArray.length() == 0) {
                return 0;
            }
            if (i >= optJSONArray.length()) {
                i = 0;
            }
            this.d = optJSONArray.optString(i);
            return i;
        }
        return invokeLIL.intValue;
    }
}
