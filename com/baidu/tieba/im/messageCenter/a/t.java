package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.am;
import com.baidu.tieba.im.message.bv;
import com.baidu.tieba.im.message.bz;
import java.util.List;
/* loaded from: classes.dex */
public class t extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public bz a(com.baidu.tieba.im.message.n nVar) {
        if (nVar == null || !(nVar instanceof am)) {
            return null;
        }
        List<com.baidu.adp.lib.cache.t<String>> a = com.baidu.adp.lib.h.j.a(com.baidu.tieba.b.a.a().h());
        bv bvVar = new bv();
        bvVar.e(-202);
        bvVar.a(nVar);
        bvVar.b(a);
        return bvVar;
    }
}
