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
    private ArrayList<m> eYf;
    private final HashMap<Integer, bh> fDu;
    private FrsViewData fDv;
    private List<com.baidu.adp.widget.ListView.a> fMm;
    private FrsNewAreaFragment fOb;
    private BdTypeRecyclerView fzi;
    private List<com.baidu.adp.widget.ListView.a> agy = new LinkedList();
    private CustomMessageListener fMo = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.isEmpty(f.this.fMm)) {
                f.this.b(f.this.fzi);
                f.this.b(f.this.eYf, f.this.fDv);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.fzi = bdTypeRecyclerView;
        this.fDu = new HashMap<>();
    }

    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fOb = frsNewAreaFragment;
        r rVar = new r(frsNewAreaFragment.getTbPageContext(), bh.caH, this.fOb.getUniqueId());
        rVar.setInFrsAllThread(true);
        rVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.g gVar = new com.baidu.tieba.frs.entelechy.a.g(frsNewAreaFragment.getTbPageContext(), bh.caI, this.fOb.getUniqueId());
        gVar.a(bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), bh.caK, this.fOb.getUniqueId());
        oVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bh.caL, this.fOb.getUniqueId());
        mVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.f fVar = new com.baidu.tieba.frs.entelechy.a.f(frsNewAreaFragment.getTbPageContext(), bh.caM, this.fOb.getUniqueId());
        fVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getTbPageContext(), bh.caN, this.fOb.getUniqueId());
        hVar.a(bdTypeRecyclerView);
        p pVar = new p(frsNewAreaFragment.getTbPageContext(), bh.cbb, this.fOb.getUniqueId());
        pVar.a(bdTypeRecyclerView);
        s sVar = new s(frsNewAreaFragment.getPageContext(), bh.caR, this.fOb.getUniqueId());
        sVar.setInFrsAllThread(true);
        sVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.k kVar = new com.baidu.tieba.frs.entelechy.a.k(frsNewAreaFragment.getPageContext(), bh.caP, this.fOb.getUniqueId());
        kVar.a(bdTypeRecyclerView);
        n nVar = new n(frsNewAreaFragment.getPageContext(), bh.caQ, this.fOb.getUniqueId());
        nVar.setVoiceManager(frsNewAreaFragment.getVoiceManager());
        nVar.a(bdTypeRecyclerView);
        s sVar2 = new s(frsNewAreaFragment.getPageContext(), bh.caW, this.fOb.getUniqueId());
        sVar2.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.l lVar = new com.baidu.tieba.frs.l(frsNewAreaFragment.getPageContext(), com.baidu.tieba.frs.m.fxr);
        lVar.a(bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> a = com.baidu.tieba.frs.c.bjg().a(frsNewAreaFragment.getPageContext(), this.fOb.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bh, ? extends v.a> b = com.baidu.tieba.frs.c.bjg().b(frsNewAreaFragment.getPageContext(), bh.ccy, this.fOb.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.cfJ().a(this.fOb, AdvertAppInfo.bWc);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.cfJ().a(this.fOb, AdvertAppInfo.bWl);
        q qVar = new q(frsNewAreaFragment.getPageContext(), bh.caV, this.fOb.getUniqueId());
        qVar.a(bdTypeRecyclerView);
        this.agy.add(rVar);
        this.agy.add(gVar);
        this.agy.add(oVar);
        this.agy.add(mVar);
        this.agy.add(fVar);
        this.agy.add(hVar);
        this.agy.add(pVar);
        this.agy.add(sVar);
        this.agy.add(kVar);
        this.agy.add(kVar);
        this.agy.add(nVar);
        this.agy.add(lVar);
        this.agy.add(sVar);
        this.agy.add(sVar2);
        this.agy.add(qVar);
        if (a != null) {
            this.agy.add(a);
        }
        if (b != null) {
            this.agy.add(b);
        }
        this.agy.add(a2);
        this.agy.add(a3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.fOb.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fOb, 1);
        bVar.setExtraData(this.agy);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        bdTypeRecyclerView.addAdapters(this.agy);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    public void b(ArrayList<m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        com.baidu.tieba.tbadkCore.s.n(arrayList, 1);
        ae(arrayList);
        this.fzi.setData(arrayList);
        this.eYf = arrayList;
        this.fDv = frsViewData;
        bmx();
    }

    public void refreshData() {
        this.fzi.setData(this.eYf);
        notifyDataSetChanged();
    }

    private void bmx() {
        com.baidu.tieba.frs.d.b bmV;
        if (this.fDv != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bmV = ((com.baidu.tieba.frs.d.d) aVar).bmV()) != null) {
                    if (this.fDv.needLog == 1) {
                        bmV.fPK = true;
                    } else {
                        bmV.fPK = false;
                    }
                    if (this.fDv.getForum() != null) {
                        bmV.fPM = this.fDv.getForum().getId();
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
                    if ((mVar instanceof AdvertAppInfo) && this.fDu != null && !this.fDu.containsValue(mVar)) {
                        this.fDu.put(Integer.valueOf(i2), (bh) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bh> bmW() {
        return this.fDu;
    }

    public void bnb() {
        if (this.fzi != null && this.fzi.getData() != null && this.fzi.getData().size() != 0) {
            for (m mVar : this.fzi.getData()) {
                if ((mVar instanceof bg) && ((bg) mVar).caz.aiz() != 0) {
                    ((bg) mVar).caz.aju();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.fzi.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.fzi.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.agy != null && this.agy.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.agy != null && this.agy.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        if (this.agy != null && this.agy.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.h)) {
                    ((com.baidu.tieba.frs.h) aVar).a(sVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.fOb != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.fOb.registerListener(this.fMo);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.fOb == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.fMm = new ArrayList();
        ArrayList<BdUniqueId> cnB = com.baidu.tieba.tbadkCore.s.cnB();
        if (cnB == null || cnB.size() <= 0) {
            return false;
        }
        int size = cnB.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends v.a> a = com.baidu.tieba.frs.c.bjg().a(this.fOb.getPageContext(), cnB.get(i), this.fOb.getUniqueId());
            if (a != null) {
                this.agy.add(a);
                this.fMm.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.fMm)) {
            bdTypeRecyclerView.addAdapters(this.fMm);
        }
        return true;
    }

    public List<m> getDataList() {
        return this.eYf;
    }
}
