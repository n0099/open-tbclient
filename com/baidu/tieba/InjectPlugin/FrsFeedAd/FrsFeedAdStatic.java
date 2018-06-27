package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bc;
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
            if (hVar instanceof bc) {
                bc bcVar = (bc) hVar;
                if (bcVar.vr() == 1) {
                    cVar.setThreadType(1);
                } else if (bcVar.vr() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.I(hVar);
            } else if (hVar instanceof b) {
                cVar.setThreadType(3);
                cVar.gc(((b) hVar).OC());
                cVar.I(((b) hVar).OB());
            } else {
                cVar.setThreadType(4);
                cVar.I(hVar);
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
                bVar.I(cVar.OB());
                bVar.gc(cVar.OC());
                arrayList.add(bVar);
            } else if (cVar.OB() instanceof h) {
                arrayList.add((h) cVar.OB());
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
            com.baidu.tieba.InjectPlugin.a.b OI;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (OI = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).OI()) != null && (OI instanceof n)) {
                n nVar = (n) OI;
                com.baidu.tieba.InjectPlugin.a.a gd = OI.gd(1);
                if (gd == null) {
                    com.baidu.tieba.InjectPlugin.a.d ge = e.OH().ge(1);
                    if (ge != null) {
                        gd = ge.OG();
                        OI.a(1, gd);
                        gd.J(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = gd;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.OJ() == 1) {
                        List list = (List) bVar.OM();
                        b.O(dVar.OE());
                        for (BdUniqueId bdUniqueId : b.OD()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.ahZ());
                            list.add(aVar2);
                        }
                    } else if (bVar.OJ() == 2) {
                        dVar.R(bVar.ON());
                    } else if (bVar.OJ() == 3) {
                        List<h> threadList = bVar.getThreadList();
                        List<c> P = FrsFeedAdStatic.P(threadList);
                        if (bVar.OP()) {
                            dVar.a(P, FrsFeedAdStatic.P(bVar.OO()), bVar.isRefresh(), bVar.OQ());
                        } else {
                            dVar.g(P, bVar.OQ());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.Q(P));
                    } else if (bVar.OJ() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.OJ() == 5) {
                        dVar.a(FrsFeedAdStatic.P(bVar.getThreadList()), bVar.getForumId(), bVar.OS(), bVar.OT(), bVar.OU(), bVar.OR(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
