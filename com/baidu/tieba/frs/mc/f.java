package com.baidu.tieba.frs.mc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.aa;
import com.baidu.tieba.frs.entelechy.a.ab;
import com.baidu.tieba.frs.entelechy.a.ac;
import com.baidu.tieba.frs.entelechy.a.o;
import com.baidu.tieba.frs.entelechy.a.r;
import com.baidu.tieba.frs.entelechy.a.t;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.entelechy.a.w;
import com.baidu.tieba.frs.entelechy.a.y;
import com.baidu.tieba.frs.entelechy.a.z;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes16.dex */
public class f {
    private BdTypeRecyclerView hKL;
    private final HashMap<Integer, bv> hPp;
    private FrsViewData hPq;
    private List<com.baidu.adp.widget.ListView.a> hZg;
    private ArrayList<q> hfz;
    private FrsNewAreaFragment iaZ;
    private List<com.baidu.adp.widget.ListView.a> aWf = new LinkedList();
    private CustomMessageListener hZi = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && x.isEmpty(f.this.hZg)) {
                f.this.b(f.this.hKL);
                f.this.b(f.this.hfz, f.this.hPq);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.hKL = bdTypeRecyclerView;
        this.hPp = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v10, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iaZ = frsNewAreaFragment;
        aa aaVar = new aa(frsNewAreaFragment.getTbPageContext(), bv.dRB, this.iaZ.getUniqueId());
        aaVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.n nVar = new com.baidu.tieba.frs.entelechy.a.n(frsNewAreaFragment.getTbPageContext(), bv.dRC, this.iaZ.getUniqueId());
        nVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.x xVar = new com.baidu.tieba.frs.entelechy.a.x(frsNewAreaFragment.getTbPageContext(), bv.dRE, this.iaZ.getUniqueId());
        xVar.b((v) bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.getTbPageContext(), bv.dRF, this.iaZ.getUniqueId());
        uVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bv.dRH, this.iaZ.getUniqueId());
        mVar.b((v) bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), bv.dRI, this.iaZ.getUniqueId());
        oVar.b((v) bdTypeRecyclerView);
        ac acVar = new ac(frsNewAreaFragment.getTbPageContext(), bv.dRN, this.iaZ.getUniqueId());
        acVar.b((v) bdTypeRecyclerView);
        y yVar = new y(frsNewAreaFragment.getTbPageContext(), bv.dSf, this.iaZ.getUniqueId());
        yVar.b((v) bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.getTbPageContext(), bv.dRO, this.iaZ.getUniqueId());
        t tVar = new t(frsNewAreaFragment.getTbPageContext(), bv.dRP, this.iaZ.getUniqueId());
        ab abVar = new ab(frsNewAreaFragment.getPageContext(), bv.dRS, this.iaZ.getUniqueId());
        abVar.b((v) bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getPageContext(), bv.dRQ, this.iaZ.getUniqueId());
        rVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsNewAreaFragment.getPageContext(), bv.dRY, this.iaZ.getUniqueId());
        bVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getPageContext(), bv.dRX, this.iaZ.getUniqueId());
        hVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.i iVar = new com.baidu.tieba.frs.entelechy.a.i(frsNewAreaFragment.getPageContext(), bv.dRZ, this.iaZ.getUniqueId());
        iVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsNewAreaFragment.getPageContext(), bv.dRR, this.iaZ.getUniqueId());
        vVar.b((v) bdTypeRecyclerView);
        ab abVar2 = new ab(frsNewAreaFragment.getPageContext(), bv.dSa, this.iaZ.getUniqueId());
        abVar2.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.q qVar = new com.baidu.tieba.frs.q(frsNewAreaFragment.getPageContext(), com.baidu.tieba.frs.r.hIV);
        qVar.b((v) bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bu, ? extends ad.a> a = com.baidu.tieba.frs.e.caF().a(frsNewAreaFragment.getPageContext(), this.iaZ.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends ad.a> b = com.baidu.tieba.frs.e.caF().b(frsNewAreaFragment.getPageContext(), bv.dTD, this.iaZ.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.dca().a(this.iaZ, AdvertAppInfo.dMF);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dca().a(this.iaZ, AdvertAppInfo.dMO);
        z zVar = new z(frsNewAreaFragment.getPageContext(), bv.dRW, this.iaZ.getUniqueId());
        zVar.b((v) bdTypeRecyclerView);
        this.aWf.add(aaVar);
        this.aWf.add(nVar);
        this.aWf.add(xVar);
        this.aWf.add(uVar);
        this.aWf.add(mVar);
        this.aWf.add(oVar);
        this.aWf.add(yVar);
        this.aWf.add(acVar);
        this.aWf.add(wVar);
        this.aWf.add(tVar);
        this.aWf.add(abVar);
        this.aWf.add(rVar);
        this.aWf.add(bVar);
        this.aWf.add(hVar);
        this.aWf.add(iVar);
        this.aWf.add(vVar);
        this.aWf.add(qVar);
        this.aWf.add(abVar);
        this.aWf.add(abVar2);
        this.aWf.add(zVar);
        if (a != null) {
            this.aWf.add(a);
        }
        if (b != null) {
            this.aWf.add(b);
        }
        this.aWf.add(a2);
        this.aWf.add(a3);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.iaZ.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).a(this.iaZ.getPageContext(), this.iaZ.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.aWf != null) {
                this.aWf.addAll(arrayList);
            }
        }
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.iaZ, 1);
        bVar2.setExtraData(this.aWf);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.aWf);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
            if (aVar instanceof com.baidu.tieba.frs.j) {
                ((com.baidu.tieba.frs.j) aVar).release();
            }
        }
    }

    public void b(ArrayList<q> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cdP();
        com.baidu.tieba.tbadkCore.t.r(arrayList, 1);
        as(arrayList);
        this.hKL.setData(arrayList);
        this.hfz = arrayList;
        this.hPq = frsViewData;
        cet();
    }

    public void refreshData() {
        this.hKL.setData(this.hfz);
        notifyDataSetChanged();
    }

    private void cdP() {
        if (!x.isEmpty(this.aWf) && this.iaZ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).a(this.iaZ.getTbPageTag());
                }
            }
        }
    }

    private void cet() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.hPq != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.hPq.needLog == 1) {
                        statisticMetaData.icK = true;
                    } else {
                        statisticMetaData.icK = false;
                    }
                    if (this.hPq.getForum() != null) {
                        statisticMetaData.icM = this.hPq.getForum().getId();
                    }
                }
            }
        }
    }

    private void as(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    q qVar = arrayList.get(i2);
                    if ((qVar instanceof AdvertAppInfo) && this.hPp != null && !this.hPp.containsValue(qVar)) {
                        this.hPp.put(Integer.valueOf(i2), (bv) qVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bv> cfc() {
        return this.hPp;
    }

    public void cfh() {
        if (this.hKL != null && this.hKL.getData() != null && this.hKL.getData().size() != 0) {
            for (q qVar : this.hKL.getData()) {
                if ((qVar instanceof bu) && ((bu) qVar).dLK.aWg() != 0) {
                    ((bu) qVar).dLK.aXj();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hKL.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.hKL.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.aWf != null && this.aWf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.aWf != null && this.aWf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.z zVar) {
        if (this.aWf != null && this.aWf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.j)) {
                    ((com.baidu.tieba.frs.j) aVar).a(zVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.iaZ != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.iaZ.registerListener(this.hZi);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.iaZ == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.hZg = new ArrayList();
        ArrayList<BdUniqueId> dky = com.baidu.tieba.tbadkCore.t.dky();
        if (dky == null || dky.size() <= 0) {
            return false;
        }
        int size = dky.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.j<ICardInfo, ? extends ad.a> a = com.baidu.tieba.frs.e.caF().a(this.iaZ.getPageContext(), dky.get(i), this.iaZ.getUniqueId());
            if (a != null) {
                this.aWf.add(a);
                this.hZg.add(a);
            }
        }
        if (!x.isEmpty(this.hZg)) {
            bdTypeRecyclerView.addAdapters(this.hZg);
        }
        return true;
    }

    public List<q> getDataList() {
        return this.hfz;
    }
}
