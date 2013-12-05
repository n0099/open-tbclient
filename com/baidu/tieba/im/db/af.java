package com.baidu.tieba.im.db;

import com.baidu.gson.Gson;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.im.db.pojo.GroupMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends SingleRunnable<LinkedList<ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ad f1655a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ad adVar) {
        this.f1655a = adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public LinkedList<ImMessageCenterPojo> b() {
        AtomicBoolean atomicBoolean;
        String str;
        atomicBoolean = this.f1655a.c;
        if (atomicBoolean.get()) {
            return null;
        }
        LinkedList<ImMessageCenterPojo> b = t.a().b();
        if (b != null) {
            Iterator<ImMessageCenterPojo> it = b.iterator();
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                next.setUnread_count(d.a().a(next.getGid()));
                next.setPulled_msgId(d.a().c(next.getGid()));
                GroupMsgPojo d = d.a().d(next.getGid());
                if (d != null) {
                    d.checkRidAndSelf();
                    String g = com.baidu.tieba.im.e.d.g(d.toChatMessage());
                    UserData userData = (UserData) new Gson().fromJson(d.getUser_info(), (Class<Object>) UserData.class);
                    if (userData == null) {
                        str = "";
                    } else {
                        str = userData.getUserName();
                    }
                    next.setLast_content(g);
                    next.setLast_user_name(str);
                    next.setLast_rid(d.getRid());
                    next.setLast_content_time(d.getCreate_time() * 1000);
                } else {
                    next.setLast_content("");
                    next.setPulled_msgId(0L);
                    next.setLast_rid(0L);
                    next.setLast_user_name("");
                    next.setLast_content_time(0L);
                }
            }
        }
        return b;
    }
}
