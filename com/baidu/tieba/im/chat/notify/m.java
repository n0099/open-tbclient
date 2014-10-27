package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements a {
    final /* synthetic */ g aQC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(g gVar) {
        this.aQC = gVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void Ki() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.aQC.aQo;
        if (bdListView != null) {
            imMessageCenterModel = this.aQC.aQm;
            if (imMessageCenterModel != null) {
                bdListView2 = this.aQC.aQo;
                bdListView2.hN();
                imMessageCenterListAdapter = this.aQC.aQp;
                imMessageCenterModel2 = this.aQC.aQm;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
