package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Toast;
import tbclient.ToastContent;
/* loaded from: classes6.dex */
public class iad extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Toast toast) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, toast)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "icon_type", toast.icon_type);
            if (toast.content != null) {
                JSONArray jSONArray = new JSONArray();
                for (ToastContent toastContent : toast.content) {
                    jSONArray.put(had.b(toastContent));
                }
                ltc.a(jSONObject, "content", jSONArray);
            }
            ltc.a(jSONObject, "url", toast.url);
            ltc.a(jSONObject, NotificationCompat.WearableExtender.KEY_BACKGROUND, toast.background);
            ltc.a(jSONObject, "icon_url", toast.icon_url);
            ltc.a(jSONObject, "icon_url_dark", toast.icon_url_dark);
            if (toast.task_ids != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Integer num : toast.task_ids) {
                    jSONArray2.put(num.intValue());
                }
                ltc.a(jSONObject, "task_ids", jSONArray2);
            }
            ltc.a(jSONObject, "icon_width", toast.icon_width);
            ltc.a(jSONObject, "icon_height", toast.icon_height);
            ltc.a(jSONObject, "hud_width", toast.hud_width);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
