package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.a.f;
import com.baidu.tieba.card.x;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.ac;
import com.baidu.tieba.frs.entelechy.a.ag;
import com.baidu.tieba.frs.entelechy.a.ah;
import com.baidu.tieba.frs.entelechy.a.j;
import com.baidu.tieba.frs.entelechy.a.k;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView Vw;
    private o hrZ;
    private FrsCommonTabFragment huA;
    private j huB;
    private j huC;
    private ac huD;
    private ag huE;
    private ag huF;
    private com.baidu.tieba.frs.entelechy.a.c huG;
    private k huH;
    private ah huI;
    private boolean isDynamic;
    private List<com.baidu.adp.widget.ListView.a> aSj = new LinkedList();
    private CustomMessageListener huJ = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof x) && "FrsHottopicDelegateAdapter".equals(((x) aVar).NJ()) && a.this.aSj != null) {
                        ((x) aVar).a(a.this.huA.getPageContext(), a.this.huA.getUniqueId());
                        if (a.this.isDynamic) {
                            ((x) aVar).setFrom("c13010");
                        }
                        a.this.aSj.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData);
        this.Vw = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.huA = frsCommonTabFragment;
        this.huJ.setPriority(1);
        this.huJ.setSelfListener(true);
        this.huA.registerListener(this.huJ);
        this.huB = new j(frsCommonTabFragment.getPageContext(), bk.dEE, this.huA.getUniqueId());
        this.huC = new j(frsCommonTabFragment.getPageContext(), bk.dEU, this.huA.getUniqueId());
        this.huD = new ac(frsCommonTabFragment.getPageContext(), bk.dEZ, this.huA.getUniqueId());
        this.huE = new ag(frsCommonTabFragment.getPageContext(), bk.dEV, this.huA.getUniqueId());
        this.huE.huP = this.huA.huP;
        this.huF = new ag(frsCommonTabFragment.getPageContext(), bk.dFd, this.huA.getUniqueId());
        this.huF.huP = this.huA.huP;
        this.hrZ = new o(frsCommonTabFragment.getPageContext(), p.hqo);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), bk.dER, frsCommonTabFragment.getUniqueId());
        this.huG = new com.baidu.tieba.frs.entelechy.a.c(frsCommonTabFragment.getPageContext(), bk.dFb, this.huA.getUniqueId());
        this.huH = new k(frsCommonTabFragment.getPageContext(), bk.dFa, this.huA.getUniqueId());
        this.huI = new ah(frsCommonTabFragment.getPageContext(), bk.dFc, this.huA.getUniqueId());
        this.aSj.add(this.huB);
        this.aSj.add(this.huC);
        this.aSj.add(this.huD);
        this.aSj.add(this.huE);
        this.aSj.add(this.huF);
        this.aSj.add(this.hrZ);
        this.aSj.add(aVar);
        this.aSj.add(this.huG);
        this.aSj.add(this.huH);
        this.aSj.add(this.huI);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.huB.setFrom("c13010");
            this.huC.setFrom("c13010");
            this.huD.setFrom("c13010");
            this.huE.setFrom("c13010");
            this.huF.setFrom("c13010");
            zL("page_frs_dynamic");
        }
        this.huB.qy(frsCommonTabFragment.tabId);
        this.huC.qy(frsCommonTabFragment.tabId);
        this.huD.qy(frsCommonTabFragment.tabId);
        this.huE.qy(frsCommonTabFragment.tabId);
        this.huF.qy(frsCommonTabFragment.tabId);
        this.huG.qy(frsCommonTabFragment.tabId);
        this.huH.qy(frsCommonTabFragment.tabId);
        this.huI.qy(frsCommonTabFragment.tabId);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.huA.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof h) {
                    ((h) aVar2).a(this.huA.getPageContext(), this.huA.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.aSj != null) {
                this.aSj.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
            b(frsViewData);
        }
        bXf();
        bdTypeRecyclerView.addAdapters(this.aSj);
        bXJ();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
        this.Vw.setData(arrayList);
    }

    private void bXf() {
        if (!v.isEmpty(this.aSj) && this.huA != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.huA.getTbPageTag());
                }
            }
        }
    }

    private void bXJ() {
        if (this.huA != null && !v.isEmpty(this.aSj)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.getStatisticMetaData() != null) {
                        dVar.getStatisticMetaData().hJA = this.huA.huO;
                        dVar.getStatisticMetaData().hJC = this.huA.forumId;
                        dVar.getStatisticMetaData().hJD = this.huA.tabId;
                        if (this.huA.tabId == 502) {
                            dVar.getStatisticMetaData().hJF = 10;
                        } else if (this.huA.isGeneralTab == 1) {
                            dVar.getStatisticMetaData().hJF = 12;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.Vw.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    private void zL(String str) {
        if (this.aSj != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof f) {
                    ((f) aVar).zL(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.aSj != null && this.aSj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void np(boolean z) {
        if (this.huB != null) {
            this.huB.nr(z);
        }
        if (this.huC != null) {
            this.huC.nr(z);
        }
        if (this.huE != null) {
            this.huE.nr(z);
        }
        if (this.huF != null) {
            this.huF.nr(z);
        }
    }
}
