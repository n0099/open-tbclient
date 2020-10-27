package com.baidu.tieba.frs.mc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.aa;
import com.baidu.tieba.frs.entelechy.a.ab;
import com.baidu.tieba.frs.entelechy.a.ac;
import com.baidu.tieba.frs.entelechy.a.o;
import com.baidu.tieba.frs.entelechy.a.r;
import com.baidu.tieba.frs.entelechy.a.t;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.entelechy.a.v;
import com.baidu.tieba.frs.entelechy.a.w;
import com.baidu.tieba.frs.entelechy.a.x;
import com.baidu.tieba.frs.entelechy.a.z;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class f {
    private BdTypeRecyclerView iHt;
    private final HashMap<Integer, bw> iLZ;
    private FrsViewData iMa;
    private List<com.baidu.adp.widget.ListView.a> iWc;
    private FrsNewAreaFragment iXT;
    private ArrayList<q> iaV;
    private List<com.baidu.adp.widget.ListView.a> bje = new LinkedList();
    private CustomMessageListener iWe = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && y.isEmpty(f.this.iWc)) {
                f.this.b(f.this.iHt);
                f.this.b(f.this.iaV, f.this.iMa);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.iHt = bdTypeRecyclerView;
        this.iLZ = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v10, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iXT = frsNewAreaFragment;
        aa aaVar = new aa(frsNewAreaFragment.getTbPageContext(), bw.exO, this.iXT.getUniqueId());
        aaVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.n nVar = new com.baidu.tieba.frs.entelechy.a.n(frsNewAreaFragment.getTbPageContext(), bw.exP, this.iXT.getUniqueId());
        nVar.b(bdTypeRecyclerView);
        x xVar = new x(frsNewAreaFragment.getTbPageContext(), bw.exR, this.iXT.getUniqueId());
        xVar.b(bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.getTbPageContext(), bw.exS, this.iXT.getUniqueId());
        uVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bw.exU, this.iXT.getUniqueId());
        mVar.b(bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), bw.exV, this.iXT.getUniqueId());
        oVar.b(bdTypeRecyclerView);
        ac acVar = new ac(frsNewAreaFragment.getTbPageContext(), bw.eya, this.iXT.getUniqueId());
        acVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.y yVar = new com.baidu.tieba.frs.entelechy.a.y(frsNewAreaFragment.getTbPageContext(), bw.eyv, this.iXT.getUniqueId());
        yVar.b(bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.getTbPageContext(), bw.eyb, this.iXT.getUniqueId());
        t tVar = new t(frsNewAreaFragment.getTbPageContext(), bw.eyc, this.iXT.getUniqueId());
        ab abVar = new ab(frsNewAreaFragment.getPageContext(), bw.eyg, this.iXT.getUniqueId());
        abVar.b(bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getPageContext(), bw.eyd, this.iXT.getUniqueId());
        rVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsNewAreaFragment.getPageContext(), bw.eyo, this.iXT.getUniqueId());
        bVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getPageContext(), bw.eyn, this.iXT.getUniqueId());
        hVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.i iVar = new com.baidu.tieba.frs.entelechy.a.i(frsNewAreaFragment.getPageContext(), bw.eyp, this.iXT.getUniqueId());
        iVar.b(bdTypeRecyclerView);
        v vVar = new v(frsNewAreaFragment.getPageContext(), bw.eyf, this.iXT.getUniqueId());
        vVar.b(bdTypeRecyclerView);
        ab abVar2 = new ab(frsNewAreaFragment.getPageContext(), bw.eyq, this.iXT.getUniqueId());
        abVar2.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsNewAreaFragment.getPageContext(), s.iEO);
        rVar2.b(bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends af.a> a2 = com.baidu.tieba.frs.e.cuU().a(frsNewAreaFragment.getPageContext(), this.iXT.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> b = com.baidu.tieba.frs.e.cuU().b(frsNewAreaFragment.getPageContext(), bw.ezT, this.iXT.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dxM().a(this.iXT, AdvertAppInfo.esD);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.r.dxM().a(this.iXT, AdvertAppInfo.esM);
        z zVar = new z(frsNewAreaFragment.getPageContext(), bw.eyl, this.iXT.getUniqueId());
        zVar.b(bdTypeRecyclerView);
        this.bje.add(aaVar);
        this.bje.add(nVar);
        this.bje.add(xVar);
        this.bje.add(uVar);
        this.bje.add(mVar);
        this.bje.add(oVar);
        this.bje.add(yVar);
        this.bje.add(acVar);
        this.bje.add(wVar);
        this.bje.add(tVar);
        this.bje.add(abVar);
        this.bje.add(rVar);
        this.bje.add(bVar);
        this.bje.add(hVar);
        this.bje.add(iVar);
        this.bje.add(vVar);
        this.bje.add(rVar2);
        this.bje.add(abVar);
        this.bje.add(abVar2);
        this.bje.add(zVar);
        if (a2 != null) {
            this.bje.add(a2);
        }
        if (b != null) {
            this.bje.add(b);
        }
        this.bje.add(a3);
        this.bje.add(a4);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.iXT.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iXT.getPageContext(), this.iXT.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bje != null) {
                this.bje.addAll(arrayList);
            }
        }
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.iXT, 1);
        bVar2.setExtraData(this.bje);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.bje);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    public void b(ArrayList<q> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cym();
        com.baidu.tieba.tbadkCore.u.x(arrayList, 1);
        aB(arrayList);
        this.iHt.setData(arrayList);
        this.iaV = arrayList;
        this.iMa = frsViewData;
        cyP();
    }

    public void refreshData() {
        this.iHt.setData(this.iaV);
        notifyDataSetChanged();
    }

    private void cym() {
        if (!y.isEmpty(this.bje) && this.iXT != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iXT.getTbPageTag());
                }
            }
        }
    }

    private void cyP() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.iMa != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.iMa.needLog == 1) {
                        statisticMetaData.iZE = true;
                    } else {
                        statisticMetaData.iZE = false;
                    }
                    if (this.iMa.getForum() != null) {
                        statisticMetaData.iZG = this.iMa.getForum().getId();
                    }
                }
            }
        }
    }

    private void aB(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    q qVar = arrayList.get(i2);
                    if ((qVar instanceof AdvertAppInfo) && this.iLZ != null && !this.iLZ.containsValue(qVar)) {
                        this.iLZ.put(Integer.valueOf(i2), (bw) qVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bw> czz() {
        return this.iLZ;
    }

    public void czE() {
        if (this.iHt != null && this.iHt.getData() != null && this.iHt.getData().size() != 0) {
            for (q qVar : this.iHt.getData()) {
                if ((qVar instanceof bv) && ((bv) qVar).erH.bjV() != 0) {
                    ((bv) qVar).erH.bkY();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iHt.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.iHt.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.bje != null && this.bje.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.bje != null && this.bje.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.bje != null && this.bje.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.k)) {
                    ((com.baidu.tieba.frs.k) aVar).a(abVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.iXT != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.iXT.registerListener(this.iWe);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.iXT == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.iWc = new ArrayList();
        ArrayList<BdUniqueId> dGO = com.baidu.tieba.tbadkCore.u.dGO();
        if (dGO == null || dGO.size() <= 0) {
            return false;
        }
        int size = dGO.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.k<ICardInfo, ? extends af.a> a2 = com.baidu.tieba.frs.e.cuU().a(this.iXT.getPageContext(), dGO.get(i), this.iXT.getUniqueId());
            if (a2 != null) {
                this.bje.add(a2);
                this.iWc.add(a2);
            }
        }
        if (!y.isEmpty(this.iWc)) {
            bdTypeRecyclerView.addAdapters(this.iWc);
        }
        return true;
    }

    public List<q> getDataList() {
        return this.iaV;
    }
}
