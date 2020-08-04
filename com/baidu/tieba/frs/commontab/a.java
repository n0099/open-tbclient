package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bv;
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
/* loaded from: classes16.dex */
public class a {
    private BdTypeRecyclerView VT;
    private q hKN;
    private FrsCommonTabFragment hNr;
    private j hNs;
    private j hNt;
    private af hNu;
    private aj hNv;
    private aj hNw;
    private com.baidu.tieba.frs.entelechy.a.c hNx;
    private k hNy;
    private ak hNz;
    private boolean isDynamic;
    private List<com.baidu.adp.widget.ListView.a> aWf = new LinkedList();
    private CustomMessageListener hNA = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof x) && "FrsHottopicDelegateAdapter".equals(((x) aVar).Pe()) && a.this.aWf != null) {
                        ((x) aVar).a(a.this.hNr.getPageContext(), a.this.hNr.getUniqueId());
                        if (a.this.isDynamic) {
                            ((x) aVar).setFrom("c13010");
                        }
                        a.this.aWf.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData);
        this.VT = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.hNr = frsCommonTabFragment;
        this.hNA.setPriority(1);
        this.hNA.setSelfListener(true);
        this.hNr.registerListener(this.hNA);
        this.hNs = new j(frsCommonTabFragment.getPageContext(), bv.dRx, this.hNr.getUniqueId());
        this.hNt = new j(frsCommonTabFragment.getPageContext(), bv.dRR, this.hNr.getUniqueId());
        this.hNu = new af(frsCommonTabFragment.getPageContext(), bv.dRW, this.hNr.getUniqueId());
        this.hNv = new aj(frsCommonTabFragment.getPageContext(), bv.dRS, this.hNr.getUniqueId());
        this.hNv.hNG = this.hNr.hNG;
        this.hNw = new aj(frsCommonTabFragment.getPageContext(), bv.dSa, this.hNr.getUniqueId());
        this.hNw.hNG = this.hNr.hNG;
        this.hKN = new q(frsCommonTabFragment.getPageContext(), r.hIV);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), bv.dRK, frsCommonTabFragment.getUniqueId());
        this.hNx = new com.baidu.tieba.frs.entelechy.a.c(frsCommonTabFragment.getPageContext(), bv.dRY, this.hNr.getUniqueId());
        this.hNy = new k(frsCommonTabFragment.getPageContext(), bv.dRX, this.hNr.getUniqueId());
        this.hNz = new ak(frsCommonTabFragment.getPageContext(), bv.dRZ, this.hNr.getUniqueId());
        this.aWf.add(this.hNs);
        this.aWf.add(this.hNt);
        this.aWf.add(this.hNu);
        this.aWf.add(this.hNv);
        this.aWf.add(this.hNw);
        this.aWf.add(this.hKN);
        this.aWf.add(aVar);
        this.aWf.add(this.hNx);
        this.aWf.add(this.hNy);
        this.aWf.add(this.hNz);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.hNs.setFrom("c13010");
            this.hNt.setFrom("c13010");
            this.hNu.setFrom("c13010");
            this.hNv.setFrom("c13010");
            this.hNw.setFrom("c13010");
            AP("page_frs_dynamic");
        }
        this.hNs.rn(frsCommonTabFragment.tabId);
        this.hNt.rn(frsCommonTabFragment.tabId);
        this.hNu.rn(frsCommonTabFragment.tabId);
        this.hNv.rn(frsCommonTabFragment.tabId);
        this.hNw.rn(frsCommonTabFragment.tabId);
        this.hNx.rn(frsCommonTabFragment.tabId);
        this.hNy.rn(frsCommonTabFragment.tabId);
        this.hNz.rn(frsCommonTabFragment.tabId);
        boolean z = frsCommonTabFragment.tabType == 16;
        this.hNs.oi(z);
        this.hNv.oi(z);
        this.hNu.oi(z);
        this.hNy.oi(z);
        this.hNz.oi(z);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.hNr.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar2).a(this.hNr.getPageContext(), this.hNr.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.aWf != null) {
                this.aWf.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
            b(frsViewData);
        }
        cdP();
        bdTypeRecyclerView.addAdapters(this.aWf);
        cet();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        this.VT.setData(arrayList);
    }

    private void cdP() {
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.aWf) && this.hNr != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).a(this.hNr.getTbPageTag());
                }
            }
        }
    }

    private void cet() {
        if (this.hNr != null && !com.baidu.tbadk.core.util.x.isEmpty(this.aWf)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.getStatisticMetaData() != null) {
                        dVar.getStatisticMetaData().icM = this.hNr.hNF;
                        dVar.getStatisticMetaData().icO = this.hNr.forumId;
                        dVar.getStatisticMetaData().icP = this.hNr.tabId;
                        if (this.hNr.tabId == 502) {
                            dVar.getStatisticMetaData().icR = 10;
                        } else if (this.hNr.isGeneralTab == 1) {
                            dVar.getStatisticMetaData().icR = 12;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.VT.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
            if (aVar instanceof com.baidu.tieba.frs.j) {
                ((com.baidu.tieba.frs.j) aVar).release();
            }
        }
    }

    private void AP(String str) {
        if (this.aWf != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof f) {
                    ((f) aVar).AP(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.aWf != null && this.aWf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).b(frsViewData);
                }
            }
        }
    }

    public void of(boolean z) {
        if (this.hNs != null) {
            this.hNs.oh(z);
        }
        if (this.hNt != null) {
            this.hNt.oh(z);
        }
        if (this.hNv != null) {
            this.hNv.oh(z);
        }
        if (this.hNw != null) {
            this.hNw.oh(z);
        }
    }
}
