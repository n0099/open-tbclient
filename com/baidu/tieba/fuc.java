package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.AnchorPower;
/* loaded from: classes6.dex */
public class fuc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AnchorPower anchorPower) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, anchorPower)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "have_power", anchorPower.have_power);
            qoc.a(jSONObject, "anchor_message", anchorPower.anchor_message);
            qoc.a(jSONObject, "can_add_live_post", anchorPower.can_add_live_post);
            qoc.a(jSONObject, "can_del_live_post", anchorPower.can_del_live_post);
            qoc.a(jSONObject, "can_add_live_post_msg", anchorPower.can_add_live_post_msg);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
