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
/* loaded from: classes9.dex */
public class b {
    private ArrayList<m> fSt;
    private List<com.baidu.adp.widget.ListView.a> gFK;
    private ArrayList<m> gFL;
    private FrsGoodFragment gFs;
    private BdTypeRecyclerView gsQ;
    private final HashMap<Integer, bj> gwY;
    private FrsViewData gwZ;
    private List<com.baidu.adp.widget.ListView.a> asE = new LinkedList();
    private CustomMessageListener gvA = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((h) aVar).a(b.this.gFs.getPageContext(), b.this.gFs.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.asE != null) {
                    b.this.asE.addAll(arrayList);
                }
                if (b.this.gsQ != null) {
                    b.this.gsQ.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener gFM = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.isEmpty(b.this.gFK)) {
                b.this.b(b.this.gsQ);
                b.this.b(b.this.fSt, b.this.gwZ);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.gsQ = bdTypeRecyclerView;
        this.gwY = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gFs = frsGoodFragment;
        this.gvA.setPriority(1);
        this.gvA.setSelfListener(true);
        this.gFs.registerListener(this.gvA);
        w wVar = new w(frsGoodFragment.getTbPageContext(), bj.cRn, this.gFs.getUniqueId());
        l lVar = new l(frsGoodFragment.getTbPageContext(), bj.cRo, this.gFs.getUniqueId());
        t tVar = new t(frsGoodFragment.getTbPageContext(), bj.cRq, this.gFs.getUniqueId());
        r rVar = new r(frsGoodFragment.getTbPageContext(), bj.cRr, this.gFs.getUniqueId());
        k kVar = new k(frsGoodFragment.getTbPageContext(), bj.cRt, this.gFs.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsGoodFragment.getTbPageContext(), bj.cRu, this.gFs.getUniqueId());
        u uVar = new u(frsGoodFragment.getTbPageContext(), bj.cRM, this.gFs.getUniqueId());
        x xVar = new x(frsGoodFragment.getPageContext(), bj.cRz, this.gFs.getUniqueId());
        p pVar = new p(frsGoodFragment.getPageContext(), bj.cRx, this.gFs.getUniqueId());
        s sVar = new s(frsGoodFragment.getPageContext(), bj.cRy, this.gFs.getUniqueId());
        x xVar2 = new x(frsGoodFragment.getPageContext(), bj.cRH, this.gFs.getUniqueId());
        com.baidu.tieba.frs.m mVar2 = new com.baidu.tieba.frs.m(frsGoodFragment.getPageContext(), n.gra);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends v.a> a = c.bDg().a(frsGoodFragment.getPageContext(), this.gFs.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> b = c.bDg().b(frsGoodFragment.getPageContext(), bj.cTl, this.gFs.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.cCv().a(this.gFs, AdvertAppInfo.cMF);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.cCv().a(this.gFs, AdvertAppInfo.cMO);
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsGoodFragment.getPageContext(), bj.cRD, this.gFs.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsGoodFragment.getPageContext(), bj.cRF, this.gFs.getUniqueId());
        g gVar = new g(frsGoodFragment.getPageContext(), bj.cRE, this.gFs.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsGoodFragment.getPageContext(), bj.cRG, this.gFs.getUniqueId());
        this.asE.add(wVar);
        this.asE.add(lVar);
        this.asE.add(tVar);
        this.asE.add(rVar);
        this.asE.add(kVar);
        this.asE.add(mVar);
        this.asE.add(uVar);
        this.asE.add(xVar);
        this.asE.add(pVar);
        this.asE.add(pVar);
        this.asE.add(sVar);
        this.asE.add(mVar2);
        this.asE.add(xVar);
        this.asE.add(xVar2);
        this.asE.add(vVar);
        this.asE.add(bVar);
        this.asE.add(gVar);
        this.asE.add(hVar);
        if (a != null) {
            this.asE.add(a);
        }
        if (b != null) {
            this.asE.add(b);
        }
        this.asE.add(a2);
        this.asE.add(a3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.gFs.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.gFs, 1);
        bVar2.setExtraData(this.asE);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.asE);
        wO("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
            if (aVar instanceof y) {
                ((y) aVar).kr(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
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
        bFU();
        aq(arrayList);
        com.baidu.tieba.tbadkCore.s.o(arrayList, 1);
        ap(arrayList);
        ArrayList<m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.gsQ.setData(switchThreadDataToThreadCardInfo);
        this.gFL = switchThreadDataToThreadCardInfo;
        this.fSt = arrayList;
        this.gwZ = frsViewData;
        bGy();
    }

    public void refreshData() {
        this.gsQ.setData(this.gFL);
        notifyDataSetChanged();
    }

    private void bFU() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.asE) && this.gFs != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.gFs.getTbPageTag());
                }
            }
        }
    }

    private void bGy() {
        com.baidu.tieba.frs.d.b bGX;
        if (this.gwZ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if ((aVar instanceof d) && (bGX = ((d) aVar).bGX()) != null) {
                    if (this.gwZ.needLog == 1) {
                        bGX.gJm = true;
                    } else {
                        bGX.gJm = false;
                    }
                    if (this.gwZ.getForum() != null) {
                        bGX.gJo = this.gwZ.getForum().getId();
                    }
                    if (this.gFs != null) {
                        bGX.gJn = 5;
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
                    if ((mVar instanceof AdvertAppInfo) && this.gwY != null && !this.gwY.containsValue(mVar)) {
                        this.gwY.put(Integer.valueOf(i2), (bj) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bj> bHa() {
        return this.gwY;
    }

    public void bHf() {
        if (this.gsQ != null && this.gsQ.getData() != null && this.gsQ.getData().size() != 0) {
            for (m mVar : this.gsQ.getData()) {
                if ((mVar instanceof bi) && ((bi) mVar).cRf.aCj() != 0) {
                    ((bi) mVar).cRf.aDj();
                }
            }
        }
    }

    public void bIP() {
        for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
            if (aVar instanceof com.baidu.tieba.card.x) {
                ((com.baidu.tieba.card.x) aVar).pz(3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.gsQ.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.gsQ.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.asE != null && this.asE.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof h) {
                    ((h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.asE != null && this.asE.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        if (this.asE != null && this.asE.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
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
                if (it.next().getType() == bj.cRi) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gFs != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.gFs.registerListener(this.gFM);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gFs == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.gFK = new ArrayList();
        ArrayList<BdUniqueId> cKs = com.baidu.tieba.tbadkCore.s.cKs();
        if (cKs == null || cKs.size() <= 0) {
            return false;
        }
        int size = cKs.size();
        for (int i = 0; i < size; i++) {
            h<ICardInfo, ? extends v.a> a = c.bDg().a(this.gFs.getPageContext(), cKs.get(i), this.gFs.getUniqueId());
            if (a != null) {
                this.asE.add(a);
                this.gFK.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gFK)) {
            bdTypeRecyclerView.addAdapters(this.gFK);
        }
        return true;
    }

    public boolean p(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void wO(String str) {
        if (this.asE != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof f) {
                    ((f) aVar).wO(str);
                }
            }
        }
    }

    public List<m> getDataList() {
        return this.fSt;
    }

    public List<m> bIQ() {
        return this.gFL;
    }
}
