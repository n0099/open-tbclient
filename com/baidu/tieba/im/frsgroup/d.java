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
        FrsGroupActivity frsGroupActivity;
        FrsGroupActivity frsGroupActivity2;
        frsGroupActivity = this.a.a;
        if (frsGroupActivity != null) {
            frsGroupActivity2 = this.a.a;
            frsGroupActivity2.f();
        }
    }
}
