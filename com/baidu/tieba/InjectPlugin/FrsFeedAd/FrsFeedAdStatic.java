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
                if (bbVar.zB() == 1) {
                    cVar.setThreadType(1);
                } else if (bbVar.zB() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.P(hVar);
            } else if (hVar instanceof b) {
                cVar.setThreadType(3);
                cVar.hr(((b) hVar).TK());
                cVar.P(((b) hVar).TJ());
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
                bVar.P(cVar.TJ());
                bVar.hr(cVar.TK());
                arrayList.add(bVar);
            } else if (cVar.TJ() instanceof h) {
                arrayList.add((h) cVar.TJ());
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
            com.baidu.tieba.InjectPlugin.a.b TQ;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (TQ = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).TQ()) != null && (TQ instanceof n)) {
                n nVar = (n) TQ;
                com.baidu.tieba.InjectPlugin.a.a hs = TQ.hs(1);
                if (hs == null) {
                    com.baidu.tieba.InjectPlugin.a.d ht = e.TP().ht(1);
                    if (ht != null) {
                        hs = ht.TO();
                        TQ.a(1, hs);
                        hs.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = hs;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.TR() == 1) {
                        List list = (List) bVar.TU();
                        b.W(dVar.TM());
                        for (BdUniqueId bdUniqueId : b.TL()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.TR() == 2) {
                        dVar.Z(bVar.TV());
                    } else if (bVar.TR() == 3) {
                        List<h> threadList = bVar.getThreadList();
                        List<c> X = FrsFeedAdStatic.X(threadList);
                        if (bVar.TX()) {
                            dVar.a(X, FrsFeedAdStatic.X(bVar.TW()), bVar.isRefresh(), bVar.TY());
                        } else {
                            dVar.g(X, bVar.TY());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.Y(X));
                    } else if (bVar.TR() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.TR() == 5) {
                        dVar.a(FrsFeedAdStatic.X(bVar.getThreadList()), bVar.getForumId(), bVar.Ua(), bVar.Ub(), bVar.Uc(), bVar.TZ(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
