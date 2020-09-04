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
    private BdTypeRecyclerView hYW;
    private ArrayList<q> hsy;
    private final HashMap<Integer, bw> idG;
    private FrsViewData idH;
    private List<com.baidu.adp.widget.ListView.a> inx;
    private FrsNewAreaFragment ipo;
    private List<com.baidu.adp.widget.ListView.a> bbw = new LinkedList();
    private CustomMessageListener inz = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && y.isEmpty(f.this.inx)) {
                f.this.b(f.this.hYW);
                f.this.b(f.this.hsy, f.this.idH);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.hYW = bdTypeRecyclerView;
        this.idG = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v10, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.ipo = frsNewAreaFragment;
        aa aaVar = new aa(frsNewAreaFragment.getTbPageContext(), bw.ebb, this.ipo.getUniqueId());
        aaVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.n nVar = new com.baidu.tieba.frs.entelechy.a.n(frsNewAreaFragment.getTbPageContext(), bw.ebc, this.ipo.getUniqueId());
        nVar.b((v) bdTypeRecyclerView);
        x xVar = new x(frsNewAreaFragment.getTbPageContext(), bw.ebe, this.ipo.getUniqueId());
        xVar.b((v) bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.getTbPageContext(), bw.ebf, this.ipo.getUniqueId());
        uVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bw.ebh, this.ipo.getUniqueId());
        mVar.b((v) bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.getTbPageContext(), bw.ebi, this.ipo.getUniqueId());
        oVar.b((v) bdTypeRecyclerView);
        ac acVar = new ac(frsNewAreaFragment.getTbPageContext(), bw.ebn, this.ipo.getUniqueId());
        acVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.y yVar = new com.baidu.tieba.frs.entelechy.a.y(frsNewAreaFragment.getTbPageContext(), bw.ebF, this.ipo.getUniqueId());
        yVar.b((v) bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.getTbPageContext(), bw.ebo, this.ipo.getUniqueId());
        t tVar = new t(frsNewAreaFragment.getTbPageContext(), bw.ebp, this.ipo.getUniqueId());
        ab abVar = new ab(frsNewAreaFragment.getPageContext(), bw.ebs, this.ipo.getUniqueId());
        abVar.b((v) bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getPageContext(), bw.ebq, this.ipo.getUniqueId());
        rVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsNewAreaFragment.getPageContext(), bw.eby, this.ipo.getUniqueId());
        bVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getPageContext(), bw.ebx, this.ipo.getUniqueId());
        hVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.i iVar = new com.baidu.tieba.frs.entelechy.a.i(frsNewAreaFragment.getPageContext(), bw.ebz, this.ipo.getUniqueId());
        iVar.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsNewAreaFragment.getPageContext(), bw.ebr, this.ipo.getUniqueId());
        vVar.b((v) bdTypeRecyclerView);
        ab abVar2 = new ab(frsNewAreaFragment.getPageContext(), bw.ebA, this.ipo.getUniqueId());
        abVar2.b((v) bdTypeRecyclerView);
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsNewAreaFragment.getPageContext(), s.hWr);
        rVar2.b((v) bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends af.a> a = com.baidu.tieba.frs.e.clc().a(frsNewAreaFragment.getPageContext(), this.ipo.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> b = com.baidu.tieba.frs.e.clc().b(frsNewAreaFragment.getPageContext(), bw.edd, this.ipo.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.dnk().a(this.ipo, AdvertAppInfo.dVS);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dnk().a(this.ipo, AdvertAppInfo.dWb);
        z zVar = new z(frsNewAreaFragment.getPageContext(), bw.ebw, this.ipo.getUniqueId());
        zVar.b((v) bdTypeRecyclerView);
        this.bbw.add(aaVar);
        this.bbw.add(nVar);
        this.bbw.add(xVar);
        this.bbw.add(uVar);
        this.bbw.add(mVar);
        this.bbw.add(oVar);
        this.bbw.add(yVar);
        this.bbw.add(acVar);
        this.bbw.add(wVar);
        this.bbw.add(tVar);
        this.bbw.add(abVar);
        this.bbw.add(rVar);
        this.bbw.add(bVar);
        this.bbw.add(hVar);
        this.bbw.add(iVar);
        this.bbw.add(vVar);
        this.bbw.add(rVar2);
        this.bbw.add(abVar);
        this.bbw.add(abVar2);
        this.bbw.add(zVar);
        if (a != null) {
            this.bbw.add(a);
        }
        if (b != null) {
            this.bbw.add(b);
        }
        this.bbw.add(a2);
        this.bbw.add(a3);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.ipo.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.ipo.getPageContext(), this.ipo.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bbw != null) {
                this.bbw.addAll(arrayList);
            }
        }
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.ipo, 1);
        bVar2.setExtraData(this.bbw);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.bbw);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    public void b(ArrayList<q> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cou();
        com.baidu.tieba.tbadkCore.u.u(arrayList, 1);
        ay(arrayList);
        this.hYW.setData(arrayList);
        this.hsy = arrayList;
        this.idH = frsViewData;
        coY();
    }

    public void refreshData() {
        this.hYW.setData(this.hsy);
        notifyDataSetChanged();
    }

    private void cou() {
        if (!y.isEmpty(this.bbw) && this.ipo != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.ipo.getTbPageTag());
                }
            }
        }
    }

    private void coY() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.idH != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.idH.needLog == 1) {
                        statisticMetaData.iqZ = true;
                    } else {
                        statisticMetaData.iqZ = false;
                    }
                    if (this.idH.getForum() != null) {
                        statisticMetaData.irb = this.idH.getForum().getId();
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
                    if ((qVar instanceof AdvertAppInfo) && this.idG != null && !this.idG.containsValue(qVar)) {
                        this.idG.put(Integer.valueOf(i2), (bw) qVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bw> cpI() {
        return this.idG;
    }

    public void cpN() {
        if (this.hYW != null && this.hYW.getData() != null && this.hYW.getData().size() != 0) {
            for (q qVar : this.hYW.getData()) {
                if ((qVar instanceof bv) && ((bv) qVar).dUW.bez() != 0) {
                    ((bv) qVar).dUW.bfC();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hYW.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.hYW.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.bbw != null && this.bbw.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.bbw != null && this.bbw.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.bbw != null && this.bbw.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.k)) {
                    ((com.baidu.tieba.frs.k) aVar).a(abVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.ipo != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.ipo.registerListener(this.inz);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.ipo == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.inx = new ArrayList();
        ArrayList<BdUniqueId> dwb = com.baidu.tieba.tbadkCore.u.dwb();
        if (dwb == null || dwb.size() <= 0) {
            return false;
        }
        int size = dwb.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.k<ICardInfo, ? extends af.a> a = com.baidu.tieba.frs.e.clc().a(this.ipo.getPageContext(), dwb.get(i), this.ipo.getUniqueId());
            if (a != null) {
                this.bbw.add(a);
                this.inx.add(a);
            }
        }
        if (!y.isEmpty(this.inx)) {
            bdTypeRecyclerView.addAdapters(this.inx);
        }
        return true;
    }

    public List<q> getDataList() {
        return this.hsy;
    }
}
