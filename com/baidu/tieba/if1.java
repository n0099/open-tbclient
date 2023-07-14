package com.baidu.tieba;

import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Xml;
import androidx.multidex.MultiDexExtractor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.searchbox.ui.state.StateManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.SocialConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class if1 {
    public static /* synthetic */ Interceptable $ic;
    public static final String g;
    public static final if1 h;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> a;
    public Map<Integer, Integer> b;
    public Map<String, Integer> c;
    public Map<String, Integer> d;
    public Map<String, String> e;
    public boolean f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947851477, "Lcom/baidu/tieba/if1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947851477, "Lcom/baidu/tieba/if1;");
                return;
            }
        }
        g = "nps" + File.separator + "manifest";
        h = new if1();
    }

    public if1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = false;
    }

    public List<BundleInfo> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            h();
            ArrayList arrayList = new ArrayList();
            for (String str : this.c.keySet()) {
                BundleInfo bundleInfo = new BundleInfo();
                bundleInfo.setPackageName(str);
                bundleInfo.setMinVersion(this.c.get(str).intValue());
                arrayList.add(bundleInfo);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static if1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return h;
        }
        return (if1) invokeV.objValue;
    }

    public final synchronized boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (this.f) {
                    return true;
                }
                g();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Integer num = this.d.get(str);
            if (num != null) {
                return num.intValue();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            h();
            if (this.c.containsKey(str)) {
                return this.c.get(str).intValue();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            h();
            return this.a.get(str);
        }
        return (String) invokeL.objValue;
    }

    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            h();
            return this.e.get(str);
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Null dom frontier in handler: IOException -> 0x0075 */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0069, code lost:
        if (r0 != null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                if (this.f) {
                    return true;
                }
                InputStream inputStream = null;
                try {
                    AssetManager assets = ContextHolder.getApplicationContext().getAssets();
                    inputStream = assets.open(g + File.separator + "manifest.json");
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Xml.Encoding.UTF_8.toString()), 8192);
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    i(new JSONArray(sb.toString()), this.c, this.a, this.b, this.d, this.e);
                } catch (IOException unused) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                            this.f = true;
                            return true;
                        }
                    }
                    this.f = true;
                    return true;
                } catch (JSONException unused3) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    this.f = true;
                    return true;
                }
            }
        } else {
            return invokeV.booleanValue;
        }
    }

    public final void i(JSONArray jSONArray, Map<String, Integer> map, Map<String, String> map2, Map<Integer, Integer> map3, Map<String, Integer> map4, Map<String, String> map5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{jSONArray, map, map2, map3, map4, map5}) == null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("pkg_name");
                    if (!TextUtils.isEmpty(optString)) {
                        map.put(optString, Integer.valueOf(optJSONObject.optInt("min_version")));
                        String optString2 = optJSONObject.optString("share_user_id");
                        if (!TextUtils.isEmpty(optString2)) {
                            map5.put(optString, optString2);
                        }
                        JSONArray optJSONArray = optJSONObject.optJSONArray("activity");
                        if (optJSONArray != null) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                                if (optJSONObject2 != null) {
                                    String optString3 = optJSONObject2.optString("name");
                                    if (!TextUtils.isEmpty(optString3)) {
                                        map2.put(optString3, optString);
                                        map4.put(optString3, 1);
                                    }
                                }
                            }
                        }
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("service");
                        if (optJSONArray2 != null) {
                            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                                if (optJSONObject3 != null) {
                                    String optString4 = optJSONObject3.optString("name");
                                    if (!TextUtils.isEmpty(optString4)) {
                                        map2.put(optString4, optString);
                                        map4.put(optString4, 2);
                                    }
                                }
                            }
                        }
                        JSONArray optJSONArray3 = optJSONObject.optJSONArray("provider");
                        if (optJSONArray3 != null) {
                            for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                                JSONObject optJSONObject4 = optJSONArray3.optJSONObject(i4);
                                if (optJSONObject4 != null) {
                                    String optString5 = optJSONObject4.optString("name");
                                    if (!TextUtils.isEmpty(optString5)) {
                                        map2.put(optString5, optString);
                                        map4.put(optString5, 4);
                                    }
                                }
                            }
                        }
                        JSONArray optJSONArray4 = optJSONObject.optJSONArray(SocialConstants.PARAM_RECEIVER);
                        if (optJSONArray4 != null) {
                            for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                                JSONObject optJSONObject5 = optJSONArray4.optJSONObject(i5);
                                if (optJSONObject5 != null) {
                                    String optString6 = optJSONObject5.optString("name");
                                    if (!TextUtils.isEmpty(optString6)) {
                                        map2.put(optString6, optString);
                                        map4.put(optString6, 3);
                                    }
                                }
                            }
                        }
                        JSONArray optJSONArray5 = optJSONObject.optJSONArray(MultiDexExtractor.DEX_PREFIX);
                        if (optJSONArray5 != null) {
                            for (int i6 = 0; i6 < optJSONArray5.length(); i6++) {
                                JSONObject optJSONObject6 = optJSONArray5.optJSONObject(i6);
                                if (optJSONObject6 != null) {
                                    String optString7 = optJSONObject6.optString("name");
                                    if (!TextUtils.isEmpty(optString7)) {
                                        map2.put(optString7, optString);
                                    }
                                }
                            }
                        }
                        JSONArray optJSONArray6 = optJSONObject.optJSONArray("ids");
                        if (optJSONArray6 != null) {
                            for (int i7 = 0; i7 < optJSONArray6.length(); i7++) {
                                JSONObject optJSONObject7 = optJSONArray6.optJSONObject(i7);
                                if (optJSONObject7 != null) {
                                    int optInt = optJSONObject7.optInt(StateManager.KEY_STATE);
                                    int optInt2 = optJSONObject7.optInt("host");
                                    if (optInt > 0 && optInt2 > 0) {
                                        map3.put(Integer.valueOf(optInt), Integer.valueOf(optInt2));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
