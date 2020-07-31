package com.baidu.tieba.frs.good;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.a.f;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.d.d;
import com.baidu.tieba.frs.e;
import com.baidu.tieba.frs.entelechy.a.aa;
import com.baidu.tieba.frs.entelechy.a.ab;
import com.baidu.tieba.frs.entelechy.a.ac;
import com.baidu.tieba.frs.entelechy.a.h;
import com.baidu.tieba.frs.entelechy.a.i;
import com.baidu.tieba.frs.entelechy.a.m;
import com.baidu.tieba.frs.entelechy.a.n;
import com.baidu.tieba.frs.entelechy.a.o;
import com.baidu.tieba.frs.entelechy.a.r;
import com.baidu.tieba.frs.entelechy.a.t;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.entelechy.a.v;
import com.baidu.tieba.frs.entelechy.a.w;
import com.baidu.tieba.frs.entelechy.a.y;
import com.baidu.tieba.frs.entelechy.a.z;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes16.dex */
public class b {
    private BdTypeRecyclerView hKL;
    private final HashMap<Integer, bv> hPp;
    private FrsViewData hPq;
    private FrsGoodFragment hYN;
    private List<com.baidu.adp.widget.ListView.a> hZg;
    private ArrayList<q> hZh;
    private ArrayList<q> hfz;
    private List<com.baidu.adp.widget.ListView.a> aWf = new LinkedList();
    private CustomMessageListener hNy = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                    if (aVar instanceof j) {
                        ((j) aVar).a(b.this.hYN.getPageContext(), b.this.hYN.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.aWf != null) {
                    b.this.aWf.addAll(arrayList);
                }
                if (b.this.hKL != null) {
                    b.this.hKL.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener hZi = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && x.isEmpty(b.this.hZg)) {
                b.this.b(b.this.hKL);
                b.this.b(b.this.hfz, b.this.hPq);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.hKL = bdTypeRecyclerView;
        this.hPp = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hYN = frsGoodFragment;
        this.hNy.setPriority(1);
        this.hNy.setSelfListener(true);
        this.hYN.registerListener(this.hNy);
        aa aaVar = new aa(frsGoodFragment.getTbPageContext(), bv.dRB, this.hYN.getUniqueId());
        n nVar = new n(frsGoodFragment.getTbPageContext(), bv.dRC, this.hYN.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.x xVar = new com.baidu.tieba.frs.entelechy.a.x(frsGoodFragment.getTbPageContext(), bv.dRE, this.hYN.getUniqueId());
        u uVar = new u(frsGoodFragment.getTbPageContext(), bv.dRF, this.hYN.getUniqueId());
        m mVar = new m(frsGoodFragment.getTbPageContext(), bv.dRH, this.hYN.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), bv.dRI, this.hYN.getUniqueId());
        ac acVar = new ac(frsGoodFragment.getTbPageContext(), bv.dRN, this.hYN.getUniqueId());
        y yVar = new y(frsGoodFragment.getTbPageContext(), bv.dSf, this.hYN.getUniqueId());
        w wVar = new w(frsGoodFragment.getTbPageContext(), bv.dRO, this.hYN.getUniqueId());
        t tVar = new t(frsGoodFragment.getTbPageContext(), bv.dRP, this.hYN.getUniqueId());
        ab abVar = new ab(frsGoodFragment.getPageContext(), bv.dRS, this.hYN.getUniqueId());
        r rVar = new r(frsGoodFragment.getPageContext(), bv.dRQ, this.hYN.getUniqueId());
        v vVar = new v(frsGoodFragment.getPageContext(), bv.dRR, this.hYN.getUniqueId());
        ab abVar2 = new ab(frsGoodFragment.getPageContext(), bv.dSa, this.hYN.getUniqueId());
        com.baidu.tieba.frs.q qVar = new com.baidu.tieba.frs.q(frsGoodFragment.getPageContext(), com.baidu.tieba.frs.r.hIV);
        com.baidu.adp.widget.ListView.a<? extends bu, ? extends ad.a> a = e.caF().a(frsGoodFragment.getPageContext(), this.hYN.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends ad.a> b = e.caF().b(frsGoodFragment.getPageContext(), bv.dTD, this.hYN.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.dca().a(this.hYN, AdvertAppInfo.dMF);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dca().a(this.hYN, AdvertAppInfo.dMO);
        z zVar = new z(frsGoodFragment.getPageContext(), bv.dRW, this.hYN.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsGoodFragment.getPageContext(), bv.dRY, this.hYN.getUniqueId());
        h hVar = new h(frsGoodFragment.getPageContext(), bv.dRX, this.hYN.getUniqueId());
        i iVar = new i(frsGoodFragment.getPageContext(), bv.dRZ, this.hYN.getUniqueId());
        this.aWf.add(aaVar);
        this.aWf.add(nVar);
        this.aWf.add(xVar);
        this.aWf.add(uVar);
        this.aWf.add(mVar);
        this.aWf.add(oVar);
        this.aWf.add(yVar);
        this.aWf.add(acVar);
        this.aWf.add(wVar);
        this.aWf.add(tVar);
        this.aWf.add(abVar);
        this.aWf.add(rVar);
        this.aWf.add(rVar);
        this.aWf.add(vVar);
        this.aWf.add(qVar);
        this.aWf.add(abVar);
        this.aWf.add(abVar2);
        this.aWf.add(zVar);
        this.aWf.add(bVar);
        this.aWf.add(hVar);
        this.aWf.add(iVar);
        if (a != null) {
            this.aWf.add(a);
        }
        if (b != null) {
            this.aWf.add(b);
        }
        this.aWf.add(a2);
        this.aWf.add(a3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.hYN.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.hYN, 1);
        bVar2.setExtraData(this.aWf);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.aWf);
        AP("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
            if (aVar instanceof com.baidu.tieba.card.z) {
                ((com.baidu.tieba.card.z) aVar).mJ(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
            if (aVar instanceof j) {
                ((j) aVar).release();
            }
        }
    }

    public void b(ArrayList<q> arrayList, FrsViewData frsViewData) {
        if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof com.baidu.tieba.frs.r)) {
            frsViewData.setThreadList(arrayList);
        }
        b(frsViewData);
        cdP();
        at(arrayList);
        com.baidu.tieba.tbadkCore.t.r(arrayList, 1);
        as(arrayList);
        ArrayList<q> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.hKL.setData(switchThreadDataToThreadCardInfo);
        this.hZh = switchThreadDataToThreadCardInfo;
        this.hfz = arrayList;
        this.hPq = frsViewData;
        cet();
    }

    public void refreshData() {
        this.hKL.setData(this.hZh);
        notifyDataSetChanged();
    }

    private void cdP() {
        if (!x.isEmpty(this.aWf) && this.hYN != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof j) {
                    ((j) aVar).a(this.hYN.getTbPageTag());
                }
            }
        }
    }

    private void cet() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.hPq != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if ((aVar instanceof d) && (statisticMetaData = ((d) aVar).getStatisticMetaData()) != null) {
                    if (this.hPq.needLog == 1) {
                        statisticMetaData.icK = true;
                    } else {
                        statisticMetaData.icK = false;
                    }
                    if (this.hPq.getForum() != null) {
                        statisticMetaData.icM = this.hPq.getForum().getId();
                    }
                    if (this.hYN != null) {
                        statisticMetaData.icL = 5;
                    }
                }
            }
        }
    }

    private void as(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    q qVar = arrayList.get(i2);
                    if ((qVar instanceof AdvertAppInfo) && this.hPp != null && !this.hPp.containsValue(qVar)) {
                        this.hPp.put(Integer.valueOf(i2), (bv) qVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bv> cfc() {
        return this.hPp;
    }

    public void cfh() {
        if (this.hKL != null && this.hKL.getData() != null && this.hKL.getData().size() != 0) {
            for (q qVar : this.hKL.getData()) {
                if ((qVar instanceof bu) && ((bu) qVar).dLK.aWg() != 0) {
                    ((bu) qVar).dLK.aXj();
                }
            }
        }
    }

    public void cgQ() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
            if (aVar instanceof com.baidu.tieba.card.y) {
                ((com.baidu.tieba.card.y) aVar).rn(3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hKL.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.hKL.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.aWf != null && this.aWf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof j) {
                    ((j) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.aWf != null && this.aWf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof j) {
                    ((j) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.z zVar) {
        if (this.aWf != null && this.aWf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar != null && (aVar instanceof j)) {
                    ((j) aVar).a(zVar);
                }
            }
        }
    }

    private void at(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<q> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bv.dRw) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.hYN != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.hYN.registerListener(this.hZi);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.hYN == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.hZg = new ArrayList();
        ArrayList<BdUniqueId> dky = com.baidu.tieba.tbadkCore.t.dky();
        if (dky == null || dky.size() <= 0) {
            return false;
        }
        int size = dky.size();
        for (int i = 0; i < size; i++) {
            j<ICardInfo, ? extends ad.a> a = e.caF().a(this.hYN.getPageContext(), dky.get(i), this.hYN.getUniqueId());
            if (a != null) {
                this.aWf.add(a);
                this.hZg.add(a);
            }
        }
        if (!x.isEmpty(this.hZg)) {
            bdTypeRecyclerView.addAdapters(this.hZg);
        }
        return true;
    }

    public boolean s(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void AP(String str) {
        if (this.aWf != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof f) {
                    ((f) aVar).AP(str);
                }
            }
        }
    }

    public List<q> getDataList() {
        return this.hfz;
    }

    public List<q> cgR() {
        return this.hZh;
    }
}
