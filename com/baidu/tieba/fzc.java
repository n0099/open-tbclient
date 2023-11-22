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
/* loaded from: classes6.dex */
public class fzc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ItemTable itemTable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, itemTable)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "is_commented", itemTable.is_commented);
            qoc.a(jSONObject, "comment_star", itemTable.comment_star);
            qoc.a(jSONObject, "total_point_num", itemTable.total_point_num);
            if (itemTable.item_point != null) {
                JSONArray jSONArray = new JSONArray();
                for (ItemPoint itemPoint : itemTable.item_point) {
                    jSONArray.put(dzc.b(itemPoint));
                }
                qoc.a(jSONObject, "item_point", jSONArray);
            }
            if (itemTable.item_plot != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (ItemPlot itemPlot : itemTable.item_plot) {
                    jSONArray2.put(czc.b(itemPlot));
                }
                qoc.a(jSONObject, "item_plot", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
