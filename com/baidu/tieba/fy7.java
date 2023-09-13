package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.VoiceRoom;
/* loaded from: classes5.dex */
public class fy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<by7> a(List<VoiceRoom> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (VoiceRoom voiceRoom : list) {
                if (voiceRoom != null) {
                    ArrayList arrayList2 = new ArrayList();
                    by7 by7Var = new by7();
                    by7Var.a = voiceRoom.room_name;
                    by7Var.c = String.valueOf(voiceRoom.talker_num);
                    by7Var.d = String.valueOf(voiceRoom.joined_num);
                    by7Var.e = voiceRoom.room_id.longValue();
                    for (User user : voiceRoom.talker) {
                        if (user != null) {
                            arrayList2.add(user.portrait);
                        }
                    }
                    by7Var.b = arrayList2;
                    arrayList.add(by7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
