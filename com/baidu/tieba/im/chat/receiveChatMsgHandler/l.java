package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.chat.az;
import com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.RequestSendPVTJMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class l {
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
                next.setLocalData(new MsgLocalData());
                next.getLocalData().setStatus((short) 3);
                CommonMsgPojo commonMsgPojo = new CommonMsgPojo(next);
                if (!commonMsgPojo.isSelf()) {
                    RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_V_MPUSH, commonMsgPojo.getUid());
                    com.baidu.tieba.im.model.r.a(true);
                    com.baidu.tieba.im.i.a(new m(), null);
                }
                commonMsgPojo.setPrivate(true);
                String uid = commonMsgPojo.getUid();
                String toUid = commonMsgPojo.getToUid();
                BdLog.d("see content:" + commonMsgPojo);
                BdLog.d("see push private uidStr:" + uid + " toUidStr:" + toUid + " loginId:" + TbadkApplication.getCurrentAccount());
                if (TextUtils.isEmpty(uid)) {
                    BdLog.d("see push private uidStr is null");
                    return false;
                } else if (toUid.equals(uid) && uid.equals(TbadkApplication.getCurrentAccount())) {
                    BdLog.d("see push private send msg to self");
                    return false;
                } else {
                    if (uid.equals(TbadkApplication.getCurrentAccount())) {
                        BdLog.d("see push private uid is loginid");
                    } else {
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
                        if (OfficialBarChatActivity.a && valueOf.equals(OfficialBarChatActivity.b)) {
                            i2 = 0;
                        }
                        CommonMsgPojo commonMsgPojo3 = (CommonMsgPojo) linkedList2.getLast();
                        BdLog.d("see content1:" + commonMsgPojo + "lastPojo:" + commonMsgPojo3);
                        commonMsgPojo3.checkRidAndSelf();
                        String gid = commonMsgPojo3.getGid();
                        if (((az) hashMap.get(gid)) != null) {
                            az azVar = (az) hashMap.get(gid);
                            azVar.b = commonMsgPojo3;
                            azVar.c += i2;
                        } else {
                            az azVar2 = new az();
                            azVar2.a = gid;
                            azVar2.b = commonMsgPojo3;
                            azVar2.c = i2;
                            hashMap.put(azVar2.a, azVar2);
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
                    long parseLong2 = Long.parseLong(commonMsgPojo2.getUid());
                    long parseLong3 = Long.parseLong(commonMsgPojo2.getToUid());
                    LinkedList linkedList3 = new LinkedList();
                    commonMsgPojo2.setRead_flag(a2 ? 0 : 1);
                    linkedList3.add(commonMsgPojo2);
                    BdLog.d(" private insert to db:" + commonMsgPojo2 + " unreadCount:" + i);
                    com.baidu.tieba.im.i.a(new n(parseLong2, parseLong3, linkedList3), null);
                    if (i4 == size - 1) {
                        if (OfficialBarChatActivity.a && valueOf.equals(OfficialBarChatActivity.b)) {
                            i = 0;
                        }
                        CommonMsgPojo commonMsgPojo4 = (CommonMsgPojo) linkedList.getLast();
                        commonMsgPojo4.checkRidAndSelf();
                        String gid2 = commonMsgPojo4.getGid();
                        BdLog.d("see content2:" + commonMsgPojo + "lastPojo:" + commonMsgPojo4);
                        if (((az) hashMap.get(gid2)) != null) {
                            az azVar3 = (az) hashMap.get(gid2);
                            azVar3.b = commonMsgPojo4;
                            azVar3.c += i;
                        } else {
                            az azVar4 = new az();
                            azVar4.a = gid2;
                            azVar4.b = commonMsgPojo4;
                            azVar4.c = i;
                            hashMap.put(azVar4.a, azVar4);
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
                }
            } else {
                boolean z = false;
                for (String str : hashMap.keySet()) {
                    az azVar5 = (az) hashMap.get(str);
                    com.baidu.tieba.im.b.j.a().a(azVar5.a, azVar5.c, azVar5.b, false);
                    if (a(azVar5.a, azVar5.c, azVar5.b)) {
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
        synchronized (l.class) {
            if (commonMsgPojo != null) {
                a = true;
                ChatMessage chatMessage = commonMsgPojo.toChatMessage();
                if (chatMessage != null) {
                    SystemMsgData j = com.baidu.tieba.im.f.r.j(chatMessage);
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
                String gid = commonMsgPojo.getGid();
                if (!TextUtils.isEmpty(gid) && OfficialBarChatActivity.a && gid.equals(OfficialBarChatActivity.b)) {
                    z = false;
                }
                boolean d = com.baidu.tieba.im.chat.officialBar.az.a().d(TbadkApplication.getCurrentAccount(), commonMsgPojo.getGid());
                if (!z || d) {
                    z2 = z;
                }
            }
        }
        return z2;
    }
}
