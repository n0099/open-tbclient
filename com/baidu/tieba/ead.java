package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Timgs;
/* loaded from: classes5.dex */
public class ead extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Timgs timgs) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, timgs)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, BigdayActivityConfig.IMG_URL, timgs.img_url);
            ktc.a(jSONObject, "url", timgs.url);
            ktc.a(jSONObject, "flag", timgs.flag);
            ktc.a(jSONObject, "des_main", timgs.des_main);
            ktc.a(jSONObject, "des_sub", timgs.des_sub);
            ktc.a(jSONObject, "bsize", timgs.bsize);
            ktc.a(jSONObject, "big_cdn_url", timgs.big_cdn_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
