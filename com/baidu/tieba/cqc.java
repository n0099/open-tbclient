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
public class cqc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BaijiahaoInfo baijiahaoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, baijiahaoInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "name", baijiahaoInfo.name);
            poc.a(jSONObject, "avatar", baijiahaoInfo.avatar);
            poc.a(jSONObject, "avatar_h", baijiahaoInfo.avatar_h);
            poc.a(jSONObject, DBTableDefine.GroupInfoColumns.COLUMN_BRIEF, baijiahaoInfo.brief);
            poc.a(jSONObject, "auth_id", baijiahaoInfo.auth_id);
            poc.a(jSONObject, IMUserExtraData.KEY_AUTH_DESC, baijiahaoInfo.auth_desc);
            poc.a(jSONObject, "can_modify_avatar", baijiahaoInfo.can_modify_avatar);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
