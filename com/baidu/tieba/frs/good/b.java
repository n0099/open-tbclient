package com.baidu.tieba.frs.good;

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
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.c;
import com.baidu.tieba.frs.d.d;
import com.baidu.tieba.frs.entelechy.a.f;
import com.baidu.tieba.frs.entelechy.a.g;
import com.baidu.tieba.frs.entelechy.a.k;
import com.baidu.tieba.frs.entelechy.a.n;
import com.baidu.tieba.frs.entelechy.a.o;
import com.baidu.tieba.frs.entelechy.a.p;
import com.baidu.tieba.frs.entelechy.a.q;
import com.baidu.tieba.frs.entelechy.a.r;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private ArrayList<m> ezS;
    private BdTypeRecyclerView fdo;
    private final HashMap<Integer, bg> fhc;
    private FrsViewData fhd;
    private List<com.baidu.adp.widget.ListView.a> fpL;
    private FrsGoodFragment fpr;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener ffS = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.b.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof h) {
                        ((h) aVar).a(b.this.fpr.getPageContext(), b.this.fpr.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(arrayList);
                }
                if (b.this.fdo != null) {
                    b.this.fdo.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener fpM = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.T(b.this.fpL)) {
                b.this.b(b.this.fdo);
                b.this.b(b.this.ezS, b.this.fhd);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.fdo = bdTypeRecyclerView;
        this.fhc = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fpr = frsGoodFragment;
        this.ffS.setPriority(1);
        this.ffS.setSelfListener(true);
        this.fpr.registerListener(this.ffS);
        q qVar = new q(frsGoodFragment.getTbPageContext(), bg.bAX, this.fpr.getUniqueId());
        qVar.setInFrsAllThread(true);
        g gVar = new g(frsGoodFragment.getTbPageContext(), bg.bAY, this.fpr.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), bg.bBa, this.fpr.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsGoodFragment.getTbPageContext(), bg.bBb, this.fpr.getUniqueId());
        f fVar = new f(frsGoodFragment.getTbPageContext(), bg.bBc, this.fpr.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsGoodFragment.getTbPageContext(), bg.bBd, this.fpr.getUniqueId());
        r rVar = new r(frsGoodFragment.getPageContext(), bg.bBg, this.fpr.getUniqueId());
        rVar.setInFrsAllThread(true);
        k kVar = new k(frsGoodFragment.getPageContext(), bg.bBe, this.fpr.getUniqueId());
        n nVar = new n(frsGoodFragment.getPageContext(), bg.bBf, this.fpr.getUniqueId());
        nVar.setVoiceManager(frsGoodFragment.getVoiceManager());
        r rVar2 = new r(frsGoodFragment.getPageContext(), bg.bBl, this.fpr.getUniqueId());
        l lVar = new l(frsGoodFragment.getPageContext(), com.baidu.tieba.frs.m.fbw);
        com.baidu.adp.widget.ListView.a<? extends bf, ? extends v.a> a = c.bbM().a(frsGoodFragment.getPageContext(), this.fpr.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> b = c.bbM().b(frsGoodFragment.getPageContext(), bg.bCL, this.fpr.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.bWF().a(this.fpr, AdvertAppInfo.bwp);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.bWF().a(this.fpr, AdvertAppInfo.bwy);
        p pVar = new p(frsGoodFragment.getPageContext(), bg.bBk, this.fpr.getUniqueId());
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
        customMessage.setTag(this.fpr.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        qM("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof aa) {
                ((aa) aVar).hS(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    public void b(ArrayList<m> arrayList, FrsViewData frsViewData) {
        if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof com.baidu.tieba.frs.m)) {
            frsViewData.setThreadList(arrayList);
        }
        b(frsViewData);
        W(arrayList);
        com.baidu.tieba.tbadkCore.q.p(arrayList, 1);
        V(arrayList);
        this.fdo.setData(frsViewData.switchThreadDataToThreadCardInfo());
        this.ezS = arrayList;
        this.fhd = frsViewData;
        bfa();
    }

    private void bfa() {
        com.baidu.tieba.frs.d.b bfx;
        if (this.fhd != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof d) && (bfx = ((d) aVar).bfx()) != null) {
                    if (this.fhd.needLog == 1) {
                        bfx.fsM = true;
                    } else {
                        bfx.fsM = false;
                    }
                    if (this.fhd.getForum() != null) {
                        bfx.fsO = this.fhd.getForum().getId();
                    }
                    if (this.fpr != null) {
                        if (this.fpr.fpk) {
                            bfx.fsR = 8;
                        } else {
                            bfx.fsN = 5;
                        }
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
                    if ((mVar instanceof AdvertAppInfo) && this.fhc != null && !this.fhc.containsValue(mVar)) {
                        this.fhc.put(Integer.valueOf(i2), (bg) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bg> bfy() {
        return this.fhc;
    }

    public void bfD() {
        if (this.fdo != null && this.fdo.getData() != null && this.fdo.getData().size() != 0) {
            for (m mVar : this.fdo.getData()) {
                if ((mVar instanceof bf) && ((bf) mVar).threadData.YJ() != 0) {
                    ((bf) mVar).threadData.ZE();
                }
            }
        }
    }

    public void jL(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof z) {
                ((z) aVar).mC(z ? 15 : 3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.fdo.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.fdo.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof h) {
                    ((h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void setOnAdapterItemClickListener(s sVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar != null && (aVar instanceof h)) {
                    ((h) aVar).setOnAdapterItemClickListener(sVar);
                }
            }
        }
    }

    private void W(ArrayList<m> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<m> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bg.bAS) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.fpr != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.fpr.registerListener(this.fpM);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.fpr == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.fpL = new ArrayList();
        ArrayList<BdUniqueId> cdC = com.baidu.tieba.tbadkCore.q.cdC();
        if (cdC == null || cdC.size() <= 0) {
            return false;
        }
        int size = cdC.size();
        for (int i = 0; i < size; i++) {
            h<ICardInfo, ? extends v.a> a = c.bbM().a(this.fpr.getPageContext(), cdC.get(i), this.fpr.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.fpL.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.T(this.fpL)) {
            bdTypeRecyclerView.addAdapters(this.fpL);
        }
        return true;
    }

    public boolean l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void qM(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).qM(str);
                }
            }
        }
    }
}
