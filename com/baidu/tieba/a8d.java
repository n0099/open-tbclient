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
public class a8d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ServiceArea serviceArea) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, serviceArea)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "servicename", serviceArea.servicename);
            ktc.a(jSONObject, SocialConstants.PARAM_APP_ICON, serviceArea.picurl);
            ktc.a(jSONObject, "serviceurl", serviceArea.serviceurl);
            ktc.a(jSONObject, "version", serviceArea.version);
            ktc.a(jSONObject, TableDefine.MessageColumns.COLUME_SERVICE_TYPE, serviceArea.service_type);
            SmartApp smartApp = serviceArea.area_smart_app;
            if (smartApp != null) {
                ktc.a(jSONObject, "area_smart_app", m8d.b(smartApp));
            }
            ktc.a(jSONObject, "schema", serviceArea.schema);
            if (serviceArea.third_statistics_url != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : serviceArea.third_statistics_url) {
                    jSONArray.put(str);
                }
                ktc.a(jSONObject, "third_statistics_url", jSONArray);
            }
            ktc.a(jSONObject, "tag", serviceArea.tag);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
