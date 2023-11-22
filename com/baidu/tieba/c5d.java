package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Timgs;
/* loaded from: classes5.dex */
public class c5d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Timgs timgs) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, timgs)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, BigdayActivityConfig.IMG_URL, timgs.img_url);
            qoc.a(jSONObject, "url", timgs.url);
            qoc.a(jSONObject, "flag", timgs.flag);
            qoc.a(jSONObject, "des_main", timgs.des_main);
            qoc.a(jSONObject, "des_sub", timgs.des_sub);
            qoc.a(jSONObject, "bsize", timgs.bsize);
            qoc.a(jSONObject, "big_cdn_url", timgs.big_cdn_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
