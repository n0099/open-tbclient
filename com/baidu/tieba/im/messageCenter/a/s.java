package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.am;
import com.baidu.tieba.im.message.bv;
import com.baidu.tieba.im.message.bz;
/* loaded from: classes.dex */
public class s extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public bz a(com.baidu.tieba.im.message.n nVar) {
        if (nVar == null || !(nVar instanceof am)) {
            return null;
        }
        com.baidu.tieba.b.a.a().i();
        bv bvVar = new bv();
        bvVar.e(-203);
        bvVar.a(nVar);
        bvVar.c(0);
        return bvVar;
    }
}
