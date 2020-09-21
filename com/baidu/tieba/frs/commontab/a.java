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
/* loaded from: classes21.dex */
public class a {
    private BdTypeRecyclerView WM;
    private r igc;
    private FrsCommonTabFragment iiG;
    private j iiH;
    private j iiI;
    private af iiJ;
    private aj iiK;
    private aj iiL;
    private com.baidu.tieba.frs.entelechy.a.c iiM;
    private k iiN;
    private ak iiO;
    private boolean isDynamic;
    private List<com.baidu.adp.widget.ListView.a> bdV = new LinkedList();
    private CustomMessageListener iiP = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof x) && "FrsHottopicDelegateAdapter".equals(((x) aVar).VJ()) && a.this.bdV != null) {
                        ((x) aVar).a(a.this.iiG.getPageContext(), a.this.iiG.getUniqueId());
                        if (a.this.isDynamic) {
                            ((x) aVar).setFrom("c13010");
                        }
                        a.this.bdV.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData);
        this.WM = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.iiG = frsCommonTabFragment;
        this.iiP.setPriority(1);
        this.iiP.setSelfListener(true);
        this.iiG.registerListener(this.iiP);
        this.iiH = new j(frsCommonTabFragment.getPageContext(), bw.edg, this.iiG.getUniqueId());
        this.iiI = new j(frsCommonTabFragment.getPageContext(), bw.edB, this.iiG.getUniqueId());
        this.iiJ = new af(frsCommonTabFragment.getPageContext(), bw.edG, this.iiG.getUniqueId());
        this.iiK = new aj(frsCommonTabFragment.getPageContext(), bw.edC, this.iiG.getUniqueId());
        this.iiK.iiV = this.iiG.iiV;
        this.iiL = new aj(frsCommonTabFragment.getPageContext(), bw.edK, this.iiG.getUniqueId());
        this.iiL.iiV = this.iiG.iiV;
        this.igc = new r(frsCommonTabFragment.getPageContext(), s.idu);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), bw.edu, frsCommonTabFragment.getUniqueId());
        this.iiM = new com.baidu.tieba.frs.entelechy.a.c(frsCommonTabFragment.getPageContext(), bw.edI, this.iiG.getUniqueId());
        this.iiN = new k(frsCommonTabFragment.getPageContext(), bw.edH, this.iiG.getUniqueId());
        this.iiO = new ak(frsCommonTabFragment.getPageContext(), bw.edJ, this.iiG.getUniqueId());
        this.bdV.add(this.iiH);
        this.bdV.add(this.iiI);
        this.bdV.add(this.iiJ);
        this.bdV.add(this.iiK);
        this.bdV.add(this.iiL);
        this.bdV.add(this.igc);
        this.bdV.add(aVar);
        this.bdV.add(this.iiM);
        this.bdV.add(this.iiN);
        this.bdV.add(this.iiO);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.iiH.setFrom("c13010");
            this.iiI.setFrom("c13010");
            this.iiJ.setFrom("c13010");
            this.iiK.setFrom("c13010");
            this.iiL.setFrom("c13010");
            DH("page_frs_dynamic");
        }
        this.iiH.tS(frsCommonTabFragment.tabId);
        this.iiI.tS(frsCommonTabFragment.tabId);
        this.iiJ.tS(frsCommonTabFragment.tabId);
        this.iiK.tS(frsCommonTabFragment.tabId);
        this.iiL.tS(frsCommonTabFragment.tabId);
        this.iiM.tS(frsCommonTabFragment.tabId);
        this.iiN.tS(frsCommonTabFragment.tabId);
        this.iiO.tS(frsCommonTabFragment.tabId);
        this.iiH.yi(frsCommonTabFragment.tabType);
        this.iiI.yi(frsCommonTabFragment.tabType);
        boolean z = frsCommonTabFragment.tabType == 16;
        this.iiH.oU(z);
        this.iiK.oU(z);
        this.iiJ.oU(z);
        this.iiN.oU(z);
        this.iiO.oU(z);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.iiG.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.iiG.getPageContext(), this.iiG.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bdV != null) {
                this.bdV.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
            b(frsViewData);
        }
        crH();
        bdTypeRecyclerView.addAdapters(this.bdV);
        csl();
    }

    public void setData(ArrayList<q> arrayList) {
        crH();
        this.WM.setData(arrayList);
    }

    private void crH() {
        if (!y.isEmpty(this.bdV) && this.iiG != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iiG.getTbPageTag());
                }
            }
        }
    }

    private void csl() {
        if (this.iiG != null && !y.isEmpty(this.bdV)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.getStatisticMetaData() != null) {
                        dVar.getStatisticMetaData().iyp = this.iiG.iiU;
                        dVar.getStatisticMetaData().iyr = this.iiG.forumId;
                        dVar.getStatisticMetaData().iys = this.iiG.tabId;
                        dVar.getStatisticMetaData().iyv = this.iiG.tabType;
                        if (this.iiG.tabId == 502) {
                            dVar.getStatisticMetaData().iyu = 10;
                        } else if (this.iiG.isGeneralTab == 1) {
                            dVar.getStatisticMetaData().iyu = 12;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.WM.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    private void DH(String str) {
        if (this.bdV != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof f) {
                    ((f) aVar).DH(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.bdV != null && this.bdV.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void oR(boolean z) {
        if (this.iiH != null) {
            this.iiH.oT(z);
        }
        if (this.iiI != null) {
            this.iiI.oT(z);
        }
        if (this.iiK != null) {
            this.iiK.oT(z);
        }
        if (this.iiL != null) {
            this.iiL.oT(z);
        }
    }
}
