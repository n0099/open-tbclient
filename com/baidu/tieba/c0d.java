package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.MultiForumPerm;
/* loaded from: classes5.dex */
public class c0d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MultiForumPerm multiForumPerm) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, multiForumPerm)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "is_bawu", multiForumPerm.is_bawu);
            poc.a(jSONObject, "bawu_type", multiForumPerm.bawu_type);
            poc.a(jSONObject, "is_deleted", multiForumPerm.is_deleted);
            poc.a(jSONObject, "is_block_bawu_delete", multiForumPerm.is_block_bawu_delete);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
