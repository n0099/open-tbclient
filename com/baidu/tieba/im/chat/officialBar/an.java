package com.baidu.tieba.im.chat.officialBar;

import android.content.DialogInterface;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.model.OfficialBarTipModel;
/* loaded from: classes.dex */
class an implements DialogInterface.OnClickListener {
    final /* synthetic */ am aUR;
    private final /* synthetic */ ImMessageCenterShowItemData aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.aUR = amVar;
        this.aUS = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        OfficialBarTipActivity officialBarTipActivity;
        OfficialBarTipModel officialBarTipModel;
        OfficialBarTipActivity officialBarTipActivity2;
        com.baidu.tieba.im.chat.notify.a aVar;
        officialBarTipActivity = this.aUR.aUQ;
        officialBarTipModel = officialBarTipActivity.aUO;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.aUS;
        officialBarTipActivity2 = this.aUR.aUQ;
        aVar = officialBarTipActivity2.aTC;
        officialBarTipModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
