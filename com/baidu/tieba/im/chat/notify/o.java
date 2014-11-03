package com.baidu.tieba.im.chat.notify;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements DialogInterface.OnClickListener {
    final /* synthetic */ g aQQ;
    private final /* synthetic */ ImMessageCenterShowItemData aQS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(g gVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.aQQ = gVar;
        this.aQS = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ImMessageCenterModel imMessageCenterModel;
        a aVar;
        switch (i) {
            case 0:
                imMessageCenterModel = this.aQQ.aQA;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.aQS;
                aVar = this.aQQ.aQP;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
