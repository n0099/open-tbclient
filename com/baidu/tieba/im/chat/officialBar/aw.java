package com.baidu.tieba.im.chat.officialBar;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
final class aw implements DialogInterface.OnClickListener {
    final /* synthetic */ av a;
    private final /* synthetic */ ImMessageCenterShowItemData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.a = avVar;
        this.b = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        OfficialBarTipActivity officialBarTipActivity;
        com.baidu.tieba.im.model.bc bcVar;
        OfficialBarTipActivity officialBarTipActivity2;
        com.baidu.tieba.im.a<Void> aVar;
        officialBarTipActivity = this.a.a;
        bcVar = officialBarTipActivity.a;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.b;
        officialBarTipActivity2 = this.a.a;
        aVar = officialBarTipActivity2.d;
        bcVar.a(imMessageCenterShowItemData, aVar);
    }
}
