package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.a.f;
import com.baidu.tieba.card.x;
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
/* loaded from: classes16.dex */
public class a {
    private BdTypeRecyclerView Wu;
    private r hYS;
    private aj ibA;
    private aj ibB;
    private com.baidu.tieba.frs.entelechy.a.c ibC;
    private k ibD;
    private ak ibE;
    private FrsCommonTabFragment ibw;
    private j ibx;
    private j iby;
    private af ibz;
    private boolean isDynamic;
    private List<com.baidu.adp.widget.ListView.a> bbu = new LinkedList();
    private CustomMessageListener ibF = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof x) && "FrsHottopicDelegateAdapter".equals(((x) aVar).Va()) && a.this.bbu != null) {
                        ((x) aVar).a(a.this.ibw.getPageContext(), a.this.ibw.getUniqueId());
                        if (a.this.isDynamic) {
                            ((x) aVar).setFrom("c13010");
                        }
                        a.this.bbu.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData);
        this.Wu = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.ibw = frsCommonTabFragment;
        this.ibF.setPriority(1);
        this.ibF.setSelfListener(true);
        this.ibw.registerListener(this.ibF);
        this.ibx = new j(frsCommonTabFragment.getPageContext(), bw.eaS, this.ibw.getUniqueId());
        this.iby = new j(frsCommonTabFragment.getPageContext(), bw.ebn, this.ibw.getUniqueId());
        this.ibz = new af(frsCommonTabFragment.getPageContext(), bw.ebs, this.ibw.getUniqueId());
        this.ibA = new aj(frsCommonTabFragment.getPageContext(), bw.ebo, this.ibw.getUniqueId());
        this.ibA.ibL = this.ibw.ibL;
        this.ibB = new aj(frsCommonTabFragment.getPageContext(), bw.ebw, this.ibw.getUniqueId());
        this.ibB.ibL = this.ibw.ibL;
        this.hYS = new r(frsCommonTabFragment.getPageContext(), s.hWl);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), bw.ebg, frsCommonTabFragment.getUniqueId());
        this.ibC = new com.baidu.tieba.frs.entelechy.a.c(frsCommonTabFragment.getPageContext(), bw.ebu, this.ibw.getUniqueId());
        this.ibD = new k(frsCommonTabFragment.getPageContext(), bw.ebt, this.ibw.getUniqueId());
        this.ibE = new ak(frsCommonTabFragment.getPageContext(), bw.ebv, this.ibw.getUniqueId());
        this.bbu.add(this.ibx);
        this.bbu.add(this.iby);
        this.bbu.add(this.ibz);
        this.bbu.add(this.ibA);
        this.bbu.add(this.ibB);
        this.bbu.add(this.hYS);
        this.bbu.add(aVar);
        this.bbu.add(this.ibC);
        this.bbu.add(this.ibD);
        this.bbu.add(this.ibE);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.ibx.setFrom("c13010");
            this.iby.setFrom("c13010");
            this.ibz.setFrom("c13010");
            this.ibA.setFrom("c13010");
            this.ibB.setFrom("c13010");
            Dj("page_frs_dynamic");
        }
        this.ibx.tz(frsCommonTabFragment.tabId);
        this.iby.tz(frsCommonTabFragment.tabId);
        this.ibz.tz(frsCommonTabFragment.tabId);
        this.ibA.tz(frsCommonTabFragment.tabId);
        this.ibB.tz(frsCommonTabFragment.tabId);
        this.ibC.tz(frsCommonTabFragment.tabId);
        this.ibD.tz(frsCommonTabFragment.tabId);
        this.ibE.tz(frsCommonTabFragment.tabId);
        this.ibx.xJ(frsCommonTabFragment.tabType);
        this.iby.xJ(frsCommonTabFragment.tabType);
        boolean z = frsCommonTabFragment.tabType == 16;
        this.ibx.oM(z);
        this.ibA.oM(z);
        this.ibz.oM(z);
        this.ibD.oM(z);
        this.ibE.oM(z);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.ibw.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.ibw.getPageContext(), this.ibw.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bbu != null) {
                this.bbu.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
            b(frsViewData);
        }
        cot();
        bdTypeRecyclerView.addAdapters(this.bbu);
        coX();
    }

    public void setData(ArrayList<q> arrayList) {
        this.Wu.setData(arrayList);
    }

    private void cot() {
        if (!y.isEmpty(this.bbu) && this.ibw != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.ibw.getTbPageTag());
                }
            }
        }
    }

    private void coX() {
        if (this.ibw != null && !y.isEmpty(this.bbu)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.getStatisticMetaData() != null) {
                        dVar.getStatisticMetaData().iqT = this.ibw.ibK;
                        dVar.getStatisticMetaData().iqV = this.ibw.forumId;
                        dVar.getStatisticMetaData().iqW = this.ibw.tabId;
                        dVar.getStatisticMetaData().iqZ = this.ibw.tabType;
                        if (this.ibw.tabId == 502) {
                            dVar.getStatisticMetaData().iqY = 10;
                        } else if (this.ibw.isGeneralTab == 1) {
                            dVar.getStatisticMetaData().iqY = 12;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.Wu.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    private void Dj(String str) {
        if (this.bbu != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof f) {
                    ((f) aVar).Dj(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.bbu != null && this.bbu.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void oJ(boolean z) {
        if (this.ibx != null) {
            this.ibx.oL(z);
        }
        if (this.iby != null) {
            this.iby.oL(z);
        }
        if (this.ibA != null) {
            this.ibA.oL(z);
        }
        if (this.ibB != null) {
            this.ibB.oL(z);
        }
    }
}
