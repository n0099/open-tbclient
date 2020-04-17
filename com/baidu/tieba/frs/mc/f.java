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
    private ArrayList<com.baidu.adp.widget.ListView.m> gxX;
    private BdTypeRecyclerView hcS;
    private final HashMap<Integer, bj> hhq;
    private FrsViewData hhr;
    private List<com.baidu.adp.widget.ListView.a> hqn;
    private FrsNewAreaFragment hsh;
    private List<com.baidu.adp.widget.ListView.a> aMd = new LinkedList();
    private CustomMessageListener hqp = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.isEmpty(f.this.hqn)) {
                f.this.b(f.this.hcS);
                f.this.b(f.this.gxX, f.this.hhr);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.hcS = bdTypeRecyclerView;
        this.hhq = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v10, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hsh = frsNewAreaFragment;
        y yVar = new y(frsNewAreaFragment.getTbPageContext(), bj.dqI, this.hsh.getUniqueId());
        yVar.b((r) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.n nVar = new com.baidu.tieba.frs.entelechy.a.n(frsNewAreaFragment.getTbPageContext(), bj.dqJ, this.hsh.getUniqueId());
        nVar.b((r) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsNewAreaFragment.getTbPageContext(), bj.dqL, this.hsh.getUniqueId());
        vVar.b((r) bdTypeRecyclerView);
        t tVar = new t(frsNewAreaFragment.getTbPageContext(), bj.dqM, this.hsh.getUniqueId());
        tVar.b((r) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bj.dqO, this.hsh.getUniqueId());
        mVar.b((r) bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), bj.dqP, this.hsh.getUniqueId());
        oVar.b((r) bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.getTbPageContext(), bj.dri, this.hsh.getUniqueId());
        wVar.b((r) bdTypeRecyclerView);
        z zVar = new z(frsNewAreaFragment.getPageContext(), bj.dqV, this.hsh.getUniqueId());
        zVar.b((r) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.r rVar = new com.baidu.tieba.frs.entelechy.a.r(frsNewAreaFragment.getPageContext(), bj.dqT, this.hsh.getUniqueId());
        rVar.b((r) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsNewAreaFragment.getPageContext(), bj.drb, this.hsh.getUniqueId());
        bVar.b((r) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getPageContext(), bj.dra, this.hsh.getUniqueId());
        hVar.b((r) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.i iVar = new com.baidu.tieba.frs.entelechy.a.i(frsNewAreaFragment.getPageContext(), bj.drc, this.hsh.getUniqueId());
        iVar.b((r) bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.getPageContext(), bj.dqU, this.hsh.getUniqueId());
        uVar.b((r) bdTypeRecyclerView);
        z zVar2 = new z(frsNewAreaFragment.getPageContext(), bj.drd, this.hsh.getUniqueId());
        zVar2.b((r) bdTypeRecyclerView);
        com.baidu.tieba.frs.o oVar2 = new com.baidu.tieba.frs.o(frsNewAreaFragment.getPageContext(), p.hbj);
        oVar2.b((r) bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends y.a> a = com.baidu.tieba.frs.c.bNN().a(frsNewAreaFragment.getPageContext(), this.hsh.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends y.a> b = com.baidu.tieba.frs.c.bNN().b(frsNewAreaFragment.getPageContext(), bj.dsJ, this.hsh.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = q.cNo().a(this.hsh, AdvertAppInfo.dlX);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = q.cNo().a(this.hsh, AdvertAppInfo.dmg);
        x xVar = new x(frsNewAreaFragment.getPageContext(), bj.dqZ, this.hsh.getUniqueId());
        xVar.b((r) bdTypeRecyclerView);
        this.aMd.add(yVar);
        this.aMd.add(nVar);
        this.aMd.add(vVar);
        this.aMd.add(tVar);
        this.aMd.add(mVar);
        this.aMd.add(oVar);
        this.aMd.add(wVar);
        this.aMd.add(zVar);
        this.aMd.add(rVar);
        this.aMd.add(bVar);
        this.aMd.add(hVar);
        this.aMd.add(iVar);
        this.aMd.add(uVar);
        this.aMd.add(oVar2);
        this.aMd.add(zVar);
        this.aMd.add(zVar2);
        this.aMd.add(xVar);
        if (a != null) {
            this.aMd.add(a);
        }
        if (b != null) {
            this.aMd.add(b);
        }
        this.aMd.add(a2);
        this.aMd.add(a3);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.hsh.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.hsh.getPageContext(), this.hsh.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.aMd != null) {
                this.aMd.addAll(arrayList);
            }
        }
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.hsh, 1);
        bVar2.setExtraData(this.aMd);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.aMd);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    public void b(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        bQI();
        com.baidu.tieba.tbadkCore.t.q(arrayList, 1);
        ar(arrayList);
        this.hcS.setData(arrayList);
        this.gxX = arrayList;
        this.hhr = frsViewData;
        bRm();
    }

    public void refreshData() {
        this.hcS.setData(this.gxX);
        notifyDataSetChanged();
    }

    private void bQI() {
        if (!v.isEmpty(this.aMd) && this.hsh != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.hsh.getTbPageTag());
                }
            }
        }
    }

    private void bRm() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.hhr != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.hhr.needLog == 1) {
                        statisticMetaData.htU = true;
                    } else {
                        statisticMetaData.htU = false;
                    }
                    if (this.hhr.getForum() != null) {
                        statisticMetaData.htW = this.hhr.getForum().getId();
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
                    if ((mVar instanceof AdvertAppInfo) && this.hhq != null && !this.hhq.containsValue(mVar)) {
                        this.hhq.put(Integer.valueOf(i2), (bj) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bj> bRR() {
        return this.hhq;
    }

    public void bRW() {
        if (this.hcS != null && this.hcS.getData() != null && this.hcS.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.m mVar : this.hcS.getData()) {
                if ((mVar instanceof bi) && ((bi) mVar).dqA.aKz() != 0) {
                    ((bi) mVar).dqA.aLz();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hcS.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.hcS.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.aMd != null && this.aMd.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.aMd != null && this.aMd.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aMd != null && this.aMd.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.h)) {
                    ((com.baidu.tieba.frs.h) aVar).a(vVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.hsh != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.hsh.registerListener(this.hqp);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.hsh == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.hqn = new ArrayList();
        ArrayList<BdUniqueId> cVJ = com.baidu.tieba.tbadkCore.t.cVJ();
        if (cVJ == null || cVJ.size() <= 0) {
            return false;
        }
        int size = cVJ.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends y.a> a = com.baidu.tieba.frs.c.bNN().a(this.hsh.getPageContext(), cVJ.get(i), this.hsh.getUniqueId());
            if (a != null) {
                this.aMd.add(a);
                this.hqn.add(a);
            }
        }
        if (!v.isEmpty(this.hqn)) {
            bdTypeRecyclerView.addAdapters(this.hqn);
        }
        return true;
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.gxX;
    }
}
