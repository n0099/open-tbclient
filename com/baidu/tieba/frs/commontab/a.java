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
/* loaded from: classes22.dex */
public class a {
    private BdTypeRecyclerView Xc;
    private boolean isDynamic;
    private r iuZ;
    private FrsCommonTabFragment ixD;
    private j ixE;
    private j ixF;
    private af ixG;
    private aj ixH;
    private aj ixI;
    private com.baidu.tieba.frs.entelechy.a.c ixJ;
    private k ixK;
    private ak ixL;
    private List<com.baidu.adp.widget.ListView.a> bhH = new LinkedList();
    private CustomMessageListener ixM = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof x) && "FrsHottopicDelegateAdapter".equals(((x) aVar).XG()) && a.this.bhH != null) {
                        ((x) aVar).a(a.this.ixD.getPageContext(), a.this.ixD.getUniqueId());
                        if (a.this.isDynamic) {
                            ((x) aVar).setFrom("c13010");
                        }
                        a.this.bhH.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData);
        this.Xc = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.ixD = frsCommonTabFragment;
        this.ixM.setPriority(1);
        this.ixM.setSelfListener(true);
        this.ixD.registerListener(this.ixM);
        this.ixE = new j(frsCommonTabFragment.getPageContext(), bw.epl, this.ixD.getUniqueId());
        this.ixF = new j(frsCommonTabFragment.getPageContext(), bw.epG, this.ixD.getUniqueId());
        this.ixG = new af(frsCommonTabFragment.getPageContext(), bw.epL, this.ixD.getUniqueId());
        this.ixH = new aj(frsCommonTabFragment.getPageContext(), bw.epH, this.ixD.getUniqueId());
        this.ixH.ixS = this.ixD.ixS;
        this.ixI = new aj(frsCommonTabFragment.getPageContext(), bw.epP, this.ixD.getUniqueId());
        this.ixI.ixS = this.ixD.ixS;
        this.iuZ = new r(frsCommonTabFragment.getPageContext(), s.iss);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), bw.epz, frsCommonTabFragment.getUniqueId());
        this.ixJ = new com.baidu.tieba.frs.entelechy.a.c(frsCommonTabFragment.getPageContext(), bw.epN, this.ixD.getUniqueId());
        this.ixK = new k(frsCommonTabFragment.getPageContext(), bw.epM, this.ixD.getUniqueId());
        this.ixL = new ak(frsCommonTabFragment.getPageContext(), bw.epO, this.ixD.getUniqueId());
        this.bhH.add(this.ixE);
        this.bhH.add(this.ixF);
        this.bhH.add(this.ixG);
        this.bhH.add(this.ixH);
        this.bhH.add(this.ixI);
        this.bhH.add(this.iuZ);
        this.bhH.add(aVar);
        this.bhH.add(this.ixJ);
        this.bhH.add(this.ixK);
        this.bhH.add(this.ixL);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.ixE.setFrom("c13010");
            this.ixF.setFrom("c13010");
            this.ixG.setFrom("c13010");
            this.ixH.setFrom("c13010");
            this.ixI.setFrom("c13010");
            Es("page_frs_dynamic");
        }
        this.ixE.ux(frsCommonTabFragment.tabId);
        this.ixF.ux(frsCommonTabFragment.tabId);
        this.ixG.ux(frsCommonTabFragment.tabId);
        this.ixH.ux(frsCommonTabFragment.tabId);
        this.ixI.ux(frsCommonTabFragment.tabId);
        this.ixJ.ux(frsCommonTabFragment.tabId);
        this.ixK.ux(frsCommonTabFragment.tabId);
        this.ixL.ux(frsCommonTabFragment.tabId);
        this.ixE.yO(frsCommonTabFragment.tabType);
        this.ixF.yO(frsCommonTabFragment.tabType);
        boolean z = frsCommonTabFragment.tabType == 16;
        this.ixE.pz(z);
        this.ixH.pz(z);
        this.ixG.pz(z);
        this.ixK.pz(z);
        this.ixL.pz(z);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.ixD.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.ixD.getPageContext(), this.ixD.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bhH != null) {
                this.bhH.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
            b(frsViewData);
        }
        cvf();
        bdTypeRecyclerView.addAdapters(this.bhH);
        cvI();
    }

    public void setData(ArrayList<q> arrayList) {
        cvf();
        this.Xc.setData(arrayList);
    }

    private void cvf() {
        if (!y.isEmpty(this.bhH) && this.ixD != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.ixD.getTbPageTag());
                }
            }
        }
    }

    private void cvI() {
        if (this.ixD != null && !y.isEmpty(this.bhH)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.getStatisticMetaData() != null) {
                        dVar.getStatisticMetaData().iNi = this.ixD.ixR;
                        dVar.getStatisticMetaData().iNk = this.ixD.forumId;
                        dVar.getStatisticMetaData().iNl = this.ixD.tabId;
                        dVar.getStatisticMetaData().iNo = this.ixD.tabType;
                        if (this.ixD.tabId == 502) {
                            dVar.getStatisticMetaData().iNn = 10;
                        } else if (this.ixD.isGeneralTab == 1) {
                            dVar.getStatisticMetaData().iNn = 12;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.Xc.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    private void Es(String str) {
        if (this.bhH != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar instanceof f) {
                    ((f) aVar).Es(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.bhH != null && this.bhH.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void pw(boolean z) {
        if (this.ixE != null) {
            this.ixE.py(z);
        }
        if (this.ixF != null) {
            this.ixF.py(z);
        }
        if (this.ixH != null) {
            this.ixH.py(z);
        }
        if (this.ixI != null) {
            this.ixI.py(z);
        }
    }
}
