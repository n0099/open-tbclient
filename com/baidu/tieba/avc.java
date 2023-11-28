package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.tbadk.core.data.IMUserExtraData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.BaijiahaoInfo;
/* loaded from: classes5.dex */
public class avc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BaijiahaoInfo baijiahaoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, baijiahaoInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "name", baijiahaoInfo.name);
            ltc.a(jSONObject, "avatar", baijiahaoInfo.avatar);
            ltc.a(jSONObject, "avatar_h", baijiahaoInfo.avatar_h);
            ltc.a(jSONObject, DBTableDefine.GroupInfoColumns.COLUMN_BRIEF, baijiahaoInfo.brief);
            ltc.a(jSONObject, "auth_id", baijiahaoInfo.auth_id);
            ltc.a(jSONObject, IMUserExtraData.KEY_AUTH_DESC, baijiahaoInfo.auth_desc);
            ltc.a(jSONObject, "can_modify_avatar", baijiahaoInfo.can_modify_avatar);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
