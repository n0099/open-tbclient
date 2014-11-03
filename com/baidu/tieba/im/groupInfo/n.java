package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.RequestGroupInfoLocalMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
import com.baidu.tieba.im.model.GroupInfoModel;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    final /* synthetic */ GroupInfoActivity baC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(GroupInfoActivity groupInfoActivity, int i) {
        super(i);
        this.baC = groupInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        GroupInfoModel groupInfoModel;
        t tVar;
        GroupInfoModel groupInfoModel2;
        GroupInfoModel groupInfoModel3;
        GroupInfoModel groupInfoModel4;
        GroupInfoModel groupInfoModel5;
        GroupInfoModel groupInfoModel6;
        GroupInfoModel groupInfoModel7;
        GroupInfoModel groupInfoModel8;
        t tVar2;
        if (customResponsedMessage == null) {
            tVar2 = this.baC.bax;
            tVar2.OW();
            this.baC.showToast(com.baidu.tieba.y.neterror);
        } else if (customResponsedMessage.getCmd() == 2001102) {
            if (!(customResponsedMessage instanceof ResponseGroupInfoLocalMessage)) {
                groupInfoModel6 = this.baC.bay;
                groupInfoModel7 = this.baC.bay;
                long groupId = groupInfoModel7.getGroupId();
                groupInfoModel8 = this.baC.bay;
                groupInfoModel6.sendMessage(groupId, groupInfoModel8.getFrom());
                return;
            }
            ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = (ResponseGroupInfoLocalMessage) customResponsedMessage;
            if (responseGroupInfoLocalMessage.getOrginalMessage() != null) {
                long groupId2 = ((RequestGroupInfoLocalMessage) responseGroupInfoLocalMessage.getOrginalMessage()).getGroupId();
                groupInfoModel5 = this.baC.bay;
                if (groupId2 != groupInfoModel5.getGroupId()) {
                    return;
                }
            }
            if (responseGroupInfoLocalMessage.getError() != 0) {
                groupInfoModel2 = this.baC.bay;
                groupInfoModel3 = this.baC.bay;
                long groupId3 = groupInfoModel3.getGroupId();
                groupInfoModel4 = this.baC.bay;
                groupInfoModel2.sendMessage(groupId3, groupInfoModel4.getFrom());
                return;
            }
            this.baC.Dg();
            groupInfoModel = this.baC.bay;
            groupInfoModel.setData(responseGroupInfoLocalMessage.getData());
            tVar = this.baC.bax;
            tVar.setData(responseGroupInfoLocalMessage.getData());
        }
    }
}
