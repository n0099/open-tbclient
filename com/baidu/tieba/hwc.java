package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.DealAuthInfo;
import tbclient.DealInfo;
import tbclient.DealMedia;
/* loaded from: classes6.dex */
public class hwc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull DealInfo dealInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dealInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "title", dealInfo.title);
            ktc.a(jSONObject, "des", dealInfo.des);
            ktc.a(jSONObject, "stock", dealInfo.stock);
            ktc.a(jSONObject, "sales", dealInfo.sales);
            ktc.a(jSONObject, "expire_time", dealInfo.expire_time);
            ktc.a(jSONObject, "unit_price", dealInfo.unit_price);
            ktc.a(jSONObject, "product_id", dealInfo.product_id);
            ktc.a(jSONObject, "seller_address", dealInfo.seller_address);
            ktc.a(jSONObject, "recommendations", dealInfo.recommendations);
            ktc.a(jSONObject, "has_recommend", dealInfo.has_recommend);
            ktc.a(jSONObject, "status", dealInfo.status);
            if (dealInfo.media != null) {
                JSONArray jSONArray = new JSONArray();
                for (DealMedia dealMedia : dealInfo.media) {
                    jSONArray.put(iwc.b(dealMedia));
                }
                ktc.a(jSONObject, "media", jSONArray);
            }
            if (dealInfo.auth_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (DealAuthInfo dealAuthInfo : dealInfo.auth_info) {
                    jSONArray2.put(gwc.b(dealAuthInfo));
                }
                ktc.a(jSONObject, "auth_info", jSONArray2);
            }
            ktc.a(jSONObject, "ship_fee", dealInfo.ship_fee);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
