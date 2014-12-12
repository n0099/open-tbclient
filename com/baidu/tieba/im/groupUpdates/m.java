package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import com.baidu.tieba.im.data.UpdatesItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ i bga;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.bga = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        View view2;
        UpdatesItemData updatesItemData;
        updatesActivity = this.bga.bfS;
        view2 = this.bga.avy;
        updatesItemData = this.bga.data;
        updatesActivity.onItemViewClick(view2, 101, 0, 0L, updatesItemData);
    }
}
