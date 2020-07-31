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
    private FrsCommonTabFragment hNp;
    private j hNq;
    private j hNr;
    private af hNs;
    private aj hNt;
    private aj hNu;
    private com.baidu.tieba.frs.entelechy.a.c hNv;
    private k hNw;
    private ak hNx;
    private boolean isDynamic;
    private List<com.baidu.adp.widget.ListView.a> aWf = new LinkedList();
    private CustomMessageListener hNy = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof x) && "FrsHottopicDelegateAdapter".equals(((x) aVar).Pe()) && a.this.aWf != null) {
                        ((x) aVar).a(a.this.hNp.getPageContext(), a.this.hNp.getUniqueId());
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
        this.hNp = frsCommonTabFragment;
        this.hNy.setPriority(1);
        this.hNy.setSelfListener(true);
        this.hNp.registerListener(this.hNy);
        this.hNq = new j(frsCommonTabFragment.getPageContext(), bv.dRx, this.hNp.getUniqueId());
        this.hNr = new j(frsCommonTabFragment.getPageContext(), bv.dRR, this.hNp.getUniqueId());
        this.hNs = new af(frsCommonTabFragment.getPageContext(), bv.dRW, this.hNp.getUniqueId());
        this.hNt = new aj(frsCommonTabFragment.getPageContext(), bv.dRS, this.hNp.getUniqueId());
        this.hNt.hNE = this.hNp.hNE;
        this.hNu = new aj(frsCommonTabFragment.getPageContext(), bv.dSa, this.hNp.getUniqueId());
        this.hNu.hNE = this.hNp.hNE;
        this.hKN = new q(frsCommonTabFragment.getPageContext(), r.hIV);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), bv.dRK, frsCommonTabFragment.getUniqueId());
        this.hNv = new com.baidu.tieba.frs.entelechy.a.c(frsCommonTabFragment.getPageContext(), bv.dRY, this.hNp.getUniqueId());
        this.hNw = new k(frsCommonTabFragment.getPageContext(), bv.dRX, this.hNp.getUniqueId());
        this.hNx = new ak(frsCommonTabFragment.getPageContext(), bv.dRZ, this.hNp.getUniqueId());
        this.aWf.add(this.hNq);
        this.aWf.add(this.hNr);
        this.aWf.add(this.hNs);
        this.aWf.add(this.hNt);
        this.aWf.add(this.hNu);
        this.aWf.add(this.hKN);
        this.aWf.add(aVar);
        this.aWf.add(this.hNv);
        this.aWf.add(this.hNw);
        this.aWf.add(this.hNx);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.hNq.setFrom("c13010");
            this.hNr.setFrom("c13010");
            this.hNs.setFrom("c13010");
            this.hNt.setFrom("c13010");
            this.hNu.setFrom("c13010");
            AP("page_frs_dynamic");
        }
        this.hNq.rn(frsCommonTabFragment.tabId);
        this.hNr.rn(frsCommonTabFragment.tabId);
        this.hNs.rn(frsCommonTabFragment.tabId);
        this.hNt.rn(frsCommonTabFragment.tabId);
        this.hNu.rn(frsCommonTabFragment.tabId);
        this.hNv.rn(frsCommonTabFragment.tabId);
        this.hNw.rn(frsCommonTabFragment.tabId);
        this.hNx.rn(frsCommonTabFragment.tabId);
        boolean z = frsCommonTabFragment.tabType == 16;
        this.hNq.oi(z);
        this.hNt.oi(z);
        this.hNs.oi(z);
        this.hNw.oi(z);
        this.hNx.oi(z);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.hNp.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar2).a(this.hNp.getPageContext(), this.hNp.getUniqueId());
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
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.aWf) && this.hNp != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).a(this.hNp.getTbPageTag());
                }
            }
        }
    }

    private void cet() {
        if (this.hNp != null && !com.baidu.tbadk.core.util.x.isEmpty(this.aWf)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.getStatisticMetaData() != null) {
                        dVar.getStatisticMetaData().icK = this.hNp.hND;
                        dVar.getStatisticMetaData().icM = this.hNp.forumId;
                        dVar.getStatisticMetaData().icN = this.hNp.tabId;
                        if (this.hNp.tabId == 502) {
                            dVar.getStatisticMetaData().icP = 10;
                        } else if (this.hNp.isGeneralTab == 1) {
                            dVar.getStatisticMetaData().icP = 12;
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
        if (this.hNq != null) {
            this.hNq.oh(z);
        }
        if (this.hNr != null) {
            this.hNr.oh(z);
        }
        if (this.hNt != null) {
            this.hNt.oh(z);
        }
        if (this.hNu != null) {
            this.hNu.oh(z);
        }
    }
}
