package com.baidu.tieba.im.groupUpdates;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements DialogInterface.OnClickListener {
    final /* synthetic */ UpdatesActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(UpdatesActivity updatesActivity) {
        this.a = updatesActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        q qVar;
        UpdatesItemData updatesItemData;
        switch (i) {
            case 0:
                qVar = this.a.b;
                qVar.a(true);
                UpdatesActivity updatesActivity = this.a;
                updatesItemData = this.a.i;
                UpdatesActivity.a(updatesActivity, updatesItemData);
                return;
            default:
                return;
        }
    }
}
