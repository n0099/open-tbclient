package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class igb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.fun.module.csj.f0 a(TTNativeAd tTNativeAd) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tTNativeAd)) == null) {
            int imageMode = tTNativeAd.getImageMode();
            if (imageMode == 15) {
                i = R.layout.fun_csj_ad_native_vertical_video_view;
            } else if (imageMode != 16) {
                if (imageMode != 166) {
                    if (imageMode == 2) {
                        i = R.layout.fun_csj_ad_native_small_img_view;
                    } else if (imageMode == 3) {
                        i = R.layout.fun_csj_ad_native_large_img_view;
                    } else if (imageMode == 4) {
                        i = R.layout.fun_csj_ad_native_group_img_view;
                    } else if (imageMode != 5) {
                        return null;
                    }
                }
                i = R.layout.fun_csj_ad_native_large_video_view;
            } else {
                i = R.layout.fun_csj_ad_native_vertical_img_view;
            }
            com.fun.module.csj.f0 f0Var = (com.fun.module.csj.f0) LayoutInflater.from(FunAdSdk.getAppContext()).inflate(i, (ViewGroup) null);
            f0Var.a(tTNativeAd);
            return f0Var;
        }
        return (com.fun.module.csj.f0) invokeL.objValue;
    }

    public static String b(boolean z) {
        InterceptResult invokeZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) {
            HashMap hashMap = new HashMap();
            if (z) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("personal_ads_type", str);
            if (hashMap.isEmpty()) {
                return "";
            }
            try {
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry entry : hashMap.entrySet()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", entry.getKey());
                    jSONObject.put("value", entry.getValue());
                    jSONArray.put(jSONObject);
                }
                return jSONArray.toString();
            } catch (Exception e) {
                LogPrinter.e(e);
                return "";
            }
        }
        return (String) invokeZ.objValue;
    }
}
