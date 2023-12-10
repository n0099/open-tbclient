package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.TabPic;
import tbclient.TabPicDesc;
/* loaded from: classes6.dex */
public class g9d extends ltc {
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
                ltc.a(jSONObject, "normal", f9d.b(tabPicDesc));
            }
            TabPicDesc tabPicDesc2 = tabPic.dark;
            if (tabPicDesc2 != null) {
                ltc.a(jSONObject, "dark", f9d.b(tabPicDesc2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
