package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import com.baidu.tieba.im.data.UpdatesItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ i biH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(i iVar) {
        this.biH = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        UpdatesItemData updatesItemData;
        view.setSelected(!view.isSelected());
        updatesActivity = this.biH.biz;
        boolean isSelected = view.isSelected();
        updatesItemData = this.biH.data;
        updatesActivity.onCheckedChanged(view, isSelected, updatesItemData);
    }
}
