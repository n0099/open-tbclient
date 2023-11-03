package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ItemPlot;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes5.dex */
public class ezc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ItemTable itemTable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, itemTable)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "is_commented", itemTable.is_commented);
            poc.a(jSONObject, "comment_star", itemTable.comment_star);
            poc.a(jSONObject, "total_point_num", itemTable.total_point_num);
            if (itemTable.item_point != null) {
                JSONArray jSONArray = new JSONArray();
                for (ItemPoint itemPoint : itemTable.item_point) {
                    jSONArray.put(czc.b(itemPoint));
                }
                poc.a(jSONObject, "item_point", jSONArray);
            }
            if (itemTable.item_plot != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (ItemPlot itemPlot : itemTable.item_plot) {
                    jSONArray2.put(bzc.b(itemPlot));
                }
                poc.a(jSONObject, "item_plot", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
