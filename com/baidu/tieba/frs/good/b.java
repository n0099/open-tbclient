package com.baidu.tieba.frs.good;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.a.f;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.c;
import com.baidu.tieba.frs.d.d;
import com.baidu.tieba.frs.entelechy.a.i;
import com.baidu.tieba.frs.entelechy.a.m;
import com.baidu.tieba.frs.entelechy.a.n;
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
    private ArrayList<o> gMY;
    private FrsGoodFragment hFB;
    private List<com.baidu.adp.widget.ListView.a> hFU;
    private ArrayList<o> hFV;
    private BdTypeRecyclerView hrX;
    private final HashMap<Integer, bk> hwv;
    private FrsViewData hww;
    private List<com.baidu.adp.widget.ListView.a> aSj = new LinkedList();
    private CustomMessageListener huJ = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((h) aVar).a(b.this.hFB.getPageContext(), b.this.hFB.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.aSj != null) {
                    b.this.aSj.addAll(arrayList);
                }
                if (b.this.hrX != null) {
                    b.this.hrX.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener hFW = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.isEmpty(b.this.hFU)) {
                b.this.b(b.this.hrX);
                b.this.b(b.this.gMY, b.this.hww);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.hrX = bdTypeRecyclerView;
        this.hwv = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hFB = frsGoodFragment;
        this.huJ.setPriority(1);
        this.huJ.setSelfListener(true);
        this.hFB.registerListener(this.huJ);
        y yVar = new y(frsGoodFragment.getTbPageContext(), bk.dEI, this.hFB.getUniqueId());
        n nVar = new n(frsGoodFragment.getTbPageContext(), bk.dEJ, this.hFB.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsGoodFragment.getTbPageContext(), bk.dEL, this.hFB.getUniqueId());
        t tVar = new t(frsGoodFragment.getTbPageContext(), bk.dEM, this.hFB.getUniqueId());
        m mVar = new m(frsGoodFragment.getTbPageContext(), bk.dEO, this.hFB.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.o oVar = new com.baidu.tieba.frs.entelechy.a.o(frsGoodFragment.getTbPageContext(), bk.dEP, this.hFB.getUniqueId());
        w wVar = new w(frsGoodFragment.getTbPageContext(), bk.dFi, this.hFB.getUniqueId());
        z zVar = new z(frsGoodFragment.getPageContext(), bk.dEV, this.hFB.getUniqueId());
        r rVar = new r(frsGoodFragment.getPageContext(), bk.dET, this.hFB.getUniqueId());
        u uVar = new u(frsGoodFragment.getPageContext(), bk.dEU, this.hFB.getUniqueId());
        z zVar2 = new z(frsGoodFragment.getPageContext(), bk.dFd, this.hFB.getUniqueId());
        com.baidu.tieba.frs.o oVar2 = new com.baidu.tieba.frs.o(frsGoodFragment.getPageContext(), p.hqo);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends aa.a> a = c.bUj().a(frsGoodFragment.getPageContext(), this.hFB.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bk, ? extends aa.a> b = c.bUj().b(frsGoodFragment.getPageContext(), bk.dGH, this.hFB.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = q.cUC().a(this.hFB, AdvertAppInfo.dAd);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = q.cUC().a(this.hFB, AdvertAppInfo.dAm);
        x xVar = new x(frsGoodFragment.getPageContext(), bk.dEZ, this.hFB.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsGoodFragment.getPageContext(), bk.dFb, this.hFB.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsGoodFragment.getPageContext(), bk.dFa, this.hFB.getUniqueId());
        i iVar = new i(frsGoodFragment.getPageContext(), bk.dFc, this.hFB.getUniqueId());
        this.aSj.add(yVar);
        this.aSj.add(nVar);
        this.aSj.add(vVar);
        this.aSj.add(tVar);
        this.aSj.add(mVar);
        this.aSj.add(oVar);
        this.aSj.add(wVar);
        this.aSj.add(zVar);
        this.aSj.add(rVar);
        this.aSj.add(rVar);
        this.aSj.add(uVar);
        this.aSj.add(oVar2);
        this.aSj.add(zVar);
        this.aSj.add(zVar2);
        this.aSj.add(xVar);
        this.aSj.add(bVar);
        this.aSj.add(hVar);
        this.aSj.add(iVar);
        if (a != null) {
            this.aSj.add(a);
        }
        if (b != null) {
            this.aSj.add(b);
        }
        this.aSj.add(a2);
        this.aSj.add(a3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.hFB.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.hFB, 1);
        bVar2.setExtraData(this.aSj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.aSj);
        zL("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
            if (aVar instanceof com.baidu.tieba.card.z) {
                ((com.baidu.tieba.card.z) aVar).lV(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    public void b(ArrayList<o> arrayList, FrsViewData frsViewData) {
        if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof p)) {
            frsViewData.setThreadList(arrayList);
        }
        b(frsViewData);
        bXf();
        as(arrayList);
        com.baidu.tieba.tbadkCore.t.s(arrayList, 1);
        ar(arrayList);
        ArrayList<o> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.hrX.setData(switchThreadDataToThreadCardInfo);
        this.hFV = switchThreadDataToThreadCardInfo;
        this.gMY = arrayList;
        this.hww = frsViewData;
        bXJ();
    }

    public void refreshData() {
        this.hrX.setData(this.hFV);
        notifyDataSetChanged();
    }

    private void bXf() {
        if (!v.isEmpty(this.aSj) && this.hFB != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.hFB.getTbPageTag());
                }
            }
        }
    }

    private void bXJ() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.hww != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if ((aVar instanceof d) && (statisticMetaData = ((d) aVar).getStatisticMetaData()) != null) {
                    if (this.hww.needLog == 1) {
                        statisticMetaData.hJA = true;
                    } else {
                        statisticMetaData.hJA = false;
                    }
                    if (this.hww.getForum() != null) {
                        statisticMetaData.hJC = this.hww.getForum().getId();
                    }
                    if (this.hFB != null) {
                        statisticMetaData.hJB = 5;
                    }
                }
            }
        }
    }

    private void ar(ArrayList<o> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    o oVar = arrayList.get(i2);
                    if ((oVar instanceof AdvertAppInfo) && this.hwv != null && !this.hwv.containsValue(oVar)) {
                        this.hwv.put(Integer.valueOf(i2), (bk) oVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bk> bYp() {
        return this.hwv;
    }

    public void bYu() {
        if (this.hrX != null && this.hrX.getData() != null && this.hrX.getData().size() != 0) {
            for (o oVar : this.hrX.getData()) {
                if ((oVar instanceof bj) && ((bj) oVar).dEA.aQs() != 0) {
                    ((bj) oVar).dEA.aRw();
                }
            }
        }
    }

    public void cac() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
            if (aVar instanceof com.baidu.tieba.card.y) {
                ((com.baidu.tieba.card.y) aVar).qy(3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hrX.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.hrX.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.aSj != null && this.aSj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof h) {
                    ((h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.aSj != null && this.aSj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        if (this.aSj != null && this.aSj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar != null && (aVar instanceof h)) {
                    ((h) aVar).a(xVar);
                }
            }
        }
    }

    private void as(ArrayList<o> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<o> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bk.dED) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.hFB != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.hFB.registerListener(this.hFW);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.hFB == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.hFU = new ArrayList();
        ArrayList<BdUniqueId> dda = com.baidu.tieba.tbadkCore.t.dda();
        if (dda == null || dda.size() <= 0) {
            return false;
        }
        int size = dda.size();
        for (int i = 0; i < size; i++) {
            h<ICardInfo, ? extends aa.a> a = c.bUj().a(this.hFB.getPageContext(), dda.get(i), this.hFB.getUniqueId());
            if (a != null) {
                this.aSj.add(a);
                this.hFU.add(a);
            }
        }
        if (!v.isEmpty(this.hFU)) {
            bdTypeRecyclerView.addAdapters(this.hFU);
        }
        return true;
    }

    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void zL(String str) {
        if (this.aSj != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof f) {
                    ((f) aVar).zL(str);
                }
            }
        }
    }

    public List<o> getDataList() {
        return this.gMY;
    }

    public List<o> cad() {
        return this.hFV;
    }
}
