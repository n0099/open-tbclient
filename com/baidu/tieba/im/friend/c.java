package com.baidu.tieba.im.friend;

import android.content.DialogInterface;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements DialogInterface.OnCancelListener {
    final /* synthetic */ IMBlackListActivity aZY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(IMBlackListActivity iMBlackListActivity) {
        this.aZY = iMBlackListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        blackListModel = this.aZY.aZV;
        if (blackListModel != null) {
            blackListModel2 = this.aZY.aZV;
            blackListModel2.cancelLoadData();
            this.aZY.aZX = null;
        }
    }
}
