package com.baidu.tieba.im.groupUpdates;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.UpdatesItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnClickListener {
    final /* synthetic */ UpdatesActivity bfR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(UpdatesActivity updatesActivity) {
        this.bfR = updatesActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        p pVar;
        UpdatesItemData updatesItemData;
        switch (i) {
            case 0:
                pVar = this.bfR.bfO;
                pVar.setLoadProgressBarVisable(true);
                UpdatesActivity updatesActivity = this.bfR;
                updatesItemData = this.bfR.pendingToDel;
                updatesActivity.processDel(updatesItemData);
                return;
            default:
                return;
        }
    }
}
