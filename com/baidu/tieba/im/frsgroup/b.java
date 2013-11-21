package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class b implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsGroupListFragment f1636a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsGroupListFragment frsGroupListFragment) {
        this.f1636a = frsGroupListFragment;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        com.baidu.tieba.im.model.b bVar;
        com.baidu.tieba.im.model.b bVar2;
        int i;
        BdListView bdListView;
        bVar = this.f1636a.b;
        if (!bVar.h() || !z) {
            bVar2 = this.f1636a.b;
            if (bVar2.i()) {
                i = this.f1636a.Y;
                if (i == com.baidu.tieba.im.d.b.a()) {
                    bdListView = this.f1636a.d;
                    bdListView.a();
                    this.f1636a.b(R.string.frsgroup_hot_cannot_refresh_tip);
                    return;
                }
            }
            this.f1636a.J();
            return;
        }
        this.f1636a.a(false);
    }
}
