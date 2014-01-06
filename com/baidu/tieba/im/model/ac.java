package com.baidu.tieba.im.model;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MsglistModel a;

    private ac(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ac(MsglistModel msglistModel, n nVar) {
        this(msglistModel);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.o oVar) {
        if (oVar == null) {
            com.baidu.adp.lib.h.e.a("msg == null");
        } else if (oVar.u() == 103112) {
            this.a.b(oVar);
        } else if (oVar.u() == 103102) {
            this.a.d(oVar);
        } else if (oVar.u() == 202003) {
            this.a.c(oVar);
        } else if (oVar.u() == -113) {
            this.a.p();
        } else if (oVar.u() == 205004) {
            this.a.a(oVar);
        }
    }
}
