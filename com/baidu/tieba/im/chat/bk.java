package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
final class bk extends com.baidu.adp.framework.c.g {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bk(GroupSettingActivity groupSettingActivity, int i) {
        super(0);
        this.a = groupSettingActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        bs bsVar;
        bs bsVar2;
        com.baidu.tieba.im.model.br brVar;
        bs bsVar3;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 == null || !(socketResponsedMessage2 instanceof com.baidu.adp.framework.message.f)) {
            return;
        }
        if (socketResponsedMessage2.g() == 103112) {
            if (socketResponsedMessage2.e() != 0) {
                this.a.hideProgressBar();
                this.a.showToast(com.baidu.tieba.im.j.neterror);
                return;
            }
            this.a.hideProgressBar();
            this.a.showToast(com.baidu.tieba.im.j.group_quit_suc);
            bsVar3 = this.a.b;
            com.baidu.tieba.im.f.h.a(bsVar3.b());
            com.baidu.tieba.im.pushNotify.a.d().b(false, null);
            this.a.finish();
        } else if (socketResponsedMessage2.g() == 103102) {
            if (socketResponsedMessage2.e() != 0) {
                this.a.hideProgressBar();
                this.a.showToast(socketResponsedMessage2.f());
                return;
            }
            this.a.hideProgressBar();
            this.a.showToast(com.baidu.tieba.im.j.group_add_group_switch_success);
            bsVar2 = this.a.b;
            brVar = this.a.c;
            bsVar2.b(brVar.c());
        } else if (socketResponsedMessage2.g() != 103104) {
            socketResponsedMessage2.g();
        } else {
            this.a.hideProgressBar();
            if (socketResponsedMessage2.e() != 0) {
                GroupSettingActivity.a(this.a, socketResponsedMessage2.f(), socketResponsedMessage2.e());
                return;
            }
            com.baidu.tbadk.core.g.a(this.a, "dismiss_group_success");
            bsVar = this.a.b;
            com.baidu.tieba.im.f.h.a(bsVar.b());
            this.a.showToast(com.baidu.tieba.im.j.group_dismiss_success, false);
            this.a.finish();
        }
    }
}
