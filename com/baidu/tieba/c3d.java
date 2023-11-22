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
public class c3d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SidewayRecomComponent sidewayRecomComponent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, sidewayRecomComponent)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "type", sidewayRecomComponent.type);
            FeedContentText feedContentText = sidewayRecomComponent.title;
            if (feedContentText != null) {
                qoc.a(jSONObject, "title", hsc.b(feedContentText));
            }
            FeedContentText feedContentText2 = sidewayRecomComponent.desc;
            if (feedContentText2 != null) {
                qoc.a(jSONObject, "desc", hsc.b(feedContentText2));
            }
            qoc.a(jSONObject, BigdayActivityConfig.IMG_URL, sidewayRecomComponent.img_url);
            qoc.a(jSONObject, "corner_url", sidewayRecomComponent.corner_url);
            if (sidewayRecomComponent.business_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedKV feedKV : sidewayRecomComponent.business_info) {
                    jSONArray.put(usc.b(feedKV));
                }
                qoc.a(jSONObject, "business_info", jSONArray);
            }
            qoc.a(jSONObject, "schema", sidewayRecomComponent.schema);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
