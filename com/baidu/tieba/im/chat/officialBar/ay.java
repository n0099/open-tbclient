package com.baidu.tieba.im.chat.officialBar;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.model.bi;
/* loaded from: classes.dex */
class ay implements DialogInterface.OnClickListener {
    final /* synthetic */ ax a;
    private final /* synthetic */ ImMessageCenterShowItemData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.a = axVar;
        this.b = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        OfficialBarTipActivity officialBarTipActivity;
        bi biVar;
        OfficialBarTipActivity officialBarTipActivity2;
        com.baidu.tieba.im.a<Void> aVar;
        officialBarTipActivity = this.a.a;
        biVar = officialBarTipActivity.b;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.b;
        officialBarTipActivity2 = this.a.a;
        aVar = officialBarTipActivity2.e;
        biVar.a(imMessageCenterShowItemData, aVar);
    }
}
