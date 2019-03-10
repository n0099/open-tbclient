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
    private ArrayList<m> eAl;
    private BdTypeRecyclerView fdC;
    private final HashMap<Integer, bg> fhr;
    private FrsViewData fhs;
    private List<com.baidu.adp.widget.ListView.a> fqa;
    private FrsNewAreaFragment frO;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener fqb = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.T(f.this.fqa)) {
                f.this.b(f.this.fdC);
                f.this.b(f.this.eAl, f.this.fhs);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.fdC = bdTypeRecyclerView;
        this.fhr = new HashMap<>();
    }

    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.frO = frsNewAreaFragment;
        q qVar = new q(frsNewAreaFragment.getTbPageContext(), bg.bAS, this.frO.getUniqueId());
        qVar.setInFrsAllThread(true);
        qVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.g gVar = new com.baidu.tieba.frs.entelechy.a.g(frsNewAreaFragment.getTbPageContext(), bg.bAT, this.frO.getUniqueId());
        gVar.a(bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), bg.bAV, this.frO.getUniqueId());
        oVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bg.bAW, this.frO.getUniqueId());
        mVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.f fVar = new com.baidu.tieba.frs.entelechy.a.f(frsNewAreaFragment.getTbPageContext(), bg.bAX, this.frO.getUniqueId());
        fVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getTbPageContext(), bg.bAY, this.frO.getUniqueId());
        hVar.a(bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getPageContext(), bg.bBb, this.frO.getUniqueId());
        rVar.setInFrsAllThread(true);
        rVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.k kVar = new com.baidu.tieba.frs.entelechy.a.k(frsNewAreaFragment.getPageContext(), bg.bAZ, this.frO.getUniqueId());
        kVar.a(bdTypeRecyclerView);
        n nVar = new n(frsNewAreaFragment.getPageContext(), bg.bBa, this.frO.getUniqueId());
        nVar.setVoiceManager(frsNewAreaFragment.getVoiceManager());
        nVar.a(bdTypeRecyclerView);
        r rVar2 = new r(frsNewAreaFragment.getPageContext(), bg.bBg, this.frO.getUniqueId());
        rVar2.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.l lVar = new com.baidu.tieba.frs.l(frsNewAreaFragment.getPageContext(), com.baidu.tieba.frs.m.fbK);
        lVar.a(bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> a = com.baidu.tieba.frs.c.bbP().a(frsNewAreaFragment.getPageContext(), bg.bCy, this.frO.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> b = com.baidu.tieba.frs.c.bbP().b(frsNewAreaFragment.getPageContext(), bg.bCG, this.frO.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.bWH().a(this.frO, AdvertAppInfo.bwk);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.bWH().a(this.frO, AdvertAppInfo.bwt);
        p pVar = new p(frsNewAreaFragment.getPageContext(), bg.bBf, this.frO.getUniqueId());
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
        customMessage.setTag(this.frO.getUniqueId());
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
        this.fdC.setData(arrayList);
        this.eAl = arrayList;
        this.fhs = frsViewData;
        bfd();
    }

    private void bfd() {
        com.baidu.tieba.frs.d.b bfA;
        if (this.fhs != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bfA = ((com.baidu.tieba.frs.d.d) aVar).bfA()) != null) {
                    if (this.fhs.needLog == 1) {
                        bfA.ftb = true;
                    } else {
                        bfA.ftb = false;
                    }
                    if (this.fhs.getForum() != null) {
                        bfA.ftd = this.fhs.getForum().getId();
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
                    if ((mVar instanceof AdvertAppInfo) && this.fhr != null && !this.fhr.containsValue(mVar)) {
                        this.fhr.put(Integer.valueOf(i2), (bg) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bg> bfB() {
        return this.fhr;
    }

    public void bfG() {
        if (this.fdC != null && this.fdC.getData() != null && this.fdC.getData().size() != 0) {
            for (m mVar : this.fdC.getData()) {
                if ((mVar instanceof bf) && ((bf) mVar).threadData.YM() != 0) {
                    ((bf) mVar).threadData.ZH();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.fdC.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.fdC.getAdapter().notifyDataSetChanged();
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
        if (this.frO != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.frO.registerListener(this.fqb);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.frO == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.fqa = new ArrayList();
        ArrayList<BdUniqueId> cdE = com.baidu.tieba.tbadkCore.q.cdE();
        if (cdE == null || cdE.size() <= 0) {
            return false;
        }
        int size = cdE.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends v.a> a = com.baidu.tieba.frs.c.bbP().a(this.frO.getPageContext(), cdE.get(i), this.frO.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.fqa.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.T(this.fqa)) {
            bdTypeRecyclerView.addAdapters(this.fqa);
        }
        return true;
    }
}
