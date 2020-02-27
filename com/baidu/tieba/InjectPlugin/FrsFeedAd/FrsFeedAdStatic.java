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
                if (bjVar.aCh() == 1) {
                    cVar.setThreadType(1);
                } else if (bjVar.aCh() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.an(mVar);
            } else if (mVar instanceof b) {
                cVar.setThreadType(3);
                cVar.nR(((b) mVar).aVv());
                cVar.an(((b) mVar).aVu());
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
                bVar.an(cVar.aVu());
                bVar.nR(cVar.aVv());
                arrayList.add(bVar);
            } else if (cVar.aVu() instanceof m) {
                arrayList.add((m) cVar.aVu());
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
            com.baidu.tieba.InjectPlugin.a.b aVB;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (aVB = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).aVB()) != null && (aVB instanceof n)) {
                n nVar = (n) aVB;
                com.baidu.tieba.InjectPlugin.a.a nS = aVB.nS(1);
                if (nS == null) {
                    com.baidu.tieba.InjectPlugin.a.d nT = e.aVA().nT(1);
                    if (nT != null) {
                        nS = nT.aVz();
                        aVB.a(1, nS);
                        nS.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = nS;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.aVC() == 1) {
                        List list = (List) bVar.nq();
                        b.aP(dVar.aVx());
                        for (BdUniqueId bdUniqueId : b.aVw()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.aVC() == 2) {
                        dVar.aS(bVar.aVF());
                    } else if (bVar.aVC() == 3) {
                        List<m> threadList = bVar.getThreadList();
                        List<c> aQ = FrsFeedAdStatic.aQ(threadList);
                        if (bVar.aVH()) {
                            dVar.a(aQ, FrsFeedAdStatic.aQ(bVar.aVG()), bVar.aVI(), bVar.aVJ());
                        } else {
                            dVar.d(aQ, bVar.aVJ());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.aR(aQ));
                    } else if (bVar.aVC() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.aVC() == 5) {
                        dVar.a(FrsFeedAdStatic.aQ(bVar.getThreadList()), bVar.getForumId(), bVar.aVL(), bVar.aVM(), bVar.aVN(), bVar.aVK(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
