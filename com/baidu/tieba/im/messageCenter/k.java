package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.coder.CoderException;
import com.baidu.tieba.im.message.da;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.util.cb;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.im.b<l> {
    private LinkedList<s> a = null;
    private com.baidu.tieba.im.coder.d c;
    private p d;

    public k(com.baidu.tieba.im.coder.d dVar, p pVar) {
        this.c = null;
        this.d = null;
        this.c = dVar;
        this.d = pVar;
    }

    private List<s> b() {
        synchronized (k.class) {
            if (this.a == null) {
                this.a = new LinkedList<>();
                this.a.addLast(new da(1003));
            }
        }
        return this.a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
    @Override // com.baidu.tieba.im.b
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public l a() {
        CoderException coderException;
        int i;
        com.baidu.tieba.im.coder.d dVar;
        int i2;
        List<s> list;
        da daVar;
        s sVar;
        l lVar = null;
        boolean z = false;
        if (this.c != null) {
            try {
                i2 = this.c.a.e();
                try {
                    int c = this.c.a.c();
                    try {
                        if (c == 1003) {
                            dVar = null;
                            list = b();
                        } else if (this.c.d > 0) {
                            com.baidu.tieba.im.coder.d a = com.baidu.tieba.im.coder.c.a().a(this.c);
                            try {
                                dVar = a;
                                list = com.baidu.tieba.im.coder.c.a().a(c, a.b, a.c, a.d);
                            } catch (CoderException e) {
                                coderException = e;
                                dVar = a;
                                i = c;
                                cb.a("MessageUnPackProcess", i, i2, "cont unpack", coderException.getErrorCode());
                                cb.a(0, i2, "cont unpack", "unpack error", null, coderException.getErrorCode(), null);
                                com.baidu.adp.lib.util.e.b("IMException code = " + coderException.getErrorCode());
                                list = null;
                                p pVar = this.d;
                                if (i2 != 0) {
                                }
                                z = true;
                                a(list, dVar);
                                lVar = new l(this);
                                lVar.a = list;
                                if (!z) {
                                }
                                return lVar;
                            }
                        } else {
                            dVar = null;
                            list = null;
                        }
                    } catch (CoderException e2) {
                        coderException = e2;
                        dVar = null;
                        i = c;
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
            p pVar2 = this.d;
            if (i2 != 0) {
                if (list == null || list.size() <= 0 || (sVar = list.get(0)) == null || !(sVar instanceof da)) {
                    daVar = null;
                } else {
                    daVar = (da) sVar;
                    if (pVar2 != null) {
                        daVar.a(pVar2.i());
                    }
                }
                if (daVar == null && pVar2 != null) {
                    cb.a(0, 0, "server error", "ack cont responsed", null, 0, null);
                    a(list, dVar);
                    lVar = new l(this);
                    lVar.a = list;
                    if (!z) {
                        lVar.b = this.d;
                    }
                }
            }
            z = true;
            a(list, dVar);
            lVar = new l(this);
            lVar.a = list;
            if (!z) {
            }
        }
        return lVar;
    }

    private static void a(List<s> list, com.baidu.tieba.im.coder.d dVar) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                s sVar = list.get(i);
                a a = d.a().a(sVar.w());
                if (a != null) {
                    a.a(sVar, dVar);
                }
            }
        }
    }
}
