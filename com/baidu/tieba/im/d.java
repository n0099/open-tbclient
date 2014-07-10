package com.baidu.tieba.im;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c a;
    private final /* synthetic */ a b;
    private final /* synthetic */ Object c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, a aVar, Object obj) {
        this.a = cVar;
        this.b = aVar;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b != null) {
            try {
                this.b.a(this.c);
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }
}
