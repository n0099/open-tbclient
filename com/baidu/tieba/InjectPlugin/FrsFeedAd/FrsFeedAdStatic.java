package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.InjectPlugin.a.e;
import com.baidu.tieba.recapp.p;
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
                cVar.sL(((b) nVar).bJr());
                cVar.aC(((b) nVar).bJq());
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
                bVar.aC(cVar.bJq());
                bVar.sL(cVar.bJr());
                arrayList.add(bVar);
            } else if (cVar.bJq() instanceof n) {
                arrayList.add((n) cVar.bJq());
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
            com.baidu.tieba.InjectPlugin.a.b bJx;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (bJx = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).bJx()) != null && (bJx instanceof p)) {
                p pVar = (p) bJx;
                com.baidu.tieba.InjectPlugin.a.a sM = bJx.sM(1);
                if (sM == null) {
                    com.baidu.tieba.InjectPlugin.a.d sN = e.bJw().sN(1);
                    if (sN != null) {
                        sM = sN.bJv();
                        bJx.a(1, sM);
                        sM.init(new com.baidu.tieba.InjectPlugin.a.c(pVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = sM;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.bJy() == 1) {
                        List list = (List) bVar.tr();
                        b.bM(dVar.bJt());
                        for (BdUniqueId bdUniqueId : b.bJs()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(pVar, bdUniqueId);
                            aVar2.setPageContext(pVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.bJy() == 2) {
                        dVar.bP(bVar.bJB());
                    } else if (bVar.bJy() == 3) {
                        List<n> threadList = bVar.getThreadList();
                        List<c> bN = FrsFeedAdStatic.bN(threadList);
                        if (bVar.bJD()) {
                            dVar.a(bN, FrsFeedAdStatic.bN(bVar.bJC()), bVar.bJE(), bVar.bJF());
                        } else {
                            dVar.d(bN, bVar.bJF());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.bO(bN));
                    } else if (bVar.bJy() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.bJy() == 5) {
                        dVar.a(FrsFeedAdStatic.bN(bVar.getThreadList()), bVar.getForumId(), bVar.bJH(), bVar.bJI(), bVar.bJJ(), bVar.bJG(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
