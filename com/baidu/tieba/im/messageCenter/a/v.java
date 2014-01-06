package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.data.BaseGroupData;
import com.baidu.tieba.im.message.ap;
import com.baidu.tieba.im.message.by;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.o a(com.baidu.tieba.im.message.o oVar, com.baidu.tieba.im.coder.d dVar) {
        if (oVar == null || !(oVar instanceof by)) {
            return null;
        }
        by byVar = (by) oVar;
        com.baidu.tieba.im.message.o l = byVar.l();
        if (l != null && (l instanceof ap) && !byVar.i()) {
            String str = ((ap) l).b() + "";
            com.baidu.adp.lib.cache.s<String> h = com.baidu.tieba.b.a.a().h();
            List<BaseGroupData> a = byVar.a();
            if (a != null) {
                Iterator<BaseGroupData> it = a.iterator();
                while (it.hasNext()) {
                    h.a(str, it.next().getName() + "(" + str + ")");
                }
                return oVar;
            }
            return oVar;
        }
        return oVar;
    }
}
