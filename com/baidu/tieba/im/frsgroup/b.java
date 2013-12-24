package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class b implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ FrsGroupListFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsGroupListFragment frsGroupListFragment) {
        this.a = frsGroupListFragment;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        com.baidu.tieba.im.model.c cVar;
        com.baidu.tieba.im.model.c cVar2;
        int i;
        BdListView bdListView;
        cVar = this.a.b;
        if (!cVar.h() || !z) {
            cVar2 = this.a.b;
            if (cVar2.i()) {
                i = this.a.Y;
                if (i == com.baidu.tieba.im.d.c.a()) {
                    bdListView = this.a.d;
                    bdListView.a();
                    this.a.b(R.string.frsgroup_hot_cannot_refresh_tip);
                    return;
                }
            }
            this.a.J();
            return;
        }
        this.a.a(false);
    }
}
