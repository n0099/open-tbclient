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
    private r iNs;
    private FrsCommonTabFragment iPW;
    private j iPX;
    private j iPY;
    private af iPZ;
    private aj iQa;
    private aj iQb;
    private com.baidu.tieba.frs.entelechy.a.c iQc;
    private k iQd;
    private ak iQe;
    private boolean isDynamic;
    private List<com.baidu.adp.widget.ListView.a> bky = new LinkedList();
    private CustomMessageListener iQf = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof y) && "FrsHottopicDelegateAdapter".equals(((y) aVar).abZ()) && a.this.bky != null) {
                        ((y) aVar).a(a.this.iPW.getPageContext(), a.this.iPW.getUniqueId());
                        if (a.this.isDynamic) {
                            ((y) aVar).setFrom("c13010");
                        }
                        a.this.bky.add(aVar);
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
        this.iPW = frsCommonTabFragment;
        this.iQf.setPriority(1);
        this.iQf.setSelfListener(true);
        this.iPW.registerListener(this.iQf);
        this.iPX = new j(frsCommonTabFragment.getPageContext(), bw.eDA, this.iPW.getUniqueId());
        this.iPY = new j(frsCommonTabFragment.getPageContext(), bw.eDV, this.iPW.getUniqueId());
        this.iPZ = new af(frsCommonTabFragment.getPageContext(), bw.eEb, this.iPW.getUniqueId());
        this.iQa = new aj(frsCommonTabFragment.getPageContext(), bw.eDW, this.iPW.getUniqueId());
        this.iQa.iQl = this.iPW.iQl;
        this.iQb = new aj(frsCommonTabFragment.getPageContext(), bw.eEf, this.iPW.getUniqueId());
        this.iQb.iQl = this.iPW.iQl;
        this.iNs = new r(frsCommonTabFragment.getPageContext(), s.iKL);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), bw.eDO, frsCommonTabFragment.getUniqueId());
        this.iQc = new com.baidu.tieba.frs.entelechy.a.c(frsCommonTabFragment.getPageContext(), bw.eEd, this.iPW.getUniqueId());
        this.iQd = new k(frsCommonTabFragment.getPageContext(), bw.eEc, this.iPW.getUniqueId());
        this.iQe = new ak(frsCommonTabFragment.getPageContext(), bw.eEe, this.iPW.getUniqueId());
        this.bky.add(this.iPX);
        this.bky.add(this.iPY);
        this.bky.add(this.iPZ);
        this.bky.add(this.iQa);
        this.bky.add(this.iQb);
        this.bky.add(this.iNs);
        this.bky.add(aVar);
        this.bky.add(this.iQc);
        this.bky.add(this.iQd);
        this.bky.add(this.iQe);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.iPX.setFrom("c13010");
            this.iPY.setFrom("c13010");
            this.iPZ.setFrom("c13010");
            this.iQa.setFrom("c13010");
            this.iQb.setFrom("c13010");
            EZ("page_frs_dynamic");
        }
        this.iPX.vd(frsCommonTabFragment.tabId);
        this.iPY.vd(frsCommonTabFragment.tabId);
        this.iPZ.vd(frsCommonTabFragment.tabId);
        this.iQa.vd(frsCommonTabFragment.tabId);
        this.iQb.vd(frsCommonTabFragment.tabId);
        this.iQc.vd(frsCommonTabFragment.tabId);
        this.iQd.vd(frsCommonTabFragment.tabId);
        this.iQe.vd(frsCommonTabFragment.tabId);
        this.iPX.zu(frsCommonTabFragment.tabType);
        this.iPY.zu(frsCommonTabFragment.tabType);
        boolean z = frsCommonTabFragment.tabType == 16;
        this.iPX.qa(z);
        this.iQa.qa(z);
        this.iPZ.qa(z);
        this.iQd.qa(z);
        this.iQe.qa(z);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.iPW.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.iPW.getPageContext(), this.iPW.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bky != null) {
                this.bky.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
            b(frsViewData);
        }
        cAN();
        bdTypeRecyclerView.addAdapters(this.bky);
        cBq();
    }

    public void setData(ArrayList<q> arrayList) {
        cAN();
        this.Xe.setData(arrayList);
    }

    private void cAN() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.bky) && this.iPW != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iPW.getTbPageTag());
                }
            }
        }
    }

    private void cBq() {
        if (this.iPW != null && !com.baidu.tbadk.core.util.y.isEmpty(this.bky)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.getStatisticMetaData() != null) {
                        dVar.getStatisticMetaData().jfB = this.iPW.iQk;
                        dVar.getStatisticMetaData().jfD = this.iPW.forumId;
                        dVar.getStatisticMetaData().jfE = this.iPW.tabId;
                        dVar.getStatisticMetaData().jfH = this.iPW.tabType;
                        if (this.iPW.tabId == 502) {
                            dVar.getStatisticMetaData().jfG = 10;
                        } else if (this.iPW.isGeneralTab == 1) {
                            dVar.getStatisticMetaData().jfG = 12;
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
        for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    private void EZ(String str) {
        if (this.bky != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar instanceof f) {
                    ((f) aVar).EZ(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.bky != null && this.bky.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void pX(boolean z) {
        if (this.iPX != null) {
            this.iPX.pZ(z);
        }
        if (this.iPY != null) {
            this.iPY.pZ(z);
        }
        if (this.iQa != null) {
            this.iQa.pZ(z);
        }
        if (this.iQb != null) {
            this.iQb.pZ(z);
        }
    }
}
