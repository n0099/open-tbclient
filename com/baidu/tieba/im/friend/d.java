package com.baidu.tieba.im.friend;

import android.content.DialogInterface;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements DialogInterface.OnClickListener {
    final /* synthetic */ IMBlackListActivity aVt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(IMBlackListActivity iMBlackListActivity) {
        this.aVt = iMBlackListActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.data.a aVar;
        BlackListModel blackListModel;
        com.baidu.tieba.im.data.a aVar2;
        aVar = this.aVt.aVs;
        if (aVar != null) {
            this.aVt.MS();
            blackListModel = this.aVt.aVq;
            aVar2 = this.aVt.aVs;
            blackListModel.removeFromBlackList(aVar2.getUserId());
        }
    }
}
