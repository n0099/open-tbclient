package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.data.BaseGroupData;
import com.baidu.tieba.im.message.am;
import com.baidu.tieba.im.message.bv;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.n a(com.baidu.tieba.im.message.n nVar, com.baidu.tieba.im.coder.d dVar) {
        if (nVar == null || !(nVar instanceof bv)) {
            return null;
        }
        bv bvVar = (bv) nVar;
        com.baidu.tieba.im.message.n l = bvVar.l();
        if (l != null && (l instanceof am) && !bvVar.i()) {
            String str = ((am) l).b() + "";
            com.baidu.adp.lib.cache.s<String> h = com.baidu.tieba.b.a.a().h();
            List<BaseGroupData> a = bvVar.a();
            if (a != null) {
                Iterator<BaseGroupData> it = a.iterator();
                while (it.hasNext()) {
                    h.a(str, it.next().getName() + "(" + str + ")");
                }
                return nVar;
            }
            return nVar;
        }
        return nVar;
    }
}
