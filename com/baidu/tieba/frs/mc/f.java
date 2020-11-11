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
import com.baidu.tieba.frs.entelechy.a.v;
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
/* loaded from: classes22.dex */
public class f {
    private BdTypeRecyclerView iNq;
    private final HashMap<Integer, bw> iRW;
    private FrsViewData iRX;
    private ArrayList<q> igW;
    private List<com.baidu.adp.widget.ListView.a> jbZ;
    private FrsNewAreaFragment jdQ;
    private List<com.baidu.adp.widget.ListView.a> bky = new LinkedList();
    private CustomMessageListener jcb = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && y.isEmpty(f.this.jbZ)) {
                f.this.b(f.this.iNq);
                f.this.b(f.this.igW, f.this.iRX);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.iNq = bdTypeRecyclerView;
        this.iRW = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v10, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jdQ = frsNewAreaFragment;
        aa aaVar = new aa(frsNewAreaFragment.getTbPageContext(), bw.eDF, this.jdQ.getUniqueId());
        aaVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.n nVar = new com.baidu.tieba.frs.entelechy.a.n(frsNewAreaFragment.getTbPageContext(), bw.eDG, this.jdQ.getUniqueId());
        nVar.b(bdTypeRecyclerView);
        x xVar = new x(frsNewAreaFragment.getTbPageContext(), bw.eDI, this.jdQ.getUniqueId());
        xVar.b(bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.getTbPageContext(), bw.eDJ, this.jdQ.getUniqueId());
        uVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bw.eDL, this.jdQ.getUniqueId());
        mVar.b(bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), bw.eDM, this.jdQ.getUniqueId());
        oVar.b(bdTypeRecyclerView);
        ac acVar = new ac(frsNewAreaFragment.getTbPageContext(), bw.eDR, this.jdQ.getUniqueId());
        acVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.y yVar = new com.baidu.tieba.frs.entelechy.a.y(frsNewAreaFragment.getTbPageContext(), bw.eEk, this.jdQ.getUniqueId());
        yVar.b(bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.getTbPageContext(), bw.eDS, this.jdQ.getUniqueId());
        t tVar = new t(frsNewAreaFragment.getTbPageContext(), bw.eDT, this.jdQ.getUniqueId());
        ab abVar = new ab(frsNewAreaFragment.getPageContext(), bw.eDW, this.jdQ.getUniqueId());
        abVar.b(bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getPageContext(), bw.eDU, this.jdQ.getUniqueId());
        rVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsNewAreaFragment.getPageContext(), bw.eEd, this.jdQ.getUniqueId());
        bVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getPageContext(), bw.eEc, this.jdQ.getUniqueId());
        hVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.i iVar = new com.baidu.tieba.frs.entelechy.a.i(frsNewAreaFragment.getPageContext(), bw.eEe, this.jdQ.getUniqueId());
        iVar.b(bdTypeRecyclerView);
        v vVar = new v(frsNewAreaFragment.getPageContext(), bw.eDV, this.jdQ.getUniqueId());
        vVar.b(bdTypeRecyclerView);
        ab abVar2 = new ab(frsNewAreaFragment.getPageContext(), bw.eEf, this.jdQ.getUniqueId());
        abVar2.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsNewAreaFragment.getPageContext(), s.iKL);
        rVar2.b(bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends af.a> a2 = com.baidu.tieba.frs.e.cxv().a(frsNewAreaFragment.getPageContext(), this.jdQ.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> b = com.baidu.tieba.frs.e.cxv().b(frsNewAreaFragment.getPageContext(), bw.eFI, this.jdQ.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dAo().a(this.jdQ, AdvertAppInfo.eyx);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.r.dAo().a(this.jdQ, AdvertAppInfo.eyG);
        z zVar = new z(frsNewAreaFragment.getPageContext(), bw.eEb, this.jdQ.getUniqueId());
        zVar.b(bdTypeRecyclerView);
        this.bky.add(aaVar);
        this.bky.add(nVar);
        this.bky.add(xVar);
        this.bky.add(uVar);
        this.bky.add(mVar);
        this.bky.add(oVar);
        this.bky.add(yVar);
        this.bky.add(acVar);
        this.bky.add(wVar);
        this.bky.add(tVar);
        this.bky.add(abVar);
        this.bky.add(rVar);
        this.bky.add(bVar);
        this.bky.add(hVar);
        this.bky.add(iVar);
        this.bky.add(vVar);
        this.bky.add(rVar2);
        this.bky.add(abVar);
        this.bky.add(abVar2);
        this.bky.add(zVar);
        if (a2 != null) {
            this.bky.add(a2);
        }
        if (b != null) {
            this.bky.add(b);
        }
        this.bky.add(a3);
        this.bky.add(a4);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.jdQ.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jdQ.getPageContext(), this.jdQ.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bky != null) {
                this.bky.addAll(arrayList);
            }
        }
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.jdQ, 1);
        bVar2.setExtraData(this.bky);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.bky);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    public void b(ArrayList<q> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cAN();
        com.baidu.tieba.tbadkCore.u.x(arrayList, 1);
        aB(arrayList);
        this.iNq.setData(arrayList);
        this.igW = arrayList;
        this.iRX = frsViewData;
        cBq();
    }

    public void refreshData() {
        this.iNq.setData(this.igW);
        notifyDataSetChanged();
    }

    private void cAN() {
        if (!y.isEmpty(this.bky) && this.jdQ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jdQ.getTbPageTag());
                }
            }
        }
    }

    private void cBq() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.iRX != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.iRX.needLog == 1) {
                        statisticMetaData.jfB = true;
                    } else {
                        statisticMetaData.jfB = false;
                    }
                    if (this.iRX.getForum() != null) {
                        statisticMetaData.jfD = this.iRX.getForum().getId();
                    }
                }
            }
        }
    }

    private void aB(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    q qVar = arrayList.get(i2);
                    if ((qVar instanceof AdvertAppInfo) && this.iRW != null && !this.iRW.containsValue(qVar)) {
                        this.iRW.put(Integer.valueOf(i2), (bw) qVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bw> cCa() {
        return this.iRW;
    }

    public void cCf() {
        if (this.iNq != null && this.iNq.getData() != null && this.iNq.getData().size() != 0) {
            for (q qVar : this.iNq.getData()) {
                if ((qVar instanceof bv) && ((bv) qVar).exA.bmv() != 0) {
                    ((bv) qVar).exA.bny();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iNq.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.iNq.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.bky != null && this.bky.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.bky != null && this.bky.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.bky != null && this.bky.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.k)) {
                    ((com.baidu.tieba.frs.k) aVar).a(abVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jdQ != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.jdQ.registerListener(this.jcb);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jdQ == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.jbZ = new ArrayList();
        ArrayList<BdUniqueId> dJq = com.baidu.tieba.tbadkCore.u.dJq();
        if (dJq == null || dJq.size() <= 0) {
            return false;
        }
        int size = dJq.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.k<ICardInfo, ? extends af.a> a2 = com.baidu.tieba.frs.e.cxv().a(this.jdQ.getPageContext(), dJq.get(i), this.jdQ.getUniqueId());
            if (a2 != null) {
                this.bky.add(a2);
                this.jbZ.add(a2);
            }
        }
        if (!y.isEmpty(this.jbZ)) {
            bdTypeRecyclerView.addAdapters(this.jbZ);
        }
        return true;
    }

    public List<q> getDataList() {
        return this.igW;
    }
}
