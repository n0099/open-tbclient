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
                if (bhVar.aex() == 1) {
                    cVar.setThreadType(1);
                } else if (bhVar.aex() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.aj(mVar);
            } else if (mVar instanceof b) {
                cVar.setThreadType(3);
                cVar.mi(((b) mVar).aAO());
                cVar.aj(((b) mVar).aAN());
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
                bVar.aj(cVar.aAN());
                bVar.mi(cVar.aAO());
                arrayList.add(bVar);
            } else if (cVar.aAN() instanceof m) {
                arrayList.add((m) cVar.aAN());
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
            com.baidu.tieba.InjectPlugin.a.b aAU;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (aAU = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).aAU()) != null && (aAU instanceof n)) {
                n nVar = (n) aAU;
                com.baidu.tieba.InjectPlugin.a.a mj = aAU.mj(1);
                if (mj == null) {
                    com.baidu.tieba.InjectPlugin.a.d mk = e.aAT().mk(1);
                    if (mk != null) {
                        mj = mk.aAS();
                        aAU.a(1, mj);
                        mj.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = mj;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.aAV() == 1) {
                        List list = (List) bVar.qW();
                        b.ar(dVar.aAQ());
                        for (BdUniqueId bdUniqueId : b.aAP()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.aAV() == 2) {
                        dVar.au(bVar.aAY());
                    } else if (bVar.aAV() == 3) {
                        List<m> threadList = bVar.getThreadList();
                        List<c> as = FrsFeedAdStatic.as(threadList);
                        if (bVar.aBa()) {
                            dVar.a(as, FrsFeedAdStatic.as(bVar.aAZ()), bVar.isRefresh(), bVar.aBb());
                        } else {
                            dVar.f(as, bVar.aBb());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.at(as));
                    } else if (bVar.aAV() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.aAV() == 5) {
                        dVar.a(FrsFeedAdStatic.as(bVar.getThreadList()), bVar.getForumId(), bVar.aBd(), bVar.aBe(), bVar.aBf(), bVar.aBc(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
