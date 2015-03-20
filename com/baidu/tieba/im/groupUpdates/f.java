package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import com.baidu.tieba.im.data.UpdatesItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ UpdatesActivity biy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(UpdatesActivity updatesActivity) {
        this.biy = updatesActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        s sVar;
        UpdatesItemData updatesItemData;
        eVar.dismiss();
        switch (i) {
            case 0:
                sVar = this.biy.biv;
                sVar.setLoadProgressBarVisable(true);
                UpdatesActivity updatesActivity = this.biy;
                updatesItemData = this.biy.pendingToDel;
                updatesActivity.processDel(updatesItemData);
                return;
            default:
                return;
        }
    }
}
