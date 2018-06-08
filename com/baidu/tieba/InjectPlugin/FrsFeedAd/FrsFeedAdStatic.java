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
    public static List<c> O(List<h> list) {
        ArrayList arrayList = new ArrayList();
        for (h hVar : list) {
            c cVar = new c();
            if (hVar instanceof bd) {
                bd bdVar = (bd) hVar;
                if (bdVar.vh() == 1) {
                    cVar.setThreadType(1);
                } else if (bdVar.vh() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.I(hVar);
            } else if (hVar instanceof b) {
                cVar.setThreadType(3);
                cVar.gb(((b) hVar).Oj());
                cVar.I(((b) hVar).Oi());
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
                bVar.I(cVar.Oi());
                bVar.gb(cVar.Oj());
                arrayList.add(bVar);
            } else if (cVar.Oi() instanceof h) {
                arrayList.add((h) cVar.Oi());
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
            com.baidu.tieba.InjectPlugin.a.b Op;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (Op = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).Op()) != null && (Op instanceof n)) {
                n nVar = (n) Op;
                com.baidu.tieba.InjectPlugin.a.a gc = Op.gc(1);
                if (gc == null) {
                    com.baidu.tieba.InjectPlugin.a.d gd = e.Oo().gd(1);
                    if (gd != null) {
                        gc = gd.On();
                        Op.a(1, gc);
                        gc.J(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = gc;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.Oq() == 1) {
                        List list = (List) bVar.Ot();
                        b.N(dVar.Ol());
                        for (BdUniqueId bdUniqueId : b.Ok()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.aiH());
                            list.add(aVar2);
                        }
                    } else if (bVar.Oq() == 2) {
                        dVar.Q(bVar.Ou());
                    } else if (bVar.Oq() == 3) {
                        List<h> threadList = bVar.getThreadList();
                        List<c> O = FrsFeedAdStatic.O(threadList);
                        if (bVar.Ow()) {
                            dVar.a(O, FrsFeedAdStatic.O(bVar.Ov()), bVar.isRefresh(), bVar.Ox());
                        } else {
                            dVar.f(O, bVar.Ox());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.P(O));
                    } else if (bVar.Oq() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.Oq() == 5) {
                        dVar.a(FrsFeedAdStatic.O(bVar.getThreadList()), bVar.getForumId(), bVar.Oz(), bVar.OA(), bVar.OB(), bVar.Oy(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
