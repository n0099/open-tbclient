package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gl4 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<String, String> f;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public String c;
    public JSONObject d;
    public List<wk4> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947797754, "Lcom/baidu/tieba/gl4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947797754, "Lcom/baidu/tieba/gl4;");
                return;
            }
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        f = concurrentHashMap;
        concurrentHashMap.put("1415", PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW);
    }

    public List<wk4> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (List) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public gl4(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = new ArrayList();
        this.c = str;
        this.d = jSONObject;
    }

    @SuppressLint({"BDThrowableCheck"})
    public boolean e() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                JSONObject jSONObject = this.d;
                this.a = jSONObject.getInt("threshold");
                this.b = jSONObject.getInt("timeup");
                JSONArray jSONArray = new JSONArray(jSONObject.getString("item"));
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("ubcid");
                    if (!TextUtils.isEmpty(string) && f.containsKey(string)) {
                        String optString = jSONObject2.optString("bizid");
                        f.get(string);
                        str = optString;
                    } else {
                        str = string;
                    }
                    String string2 = jSONObject2.getString("switch");
                    String string3 = jSONObject2.getString(Constant.IS_REAL);
                    String string4 = jSONObject2.getString("isAbtest");
                    int parseInt = Integer.parseInt(jSONObject2.getString("timeout"));
                    String string5 = jSONObject2.getString("type");
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string5)) {
                        wk4 wk4Var = new wk4(str, string2, string3, parseInt, string5, string4);
                        if (jSONObject2.has("rate")) {
                            wk4Var.g = Integer.parseInt(jSONObject2.getString("rate"));
                        }
                        if (jSONObject2.has("bizid")) {
                            jSONObject2.getString("bizid");
                        }
                        if (jSONObject2.has("c")) {
                            wk4Var.h = jSONObject2.getString("c");
                        }
                        if (jSONObject2.has("limitUnit")) {
                            wk4Var.i = Integer.parseInt(jSONObject2.getString("limitUnit"));
                        }
                        if (jSONObject2.has("limitCnt")) {
                            wk4Var.j = Integer.parseInt(jSONObject2.getString("limitCnt"));
                        }
                        if (jSONObject2.has(Constant.ID_TYPE)) {
                            wk4Var.k = jSONObject2.getString(Constant.ID_TYPE);
                        }
                        if (jSONObject2.has("appblacklist")) {
                            jSONObject2.getString("appblacklist");
                        }
                        this.e.add(wk4Var);
                    }
                }
                return true;
            } catch (NumberFormatException | JSONException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
