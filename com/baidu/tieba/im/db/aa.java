package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.GroupMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    private static aa f1602a;
    private ag b;

    private aa() {
    }

    public static synchronized aa a() {
        aa aaVar;
        synchronized (aa.class) {
            if (f1602a == null) {
                f1602a = new aa();
            }
            aaVar = f1602a;
        }
        return aaVar;
    }

    public void b() {
        c();
    }

    private void c() {
        this.b = new ag(this, null);
        com.baidu.tieba.im.messageCenter.f.a().a(103112, this.b);
        com.baidu.tieba.im.messageCenter.f.a().a(103101, this.b);
    }

    public void a(String str, int i, GroupMsgPojo groupMsgPojo, com.baidu.tieba.im.a<Void> aVar) {
        x.a().a(new ab(this, groupMsgPojo, str, i, aVar));
    }

    public synchronized void a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!TextUtils.isEmpty(gid)) {
                x.a().a(new ac(this, gid, imMessageCenterPojo));
            }
        }
    }

    public synchronized void a(String str) {
        x.a().a(new ad(this, str));
    }

    public synchronized void b(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            x.a().a(new ae(this, imMessageCenterPojo));
        }
    }

    public void a(String str, com.baidu.tieba.im.a<Void> aVar) {
        if (!TextUtils.isEmpty(str)) {
            x.a().a(new af(this, str, aVar));
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
