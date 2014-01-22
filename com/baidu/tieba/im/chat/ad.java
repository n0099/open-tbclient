package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ q a;

    private ad(q qVar) {
        this.a = qVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ad(q qVar, r rVar) {
        this(qVar);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        if (qVar == null) {
            com.baidu.adp.lib.g.e.a("msg == null");
        } else if (qVar.w() == -100) {
            this.a.a(qVar);
        } else if (qVar.w() == 205001) {
            b(qVar);
            this.a.c(qVar);
        } else if (qVar.w() == 202001) {
            b(qVar);
            this.a.b(qVar);
        } else if (qVar.w() == -103) {
            if (qVar instanceof com.baidu.tieba.im.message.n) {
                this.a.d(qVar);
            }
        } else if (qVar.w() == -105) {
            if (qVar instanceof com.baidu.tieba.im.message.p) {
                this.a.d(qVar);
            }
        } else {
            com.baidu.adp.lib.g.e.a("convert error need GroupMsgData");
        }
    }

    private void b(com.baidu.tieba.im.message.q qVar) {
        if (qVar instanceof com.baidu.tieba.im.message.cr) {
            com.baidu.tieba.im.message.q n = ((com.baidu.tieba.im.message.cr) qVar).n();
            if (n instanceof com.baidu.tieba.im.message.b) {
                long b = ((com.baidu.tieba.im.message.b) n).b();
                if (b != 0) {
                    com.baidu.tieba.util.by.a(qVar.v(), System.currentTimeMillis() - b);
                }
            }
        }
    }
}
