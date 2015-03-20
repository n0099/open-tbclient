package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.model.OfficialBarTipModel;
/* loaded from: classes.dex */
class an implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ am aZF;
    private final /* synthetic */ ImMessageCenterShowItemData aZG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.aZF = amVar;
        this.aZG = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        OfficialBarTipActivity officialBarTipActivity;
        OfficialBarTipModel officialBarTipModel;
        OfficialBarTipActivity officialBarTipActivity2;
        com.baidu.tieba.im.chat.notify.a aVar;
        eVar.dismiss();
        officialBarTipActivity = this.aZF.aZE;
        officialBarTipModel = officialBarTipActivity.aZA;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.aZG;
        officialBarTipActivity2 = this.aZF.aZE;
        aVar = officialBarTipActivity2.aZD;
        officialBarTipModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
