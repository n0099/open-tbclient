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
public class c0d extends qoc {
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
                qoc.a(jSONObject, "avatarframe", zpc.b(avatarFrame));
            }
            Portrait portrait = mparrProps.portrait;
            if (portrait != null) {
                qoc.a(jSONObject, "portrait", n1d.b(portrait));
            }
            Level level = mparrProps.level;
            if (level != null) {
                qoc.a(jSONObject, "level", nzc.b(level));
            }
            if (mparrProps.props != null) {
                JSONArray jSONArray = new JSONArray();
                for (Props props : mparrProps.props) {
                    jSONArray.put(v1d.b(props));
                }
                qoc.a(jSONObject, "props", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
