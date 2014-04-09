package com.baidu.tieba.im.c;

import android.util.SparseArray;
import com.baidu.adp.framework.b.n;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.message.s;
/* loaded from: classes.dex */
public final class k extends n {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.d, com.baidu.adp.framework.task.b] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.d' to match base method */
    @Override // com.baidu.adp.framework.b.h
    public final /* synthetic */ com.baidu.adp.framework.message.g a(com.baidu.adp.framework.message.g gVar, SocketMessageTask socketMessageTask) {
        com.baidu.adp.framework.message.g gVar2 = gVar;
        StringBuilder sb = new StringBuilder(200);
        if (gVar2 instanceof s) {
            SparseArray<Long> i = ((s) gVar2).i();
            for (int i2 = 0; i2 < i.size(); i2++) {
                sb.append(i.keyAt(i2));
                sb.append("-");
                sb.append(i.valueAt(i2));
                sb.append("|");
            }
            TiebaStatic.a(202003, ((s) gVar2).k(), ((s) gVar2).j() ? "active" : "passive", "MessageSync-send-pullmsg", "succ", 0, "", 0L, 0, sb.toString());
            com.baidu.adp.lib.util.f.e(sb.toString());
        }
        return gVar2;
    }

    public k() {
        super(202003);
    }
}
