package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.InjectPlugin.a.e;
import com.baidu.tieba.recapp.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class FrsFeedAdStatic {
    static {
        MessageManager.getInstance().registerListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> aR(List<m> list) {
        ArrayList arrayList = new ArrayList();
        for (m mVar : list) {
            c cVar = new c();
            if (mVar instanceof bj) {
                bj bjVar = (bj) mVar;
                if (bjVar.azz() == 1) {
                    cVar.setThreadType(1);
                } else if (bjVar.azz() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.al(mVar);
            } else if (mVar instanceof b) {
                cVar.setThreadType(3);
                cVar.nA(((b) mVar).aSK());
                cVar.al(((b) mVar).aSJ());
            } else {
                cVar.setThreadType(4);
                cVar.al(mVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<m> aS(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.al(cVar.aSJ());
                bVar.nA(cVar.aSK());
                arrayList.add(bVar);
            } else if (cVar.aSJ() instanceof m) {
                arrayList.add((m) cVar.aSJ());
            }
        }
        return arrayList;
    }

    /* loaded from: classes5.dex */
    static final class a extends CustomMessageListener {
        public a() {
            super(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.InjectPlugin.b.b bVar;
            com.baidu.tieba.InjectPlugin.a.b aSQ;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (aSQ = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).aSQ()) != null && (aSQ instanceof n)) {
                n nVar = (n) aSQ;
                com.baidu.tieba.InjectPlugin.a.a nB = aSQ.nB(1);
                if (nB == null) {
                    com.baidu.tieba.InjectPlugin.a.d nC = e.aSP().nC(1);
                    if (nC != null) {
                        nB = nC.aSO();
                        aSQ.a(1, nB);
                        nB.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = nB;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.aSR() == 1) {
                        List list = (List) bVar.mY();
                        b.aQ(dVar.aSM());
                        for (BdUniqueId bdUniqueId : b.aSL()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.aSR() == 2) {
                        dVar.aT(bVar.aSU());
                    } else if (bVar.aSR() == 3) {
                        List<m> threadList = bVar.getThreadList();
                        List<c> aR = FrsFeedAdStatic.aR(threadList);
                        if (bVar.aSW()) {
                            dVar.a(aR, FrsFeedAdStatic.aR(bVar.aSV()), bVar.aSX(), bVar.aSY());
                        } else {
                            dVar.d(aR, bVar.aSY());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.aS(aR));
                    } else if (bVar.aSR() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.aSR() == 5) {
                        dVar.a(FrsFeedAdStatic.aR(bVar.getThreadList()), bVar.getForumId(), bVar.aTa(), bVar.aTb(), bVar.aTc(), bVar.aSZ(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
