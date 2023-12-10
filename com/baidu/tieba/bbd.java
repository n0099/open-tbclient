package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ComponentFactory;
import tbclient.FeedKV;
import tbclient.VideoDoubleRowLayout;
/* loaded from: classes5.dex */
public class bbd extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VideoDoubleRowLayout videoDoubleRowLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, videoDoubleRowLayout)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (videoDoubleRowLayout.components != null) {
                JSONArray jSONArray = new JSONArray();
                for (ComponentFactory componentFactory : videoDoubleRowLayout.components) {
                    jSONArray.put(cwc.b(componentFactory));
                }
                ltc.a(jSONObject, "components", jSONArray);
            }
            ltc.a(jSONObject, "schema", videoDoubleRowLayout.schema);
            if (videoDoubleRowLayout.business_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedKV feedKV : videoDoubleRowLayout.business_info) {
                    jSONArray2.put(sxc.b(feedKV));
                }
                ltc.a(jSONObject, "business_info", jSONArray2);
            }
            if (videoDoubleRowLayout.log_info != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (FeedKV feedKV2 : videoDoubleRowLayout.log_info) {
                    jSONArray3.put(sxc.b(feedKV2));
                }
                ltc.a(jSONObject, "log_info", jSONArray3);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
