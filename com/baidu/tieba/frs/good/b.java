package com.baidu.tieba.frs.good;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
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
import com.baidu.tieba.frs.entelechy.a.x;
import com.baidu.tieba.frs.entelechy.a.y;
import com.baidu.tieba.frs.entelechy.a.z;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private ArrayList<q> gZU;
    private BdTypeRecyclerView hEN;
    private final HashMap<Integer, bu> hJp;
    private FrsViewData hJq;
    private FrsGoodFragment hSO;
    private List<com.baidu.adp.widget.ListView.a> hTh;
    private ArrayList<q> hTi;
    private List<com.baidu.adp.widget.ListView.a> aUP = new LinkedList();
    private CustomMessageListener hHz = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                    if (aVar instanceof j) {
                        ((j) aVar).a(b.this.hSO.getPageContext(), b.this.hSO.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.aUP != null) {
                    b.this.aUP.addAll(arrayList);
                }
                if (b.this.hEN != null) {
                    b.this.hEN.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener hTj = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && w.isEmpty(b.this.hTh)) {
                b.this.b(b.this.hEN);
                b.this.b(b.this.gZU, b.this.hJq);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.hEN = bdTypeRecyclerView;
        this.hJp = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hSO = frsGoodFragment;
        this.hHz.setPriority(1);
        this.hHz.setSelfListener(true);
        this.hSO.registerListener(this.hHz);
        aa aaVar = new aa(frsGoodFragment.getTbPageContext(), bu.dLq, this.hSO.getUniqueId());
        n nVar = new n(frsGoodFragment.getTbPageContext(), bu.dLr, this.hSO.getUniqueId());
        x xVar = new x(frsGoodFragment.getTbPageContext(), bu.dLt, this.hSO.getUniqueId());
        u uVar = new u(frsGoodFragment.getTbPageContext(), bu.dLu, this.hSO.getUniqueId());
        m mVar = new m(frsGoodFragment.getTbPageContext(), bu.dLw, this.hSO.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), bu.dLx, this.hSO.getUniqueId());
        ac acVar = new ac(frsGoodFragment.getTbPageContext(), bu.dLC, this.hSO.getUniqueId());
        y yVar = new y(frsGoodFragment.getTbPageContext(), bu.dLU, this.hSO.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.w wVar = new com.baidu.tieba.frs.entelechy.a.w(frsGoodFragment.getTbPageContext(), bu.dLD, this.hSO.getUniqueId());
        t tVar = new t(frsGoodFragment.getTbPageContext(), bu.dLE, this.hSO.getUniqueId());
        ab abVar = new ab(frsGoodFragment.getPageContext(), bu.dLH, this.hSO.getUniqueId());
        r rVar = new r(frsGoodFragment.getPageContext(), bu.dLF, this.hSO.getUniqueId());
        v vVar = new v(frsGoodFragment.getPageContext(), bu.dLG, this.hSO.getUniqueId());
        ab abVar2 = new ab(frsGoodFragment.getPageContext(), bu.dLP, this.hSO.getUniqueId());
        com.baidu.tieba.frs.q qVar = new com.baidu.tieba.frs.q(frsGoodFragment.getPageContext(), com.baidu.tieba.frs.r.hCX);
        com.baidu.adp.widget.ListView.a<? extends bt, ? extends ad.a> a = e.bXl().a(frsGoodFragment.getPageContext(), this.hSO.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bu, ? extends ad.a> b = e.bXl().b(frsGoodFragment.getPageContext(), bu.dNs, this.hSO.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.q.cYS().a(this.hSO, AdvertAppInfo.dGu);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.q.cYS().a(this.hSO, AdvertAppInfo.dGD);
        z zVar = new z(frsGoodFragment.getPageContext(), bu.dLL, this.hSO.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsGoodFragment.getPageContext(), bu.dLN, this.hSO.getUniqueId());
        h hVar = new h(frsGoodFragment.getPageContext(), bu.dLM, this.hSO.getUniqueId());
        i iVar = new i(frsGoodFragment.getPageContext(), bu.dLO, this.hSO.getUniqueId());
        this.aUP.add(aaVar);
        this.aUP.add(nVar);
        this.aUP.add(xVar);
        this.aUP.add(uVar);
        this.aUP.add(mVar);
        this.aUP.add(oVar);
        this.aUP.add(yVar);
        this.aUP.add(acVar);
        this.aUP.add(wVar);
        this.aUP.add(tVar);
        this.aUP.add(abVar);
        this.aUP.add(rVar);
        this.aUP.add(rVar);
        this.aUP.add(vVar);
        this.aUP.add(qVar);
        this.aUP.add(abVar);
        this.aUP.add(abVar2);
        this.aUP.add(zVar);
        this.aUP.add(bVar);
        this.aUP.add(hVar);
        this.aUP.add(iVar);
        if (a != null) {
            this.aUP.add(a);
        }
        if (b != null) {
            this.aUP.add(b);
        }
        this.aUP.add(a2);
        this.aUP.add(a3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.hSO.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.hSO, 1);
        bVar2.setExtraData(this.aUP);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.aUP);
        Ae("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
            if (aVar instanceof com.baidu.tieba.card.z) {
                ((com.baidu.tieba.card.z) aVar).me(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
            if (aVar instanceof j) {
                ((j) aVar).release();
            }
        }
    }

    public void b(ArrayList<q> arrayList, FrsViewData frsViewData) {
        if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof com.baidu.tieba.frs.r)) {
            frsViewData.setThreadList(arrayList);
        }
        b(frsViewData);
        caq();
        as(arrayList);
        com.baidu.tieba.tbadkCore.t.t(arrayList, 1);
        ar(arrayList);
        ArrayList<q> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.hEN.setData(switchThreadDataToThreadCardInfo);
        this.hTi = switchThreadDataToThreadCardInfo;
        this.gZU = arrayList;
        this.hJq = frsViewData;
        caU();
    }

    public void refreshData() {
        this.hEN.setData(this.hTi);
        notifyDataSetChanged();
    }

    private void caq() {
        if (!w.isEmpty(this.aUP) && this.hSO != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof j) {
                    ((j) aVar).a(this.hSO.getTbPageTag());
                }
            }
        }
    }

    private void caU() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.hJq != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if ((aVar instanceof d) && (statisticMetaData = ((d) aVar).getStatisticMetaData()) != null) {
                    if (this.hJq.needLog == 1) {
                        statisticMetaData.hWM = true;
                    } else {
                        statisticMetaData.hWM = false;
                    }
                    if (this.hJq.getForum() != null) {
                        statisticMetaData.hWO = this.hJq.getForum().getId();
                    }
                    if (this.hSO != null) {
                        statisticMetaData.hWN = 5;
                    }
                }
            }
        }
    }

    private void ar(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    q qVar = arrayList.get(i2);
                    if ((qVar instanceof AdvertAppInfo) && this.hJp != null && !this.hJp.containsValue(qVar)) {
                        this.hJp.put(Integer.valueOf(i2), (bu) qVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bu> cbD() {
        return this.hJp;
    }

    public void cbI() {
        if (this.hEN != null && this.hEN.getData() != null && this.hEN.getData().size() != 0) {
            for (q qVar : this.hEN.getData()) {
                if ((qVar instanceof bt) && ((bt) qVar).dLi.aSk() != 0) {
                    ((bt) qVar).dLi.aTn();
                }
            }
        }
    }

    public void cdq() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
            if (aVar instanceof com.baidu.tieba.card.y) {
                ((com.baidu.tieba.card.y) aVar).qX(3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hEN.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.hEN.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.aUP != null && this.aUP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof j) {
                    ((j) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.aUP != null && this.aUP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof j) {
                    ((j) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.z zVar) {
        if (this.aUP != null && this.aUP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar != null && (aVar instanceof j)) {
                    ((j) aVar).a(zVar);
                }
            }
        }
    }

    private void as(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<q> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bu.dLl) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.hSO != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.hSO.registerListener(this.hTj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.hSO == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.hTh = new ArrayList();
        ArrayList<BdUniqueId> dhp = com.baidu.tieba.tbadkCore.t.dhp();
        if (dhp == null || dhp.size() <= 0) {
            return false;
        }
        int size = dhp.size();
        for (int i = 0; i < size; i++) {
            j<ICardInfo, ? extends ad.a> a = e.bXl().a(this.hSO.getPageContext(), dhp.get(i), this.hSO.getUniqueId());
            if (a != null) {
                this.aUP.add(a);
                this.hTh.add(a);
            }
        }
        if (!w.isEmpty(this.hTh)) {
            bdTypeRecyclerView.addAdapters(this.hTh);
        }
        return true;
    }

    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void Ae(String str) {
        if (this.aUP != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof f) {
                    ((f) aVar).Ae(str);
                }
            }
        }
    }

    public List<q> getDataList() {
        return this.gZU;
    }

    public List<q> cdr() {
        return this.hTi;
    }
}
