package com.baidu.tieba.frs.good;

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
import com.baidu.tieba.frs.entelechy.a.s;
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
    private ArrayList<m> eUE;
    private final HashMap<Integer, bh> fDh;
    private FrsViewData fDi;
    private FrsGoodFragment fLB;
    private List<com.baidu.adp.widget.ListView.a> fLV;
    private ArrayList<m> fLW;
    private BdTypeRecyclerView fyY;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener fBQ = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((h) aVar).a(b.this.fLB.getPageContext(), b.this.fLB.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(arrayList);
                }
                if (b.this.fyY != null) {
                    b.this.fyY.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener fLX = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.aa(b.this.fLV)) {
                b.this.b(b.this.fyY);
                b.this.b(b.this.eUE, b.this.fDi);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.fyY = bdTypeRecyclerView;
        this.fDh = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fLB = frsGoodFragment;
        this.fBQ.setPriority(1);
        this.fBQ.setSelfListener(true);
        this.fLB.registerListener(this.fBQ);
        r rVar = new r(frsGoodFragment.getTbPageContext(), bh.bJs, this.fLB.getUniqueId());
        rVar.setInFrsAllThread(true);
        g gVar = new g(frsGoodFragment.getTbPageContext(), bh.bJt, this.fLB.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), bh.bJv, this.fLB.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsGoodFragment.getTbPageContext(), bh.bJw, this.fLB.getUniqueId());
        f fVar = new f(frsGoodFragment.getTbPageContext(), bh.bJx, this.fLB.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsGoodFragment.getTbPageContext(), bh.bJy, this.fLB.getUniqueId());
        p pVar = new p(frsGoodFragment.getTbPageContext(), bh.bJM, this.fLB.getUniqueId());
        s sVar = new s(frsGoodFragment.getPageContext(), bh.bJC, this.fLB.getUniqueId());
        sVar.setInFrsAllThread(true);
        k kVar = new k(frsGoodFragment.getPageContext(), bh.bJA, this.fLB.getUniqueId());
        n nVar = new n(frsGoodFragment.getPageContext(), bh.bJB, this.fLB.getUniqueId());
        nVar.setVoiceManager(frsGoodFragment.getVoiceManager());
        s sVar2 = new s(frsGoodFragment.getPageContext(), bh.bJH, this.fLB.getUniqueId());
        l lVar = new l(frsGoodFragment.getPageContext(), com.baidu.tieba.frs.m.fxi);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> a = c.blr().a(frsGoodFragment.getPageContext(), this.fLB.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bh, ? extends v.a> b = c.blr().b(frsGoodFragment.getPageContext(), bh.bLi, this.fLB.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.chV().a(this.fLB, AdvertAppInfo.bED);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.chV().a(this.fLB, AdvertAppInfo.bEM);
        q qVar = new q(frsGoodFragment.getPageContext(), bh.bJG, this.fLB.getUniqueId());
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
        customMessage.setTag(this.fLB.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fLB, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        sm("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof aa) {
                ((aa) aVar).iG(true);
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
        aa(arrayList);
        com.baidu.tieba.tbadkCore.s.p(arrayList, 1);
        Z(arrayList);
        ArrayList<m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.fyY.setData(switchThreadDataToThreadCardInfo);
        this.fLW = switchThreadDataToThreadCardInfo;
        this.eUE = arrayList;
        this.fDi = frsViewData;
        boJ();
    }

    public void refreshData() {
        this.fyY.setData(this.fLW);
        notifyDataSetChanged();
    }

    private void boJ() {
        com.baidu.tieba.frs.d.b bph;
        if (this.fDi != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof d) && (bph = ((d) aVar).bph()) != null) {
                    if (this.fDi.needLog == 1) {
                        bph.fPr = true;
                    } else {
                        bph.fPr = false;
                    }
                    if (this.fDi.getForum() != null) {
                        bph.fPt = this.fDi.getForum().getId();
                    }
                    if (this.fLB != null) {
                        if (this.fLB.fLu) {
                            bph.fPw = 8;
                        } else {
                            bph.fPs = 5;
                        }
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
                    if ((mVar instanceof AdvertAppInfo) && this.fDh != null && !this.fDh.containsValue(mVar)) {
                        this.fDh.put(Integer.valueOf(i2), (bh) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bh> bpi() {
        return this.fDh;
    }

    public void bpn() {
        if (this.fyY != null && this.fyY.getData() != null && this.fyY.getData().size() != 0) {
            for (m mVar : this.fyY.getData()) {
                if ((mVar instanceof bg) && ((bg) mVar).threadData.aet() != 0) {
                    ((bg) mVar).threadData.afo();
                }
            }
        }
    }

    public void kH(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof z) {
                ((z) aVar).nD(z ? 15 : 3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.fyY.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.fyY.getAdapter().notifyDataSetChanged();
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

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.s sVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar != null && (aVar instanceof h)) {
                    ((h) aVar).setOnAdapterItemClickListener(sVar);
                }
            }
        }
    }

    private void aa(ArrayList<m> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<m> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bh.bJn) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.fLB != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.fLB.registerListener(this.fLX);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.fLB == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.fLV = new ArrayList();
        ArrayList<BdUniqueId> coY = com.baidu.tieba.tbadkCore.s.coY();
        if (coY == null || coY.size() <= 0) {
            return false;
        }
        int size = coY.size();
        for (int i = 0; i < size; i++) {
            h<ICardInfo, ? extends v.a> a = c.blr().a(this.fLB.getPageContext(), coY.get(i), this.fLB.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.fLV.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.fLV)) {
            bdTypeRecyclerView.addAdapters(this.fLV);
        }
        return true;
    }

    public boolean n(BdUniqueId bdUniqueId) {
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

    private void sm(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).sm(str);
                }
            }
        }
    }

    public List<m> getDataList() {
        return this.eUE;
    }

    public List<m> bra() {
        return this.fLW;
    }
}
