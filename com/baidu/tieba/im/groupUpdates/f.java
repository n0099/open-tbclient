package com.baidu.tieba.im.groupUpdates;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnClickListener {
    final /* synthetic */ UpdatesActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(UpdatesActivity updatesActivity) {
        this.a = updatesActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        t tVar;
        UpdatesItemData updatesItemData;
        switch (i) {
            case 0:
                tVar = this.a.b;
                tVar.a(true);
                UpdatesActivity updatesActivity = this.a;
                updatesItemData = this.a.i;
                updatesActivity.a(updatesItemData);
                return;
            default:
                return;
        }
    }
}
