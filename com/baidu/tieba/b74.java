package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static RecommendItemModel a(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            RecommendItemModel recommendItemModel = new RecommendItemModel();
            recommendItemModel.appName = jSONObject.optString("app_name");
            recommendItemModel.appKey = jSONObject.optString(GameGuideConfigInfo.KEY_APP_KEY);
            recommendItemModel.iconUrl = jSONObject.optString("icon_url");
            recommendItemModel.scheme = jSONObject.optString("scheme");
            recommendItemModel.desc = jSONObject.optString("desc");
            JSONObject optJSONObject = jSONObject.optJSONObject(NativeConstants.ID_BUTTON);
            if (optJSONObject != null) {
                recommendItemModel.buttonText = optJSONObject.optString("text");
            }
            return recommendItemModel;
        }
        return (RecommendItemModel) invokeL.objValue;
    }

    @NonNull
    public static a74 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            a74 a74Var = new a74();
            if (jSONObject == null) {
                return a74Var;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("game_center");
            if (optJSONObject != null) {
                a74Var.a = a(optJSONObject);
            }
            a74Var.b = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("app_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a74Var.b.add(a(optJSONArray.optJSONObject(i)));
                }
            }
            return a74Var;
        }
        return (a74) invokeL.objValue;
    }

    @NonNull
    public static c74 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            c74 c74Var = new c74();
            try {
                JSONObject jSONObject = new JSONObject(str);
                c74Var.a = jSONObject.getInt("errno");
                c74Var.b = jSONObject.optString("errmsg");
                c74Var.c = jSONObject.optJSONObject("data");
                return c74Var;
            } catch (JSONException e) {
                c74Var.a = -1;
                c74Var.b = "network error: response parse failed.";
                if (vj1.a) {
                    Log.e("RecommendModelParser", "parseResponseModel error:" + e);
                }
                return c74Var;
            }
        }
        return (c74) invokeL.objValue;
    }
}
