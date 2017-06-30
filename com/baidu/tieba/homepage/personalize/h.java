package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ThreadInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ e cIE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(e eVar, int i) {
        super(i);
        this.cIE = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        com.baidu.tieba.homepage.personalize.b.af afVar;
        List list6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            if (!StringUtils.isNull(str)) {
                list = this.cIE.bZo;
                if (!com.baidu.tbadk.core.util.z.t(list)) {
                    list2 = this.cIE.cIB;
                    if (!com.baidu.tbadk.core.util.z.t(list2)) {
                        list3 = this.cIE.bZo;
                        Iterator it = list3.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) it.next();
                            if (vVar instanceof com.baidu.tieba.card.data.c) {
                                com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) vVar;
                                if (cVar.Mv() != null && cVar.Mv().getTid() != null && cVar.Mv().getTid().equals(str)) {
                                    it.remove();
                                    list5 = this.cIE.bZo;
                                    com.baidu.tieba.homepage.personalize.model.c.bi(list5);
                                    afVar = this.cIE.cIz;
                                    list6 = this.cIE.bZo;
                                    afVar.bg(new ArrayList(list6));
                                    break;
                                }
                            }
                        }
                        long c = com.baidu.adp.lib.g.b.c(str, 0L);
                        list4 = this.cIE.cIB;
                        Iterator it2 = list4.iterator();
                        while (it2.hasNext()) {
                            ThreadInfo threadInfo = (ThreadInfo) it2.next();
                            if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                                it2.remove();
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}
