package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.InjectPlugin.a.e;
import com.baidu.tieba.recapp.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsFeedAdStatic {
    static {
        MessageManager.getInstance().registerListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> as(List<m> list) {
        ArrayList arrayList = new ArrayList();
        for (m mVar : list) {
            c cVar = new c();
            if (mVar instanceof bg) {
                bg bgVar = (bg) mVar;
                if (bgVar.aes() == 1) {
                    cVar.setThreadType(1);
                } else if (bgVar.aes() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.aj(mVar);
            } else if (mVar instanceof b) {
                cVar.setThreadType(3);
                cVar.md(((b) mVar).aAy());
                cVar.aj(((b) mVar).aAx());
            } else {
                cVar.setThreadType(4);
                cVar.aj(mVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<m> at(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.aj(cVar.aAx());
                bVar.md(cVar.aAy());
                arrayList.add(bVar);
            } else if (cVar.aAx() instanceof m) {
                arrayList.add((m) cVar.aAx());
            }
        }
        return arrayList;
    }

    /* loaded from: classes3.dex */
    static final class a extends CustomMessageListener {
        public a() {
            super(2016515);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.InjectPlugin.b.b bVar;
            com.baidu.tieba.InjectPlugin.a.b aAE;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (aAE = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).aAE()) != null && (aAE instanceof n)) {
                n nVar = (n) aAE;
                com.baidu.tieba.InjectPlugin.a.a me = aAE.me(1);
                if (me == null) {
                    com.baidu.tieba.InjectPlugin.a.d mf = e.aAD().mf(1);
                    if (mf != null) {
                        me = mf.aAC();
                        aAE.a(1, me);
                        me.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = me;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.aAF() == 1) {
                        List list = (List) bVar.qV();
                        b.ar(dVar.aAA());
                        for (BdUniqueId bdUniqueId : b.aAz()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.aAF() == 2) {
                        dVar.au(bVar.aAI());
                    } else if (bVar.aAF() == 3) {
                        List<m> threadList = bVar.getThreadList();
                        List<c> as = FrsFeedAdStatic.as(threadList);
                        if (bVar.aAK()) {
                            dVar.a(as, FrsFeedAdStatic.as(bVar.aAJ()), bVar.isRefresh(), bVar.aAL());
                        } else {
                            dVar.f(as, bVar.aAL());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.at(as));
                    } else if (bVar.aAF() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.aAF() == 5) {
                        dVar.a(FrsFeedAdStatic.as(bVar.getThreadList()), bVar.getForumId(), bVar.aAN(), bVar.aAO(), bVar.aAP(), bVar.aAM(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
