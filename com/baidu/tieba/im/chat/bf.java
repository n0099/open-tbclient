package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
class bf extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bf(GroupSettingActivity groupSettingActivity, int i) {
        super(i);
        this.a = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        bn bnVar;
        bn bnVar2;
        com.baidu.tieba.im.model.by byVar;
        bn bnVar3;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage)) {
            if (socketResponsedMessage.getCmd() == 103112) {
                if (socketResponsedMessage.getError() != 0) {
                    this.a.hideProgressBar();
                    this.a.showToast(com.baidu.tieba.y.neterror);
                    return;
                }
                this.a.hideProgressBar();
                this.a.showToast(com.baidu.tieba.y.group_quit_suc);
                bnVar3 = this.a.b;
                com.baidu.tieba.im.e.i.a(bnVar3.b());
                com.baidu.tieba.im.pushNotify.a.f().b(false, (com.baidu.tieba.im.a<Void>) null);
                this.a.finish();
            } else if (socketResponsedMessage.getCmd() == 103102) {
                if (socketResponsedMessage.getError() != 0) {
                    this.a.hideProgressBar();
                    this.a.showToast(socketResponsedMessage.getErrorString());
                    return;
                }
                this.a.hideProgressBar();
                this.a.showToast(com.baidu.tieba.y.group_add_group_switch_success);
                bnVar2 = this.a.b;
                byVar = this.a.c;
                bnVar2.b(byVar.h());
            } else if (socketResponsedMessage.getCmd() == 103104) {
                this.a.hideProgressBar();
                if (socketResponsedMessage.getError() == 0) {
                    com.baidu.tbadk.core.f.a(this.a, "dismiss_group_success");
                    bnVar = this.a.b;
                    com.baidu.tieba.im.e.i.a(bnVar.b());
                    this.a.showToast(com.baidu.tieba.y.group_dismiss_success, false);
                    this.a.finish();
                    return;
                }
                this.a.a(socketResponsedMessage.getErrorString(), socketResponsedMessage.getError());
            } else {
                socketResponsedMessage.getCmd();
            }
        }
    }
}
