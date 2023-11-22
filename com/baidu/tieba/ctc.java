package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.open.SocialConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedPicComponent;
import tbclient.PicInfo;
/* loaded from: classes5.dex */
public class ctc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedPicComponent feedPicComponent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedPicComponent)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (feedPicComponent.pics != null) {
                JSONArray jSONArray = new JSONArray();
                for (PicInfo picInfo : feedPicComponent.pics) {
                    jSONArray.put(g1d.b(picInfo));
                }
                qoc.a(jSONObject, SocialConstants.PARAM_IMAGE, jSONArray);
            }
            qoc.a(jSONObject, "schema", feedPicComponent.schema);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
