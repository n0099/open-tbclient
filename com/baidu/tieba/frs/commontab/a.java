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
    private m gsS;
    private FrsCommonTabFragment gvu;
    private i gvv;
    private i gvw;
    private aa gvx;
    private ae gvy;
    private ae gvz;
    private boolean isDynamic;
    private List<com.baidu.adp.widget.ListView.a> asE = new LinkedList();
    private CustomMessageListener gvA = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof w) && "FrsHottopicDelegateAdapter".equals(((w) aVar).bvi()) && a.this.asE != null) {
                        ((w) aVar).a(a.this.gvu.getPageContext(), a.this.gvu.getUniqueId());
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
        this.gvu = frsCommonTabFragment;
        this.gvA.setPriority(1);
        this.gvA.setSelfListener(true);
        this.gvu.registerListener(this.gvA);
        this.gvv = new i(frsCommonTabFragment.getPageContext(), bj.cRj, this.gvu.getUniqueId());
        this.gvw = new i(frsCommonTabFragment.getPageContext(), bj.cRy, this.gvu.getUniqueId());
        this.gvx = new aa(frsCommonTabFragment.getPageContext(), bj.cRD, this.gvu.getUniqueId());
        this.gvy = new ae(frsCommonTabFragment.getPageContext(), bj.cRz, this.gvu.getUniqueId());
        this.gvy.gvG = this.gvu.gvG;
        this.gvz = new ae(frsCommonTabFragment.getPageContext(), bj.cRH, this.gvu.getUniqueId());
        this.gvz.gvG = this.gvu.gvG;
        this.gsS = new m(frsCommonTabFragment.getPageContext(), n.gra);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), bj.cRw, frsCommonTabFragment.getUniqueId());
        this.asE.add(this.gvv);
        this.asE.add(this.gvw);
        this.asE.add(this.gvx);
        this.asE.add(this.gvy);
        this.asE.add(this.gvz);
        this.asE.add(this.gsS);
        this.asE.add(aVar);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.gvv.setFrom("c13010");
            this.gvw.setFrom("c13010");
            this.gvx.setFrom("c13010");
            this.gvy.setFrom("c13010");
            this.gvz.setFrom("c13010");
            wO("page_frs_dynamic");
        }
        if (frsCommonTabFragment.tabId == 502) {
            b(frsViewData);
        }
        bFU();
        bdTypeRecyclerView.addAdapters(this.asE);
        bGy();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.BK.setData(arrayList);
    }

    private void bFU() {
        if (!v.isEmpty(this.asE) && this.gvu != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.gvu.getTbPageTag());
                }
            }
        }
    }

    private void bGy() {
        if (this.gvu != null && !v.isEmpty(this.asE)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.bGX() != null) {
                        dVar.bGX().gJm = this.gvu.gvF;
                        dVar.bGX().gJo = this.gvu.forumId;
                        dVar.bGX().gJp = this.gvu.tabId;
                        if (this.gvu.tabId == 502) {
                            dVar.bGX().gJr = 10;
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
        if (this.gvv != null) {
            this.gvv.lN(z);
        }
        if (this.gvw != null) {
            this.gvw.lN(z);
        }
        if (this.gvy != null) {
            this.gvy.lN(z);
        }
        if (this.gvz != null) {
            this.gvz.lN(z);
        }
    }
}
