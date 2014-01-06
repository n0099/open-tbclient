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
    public void a(com.baidu.tieba.im.message.o oVar) {
        if (oVar == null) {
            com.baidu.adp.lib.h.e.a("msg == null");
        } else if (oVar.u() == -100) {
            this.a.a(oVar);
        } else if (oVar.u() == 205001) {
            this.a.c(oVar);
        } else if (oVar.u() == 202001) {
            this.a.b(oVar);
        } else if (oVar.u() == -103) {
            if (oVar instanceof com.baidu.tieba.im.message.l) {
                this.a.d(oVar);
            }
        } else if (oVar.u() == -105) {
            if (oVar instanceof com.baidu.tieba.im.message.n) {
                this.a.d(oVar);
            }
        } else {
            com.baidu.adp.lib.h.e.a("convert error need GroupMsgData");
        }
    }
}
