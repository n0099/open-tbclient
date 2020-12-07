package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.InjectPlugin.a.e;
import com.baidu.tieba.recapp.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class FrsFeedAdStatic {
    static {
        MessageManager.getInstance().registerListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> bL(List<q> list) {
        ArrayList arrayList = new ArrayList();
        for (q qVar : list) {
            c cVar = new c();
            if (qVar instanceof by) {
                by byVar = (by) qVar;
                if (byVar.boK() == 1) {
                    cVar.setThreadType(1);
                } else if (byVar.boK() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.aA(qVar);
            } else if (qVar instanceof b) {
                cVar.setThreadType(3);
                cVar.ua(((b) qVar).bKw());
                cVar.aA(((b) qVar).bKv());
            } else {
                cVar.setThreadType(4);
                cVar.aA(qVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<q> bM(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.aA(cVar.bKv());
                bVar.ua(cVar.bKw());
                arrayList.add(bVar);
            } else if (cVar.bKv() instanceof q) {
                arrayList.add((q) cVar.bKv());
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
            com.baidu.tieba.InjectPlugin.a.b bKC;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (bKC = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).bKC()) != null && (bKC instanceof p)) {
                p pVar = (p) bKC;
                com.baidu.tieba.InjectPlugin.a.a ub = bKC.ub(1);
                if (ub == null) {
                    com.baidu.tieba.InjectPlugin.a.d uc = e.bKB().uc(1);
                    if (uc != null) {
                        ub = uc.bKA();
                        bKC.a(1, ub);
                        ub.init(new com.baidu.tieba.InjectPlugin.a.c(pVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = ub;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.bKD() == 1) {
                        List list = (List) bVar.ug();
                        b.bK(dVar.bKy());
                        for (BdUniqueId bdUniqueId : b.bKx()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(pVar, bdUniqueId);
                            aVar2.setPageContext(pVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.bKD() == 2) {
                        dVar.bN(bVar.bKG());
                    } else if (bVar.bKD() == 3) {
                        List<q> threadList = bVar.getThreadList();
                        List<c> bL = FrsFeedAdStatic.bL(threadList);
                        if (bVar.bKI()) {
                            dVar.a(bL, FrsFeedAdStatic.bL(bVar.bKH()), bVar.bKJ(), bVar.bKK());
                        } else {
                            dVar.d(bL, bVar.bKK());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.bM(bL));
                    } else if (bVar.bKD() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.bKD() == 5) {
                        dVar.a(FrsFeedAdStatic.bL(bVar.getThreadList()), bVar.getForumId(), bVar.bKM(), bVar.bKN(), bVar.bKO(), bVar.bKL(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
