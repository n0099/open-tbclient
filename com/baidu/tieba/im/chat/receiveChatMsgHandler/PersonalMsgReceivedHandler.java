package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.chat.aj;
import com.baidu.tieba.im.chat.q;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PersonalMsgReceivedHandler extends d {
    public PersonalMsgReceivedHandler() {
        super(6);
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.d
    protected void a(com.baidu.tieba.im.data.c cVar) {
        List<com.baidu.tieba.im.message.b> a;
        long j;
        LinkedList linkedList;
        int i;
        q.a(cVar.a().getGroupId());
        com.baidu.adp.lib.util.f.e("GET Personal Gid PULLMSG=" + cVar.a().getGroupId());
        String valueOf = String.valueOf(cVar.a().getGroupId());
        com.baidu.tieba.im.data.f b = cVar.b();
        HashMap<String, aj> hashMap = new HashMap<>();
        if (b != null && (a = b.a()) != null && a.size() > 0) {
            LinkedList linkedList2 = new LinkedList();
            int i2 = 0;
            long j2 = 0;
            int i3 = 0;
            int size = a.size();
            Iterator<com.baidu.tieba.im.message.b> it = a.iterator();
            while (true) {
                int i4 = i3;
                if (it.hasNext()) {
                    com.baidu.tieba.im.message.b next = it.next();
                    next.a(new MsgLocalData());
                    next.n().setStatus((short) 3);
                    if (next instanceof com.baidu.tieba.im.message.g) {
                        CommonMsgPojo commonMsgPojo = new CommonMsgPojo(next);
                        commonMsgPojo.setPrivate(true);
                        String uid = commonMsgPojo.getUid();
                        String toUid = commonMsgPojo.getToUid();
                        com.baidu.adp.lib.util.f.e("see content:" + commonMsgPojo);
                        com.baidu.adp.lib.util.f.e("see push private uidStr:" + uid + " toUidStr:" + toUid + " loginId:" + TiebaApplication.A());
                        if (TextUtils.isEmpty(uid)) {
                            com.baidu.adp.lib.util.f.e("see push private uidStr is null");
                            return;
                        } else if (toUid.equals(uid) && uid.equals(TiebaApplication.A())) {
                            com.baidu.adp.lib.util.f.e("see push private send msg to self");
                            return;
                        } else {
                            if (uid.equals(TiebaApplication.A())) {
                                com.baidu.adp.lib.util.f.e("see push private uid is loginid");
                            } else {
                                toUid = uid;
                            }
                            commonMsgPojo.setGid(toUid);
                            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(next);
                            long parseLong = Long.parseLong(toUid);
                            if (0 == j2) {
                                j = parseLong;
                                linkedList = linkedList2;
                            } else if (j2 == parseLong || i4 == size - 1) {
                                j = j2;
                                linkedList = linkedList2;
                            } else {
                                if (PersonalChatActivity.a && valueOf.equals(PersonalChatActivity.b)) {
                                    i2 = 0;
                                }
                                CommonMsgPojo commonMsgPojo3 = (CommonMsgPojo) linkedList2.getLast();
                                com.baidu.adp.lib.util.f.e("see content1:" + commonMsgPojo + "lastPojo:" + commonMsgPojo3);
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
                            LinkedList linkedList3 = new LinkedList();
                            linkedList3.add(commonMsgPojo2);
                            com.baidu.adp.lib.util.f.e(" private insert to db:" + commonMsgPojo2 + " unreadCount:" + i);
                            j.a(new e(this, parseLong2, parseLong3, linkedList3), null);
                            if (i4 == size - 1) {
                                if (PersonalChatActivity.a && valueOf.equals(PersonalChatActivity.b)) {
                                    i = 0;
                                }
                                CommonMsgPojo commonMsgPojo4 = (CommonMsgPojo) linkedList.getLast();
                                commonMsgPojo4.checkRidAndSelf();
                                String gid2 = commonMsgPojo4.getGid();
                                com.baidu.adp.lib.util.f.e("see content2:" + commonMsgPojo + "lastPojo:" + commonMsgPojo4);
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
                                i2 = 0;
                                j2 = parseLong3;
                            } else {
                                j2 = j;
                                i2 = i;
                            }
                            linkedList2 = linkedList;
                            i3 = i4 + 1;
                        }
                    } else {
                        return;
                    }
                } else {
                    com.baidu.tieba.im.c.j.a().a(l.a().a(hashMap));
                    q.b().a(cVar);
                    return;
                }
            }
        }
    }
}
