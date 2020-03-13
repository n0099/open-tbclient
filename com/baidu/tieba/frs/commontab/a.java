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
    private m gtf;
    private FrsCommonTabFragment gvG;
    private i gvH;
    private i gvI;
    private aa gvJ;
    private ae gvK;
    private ae gvL;
    private boolean isDynamic;
    private List<com.baidu.adp.widget.ListView.a> asF = new LinkedList();
    private CustomMessageListener gvM = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof w) && "FrsHottopicDelegateAdapter".equals(((w) aVar).bvj()) && a.this.asF != null) {
                        ((w) aVar).a(a.this.gvG.getPageContext(), a.this.gvG.getUniqueId());
                        if (a.this.isDynamic) {
                            ((w) aVar).setFrom("c13010");
                        }
                        a.this.asF.add(aVar);
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
        this.gvG = frsCommonTabFragment;
        this.gvM.setPriority(1);
        this.gvM.setSelfListener(true);
        this.gvG.registerListener(this.gvM);
        this.gvH = new i(frsCommonTabFragment.getPageContext(), bj.cRk, this.gvG.getUniqueId());
        this.gvI = new i(frsCommonTabFragment.getPageContext(), bj.cRz, this.gvG.getUniqueId());
        this.gvJ = new aa(frsCommonTabFragment.getPageContext(), bj.cRE, this.gvG.getUniqueId());
        this.gvK = new ae(frsCommonTabFragment.getPageContext(), bj.cRA, this.gvG.getUniqueId());
        this.gvK.gvS = this.gvG.gvS;
        this.gvL = new ae(frsCommonTabFragment.getPageContext(), bj.cRI, this.gvG.getUniqueId());
        this.gvL.gvS = this.gvG.gvS;
        this.gtf = new m(frsCommonTabFragment.getPageContext(), n.grn);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), bj.cRx, frsCommonTabFragment.getUniqueId());
        this.asF.add(this.gvH);
        this.asF.add(this.gvI);
        this.asF.add(this.gvJ);
        this.asF.add(this.gvK);
        this.asF.add(this.gvL);
        this.asF.add(this.gtf);
        this.asF.add(aVar);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.gvH.setFrom("c13010");
            this.gvI.setFrom("c13010");
            this.gvJ.setFrom("c13010");
            this.gvK.setFrom("c13010");
            this.gvL.setFrom("c13010");
            wP("page_frs_dynamic");
        }
        if (frsCommonTabFragment.tabId == 502) {
            b(frsViewData);
        }
        bFV();
        bdTypeRecyclerView.addAdapters(this.asF);
        bGz();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.BK.setData(arrayList);
    }

    private void bFV() {
        if (!v.isEmpty(this.asF) && this.gvG != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.gvG.getTbPageTag());
                }
            }
        }
    }

    private void bGz() {
        if (this.gvG != null && !v.isEmpty(this.asF)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.bGY() != null) {
                        dVar.bGY().gJy = this.gvG.gvR;
                        dVar.bGY().gJA = this.gvG.forumId;
                        dVar.bGY().gJB = this.gvG.tabId;
                        if (this.gvG.tabId == 502) {
                            dVar.bGY().gJD = 10;
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
        for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    private void wP(String str) {
        if (this.asF != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if (aVar instanceof f) {
                    ((f) aVar).wP(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.asF != null && this.asF.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void lL(boolean z) {
        if (this.gvH != null) {
            this.gvH.lN(z);
        }
        if (this.gvI != null) {
            this.gvI.lN(z);
        }
        if (this.gvK != null) {
            this.gvK.lN(z);
        }
        if (this.gvL != null) {
            this.gvL.lN(z);
        }
    }
}
