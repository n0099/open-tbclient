package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements a {
    final /* synthetic */ g aQQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(g gVar) {
        this.aQQ = gVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void Km() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.aQQ.aQC;
        if (bdListView != null) {
            imMessageCenterModel = this.aQQ.aQA;
            if (imMessageCenterModel != null) {
                bdListView2 = this.aQQ.aQC;
                bdListView2.hN();
                imMessageCenterListAdapter = this.aQQ.aQD;
                imMessageCenterModel2 = this.aQQ.aQA;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
