package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class f implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.a = cVar;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        com.baidu.tieba.im.model.d dVar;
        com.baidu.tieba.im.model.d dVar2;
        int i;
        BdListView bdListView;
        dVar = this.a.c;
        if (!dVar.h() || !z) {
            dVar2 = this.a.c;
            if (dVar2.i()) {
                i = this.a.k;
                if (i == BdUtilHelper.a()) {
                    bdListView = this.a.e;
                    bdListView.a();
                    this.a.a(R.string.frsgroup_hot_cannot_refresh_tip);
                    return;
                }
            }
            this.a.f();
            return;
        }
        this.a.a(false);
    }
}
