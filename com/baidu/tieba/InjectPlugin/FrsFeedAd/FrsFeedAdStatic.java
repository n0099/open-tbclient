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
    public static List<c> O(List<h> list) {
        ArrayList arrayList = new ArrayList();
        for (h hVar : list) {
            c cVar = new c();
            if (hVar instanceof bb) {
                bb bbVar = (bb) hVar;
                if (bbVar.vf() == 1) {
                    cVar.setThreadType(1);
                } else if (bbVar.vf() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.I(hVar);
            } else if (hVar instanceof b) {
                cVar.setThreadType(3);
                cVar.gh(((b) hVar).OI());
                cVar.I(((b) hVar).OH());
            } else {
                cVar.setThreadType(4);
                cVar.I(hVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<h> P(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.I(cVar.OH());
                bVar.gh(cVar.OI());
                arrayList.add(bVar);
            } else if (cVar.OH() instanceof h) {
                arrayList.add((h) cVar.OH());
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
            com.baidu.tieba.InjectPlugin.a.b OO;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (OO = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).OO()) != null && (OO instanceof n)) {
                n nVar = (n) OO;
                com.baidu.tieba.InjectPlugin.a.a gi = OO.gi(1);
                if (gi == null) {
                    com.baidu.tieba.InjectPlugin.a.d gj = e.ON().gj(1);
                    if (gj != null) {
                        gi = gj.OM();
                        OO.a(1, gi);
                        gi.J(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = gi;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.OP() == 1) {
                        List list = (List) bVar.OS();
                        b.N(dVar.OK());
                        for (BdUniqueId bdUniqueId : b.OJ()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.aiy());
                            list.add(aVar2);
                        }
                    } else if (bVar.OP() == 2) {
                        dVar.Q(bVar.OT());
                    } else if (bVar.OP() == 3) {
                        List<h> threadList = bVar.getThreadList();
                        List<c> O = FrsFeedAdStatic.O(threadList);
                        if (bVar.OV()) {
                            dVar.a(O, FrsFeedAdStatic.O(bVar.OU()), bVar.isRefresh(), bVar.OW());
                        } else {
                            dVar.g(O, bVar.OW());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.P(O));
                    } else if (bVar.OP() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.OP() == 5) {
                        dVar.a(FrsFeedAdStatic.O(bVar.getThreadList()), bVar.getForumId(), bVar.OY(), bVar.OZ(), bVar.Pa(), bVar.OX(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
