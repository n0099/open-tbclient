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
public class b0d extends poc {
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
                poc.a(jSONObject, "avatarframe", ypc.b(avatarFrame));
            }
            Portrait portrait = mparrProps.portrait;
            if (portrait != null) {
                poc.a(jSONObject, "portrait", m1d.b(portrait));
            }
            Level level = mparrProps.level;
            if (level != null) {
                poc.a(jSONObject, "level", mzc.b(level));
            }
            if (mparrProps.props != null) {
                JSONArray jSONArray = new JSONArray();
                for (Props props : mparrProps.props) {
                    jSONArray.put(u1d.b(props));
                }
                poc.a(jSONObject, "props", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
