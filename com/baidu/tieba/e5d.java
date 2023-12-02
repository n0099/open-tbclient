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
public class e5d extends ktc {
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
                ktc.a(jSONObject, "avatarframe", vuc.b(avatarFrame));
            }
            Portrait portrait = mparrProps.portrait;
            if (portrait != null) {
                ktc.a(jSONObject, "portrait", p6d.b(portrait));
            }
            Level level = mparrProps.level;
            if (level != null) {
                ktc.a(jSONObject, "level", p4d.b(level));
            }
            if (mparrProps.props != null) {
                JSONArray jSONArray = new JSONArray();
                for (Props props : mparrProps.props) {
                    jSONArray.put(x6d.b(props));
                }
                ktc.a(jSONObject, "props", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
