package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.chat.ba;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class ag {
    private static ag a;
    private aq b;

    private ag() {
    }

    public static synchronized ag a() {
        ag agVar;
        synchronized (ag.class) {
            if (a == null) {
                a = new ag();
            }
            agVar = a;
        }
        return agVar;
    }

    public void b() {
        c();
    }

    private void c() {
        this.b = new aq(this, null);
        com.baidu.tieba.im.messageCenter.e.a().a(103112, this.b);
        com.baidu.tieba.im.messageCenter.e.a().a(103101, this.b);
    }

    public void a(String str, int i, CommonMsgPojo commonMsgPojo, com.baidu.tieba.im.a<Void> aVar) {
        ad.a().a(new ah(this, commonMsgPojo, str, i, aVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0083 A[Catch: all -> 0x0240, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x001f, B:7:0x0029, B:9:0x0033, B:12:0x0043, B:14:0x0083, B:16:0x0092, B:17:0x0097, B:19:0x010d, B:21:0x0144, B:26:0x016e, B:29:0x0181, B:31:0x0187, B:33:0x018d, B:36:0x0194, B:38:0x019a, B:40:0x01ac, B:43:0x01b5, B:46:0x01bc, B:48:0x01c6, B:51:0x01cd, B:53:0x01d7, B:56:0x01de, B:58:0x01e8, B:60:0x01ed, B:63:0x01f6, B:65:0x0200, B:92:0x02c8, B:94:0x02ce, B:95:0x02dc, B:85:0x02b2, B:87:0x02b8, B:89:0x02bd, B:73:0x0210, B:78:0x0243, B:80:0x0249, B:83:0x0256, B:84:0x0280), top: B:98:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0181 A[Catch: all -> 0x0240, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x001f, B:7:0x0029, B:9:0x0033, B:12:0x0043, B:14:0x0083, B:16:0x0092, B:17:0x0097, B:19:0x010d, B:21:0x0144, B:26:0x016e, B:29:0x0181, B:31:0x0187, B:33:0x018d, B:36:0x0194, B:38:0x019a, B:40:0x01ac, B:43:0x01b5, B:46:0x01bc, B:48:0x01c6, B:51:0x01cd, B:53:0x01d7, B:56:0x01de, B:58:0x01e8, B:60:0x01ed, B:63:0x01f6, B:65:0x0200, B:92:0x02c8, B:94:0x02ce, B:95:0x02dc, B:85:0x02b2, B:87:0x02b8, B:89:0x02bd, B:73:0x0210, B:78:0x0243, B:80:0x0249, B:83:0x0256, B:84:0x0280), top: B:98:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0243 A[Catch: all -> 0x0240, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x001f, B:7:0x0029, B:9:0x0033, B:12:0x0043, B:14:0x0083, B:16:0x0092, B:17:0x0097, B:19:0x010d, B:21:0x0144, B:26:0x016e, B:29:0x0181, B:31:0x0187, B:33:0x018d, B:36:0x0194, B:38:0x019a, B:40:0x01ac, B:43:0x01b5, B:46:0x01bc, B:48:0x01c6, B:51:0x01cd, B:53:0x01d7, B:56:0x01de, B:58:0x01e8, B:60:0x01ed, B:63:0x01f6, B:65:0x0200, B:92:0x02c8, B:94:0x02ce, B:95:0x02dc, B:85:0x02b2, B:87:0x02b8, B:89:0x02bd, B:73:0x0210, B:78:0x0243, B:80:0x0249, B:83:0x0256, B:84:0x0280), top: B:98:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean a(String str, int i, CommonMsgPojo commonMsgPojo, ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        boolean z;
        boolean z2;
        boolean b;
        String h = com.baidu.tieba.im.d.d.h(commonMsgPojo.toChatMessage());
        UserData userData = (UserData) new Gson().fromJson(commonMsgPojo.getUser_info(), (Class<Object>) UserData.class);
        String str2 = "";
        if (userData != null) {
            str2 = userData.getName();
            if (TiebaApplication.B()) {
                String A = TiebaApplication.A();
                if (!TextUtils.isEmpty(A) && A.equals(String.valueOf(userData.getId()))) {
                    z = true;
                    com.baidu.adp.lib.h.e.d("see gid:" + str + " content:" + h);
                    com.baidu.adp.lib.h.e.d("see pojo1:" + commonMsgPojo);
                    if (concurrentHashMap.get(str) == null) {
                        ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(str);
                        if (imMessageCenterPojo.getGroup_type() == 6) {
                            com.baidu.adp.lib.h.e.d("see private group found in mem");
                        }
                        long rid = commonMsgPojo.getRid();
                        long last_rid = concurrentHashMap.get(str).getLast_rid();
                        com.baidu.adp.lib.h.e.d("gid:" + str + "curLastMid:" + rid + "orginalLastMid:" + last_rid + " cur unRead:" + concurrentHashMap.get(str).getUnread_count() + " add unread:" + i + "content:" + commonMsgPojo + " readableContent:" + h);
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
                            com.baidu.adp.lib.h.e.d("curRid(" + rid + ") <= orginalLastRid(" + last_rid + "), 所以没有更新消息中心。消息： " + commonMsgPojo.getContent());
                        }
                    } else if (commonMsgPojo.isPrivate()) {
                        com.baidu.adp.lib.h.e.d("see add private chat");
                        ImMessageCenterPojo a2 = ad.a(commonMsgPojo);
                        if (a2 == null) {
                            z2 = false;
                        } else {
                            LinkedList<String> linkedList = new LinkedList<>();
                            linkedList.add(a2.getGid());
                            as.a().a(linkedList, (com.baidu.tieba.im.a<Void>) null);
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
                    if (commonMsgPojo != null) {
                        com.baidu.tieba.im.message.e chatMessage = commonMsgPojo.toChatMessage();
                        if (chatMessage != null) {
                            SystemMsgData i2 = com.baidu.tieba.im.d.d.i(chatMessage);
                            if (i2 != null && !i2.getIsSelf()) {
                                z2 = false;
                            }
                            if (TiebaApplication.B()) {
                                if (chatMessage.f().getId().equals(TiebaApplication.A()) && chatMessage.h() != 11) {
                                    z2 = false;
                                }
                            }
                        }
                        if (commonMsgPojo.getRead_flag() == 0) {
                            z2 = false;
                        }
                        if (!TiebaApplication.g().aa() && !commonMsgPojo.isPrivate()) {
                            z2 = false;
                        }
                        if (!TiebaApplication.g().Z() && commonMsgPojo.isPrivate()) {
                            z2 = false;
                        }
                        String gid = commonMsgPojo.getGid();
                        if (!TextUtils.isEmpty(gid) && GroupChatActivity.a && gid.equals(ba.c)) {
                            z2 = false;
                        } else if (!TextUtils.isEmpty(gid) && PersonalChatActivity.a && gid.equals(ba.d)) {
                            z2 = false;
                        }
                        com.baidu.tieba.im.c.k e = com.baidu.tieba.im.c.a.h().e(gid);
                        if (e != null) {
                            b = e.isAcceptNotify();
                        } else if (commonMsgPojo.isPrivate()) {
                            b = com.baidu.tieba.im.chat.personaltalk.a.b(TiebaApplication.A(), commonMsgPojo.getGid());
                        } else {
                            b = com.baidu.tieba.im.chat.personaltalk.a.b(TiebaApplication.A(), commonMsgPojo.getGid());
                        }
                        if (z2 && !b) {
                            z2 = false;
                        }
                    }
                }
            }
        }
        z = false;
        com.baidu.adp.lib.h.e.d("see gid:" + str + " content:" + h);
        com.baidu.adp.lib.h.e.d("see pojo1:" + commonMsgPojo);
        if (concurrentHashMap.get(str) == null) {
        }
        z2 = true;
        if (commonMsgPojo != null) {
        }
        return z2;
    }

    public void a(HashMap<String, com.baidu.tieba.im.chat.o> hashMap, com.baidu.tieba.im.a<Boolean> aVar) {
        ad.a().a(new aj(this, hashMap, aVar));
    }

    public synchronized void a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!TextUtils.isEmpty(gid)) {
                ad.a().a(new am(this, gid, imMessageCenterPojo));
            }
        }
    }

    public synchronized void a(String str) {
        ad.a().a(new an(this, str));
    }

    public synchronized void b(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            ad.a().a(new ao(this, imMessageCenterPojo));
        }
    }

    public void a(String str, com.baidu.tieba.im.a<Void> aVar) {
        if (!TextUtils.isEmpty(str)) {
            ad.a().a(new ap(this, str, aVar));
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
                if (imMessageCenterPojo2 != null) {
                    imMessageCenterPojo2.setIs_delete(1);
                }
            }
        }
    }
}
