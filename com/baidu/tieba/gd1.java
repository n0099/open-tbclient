package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.heytap.mcssdk.mode.CommandMessage;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gd1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, context, bundle) != null) || bundle == null) {
            return;
        }
        try {
            String string = bundle.getString("zid");
            if (!TextUtils.isEmpty(string)) {
                bundle.remove("zid");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("c", bundle.getString("cuid"));
                jSONObject.put("z", string);
                jSONObject.put("mac", wc1.c());
                jSONObject.put("app", "android");
                jSONObject.put("ver", xc1.a(context));
                bundle.putString(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, jSONObject.toString());
            }
        } catch (Exception e) {
            dd1.b(e.getMessage());
        }
    }

    public static Bundle b(Context context, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, bundle)) == null) {
            if (bundle == null) {
                return new Bundle();
            }
            uc1.a = bundle.getString("bduss");
            uc1.b = bundle.getString("tpOrderId");
            uc1.g = bundle.getString("nativeAppId");
            uc1.h = bundle.getString("sceneSource");
            uc1.c = bundle.getString("appKey");
            uc1.d = bundle.getString("dealId");
            bundle.putString("deviceType", "ANDROID");
            bundle.putString("channel", "cashiersdk");
            bundle.putString(CommandMessage.SDK_VERSION, "2.8.7.9");
            String[] stringArray = bundle.getStringArray("blockedPayChannels");
            if (stringArray != null && stringArray.length > 0) {
                bundle.remove("blockedPayChannels");
                JSONArray jSONArray = new JSONArray();
                for (String str : stringArray) {
                    jSONArray.put(str);
                }
                bundle.putString("bannedChannels", jSONArray.toString());
            }
            a(context, bundle);
            return bundle;
        }
        return (Bundle) invokeLL.objValue;
    }
}
