package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.chat.ay;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.stranger.StrangerListActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class q {
    public static boolean a = true;

    public static boolean a(GroupMsgData groupMsgData) {
        LinkedList linkedList;
        int i;
        String valueOf = String.valueOf(groupMsgData.getGroupInfo().getGroupId());
        HashMap hashMap = new HashMap();
        LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
        if (listMessage == null || listMessage.size() <= 0) {
            return false;
        }
        LinkedList linkedList2 = new LinkedList();
        int i2 = 0;
        long j = 0;
        int i3 = 0;
        int size = listMessage.size();
        Iterator<ChatMessage> it = listMessage.iterator();
        while (true) {
            int i4 = i3;
            if (it.hasNext()) {
                ChatMessage next = it.next();
                if (next.getIsFriend() == 0 && !StrangerListActivity.a) {
                    com.baidu.tieba.im.model.p.b(true);
                    com.baidu.tieba.im.i.a(new r(), null);
                }
                next.setLocalData(new MsgLocalData());
                next.getLocalData().setStatus((short) 3);
                CommonMsgPojo commonMsgPojo = new CommonMsgPojo(next);
                commonMsgPojo.setPrivate(true);
                String uid = commonMsgPojo.getUid();
                String toUid = commonMsgPojo.getToUid();
                if (TextUtils.isEmpty(uid)) {
                    return false;
                }
                if (toUid.equals(uid) && uid.equals(TbadkApplication.getCurrentAccount())) {
                    return false;
                }
                if (!uid.equals(TbadkApplication.getCurrentAccount())) {
                    toUid = uid;
                }
                commonMsgPojo.setGid(toUid);
                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(next);
                long parseLong = Long.parseLong(toUid);
                if (0 == j) {
                    linkedList = linkedList2;
                } else if (j == parseLong || i4 == size - 1) {
                    parseLong = j;
                    linkedList = linkedList2;
                } else {
                    CommonMsgPojo commonMsgPojo3 = (CommonMsgPojo) linkedList2.getLast();
                    commonMsgPojo3.checkRidAndSelf();
                    String gid = commonMsgPojo3.getGid();
                    if (PersonalChatActivity.a && gid.equals(PersonalChatActivity.b)) {
                        i2 = 0;
                    }
                    if (((ay) hashMap.get(gid)) != null) {
                        ay ayVar = (ay) hashMap.get(gid);
                        ayVar.b = commonMsgPojo3;
                        ayVar.c += i2;
                    } else {
                        ay ayVar2 = new ay();
                        ayVar2.a = gid;
                        ayVar2.b = commonMsgPojo3;
                        ayVar2.c = i2;
                        hashMap.put(ayVar2.a, ayVar2);
                    }
                    i2 = 0;
                    linkedList = new LinkedList();
                }
                a.a(valueOf, next);
                boolean a2 = a.a(next);
                if (a2) {
                    commonMsgPojo.setRead_flag(0);
                    i = i2;
                } else {
                    commonMsgPojo.setRead_flag(1);
                    i = i2 + 1;
                }
                linkedList.add(commonMsgPojo);
                commonMsgPojo2.setRead_flag(a2 ? 0 : 1);
                long parseLong2 = Long.parseLong(commonMsgPojo2.getUid());
                long parseLong3 = Long.parseLong(commonMsgPojo2.getToUid());
                LinkedList linkedList3 = new LinkedList();
                linkedList3.add(commonMsgPojo2);
                com.baidu.tieba.im.i.a(new s(parseLong2, parseLong3, linkedList3), null);
                if (i4 == size - 1) {
                    CommonMsgPojo commonMsgPojo4 = (CommonMsgPojo) linkedList.getLast();
                    commonMsgPojo4.checkRidAndSelf();
                    String gid2 = commonMsgPojo4.getGid();
                    if (PersonalChatActivity.a && gid2.equals(PersonalChatActivity.b)) {
                        i = 0;
                    }
                    if (((ay) hashMap.get(gid2)) != null) {
                        ay ayVar3 = (ay) hashMap.get(gid2);
                        ayVar3.b = commonMsgPojo4;
                        ayVar3.c += i;
                    } else {
                        ay ayVar4 = new ay();
                        ayVar4.a = gid2;
                        ayVar4.b = commonMsgPojo4;
                        ayVar4.c = i;
                        hashMap.put(ayVar4.a, ayVar4);
                    }
                    linkedList = new LinkedList();
                    i = 0;
                    j = parseLong3;
                } else {
                    j = parseLong;
                }
                i2 = i;
                linkedList2 = linkedList;
                i3 = i4 + 1;
            } else {
                boolean z = false;
                for (String str : hashMap.keySet()) {
                    ay ayVar5 = (ay) hashMap.get(str);
                    com.baidu.tieba.im.b.k.a().a(ayVar5.a, ayVar5.c, ayVar5.b, false);
                    if (a(ayVar5.a, ayVar5.c, ayVar5.b)) {
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    public static synchronized boolean a(String str, int i, CommonMsgPojo commonMsgPojo) {
        boolean z = true;
        boolean z2 = false;
        synchronized (q.class) {
            if (commonMsgPojo != null) {
                a = true;
                ChatMessage chatMessage = commonMsgPojo.toChatMessage();
                if (chatMessage != null) {
                    SystemMsgData j = com.baidu.tieba.im.e.r.j(chatMessage);
                    if (j != null && !j.getIsSelf()) {
                        z = false;
                    }
                    if (TbadkApplication.isLogin()) {
                        if (chatMessage.getUserInfo().getUserId().equals(TbadkApplication.getCurrentAccount()) && chatMessage.getMsgType() != 11) {
                            z = false;
                        }
                    }
                }
                if (commonMsgPojo.getRead_flag() == 0) {
                    a = false;
                    z = false;
                }
                if (!TbadkApplication.m252getInst().isMsgChatOn() && commonMsgPojo.isPrivate()) {
                    z = false;
                }
                if (commonMsgPojo.getIsFriend() == 0) {
                    z = false;
                }
                String gid = commonMsgPojo.getGid();
                if (!TextUtils.isEmpty(gid) && PersonalChatActivity.a && gid.equals(PersonalChatActivity.b)) {
                    z = false;
                }
                boolean d = com.baidu.tieba.im.chat.personaltalk.a.a().d(TbadkApplication.getCurrentAccount(), commonMsgPojo.getGid());
                if (!z || d) {
                    z2 = z;
                }
            }
        }
        return z2;
    }
}
