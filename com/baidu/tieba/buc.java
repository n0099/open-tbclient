package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.schemedispatch.forbid.InvokeStatisticKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Advertisement;
/* loaded from: classes5.dex */
public class buc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Advertisement advertisement) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, advertisement)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "time", advertisement.time);
            ltc.a(jSONObject, pic.f, advertisement.pic);
            ltc.a(jSONObject, "pic_click", advertisement.pic_click);
            ltc.a(jSONObject, "jump_link", advertisement.jump_link);
            ltc.a(jSONObject, "advertisement_id", advertisement.advertisement_id);
            ltc.a(jSONObject, "view_statistics_url", advertisement.view_statistics_url);
            ltc.a(jSONObject, "click_statistics_url", advertisement.click_statistics_url);
            ltc.a(jSONObject, "floating_text", advertisement.floating_text);
            ltc.a(jSONObject, InvokeStatisticKt.SCHEME_INVOKE_PAGE_DEEPLINK, advertisement.deeplink);
            ltc.a(jSONObject, "scheme", advertisement.scheme);
            ltc.a(jSONObject, "package_name", advertisement.package_name);
            ltc.a(jSONObject, "display_ad_icon", advertisement.display_ad_icon);
            ltc.a(jSONObject, "activity_id", advertisement.activity_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
