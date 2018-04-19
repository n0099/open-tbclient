package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bd;
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
    public static List<c> L(List<h> list) {
        ArrayList arrayList = new ArrayList();
        for (h hVar : list) {
            c cVar = new c();
            if (hVar instanceof bd) {
                bd bdVar = (bd) hVar;
                if (bdVar.rL() == 1) {
                    cVar.setThreadType(1);
                } else if (bdVar.rL() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.F(hVar);
            } else if (hVar instanceof b) {
                cVar.setThreadType(3);
                cVar.fZ(((b) hVar).KM());
                cVar.F(((b) hVar).KL());
            } else {
                cVar.setThreadType(4);
                cVar.F(hVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<h> M(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.F(cVar.KL());
                bVar.fZ(cVar.KM());
                arrayList.add(bVar);
            } else if (cVar.KL() instanceof h) {
                arrayList.add((h) cVar.KL());
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
            com.baidu.tieba.InjectPlugin.a.b KS;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (KS = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).KS()) != null && (KS instanceof n)) {
                n nVar = (n) KS;
                com.baidu.tieba.InjectPlugin.a.a ga = KS.ga(1);
                if (ga == null) {
                    com.baidu.tieba.InjectPlugin.a.d gb = e.KR().gb(1);
                    if (gb != null) {
                        ga = gb.KQ();
                        KS.a(1, ga);
                        ga.G(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = ga;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.KT() == 1) {
                        List list = (List) bVar.KW();
                        b.K(dVar.KO());
                        for (BdUniqueId bdUniqueId : b.KN()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.aeY());
                            list.add(aVar2);
                        }
                    } else if (bVar.KT() == 2) {
                        dVar.N(bVar.KX());
                    } else if (bVar.KT() == 3) {
                        List<h> threadList = bVar.getThreadList();
                        List<c> L = FrsFeedAdStatic.L(threadList);
                        if (bVar.KZ()) {
                            dVar.a(L, FrsFeedAdStatic.L(bVar.KY()), bVar.isRefresh(), bVar.La());
                        } else {
                            dVar.f(L, bVar.La());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.M(L));
                    } else if (bVar.KT() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.KT() == 5) {
                        dVar.a(FrsFeedAdStatic.L(bVar.getThreadList()), bVar.getForumId(), bVar.Lc(), bVar.Ld(), bVar.Le(), bVar.Lb(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
