package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.InjectPlugin.a.e;
import com.baidu.tieba.recapp.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsFeedAdStatic {
    static {
        MessageManager.getInstance().registerListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> as(List<m> list) {
        ArrayList arrayList = new ArrayList();
        for (m mVar : list) {
            c cVar = new c();
            if (mVar instanceof bh) {
                bh bhVar = (bh) mVar;
                if (bhVar.aet() == 1) {
                    cVar.setThreadType(1);
                } else if (bhVar.aet() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.aj(mVar);
            } else if (mVar instanceof b) {
                cVar.setThreadType(3);
                cVar.me(((b) mVar).aAA());
                cVar.aj(((b) mVar).aAz());
            } else {
                cVar.setThreadType(4);
                cVar.aj(mVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<m> at(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.aj(cVar.aAz());
                bVar.me(cVar.aAA());
                arrayList.add(bVar);
            } else if (cVar.aAz() instanceof m) {
                arrayList.add((m) cVar.aAz());
            }
        }
        return arrayList;
    }

    /* loaded from: classes3.dex */
    static final class a extends CustomMessageListener {
        public a() {
            super(2016515);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.InjectPlugin.b.b bVar;
            com.baidu.tieba.InjectPlugin.a.b aAG;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (aAG = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).aAG()) != null && (aAG instanceof n)) {
                n nVar = (n) aAG;
                com.baidu.tieba.InjectPlugin.a.a mf = aAG.mf(1);
                if (mf == null) {
                    com.baidu.tieba.InjectPlugin.a.d mg = e.aAF().mg(1);
                    if (mg != null) {
                        mf = mg.aAE();
                        aAG.a(1, mf);
                        mf.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = mf;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.aAH() == 1) {
                        List list = (List) bVar.qV();
                        b.ar(dVar.aAC());
                        for (BdUniqueId bdUniqueId : b.aAB()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.aAH() == 2) {
                        dVar.au(bVar.aAK());
                    } else if (bVar.aAH() == 3) {
                        List<m> threadList = bVar.getThreadList();
                        List<c> as = FrsFeedAdStatic.as(threadList);
                        if (bVar.aAM()) {
                            dVar.a(as, FrsFeedAdStatic.as(bVar.aAL()), bVar.isRefresh(), bVar.aAN());
                        } else {
                            dVar.f(as, bVar.aAN());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.at(as));
                    } else if (bVar.aAH() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.aAH() == 5) {
                        dVar.a(FrsFeedAdStatic.as(bVar.getThreadList()), bVar.getForumId(), bVar.aAP(), bVar.aAQ(), bVar.aAR(), bVar.aAO(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
