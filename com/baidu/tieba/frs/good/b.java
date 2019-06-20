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
    private ArrayList<m> ePx;
    private FrsGoodFragment fFP;
    private List<com.baidu.adp.widget.ListView.a> fGj;
    private ArrayList<m> fGk;
    private BdTypeRecyclerView ftD;
    private final HashMap<Integer, bg> fxx;
    private FrsViewData fxy;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener fwg = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((h) aVar).a(b.this.fFP.getPageContext(), b.this.fFP.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(arrayList);
                }
                if (b.this.ftD != null) {
                    b.this.ftD.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener fGl = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.aa(b.this.fGj)) {
                b.this.b(b.this.ftD);
                b.this.b(b.this.ePx, b.this.fxy);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.ftD = bdTypeRecyclerView;
        this.fxx = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fFP = frsGoodFragment;
        this.fwg.setPriority(1);
        this.fwg.setSelfListener(true);
        this.fFP.registerListener(this.fwg);
        r rVar = new r(frsGoodFragment.getTbPageContext(), bg.bIn, this.fFP.getUniqueId());
        rVar.setInFrsAllThread(true);
        g gVar = new g(frsGoodFragment.getTbPageContext(), bg.bIo, this.fFP.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), bg.bIq, this.fFP.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsGoodFragment.getTbPageContext(), bg.bIr, this.fFP.getUniqueId());
        f fVar = new f(frsGoodFragment.getTbPageContext(), bg.bIs, this.fFP.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsGoodFragment.getTbPageContext(), bg.bIt, this.fFP.getUniqueId());
        p pVar = new p(frsGoodFragment.getTbPageContext(), bg.bIH, this.fFP.getUniqueId());
        s sVar = new s(frsGoodFragment.getPageContext(), bg.bIx, this.fFP.getUniqueId());
        sVar.setInFrsAllThread(true);
        k kVar = new k(frsGoodFragment.getPageContext(), bg.bIv, this.fFP.getUniqueId());
        n nVar = new n(frsGoodFragment.getPageContext(), bg.bIw, this.fFP.getUniqueId());
        nVar.setVoiceManager(frsGoodFragment.getVoiceManager());
        s sVar2 = new s(frsGoodFragment.getPageContext(), bg.bIC, this.fFP.getUniqueId());
        l lVar = new l(frsGoodFragment.getPageContext(), com.baidu.tieba.frs.m.frM);
        com.baidu.adp.widget.ListView.a<? extends bf, ? extends v.a> a = c.bji().a(frsGoodFragment.getPageContext(), this.fFP.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> b = c.bji().b(frsGoodFragment.getPageContext(), bg.bKd, this.fFP.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.ceM().a(this.fFP, AdvertAppInfo.bDC);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.ceM().a(this.fFP, AdvertAppInfo.bDL);
        q qVar = new q(frsGoodFragment.getPageContext(), bg.bIB, this.fFP.getUniqueId());
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
        customMessage.setTag(this.fFP.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fFP, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        rU("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof aa) {
                ((aa) aVar).ix(true);
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
        this.ftD.setData(switchThreadDataToThreadCardInfo);
        this.fGk = switchThreadDataToThreadCardInfo;
        this.ePx = arrayList;
        this.fxy = frsViewData;
        bmv();
    }

    public void refreshData() {
        this.ftD.setData(this.fGk);
        notifyDataSetChanged();
    }

    private void bmv() {
        com.baidu.tieba.frs.d.b bmT;
        if (this.fxy != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof d) && (bmT = ((d) aVar).bmT()) != null) {
                    if (this.fxy.needLog == 1) {
                        bmT.fJF = true;
                    } else {
                        bmT.fJF = false;
                    }
                    if (this.fxy.getForum() != null) {
                        bmT.fJH = this.fxy.getForum().getId();
                    }
                    if (this.fFP != null) {
                        if (this.fFP.fFI) {
                            bmT.fJK = 8;
                        } else {
                            bmT.fJG = 5;
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

    public void kx(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof z) {
                ((z) aVar).nt(z ? 15 : 3);
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
                if (it.next().getType() == bg.bIi) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.fFP != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.fFP.registerListener(this.fGl);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.fFP == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.fGj = new ArrayList();
        ArrayList<BdUniqueId> clK = com.baidu.tieba.tbadkCore.q.clK();
        if (clK == null || clK.size() <= 0) {
            return false;
        }
        int size = clK.size();
        for (int i = 0; i < size; i++) {
            h<ICardInfo, ? extends v.a> a = c.bji().a(this.fFP.getPageContext(), clK.get(i), this.fFP.getUniqueId());
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

    public boolean m(BdUniqueId bdUniqueId) {
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

    private void rU(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).rU(str);
                }
            }
        }
    }

    public List<m> getDataList() {
        return this.ePx;
    }

    public List<m> boM() {
        return this.fGk;
    }
}
