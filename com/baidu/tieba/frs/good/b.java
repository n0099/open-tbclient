package com.baidu.tieba.frs.good;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.y;
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
import com.baidu.tieba.frs.p;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.q;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private ArrayList<m> gyd;
    private BdTypeRecyclerView hcY;
    private final HashMap<Integer, bj> hhw;
    private FrsViewData hhx;
    private FrsGoodFragment hqa;
    private List<com.baidu.adp.widget.ListView.a> hqt;
    private ArrayList<m> hqu;
    private List<com.baidu.adp.widget.ListView.a> aMj = new LinkedList();
    private CustomMessageListener hfK = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((h) aVar).a(b.this.hqa.getPageContext(), b.this.hqa.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.aMj != null) {
                    b.this.aMj.addAll(arrayList);
                }
                if (b.this.hcY != null) {
                    b.this.hcY.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener hqv = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.isEmpty(b.this.hqt)) {
                b.this.b(b.this.hcY);
                b.this.b(b.this.gyd, b.this.hhx);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.hcY = bdTypeRecyclerView;
        this.hhw = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hqa = frsGoodFragment;
        this.hfK.setPriority(1);
        this.hfK.setSelfListener(true);
        this.hqa.registerListener(this.hfK);
        y yVar = new y(frsGoodFragment.getTbPageContext(), bj.dqM, this.hqa.getUniqueId());
        n nVar = new n(frsGoodFragment.getTbPageContext(), bj.dqN, this.hqa.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsGoodFragment.getTbPageContext(), bj.dqP, this.hqa.getUniqueId());
        t tVar = new t(frsGoodFragment.getTbPageContext(), bj.dqQ, this.hqa.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsGoodFragment.getTbPageContext(), bj.dqS, this.hqa.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), bj.dqT, this.hqa.getUniqueId());
        w wVar = new w(frsGoodFragment.getTbPageContext(), bj.drm, this.hqa.getUniqueId());
        z zVar = new z(frsGoodFragment.getPageContext(), bj.dqZ, this.hqa.getUniqueId());
        r rVar = new r(frsGoodFragment.getPageContext(), bj.dqX, this.hqa.getUniqueId());
        u uVar = new u(frsGoodFragment.getPageContext(), bj.dqY, this.hqa.getUniqueId());
        z zVar2 = new z(frsGoodFragment.getPageContext(), bj.drh, this.hqa.getUniqueId());
        com.baidu.tieba.frs.o oVar2 = new com.baidu.tieba.frs.o(frsGoodFragment.getPageContext(), p.hbp);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends y.a> a = c.bNM().a(frsGoodFragment.getPageContext(), this.hqa.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends y.a> b = c.bNM().b(frsGoodFragment.getPageContext(), bj.dsN, this.hqa.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = q.cNm().a(this.hqa, AdvertAppInfo.dmb);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = q.cNm().a(this.hqa, AdvertAppInfo.dmk);
        x xVar = new x(frsGoodFragment.getPageContext(), bj.drd, this.hqa.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsGoodFragment.getPageContext(), bj.drf, this.hqa.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsGoodFragment.getPageContext(), bj.dre, this.hqa.getUniqueId());
        i iVar = new i(frsGoodFragment.getPageContext(), bj.drg, this.hqa.getUniqueId());
        this.aMj.add(yVar);
        this.aMj.add(nVar);
        this.aMj.add(vVar);
        this.aMj.add(tVar);
        this.aMj.add(mVar);
        this.aMj.add(oVar);
        this.aMj.add(wVar);
        this.aMj.add(zVar);
        this.aMj.add(rVar);
        this.aMj.add(rVar);
        this.aMj.add(uVar);
        this.aMj.add(oVar2);
        this.aMj.add(zVar);
        this.aMj.add(zVar2);
        this.aMj.add(xVar);
        this.aMj.add(bVar);
        this.aMj.add(hVar);
        this.aMj.add(iVar);
        if (a != null) {
            this.aMj.add(a);
        }
        if (b != null) {
            this.aMj.add(b);
        }
        this.aMj.add(a2);
        this.aMj.add(a3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.hqa.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.hqa, 1);
        bVar2.setExtraData(this.aMj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.aMj);
        yf("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
            if (aVar instanceof com.baidu.tieba.card.y) {
                ((com.baidu.tieba.card.y) aVar).lz(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    public void b(ArrayList<m> arrayList, FrsViewData frsViewData) {
        if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof p)) {
            frsViewData.setThreadList(arrayList);
        }
        b(frsViewData);
        bQH();
        as(arrayList);
        com.baidu.tieba.tbadkCore.t.q(arrayList, 1);
        ar(arrayList);
        ArrayList<m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.hcY.setData(switchThreadDataToThreadCardInfo);
        this.hqu = switchThreadDataToThreadCardInfo;
        this.gyd = arrayList;
        this.hhx = frsViewData;
        bRl();
    }

    public void refreshData() {
        this.hcY.setData(this.hqu);
        notifyDataSetChanged();
    }

    private void bQH() {
        if (!v.isEmpty(this.aMj) && this.hqa != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.hqa.getTbPageTag());
                }
            }
        }
    }

    private void bRl() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.hhx != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if ((aVar instanceof d) && (statisticMetaData = ((d) aVar).getStatisticMetaData()) != null) {
                    if (this.hhx.needLog == 1) {
                        statisticMetaData.hua = true;
                    } else {
                        statisticMetaData.hua = false;
                    }
                    if (this.hhx.getForum() != null) {
                        statisticMetaData.huc = this.hhx.getForum().getId();
                    }
                    if (this.hqa != null) {
                        statisticMetaData.hub = 5;
                    }
                }
            }
        }
    }

    private void ar(ArrayList<m> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    m mVar = arrayList.get(i2);
                    if ((mVar instanceof AdvertAppInfo) && this.hhw != null && !this.hhw.containsValue(mVar)) {
                        this.hhw.put(Integer.valueOf(i2), (bj) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bj> bRQ() {
        return this.hhw;
    }

    public void bRV() {
        if (this.hcY != null && this.hcY.getData() != null && this.hcY.getData().size() != 0) {
            for (m mVar : this.hcY.getData()) {
                if ((mVar instanceof bi) && ((bi) mVar).dqE.aKx() != 0) {
                    ((bi) mVar).dqE.aLx();
                }
            }
        }
    }

    public void bTy() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
            if (aVar instanceof com.baidu.tieba.card.x) {
                ((com.baidu.tieba.card.x) aVar).pV(3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hcY.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.hcY.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.aMj != null && this.aMj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar instanceof h) {
                    ((h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.aMj != null && this.aMj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aMj != null && this.aMj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar != null && (aVar instanceof h)) {
                    ((h) aVar).a(vVar);
                }
            }
        }
    }

    private void as(ArrayList<m> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<m> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bj.dqH) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.hqa != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.hqa.registerListener(this.hqv);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.hqa == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.hqt = new ArrayList();
        ArrayList<BdUniqueId> cVH = com.baidu.tieba.tbadkCore.t.cVH();
        if (cVH == null || cVH.size() <= 0) {
            return false;
        }
        int size = cVH.size();
        for (int i = 0; i < size; i++) {
            h<ICardInfo, ? extends y.a> a = c.bNM().a(this.hqa.getPageContext(), cVH.get(i), this.hqa.getUniqueId());
            if (a != null) {
                this.aMj.add(a);
                this.hqt.add(a);
            }
        }
        if (!v.isEmpty(this.hqt)) {
            bdTypeRecyclerView.addAdapters(this.hqt);
        }
        return true;
    }

    public boolean p(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void yf(String str) {
        if (this.aMj != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar instanceof f) {
                    ((f) aVar).yf(str);
                }
            }
        }
    }

    public List<m> getDataList() {
        return this.gyd;
    }

    public List<m> bTz() {
        return this.hqu;
    }
}
