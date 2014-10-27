package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.im.model.MembersModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ MembersActivity aXN;
    private final /* synthetic */ BdListView aXO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(MembersActivity membersActivity, BdListView bdListView) {
        this.aXN = membersActivity;
        this.aXO = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        ah ahVar;
        boolean isFirstLoad;
        MembersModel membersModel;
        MembersModel membersModel2;
        MembersModel membersModel3;
        MembersModel membersModel4;
        MembersModel membersModel5;
        ahVar = this.aXN.aXJ;
        if (ahVar.NO().NJ()) {
            this.aXO.hN();
            return;
        }
        isFirstLoad = this.aXN.isFirstLoad();
        if (isFirstLoad) {
            membersModel = this.aXN.aXK;
            membersModel2 = this.aXN.aXK;
            long groupId = membersModel2.getGroupId();
            membersModel3 = this.aXN.aXK;
            int start = membersModel3.getStart();
            membersModel4 = this.aXN.aXK;
            int len = membersModel4.getLen();
            membersModel5 = this.aXN.aXK;
            membersModel.sendMessage(groupId, start, len, membersModel5.getOrderType());
            return;
        }
        this.aXN.reset();
    }
}
