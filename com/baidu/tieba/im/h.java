package com.baidu.tieba.im;

import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ Object b;
    final /* synthetic */ SingleRunnable.UIHandler c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SingleRunnable.UIHandler uIHandler, a aVar, Object obj) {
        this.c = uIHandler;
        this.a = aVar;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a != null) {
            this.a.a(this.b);
        }
    }
}
