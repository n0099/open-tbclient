package com.baidu.tieba.im.chat.officialBar;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.model.OfficialBarTipModel;
/* loaded from: classes.dex */
class at implements DialogInterface.OnClickListener {
    final /* synthetic */ as aRV;
    private final /* synthetic */ ImMessageCenterShowItemData aRW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.aRV = asVar;
        this.aRW = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        OfficialBarTipActivity officialBarTipActivity;
        OfficialBarTipModel officialBarTipModel;
        OfficialBarTipActivity officialBarTipActivity2;
        com.baidu.tieba.im.chat.notify.a aVar;
        officialBarTipActivity = this.aRV.aRU;
        officialBarTipModel = officialBarTipActivity.aRS;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.aRW;
        officialBarTipActivity2 = this.aRV.aRU;
        aVar = officialBarTipActivity2.aQB;
        officialBarTipModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
