package com.baidu.tieba.im;

import com.baidu.tieba.im.SingleRunnable;
/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1633a;
    final /* synthetic */ Object b;
    final /* synthetic */ SingleRunnable.UIHandler c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SingleRunnable.UIHandler uIHandler, a aVar, Object obj) {
        this.c = uIHandler;
        this.f1633a = aVar;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1633a != null) {
            this.f1633a.a(this.b);
        }
    }
}
