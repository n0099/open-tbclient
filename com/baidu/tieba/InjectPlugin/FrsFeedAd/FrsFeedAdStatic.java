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
                cVar.pl(((b) qVar).bmx());
                cVar.at(((b) qVar).bmw());
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
                bVar.at(cVar.bmw());
                bVar.pl(cVar.bmx());
                arrayList.add(bVar);
            } else if (cVar.bmw() instanceof q) {
                arrayList.add((q) cVar.bmw());
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
            com.baidu.tieba.InjectPlugin.a.b bmD;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (bmD = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).bmD()) != null && (bmD instanceof m)) {
                m mVar = (m) bmD;
                com.baidu.tieba.InjectPlugin.a.a pm = bmD.pm(1);
                if (pm == null) {
                    com.baidu.tieba.InjectPlugin.a.d po = e.bmC().po(1);
                    if (po != null) {
                        pm = po.bmB();
                        bmD.a(1, pm);
                        pm.init(new com.baidu.tieba.InjectPlugin.a.c(mVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = pm;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.bmE() == 1) {
                        List list = (List) bVar.sk();
                        b.be(dVar.bmz());
                        for (BdUniqueId bdUniqueId : b.bmy()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(mVar, bdUniqueId);
                            aVar2.setPageContext(mVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.bmE() == 2) {
                        dVar.bh(bVar.bmH());
                    } else if (bVar.bmE() == 3) {
                        List<q> threadList = bVar.getThreadList();
                        List<c> bf = FrsFeedAdStatic.bf(threadList);
                        if (bVar.bmJ()) {
                            dVar.a(bf, FrsFeedAdStatic.bf(bVar.bmI()), bVar.bmK(), bVar.bmL());
                        } else {
                            dVar.d(bf, bVar.bmL());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.bg(bf));
                    } else if (bVar.bmE() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.bmE() == 5) {
                        dVar.a(FrsFeedAdStatic.bf(bVar.getThreadList()), bVar.getForumId(), bVar.bmN(), bVar.bmO(), bVar.bmP(), bVar.bmM(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
