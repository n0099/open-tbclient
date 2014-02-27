package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.message.s;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements Runnable {
    final /* synthetic */ d a;
    private final /* synthetic */ s b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, s sVar) {
        this.a = dVar;
        this.b = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.b);
        this.a.a(linkedList);
    }
}
