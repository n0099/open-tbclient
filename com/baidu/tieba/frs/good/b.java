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
    private ArrayList<m> eUx;
    private final HashMap<Integer, bg> fCt;
    private FrsViewData fCu;
    private FrsGoodFragment fKN;
    private List<com.baidu.adp.widget.ListView.a> fLh;
    private ArrayList<m> fLi;
    private BdTypeRecyclerView fyz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener fBc = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((h) aVar).a(b.this.fKN.getPageContext(), b.this.fKN.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(arrayList);
                }
                if (b.this.fyz != null) {
                    b.this.fyz.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener fLj = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.aa(b.this.fLh)) {
                b.this.b(b.this.fyz);
                b.this.b(b.this.eUx, b.this.fCu);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.fyz = bdTypeRecyclerView;
        this.fCt = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fKN = frsGoodFragment;
        this.fBc.setPriority(1);
        this.fBc.setSelfListener(true);
        this.fKN.registerListener(this.fBc);
        r rVar = new r(frsGoodFragment.getTbPageContext(), bg.bJn, this.fKN.getUniqueId());
        rVar.setInFrsAllThread(true);
        g gVar = new g(frsGoodFragment.getTbPageContext(), bg.bJo, this.fKN.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), bg.bJq, this.fKN.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsGoodFragment.getTbPageContext(), bg.bJr, this.fKN.getUniqueId());
        f fVar = new f(frsGoodFragment.getTbPageContext(), bg.bJs, this.fKN.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsGoodFragment.getTbPageContext(), bg.bJt, this.fKN.getUniqueId());
        p pVar = new p(frsGoodFragment.getTbPageContext(), bg.bJH, this.fKN.getUniqueId());
        s sVar = new s(frsGoodFragment.getPageContext(), bg.bJx, this.fKN.getUniqueId());
        sVar.setInFrsAllThread(true);
        k kVar = new k(frsGoodFragment.getPageContext(), bg.bJv, this.fKN.getUniqueId());
        n nVar = new n(frsGoodFragment.getPageContext(), bg.bJw, this.fKN.getUniqueId());
        nVar.setVoiceManager(frsGoodFragment.getVoiceManager());
        s sVar2 = new s(frsGoodFragment.getPageContext(), bg.bJC, this.fKN.getUniqueId());
        l lVar = new l(frsGoodFragment.getPageContext(), com.baidu.tieba.frs.m.fwJ);
        com.baidu.adp.widget.ListView.a<? extends bf, ? extends v.a> a = c.blk().a(frsGoodFragment.getPageContext(), this.fKN.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> b = c.blk().b(frsGoodFragment.getPageContext(), bg.bLd, this.fKN.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.chD().a(this.fKN, AdvertAppInfo.bEC);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.chD().a(this.fKN, AdvertAppInfo.bEL);
        q qVar = new q(frsGoodFragment.getPageContext(), bg.bJB, this.fKN.getUniqueId());
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
        customMessage.setTag(this.fKN.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fKN, 1);
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
        com.baidu.tieba.tbadkCore.q.p(arrayList, 1);
        Z(arrayList);
        ArrayList<m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.fyz.setData(switchThreadDataToThreadCardInfo);
        this.fLi = switchThreadDataToThreadCardInfo;
        this.eUx = arrayList;
        this.fCu = frsViewData;
        bow();
    }

    public void refreshData() {
        this.fyz.setData(this.fLi);
        notifyDataSetChanged();
    }

    private void bow() {
        com.baidu.tieba.frs.d.b boU;
        if (this.fCu != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof d) && (boU = ((d) aVar).boU()) != null) {
                    if (this.fCu.needLog == 1) {
                        boU.fOD = true;
                    } else {
                        boU.fOD = false;
                    }
                    if (this.fCu.getForum() != null) {
                        boU.fOF = this.fCu.getForum().getId();
                    }
                    if (this.fKN != null) {
                        if (this.fKN.fKG) {
                            boU.fOI = 8;
                        } else {
                            boU.fOE = 5;
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
                    if ((mVar instanceof AdvertAppInfo) && this.fCt != null && !this.fCt.containsValue(mVar)) {
                        this.fCt.put(Integer.valueOf(i2), (bg) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bg> boV() {
        return this.fCt;
    }

    public void bpa() {
        if (this.fyz != null && this.fyz.getData() != null && this.fyz.getData().size() != 0) {
            for (m mVar : this.fyz.getData()) {
                if ((mVar instanceof bf) && ((bf) mVar).threadData.aes() != 0) {
                    ((bf) mVar).threadData.afn();
                }
            }
        }
    }

    public void kH(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof z) {
                ((z) aVar).nC(z ? 15 : 3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.fyz.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.fyz.getAdapter().notifyDataSetChanged();
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
                if (it.next().getType() == bg.bJi) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.fKN != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.fKN.registerListener(this.fLj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.fKN == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.fLh = new ArrayList();
        ArrayList<BdUniqueId> coC = com.baidu.tieba.tbadkCore.q.coC();
        if (coC == null || coC.size() <= 0) {
            return false;
        }
        int size = coC.size();
        for (int i = 0; i < size; i++) {
            h<ICardInfo, ? extends v.a> a = c.blk().a(this.fKN.getPageContext(), coC.get(i), this.fKN.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.fLh.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.fLh)) {
            bdTypeRecyclerView.addAdapters(this.fLh);
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
        return this.eUx;
    }

    public List<m> bqN() {
        return this.fLi;
    }
}
