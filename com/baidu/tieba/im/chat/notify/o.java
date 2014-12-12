package com.baidu.tieba.im.chat.notify;

import android.content.DialogInterface;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements DialogInterface.OnClickListener {
    final /* synthetic */ g aSu;
    private final /* synthetic */ ImMessageCenterShowItemData aSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(g gVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.aSu = gVar;
        this.aSw = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ImMessageCenterModel imMessageCenterModel;
        a aVar;
        switch (i) {
            case 0:
                imMessageCenterModel = this.aSu.aSe;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.aSw;
                aVar = this.aSu.aSt;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
