package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.coder.CoderException;
import com.baidu.tieba.im.message.cr;
import com.baidu.tieba.util.by;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends SingleRunnable<m> {
    private LinkedList<com.baidu.tieba.im.message.q> a = null;
    private com.baidu.tieba.im.coder.d b;
    private p c;

    public l(com.baidu.tieba.im.coder.d dVar, p pVar) {
        this.b = null;
        this.c = null;
        this.b = dVar;
        this.c = pVar;
    }

    private List<com.baidu.tieba.im.message.q> c() {
        synchronized (l.class) {
            if (this.a == null) {
                this.a = new LinkedList<>();
                this.a.addLast(new cr(1003));
            }
        }
        return this.a;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0019 */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r4v18 */
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
        List<com.baidu.tieba.im.message.q> list;
        com.baidu.tieba.im.coder.d dVar2;
        boolean a;
        ?? r0 = 0;
        r0 = 0;
        List<com.baidu.tieba.im.message.q> list2 = null;
        r0 = 0;
        m mVar = null;
        r4 = null;
        r4 = null;
        r4 = null;
        com.baidu.tieba.im.coder.d dVar3 = null;
        r4 = null;
        String str = null;
        if (this.b != null) {
            try {
                int e = this.b.a.e();
                try {
                    int c = this.b.a.c();
                    try {
                        if (c == 1003) {
                            list2 = c();
                        } else if (this.b.d > 0) {
                            com.baidu.tieba.im.coder.d a2 = com.baidu.tieba.im.coder.c.a().a(this.b);
                            try {
                                list2 = com.baidu.tieba.im.coder.c.a().a(c, a2.b, a2.c, a2.d);
                                dVar3 = a2;
                            } catch (CoderException e2) {
                                coderException = e2;
                                dVar = a2;
                                i2 = e;
                                i = c;
                                by.a("MessageUnPackProcess", i, i2, "cont unpack", coderException.getErrorCode());
                                by.a(r0, i2, "cont unpack", "unpack error", str, coderException.getErrorCode(), str);
                                com.baidu.adp.lib.g.e.a("IMException code = " + coderException.getErrorCode());
                                list = str;
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
                        i2 = e;
                        list = list2;
                        dVar2 = dVar3;
                    } catch (CoderException e3) {
                        coderException = e3;
                        dVar = dVar3;
                        i2 = e;
                        i = c;
                        r0 = list2;
                        str = dVar3;
                    }
                } catch (CoderException e4) {
                    coderException = e4;
                    dVar = null;
                    i2 = e;
                    i = 0;
                }
            } catch (CoderException e5) {
                coderException = e5;
                i = 0;
                dVar = null;
                i2 = 0;
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

    private boolean a(List<com.baidu.tieba.im.message.q> list, int i, p pVar) {
        cr crVar;
        com.baidu.tieba.im.message.q qVar;
        if (i != 0) {
            if (list == null || list.size() <= 0 || (qVar = list.get(0)) == null || !(qVar instanceof cr)) {
                crVar = null;
            } else {
                crVar = (cr) qVar;
                if (pVar != null) {
                    crVar.a(pVar.j());
                }
            }
            if (crVar == null && pVar != null) {
                by.a(0, 0, "server error", "ack cont responsed", null, 0, null);
                return false;
            }
        }
        return true;
    }

    private void a(List<com.baidu.tieba.im.message.q> list, com.baidu.tieba.im.coder.d dVar) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.im.message.q qVar = list.get(i);
                a a = e.a().a(qVar.w());
                if (a != null) {
                    a.a(qVar, dVar);
                }
            }
        }
    }
}
