package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.InjectPlugin.a.e;
import com.baidu.tieba.recapp.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class FrsFeedAdStatic {
    static {
        MessageManager.getInstance().registerListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> bN(List<n> list) {
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            c cVar = new c();
            if (nVar instanceof cb) {
                cb cbVar = (cb) nVar;
                if (cbVar.bnL() == 1) {
                    cVar.setThreadType(1);
                } else if (cbVar.bnL() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.aC(nVar);
            } else if (nVar instanceof b) {
                cVar.setThreadType(3);
                cVar.sL(((b) nVar).bJw());
                cVar.aC(((b) nVar).bJv());
            } else {
                cVar.setThreadType(4);
                cVar.aC(nVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<n> bO(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.aC(cVar.bJv());
                bVar.sL(cVar.bJw());
                arrayList.add(bVar);
            } else if (cVar.bJv() instanceof n) {
                arrayList.add((n) cVar.bJv());
            }
        }
        return arrayList;
    }

    /* loaded from: classes8.dex */
    static final class a extends CustomMessageListener {
        public a() {
            super(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.InjectPlugin.b.b bVar;
            com.baidu.tieba.InjectPlugin.a.b bJC;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (bJC = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).bJC()) != null && (bJC instanceof q)) {
                q qVar = (q) bJC;
                com.baidu.tieba.InjectPlugin.a.a sM = bJC.sM(1);
                if (sM == null) {
                    com.baidu.tieba.InjectPlugin.a.d sN = e.bJB().sN(1);
                    if (sN != null) {
                        sM = sN.bJA();
                        bJC.a(1, sM);
                        sM.init(new com.baidu.tieba.InjectPlugin.a.c(qVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = sM;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.bJD() == 1) {
                        List list = (List) bVar.tr();
                        b.bM(dVar.bJy());
                        for (BdUniqueId bdUniqueId : b.bJx()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(qVar, bdUniqueId);
                            aVar2.setPageContext(qVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.bJD() == 2) {
                        dVar.bP(bVar.bJG());
                    } else if (bVar.bJD() == 3) {
                        List<n> threadList = bVar.getThreadList();
                        List<c> bN = FrsFeedAdStatic.bN(threadList);
                        if (bVar.bJI()) {
                            dVar.a(bN, FrsFeedAdStatic.bN(bVar.bJH()), bVar.bJJ(), bVar.bJK());
                        } else {
                            dVar.d(bN, bVar.bJK());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.bO(bN));
                    } else if (bVar.bJD() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.bJD() == 5) {
                        dVar.a(FrsFeedAdStatic.bN(bVar.getThreadList()), bVar.getForumId(), bVar.bJM(), bVar.bJN(), bVar.bJO(), bVar.bJL(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
