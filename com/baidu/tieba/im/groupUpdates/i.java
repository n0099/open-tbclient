package com.baidu.tieba.im.groupUpdates;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1772a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.f1772a = fVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        UpdatesActivity updatesActivity;
        View view2;
        UpdatesItemData updatesItemData;
        updatesActivity = this.f1772a.l;
        view2 = this.f1772a.c;
        updatesItemData = this.f1772a.m;
        updatesActivity.b(view2, 200, 0, 0L, updatesItemData);
        return true;
    }
}
