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
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
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
import com.baidu.tieba.frs.entelechy.adapter.x;
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
    private ArrayList<com.baidu.adp.widget.ListView.n> iHS;
    private List<com.baidu.adp.widget.ListView.a> jFJ;
    private FrsNewAreaFragment jHy;
    private BdTypeRecyclerView joh;
    private final HashMap<Integer, cb> jtc;
    private FrsViewData jtd;
    private List<com.baidu.adp.widget.ListView.a> boS = new LinkedList();
    private CustomMessageListener jFL = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && y.isEmpty(f.this.jFJ)) {
                f.this.g(f.this.joh);
                f.this.b(f.this.iHS, f.this.jtd);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.joh = bdTypeRecyclerView;
        this.jtc = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v11, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jHy = frsNewAreaFragment;
        ac acVar = new ac(frsNewAreaFragment.getTbPageContext(), cb.eRT, this.jHy.getUniqueId());
        acVar.b(bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), cb.eRU, this.jHy.getUniqueId());
        oVar.b(bdTypeRecyclerView);
        z zVar = new z(frsNewAreaFragment.getTbPageContext(), cb.eRW, this.jHy.getUniqueId());
        zVar.b(bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.getTbPageContext(), cb.eRX, this.jHy.getUniqueId());
        wVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.n nVar = new com.baidu.tieba.frs.entelechy.adapter.n(frsNewAreaFragment.getTbPageContext(), cb.eRZ, this.jHy.getUniqueId());
        nVar.b(bdTypeRecyclerView);
        q qVar = new q(frsNewAreaFragment.getTbPageContext(), cb.eSa, this.jHy.getUniqueId());
        qVar.b(bdTypeRecyclerView);
        ae aeVar = new ae(frsNewAreaFragment.getTbPageContext(), cb.eSf, this.jHy.getUniqueId());
        aeVar.b(bdTypeRecyclerView);
        aa aaVar = new aa(frsNewAreaFragment.getTbPageContext(), cb.eSz, this.jHy.getUniqueId());
        aaVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.y yVar = new com.baidu.tieba.frs.entelechy.adapter.y(frsNewAreaFragment.getTbPageContext(), cb.eSg, this.jHy.getUniqueId());
        v vVar = new v(frsNewAreaFragment.getTbPageContext(), cb.eSh, this.jHy.getUniqueId());
        ad adVar = new ad(frsNewAreaFragment.getPageContext(), cb.eSl, this.jHy.getUniqueId());
        adVar.b(bdTypeRecyclerView);
        p pVar = new p(frsNewAreaFragment.getPageContext(), cb.eSE, this.jHy.getUniqueId());
        pVar.b(bdTypeRecyclerView);
        t tVar = new t(frsNewAreaFragment.getPageContext(), cb.eSj, this.jHy.getUniqueId());
        tVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.b bVar = new com.baidu.tieba.frs.entelechy.adapter.b(frsNewAreaFragment.getPageContext(), cb.eSs, this.jHy.getUniqueId());
        bVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.i iVar = new com.baidu.tieba.frs.entelechy.adapter.i(frsNewAreaFragment.getPageContext(), cb.eSr, this.jHy.getUniqueId());
        iVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.j jVar = new com.baidu.tieba.frs.entelechy.adapter.j(frsNewAreaFragment.getPageContext(), cb.eSt, this.jHy.getUniqueId());
        jVar.b(bdTypeRecyclerView);
        x xVar = new x(frsNewAreaFragment.getPageContext(), cb.eSk, this.jHy.getUniqueId());
        xVar.b(bdTypeRecyclerView);
        ad adVar2 = new ad(frsNewAreaFragment.getPageContext(), cb.eSu, this.jHy.getUniqueId());
        adVar2.b(bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getPageContext(), s.jlC);
        rVar.b(bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends ca, ? extends TypeAdapter.ViewHolder> a2 = com.baidu.tieba.frs.e.cBN().a(frsNewAreaFragment.getPageContext(), this.jHy.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends cb, ? extends TypeAdapter.ViewHolder> b = com.baidu.tieba.frs.e.cBN().b(frsNewAreaFragment.getPageContext(), cb.eTY, this.jHy.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.s.dDB().a(this.jHy, AdvertAppInfo.eMB);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.s.dDB().a(this.jHy, AdvertAppInfo.eMK);
        ab abVar = new ab(frsNewAreaFragment.getPageContext(), cb.eSq, this.jHy.getUniqueId());
        abVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.adapter.g gVar = new com.baidu.tieba.frs.entelechy.adapter.g(frsNewAreaFragment.getPageContext(), cb.eSe, this.jHy.getUniqueId());
        gVar.a(bdTypeRecyclerView);
        this.boS.add(acVar);
        this.boS.add(oVar);
        this.boS.add(zVar);
        this.boS.add(wVar);
        this.boS.add(nVar);
        this.boS.add(qVar);
        this.boS.add(aaVar);
        this.boS.add(aeVar);
        this.boS.add(yVar);
        this.boS.add(vVar);
        this.boS.add(adVar);
        this.boS.add(tVar);
        this.boS.add(bVar);
        this.boS.add(iVar);
        this.boS.add(jVar);
        this.boS.add(xVar);
        this.boS.add(rVar);
        this.boS.add(pVar);
        this.boS.add(adVar2);
        this.boS.add(abVar);
        this.boS.add(gVar);
        if (a2 != null) {
            this.boS.add(a2);
        }
        if (b != null) {
            this.boS.add(b);
        }
        this.boS.add(a3);
        this.boS.add(a4);
        com.baidu.adp.widget.ListView.a<?, ?> c = com.baidu.tieba.h.b.cNB().c(this.jHy.getBaseFragmentActivity(), AdvertAppInfo.eMN);
        com.baidu.adp.widget.ListView.a<?, ?> c2 = com.baidu.tieba.h.b.cNB().c(this.jHy.getBaseFragmentActivity(), AdvertAppInfo.eMM);
        this.boS.add(c);
        this.boS.add(c2);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.jHy.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jHy.getPageContext(), this.jHy.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.boS != null) {
                this.boS.addAll(arrayList);
            }
        }
        f(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.jHy, 1);
        bVar2.setExtraData(this.boS);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.boS);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    public void b(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cFk();
        com.baidu.tieba.tbadkCore.v.x(arrayList, 1);
        ay(arrayList);
        this.joh.setData(arrayList);
        this.iHS = arrayList;
        this.jtd = frsViewData;
        cFO();
    }

    public void refreshData() {
        this.joh.setData(this.iHS);
        notifyDataSetChanged();
    }

    private void cFk() {
        if (!y.isEmpty(this.boS) && this.jHy != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jHy.getTbPageTag());
                }
            }
        }
    }

    private void cFO() {
        com.baidu.tieba.frs.b.b statisticMetaData;
        if (this.jtd != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if ((aVar instanceof com.baidu.tieba.frs.b.d) && (statisticMetaData = ((com.baidu.tieba.frs.b.d) aVar).getStatisticMetaData()) != null) {
                    if (this.jtd.needLog == 1) {
                        statisticMetaData.jJh = true;
                    } else {
                        statisticMetaData.jJh = false;
                    }
                    if (this.jtd.getForum() != null) {
                        statisticMetaData.jJj = this.jtd.getForum().getId();
                    }
                }
            }
        }
    }

    private void ay(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    com.baidu.adp.widget.ListView.n nVar = arrayList.get(i2);
                    if ((nVar instanceof AdvertAppInfo) && this.jtc != null && !this.jtc.containsValue(nVar)) {
                        this.jtc.put(Integer.valueOf(i2), (cb) nVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, cb> cGF() {
        return this.jtc;
    }

    public void cGK() {
        if (this.joh != null && this.joh.getData() != null && this.joh.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.n nVar : this.joh.getData()) {
                if ((nVar instanceof ca) && ((ca) nVar).eLr.bnN() != 0) {
                    ((ca) nVar).eLr.boR();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.joh.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.joh.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.boS != null && this.boS.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.boS != null && this.boS.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.boS != null && this.boS.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.k)) {
                    ((com.baidu.tieba.frs.k) aVar).a(wVar);
                }
            }
        }
    }

    private void f(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jHy != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.jHy.registerListener(this.jFL);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jHy == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.jFJ = new ArrayList();
        ArrayList<BdUniqueId> dNb = com.baidu.tieba.tbadkCore.v.dNb();
        if (dNb == null || dNb.size() <= 0) {
            return false;
        }
        int size = dNb.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.k<ICardInfo, ? extends TypeAdapter.ViewHolder> a2 = com.baidu.tieba.frs.e.cBN().a(this.jHy.getPageContext(), dNb.get(i), this.jHy.getUniqueId());
            if (a2 != null) {
                this.boS.add(a2);
                this.jFJ.add(a2);
            }
        }
        if (!y.isEmpty(this.jFJ)) {
            bdTypeRecyclerView.addAdapters(this.jFJ);
        }
        return true;
    }

    public List<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.iHS;
    }
}
