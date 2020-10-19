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
    private ArrayList<q> hOy;
    private List<com.baidu.adp.widget.ListView.a> iJG;
    private FrsNewAreaFragment iLx;
    private BdTypeRecyclerView iuX;
    private final HashMap<Integer, bw> izD;
    private FrsViewData izE;
    private List<com.baidu.adp.widget.ListView.a> bhH = new LinkedList();
    private CustomMessageListener iJI = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && y.isEmpty(f.this.iJG)) {
                f.this.b(f.this.iuX);
                f.this.b(f.this.hOy, f.this.izE);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.iuX = bdTypeRecyclerView;
        this.izD = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v10, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iLx = frsNewAreaFragment;
        aa aaVar = new aa(frsNewAreaFragment.getTbPageContext(), bw.epq, this.iLx.getUniqueId());
        aaVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.n nVar = new com.baidu.tieba.frs.entelechy.a.n(frsNewAreaFragment.getTbPageContext(), bw.epr, this.iLx.getUniqueId());
        nVar.b(bdTypeRecyclerView);
        x xVar = new x(frsNewAreaFragment.getTbPageContext(), bw.ept, this.iLx.getUniqueId());
        xVar.b(bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.getTbPageContext(), bw.epu, this.iLx.getUniqueId());
        uVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bw.epw, this.iLx.getUniqueId());
        mVar.b(bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), bw.epx, this.iLx.getUniqueId());
        oVar.b(bdTypeRecyclerView);
        ac acVar = new ac(frsNewAreaFragment.getTbPageContext(), bw.epC, this.iLx.getUniqueId());
        acVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.y yVar = new com.baidu.tieba.frs.entelechy.a.y(frsNewAreaFragment.getTbPageContext(), bw.epU, this.iLx.getUniqueId());
        yVar.b(bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.getTbPageContext(), bw.epD, this.iLx.getUniqueId());
        t tVar = new t(frsNewAreaFragment.getTbPageContext(), bw.epE, this.iLx.getUniqueId());
        ab abVar = new ab(frsNewAreaFragment.getPageContext(), bw.epH, this.iLx.getUniqueId());
        abVar.b(bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getPageContext(), bw.epF, this.iLx.getUniqueId());
        rVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsNewAreaFragment.getPageContext(), bw.epN, this.iLx.getUniqueId());
        bVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getPageContext(), bw.epM, this.iLx.getUniqueId());
        hVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.i iVar = new com.baidu.tieba.frs.entelechy.a.i(frsNewAreaFragment.getPageContext(), bw.epO, this.iLx.getUniqueId());
        iVar.b(bdTypeRecyclerView);
        v vVar = new v(frsNewAreaFragment.getPageContext(), bw.epG, this.iLx.getUniqueId());
        vVar.b(bdTypeRecyclerView);
        ab abVar2 = new ab(frsNewAreaFragment.getPageContext(), bw.epP, this.iLx.getUniqueId());
        abVar2.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsNewAreaFragment.getPageContext(), s.iss);
        rVar2.b(bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends af.a> a2 = com.baidu.tieba.frs.e.crN().a(frsNewAreaFragment.getPageContext(), this.iLx.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> b = com.baidu.tieba.frs.e.crN().b(frsNewAreaFragment.getPageContext(), bw.ert, this.iLx.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.duF().a(this.iLx, AdvertAppInfo.eke);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.r.duF().a(this.iLx, AdvertAppInfo.ekn);
        z zVar = new z(frsNewAreaFragment.getPageContext(), bw.epL, this.iLx.getUniqueId());
        zVar.b(bdTypeRecyclerView);
        this.bhH.add(aaVar);
        this.bhH.add(nVar);
        this.bhH.add(xVar);
        this.bhH.add(uVar);
        this.bhH.add(mVar);
        this.bhH.add(oVar);
        this.bhH.add(yVar);
        this.bhH.add(acVar);
        this.bhH.add(wVar);
        this.bhH.add(tVar);
        this.bhH.add(abVar);
        this.bhH.add(rVar);
        this.bhH.add(bVar);
        this.bhH.add(hVar);
        this.bhH.add(iVar);
        this.bhH.add(vVar);
        this.bhH.add(rVar2);
        this.bhH.add(abVar);
        this.bhH.add(abVar2);
        this.bhH.add(zVar);
        if (a2 != null) {
            this.bhH.add(a2);
        }
        if (b != null) {
            this.bhH.add(b);
        }
        this.bhH.add(a3);
        this.bhH.add(a4);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.iLx.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iLx.getPageContext(), this.iLx.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bhH != null) {
                this.bhH.addAll(arrayList);
            }
        }
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.iLx, 1);
        bVar2.setExtraData(this.bhH);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.bhH);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    public void b(ArrayList<q> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cvf();
        com.baidu.tieba.tbadkCore.u.w(arrayList, 1);
        aA(arrayList);
        this.iuX.setData(arrayList);
        this.hOy = arrayList;
        this.izE = frsViewData;
        cvI();
    }

    public void refreshData() {
        this.iuX.setData(this.hOy);
        notifyDataSetChanged();
    }

    private void cvf() {
        if (!y.isEmpty(this.bhH) && this.iLx != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iLx.getTbPageTag());
                }
            }
        }
    }

    private void cvI() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.izE != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.izE.needLog == 1) {
                        statisticMetaData.iNi = true;
                    } else {
                        statisticMetaData.iNi = false;
                    }
                    if (this.izE.getForum() != null) {
                        statisticMetaData.iNk = this.izE.getForum().getId();
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
                    if ((qVar instanceof AdvertAppInfo) && this.izD != null && !this.izD.containsValue(qVar)) {
                        this.izD.put(Integer.valueOf(i2), (bw) qVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bw> cws() {
        return this.izD;
    }

    public void cwx() {
        if (this.iuX != null && this.iuX.getData() != null && this.iuX.getData().size() != 0) {
            for (q qVar : this.iuX.getData()) {
                if ((qVar instanceof bv) && ((bv) qVar).eji.bic() != 0) {
                    ((bv) qVar).eji.bjf();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iuX.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.iuX.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.bhH != null && this.bhH.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.bhH != null && this.bhH.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.bhH != null && this.bhH.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.k)) {
                    ((com.baidu.tieba.frs.k) aVar).a(abVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.iLx != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.iLx.registerListener(this.iJI);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.iLx == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.iJG = new ArrayList();
        ArrayList<BdUniqueId> dDG = com.baidu.tieba.tbadkCore.u.dDG();
        if (dDG == null || dDG.size() <= 0) {
            return false;
        }
        int size = dDG.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.k<ICardInfo, ? extends af.a> a2 = com.baidu.tieba.frs.e.crN().a(this.iLx.getPageContext(), dDG.get(i), this.iLx.getUniqueId());
            if (a2 != null) {
                this.bhH.add(a2);
                this.iJG.add(a2);
            }
        }
        if (!y.isEmpty(this.iJG)) {
            bdTypeRecyclerView.addAdapters(this.iJG);
        }
        return true;
    }

    public List<q> getDataList() {
        return this.hOy;
    }
}
