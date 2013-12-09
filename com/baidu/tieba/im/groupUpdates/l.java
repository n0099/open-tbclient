package com.baidu.tieba.im.groupUpdates;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1775a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.f1775a = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        UpdatesItemData updatesItemData;
        view.setSelected(!view.isSelected());
        updatesActivity = this.f1775a.l;
        boolean isSelected = view.isSelected();
        updatesItemData = this.f1775a.m;
        updatesActivity.a(view, isSelected, updatesItemData);
    }
}
