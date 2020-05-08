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
                if (bjVar.aKx() == 1) {
                    cVar.setThreadType(1);
                } else if (bjVar.aKx() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.ao(mVar);
            } else if (mVar instanceof b) {
                cVar.setThreadType(3);
                cVar.og(((b) mVar).bdK());
                cVar.ao(((b) mVar).bdJ());
            } else {
                cVar.setThreadType(4);
                cVar.ao(mVar);
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
                bVar.ao(cVar.bdJ());
                bVar.og(cVar.bdK());
                arrayList.add(bVar);
            } else if (cVar.bdJ() instanceof m) {
                arrayList.add((m) cVar.bdJ());
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
            com.baidu.tieba.InjectPlugin.a.b bdQ;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (bdQ = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).bdQ()) != null && (bdQ instanceof com.baidu.tieba.recapp.m)) {
                com.baidu.tieba.recapp.m mVar = (com.baidu.tieba.recapp.m) bdQ;
                com.baidu.tieba.InjectPlugin.a.a oh = bdQ.oh(1);
                if (oh == null) {
                    com.baidu.tieba.InjectPlugin.a.d oi = e.bdP().oi(1);
                    if (oi != null) {
                        oh = oi.bdO();
                        bdQ.a(1, oh);
                        oh.init(new com.baidu.tieba.InjectPlugin.a.c(mVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = oh;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.bdR() == 1) {
                        List list = (List) bVar.rJ();
                        b.aZ(dVar.bdM());
                        for (BdUniqueId bdUniqueId : b.bdL()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(mVar, bdUniqueId);
                            aVar2.setPageContext(mVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.bdR() == 2) {
                        dVar.bc(bVar.bdU());
                    } else if (bVar.bdR() == 3) {
                        List<m> threadList = bVar.getThreadList();
                        List<c> ba = FrsFeedAdStatic.ba(threadList);
                        if (bVar.bdW()) {
                            dVar.a(ba, FrsFeedAdStatic.ba(bVar.bdV()), bVar.bdX(), bVar.bdY());
                        } else {
                            dVar.e(ba, bVar.bdY());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.bb(ba));
                    } else if (bVar.bdR() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.bdR() == 5) {
                        dVar.a(FrsFeedAdStatic.ba(bVar.getThreadList()), bVar.getForumId(), bVar.bea(), bVar.beb(), bVar.bec(), bVar.bdZ(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
