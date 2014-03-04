package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ai implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ q a;

    private ai(q qVar) {
        this.a = qVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ai(q qVar, byte b) {
        this(qVar);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar == null) {
            com.baidu.adp.lib.util.e.b("msg == null");
        } else if (sVar.v() == 205001) {
            b(sVar);
            q.a(this.a, sVar);
        } else if (sVar.v() == 202001) {
            b(sVar);
            q.b(this.a, sVar);
        } else if (sVar.v() == -103) {
            if (sVar instanceof com.baidu.tieba.im.message.p) {
                this.a.a(sVar);
            }
        } else if (sVar.v() == -105) {
            if (sVar instanceof com.baidu.tieba.im.message.r) {
                this.a.a(sVar);
            }
        } else {
            com.baidu.adp.lib.util.e.b("convert error need GroupMsgData");
        }
    }

    private static void b(com.baidu.tieba.im.message.s sVar) {
        if (sVar instanceof com.baidu.tieba.im.message.da) {
            com.baidu.tieba.im.message.da daVar = (com.baidu.tieba.im.message.da) sVar;
            com.baidu.tieba.im.message.s o = daVar.o();
            if (o instanceof com.baidu.tieba.im.message.b) {
                com.baidu.tieba.im.message.b bVar = (com.baidu.tieba.im.message.b) o;
                long b = bVar.b();
                if (b != 0) {
                    com.baidu.tieba.util.cb.a(0, System.currentTimeMillis() - b, bVar.i(), daVar.m(), daVar.n());
                }
            }
        }
    }
}
