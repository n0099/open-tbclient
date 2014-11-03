package com.baidu.tieba.im.groupUpdates;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnClickListener {
    final /* synthetic */ UpdatesActivity bci;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(UpdatesActivity updatesActivity) {
        this.bci = updatesActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        t tVar;
        UpdatesItemData updatesItemData;
        switch (i) {
            case 0:
                tVar = this.bci.bca;
                tVar.dg(true);
                UpdatesActivity updatesActivity = this.bci;
                updatesItemData = this.bci.bcg;
                updatesActivity.a(updatesItemData);
                return;
            default:
                return;
        }
    }
}
