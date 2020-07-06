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
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.aa;
import com.baidu.tieba.frs.entelechy.a.ab;
import com.baidu.tieba.frs.entelechy.a.ac;
import com.baidu.tieba.frs.entelechy.a.o;
import com.baidu.tieba.frs.entelechy.a.r;
import com.baidu.tieba.frs.entelechy.a.t;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.entelechy.a.x;
import com.baidu.tieba.frs.entelechy.a.y;
import com.baidu.tieba.frs.entelechy.a.z;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class f {
    private ArrayList<q> gZU;
    private BdTypeRecyclerView hEN;
    private final HashMap<Integer, bu> hJp;
    private FrsViewData hJq;
    private List<com.baidu.adp.widget.ListView.a> hTh;
    private FrsNewAreaFragment hVa;
    private List<com.baidu.adp.widget.ListView.a> aUP = new LinkedList();
    private CustomMessageListener hTj = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && w.isEmpty(f.this.hTh)) {
                f.this.b(f.this.hEN);
                f.this.b(f.this.gZU, f.this.hJq);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.hEN = bdTypeRecyclerView;
        this.hJp = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v10, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hVa = frsNewAreaFragment;
        aa aaVar = new aa(frsNewAreaFragment.getTbPageContext(), bu.dLq, this.hVa.getUniqueId());
        aaVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.n nVar = new com.baidu.tieba.frs.entelechy.a.n(frsNewAreaFragment.getTbPageContext(), bu.dLr, this.hVa.getUniqueId());
        nVar.b((v) bdTypeRecyclerView);
        x xVar = new x(frsNewAreaFragment.getTbPageContext(), bu.dLt, this.hVa.getUniqueId());
        xVar.b((v) bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.getTbPageContext(), bu.dLu, this.hVa.getUniqueId());
        uVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bu.dLw, this.hVa.getUniqueId());
        mVar.b((v) bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), bu.dLx, this.hVa.getUniqueId());
        oVar.b((v) bdTypeRecyclerView);
        ac acVar = new ac(frsNewAreaFragment.getTbPageContext(), bu.dLC, this.hVa.getUniqueId());
        acVar.b((v) bdTypeRecyclerView);
        y yVar = new y(frsNewAreaFragment.getTbPageContext(), bu.dLU, this.hVa.getUniqueId());
        yVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.w wVar = new com.baidu.tieba.frs.entelechy.a.w(frsNewAreaFragment.getTbPageContext(), bu.dLD, this.hVa.getUniqueId());
        t tVar = new t(frsNewAreaFragment.getTbPageContext(), bu.dLE, this.hVa.getUniqueId());
        ab abVar = new ab(frsNewAreaFragment.getPageContext(), bu.dLH, this.hVa.getUniqueId());
        abVar.b((v) bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getPageContext(), bu.dLF, this.hVa.getUniqueId());
        rVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsNewAreaFragment.getPageContext(), bu.dLN, this.hVa.getUniqueId());
        bVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getPageContext(), bu.dLM, this.hVa.getUniqueId());
        hVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.i iVar = new com.baidu.tieba.frs.entelechy.a.i(frsNewAreaFragment.getPageContext(), bu.dLO, this.hVa.getUniqueId());
        iVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsNewAreaFragment.getPageContext(), bu.dLG, this.hVa.getUniqueId());
        vVar.b((v) bdTypeRecyclerView);
        ab abVar2 = new ab(frsNewAreaFragment.getPageContext(), bu.dLP, this.hVa.getUniqueId());
        abVar2.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.q qVar = new com.baidu.tieba.frs.q(frsNewAreaFragment.getPageContext(), com.baidu.tieba.frs.r.hCX);
        qVar.b((v) bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bt, ? extends ad.a> a = com.baidu.tieba.frs.e.bXm().a(frsNewAreaFragment.getPageContext(), this.hVa.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bu, ? extends ad.a> b = com.baidu.tieba.frs.e.bXm().b(frsNewAreaFragment.getPageContext(), bu.dNs, this.hVa.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.q.cYT().a(this.hVa, AdvertAppInfo.dGu);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.q.cYT().a(this.hVa, AdvertAppInfo.dGD);
        z zVar = new z(frsNewAreaFragment.getPageContext(), bu.dLL, this.hVa.getUniqueId());
        zVar.b((v) bdTypeRecyclerView);
        this.aUP.add(aaVar);
        this.aUP.add(nVar);
        this.aUP.add(xVar);
        this.aUP.add(uVar);
        this.aUP.add(mVar);
        this.aUP.add(oVar);
        this.aUP.add(yVar);
        this.aUP.add(acVar);
        this.aUP.add(wVar);
        this.aUP.add(tVar);
        this.aUP.add(abVar);
        this.aUP.add(rVar);
        this.aUP.add(bVar);
        this.aUP.add(hVar);
        this.aUP.add(iVar);
        this.aUP.add(vVar);
        this.aUP.add(qVar);
        this.aUP.add(abVar);
        this.aUP.add(abVar2);
        this.aUP.add(zVar);
        if (a != null) {
            this.aUP.add(a);
        }
        if (b != null) {
            this.aUP.add(b);
        }
        this.aUP.add(a2);
        this.aUP.add(a3);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.hVa.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).a(this.hVa.getPageContext(), this.hVa.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.aUP != null) {
                this.aUP.addAll(arrayList);
            }
        }
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.hVa, 1);
        bVar2.setExtraData(this.aUP);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.aUP);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
            if (aVar instanceof com.baidu.tieba.frs.j) {
                ((com.baidu.tieba.frs.j) aVar).release();
            }
        }
    }

    public void b(ArrayList<q> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        car();
        com.baidu.tieba.tbadkCore.t.t(arrayList, 1);
        ar(arrayList);
        this.hEN.setData(arrayList);
        this.gZU = arrayList;
        this.hJq = frsViewData;
        caV();
    }

    public void refreshData() {
        this.hEN.setData(this.gZU);
        notifyDataSetChanged();
    }

    private void car() {
        if (!w.isEmpty(this.aUP) && this.hVa != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).a(this.hVa.getTbPageTag());
                }
            }
        }
    }

    private void caV() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.hJq != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.hJq.needLog == 1) {
                        statisticMetaData.hWM = true;
                    } else {
                        statisticMetaData.hWM = false;
                    }
                    if (this.hJq.getForum() != null) {
                        statisticMetaData.hWO = this.hJq.getForum().getId();
                    }
                }
            }
        }
    }

    private void ar(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    q qVar = arrayList.get(i2);
                    if ((qVar instanceof AdvertAppInfo) && this.hJp != null && !this.hJp.containsValue(qVar)) {
                        this.hJp.put(Integer.valueOf(i2), (bu) qVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bu> cbE() {
        return this.hJp;
    }

    public void cbJ() {
        if (this.hEN != null && this.hEN.getData() != null && this.hEN.getData().size() != 0) {
            for (q qVar : this.hEN.getData()) {
                if ((qVar instanceof bt) && ((bt) qVar).dLi.aSk() != 0) {
                    ((bt) qVar).dLi.aTn();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hEN.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.hEN.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.aUP != null && this.aUP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.aUP != null && this.aUP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.z zVar) {
        if (this.aUP != null && this.aUP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.j)) {
                    ((com.baidu.tieba.frs.j) aVar).a(zVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.hVa != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.hVa.registerListener(this.hTj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.hVa == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.hTh = new ArrayList();
        ArrayList<BdUniqueId> dhq = com.baidu.tieba.tbadkCore.t.dhq();
        if (dhq == null || dhq.size() <= 0) {
            return false;
        }
        int size = dhq.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.j<ICardInfo, ? extends ad.a> a = com.baidu.tieba.frs.e.bXm().a(this.hVa.getPageContext(), dhq.get(i), this.hVa.getUniqueId());
            if (a != null) {
                this.aUP.add(a);
                this.hTh.add(a);
            }
        }
        if (!w.isEmpty(this.hTh)) {
            bdTypeRecyclerView.addAdapters(this.hTh);
        }
        return true;
    }

    public List<q> getDataList() {
        return this.gZU;
    }
}
