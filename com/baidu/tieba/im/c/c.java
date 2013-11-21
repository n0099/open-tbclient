package com.baidu.tieba.im.c;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Map f1477a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, Map map) {
        this.b = aVar;
        this.f1477a = map;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            for (Map.Entry entry : this.f1477a.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    String valueOf = String.valueOf(((Long) entry.getKey()).longValue());
                    if (concurrentHashMap.containsKey(valueOf) && concurrentHashMap.get(valueOf) != null) {
                        concurrentHashMap.get(valueOf).setPulled_msgId(((Long) entry.getValue()).longValue());
                    }
                }
            }
            this.b.n();
        }
    }
}
