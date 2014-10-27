package com.baidu.tieba.im.groupUpdates;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ i bcg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.bcg = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        View view2;
        UpdatesItemData updatesItemData;
        updatesActivity = this.bcg.bbW;
        view2 = this.bcg.bbX;
        updatesItemData = this.bcg.bcf;
        updatesActivity.a(view2, 101, 0, 0L, updatesItemData);
    }
}
