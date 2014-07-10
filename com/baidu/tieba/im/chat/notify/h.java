package com.baidu.tieba.im.chat.notify;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements DialogInterface.OnClickListener {
    final /* synthetic */ d a;
    private final /* synthetic */ ImMessageCenterShowItemData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.a = dVar;
        this.b = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.p pVar;
        switch (i) {
            case 0:
                pVar = this.a.d;
                pVar.a(this.b, new i(this));
                return;
            default:
                return;
        }
    }
}
