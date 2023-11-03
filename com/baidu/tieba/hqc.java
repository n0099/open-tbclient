package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.data.IMUserExtraData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.BawuThrones;
/* loaded from: classes6.dex */
public class hqc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BawuThrones bawuThrones) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bawuThrones)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "total_recommend_num", bawuThrones.total_recommend_num);
            poc.a(jSONObject, "used_recommend_num", bawuThrones.used_recommend_num);
            poc.a(jSONObject, IMUserExtraData.KEY_BAZHU_LEVEL, bawuThrones.bazhu_level);
            poc.a(jSONObject, "used_bcast_cnt", bawuThrones.used_bcast_cnt);
            poc.a(jSONObject, "total_bcast_cnt", bawuThrones.total_bcast_cnt);
            poc.a(jSONObject, "newest_bcast_pv", bawuThrones.newest_bcast_pv);
            poc.a(jSONObject, "has_send_bcast", bawuThrones.has_send_bcast);
            poc.a(jSONObject, "newest_bcast_pushuser_cnt", bawuThrones.newest_bcast_pushuser_cnt);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
