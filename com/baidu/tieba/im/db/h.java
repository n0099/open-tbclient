package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.s;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class h {
    private static h a = new h();
    private com.baidu.adp.framework.c.g b = new i(this, 0);

    private h() {
    }

    public static h a() {
        return a;
    }

    public final void b() {
        com.baidu.adp.framework.c.a().a(103112, this.b);
        com.baidu.adp.framework.c.a().a(103101, this.b);
    }

    public final synchronized void a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!TextUtils.isEmpty(gid)) {
                ImMessageCenterPojo a2 = com.baidu.tieba.im.b.a.a().a(gid);
                if (a2 == null) {
                    a2 = new ImMessageCenterPojo();
                    a2.setGid(gid);
                }
                a2.setExt(imMessageCenterPojo.getExt());
                a2.setGroup_ext(imMessageCenterPojo.getGroup_ext());
                a2.setGroup_head(imMessageCenterPojo.getGroup_head());
                a2.setGroup_name(imMessageCenterPojo.getGroup_name());
                a2.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
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
                        com.baidu.tbadk.coreExtra.messageCenter.d.a().a(com.baidu.adp.lib.f.b.a(a2.getGid(), 0), a2.getPulled_msgId() / 100);
                        com.baidu.tieba.im.b.a.a().a(a2);
                    }
                }
            }
        }
    }

    public final synchronized void a(String str) {
        ImMessageCenterPojo a2 = com.baidu.tieba.im.b.e.a(str);
        if (a2 != null) {
            a2.setLast_rid(0L);
            a2.setPulled_msgId(0L);
            a2.setIs_delete(1);
        } else {
            com.baidu.adp.lib.util.f.b("删除gid失败");
        }
    }

    public final synchronized void b(String str) {
        com.baidu.tbadk.coreExtra.messageCenter.d.a().a(com.baidu.adp.lib.f.b.a(str, 0));
        com.baidu.tieba.im.b.a.a().b(str);
    }

    public final synchronized void b(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            ImMessageCenterPojo a2 = com.baidu.tieba.im.b.a.a().a(imMessageCenterPojo.getGid());
            if (a2 == null) {
                a2 = new ImMessageCenterPojo();
            }
            a2.setExt(imMessageCenterPojo.getExt());
            a2.setGid(imMessageCenterPojo.getGid());
            a2.setGroup_ext(imMessageCenterPojo.getGroup_ext());
            a2.setGroup_head(imMessageCenterPojo.getGroup_head());
            a2.setGroup_name(imMessageCenterPojo.getGroup_name());
            a2.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
            a2.setIs_delete(0);
            a2.setIs_hidden(0);
            a2.setType(imMessageCenterPojo.getType());
            a2.setUnread_count(imMessageCenterPojo.getUnread_count());
            com.baidu.tieba.im.b.a.a().a(a2);
        }
    }

    public static void c(String str) {
        ImMessageCenterPojo a2;
        if (!TextUtils.isEmpty(str) && (a2 = com.baidu.tieba.im.b.e.a(str)) != null) {
            a2.setUnread_count(0);
        }
    }

    public final void a(LinkedList<ImMessageCenterPojo> linkedList) {
        if (linkedList != null) {
            HashSet hashSet = new HashSet();
            com.baidu.tieba.im.b.e.a(new k(this, hashSet));
            Iterator<ImMessageCenterPojo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                hashSet.remove(next.getGid());
                ImMessageCenterPojo a2 = com.baidu.tieba.im.b.a.a().a(next.getGid());
                if (a2 != null) {
                    a2.setExt(next.getExt());
                    a2.setGroup_ext(next.getGroup_ext());
                    a2.setGroup_head(next.getGroup_head());
                    a2.setGroup_name(next.getGroup_name());
                    a2.setCustomGroupType(next.getCustomGroupType());
                    a2.setIs_delete(next.getIs_delete());
                    a2.setIs_hidden(next.getIs_hidden());
                    a2.setOrderCol(next.getOrderCol());
                    if (a2.getPulled_msgId() == 0) {
                        a2.setPulled_msgId(next.getPulled_msgId());
                    }
                } else {
                    com.baidu.tieba.im.b.a.a().a(next);
                }
            }
            s.a(new l(this, linkedList), null);
        }
    }
}
