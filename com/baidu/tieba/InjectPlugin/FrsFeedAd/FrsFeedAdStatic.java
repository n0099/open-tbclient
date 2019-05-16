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
                cVar.lW(((b) mVar).azj());
                cVar.aj(((b) mVar).azi());
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
                bVar.aj(cVar.azi());
                bVar.lW(cVar.azj());
                arrayList.add(bVar);
            } else if (cVar.azi() instanceof m) {
                arrayList.add((m) cVar.azi());
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
            com.baidu.tieba.InjectPlugin.a.b azp;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (azp = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).azp()) != null && (azp instanceof n)) {
                n nVar = (n) azp;
                com.baidu.tieba.InjectPlugin.a.a lX = azp.lX(1);
                if (lX == null) {
                    com.baidu.tieba.InjectPlugin.a.d lY = e.azo().lY(1);
                    if (lY != null) {
                        lX = lY.azn();
                        azp.a(1, lX);
                        lX.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = lX;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.azq() == 1) {
                        List list = (List) bVar.qy();
                        b.ar(dVar.azl());
                        for (BdUniqueId bdUniqueId : b.azk()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.azq() == 2) {
                        dVar.au(bVar.azt());
                    } else if (bVar.azq() == 3) {
                        List<m> threadList = bVar.getThreadList();
                        List<c> as = FrsFeedAdStatic.as(threadList);
                        if (bVar.azv()) {
                            dVar.a(as, FrsFeedAdStatic.as(bVar.azu()), bVar.isRefresh(), bVar.azw());
                        } else {
                            dVar.f(as, bVar.azw());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.at(as));
                    } else if (bVar.azq() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.azq() == 5) {
                        dVar.a(FrsFeedAdStatic.as(bVar.getThreadList()), bVar.getForumId(), bVar.azy(), bVar.azz(), bVar.azA(), bVar.azx(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
