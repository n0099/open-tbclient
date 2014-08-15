package com.baidu.tieba.im.chat.notify;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements DialogInterface.OnClickListener {
    final /* synthetic */ e a;
    private final /* synthetic */ ImMessageCenterShowItemData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.a = eVar;
        this.b = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.p pVar;
        a aVar;
        switch (i) {
            case 0:
                pVar = this.a.c;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.b;
                aVar = this.a.u;
                pVar.a(imMessageCenterShowItemData, false, aVar);
                return;
            default:
                return;
        }
    }
}
