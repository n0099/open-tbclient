package com.baidu.tieba.frs.mc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.aa;
import com.baidu.tieba.frs.entelechy.a.ab;
import com.baidu.tieba.frs.entelechy.a.ac;
import com.baidu.tieba.frs.entelechy.a.o;
import com.baidu.tieba.frs.entelechy.a.r;
import com.baidu.tieba.frs.entelechy.a.t;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.entelechy.a.w;
import com.baidu.tieba.frs.entelechy.a.y;
import com.baidu.tieba.frs.entelechy.a.z;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes16.dex */
public class f {
    private BdTypeRecyclerView hKL;
    private final HashMap<Integer, bv> hPr;
    private FrsViewData hPs;
    private List<com.baidu.adp.widget.ListView.a> hZi;
    private ArrayList<q> hfz;
    private FrsNewAreaFragment ibb;
    private List<com.baidu.adp.widget.ListView.a> aWf = new LinkedList();
    private CustomMessageListener hZk = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && x.isEmpty(f.this.hZi)) {
                f.this.b(f.this.hKL);
                f.this.b(f.this.hfz, f.this.hPs);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.hKL = bdTypeRecyclerView;
        this.hPr = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v10, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.ibb = frsNewAreaFragment;
        aa aaVar = new aa(frsNewAreaFragment.getTbPageContext(), bv.dRB, this.ibb.getUniqueId());
        aaVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.n nVar = new com.baidu.tieba.frs.entelechy.a.n(frsNewAreaFragment.getTbPageContext(), bv.dRC, this.ibb.getUniqueId());
        nVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.x xVar = new com.baidu.tieba.frs.entelechy.a.x(frsNewAreaFragment.getTbPageContext(), bv.dRE, this.ibb.getUniqueId());
        xVar.b((v) bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.getTbPageContext(), bv.dRF, this.ibb.getUniqueId());
        uVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bv.dRH, this.ibb.getUniqueId());
        mVar.b((v) bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), bv.dRI, this.ibb.getUniqueId());
        oVar.b((v) bdTypeRecyclerView);
        ac acVar = new ac(frsNewAreaFragment.getTbPageContext(), bv.dRN, this.ibb.getUniqueId());
        acVar.b((v) bdTypeRecyclerView);
        y yVar = new y(frsNewAreaFragment.getTbPageContext(), bv.dSf, this.ibb.getUniqueId());
        yVar.b((v) bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.getTbPageContext(), bv.dRO, this.ibb.getUniqueId());
        t tVar = new t(frsNewAreaFragment.getTbPageContext(), bv.dRP, this.ibb.getUniqueId());
        ab abVar = new ab(frsNewAreaFragment.getPageContext(), bv.dRS, this.ibb.getUniqueId());
        abVar.b((v) bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getPageContext(), bv.dRQ, this.ibb.getUniqueId());
        rVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsNewAreaFragment.getPageContext(), bv.dRY, this.ibb.getUniqueId());
        bVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getPageContext(), bv.dRX, this.ibb.getUniqueId());
        hVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.i iVar = new com.baidu.tieba.frs.entelechy.a.i(frsNewAreaFragment.getPageContext(), bv.dRZ, this.ibb.getUniqueId());
        iVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsNewAreaFragment.getPageContext(), bv.dRR, this.ibb.getUniqueId());
        vVar.b((v) bdTypeRecyclerView);
        ab abVar2 = new ab(frsNewAreaFragment.getPageContext(), bv.dSa, this.ibb.getUniqueId());
        abVar2.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.q qVar = new com.baidu.tieba.frs.q(frsNewAreaFragment.getPageContext(), com.baidu.tieba.frs.r.hIV);
        qVar.b((v) bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bu, ? extends ad.a> a = com.baidu.tieba.frs.e.caF().a(frsNewAreaFragment.getPageContext(), this.ibb.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends ad.a> b = com.baidu.tieba.frs.e.caF().b(frsNewAreaFragment.getPageContext(), bv.dTD, this.ibb.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.dca().a(this.ibb, AdvertAppInfo.dMF);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dca().a(this.ibb, AdvertAppInfo.dMO);
        z zVar = new z(frsNewAreaFragment.getPageContext(), bv.dRW, this.ibb.getUniqueId());
        zVar.b((v) bdTypeRecyclerView);
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
        this.aWf.add(bVar);
        this.aWf.add(hVar);
        this.aWf.add(iVar);
        this.aWf.add(vVar);
        this.aWf.add(qVar);
        this.aWf.add(abVar);
        this.aWf.add(abVar2);
        this.aWf.add(zVar);
        if (a != null) {
            this.aWf.add(a);
        }
        if (b != null) {
            this.aWf.add(b);
        }
        this.aWf.add(a2);
        this.aWf.add(a3);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.ibb.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).a(this.ibb.getPageContext(), this.ibb.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.aWf != null) {
                this.aWf.addAll(arrayList);
            }
        }
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.ibb, 1);
        bVar2.setExtraData(this.aWf);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.aWf);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
            if (aVar instanceof com.baidu.tieba.frs.j) {
                ((com.baidu.tieba.frs.j) aVar).release();
            }
        }
    }

    public void b(ArrayList<q> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cdP();
        com.baidu.tieba.tbadkCore.t.r(arrayList, 1);
        as(arrayList);
        this.hKL.setData(arrayList);
        this.hfz = arrayList;
        this.hPs = frsViewData;
        cet();
    }

    public void refreshData() {
        this.hKL.setData(this.hfz);
        notifyDataSetChanged();
    }

    private void cdP() {
        if (!x.isEmpty(this.aWf) && this.ibb != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).a(this.ibb.getTbPageTag());
                }
            }
        }
    }

    private void cet() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.hPs != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.hPs.needLog == 1) {
                        statisticMetaData.icM = true;
                    } else {
                        statisticMetaData.icM = false;
                    }
                    if (this.hPs.getForum() != null) {
                        statisticMetaData.icO = this.hPs.getForum().getId();
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
                    if ((qVar instanceof AdvertAppInfo) && this.hPr != null && !this.hPr.containsValue(qVar)) {
                        this.hPr.put(Integer.valueOf(i2), (bv) qVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bv> cfc() {
        return this.hPr;
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
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.aWf != null && this.aWf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.z zVar) {
        if (this.aWf != null && this.aWf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.j)) {
                    ((com.baidu.tieba.frs.j) aVar).a(zVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.ibb != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.ibb.registerListener(this.hZk);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.ibb == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.hZi = new ArrayList();
        ArrayList<BdUniqueId> dkz = com.baidu.tieba.tbadkCore.t.dkz();
        if (dkz == null || dkz.size() <= 0) {
            return false;
        }
        int size = dkz.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.j<ICardInfo, ? extends ad.a> a = com.baidu.tieba.frs.e.caF().a(this.ibb.getPageContext(), dkz.get(i), this.ibb.getUniqueId());
            if (a != null) {
                this.aWf.add(a);
                this.hZi.add(a);
            }
        }
        if (!x.isEmpty(this.hZi)) {
            bdTypeRecyclerView.addAdapters(this.hZi);
        }
        return true;
    }

    public List<q> getDataList() {
        return this.hfz;
    }
}
