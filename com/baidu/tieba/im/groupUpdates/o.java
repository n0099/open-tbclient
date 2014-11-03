package com.baidu.tieba.im.groupUpdates;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ i bcu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(i iVar) {
        this.bcu = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        UpdatesItemData updatesItemData;
        view.setSelected(!view.isSelected());
        updatesActivity = this.bcu.bck;
        boolean isSelected = view.isSelected();
        updatesItemData = this.bcu.bct;
        updatesActivity.a(view, isSelected, updatesItemData);
    }
}
