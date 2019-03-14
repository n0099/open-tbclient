package com.baidu.tieba.frs.mc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
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
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {
    private ArrayList<m> eAh;
    private BdTypeRecyclerView fdB;
    private final HashMap<Integer, bg> fhq;
    private FrsViewData fhr;
    private List<com.baidu.adp.widget.ListView.a> fpZ;
    private FrsNewAreaFragment frN;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener fqa = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.T(f.this.fpZ)) {
                f.this.b(f.this.fdB);
                f.this.b(f.this.eAh, f.this.fhr);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.fdB = bdTypeRecyclerView;
        this.fhq = new HashMap<>();
    }

    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.frN = frsNewAreaFragment;
        q qVar = new q(frsNewAreaFragment.getTbPageContext(), bg.bAU, this.frN.getUniqueId());
        qVar.setInFrsAllThread(true);
        qVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.g gVar = new com.baidu.tieba.frs.entelechy.a.g(frsNewAreaFragment.getTbPageContext(), bg.bAV, this.frN.getUniqueId());
        gVar.a(bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), bg.bAX, this.frN.getUniqueId());
        oVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bg.bAY, this.frN.getUniqueId());
        mVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.f fVar = new com.baidu.tieba.frs.entelechy.a.f(frsNewAreaFragment.getTbPageContext(), bg.bAZ, this.frN.getUniqueId());
        fVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getTbPageContext(), bg.bBa, this.frN.getUniqueId());
        hVar.a(bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getPageContext(), bg.bBd, this.frN.getUniqueId());
        rVar.setInFrsAllThread(true);
        rVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.k kVar = new com.baidu.tieba.frs.entelechy.a.k(frsNewAreaFragment.getPageContext(), bg.bBb, this.frN.getUniqueId());
        kVar.a(bdTypeRecyclerView);
        n nVar = new n(frsNewAreaFragment.getPageContext(), bg.bBc, this.frN.getUniqueId());
        nVar.setVoiceManager(frsNewAreaFragment.getVoiceManager());
        nVar.a(bdTypeRecyclerView);
        r rVar2 = new r(frsNewAreaFragment.getPageContext(), bg.bBi, this.frN.getUniqueId());
        rVar2.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.l lVar = new com.baidu.tieba.frs.l(frsNewAreaFragment.getPageContext(), com.baidu.tieba.frs.m.fbJ);
        lVar.a(bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> a = com.baidu.tieba.frs.c.bbO().a(frsNewAreaFragment.getPageContext(), bg.bCA, this.frN.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> b = com.baidu.tieba.frs.c.bbO().b(frsNewAreaFragment.getPageContext(), bg.bCI, this.frN.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.bWJ().a(this.frN, AdvertAppInfo.bwm);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.bWJ().a(this.frN, AdvertAppInfo.bwv);
        p pVar = new p(frsNewAreaFragment.getPageContext(), bg.bBh, this.frN.getUniqueId());
        pVar.a(bdTypeRecyclerView);
        this.mAdapters.add(qVar);
        this.mAdapters.add(gVar);
        this.mAdapters.add(oVar);
        this.mAdapters.add(mVar);
        this.mAdapters.add(fVar);
        this.mAdapters.add(hVar);
        this.mAdapters.add(rVar);
        this.mAdapters.add(kVar);
        this.mAdapters.add(kVar);
        this.mAdapters.add(nVar);
        this.mAdapters.add(lVar);
        this.mAdapters.add(rVar);
        this.mAdapters.add(rVar2);
        this.mAdapters.add(pVar);
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
        customMessage.setTag(this.frN.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
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
        V(arrayList);
        this.fdB.setData(arrayList);
        this.eAh = arrayList;
        this.fhr = frsViewData;
        bfc();
    }

    private void bfc() {
        com.baidu.tieba.frs.d.b bfz;
        if (this.fhr != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bfz = ((com.baidu.tieba.frs.d.d) aVar).bfz()) != null) {
                    if (this.fhr.needLog == 1) {
                        bfz.fta = true;
                    } else {
                        bfz.fta = false;
                    }
                    if (this.fhr.getForum() != null) {
                        bfz.ftc = this.fhr.getForum().getId();
                    }
                }
            }
        }
    }

    private void V(ArrayList<m> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    m mVar = arrayList.get(i2);
                    if ((mVar instanceof AdvertAppInfo) && this.fhq != null && !this.fhq.containsValue(mVar)) {
                        this.fhq.put(Integer.valueOf(i2), (bg) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bg> bfA() {
        return this.fhq;
    }

    public void bfF() {
        if (this.fdB != null && this.fdB.getData() != null && this.fdB.getData().size() != 0) {
            for (m mVar : this.fdB.getData()) {
                if ((mVar instanceof bf) && ((bf) mVar).threadData.YM() != 0) {
                    ((bf) mVar).threadData.ZH();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.fdB.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.fdB.getAdapter().notifyDataSetChanged();
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

    public void setOnAdapterItemClickListener(s sVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.h)) {
                    ((com.baidu.tieba.frs.h) aVar).setOnAdapterItemClickListener(sVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.frN != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.frN.registerListener(this.fqa);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.frN == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.fpZ = new ArrayList();
        ArrayList<BdUniqueId> cdG = com.baidu.tieba.tbadkCore.q.cdG();
        if (cdG == null || cdG.size() <= 0) {
            return false;
        }
        int size = cdG.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends v.a> a = com.baidu.tieba.frs.c.bbO().a(this.frN.getPageContext(), cdG.get(i), this.frN.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.fpZ.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.T(this.fpZ)) {
            bdTypeRecyclerView.addAdapters(this.fpZ);
        }
        return true;
    }
}
