package com.baidu.tieba.im.chat.officialBar;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.model.OfficialBarTipModel;
/* loaded from: classes.dex */
class at implements DialogInterface.OnClickListener {
    final /* synthetic */ as aSj;
    private final /* synthetic */ ImMessageCenterShowItemData aSk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.aSj = asVar;
        this.aSk = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        OfficialBarTipActivity officialBarTipActivity;
        OfficialBarTipModel officialBarTipModel;
        OfficialBarTipActivity officialBarTipActivity2;
        com.baidu.tieba.im.chat.notify.a aVar;
        officialBarTipActivity = this.aSj.aSi;
        officialBarTipModel = officialBarTipActivity.aSg;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.aSk;
        officialBarTipActivity2 = this.aSj.aSi;
        aVar = officialBarTipActivity2.aQP;
        officialBarTipModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
