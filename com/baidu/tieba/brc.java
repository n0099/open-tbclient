package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ClickBackCard;
import tbclient.ClickBackCardItem;
/* loaded from: classes5.dex */
public class brc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ClickBackCard clickBackCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, clickBackCard)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "card_name", clickBackCard.card_name);
            if (clickBackCard.card_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ClickBackCardItem clickBackCardItem : clickBackCard.card_list) {
                    jSONArray.put(crc.b(clickBackCardItem));
                }
                poc.a(jSONObject, "card_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
