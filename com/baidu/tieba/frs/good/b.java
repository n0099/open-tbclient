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
    private ArrayList<m> eYf;
    private final HashMap<Integer, bh> fDu;
    private FrsViewData fDv;
    private FrsGoodFragment fLS;
    private List<com.baidu.adp.widget.ListView.a> fMm;
    private ArrayList<m> fMn;
    private BdTypeRecyclerView fzi;
    private List<com.baidu.adp.widget.ListView.a> agy = new LinkedList();
    private CustomMessageListener fCd = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((h) aVar).a(b.this.fLS.getPageContext(), b.this.fLS.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.agy != null) {
                    b.this.agy.addAll(arrayList);
                }
                if (b.this.fzi != null) {
                    b.this.fzi.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener fMo = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.isEmpty(b.this.fMm)) {
                b.this.b(b.this.fzi);
                b.this.b(b.this.eYf, b.this.fDv);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.fzi = bdTypeRecyclerView;
        this.fDu = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fLS = frsGoodFragment;
        this.fCd.setPriority(1);
        this.fCd.setSelfListener(true);
        this.fLS.registerListener(this.fCd);
        r rVar = new r(frsGoodFragment.getTbPageContext(), bh.caH, this.fLS.getUniqueId());
        rVar.setInFrsAllThread(true);
        g gVar = new g(frsGoodFragment.getTbPageContext(), bh.caI, this.fLS.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), bh.caK, this.fLS.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsGoodFragment.getTbPageContext(), bh.caL, this.fLS.getUniqueId());
        f fVar = new f(frsGoodFragment.getTbPageContext(), bh.caM, this.fLS.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsGoodFragment.getTbPageContext(), bh.caN, this.fLS.getUniqueId());
        p pVar = new p(frsGoodFragment.getTbPageContext(), bh.cbb, this.fLS.getUniqueId());
        s sVar = new s(frsGoodFragment.getPageContext(), bh.caR, this.fLS.getUniqueId());
        sVar.setInFrsAllThread(true);
        k kVar = new k(frsGoodFragment.getPageContext(), bh.caP, this.fLS.getUniqueId());
        n nVar = new n(frsGoodFragment.getPageContext(), bh.caQ, this.fLS.getUniqueId());
        nVar.setVoiceManager(frsGoodFragment.getVoiceManager());
        s sVar2 = new s(frsGoodFragment.getPageContext(), bh.caW, this.fLS.getUniqueId());
        l lVar = new l(frsGoodFragment.getPageContext(), com.baidu.tieba.frs.m.fxr);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> a = c.bjg().a(frsGoodFragment.getPageContext(), this.fLS.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bh, ? extends v.a> b = c.bjg().b(frsGoodFragment.getPageContext(), bh.ccy, this.fLS.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.cfJ().a(this.fLS, AdvertAppInfo.bWc);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.cfJ().a(this.fLS, AdvertAppInfo.bWl);
        q qVar = new q(frsGoodFragment.getPageContext(), bh.caV, this.fLS.getUniqueId());
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
        customMessage.setTag(this.fLS.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fLS, 1);
        bVar.setExtraData(this.agy);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        bdTypeRecyclerView.addAdapters(this.agy);
        rh("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
            if (aVar instanceof aa) {
                ((aa) aVar).iM(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
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
        this.fzi.setData(switchThreadDataToThreadCardInfo);
        this.fMn = switchThreadDataToThreadCardInfo;
        this.eYf = arrayList;
        this.fDv = frsViewData;
        bmx();
    }

    public void refreshData() {
        this.fzi.setData(this.fMn);
        notifyDataSetChanged();
    }

    private void bmx() {
        com.baidu.tieba.frs.d.b bmV;
        if (this.fDv != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
                if ((aVar instanceof d) && (bmV = ((d) aVar).bmV()) != null) {
                    if (this.fDv.needLog == 1) {
                        bmV.fPK = true;
                    } else {
                        bmV.fPK = false;
                    }
                    if (this.fDv.getForum() != null) {
                        bmV.fPM = this.fDv.getForum().getId();
                    }
                    if (this.fLS != null) {
                        if (this.fLS.fLL) {
                            bmV.fPP = 8;
                        } else {
                            bmV.fPL = 5;
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

    public void kx(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
            if (aVar instanceof z) {
                ((z) aVar).mW(z ? 15 : 3);
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
                if (aVar instanceof h) {
                    ((h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.agy != null && this.agy.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        if (this.agy != null && this.agy.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
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
                if (it.next().getType() == bh.caC) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.fLS != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.fLS.registerListener(this.fMo);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.fLS == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.fMm = new ArrayList();
        ArrayList<BdUniqueId> cnB = com.baidu.tieba.tbadkCore.s.cnB();
        if (cnB == null || cnB.size() <= 0) {
            return false;
        }
        int size = cnB.size();
        for (int i = 0; i < size; i++) {
            h<ICardInfo, ? extends v.a> a = c.bjg().a(this.fLS.getPageContext(), cnB.get(i), this.fLS.getUniqueId());
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

    public boolean o(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void rh(String str) {
        if (this.agy != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).rh(str);
                }
            }
        }
    }

    public List<m> getDataList() {
        return this.eYf;
    }

    public List<m> boN() {
        return this.fMn;
    }
}
