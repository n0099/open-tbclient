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
                cVar.oL(((b) oVar).bjV());
                cVar.as(((b) oVar).bjU());
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
                bVar.as(cVar.bjU());
                bVar.oL(cVar.bjV());
                arrayList.add(bVar);
            } else if (cVar.bjU() instanceof o) {
                arrayList.add((o) cVar.bjU());
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
            com.baidu.tieba.InjectPlugin.a.b bkb;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (bkb = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).bkb()) != null && (bkb instanceof m)) {
                m mVar = (m) bkb;
                com.baidu.tieba.InjectPlugin.a.a oM = bkb.oM(1);
                if (oM == null) {
                    com.baidu.tieba.InjectPlugin.a.d oN = e.bka().oN(1);
                    if (oN != null) {
                        oM = oN.bjZ();
                        bkb.a(1, oM);
                        oM.init(new com.baidu.tieba.InjectPlugin.a.c(mVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = oM;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.bkc() == 1) {
                        List list = (List) bVar.rS();
                        b.aU(dVar.bjX());
                        for (BdUniqueId bdUniqueId : b.bjW()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(mVar, bdUniqueId);
                            aVar2.setPageContext(mVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.bkc() == 2) {
                        dVar.aX(bVar.bkf());
                    } else if (bVar.bkc() == 3) {
                        List<o> threadList = bVar.getThreadList();
                        List<c> aV = FrsFeedAdStatic.aV(threadList);
                        if (bVar.bkh()) {
                            dVar.a(aV, FrsFeedAdStatic.aV(bVar.bkg()), bVar.bki(), bVar.bkj());
                        } else {
                            dVar.d(aV, bVar.bkj());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.aW(aV));
                    } else if (bVar.bkc() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.bkc() == 5) {
                        dVar.a(FrsFeedAdStatic.aV(bVar.getThreadList()), bVar.getForumId(), bVar.bkl(), bVar.bkm(), bVar.bkn(), bVar.bkk(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
