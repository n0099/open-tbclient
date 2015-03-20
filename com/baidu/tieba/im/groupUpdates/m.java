package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import com.baidu.tieba.im.data.UpdatesItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ i biH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.biH = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        View view2;
        UpdatesItemData updatesItemData;
        updatesActivity = this.biH.biz;
        view2 = this.biH.aCi;
        updatesItemData = this.biH.data;
        updatesActivity.onItemViewClick(view2, 101, 0, 0L, updatesItemData);
    }
}
