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
                if (bbVar.zO() == 1) {
                    cVar.setThreadType(1);
                } else if (bbVar.zO() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.P(hVar);
            } else if (hVar instanceof b) {
                cVar.setThreadType(3);
                cVar.hs(((b) hVar).Ui());
                cVar.P(((b) hVar).Uh());
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
                bVar.P(cVar.Uh());
                bVar.hs(cVar.Ui());
                arrayList.add(bVar);
            } else if (cVar.Uh() instanceof h) {
                arrayList.add((h) cVar.Uh());
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
            com.baidu.tieba.InjectPlugin.a.b Uo;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (Uo = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).Uo()) != null && (Uo instanceof n)) {
                n nVar = (n) Uo;
                com.baidu.tieba.InjectPlugin.a.a ht = Uo.ht(1);
                if (ht == null) {
                    com.baidu.tieba.InjectPlugin.a.d hu = e.Un().hu(1);
                    if (hu != null) {
                        ht = hu.Um();
                        Uo.a(1, ht);
                        ht.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = ht;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.Up() == 1) {
                        List list = (List) bVar.Us();
                        b.X(dVar.Uk());
                        for (BdUniqueId bdUniqueId : b.Uj()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.Up() == 2) {
                        dVar.aa(bVar.Ut());
                    } else if (bVar.Up() == 3) {
                        List<h> threadList = bVar.getThreadList();
                        List<c> Y = FrsFeedAdStatic.Y(threadList);
                        if (bVar.Uv()) {
                            dVar.a(Y, FrsFeedAdStatic.Y(bVar.Uu()), bVar.isRefresh(), bVar.Uw());
                        } else {
                            dVar.g(Y, bVar.Uw());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.Z(Y));
                    } else if (bVar.Up() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.Up() == 5) {
                        dVar.a(FrsFeedAdStatic.Y(bVar.getThreadList()), bVar.getForumId(), bVar.Uy(), bVar.Uz(), bVar.UA(), bVar.Ux(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
