package com.baidu.tieba.im.chat.officialBar;

import android.content.DialogInterface;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.model.OfficialBarTipModel;
/* loaded from: classes.dex */
class an implements DialogInterface.OnClickListener {
    final /* synthetic */ am aTC;
    private final /* synthetic */ ImMessageCenterShowItemData aTD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.aTC = amVar;
        this.aTD = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        OfficialBarTipActivity officialBarTipActivity;
        OfficialBarTipModel officialBarTipModel;
        OfficialBarTipActivity officialBarTipActivity2;
        com.baidu.tieba.im.chat.notify.a aVar;
        officialBarTipActivity = this.aTC.aTB;
        officialBarTipModel = officialBarTipActivity.aTz;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.aTD;
        officialBarTipActivity2 = this.aTC.aTB;
        aVar = officialBarTipActivity2.aSt;
        officialBarTipModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
