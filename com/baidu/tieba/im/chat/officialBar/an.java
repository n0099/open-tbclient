package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.model.OfficialBarTipModel;
/* loaded from: classes.dex */
class an implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ am aZV;
    private final /* synthetic */ ImMessageCenterShowItemData aZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.aZV = amVar;
        this.aZW = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        OfficialBarTipActivity officialBarTipActivity;
        OfficialBarTipModel officialBarTipModel;
        OfficialBarTipActivity officialBarTipActivity2;
        com.baidu.tieba.im.chat.notify.a aVar;
        eVar.dismiss();
        officialBarTipActivity = this.aZV.aZU;
        officialBarTipModel = officialBarTipActivity.aZQ;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.aZW;
        officialBarTipActivity2 = this.aZV.aZU;
        aVar = officialBarTipActivity2.aZT;
        officialBarTipModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
