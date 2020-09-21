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
/* loaded from: classes21.dex */
public class b {
    private ArrayList<q> hzD;
    private BdTypeRecyclerView iga;
    private final HashMap<Integer, bw> ikG;
    private FrsViewData ikH;
    private List<com.baidu.adp.widget.ListView.a> iuN;
    private ArrayList<q> iuO;
    private FrsGoodFragment iuu;
    private List<com.baidu.adp.widget.ListView.a> bdV = new LinkedList();
    private CustomMessageListener iiP = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((k) aVar).a(b.this.iuu.getPageContext(), b.this.iuu.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.bdV != null) {
                    b.this.bdV.addAll(arrayList);
                }
                if (b.this.iga != null) {
                    b.this.iga.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener iuP = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && y.isEmpty(b.this.iuN)) {
                b.this.b(b.this.iga);
                b.this.b(b.this.hzD, b.this.ikH);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.iga = bdTypeRecyclerView;
        this.ikG = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iuu = frsGoodFragment;
        this.iiP.setPriority(1);
        this.iiP.setSelfListener(true);
        this.iuu.registerListener(this.iiP);
        aa aaVar = new aa(frsGoodFragment.getTbPageContext(), bw.edl, this.iuu.getUniqueId());
        n nVar = new n(frsGoodFragment.getTbPageContext(), bw.edm, this.iuu.getUniqueId());
        x xVar = new x(frsGoodFragment.getTbPageContext(), bw.edo, this.iuu.getUniqueId());
        u uVar = new u(frsGoodFragment.getTbPageContext(), bw.edp, this.iuu.getUniqueId());
        m mVar = new m(frsGoodFragment.getTbPageContext(), bw.edr, this.iuu.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), bw.eds, this.iuu.getUniqueId());
        ac acVar = new ac(frsGoodFragment.getTbPageContext(), bw.edx, this.iuu.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.y yVar = new com.baidu.tieba.frs.entelechy.a.y(frsGoodFragment.getTbPageContext(), bw.edP, this.iuu.getUniqueId());
        w wVar = new w(frsGoodFragment.getTbPageContext(), bw.edy, this.iuu.getUniqueId());
        t tVar = new t(frsGoodFragment.getTbPageContext(), bw.edz, this.iuu.getUniqueId());
        ab abVar = new ab(frsGoodFragment.getPageContext(), bw.edC, this.iuu.getUniqueId());
        r rVar = new r(frsGoodFragment.getPageContext(), bw.edA, this.iuu.getUniqueId());
        v vVar = new v(frsGoodFragment.getPageContext(), bw.edB, this.iuu.getUniqueId());
        ab abVar2 = new ab(frsGoodFragment.getPageContext(), bw.edK, this.iuu.getUniqueId());
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsGoodFragment.getPageContext(), s.idu);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends af.a> a = e.cop().a(frsGoodFragment.getPageContext(), this.iuu.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> b = e.cop().b(frsGoodFragment.getPageContext(), bw.efn, this.iuu.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.dqU().a(this.iuu, AdvertAppInfo.dYc);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dqU().a(this.iuu, AdvertAppInfo.dYl);
        z zVar = new z(frsGoodFragment.getPageContext(), bw.edG, this.iuu.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsGoodFragment.getPageContext(), bw.edI, this.iuu.getUniqueId());
        h hVar = new h(frsGoodFragment.getPageContext(), bw.edH, this.iuu.getUniqueId());
        i iVar = new i(frsGoodFragment.getPageContext(), bw.edJ, this.iuu.getUniqueId());
        this.bdV.add(aaVar);
        this.bdV.add(nVar);
        this.bdV.add(xVar);
        this.bdV.add(uVar);
        this.bdV.add(mVar);
        this.bdV.add(oVar);
        this.bdV.add(yVar);
        this.bdV.add(acVar);
        this.bdV.add(wVar);
        this.bdV.add(tVar);
        this.bdV.add(abVar);
        this.bdV.add(rVar);
        this.bdV.add(rVar);
        this.bdV.add(vVar);
        this.bdV.add(rVar2);
        this.bdV.add(abVar);
        this.bdV.add(abVar2);
        this.bdV.add(zVar);
        this.bdV.add(bVar);
        this.bdV.add(hVar);
        this.bdV.add(iVar);
        if (a != null) {
            this.bdV.add(a);
        }
        if (b != null) {
            this.bdV.add(b);
        }
        this.bdV.add(a2);
        this.bdV.add(a3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.iuu.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.iuu, 1);
        bVar2.setExtraData(this.bdV);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.bdV);
        DH("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
            if (aVar instanceof com.baidu.tieba.card.z) {
                ((com.baidu.tieba.card.z) aVar).nu(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
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
        crH();
        aB(arrayList);
        com.baidu.tieba.tbadkCore.u.u(arrayList, 1);
        aA(arrayList);
        ArrayList<q> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.iga.setData(switchThreadDataToThreadCardInfo);
        this.iuO = switchThreadDataToThreadCardInfo;
        this.hzD = arrayList;
        this.ikH = frsViewData;
        csl();
    }

    public void refreshData() {
        this.iga.setData(this.iuO);
        notifyDataSetChanged();
    }

    private void crH() {
        if (!y.isEmpty(this.bdV) && this.iuu != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.iuu.getTbPageTag());
                }
            }
        }
    }

    private void csl() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.ikH != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if ((aVar instanceof d) && (statisticMetaData = ((d) aVar).getStatisticMetaData()) != null) {
                    if (this.ikH.needLog == 1) {
                        statisticMetaData.iyp = true;
                    } else {
                        statisticMetaData.iyp = false;
                    }
                    if (this.ikH.getForum() != null) {
                        statisticMetaData.iyr = this.ikH.getForum().getId();
                    }
                    if (this.iuu != null) {
                        statisticMetaData.iyq = 5;
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
                    if ((qVar instanceof AdvertAppInfo) && this.ikG != null && !this.ikG.containsValue(qVar)) {
                        this.ikG.put(Integer.valueOf(i2), (bw) qVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bw> csV() {
        return this.ikG;
    }

    public void cta() {
        if (this.iga != null && this.iga.getData() != null && this.iga.getData().size() != 0) {
            for (q qVar : this.iga.getData()) {
                if ((qVar instanceof bv) && ((bv) qVar).dXg.bft() != 0) {
                    ((bv) qVar).dXg.bgw();
                }
            }
        }
    }

    public void cuL() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
            if (aVar instanceof com.baidu.tieba.card.y) {
                ((com.baidu.tieba.card.y) aVar).tS(3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iga.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.iga.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.bdV != null && this.bdV.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof k) {
                    ((k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.bdV != null && this.bdV.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof k) {
                    ((k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.bdV != null && this.bdV.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
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
                if (it.next().getType() == bw.edf) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.iuu != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.iuu.registerListener(this.iuP);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.iuu == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.iuN = new ArrayList();
        ArrayList<BdUniqueId> dzU = com.baidu.tieba.tbadkCore.u.dzU();
        if (dzU == null || dzU.size() <= 0) {
            return false;
        }
        int size = dzU.size();
        for (int i = 0; i < size; i++) {
            k<ICardInfo, ? extends af.a> a = e.cop().a(this.iuu.getPageContext(), dzU.get(i), this.iuu.getUniqueId());
            if (a != null) {
                this.bdV.add(a);
                this.iuN.add(a);
            }
        }
        if (!y.isEmpty(this.iuN)) {
            bdTypeRecyclerView.addAdapters(this.iuN);
        }
        return true;
    }

    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void DH(String str) {
        if (this.bdV != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof f) {
                    ((f) aVar).DH(str);
                }
            }
        }
    }

    public List<q> getDataList() {
        return this.hzD;
    }

    public List<q> cuM() {
        return this.iuO;
    }
}
