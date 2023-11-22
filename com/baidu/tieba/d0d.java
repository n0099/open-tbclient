package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.MultiForumPerm;
/* loaded from: classes5.dex */
public class d0d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MultiForumPerm multiForumPerm) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, multiForumPerm)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "is_bawu", multiForumPerm.is_bawu);
            qoc.a(jSONObject, "bawu_type", multiForumPerm.bawu_type);
            qoc.a(jSONObject, "is_deleted", multiForumPerm.is_deleted);
            qoc.a(jSONObject, "is_block_bawu_delete", multiForumPerm.is_block_bawu_delete);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
