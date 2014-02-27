package com.baidu.tieba.im.groupUpdates;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k implements View.OnLongClickListener {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.a = fVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        UpdatesActivity updatesActivity;
        View view2;
        UpdatesItemData updatesItemData;
        updatesActivity = this.a.l;
        view2 = this.a.c;
        updatesItemData = this.a.m;
        updatesActivity.a(view2, 200, updatesItemData);
        return true;
    }
}
