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
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView BK;
    private m gsQ;
    private FrsCommonTabFragment gvs;
    private i gvt;
    private i gvu;
    private aa gvv;
    private ae gvw;
    private ae gvx;
    private boolean isDynamic;
    private List<com.baidu.adp.widget.ListView.a> asE = new LinkedList();
    private CustomMessageListener gvy = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof w) && "FrsHottopicDelegateAdapter".equals(((w) aVar).bvg()) && a.this.asE != null) {
                        ((w) aVar).a(a.this.gvs.getPageContext(), a.this.gvs.getUniqueId());
                        if (a.this.isDynamic) {
                            ((w) aVar).setFrom("c13010");
                        }
                        a.this.asE.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData);
        this.BK = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.gvs = frsCommonTabFragment;
        this.gvy.setPriority(1);
        this.gvy.setSelfListener(true);
        this.gvs.registerListener(this.gvy);
        this.gvt = new i(frsCommonTabFragment.getPageContext(), bj.cRi, this.gvs.getUniqueId());
        this.gvu = new i(frsCommonTabFragment.getPageContext(), bj.cRx, this.gvs.getUniqueId());
        this.gvv = new aa(frsCommonTabFragment.getPageContext(), bj.cRC, this.gvs.getUniqueId());
        this.gvw = new ae(frsCommonTabFragment.getPageContext(), bj.cRy, this.gvs.getUniqueId());
        this.gvw.gvE = this.gvs.gvE;
        this.gvx = new ae(frsCommonTabFragment.getPageContext(), bj.cRG, this.gvs.getUniqueId());
        this.gvx.gvE = this.gvs.gvE;
        this.gsQ = new m(frsCommonTabFragment.getPageContext(), n.gqY);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), bj.cRv, frsCommonTabFragment.getUniqueId());
        this.asE.add(this.gvt);
        this.asE.add(this.gvu);
        this.asE.add(this.gvv);
        this.asE.add(this.gvw);
        this.asE.add(this.gvx);
        this.asE.add(this.gsQ);
        this.asE.add(aVar);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.gvt.setFrom("c13010");
            this.gvu.setFrom("c13010");
            this.gvv.setFrom("c13010");
            this.gvw.setFrom("c13010");
            this.gvx.setFrom("c13010");
            wO("page_frs_dynamic");
        }
        if (frsCommonTabFragment.tabId == 502) {
            b(frsViewData);
        }
        bFS();
        bdTypeRecyclerView.addAdapters(this.asE);
        bGw();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.BK.setData(arrayList);
    }

    private void bFS() {
        if (!v.isEmpty(this.asE) && this.gvs != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.gvs.getTbPageTag());
                }
            }
        }
    }

    private void bGw() {
        if (this.gvs != null && !v.isEmpty(this.asE)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.bGV() != null) {
                        dVar.bGV().gJk = this.gvs.gvD;
                        dVar.bGV().gJm = this.gvs.forumId;
                        dVar.bGV().gJn = this.gvs.tabId;
                        if (this.gvs.tabId == 502) {
                            dVar.bGV().gJp = 10;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.BK.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    private void wO(String str) {
        if (this.asE != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof f) {
                    ((f) aVar).wO(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.asE != null && this.asE.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void lL(boolean z) {
        if (this.gvt != null) {
            this.gvt.lN(z);
        }
        if (this.gvu != null) {
            this.gvu.lN(z);
        }
        if (this.gvw != null) {
            this.gvw.lN(z);
        }
        if (this.gvx != null) {
            this.gvx.lN(z);
        }
    }
}
