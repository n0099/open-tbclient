package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
class be extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(GroupSettingActivity groupSettingActivity, int i) {
        super(i);
        this.a = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        bm bmVar;
        com.baidu.tieba.im.model.bb bbVar;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage)) {
            if (socketResponsedMessage.getCmd() == 103112) {
                if (socketResponsedMessage.getError() != 0) {
                    this.a.hideProgressBar();
                    this.a.showToast(com.baidu.tieba.x.neterror);
                    return;
                }
                this.a.hideProgressBar();
                this.a.showToast(com.baidu.tieba.x.group_quit_suc);
                this.a.finish();
            } else if (socketResponsedMessage.getCmd() == 103102) {
                if (socketResponsedMessage.getError() != 0) {
                    this.a.hideProgressBar();
                    this.a.showToast(socketResponsedMessage.getErrorString());
                    return;
                }
                this.a.hideProgressBar();
                this.a.showToast(com.baidu.tieba.x.group_add_group_switch_success);
                bmVar = this.a.b;
                bbVar = this.a.c;
                bmVar.b(bbVar.h());
            } else if (socketResponsedMessage.getCmd() == 103104) {
                this.a.hideProgressBar();
                if (socketResponsedMessage.getError() == 0) {
                    com.baidu.tbadk.core.f.a(this.a, "dismiss_group_success");
                    this.a.showToast(com.baidu.tieba.x.group_dismiss_success, false);
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
