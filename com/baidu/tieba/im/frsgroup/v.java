package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.im.model.MembersModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ MembersActivity aYb;
    private final /* synthetic */ BdListView aYc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(MembersActivity membersActivity, BdListView bdListView) {
        this.aYb = membersActivity;
        this.aYc = bdListView;
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
        ahVar = this.aYb.aXX;
        if (ahVar.NS().NN()) {
            this.aYc.hN();
            return;
        }
        isFirstLoad = this.aYb.isFirstLoad();
        if (isFirstLoad) {
            membersModel = this.aYb.aXY;
            membersModel2 = this.aYb.aXY;
            long groupId = membersModel2.getGroupId();
            membersModel3 = this.aYb.aXY;
            int start = membersModel3.getStart();
            membersModel4 = this.aYb.aXY;
            int len = membersModel4.getLen();
            membersModel5 = this.aYb.aXY;
            membersModel.sendMessage(groupId, start, len, membersModel5.getOrderType());
            return;
        }
        this.aYb.reset();
    }
}
