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
    private BdTypeRecyclerView Vi;
    private o hda;
    private FrsCommonTabFragment hfB;
    private j hfC;
    private j hfD;
    private ac hfE;
    private ag hfF;
    private ag hfG;
    private com.baidu.tieba.frs.entelechy.a.c hfH;
    private k hfI;
    private ah hfJ;
    private boolean isDynamic;
    private List<com.baidu.adp.widget.ListView.a> aMj = new LinkedList();
    private CustomMessageListener hfK = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof w) && "FrsHottopicDelegateAdapter".equals(((w) aVar).Lw()) && a.this.aMj != null) {
                        ((w) aVar).a(a.this.hfB.getPageContext(), a.this.hfB.getUniqueId());
                        if (a.this.isDynamic) {
                            ((w) aVar).setFrom("c13010");
                        }
                        a.this.aMj.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData);
        this.Vi = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.hfB = frsCommonTabFragment;
        this.hfK.setPriority(1);
        this.hfK.setSelfListener(true);
        this.hfB.registerListener(this.hfK);
        this.hfC = new j(frsCommonTabFragment.getPageContext(), bj.dqI, this.hfB.getUniqueId());
        this.hfD = new j(frsCommonTabFragment.getPageContext(), bj.dqY, this.hfB.getUniqueId());
        this.hfE = new ac(frsCommonTabFragment.getPageContext(), bj.drd, this.hfB.getUniqueId());
        this.hfF = new ag(frsCommonTabFragment.getPageContext(), bj.dqZ, this.hfB.getUniqueId());
        this.hfF.hfQ = this.hfB.hfQ;
        this.hfG = new ag(frsCommonTabFragment.getPageContext(), bj.drh, this.hfB.getUniqueId());
        this.hfG.hfQ = this.hfB.hfQ;
        this.hda = new o(frsCommonTabFragment.getPageContext(), p.hbp);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), bj.dqV, frsCommonTabFragment.getUniqueId());
        this.hfH = new com.baidu.tieba.frs.entelechy.a.c(frsCommonTabFragment.getPageContext(), bj.drf, this.hfB.getUniqueId());
        this.hfI = new k(frsCommonTabFragment.getPageContext(), bj.dre, this.hfB.getUniqueId());
        this.hfJ = new ah(frsCommonTabFragment.getPageContext(), bj.drg, this.hfB.getUniqueId());
        this.aMj.add(this.hfC);
        this.aMj.add(this.hfD);
        this.aMj.add(this.hfE);
        this.aMj.add(this.hfF);
        this.aMj.add(this.hfG);
        this.aMj.add(this.hda);
        this.aMj.add(aVar);
        this.aMj.add(this.hfH);
        this.aMj.add(this.hfI);
        this.aMj.add(this.hfJ);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.hfC.setFrom("c13010");
            this.hfD.setFrom("c13010");
            this.hfE.setFrom("c13010");
            this.hfF.setFrom("c13010");
            this.hfG.setFrom("c13010");
            yf("page_frs_dynamic");
        }
        this.hfC.pV(frsCommonTabFragment.tabId);
        this.hfD.pV(frsCommonTabFragment.tabId);
        this.hfE.pV(frsCommonTabFragment.tabId);
        this.hfF.pV(frsCommonTabFragment.tabId);
        this.hfG.pV(frsCommonTabFragment.tabId);
        this.hfH.pV(frsCommonTabFragment.tabId);
        this.hfI.pV(frsCommonTabFragment.tabId);
        this.hfJ.pV(frsCommonTabFragment.tabId);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.hfB.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof h) {
                    ((h) aVar2).a(this.hfB.getPageContext(), this.hfB.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.aMj != null) {
                this.aMj.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
            b(frsViewData);
        }
        bQG();
        bdTypeRecyclerView.addAdapters(this.aMj);
        bRk();
    }

    public void setData(ArrayList<m> arrayList) {
        this.Vi.setData(arrayList);
    }

    private void bQG() {
        if (!v.isEmpty(this.aMj) && this.hfB != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.hfB.getTbPageTag());
                }
            }
        }
    }

    private void bRk() {
        if (this.hfB != null && !v.isEmpty(this.aMj)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.getStatisticMetaData() != null) {
                        dVar.getStatisticMetaData().hua = this.hfB.hfP;
                        dVar.getStatisticMetaData().huc = this.hfB.forumId;
                        dVar.getStatisticMetaData().hud = this.hfB.tabId;
                        if (this.hfB.tabId == 502) {
                            dVar.getStatisticMetaData().huf = 10;
                        } else if (this.hfB.isGeneralTab == 1) {
                            dVar.getStatisticMetaData().huf = 12;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.Vi.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    private void yf(String str) {
        if (this.aMj != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar instanceof f) {
                    ((f) aVar).yf(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.aMj != null && this.aMj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void mU(boolean z) {
        if (this.hfC != null) {
            this.hfC.mW(z);
        }
        if (this.hfD != null) {
            this.hfD.mW(z);
        }
        if (this.hfF != null) {
            this.hfF.mW(z);
        }
        if (this.hfG != null) {
            this.hfG.mW(z);
        }
    }
}
