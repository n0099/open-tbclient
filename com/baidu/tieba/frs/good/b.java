package com.baidu.tieba.frs.good;

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
import com.baidu.tieba.a.f;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.c;
import com.baidu.tieba.frs.d.d;
import com.baidu.tieba.frs.entelechy.a.g;
import com.baidu.tieba.frs.entelechy.a.k;
import com.baidu.tieba.frs.entelechy.a.l;
import com.baidu.tieba.frs.entelechy.a.p;
import com.baidu.tieba.frs.entelechy.a.r;
import com.baidu.tieba.frs.entelechy.a.s;
import com.baidu.tieba.frs.entelechy.a.t;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.entelechy.a.w;
import com.baidu.tieba.frs.entelechy.a.x;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    private ArrayList<m> fMN;
    private ArrayList<m> gAA;
    private FrsGoodFragment gAh;
    private List<com.baidu.adp.widget.ListView.a> gAz;
    private BdTypeRecyclerView gnE;
    private final HashMap<Integer, bj> grM;
    private FrsViewData grN;
    private List<com.baidu.adp.widget.ListView.a> aoz = new LinkedList();
    private CustomMessageListener gqo = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((h) aVar).a(b.this.gAh.getPageContext(), b.this.gAh.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.aoz != null) {
                    b.this.aoz.addAll(arrayList);
                }
                if (b.this.gnE != null) {
                    b.this.gnE.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener gAB = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.isEmpty(b.this.gAz)) {
                b.this.b(b.this.gnE);
                b.this.b(b.this.fMN, b.this.grN);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.gnE = bdTypeRecyclerView;
        this.grM = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gAh = frsGoodFragment;
        this.gqo.setPriority(1);
        this.gqo.setSelfListener(true);
        this.gAh.registerListener(this.gqo);
        w wVar = new w(frsGoodFragment.getTbPageContext(), bj.cMZ, this.gAh.getUniqueId());
        l lVar = new l(frsGoodFragment.getTbPageContext(), bj.cNa, this.gAh.getUniqueId());
        t tVar = new t(frsGoodFragment.getTbPageContext(), bj.cNc, this.gAh.getUniqueId());
        r rVar = new r(frsGoodFragment.getTbPageContext(), bj.cNd, this.gAh.getUniqueId());
        k kVar = new k(frsGoodFragment.getTbPageContext(), bj.cNf, this.gAh.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsGoodFragment.getTbPageContext(), bj.cNg, this.gAh.getUniqueId());
        u uVar = new u(frsGoodFragment.getTbPageContext(), bj.cNy, this.gAh.getUniqueId());
        x xVar = new x(frsGoodFragment.getPageContext(), bj.cNl, this.gAh.getUniqueId());
        p pVar = new p(frsGoodFragment.getPageContext(), bj.cNj, this.gAh.getUniqueId());
        s sVar = new s(frsGoodFragment.getPageContext(), bj.cNk, this.gAh.getUniqueId());
        x xVar2 = new x(frsGoodFragment.getPageContext(), bj.cNt, this.gAh.getUniqueId());
        com.baidu.tieba.frs.m mVar2 = new com.baidu.tieba.frs.m(frsGoodFragment.getPageContext(), n.glO);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends v.a> a = c.bAA().a(frsGoodFragment.getPageContext(), this.gAh.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> b = c.bAA().b(frsGoodFragment.getPageContext(), bj.cOY, this.gAh.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.czO().a(this.gAh, AdvertAppInfo.cIp);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.czO().a(this.gAh, AdvertAppInfo.cIy);
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsGoodFragment.getPageContext(), bj.cNp, this.gAh.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsGoodFragment.getPageContext(), bj.cNr, this.gAh.getUniqueId());
        g gVar = new g(frsGoodFragment.getPageContext(), bj.cNq, this.gAh.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsGoodFragment.getPageContext(), bj.cNs, this.gAh.getUniqueId());
        this.aoz.add(wVar);
        this.aoz.add(lVar);
        this.aoz.add(tVar);
        this.aoz.add(rVar);
        this.aoz.add(kVar);
        this.aoz.add(mVar);
        this.aoz.add(uVar);
        this.aoz.add(xVar);
        this.aoz.add(pVar);
        this.aoz.add(pVar);
        this.aoz.add(sVar);
        this.aoz.add(mVar2);
        this.aoz.add(xVar);
        this.aoz.add(xVar2);
        this.aoz.add(vVar);
        this.aoz.add(bVar);
        this.aoz.add(gVar);
        this.aoz.add(hVar);
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
        customMessage.setTag(this.gAh.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.gAh, 1);
        bVar2.setExtraData(this.aoz);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.aoz);
        wq("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
            if (aVar instanceof y) {
                ((y) aVar).ke(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    public void b(ArrayList<m> arrayList, FrsViewData frsViewData) {
        if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof n)) {
            frsViewData.setThreadList(arrayList);
        }
        b(frsViewData);
        bDo();
        aq(arrayList);
        com.baidu.tieba.tbadkCore.s.n(arrayList, 1);
        ap(arrayList);
        ArrayList<m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.gnE.setData(switchThreadDataToThreadCardInfo);
        this.gAA = switchThreadDataToThreadCardInfo;
        this.fMN = arrayList;
        this.grN = frsViewData;
        bDS();
    }

    public void refreshData() {
        this.gnE.setData(this.gAA);
        notifyDataSetChanged();
    }

    private void bDo() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.aoz) && this.gAh != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.gAh.getTbPageTag());
                }
            }
        }
    }

    private void bDS() {
        com.baidu.tieba.frs.d.b bEr;
        if (this.grN != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if ((aVar instanceof d) && (bEr = ((d) aVar).bEr()) != null) {
                    if (this.grN.needLog == 1) {
                        bEr.gDW = true;
                    } else {
                        bEr.gDW = false;
                    }
                    if (this.grN.getForum() != null) {
                        bEr.gDY = this.grN.getForum().getId();
                    }
                    if (this.gAh != null) {
                        if (this.gAh.gAa) {
                            bEr.gEb = 8;
                        } else {
                            bEr.gDX = 5;
                        }
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

    public void lJ(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
            if (aVar instanceof com.baidu.tieba.card.x) {
                ((com.baidu.tieba.card.x) aVar).pm(z ? 15 : 3);
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
                if (aVar instanceof h) {
                    ((h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.aoz != null && this.aoz.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        if (this.aoz != null && this.aoz.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
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
                if (it.next().getType() == bj.cMU) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gAh != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.gAh.registerListener(this.gAB);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gAh == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.gAz = new ArrayList();
        ArrayList<BdUniqueId> cHG = com.baidu.tieba.tbadkCore.s.cHG();
        if (cHG == null || cHG.size() <= 0) {
            return false;
        }
        int size = cHG.size();
        for (int i = 0; i < size; i++) {
            h<ICardInfo, ? extends v.a> a = c.bAA().a(this.gAh.getPageContext(), cHG.get(i), this.gAh.getUniqueId());
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

    public boolean p(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void wq(String str) {
        if (this.aoz != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar instanceof f) {
                    ((f) aVar).wq(str);
                }
            }
        }
    }

    public List<m> getDataList() {
        return this.fMN;
    }

    public List<m> bGk() {
        return this.gAA;
    }
}
