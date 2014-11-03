package com.baidu.tieba.im.groupUpdates;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ i bcu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.bcu = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        View view2;
        UpdatesItemData updatesItemData;
        updatesActivity = this.bcu.bck;
        view2 = this.bcu.bcl;
        updatesItemData = this.bcu.bct;
        updatesActivity.a(view2, 101, 0, 0L, updatesItemData);
    }
}
