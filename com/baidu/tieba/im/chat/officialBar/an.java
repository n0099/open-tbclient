package com.baidu.tieba.im.chat.officialBar;

import android.content.DialogInterface;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.model.OfficialBarTipModel;
/* loaded from: classes.dex */
class an implements DialogInterface.OnClickListener {
    final /* synthetic */ am aUS;
    private final /* synthetic */ ImMessageCenterShowItemData aUT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.aUS = amVar;
        this.aUT = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        OfficialBarTipActivity officialBarTipActivity;
        OfficialBarTipModel officialBarTipModel;
        OfficialBarTipActivity officialBarTipActivity2;
        com.baidu.tieba.im.chat.notify.a aVar;
        officialBarTipActivity = this.aUS.aUR;
        officialBarTipModel = officialBarTipActivity.aUP;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.aUT;
        officialBarTipActivity2 = this.aUS.aUR;
        aVar = officialBarTipActivity2.aTD;
        officialBarTipModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
