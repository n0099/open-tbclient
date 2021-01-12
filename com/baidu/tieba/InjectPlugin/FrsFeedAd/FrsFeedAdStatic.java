package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.InjectPlugin.a.e;
import com.baidu.tieba.recapp.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class FrsFeedAdStatic {
    static {
        MessageManager.getInstance().registerListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> bS(List<n> list) {
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            c cVar = new c();
            if (nVar instanceof bz) {
                bz bzVar = (bz) nVar;
                if (bzVar.bns() == 1) {
                    cVar.setThreadType(1);
                } else if (bzVar.bns() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.aC(nVar);
            } else if (nVar instanceof b) {
                cVar.setThreadType(3);
                cVar.sG(((b) nVar).bIX());
                cVar.aC(((b) nVar).bIW());
            } else {
                cVar.setThreadType(4);
                cVar.aC(nVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<n> bT(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.aC(cVar.bIW());
                bVar.sG(cVar.bIX());
                arrayList.add(bVar);
            } else if (cVar.bIW() instanceof n) {
                arrayList.add((n) cVar.bIW());
            }
        }
        return arrayList;
    }

    /* loaded from: classes7.dex */
    static final class a extends CustomMessageListener {
        public a() {
            super(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.InjectPlugin.b.b bVar;
            com.baidu.tieba.InjectPlugin.a.b bJd;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (bJd = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).bJd()) != null && (bJd instanceof p)) {
                p pVar = (p) bJd;
                com.baidu.tieba.InjectPlugin.a.a sH = bJd.sH(1);
                if (sH == null) {
                    com.baidu.tieba.InjectPlugin.a.d sI = e.bJc().sI(1);
                    if (sI != null) {
                        sH = sI.bJb();
                        bJd.a(1, sH);
                        sH.init(new com.baidu.tieba.InjectPlugin.a.c(pVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = sH;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.bJe() == 1) {
                        List list = (List) bVar.tu();
                        b.bR(dVar.bIZ());
                        for (BdUniqueId bdUniqueId : b.bIY()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(pVar, bdUniqueId);
                            aVar2.setPageContext(pVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.bJe() == 2) {
                        dVar.bU(bVar.bJh());
                    } else if (bVar.bJe() == 3) {
                        List<n> threadList = bVar.getThreadList();
                        List<c> bS = FrsFeedAdStatic.bS(threadList);
                        if (bVar.bJj()) {
                            dVar.a(bS, FrsFeedAdStatic.bS(bVar.bJi()), bVar.bJk(), bVar.bJl());
                        } else {
                            dVar.d(bS, bVar.bJl());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.bT(bS));
                    } else if (bVar.bJe() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.bJe() == 5) {
                        dVar.a(FrsFeedAdStatic.bS(bVar.getThreadList()), bVar.getForumId(), bVar.bJn(), bVar.bJo(), bVar.bJp(), bVar.bJm(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
