package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.schemedispatch.forbid.InvokeStatisticKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Advertisement;
/* loaded from: classes6.dex */
public class fpc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Advertisement advertisement) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, advertisement)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "time", advertisement.time);
            poc.a(jSONObject, "pic", advertisement.pic);
            poc.a(jSONObject, "pic_click", advertisement.pic_click);
            poc.a(jSONObject, "jump_link", advertisement.jump_link);
            poc.a(jSONObject, "advertisement_id", advertisement.advertisement_id);
            poc.a(jSONObject, "view_statistics_url", advertisement.view_statistics_url);
            poc.a(jSONObject, "click_statistics_url", advertisement.click_statistics_url);
            poc.a(jSONObject, "floating_text", advertisement.floating_text);
            poc.a(jSONObject, InvokeStatisticKt.SCHEME_INVOKE_PAGE_DEEPLINK, advertisement.deeplink);
            poc.a(jSONObject, "scheme", advertisement.scheme);
            poc.a(jSONObject, "package_name", advertisement.package_name);
            poc.a(jSONObject, "display_ad_icon", advertisement.display_ad_icon);
            poc.a(jSONObject, "activity_id", advertisement.activity_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
