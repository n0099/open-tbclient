package com.baidu.tieba.im.db;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {
    final /* synthetic */ ImMessageCenterPojo a;
    final /* synthetic */ ah b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ah ahVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.b = ahVar;
        this.a = imMessageCenterPojo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(this.a.getGid());
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
        }
        imMessageCenterPojo.setExt(this.a.getExt());
        imMessageCenterPojo.setGid(this.a.getGid());
        imMessageCenterPojo.setGroup_ext(this.a.getGroup_ext());
        imMessageCenterPojo.setGroup_head(this.a.getGroup_head());
        imMessageCenterPojo.setGroup_name(this.a.getGroup_name());
        imMessageCenterPojo.setGroup_type(this.a.getGroup_type());
        imMessageCenterPojo.setIs_delete(0);
        imMessageCenterPojo.setIs_hidden(0);
        imMessageCenterPojo.setType(this.a.getType());
        imMessageCenterPojo.setUnread_count(this.a.getUnread_count());
        concurrentHashMap.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
    }
}
