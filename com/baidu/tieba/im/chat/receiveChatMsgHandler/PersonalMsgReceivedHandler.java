package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.c.j;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.chat.aj;
import com.baidu.tieba.im.chat.q;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.i;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PersonalMsgReceivedHandler extends d {
    public PersonalMsgReceivedHandler() {
        super(6);
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.d
    protected final void a(com.baidu.tieba.im.data.c cVar) {
        List<com.baidu.tieba.im.message.b> a;
        LinkedList linkedList;
        long j;
        int i;
        q.a(cVar.a().getGroupId());
        com.baidu.adp.lib.util.e.e("GET Personal Gid PULLMSG=" + cVar.a().getGroupId());
        String valueOf = String.valueOf(cVar.a().getGroupId());
        com.baidu.tieba.im.data.f b = cVar.b();
        HashMap<String, aj> hashMap = new HashMap<>();
        if (b != null && (a = b.a()) != null && a.size() > 0) {
            LinkedList linkedList2 = new LinkedList();
            int i2 = 0;
            long j2 = 0;
            int size = a.size();
            int i3 = 0;
            for (com.baidu.tieba.im.message.b bVar : a) {
                bVar.a(new MsgLocalData());
                bVar.n().setStatus((short) 3);
                if (bVar instanceof com.baidu.tieba.im.message.g) {
                    CommonMsgPojo commonMsgPojo = new CommonMsgPojo(bVar);
                    commonMsgPojo.setPrivate(true);
                    String uid = commonMsgPojo.getUid();
                    String toUid = commonMsgPojo.getToUid();
                    com.baidu.adp.lib.util.e.e("see content:" + commonMsgPojo);
                    com.baidu.adp.lib.util.e.e("see push private uidStr:" + uid + " toUidStr:" + toUid + " loginId:" + TiebaApplication.v());
                    if (TextUtils.isEmpty(uid)) {
                        com.baidu.adp.lib.util.e.e("see push private uidStr is null");
                        return;
                    } else if (toUid.equals(uid) && uid.equals(TiebaApplication.v())) {
                        com.baidu.adp.lib.util.e.e("see push private send msg to self");
                        return;
                    } else {
                        if (uid.equals(TiebaApplication.v())) {
                            com.baidu.adp.lib.util.e.e("see push private uid is loginid");
                        } else {
                            toUid = uid;
                        }
                        commonMsgPojo.setGid(toUid);
                        CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(bVar);
                        long parseLong = Long.parseLong(toUid);
                        if (0 == j2) {
                            linkedList = linkedList2;
                            j = parseLong;
                        } else if (j2 == parseLong || i3 == size - 1) {
                            linkedList = linkedList2;
                            j = j2;
                        } else {
                            if (PersonalChatActivity.a && valueOf.equals(PersonalChatActivity.b)) {
                                i2 = 0;
                            }
                            CommonMsgPojo commonMsgPojo3 = (CommonMsgPojo) linkedList2.getLast();
                            com.baidu.adp.lib.util.e.e("see content1:" + commonMsgPojo + "lastPojo:" + commonMsgPojo3);
                            commonMsgPojo3.checkRidAndSelf();
                            String gid = commonMsgPojo3.getGid();
                            if (hashMap.get(gid) != null) {
                                aj ajVar = hashMap.get(gid);
                                ajVar.b = commonMsgPojo3;
                                ajVar.c += i2;
                            } else {
                                aj ajVar2 = new aj();
                                ajVar2.a = gid;
                                ajVar2.b = commonMsgPojo3;
                                ajVar2.c = i2;
                                hashMap.put(ajVar2.a, ajVar2);
                            }
                            i2 = 0;
                            j = parseLong;
                            linkedList = new LinkedList();
                        }
                        a.a(valueOf, bVar);
                        if (a.a(bVar)) {
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
                        linkedList3.add(commonMsgPojo2);
                        com.baidu.adp.lib.util.e.e(" private insert to db:" + commonMsgPojo2 + " unreadCount:" + i);
                        i.a(new e(this, parseLong2, parseLong3, linkedList3), null);
                        if (i3 == size - 1) {
                            if (PersonalChatActivity.a && valueOf.equals(PersonalChatActivity.b)) {
                                i = 0;
                            }
                            CommonMsgPojo commonMsgPojo4 = (CommonMsgPojo) linkedList.getLast();
                            commonMsgPojo4.checkRidAndSelf();
                            String gid2 = commonMsgPojo4.getGid();
                            com.baidu.adp.lib.util.e.e("see content2:" + commonMsgPojo + "lastPojo:" + commonMsgPojo4);
                            if (hashMap.get(gid2) != null) {
                                aj ajVar3 = hashMap.get(gid2);
                                ajVar3.b = commonMsgPojo4;
                                ajVar3.c += i;
                            } else {
                                aj ajVar4 = new aj();
                                ajVar4.a = gid2;
                                ajVar4.b = commonMsgPojo4;
                                ajVar4.c = i;
                                hashMap.put(ajVar4.a, ajVar4);
                            }
                            linkedList = new LinkedList();
                            i = 0;
                        } else {
                            parseLong3 = j;
                        }
                        j2 = parseLong3;
                        i3++;
                        i2 = i;
                        linkedList2 = linkedList;
                    }
                } else {
                    return;
                }
            }
            j.a().a(l.a().a(hashMap));
            q.b().a(cVar);
        }
    }
}
