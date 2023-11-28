package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.open.SocialConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ServiceArea;
import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class b8d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ServiceArea serviceArea) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, serviceArea)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "servicename", serviceArea.servicename);
            ltc.a(jSONObject, SocialConstants.PARAM_APP_ICON, serviceArea.picurl);
            ltc.a(jSONObject, "serviceurl", serviceArea.serviceurl);
            ltc.a(jSONObject, "version", serviceArea.version);
            ltc.a(jSONObject, TableDefine.MessageColumns.COLUME_SERVICE_TYPE, serviceArea.service_type);
            SmartApp smartApp = serviceArea.area_smart_app;
            if (smartApp != null) {
                ltc.a(jSONObject, "area_smart_app", n8d.b(smartApp));
            }
            ltc.a(jSONObject, "schema", serviceArea.schema);
            if (serviceArea.third_statistics_url != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : serviceArea.third_statistics_url) {
                    jSONArray.put(str);
                }
                ltc.a(jSONObject, "third_statistics_url", jSONArray);
            }
            ltc.a(jSONObject, "tag", serviceArea.tag);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
