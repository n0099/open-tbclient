package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements a {
    final /* synthetic */ g aTE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(g gVar) {
        this.aTE = gVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.aTE.aTq;
        if (bdListView != null) {
            imMessageCenterModel = this.aTE.aTn;
            if (imMessageCenterModel != null) {
                bdListView2 = this.aTE.aTq;
                bdListView2.jI();
                imMessageCenterListAdapter = this.aTE.aTr;
                imMessageCenterModel2 = this.aTE.aTn;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
