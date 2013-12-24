package com.baidu.tieba.im.b;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {
    final /* synthetic */ Map a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, Map map) {
        this.b = aVar;
        this.a = map;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            for (Map.Entry entry : this.a.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    String valueOf = String.valueOf(((Long) entry.getKey()).longValue());
                    if (concurrentHashMap.containsKey(valueOf) && concurrentHashMap.get(valueOf) != null) {
                        concurrentHashMap.get(valueOf).setPulled_msgId(((Long) entry.getValue()).longValue());
                    }
                }
            }
            this.b.k();
        }
    }
}
