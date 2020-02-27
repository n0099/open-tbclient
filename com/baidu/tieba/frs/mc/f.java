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
    private ArrayList<m> fSr;
    private List<com.baidu.adp.widget.ListView.a> gFI;
    private FrsNewAreaFragment gHC;
    private BdTypeRecyclerView gsO;
    private final HashMap<Integer, bj> gwW;
    private FrsViewData gwX;
    private List<com.baidu.adp.widget.ListView.a> asE = new LinkedList();
    private CustomMessageListener gFK = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.isEmpty(f.this.gFI)) {
                f.this.b(f.this.gsO);
                f.this.b(f.this.fSr, f.this.gwX);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.gsO = bdTypeRecyclerView;
        this.gwW = new HashMap<>();
    }

    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gHC = frsNewAreaFragment;
        w wVar = new w(frsNewAreaFragment.getTbPageContext(), bj.cRm, this.gHC.getUniqueId());
        wVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.l lVar = new com.baidu.tieba.frs.entelechy.a.l(frsNewAreaFragment.getTbPageContext(), bj.cRn, this.gHC.getUniqueId());
        lVar.a(bdTypeRecyclerView);
        t tVar = new t(frsNewAreaFragment.getTbPageContext(), bj.cRp, this.gHC.getUniqueId());
        tVar.a(bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getTbPageContext(), bj.cRq, this.gHC.getUniqueId());
        rVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.k kVar = new com.baidu.tieba.frs.entelechy.a.k(frsNewAreaFragment.getTbPageContext(), bj.cRs, this.gHC.getUniqueId());
        kVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bj.cRt, this.gHC.getUniqueId());
        mVar.a(bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.getTbPageContext(), bj.cRL, this.gHC.getUniqueId());
        uVar.a(bdTypeRecyclerView);
        x xVar = new x(frsNewAreaFragment.getPageContext(), bj.cRy, this.gHC.getUniqueId());
        xVar.a(bdTypeRecyclerView);
        p pVar = new p(frsNewAreaFragment.getPageContext(), bj.cRw, this.gHC.getUniqueId());
        pVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsNewAreaFragment.getPageContext(), bj.cRE, this.gHC.getUniqueId());
        bVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.g gVar = new com.baidu.tieba.frs.entelechy.a.g(frsNewAreaFragment.getPageContext(), bj.cRD, this.gHC.getUniqueId());
        gVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getPageContext(), bj.cRF, this.gHC.getUniqueId());
        hVar.a(bdTypeRecyclerView);
        s sVar = new s(frsNewAreaFragment.getPageContext(), bj.cRx, this.gHC.getUniqueId());
        sVar.a(bdTypeRecyclerView);
        x xVar2 = new x(frsNewAreaFragment.getPageContext(), bj.cRG, this.gHC.getUniqueId());
        xVar2.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.m mVar2 = new com.baidu.tieba.frs.m(frsNewAreaFragment.getPageContext(), n.gqY);
        mVar2.a(bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends v.a> a = com.baidu.tieba.frs.c.bDe().a(frsNewAreaFragment.getPageContext(), this.gHC.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> b = com.baidu.tieba.frs.c.bDe().b(frsNewAreaFragment.getPageContext(), bj.cTk, this.gHC.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.cCt().a(this.gHC, AdvertAppInfo.cME);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.cCt().a(this.gHC, AdvertAppInfo.cMN);
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsNewAreaFragment.getPageContext(), bj.cRC, this.gHC.getUniqueId());
        vVar.a(bdTypeRecyclerView);
        this.asE.add(wVar);
        this.asE.add(lVar);
        this.asE.add(tVar);
        this.asE.add(rVar);
        this.asE.add(kVar);
        this.asE.add(mVar);
        this.asE.add(uVar);
        this.asE.add(xVar);
        this.asE.add(pVar);
        this.asE.add(bVar);
        this.asE.add(gVar);
        this.asE.add(hVar);
        this.asE.add(sVar);
        this.asE.add(mVar2);
        this.asE.add(xVar);
        this.asE.add(xVar2);
        this.asE.add(vVar);
        if (a != null) {
            this.asE.add(a);
        }
        if (b != null) {
            this.asE.add(b);
        }
        this.asE.add(a2);
        this.asE.add(a3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.gHC.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.gHC, 1);
        bVar2.setExtraData(this.asE);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.asE);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    public void b(ArrayList<m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        bFS();
        com.baidu.tieba.tbadkCore.s.o(arrayList, 1);
        ap(arrayList);
        this.gsO.setData(arrayList);
        this.fSr = arrayList;
        this.gwX = frsViewData;
        bGw();
    }

    public void refreshData() {
        this.gsO.setData(this.fSr);
        notifyDataSetChanged();
    }

    private void bFS() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.asE) && this.gHC != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gHC.getTbPageTag());
                }
            }
        }
    }

    private void bGw() {
        com.baidu.tieba.frs.d.b bGV;
        if (this.gwX != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bGV = ((com.baidu.tieba.frs.d.d) aVar).bGV()) != null) {
                    if (this.gwX.needLog == 1) {
                        bGV.gJk = true;
                    } else {
                        bGV.gJk = false;
                    }
                    if (this.gwX.getForum() != null) {
                        bGV.gJm = this.gwX.getForum().getId();
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
                    if ((mVar instanceof AdvertAppInfo) && this.gwW != null && !this.gwW.containsValue(mVar)) {
                        this.gwW.put(Integer.valueOf(i2), (bj) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bj> bGY() {
        return this.gwW;
    }

    public void bHd() {
        if (this.gsO != null && this.gsO.getData() != null && this.gsO.getData().size() != 0) {
            for (m mVar : this.gsO.getData()) {
                if ((mVar instanceof bi) && ((bi) mVar).cRe.aCh() != 0) {
                    ((bi) mVar).cRe.aDh();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.gsO.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.gsO.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.asE != null && this.asE.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.asE != null && this.asE.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        if (this.asE != null && this.asE.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.h)) {
                    ((com.baidu.tieba.frs.h) aVar).a(sVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gHC != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.gHC.registerListener(this.gFK);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gHC == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.gFI = new ArrayList();
        ArrayList<BdUniqueId> cKq = com.baidu.tieba.tbadkCore.s.cKq();
        if (cKq == null || cKq.size() <= 0) {
            return false;
        }
        int size = cKq.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends v.a> a = com.baidu.tieba.frs.c.bDe().a(this.gHC.getPageContext(), cKq.get(i), this.gHC.getUniqueId());
            if (a != null) {
                this.asE.add(a);
                this.gFI.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gFI)) {
            bdTypeRecyclerView.addAdapters(this.gFI);
        }
        return true;
    }

    public List<m> getDataList() {
        return this.fSr;
    }
}
