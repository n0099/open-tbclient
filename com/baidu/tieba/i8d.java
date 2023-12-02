package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Avatar;
import tbclient.Equipment;
import tbclient.SignatureInfo;
/* loaded from: classes6.dex */
public class i8d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SignatureInfo signatureInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, signatureInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            Equipment equipment = signatureInfo.equipment;
            if (equipment != null) {
                ktc.a(jSONObject, "equipment", swc.b(equipment));
            }
            ktc.a(jSONObject, "game_id", signatureInfo.game_id);
            ktc.a(jSONObject, "game_name", signatureInfo.game_name);
            ktc.a(jSONObject, DI.LIVE_PLAYER, signatureInfo.player);
            Avatar avatar = signatureInfo.avatar;
            if (avatar != null) {
                ktc.a(jSONObject, "avatar", uuc.b(avatar));
            }
            ktc.a(jSONObject, "power", signatureInfo.power);
            ktc.a(jSONObject, CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_SERVER, signatureInfo.server);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
