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
public class h1d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NtSpreadInfo ntSpreadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ntSpreadInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "user_name", ntSpreadInfo.user_name);
            ltc.a(jSONObject, "user_avatar", ntSpreadInfo.user_avatar);
            ltc.a(jSONObject, "tips", ntSpreadInfo.tips);
            ltc.a(jSONObject, "type", ntSpreadInfo.type);
            ltc.a(jSONObject, "title", ntSpreadInfo.title);
            if (ntSpreadInfo.pics != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : ntSpreadInfo.pics) {
                    jSONArray.put(str);
                }
                ltc.a(jSONObject, SocialConstants.PARAM_IMAGE, jSONArray);
            }
            ltc.a(jSONObject, "link_url", ntSpreadInfo.link_url);
            ltc.a(jSONObject, CriusAttrConstants.POSITION, ntSpreadInfo.position);
            ltc.a(jSONObject, "publish_date", ntSpreadInfo.publish_date);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
