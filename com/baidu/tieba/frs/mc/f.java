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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
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
import com.baidu.tieba.frs.entelechy.adapter.y;
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
    private ArrayList<com.baidu.adp.widget.ListView.n> iES;
    private List<com.baidu.adp.widget.ListView.a> jCN;
    private FrsNewAreaFragment jED;
    private BdTypeRecyclerView jlj;
    private final HashMap<Integer, bz> jqf;
    private FrsViewData jqg;
    private List<com.baidu.adp.widget.ListView.a> boM = new LinkedList();
    private CustomMessageListener jCP = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && x.isEmpty(f.this.jCN)) {
                f.this.g(f.this.jlj);
                f.this.b(f.this.iES, f.this.jqg);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.jlj = bdTypeRecyclerView;
        this.jqf = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v11, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jED = frsNewAreaFragment;
        ac acVar = new ac(frsNewAreaFragment.getTbPageContext(), bz.eSR, this.jED.getUniqueId());
        acVar.b(bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), bz.eSS, this.jED.getUniqueId());
        oVar.b(bdTypeRecyclerView);
        z zVar = new z(frsNewAreaFragment.getTbPageContext(), bz.eSU, this.jED.getUniqueId());
        zVar.b(bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.getTbPageContext(), bz.eSV, this.jED.getUniqueId());
        wVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.n nVar = new com.baidu.tieba.frs.entelechy.adapter.n(frsNewAreaFragment.getTbPageContext(), bz.eSX, this.jED.getUniqueId());
        nVar.b(bdTypeRecyclerView);
        q qVar = new q(frsNewAreaFragment.getTbPageContext(), bz.eSY, this.jED.getUniqueId());
        qVar.b(bdTypeRecyclerView);
        ae aeVar = new ae(frsNewAreaFragment.getTbPageContext(), bz.eTd, this.jED.getUniqueId());
        aeVar.b(bdTypeRecyclerView);
        aa aaVar = new aa(frsNewAreaFragment.getTbPageContext(), bz.eTx, this.jED.getUniqueId());
        aaVar.b(bdTypeRecyclerView);
        y yVar = new y(frsNewAreaFragment.getTbPageContext(), bz.eTe, this.jED.getUniqueId());
        v vVar = new v(frsNewAreaFragment.getTbPageContext(), bz.eTf, this.jED.getUniqueId());
        ad adVar = new ad(frsNewAreaFragment.getPageContext(), bz.eTj, this.jED.getUniqueId());
        adVar.b(bdTypeRecyclerView);
        p pVar = new p(frsNewAreaFragment.getPageContext(), bz.eTC, this.jED.getUniqueId());
        pVar.b(bdTypeRecyclerView);
        t tVar = new t(frsNewAreaFragment.getPageContext(), bz.eTh, this.jED.getUniqueId());
        tVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.b bVar = new com.baidu.tieba.frs.entelechy.adapter.b(frsNewAreaFragment.getPageContext(), bz.eTq, this.jED.getUniqueId());
        bVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.i iVar = new com.baidu.tieba.frs.entelechy.adapter.i(frsNewAreaFragment.getPageContext(), bz.eTp, this.jED.getUniqueId());
        iVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.j jVar = new com.baidu.tieba.frs.entelechy.adapter.j(frsNewAreaFragment.getPageContext(), bz.eTr, this.jED.getUniqueId());
        jVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.x xVar = new com.baidu.tieba.frs.entelechy.adapter.x(frsNewAreaFragment.getPageContext(), bz.eTi, this.jED.getUniqueId());
        xVar.b(bdTypeRecyclerView);
        ad adVar2 = new ad(frsNewAreaFragment.getPageContext(), bz.eTs, this.jED.getUniqueId());
        adVar2.b(bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getPageContext(), s.jiG);
        rVar.b(bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends by, ? extends TypeAdapter.ViewHolder> a2 = com.baidu.tieba.frs.e.cEh().a(frsNewAreaFragment.getPageContext(), this.jED.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bz, ? extends TypeAdapter.ViewHolder> b2 = com.baidu.tieba.frs.e.cEh().b(frsNewAreaFragment.getPageContext(), bz.eUW, this.jED.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dEW().a(this.jED, AdvertAppInfo.eNz);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.r.dEW().a(this.jED, AdvertAppInfo.eNI);
        ab abVar = new ab(frsNewAreaFragment.getPageContext(), bz.eTo, this.jED.getUniqueId());
        abVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.g gVar = new com.baidu.tieba.frs.entelechy.adapter.g(frsNewAreaFragment.getPageContext(), bz.eTc, this.jED.getUniqueId());
        gVar.a(bdTypeRecyclerView);
        this.boM.add(acVar);
        this.boM.add(oVar);
        this.boM.add(zVar);
        this.boM.add(wVar);
        this.boM.add(nVar);
        this.boM.add(qVar);
        this.boM.add(aaVar);
        this.boM.add(aeVar);
        this.boM.add(yVar);
        this.boM.add(vVar);
        this.boM.add(adVar);
        this.boM.add(tVar);
        this.boM.add(bVar);
        this.boM.add(iVar);
        this.boM.add(jVar);
        this.boM.add(xVar);
        this.boM.add(rVar);
        this.boM.add(pVar);
        this.boM.add(adVar2);
        this.boM.add(abVar);
        this.boM.add(gVar);
        if (a2 != null) {
            this.boM.add(a2);
        }
        if (b2 != null) {
            this.boM.add(b2);
        }
        this.boM.add(a3);
        this.boM.add(a4);
        com.baidu.adp.widget.ListView.a<?, ?> c = com.baidu.tieba.h.b.cPq().c(this.jED.getBaseFragmentActivity(), AdvertAppInfo.eNL);
        com.baidu.adp.widget.ListView.a<?, ?> c2 = com.baidu.tieba.h.b.cPq().c(this.jED.getBaseFragmentActivity(), AdvertAppInfo.eNK);
        this.boM.add(c);
        this.boM.add(c2);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.jED.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jED.getPageContext(), this.jED.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.boM != null) {
                this.boM.addAll(arrayList);
            }
        }
        f(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.jED, 1);
        bVar2.setExtraData(this.boM);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.boM);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    public void b(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cHD();
        com.baidu.tieba.tbadkCore.v.x(arrayList, 1);
        aE(arrayList);
        this.jlj.setData(arrayList);
        this.iES = arrayList;
        this.jqg = frsViewData;
        cIg();
    }

    public void refreshData() {
        this.jlj.setData(this.iES);
        notifyDataSetChanged();
    }

    private void cHD() {
        if (!x.isEmpty(this.boM) && this.jED != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jED.getTbPageTag());
                }
            }
        }
    }

    private void cIg() {
        com.baidu.tieba.frs.b.b statisticMetaData;
        if (this.jqg != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if ((aVar instanceof com.baidu.tieba.frs.b.d) && (statisticMetaData = ((com.baidu.tieba.frs.b.d) aVar).getStatisticMetaData()) != null) {
                    if (this.jqg.needLog == 1) {
                        statisticMetaData.jGm = true;
                    } else {
                        statisticMetaData.jGm = false;
                    }
                    if (this.jqg.getForum() != null) {
                        statisticMetaData.jGo = this.jqg.getForum().getId();
                    }
                }
            }
        }
    }

    private void aE(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    com.baidu.adp.widget.ListView.n nVar = arrayList.get(i2);
                    if ((nVar instanceof AdvertAppInfo) && this.jqf != null && !this.jqf.containsValue(nVar)) {
                        this.jqf.put(Integer.valueOf(i2), (bz) nVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bz> cIX() {
        return this.jqf;
    }

    public void cJc() {
        if (this.jlj != null && this.jlj.getData() != null && this.jlj.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.n nVar : this.jlj.getData()) {
                if ((nVar instanceof by) && ((by) nVar).eMv.brm() != 0) {
                    ((by) nVar).eMv.bsr();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.jlj.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.jlj.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.boM != null && this.boM.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.boM != null && this.boM.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.boM != null && this.boM.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.k)) {
                    ((com.baidu.tieba.frs.k) aVar).a(wVar);
                }
            }
        }
    }

    private void f(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jED != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.jED.registerListener(this.jCP);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jED == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.jCN = new ArrayList();
        ArrayList<BdUniqueId> dOs = com.baidu.tieba.tbadkCore.v.dOs();
        if (dOs == null || dOs.size() <= 0) {
            return false;
        }
        int size = dOs.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.k<ICardInfo, ? extends TypeAdapter.ViewHolder> a2 = com.baidu.tieba.frs.e.cEh().a(this.jED.getPageContext(), dOs.get(i), this.jED.getUniqueId());
            if (a2 != null) {
                this.boM.add(a2);
                this.jCN.add(a2);
            }
        }
        if (!x.isEmpty(this.jCN)) {
            bdTypeRecyclerView.addAdapters(this.jCN);
        }
        return true;
    }

    public List<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.iES;
    }
}
