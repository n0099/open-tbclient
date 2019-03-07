package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bg;
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
    public static List<c> al(List<m> list) {
        ArrayList arrayList = new ArrayList();
        for (m mVar : list) {
            c cVar = new c();
            if (mVar instanceof bg) {
                bg bgVar = (bg) mVar;
                if (bgVar.YM() == 1) {
                    cVar.setThreadType(1);
                } else if (bgVar.YM() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.aj(mVar);
            } else if (mVar instanceof b) {
                cVar.setThreadType(3);
                cVar.li(((b) mVar).auh());
                cVar.aj(((b) mVar).aug());
            } else {
                cVar.setThreadType(4);
                cVar.aj(mVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<m> am(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.aj(cVar.aug());
                bVar.li(cVar.auh());
                arrayList.add(bVar);
            } else if (cVar.aug() instanceof m) {
                arrayList.add((m) cVar.aug());
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
            com.baidu.tieba.InjectPlugin.a.b aun;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (aun = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).aun()) != null && (aun instanceof n)) {
                n nVar = (n) aun;
                com.baidu.tieba.InjectPlugin.a.a lj = aun.lj(1);
                if (lj == null) {
                    com.baidu.tieba.InjectPlugin.a.d lk = e.aum().lk(1);
                    if (lk != null) {
                        lj = lk.aul();
                        aun.a(1, lj);
                        lj.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = lj;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.auo() == 1) {
                        List list = (List) bVar.rD();
                        b.ak(dVar.auj());
                        for (BdUniqueId bdUniqueId : b.aui()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.auo() == 2) {
                        dVar.an(bVar.aur());
                    } else if (bVar.auo() == 3) {
                        List<m> threadList = bVar.getThreadList();
                        List<c> al = FrsFeedAdStatic.al(threadList);
                        if (bVar.aut()) {
                            dVar.a(al, FrsFeedAdStatic.al(bVar.aus()), bVar.isRefresh(), bVar.auu());
                        } else {
                            dVar.f(al, bVar.auu());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.am(al));
                    } else if (bVar.auo() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.auo() == 5) {
                        dVar.a(FrsFeedAdStatic.al(bVar.getThreadList()), bVar.getForumId(), bVar.auw(), bVar.aux(), bVar.auy(), bVar.auv(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
