package com.baidu.tieba.im.friend;

import android.content.DialogInterface;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements DialogInterface.OnCancelListener {
    final /* synthetic */ IMBlackListActivity bbv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(IMBlackListActivity iMBlackListActivity) {
        this.bbv = iMBlackListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        blackListModel = this.bbv.bbs;
        if (blackListModel != null) {
            blackListModel2 = this.bbv.bbs;
            blackListModel2.cancelLoadData();
            this.bbv.bbu = null;
        }
    }
}
