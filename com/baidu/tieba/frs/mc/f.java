package com.baidu.tieba.frs.mc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.adapter.aa;
import com.baidu.tieba.frs.entelechy.adapter.ab;
import com.baidu.tieba.frs.entelechy.adapter.ac;
import com.baidu.tieba.frs.entelechy.adapter.ad;
import com.baidu.tieba.frs.entelechy.adapter.ae;
import com.baidu.tieba.frs.entelechy.adapter.o;
import com.baidu.tieba.frs.entelechy.adapter.p;
import com.baidu.tieba.frs.entelechy.adapter.q;
import com.baidu.tieba.frs.entelechy.adapter.t;
import com.baidu.tieba.frs.entelechy.adapter.v;
import com.baidu.tieba.frs.entelechy.adapter.w;
import com.baidu.tieba.frs.entelechy.adapter.y;
import com.baidu.tieba.frs.entelechy.adapter.z;
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
public class f {
    private ArrayList<com.baidu.adp.widget.ListView.n> iAl;
    private BdTypeRecyclerView jgC;
    private final HashMap<Integer, bz> jly;
    private FrsViewData jlz;
    private List<com.baidu.adp.widget.ListView.a> jyh;
    private FrsNewAreaFragment jzX;
    private List<com.baidu.adp.widget.ListView.a> bjZ = new LinkedList();
    private CustomMessageListener jyj = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && x.isEmpty(f.this.jyh)) {
                f.this.g(f.this.jgC);
                f.this.b(f.this.iAl, f.this.jlz);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.jgC = bdTypeRecyclerView;
        this.jly = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v11, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jzX = frsNewAreaFragment;
        ac acVar = new ac(frsNewAreaFragment.getTbPageContext(), bz.eOg, this.jzX.getUniqueId());
        acVar.b(bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), bz.eOh, this.jzX.getUniqueId());
        oVar.b(bdTypeRecyclerView);
        z zVar = new z(frsNewAreaFragment.getTbPageContext(), bz.eOj, this.jzX.getUniqueId());
        zVar.b(bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.getTbPageContext(), bz.eOk, this.jzX.getUniqueId());
        wVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.n nVar = new com.baidu.tieba.frs.entelechy.adapter.n(frsNewAreaFragment.getTbPageContext(), bz.eOm, this.jzX.getUniqueId());
        nVar.b(bdTypeRecyclerView);
        q qVar = new q(frsNewAreaFragment.getTbPageContext(), bz.eOn, this.jzX.getUniqueId());
        qVar.b(bdTypeRecyclerView);
        ae aeVar = new ae(frsNewAreaFragment.getTbPageContext(), bz.eOs, this.jzX.getUniqueId());
        aeVar.b(bdTypeRecyclerView);
        aa aaVar = new aa(frsNewAreaFragment.getTbPageContext(), bz.eOM, this.jzX.getUniqueId());
        aaVar.b(bdTypeRecyclerView);
        y yVar = new y(frsNewAreaFragment.getTbPageContext(), bz.eOt, this.jzX.getUniqueId());
        v vVar = new v(frsNewAreaFragment.getTbPageContext(), bz.eOu, this.jzX.getUniqueId());
        ad adVar = new ad(frsNewAreaFragment.getPageContext(), bz.eOy, this.jzX.getUniqueId());
        adVar.b(bdTypeRecyclerView);
        p pVar = new p(frsNewAreaFragment.getPageContext(), bz.eOR, this.jzX.getUniqueId());
        pVar.b(bdTypeRecyclerView);
        t tVar = new t(frsNewAreaFragment.getPageContext(), bz.eOw, this.jzX.getUniqueId());
        tVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.b bVar = new com.baidu.tieba.frs.entelechy.adapter.b(frsNewAreaFragment.getPageContext(), bz.eOF, this.jzX.getUniqueId());
        bVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.i iVar = new com.baidu.tieba.frs.entelechy.adapter.i(frsNewAreaFragment.getPageContext(), bz.eOE, this.jzX.getUniqueId());
        iVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.j jVar = new com.baidu.tieba.frs.entelechy.adapter.j(frsNewAreaFragment.getPageContext(), bz.eOG, this.jzX.getUniqueId());
        jVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.x xVar = new com.baidu.tieba.frs.entelechy.adapter.x(frsNewAreaFragment.getPageContext(), bz.eOx, this.jzX.getUniqueId());
        xVar.b(bdTypeRecyclerView);
        ad adVar2 = new ad(frsNewAreaFragment.getPageContext(), bz.eOH, this.jzX.getUniqueId());
        adVar2.b(bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getPageContext(), s.jdY);
        rVar.b(bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends by, ? extends TypeAdapter.ViewHolder> a2 = com.baidu.tieba.frs.e.cAp().a(frsNewAreaFragment.getPageContext(), this.jzX.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bz, ? extends TypeAdapter.ViewHolder> b2 = com.baidu.tieba.frs.e.cAp().b(frsNewAreaFragment.getPageContext(), bz.eQl, this.jzX.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dBe().a(this.jzX, AdvertAppInfo.eIO);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.r.dBe().a(this.jzX, AdvertAppInfo.eIX);
        ab abVar = new ab(frsNewAreaFragment.getPageContext(), bz.eOD, this.jzX.getUniqueId());
        abVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.g gVar = new com.baidu.tieba.frs.entelechy.adapter.g(frsNewAreaFragment.getPageContext(), bz.eOr, this.jzX.getUniqueId());
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
        this.bjZ.add(bVar);
        this.bjZ.add(iVar);
        this.bjZ.add(jVar);
        this.bjZ.add(xVar);
        this.bjZ.add(rVar);
        this.bjZ.add(pVar);
        this.bjZ.add(adVar2);
        this.bjZ.add(abVar);
        this.bjZ.add(gVar);
        if (a2 != null) {
            this.bjZ.add(a2);
        }
        if (b2 != null) {
            this.bjZ.add(b2);
        }
        this.bjZ.add(a3);
        this.bjZ.add(a4);
        com.baidu.adp.widget.ListView.a<?, ?> c = com.baidu.tieba.h.b.cLy().c(this.jzX.getBaseFragmentActivity(), AdvertAppInfo.eJa);
        com.baidu.adp.widget.ListView.a<?, ?> c2 = com.baidu.tieba.h.b.cLy().c(this.jzX.getBaseFragmentActivity(), AdvertAppInfo.eIZ);
        this.bjZ.add(c);
        this.bjZ.add(c2);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.jzX.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jzX.getPageContext(), this.jzX.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bjZ != null) {
                this.bjZ.addAll(arrayList);
            }
        }
        f(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.jzX, 1);
        bVar2.setExtraData(this.bjZ);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.bjZ);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    public void b(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cDL();
        com.baidu.tieba.tbadkCore.v.x(arrayList, 1);
        az(arrayList);
        this.jgC.setData(arrayList);
        this.iAl = arrayList;
        this.jlz = frsViewData;
        cEo();
    }

    public void refreshData() {
        this.jgC.setData(this.iAl);
        notifyDataSetChanged();
    }

    private void cDL() {
        if (!x.isEmpty(this.bjZ) && this.jzX != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jzX.getTbPageTag());
                }
            }
        }
    }

    private void cEo() {
        com.baidu.tieba.frs.b.b statisticMetaData;
        if (this.jlz != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if ((aVar instanceof com.baidu.tieba.frs.b.d) && (statisticMetaData = ((com.baidu.tieba.frs.b.d) aVar).getStatisticMetaData()) != null) {
                    if (this.jlz.needLog == 1) {
                        statisticMetaData.jBG = true;
                    } else {
                        statisticMetaData.jBG = false;
                    }
                    if (this.jlz.getForum() != null) {
                        statisticMetaData.jBI = this.jlz.getForum().getId();
                    }
                }
            }
        }
    }

    private void az(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    com.baidu.adp.widget.ListView.n nVar = arrayList.get(i2);
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
            for (com.baidu.adp.widget.ListView.n nVar : this.jgC.getData()) {
                if ((nVar instanceof by) && ((by) nVar).eHK.bns() != 0) {
                    ((by) nVar).eHK.box();
                }
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
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.bjZ != null && this.bjZ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.bjZ != null && this.bjZ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.k)) {
                    ((com.baidu.tieba.frs.k) aVar).a(wVar);
                }
            }
        }
    }

    private void f(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jzX != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.jzX.registerListener(this.jyj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jzX == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.jyh = new ArrayList();
        ArrayList<BdUniqueId> dKA = com.baidu.tieba.tbadkCore.v.dKA();
        if (dKA == null || dKA.size() <= 0) {
            return false;
        }
        int size = dKA.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.k<ICardInfo, ? extends TypeAdapter.ViewHolder> a2 = com.baidu.tieba.frs.e.cAp().a(this.jzX.getPageContext(), dKA.get(i), this.jzX.getUniqueId());
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

    public List<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.iAl;
    }
}
