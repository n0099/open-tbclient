package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.im.db.pojo.GroupMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends SingleRunnable<LinkedList<ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x f1633a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.f1633a = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public LinkedList<ImMessageCenterPojo> b() {
        AtomicBoolean atomicBoolean;
        String str;
        atomicBoolean = this.f1633a.c;
        if (atomicBoolean.get()) {
            return null;
        }
        LinkedList<ImMessageCenterPojo> b = n.a().b();
        if (b != null) {
            Iterator<ImMessageCenterPojo> it = b.iterator();
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                next.setUnread_count(a.a().a(next.getGid()));
                GroupMsgPojo c = a.a().c(next.getGid());
                if (c != null) {
                    String g = com.baidu.tieba.im.d.c.g(c.toChatMessage());
                    UserData userData = (UserData) new Gson().fromJson(c.getUser_info(), (Class<Object>) UserData.class);
                    if (userData == null) {
                        str = "";
                    } else {
                        str = userData.getUserName();
                    }
                    next.setLast_content(g);
                    next.setLast_msgId(c.getMid());
                    next.setPulled_msgId(c.getMid());
                    next.setLast_user_name(str);
                    next.setLast_content_time(c.getCreate_time() * 1000);
                } else {
                    next.setLast_content("");
                    next.setLast_msgId(0L);
                    next.setLast_user_name("");
                    next.setLast_content_time(0L);
                }
            }
        }
        return b;
    }
}
