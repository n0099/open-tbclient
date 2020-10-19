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
/* loaded from: classes21.dex */
public class FrsFeedAdStatic {
    static {
        MessageManager.getInstance().registerListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> br(List<q> list) {
        ArrayList arrayList = new ArrayList();
        for (q qVar : list) {
            c cVar = new c();
            if (qVar instanceof bw) {
                bw bwVar = (bw) qVar;
                if (bwVar.bic() == 1) {
                    cVar.setThreadType(1);
                } else if (bwVar.bic() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.aA(qVar);
            } else if (qVar instanceof b) {
                cVar.setThreadType(3);
                cVar.sE(((b) qVar).bDl());
                cVar.aA(((b) qVar).bDk());
            } else {
                cVar.setThreadType(4);
                cVar.aA(qVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<q> bs(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.aA(cVar.bDk());
                bVar.sE(cVar.bDl());
                arrayList.add(bVar);
            } else if (cVar.bDk() instanceof q) {
                arrayList.add((q) cVar.bDk());
            }
        }
        return arrayList;
    }

    /* loaded from: classes21.dex */
    static final class a extends CustomMessageListener {
        public a() {
            super(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.InjectPlugin.b.b bVar;
            com.baidu.tieba.InjectPlugin.a.b bDr;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (bDr = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).bDr()) != null && (bDr instanceof n)) {
                n nVar = (n) bDr;
                com.baidu.tieba.InjectPlugin.a.a sF = bDr.sF(1);
                if (sF == null) {
                    com.baidu.tieba.InjectPlugin.a.d sG = e.bDq().sG(1);
                    if (sG != null) {
                        sF = sG.bDp();
                        bDr.a(1, sF);
                        sF.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = sF;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.bDs() == 1) {
                        List list = (List) bVar.ud();
                        b.bq(dVar.bDn());
                        for (BdUniqueId bdUniqueId : b.bDm()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.bDs() == 2) {
                        dVar.bt(bVar.bDv());
                    } else if (bVar.bDs() == 3) {
                        List<q> threadList = bVar.getThreadList();
                        List<c> br = FrsFeedAdStatic.br(threadList);
                        if (bVar.bDx()) {
                            dVar.a(br, FrsFeedAdStatic.br(bVar.bDw()), bVar.bDy(), bVar.bDz());
                        } else {
                            dVar.d(br, bVar.bDz());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.bs(br));
                    } else if (bVar.bDs() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.bDs() == 5) {
                        dVar.a(FrsFeedAdStatic.br(bVar.getThreadList()), bVar.getForumId(), bVar.bDB(), bVar.bDC(), bVar.bDD(), bVar.bDA(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
