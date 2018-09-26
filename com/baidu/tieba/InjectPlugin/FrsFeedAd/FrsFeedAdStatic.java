package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bb;
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
    public static List<c> P(List<h> list) {
        ArrayList arrayList = new ArrayList();
        for (h hVar : list) {
            c cVar = new c();
            if (hVar instanceof bb) {
                bb bbVar = (bb) hVar;
                if (bbVar.wh() == 1) {
                    cVar.setThreadType(1);
                } else if (bbVar.wh() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.L(hVar);
            } else if (hVar instanceof b) {
                cVar.setThreadType(3);
                cVar.gH(((b) hVar).QB());
                cVar.L(((b) hVar).QA());
            } else {
                cVar.setThreadType(4);
                cVar.L(hVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<h> Q(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.L(cVar.QA());
                bVar.gH(cVar.QB());
                arrayList.add(bVar);
            } else if (cVar.QA() instanceof h) {
                arrayList.add((h) cVar.QA());
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
            com.baidu.tieba.InjectPlugin.a.b QH;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (QH = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).QH()) != null && (QH instanceof n)) {
                n nVar = (n) QH;
                com.baidu.tieba.InjectPlugin.a.a gI = QH.gI(1);
                if (gI == null) {
                    com.baidu.tieba.InjectPlugin.a.d gJ = e.QG().gJ(1);
                    if (gJ != null) {
                        gI = gJ.QF();
                        QH.a(1, gI);
                        gI.M(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = gI;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.QI() == 1) {
                        List list = (List) bVar.QL();
                        b.O(dVar.QD());
                        for (BdUniqueId bdUniqueId : b.QC()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.QI() == 2) {
                        dVar.R(bVar.QM());
                    } else if (bVar.QI() == 3) {
                        List<h> threadList = bVar.getThreadList();
                        List<c> P = FrsFeedAdStatic.P(threadList);
                        if (bVar.QO()) {
                            dVar.a(P, FrsFeedAdStatic.P(bVar.QN()), bVar.isRefresh(), bVar.QP());
                        } else {
                            dVar.g(P, bVar.QP());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.Q(P));
                    } else if (bVar.QI() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.QI() == 5) {
                        dVar.a(FrsFeedAdStatic.P(bVar.getThreadList()), bVar.getForumId(), bVar.QR(), bVar.QS(), bVar.QT(), bVar.QQ(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
