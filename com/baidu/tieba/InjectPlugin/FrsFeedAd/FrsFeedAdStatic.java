package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.InjectPlugin.a.e;
import com.baidu.tieba.recapp.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class FrsFeedAdStatic {
    static {
        MessageManager.getInstance().registerListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> bA(List<q> list) {
        ArrayList arrayList = new ArrayList();
        for (q qVar : list) {
            c cVar = new c();
            if (qVar instanceof bw) {
                bw bwVar = (bw) qVar;
                if (bwVar.bjV() == 1) {
                    cVar.setThreadType(1);
                } else if (bwVar.bjV() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.aA(qVar);
            } else if (qVar instanceof b) {
                cVar.setThreadType(3);
                cVar.sP(((b) qVar).bFe());
                cVar.aA(((b) qVar).bFd());
            } else {
                cVar.setThreadType(4);
                cVar.aA(qVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<q> bB(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.aA(cVar.bFd());
                bVar.sP(cVar.bFe());
                arrayList.add(bVar);
            } else if (cVar.bFd() instanceof q) {
                arrayList.add((q) cVar.bFd());
            }
        }
        return arrayList;
    }

    /* loaded from: classes21.dex */
    static final class a extends CustomMessageListener {
        public a() {
            super(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.InjectPlugin.b.b bVar;
            com.baidu.tieba.InjectPlugin.a.b bFk;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (bFk = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).bFk()) != null && (bFk instanceof n)) {
                n nVar = (n) bFk;
                com.baidu.tieba.InjectPlugin.a.a sQ = bFk.sQ(1);
                if (sQ == null) {
                    com.baidu.tieba.InjectPlugin.a.d sR = e.bFj().sR(1);
                    if (sR != null) {
                        sQ = sR.bFi();
                        bFk.a(1, sQ);
                        sQ.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = sQ;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.bFl() == 1) {
                        List list = (List) bVar.ud();
                        b.bz(dVar.bFg());
                        for (BdUniqueId bdUniqueId : b.bFf()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.bFl() == 2) {
                        dVar.bC(bVar.bFo());
                    } else if (bVar.bFl() == 3) {
                        List<q> threadList = bVar.getThreadList();
                        List<c> bA = FrsFeedAdStatic.bA(threadList);
                        if (bVar.bFq()) {
                            dVar.a(bA, FrsFeedAdStatic.bA(bVar.bFp()), bVar.bFr(), bVar.bFs());
                        } else {
                            dVar.d(bA, bVar.bFs());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.bB(bA));
                    } else if (bVar.bFl() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.bFl() == 5) {
                        dVar.a(FrsFeedAdStatic.bA(bVar.getThreadList()), bVar.getForumId(), bVar.bFu(), bVar.bFv(), bVar.bFw(), bVar.bFt(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
