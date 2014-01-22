package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class ah {
    private static ah a;
    private as b;

    private ah() {
    }

    public static synchronized ah a() {
        ah ahVar;
        synchronized (ah.class) {
            if (a == null) {
                a = new ah();
            }
            ahVar = a;
        }
        return ahVar;
    }

    public void b() {
        c();
    }

    private void c() {
        this.b = new as(this, null);
        com.baidu.tieba.im.messageCenter.e.a().a(103112, this.b);
        com.baidu.tieba.im.messageCenter.e.a().a(103101, this.b);
    }

    public void a(String str, int i, CommonMsgPojo commonMsgPojo, com.baidu.tieba.im.a<Void> aVar) {
        ae.a().a(new ai(this, commonMsgPojo, str, i, aVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0088 A[Catch: all -> 0x0243, TryCatch #0 {, blocks: (B:7:0x0006, B:9:0x0024, B:11:0x002e, B:13:0x0038, B:16:0x0048, B:18:0x0088, B:20:0x0097, B:21:0x009c, B:23:0x0112, B:25:0x0149, B:30:0x0173, B:31:0x0183, B:33:0x018a, B:35:0x0190, B:38:0x0197, B:40:0x019d, B:42:0x01af, B:45:0x01b8, B:48:0x01bf, B:50:0x01c9, B:53:0x01d0, B:55:0x01da, B:58:0x01e1, B:60:0x01eb, B:62:0x01f0, B:65:0x01f9, B:67:0x0203, B:92:0x02cc, B:85:0x02b6, B:87:0x02bc, B:89:0x02c1, B:73:0x0213, B:78:0x0246, B:80:0x024c, B:83:0x025a, B:84:0x0284), top: B:95:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x018a A[Catch: all -> 0x0243, TryCatch #0 {, blocks: (B:7:0x0006, B:9:0x0024, B:11:0x002e, B:13:0x0038, B:16:0x0048, B:18:0x0088, B:20:0x0097, B:21:0x009c, B:23:0x0112, B:25:0x0149, B:30:0x0173, B:31:0x0183, B:33:0x018a, B:35:0x0190, B:38:0x0197, B:40:0x019d, B:42:0x01af, B:45:0x01b8, B:48:0x01bf, B:50:0x01c9, B:53:0x01d0, B:55:0x01da, B:58:0x01e1, B:60:0x01eb, B:62:0x01f0, B:65:0x01f9, B:67:0x0203, B:92:0x02cc, B:85:0x02b6, B:87:0x02bc, B:89:0x02c1, B:73:0x0213, B:78:0x0246, B:80:0x024c, B:83:0x025a, B:84:0x0284), top: B:95:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0203 A[Catch: all -> 0x0243, TryCatch #0 {, blocks: (B:7:0x0006, B:9:0x0024, B:11:0x002e, B:13:0x0038, B:16:0x0048, B:18:0x0088, B:20:0x0097, B:21:0x009c, B:23:0x0112, B:25:0x0149, B:30:0x0173, B:31:0x0183, B:33:0x018a, B:35:0x0190, B:38:0x0197, B:40:0x019d, B:42:0x01af, B:45:0x01b8, B:48:0x01bf, B:50:0x01c9, B:53:0x01d0, B:55:0x01da, B:58:0x01e1, B:60:0x01eb, B:62:0x01f0, B:65:0x01f9, B:67:0x0203, B:92:0x02cc, B:85:0x02b6, B:87:0x02bc, B:89:0x02c1, B:73:0x0213, B:78:0x0246, B:80:0x024c, B:83:0x025a, B:84:0x0284), top: B:95:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0246 A[Catch: all -> 0x0243, TRY_ENTER, TryCatch #0 {, blocks: (B:7:0x0006, B:9:0x0024, B:11:0x002e, B:13:0x0038, B:16:0x0048, B:18:0x0088, B:20:0x0097, B:21:0x009c, B:23:0x0112, B:25:0x0149, B:30:0x0173, B:31:0x0183, B:33:0x018a, B:35:0x0190, B:38:0x0197, B:40:0x019d, B:42:0x01af, B:45:0x01b8, B:48:0x01bf, B:50:0x01c9, B:53:0x01d0, B:55:0x01da, B:58:0x01e1, B:60:0x01eb, B:62:0x01f0, B:65:0x01f9, B:67:0x0203, B:92:0x02cc, B:85:0x02b6, B:87:0x02bc, B:89:0x02c1, B:73:0x0213, B:78:0x0246, B:80:0x024c, B:83:0x025a, B:84:0x0284), top: B:95:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02cc A[Catch: all -> 0x0243, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x0006, B:9:0x0024, B:11:0x002e, B:13:0x0038, B:16:0x0048, B:18:0x0088, B:20:0x0097, B:21:0x009c, B:23:0x0112, B:25:0x0149, B:30:0x0173, B:31:0x0183, B:33:0x018a, B:35:0x0190, B:38:0x0197, B:40:0x019d, B:42:0x01af, B:45:0x01b8, B:48:0x01bf, B:50:0x01c9, B:53:0x01d0, B:55:0x01da, B:58:0x01e1, B:60:0x01eb, B:62:0x01f0, B:65:0x01f9, B:67:0x0203, B:92:0x02cc, B:85:0x02b6, B:87:0x02bc, B:89:0x02c1, B:73:0x0213, B:78:0x0246, B:80:0x024c, B:83:0x025a, B:84:0x0284), top: B:95:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean a(String str, int i, CommonMsgPojo commonMsgPojo, ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        boolean z;
        boolean z2;
        com.baidu.tieba.im.message.g chatMessage;
        String gid;
        com.baidu.tieba.im.c.k e;
        boolean b;
        if (commonMsgPojo == null) {
            z2 = false;
        } else {
            String h = com.baidu.tieba.im.d.d.h(commonMsgPojo.toChatMessage());
            UserData userData = (UserData) new Gson().fromJson(commonMsgPojo.getUser_info(), (Class<Object>) UserData.class);
            String str2 = "";
            if (userData != null) {
                str2 = userData.getName();
                if (TiebaApplication.B()) {
                    String A = TiebaApplication.A();
                    if (!TextUtils.isEmpty(A) && A.equals(String.valueOf(userData.getId()))) {
                        z = true;
                        com.baidu.adp.lib.g.e.d("see gid:" + str + " content:" + h);
                        com.baidu.adp.lib.g.e.d("see pojo1:" + commonMsgPojo);
                        if (concurrentHashMap.get(str) == null) {
                            ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(str);
                            if (imMessageCenterPojo.getGroup_type() == 6) {
                                com.baidu.adp.lib.g.e.d("see private group found in mem");
                            }
                            long rid = commonMsgPojo.getRid();
                            long last_rid = concurrentHashMap.get(str).getLast_rid();
                            com.baidu.adp.lib.g.e.d("gid:" + str + "curLastMid:" + rid + "orginalLastMid:" + last_rid + " cur unRead:" + concurrentHashMap.get(str).getUnread_count() + " add unread:" + i + "content:" + commonMsgPojo + " readableContent:" + h);
                            if (rid > last_rid) {
                                concurrentHashMap.get(str).setLast_rid(rid);
                                concurrentHashMap.get(str).setLast_content(h);
                                concurrentHashMap.get(str).setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
                                concurrentHashMap.get(str).setLast_user_name(str2);
                                if (last_rid < rid) {
                                    concurrentHashMap.get(str).setLast_rid(rid);
                                    concurrentHashMap.get(str).setUnread_count(concurrentHashMap.get(str).getUnread_count() + i);
                                }
                                boolean z3 = false;
                                if (i > 0) {
                                    z3 = true;
                                } else if (z) {
                                    z3 = true;
                                }
                                if (z3) {
                                    t.a().a(t.b(str), false);
                                    imMessageCenterPojo.setIs_hidden(0);
                                }
                            } else {
                                com.baidu.adp.lib.g.e.d("curRid(" + rid + ") <= orginalLastRid(" + last_rid + "), 所以没有更新消息中心。消息： " + commonMsgPojo.getContent());
                            }
                        } else if (commonMsgPojo.isPrivate()) {
                            com.baidu.adp.lib.g.e.d("see add private chat");
                            ImMessageCenterPojo a2 = ae.a(commonMsgPojo);
                            if (a2 == null) {
                                z2 = false;
                            } else {
                                LinkedList<String> linkedList = new LinkedList<>();
                                linkedList.add(a2.getGid());
                                au.a().a(linkedList, (com.baidu.tieba.im.a<Void>) null);
                                new LinkedList().add(commonMsgPojo);
                                a2.setUnread_count(i);
                                concurrentHashMap.put(str, a2);
                            }
                        } else {
                            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                            imMessageCenterPojo2.setGid(str);
                            imMessageCenterPojo2.setLast_content(h);
                            imMessageCenterPojo2.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
                            imMessageCenterPojo2.setLast_user_name(str2);
                            imMessageCenterPojo2.setLast_rid(commonMsgPojo.getMid());
                            imMessageCenterPojo2.setPulled_msgId(commonMsgPojo.getMid());
                            imMessageCenterPojo2.setUnread_count(i);
                            concurrentHashMap.put(str, imMessageCenterPojo2);
                        }
                        z2 = true;
                        chatMessage = commonMsgPojo.toChatMessage();
                        if (chatMessage != null) {
                            SystemMsgData i2 = com.baidu.tieba.im.d.d.i(chatMessage);
                            if (i2 != null && !i2.getIsSelf()) {
                                z2 = false;
                            }
                            if (TiebaApplication.B()) {
                                if (chatMessage.g().getId().equals(TiebaApplication.A()) && chatMessage.i() != 11) {
                                    z2 = false;
                                }
                            }
                        }
                        if (commonMsgPojo.getRead_flag() == 0) {
                            z2 = false;
                        }
                        if (!TiebaApplication.h().Z() && !commonMsgPojo.isPrivate()) {
                            z2 = false;
                        }
                        if (!TiebaApplication.h().Y() && commonMsgPojo.isPrivate()) {
                            z2 = false;
                        }
                        gid = commonMsgPojo.getGid();
                        if (TextUtils.isEmpty(gid) && GroupChatActivity.a && gid.equals(GroupChatActivity.b)) {
                            z2 = false;
                        } else if (!TextUtils.isEmpty(gid) && PersonalChatActivity.a && gid.equals(PersonalChatActivity.b)) {
                            z2 = false;
                        }
                        e = com.baidu.tieba.im.c.a.h().e(gid);
                        if (e == null) {
                            b = e.isAcceptNotify();
                        } else {
                            b = com.baidu.tieba.im.chat.personaltalk.a.b(TiebaApplication.A(), commonMsgPojo.getGid());
                        }
                        if (z2 && !b) {
                            z2 = false;
                        }
                    }
                }
            }
            z = false;
            com.baidu.adp.lib.g.e.d("see gid:" + str + " content:" + h);
            com.baidu.adp.lib.g.e.d("see pojo1:" + commonMsgPojo);
            if (concurrentHashMap.get(str) == null) {
            }
            z2 = true;
            chatMessage = commonMsgPojo.toChatMessage();
            if (chatMessage != null) {
            }
            if (commonMsgPojo.getRead_flag() == 0) {
            }
            if (!TiebaApplication.h().Z()) {
                z2 = false;
            }
            if (!TiebaApplication.h().Y()) {
                z2 = false;
            }
            gid = commonMsgPojo.getGid();
            if (TextUtils.isEmpty(gid)) {
            }
            if (!TextUtils.isEmpty(gid)) {
                z2 = false;
            }
            e = com.baidu.tieba.im.c.a.h().e(gid);
            if (e == null) {
            }
            if (z2) {
                z2 = false;
            }
        }
        return z2;
    }

    public void a(HashMap<String, com.baidu.tieba.im.chat.ae> hashMap, com.baidu.tieba.im.a<Boolean> aVar) {
        ae.a().a(new ak(this, hashMap, aVar));
    }

    public synchronized void a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!TextUtils.isEmpty(gid)) {
                ae.a().a(new an(this, gid, imMessageCenterPojo));
            }
        }
    }

    public synchronized void a(String str) {
        ae.a().a(new ao(this, str));
    }

    public synchronized void b(String str) {
        ae.a().a(new ap(this, str));
    }

    public synchronized void b(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            ae.a().a(new aq(this, imMessageCenterPojo));
        }
    }

    public void a(String str, com.baidu.tieba.im.a<Void> aVar) {
        if (!TextUtils.isEmpty(str)) {
            ae.a().a(new ar(this, str, aVar));
        }
    }

    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap, LinkedList<ImMessageCenterPojo> linkedList) {
        if (concurrentHashMap != null && linkedList != null) {
            HashSet<String> hashSet = new HashSet();
            for (String str : concurrentHashMap.keySet()) {
                hashSet.add(str);
            }
            Iterator<ImMessageCenterPojo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                hashSet.remove(next.getGid());
                if (concurrentHashMap.containsKey(next.getGid())) {
                    ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(next.getGid());
                    imMessageCenterPojo.setExt(next.getExt());
                    imMessageCenterPojo.setGroup_ext(next.getGroup_ext());
                    imMessageCenterPojo.setGroup_head(next.getGroup_head());
                    imMessageCenterPojo.setGroup_name(next.getGroup_name());
                    imMessageCenterPojo.setGroup_type(next.getGroup_type());
                    imMessageCenterPojo.setIs_delete(next.getIs_delete());
                    imMessageCenterPojo.setIs_hidden(next.getIs_hidden());
                    imMessageCenterPojo.setOrderCol(next.getOrderCol());
                    if (imMessageCenterPojo.getPulled_msgId() == 0) {
                        imMessageCenterPojo.setPulled_msgId(next.getPulled_msgId());
                    }
                } else {
                    concurrentHashMap.put(next.getGid(), next);
                }
            }
            for (String str2 : hashSet) {
                ImMessageCenterPojo imMessageCenterPojo2 = concurrentHashMap.get(str2);
                if (imMessageCenterPojo2 != null && imMessageCenterPojo2.getGroup_type() != 7) {
                    imMessageCenterPojo2.setIs_delete(1);
                }
            }
        }
    }
}
