package com.baidu.tieba.frs.mc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.aa;
import com.baidu.tieba.frs.entelechy.a.ab;
import com.baidu.tieba.frs.entelechy.a.ac;
import com.baidu.tieba.frs.entelechy.a.o;
import com.baidu.tieba.frs.entelechy.a.r;
import com.baidu.tieba.frs.entelechy.a.t;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.entelechy.a.w;
import com.baidu.tieba.frs.entelechy.a.x;
import com.baidu.tieba.frs.entelechy.a.z;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes16.dex */
public class f {
    private BdTypeRecyclerView hYQ;
    private ArrayList<q> hss;
    private final HashMap<Integer, bw> idA;
    private FrsViewData idB;
    private List<com.baidu.adp.widget.ListView.a> inq;
    private FrsNewAreaFragment ipi;
    private List<com.baidu.adp.widget.ListView.a> bbu = new LinkedList();

    /* renamed from: int  reason: not valid java name */
    private CustomMessageListener f4int = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && y.isEmpty(f.this.inq)) {
                f.this.b(f.this.hYQ);
                f.this.b(f.this.hss, f.this.idB);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.hYQ = bdTypeRecyclerView;
        this.idA = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v10, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.ipi = frsNewAreaFragment;
        aa aaVar = new aa(frsNewAreaFragment.getTbPageContext(), bw.eaX, this.ipi.getUniqueId());
        aaVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.n nVar = new com.baidu.tieba.frs.entelechy.a.n(frsNewAreaFragment.getTbPageContext(), bw.eaY, this.ipi.getUniqueId());
        nVar.b((v) bdTypeRecyclerView);
        x xVar = new x(frsNewAreaFragment.getTbPageContext(), bw.eba, this.ipi.getUniqueId());
        xVar.b((v) bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.getTbPageContext(), bw.ebb, this.ipi.getUniqueId());
        uVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bw.ebd, this.ipi.getUniqueId());
        mVar.b((v) bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), bw.ebe, this.ipi.getUniqueId());
        oVar.b((v) bdTypeRecyclerView);
        ac acVar = new ac(frsNewAreaFragment.getTbPageContext(), bw.ebj, this.ipi.getUniqueId());
        acVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.y yVar = new com.baidu.tieba.frs.entelechy.a.y(frsNewAreaFragment.getTbPageContext(), bw.ebB, this.ipi.getUniqueId());
        yVar.b((v) bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.getTbPageContext(), bw.ebk, this.ipi.getUniqueId());
        t tVar = new t(frsNewAreaFragment.getTbPageContext(), bw.ebl, this.ipi.getUniqueId());
        ab abVar = new ab(frsNewAreaFragment.getPageContext(), bw.ebo, this.ipi.getUniqueId());
        abVar.b((v) bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getPageContext(), bw.ebm, this.ipi.getUniqueId());
        rVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsNewAreaFragment.getPageContext(), bw.ebu, this.ipi.getUniqueId());
        bVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getPageContext(), bw.ebt, this.ipi.getUniqueId());
        hVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.i iVar = new com.baidu.tieba.frs.entelechy.a.i(frsNewAreaFragment.getPageContext(), bw.ebv, this.ipi.getUniqueId());
        iVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsNewAreaFragment.getPageContext(), bw.ebn, this.ipi.getUniqueId());
        vVar.b((v) bdTypeRecyclerView);
        ab abVar2 = new ab(frsNewAreaFragment.getPageContext(), bw.ebw, this.ipi.getUniqueId());
        abVar2.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsNewAreaFragment.getPageContext(), s.hWl);
        rVar2.b((v) bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends af.a> a = com.baidu.tieba.frs.e.clb().a(frsNewAreaFragment.getPageContext(), this.ipi.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> b = com.baidu.tieba.frs.e.clb().b(frsNewAreaFragment.getPageContext(), bw.ecZ, this.ipi.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.dnh().a(this.ipi, AdvertAppInfo.dVO);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dnh().a(this.ipi, AdvertAppInfo.dVX);
        z zVar = new z(frsNewAreaFragment.getPageContext(), bw.ebs, this.ipi.getUniqueId());
        zVar.b((v) bdTypeRecyclerView);
        this.bbu.add(aaVar);
        this.bbu.add(nVar);
        this.bbu.add(xVar);
        this.bbu.add(uVar);
        this.bbu.add(mVar);
        this.bbu.add(oVar);
        this.bbu.add(yVar);
        this.bbu.add(acVar);
        this.bbu.add(wVar);
        this.bbu.add(tVar);
        this.bbu.add(abVar);
        this.bbu.add(rVar);
        this.bbu.add(bVar);
        this.bbu.add(hVar);
        this.bbu.add(iVar);
        this.bbu.add(vVar);
        this.bbu.add(rVar2);
        this.bbu.add(abVar);
        this.bbu.add(abVar2);
        this.bbu.add(zVar);
        if (a != null) {
            this.bbu.add(a);
        }
        if (b != null) {
            this.bbu.add(b);
        }
        this.bbu.add(a2);
        this.bbu.add(a3);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.ipi.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.ipi.getPageContext(), this.ipi.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bbu != null) {
                this.bbu.addAll(arrayList);
            }
        }
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.ipi, 1);
        bVar2.setExtraData(this.bbu);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.bbu);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    public void b(ArrayList<q> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cot();
        com.baidu.tieba.tbadkCore.u.u(arrayList, 1);
        ay(arrayList);
        this.hYQ.setData(arrayList);
        this.hss = arrayList;
        this.idB = frsViewData;
        coX();
    }

    public void refreshData() {
        this.hYQ.setData(this.hss);
        notifyDataSetChanged();
    }

    private void cot() {
        if (!y.isEmpty(this.bbu) && this.ipi != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.ipi.getTbPageTag());
                }
            }
        }
    }

    private void coX() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.idB != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.idB.needLog == 1) {
                        statisticMetaData.iqT = true;
                    } else {
                        statisticMetaData.iqT = false;
                    }
                    if (this.idB.getForum() != null) {
                        statisticMetaData.iqV = this.idB.getForum().getId();
                    }
                }
            }
        }
    }

    private void ay(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    q qVar = arrayList.get(i2);
                    if ((qVar instanceof AdvertAppInfo) && this.idA != null && !this.idA.containsValue(qVar)) {
                        this.idA.put(Integer.valueOf(i2), (bw) qVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bw> cpH() {
        return this.idA;
    }

    public void cpM() {
        if (this.hYQ != null && this.hYQ.getData() != null && this.hYQ.getData().size() != 0) {
            for (q qVar : this.hYQ.getData()) {
                if ((qVar instanceof bv) && ((bv) qVar).dUS.bez() != 0) {
                    ((bv) qVar).dUS.bfC();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hYQ.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.hYQ.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.bbu != null && this.bbu.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.bbu != null && this.bbu.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.bbu != null && this.bbu.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.k)) {
                    ((com.baidu.tieba.frs.k) aVar).a(abVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.ipi != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.ipi.registerListener(this.f4int);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.ipi == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.inq = new ArrayList();
        ArrayList<BdUniqueId> dvW = com.baidu.tieba.tbadkCore.u.dvW();
        if (dvW == null || dvW.size() <= 0) {
            return false;
        }
        int size = dvW.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.k<ICardInfo, ? extends af.a> a = com.baidu.tieba.frs.e.clb().a(this.ipi.getPageContext(), dvW.get(i), this.ipi.getUniqueId());
            if (a != null) {
                this.bbu.add(a);
                this.inq.add(a);
            }
        }
        if (!y.isEmpty(this.inq)) {
            bdTypeRecyclerView.addAdapters(this.inq);
        }
        return true;
    }

    public List<q> getDataList() {
        return this.hss;
    }
}
