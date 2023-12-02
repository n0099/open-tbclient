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
public class b6d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PbLinkInfo pbLinkInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pbLinkInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "title", pbLinkInfo.title);
            ktc.a(jSONObject, "to_url", pbLinkInfo.to_url);
            ktc.a(jSONObject, "pic_url", pbLinkInfo.pic_url);
            ktc.a(jSONObject, "link_from", pbLinkInfo.link_from);
            ktc.a(jSONObject, "ext_txt", pbLinkInfo.ext_txt);
            ktc.a(jSONObject, QuickPersistConfigConst.KEY_SPLASH_SORT, pbLinkInfo.sort);
            ktc.a(jSONObject, "url_type", pbLinkInfo.url_type);
            ktc.a(jSONObject, GameGuideConfigInfo.KEY_CONTENT1, pbLinkInfo.content1);
            ktc.a(jSONObject, GameGuideConfigInfo.KEY_CONTENT2, pbLinkInfo.content2);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
