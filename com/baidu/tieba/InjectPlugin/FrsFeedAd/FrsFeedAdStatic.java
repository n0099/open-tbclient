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
    public static List<c> X(List<h> list) {
        ArrayList arrayList = new ArrayList();
        for (h hVar : list) {
            c cVar = new c();
            if (hVar instanceof bb) {
                bb bbVar = (bb) hVar;
                if (bbVar.yx() == 1) {
                    cVar.setThreadType(1);
                } else if (bbVar.yx() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.P(hVar);
            } else if (hVar instanceof b) {
                cVar.setThreadType(3);
                cVar.hd(((b) hVar).SE());
                cVar.P(((b) hVar).SD());
            } else {
                cVar.setThreadType(4);
                cVar.P(hVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<h> Y(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.P(cVar.SD());
                bVar.hd(cVar.SE());
                arrayList.add(bVar);
            } else if (cVar.SD() instanceof h) {
                arrayList.add((h) cVar.SD());
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
            com.baidu.tieba.InjectPlugin.a.b SK;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (SK = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).SK()) != null && (SK instanceof n)) {
                n nVar = (n) SK;
                com.baidu.tieba.InjectPlugin.a.a he = SK.he(1);
                if (he == null) {
                    com.baidu.tieba.InjectPlugin.a.d hf = e.SJ().hf(1);
                    if (hf != null) {
                        he = hf.SI();
                        SK.a(1, he);
                        he.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = he;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.SL() == 1) {
                        List list = (List) bVar.SO();
                        b.W(dVar.SG());
                        for (BdUniqueId bdUniqueId : b.SF()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.SL() == 2) {
                        dVar.Z(bVar.SP());
                    } else if (bVar.SL() == 3) {
                        List<h> threadList = bVar.getThreadList();
                        List<c> X = FrsFeedAdStatic.X(threadList);
                        if (bVar.SR()) {
                            dVar.a(X, FrsFeedAdStatic.X(bVar.SQ()), bVar.isRefresh(), bVar.SS());
                        } else {
                            dVar.g(X, bVar.SS());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.Y(X));
                    } else if (bVar.SL() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.SL() == 5) {
                        dVar.a(FrsFeedAdStatic.X(bVar.getThreadList()), bVar.getForumId(), bVar.SU(), bVar.SV(), bVar.SW(), bVar.ST(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
