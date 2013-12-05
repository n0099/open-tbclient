package com.baidu.tieba.im.db;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class ai implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1658a;
    final /* synthetic */ ImMessageCenterPojo b;
    final /* synthetic */ ag c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar, String str, ImMessageCenterPojo imMessageCenterPojo) {
        this.c = agVar;
        this.f1658a = str;
        this.b = imMessageCenterPojo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(this.f1658a);
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(this.f1658a);
        }
        imMessageCenterPojo.setExt(this.b.getExt());
        imMessageCenterPojo.setGroup_ext(this.b.getGroup_ext());
        imMessageCenterPojo.setGroup_head(this.b.getGroup_head());
        imMessageCenterPojo.setGroup_name(this.b.getGroup_name());
        imMessageCenterPojo.setGroup_type(this.b.getGroup_type());
        imMessageCenterPojo.setIs_delete(this.b.getIs_delete());
        imMessageCenterPojo.setIs_hidden(this.b.getIs_hidden());
        imMessageCenterPojo.setLast_content_time(this.b.getLast_content_time());
        imMessageCenterPojo.setLast_content(this.b.getLast_content());
        imMessageCenterPojo.setLast_user_name(this.b.getLast_user_name());
        imMessageCenterPojo.setOrderCol(this.b.getOrderCol());
        imMessageCenterPojo.setType(this.b.getType());
        imMessageCenterPojo.setUnread_count(this.b.getUnread_count());
        if (this.b.getLast_rid() > imMessageCenterPojo.getLast_rid()) {
            imMessageCenterPojo.setLast_rid(this.b.getLast_rid());
        }
        long pulled_msgId = imMessageCenterPojo.getPulled_msgId();
        long pulled_msgId2 = this.b.getPulled_msgId();
        if (pulled_msgId <= pulled_msgId2) {
            imMessageCenterPojo.setPulled_msgId(pulled_msgId2);
            long last_rid = imMessageCenterPojo.getLast_rid();
            long last_rid2 = this.b.getLast_rid();
            if (last_rid <= last_rid2) {
                imMessageCenterPojo.setLast_rid(last_rid2);
                concurrentHashMap.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
            }
        }
    }
}
