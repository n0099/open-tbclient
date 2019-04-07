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
                if (bgVar.YJ() == 1) {
                    cVar.setThreadType(1);
                } else if (bgVar.YJ() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.ah(mVar);
            } else if (mVar instanceof b) {
                cVar.setThreadType(3);
                cVar.lh(((b) mVar).aue());
                cVar.ah(((b) mVar).aud());
            } else {
                cVar.setThreadType(4);
                cVar.ah(mVar);
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
                bVar.ah(cVar.aud());
                bVar.lh(cVar.aue());
                arrayList.add(bVar);
            } else if (cVar.aud() instanceof m) {
                arrayList.add((m) cVar.aud());
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
            com.baidu.tieba.InjectPlugin.a.b auk;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (auk = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).auk()) != null && (auk instanceof n)) {
                n nVar = (n) auk;
                com.baidu.tieba.InjectPlugin.a.a li = auk.li(1);
                if (li == null) {
                    com.baidu.tieba.InjectPlugin.a.d lj = e.auj().lj(1);
                    if (lj != null) {
                        li = lj.aui();
                        auk.a(1, li);
                        li.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = li;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.aul() == 1) {
                        List list = (List) bVar.rD();
                        b.ak(dVar.aug());
                        for (BdUniqueId bdUniqueId : b.auf()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.aul() == 2) {
                        dVar.an(bVar.auo());
                    } else if (bVar.aul() == 3) {
                        List<m> threadList = bVar.getThreadList();
                        List<c> al = FrsFeedAdStatic.al(threadList);
                        if (bVar.auq()) {
                            dVar.a(al, FrsFeedAdStatic.al(bVar.aup()), bVar.isRefresh(), bVar.aur());
                        } else {
                            dVar.f(al, bVar.aur());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.am(al));
                    } else if (bVar.aul() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.aul() == 5) {
                        dVar.a(FrsFeedAdStatic.al(bVar.getThreadList()), bVar.getForumId(), bVar.aut(), bVar.auu(), bVar.auv(), bVar.aus(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
