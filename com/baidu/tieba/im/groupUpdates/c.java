package com.baidu.tieba.im.groupUpdates;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdatesActivity f1700a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(UpdatesActivity updatesActivity) {
        this.f1700a = updatesActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        n nVar;
        UpdatesItemData updatesItemData;
        switch (i) {
            case 0:
                nVar = this.f1700a.b;
                nVar.a(true);
                UpdatesActivity updatesActivity = this.f1700a;
                updatesItemData = this.f1700a.i;
                updatesActivity.a(updatesItemData);
                return;
            default:
                return;
        }
    }
}
