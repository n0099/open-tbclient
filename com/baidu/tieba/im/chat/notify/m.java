package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements a {
    final /* synthetic */ g aSu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(g gVar) {
        this.aSu = gVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.aSu.aSh;
        if (bdListView != null) {
            imMessageCenterModel = this.aSu.aSe;
            if (imMessageCenterModel != null) {
                bdListView2 = this.aSu.aSh;
                bdListView2.jJ();
                imMessageCenterListAdapter = this.aSu.aSi;
                imMessageCenterModel2 = this.aSu.aSe;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
