package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AvatarFrame;
import tbclient.Level;
import tbclient.MparrProps;
import tbclient.Portrait;
import tbclient.Props;
/* loaded from: classes5.dex */
public class f5d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MparrProps mparrProps) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, mparrProps)) == null) {
            JSONObject jSONObject = new JSONObject();
            AvatarFrame avatarFrame = mparrProps.avatarframe;
            if (avatarFrame != null) {
                ltc.a(jSONObject, "avatarframe", wuc.b(avatarFrame));
            }
            Portrait portrait = mparrProps.portrait;
            if (portrait != null) {
                ltc.a(jSONObject, "portrait", q6d.b(portrait));
            }
            Level level = mparrProps.level;
            if (level != null) {
                ltc.a(jSONObject, "level", q4d.b(level));
            }
            if (mparrProps.props != null) {
                JSONArray jSONArray = new JSONArray();
                for (Props props : mparrProps.props) {
                    jSONArray.put(y6d.b(props));
                }
                ltc.a(jSONObject, "props", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
