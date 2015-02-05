package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import com.baidu.tieba.im.data.UpdatesItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnLongClickListener {
    final /* synthetic */ i bhr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.bhr = iVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        UpdatesActivity updatesActivity;
        View view2;
        UpdatesItemData updatesItemData;
        updatesActivity = this.bhr.bhj;
        view2 = this.bhr.awv;
        updatesItemData = this.bhr.data;
        updatesActivity.onItemViewLongClick(view2, 200, 0, 0L, updatesItemData);
        return true;
    }
}
