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
/* loaded from: classes6.dex */
public class f {
    private ArrayList<m> fMN;
    private List<com.baidu.adp.widget.ListView.a> gAz;
    private FrsNewAreaFragment gCo;
    private BdTypeRecyclerView gnE;
    private final HashMap<Integer, bj> grM;
    private FrsViewData grN;
    private List<com.baidu.adp.widget.ListView.a> aoz = new LinkedList();
    private CustomMessageListener gAB = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.isEmpty(f.this.gAz)) {
                f.this.b(f.this.gnE);
                f.this.b(f.this.fMN, f.this.grN);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.gnE = bdTypeRecyclerView;
        this.grM = new HashMap<>();
    }

    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gCo = frsNewAreaFragment;
        w wVar = new w(frsNewAreaFragment.getTbPageContext(), bj.cMZ, this.gCo.getUniqueId());
        wVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.l lVar = new com.baidu.tieba.frs.entelechy.a.l(frsNewAreaFragment.getTbPageContext(), bj.cNa, this.gCo.getUniqueId());
        lVar.a(bdTypeRecyclerView);
        t tVar = new t(frsNewAreaFragment.getTbPageContext(), bj.cNc, this.gCo.getUniqueId());
        tVar.a(bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getTbPageContext(), bj.cNd, this.gCo.getUniqueId());
        rVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.k kVar = new com.baidu.tieba.frs.entelechy.a.k(frsNewAreaFragment.getTbPageContext(), bj.cNf, this.gCo.getUniqueId());
        kVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bj.cNg, this.gCo.getUniqueId());
        mVar.a(bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.getTbPageContext(), bj.cNy, this.gCo.getUniqueId());
        uVar.a(bdTypeRecyclerView);
        x xVar = new x(frsNewAreaFragment.getPageContext(), bj.cNl, this.gCo.getUniqueId());
        xVar.a(bdTypeRecyclerView);
        p pVar = new p(frsNewAreaFragment.getPageContext(), bj.cNj, this.gCo.getUniqueId());
        pVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsNewAreaFragment.getPageContext(), bj.cNr, this.gCo.getUniqueId());
        bVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.g gVar = new com.baidu.tieba.frs.entelechy.a.g(frsNewAreaFragment.getPageContext(), bj.cNq, this.gCo.getUniqueId());
        gVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getPageContext(), bj.cNs, this.gCo.getUniqueId());
        hVar.a(bdTypeRecyclerView);
        s sVar = new s(frsNewAreaFragment.getPageContext(), bj.cNk, this.gCo.getUniqueId());
        sVar.a(bdTypeRecyclerView);
        x xVar2 = new x(frsNewAreaFragment.getPageContext(), bj.cNt, this.gCo.getUniqueId());
        xVar2.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.m mVar2 = new com.baidu.tieba.frs.m(frsNewAreaFragment.getPageContext(), n.glO);
        mVar2.a(bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends v.a> a = com.baidu.tieba.frs.c.bAA().a(frsNewAreaFragment.getPageContext(), this.gCo.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> b = com.baidu.tieba.frs.c.bAA().b(frsNewAreaFragment.getPageContext(), bj.cOY, this.gCo.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.czO().a(this.gCo, AdvertAppInfo.cIp);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.czO().a(this.gCo, AdvertAppInfo.cIy);
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsNewAreaFragment.getPageContext(), bj.cNp, this.gCo.getUniqueId());
        vVar.a(bdTypeRecyclerView);
        this.aoz.add(wVar);
        this.aoz.add(lVar);
        this.aoz.add(tVar);
        this.aoz.add(rVar);
        this.aoz.add(kVar);
        this.aoz.add(mVar);
        this.aoz.add(uVar);
        this.aoz.add(xVar);
        this.aoz.add(pVar);
        this.aoz.add(bVar);
        this.aoz.add(gVar);
        this.aoz.add(hVar);
        this.aoz.add(sVar);
        this.aoz.add(mVar2);
        this.aoz.add(xVar);
        this.aoz.add(xVar2);
        this.aoz.add(vVar);
        if (a != null) {
            this.aoz.add(a);
        }
        if (b != null) {
            this.aoz.add(b);
        }
        this.aoz.add(a2);
        this.aoz.add(a3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.gCo.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.gCo, 1);
        bVar2.setExtraData(this.aoz);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.aoz);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    public void b(ArrayList<m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        bDo();
        com.baidu.tieba.tbadkCore.s.n(arrayList, 1);
        ap(arrayList);
        this.gnE.setData(arrayList);
        this.fMN = arrayList;
        this.grN = frsViewData;
        bDS();
    }

    public void refreshData() {
        this.gnE.setData(this.fMN);
        notifyDataSetChanged();
    }

    private void bDo() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.aoz) && this.gCo != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gCo.getTbPageTag());
                }
            }
        }
    }

    private void bDS() {
        com.baidu.tieba.frs.d.b bEr;
        if (this.grN != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bEr = ((com.baidu.tieba.frs.d.d) aVar).bEr()) != null) {
                    if (this.grN.needLog == 1) {
                        bEr.gDW = true;
                    } else {
                        bEr.gDW = false;
                    }
                    if (this.grN.getForum() != null) {
                        bEr.gDY = this.grN.getForum().getId();
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
                    if ((mVar instanceof AdvertAppInfo) && this.grM != null && !this.grM.containsValue(mVar)) {
                        this.grM.put(Integer.valueOf(i2), (bj) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bj> bEu() {
        return this.grM;
    }

    public void bEz() {
        if (this.gnE != null && this.gnE.getData() != null && this.gnE.getData().size() != 0) {
            for (m mVar : this.gnE.getData()) {
                if ((mVar instanceof bi) && ((bi) mVar).cMR.azz() != 0) {
                    ((bi) mVar).cMR.aAA();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.gnE.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.gnE.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.aoz != null && this.aoz.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.aoz != null && this.aoz.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        if (this.aoz != null && this.aoz.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.h)) {
                    ((com.baidu.tieba.frs.h) aVar).a(sVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gCo != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.gCo.registerListener(this.gAB);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gCo == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.gAz = new ArrayList();
        ArrayList<BdUniqueId> cHG = com.baidu.tieba.tbadkCore.s.cHG();
        if (cHG == null || cHG.size() <= 0) {
            return false;
        }
        int size = cHG.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends v.a> a = com.baidu.tieba.frs.c.bAA().a(this.gCo.getPageContext(), cHG.get(i), this.gCo.getUniqueId());
            if (a != null) {
                this.aoz.add(a);
                this.gAz.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gAz)) {
            bdTypeRecyclerView.addAdapters(this.gAz);
        }
        return true;
    }

    public List<m> getDataList() {
        return this.fMN;
    }
}
