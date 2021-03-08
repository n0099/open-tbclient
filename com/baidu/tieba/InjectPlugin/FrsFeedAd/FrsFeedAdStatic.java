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
/* loaded from: classes7.dex */
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
                if (cbVar.bnN() == 1) {
                    cVar.setThreadType(1);
                } else if (cbVar.bnN() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.aE(nVar);
            } else if (nVar instanceof b) {
                cVar.setThreadType(3);
                cVar.sN(((b) nVar).bJA());
                cVar.aE(((b) nVar).bJz());
            } else {
                cVar.setThreadType(4);
                cVar.aE(nVar);
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
                bVar.aE(cVar.bJz());
                bVar.sN(cVar.bJA());
                arrayList.add(bVar);
            } else if (cVar.bJz() instanceof n) {
                arrayList.add((n) cVar.bJz());
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
            com.baidu.tieba.InjectPlugin.a.b bJG;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (bJG = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).bJG()) != null && (bJG instanceof q)) {
                q qVar = (q) bJG;
                com.baidu.tieba.InjectPlugin.a.a sO = bJG.sO(1);
                if (sO == null) {
                    com.baidu.tieba.InjectPlugin.a.d sP = e.bJF().sP(1);
                    if (sP != null) {
                        sO = sP.bJE();
                        bJG.a(1, sO);
                        sO.init(new com.baidu.tieba.InjectPlugin.a.c(qVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = sO;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.bJH() == 1) {
                        List list = (List) bVar.tr();
                        b.bM(dVar.bJC());
                        for (BdUniqueId bdUniqueId : b.bJB()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(qVar, bdUniqueId);
                            aVar2.setPageContext(qVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.bJH() == 2) {
                        dVar.bP(bVar.bJK());
                    } else if (bVar.bJH() == 3) {
                        List<n> threadList = bVar.getThreadList();
                        List<c> bN = FrsFeedAdStatic.bN(threadList);
                        if (bVar.bJM()) {
                            dVar.a(bN, FrsFeedAdStatic.bN(bVar.bJL()), bVar.bJN(), bVar.bJO());
                        } else {
                            dVar.d(bN, bVar.bJO());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.bO(bN));
                    } else if (bVar.bJH() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.bJH() == 5) {
                        dVar.a(FrsFeedAdStatic.bN(bVar.getThreadList()), bVar.getForumId(), bVar.bJQ(), bVar.bJR(), bVar.bJS(), bVar.bJP(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
