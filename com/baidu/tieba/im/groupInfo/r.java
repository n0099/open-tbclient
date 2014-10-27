package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
import com.baidu.tieba.im.model.GroupInfoModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ q bao;
    private final /* synthetic */ ResponseGroupInfoMessage bap;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, ResponseGroupInfoMessage responseGroupInfoMessage) {
        this.bao = qVar;
        this.bap = responseGroupInfoMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        GroupInfoActivity groupInfoActivity;
        s sVar;
        GroupInfoActivity groupInfoActivity2;
        s sVar2;
        GroupInfoActivity groupInfoActivity3;
        GroupInfoModel groupInfoModel;
        if (bool == null) {
            bool = false;
        }
        groupInfoActivity = this.bao.ban;
        sVar = groupInfoActivity.bai;
        sVar.OT();
        groupInfoActivity2 = this.bao.ban;
        sVar2 = groupInfoActivity2.bai;
        sVar2.a(this.bap.getData(), bool.booleanValue());
        groupInfoActivity3 = this.bao.ban;
        groupInfoModel = groupInfoActivity3.baj;
        groupInfoModel.setHasRecentJoin(bool.booleanValue() ? false : true);
    }
}
