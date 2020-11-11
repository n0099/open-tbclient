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
    public static List<c> bH(List<q> list) {
        ArrayList arrayList = new ArrayList();
        for (q qVar : list) {
            c cVar = new c();
            if (qVar instanceof bw) {
                bw bwVar = (bw) qVar;
                if (bwVar.bmv() == 1) {
                    cVar.setThreadType(1);
                } else if (bwVar.bmv() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.aA(qVar);
            } else if (qVar instanceof b) {
                cVar.setThreadType(3);
                cVar.sZ(((b) qVar).bHD());
                cVar.aA(((b) qVar).bHC());
            } else {
                cVar.setThreadType(4);
                cVar.aA(qVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<q> bI(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.aA(cVar.bHC());
                bVar.sZ(cVar.bHD());
                arrayList.add(bVar);
            } else if (cVar.bHC() instanceof q) {
                arrayList.add((q) cVar.bHC());
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
            com.baidu.tieba.InjectPlugin.a.b bHJ;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (bHJ = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).bHJ()) != null && (bHJ instanceof n)) {
                n nVar = (n) bHJ;
                com.baidu.tieba.InjectPlugin.a.a ta = bHJ.ta(1);
                if (ta == null) {
                    com.baidu.tieba.InjectPlugin.a.d tb = e.bHI().tb(1);
                    if (tb != null) {
                        ta = tb.bHH();
                        bHJ.a(1, ta);
                        ta.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = ta;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.bHK() == 1) {
                        List list = (List) bVar.ud();
                        b.bG(dVar.bHF());
                        for (BdUniqueId bdUniqueId : b.bHE()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.bHK() == 2) {
                        dVar.bJ(bVar.bHN());
                    } else if (bVar.bHK() == 3) {
                        List<q> threadList = bVar.getThreadList();
                        List<c> bH = FrsFeedAdStatic.bH(threadList);
                        if (bVar.bHP()) {
                            dVar.a(bH, FrsFeedAdStatic.bH(bVar.bHO()), bVar.bHQ(), bVar.bHR());
                        } else {
                            dVar.d(bH, bVar.bHR());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.bI(bH));
                    } else if (bVar.bHK() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.bHK() == 5) {
                        dVar.a(FrsFeedAdStatic.bH(bVar.getThreadList()), bVar.getForumId(), bVar.bHT(), bVar.bHU(), bVar.bHV(), bVar.bHS(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
