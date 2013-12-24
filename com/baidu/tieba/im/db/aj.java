package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class aj extends SingleRunnable<Boolean> {
    final /* synthetic */ ConcurrentHashMap a;
    final /* synthetic */ ai b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar, ConcurrentHashMap concurrentHashMap) {
        this.b = aiVar;
        this.a = concurrentHashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        boolean z = false;
        Iterator it = this.b.a.keySet().iterator();
        while (true) {
            boolean z2 = z;
            if (it.hasNext()) {
                com.baidu.tieba.im.chat.o oVar = (com.baidu.tieba.im.chat.o) this.b.a.get((String) it.next());
                z = this.b.c.a(oVar.a, oVar.c, oVar.b, this.a) ? true : z2;
            } else {
                return Boolean.valueOf(z2);
            }
        }
    }
}
