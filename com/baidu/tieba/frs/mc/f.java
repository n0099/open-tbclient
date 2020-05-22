package com.baidu.tieba.frs.mc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.t;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.r;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.entelechy.a.w;
import com.baidu.tieba.frs.entelechy.a.x;
import com.baidu.tieba.frs.entelechy.a.y;
import com.baidu.tieba.frs.entelechy.a.z;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.q;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class f {
    private ArrayList<o> gMN;
    private List<com.baidu.adp.widget.ListView.a> hFh;
    private FrsNewAreaFragment hHb;
    private BdTypeRecyclerView hrM;
    private final HashMap<Integer, bk> hwk;
    private FrsViewData hwl;
    private List<com.baidu.adp.widget.ListView.a> aSj = new LinkedList();
    private CustomMessageListener hFj = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.isEmpty(f.this.hFh)) {
                f.this.b(f.this.hrM);
                f.this.b(f.this.gMN, f.this.hwl);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.hrM = bdTypeRecyclerView;
        this.hwk = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v10, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hHb = frsNewAreaFragment;
        y yVar = new y(frsNewAreaFragment.getTbPageContext(), bk.dEI, this.hHb.getUniqueId());
        yVar.b((t) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.n nVar = new com.baidu.tieba.frs.entelechy.a.n(frsNewAreaFragment.getTbPageContext(), bk.dEJ, this.hHb.getUniqueId());
        nVar.b((t) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsNewAreaFragment.getTbPageContext(), bk.dEL, this.hHb.getUniqueId());
        vVar.b((t) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.t tVar = new com.baidu.tieba.frs.entelechy.a.t(frsNewAreaFragment.getTbPageContext(), bk.dEM, this.hHb.getUniqueId());
        tVar.b((t) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bk.dEO, this.hHb.getUniqueId());
        mVar.b((t) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.o oVar = new com.baidu.tieba.frs.entelechy.a.o(frsNewAreaFragment.getTbPageContext(), bk.dEP, this.hHb.getUniqueId());
        oVar.b((t) bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.getTbPageContext(), bk.dFi, this.hHb.getUniqueId());
        wVar.b((t) bdTypeRecyclerView);
        z zVar = new z(frsNewAreaFragment.getPageContext(), bk.dEV, this.hHb.getUniqueId());
        zVar.b((t) bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getPageContext(), bk.dET, this.hHb.getUniqueId());
        rVar.b((t) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsNewAreaFragment.getPageContext(), bk.dFb, this.hHb.getUniqueId());
        bVar.b((t) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getPageContext(), bk.dFa, this.hHb.getUniqueId());
        hVar.b((t) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.i iVar = new com.baidu.tieba.frs.entelechy.a.i(frsNewAreaFragment.getPageContext(), bk.dFc, this.hHb.getUniqueId());
        iVar.b((t) bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.getPageContext(), bk.dEU, this.hHb.getUniqueId());
        uVar.b((t) bdTypeRecyclerView);
        z zVar2 = new z(frsNewAreaFragment.getPageContext(), bk.dFd, this.hHb.getUniqueId());
        zVar2.b((t) bdTypeRecyclerView);
        com.baidu.tieba.frs.o oVar2 = new com.baidu.tieba.frs.o(frsNewAreaFragment.getPageContext(), p.hqd);
        oVar2.b((t) bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends aa.a> a = com.baidu.tieba.frs.c.bUh().a(frsNewAreaFragment.getPageContext(), this.hHb.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bk, ? extends aa.a> b = com.baidu.tieba.frs.c.bUh().b(frsNewAreaFragment.getPageContext(), bk.dGH, this.hHb.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = q.cUm().a(this.hHb, AdvertAppInfo.dAd);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = q.cUm().a(this.hHb, AdvertAppInfo.dAm);
        x xVar = new x(frsNewAreaFragment.getPageContext(), bk.dEZ, this.hHb.getUniqueId());
        xVar.b((t) bdTypeRecyclerView);
        this.aSj.add(yVar);
        this.aSj.add(nVar);
        this.aSj.add(vVar);
        this.aSj.add(tVar);
        this.aSj.add(mVar);
        this.aSj.add(oVar);
        this.aSj.add(wVar);
        this.aSj.add(zVar);
        this.aSj.add(rVar);
        this.aSj.add(bVar);
        this.aSj.add(hVar);
        this.aSj.add(iVar);
        this.aSj.add(uVar);
        this.aSj.add(oVar2);
        this.aSj.add(zVar);
        this.aSj.add(zVar2);
        this.aSj.add(xVar);
        if (a != null) {
            this.aSj.add(a);
        }
        if (b != null) {
            this.aSj.add(b);
        }
        this.aSj.add(a2);
        this.aSj.add(a3);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.hHb.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.hHb.getPageContext(), this.hHb.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.aSj != null) {
                this.aSj.addAll(arrayList);
            }
        }
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.hHb, 1);
        bVar2.setExtraData(this.aSj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.aSj);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    public void b(ArrayList<o> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        bXd();
        com.baidu.tieba.tbadkCore.t.s(arrayList, 1);
        ar(arrayList);
        this.hrM.setData(arrayList);
        this.gMN = arrayList;
        this.hwl = frsViewData;
        bXH();
    }

    public void refreshData() {
        this.hrM.setData(this.gMN);
        notifyDataSetChanged();
    }

    private void bXd() {
        if (!v.isEmpty(this.aSj) && this.hHb != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.hHb.getTbPageTag());
                }
            }
        }
    }

    private void bXH() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.hwl != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.hwl.needLog == 1) {
                        statisticMetaData.hIN = true;
                    } else {
                        statisticMetaData.hIN = false;
                    }
                    if (this.hwl.getForum() != null) {
                        statisticMetaData.hIP = this.hwl.getForum().getId();
                    }
                }
            }
        }
    }

    private void ar(ArrayList<o> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    o oVar = arrayList.get(i2);
                    if ((oVar instanceof AdvertAppInfo) && this.hwk != null && !this.hwk.containsValue(oVar)) {
                        this.hwk.put(Integer.valueOf(i2), (bk) oVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bk> bYm() {
        return this.hwk;
    }

    public void bYr() {
        if (this.hrM != null && this.hrM.getData() != null && this.hrM.getData().size() != 0) {
            for (o oVar : this.hrM.getData()) {
                if ((oVar instanceof bj) && ((bj) oVar).dEA.aQs() != 0) {
                    ((bj) oVar).dEA.aRw();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hrM.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.hrM.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.aSj != null && this.aSj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.aSj != null && this.aSj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        if (this.aSj != null && this.aSj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.h)) {
                    ((com.baidu.tieba.frs.h) aVar).a(xVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.hHb != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.hHb.registerListener(this.hFj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.hHb == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.hFh = new ArrayList();
        ArrayList<BdUniqueId> dcL = com.baidu.tieba.tbadkCore.t.dcL();
        if (dcL == null || dcL.size() <= 0) {
            return false;
        }
        int size = dcL.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends aa.a> a = com.baidu.tieba.frs.c.bUh().a(this.hHb.getPageContext(), dcL.get(i), this.hHb.getUniqueId());
            if (a != null) {
                this.aSj.add(a);
                this.hFh.add(a);
            }
        }
        if (!v.isEmpty(this.hFh)) {
            bdTypeRecyclerView.addAdapters(this.hFh);
        }
        return true;
    }

    public List<o> getDataList() {
        return this.gMN;
    }
}
