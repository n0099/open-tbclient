package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MembersActivity f1571a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MembersActivity membersActivity) {
        this.f1571a = membersActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ae aeVar;
        ae aeVar2;
        aeVar = this.f1571a.f1551a;
        BdListView m = aeVar.m();
        aeVar2 = this.f1571a.f1551a;
        com.baidu.tieba.util.ab.a(m, aeVar2.i().e(), 1, 0);
    }
}
