package com.baidu.tieba.frs.mc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.aa;
import com.baidu.tieba.frs.entelechy.a.ab;
import com.baidu.tieba.frs.entelechy.a.ac;
import com.baidu.tieba.frs.entelechy.a.ad;
import com.baidu.tieba.frs.entelechy.a.o;
import com.baidu.tieba.frs.entelechy.a.p;
import com.baidu.tieba.frs.entelechy.a.s;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.entelechy.a.v;
import com.baidu.tieba.frs.entelechy.a.w;
import com.baidu.tieba.frs.entelechy.a.x;
import com.baidu.tieba.frs.entelechy.a.z;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class f {
    private BdTypeRecyclerView iYW;
    private ArrayList<q> isF;
    private final HashMap<Integer, by> jdH;
    private FrsViewData jdI;
    private List<com.baidu.adp.widget.ListView.a> jqr;
    private FrsNewAreaFragment jsi;
    private List<com.baidu.adp.widget.ListView.a> bnf = new LinkedList();
    private CustomMessageListener jqt = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && y.isEmpty(f.this.jqr)) {
                f.this.g(f.this.iYW);
                f.this.b(f.this.isF, f.this.jdI);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.iYW = bdTypeRecyclerView;
        this.jdH = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v10, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jsi = frsNewAreaFragment;
        ab abVar = new ab(frsNewAreaFragment.getTbPageContext(), by.eIY, this.jsi.getUniqueId());
        abVar.b(bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), by.eIZ, this.jsi.getUniqueId());
        oVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.y yVar = new com.baidu.tieba.frs.entelechy.a.y(frsNewAreaFragment.getTbPageContext(), by.eJb, this.jsi.getUniqueId());
        yVar.b(bdTypeRecyclerView);
        v vVar = new v(frsNewAreaFragment.getTbPageContext(), by.eJc, this.jsi.getUniqueId());
        vVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.n nVar = new com.baidu.tieba.frs.entelechy.a.n(frsNewAreaFragment.getTbPageContext(), by.eJe, this.jsi.getUniqueId());
        nVar.b(bdTypeRecyclerView);
        p pVar = new p(frsNewAreaFragment.getTbPageContext(), by.eJf, this.jsi.getUniqueId());
        pVar.b(bdTypeRecyclerView);
        ad adVar = new ad(frsNewAreaFragment.getTbPageContext(), by.eJk, this.jsi.getUniqueId());
        adVar.b(bdTypeRecyclerView);
        z zVar = new z(frsNewAreaFragment.getTbPageContext(), by.eJE, this.jsi.getUniqueId());
        zVar.b(bdTypeRecyclerView);
        x xVar = new x(frsNewAreaFragment.getTbPageContext(), by.eJl, this.jsi.getUniqueId());
        u uVar = new u(frsNewAreaFragment.getTbPageContext(), by.eJm, this.jsi.getUniqueId());
        ac acVar = new ac(frsNewAreaFragment.getPageContext(), by.eJq, this.jsi.getUniqueId());
        acVar.b(bdTypeRecyclerView);
        s sVar = new s(frsNewAreaFragment.getPageContext(), by.eJo, this.jsi.getUniqueId());
        sVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsNewAreaFragment.getPageContext(), by.eJx, this.jsi.getUniqueId());
        bVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.i iVar = new com.baidu.tieba.frs.entelechy.a.i(frsNewAreaFragment.getPageContext(), by.eJw, this.jsi.getUniqueId());
        iVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.j jVar = new com.baidu.tieba.frs.entelechy.a.j(frsNewAreaFragment.getPageContext(), by.eJy, this.jsi.getUniqueId());
        jVar.b(bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.getPageContext(), by.eJp, this.jsi.getUniqueId());
        wVar.b(bdTypeRecyclerView);
        ac acVar2 = new ac(frsNewAreaFragment.getPageContext(), by.eJz, this.jsi.getUniqueId());
        acVar2.b(bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getPageContext(), com.baidu.tieba.frs.s.iWt);
        rVar.b(bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bx, ? extends af.a> a2 = com.baidu.tieba.frs.e.cBn().a(frsNewAreaFragment.getPageContext(), this.jsi.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends by, ? extends af.a> b = com.baidu.tieba.frs.e.cBn().b(frsNewAreaFragment.getPageContext(), by.eLc, this.jsi.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dFg().a(this.jsi, AdvertAppInfo.eDM);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.r.dFg().a(this.jsi, AdvertAppInfo.eDV);
        aa aaVar = new aa(frsNewAreaFragment.getPageContext(), by.eJv, this.jsi.getUniqueId());
        aaVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.g gVar = new com.baidu.tieba.frs.entelechy.a.g(frsNewAreaFragment.getPageContext(), by.eJj, this.jsi.getUniqueId());
        gVar.a(bdTypeRecyclerView);
        this.bnf.add(abVar);
        this.bnf.add(oVar);
        this.bnf.add(yVar);
        this.bnf.add(vVar);
        this.bnf.add(nVar);
        this.bnf.add(pVar);
        this.bnf.add(zVar);
        this.bnf.add(adVar);
        this.bnf.add(xVar);
        this.bnf.add(uVar);
        this.bnf.add(acVar);
        this.bnf.add(sVar);
        this.bnf.add(bVar);
        this.bnf.add(iVar);
        this.bnf.add(jVar);
        this.bnf.add(wVar);
        this.bnf.add(rVar);
        this.bnf.add(acVar);
        this.bnf.add(acVar2);
        this.bnf.add(aaVar);
        this.bnf.add(gVar);
        if (a2 != null) {
            this.bnf.add(a2);
        }
        if (b != null) {
            this.bnf.add(b);
        }
        this.bnf.add(a3);
        this.bnf.add(a4);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.jsi.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jsi.getPageContext(), this.jsi.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bnf != null) {
                this.bnf.addAll(arrayList);
            }
        }
        f(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.jsi, 1);
        bVar2.setExtraData(this.bnf);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.bnf);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    public void b(ArrayList<q> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cEH();
        com.baidu.tieba.tbadkCore.v.x(arrayList, 1);
        aE(arrayList);
        this.iYW.setData(arrayList);
        this.isF = arrayList;
        this.jdI = frsViewData;
        cFk();
    }

    public void refreshData() {
        this.iYW.setData(this.isF);
        notifyDataSetChanged();
    }

    private void cEH() {
        if (!y.isEmpty(this.bnf) && this.jsi != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jsi.getTbPageTag());
                }
            }
        }
    }

    private void cFk() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.jdI != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.jdI.needLog == 1) {
                        statisticMetaData.jtR = true;
                    } else {
                        statisticMetaData.jtR = false;
                    }
                    if (this.jdI.getForum() != null) {
                        statisticMetaData.jtT = this.jdI.getForum().getId();
                    }
                }
            }
        }
    }

    private void aE(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    q qVar = arrayList.get(i2);
                    if ((qVar instanceof AdvertAppInfo) && this.jdH != null && !this.jdH.containsValue(qVar)) {
                        this.jdH.put(Integer.valueOf(i2), (by) qVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, by> cFX() {
        return this.jdH;
    }

    public void cGc() {
        if (this.iYW != null && this.iYW.getData() != null && this.iYW.getData().size() != 0) {
            for (q qVar : this.iYW.getData()) {
                if ((qVar instanceof bx) && ((bx) qVar).eCR.boK() != 0) {
                    ((bx) qVar).eCR.bpP();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iYW.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.iYW.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.bnf != null && this.bnf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.bnf != null && this.bnf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.bnf != null && this.bnf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.k)) {
                    ((com.baidu.tieba.frs.k) aVar).a(abVar);
                }
            }
        }
    }

    private void f(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jsi != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.jsi.registerListener(this.jqt);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jsi == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.jqr = new ArrayList();
        ArrayList<BdUniqueId> dOz = com.baidu.tieba.tbadkCore.v.dOz();
        if (dOz == null || dOz.size() <= 0) {
            return false;
        }
        int size = dOz.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.k<ICardInfo, ? extends af.a> a2 = com.baidu.tieba.frs.e.cBn().a(this.jsi.getPageContext(), dOz.get(i), this.jsi.getUniqueId());
            if (a2 != null) {
                this.bnf.add(a2);
                this.jqr.add(a2);
            }
        }
        if (!y.isEmpty(this.jqr)) {
            bdTypeRecyclerView.addAdapters(this.jqr);
        }
        return true;
    }

    public List<q> getDataList() {
        return this.isF;
    }
}
