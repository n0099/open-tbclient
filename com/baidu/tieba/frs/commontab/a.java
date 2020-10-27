package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.a.f;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.af;
import com.baidu.tieba.frs.entelechy.a.aj;
import com.baidu.tieba.frs.entelechy.a.ak;
import com.baidu.tieba.frs.entelechy.a.j;
import com.baidu.tieba.frs.entelechy.a.k;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private BdTypeRecyclerView Xe;
    private r iHv;
    private FrsCommonTabFragment iJZ;
    private j iKa;
    private j iKb;
    private af iKc;
    private aj iKd;
    private aj iKe;
    private com.baidu.tieba.frs.entelechy.a.c iKf;
    private k iKg;
    private ak iKh;
    private boolean isDynamic;
    private List<com.baidu.adp.widget.ListView.a> bje = new LinkedList();
    private CustomMessageListener iKi = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof y) && "FrsHottopicDelegateAdapter".equals(((y) aVar).ZA()) && a.this.bje != null) {
                        ((y) aVar).a(a.this.iJZ.getPageContext(), a.this.iJZ.getUniqueId());
                        if (a.this.isDynamic) {
                            ((y) aVar).setFrom("c13010");
                        }
                        a.this.bje.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData);
        this.Xe = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.iJZ = frsCommonTabFragment;
        this.iKi.setPriority(1);
        this.iKi.setSelfListener(true);
        this.iJZ.registerListener(this.iKi);
        this.iKa = new j(frsCommonTabFragment.getPageContext(), bw.exJ, this.iJZ.getUniqueId());
        this.iKb = new j(frsCommonTabFragment.getPageContext(), bw.eyf, this.iJZ.getUniqueId());
        this.iKc = new af(frsCommonTabFragment.getPageContext(), bw.eyl, this.iJZ.getUniqueId());
        this.iKd = new aj(frsCommonTabFragment.getPageContext(), bw.eyg, this.iJZ.getUniqueId());
        this.iKd.iKo = this.iJZ.iKo;
        this.iKe = new aj(frsCommonTabFragment.getPageContext(), bw.eyq, this.iJZ.getUniqueId());
        this.iKe.iKo = this.iJZ.iKo;
        this.iHv = new r(frsCommonTabFragment.getPageContext(), s.iEO);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), bw.exX, frsCommonTabFragment.getUniqueId());
        this.iKf = new com.baidu.tieba.frs.entelechy.a.c(frsCommonTabFragment.getPageContext(), bw.eyo, this.iJZ.getUniqueId());
        this.iKg = new k(frsCommonTabFragment.getPageContext(), bw.eyn, this.iJZ.getUniqueId());
        this.iKh = new ak(frsCommonTabFragment.getPageContext(), bw.eyp, this.iJZ.getUniqueId());
        this.bje.add(this.iKa);
        this.bje.add(this.iKb);
        this.bje.add(this.iKc);
        this.bje.add(this.iKd);
        this.bje.add(this.iKe);
        this.bje.add(this.iHv);
        this.bje.add(aVar);
        this.bje.add(this.iKf);
        this.bje.add(this.iKg);
        this.bje.add(this.iKh);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.iKa.setFrom("c13010");
            this.iKb.setFrom("c13010");
            this.iKc.setFrom("c13010");
            this.iKd.setFrom("c13010");
            this.iKe.setFrom("c13010");
            EL("page_frs_dynamic");
        }
        this.iKa.uQ(frsCommonTabFragment.tabId);
        this.iKb.uQ(frsCommonTabFragment.tabId);
        this.iKc.uQ(frsCommonTabFragment.tabId);
        this.iKd.uQ(frsCommonTabFragment.tabId);
        this.iKe.uQ(frsCommonTabFragment.tabId);
        this.iKf.uQ(frsCommonTabFragment.tabId);
        this.iKg.uQ(frsCommonTabFragment.tabId);
        this.iKh.uQ(frsCommonTabFragment.tabId);
        this.iKa.zh(frsCommonTabFragment.tabType);
        this.iKb.zh(frsCommonTabFragment.tabType);
        boolean z = frsCommonTabFragment.tabType == 16;
        this.iKa.pR(z);
        this.iKd.pR(z);
        this.iKc.pR(z);
        this.iKg.pR(z);
        this.iKh.pR(z);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.iJZ.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.iJZ.getPageContext(), this.iJZ.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bje != null) {
                this.bje.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
            b(frsViewData);
        }
        cym();
        bdTypeRecyclerView.addAdapters(this.bje);
        cyP();
    }

    public void setData(ArrayList<q> arrayList) {
        cym();
        this.Xe.setData(arrayList);
    }

    private void cym() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.bje) && this.iJZ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iJZ.getTbPageTag());
                }
            }
        }
    }

    private void cyP() {
        if (this.iJZ != null && !com.baidu.tbadk.core.util.y.isEmpty(this.bje)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.getStatisticMetaData() != null) {
                        dVar.getStatisticMetaData().iZE = this.iJZ.iKn;
                        dVar.getStatisticMetaData().iZG = this.iJZ.forumId;
                        dVar.getStatisticMetaData().iZH = this.iJZ.tabId;
                        dVar.getStatisticMetaData().iZK = this.iJZ.tabType;
                        if (this.iJZ.tabId == 502) {
                            dVar.getStatisticMetaData().iZJ = 10;
                        } else if (this.iJZ.isGeneralTab == 1) {
                            dVar.getStatisticMetaData().iZJ = 12;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.Xe.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    private void EL(String str) {
        if (this.bje != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar instanceof f) {
                    ((f) aVar).EL(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.bje != null && this.bje.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void pO(boolean z) {
        if (this.iKa != null) {
            this.iKa.pQ(z);
        }
        if (this.iKb != null) {
            this.iKb.pQ(z);
        }
        if (this.iKd != null) {
            this.iKd.pQ(z);
        }
        if (this.iKe != null) {
            this.iKe.pQ(z);
        }
    }
}
