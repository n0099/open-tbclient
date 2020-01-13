package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.a.f;
import com.baidu.tieba.card.w;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.aa;
import com.baidu.tieba.frs.entelechy.a.ae;
import com.baidu.tieba.frs.entelechy.a.i;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private BdTypeRecyclerView Bs;
    private m gqP;
    private FrsCommonTabFragment gtr;
    private i gts;
    private i gtt;
    private aa gtu;
    private ae gtv;
    private ae gtw;
    private boolean isDynamic;
    private List<com.baidu.adp.widget.ListView.a> apl = new LinkedList();
    private CustomMessageListener gtx = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof w) && "FrsHottopicDelegateAdapter".equals(((w) aVar).btC()) && a.this.apl != null) {
                        ((w) aVar).a(a.this.gtr.getPageContext(), a.this.gtr.getUniqueId());
                        if (a.this.isDynamic) {
                            ((w) aVar).setFrom("c13010");
                        }
                        a.this.apl.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData);
        this.Bs = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.gtr = frsCommonTabFragment;
        this.gtx.setPriority(1);
        this.gtx.setSelfListener(true);
        this.gtr.registerListener(this.gtx);
        this.gts = new i(frsCommonTabFragment.getPageContext(), bj.cNf, this.gtr.getUniqueId());
        this.gtt = new i(frsCommonTabFragment.getPageContext(), bj.cNu, this.gtr.getUniqueId());
        this.gtu = new aa(frsCommonTabFragment.getPageContext(), bj.cNz, this.gtr.getUniqueId());
        this.gtv = new ae(frsCommonTabFragment.getPageContext(), bj.cNv, this.gtr.getUniqueId());
        this.gtv.gtD = this.gtr.gtD;
        this.gtw = new ae(frsCommonTabFragment.getPageContext(), bj.cND, this.gtr.getUniqueId());
        this.gtw.gtD = this.gtr.gtD;
        this.gqP = new m(frsCommonTabFragment.getPageContext(), n.goX);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), bj.cNs, frsCommonTabFragment.getUniqueId());
        this.apl.add(this.gts);
        this.apl.add(this.gtt);
        this.apl.add(this.gtu);
        this.apl.add(this.gtv);
        this.apl.add(this.gtw);
        this.apl.add(this.gqP);
        this.apl.add(aVar);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.gts.setFrom("c13010");
            this.gtt.setFrom("c13010");
            this.gtu.setFrom("c13010");
            this.gtv.setFrom("c13010");
            this.gtw.setFrom("c13010");
            wu("page_frs_dynamic");
        }
        if (frsCommonTabFragment.tabId == 502) {
            b(frsViewData);
        }
        bEq();
        bdTypeRecyclerView.addAdapters(this.apl);
        bEU();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.Bs.setData(arrayList);
    }

    private void bEq() {
        if (!v.isEmpty(this.apl) && this.gtr != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.gtr.getTbPageTag());
                }
            }
        }
    }

    private void bEU() {
        if (this.gtr != null && !v.isEmpty(this.apl)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.bFt() != null) {
                        dVar.bFt().gHl = this.gtr.gtC;
                        dVar.bFt().gHn = this.gtr.forumId;
                        dVar.bFt().gHo = this.gtr.tabId;
                        if (this.gtr.tabId == 502) {
                            dVar.bFt().gHq = 10;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.Bs.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    private void wu(String str) {
        if (this.apl != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar instanceof f) {
                    ((f) aVar).wu(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.apl != null && this.apl.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void lI(boolean z) {
        if (this.gts != null) {
            this.gts.lK(z);
        }
        if (this.gtt != null) {
            this.gtt.lK(z);
        }
        if (this.gtv != null) {
            this.gtv.lK(z);
        }
        if (this.gtw != null) {
            this.gtw.lK(z);
        }
    }
}
