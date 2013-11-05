package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class d implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsGroupListFragment f1559a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsGroupListFragment frsGroupListFragment) {
        this.f1559a = frsGroupListFragment;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        com.baidu.tieba.im.model.b bVar;
        com.baidu.tieba.im.model.b bVar2;
        int i;
        BdListView bdListView;
        bVar = this.f1559a.b;
        if (!bVar.h() || !z) {
            bVar2 = this.f1559a.b;
            if (bVar2.i()) {
                i = this.f1559a.Y;
                if (i == com.baidu.tieba.im.d.b.a()) {
                    bdListView = this.f1559a.d;
                    bdListView.a();
                    this.f1559a.b(R.string.frsgroup_hot_cannot_refresh_tip);
                    return;
                }
            }
            this.f1559a.H();
            return;
        }
        this.f1559a.a(false);
    }
}
