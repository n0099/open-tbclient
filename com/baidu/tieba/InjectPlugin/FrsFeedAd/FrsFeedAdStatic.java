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
                if (bjVar.aCm() == 1) {
                    cVar.setThreadType(1);
                } else if (bjVar.aCm() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.an(mVar);
            } else if (mVar instanceof b) {
                cVar.setThreadType(3);
                cVar.nT(((b) mVar).aVC());
                cVar.an(((b) mVar).aVB());
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
                bVar.an(cVar.aVB());
                bVar.nT(cVar.aVC());
                arrayList.add(bVar);
            } else if (cVar.aVB() instanceof m) {
                arrayList.add((m) cVar.aVB());
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
            com.baidu.tieba.InjectPlugin.a.b aVI;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (aVI = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).aVI()) != null && (aVI instanceof n)) {
                n nVar = (n) aVI;
                com.baidu.tieba.InjectPlugin.a.a nU = aVI.nU(1);
                if (nU == null) {
                    com.baidu.tieba.InjectPlugin.a.d nV = e.aVH().nV(1);
                    if (nV != null) {
                        nU = nV.aVG();
                        aVI.a(1, nU);
                        nU.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = nU;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.aVJ() == 1) {
                        List list = (List) bVar.nq();
                        b.aP(dVar.aVE());
                        for (BdUniqueId bdUniqueId : b.aVD()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.aVJ() == 2) {
                        dVar.aS(bVar.aVM());
                    } else if (bVar.aVJ() == 3) {
                        List<m> threadList = bVar.getThreadList();
                        List<c> aQ = FrsFeedAdStatic.aQ(threadList);
                        if (bVar.aVO()) {
                            dVar.a(aQ, FrsFeedAdStatic.aQ(bVar.aVN()), bVar.aVP(), bVar.aVQ());
                        } else {
                            dVar.d(aQ, bVar.aVQ());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.aR(aQ));
                    } else if (bVar.aVJ() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.aVJ() == 5) {
                        dVar.a(FrsFeedAdStatic.aQ(bVar.getThreadList()), bVar.getForumId(), bVar.aVS(), bVar.aVT(), bVar.aVU(), bVar.aVR(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
