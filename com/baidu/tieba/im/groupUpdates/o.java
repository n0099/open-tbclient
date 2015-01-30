package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import com.baidu.tieba.im.data.UpdatesItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ i bhs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(i iVar) {
        this.bhs = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        UpdatesItemData updatesItemData;
        view.setSelected(!view.isSelected());
        updatesActivity = this.bhs.bhk;
        boolean isSelected = view.isSelected();
        updatesItemData = this.bhs.data;
        updatesActivity.onCheckedChanged(view, isSelected, updatesItemData);
    }
}
