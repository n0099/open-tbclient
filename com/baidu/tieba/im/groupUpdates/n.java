package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import com.baidu.tieba.im.data.UpdatesItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnLongClickListener {
    final /* synthetic */ i bhs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar) {
        this.bhs = iVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        UpdatesActivity updatesActivity;
        View view2;
        UpdatesItemData updatesItemData;
        updatesActivity = this.bhs.bhk;
        view2 = this.bhs.awy;
        updatesItemData = this.bhs.data;
        updatesActivity.onItemViewLongClick(view2, 200, 0, 0L, updatesItemData);
        return true;
    }
}
