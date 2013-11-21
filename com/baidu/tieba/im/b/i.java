package com.baidu.tieba.im.b;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1473a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(d dVar) {
        this.f1473a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        BdListView bdListView = this.f1473a.f1468a;
        aVar = this.f1473a.j;
        ak.a(bdListView, aVar.a(), 0, -1);
    }
}
