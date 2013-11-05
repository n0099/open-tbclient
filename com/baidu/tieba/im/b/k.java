package com.baidu.tieba.im.b;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1388a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(d dVar) {
        this.f1388a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        BdListView bdListView = this.f1388a.f1381a;
        aVar = this.f1388a.h;
        ab.a(bdListView, aVar.a(), 0, -1);
    }
}
