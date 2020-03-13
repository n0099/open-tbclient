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
/* loaded from: classes8.dex */
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
                if (bjVar.aCj() == 1) {
                    cVar.setThreadType(1);
                } else if (bjVar.aCj() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.an(mVar);
            } else if (mVar instanceof b) {
                cVar.setThreadType(3);
                cVar.nR(((b) mVar).aVy());
                cVar.an(((b) mVar).aVx());
            } else {
                cVar.setThreadType(4);
                cVar.an(mVar);
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
                bVar.an(cVar.aVx());
                bVar.nR(cVar.aVy());
                arrayList.add(bVar);
            } else if (cVar.aVx() instanceof m) {
                arrayList.add((m) cVar.aVx());
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
            com.baidu.tieba.InjectPlugin.a.b aVE;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (aVE = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).aVE()) != null && (aVE instanceof n)) {
                n nVar = (n) aVE;
                com.baidu.tieba.InjectPlugin.a.a nS = aVE.nS(1);
                if (nS == null) {
                    com.baidu.tieba.InjectPlugin.a.d nT = e.aVD().nT(1);
                    if (nT != null) {
                        nS = nT.aVC();
                        aVE.a(1, nS);
                        nS.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = nS;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.aVF() == 1) {
                        List list = (List) bVar.nq();
                        b.aP(dVar.aVA());
                        for (BdUniqueId bdUniqueId : b.aVz()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.aVF() == 2) {
                        dVar.aS(bVar.aVI());
                    } else if (bVar.aVF() == 3) {
                        List<m> threadList = bVar.getThreadList();
                        List<c> aQ = FrsFeedAdStatic.aQ(threadList);
                        if (bVar.aVK()) {
                            dVar.a(aQ, FrsFeedAdStatic.aQ(bVar.aVJ()), bVar.aVL(), bVar.aVM());
                        } else {
                            dVar.d(aQ, bVar.aVM());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.aR(aQ));
                    } else if (bVar.aVF() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.aVF() == 5) {
                        dVar.a(FrsFeedAdStatic.aQ(bVar.getThreadList()), bVar.getForumId(), bVar.aVO(), bVar.aVP(), bVar.aVQ(), bVar.aVN(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
