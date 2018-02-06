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
                cVar.jb(((b) iVar).So());
                cVar.aK(((b) iVar).Sn());
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
                bVar.aK(cVar.Sn());
                bVar.jb(cVar.So());
                arrayList.add(bVar);
            } else if (cVar.Sn() instanceof i) {
                arrayList.add((i) cVar.Sn());
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
            com.baidu.tieba.InjectPlugin.a.b Su;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (Su = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).Su()) != null && (Su instanceof n)) {
                n nVar = (n) Su;
                com.baidu.tieba.InjectPlugin.a.a jc = Su.jc(1);
                if (jc == null) {
                    com.baidu.tieba.InjectPlugin.a.d jd = e.St().jd(1);
                    if (jd != null) {
                        jc = jd.Ss();
                        Su.a(1, jc);
                        jc.aL(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = jc;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.Sv() == 1) {
                        List list = (List) bVar.Sy();
                        b.T(dVar.Sq());
                        for (BdUniqueId bdUniqueId : b.Sp()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.akO());
                            list.add(aVar2);
                        }
                    } else if (bVar.Sv() == 2) {
                        dVar.W(bVar.Sz());
                    } else if (bVar.Sv() == 3) {
                        List<i> threadList = bVar.getThreadList();
                        List<c> U = FrsFeedAdStatic.U(threadList);
                        if (bVar.SB()) {
                            dVar.a(U, FrsFeedAdStatic.U(bVar.SA()), bVar.isRefresh(), bVar.SC());
                        } else {
                            dVar.j(U, bVar.SC());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.V(U));
                    } else if (bVar.Sv() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.Sv() == 5) {
                        dVar.a(FrsFeedAdStatic.U(bVar.getThreadList()), bVar.getForumId(), bVar.SE(), bVar.SF(), bVar.SG(), bVar.SD(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
