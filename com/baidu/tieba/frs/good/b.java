package com.baidu.tieba.frs.good;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.a.f;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.b.d;
import com.baidu.tieba.frs.e;
import com.baidu.tieba.frs.entelechy.adapter.aa;
import com.baidu.tieba.frs.entelechy.adapter.ab;
import com.baidu.tieba.frs.entelechy.adapter.ac;
import com.baidu.tieba.frs.entelechy.adapter.ad;
import com.baidu.tieba.frs.entelechy.adapter.ae;
import com.baidu.tieba.frs.entelechy.adapter.g;
import com.baidu.tieba.frs.entelechy.adapter.i;
import com.baidu.tieba.frs.entelechy.adapter.j;
import com.baidu.tieba.frs.entelechy.adapter.o;
import com.baidu.tieba.frs.entelechy.adapter.q;
import com.baidu.tieba.frs.entelechy.adapter.t;
import com.baidu.tieba.frs.entelechy.adapter.v;
import com.baidu.tieba.frs.entelechy.adapter.w;
import com.baidu.tieba.frs.entelechy.adapter.x;
import com.baidu.tieba.frs.entelechy.adapter.z;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private ArrayList<n> iGj;
    private FrsGoodFragment jDI;
    private List<com.baidu.adp.widget.ListView.a> jEa;
    private ArrayList<n> jEb;
    private BdTypeRecyclerView jmy;
    private final HashMap<Integer, cb> jrt;
    private FrsViewData jru;
    private List<com.baidu.adp.widget.ListView.a> bns = new LinkedList();
    private CustomMessageListener jpp = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                    if (aVar instanceof k) {
                        ((k) aVar).a(b.this.jDI.getPageContext(), b.this.jDI.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.bns != null) {
                    b.this.bns.addAll(arrayList);
                }
                if (b.this.jmy != null) {
                    b.this.jmy.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener jEc = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && y.isEmpty(b.this.jEa)) {
                b.this.g(b.this.jmy);
                b.this.b(b.this.iGj, b.this.jru);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.jmy = bdTypeRecyclerView;
        this.jrt = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jDI = frsGoodFragment;
        this.jpp.setPriority(1);
        this.jpp.setSelfListener(true);
        this.jDI.registerListener(this.jpp);
        ac acVar = new ac(frsGoodFragment.getTbPageContext(), cb.eQs, this.jDI.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), cb.eQt, this.jDI.getUniqueId());
        z zVar = new z(frsGoodFragment.getTbPageContext(), cb.eQv, this.jDI.getUniqueId());
        w wVar = new w(frsGoodFragment.getTbPageContext(), cb.eQw, this.jDI.getUniqueId());
        com.baidu.tieba.frs.entelechy.adapter.n nVar = new com.baidu.tieba.frs.entelechy.adapter.n(frsGoodFragment.getTbPageContext(), cb.eQy, this.jDI.getUniqueId());
        q qVar = new q(frsGoodFragment.getTbPageContext(), cb.eQz, this.jDI.getUniqueId());
        ae aeVar = new ae(frsGoodFragment.getTbPageContext(), cb.eQE, this.jDI.getUniqueId());
        aa aaVar = new aa(frsGoodFragment.getTbPageContext(), cb.eQY, this.jDI.getUniqueId());
        com.baidu.tieba.frs.entelechy.adapter.y yVar = new com.baidu.tieba.frs.entelechy.adapter.y(frsGoodFragment.getTbPageContext(), cb.eQF, this.jDI.getUniqueId());
        v vVar = new v(frsGoodFragment.getTbPageContext(), cb.eQG, this.jDI.getUniqueId());
        ad adVar = new ad(frsGoodFragment.getPageContext(), cb.eQK, this.jDI.getUniqueId());
        t tVar = new t(frsGoodFragment.getPageContext(), cb.eQI, this.jDI.getUniqueId());
        x xVar = new x(frsGoodFragment.getPageContext(), cb.eQJ, this.jDI.getUniqueId());
        ad adVar2 = new ad(frsGoodFragment.getPageContext(), cb.eQT, this.jDI.getUniqueId());
        r rVar = new r(frsGoodFragment.getPageContext(), s.jjT);
        com.baidu.adp.widget.ListView.a<? extends ca, ? extends TypeAdapter.ViewHolder> a2 = e.cBH().a(frsGoodFragment.getPageContext(), this.jDI.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends cb, ? extends TypeAdapter.ViewHolder> b2 = e.cBH().b(frsGoodFragment.getPageContext(), cb.eSx, this.jDI.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.s.dDt().a(this.jDI, AdvertAppInfo.eLa);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.s.dDt().a(this.jDI, AdvertAppInfo.eLj);
        ab abVar = new ab(frsGoodFragment.getPageContext(), cb.eQP, this.jDI.getUniqueId());
        com.baidu.tieba.frs.entelechy.adapter.b bVar = new com.baidu.tieba.frs.entelechy.adapter.b(frsGoodFragment.getPageContext(), cb.eQR, this.jDI.getUniqueId());
        i iVar = new i(frsGoodFragment.getPageContext(), cb.eQQ, this.jDI.getUniqueId());
        j jVar = new j(frsGoodFragment.getPageContext(), cb.eQS, this.jDI.getUniqueId());
        g gVar = new g(frsGoodFragment.getPageContext(), cb.eQD, this.jDI.getUniqueId());
        gVar.a(bdTypeRecyclerView);
        this.bns.add(acVar);
        this.bns.add(oVar);
        this.bns.add(zVar);
        this.bns.add(wVar);
        this.bns.add(nVar);
        this.bns.add(qVar);
        this.bns.add(aaVar);
        this.bns.add(aeVar);
        this.bns.add(yVar);
        this.bns.add(vVar);
        this.bns.add(adVar);
        this.bns.add(tVar);
        this.bns.add(tVar);
        this.bns.add(xVar);
        this.bns.add(rVar);
        this.bns.add(adVar);
        this.bns.add(adVar2);
        this.bns.add(abVar);
        this.bns.add(bVar);
        this.bns.add(iVar);
        this.bns.add(jVar);
        this.bns.add(gVar);
        if (a2 != null) {
            this.bns.add(a2);
        }
        if (b2 != null) {
            this.bns.add(b2);
        }
        this.bns.add(a3);
        this.bns.add(a4);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.jDI.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        f(bdTypeRecyclerView);
        this.bns.add(com.baidu.tieba.h.b.cNt().c(this.jDI.getBaseFragmentActivity(), AdvertAppInfo.eLm));
        this.bns.add(com.baidu.tieba.h.b.cNt().c(this.jDI.getBaseFragmentActivity(), AdvertAppInfo.eLl));
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.jDI, 1);
        bVar2.setExtraData(this.bns);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.bns);
        Ew("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
            if (aVar instanceof com.baidu.tieba.card.aa) {
                ((com.baidu.tieba.card.aa) aVar).pD(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
            if (aVar instanceof k) {
                ((k) aVar).release();
            }
        }
        MessageManager.getInstance().unRegisterListener(this.jpp);
    }

    public void b(ArrayList<n> arrayList, FrsViewData frsViewData) {
        if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof s)) {
            frsViewData.setThreadList(arrayList);
        }
        b(frsViewData);
        cFe();
        az(arrayList);
        com.baidu.tieba.tbadkCore.v.x(arrayList, 1);
        ay(arrayList);
        ArrayList<n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.jmy.setData(switchThreadDataToThreadCardInfo);
        this.jEb = switchThreadDataToThreadCardInfo;
        this.iGj = arrayList;
        this.jru = frsViewData;
        cFI();
    }

    public void refreshData() {
        this.jmy.setData(this.jEb);
        notifyDataSetChanged();
    }

    private void cFe() {
        if (!y.isEmpty(this.bns) && this.jDI != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.jDI.getTbPageTag());
                }
            }
        }
    }

    private void cFI() {
        com.baidu.tieba.frs.b.b statisticMetaData;
        if (this.jru != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if ((aVar instanceof d) && (statisticMetaData = ((d) aVar).getStatisticMetaData()) != null) {
                    if (this.jru.needLog == 1) {
                        statisticMetaData.jHy = true;
                    } else {
                        statisticMetaData.jHy = false;
                    }
                    if (this.jru.getForum() != null) {
                        statisticMetaData.jHA = this.jru.getForum().getId();
                    }
                    if (this.jDI != null) {
                        statisticMetaData.jHz = 5;
                    }
                }
            }
        }
    }

    private void ay(ArrayList<n> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    n nVar = arrayList.get(i2);
                    if ((nVar instanceof AdvertAppInfo) && this.jrt != null && !this.jrt.containsValue(nVar)) {
                        this.jrt.put(Integer.valueOf(i2), (cb) nVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, cb> cGz() {
        return this.jrt;
    }

    public void cGE() {
        if (this.jmy != null && this.jmy.getData() != null && this.jmy.getData().size() != 0) {
            for (n nVar : this.jmy.getData()) {
                if ((nVar instanceof ca) && ((ca) nVar).eJQ.bnL() != 0) {
                    ((ca) nVar).eJQ.boP();
                }
            }
        }
    }

    public void cJl() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
            if (aVar instanceof com.baidu.tieba.card.z) {
                ((com.baidu.tieba.card.z) aVar).uX(3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.jmy.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.jmy.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.bns != null && this.bns.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof k) {
                    ((k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.bns != null && this.bns.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof k) {
                    ((k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.bns != null && this.bns.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar != null && (aVar instanceof k)) {
                    ((k) aVar).a(wVar);
                }
            }
        }
    }

    private void az(ArrayList<n> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == cb.eQl) {
                    it.remove();
                }
            }
        }
    }

    private void f(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jDI != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.jDI.registerListener(this.jEc);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jDI == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.jEa = new ArrayList();
        ArrayList<BdUniqueId> dMT = com.baidu.tieba.tbadkCore.v.dMT();
        if (dMT == null || dMT.size() <= 0) {
            return false;
        }
        int size = dMT.size();
        for (int i = 0; i < size; i++) {
            k<ICardInfo, ? extends TypeAdapter.ViewHolder> a2 = e.cBH().a(this.jDI.getPageContext(), dMT.get(i), this.jDI.getUniqueId());
            if (a2 != null) {
                this.bns.add(a2);
                this.jEa.add(a2);
            }
        }
        if (!y.isEmpty(this.jEa)) {
            bdTypeRecyclerView.addAdapters(this.jEa);
        }
        return true;
    }

    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void Ew(String str) {
        if (this.bns != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof f) {
                    ((f) aVar).Ew(str);
                }
            }
        }
    }

    public List<n> getDataList() {
        return this.iGj;
    }

    public List<n> cJm() {
        return this.jEb;
    }
}
