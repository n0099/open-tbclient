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
/* loaded from: classes6.dex */
public class FrsFeedAdStatic {
    static {
        MessageManager.getInstance().registerListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> aQ(List<m> list) {
        ArrayList arrayList = new ArrayList();
        for (m mVar : list) {
            c cVar = new c();
            if (mVar instanceof bj) {
                bj bjVar = (bj) mVar;
                if (bjVar.azS() == 1) {
                    cVar.setThreadType(1);
                } else if (bjVar.azS() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.al(mVar);
            } else if (mVar instanceof b) {
                cVar.setThreadType(3);
                cVar.nA(((b) mVar).aTe());
                cVar.al(((b) mVar).aTd());
            } else {
                cVar.setThreadType(4);
                cVar.al(mVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<m> aR(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.al(cVar.aTd());
                bVar.nA(cVar.aTe());
                arrayList.add(bVar);
            } else if (cVar.aTd() instanceof m) {
                arrayList.add((m) cVar.aTd());
            }
        }
        return arrayList;
    }

    /* loaded from: classes6.dex */
    static final class a extends CustomMessageListener {
        public a() {
            super(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.InjectPlugin.b.b bVar;
            com.baidu.tieba.InjectPlugin.a.b aTk;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (aTk = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).aTk()) != null && (aTk instanceof n)) {
                n nVar = (n) aTk;
                com.baidu.tieba.InjectPlugin.a.a nB = aTk.nB(1);
                if (nB == null) {
                    com.baidu.tieba.InjectPlugin.a.d nC = e.aTj().nC(1);
                    if (nC != null) {
                        nB = nC.aTi();
                        aTk.a(1, nB);
                        nB.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = nB;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.aTl() == 1) {
                        List list = (List) bVar.mZ();
                        b.aP(dVar.aTg());
                        for (BdUniqueId bdUniqueId : b.aTf()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.aTl() == 2) {
                        dVar.aS(bVar.aTo());
                    } else if (bVar.aTl() == 3) {
                        List<m> threadList = bVar.getThreadList();
                        List<c> aQ = FrsFeedAdStatic.aQ(threadList);
                        if (bVar.aTq()) {
                            dVar.a(aQ, FrsFeedAdStatic.aQ(bVar.aTp()), bVar.aTr(), bVar.aTs());
                        } else {
                            dVar.d(aQ, bVar.aTs());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.aR(aQ));
                    } else if (bVar.aTl() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.aTl() == 5) {
                        dVar.a(FrsFeedAdStatic.aQ(bVar.getThreadList()), bVar.getForumId(), bVar.aTu(), bVar.aTv(), bVar.aTw(), bVar.aTt(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
