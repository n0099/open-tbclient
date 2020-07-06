package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.a.f;
import com.baidu.tieba.card.x;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.af;
import com.baidu.tieba.frs.entelechy.a.aj;
import com.baidu.tieba.frs.entelechy.a.ak;
import com.baidu.tieba.frs.entelechy.a.j;
import com.baidu.tieba.frs.entelechy.a.k;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView Wa;
    private q hEP;
    private FrsCommonTabFragment hHq;
    private j hHr;
    private j hHs;
    private af hHt;
    private aj hHu;
    private aj hHv;
    private com.baidu.tieba.frs.entelechy.a.c hHw;
    private k hHx;
    private ak hHy;
    private boolean isDynamic;
    private List<com.baidu.adp.widget.ListView.a> aUP = new LinkedList();
    private CustomMessageListener hHz = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof x) && "FrsHottopicDelegateAdapter".equals(((x) aVar).OP()) && a.this.aUP != null) {
                        ((x) aVar).a(a.this.hHq.getPageContext(), a.this.hHq.getUniqueId());
                        if (a.this.isDynamic) {
                            ((x) aVar).setFrom("c13010");
                        }
                        a.this.aUP.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData);
        this.Wa = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.hHq = frsCommonTabFragment;
        this.hHz.setPriority(1);
        this.hHz.setSelfListener(true);
        this.hHq.registerListener(this.hHz);
        this.hHr = new j(frsCommonTabFragment.getPageContext(), bu.dLm, this.hHq.getUniqueId());
        this.hHs = new j(frsCommonTabFragment.getPageContext(), bu.dLG, this.hHq.getUniqueId());
        this.hHt = new af(frsCommonTabFragment.getPageContext(), bu.dLL, this.hHq.getUniqueId());
        this.hHu = new aj(frsCommonTabFragment.getPageContext(), bu.dLH, this.hHq.getUniqueId());
        this.hHu.hHF = this.hHq.hHF;
        this.hHv = new aj(frsCommonTabFragment.getPageContext(), bu.dLP, this.hHq.getUniqueId());
        this.hHv.hHF = this.hHq.hHF;
        this.hEP = new q(frsCommonTabFragment.getPageContext(), r.hCX);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), bu.dLz, frsCommonTabFragment.getUniqueId());
        this.hHw = new com.baidu.tieba.frs.entelechy.a.c(frsCommonTabFragment.getPageContext(), bu.dLN, this.hHq.getUniqueId());
        this.hHx = new k(frsCommonTabFragment.getPageContext(), bu.dLM, this.hHq.getUniqueId());
        this.hHy = new ak(frsCommonTabFragment.getPageContext(), bu.dLO, this.hHq.getUniqueId());
        this.aUP.add(this.hHr);
        this.aUP.add(this.hHs);
        this.aUP.add(this.hHt);
        this.aUP.add(this.hHu);
        this.aUP.add(this.hHv);
        this.aUP.add(this.hEP);
        this.aUP.add(aVar);
        this.aUP.add(this.hHw);
        this.aUP.add(this.hHx);
        this.aUP.add(this.hHy);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.hHr.setFrom("c13010");
            this.hHs.setFrom("c13010");
            this.hHt.setFrom("c13010");
            this.hHu.setFrom("c13010");
            this.hHv.setFrom("c13010");
            Ae("page_frs_dynamic");
        }
        this.hHr.qX(frsCommonTabFragment.tabId);
        this.hHs.qX(frsCommonTabFragment.tabId);
        this.hHt.qX(frsCommonTabFragment.tabId);
        this.hHu.qX(frsCommonTabFragment.tabId);
        this.hHv.qX(frsCommonTabFragment.tabId);
        this.hHw.qX(frsCommonTabFragment.tabId);
        this.hHx.qX(frsCommonTabFragment.tabId);
        this.hHy.qX(frsCommonTabFragment.tabId);
        boolean z = frsCommonTabFragment.tabType == 16;
        this.hHr.nD(z);
        this.hHu.nD(z);
        this.hHt.nD(z);
        this.hHx.nD(z);
        this.hHy.nD(z);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.hHq.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar2).a(this.hHq.getPageContext(), this.hHq.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.aUP != null) {
                this.aUP.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
            b(frsViewData);
        }
        car();
        bdTypeRecyclerView.addAdapters(this.aUP);
        caV();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        this.Wa.setData(arrayList);
    }

    private void car() {
        if (!w.isEmpty(this.aUP) && this.hHq != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).a(this.hHq.getTbPageTag());
                }
            }
        }
    }

    private void caV() {
        if (this.hHq != null && !w.isEmpty(this.aUP)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.getStatisticMetaData() != null) {
                        dVar.getStatisticMetaData().hWM = this.hHq.hHE;
                        dVar.getStatisticMetaData().hWO = this.hHq.forumId;
                        dVar.getStatisticMetaData().hWP = this.hHq.tabId;
                        if (this.hHq.tabId == 502) {
                            dVar.getStatisticMetaData().hWR = 10;
                        } else if (this.hHq.isGeneralTab == 1) {
                            dVar.getStatisticMetaData().hWR = 12;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.Wa.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
            if (aVar instanceof com.baidu.tieba.frs.j) {
                ((com.baidu.tieba.frs.j) aVar).release();
            }
        }
    }

    private void Ae(String str) {
        if (this.aUP != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof f) {
                    ((f) aVar).Ae(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.aUP != null && this.aUP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).b(frsViewData);
                }
            }
        }
    }

    public void nA(boolean z) {
        if (this.hHr != null) {
            this.hHr.nC(z);
        }
        if (this.hHs != null) {
            this.hHs.nC(z);
        }
        if (this.hHu != null) {
            this.hHu.nC(z);
        }
        if (this.hHv != null) {
            this.hHv.nC(z);
        }
    }
}
