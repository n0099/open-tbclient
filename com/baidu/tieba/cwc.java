package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsTabInfo;
/* loaded from: classes5.dex */
public class cwc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NavTabInfo navTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, navTabInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (navTabInfo.tab != null) {
                JSONArray jSONArray = new JSONArray();
                for (FrsTabInfo frsTabInfo : navTabInfo.tab) {
                    jSONArray.put(fyc.b(frsTabInfo));
                }
                qoc.a(jSONObject, "tab", jSONArray);
            }
            if (navTabInfo.menu != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FrsTabInfo frsTabInfo2 : navTabInfo.menu) {
                    jSONArray2.put(fyc.b(frsTabInfo2));
                }
                qoc.a(jSONObject, "menu", jSONArray2);
            }
            if (navTabInfo.head != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (FrsTabInfo frsTabInfo3 : navTabInfo.head) {
                    jSONArray3.put(fyc.b(frsTabInfo3));
                }
                qoc.a(jSONObject, "head", jSONArray3);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
