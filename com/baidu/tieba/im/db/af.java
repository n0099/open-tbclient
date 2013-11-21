package com.baidu.tieba.im.db;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1598a;
    final /* synthetic */ com.baidu.tieba.im.a b;
    final /* synthetic */ aa c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(aa aaVar, String str, com.baidu.tieba.im.a aVar) {
        this.c = aaVar;
        this.f1598a = str;
        this.b = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo;
        if (concurrentHashMap != null && (imMessageCenterPojo = concurrentHashMap.get(this.f1598a)) != null) {
            imMessageCenterPojo.setUnread_count(0);
        }
        if (this.b != null) {
            this.b.a(null);
        }
    }
}
