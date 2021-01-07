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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
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
import com.baidu.tieba.frs.entelechy.adapter.y;
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
    private ArrayList<n> iES;
    private List<com.baidu.adp.widget.ListView.a> jCN;
    private ArrayList<n> jCO;
    private FrsGoodFragment jCu;
    private BdTypeRecyclerView jlj;
    private final HashMap<Integer, bz> jqf;
    private FrsViewData jqg;
    private List<com.baidu.adp.widget.ListView.a> boM = new LinkedList();
    private CustomMessageListener job = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((k) aVar).a(b.this.jCu.getPageContext(), b.this.jCu.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.boM != null) {
                    b.this.boM.addAll(arrayList);
                }
                if (b.this.jlj != null) {
                    b.this.jlj.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener jCP = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && x.isEmpty(b.this.jCN)) {
                b.this.g(b.this.jlj);
                b.this.b(b.this.iES, b.this.jqg);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.jlj = bdTypeRecyclerView;
        this.jqf = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jCu = frsGoodFragment;
        this.job.setPriority(1);
        this.job.setSelfListener(true);
        this.jCu.registerListener(this.job);
        ac acVar = new ac(frsGoodFragment.getTbPageContext(), bz.eSR, this.jCu.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), bz.eSS, this.jCu.getUniqueId());
        z zVar = new z(frsGoodFragment.getTbPageContext(), bz.eSU, this.jCu.getUniqueId());
        w wVar = new w(frsGoodFragment.getTbPageContext(), bz.eSV, this.jCu.getUniqueId());
        com.baidu.tieba.frs.entelechy.adapter.n nVar = new com.baidu.tieba.frs.entelechy.adapter.n(frsGoodFragment.getTbPageContext(), bz.eSX, this.jCu.getUniqueId());
        q qVar = new q(frsGoodFragment.getTbPageContext(), bz.eSY, this.jCu.getUniqueId());
        ae aeVar = new ae(frsGoodFragment.getTbPageContext(), bz.eTd, this.jCu.getUniqueId());
        aa aaVar = new aa(frsGoodFragment.getTbPageContext(), bz.eTx, this.jCu.getUniqueId());
        y yVar = new y(frsGoodFragment.getTbPageContext(), bz.eTe, this.jCu.getUniqueId());
        v vVar = new v(frsGoodFragment.getTbPageContext(), bz.eTf, this.jCu.getUniqueId());
        ad adVar = new ad(frsGoodFragment.getPageContext(), bz.eTj, this.jCu.getUniqueId());
        t tVar = new t(frsGoodFragment.getPageContext(), bz.eTh, this.jCu.getUniqueId());
        com.baidu.tieba.frs.entelechy.adapter.x xVar = new com.baidu.tieba.frs.entelechy.adapter.x(frsGoodFragment.getPageContext(), bz.eTi, this.jCu.getUniqueId());
        ad adVar2 = new ad(frsGoodFragment.getPageContext(), bz.eTs, this.jCu.getUniqueId());
        r rVar = new r(frsGoodFragment.getPageContext(), s.jiG);
        com.baidu.adp.widget.ListView.a<? extends by, ? extends TypeAdapter.ViewHolder> a2 = e.cEh().a(frsGoodFragment.getPageContext(), this.jCu.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bz, ? extends TypeAdapter.ViewHolder> b2 = e.cEh().b(frsGoodFragment.getPageContext(), bz.eUW, this.jCu.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dEW().a(this.jCu, AdvertAppInfo.eNz);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.r.dEW().a(this.jCu, AdvertAppInfo.eNI);
        ab abVar = new ab(frsGoodFragment.getPageContext(), bz.eTo, this.jCu.getUniqueId());
        com.baidu.tieba.frs.entelechy.adapter.b bVar = new com.baidu.tieba.frs.entelechy.adapter.b(frsGoodFragment.getPageContext(), bz.eTq, this.jCu.getUniqueId());
        i iVar = new i(frsGoodFragment.getPageContext(), bz.eTp, this.jCu.getUniqueId());
        j jVar = new j(frsGoodFragment.getPageContext(), bz.eTr, this.jCu.getUniqueId());
        g gVar = new g(frsGoodFragment.getPageContext(), bz.eTc, this.jCu.getUniqueId());
        gVar.a(bdTypeRecyclerView);
        this.boM.add(acVar);
        this.boM.add(oVar);
        this.boM.add(zVar);
        this.boM.add(wVar);
        this.boM.add(nVar);
        this.boM.add(qVar);
        this.boM.add(aaVar);
        this.boM.add(aeVar);
        this.boM.add(yVar);
        this.boM.add(vVar);
        this.boM.add(adVar);
        this.boM.add(tVar);
        this.boM.add(tVar);
        this.boM.add(xVar);
        this.boM.add(rVar);
        this.boM.add(adVar);
        this.boM.add(adVar2);
        this.boM.add(abVar);
        this.boM.add(bVar);
        this.boM.add(iVar);
        this.boM.add(jVar);
        this.boM.add(gVar);
        if (a2 != null) {
            this.boM.add(a2);
        }
        if (b2 != null) {
            this.boM.add(b2);
        }
        this.boM.add(a3);
        this.boM.add(a4);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.jCu.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        f(bdTypeRecyclerView);
        this.boM.add(com.baidu.tieba.h.b.cPq().c(this.jCu.getBaseFragmentActivity(), AdvertAppInfo.eNL));
        this.boM.add(com.baidu.tieba.h.b.cPq().c(this.jCu.getBaseFragmentActivity(), AdvertAppInfo.eNK));
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.jCu, 1);
        bVar2.setExtraData(this.boM);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.boM);
        Fl("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
            if (aVar instanceof com.baidu.tieba.card.z) {
                ((com.baidu.tieba.card.z) aVar).px(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
            if (aVar instanceof k) {
                ((k) aVar).release();
            }
        }
    }

    public void b(ArrayList<n> arrayList, FrsViewData frsViewData) {
        if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof s)) {
            frsViewData.setThreadList(arrayList);
        }
        b(frsViewData);
        cHD();
        aF(arrayList);
        com.baidu.tieba.tbadkCore.v.x(arrayList, 1);
        aE(arrayList);
        ArrayList<n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.jlj.setData(switchThreadDataToThreadCardInfo);
        this.jCO = switchThreadDataToThreadCardInfo;
        this.iES = arrayList;
        this.jqg = frsViewData;
        cIg();
    }

    public void refreshData() {
        this.jlj.setData(this.jCO);
        notifyDataSetChanged();
    }

    private void cHD() {
        if (!x.isEmpty(this.boM) && this.jCu != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.jCu.getTbPageTag());
                }
            }
        }
    }

    private void cIg() {
        com.baidu.tieba.frs.b.b statisticMetaData;
        if (this.jqg != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if ((aVar instanceof d) && (statisticMetaData = ((d) aVar).getStatisticMetaData()) != null) {
                    if (this.jqg.needLog == 1) {
                        statisticMetaData.jGm = true;
                    } else {
                        statisticMetaData.jGm = false;
                    }
                    if (this.jqg.getForum() != null) {
                        statisticMetaData.jGo = this.jqg.getForum().getId();
                    }
                    if (this.jCu != null) {
                        statisticMetaData.jGn = 5;
                    }
                }
            }
        }
    }

    private void aE(ArrayList<n> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    n nVar = arrayList.get(i2);
                    if ((nVar instanceof AdvertAppInfo) && this.jqf != null && !this.jqf.containsValue(nVar)) {
                        this.jqf.put(Integer.valueOf(i2), (bz) nVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bz> cIX() {
        return this.jqf;
    }

    public void cJc() {
        if (this.jlj != null && this.jlj.getData() != null && this.jlj.getData().size() != 0) {
            for (n nVar : this.jlj.getData()) {
                if ((nVar instanceof by) && ((by) nVar).eMv.brm() != 0) {
                    ((by) nVar).eMv.bsr();
                }
            }
        }
    }

    public void cLJ() {
        for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
            if (aVar instanceof com.baidu.tieba.card.y) {
                ((com.baidu.tieba.card.y) aVar).wt(3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.jlj.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.jlj.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.boM != null && this.boM.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof k) {
                    ((k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.boM != null && this.boM.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof k) {
                    ((k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.boM != null && this.boM.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar != null && (aVar instanceof k)) {
                    ((k) aVar).a(wVar);
                }
            }
        }
    }

    private void aF(ArrayList<n> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bz.eSK) {
                    it.remove();
                }
            }
        }
    }

    private void f(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jCu != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.jCu.registerListener(this.jCP);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jCu == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.jCN = new ArrayList();
        ArrayList<BdUniqueId> dOs = com.baidu.tieba.tbadkCore.v.dOs();
        if (dOs == null || dOs.size() <= 0) {
            return false;
        }
        int size = dOs.size();
        for (int i = 0; i < size; i++) {
            k<ICardInfo, ? extends TypeAdapter.ViewHolder> a2 = e.cEh().a(this.jCu.getPageContext(), dOs.get(i), this.jCu.getUniqueId());
            if (a2 != null) {
                this.boM.add(a2);
                this.jCN.add(a2);
            }
        }
        if (!x.isEmpty(this.jCN)) {
            bdTypeRecyclerView.addAdapters(this.jCN);
        }
        return true;
    }

    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void Fl(String str) {
        if (this.boM != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof f) {
                    ((f) aVar).Fl(str);
                }
            }
        }
    }

    public List<n> getDataList() {
        return this.iES;
    }

    public List<n> cLK() {
        return this.jCO;
    }
}
