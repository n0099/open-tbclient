package com.baidu.tieba.im.chat.notify;

import android.content.DialogInterface;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements DialogInterface.OnClickListener {
    final /* synthetic */ g aTE;
    private final /* synthetic */ ImMessageCenterShowItemData aTG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(g gVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.aTE = gVar;
        this.aTG = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ImMessageCenterModel imMessageCenterModel;
        a aVar;
        switch (i) {
            case 0:
                imMessageCenterModel = this.aTE.aTn;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.aTG;
                aVar = this.aTE.aTD;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
