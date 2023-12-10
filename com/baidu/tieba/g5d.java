package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.MultiForumPerm;
/* loaded from: classes6.dex */
public class g5d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MultiForumPerm multiForumPerm) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, multiForumPerm)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "is_bawu", multiForumPerm.is_bawu);
            ltc.a(jSONObject, "bawu_type", multiForumPerm.bawu_type);
            ltc.a(jSONObject, "is_deleted", multiForumPerm.is_deleted);
            ltc.a(jSONObject, "is_block_bawu_delete", multiForumPerm.is_block_bawu_delete);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
