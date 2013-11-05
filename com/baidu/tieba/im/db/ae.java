package com.baidu.tieba.im.db;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImMessageCenterPojo f1515a;
    final /* synthetic */ aa b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(aa aaVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.b = aaVar;
        this.f1515a = imMessageCenterPojo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(this.f1515a.getGid());
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
        }
        imMessageCenterPojo.setExt(this.f1515a.getExt());
        imMessageCenterPojo.setGid(this.f1515a.getGid());
        imMessageCenterPojo.setGroup_ext(this.f1515a.getGroup_ext());
        imMessageCenterPojo.setGroup_head(this.f1515a.getGroup_head());
        imMessageCenterPojo.setGroup_name(this.f1515a.getGroup_name());
        imMessageCenterPojo.setGroup_type(this.f1515a.getGroup_type());
        imMessageCenterPojo.setIs_delete(0);
        imMessageCenterPojo.setIs_hidden(0);
        imMessageCenterPojo.setType(this.f1515a.getType());
        imMessageCenterPojo.setUnread_count(this.f1515a.getUnread_count());
        concurrentHashMap.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
    }
}
