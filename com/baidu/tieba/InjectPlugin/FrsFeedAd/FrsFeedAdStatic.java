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
            if (qVar instanceof bw) {
                bw bwVar = (bw) qVar;
                if (bwVar.bez() == 1) {
                    cVar.setThreadType(1);
                } else if (bwVar.bez() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.av(qVar);
            } else if (qVar instanceof b) {
                cVar.setThreadType(3);
                cVar.rP(((b) qVar).bzq());
                cVar.av(((b) qVar).bzp());
            } else {
                cVar.setThreadType(4);
                cVar.av(qVar);
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
                bVar.av(cVar.bzp());
                bVar.rP(cVar.bzq());
                arrayList.add(bVar);
            } else if (cVar.bzp() instanceof q) {
                arrayList.add((q) cVar.bzp());
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
            com.baidu.tieba.InjectPlugin.a.b bzw;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (bzw = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).bzw()) != null && (bzw instanceof n)) {
                n nVar = (n) bzw;
                com.baidu.tieba.InjectPlugin.a.a rQ = bzw.rQ(1);
                if (rQ == null) {
                    com.baidu.tieba.InjectPlugin.a.d rR = e.bzv().rR(1);
                    if (rR != null) {
                        rQ = rR.bzu();
                        bzw.a(1, rQ);
                        rQ.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = rQ;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.bzx() == 1) {
                        List list = (List) bVar.tX();
                        b.bi(dVar.bzs());
                        for (BdUniqueId bdUniqueId : b.bzr()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.bzx() == 2) {
                        dVar.bl(bVar.bzA());
                    } else if (bVar.bzx() == 3) {
                        List<q> threadList = bVar.getThreadList();
                        List<c> bj = FrsFeedAdStatic.bj(threadList);
                        if (bVar.bzC()) {
                            dVar.a(bj, FrsFeedAdStatic.bj(bVar.bzB()), bVar.bzD(), bVar.bzE());
                        } else {
                            dVar.d(bj, bVar.bzE());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.bk(bj));
                    } else if (bVar.bzx() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.bzx() == 5) {
                        dVar.a(FrsFeedAdStatic.bj(bVar.getThreadList()), bVar.getForumId(), bVar.bzG(), bVar.bzH(), bVar.bzI(), bVar.bzF(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
