package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class al extends SingleRunnable<Boolean> {
    final /* synthetic */ ConcurrentHashMap a;
    final /* synthetic */ ak b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar, ConcurrentHashMap concurrentHashMap) {
        this.b = akVar;
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
                com.baidu.tieba.im.chat.ae aeVar = (com.baidu.tieba.im.chat.ae) this.b.a.get((String) it.next());
                z = this.b.c.a(aeVar.a, aeVar.c, aeVar.b, this.a) ? true : z2;
            } else {
                return Boolean.valueOf(z2);
            }
        }
    }
}
