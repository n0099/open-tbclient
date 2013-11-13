package com.baidu.tieba.im.db;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class ac implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1604a;
    final /* synthetic */ ImMessageCenterPojo b;
    final /* synthetic */ aa c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar, String str, ImMessageCenterPojo imMessageCenterPojo) {
        this.c = aaVar;
        this.f1604a = str;
        this.b = imMessageCenterPojo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(this.f1604a);
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(this.f1604a);
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
        long last_msgId = imMessageCenterPojo.getLast_msgId();
        long last_msgId2 = this.b.getLast_msgId();
        if (last_msgId <= last_msgId2) {
            imMessageCenterPojo.setLast_msgId(last_msgId2);
            imMessageCenterPojo.setPulled_msgId(last_msgId2);
            concurrentHashMap.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }
}
