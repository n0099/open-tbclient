package com.baidu.tieba.im.frsgroup;

import android.view.View;
/* loaded from: classes.dex */
class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsGroupListFragment f1647a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsGroupListFragment frsGroupListFragment) {
        this.f1647a = frsGroupListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.im.model.b bVar;
        FrsGroupActivity frsGroupActivity;
        com.baidu.tieba.im.model.b bVar2;
        bVar = this.f1647a.b;
        if (bVar.d() != null) {
            frsGroupActivity = this.f1647a.f1636a;
            bVar2 = this.f1647a.b;
            frsGroupActivity.a(bVar2.d());
        }
    }
}
