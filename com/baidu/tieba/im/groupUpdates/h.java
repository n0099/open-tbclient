package com.baidu.tieba.im.groupUpdates;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1713a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.f1713a = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        View view2;
        UpdatesItemData updatesItemData;
        updatesActivity = this.f1713a.l;
        view2 = this.f1713a.c;
        updatesItemData = this.f1713a.m;
        updatesActivity.a(view2, 101, 0, 0L, updatesItemData);
    }
}
