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
    private ArrayList<m> fSG;
    private FrsGoodFragment gFE;
    private List<com.baidu.adp.widget.ListView.a> gFW;
    private ArrayList<m> gFX;
    private BdTypeRecyclerView gtd;
    private final HashMap<Integer, bj> gxk;
    private FrsViewData gxl;
    private List<com.baidu.adp.widget.ListView.a> asF = new LinkedList();
    private CustomMessageListener gvM = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((h) aVar).a(b.this.gFE.getPageContext(), b.this.gFE.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.asF != null) {
                    b.this.asF.addAll(arrayList);
                }
                if (b.this.gtd != null) {
                    b.this.gtd.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener gFY = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.isEmpty(b.this.gFW)) {
                b.this.b(b.this.gtd);
                b.this.b(b.this.fSG, b.this.gxl);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.gtd = bdTypeRecyclerView;
        this.gxk = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gFE = frsGoodFragment;
        this.gvM.setPriority(1);
        this.gvM.setSelfListener(true);
        this.gFE.registerListener(this.gvM);
        w wVar = new w(frsGoodFragment.getTbPageContext(), bj.cRo, this.gFE.getUniqueId());
        l lVar = new l(frsGoodFragment.getTbPageContext(), bj.cRp, this.gFE.getUniqueId());
        t tVar = new t(frsGoodFragment.getTbPageContext(), bj.cRr, this.gFE.getUniqueId());
        r rVar = new r(frsGoodFragment.getTbPageContext(), bj.cRs, this.gFE.getUniqueId());
        k kVar = new k(frsGoodFragment.getTbPageContext(), bj.cRu, this.gFE.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsGoodFragment.getTbPageContext(), bj.cRv, this.gFE.getUniqueId());
        u uVar = new u(frsGoodFragment.getTbPageContext(), bj.cRN, this.gFE.getUniqueId());
        x xVar = new x(frsGoodFragment.getPageContext(), bj.cRA, this.gFE.getUniqueId());
        p pVar = new p(frsGoodFragment.getPageContext(), bj.cRy, this.gFE.getUniqueId());
        s sVar = new s(frsGoodFragment.getPageContext(), bj.cRz, this.gFE.getUniqueId());
        x xVar2 = new x(frsGoodFragment.getPageContext(), bj.cRI, this.gFE.getUniqueId());
        com.baidu.tieba.frs.m mVar2 = new com.baidu.tieba.frs.m(frsGoodFragment.getPageContext(), n.grn);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends v.a> a = c.bDh().a(frsGoodFragment.getPageContext(), this.gFE.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> b = c.bDh().b(frsGoodFragment.getPageContext(), bj.cTm, this.gFE.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.cCw().a(this.gFE, AdvertAppInfo.cMG);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.cCw().a(this.gFE, AdvertAppInfo.cMP);
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsGoodFragment.getPageContext(), bj.cRE, this.gFE.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsGoodFragment.getPageContext(), bj.cRG, this.gFE.getUniqueId());
        g gVar = new g(frsGoodFragment.getPageContext(), bj.cRF, this.gFE.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsGoodFragment.getPageContext(), bj.cRH, this.gFE.getUniqueId());
        this.asF.add(wVar);
        this.asF.add(lVar);
        this.asF.add(tVar);
        this.asF.add(rVar);
        this.asF.add(kVar);
        this.asF.add(mVar);
        this.asF.add(uVar);
        this.asF.add(xVar);
        this.asF.add(pVar);
        this.asF.add(pVar);
        this.asF.add(sVar);
        this.asF.add(mVar2);
        this.asF.add(xVar);
        this.asF.add(xVar2);
        this.asF.add(vVar);
        this.asF.add(bVar);
        this.asF.add(gVar);
        this.asF.add(hVar);
        if (a != null) {
            this.asF.add(a);
        }
        if (b != null) {
            this.asF.add(b);
        }
        this.asF.add(a2);
        this.asF.add(a3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.gFE.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.gFE, 1);
        bVar2.setExtraData(this.asF);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.asF);
        wP("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
            if (aVar instanceof y) {
                ((y) aVar).kr(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
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
        bFV();
        aq(arrayList);
        com.baidu.tieba.tbadkCore.s.o(arrayList, 1);
        ap(arrayList);
        ArrayList<m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.gtd.setData(switchThreadDataToThreadCardInfo);
        this.gFX = switchThreadDataToThreadCardInfo;
        this.fSG = arrayList;
        this.gxl = frsViewData;
        bGz();
    }

    public void refreshData() {
        this.gtd.setData(this.gFX);
        notifyDataSetChanged();
    }

    private void bFV() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.asF) && this.gFE != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.gFE.getTbPageTag());
                }
            }
        }
    }

    private void bGz() {
        com.baidu.tieba.frs.d.b bGY;
        if (this.gxl != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if ((aVar instanceof d) && (bGY = ((d) aVar).bGY()) != null) {
                    if (this.gxl.needLog == 1) {
                        bGY.gJy = true;
                    } else {
                        bGY.gJy = false;
                    }
                    if (this.gxl.getForum() != null) {
                        bGY.gJA = this.gxl.getForum().getId();
                    }
                    if (this.gFE != null) {
                        bGY.gJz = 5;
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
                    if ((mVar instanceof AdvertAppInfo) && this.gxk != null && !this.gxk.containsValue(mVar)) {
                        this.gxk.put(Integer.valueOf(i2), (bj) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bj> bHb() {
        return this.gxk;
    }

    public void bHg() {
        if (this.gtd != null && this.gtd.getData() != null && this.gtd.getData().size() != 0) {
            for (m mVar : this.gtd.getData()) {
                if ((mVar instanceof bi) && ((bi) mVar).cRg.aCj() != 0) {
                    ((bi) mVar).cRg.aDj();
                }
            }
        }
    }

    public void bIQ() {
        for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
            if (aVar instanceof com.baidu.tieba.card.x) {
                ((com.baidu.tieba.card.x) aVar).pz(3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.gtd.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.gtd.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.asF != null && this.asF.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if (aVar instanceof h) {
                    ((h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.asF != null && this.asF.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        if (this.asF != null && this.asF.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
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
                if (it.next().getType() == bj.cRj) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gFE != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.gFE.registerListener(this.gFY);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gFE == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.gFW = new ArrayList();
        ArrayList<BdUniqueId> cKt = com.baidu.tieba.tbadkCore.s.cKt();
        if (cKt == null || cKt.size() <= 0) {
            return false;
        }
        int size = cKt.size();
        for (int i = 0; i < size; i++) {
            h<ICardInfo, ? extends v.a> a = c.bDh().a(this.gFE.getPageContext(), cKt.get(i), this.gFE.getUniqueId());
            if (a != null) {
                this.asF.add(a);
                this.gFW.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gFW)) {
            bdTypeRecyclerView.addAdapters(this.gFW);
        }
        return true;
    }

    public boolean p(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void wP(String str) {
        if (this.asF != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if (aVar instanceof f) {
                    ((f) aVar).wP(str);
                }
            }
        }
    }

    public List<m> getDataList() {
        return this.fSG;
    }

    public List<m> bIR() {
        return this.gFX;
    }
}
