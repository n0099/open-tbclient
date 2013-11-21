package com.baidu.tieba.im.groupUpdates;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1707a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.f1707a = fVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        UpdatesActivity updatesActivity;
        View view2;
        UpdatesItemData updatesItemData;
        updatesActivity = this.f1707a.l;
        view2 = this.f1707a.c;
        updatesItemData = this.f1707a.m;
        updatesActivity.b(view2, 200, 0, 0L, updatesItemData);
        return true;
    }
}
