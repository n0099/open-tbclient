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
public class d8d extends ktc {
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
                    jSONArray.put(bwc.b(componentFactory));
                }
                ktc.a(jSONObject, "components", jSONArray);
            }
            ComponentFactory componentFactory2 = sidewayLayout.title;
            if (componentFactory2 != null) {
                ktc.a(jSONObject, "title", bwc.b(componentFactory2));
            }
            FeedFeedback feedFeedback = sidewayLayout.feedback;
            if (feedFeedback != null) {
                ktc.a(jSONObject, "feedback", gxc.b(feedFeedback));
            }
            if (sidewayLayout.business_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedKV feedKV : sidewayLayout.business_info) {
                    jSONArray2.put(rxc.b(feedKV));
                }
                ktc.a(jSONObject, "business_info", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
