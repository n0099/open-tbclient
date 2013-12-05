package com.baidu.tieba.im.db;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class ak implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImMessageCenterPojo f1660a;
    final /* synthetic */ ag b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.b = agVar;
        this.f1660a = imMessageCenterPojo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(this.f1660a.getGid());
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
        }
        imMessageCenterPojo.setExt(this.f1660a.getExt());
        imMessageCenterPojo.setGid(this.f1660a.getGid());
        imMessageCenterPojo.setGroup_ext(this.f1660a.getGroup_ext());
        imMessageCenterPojo.setGroup_head(this.f1660a.getGroup_head());
        imMessageCenterPojo.setGroup_name(this.f1660a.getGroup_name());
        imMessageCenterPojo.setGroup_type(this.f1660a.getGroup_type());
        imMessageCenterPojo.setIs_delete(0);
        imMessageCenterPojo.setIs_hidden(0);
        imMessageCenterPojo.setType(this.f1660a.getType());
        imMessageCenterPojo.setUnread_count(this.f1660a.getUnread_count());
        concurrentHashMap.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
    }
}
