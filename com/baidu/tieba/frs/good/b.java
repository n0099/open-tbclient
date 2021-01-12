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
    private ArrayList<n> iAl;
    private BdTypeRecyclerView jgC;
    private final HashMap<Integer, bz> jly;
    private FrsViewData jlz;
    private FrsGoodFragment jxO;
    private List<com.baidu.adp.widget.ListView.a> jyh;
    private ArrayList<n> jyi;
    private List<com.baidu.adp.widget.ListView.a> bjZ = new LinkedList();
    private CustomMessageListener jju = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((k) aVar).a(b.this.jxO.getPageContext(), b.this.jxO.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.bjZ != null) {
                    b.this.bjZ.addAll(arrayList);
                }
                if (b.this.jgC != null) {
                    b.this.jgC.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener jyj = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && x.isEmpty(b.this.jyh)) {
                b.this.g(b.this.jgC);
                b.this.b(b.this.iAl, b.this.jlz);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.jgC = bdTypeRecyclerView;
        this.jly = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jxO = frsGoodFragment;
        this.jju.setPriority(1);
        this.jju.setSelfListener(true);
        this.jxO.registerListener(this.jju);
        ac acVar = new ac(frsGoodFragment.getTbPageContext(), bz.eOg, this.jxO.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), bz.eOh, this.jxO.getUniqueId());
        z zVar = new z(frsGoodFragment.getTbPageContext(), bz.eOj, this.jxO.getUniqueId());
        w wVar = new w(frsGoodFragment.getTbPageContext(), bz.eOk, this.jxO.getUniqueId());
        com.baidu.tieba.frs.entelechy.adapter.n nVar = new com.baidu.tieba.frs.entelechy.adapter.n(frsGoodFragment.getTbPageContext(), bz.eOm, this.jxO.getUniqueId());
        q qVar = new q(frsGoodFragment.getTbPageContext(), bz.eOn, this.jxO.getUniqueId());
        ae aeVar = new ae(frsGoodFragment.getTbPageContext(), bz.eOs, this.jxO.getUniqueId());
        aa aaVar = new aa(frsGoodFragment.getTbPageContext(), bz.eOM, this.jxO.getUniqueId());
        y yVar = new y(frsGoodFragment.getTbPageContext(), bz.eOt, this.jxO.getUniqueId());
        v vVar = new v(frsGoodFragment.getTbPageContext(), bz.eOu, this.jxO.getUniqueId());
        ad adVar = new ad(frsGoodFragment.getPageContext(), bz.eOy, this.jxO.getUniqueId());
        t tVar = new t(frsGoodFragment.getPageContext(), bz.eOw, this.jxO.getUniqueId());
        com.baidu.tieba.frs.entelechy.adapter.x xVar = new com.baidu.tieba.frs.entelechy.adapter.x(frsGoodFragment.getPageContext(), bz.eOx, this.jxO.getUniqueId());
        ad adVar2 = new ad(frsGoodFragment.getPageContext(), bz.eOH, this.jxO.getUniqueId());
        r rVar = new r(frsGoodFragment.getPageContext(), s.jdY);
        com.baidu.adp.widget.ListView.a<? extends by, ? extends TypeAdapter.ViewHolder> a2 = e.cAp().a(frsGoodFragment.getPageContext(), this.jxO.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bz, ? extends TypeAdapter.ViewHolder> b2 = e.cAp().b(frsGoodFragment.getPageContext(), bz.eQl, this.jxO.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dBe().a(this.jxO, AdvertAppInfo.eIO);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.r.dBe().a(this.jxO, AdvertAppInfo.eIX);
        ab abVar = new ab(frsGoodFragment.getPageContext(), bz.eOD, this.jxO.getUniqueId());
        com.baidu.tieba.frs.entelechy.adapter.b bVar = new com.baidu.tieba.frs.entelechy.adapter.b(frsGoodFragment.getPageContext(), bz.eOF, this.jxO.getUniqueId());
        i iVar = new i(frsGoodFragment.getPageContext(), bz.eOE, this.jxO.getUniqueId());
        j jVar = new j(frsGoodFragment.getPageContext(), bz.eOG, this.jxO.getUniqueId());
        g gVar = new g(frsGoodFragment.getPageContext(), bz.eOr, this.jxO.getUniqueId());
        gVar.a(bdTypeRecyclerView);
        this.bjZ.add(acVar);
        this.bjZ.add(oVar);
        this.bjZ.add(zVar);
        this.bjZ.add(wVar);
        this.bjZ.add(nVar);
        this.bjZ.add(qVar);
        this.bjZ.add(aaVar);
        this.bjZ.add(aeVar);
        this.bjZ.add(yVar);
        this.bjZ.add(vVar);
        this.bjZ.add(adVar);
        this.bjZ.add(tVar);
        this.bjZ.add(tVar);
        this.bjZ.add(xVar);
        this.bjZ.add(rVar);
        this.bjZ.add(adVar);
        this.bjZ.add(adVar2);
        this.bjZ.add(abVar);
        this.bjZ.add(bVar);
        this.bjZ.add(iVar);
        this.bjZ.add(jVar);
        this.bjZ.add(gVar);
        if (a2 != null) {
            this.bjZ.add(a2);
        }
        if (b2 != null) {
            this.bjZ.add(b2);
        }
        this.bjZ.add(a3);
        this.bjZ.add(a4);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.jxO.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        f(bdTypeRecyclerView);
        this.bjZ.add(com.baidu.tieba.h.b.cLy().c(this.jxO.getBaseFragmentActivity(), AdvertAppInfo.eJa));
        this.bjZ.add(com.baidu.tieba.h.b.cLy().c(this.jxO.getBaseFragmentActivity(), AdvertAppInfo.eIZ));
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.jxO, 1);
        bVar2.setExtraData(this.bjZ);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.bjZ);
        Ea("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
            if (aVar instanceof com.baidu.tieba.card.z) {
                ((com.baidu.tieba.card.z) aVar).pt(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
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
        cDL();
        aA(arrayList);
        com.baidu.tieba.tbadkCore.v.x(arrayList, 1);
        az(arrayList);
        ArrayList<n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.jgC.setData(switchThreadDataToThreadCardInfo);
        this.jyi = switchThreadDataToThreadCardInfo;
        this.iAl = arrayList;
        this.jlz = frsViewData;
        cEo();
    }

    public void refreshData() {
        this.jgC.setData(this.jyi);
        notifyDataSetChanged();
    }

    private void cDL() {
        if (!x.isEmpty(this.bjZ) && this.jxO != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.jxO.getTbPageTag());
                }
            }
        }
    }

    private void cEo() {
        com.baidu.tieba.frs.b.b statisticMetaData;
        if (this.jlz != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if ((aVar instanceof d) && (statisticMetaData = ((d) aVar).getStatisticMetaData()) != null) {
                    if (this.jlz.needLog == 1) {
                        statisticMetaData.jBG = true;
                    } else {
                        statisticMetaData.jBG = false;
                    }
                    if (this.jlz.getForum() != null) {
                        statisticMetaData.jBI = this.jlz.getForum().getId();
                    }
                    if (this.jxO != null) {
                        statisticMetaData.jBH = 5;
                    }
                }
            }
        }
    }

    private void az(ArrayList<n> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    n nVar = arrayList.get(i2);
                    if ((nVar instanceof AdvertAppInfo) && this.jly != null && !this.jly.containsValue(nVar)) {
                        this.jly.put(Integer.valueOf(i2), (bz) nVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bz> cFf() {
        return this.jly;
    }

    public void cFk() {
        if (this.jgC != null && this.jgC.getData() != null && this.jgC.getData().size() != 0) {
            for (n nVar : this.jgC.getData()) {
                if ((nVar instanceof by) && ((by) nVar).eHK.bns() != 0) {
                    ((by) nVar).eHK.box();
                }
            }
        }
    }

    public void cHR() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
            if (aVar instanceof com.baidu.tieba.card.y) {
                ((com.baidu.tieba.card.y) aVar).uN(3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.jgC.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.jgC.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.bjZ != null && this.bjZ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar instanceof k) {
                    ((k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.bjZ != null && this.bjZ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar instanceof k) {
                    ((k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.bjZ != null && this.bjZ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar != null && (aVar instanceof k)) {
                    ((k) aVar).a(wVar);
                }
            }
        }
    }

    private void aA(ArrayList<n> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bz.eNZ) {
                    it.remove();
                }
            }
        }
    }

    private void f(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jxO != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.jxO.registerListener(this.jyj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jxO == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.jyh = new ArrayList();
        ArrayList<BdUniqueId> dKA = com.baidu.tieba.tbadkCore.v.dKA();
        if (dKA == null || dKA.size() <= 0) {
            return false;
        }
        int size = dKA.size();
        for (int i = 0; i < size; i++) {
            k<ICardInfo, ? extends TypeAdapter.ViewHolder> a2 = e.cAp().a(this.jxO.getPageContext(), dKA.get(i), this.jxO.getUniqueId());
            if (a2 != null) {
                this.bjZ.add(a2);
                this.jyh.add(a2);
            }
        }
        if (!x.isEmpty(this.jyh)) {
            bdTypeRecyclerView.addAdapters(this.jyh);
        }
        return true;
    }

    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void Ea(String str) {
        if (this.bjZ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar instanceof f) {
                    ((f) aVar).Ea(str);
                }
            }
        }
    }

    public List<n> getDataList() {
        return this.iAl;
    }

    public List<n> cHS() {
        return this.jyi;
    }
}
