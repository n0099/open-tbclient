package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tieba.InjectPlugin.a.e;
import com.baidu.tieba.recapp.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class FrsFeedAdStatic {
    static {
        MessageManager.getInstance().registerListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> bf(List<q> list) {
        ArrayList arrayList = new ArrayList();
        for (q qVar : list) {
            c cVar = new c();
            if (qVar instanceof bu) {
                bu buVar = (bu) qVar;
                if (buVar.aSk() == 1) {
                    cVar.setThreadType(1);
                } else if (buVar.aSk() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.at(qVar);
            } else if (qVar instanceof b) {
                cVar.setThreadType(3);
                cVar.pl(((b) qVar).bmw());
                cVar.at(((b) qVar).bmv());
            } else {
                cVar.setThreadType(4);
                cVar.at(qVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<q> bg(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.at(cVar.bmv());
                bVar.pl(cVar.bmw());
                arrayList.add(bVar);
            } else if (cVar.bmv() instanceof q) {
                arrayList.add((q) cVar.bmv());
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
            com.baidu.tieba.InjectPlugin.a.b bmC;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (bmC = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).bmC()) != null && (bmC instanceof m)) {
                m mVar = (m) bmC;
                com.baidu.tieba.InjectPlugin.a.a pm = bmC.pm(1);
                if (pm == null) {
                    com.baidu.tieba.InjectPlugin.a.d po = e.bmB().po(1);
                    if (po != null) {
                        pm = po.bmA();
                        bmC.a(1, pm);
                        pm.init(new com.baidu.tieba.InjectPlugin.a.c(mVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = pm;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.bmD() == 1) {
                        List list = (List) bVar.sk();
                        b.be(dVar.bmy());
                        for (BdUniqueId bdUniqueId : b.bmx()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(mVar, bdUniqueId);
                            aVar2.setPageContext(mVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.bmD() == 2) {
                        dVar.bh(bVar.bmG());
                    } else if (bVar.bmD() == 3) {
                        List<q> threadList = bVar.getThreadList();
                        List<c> bf = FrsFeedAdStatic.bf(threadList);
                        if (bVar.bmI()) {
                            dVar.a(bf, FrsFeedAdStatic.bf(bVar.bmH()), bVar.bmJ(), bVar.bmK());
                        } else {
                            dVar.d(bf, bVar.bmK());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.bg(bf));
                    } else if (bVar.bmD() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.bmD() == 5) {
                        dVar.a(FrsFeedAdStatic.bf(bVar.getThreadList()), bVar.getForumId(), bVar.bmM(), bVar.bmN(), bVar.bmO(), bVar.bmL(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
