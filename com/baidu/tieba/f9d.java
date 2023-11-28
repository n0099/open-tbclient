package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.TabPicDesc;
/* loaded from: classes5.dex */
public class f9d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TabPicDesc tabPicDesc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tabPicDesc)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "selected_pic_url", tabPicDesc.selected_pic_url);
            ltc.a(jSONObject, "unselected_pic_url", tabPicDesc.unselected_pic_url);
            ltc.a(jSONObject, VrPlayerActivityConfig.PIC_HEIGHT, tabPicDesc.pic_height);
            ltc.a(jSONObject, VrPlayerActivityConfig.PIC_WIDTH, tabPicDesc.pic_width);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
