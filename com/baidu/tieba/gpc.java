package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.schemedispatch.forbid.InvokeStatisticKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Advertisement;
/* loaded from: classes6.dex */
public class gpc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Advertisement advertisement) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, advertisement)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "time", advertisement.time);
            qoc.a(jSONObject, "pic", advertisement.pic);
            qoc.a(jSONObject, "pic_click", advertisement.pic_click);
            qoc.a(jSONObject, "jump_link", advertisement.jump_link);
            qoc.a(jSONObject, "advertisement_id", advertisement.advertisement_id);
            qoc.a(jSONObject, "view_statistics_url", advertisement.view_statistics_url);
            qoc.a(jSONObject, "click_statistics_url", advertisement.click_statistics_url);
            qoc.a(jSONObject, "floating_text", advertisement.floating_text);
            qoc.a(jSONObject, InvokeStatisticKt.SCHEME_INVOKE_PAGE_DEEPLINK, advertisement.deeplink);
            qoc.a(jSONObject, "scheme", advertisement.scheme);
            qoc.a(jSONObject, "package_name", advertisement.package_name);
            qoc.a(jSONObject, "display_ad_icon", advertisement.display_ad_icon);
            qoc.a(jSONObject, "activity_id", advertisement.activity_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
