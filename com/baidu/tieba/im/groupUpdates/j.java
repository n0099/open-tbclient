package com.baidu.tieba.im.groupUpdates;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1706a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(f fVar) {
        this.f1706a = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        View view2;
        UpdatesItemData updatesItemData;
        updatesActivity = this.f1706a.l;
        view2 = this.f1706a.c;
        updatesItemData = this.f1706a.m;
        updatesActivity.a(view2, 101, 0, 0L, updatesItemData);
    }
}
