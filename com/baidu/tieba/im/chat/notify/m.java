package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements a {
    final /* synthetic */ g aTD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(g gVar) {
        this.aTD = gVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.aTD.aTp;
        if (bdListView != null) {
            imMessageCenterModel = this.aTD.aTm;
            if (imMessageCenterModel != null) {
                bdListView2 = this.aTD.aTp;
                bdListView2.jB();
                imMessageCenterListAdapter = this.aTD.aTq;
                imMessageCenterModel2 = this.aTD.aTm;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
