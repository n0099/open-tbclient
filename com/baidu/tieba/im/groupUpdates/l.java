package com.baidu.tieba.im.groupUpdates;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.a = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        UpdatesItemData updatesItemData;
        view.setSelected(!view.isSelected());
        updatesActivity = this.a.l;
        boolean isSelected = view.isSelected();
        updatesItemData = this.a.m;
        updatesActivity.a(view, isSelected, updatesItemData);
    }
}
