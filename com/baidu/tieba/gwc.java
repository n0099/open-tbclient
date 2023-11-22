package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.open.SocialConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.NtSpreadInfo;
/* loaded from: classes6.dex */
public class gwc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NtSpreadInfo ntSpreadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ntSpreadInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "user_name", ntSpreadInfo.user_name);
            qoc.a(jSONObject, "user_avatar", ntSpreadInfo.user_avatar);
            qoc.a(jSONObject, "tips", ntSpreadInfo.tips);
            qoc.a(jSONObject, "type", ntSpreadInfo.type);
            qoc.a(jSONObject, "title", ntSpreadInfo.title);
            if (ntSpreadInfo.pics != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : ntSpreadInfo.pics) {
                    jSONArray.put(str);
                }
                qoc.a(jSONObject, SocialConstants.PARAM_IMAGE, jSONArray);
            }
            qoc.a(jSONObject, "link_url", ntSpreadInfo.link_url);
            qoc.a(jSONObject, CriusAttrConstants.POSITION, ntSpreadInfo.position);
            qoc.a(jSONObject, "publish_date", ntSpreadInfo.publish_date);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
