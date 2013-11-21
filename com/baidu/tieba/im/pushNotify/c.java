package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class c implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f1762a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f1762a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo;
        if (concurrentHashMap != null && !TextUtils.isEmpty(this.f1762a.f1761a) && (imMessageCenterPojo = concurrentHashMap.get(this.f1762a.f1761a)) != null) {
            imMessageCenterPojo.setPulled_msgId(0L);
        }
    }
}
