package com.baidu.tieba.chat;

import android.content.DialogInterface;
import com.baidu.tieba.data.chat.ImMessageCenterShowItemData;
import com.baidu.tieba.model.ag;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l implements DialogInterface.OnClickListener {
    final /* synthetic */ a a;
    private final /* synthetic */ ImMessageCenterShowItemData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.a = aVar;
        this.b = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        ag agVar;
        switch (i) {
            case 0:
                this.a.i = 4;
                agVar = this.a.c;
                agVar.a(this.b, new m(this));
                return;
            default:
                return;
        }
    }
}
