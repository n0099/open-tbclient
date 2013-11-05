package com.baidu.tieba.im.frsgroup;

import android.view.View;
/* loaded from: classes.dex */
class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsGroupListFragment f1561a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsGroupListFragment frsGroupListFragment) {
        this.f1561a = frsGroupListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.im.model.b bVar;
        FrsGroupActivity frsGroupActivity;
        com.baidu.tieba.im.model.b bVar2;
        bVar = this.f1561a.b;
        if (bVar.d() != null) {
            frsGroupActivity = this.f1561a.f1546a;
            bVar2 = this.f1561a.b;
            frsGroupActivity.a(bVar2.d());
        }
    }
}
