package com.baidu.tieba.frs.mc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.n;
import com.baidu.tieba.frs.entelechy.a.o;
import com.baidu.tieba.frs.entelechy.a.p;
import com.baidu.tieba.frs.entelechy.a.q;
import com.baidu.tieba.frs.entelechy.a.r;
import com.baidu.tieba.frs.entelechy.a.s;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {
    private ArrayList<m> eWk;
    private BdTypeRecyclerView fAL;
    private final HashMap<Integer, bh> fEU;
    private FrsViewData fEV;
    private List<com.baidu.adp.widget.ListView.a> fNK;
    private FrsNewAreaFragment fPy;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener fNM = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.aa(f.this.fNK)) {
                f.this.b(f.this.fAL);
                f.this.b(f.this.eWk, f.this.fEV);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.fAL = bdTypeRecyclerView;
        this.fEU = new HashMap<>();
    }

    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fPy = frsNewAreaFragment;
        r rVar = new r(frsNewAreaFragment.getTbPageContext(), bh.bJQ, this.fPy.getUniqueId());
        rVar.setInFrsAllThread(true);
        rVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.g gVar = new com.baidu.tieba.frs.entelechy.a.g(frsNewAreaFragment.getTbPageContext(), bh.bJR, this.fPy.getUniqueId());
        gVar.a(bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), bh.bJT, this.fPy.getUniqueId());
        oVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bh.bJU, this.fPy.getUniqueId());
        mVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.f fVar = new com.baidu.tieba.frs.entelechy.a.f(frsNewAreaFragment.getTbPageContext(), bh.bJV, this.fPy.getUniqueId());
        fVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getTbPageContext(), bh.bJW, this.fPy.getUniqueId());
        hVar.a(bdTypeRecyclerView);
        p pVar = new p(frsNewAreaFragment.getTbPageContext(), bh.bKk, this.fPy.getUniqueId());
        pVar.a(bdTypeRecyclerView);
        s sVar = new s(frsNewAreaFragment.getPageContext(), bh.bKa, this.fPy.getUniqueId());
        sVar.setInFrsAllThread(true);
        sVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.k kVar = new com.baidu.tieba.frs.entelechy.a.k(frsNewAreaFragment.getPageContext(), bh.bJY, this.fPy.getUniqueId());
        kVar.a(bdTypeRecyclerView);
        n nVar = new n(frsNewAreaFragment.getPageContext(), bh.bJZ, this.fPy.getUniqueId());
        nVar.setVoiceManager(frsNewAreaFragment.getVoiceManager());
        nVar.a(bdTypeRecyclerView);
        s sVar2 = new s(frsNewAreaFragment.getPageContext(), bh.bKf, this.fPy.getUniqueId());
        sVar2.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.l lVar = new com.baidu.tieba.frs.l(frsNewAreaFragment.getPageContext(), com.baidu.tieba.frs.m.fyV);
        lVar.a(bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> a = com.baidu.tieba.frs.c.bmc().a(frsNewAreaFragment.getPageContext(), this.fPy.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bh, ? extends v.a> b = com.baidu.tieba.frs.c.bmc().b(frsNewAreaFragment.getPageContext(), bh.bLG, this.fPy.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.ciJ().a(this.fPy, AdvertAppInfo.bFb);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.ciJ().a(this.fPy, AdvertAppInfo.bFk);
        q qVar = new q(frsNewAreaFragment.getPageContext(), bh.bKe, this.fPy.getUniqueId());
        qVar.a(bdTypeRecyclerView);
        this.mAdapters.add(rVar);
        this.mAdapters.add(gVar);
        this.mAdapters.add(oVar);
        this.mAdapters.add(mVar);
        this.mAdapters.add(fVar);
        this.mAdapters.add(hVar);
        this.mAdapters.add(pVar);
        this.mAdapters.add(sVar);
        this.mAdapters.add(kVar);
        this.mAdapters.add(kVar);
        this.mAdapters.add(nVar);
        this.mAdapters.add(lVar);
        this.mAdapters.add(sVar);
        this.mAdapters.add(sVar2);
        this.mAdapters.add(qVar);
        if (a != null) {
            this.mAdapters.add(a);
        }
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.mAdapters.add(a2);
        this.mAdapters.add(a3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.fPy.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fPy, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        bdTypeRecyclerView.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    public void b(ArrayList<m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        com.baidu.tieba.tbadkCore.s.p(arrayList, 1);
        Z(arrayList);
        this.fAL.setData(arrayList);
        this.eWk = arrayList;
        this.fEV = frsViewData;
        bpu();
    }

    public void refreshData() {
        this.fAL.setData(this.eWk);
        notifyDataSetChanged();
    }

    private void bpu() {
        com.baidu.tieba.frs.d.b bpS;
        if (this.fEV != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bpS = ((com.baidu.tieba.frs.d.d) aVar).bpS()) != null) {
                    if (this.fEV.needLog == 1) {
                        bpS.fRi = true;
                    } else {
                        bpS.fRi = false;
                    }
                    if (this.fEV.getForum() != null) {
                        bpS.fRk = this.fEV.getForum().getId();
                    }
                }
            }
        }
    }

    private void Z(ArrayList<m> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    m mVar = arrayList.get(i2);
                    if ((mVar instanceof AdvertAppInfo) && this.fEU != null && !this.fEU.containsValue(mVar)) {
                        this.fEU.put(Integer.valueOf(i2), (bh) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bh> bpT() {
        return this.fEU;
    }

    public void bpY() {
        if (this.fAL != null && this.fAL.getData() != null && this.fAL.getData().size() != 0) {
            for (m mVar : this.fAL.getData()) {
                if ((mVar instanceof bg) && ((bg) mVar).threadData.aex() != 0) {
                    ((bg) mVar).threadData.afs();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.fAL.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.fAL.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.s sVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.h)) {
                    ((com.baidu.tieba.frs.h) aVar).setOnAdapterItemClickListener(sVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.fPy != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.fPy.registerListener(this.fNM);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.fPy == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.fNK = new ArrayList();
        ArrayList<BdUniqueId> cpM = com.baidu.tieba.tbadkCore.s.cpM();
        if (cpM == null || cpM.size() <= 0) {
            return false;
        }
        int size = cpM.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends v.a> a = com.baidu.tieba.frs.c.bmc().a(this.fPy.getPageContext(), cpM.get(i), this.fPy.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.fNK.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.fNK)) {
            bdTypeRecyclerView.addAdapters(this.fNK);
        }
        return true;
    }

    public List<m> getDataList() {
        return this.eWk;
    }
}
