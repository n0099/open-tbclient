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
    private ArrayList<m> gxX;
    private BdTypeRecyclerView hcS;
    private final HashMap<Integer, bj> hhq;
    private FrsViewData hhr;
    private FrsGoodFragment hpU;
    private List<com.baidu.adp.widget.ListView.a> hqn;
    private ArrayList<m> hqo;
    private List<com.baidu.adp.widget.ListView.a> aMd = new LinkedList();
    private CustomMessageListener hfE = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((h) aVar).a(b.this.hpU.getPageContext(), b.this.hpU.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.aMd != null) {
                    b.this.aMd.addAll(arrayList);
                }
                if (b.this.hcS != null) {
                    b.this.hcS.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener hqp = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.isEmpty(b.this.hqn)) {
                b.this.b(b.this.hcS);
                b.this.b(b.this.gxX, b.this.hhr);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.hcS = bdTypeRecyclerView;
        this.hhq = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hpU = frsGoodFragment;
        this.hfE.setPriority(1);
        this.hfE.setSelfListener(true);
        this.hpU.registerListener(this.hfE);
        y yVar = new y(frsGoodFragment.getTbPageContext(), bj.dqI, this.hpU.getUniqueId());
        n nVar = new n(frsGoodFragment.getTbPageContext(), bj.dqJ, this.hpU.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsGoodFragment.getTbPageContext(), bj.dqL, this.hpU.getUniqueId());
        t tVar = new t(frsGoodFragment.getTbPageContext(), bj.dqM, this.hpU.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsGoodFragment.getTbPageContext(), bj.dqO, this.hpU.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), bj.dqP, this.hpU.getUniqueId());
        w wVar = new w(frsGoodFragment.getTbPageContext(), bj.dri, this.hpU.getUniqueId());
        z zVar = new z(frsGoodFragment.getPageContext(), bj.dqV, this.hpU.getUniqueId());
        r rVar = new r(frsGoodFragment.getPageContext(), bj.dqT, this.hpU.getUniqueId());
        u uVar = new u(frsGoodFragment.getPageContext(), bj.dqU, this.hpU.getUniqueId());
        z zVar2 = new z(frsGoodFragment.getPageContext(), bj.drd, this.hpU.getUniqueId());
        com.baidu.tieba.frs.o oVar2 = new com.baidu.tieba.frs.o(frsGoodFragment.getPageContext(), p.hbj);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends y.a> a = c.bNN().a(frsGoodFragment.getPageContext(), this.hpU.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends y.a> b = c.bNN().b(frsGoodFragment.getPageContext(), bj.dsJ, this.hpU.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = q.cNo().a(this.hpU, AdvertAppInfo.dlX);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = q.cNo().a(this.hpU, AdvertAppInfo.dmg);
        x xVar = new x(frsGoodFragment.getPageContext(), bj.dqZ, this.hpU.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsGoodFragment.getPageContext(), bj.drb, this.hpU.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsGoodFragment.getPageContext(), bj.dra, this.hpU.getUniqueId());
        i iVar = new i(frsGoodFragment.getPageContext(), bj.drc, this.hpU.getUniqueId());
        this.aMd.add(yVar);
        this.aMd.add(nVar);
        this.aMd.add(vVar);
        this.aMd.add(tVar);
        this.aMd.add(mVar);
        this.aMd.add(oVar);
        this.aMd.add(wVar);
        this.aMd.add(zVar);
        this.aMd.add(rVar);
        this.aMd.add(rVar);
        this.aMd.add(uVar);
        this.aMd.add(oVar2);
        this.aMd.add(zVar);
        this.aMd.add(zVar2);
        this.aMd.add(xVar);
        this.aMd.add(bVar);
        this.aMd.add(hVar);
        this.aMd.add(iVar);
        if (a != null) {
            this.aMd.add(a);
        }
        if (b != null) {
            this.aMd.add(b);
        }
        this.aMd.add(a2);
        this.aMd.add(a3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.hpU.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.hpU, 1);
        bVar2.setExtraData(this.aMd);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.aMd);
        yc("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
            if (aVar instanceof com.baidu.tieba.card.y) {
                ((com.baidu.tieba.card.y) aVar).lz(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
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
        bQI();
        as(arrayList);
        com.baidu.tieba.tbadkCore.t.q(arrayList, 1);
        ar(arrayList);
        ArrayList<m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.hcS.setData(switchThreadDataToThreadCardInfo);
        this.hqo = switchThreadDataToThreadCardInfo;
        this.gxX = arrayList;
        this.hhr = frsViewData;
        bRm();
    }

    public void refreshData() {
        this.hcS.setData(this.hqo);
        notifyDataSetChanged();
    }

    private void bQI() {
        if (!v.isEmpty(this.aMd) && this.hpU != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.hpU.getTbPageTag());
                }
            }
        }
    }

    private void bRm() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.hhr != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if ((aVar instanceof d) && (statisticMetaData = ((d) aVar).getStatisticMetaData()) != null) {
                    if (this.hhr.needLog == 1) {
                        statisticMetaData.htU = true;
                    } else {
                        statisticMetaData.htU = false;
                    }
                    if (this.hhr.getForum() != null) {
                        statisticMetaData.htW = this.hhr.getForum().getId();
                    }
                    if (this.hpU != null) {
                        statisticMetaData.htV = 5;
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
                    if ((mVar instanceof AdvertAppInfo) && this.hhq != null && !this.hhq.containsValue(mVar)) {
                        this.hhq.put(Integer.valueOf(i2), (bj) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bj> bRR() {
        return this.hhq;
    }

    public void bRW() {
        if (this.hcS != null && this.hcS.getData() != null && this.hcS.getData().size() != 0) {
            for (m mVar : this.hcS.getData()) {
                if ((mVar instanceof bi) && ((bi) mVar).dqA.aKz() != 0) {
                    ((bi) mVar).dqA.aLz();
                }
            }
        }
    }

    public void bTz() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
            if (aVar instanceof com.baidu.tieba.card.x) {
                ((com.baidu.tieba.card.x) aVar).pV(3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hcS.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.hcS.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.aMd != null && this.aMd.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof h) {
                    ((h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.aMd != null && this.aMd.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aMd != null && this.aMd.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
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
                if (it.next().getType() == bj.dqD) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.hpU != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.hpU.registerListener(this.hqp);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.hpU == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.hqn = new ArrayList();
        ArrayList<BdUniqueId> cVJ = com.baidu.tieba.tbadkCore.t.cVJ();
        if (cVJ == null || cVJ.size() <= 0) {
            return false;
        }
        int size = cVJ.size();
        for (int i = 0; i < size; i++) {
            h<ICardInfo, ? extends y.a> a = c.bNN().a(this.hpU.getPageContext(), cVJ.get(i), this.hpU.getUniqueId());
            if (a != null) {
                this.aMd.add(a);
                this.hqn.add(a);
            }
        }
        if (!v.isEmpty(this.hqn)) {
            bdTypeRecyclerView.addAdapters(this.hqn);
        }
        return true;
    }

    public boolean p(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void yc(String str) {
        if (this.aMd != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof f) {
                    ((f) aVar).yc(str);
                }
            }
        }
    }

    public List<m> getDataList() {
        return this.gxX;
    }

    public List<m> bTA() {
        return this.hqo;
    }
}
