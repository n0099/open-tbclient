package com.baidu.tieba.im.chat.officialBar;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.model.bi;
/* loaded from: classes.dex */
class au implements DialogInterface.OnClickListener {
    final /* synthetic */ at a;
    private final /* synthetic */ ImMessageCenterShowItemData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(at atVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.a = atVar;
        this.b = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        OfficialBarTipActivity officialBarTipActivity;
        bi biVar;
        OfficialBarTipActivity officialBarTipActivity2;
        com.baidu.tieba.im.a<Void> aVar;
        officialBarTipActivity = this.a.a;
        biVar = officialBarTipActivity.a;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.b;
        officialBarTipActivity2 = this.a.a;
        aVar = officialBarTipActivity2.d;
        biVar.a(imMessageCenterShowItemData, aVar);
    }
}
