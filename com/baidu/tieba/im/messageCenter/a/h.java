package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.ag;
import com.baidu.tieba.im.message.bp;
import com.baidu.tieba.im.message.cr;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cr a(com.baidu.tieba.im.message.q qVar) {
        if (qVar == null || !(qVar instanceof ag)) {
            return null;
        }
        ag agVar = (ag) qVar;
        cr a = l.a(103002, com.baidu.tieba.b.a.a().e().a("pb_" + agVar.e() + "_" + agVar.d()));
        if (a == null) {
            a = new bp();
        }
        a.e(-201);
        a.a(qVar);
        return a;
    }
}
