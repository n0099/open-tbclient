package com.baidu.tieba.frs.good;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.a.f;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.c;
import com.baidu.tieba.frs.d.d;
import com.baidu.tieba.frs.entelechy.a.i;
import com.baidu.tieba.frs.entelechy.a.n;
import com.baidu.tieba.frs.entelechy.a.o;
import com.baidu.tieba.frs.entelechy.a.r;
import com.baidu.tieba.frs.entelechy.a.t;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.entelechy.a.w;
import com.baidu.tieba.frs.entelechy.a.x;
import com.baidu.tieba.frs.entelechy.a.y;
import com.baidu.tieba.frs.entelechy.a.z;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private ArrayList<m> fTp;
    private FrsGoodFragment gGC;
    private List<com.baidu.adp.widget.ListView.a> gGU;
    private ArrayList<m> gGV;
    private BdTypeRecyclerView gtH;
    private final HashMap<Integer, bj> gxV;
    private FrsViewData gxW;
    private List<com.baidu.adp.widget.ListView.a> asP = new LinkedList();
    private CustomMessageListener gwt = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                    if (aVar instanceof h) {
                        ((h) aVar).a(b.this.gGC.getPageContext(), b.this.gGC.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.asP != null) {
                    b.this.asP.addAll(arrayList);
                }
                if (b.this.gtH != null) {
                    b.this.gtH.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener gGW = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.isEmpty(b.this.gGU)) {
                b.this.b(b.this.gtH);
                b.this.b(b.this.fTp, b.this.gxW);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.gtH = bdTypeRecyclerView;
        this.gxV = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gGC = frsGoodFragment;
        this.gwt.setPriority(1);
        this.gwt.setSelfListener(true);
        this.gGC.registerListener(this.gwt);
        y yVar = new y(frsGoodFragment.getTbPageContext(), bj.cRB, this.gGC.getUniqueId());
        n nVar = new n(frsGoodFragment.getTbPageContext(), bj.cRC, this.gGC.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsGoodFragment.getTbPageContext(), bj.cRE, this.gGC.getUniqueId());
        t tVar = new t(frsGoodFragment.getTbPageContext(), bj.cRF, this.gGC.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsGoodFragment.getTbPageContext(), bj.cRH, this.gGC.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), bj.cRI, this.gGC.getUniqueId());
        w wVar = new w(frsGoodFragment.getTbPageContext(), bj.cSa, this.gGC.getUniqueId());
        z zVar = new z(frsGoodFragment.getPageContext(), bj.cRN, this.gGC.getUniqueId());
        r rVar = new r(frsGoodFragment.getPageContext(), bj.cRL, this.gGC.getUniqueId());
        u uVar = new u(frsGoodFragment.getPageContext(), bj.cRM, this.gGC.getUniqueId());
        z zVar2 = new z(frsGoodFragment.getPageContext(), bj.cRV, this.gGC.getUniqueId());
        com.baidu.tieba.frs.n nVar2 = new com.baidu.tieba.frs.n(frsGoodFragment.getPageContext(), com.baidu.tieba.frs.o.grX);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends v.a> a = c.bDp().a(frsGoodFragment.getPageContext(), this.gGC.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> b = c.bDp().b(frsGoodFragment.getPageContext(), bj.cTz, this.gGC.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.cCQ().a(this.gGC, AdvertAppInfo.cMR);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.cCQ().a(this.gGC, AdvertAppInfo.cNa);
        x xVar = new x(frsGoodFragment.getPageContext(), bj.cRR, this.gGC.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsGoodFragment.getPageContext(), bj.cRT, this.gGC.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsGoodFragment.getPageContext(), bj.cRS, this.gGC.getUniqueId());
        i iVar = new i(frsGoodFragment.getPageContext(), bj.cRU, this.gGC.getUniqueId());
        this.asP.add(yVar);
        this.asP.add(nVar);
        this.asP.add(vVar);
        this.asP.add(tVar);
        this.asP.add(mVar);
        this.asP.add(oVar);
        this.asP.add(wVar);
        this.asP.add(zVar);
        this.asP.add(rVar);
        this.asP.add(rVar);
        this.asP.add(uVar);
        this.asP.add(nVar2);
        this.asP.add(zVar);
        this.asP.add(zVar2);
        this.asP.add(xVar);
        this.asP.add(bVar);
        this.asP.add(hVar);
        this.asP.add(iVar);
        if (a != null) {
            this.asP.add(a);
        }
        if (b != null) {
            this.asP.add(b);
        }
        this.asP.add(a2);
        this.asP.add(a3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.gGC.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.gGC, 1);
        bVar2.setExtraData(this.asP);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.asP);
        wP("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
            if (aVar instanceof com.baidu.tieba.card.y) {
                ((com.baidu.tieba.card.y) aVar).kw(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    public void b(ArrayList<m> arrayList, FrsViewData frsViewData) {
        if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof com.baidu.tieba.frs.o)) {
            frsViewData.setThreadList(arrayList);
        }
        b(frsViewData);
        bGg();
        aq(arrayList);
        com.baidu.tieba.tbadkCore.t.n(arrayList, 1);
        ap(arrayList);
        ArrayList<m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.gtH.setData(switchThreadDataToThreadCardInfo);
        this.gGV = switchThreadDataToThreadCardInfo;
        this.fTp = arrayList;
        this.gxW = frsViewData;
        bGL();
    }

    public void refreshData() {
        this.gtH.setData(this.gGV);
        notifyDataSetChanged();
    }

    private void bGg() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.asP) && this.gGC != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.gGC.getTbPageTag());
                }
            }
        }
    }

    private void bGL() {
        com.baidu.tieba.frs.d.b bHn;
        if (this.gxW != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if ((aVar instanceof d) && (bHn = ((d) aVar).bHn()) != null) {
                    if (this.gxW.needLog == 1) {
                        bHn.gKD = true;
                    } else {
                        bHn.gKD = false;
                    }
                    if (this.gxW.getForum() != null) {
                        bHn.gKF = this.gxW.getForum().getId();
                    }
                    if (this.gGC != null) {
                        bHn.gKE = 5;
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
                    if ((mVar instanceof AdvertAppInfo) && this.gxV != null && !this.gxV.containsValue(mVar)) {
                        this.gxV.put(Integer.valueOf(i2), (bj) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bj> bHq() {
        return this.gxV;
    }

    public void bHv() {
        if (this.gtH != null && this.gtH.getData() != null && this.gtH.getData().size() != 0) {
            for (m mVar : this.gtH.getData()) {
                if ((mVar instanceof bi) && ((bi) mVar).cRt.aCm() != 0) {
                    ((bi) mVar).cRt.aDm();
                }
            }
        }
    }

    public void bJc() {
        for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
            if (aVar instanceof com.baidu.tieba.card.x) {
                ((com.baidu.tieba.card.x) aVar).pB(3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.gtH.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.gtH.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.asP != null && this.asP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar instanceof h) {
                    ((h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.asP != null && this.asP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(s sVar) {
        if (this.asP != null && this.asP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar != null && (aVar instanceof h)) {
                    ((h) aVar).a(sVar);
                }
            }
        }
    }

    private void aq(ArrayList<m> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<m> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bj.cRw) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gGC != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.gGC.registerListener(this.gGW);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gGC == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.gGU = new ArrayList();
        ArrayList<BdUniqueId> cKN = com.baidu.tieba.tbadkCore.t.cKN();
        if (cKN == null || cKN.size() <= 0) {
            return false;
        }
        int size = cKN.size();
        for (int i = 0; i < size; i++) {
            h<ICardInfo, ? extends v.a> a = c.bDp().a(this.gGC.getPageContext(), cKN.get(i), this.gGC.getUniqueId());
            if (a != null) {
                this.asP.add(a);
                this.gGU.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gGU)) {
            bdTypeRecyclerView.addAdapters(this.gGU);
        }
        return true;
    }

    public boolean p(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void wP(String str) {
        if (this.asP != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar instanceof f) {
                    ((f) aVar).wP(str);
                }
            }
        }
    }

    public List<m> getDataList() {
        return this.fTp;
    }

    public List<m> bJd() {
        return this.gGV;
    }
}
