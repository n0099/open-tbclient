package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.da;
/* loaded from: classes.dex */
class ai implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MsglistModel a;

    private ai(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ai(MsglistModel msglistModel, ai aiVar) {
        this(msglistModel);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar == null) {
            com.baidu.adp.lib.util.f.b("msg == null");
        } else if (sVar.w() == 103112) {
            MsglistModel.a(this.a, sVar);
        } else if (sVar.w() == 103102) {
            MsglistModel.b(this.a, sVar);
        } else if (sVar.w() == 202003) {
            MsglistModel.c(this.a, sVar);
        } else if (sVar.w() == -113) {
            MsglistModel.k(this.a);
        } else if (sVar.w() == 205004) {
            MsglistModel.d(this.a, sVar);
        } else if (sVar.w() == -126) {
            com.baidu.adp.lib.util.f.e("simon", "onMessage", "msg = " + sVar);
            if (sVar instanceof da) {
                MsglistModel.e(this.a).getChatMessages().add((com.baidu.tieba.im.message.b) ((da) sVar).o());
                MsglistModel.f(this.a).a(MsglistModel.e(this.a));
            }
        }
    }
}
