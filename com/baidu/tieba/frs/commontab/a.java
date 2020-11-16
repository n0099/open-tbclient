package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes21.dex */
public class a {
    private BdTypeRecyclerView Xi;
    private r iOf;
    private FrsCommonTabFragment iQJ;
    private j iQK;
    private j iQL;
    private af iQM;
    private aj iQN;
    private aj iQO;
    private com.baidu.tieba.frs.entelechy.a.c iQP;
    private k iQQ;
    private ak iQR;
    private boolean isDynamic;
    private List<com.baidu.adp.widget.ListView.a> biN = new LinkedList();
    private CustomMessageListener iQS = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof y) && "FrsHottopicDelegateAdapter".equals(((y) aVar).abq()) && a.this.biN != null) {
                        ((y) aVar).a(a.this.iQJ.getPageContext(), a.this.iQJ.getUniqueId());
                        if (a.this.isDynamic) {
                            ((y) aVar).setFrom("c13010");
                        }
                        a.this.biN.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData);
        this.Xi = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.iQJ = frsCommonTabFragment;
        this.iQS.setPriority(1);
        this.iQS.setSelfListener(true);
        this.iQJ.registerListener(this.iQS);
        this.iQK = new j(frsCommonTabFragment.getPageContext(), bx.eBR, this.iQJ.getUniqueId());
        this.iQL = new j(frsCommonTabFragment.getPageContext(), bx.eCn, this.iQJ.getUniqueId());
        this.iQM = new af(frsCommonTabFragment.getPageContext(), bx.eCt, this.iQJ.getUniqueId());
        this.iQN = new aj(frsCommonTabFragment.getPageContext(), bx.eCo, this.iQJ.getUniqueId());
        this.iQN.iQY = this.iQJ.iQY;
        this.iQO = new aj(frsCommonTabFragment.getPageContext(), bx.eCx, this.iQJ.getUniqueId());
        this.iQO.iQY = this.iQJ.iQY;
        this.iOf = new r(frsCommonTabFragment.getPageContext(), s.iLy);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), bx.eCg, frsCommonTabFragment.getUniqueId());
        this.iQP = new com.baidu.tieba.frs.entelechy.a.c(frsCommonTabFragment.getPageContext(), bx.eCv, this.iQJ.getUniqueId());
        this.iQQ = new k(frsCommonTabFragment.getPageContext(), bx.eCu, this.iQJ.getUniqueId());
        this.iQR = new ak(frsCommonTabFragment.getPageContext(), bx.eCw, this.iQJ.getUniqueId());
        this.biN.add(this.iQK);
        this.biN.add(this.iQL);
        this.biN.add(this.iQM);
        this.biN.add(this.iQN);
        this.biN.add(this.iQO);
        this.biN.add(this.iOf);
        this.biN.add(aVar);
        this.biN.add(this.iQP);
        this.biN.add(this.iQQ);
        this.biN.add(this.iQR);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.iQK.setFrom("c13010");
            this.iQL.setFrom("c13010");
            this.iQM.setFrom("c13010");
            this.iQN.setFrom("c13010");
            this.iQO.setFrom("c13010");
            EA("page_frs_dynamic");
        }
        this.iQK.vB(frsCommonTabFragment.tabId);
        this.iQL.vB(frsCommonTabFragment.tabId);
        this.iQM.vB(frsCommonTabFragment.tabId);
        this.iQN.vB(frsCommonTabFragment.tabId);
        this.iQO.vB(frsCommonTabFragment.tabId);
        this.iQP.vB(frsCommonTabFragment.tabId);
        this.iQQ.vB(frsCommonTabFragment.tabId);
        this.iQR.vB(frsCommonTabFragment.tabId);
        this.iQK.zS(frsCommonTabFragment.tabType);
        this.iQL.zS(frsCommonTabFragment.tabType);
        boolean z = frsCommonTabFragment.tabType == 16;
        this.iQK.qd(z);
        this.iQN.qd(z);
        this.iQM.qd(z);
        this.iQQ.qd(z);
        this.iQR.qd(z);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.iQJ.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.iQJ.getPageContext(), this.iQJ.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.biN != null) {
                this.biN.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
            b(frsViewData);
        }
        cAq();
        bdTypeRecyclerView.addAdapters(this.biN);
        cAT();
    }

    public void setData(ArrayList<q> arrayList) {
        cAq();
        this.Xi.setData(arrayList);
    }

    private void cAq() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.biN) && this.iQJ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iQJ.getTbPageTag());
                }
            }
        }
    }

    private void cAT() {
        if (this.iQJ != null && !com.baidu.tbadk.core.util.y.isEmpty(this.biN)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.getStatisticMetaData() != null) {
                        dVar.getStatisticMetaData().jgm = this.iQJ.iQX;
                        dVar.getStatisticMetaData().jgo = this.iQJ.forumId;
                        dVar.getStatisticMetaData().jgp = this.iQJ.tabId;
                        dVar.getStatisticMetaData().jgs = this.iQJ.tabType;
                        if (this.iQJ.tabId == 502) {
                            dVar.getStatisticMetaData().jgr = 10;
                        } else if (this.iQJ.isGeneralTab == 1) {
                            dVar.getStatisticMetaData().jgr = 12;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.Xi.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    private void EA(String str) {
        if (this.biN != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar instanceof f) {
                    ((f) aVar).EA(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.biN != null && this.biN.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void qa(boolean z) {
        if (this.iQK != null) {
            this.iQK.qc(z);
        }
        if (this.iQL != null) {
            this.iQL.qc(z);
        }
        if (this.iQN != null) {
            this.iQN.qc(z);
        }
        if (this.iQO != null) {
            this.iQO.qc(z);
        }
    }
}
