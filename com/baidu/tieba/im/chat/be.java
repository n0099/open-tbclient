package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.model.UpdateGroupModel;
/* loaded from: classes.dex */
class be extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ GroupSettingActivity aOC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(GroupSettingActivity groupSettingActivity, int i) {
        super(i);
        this.aOC = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        bm bmVar;
        UpdateGroupModel updateGroupModel;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage)) {
            if (socketResponsedMessage.getCmd() == 103112) {
                if (socketResponsedMessage.getError() != 0) {
                    this.aOC.hideProgressBar();
                    this.aOC.showToast(com.baidu.tieba.y.neterror);
                    return;
                }
                this.aOC.hideProgressBar();
                this.aOC.showToast(com.baidu.tieba.y.group_quit_suc);
                this.aOC.finish();
            } else if (socketResponsedMessage.getCmd() == 103102) {
                if (socketResponsedMessage.getError() != 0) {
                    this.aOC.hideProgressBar();
                    this.aOC.showToast(socketResponsedMessage.getErrorString());
                    return;
                }
                this.aOC.hideProgressBar();
                this.aOC.showToast(com.baidu.tieba.y.group_add_group_switch_success);
                bmVar = this.aOC.aOw;
                updateGroupModel = this.aOC.aOx;
                bmVar.setFlag(updateGroupModel.getFlag());
            } else if (socketResponsedMessage.getCmd() == 103104) {
                this.aOC.hideProgressBar();
                if (socketResponsedMessage.getError() == 0) {
                    com.baidu.tbadk.core.j.l(this.aOC, "dismiss_group_success");
                    this.aOC.showToast(com.baidu.tieba.y.group_dismiss_success, false);
                    this.aOC.finish();
                    return;
                }
                this.aOC.t(socketResponsedMessage.getErrorString(), socketResponsedMessage.getError());
            } else {
                socketResponsedMessage.getCmd();
            }
        }
    }
}
