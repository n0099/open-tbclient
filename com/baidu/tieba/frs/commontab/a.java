package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.a.f;
import com.baidu.tieba.card.w;
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
    private BdTypeRecyclerView Vf;
    private o hcU;
    private ag hfA;
    private com.baidu.tieba.frs.entelechy.a.c hfB;
    private k hfC;
    private ah hfD;
    private FrsCommonTabFragment hfv;
    private j hfw;
    private j hfx;
    private ac hfy;
    private ag hfz;
    private boolean isDynamic;
    private List<com.baidu.adp.widget.ListView.a> aMd = new LinkedList();
    private CustomMessageListener hfE = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof w) && "FrsHottopicDelegateAdapter".equals(((w) aVar).Lx()) && a.this.aMd != null) {
                        ((w) aVar).a(a.this.hfv.getPageContext(), a.this.hfv.getUniqueId());
                        if (a.this.isDynamic) {
                            ((w) aVar).setFrom("c13010");
                        }
                        a.this.aMd.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData);
        this.Vf = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.hfv = frsCommonTabFragment;
        this.hfE.setPriority(1);
        this.hfE.setSelfListener(true);
        this.hfv.registerListener(this.hfE);
        this.hfw = new j(frsCommonTabFragment.getPageContext(), bj.dqE, this.hfv.getUniqueId());
        this.hfx = new j(frsCommonTabFragment.getPageContext(), bj.dqU, this.hfv.getUniqueId());
        this.hfy = new ac(frsCommonTabFragment.getPageContext(), bj.dqZ, this.hfv.getUniqueId());
        this.hfz = new ag(frsCommonTabFragment.getPageContext(), bj.dqV, this.hfv.getUniqueId());
        this.hfz.hfK = this.hfv.hfK;
        this.hfA = new ag(frsCommonTabFragment.getPageContext(), bj.drd, this.hfv.getUniqueId());
        this.hfA.hfK = this.hfv.hfK;
        this.hcU = new o(frsCommonTabFragment.getPageContext(), p.hbj);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), bj.dqR, frsCommonTabFragment.getUniqueId());
        this.hfB = new com.baidu.tieba.frs.entelechy.a.c(frsCommonTabFragment.getPageContext(), bj.drb, this.hfv.getUniqueId());
        this.hfC = new k(frsCommonTabFragment.getPageContext(), bj.dra, this.hfv.getUniqueId());
        this.hfD = new ah(frsCommonTabFragment.getPageContext(), bj.drc, this.hfv.getUniqueId());
        this.aMd.add(this.hfw);
        this.aMd.add(this.hfx);
        this.aMd.add(this.hfy);
        this.aMd.add(this.hfz);
        this.aMd.add(this.hfA);
        this.aMd.add(this.hcU);
        this.aMd.add(aVar);
        this.aMd.add(this.hfB);
        this.aMd.add(this.hfC);
        this.aMd.add(this.hfD);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.hfw.setFrom("c13010");
            this.hfx.setFrom("c13010");
            this.hfy.setFrom("c13010");
            this.hfz.setFrom("c13010");
            this.hfA.setFrom("c13010");
            yc("page_frs_dynamic");
        }
        this.hfw.pV(frsCommonTabFragment.tabId);
        this.hfx.pV(frsCommonTabFragment.tabId);
        this.hfy.pV(frsCommonTabFragment.tabId);
        this.hfz.pV(frsCommonTabFragment.tabId);
        this.hfA.pV(frsCommonTabFragment.tabId);
        this.hfB.pV(frsCommonTabFragment.tabId);
        this.hfC.pV(frsCommonTabFragment.tabId);
        this.hfD.pV(frsCommonTabFragment.tabId);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.hfv.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof h) {
                    ((h) aVar2).a(this.hfv.getPageContext(), this.hfv.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.aMd != null) {
                this.aMd.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
            b(frsViewData);
        }
        bQI();
        bdTypeRecyclerView.addAdapters(this.aMd);
        bRm();
    }

    public void setData(ArrayList<m> arrayList) {
        this.Vf.setData(arrayList);
    }

    private void bQI() {
        if (!v.isEmpty(this.aMd) && this.hfv != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.hfv.getTbPageTag());
                }
            }
        }
    }

    private void bRm() {
        if (this.hfv != null && !v.isEmpty(this.aMd)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.getStatisticMetaData() != null) {
                        dVar.getStatisticMetaData().htU = this.hfv.hfJ;
                        dVar.getStatisticMetaData().htW = this.hfv.forumId;
                        dVar.getStatisticMetaData().htX = this.hfv.tabId;
                        if (this.hfv.tabId == 502) {
                            dVar.getStatisticMetaData().htZ = 10;
                        } else if (this.hfv.isGeneralTab == 1) {
                            dVar.getStatisticMetaData().htZ = 12;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.Vf.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    private void yc(String str) {
        if (this.aMd != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof f) {
                    ((f) aVar).yc(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.aMd != null && this.aMd.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void mU(boolean z) {
        if (this.hfw != null) {
            this.hfw.mW(z);
        }
        if (this.hfx != null) {
            this.hfx.mW(z);
        }
        if (this.hfz != null) {
            this.hfz.mW(z);
        }
        if (this.hfA != null) {
            this.hfA.mW(z);
        }
    }
}
