package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PbLinkInfo;
/* loaded from: classes5.dex */
public class c6d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PbLinkInfo pbLinkInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pbLinkInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "title", pbLinkInfo.title);
            ltc.a(jSONObject, "to_url", pbLinkInfo.to_url);
            ltc.a(jSONObject, "pic_url", pbLinkInfo.pic_url);
            ltc.a(jSONObject, "link_from", pbLinkInfo.link_from);
            ltc.a(jSONObject, "ext_txt", pbLinkInfo.ext_txt);
            ltc.a(jSONObject, QuickPersistConfigConst.KEY_SPLASH_SORT, pbLinkInfo.sort);
            ltc.a(jSONObject, "url_type", pbLinkInfo.url_type);
            ltc.a(jSONObject, GameGuideConfigInfo.KEY_CONTENT1, pbLinkInfo.content1);
            ltc.a(jSONObject, GameGuideConfigInfo.KEY_CONTENT2, pbLinkInfo.content2);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
