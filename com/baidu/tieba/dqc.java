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
public class dqc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BaijiahaoInfo baijiahaoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, baijiahaoInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "name", baijiahaoInfo.name);
            qoc.a(jSONObject, "avatar", baijiahaoInfo.avatar);
            qoc.a(jSONObject, "avatar_h", baijiahaoInfo.avatar_h);
            qoc.a(jSONObject, DBTableDefine.GroupInfoColumns.COLUMN_BRIEF, baijiahaoInfo.brief);
            qoc.a(jSONObject, "auth_id", baijiahaoInfo.auth_id);
            qoc.a(jSONObject, IMUserExtraData.KEY_AUTH_DESC, baijiahaoInfo.auth_desc);
            qoc.a(jSONObject, "can_modify_avatar", baijiahaoInfo.can_modify_avatar);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
