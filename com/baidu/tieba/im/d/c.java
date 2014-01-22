package com.baidu.tieba.im.d;

import android.content.Context;
import com.baidu.tieba.im.chat.ba;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.db.ah;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.db.t;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Locale;
/* loaded from: classes.dex */
public class c {
    public static int a() {
        return Calendar.getInstance(Locale.CHINA).get(6);
    }

    public static int a(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }

    public static void a(RandChatRoomData randChatRoomData) {
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        imMessageCenterPojo.setGid(String.valueOf(randChatRoomData.d()));
        imMessageCenterPojo.setPulled_msgId(ba.b(randChatRoomData.k()));
        imMessageCenterPojo.setGroup_type(7);
        imMessageCenterPojo.setGroup_name("聊天室");
        imMessageCenterPojo.setIs_delete(0);
        LinkedHashMap<String, Long> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(imMessageCenterPojo.getGid(), 0L);
        com.baidu.tieba.im.db.d.a().a(linkedHashMap, (com.baidu.tieba.im.a<Void>) null);
        imMessageCenterPojo.setIs_hidden(1);
        ah.a().b(imMessageCenterPojo);
        t.a().a(imMessageCenterPojo, (com.baidu.tieba.im.a<Boolean>) null);
    }

    public static void a(String str) {
        ah.a().b(str);
        t.a().a(str, (com.baidu.tieba.im.a<Boolean>) null);
        com.baidu.tieba.im.db.d.a().a(str, (com.baidu.tieba.im.a<Boolean>) null);
    }
}
