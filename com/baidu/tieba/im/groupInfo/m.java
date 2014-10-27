package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.RequestGroupInfoLocalMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
import com.baidu.tieba.im.model.GroupInfoModel;
/* loaded from: classes.dex */
class m extends CustomMessageListener {
    final /* synthetic */ GroupInfoActivity ban;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(GroupInfoActivity groupInfoActivity, int i) {
        super(i);
        this.ban = groupInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        GroupInfoModel groupInfoModel;
        s sVar;
        GroupInfoModel groupInfoModel2;
        GroupInfoModel groupInfoModel3;
        GroupInfoModel groupInfoModel4;
        GroupInfoModel groupInfoModel5;
        GroupInfoModel groupInfoModel6;
        GroupInfoModel groupInfoModel7;
        GroupInfoModel groupInfoModel8;
        s sVar2;
        if (customResponsedMessage == null) {
            sVar2 = this.ban.bai;
            sVar2.OT();
            this.ban.showToast(com.baidu.tieba.y.neterror);
        } else if (customResponsedMessage.getCmd() == 2001102) {
            if (!(customResponsedMessage instanceof ResponseGroupInfoLocalMessage)) {
                groupInfoModel6 = this.ban.baj;
                groupInfoModel7 = this.ban.baj;
                long groupId = groupInfoModel7.getGroupId();
                groupInfoModel8 = this.ban.baj;
                groupInfoModel6.sendMessage(groupId, groupInfoModel8.getFrom());
                return;
            }
            ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = (ResponseGroupInfoLocalMessage) customResponsedMessage;
            if (responseGroupInfoLocalMessage.getOrginalMessage() != null) {
                long groupId2 = ((RequestGroupInfoLocalMessage) responseGroupInfoLocalMessage.getOrginalMessage()).getGroupId();
                groupInfoModel5 = this.ban.baj;
                if (groupId2 != groupInfoModel5.getGroupId()) {
                    return;
                }
            }
            if (responseGroupInfoLocalMessage.getError() != 0) {
                groupInfoModel2 = this.ban.baj;
                groupInfoModel3 = this.ban.baj;
                long groupId3 = groupInfoModel3.getGroupId();
                groupInfoModel4 = this.ban.baj;
                groupInfoModel2.sendMessage(groupId3, groupInfoModel4.getFrom());
                return;
            }
            this.ban.De();
            groupInfoModel = this.ban.baj;
            groupInfoModel.setData(responseGroupInfoLocalMessage.getData());
            sVar = this.ban.bai;
            sVar.setData(responseGroupInfoLocalMessage.getData());
        }
    }
}
