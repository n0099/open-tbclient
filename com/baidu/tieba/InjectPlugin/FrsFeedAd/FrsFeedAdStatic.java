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
    public static List<c> Y(List<h> list) {
        ArrayList arrayList = new ArrayList();
        for (h hVar : list) {
            c cVar = new c();
            if (hVar instanceof bb) {
                bb bbVar = (bb) hVar;
                if (bbVar.yq() == 1) {
                    cVar.setThreadType(1);
                } else if (bbVar.yq() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.P(hVar);
            } else if (hVar instanceof b) {
                cVar.setThreadType(3);
                cVar.gP(((b) hVar).Sv());
                cVar.P(((b) hVar).Su());
            } else {
                cVar.setThreadType(4);
                cVar.P(hVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<h> Z(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.P(cVar.Su());
                bVar.gP(cVar.Sv());
                arrayList.add(bVar);
            } else if (cVar.Su() instanceof h) {
                arrayList.add((h) cVar.Su());
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
            com.baidu.tieba.InjectPlugin.a.b SB;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (SB = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).SB()) != null && (SB instanceof n)) {
                n nVar = (n) SB;
                com.baidu.tieba.InjectPlugin.a.a gQ = SB.gQ(1);
                if (gQ == null) {
                    com.baidu.tieba.InjectPlugin.a.d gR = e.SA().gR(1);
                    if (gR != null) {
                        gQ = gR.Sz();
                        SB.a(1, gQ);
                        gQ.Q(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = gQ;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.SC() == 1) {
                        List list = (List) bVar.SF();
                        b.X(dVar.Sx());
                        for (BdUniqueId bdUniqueId : b.Sw()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.SC() == 2) {
                        dVar.aa(bVar.SG());
                    } else if (bVar.SC() == 3) {
                        List<h> threadList = bVar.getThreadList();
                        List<c> Y = FrsFeedAdStatic.Y(threadList);
                        if (bVar.SI()) {
                            dVar.a(Y, FrsFeedAdStatic.Y(bVar.SH()), bVar.isRefresh(), bVar.SJ());
                        } else {
                            dVar.g(Y, bVar.SJ());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.Z(Y));
                    } else if (bVar.SC() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.SC() == 5) {
                        dVar.a(FrsFeedAdStatic.Y(bVar.getThreadList()), bVar.getForumId(), bVar.SL(), bVar.SM(), bVar.SN(), bVar.SK(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
