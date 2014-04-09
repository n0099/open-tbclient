package com.baidu.tieba.im.chat.notify;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements DialogInterface.OnClickListener {
    final /* synthetic */ b a;
    private final /* synthetic */ ImMessageCenterShowItemData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.a = bVar;
        this.b = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.p pVar;
        switch (i) {
            case 0:
                this.a.i = 4;
                pVar = this.a.c;
                pVar.a(this.b, new e(this));
                return;
            default:
                return;
        }
    }
}
