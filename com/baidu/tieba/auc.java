package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.schemedispatch.forbid.InvokeStatisticKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Advertisement;
/* loaded from: classes5.dex */
public class auc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Advertisement advertisement) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, advertisement)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "time", advertisement.time);
            ktc.a(jSONObject, "pic", advertisement.pic);
            ktc.a(jSONObject, "pic_click", advertisement.pic_click);
            ktc.a(jSONObject, "jump_link", advertisement.jump_link);
            ktc.a(jSONObject, "advertisement_id", advertisement.advertisement_id);
            ktc.a(jSONObject, "view_statistics_url", advertisement.view_statistics_url);
            ktc.a(jSONObject, "click_statistics_url", advertisement.click_statistics_url);
            ktc.a(jSONObject, "floating_text", advertisement.floating_text);
            ktc.a(jSONObject, InvokeStatisticKt.SCHEME_INVOKE_PAGE_DEEPLINK, advertisement.deeplink);
            ktc.a(jSONObject, "scheme", advertisement.scheme);
            ktc.a(jSONObject, "package_name", advertisement.package_name);
            ktc.a(jSONObject, "display_ad_icon", advertisement.display_ad_icon);
            ktc.a(jSONObject, "activity_id", advertisement.activity_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
