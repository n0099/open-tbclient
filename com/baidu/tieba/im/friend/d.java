package com.baidu.tieba.im.friend;

import android.content.DialogInterface;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements DialogInterface.OnClickListener {
    final /* synthetic */ IMBlackListActivity aVH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(IMBlackListActivity iMBlackListActivity) {
        this.aVH = iMBlackListActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.data.a aVar;
        BlackListModel blackListModel;
        com.baidu.tieba.im.data.a aVar2;
        aVar = this.aVH.aVG;
        if (aVar != null) {
            this.aVH.MW();
            blackListModel = this.aVH.aVE;
            aVar2 = this.aVH.aVG;
            blackListModel.removeFromBlackList(aVar2.getUserId());
        }
    }
}
