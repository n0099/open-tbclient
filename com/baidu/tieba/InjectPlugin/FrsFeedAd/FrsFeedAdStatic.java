package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bh;
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
    public static List<c> aK(List<m> list) {
        ArrayList arrayList = new ArrayList();
        for (m mVar : list) {
            c cVar = new c();
            if (mVar instanceof bh) {
                bh bhVar = (bh) mVar;
                if (bhVar.aiz() == 1) {
                    cVar.setThreadType(1);
                } else if (bhVar.aiz() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.af(mVar);
            } else if (mVar instanceof b) {
                cVar.setThreadType(3);
                cVar.lm(((b) mVar).aAW());
                cVar.af(((b) mVar).aAV());
            } else {
                cVar.setThreadType(4);
                cVar.af(mVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<m> aL(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (cVar.getThreadType() == 3) {
                b bVar = new b();
                bVar.af(cVar.aAV());
                bVar.lm(cVar.aAW());
                arrayList.add(bVar);
            } else if (cVar.aAV() instanceof m) {
                arrayList.add((m) cVar.aAV());
            }
        }
        return arrayList;
    }

    /* loaded from: classes3.dex */
    static final class a extends CustomMessageListener {
        public a() {
            super(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.InjectPlugin.b.b bVar;
            com.baidu.tieba.InjectPlugin.a.b aBc;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (aBc = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).aBc()) != null && (aBc instanceof n)) {
                n nVar = (n) aBc;
                com.baidu.tieba.InjectPlugin.a.a ln = aBc.ln(1);
                if (ln == null) {
                    com.baidu.tieba.InjectPlugin.a.d lo = e.aBb().lo(1);
                    if (lo != null) {
                        ln = lo.aBa();
                        aBc.a(1, ln);
                        ln.init(new com.baidu.tieba.InjectPlugin.a.c(nVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = ln;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.aBd() == 1) {
                        List list = (List) bVar.mb();
                        b.aJ(dVar.aAY());
                        for (BdUniqueId bdUniqueId : b.aAX()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(nVar, bdUniqueId);
                            aVar2.setPageContext(nVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.aBd() == 2) {
                        dVar.aM(bVar.aBg());
                    } else if (bVar.aBd() == 3) {
                        List<m> threadList = bVar.getThreadList();
                        List<c> aK = FrsFeedAdStatic.aK(threadList);
                        if (bVar.aBi()) {
                            dVar.a(aK, FrsFeedAdStatic.aK(bVar.aBh()), bVar.aBj(), bVar.aBk());
                        } else {
                            dVar.c(aK, bVar.aBk());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.aL(aK));
                    } else if (bVar.aBd() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.aBd() == 5) {
                        dVar.a(FrsFeedAdStatic.aK(bVar.getThreadList()), bVar.getForumId(), bVar.aBm(), bVar.aBn(), bVar.aBo(), bVar.aBl(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
