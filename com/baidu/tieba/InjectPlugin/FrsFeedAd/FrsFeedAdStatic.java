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
                if (bgVar.adq() == 1) {
                    cVar.setThreadType(1);
                } else if (bgVar.adq() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.aj(mVar);
            } else if (mVar instanceof b) {
                cVar.setThreadType(3);
                cVar.lW(((b) mVar).azk());
                cVar.aj(((b) mVar).azj());
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
                bVar.aj(cVar.azj());
                bVar.lW(cVar.azk());
                arrayList.add(bVar);
            } else if (cVar.azj() instanceof m) {
                arrayList.add((m) cVar.azj());
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
            com.baidu.tieba.InjectPlugin.a.b azq;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (azq = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).azq()) != null && (azq instanceof n)) {
                n nVar = (n) azq;
                com.baidu.tieba.InjectPlugin.a.a lX = azq.lX(1);
                if (lX == null) {
                    com.baidu.tieba.InjectPlugin.a.d lY = e.azp().lY(1);
                    if (lY != null) {
                        lX = lY.azo();
                        azq.a(1, lX);
                        lX.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = lX;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.azr() == 1) {
                        List list = (List) bVar.qy();
                        b.ar(dVar.azm());
                        for (BdUniqueId bdUniqueId : b.azl()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.azr() == 2) {
                        dVar.au(bVar.azu());
                    } else if (bVar.azr() == 3) {
                        List<m> threadList = bVar.getThreadList();
                        List<c> as = FrsFeedAdStatic.as(threadList);
                        if (bVar.azw()) {
                            dVar.a(as, FrsFeedAdStatic.as(bVar.azv()), bVar.isRefresh(), bVar.azx());
                        } else {
                            dVar.f(as, bVar.azx());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.at(as));
                    } else if (bVar.azr() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.azr() == 5) {
                        dVar.a(FrsFeedAdStatic.as(bVar.getThreadList()), bVar.getForumId(), bVar.azz(), bVar.azA(), bVar.azB(), bVar.azy(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
