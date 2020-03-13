package com.baidu.tieba.frs.mc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.p;
import com.baidu.tieba.frs.entelechy.a.r;
import com.baidu.tieba.frs.entelechy.a.s;
import com.baidu.tieba.frs.entelechy.a.t;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.entelechy.a.w;
import com.baidu.tieba.frs.entelechy.a.x;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class f {
    private ArrayList<m> fSG;
    private List<com.baidu.adp.widget.ListView.a> gFW;
    private FrsNewAreaFragment gHQ;
    private BdTypeRecyclerView gtd;
    private final HashMap<Integer, bj> gxk;
    private FrsViewData gxl;
    private List<com.baidu.adp.widget.ListView.a> asF = new LinkedList();
    private CustomMessageListener gFY = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.isEmpty(f.this.gFW)) {
                f.this.b(f.this.gtd);
                f.this.b(f.this.fSG, f.this.gxl);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.gtd = bdTypeRecyclerView;
        this.gxk = new HashMap<>();
    }

    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gHQ = frsNewAreaFragment;
        w wVar = new w(frsNewAreaFragment.getTbPageContext(), bj.cRo, this.gHQ.getUniqueId());
        wVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.l lVar = new com.baidu.tieba.frs.entelechy.a.l(frsNewAreaFragment.getTbPageContext(), bj.cRp, this.gHQ.getUniqueId());
        lVar.a(bdTypeRecyclerView);
        t tVar = new t(frsNewAreaFragment.getTbPageContext(), bj.cRr, this.gHQ.getUniqueId());
        tVar.a(bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getTbPageContext(), bj.cRs, this.gHQ.getUniqueId());
        rVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.k kVar = new com.baidu.tieba.frs.entelechy.a.k(frsNewAreaFragment.getTbPageContext(), bj.cRu, this.gHQ.getUniqueId());
        kVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bj.cRv, this.gHQ.getUniqueId());
        mVar.a(bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.getTbPageContext(), bj.cRN, this.gHQ.getUniqueId());
        uVar.a(bdTypeRecyclerView);
        x xVar = new x(frsNewAreaFragment.getPageContext(), bj.cRA, this.gHQ.getUniqueId());
        xVar.a(bdTypeRecyclerView);
        p pVar = new p(frsNewAreaFragment.getPageContext(), bj.cRy, this.gHQ.getUniqueId());
        pVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsNewAreaFragment.getPageContext(), bj.cRG, this.gHQ.getUniqueId());
        bVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.g gVar = new com.baidu.tieba.frs.entelechy.a.g(frsNewAreaFragment.getPageContext(), bj.cRF, this.gHQ.getUniqueId());
        gVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getPageContext(), bj.cRH, this.gHQ.getUniqueId());
        hVar.a(bdTypeRecyclerView);
        s sVar = new s(frsNewAreaFragment.getPageContext(), bj.cRz, this.gHQ.getUniqueId());
        sVar.a(bdTypeRecyclerView);
        x xVar2 = new x(frsNewAreaFragment.getPageContext(), bj.cRI, this.gHQ.getUniqueId());
        xVar2.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.m mVar2 = new com.baidu.tieba.frs.m(frsNewAreaFragment.getPageContext(), n.grn);
        mVar2.a(bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends v.a> a = com.baidu.tieba.frs.c.bDh().a(frsNewAreaFragment.getPageContext(), this.gHQ.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> b = com.baidu.tieba.frs.c.bDh().b(frsNewAreaFragment.getPageContext(), bj.cTm, this.gHQ.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.cCw().a(this.gHQ, AdvertAppInfo.cMG);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.cCw().a(this.gHQ, AdvertAppInfo.cMP);
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsNewAreaFragment.getPageContext(), bj.cRE, this.gHQ.getUniqueId());
        vVar.a(bdTypeRecyclerView);
        this.asF.add(wVar);
        this.asF.add(lVar);
        this.asF.add(tVar);
        this.asF.add(rVar);
        this.asF.add(kVar);
        this.asF.add(mVar);
        this.asF.add(uVar);
        this.asF.add(xVar);
        this.asF.add(pVar);
        this.asF.add(bVar);
        this.asF.add(gVar);
        this.asF.add(hVar);
        this.asF.add(sVar);
        this.asF.add(mVar2);
        this.asF.add(xVar);
        this.asF.add(xVar2);
        this.asF.add(vVar);
        if (a != null) {
            this.asF.add(a);
        }
        if (b != null) {
            this.asF.add(b);
        }
        this.asF.add(a2);
        this.asF.add(a3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.gHQ.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.gHQ, 1);
        bVar2.setExtraData(this.asF);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.asF);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    public void b(ArrayList<m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        bFV();
        com.baidu.tieba.tbadkCore.s.o(arrayList, 1);
        ap(arrayList);
        this.gtd.setData(arrayList);
        this.fSG = arrayList;
        this.gxl = frsViewData;
        bGz();
    }

    public void refreshData() {
        this.gtd.setData(this.fSG);
        notifyDataSetChanged();
    }

    private void bFV() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.asF) && this.gHQ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gHQ.getTbPageTag());
                }
            }
        }
    }

    private void bGz() {
        com.baidu.tieba.frs.d.b bGY;
        if (this.gxl != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bGY = ((com.baidu.tieba.frs.d.d) aVar).bGY()) != null) {
                    if (this.gxl.needLog == 1) {
                        bGY.gJy = true;
                    } else {
                        bGY.gJy = false;
                    }
                    if (this.gxl.getForum() != null) {
                        bGY.gJA = this.gxl.getForum().getId();
                    }
                }
            }
        }
    }

    private void ap(ArrayList<m> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    m mVar = arrayList.get(i2);
                    if ((mVar instanceof AdvertAppInfo) && this.gxk != null && !this.gxk.containsValue(mVar)) {
                        this.gxk.put(Integer.valueOf(i2), (bj) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bj> bHb() {
        return this.gxk;
    }

    public void bHg() {
        if (this.gtd != null && this.gtd.getData() != null && this.gtd.getData().size() != 0) {
            for (m mVar : this.gtd.getData()) {
                if ((mVar instanceof bi) && ((bi) mVar).cRg.aCj() != 0) {
                    ((bi) mVar).cRg.aDj();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.gtd.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.gtd.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.asF != null && this.asF.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.asF != null && this.asF.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        if (this.asF != null && this.asF.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.h)) {
                    ((com.baidu.tieba.frs.h) aVar).a(sVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gHQ != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.gHQ.registerListener(this.gFY);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gHQ == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.gFW = new ArrayList();
        ArrayList<BdUniqueId> cKt = com.baidu.tieba.tbadkCore.s.cKt();
        if (cKt == null || cKt.size() <= 0) {
            return false;
        }
        int size = cKt.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends v.a> a = com.baidu.tieba.frs.c.bDh().a(this.gHQ.getPageContext(), cKt.get(i), this.gHQ.getUniqueId());
            if (a != null) {
                this.asF.add(a);
                this.gFW.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gFW)) {
            bdTypeRecyclerView.addAdapters(this.gFW);
        }
        return true;
    }

    public List<m> getDataList() {
        return this.fSG;
    }
}
