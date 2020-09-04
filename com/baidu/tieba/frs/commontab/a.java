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
    private r hYY;
    private FrsCommonTabFragment ibC;
    private j ibD;
    private j ibE;
    private af ibF;
    private aj ibG;
    private aj ibH;
    private com.baidu.tieba.frs.entelechy.a.c ibI;
    private k ibJ;
    private ak ibK;
    private boolean isDynamic;
    private List<com.baidu.adp.widget.ListView.a> bbw = new LinkedList();
    private CustomMessageListener ibL = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof x) && "FrsHottopicDelegateAdapter".equals(((x) aVar).Va()) && a.this.bbw != null) {
                        ((x) aVar).a(a.this.ibC.getPageContext(), a.this.ibC.getUniqueId());
                        if (a.this.isDynamic) {
                            ((x) aVar).setFrom("c13010");
                        }
                        a.this.bbw.add(aVar);
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
        this.ibC = frsCommonTabFragment;
        this.ibL.setPriority(1);
        this.ibL.setSelfListener(true);
        this.ibC.registerListener(this.ibL);
        this.ibD = new j(frsCommonTabFragment.getPageContext(), bw.eaW, this.ibC.getUniqueId());
        this.ibE = new j(frsCommonTabFragment.getPageContext(), bw.ebr, this.ibC.getUniqueId());
        this.ibF = new af(frsCommonTabFragment.getPageContext(), bw.ebw, this.ibC.getUniqueId());
        this.ibG = new aj(frsCommonTabFragment.getPageContext(), bw.ebs, this.ibC.getUniqueId());
        this.ibG.ibR = this.ibC.ibR;
        this.ibH = new aj(frsCommonTabFragment.getPageContext(), bw.ebA, this.ibC.getUniqueId());
        this.ibH.ibR = this.ibC.ibR;
        this.hYY = new r(frsCommonTabFragment.getPageContext(), s.hWr);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), bw.ebk, frsCommonTabFragment.getUniqueId());
        this.ibI = new com.baidu.tieba.frs.entelechy.a.c(frsCommonTabFragment.getPageContext(), bw.eby, this.ibC.getUniqueId());
        this.ibJ = new k(frsCommonTabFragment.getPageContext(), bw.ebx, this.ibC.getUniqueId());
        this.ibK = new ak(frsCommonTabFragment.getPageContext(), bw.ebz, this.ibC.getUniqueId());
        this.bbw.add(this.ibD);
        this.bbw.add(this.ibE);
        this.bbw.add(this.ibF);
        this.bbw.add(this.ibG);
        this.bbw.add(this.ibH);
        this.bbw.add(this.hYY);
        this.bbw.add(aVar);
        this.bbw.add(this.ibI);
        this.bbw.add(this.ibJ);
        this.bbw.add(this.ibK);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.ibD.setFrom("c13010");
            this.ibE.setFrom("c13010");
            this.ibF.setFrom("c13010");
            this.ibG.setFrom("c13010");
            this.ibH.setFrom("c13010");
            Dk("page_frs_dynamic");
        }
        this.ibD.tz(frsCommonTabFragment.tabId);
        this.ibE.tz(frsCommonTabFragment.tabId);
        this.ibF.tz(frsCommonTabFragment.tabId);
        this.ibG.tz(frsCommonTabFragment.tabId);
        this.ibH.tz(frsCommonTabFragment.tabId);
        this.ibI.tz(frsCommonTabFragment.tabId);
        this.ibJ.tz(frsCommonTabFragment.tabId);
        this.ibK.tz(frsCommonTabFragment.tabId);
        this.ibD.xJ(frsCommonTabFragment.tabType);
        this.ibE.xJ(frsCommonTabFragment.tabType);
        boolean z = frsCommonTabFragment.tabType == 16;
        this.ibD.oO(z);
        this.ibG.oO(z);
        this.ibF.oO(z);
        this.ibJ.oO(z);
        this.ibK.oO(z);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.ibC.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.ibC.getPageContext(), this.ibC.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bbw != null) {
                this.bbw.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
            b(frsViewData);
        }
        cou();
        bdTypeRecyclerView.addAdapters(this.bbw);
        coY();
    }

    public void setData(ArrayList<q> arrayList) {
        cou();
        this.Wu.setData(arrayList);
    }

    private void cou() {
        if (!y.isEmpty(this.bbw) && this.ibC != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.ibC.getTbPageTag());
                }
            }
        }
    }

    private void coY() {
        if (this.ibC != null && !y.isEmpty(this.bbw)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.getStatisticMetaData() != null) {
                        dVar.getStatisticMetaData().iqZ = this.ibC.ibQ;
                        dVar.getStatisticMetaData().irb = this.ibC.forumId;
                        dVar.getStatisticMetaData().irc = this.ibC.tabId;
                        dVar.getStatisticMetaData().irf = this.ibC.tabType;
                        if (this.ibC.tabId == 502) {
                            dVar.getStatisticMetaData().ire = 10;
                        } else if (this.ibC.isGeneralTab == 1) {
                            dVar.getStatisticMetaData().ire = 12;
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
        for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    private void Dk(String str) {
        if (this.bbw != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof f) {
                    ((f) aVar).Dk(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.bbw != null && this.bbw.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void oL(boolean z) {
        if (this.ibD != null) {
            this.ibD.oN(z);
        }
        if (this.ibE != null) {
            this.ibE.oN(z);
        }
        if (this.ibG != null) {
            this.ibG.oN(z);
        }
        if (this.ibH != null) {
            this.ibH.oN(z);
        }
    }
}
