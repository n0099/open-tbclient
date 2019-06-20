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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
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
    private ArrayList<m> ePx;
    private List<com.baidu.adp.widget.ListView.a> fGj;
    private FrsNewAreaFragment fHW;
    private BdTypeRecyclerView ftD;
    private final HashMap<Integer, bg> fxx;
    private FrsViewData fxy;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener fGl = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.aa(f.this.fGj)) {
                f.this.b(f.this.ftD);
                f.this.b(f.this.ePx, f.this.fxy);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.ftD = bdTypeRecyclerView;
        this.fxx = new HashMap<>();
    }

    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fHW = frsNewAreaFragment;
        r rVar = new r(frsNewAreaFragment.getTbPageContext(), bg.bIn, this.fHW.getUniqueId());
        rVar.setInFrsAllThread(true);
        rVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.g gVar = new com.baidu.tieba.frs.entelechy.a.g(frsNewAreaFragment.getTbPageContext(), bg.bIo, this.fHW.getUniqueId());
        gVar.a(bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), bg.bIq, this.fHW.getUniqueId());
        oVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bg.bIr, this.fHW.getUniqueId());
        mVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.f fVar = new com.baidu.tieba.frs.entelechy.a.f(frsNewAreaFragment.getTbPageContext(), bg.bIs, this.fHW.getUniqueId());
        fVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getTbPageContext(), bg.bIt, this.fHW.getUniqueId());
        hVar.a(bdTypeRecyclerView);
        p pVar = new p(frsNewAreaFragment.getTbPageContext(), bg.bIH, this.fHW.getUniqueId());
        pVar.a(bdTypeRecyclerView);
        s sVar = new s(frsNewAreaFragment.getPageContext(), bg.bIx, this.fHW.getUniqueId());
        sVar.setInFrsAllThread(true);
        sVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.k kVar = new com.baidu.tieba.frs.entelechy.a.k(frsNewAreaFragment.getPageContext(), bg.bIv, this.fHW.getUniqueId());
        kVar.a(bdTypeRecyclerView);
        n nVar = new n(frsNewAreaFragment.getPageContext(), bg.bIw, this.fHW.getUniqueId());
        nVar.setVoiceManager(frsNewAreaFragment.getVoiceManager());
        nVar.a(bdTypeRecyclerView);
        s sVar2 = new s(frsNewAreaFragment.getPageContext(), bg.bIC, this.fHW.getUniqueId());
        sVar2.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.l lVar = new com.baidu.tieba.frs.l(frsNewAreaFragment.getPageContext(), com.baidu.tieba.frs.m.frM);
        lVar.a(bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bf, ? extends v.a> a = com.baidu.tieba.frs.c.bji().a(frsNewAreaFragment.getPageContext(), this.fHW.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> b = com.baidu.tieba.frs.c.bji().b(frsNewAreaFragment.getPageContext(), bg.bKd, this.fHW.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.ceM().a(this.fHW, AdvertAppInfo.bDC);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.ceM().a(this.fHW, AdvertAppInfo.bDL);
        q qVar = new q(frsNewAreaFragment.getPageContext(), bg.bIB, this.fHW.getUniqueId());
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
        customMessage.setTag(this.fHW.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fHW, 1);
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
        com.baidu.tieba.tbadkCore.q.p(arrayList, 1);
        Z(arrayList);
        this.ftD.setData(arrayList);
        this.ePx = arrayList;
        this.fxy = frsViewData;
        bmv();
    }

    public void refreshData() {
        this.ftD.setData(this.ePx);
        notifyDataSetChanged();
    }

    private void bmv() {
        com.baidu.tieba.frs.d.b bmT;
        if (this.fxy != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bmT = ((com.baidu.tieba.frs.d.d) aVar).bmT()) != null) {
                    if (this.fxy.needLog == 1) {
                        bmT.fJF = true;
                    } else {
                        bmT.fJF = false;
                    }
                    if (this.fxy.getForum() != null) {
                        bmT.fJH = this.fxy.getForum().getId();
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
                    if ((mVar instanceof AdvertAppInfo) && this.fxx != null && !this.fxx.containsValue(mVar)) {
                        this.fxx.put(Integer.valueOf(i2), (bg) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bg> bmU() {
        return this.fxx;
    }

    public void bmZ() {
        if (this.ftD != null && this.ftD.getData() != null && this.ftD.getData().size() != 0) {
            for (m mVar : this.ftD.getData()) {
                if ((mVar instanceof bf) && ((bf) mVar).threadData.adq() != 0) {
                    ((bf) mVar).threadData.ael();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.ftD.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.ftD.getAdapter().notifyDataSetChanged();
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
        if (this.fHW != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.fHW.registerListener(this.fGl);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.fHW == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.fGj = new ArrayList();
        ArrayList<BdUniqueId> clK = com.baidu.tieba.tbadkCore.q.clK();
        if (clK == null || clK.size() <= 0) {
            return false;
        }
        int size = clK.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends v.a> a = com.baidu.tieba.frs.c.bji().a(this.fHW.getPageContext(), clK.get(i), this.fHW.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.fGj.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.fGj)) {
            bdTypeRecyclerView.addAdapters(this.fGj);
        }
        return true;
    }

    public List<m> getDataList() {
        return this.ePx;
    }
}
