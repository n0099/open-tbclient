package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.ak;
/* loaded from: classes.dex */
class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MembersActivity f1655a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(MembersActivity membersActivity) {
        this.f1655a = membersActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        aa aaVar;
        aa aaVar2;
        aaVar = this.f1655a.f1641a;
        BdListView l = aaVar.l();
        aaVar2 = this.f1655a.f1641a;
        ak.a(l, aaVar2.i().e(), 1, 0);
    }
}
