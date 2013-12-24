package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.coder.CoderException;
import com.baidu.tieba.im.message.bz;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends SingleRunnable<m> {
    private LinkedList<com.baidu.tieba.im.message.n> a = null;
    private com.baidu.tieba.im.coder.d b;
    private p c;

    public l(com.baidu.tieba.im.coder.d dVar, p pVar) {
        this.b = null;
        this.c = null;
        this.b = dVar;
        this.c = pVar;
    }

    private List<com.baidu.tieba.im.message.n> c() {
        if (this.a == null) {
            synchronized (l.class) {
                if (this.a == null) {
                    this.a = new LinkedList<>();
                    this.a.addLast(new bz(1003));
                }
            }
        }
        return this.a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public m b() {
        CoderException coderException;
        int i;
        com.baidu.tieba.im.coder.d dVar;
        int i2;
        List<com.baidu.tieba.im.message.n> list;
        boolean a;
        List<com.baidu.tieba.im.message.n> list2;
        m mVar = null;
        r4 = null;
        com.baidu.tieba.im.coder.d dVar2 = null;
        if (this.b != null) {
            try {
                int e = this.b.a.e();
                try {
                    int c = this.b.a.c();
                    if (c == 1003) {
                        list2 = c();
                    } else if (this.b.d > 0) {
                        com.baidu.tieba.im.coder.d a2 = com.baidu.tieba.im.coder.c.a().a(this.b);
                        try {
                            list2 = com.baidu.tieba.im.coder.c.a().a(c, a2.b, a2.c, a2.d);
                            dVar2 = a2;
                        } catch (CoderException e2) {
                            coderException = e2;
                            i = e;
                            dVar = a2;
                            com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(0, 0, "cont unpack", "unpack error", null, coderException.getErrorCode(), null));
                            com.baidu.adp.lib.h.e.a("IMException code = " + coderException.getErrorCode());
                            i2 = i;
                            list = null;
                            dVar2 = dVar;
                            a = a(list, i2, this.c);
                            a(list, dVar2);
                            mVar = new m(this);
                            mVar.a = list;
                            if (!a) {
                            }
                            return mVar;
                        }
                    } else {
                        list2 = null;
                    }
                    list = list2;
                    i2 = e;
                } catch (CoderException e3) {
                    coderException = e3;
                    i = e;
                    dVar = null;
                }
            } catch (CoderException e4) {
                coderException = e4;
                i = 0;
                dVar = null;
            }
            a = a(list, i2, this.c);
            a(list, dVar2);
            mVar = new m(this);
            mVar.a = list;
            if (!a) {
                mVar.b = this.c;
            }
        }
        return mVar;
    }

    private boolean a(List<com.baidu.tieba.im.message.n> list, int i, p pVar) {
        bz bzVar;
        com.baidu.tieba.im.message.n nVar;
        if (i != 0) {
            if (list == null || list.size() <= 0 || (nVar = list.get(0)) == null || !(nVar instanceof bz)) {
                bzVar = null;
            } else {
                bzVar = (bz) nVar;
                if (pVar != null) {
                    bzVar.a(pVar.j());
                }
            }
            if (bzVar == null && pVar != null) {
                com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(0, 0, "server error", "ack cont responsed", null, 0, null));
                return false;
            }
        }
        return true;
    }

    private void a(List<com.baidu.tieba.im.message.n> list, com.baidu.tieba.im.coder.d dVar) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.im.message.n nVar = list.get(i);
                a a = e.a().a(nVar.t());
                if (a != null) {
                    a.a(nVar, dVar);
                }
            }
        }
    }
}
