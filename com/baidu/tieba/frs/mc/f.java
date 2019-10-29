package com.baidu.tieba.frs.mc;

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
    private ArrayList<m> eYW;
    private final HashMap<Integer, bh> fEl;
    private FrsViewData fEm;
    private List<com.baidu.adp.widget.ListView.a> fNd;
    private FrsNewAreaFragment fOS;
    private BdTypeRecyclerView fzZ;
    private List<com.baidu.adp.widget.ListView.a> agQ = new LinkedList();
    private CustomMessageListener fNf = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.isEmpty(f.this.fNd)) {
                f.this.b(f.this.fzZ);
                f.this.b(f.this.eYW, f.this.fEm);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.fzZ = bdTypeRecyclerView;
        this.fEl = new HashMap<>();
    }

    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fOS = frsNewAreaFragment;
        r rVar = new r(frsNewAreaFragment.getTbPageContext(), bh.cby, this.fOS.getUniqueId());
        rVar.setInFrsAllThread(true);
        rVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.g gVar = new com.baidu.tieba.frs.entelechy.a.g(frsNewAreaFragment.getTbPageContext(), bh.cbz, this.fOS.getUniqueId());
        gVar.a(bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), bh.cbB, this.fOS.getUniqueId());
        oVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bh.cbC, this.fOS.getUniqueId());
        mVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.f fVar = new com.baidu.tieba.frs.entelechy.a.f(frsNewAreaFragment.getTbPageContext(), bh.cbD, this.fOS.getUniqueId());
        fVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getTbPageContext(), bh.cbE, this.fOS.getUniqueId());
        hVar.a(bdTypeRecyclerView);
        p pVar = new p(frsNewAreaFragment.getTbPageContext(), bh.cbS, this.fOS.getUniqueId());
        pVar.a(bdTypeRecyclerView);
        s sVar = new s(frsNewAreaFragment.getPageContext(), bh.cbI, this.fOS.getUniqueId());
        sVar.setInFrsAllThread(true);
        sVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.k kVar = new com.baidu.tieba.frs.entelechy.a.k(frsNewAreaFragment.getPageContext(), bh.cbG, this.fOS.getUniqueId());
        kVar.a(bdTypeRecyclerView);
        n nVar = new n(frsNewAreaFragment.getPageContext(), bh.cbH, this.fOS.getUniqueId());
        nVar.setVoiceManager(frsNewAreaFragment.getVoiceManager());
        nVar.a(bdTypeRecyclerView);
        s sVar2 = new s(frsNewAreaFragment.getPageContext(), bh.cbN, this.fOS.getUniqueId());
        sVar2.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.l lVar = new com.baidu.tieba.frs.l(frsNewAreaFragment.getPageContext(), com.baidu.tieba.frs.m.fyi);
        lVar.a(bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> a = com.baidu.tieba.frs.c.bji().a(frsNewAreaFragment.getPageContext(), this.fOS.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bh, ? extends v.a> b = com.baidu.tieba.frs.c.bji().b(frsNewAreaFragment.getPageContext(), bh.cdp, this.fOS.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.cfL().a(this.fOS, AdvertAppInfo.bWT);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.cfL().a(this.fOS, AdvertAppInfo.bXc);
        q qVar = new q(frsNewAreaFragment.getPageContext(), bh.cbM, this.fOS.getUniqueId());
        qVar.a(bdTypeRecyclerView);
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
        customMessage.setTag(this.fOS.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fOS, 1);
        bVar.setExtraData(this.agQ);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        bdTypeRecyclerView.addAdapters(this.agQ);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    public void b(ArrayList<m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        com.baidu.tieba.tbadkCore.s.n(arrayList, 1);
        ae(arrayList);
        this.fzZ.setData(arrayList);
        this.eYW = arrayList;
        this.fEm = frsViewData;
        bmz();
    }

    public void refreshData() {
        this.fzZ.setData(this.eYW);
        notifyDataSetChanged();
    }

    private void bmz() {
        com.baidu.tieba.frs.d.b bmX;
        if (this.fEm != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bmX = ((com.baidu.tieba.frs.d.d) aVar).bmX()) != null) {
                    if (this.fEm.needLog == 1) {
                        bmX.fQB = true;
                    } else {
                        bmX.fQB = false;
                    }
                    if (this.fEm.getForum() != null) {
                        bmX.fQD = this.fEm.getForum().getId();
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
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.agQ != null && this.agQ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        if (this.agQ != null && this.agQ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.h)) {
                    ((com.baidu.tieba.frs.h) aVar).a(sVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.fOS != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.fOS.registerListener(this.fNf);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.fOS == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.fNd = new ArrayList();
        ArrayList<BdUniqueId> cnD = com.baidu.tieba.tbadkCore.s.cnD();
        if (cnD == null || cnD.size() <= 0) {
            return false;
        }
        int size = cnD.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends v.a> a = com.baidu.tieba.frs.c.bji().a(this.fOS.getPageContext(), cnD.get(i), this.fOS.getUniqueId());
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

    public List<m> getDataList() {
        return this.eYW;
    }
}
