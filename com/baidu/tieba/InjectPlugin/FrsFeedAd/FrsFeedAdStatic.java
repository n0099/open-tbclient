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
                if (bdVar.rK() == 1) {
                    cVar.setThreadType(1);
                } else if (bdVar.rK() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.F(hVar);
            } else if (hVar instanceof b) {
                cVar.setThreadType(3);
                cVar.ga(((b) hVar).KK());
                cVar.F(((b) hVar).KJ());
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
                bVar.F(cVar.KJ());
                bVar.ga(cVar.KK());
                arrayList.add(bVar);
            } else if (cVar.KJ() instanceof h) {
                arrayList.add((h) cVar.KJ());
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
            com.baidu.tieba.InjectPlugin.a.b KQ;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (KQ = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).KQ()) != null && (KQ instanceof n)) {
                n nVar = (n) KQ;
                com.baidu.tieba.InjectPlugin.a.a gb = KQ.gb(1);
                if (gb == null) {
                    com.baidu.tieba.InjectPlugin.a.d gc = e.KP().gc(1);
                    if (gc != null) {
                        gb = gc.KO();
                        KQ.a(1, gb);
                        gb.G(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = gb;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.KR() == 1) {
                        List list = (List) bVar.KU();
                        b.K(dVar.KM());
                        for (BdUniqueId bdUniqueId : b.KL()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.aeY());
                            list.add(aVar2);
                        }
                    } else if (bVar.KR() == 2) {
                        dVar.N(bVar.KV());
                    } else if (bVar.KR() == 3) {
                        List<h> threadList = bVar.getThreadList();
                        List<c> L = FrsFeedAdStatic.L(threadList);
                        if (bVar.KX()) {
                            dVar.a(L, FrsFeedAdStatic.L(bVar.KW()), bVar.isRefresh(), bVar.KY());
                        } else {
                            dVar.f(L, bVar.KY());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.M(L));
                    } else if (bVar.KR() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.KR() == 5) {
                        dVar.a(FrsFeedAdStatic.L(bVar.getThreadList()), bVar.getForumId(), bVar.La(), bVar.Lb(), bVar.Lc(), bVar.KZ(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
