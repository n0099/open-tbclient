package com.baidu.tieba.im.chat.notify;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements DialogInterface.OnClickListener {
    final /* synthetic */ g aQC;
    private final /* synthetic */ ImMessageCenterShowItemData aQE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(g gVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.aQC = gVar;
        this.aQE = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ImMessageCenterModel imMessageCenterModel;
        a aVar;
        switch (i) {
            case 0:
                imMessageCenterModel = this.aQC.aQm;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.aQE;
                aVar = this.aQC.aQB;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
