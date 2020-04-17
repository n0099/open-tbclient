package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.InjectPlugin.a.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class FrsFeedAdStatic {
    static {
        MessageManager.getInstance().registerListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> ba(List<m> list) {
        ArrayList arrayList = new ArrayList();
        for (m mVar : list) {
            c cVar = new c();
            if (mVar instanceof bj) {
                bj bjVar = (bj) mVar;
                if (bjVar.aKz() == 1) {
                    cVar.setThreadType(1);
                } else if (bjVar.aKz() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.an(mVar);
            } else if (mVar instanceof b) {
                cVar.setThreadType(3);
                cVar.og(((b) mVar).bdM());
                cVar.an(((b) mVar).bdL());
            } else {
                cVar.setThreadType(4);
                cVar.an(mVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<m> bb(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.an(cVar.bdL());
                bVar.og(cVar.bdM());
                arrayList.add(bVar);
            } else if (cVar.bdL() instanceof m) {
                arrayList.add((m) cVar.bdL());
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
            com.baidu.tieba.InjectPlugin.a.b bdS;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (bdS = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).bdS()) != null && (bdS instanceof com.baidu.tieba.recapp.m)) {
                com.baidu.tieba.recapp.m mVar = (com.baidu.tieba.recapp.m) bdS;
                com.baidu.tieba.InjectPlugin.a.a oh = bdS.oh(1);
                if (oh == null) {
                    com.baidu.tieba.InjectPlugin.a.d oi = e.bdR().oi(1);
                    if (oi != null) {
                        oh = oi.bdQ();
                        bdS.a(1, oh);
                        oh.init(new com.baidu.tieba.InjectPlugin.a.c(mVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = oh;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.bdT() == 1) {
                        List list = (List) bVar.rJ();
                        b.aZ(dVar.bdO());
                        for (BdUniqueId bdUniqueId : b.bdN()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(mVar, bdUniqueId);
                            aVar2.setPageContext(mVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.bdT() == 2) {
                        dVar.bc(bVar.bdW());
                    } else if (bVar.bdT() == 3) {
                        List<m> threadList = bVar.getThreadList();
                        List<c> ba = FrsFeedAdStatic.ba(threadList);
                        if (bVar.bdY()) {
                            dVar.a(ba, FrsFeedAdStatic.ba(bVar.bdX()), bVar.bdZ(), bVar.bea());
                        } else {
                            dVar.e(ba, bVar.bea());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.bb(ba));
                    } else if (bVar.bdT() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.bdT() == 5) {
                        dVar.a(FrsFeedAdStatic.ba(bVar.getThreadList()), bVar.getForumId(), bVar.bec(), bVar.bed(), bVar.bee(), bVar.beb(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
