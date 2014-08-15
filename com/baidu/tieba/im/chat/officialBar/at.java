package com.baidu.tieba.im.chat.officialBar;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class at implements DialogInterface.OnClickListener {
    final /* synthetic */ as a;
    private final /* synthetic */ ImMessageCenterShowItemData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.a = asVar;
        this.b = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        OfficialBarTipActivity officialBarTipActivity;
        com.baidu.tieba.im.model.ar arVar;
        OfficialBarTipActivity officialBarTipActivity2;
        com.baidu.tieba.im.chat.notify.a aVar;
        officialBarTipActivity = this.a.a;
        arVar = officialBarTipActivity.b;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.b;
        officialBarTipActivity2 = this.a.a;
        aVar = officialBarTipActivity2.e;
        arVar.a(imMessageCenterShowItemData, aVar);
    }
}
