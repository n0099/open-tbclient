package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedContentText;
import tbclient.FeedKV;
import tbclient.SidewayRecomComponent;
/* loaded from: classes5.dex */
public class f8d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SidewayRecomComponent sidewayRecomComponent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, sidewayRecomComponent)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "type", sidewayRecomComponent.type);
            FeedContentText feedContentText = sidewayRecomComponent.title;
            if (feedContentText != null) {
                ltc.a(jSONObject, "title", fxc.b(feedContentText));
            }
            FeedContentText feedContentText2 = sidewayRecomComponent.desc;
            if (feedContentText2 != null) {
                ltc.a(jSONObject, "desc", fxc.b(feedContentText2));
            }
            ltc.a(jSONObject, BigdayActivityConfig.IMG_URL, sidewayRecomComponent.img_url);
            ltc.a(jSONObject, "corner_url", sidewayRecomComponent.corner_url);
            if (sidewayRecomComponent.business_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedKV feedKV : sidewayRecomComponent.business_info) {
                    jSONArray.put(sxc.b(feedKV));
                }
                ltc.a(jSONObject, "business_info", jSONArray);
            }
            ltc.a(jSONObject, "schema", sidewayRecomComponent.schema);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
