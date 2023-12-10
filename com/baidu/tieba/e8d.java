package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ComponentFactory;
import tbclient.FeedFeedback;
import tbclient.FeedKV;
import tbclient.SidewayLayout;
/* loaded from: classes5.dex */
public class e8d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SidewayLayout sidewayLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, sidewayLayout)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (sidewayLayout.components != null) {
                JSONArray jSONArray = new JSONArray();
                for (ComponentFactory componentFactory : sidewayLayout.components) {
                    jSONArray.put(cwc.b(componentFactory));
                }
                ltc.a(jSONObject, "components", jSONArray);
            }
            ComponentFactory componentFactory2 = sidewayLayout.title;
            if (componentFactory2 != null) {
                ltc.a(jSONObject, "title", cwc.b(componentFactory2));
            }
            FeedFeedback feedFeedback = sidewayLayout.feedback;
            if (feedFeedback != null) {
                ltc.a(jSONObject, "feedback", hxc.b(feedFeedback));
            }
            if (sidewayLayout.business_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedKV feedKV : sidewayLayout.business_info) {
                    jSONArray2.put(sxc.b(feedKV));
                }
                ltc.a(jSONObject, "business_info", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
