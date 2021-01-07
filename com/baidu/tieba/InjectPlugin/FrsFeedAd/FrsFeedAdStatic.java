package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.InjectPlugin.a.e;
import com.baidu.tieba.recapp.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class FrsFeedAdStatic {
    static {
        MessageManager.getInstance().registerListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> bS(List<n> list) {
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            c cVar = new c();
            if (nVar instanceof bz) {
                bz bzVar = (bz) nVar;
                if (bzVar.brm() == 1) {
                    cVar.setThreadType(1);
                } else if (bzVar.brm() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.aC(nVar);
            } else if (nVar instanceof b) {
                cVar.setThreadType(3);
                cVar.um(((b) nVar).bMP());
                cVar.aC(((b) nVar).bMO());
            } else {
                cVar.setThreadType(4);
                cVar.aC(nVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<n> bT(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.aC(cVar.bMO());
                bVar.um(cVar.bMP());
                arrayList.add(bVar);
            } else if (cVar.bMO() instanceof n) {
                arrayList.add((n) cVar.bMO());
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
            com.baidu.tieba.InjectPlugin.a.b bMV;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (bMV = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).bMV()) != null && (bMV instanceof p)) {
                p pVar = (p) bMV;
                com.baidu.tieba.InjectPlugin.a.a un = bMV.un(1);
                if (un == null) {
                    com.baidu.tieba.InjectPlugin.a.d uo = e.bMU().uo(1);
                    if (uo != null) {
                        un = uo.bMT();
                        bMV.a(1, un);
                        un.init(new com.baidu.tieba.InjectPlugin.a.c(pVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = un;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.bMW() == 1) {
                        List list = (List) bVar.tF();
                        b.bR(dVar.bMR());
                        for (BdUniqueId bdUniqueId : b.bMQ()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(pVar, bdUniqueId);
                            aVar2.setPageContext(pVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.bMW() == 2) {
                        dVar.bU(bVar.bMZ());
                    } else if (bVar.bMW() == 3) {
                        List<n> threadList = bVar.getThreadList();
                        List<c> bS = FrsFeedAdStatic.bS(threadList);
                        if (bVar.bNb()) {
                            dVar.a(bS, FrsFeedAdStatic.bS(bVar.bNa()), bVar.bNc(), bVar.bNd());
                        } else {
                            dVar.d(bS, bVar.bNd());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.bT(bS));
                    } else if (bVar.bMW() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.bMW() == 5) {
                        dVar.a(FrsFeedAdStatic.bS(bVar.getThreadList()), bVar.getForumId(), bVar.bNf(), bVar.bNg(), bVar.bNh(), bVar.bNe(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
