package com.baidu.tieba.frs.good;

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
import com.baidu.tieba.a.f;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.d.d;
import com.baidu.tieba.frs.e;
import com.baidu.tieba.frs.entelechy.a.aa;
import com.baidu.tieba.frs.entelechy.a.ab;
import com.baidu.tieba.frs.entelechy.a.ac;
import com.baidu.tieba.frs.entelechy.a.h;
import com.baidu.tieba.frs.entelechy.a.i;
import com.baidu.tieba.frs.entelechy.a.m;
import com.baidu.tieba.frs.entelechy.a.n;
import com.baidu.tieba.frs.entelechy.a.o;
import com.baidu.tieba.frs.entelechy.a.r;
import com.baidu.tieba.frs.entelechy.a.t;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.entelechy.a.v;
import com.baidu.tieba.frs.entelechy.a.w;
import com.baidu.tieba.frs.entelechy.a.x;
import com.baidu.tieba.frs.entelechy.a.z;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private ArrayList<q> hOy;
    private List<com.baidu.adp.widget.ListView.a> iJG;
    private ArrayList<q> iJH;
    private FrsGoodFragment iJn;
    private BdTypeRecyclerView iuX;
    private final HashMap<Integer, bw> izD;
    private FrsViewData izE;
    private List<com.baidu.adp.widget.ListView.a> bhH = new LinkedList();
    private CustomMessageListener ixM = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).a(b.this.iJn.getPageContext(), b.this.iJn.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.bhH != null) {
                    b.this.bhH.addAll(arrayList);
                }
                if (b.this.iuX != null) {
                    b.this.iuX.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener iJI = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && y.isEmpty(b.this.iJG)) {
                b.this.b(b.this.iuX);
                b.this.b(b.this.hOy, b.this.izE);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.iuX = bdTypeRecyclerView;
        this.izD = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iJn = frsGoodFragment;
        this.ixM.setPriority(1);
        this.ixM.setSelfListener(true);
        this.iJn.registerListener(this.ixM);
        aa aaVar = new aa(frsGoodFragment.getTbPageContext(), bw.epq, this.iJn.getUniqueId());
        n nVar = new n(frsGoodFragment.getTbPageContext(), bw.epr, this.iJn.getUniqueId());
        x xVar = new x(frsGoodFragment.getTbPageContext(), bw.ept, this.iJn.getUniqueId());
        u uVar = new u(frsGoodFragment.getTbPageContext(), bw.epu, this.iJn.getUniqueId());
        m mVar = new m(frsGoodFragment.getTbPageContext(), bw.epw, this.iJn.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), bw.epx, this.iJn.getUniqueId());
        ac acVar = new ac(frsGoodFragment.getTbPageContext(), bw.epC, this.iJn.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.y yVar = new com.baidu.tieba.frs.entelechy.a.y(frsGoodFragment.getTbPageContext(), bw.epU, this.iJn.getUniqueId());
        w wVar = new w(frsGoodFragment.getTbPageContext(), bw.epD, this.iJn.getUniqueId());
        t tVar = new t(frsGoodFragment.getTbPageContext(), bw.epE, this.iJn.getUniqueId());
        ab abVar = new ab(frsGoodFragment.getPageContext(), bw.epH, this.iJn.getUniqueId());
        r rVar = new r(frsGoodFragment.getPageContext(), bw.epF, this.iJn.getUniqueId());
        v vVar = new v(frsGoodFragment.getPageContext(), bw.epG, this.iJn.getUniqueId());
        ab abVar2 = new ab(frsGoodFragment.getPageContext(), bw.epP, this.iJn.getUniqueId());
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsGoodFragment.getPageContext(), s.iss);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends af.a> a2 = e.crN().a(frsGoodFragment.getPageContext(), this.iJn.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> b = e.crN().b(frsGoodFragment.getPageContext(), bw.ert, this.iJn.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.duF().a(this.iJn, AdvertAppInfo.eke);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.r.duF().a(this.iJn, AdvertAppInfo.ekn);
        z zVar = new z(frsGoodFragment.getPageContext(), bw.epL, this.iJn.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsGoodFragment.getPageContext(), bw.epN, this.iJn.getUniqueId());
        h hVar = new h(frsGoodFragment.getPageContext(), bw.epM, this.iJn.getUniqueId());
        i iVar = new i(frsGoodFragment.getPageContext(), bw.epO, this.iJn.getUniqueId());
        this.bhH.add(aaVar);
        this.bhH.add(nVar);
        this.bhH.add(xVar);
        this.bhH.add(uVar);
        this.bhH.add(mVar);
        this.bhH.add(oVar);
        this.bhH.add(yVar);
        this.bhH.add(acVar);
        this.bhH.add(wVar);
        this.bhH.add(tVar);
        this.bhH.add(abVar);
        this.bhH.add(rVar);
        this.bhH.add(rVar);
        this.bhH.add(vVar);
        this.bhH.add(rVar2);
        this.bhH.add(abVar);
        this.bhH.add(abVar2);
        this.bhH.add(zVar);
        this.bhH.add(bVar);
        this.bhH.add(hVar);
        this.bhH.add(iVar);
        if (a2 != null) {
            this.bhH.add(a2);
        }
        if (b != null) {
            this.bhH.add(b);
        }
        this.bhH.add(a3);
        this.bhH.add(a4);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.iJn.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.iJn, 1);
        bVar2.setExtraData(this.bhH);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.bhH);
        Es("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
            if (aVar instanceof com.baidu.tieba.card.z) {
                ((com.baidu.tieba.card.z) aVar).nZ(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
            if (aVar instanceof k) {
                ((k) aVar).release();
            }
        }
    }

    public void b(ArrayList<q> arrayList, FrsViewData frsViewData) {
        if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof s)) {
            frsViewData.setThreadList(arrayList);
        }
        b(frsViewData);
        cvf();
        aB(arrayList);
        com.baidu.tieba.tbadkCore.u.w(arrayList, 1);
        aA(arrayList);
        ArrayList<q> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.iuX.setData(switchThreadDataToThreadCardInfo);
        this.iJH = switchThreadDataToThreadCardInfo;
        this.hOy = arrayList;
        this.izE = frsViewData;
        cvI();
    }

    public void refreshData() {
        this.iuX.setData(this.iJH);
        notifyDataSetChanged();
    }

    private void cvf() {
        if (!y.isEmpty(this.bhH) && this.iJn != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.iJn.getTbPageTag());
                }
            }
        }
    }

    private void cvI() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.izE != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if ((aVar instanceof d) && (statisticMetaData = ((d) aVar).getStatisticMetaData()) != null) {
                    if (this.izE.needLog == 1) {
                        statisticMetaData.iNi = true;
                    } else {
                        statisticMetaData.iNi = false;
                    }
                    if (this.izE.getForum() != null) {
                        statisticMetaData.iNk = this.izE.getForum().getId();
                    }
                    if (this.iJn != null) {
                        statisticMetaData.iNj = 5;
                    }
                }
            }
        }
    }

    private void aA(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    q qVar = arrayList.get(i2);
                    if ((qVar instanceof AdvertAppInfo) && this.izD != null && !this.izD.containsValue(qVar)) {
                        this.izD.put(Integer.valueOf(i2), (bw) qVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bw> cws() {
        return this.izD;
    }

    public void cwx() {
        if (this.iuX != null && this.iuX.getData() != null && this.iuX.getData().size() != 0) {
            for (q qVar : this.iuX.getData()) {
                if ((qVar instanceof bv) && ((bv) qVar).eji.bic() != 0) {
                    ((bv) qVar).eji.bjf();
                }
            }
        }
    }

    public void cyi() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
            if (aVar instanceof com.baidu.tieba.card.y) {
                ((com.baidu.tieba.card.y) aVar).ux(3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iuX.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.iuX.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.bhH != null && this.bhH.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar instanceof k) {
                    ((k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.bhH != null && this.bhH.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar instanceof k) {
                    ((k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.bhH != null && this.bhH.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar != null && (aVar instanceof k)) {
                    ((k) aVar).a(abVar);
                }
            }
        }
    }

    private void aB(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<q> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bw.epk) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.iJn != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.iJn.registerListener(this.iJI);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.iJn == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.iJG = new ArrayList();
        ArrayList<BdUniqueId> dDG = com.baidu.tieba.tbadkCore.u.dDG();
        if (dDG == null || dDG.size() <= 0) {
            return false;
        }
        int size = dDG.size();
        for (int i = 0; i < size; i++) {
            k<ICardInfo, ? extends af.a> a2 = e.crN().a(this.iJn.getPageContext(), dDG.get(i), this.iJn.getUniqueId());
            if (a2 != null) {
                this.bhH.add(a2);
                this.iJG.add(a2);
            }
        }
        if (!y.isEmpty(this.iJG)) {
            bdTypeRecyclerView.addAdapters(this.iJG);
        }
        return true;
    }

    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void Es(String str) {
        if (this.bhH != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar instanceof f) {
                    ((f) aVar).Es(str);
                }
            }
        }
    }

    public List<q> getDataList() {
        return this.hOy;
    }

    public List<q> cyj() {
        return this.iJH;
    }
}
