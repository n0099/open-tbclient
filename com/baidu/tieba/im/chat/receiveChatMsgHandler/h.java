package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity;
import com.baidu.tieba.im.chat.officialBar.bb;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.az;
import java.util.HashMap;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class h {
    public static boolean a = true;

    public static boolean a(GroupMsgData groupMsgData) {
        int i;
        String valueOf = String.valueOf(groupMsgData.b().getGroupId());
        HashMap hashMap = new HashMap();
        LinkedList<com.baidu.tieba.im.message.a.a> c = groupMsgData.c();
        if (c == null || c.size() <= 0) {
            return false;
        }
        LinkedList linkedList = new LinkedList();
        int i2 = 0;
        long j = 0;
        int size = c.size();
        int i3 = 0;
        for (com.baidu.tieba.im.message.a.a aVar : c) {
            aVar.a(new MsgLocalData());
            aVar.y().setStatus((short) 3);
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(aVar);
            if (!commonMsgPojo.isSelf()) {
                az.a("v_mpush", commonMsgPojo.getUid());
                com.baidu.tieba.im.model.p.a(true);
                com.baidu.tieba.im.r.a(new i(), null);
            }
            commonMsgPojo.setPrivate(true);
            String uid = commonMsgPojo.getUid();
            String toUid = commonMsgPojo.getToUid();
            com.baidu.adp.lib.util.f.e("see content:" + commonMsgPojo);
            com.baidu.adp.lib.util.f.e("see push private uidStr:" + uid + " toUidStr:" + toUid + " loginId:" + TbadkApplication.E());
            if (TextUtils.isEmpty(uid)) {
                com.baidu.adp.lib.util.f.e("see push private uidStr is null");
                return false;
            } else if (toUid.equals(uid) && uid.equals(TbadkApplication.E())) {
                com.baidu.adp.lib.util.f.e("see push private send msg to self");
                return false;
            } else {
                if (uid.equals(TbadkApplication.E())) {
                    com.baidu.adp.lib.util.f.e("see push private uid is loginid");
                } else {
                    toUid = uid;
                }
                commonMsgPojo.setGid(toUid);
                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(aVar);
                long parseLong = Long.parseLong(toUid);
                if (0 == j) {
                    j = parseLong;
                } else if (j != parseLong && i3 != size - 1) {
                    if (OfficialBarChatActivity.a && valueOf.equals(OfficialBarChatActivity.b)) {
                        i2 = 0;
                    }
                    CommonMsgPojo commonMsgPojo3 = (CommonMsgPojo) linkedList.getLast();
                    com.baidu.adp.lib.util.f.e("see content1:" + commonMsgPojo + "lastPojo:" + commonMsgPojo3);
                    commonMsgPojo3.checkRidAndSelf();
                    String gid = commonMsgPojo3.getGid();
                    if (((com.baidu.tieba.im.chat.az) hashMap.get(gid)) != null) {
                        com.baidu.tieba.im.chat.az azVar = (com.baidu.tieba.im.chat.az) hashMap.get(gid);
                        azVar.b = commonMsgPojo3;
                        azVar.c += i2;
                    } else {
                        com.baidu.tieba.im.chat.az azVar2 = new com.baidu.tieba.im.chat.az();
                        azVar2.a = gid;
                        azVar2.b = commonMsgPojo3;
                        azVar2.c = i2;
                        hashMap.put(azVar2.a, azVar2);
                    }
                    i2 = 0;
                    j = parseLong;
                    linkedList = new LinkedList();
                }
                a.a(valueOf, aVar);
                boolean a2 = a.a(aVar);
                if (a2) {
                    commonMsgPojo.setRead_flag(0);
                    i = i2;
                } else {
                    commonMsgPojo.setRead_flag(1);
                    i = i2 + 1;
                }
                linkedList.add(commonMsgPojo);
                long parseLong2 = Long.parseLong(commonMsgPojo2.getUid());
                long parseLong3 = Long.parseLong(commonMsgPojo2.getToUid());
                LinkedList linkedList2 = new LinkedList();
                commonMsgPojo2.setRead_flag(a2 ? 0 : 1);
                linkedList2.add(commonMsgPojo2);
                com.baidu.adp.lib.util.f.e(" private insert to db:" + commonMsgPojo2 + " unreadCount:" + i);
                com.baidu.tieba.im.r.a(new j(parseLong2, parseLong3, linkedList2), null);
                if (i3 == size - 1) {
                    if (OfficialBarChatActivity.a && valueOf.equals(OfficialBarChatActivity.b)) {
                        i = 0;
                    }
                    CommonMsgPojo commonMsgPojo4 = (CommonMsgPojo) linkedList.getLast();
                    commonMsgPojo4.checkRidAndSelf();
                    String gid2 = commonMsgPojo4.getGid();
                    com.baidu.adp.lib.util.f.e("see content2:" + commonMsgPojo + "lastPojo:" + commonMsgPojo4);
                    if (((com.baidu.tieba.im.chat.az) hashMap.get(gid2)) != null) {
                        com.baidu.tieba.im.chat.az azVar3 = (com.baidu.tieba.im.chat.az) hashMap.get(gid2);
                        azVar3.b = commonMsgPojo4;
                        azVar3.c += i;
                    } else {
                        com.baidu.tieba.im.chat.az azVar4 = new com.baidu.tieba.im.chat.az();
                        azVar4.a = gid2;
                        azVar4.b = commonMsgPojo4;
                        azVar4.c = i;
                        hashMap.put(azVar4.a, azVar4);
                    }
                    linkedList = new LinkedList();
                    i = 0;
                } else {
                    parseLong3 = j;
                }
                j = parseLong3;
                i3++;
                i2 = i;
            }
        }
        boolean z = false;
        for (String str : hashMap.keySet()) {
            com.baidu.tieba.im.chat.az azVar5 = (com.baidu.tieba.im.chat.az) hashMap.get(str);
            com.baidu.tieba.im.b.j.a().a(azVar5.a, azVar5.c, azVar5.b);
            String str2 = azVar5.a;
            int i4 = azVar5.c;
            if (a(azVar5.b)) {
                z = true;
            }
        }
        return z;
    }

    private static synchronized boolean a(CommonMsgPojo commonMsgPojo) {
        boolean z = true;
        boolean z2 = false;
        synchronized (h.class) {
            if (commonMsgPojo != null) {
                a = true;
                com.baidu.tieba.im.message.a.a chatMessage = commonMsgPojo.toChatMessage();
                if (chatMessage != null) {
                    SystemMsgData i = com.baidu.tieba.im.f.q.i(chatMessage);
                    if (i != null && !i.getIsSelf()) {
                        z = false;
                    }
                    if (TbadkApplication.F()) {
                        if (chatMessage.r().getUserId().equals(TbadkApplication.E()) && chatMessage.t() != 11) {
                            z = false;
                        }
                    }
                }
                if (commonMsgPojo.getRead_flag() == 0) {
                    a = false;
                    z = false;
                }
                if (!TbadkApplication.j().ag() && commonMsgPojo.isPrivate()) {
                    z = false;
                }
                String gid = commonMsgPojo.getGid();
                if (!TextUtils.isEmpty(gid) && OfficialBarChatActivity.a && gid.equals(OfficialBarChatActivity.b)) {
                    z = false;
                }
                boolean d = bb.a().d(TbadkApplication.E(), commonMsgPojo.getGid());
                if (!z || d) {
                    z2 = z;
                }
            }
        }
        return z2;
    }
}
