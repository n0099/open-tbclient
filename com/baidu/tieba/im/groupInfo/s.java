package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
import com.baidu.tieba.im.model.GroupInfoModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ r baD;
    private final /* synthetic */ ResponseGroupInfoMessage baE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, ResponseGroupInfoMessage responseGroupInfoMessage) {
        this.baD = rVar;
        this.baE = responseGroupInfoMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        GroupInfoActivity groupInfoActivity;
        t tVar;
        GroupInfoActivity groupInfoActivity2;
        t tVar2;
        GroupInfoActivity groupInfoActivity3;
        GroupInfoModel groupInfoModel;
        if (bool == null) {
            bool = false;
        }
        groupInfoActivity = this.baD.baC;
        tVar = groupInfoActivity.bax;
        tVar.OW();
        groupInfoActivity2 = this.baD.baC;
        tVar2 = groupInfoActivity2.bax;
        tVar2.a(this.baE.getData(), bool.booleanValue());
        groupInfoActivity3 = this.baD.baC;
        groupInfoModel = groupInfoActivity3.bay;
        groupInfoModel.setHasRecentJoin(bool.booleanValue() ? false : true);
    }
}
