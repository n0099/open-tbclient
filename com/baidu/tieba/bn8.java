package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class bn8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bn8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public bn8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static bn8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (bn8.class) {
                    if (a == null) {
                        a = new bn8();
                    }
                }
            }
            return a;
        }
        return (bn8) invokeV.objValue;
    }

    public void b(long j, String str, String str2, String str3, String str4, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), str, str2, str3, str4, Long.valueOf(j2)}) == null) && j != 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            pb8.j().r(TbadkCoreApplication.getCurrentAccount(), str, str2, str3, str4, j, 0L, j2, true);
        }
    }

    public void c(@Nullable List<ChatRoomInfo> list, @Nullable List<ChatRoomInfo> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2) == null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            if (list == null) {
                list = new ArrayList<>();
            }
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            for (ChatRoomInfo chatRoomInfo : list) {
                if (chatRoomInfo != null) {
                    hashMap.put(Long.valueOf(chatRoomInfo.getRoomId()), chatRoomInfo);
                }
            }
            for (ChatRoomInfo chatRoomInfo2 : list2) {
                if (chatRoomInfo2 != null) {
                    hashMap2.put(Long.valueOf(chatRoomInfo2.getRoomId()), chatRoomInfo2);
                }
            }
            if (c31.c(hashMap)) {
                if (c31.c(hashMap2)) {
                    return;
                }
                for (ChatRoomInfo chatRoomInfo3 : list2) {
                    if (chatRoomInfo3 != null) {
                        b(chatRoomInfo3.getRoomId(), chatRoomInfo3.getName(), chatRoomInfo3.getAvatar(), chatRoomInfo3.getForumId(), chatRoomInfo3.getForumName(), chatRoomInfo3.getTimestamp());
                    }
                }
            } else if (c31.c(hashMap2)) {
                if (c31.c(hashMap)) {
                    return;
                }
                for (ChatRoomInfo chatRoomInfo4 : list) {
                    if (chatRoomInfo4 != null) {
                        d(chatRoomInfo4.getRoomId(), chatRoomInfo4.getName(), chatRoomInfo4.getAvatar(), false);
                    }
                }
            } else {
                if (!c31.c(hashMap2) && hashMap2.entrySet() != null && hashMap2.entrySet().iterator() != null) {
                    for (Map.Entry entry : hashMap2.entrySet()) {
                        if (entry != null && entry.getValue() != null) {
                            if (hashMap.containsKey(entry.getKey())) {
                                if (!((ChatRoomInfo) hashMap.get(entry.getKey())).isSubscribe()) {
                                    d(((ChatRoomInfo) entry.getValue()).getRoomId(), ((ChatRoomInfo) entry.getValue()).getName(), ((ChatRoomInfo) entry.getValue()).getAvatar(), true);
                                }
                            } else {
                                b(((ChatRoomInfo) entry.getValue()).getRoomId(), ((ChatRoomInfo) entry.getValue()).getName(), ((ChatRoomInfo) entry.getValue()).getAvatar(), ((ChatRoomInfo) entry.getValue()).getForumId(), ((ChatRoomInfo) entry.getValue()).getForumName(), ((ChatRoomInfo) entry.getValue()).getTimestamp());
                            }
                        }
                    }
                }
                if (!c31.c(hashMap) && hashMap.entrySet() != null && hashMap.entrySet().iterator() != null) {
                    for (Map.Entry entry2 : hashMap.entrySet()) {
                        if (entry2 != null && entry2.getValue() != null) {
                            if (!hashMap2.containsKey(entry2.getKey())) {
                                d(((ChatRoomInfo) entry2.getValue()).getRoomId(), ((ChatRoomInfo) entry2.getValue()).getName(), ((ChatRoomInfo) entry2.getValue()).getAvatar(), false);
                            } else if (((ChatRoomInfo) hashMap2.get(entry2.getKey())).getIsShow() == 0 && TextUtils.isEmpty(((ChatRoomInfo) hashMap2.get(entry2.getKey())).getName())) {
                                d(((ChatRoomInfo) entry2.getValue()).getRoomId(), ((ChatRoomInfo) entry2.getValue()).getName(), ((ChatRoomInfo) entry2.getValue()).getAvatar(), false);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void d(long j, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, str2, Boolean.valueOf(z)}) == null) && j != 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            pb8.j().x(TbadkCoreApplication.getCurrentAccount(), j, str, str2, z);
        }
    }
}
