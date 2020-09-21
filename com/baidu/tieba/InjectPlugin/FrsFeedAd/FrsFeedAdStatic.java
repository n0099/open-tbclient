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
/* loaded from: classes20.dex */
public class FrsFeedAdStatic {
    static {
        MessageManager.getInstance().registerListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> bo(List<q> list) {
        ArrayList arrayList = new ArrayList();
        for (q qVar : list) {
            c cVar = new c();
            if (qVar instanceof bw) {
                bw bwVar = (bw) qVar;
                if (bwVar.bft() == 1) {
                    cVar.setThreadType(1);
                } else if (bwVar.bft() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.ax(qVar);
            } else if (qVar instanceof b) {
                cVar.setThreadType(3);
                cVar.sg(((b) qVar).bAz());
                cVar.ax(((b) qVar).bAy());
            } else {
                cVar.setThreadType(4);
                cVar.ax(qVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<q> bp(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.ax(cVar.bAy());
                bVar.sg(cVar.bAz());
                arrayList.add(bVar);
            } else if (cVar.bAy() instanceof q) {
                arrayList.add((q) cVar.bAy());
            }
        }
        return arrayList;
    }

    /* loaded from: classes20.dex */
    static final class a extends CustomMessageListener {
        public a() {
            super(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.InjectPlugin.b.b bVar;
            com.baidu.tieba.InjectPlugin.a.b bAF;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (bAF = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).bAF()) != null && (bAF instanceof n)) {
                n nVar = (n) bAF;
                com.baidu.tieba.InjectPlugin.a.a sh = bAF.sh(1);
                if (sh == null) {
                    com.baidu.tieba.InjectPlugin.a.d si = e.bAE().si(1);
                    if (si != null) {
                        sh = si.bAD();
                        bAF.a(1, sh);
                        sh.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = sh;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.bAG() == 1) {
                        List list = (List) bVar.ud();
                        b.bn(dVar.bAB());
                        for (BdUniqueId bdUniqueId : b.bAA()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.bAG() == 2) {
                        dVar.bq(bVar.bAJ());
                    } else if (bVar.bAG() == 3) {
                        List<q> threadList = bVar.getThreadList();
                        List<c> bo = FrsFeedAdStatic.bo(threadList);
                        if (bVar.bAL()) {
                            dVar.a(bo, FrsFeedAdStatic.bo(bVar.bAK()), bVar.bAM(), bVar.bAN());
                        } else {
                            dVar.d(bo, bVar.bAN());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.bp(bo));
                    } else if (bVar.bAG() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.bAG() == 5) {
                        dVar.a(FrsFeedAdStatic.bo(bVar.getThreadList()), bVar.getForumId(), bVar.bAP(), bVar.bAQ(), bVar.bAR(), bVar.bAO(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
