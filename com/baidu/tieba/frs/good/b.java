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
    private BdTypeRecyclerView iHt;
    private final HashMap<Integer, bw> iLZ;
    private FrsViewData iMa;
    private FrsGoodFragment iVJ;
    private List<com.baidu.adp.widget.ListView.a> iWc;
    private ArrayList<q> iWd;
    private ArrayList<q> iaV;
    private List<com.baidu.adp.widget.ListView.a> bje = new LinkedList();
    private CustomMessageListener iKi = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((k) aVar).a(b.this.iVJ.getPageContext(), b.this.iVJ.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.bje != null) {
                    b.this.bje.addAll(arrayList);
                }
                if (b.this.iHt != null) {
                    b.this.iHt.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener iWe = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && y.isEmpty(b.this.iWc)) {
                b.this.b(b.this.iHt);
                b.this.b(b.this.iaV, b.this.iMa);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.iHt = bdTypeRecyclerView;
        this.iLZ = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iVJ = frsGoodFragment;
        this.iKi.setPriority(1);
        this.iKi.setSelfListener(true);
        this.iVJ.registerListener(this.iKi);
        aa aaVar = new aa(frsGoodFragment.getTbPageContext(), bw.exO, this.iVJ.getUniqueId());
        n nVar = new n(frsGoodFragment.getTbPageContext(), bw.exP, this.iVJ.getUniqueId());
        x xVar = new x(frsGoodFragment.getTbPageContext(), bw.exR, this.iVJ.getUniqueId());
        u uVar = new u(frsGoodFragment.getTbPageContext(), bw.exS, this.iVJ.getUniqueId());
        m mVar = new m(frsGoodFragment.getTbPageContext(), bw.exU, this.iVJ.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), bw.exV, this.iVJ.getUniqueId());
        ac acVar = new ac(frsGoodFragment.getTbPageContext(), bw.eya, this.iVJ.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.y yVar = new com.baidu.tieba.frs.entelechy.a.y(frsGoodFragment.getTbPageContext(), bw.eyv, this.iVJ.getUniqueId());
        w wVar = new w(frsGoodFragment.getTbPageContext(), bw.eyb, this.iVJ.getUniqueId());
        t tVar = new t(frsGoodFragment.getTbPageContext(), bw.eyc, this.iVJ.getUniqueId());
        ab abVar = new ab(frsGoodFragment.getPageContext(), bw.eyg, this.iVJ.getUniqueId());
        r rVar = new r(frsGoodFragment.getPageContext(), bw.eyd, this.iVJ.getUniqueId());
        v vVar = new v(frsGoodFragment.getPageContext(), bw.eyf, this.iVJ.getUniqueId());
        ab abVar2 = new ab(frsGoodFragment.getPageContext(), bw.eyq, this.iVJ.getUniqueId());
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsGoodFragment.getPageContext(), s.iEO);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends af.a> a2 = e.cuU().a(frsGoodFragment.getPageContext(), this.iVJ.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> b = e.cuU().b(frsGoodFragment.getPageContext(), bw.ezT, this.iVJ.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dxM().a(this.iVJ, AdvertAppInfo.esD);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.r.dxM().a(this.iVJ, AdvertAppInfo.esM);
        z zVar = new z(frsGoodFragment.getPageContext(), bw.eyl, this.iVJ.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsGoodFragment.getPageContext(), bw.eyo, this.iVJ.getUniqueId());
        h hVar = new h(frsGoodFragment.getPageContext(), bw.eyn, this.iVJ.getUniqueId());
        i iVar = new i(frsGoodFragment.getPageContext(), bw.eyp, this.iVJ.getUniqueId());
        this.bje.add(aaVar);
        this.bje.add(nVar);
        this.bje.add(xVar);
        this.bje.add(uVar);
        this.bje.add(mVar);
        this.bje.add(oVar);
        this.bje.add(yVar);
        this.bje.add(acVar);
        this.bje.add(wVar);
        this.bje.add(tVar);
        this.bje.add(abVar);
        this.bje.add(rVar);
        this.bje.add(rVar);
        this.bje.add(vVar);
        this.bje.add(rVar2);
        this.bje.add(abVar);
        this.bje.add(abVar2);
        this.bje.add(zVar);
        this.bje.add(bVar);
        this.bje.add(hVar);
        this.bje.add(iVar);
        if (a2 != null) {
            this.bje.add(a2);
        }
        if (b != null) {
            this.bje.add(b);
        }
        this.bje.add(a3);
        this.bje.add(a4);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.iVJ.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.iVJ, 1);
        bVar2.setExtraData(this.bje);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.bje);
        EL("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
            if (aVar instanceof com.baidu.tieba.card.aa) {
                ((com.baidu.tieba.card.aa) aVar).or(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
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
        cym();
        aC(arrayList);
        com.baidu.tieba.tbadkCore.u.x(arrayList, 1);
        aB(arrayList);
        ArrayList<q> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.iHt.setData(switchThreadDataToThreadCardInfo);
        this.iWd = switchThreadDataToThreadCardInfo;
        this.iaV = arrayList;
        this.iMa = frsViewData;
        cyP();
    }

    public void refreshData() {
        this.iHt.setData(this.iWd);
        notifyDataSetChanged();
    }

    private void cym() {
        if (!y.isEmpty(this.bje) && this.iVJ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.iVJ.getTbPageTag());
                }
            }
        }
    }

    private void cyP() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.iMa != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if ((aVar instanceof d) && (statisticMetaData = ((d) aVar).getStatisticMetaData()) != null) {
                    if (this.iMa.needLog == 1) {
                        statisticMetaData.iZE = true;
                    } else {
                        statisticMetaData.iZE = false;
                    }
                    if (this.iMa.getForum() != null) {
                        statisticMetaData.iZG = this.iMa.getForum().getId();
                    }
                    if (this.iVJ != null) {
                        statisticMetaData.iZF = 5;
                    }
                }
            }
        }
    }

    private void aB(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    q qVar = arrayList.get(i2);
                    if ((qVar instanceof AdvertAppInfo) && this.iLZ != null && !this.iLZ.containsValue(qVar)) {
                        this.iLZ.put(Integer.valueOf(i2), (bw) qVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bw> czz() {
        return this.iLZ;
    }

    public void czE() {
        if (this.iHt != null && this.iHt.getData() != null && this.iHt.getData().size() != 0) {
            for (q qVar : this.iHt.getData()) {
                if ((qVar instanceof bv) && ((bv) qVar).erH.bjV() != 0) {
                    ((bv) qVar).erH.bkY();
                }
            }
        }
    }

    public void cBp() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
            if (aVar instanceof com.baidu.tieba.card.z) {
                ((com.baidu.tieba.card.z) aVar).uQ(3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iHt.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.iHt.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.bje != null && this.bje.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar instanceof k) {
                    ((k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.bje != null && this.bje.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar instanceof k) {
                    ((k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.bje != null && this.bje.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar != null && (aVar instanceof k)) {
                    ((k) aVar).a(abVar);
                }
            }
        }
    }

    private void aC(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<q> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bw.exI) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.iVJ != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.iVJ.registerListener(this.iWe);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.iVJ == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.iWc = new ArrayList();
        ArrayList<BdUniqueId> dGO = com.baidu.tieba.tbadkCore.u.dGO();
        if (dGO == null || dGO.size() <= 0) {
            return false;
        }
        int size = dGO.size();
        for (int i = 0; i < size; i++) {
            k<ICardInfo, ? extends af.a> a2 = e.cuU().a(this.iVJ.getPageContext(), dGO.get(i), this.iVJ.getUniqueId());
            if (a2 != null) {
                this.bje.add(a2);
                this.iWc.add(a2);
            }
        }
        if (!y.isEmpty(this.iWc)) {
            bdTypeRecyclerView.addAdapters(this.iWc);
        }
        return true;
    }

    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void EL(String str) {
        if (this.bje != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar instanceof f) {
                    ((f) aVar).EL(str);
                }
            }
        }
    }

    public List<q> getDataList() {
        return this.iaV;
    }

    public List<q> cBq() {
        return this.iWd;
    }
}
