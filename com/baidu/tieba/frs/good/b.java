package com.baidu.tieba.frs.good;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    private ArrayList<m> eYW;
    private final HashMap<Integer, bh> fEl;
    private FrsViewData fEm;
    private FrsGoodFragment fMJ;
    private List<com.baidu.adp.widget.ListView.a> fNd;
    private ArrayList<m> fNe;
    private BdTypeRecyclerView fzZ;
    private List<com.baidu.adp.widget.ListView.a> agQ = new LinkedList();
    private CustomMessageListener fCU = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((h) aVar).a(b.this.fMJ.getPageContext(), b.this.fMJ.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.agQ != null) {
                    b.this.agQ.addAll(arrayList);
                }
                if (b.this.fzZ != null) {
                    b.this.fzZ.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener fNf = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.isEmpty(b.this.fNd)) {
                b.this.b(b.this.fzZ);
                b.this.b(b.this.eYW, b.this.fEm);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.fzZ = bdTypeRecyclerView;
        this.fEl = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fMJ = frsGoodFragment;
        this.fCU.setPriority(1);
        this.fCU.setSelfListener(true);
        this.fMJ.registerListener(this.fCU);
        r rVar = new r(frsGoodFragment.getTbPageContext(), bh.cby, this.fMJ.getUniqueId());
        rVar.setInFrsAllThread(true);
        g gVar = new g(frsGoodFragment.getTbPageContext(), bh.cbz, this.fMJ.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), bh.cbB, this.fMJ.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsGoodFragment.getTbPageContext(), bh.cbC, this.fMJ.getUniqueId());
        f fVar = new f(frsGoodFragment.getTbPageContext(), bh.cbD, this.fMJ.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsGoodFragment.getTbPageContext(), bh.cbE, this.fMJ.getUniqueId());
        p pVar = new p(frsGoodFragment.getTbPageContext(), bh.cbS, this.fMJ.getUniqueId());
        s sVar = new s(frsGoodFragment.getPageContext(), bh.cbI, this.fMJ.getUniqueId());
        sVar.setInFrsAllThread(true);
        k kVar = new k(frsGoodFragment.getPageContext(), bh.cbG, this.fMJ.getUniqueId());
        n nVar = new n(frsGoodFragment.getPageContext(), bh.cbH, this.fMJ.getUniqueId());
        nVar.setVoiceManager(frsGoodFragment.getVoiceManager());
        s sVar2 = new s(frsGoodFragment.getPageContext(), bh.cbN, this.fMJ.getUniqueId());
        l lVar = new l(frsGoodFragment.getPageContext(), com.baidu.tieba.frs.m.fyi);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> a = c.bji().a(frsGoodFragment.getPageContext(), this.fMJ.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bh, ? extends v.a> b = c.bji().b(frsGoodFragment.getPageContext(), bh.cdp, this.fMJ.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.cfL().a(this.fMJ, AdvertAppInfo.bWT);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.cfL().a(this.fMJ, AdvertAppInfo.bXc);
        q qVar = new q(frsGoodFragment.getPageContext(), bh.cbM, this.fMJ.getUniqueId());
        this.agQ.add(rVar);
        this.agQ.add(gVar);
        this.agQ.add(oVar);
        this.agQ.add(mVar);
        this.agQ.add(fVar);
        this.agQ.add(hVar);
        this.agQ.add(pVar);
        this.agQ.add(sVar);
        this.agQ.add(kVar);
        this.agQ.add(kVar);
        this.agQ.add(nVar);
        this.agQ.add(lVar);
        this.agQ.add(sVar);
        this.agQ.add(sVar2);
        this.agQ.add(qVar);
        if (a != null) {
            this.agQ.add(a);
        }
        if (b != null) {
            this.agQ.add(b);
        }
        this.agQ.add(a2);
        this.agQ.add(a3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.fMJ.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fMJ, 1);
        bVar.setExtraData(this.agQ);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        bdTypeRecyclerView.addAdapters(this.agQ);
        rh("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
            if (aVar instanceof aa) {
                ((aa) aVar).iM(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
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
        af(arrayList);
        com.baidu.tieba.tbadkCore.s.n(arrayList, 1);
        ae(arrayList);
        ArrayList<m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.fzZ.setData(switchThreadDataToThreadCardInfo);
        this.fNe = switchThreadDataToThreadCardInfo;
        this.eYW = arrayList;
        this.fEm = frsViewData;
        bmz();
    }

    public void refreshData() {
        this.fzZ.setData(this.fNe);
        notifyDataSetChanged();
    }

    private void bmz() {
        com.baidu.tieba.frs.d.b bmX;
        if (this.fEm != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
                if ((aVar instanceof d) && (bmX = ((d) aVar).bmX()) != null) {
                    if (this.fEm.needLog == 1) {
                        bmX.fQB = true;
                    } else {
                        bmX.fQB = false;
                    }
                    if (this.fEm.getForum() != null) {
                        bmX.fQD = this.fEm.getForum().getId();
                    }
                    if (this.fMJ != null) {
                        if (this.fMJ.fMC) {
                            bmX.fQG = 8;
                        } else {
                            bmX.fQC = 5;
                        }
                    }
                }
            }
        }
    }

    private void ae(ArrayList<m> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    m mVar = arrayList.get(i2);
                    if ((mVar instanceof AdvertAppInfo) && this.fEl != null && !this.fEl.containsValue(mVar)) {
                        this.fEl.put(Integer.valueOf(i2), (bh) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bh> bmY() {
        return this.fEl;
    }

    public void bnd() {
        if (this.fzZ != null && this.fzZ.getData() != null && this.fzZ.getData().size() != 0) {
            for (m mVar : this.fzZ.getData()) {
                if ((mVar instanceof bg) && ((bg) mVar).cbq.aiB() != 0) {
                    ((bg) mVar).cbq.ajw();
                }
            }
        }
    }

    public void kx(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
            if (aVar instanceof z) {
                ((z) aVar).mX(z ? 15 : 3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.fzZ.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.fzZ.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.agQ != null && this.agQ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
                if (aVar instanceof h) {
                    ((h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.agQ != null && this.agQ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        if (this.agQ != null && this.agQ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
                if (aVar != null && (aVar instanceof h)) {
                    ((h) aVar).a(sVar);
                }
            }
        }
    }

    private void af(ArrayList<m> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<m> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bh.cbt) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.fMJ != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.fMJ.registerListener(this.fNf);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.fMJ == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.fNd = new ArrayList();
        ArrayList<BdUniqueId> cnD = com.baidu.tieba.tbadkCore.s.cnD();
        if (cnD == null || cnD.size() <= 0) {
            return false;
        }
        int size = cnD.size();
        for (int i = 0; i < size; i++) {
            h<ICardInfo, ? extends v.a> a = c.bji().a(this.fMJ.getPageContext(), cnD.get(i), this.fMJ.getUniqueId());
            if (a != null) {
                this.agQ.add(a);
                this.fNd.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.fNd)) {
            bdTypeRecyclerView.addAdapters(this.fNd);
        }
        return true;
    }

    public boolean o(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void rh(String str) {
        if (this.agQ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).rh(str);
                }
            }
        }
    }

    public List<m> getDataList() {
        return this.eYW;
    }

    public List<m> boP() {
        return this.fNe;
    }
}
