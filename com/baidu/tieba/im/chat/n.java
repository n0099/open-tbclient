package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ a a;

    private n(a aVar) {
        this.a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(a aVar, b bVar) {
        this(aVar);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.n nVar) {
        if (nVar == null) {
            com.baidu.adp.lib.h.e.a("msg == null");
        } else if (nVar.t() == -100) {
            this.a.a(nVar);
        } else if (nVar.t() == 205001) {
            this.a.c(nVar);
        } else if (nVar.t() == 202001) {
            this.a.b(nVar);
        } else if (nVar.t() == -103) {
            if (nVar instanceof com.baidu.tieba.im.message.k) {
                this.a.d(nVar);
            }
        } else if (nVar.t() == -105) {
            if (nVar instanceof com.baidu.tieba.im.message.m) {
                this.a.d(nVar);
            }
        } else {
            com.baidu.adp.lib.h.e.a("convert error need GroupMsgData");
        }
    }
}
