package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.InjectPlugin.a.e;
import com.baidu.tieba.recapp.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class FrsFeedAdStatic {
    static {
        MessageManager.getInstance().registerListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> bj(List<q> list) {
        ArrayList arrayList = new ArrayList();
        for (q qVar : list) {
            c cVar = new c();
            if (qVar instanceof bv) {
                bv bvVar = (bv) qVar;
                if (bvVar.aWg() == 1) {
                    cVar.setThreadType(1);
                } else if (bvVar.aWg() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.at(qVar);
            } else if (qVar instanceof b) {
                cVar.setThreadType(3);
                cVar.pD(((b) qVar).bqr());
                cVar.at(((b) qVar).bqq());
            } else {
                cVar.setThreadType(4);
                cVar.at(qVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<q> bk(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.at(cVar.bqq());
                bVar.pD(cVar.bqr());
                arrayList.add(bVar);
            } else if (cVar.bqq() instanceof q) {
                arrayList.add((q) cVar.bqq());
            }
        }
        return arrayList;
    }

    /* loaded from: classes15.dex */
    static final class a extends CustomMessageListener {
        public a() {
            super(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.InjectPlugin.b.b bVar;
            com.baidu.tieba.InjectPlugin.a.b bqx;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (bqx = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).bqx()) != null && (bqx instanceof n)) {
                n nVar = (n) bqx;
                com.baidu.tieba.InjectPlugin.a.a pE = bqx.pE(1);
                if (pE == null) {
                    com.baidu.tieba.InjectPlugin.a.d pF = e.bqw().pF(1);
                    if (pF != null) {
                        pE = pF.bqv();
                        bqx.a(1, pE);
                        pE.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = pE;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.bqy() == 1) {
                        List list = (List) bVar.sm();
                        b.bi(dVar.bqt());
                        for (BdUniqueId bdUniqueId : b.bqs()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.bqy() == 2) {
                        dVar.bl(bVar.bqB());
                    } else if (bVar.bqy() == 3) {
                        List<q> threadList = bVar.getThreadList();
                        List<c> bj = FrsFeedAdStatic.bj(threadList);
                        if (bVar.bqD()) {
                            dVar.a(bj, FrsFeedAdStatic.bj(bVar.bqC()), bVar.bqE(), bVar.bqF());
                        } else {
                            dVar.d(bj, bVar.bqF());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.bk(bj));
                    } else if (bVar.bqy() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.bqy() == 5) {
                        dVar.a(FrsFeedAdStatic.bj(bVar.getThreadList()), bVar.getForumId(), bVar.bqH(), bVar.bqI(), bVar.bqJ(), bVar.bqG(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
