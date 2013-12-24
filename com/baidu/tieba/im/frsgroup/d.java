package com.baidu.tieba.im.frsgroup;

import android.view.View;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ FrsGroupListFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsGroupListFragment frsGroupListFragment) {
        this.a = frsGroupListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.im.model.c cVar;
        FrsGroupActivity frsGroupActivity;
        com.baidu.tieba.im.model.c cVar2;
        cVar = this.a.b;
        if (cVar.d() != null) {
            frsGroupActivity = this.a.a;
            cVar2 = this.a.b;
            frsGroupActivity.a(cVar2.d());
        }
    }
}
