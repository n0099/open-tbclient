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
public class fwc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NtSpreadInfo ntSpreadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ntSpreadInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "user_name", ntSpreadInfo.user_name);
            poc.a(jSONObject, "user_avatar", ntSpreadInfo.user_avatar);
            poc.a(jSONObject, "tips", ntSpreadInfo.tips);
            poc.a(jSONObject, "type", ntSpreadInfo.type);
            poc.a(jSONObject, "title", ntSpreadInfo.title);
            if (ntSpreadInfo.pics != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : ntSpreadInfo.pics) {
                    jSONArray.put(str);
                }
                poc.a(jSONObject, SocialConstants.PARAM_IMAGE, jSONArray);
            }
            poc.a(jSONObject, "link_url", ntSpreadInfo.link_url);
            poc.a(jSONObject, CriusAttrConstants.POSITION, ntSpreadInfo.position);
            poc.a(jSONObject, "publish_date", ntSpreadInfo.publish_date);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
