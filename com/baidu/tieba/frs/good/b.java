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
/* loaded from: classes16.dex */
public class b {
    private BdTypeRecyclerView hYQ;
    private ArrayList<q> hss;
    private final HashMap<Integer, bw> idA;
    private FrsViewData idB;
    private FrsGoodFragment imX;
    private List<com.baidu.adp.widget.ListView.a> inq;
    private ArrayList<q> inr;
    private List<com.baidu.adp.widget.ListView.a> bbu = new LinkedList();
    private CustomMessageListener ibF = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((k) aVar).a(b.this.imX.getPageContext(), b.this.imX.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.bbu != null) {
                    b.this.bbu.addAll(arrayList);
                }
                if (b.this.hYQ != null) {
                    b.this.hYQ.addAdapters(arrayList);
                }
            }
        }
    };

    /* renamed from: int  reason: not valid java name */
    private CustomMessageListener f3int = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && y.isEmpty(b.this.inq)) {
                b.this.b(b.this.hYQ);
                b.this.b(b.this.hss, b.this.idB);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.hYQ = bdTypeRecyclerView;
        this.idA = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.imX = frsGoodFragment;
        this.ibF.setPriority(1);
        this.ibF.setSelfListener(true);
        this.imX.registerListener(this.ibF);
        aa aaVar = new aa(frsGoodFragment.getTbPageContext(), bw.eaX, this.imX.getUniqueId());
        n nVar = new n(frsGoodFragment.getTbPageContext(), bw.eaY, this.imX.getUniqueId());
        x xVar = new x(frsGoodFragment.getTbPageContext(), bw.eba, this.imX.getUniqueId());
        u uVar = new u(frsGoodFragment.getTbPageContext(), bw.ebb, this.imX.getUniqueId());
        m mVar = new m(frsGoodFragment.getTbPageContext(), bw.ebd, this.imX.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), bw.ebe, this.imX.getUniqueId());
        ac acVar = new ac(frsGoodFragment.getTbPageContext(), bw.ebj, this.imX.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.y yVar = new com.baidu.tieba.frs.entelechy.a.y(frsGoodFragment.getTbPageContext(), bw.ebB, this.imX.getUniqueId());
        w wVar = new w(frsGoodFragment.getTbPageContext(), bw.ebk, this.imX.getUniqueId());
        t tVar = new t(frsGoodFragment.getTbPageContext(), bw.ebl, this.imX.getUniqueId());
        ab abVar = new ab(frsGoodFragment.getPageContext(), bw.ebo, this.imX.getUniqueId());
        r rVar = new r(frsGoodFragment.getPageContext(), bw.ebm, this.imX.getUniqueId());
        v vVar = new v(frsGoodFragment.getPageContext(), bw.ebn, this.imX.getUniqueId());
        ab abVar2 = new ab(frsGoodFragment.getPageContext(), bw.ebw, this.imX.getUniqueId());
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsGoodFragment.getPageContext(), s.hWl);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends af.a> a = e.clb().a(frsGoodFragment.getPageContext(), this.imX.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> b = e.clb().b(frsGoodFragment.getPageContext(), bw.ecZ, this.imX.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.dnh().a(this.imX, AdvertAppInfo.dVO);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dnh().a(this.imX, AdvertAppInfo.dVX);
        z zVar = new z(frsGoodFragment.getPageContext(), bw.ebs, this.imX.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsGoodFragment.getPageContext(), bw.ebu, this.imX.getUniqueId());
        h hVar = new h(frsGoodFragment.getPageContext(), bw.ebt, this.imX.getUniqueId());
        i iVar = new i(frsGoodFragment.getPageContext(), bw.ebv, this.imX.getUniqueId());
        this.bbu.add(aaVar);
        this.bbu.add(nVar);
        this.bbu.add(xVar);
        this.bbu.add(uVar);
        this.bbu.add(mVar);
        this.bbu.add(oVar);
        this.bbu.add(yVar);
        this.bbu.add(acVar);
        this.bbu.add(wVar);
        this.bbu.add(tVar);
        this.bbu.add(abVar);
        this.bbu.add(rVar);
        this.bbu.add(rVar);
        this.bbu.add(vVar);
        this.bbu.add(rVar2);
        this.bbu.add(abVar);
        this.bbu.add(abVar2);
        this.bbu.add(zVar);
        this.bbu.add(bVar);
        this.bbu.add(hVar);
        this.bbu.add(iVar);
        if (a != null) {
            this.bbu.add(a);
        }
        if (b != null) {
            this.bbu.add(b);
        }
        this.bbu.add(a2);
        this.bbu.add(a3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.imX.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.imX, 1);
        bVar2.setExtraData(this.bbu);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.bbu);
        Dj("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
            if (aVar instanceof com.baidu.tieba.card.z) {
                ((com.baidu.tieba.card.z) aVar).nm(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
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
        cot();
        az(arrayList);
        com.baidu.tieba.tbadkCore.u.u(arrayList, 1);
        ay(arrayList);
        ArrayList<q> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.hYQ.setData(switchThreadDataToThreadCardInfo);
        this.inr = switchThreadDataToThreadCardInfo;
        this.hss = arrayList;
        this.idB = frsViewData;
        coX();
    }

    public void refreshData() {
        this.hYQ.setData(this.inr);
        notifyDataSetChanged();
    }

    private void cot() {
        if (!y.isEmpty(this.bbu) && this.imX != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.imX.getTbPageTag());
                }
            }
        }
    }

    private void coX() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.idB != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if ((aVar instanceof d) && (statisticMetaData = ((d) aVar).getStatisticMetaData()) != null) {
                    if (this.idB.needLog == 1) {
                        statisticMetaData.iqT = true;
                    } else {
                        statisticMetaData.iqT = false;
                    }
                    if (this.idB.getForum() != null) {
                        statisticMetaData.iqV = this.idB.getForum().getId();
                    }
                    if (this.imX != null) {
                        statisticMetaData.iqU = 5;
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
                    if ((qVar instanceof AdvertAppInfo) && this.idA != null && !this.idA.containsValue(qVar)) {
                        this.idA.put(Integer.valueOf(i2), (bw) qVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bw> cpH() {
        return this.idA;
    }

    public void cpM() {
        if (this.hYQ != null && this.hYQ.getData() != null && this.hYQ.getData().size() != 0) {
            for (q qVar : this.hYQ.getData()) {
                if ((qVar instanceof bv) && ((bv) qVar).dUS.bez() != 0) {
                    ((bv) qVar).dUS.bfC();
                }
            }
        }
    }

    public void crv() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
            if (aVar instanceof com.baidu.tieba.card.y) {
                ((com.baidu.tieba.card.y) aVar).tz(3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hYQ.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.hYQ.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.bbu != null && this.bbu.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof k) {
                    ((k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.bbu != null && this.bbu.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof k) {
                    ((k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.bbu != null && this.bbu.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar != null && (aVar instanceof k)) {
                    ((k) aVar).a(abVar);
                }
            }
        }
    }

    private void az(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<q> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bw.eaR) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.imX != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.imX.registerListener(this.f3int);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.imX == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.inq = new ArrayList();
        ArrayList<BdUniqueId> dvW = com.baidu.tieba.tbadkCore.u.dvW();
        if (dvW == null || dvW.size() <= 0) {
            return false;
        }
        int size = dvW.size();
        for (int i = 0; i < size; i++) {
            k<ICardInfo, ? extends af.a> a = e.clb().a(this.imX.getPageContext(), dvW.get(i), this.imX.getUniqueId());
            if (a != null) {
                this.bbu.add(a);
                this.inq.add(a);
            }
        }
        if (!y.isEmpty(this.inq)) {
            bdTypeRecyclerView.addAdapters(this.inq);
        }
        return true;
    }

    public boolean s(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void Dj(String str) {
        if (this.bbu != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof f) {
                    ((f) aVar).Dj(str);
                }
            }
        }
    }

    public List<q> getDataList() {
        return this.hss;
    }

    public List<q> crw() {
        return this.inr;
    }
}
