package com.baidu.tieba.frs.mc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.adapter.aa;
import com.baidu.tieba.frs.entelechy.adapter.ab;
import com.baidu.tieba.frs.entelechy.adapter.ac;
import com.baidu.tieba.frs.entelechy.adapter.ad;
import com.baidu.tieba.frs.entelechy.adapter.ae;
import com.baidu.tieba.frs.entelechy.adapter.o;
import com.baidu.tieba.frs.entelechy.adapter.p;
import com.baidu.tieba.frs.entelechy.adapter.q;
import com.baidu.tieba.frs.entelechy.adapter.t;
import com.baidu.tieba.frs.entelechy.adapter.v;
import com.baidu.tieba.frs.entelechy.adapter.w;
import com.baidu.tieba.frs.entelechy.adapter.x;
import com.baidu.tieba.frs.entelechy.adapter.z;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class f {
    private ArrayList<com.baidu.adp.widget.ListView.n> iFV;
    private List<com.baidu.adp.widget.ListView.a> jDM;
    private FrsNewAreaFragment jFB;
    private BdTypeRecyclerView jmj;
    private final HashMap<Integer, cb> jrf;
    private FrsViewData jrg;
    private List<com.baidu.adp.widget.ListView.a> bns = new LinkedList();
    private CustomMessageListener jDO = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && y.isEmpty(f.this.jDM)) {
                f.this.g(f.this.jmj);
                f.this.b(f.this.iFV, f.this.jrg);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.jmj = bdTypeRecyclerView;
        this.jrf = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v11, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jFB = frsNewAreaFragment;
        ac acVar = new ac(frsNewAreaFragment.getTbPageContext(), cb.eQs, this.jFB.getUniqueId());
        acVar.b(bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), cb.eQt, this.jFB.getUniqueId());
        oVar.b(bdTypeRecyclerView);
        z zVar = new z(frsNewAreaFragment.getTbPageContext(), cb.eQv, this.jFB.getUniqueId());
        zVar.b(bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.getTbPageContext(), cb.eQw, this.jFB.getUniqueId());
        wVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.n nVar = new com.baidu.tieba.frs.entelechy.adapter.n(frsNewAreaFragment.getTbPageContext(), cb.eQy, this.jFB.getUniqueId());
        nVar.b(bdTypeRecyclerView);
        q qVar = new q(frsNewAreaFragment.getTbPageContext(), cb.eQz, this.jFB.getUniqueId());
        qVar.b(bdTypeRecyclerView);
        ae aeVar = new ae(frsNewAreaFragment.getTbPageContext(), cb.eQE, this.jFB.getUniqueId());
        aeVar.b(bdTypeRecyclerView);
        aa aaVar = new aa(frsNewAreaFragment.getTbPageContext(), cb.eQY, this.jFB.getUniqueId());
        aaVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.y yVar = new com.baidu.tieba.frs.entelechy.adapter.y(frsNewAreaFragment.getTbPageContext(), cb.eQF, this.jFB.getUniqueId());
        v vVar = new v(frsNewAreaFragment.getTbPageContext(), cb.eQG, this.jFB.getUniqueId());
        ad adVar = new ad(frsNewAreaFragment.getPageContext(), cb.eQK, this.jFB.getUniqueId());
        adVar.b(bdTypeRecyclerView);
        p pVar = new p(frsNewAreaFragment.getPageContext(), cb.eRd, this.jFB.getUniqueId());
        pVar.b(bdTypeRecyclerView);
        t tVar = new t(frsNewAreaFragment.getPageContext(), cb.eQI, this.jFB.getUniqueId());
        tVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.b bVar = new com.baidu.tieba.frs.entelechy.adapter.b(frsNewAreaFragment.getPageContext(), cb.eQR, this.jFB.getUniqueId());
        bVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.i iVar = new com.baidu.tieba.frs.entelechy.adapter.i(frsNewAreaFragment.getPageContext(), cb.eQQ, this.jFB.getUniqueId());
        iVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.j jVar = new com.baidu.tieba.frs.entelechy.adapter.j(frsNewAreaFragment.getPageContext(), cb.eQS, this.jFB.getUniqueId());
        jVar.b(bdTypeRecyclerView);
        x xVar = new x(frsNewAreaFragment.getPageContext(), cb.eQJ, this.jFB.getUniqueId());
        xVar.b(bdTypeRecyclerView);
        ad adVar2 = new ad(frsNewAreaFragment.getPageContext(), cb.eQT, this.jFB.getUniqueId());
        adVar2.b(bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getPageContext(), s.jjF);
        rVar.b(bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends ca, ? extends TypeAdapter.ViewHolder> a2 = com.baidu.tieba.frs.e.cBA().a(frsNewAreaFragment.getPageContext(), this.jFB.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends cb, ? extends TypeAdapter.ViewHolder> b2 = com.baidu.tieba.frs.e.cBA().b(frsNewAreaFragment.getPageContext(), cb.eSx, this.jFB.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dDm().a(this.jFB, AdvertAppInfo.eLa);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.r.dDm().a(this.jFB, AdvertAppInfo.eLj);
        ab abVar = new ab(frsNewAreaFragment.getPageContext(), cb.eQP, this.jFB.getUniqueId());
        abVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.g gVar = new com.baidu.tieba.frs.entelechy.adapter.g(frsNewAreaFragment.getPageContext(), cb.eQD, this.jFB.getUniqueId());
        gVar.a(bdTypeRecyclerView);
        this.bns.add(acVar);
        this.bns.add(oVar);
        this.bns.add(zVar);
        this.bns.add(wVar);
        this.bns.add(nVar);
        this.bns.add(qVar);
        this.bns.add(aaVar);
        this.bns.add(aeVar);
        this.bns.add(yVar);
        this.bns.add(vVar);
        this.bns.add(adVar);
        this.bns.add(tVar);
        this.bns.add(bVar);
        this.bns.add(iVar);
        this.bns.add(jVar);
        this.bns.add(xVar);
        this.bns.add(rVar);
        this.bns.add(pVar);
        this.bns.add(adVar2);
        this.bns.add(abVar);
        this.bns.add(gVar);
        if (a2 != null) {
            this.bns.add(a2);
        }
        if (b2 != null) {
            this.bns.add(b2);
        }
        this.bns.add(a3);
        this.bns.add(a4);
        com.baidu.adp.widget.ListView.a<?, ?> c = com.baidu.tieba.h.b.cNm().c(this.jFB.getBaseFragmentActivity(), AdvertAppInfo.eLm);
        com.baidu.adp.widget.ListView.a<?, ?> c2 = com.baidu.tieba.h.b.cNm().c(this.jFB.getBaseFragmentActivity(), AdvertAppInfo.eLl);
        this.bns.add(c);
        this.bns.add(c2);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.jFB.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jFB.getPageContext(), this.jFB.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bns != null) {
                this.bns.addAll(arrayList);
            }
        }
        f(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.jFB, 1);
        bVar2.setExtraData(this.bns);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.bns);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    public void b(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cEX();
        com.baidu.tieba.tbadkCore.v.x(arrayList, 1);
        ay(arrayList);
        this.jmj.setData(arrayList);
        this.iFV = arrayList;
        this.jrg = frsViewData;
        cFB();
    }

    public void refreshData() {
        this.jmj.setData(this.iFV);
        notifyDataSetChanged();
    }

    private void cEX() {
        if (!y.isEmpty(this.bns) && this.jFB != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jFB.getTbPageTag());
                }
            }
        }
    }

    private void cFB() {
        com.baidu.tieba.frs.b.b statisticMetaData;
        if (this.jrg != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if ((aVar instanceof com.baidu.tieba.frs.b.d) && (statisticMetaData = ((com.baidu.tieba.frs.b.d) aVar).getStatisticMetaData()) != null) {
                    if (this.jrg.needLog == 1) {
                        statisticMetaData.jHk = true;
                    } else {
                        statisticMetaData.jHk = false;
                    }
                    if (this.jrg.getForum() != null) {
                        statisticMetaData.jHm = this.jrg.getForum().getId();
                    }
                }
            }
        }
    }

    private void ay(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    com.baidu.adp.widget.ListView.n nVar = arrayList.get(i2);
                    if ((nVar instanceof AdvertAppInfo) && this.jrf != null && !this.jrf.containsValue(nVar)) {
                        this.jrf.put(Integer.valueOf(i2), (cb) nVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, cb> cGs() {
        return this.jrf;
    }

    public void cGx() {
        if (this.jmj != null && this.jmj.getData() != null && this.jmj.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.n nVar : this.jmj.getData()) {
                if ((nVar instanceof ca) && ((ca) nVar).eJQ.bnL() != 0) {
                    ((ca) nVar).eJQ.boP();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.jmj.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.jmj.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.bns != null && this.bns.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.bns != null && this.bns.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.bns != null && this.bns.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.k)) {
                    ((com.baidu.tieba.frs.k) aVar).a(wVar);
                }
            }
        }
    }

    private void f(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jFB != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.jFB.registerListener(this.jDO);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jFB == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.jDM = new ArrayList();
        ArrayList<BdUniqueId> dML = com.baidu.tieba.tbadkCore.v.dML();
        if (dML == null || dML.size() <= 0) {
            return false;
        }
        int size = dML.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.k<ICardInfo, ? extends TypeAdapter.ViewHolder> a2 = com.baidu.tieba.frs.e.cBA().a(this.jFB.getPageContext(), dML.get(i), this.jFB.getUniqueId());
            if (a2 != null) {
                this.bns.add(a2);
                this.jDM.add(a2);
            }
        }
        if (!y.isEmpty(this.jDM)) {
            bdTypeRecyclerView.addAdapters(this.jDM);
        }
        return true;
    }

    public List<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.iFV;
    }
}
