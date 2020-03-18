package com.baidu.tieba.frs.mc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.o;
import com.baidu.tieba.frs.entelechy.a.r;
import com.baidu.tieba.frs.entelechy.a.t;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.entelechy.a.w;
import com.baidu.tieba.frs.entelechy.a.x;
import com.baidu.tieba.frs.entelechy.a.y;
import com.baidu.tieba.frs.entelechy.a.z;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class f {
    private ArrayList<com.baidu.adp.widget.ListView.m> fTp;
    private List<com.baidu.adp.widget.ListView.a> gGU;
    private FrsNewAreaFragment gIR;
    private BdTypeRecyclerView gtH;
    private final HashMap<Integer, bj> gxV;
    private FrsViewData gxW;
    private List<com.baidu.adp.widget.ListView.a> asP = new LinkedList();
    private CustomMessageListener gGW = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.isEmpty(f.this.gGU)) {
                f.this.b(f.this.gtH);
                f.this.b(f.this.fTp, f.this.gxW);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.gtH = bdTypeRecyclerView;
        this.gxV = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v10, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gIR = frsNewAreaFragment;
        y yVar = new y(frsNewAreaFragment.getTbPageContext(), bj.cRB, this.gIR.getUniqueId());
        yVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.n nVar = new com.baidu.tieba.frs.entelechy.a.n(frsNewAreaFragment.getTbPageContext(), bj.cRC, this.gIR.getUniqueId());
        nVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsNewAreaFragment.getTbPageContext(), bj.cRE, this.gIR.getUniqueId());
        vVar.a(bdTypeRecyclerView);
        t tVar = new t(frsNewAreaFragment.getTbPageContext(), bj.cRF, this.gIR.getUniqueId());
        tVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bj.cRH, this.gIR.getUniqueId());
        mVar.a(bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), bj.cRI, this.gIR.getUniqueId());
        oVar.a(bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.getTbPageContext(), bj.cSa, this.gIR.getUniqueId());
        wVar.a(bdTypeRecyclerView);
        z zVar = new z(frsNewAreaFragment.getPageContext(), bj.cRN, this.gIR.getUniqueId());
        zVar.a(bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getPageContext(), bj.cRL, this.gIR.getUniqueId());
        rVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsNewAreaFragment.getPageContext(), bj.cRT, this.gIR.getUniqueId());
        bVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getPageContext(), bj.cRS, this.gIR.getUniqueId());
        hVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.i iVar = new com.baidu.tieba.frs.entelechy.a.i(frsNewAreaFragment.getPageContext(), bj.cRU, this.gIR.getUniqueId());
        iVar.a(bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.getPageContext(), bj.cRM, this.gIR.getUniqueId());
        uVar.a(bdTypeRecyclerView);
        z zVar2 = new z(frsNewAreaFragment.getPageContext(), bj.cRV, this.gIR.getUniqueId());
        zVar2.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.n nVar2 = new com.baidu.tieba.frs.n(frsNewAreaFragment.getPageContext(), com.baidu.tieba.frs.o.grX);
        nVar2.a(bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends v.a> a = com.baidu.tieba.frs.c.bDp().a(frsNewAreaFragment.getPageContext(), this.gIR.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> b = com.baidu.tieba.frs.c.bDp().b(frsNewAreaFragment.getPageContext(), bj.cTz, this.gIR.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.cCQ().a(this.gIR, AdvertAppInfo.cMR);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.cCQ().a(this.gIR, AdvertAppInfo.cNa);
        x xVar = new x(frsNewAreaFragment.getPageContext(), bj.cRR, this.gIR.getUniqueId());
        xVar.a(bdTypeRecyclerView);
        this.asP.add(yVar);
        this.asP.add(nVar);
        this.asP.add(vVar);
        this.asP.add(tVar);
        this.asP.add(mVar);
        this.asP.add(oVar);
        this.asP.add(wVar);
        this.asP.add(zVar);
        this.asP.add(rVar);
        this.asP.add(bVar);
        this.asP.add(hVar);
        this.asP.add(iVar);
        this.asP.add(uVar);
        this.asP.add(nVar2);
        this.asP.add(zVar);
        this.asP.add(zVar2);
        this.asP.add(xVar);
        if (a != null) {
            this.asP.add(a);
        }
        if (b != null) {
            this.asP.add(b);
        }
        this.asP.add(a2);
        this.asP.add(a3);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.gIR.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gIR.getPageContext(), this.gIR.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.asP != null) {
                this.asP.addAll(arrayList);
            }
        }
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.gIR, 1);
        bVar2.setExtraData(this.asP);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.asP);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    public void b(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        bGg();
        com.baidu.tieba.tbadkCore.t.n(arrayList, 1);
        ap(arrayList);
        this.gtH.setData(arrayList);
        this.fTp = arrayList;
        this.gxW = frsViewData;
        bGL();
    }

    public void refreshData() {
        this.gtH.setData(this.fTp);
        notifyDataSetChanged();
    }

    private void bGg() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.asP) && this.gIR != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gIR.getTbPageTag());
                }
            }
        }
    }

    private void bGL() {
        com.baidu.tieba.frs.d.b bHn;
        if (this.gxW != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bHn = ((com.baidu.tieba.frs.d.d) aVar).bHn()) != null) {
                    if (this.gxW.needLog == 1) {
                        bHn.gKD = true;
                    } else {
                        bHn.gKD = false;
                    }
                    if (this.gxW.getForum() != null) {
                        bHn.gKF = this.gxW.getForum().getId();
                    }
                }
            }
        }
    }

    private void ap(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    com.baidu.adp.widget.ListView.m mVar = arrayList.get(i2);
                    if ((mVar instanceof AdvertAppInfo) && this.gxV != null && !this.gxV.containsValue(mVar)) {
                        this.gxV.put(Integer.valueOf(i2), (bj) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bj> bHq() {
        return this.gxV;
    }

    public void bHv() {
        if (this.gtH != null && this.gtH.getData() != null && this.gtH.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.m mVar : this.gtH.getData()) {
                if ((mVar instanceof bi) && ((bi) mVar).cRt.aCm() != 0) {
                    ((bi) mVar).cRt.aDm();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.gtH.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.gtH.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.asP != null && this.asP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.asP != null && this.asP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(s sVar) {
        if (this.asP != null && this.asP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.h)) {
                    ((com.baidu.tieba.frs.h) aVar).a(sVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gIR != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.gIR.registerListener(this.gGW);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gIR == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.gGU = new ArrayList();
        ArrayList<BdUniqueId> cKN = com.baidu.tieba.tbadkCore.t.cKN();
        if (cKN == null || cKN.size() <= 0) {
            return false;
        }
        int size = cKN.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends v.a> a = com.baidu.tieba.frs.c.bDp().a(this.gIR.getPageContext(), cKN.get(i), this.gIR.getUniqueId());
            if (a != null) {
                this.asP.add(a);
                this.gGU.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gGU)) {
            bdTypeRecyclerView.addAdapters(this.gGU);
        }
        return true;
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.fTp;
    }
}
