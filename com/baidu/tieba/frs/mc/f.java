package com.baidu.tieba.frs.mc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.y;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.o;
import com.baidu.tieba.frs.entelechy.a.t;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.entelechy.a.w;
import com.baidu.tieba.frs.entelechy.a.x;
import com.baidu.tieba.frs.entelechy.a.y;
import com.baidu.tieba.frs.entelechy.a.z;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.q;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class f {
    private ArrayList<com.baidu.adp.widget.ListView.m> gyd;
    private BdTypeRecyclerView hcY;
    private final HashMap<Integer, bj> hhw;
    private FrsViewData hhx;
    private List<com.baidu.adp.widget.ListView.a> hqt;
    private FrsNewAreaFragment hsn;
    private List<com.baidu.adp.widget.ListView.a> aMj = new LinkedList();
    private CustomMessageListener hqv = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.isEmpty(f.this.hqt)) {
                f.this.b(f.this.hcY);
                f.this.b(f.this.gyd, f.this.hhx);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.hcY = bdTypeRecyclerView;
        this.hhw = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v10, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hsn = frsNewAreaFragment;
        y yVar = new y(frsNewAreaFragment.getTbPageContext(), bj.dqM, this.hsn.getUniqueId());
        yVar.b((r) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.n nVar = new com.baidu.tieba.frs.entelechy.a.n(frsNewAreaFragment.getTbPageContext(), bj.dqN, this.hsn.getUniqueId());
        nVar.b((r) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsNewAreaFragment.getTbPageContext(), bj.dqP, this.hsn.getUniqueId());
        vVar.b((r) bdTypeRecyclerView);
        t tVar = new t(frsNewAreaFragment.getTbPageContext(), bj.dqQ, this.hsn.getUniqueId());
        tVar.b((r) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bj.dqS, this.hsn.getUniqueId());
        mVar.b((r) bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), bj.dqT, this.hsn.getUniqueId());
        oVar.b((r) bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.getTbPageContext(), bj.drm, this.hsn.getUniqueId());
        wVar.b((r) bdTypeRecyclerView);
        z zVar = new z(frsNewAreaFragment.getPageContext(), bj.dqZ, this.hsn.getUniqueId());
        zVar.b((r) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.r rVar = new com.baidu.tieba.frs.entelechy.a.r(frsNewAreaFragment.getPageContext(), bj.dqX, this.hsn.getUniqueId());
        rVar.b((r) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsNewAreaFragment.getPageContext(), bj.drf, this.hsn.getUniqueId());
        bVar.b((r) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getPageContext(), bj.dre, this.hsn.getUniqueId());
        hVar.b((r) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.i iVar = new com.baidu.tieba.frs.entelechy.a.i(frsNewAreaFragment.getPageContext(), bj.drg, this.hsn.getUniqueId());
        iVar.b((r) bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.getPageContext(), bj.dqY, this.hsn.getUniqueId());
        uVar.b((r) bdTypeRecyclerView);
        z zVar2 = new z(frsNewAreaFragment.getPageContext(), bj.drh, this.hsn.getUniqueId());
        zVar2.b((r) bdTypeRecyclerView);
        com.baidu.tieba.frs.o oVar2 = new com.baidu.tieba.frs.o(frsNewAreaFragment.getPageContext(), p.hbp);
        oVar2.b((r) bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends y.a> a = com.baidu.tieba.frs.c.bNL().a(frsNewAreaFragment.getPageContext(), this.hsn.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends y.a> b = com.baidu.tieba.frs.c.bNL().b(frsNewAreaFragment.getPageContext(), bj.dsN, this.hsn.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = q.cNl().a(this.hsn, AdvertAppInfo.dmb);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = q.cNl().a(this.hsn, AdvertAppInfo.dmk);
        x xVar = new x(frsNewAreaFragment.getPageContext(), bj.drd, this.hsn.getUniqueId());
        xVar.b((r) bdTypeRecyclerView);
        this.aMj.add(yVar);
        this.aMj.add(nVar);
        this.aMj.add(vVar);
        this.aMj.add(tVar);
        this.aMj.add(mVar);
        this.aMj.add(oVar);
        this.aMj.add(wVar);
        this.aMj.add(zVar);
        this.aMj.add(rVar);
        this.aMj.add(bVar);
        this.aMj.add(hVar);
        this.aMj.add(iVar);
        this.aMj.add(uVar);
        this.aMj.add(oVar2);
        this.aMj.add(zVar);
        this.aMj.add(zVar2);
        this.aMj.add(xVar);
        if (a != null) {
            this.aMj.add(a);
        }
        if (b != null) {
            this.aMj.add(b);
        }
        this.aMj.add(a2);
        this.aMj.add(a3);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.hsn.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.hsn.getPageContext(), this.hsn.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.aMj != null) {
                this.aMj.addAll(arrayList);
            }
        }
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.hsn, 1);
        bVar2.setExtraData(this.aMj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.aMj);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    public void b(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        bQG();
        com.baidu.tieba.tbadkCore.t.q(arrayList, 1);
        ar(arrayList);
        this.hcY.setData(arrayList);
        this.gyd = arrayList;
        this.hhx = frsViewData;
        bRk();
    }

    public void refreshData() {
        this.hcY.setData(this.gyd);
        notifyDataSetChanged();
    }

    private void bQG() {
        if (!v.isEmpty(this.aMj) && this.hsn != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.hsn.getTbPageTag());
                }
            }
        }
    }

    private void bRk() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.hhx != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.hhx.needLog == 1) {
                        statisticMetaData.hua = true;
                    } else {
                        statisticMetaData.hua = false;
                    }
                    if (this.hhx.getForum() != null) {
                        statisticMetaData.huc = this.hhx.getForum().getId();
                    }
                }
            }
        }
    }

    private void ar(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    com.baidu.adp.widget.ListView.m mVar = arrayList.get(i2);
                    if ((mVar instanceof AdvertAppInfo) && this.hhw != null && !this.hhw.containsValue(mVar)) {
                        this.hhw.put(Integer.valueOf(i2), (bj) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bj> bRP() {
        return this.hhw;
    }

    public void bRU() {
        if (this.hcY != null && this.hcY.getData() != null && this.hcY.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.m mVar : this.hcY.getData()) {
                if ((mVar instanceof bi) && ((bi) mVar).dqE.aKx() != 0) {
                    ((bi) mVar).dqE.aLx();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hcY.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.hcY.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.aMj != null && this.aMj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.aMj != null && this.aMj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aMj != null && this.aMj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.h)) {
                    ((com.baidu.tieba.frs.h) aVar).a(vVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.hsn != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.hsn.registerListener(this.hqv);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.hsn == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.hqt = new ArrayList();
        ArrayList<BdUniqueId> cVG = com.baidu.tieba.tbadkCore.t.cVG();
        if (cVG == null || cVG.size() <= 0) {
            return false;
        }
        int size = cVG.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends y.a> a = com.baidu.tieba.frs.c.bNL().a(this.hsn.getPageContext(), cVG.get(i), this.hsn.getUniqueId());
            if (a != null) {
                this.aMj.add(a);
                this.hqt.add(a);
            }
        }
        if (!v.isEmpty(this.hqt)) {
            bdTypeRecyclerView.addAdapters(this.hqt);
        }
        return true;
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.gyd;
    }
}
