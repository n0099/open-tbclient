package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Badges;
/* loaded from: classes6.dex */
public class guc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Badges badges) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, badges)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "badge_id", badges.badge_id);
            qoc.a(jSONObject, "badge_url", badges.badge_url);
            qoc.a(jSONObject, AlbumActivityConfig.FROM_WEB_VIEW, badges.webview);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
