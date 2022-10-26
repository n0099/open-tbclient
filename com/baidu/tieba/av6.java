package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.User;
import tbclient.VoiceRoom;
/* loaded from: classes3.dex */
public class av6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List a(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                VoiceRoom voiceRoom = (VoiceRoom) it.next();
                if (voiceRoom != null) {
                    ArrayList arrayList2 = new ArrayList();
                    wu6 wu6Var = new wu6();
                    wu6Var.a = voiceRoom.room_name;
                    wu6Var.c = String.valueOf(voiceRoom.talker_num);
                    wu6Var.d = String.valueOf(voiceRoom.joined_num);
                    wu6Var.e = voiceRoom.room_id.longValue();
                    for (User user : voiceRoom.talker) {
                        if (user != null) {
                            arrayList2.add(user.portrait);
                        }
                    }
                    wu6Var.b = arrayList2;
                    arrayList.add(wu6Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
