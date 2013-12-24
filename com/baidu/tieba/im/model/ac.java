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
    public void a(com.baidu.tieba.im.message.n nVar) {
        if (nVar == null) {
            com.baidu.adp.lib.h.e.a("msg == null");
        } else if (nVar.t() == 103112) {
            this.a.b(nVar);
        } else if (nVar.t() == 103102) {
            this.a.d(nVar);
        } else if (nVar.t() == 202003) {
            this.a.c(nVar);
        } else if (nVar.t() == -113) {
            this.a.p();
        } else if (nVar.t() == 205004) {
            this.a.a(nVar);
        }
    }
}
