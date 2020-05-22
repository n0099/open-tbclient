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
    private o hrO;
    private FrsCommonTabFragment hup;
    private j huq;
    private j hur;
    private ac hus;
    private ag hut;
    private ag huu;
    private com.baidu.tieba.frs.entelechy.a.c huv;
    private k huw;
    private ah hux;
    private boolean isDynamic;
    private List<com.baidu.adp.widget.ListView.a> aSj = new LinkedList();
    private CustomMessageListener huy = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof x) && "FrsHottopicDelegateAdapter".equals(((x) aVar).NJ()) && a.this.aSj != null) {
                        ((x) aVar).a(a.this.hup.getPageContext(), a.this.hup.getUniqueId());
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
        this.hup = frsCommonTabFragment;
        this.huy.setPriority(1);
        this.huy.setSelfListener(true);
        this.hup.registerListener(this.huy);
        this.huq = new j(frsCommonTabFragment.getPageContext(), bk.dEE, this.hup.getUniqueId());
        this.hur = new j(frsCommonTabFragment.getPageContext(), bk.dEU, this.hup.getUniqueId());
        this.hus = new ac(frsCommonTabFragment.getPageContext(), bk.dEZ, this.hup.getUniqueId());
        this.hut = new ag(frsCommonTabFragment.getPageContext(), bk.dEV, this.hup.getUniqueId());
        this.hut.huE = this.hup.huE;
        this.huu = new ag(frsCommonTabFragment.getPageContext(), bk.dFd, this.hup.getUniqueId());
        this.huu.huE = this.hup.huE;
        this.hrO = new o(frsCommonTabFragment.getPageContext(), p.hqd);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), bk.dER, frsCommonTabFragment.getUniqueId());
        this.huv = new com.baidu.tieba.frs.entelechy.a.c(frsCommonTabFragment.getPageContext(), bk.dFb, this.hup.getUniqueId());
        this.huw = new k(frsCommonTabFragment.getPageContext(), bk.dFa, this.hup.getUniqueId());
        this.hux = new ah(frsCommonTabFragment.getPageContext(), bk.dFc, this.hup.getUniqueId());
        this.aSj.add(this.huq);
        this.aSj.add(this.hur);
        this.aSj.add(this.hus);
        this.aSj.add(this.hut);
        this.aSj.add(this.huu);
        this.aSj.add(this.hrO);
        this.aSj.add(aVar);
        this.aSj.add(this.huv);
        this.aSj.add(this.huw);
        this.aSj.add(this.hux);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.huq.setFrom("c13010");
            this.hur.setFrom("c13010");
            this.hus.setFrom("c13010");
            this.hut.setFrom("c13010");
            this.huu.setFrom("c13010");
            zL("page_frs_dynamic");
        }
        this.huq.qw(frsCommonTabFragment.tabId);
        this.hur.qw(frsCommonTabFragment.tabId);
        this.hus.qw(frsCommonTabFragment.tabId);
        this.hut.qw(frsCommonTabFragment.tabId);
        this.huu.qw(frsCommonTabFragment.tabId);
        this.huv.qw(frsCommonTabFragment.tabId);
        this.huw.qw(frsCommonTabFragment.tabId);
        this.hux.qw(frsCommonTabFragment.tabId);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.hup.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof h) {
                    ((h) aVar2).a(this.hup.getPageContext(), this.hup.getUniqueId());
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
        bXd();
        bdTypeRecyclerView.addAdapters(this.aSj);
        bXH();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
        this.Vw.setData(arrayList);
    }

    private void bXd() {
        if (!v.isEmpty(this.aSj) && this.hup != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.hup.getTbPageTag());
                }
            }
        }
    }

    private void bXH() {
        if (this.hup != null && !v.isEmpty(this.aSj)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.getStatisticMetaData() != null) {
                        dVar.getStatisticMetaData().hIN = this.hup.huD;
                        dVar.getStatisticMetaData().hIP = this.hup.forumId;
                        dVar.getStatisticMetaData().hIQ = this.hup.tabId;
                        if (this.hup.tabId == 502) {
                            dVar.getStatisticMetaData().hIS = 10;
                        } else if (this.hup.isGeneralTab == 1) {
                            dVar.getStatisticMetaData().hIS = 12;
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
        if (this.huq != null) {
            this.huq.nr(z);
        }
        if (this.hur != null) {
            this.hur.nr(z);
        }
        if (this.hut != null) {
            this.hut.nr(z);
        }
        if (this.huu != null) {
            this.huu.nr(z);
        }
    }
}
