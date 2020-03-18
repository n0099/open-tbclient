package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.a.f;
import com.baidu.tieba.card.w;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.ac;
import com.baidu.tieba.frs.entelechy.a.ag;
import com.baidu.tieba.frs.entelechy.a.ah;
import com.baidu.tieba.frs.entelechy.a.j;
import com.baidu.tieba.frs.entelechy.a.k;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView BK;
    private n gtJ;
    private FrsCommonTabFragment gwk;
    private j gwl;
    private j gwm;
    private ac gwn;
    private ag gwo;
    private ag gwp;
    private com.baidu.tieba.frs.entelechy.a.c gwq;
    private k gwr;
    private ah gws;
    private boolean isDynamic;
    private List<com.baidu.adp.widget.ListView.a> asP = new LinkedList();
    private CustomMessageListener gwt = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof w) && "FrsHottopicDelegateAdapter".equals(((w) aVar).bvo()) && a.this.asP != null) {
                        ((w) aVar).a(a.this.gwk.getPageContext(), a.this.gwk.getUniqueId());
                        if (a.this.isDynamic) {
                            ((w) aVar).setFrom("c13010");
                        }
                        a.this.asP.add(aVar);
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
        this.gwk = frsCommonTabFragment;
        this.gwt.setPriority(1);
        this.gwt.setSelfListener(true);
        this.gwk.registerListener(this.gwt);
        this.gwl = new j(frsCommonTabFragment.getPageContext(), bj.cRx, this.gwk.getUniqueId());
        this.gwm = new j(frsCommonTabFragment.getPageContext(), bj.cRM, this.gwk.getUniqueId());
        this.gwn = new ac(frsCommonTabFragment.getPageContext(), bj.cRR, this.gwk.getUniqueId());
        this.gwo = new ag(frsCommonTabFragment.getPageContext(), bj.cRN, this.gwk.getUniqueId());
        this.gwo.gwz = this.gwk.gwz;
        this.gwp = new ag(frsCommonTabFragment.getPageContext(), bj.cRV, this.gwk.getUniqueId());
        this.gwp.gwz = this.gwk.gwz;
        this.gtJ = new n(frsCommonTabFragment.getPageContext(), o.grX);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), bj.cRK, frsCommonTabFragment.getUniqueId());
        this.gwq = new com.baidu.tieba.frs.entelechy.a.c(frsCommonTabFragment.getPageContext(), bj.cRT, this.gwk.getUniqueId());
        this.gwr = new k(frsCommonTabFragment.getPageContext(), bj.cRS, this.gwk.getUniqueId());
        this.gws = new ah(frsCommonTabFragment.getPageContext(), bj.cRU, this.gwk.getUniqueId());
        this.asP.add(this.gwl);
        this.asP.add(this.gwm);
        this.asP.add(this.gwn);
        this.asP.add(this.gwo);
        this.asP.add(this.gwp);
        this.asP.add(this.gtJ);
        this.asP.add(aVar);
        this.asP.add(this.gwq);
        this.asP.add(this.gwr);
        this.asP.add(this.gws);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.gwl.setFrom("c13010");
            this.gwm.setFrom("c13010");
            this.gwn.setFrom("c13010");
            this.gwo.setFrom("c13010");
            this.gwp.setFrom("c13010");
            wP("page_frs_dynamic");
        }
        this.gwl.pB(frsCommonTabFragment.tabId);
        this.gwm.pB(frsCommonTabFragment.tabId);
        this.gwn.pB(frsCommonTabFragment.tabId);
        this.gwo.pB(frsCommonTabFragment.tabId);
        this.gwp.pB(frsCommonTabFragment.tabId);
        this.gwq.pB(frsCommonTabFragment.tabId);
        this.gwr.pB(frsCommonTabFragment.tabId);
        this.gws.pB(frsCommonTabFragment.tabId);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.gwk.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof h) {
                    ((h) aVar2).a(this.gwk.getPageContext(), this.gwk.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.asP != null) {
                this.asP.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
            b(frsViewData);
        }
        bGg();
        bdTypeRecyclerView.addAdapters(this.asP);
        bGL();
    }

    public void setData(ArrayList<m> arrayList) {
        this.BK.setData(arrayList);
    }

    private void bGg() {
        if (!v.isEmpty(this.asP) && this.gwk != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.gwk.getTbPageTag());
                }
            }
        }
    }

    private void bGL() {
        if (this.gwk != null && !v.isEmpty(this.asP)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.bHn() != null) {
                        dVar.bHn().gKD = this.gwk.gwy;
                        dVar.bHn().gKF = this.gwk.forumId;
                        dVar.bHn().gKG = this.gwk.tabId;
                        if (this.gwk.tabId == 502) {
                            dVar.bHn().gKI = 10;
                        } else if (this.gwk.isGeneralTab == 1) {
                            dVar.bHn().gKI = 12;
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
        for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    private void wP(String str) {
        if (this.asP != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar instanceof f) {
                    ((f) aVar).wP(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.asP != null && this.asP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void lQ(boolean z) {
        if (this.gwl != null) {
            this.gwl.lS(z);
        }
        if (this.gwm != null) {
            this.gwm.lS(z);
        }
        if (this.gwo != null) {
            this.gwo.lS(z);
        }
        if (this.gwp != null) {
            this.gwp.lS(z);
        }
    }
}
