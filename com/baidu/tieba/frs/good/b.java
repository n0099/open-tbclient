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
    private ArrayList<m> fSr;
    private List<com.baidu.adp.widget.ListView.a> gFI;
    private ArrayList<m> gFJ;
    private FrsGoodFragment gFq;
    private BdTypeRecyclerView gsO;
    private final HashMap<Integer, bj> gwW;
    private FrsViewData gwX;
    private List<com.baidu.adp.widget.ListView.a> asE = new LinkedList();
    private CustomMessageListener gvy = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((h) aVar).a(b.this.gFq.getPageContext(), b.this.gFq.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.asE != null) {
                    b.this.asE.addAll(arrayList);
                }
                if (b.this.gsO != null) {
                    b.this.gsO.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener gFK = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.isEmpty(b.this.gFI)) {
                b.this.b(b.this.gsO);
                b.this.b(b.this.fSr, b.this.gwX);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.gsO = bdTypeRecyclerView;
        this.gwW = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gFq = frsGoodFragment;
        this.gvy.setPriority(1);
        this.gvy.setSelfListener(true);
        this.gFq.registerListener(this.gvy);
        w wVar = new w(frsGoodFragment.getTbPageContext(), bj.cRm, this.gFq.getUniqueId());
        l lVar = new l(frsGoodFragment.getTbPageContext(), bj.cRn, this.gFq.getUniqueId());
        t tVar = new t(frsGoodFragment.getTbPageContext(), bj.cRp, this.gFq.getUniqueId());
        r rVar = new r(frsGoodFragment.getTbPageContext(), bj.cRq, this.gFq.getUniqueId());
        k kVar = new k(frsGoodFragment.getTbPageContext(), bj.cRs, this.gFq.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsGoodFragment.getTbPageContext(), bj.cRt, this.gFq.getUniqueId());
        u uVar = new u(frsGoodFragment.getTbPageContext(), bj.cRL, this.gFq.getUniqueId());
        x xVar = new x(frsGoodFragment.getPageContext(), bj.cRy, this.gFq.getUniqueId());
        p pVar = new p(frsGoodFragment.getPageContext(), bj.cRw, this.gFq.getUniqueId());
        s sVar = new s(frsGoodFragment.getPageContext(), bj.cRx, this.gFq.getUniqueId());
        x xVar2 = new x(frsGoodFragment.getPageContext(), bj.cRG, this.gFq.getUniqueId());
        com.baidu.tieba.frs.m mVar2 = new com.baidu.tieba.frs.m(frsGoodFragment.getPageContext(), n.gqY);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends v.a> a = c.bDe().a(frsGoodFragment.getPageContext(), this.gFq.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> b = c.bDe().b(frsGoodFragment.getPageContext(), bj.cTk, this.gFq.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.cCt().a(this.gFq, AdvertAppInfo.cME);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.cCt().a(this.gFq, AdvertAppInfo.cMN);
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsGoodFragment.getPageContext(), bj.cRC, this.gFq.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsGoodFragment.getPageContext(), bj.cRE, this.gFq.getUniqueId());
        g gVar = new g(frsGoodFragment.getPageContext(), bj.cRD, this.gFq.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsGoodFragment.getPageContext(), bj.cRF, this.gFq.getUniqueId());
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
        customMessage.setTag(this.gFq.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.gFq, 1);
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
        bFS();
        aq(arrayList);
        com.baidu.tieba.tbadkCore.s.o(arrayList, 1);
        ap(arrayList);
        ArrayList<m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.gsO.setData(switchThreadDataToThreadCardInfo);
        this.gFJ = switchThreadDataToThreadCardInfo;
        this.fSr = arrayList;
        this.gwX = frsViewData;
        bGw();
    }

    public void refreshData() {
        this.gsO.setData(this.gFJ);
        notifyDataSetChanged();
    }

    private void bFS() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.asE) && this.gFq != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.gFq.getTbPageTag());
                }
            }
        }
    }

    private void bGw() {
        com.baidu.tieba.frs.d.b bGV;
        if (this.gwX != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if ((aVar instanceof d) && (bGV = ((d) aVar).bGV()) != null) {
                    if (this.gwX.needLog == 1) {
                        bGV.gJk = true;
                    } else {
                        bGV.gJk = false;
                    }
                    if (this.gwX.getForum() != null) {
                        bGV.gJm = this.gwX.getForum().getId();
                    }
                    if (this.gFq != null) {
                        bGV.gJl = 5;
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
                    if ((mVar instanceof AdvertAppInfo) && this.gwW != null && !this.gwW.containsValue(mVar)) {
                        this.gwW.put(Integer.valueOf(i2), (bj) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bj> bGY() {
        return this.gwW;
    }

    public void bHd() {
        if (this.gsO != null && this.gsO.getData() != null && this.gsO.getData().size() != 0) {
            for (m mVar : this.gsO.getData()) {
                if ((mVar instanceof bi) && ((bi) mVar).cRe.aCh() != 0) {
                    ((bi) mVar).cRe.aDh();
                }
            }
        }
    }

    public void bIN() {
        for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
            if (aVar instanceof com.baidu.tieba.card.x) {
                ((com.baidu.tieba.card.x) aVar).pz(3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.gsO.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.gsO.getAdapter().notifyDataSetChanged();
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
                if (it.next().getType() == bj.cRh) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gFq != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.gFq.registerListener(this.gFK);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gFq == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.gFI = new ArrayList();
        ArrayList<BdUniqueId> cKq = com.baidu.tieba.tbadkCore.s.cKq();
        if (cKq == null || cKq.size() <= 0) {
            return false;
        }
        int size = cKq.size();
        for (int i = 0; i < size; i++) {
            h<ICardInfo, ? extends v.a> a = c.bDe().a(this.gFq.getPageContext(), cKq.get(i), this.gFq.getUniqueId());
            if (a != null) {
                this.asE.add(a);
                this.gFI.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gFI)) {
            bdTypeRecyclerView.addAdapters(this.gFI);
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
        return this.fSr;
    }

    public List<m> bIO() {
        return this.gFJ;
    }
}
