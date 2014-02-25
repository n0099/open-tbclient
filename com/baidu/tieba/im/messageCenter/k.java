package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.coder.CoderException;
import com.baidu.tieba.im.message.da;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.util.cb;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.im.c<l> {
    private LinkedList<s> a = null;
    private com.baidu.tieba.im.coder.d c;
    private p d;

    public k(com.baidu.tieba.im.coder.d dVar, p pVar) {
        this.c = null;
        this.d = null;
        this.c = dVar;
        this.d = pVar;
    }

    private List<s> c() {
        synchronized (k.class) {
            if (this.a == null) {
                this.a = new LinkedList<>();
                this.a.addLast(new da(1003));
            }
        }
        return this.a;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x001f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0019 */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r4v17 */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public l b() {
        CoderException coderException;
        int i;
        com.baidu.tieba.im.coder.d dVar;
        int i2;
        boolean a;
        ?? r0 = 0;
        r0 = 0;
        List<s> list = null;
        r0 = 0;
        l lVar = null;
        r4 = null;
        r4 = null;
        r4 = null;
        com.baidu.tieba.im.coder.d dVar2 = null;
        r4 = null;
        String str = null;
        if (this.c != null) {
            try {
                i2 = this.c.a.e();
                try {
                    int c = this.c.a.c();
                    try {
                        if (c == 1003) {
                            list = c();
                        } else if (this.c.d > 0) {
                            com.baidu.tieba.im.coder.d a2 = com.baidu.tieba.im.coder.c.a().a(this.c);
                            try {
                                list = com.baidu.tieba.im.coder.c.a().a(c, a2.b, a2.c, a2.d);
                                dVar2 = a2;
                            } catch (CoderException e) {
                                coderException = e;
                                dVar = a2;
                                i = c;
                                cb.a("MessageUnPackProcess", i, i2, "cont unpack", coderException.getErrorCode());
                                cb.a(r0, i2, "cont unpack", "unpack error", str, coderException.getErrorCode(), str);
                                com.baidu.adp.lib.util.f.b("IMException code = " + coderException.getErrorCode());
                                list = str;
                                dVar2 = dVar;
                                a = a(list, i2, this.d);
                                a(list, dVar2);
                                lVar = new l(this);
                                lVar.a = list;
                                if (!a) {
                                }
                                return lVar;
                            }
                        } else {
                            list = null;
                        }
                    } catch (CoderException e2) {
                        coderException = e2;
                        dVar = dVar2;
                        i = c;
                        r0 = list;
                        str = dVar2;
                    }
                } catch (CoderException e3) {
                    coderException = e3;
                    dVar = null;
                    i = 0;
                }
            } catch (CoderException e4) {
                coderException = e4;
                i = 0;
                dVar = null;
                i2 = 0;
            }
            a = a(list, i2, this.d);
            a(list, dVar2);
            lVar = new l(this);
            lVar.a = list;
            if (!a) {
                lVar.b = this.d;
            }
        }
        return lVar;
    }

    private boolean a(List<s> list, int i, p pVar) {
        da daVar;
        s sVar;
        if (i != 0) {
            if (list == null || list.size() <= 0 || (sVar = list.get(0)) == null || !(sVar instanceof da)) {
                daVar = null;
            } else {
                daVar = (da) sVar;
                if (pVar != null) {
                    daVar.a(pVar.i());
                }
            }
            if (daVar == null && pVar != null) {
                cb.a(0, 0, "server error", "ack cont responsed", null, 0, null);
                return false;
            }
        }
        return true;
    }

    private void a(List<s> list, com.baidu.tieba.im.coder.d dVar) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                s sVar = list.get(i);
                a a = e.a().a(sVar.w());
                if (a != null) {
                    a.a(sVar, dVar);
                }
            }
        }
    }
}
