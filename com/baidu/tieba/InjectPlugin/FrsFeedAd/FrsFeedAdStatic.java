package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tieba.InjectPlugin.a.e;
import com.baidu.tieba.recapp.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class FrsFeedAdStatic {
    static {
        MessageManager.getInstance().registerListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> bH(List<q> list) {
        ArrayList arrayList = new ArrayList();
        for (q qVar : list) {
            c cVar = new c();
            if (qVar instanceof bx) {
                bx bxVar = (bx) qVar;
                if (bxVar.blx() == 1) {
                    cVar.setThreadType(1);
                } else if (bxVar.blx() == 0) {
                    cVar.setThreadType(2);
                } else {
                    cVar.setThreadType(4);
                }
                cVar.aA(qVar);
            } else if (qVar instanceof b) {
                cVar.setThreadType(3);
                cVar.tx(((b) qVar).bGW());
                cVar.aA(((b) qVar).bGV());
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
                bVar.aA(cVar.bGV());
                bVar.tx(cVar.bGW());
                arrayList.add(bVar);
            } else if (cVar.bGV() instanceof q) {
                arrayList.add((q) cVar.bGV());
            }
        }
        return arrayList;
    }

    /* loaded from: classes20.dex */
    static final class a extends CustomMessageListener {
        public a() {
            super(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.InjectPlugin.b.b bVar;
            com.baidu.tieba.InjectPlugin.a.b bHc;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.b) && (bHc = (bVar = (com.baidu.tieba.InjectPlugin.b.b) customResponsedMessage.getData()).bHc()) != null && (bHc instanceof o)) {
                o oVar = (o) bHc;
                com.baidu.tieba.InjectPlugin.a.a ty = bHc.ty(1);
                if (ty == null) {
                    com.baidu.tieba.InjectPlugin.a.d tz = e.bHb().tz(1);
                    if (tz != null) {
                        ty = tz.bHa();
                        bHc.a(1, ty);
                        ty.init(new com.baidu.tieba.InjectPlugin.a.c(oVar));
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar = ty;
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    if (bVar.bHd() == 1) {
                        List list = (List) bVar.ud();
                        b.bG(dVar.bGY());
                        for (BdUniqueId bdUniqueId : b.bGX()) {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.a aVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.a(oVar, bdUniqueId);
                            aVar2.setPageContext(oVar.getTbPageContext());
                            list.add(aVar2);
                        }
                    } else if (bVar.bHd() == 2) {
                        dVar.bJ(bVar.bHg());
                    } else if (bVar.bHd() == 3) {
                        List<q> threadList = bVar.getThreadList();
                        List<c> bH = FrsFeedAdStatic.bH(threadList);
                        if (bVar.bHi()) {
                            dVar.a(bH, FrsFeedAdStatic.bH(bVar.bHh()), bVar.bHj(), bVar.bHk());
                        } else {
                            dVar.d(bH, bVar.bHk());
                        }
                        threadList.clear();
                        threadList.addAll(FrsFeedAdStatic.bI(bH));
                    } else if (bVar.bHd() == 4) {
                        dVar.changeSkinType(bVar.getSkinType());
                    } else if (bVar.bHd() == 5) {
                        dVar.a(FrsFeedAdStatic.bH(bVar.getThreadList()), bVar.getForumId(), bVar.bHm(), bVar.bHn(), bVar.bHo(), bVar.bHl(), bVar.getPageNum());
                    }
                }
            }
        }
    }
}
