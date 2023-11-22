package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.TabPic;
import tbclient.TabPicDesc;
/* loaded from: classes5.dex */
public class d4d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TabPic tabPic) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tabPic)) == null) {
            JSONObject jSONObject = new JSONObject();
            TabPicDesc tabPicDesc = tabPic.normal;
            if (tabPicDesc != null) {
                qoc.a(jSONObject, "normal", c4d.b(tabPicDesc));
            }
            TabPicDesc tabPicDesc2 = tabPic.dark;
            if (tabPicDesc2 != null) {
                qoc.a(jSONObject, "dark", c4d.b(tabPicDesc2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
