package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.chat.aj;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class l {
    private static l a = new l();
    private o b;

    private l() {
    }

    public static l a() {
        return a;
    }

    public final void b() {
        this.b = new o(this, (byte) 0);
        com.baidu.tieba.im.messageCenter.d.a().a(103112, this.b);
        com.baidu.tieba.im.messageCenter.d.a().a(103101, this.b);
    }

    private synchronized boolean a(CommonMsgPojo commonMsgPojo) {
        boolean b;
        boolean z = false;
        synchronized (this) {
            if (commonMsgPojo != null) {
                boolean z2 = true;
                com.baidu.tieba.im.message.g chatMessage = commonMsgPojo.toChatMessage();
                if (chatMessage != null) {
                    SystemMsgData i = com.baidu.tieba.im.util.l.i(chatMessage);
                    if (i != null && !i.getIsSelf()) {
                        z2 = false;
                    }
                    if (TiebaApplication.w()) {
                        if (chatMessage.g().getUserId().equals(TiebaApplication.v()) && chatMessage.i() != 11) {
                            z2 = false;
                        }
                    }
                }
                if (commonMsgPojo.getRead_flag() == 0) {
                    z2 = false;
                }
                if (!TiebaApplication.g().S() && !commonMsgPojo.isPrivate()) {
                    z2 = false;
                }
                if (!TiebaApplication.g().R() && commonMsgPojo.isPrivate()) {
                    z2 = false;
                }
                String gid = commonMsgPojo.getGid();
                if (!TextUtils.isEmpty(gid) && GroupChatActivity.a && gid.equals(GroupChatActivity.b)) {
                    z2 = false;
                } else if (!TextUtils.isEmpty(gid) && PersonalChatActivity.a && gid.equals(PersonalChatActivity.b)) {
                    z2 = false;
                }
                com.baidu.tieba.im.c.i c = com.baidu.tieba.im.c.a.d().c(gid);
                if (c != null) {
                    b = c.isAcceptNotify();
                } else {
                    b = com.baidu.tieba.im.chat.personaltalk.a.b(TiebaApplication.v(), commonMsgPojo.getGid());
                }
                if (!z2 || b) {
                    z = z2;
                }
            }
        }
        return z;
    }

    public final boolean a(HashMap<String, aj> hashMap) {
        boolean z = false;
        for (String str : hashMap.keySet()) {
            aj ajVar = hashMap.get(str);
            h.a().a(ajVar.a, ajVar.c, ajVar.b);
            String str2 = ajVar.a;
            int i = ajVar.c;
            if (a(ajVar.b)) {
                z = true;
            }
        }
        return z;
    }

    public final synchronized void a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!TextUtils.isEmpty(gid)) {
                d d = h.a().d();
                ImMessageCenterPojo a2 = d.a(gid);
                if (a2 == null) {
                    a2 = new ImMessageCenterPojo();
                    a2.setGid(gid);
                }
                a2.setExt(imMessageCenterPojo.getExt());
                a2.setGroup_ext(imMessageCenterPojo.getGroup_ext());
                a2.setGroup_head(imMessageCenterPojo.getGroup_head());
                a2.setGroup_name(imMessageCenterPojo.getGroup_name());
                a2.setGroup_type(imMessageCenterPojo.getGroup_type());
                a2.setIs_delete(imMessageCenterPojo.getIs_delete());
                a2.setIs_hidden(imMessageCenterPojo.getIs_hidden());
                a2.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                a2.setLast_content(imMessageCenterPojo.getLast_content());
                a2.setLast_user_name(imMessageCenterPojo.getLast_user_name());
                a2.setOrderCol(imMessageCenterPojo.getOrderCol());
                a2.setType(imMessageCenterPojo.getType());
                a2.setUnread_count(imMessageCenterPojo.getUnread_count());
                if (imMessageCenterPojo.getLast_rid() > a2.getLast_rid()) {
                    a2.setLast_rid(imMessageCenterPojo.getLast_rid());
                }
                long pulled_msgId = a2.getPulled_msgId();
                long pulled_msgId2 = imMessageCenterPojo.getPulled_msgId();
                if (pulled_msgId <= pulled_msgId2) {
                    a2.setPulled_msgId(pulled_msgId2);
                    long last_rid = a2.getLast_rid();
                    long last_rid2 = imMessageCenterPojo.getLast_rid();
                    if (last_rid <= last_rid2) {
                        a2.setLast_rid(last_rid2);
                        d.a(a2);
                    }
                }
            }
        }
    }

    public final synchronized void a(String str) {
        ImMessageCenterPojo a2 = h.a().d().a(str);
        if (a2 != null) {
            a2.setLast_rid(0L);
            a2.setPulled_msgId(0L);
            a2.setIs_delete(1);
        } else {
            com.baidu.adp.lib.util.e.b("删除gid失败");
        }
    }

    public final synchronized void b(String str) {
        h.a().d().b(str);
    }

    public final synchronized void b(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            d d = h.a().d();
            ImMessageCenterPojo a2 = d.a(imMessageCenterPojo.getGid());
            if (a2 == null) {
                a2 = new ImMessageCenterPojo();
            }
            a2.setExt(imMessageCenterPojo.getExt());
            a2.setGid(imMessageCenterPojo.getGid());
            a2.setGroup_ext(imMessageCenterPojo.getGroup_ext());
            a2.setGroup_head(imMessageCenterPojo.getGroup_head());
            a2.setGroup_name(imMessageCenterPojo.getGroup_name());
            a2.setGroup_type(imMessageCenterPojo.getGroup_type());
            a2.setIs_delete(0);
            a2.setIs_hidden(0);
            a2.setType(imMessageCenterPojo.getType());
            a2.setUnread_count(imMessageCenterPojo.getUnread_count());
            d.a(a2);
        }
    }

    public static void c(String str) {
        d d;
        ImMessageCenterPojo a2;
        if (!TextUtils.isEmpty(str) && (d = h.a().d()) != null && (a2 = d.a(str)) != null) {
            a2.setUnread_count(0);
        }
    }

    public final void a(d dVar, LinkedList<ImMessageCenterPojo> linkedList) {
        if (dVar != null && linkedList != null) {
            HashSet hashSet = new HashSet();
            dVar.a(new m(this, hashSet));
            Iterator<ImMessageCenterPojo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                hashSet.remove(next.getGid());
                ImMessageCenterPojo a2 = dVar.a(next.getGid());
                if (a2 != null) {
                    a2.setExt(next.getExt());
                    a2.setGroup_ext(next.getGroup_ext());
                    a2.setGroup_head(next.getGroup_head());
                    a2.setGroup_name(next.getGroup_name());
                    a2.setGroup_type(next.getGroup_type());
                    a2.setIs_delete(next.getIs_delete());
                    a2.setIs_hidden(next.getIs_hidden());
                    a2.setOrderCol(next.getOrderCol());
                    if (a2.getPulled_msgId() == 0) {
                        a2.setPulled_msgId(next.getPulled_msgId());
                    }
                } else {
                    dVar.a(next);
                }
            }
            com.baidu.tieba.im.i.a(new n(this, linkedList), null);
        }
    }
}
