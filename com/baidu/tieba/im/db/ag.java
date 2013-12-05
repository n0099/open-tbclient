package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.GroupMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class ag {

    /* renamed from: a  reason: collision with root package name */
    private static ag f1656a;
    private am b;

    private ag() {
    }

    public static synchronized ag a() {
        ag agVar;
        synchronized (ag.class) {
            if (f1656a == null) {
                f1656a = new ag();
            }
            agVar = f1656a;
        }
        return agVar;
    }

    public void b() {
        c();
    }

    private void c() {
        this.b = new am(this, null);
        com.baidu.tieba.im.messageCenter.e.a().a(103112, this.b);
        com.baidu.tieba.im.messageCenter.e.a().a(103101, this.b);
    }

    public void a(String str, int i, GroupMsgPojo groupMsgPojo, com.baidu.tieba.im.a<Void> aVar) {
        ad.a().a(new ah(this, groupMsgPojo, str, i, aVar));
    }

    public synchronized void a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!TextUtils.isEmpty(gid)) {
                ad.a().a(new ai(this, gid, imMessageCenterPojo));
            }
        }
    }

    public synchronized void a(String str) {
        ad.a().a(new aj(this, str));
    }

    public synchronized void b(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            ad.a().a(new ak(this, imMessageCenterPojo));
        }
    }

    public void a(String str, com.baidu.tieba.im.a<Void> aVar) {
        if (!TextUtils.isEmpty(str)) {
            ad.a().a(new al(this, str, aVar));
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
