package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.framework.task.a<com.baidu.tieba.im.message.m> {
    private com.baidu.tieba.im.db.c a = com.baidu.tieba.im.db.c.a();
    private int b = 2001149;

    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<com.baidu.tieba.im.message.m> aVar) {
        if (aVar == null || !(aVar instanceof com.baidu.tieba.im.message.l)) {
            com.baidu.adp.lib.util.f.b("message error");
            return a(this.b);
        } else if (this.a == null) {
            return a(this.b);
        } else {
            com.baidu.tieba.im.message.m a = aVar.a();
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(this.b);
            LinkedList<com.baidu.tieba.im.message.a.a> a2 = this.a.a(a.d, a.a, a.b, a.c);
            if (a2 == null) {
                com.baidu.adp.lib.util.f.b("read DB error");
                return a(this.b);
            }
            com.baidu.tieba.im.message.n nVar = new com.baidu.tieba.im.message.n();
            if (a.a == null) {
                nVar.c = true;
            } else {
                nVar.c = false;
            }
            nVar.b = a2;
            nVar.a = a.d;
            try {
                loadHistoryResponsedMessage.a(2001105, nVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return loadHistoryResponsedMessage;
        }
    }

    private static LoadHistoryResponsedMessage a(int i) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i);
        loadHistoryResponsedMessage.a(-18);
        return loadHistoryResponsedMessage;
    }
}
