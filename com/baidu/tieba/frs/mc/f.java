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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes21.dex */
public class f {
    private BdTypeRecyclerView iOd;
    private final HashMap<Integer, bx> iSJ;
    private FrsViewData iSK;
    private ArrayList<q> ihK;
    private List<com.baidu.adp.widget.ListView.a> jcM;
    private FrsNewAreaFragment jeD;
    private List<com.baidu.adp.widget.ListView.a> biN = new LinkedList();
    private CustomMessageListener jcO = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && y.isEmpty(f.this.jcM)) {
                f.this.b(f.this.iOd);
                f.this.b(f.this.ihK, f.this.iSK);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.iOd = bdTypeRecyclerView;
        this.iSJ = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v10, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jeD = frsNewAreaFragment;
        aa aaVar = new aa(frsNewAreaFragment.getTbPageContext(), bx.eBX, this.jeD.getUniqueId());
        aaVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.n nVar = new com.baidu.tieba.frs.entelechy.a.n(frsNewAreaFragment.getTbPageContext(), bx.eBY, this.jeD.getUniqueId());
        nVar.b(bdTypeRecyclerView);
        x xVar = new x(frsNewAreaFragment.getTbPageContext(), bx.eCa, this.jeD.getUniqueId());
        xVar.b(bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.getTbPageContext(), bx.eCb, this.jeD.getUniqueId());
        uVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bx.eCd, this.jeD.getUniqueId());
        mVar.b(bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), bx.eCe, this.jeD.getUniqueId());
        oVar.b(bdTypeRecyclerView);
        ac acVar = new ac(frsNewAreaFragment.getTbPageContext(), bx.eCj, this.jeD.getUniqueId());
        acVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.y yVar = new com.baidu.tieba.frs.entelechy.a.y(frsNewAreaFragment.getTbPageContext(), bx.eCC, this.jeD.getUniqueId());
        yVar.b(bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.getTbPageContext(), bx.eCk, this.jeD.getUniqueId());
        t tVar = new t(frsNewAreaFragment.getTbPageContext(), bx.eCl, this.jeD.getUniqueId());
        ab abVar = new ab(frsNewAreaFragment.getPageContext(), bx.eCo, this.jeD.getUniqueId());
        abVar.b(bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getPageContext(), bx.eCm, this.jeD.getUniqueId());
        rVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsNewAreaFragment.getPageContext(), bx.eCv, this.jeD.getUniqueId());
        bVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getPageContext(), bx.eCu, this.jeD.getUniqueId());
        hVar.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.i iVar = new com.baidu.tieba.frs.entelechy.a.i(frsNewAreaFragment.getPageContext(), bx.eCw, this.jeD.getUniqueId());
        iVar.b(bdTypeRecyclerView);
        v vVar = new v(frsNewAreaFragment.getPageContext(), bx.eCn, this.jeD.getUniqueId());
        vVar.b(bdTypeRecyclerView);
        ab abVar2 = new ab(frsNewAreaFragment.getPageContext(), bx.eCx, this.jeD.getUniqueId());
        abVar2.b(bdTypeRecyclerView);
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsNewAreaFragment.getPageContext(), s.iLy);
        rVar2.b(bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> a2 = com.baidu.tieba.frs.e.cwX().a(frsNewAreaFragment.getPageContext(), this.jeD.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bx, ? extends af.a> b = com.baidu.tieba.frs.e.cwX().b(frsNewAreaFragment.getPageContext(), bx.eEa, this.jeD.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.q.dzO().a(this.jeD, AdvertAppInfo.ewL);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.q.dzO().a(this.jeD, AdvertAppInfo.ewU);
        z zVar = new z(frsNewAreaFragment.getPageContext(), bx.eCt, this.jeD.getUniqueId());
        zVar.b(bdTypeRecyclerView);
        this.biN.add(aaVar);
        this.biN.add(nVar);
        this.biN.add(xVar);
        this.biN.add(uVar);
        this.biN.add(mVar);
        this.biN.add(oVar);
        this.biN.add(yVar);
        this.biN.add(acVar);
        this.biN.add(wVar);
        this.biN.add(tVar);
        this.biN.add(abVar);
        this.biN.add(rVar);
        this.biN.add(bVar);
        this.biN.add(hVar);
        this.biN.add(iVar);
        this.biN.add(vVar);
        this.biN.add(rVar2);
        this.biN.add(abVar);
        this.biN.add(abVar2);
        this.biN.add(zVar);
        if (a2 != null) {
            this.biN.add(a2);
        }
        if (b != null) {
            this.biN.add(b);
        }
        this.biN.add(a3);
        this.biN.add(a4);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.jeD.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jeD.getPageContext(), this.jeD.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.biN != null) {
                this.biN.addAll(arrayList);
            }
        }
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.jeD, 1);
        bVar2.setExtraData(this.biN);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.biN);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    public void b(ArrayList<q> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cAq();
        com.baidu.tieba.tbadkCore.u.x(arrayList, 1);
        aC(arrayList);
        this.iOd.setData(arrayList);
        this.ihK = arrayList;
        this.iSK = frsViewData;
        cAT();
    }

    public void refreshData() {
        this.iOd.setData(this.ihK);
        notifyDataSetChanged();
    }

    private void cAq() {
        if (!y.isEmpty(this.biN) && this.jeD != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jeD.getTbPageTag());
                }
            }
        }
    }

    private void cAT() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.iSK != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.iSK.needLog == 1) {
                        statisticMetaData.jgm = true;
                    } else {
                        statisticMetaData.jgm = false;
                    }
                    if (this.iSK.getForum() != null) {
                        statisticMetaData.jgo = this.iSK.getForum().getId();
                    }
                }
            }
        }
    }

    private void aC(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    q qVar = arrayList.get(i2);
                    if ((qVar instanceof AdvertAppInfo) && this.iSJ != null && !this.iSJ.containsValue(qVar)) {
                        this.iSJ.put(Integer.valueOf(i2), (bx) qVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bx> cBD() {
        return this.iSJ;
    }

    public void cBI() {
        if (this.iOd != null && this.iOd.getData() != null && this.iOd.getData().size() != 0) {
            for (q qVar : this.iOd.getData()) {
                if ((qVar instanceof bw) && ((bw) qVar).evQ.blx() != 0) {
                    ((bw) qVar).evQ.bmC();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iOd.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.iOd.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.biN != null && this.biN.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.biN != null && this.biN.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.biN != null && this.biN.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.k)) {
                    ((com.baidu.tieba.frs.k) aVar).a(abVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jeD != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.jeD.registerListener(this.jcO);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jeD == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.jcM = new ArrayList();
        ArrayList<BdUniqueId> dJh = com.baidu.tieba.tbadkCore.u.dJh();
        if (dJh == null || dJh.size() <= 0) {
            return false;
        }
        int size = dJh.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.k<ICardInfo, ? extends af.a> a2 = com.baidu.tieba.frs.e.cwX().a(this.jeD.getPageContext(), dJh.get(i), this.jeD.getUniqueId());
            if (a2 != null) {
                this.biN.add(a2);
                this.jcM.add(a2);
            }
        }
        if (!y.isEmpty(this.jcM)) {
            bdTypeRecyclerView.addAdapters(this.jcM);
        }
        return true;
    }

    public List<q> getDataList() {
        return this.ihK;
    }
}
