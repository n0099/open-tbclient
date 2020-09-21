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
/* loaded from: classes21.dex */
public class f {
    private ArrayList<q> hzD;
    private BdTypeRecyclerView iga;
    private final HashMap<Integer, bw> ikG;
    private FrsViewData ikH;
    private List<com.baidu.adp.widget.ListView.a> iuN;
    private FrsNewAreaFragment iwE;
    private List<com.baidu.adp.widget.ListView.a> bdV = new LinkedList();
    private CustomMessageListener iuP = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && y.isEmpty(f.this.iuN)) {
                f.this.b(f.this.iga);
                f.this.b(f.this.hzD, f.this.ikH);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.iga = bdTypeRecyclerView;
        this.ikG = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v10, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iwE = frsNewAreaFragment;
        aa aaVar = new aa(frsNewAreaFragment.getTbPageContext(), bw.edl, this.iwE.getUniqueId());
        aaVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.n nVar = new com.baidu.tieba.frs.entelechy.a.n(frsNewAreaFragment.getTbPageContext(), bw.edm, this.iwE.getUniqueId());
        nVar.b(bdTypeRecyclerView);
        x xVar = new x(frsNewAreaFragment.getTbPageContext(), bw.edo, this.iwE.getUniqueId());
        xVar.b(bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.getTbPageContext(), bw.edp, this.iwE.getUniqueId());
        uVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bw.edr, this.iwE.getUniqueId());
        mVar.b(bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), bw.eds, this.iwE.getUniqueId());
        oVar.b(bdTypeRecyclerView);
        ac acVar = new ac(frsNewAreaFragment.getTbPageContext(), bw.edx, this.iwE.getUniqueId());
        acVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.y yVar = new com.baidu.tieba.frs.entelechy.a.y(frsNewAreaFragment.getTbPageContext(), bw.edP, this.iwE.getUniqueId());
        yVar.b(bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.getTbPageContext(), bw.edy, this.iwE.getUniqueId());
        t tVar = new t(frsNewAreaFragment.getTbPageContext(), bw.edz, this.iwE.getUniqueId());
        ab abVar = new ab(frsNewAreaFragment.getPageContext(), bw.edC, this.iwE.getUniqueId());
        abVar.b(bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getPageContext(), bw.edA, this.iwE.getUniqueId());
        rVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsNewAreaFragment.getPageContext(), bw.edI, this.iwE.getUniqueId());
        bVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getPageContext(), bw.edH, this.iwE.getUniqueId());
        hVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.i iVar = new com.baidu.tieba.frs.entelechy.a.i(frsNewAreaFragment.getPageContext(), bw.edJ, this.iwE.getUniqueId());
        iVar.b(bdTypeRecyclerView);
        v vVar = new v(frsNewAreaFragment.getPageContext(), bw.edB, this.iwE.getUniqueId());
        vVar.b(bdTypeRecyclerView);
        ab abVar2 = new ab(frsNewAreaFragment.getPageContext(), bw.edK, this.iwE.getUniqueId());
        abVar2.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsNewAreaFragment.getPageContext(), s.idu);
        rVar2.b(bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends af.a> a = com.baidu.tieba.frs.e.cop().a(frsNewAreaFragment.getPageContext(), this.iwE.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> b = com.baidu.tieba.frs.e.cop().b(frsNewAreaFragment.getPageContext(), bw.efn, this.iwE.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.dqU().a(this.iwE, AdvertAppInfo.dYc);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dqU().a(this.iwE, AdvertAppInfo.dYl);
        z zVar = new z(frsNewAreaFragment.getPageContext(), bw.edG, this.iwE.getUniqueId());
        zVar.b(bdTypeRecyclerView);
        this.bdV.add(aaVar);
        this.bdV.add(nVar);
        this.bdV.add(xVar);
        this.bdV.add(uVar);
        this.bdV.add(mVar);
        this.bdV.add(oVar);
        this.bdV.add(yVar);
        this.bdV.add(acVar);
        this.bdV.add(wVar);
        this.bdV.add(tVar);
        this.bdV.add(abVar);
        this.bdV.add(rVar);
        this.bdV.add(bVar);
        this.bdV.add(hVar);
        this.bdV.add(iVar);
        this.bdV.add(vVar);
        this.bdV.add(rVar2);
        this.bdV.add(abVar);
        this.bdV.add(abVar2);
        this.bdV.add(zVar);
        if (a != null) {
            this.bdV.add(a);
        }
        if (b != null) {
            this.bdV.add(b);
        }
        this.bdV.add(a2);
        this.bdV.add(a3);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.iwE.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iwE.getPageContext(), this.iwE.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bdV != null) {
                this.bdV.addAll(arrayList);
            }
        }
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.iwE, 1);
        bVar2.setExtraData(this.bdV);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.bdV);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    public void b(ArrayList<q> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        crH();
        com.baidu.tieba.tbadkCore.u.u(arrayList, 1);
        aA(arrayList);
        this.iga.setData(arrayList);
        this.hzD = arrayList;
        this.ikH = frsViewData;
        csl();
    }

    public void refreshData() {
        this.iga.setData(this.hzD);
        notifyDataSetChanged();
    }

    private void crH() {
        if (!y.isEmpty(this.bdV) && this.iwE != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iwE.getTbPageTag());
                }
            }
        }
    }

    private void csl() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.ikH != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.ikH.needLog == 1) {
                        statisticMetaData.iyp = true;
                    } else {
                        statisticMetaData.iyp = false;
                    }
                    if (this.ikH.getForum() != null) {
                        statisticMetaData.iyr = this.ikH.getForum().getId();
                    }
                }
            }
        }
    }

    private void aA(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    q qVar = arrayList.get(i2);
                    if ((qVar instanceof AdvertAppInfo) && this.ikG != null && !this.ikG.containsValue(qVar)) {
                        this.ikG.put(Integer.valueOf(i2), (bw) qVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bw> csV() {
        return this.ikG;
    }

    public void cta() {
        if (this.iga != null && this.iga.getData() != null && this.iga.getData().size() != 0) {
            for (q qVar : this.iga.getData()) {
                if ((qVar instanceof bv) && ((bv) qVar).dXg.bft() != 0) {
                    ((bv) qVar).dXg.bgw();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iga.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.iga.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.bdV != null && this.bdV.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.bdV != null && this.bdV.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.bdV != null && this.bdV.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.k)) {
                    ((com.baidu.tieba.frs.k) aVar).a(abVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.iwE != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.iwE.registerListener(this.iuP);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.iwE == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.iuN = new ArrayList();
        ArrayList<BdUniqueId> dzU = com.baidu.tieba.tbadkCore.u.dzU();
        if (dzU == null || dzU.size() <= 0) {
            return false;
        }
        int size = dzU.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.k<ICardInfo, ? extends af.a> a = com.baidu.tieba.frs.e.cop().a(this.iwE.getPageContext(), dzU.get(i), this.iwE.getUniqueId());
            if (a != null) {
                this.bdV.add(a);
                this.iuN.add(a);
            }
        }
        if (!y.isEmpty(this.iuN)) {
            bdTypeRecyclerView.addAdapters(this.iuN);
        }
        return true;
    }

    public List<q> getDataList() {
        return this.hzD;
    }
}
