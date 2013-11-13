package com.baidu.tieba.im.db;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class ad implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1605a;
    final /* synthetic */ aa b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(aa aaVar, String str) {
        this.b = aaVar;
        this.f1605a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(this.f1605a);
        if (imMessageCenterPojo != null) {
            imMessageCenterPojo.setLast_msgId(0L);
            imMessageCenterPojo.setPulled_msgId(0L);
            imMessageCenterPojo.setIs_delete(1);
            return;
        }
        com.baidu.adp.lib.h.d.a("删除gid失败");
    }
}
