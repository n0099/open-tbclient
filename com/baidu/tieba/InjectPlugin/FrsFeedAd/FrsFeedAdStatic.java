package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.i;
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
    public static List<c> U(List<i> list) {
        ArrayList arrayList = new ArrayList();
        for (i iVar : list) {
            c cVar = new c();
            if (iVar instanceof bd) {
                bd bdVar = (bd) iVar;
                if (bdVar.zi() == 1) {
                    cVar.setThreadType(1);
                } else if (bdVar.zi() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.aK(iVar);
            } else if (iVar instanceof b) {
                cVar.setThreadType(3);
                cVar.jb(((b) iVar).Sn());
                cVar.aK(((b) iVar).Sm());
            } else {
                cVar.setThreadType(4);
                cVar.aK(iVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<i> V(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.aK(cVar.Sm());
                bVar.jb(cVar.Sn());
                arrayList.add(bVar);
            } else if (cVar.Sm() instanceof i) {
                arrayList.add((i) cVar.Sm());
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
            com.baidu.tieba.InjectPlugin.a.b St;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (St = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).St()) != null && (St instanceof n)) {
                n nVar = (n) St;
                com.baidu.tieba.InjectPlugin.a.a jc = St.jc(1);
                if (jc == null) {
                    com.baidu.tieba.InjectPlugin.a.d jd = e.Ss().jd(1);
                    if (jd != null) {
                        jc = jd.Sr();
                        St.a(1, jc);
                        jc.aL(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = jc;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.Su() == 1) {
                        List list = (List) bVar.Sx();
                        b.T(dVar.Sp());
                        for (BdUniqueId bdUniqueId : b.So()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.akN());
                            list.add(aVar2);
                        }
                    } else if (bVar.Su() == 2) {
                        dVar.W(bVar.Sy());
                    } else if (bVar.Su() == 3) {
                        List<i> threadList = bVar.getThreadList();
                        List<c> U = FrsFeedAdStatic.U(threadList);
                        if (bVar.SA()) {
                            dVar.a(U, FrsFeedAdStatic.U(bVar.Sz()), bVar.isRefresh(), bVar.SB());
                        } else {
                            dVar.j(U, bVar.SB());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.V(U));
                    } else if (bVar.Su() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.Su() == 5) {
                        dVar.a(FrsFeedAdStatic.U(bVar.getThreadList()), bVar.getForumId(), bVar.SD(), bVar.SE(), bVar.SF(), bVar.SC(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
