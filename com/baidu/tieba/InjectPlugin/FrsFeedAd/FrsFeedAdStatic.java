package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bk;
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
    public static List<c> aV(List<o> list) {
        ArrayList arrayList = new ArrayList();
        for (o oVar : list) {
            c cVar = new c();
            if (oVar instanceof bk) {
                bk bkVar = (bk) oVar;
                if (bkVar.aQs() == 1) {
                    cVar.setThreadType(1);
                } else if (bkVar.aQs() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.as(oVar);
            } else if (oVar instanceof b) {
                cVar.setThreadType(3);
                cVar.oN(((b) oVar).bjX());
                cVar.as(((b) oVar).bjW());
            } else {
                cVar.setThreadType(4);
                cVar.as(oVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<o> aW(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.as(cVar.bjW());
                bVar.oN(cVar.bjX());
                arrayList.add(bVar);
            } else if (cVar.bjW() instanceof o) {
                arrayList.add((o) cVar.bjW());
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
            com.baidu.tieba.InjectPlugin.a.b bkd;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (bkd = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).bkd()) != null && (bkd instanceof m)) {
                m mVar = (m) bkd;
                com.baidu.tieba.InjectPlugin.a.a oO = bkd.oO(1);
                if (oO == null) {
                    com.baidu.tieba.InjectPlugin.a.d oP = e.bkc().oP(1);
                    if (oP != null) {
                        oO = oP.bkb();
                        bkd.a(1, oO);
                        oO.init(new com.baidu.tieba.InjectPlugin.a.c(mVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = oO;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.bke() == 1) {
                        List list = (List) bVar.rS();
                        b.aU(dVar.bjZ());
                        for (BdUniqueId bdUniqueId : b.bjY()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(mVar, bdUniqueId);
                            aVar2.setPageContext(mVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.bke() == 2) {
                        dVar.aX(bVar.bkh());
                    } else if (bVar.bke() == 3) {
                        List<o> threadList = bVar.getThreadList();
                        List<c> aV = FrsFeedAdStatic.aV(threadList);
                        if (bVar.bkj()) {
                            dVar.a(aV, FrsFeedAdStatic.aV(bVar.bki()), bVar.bkk(), bVar.bkl());
                        } else {
                            dVar.d(aV, bVar.bkl());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.aW(aV));
                    } else if (bVar.bke() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.bke() == 5) {
                        dVar.a(FrsFeedAdStatic.aV(bVar.getThreadList()), bVar.getForumId(), bVar.bkn(), bVar.bko(), bVar.bkp(), bVar.bkm(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
