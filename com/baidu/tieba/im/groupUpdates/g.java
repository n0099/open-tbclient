package com.baidu.tieba.im.groupUpdates;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnClickListener {
    final /* synthetic */ UpdatesActivity bbU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(UpdatesActivity updatesActivity) {
        this.bbU = updatesActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        t tVar;
        UpdatesItemData updatesItemData;
        switch (i) {
            case 0:
                tVar = this.bbU.bbM;
                tVar.dg(true);
                UpdatesActivity updatesActivity = this.bbU;
                updatesItemData = this.bbU.bbS;
                updatesActivity.a(updatesItemData);
                return;
            default:
                return;
        }
    }
}
