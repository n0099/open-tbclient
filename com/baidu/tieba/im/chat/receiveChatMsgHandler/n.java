package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.chat.az;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class n extends com.baidu.adp.framework.c.a {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        int i;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage2;
            String valueOf = String.valueOf(groupMsgData.b().getGroupId());
            HashMap hashMap = new HashMap();
            LinkedList<com.baidu.tieba.im.message.a.a> c = groupMsgData.c();
            if (c != null && c.size() > 0) {
                LinkedList linkedList = new LinkedList();
                int i2 = 0;
                long j = 0;
                int size = c.size();
                Iterator<com.baidu.tieba.im.message.a.a> it = c.iterator();
                int i3 = 0;
                while (true) {
                    if (it.hasNext()) {
                        com.baidu.tieba.im.message.a.a next = it.next();
                        next.a(new MsgLocalData());
                        next.y().setStatus((short) 3);
                        CommonMsgPojo commonMsgPojo = new CommonMsgPojo(next);
                        commonMsgPojo.setPrivate(true);
                        String uid = commonMsgPojo.getUid();
                        String toUid = commonMsgPojo.getToUid();
                        com.baidu.adp.lib.util.f.e("see content:" + commonMsgPojo);
                        com.baidu.adp.lib.util.f.e("see push private uidStr:" + uid + " toUidStr:" + toUid + " loginId:" + TbadkApplication.E());
                        if (TextUtils.isEmpty(uid)) {
                            com.baidu.adp.lib.util.f.e("see push private uidStr is null");
                            z = false;
                            break;
                        }
                        if (toUid.equals(uid) && uid.equals(TbadkApplication.E())) {
                            com.baidu.adp.lib.util.f.e("see push private send msg to self");
                            z = false;
                            break;
                        }
                        if (uid.equals(TbadkApplication.E())) {
                            com.baidu.adp.lib.util.f.e("see push private uid is loginid");
                        } else {
                            toUid = uid;
                        }
                        commonMsgPojo.setGid(toUid);
                        CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(next);
                        long parseLong = Long.parseLong(toUid);
                        if (0 == j) {
                            j = parseLong;
                        } else if (j != parseLong && i3 != size - 1) {
                            if (PersonalChatActivity.a && valueOf.equals(PersonalChatActivity.b)) {
                                i2 = 0;
                            }
                            CommonMsgPojo commonMsgPojo3 = (CommonMsgPojo) linkedList.getLast();
                            com.baidu.adp.lib.util.f.e("see content1:" + commonMsgPojo + "lastPojo:" + commonMsgPojo3);
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
                            j = parseLong;
                            linkedList = new LinkedList();
                        }
                        a.a(valueOf, next);
                        if (a.a(next)) {
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
                        linkedList2.add(commonMsgPojo2);
                        com.baidu.adp.lib.util.f.e(" private insert to db:" + commonMsgPojo2 + " unreadCount:" + i);
                        com.baidu.tieba.im.s.a(new m(parseLong2, parseLong3, linkedList2), null);
                        if (i3 == size - 1) {
                            if (PersonalChatActivity.a && valueOf.equals(PersonalChatActivity.b)) {
                                i = 0;
                            }
                            CommonMsgPojo commonMsgPojo4 = (CommonMsgPojo) linkedList.getLast();
                            commonMsgPojo4.checkRidAndSelf();
                            String gid2 = commonMsgPojo4.getGid();
                            com.baidu.adp.lib.util.f.e("see content2:" + commonMsgPojo + "lastPojo:" + commonMsgPojo4);
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
                        } else {
                            parseLong3 = j;
                        }
                        j = parseLong3;
                        i3++;
                        i2 = i;
                    } else {
                        z = false;
                        for (String str : hashMap.keySet()) {
                            az azVar5 = (az) hashMap.get(str);
                            com.baidu.tieba.im.b.k.a().a(azVar5.a, azVar5.c, azVar5.b);
                            String str2 = azVar5.a;
                            int i4 = azVar5.c;
                            if (l.a(azVar5.b)) {
                                z = true;
                            }
                        }
                    }
                }
            } else {
                z = false;
            }
            com.baidu.tieba.im.pushNotify.a.d().b(z, new o(this));
            com.baidu.tieba.im.chat.x.b().a(groupMsgData);
        }
    }

    public n() {
        super(2013001);
    }
}
