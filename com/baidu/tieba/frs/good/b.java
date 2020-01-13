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
/* loaded from: classes7.dex */
public class b {
    private ArrayList<m> fPW;
    private List<com.baidu.adp.widget.ListView.a> gDJ;
    private ArrayList<m> gDK;
    private FrsGoodFragment gDr;
    private BdTypeRecyclerView gqN;
    private final HashMap<Integer, bj> guV;
    private FrsViewData guW;
    private List<com.baidu.adp.widget.ListView.a> apl = new LinkedList();
    private CustomMessageListener gtx = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((h) aVar).a(b.this.gDr.getPageContext(), b.this.gDr.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.apl != null) {
                    b.this.apl.addAll(arrayList);
                }
                if (b.this.gqN != null) {
                    b.this.gqN.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener gDL = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.isEmpty(b.this.gDJ)) {
                b.this.b(b.this.gqN);
                b.this.b(b.this.fPW, b.this.guW);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.gqN = bdTypeRecyclerView;
        this.guV = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gDr = frsGoodFragment;
        this.gtx.setPriority(1);
        this.gtx.setSelfListener(true);
        this.gDr.registerListener(this.gtx);
        w wVar = new w(frsGoodFragment.getTbPageContext(), bj.cNj, this.gDr.getUniqueId());
        l lVar = new l(frsGoodFragment.getTbPageContext(), bj.cNk, this.gDr.getUniqueId());
        t tVar = new t(frsGoodFragment.getTbPageContext(), bj.cNm, this.gDr.getUniqueId());
        r rVar = new r(frsGoodFragment.getTbPageContext(), bj.cNn, this.gDr.getUniqueId());
        k kVar = new k(frsGoodFragment.getTbPageContext(), bj.cNp, this.gDr.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsGoodFragment.getTbPageContext(), bj.cNq, this.gDr.getUniqueId());
        u uVar = new u(frsGoodFragment.getTbPageContext(), bj.cNI, this.gDr.getUniqueId());
        x xVar = new x(frsGoodFragment.getPageContext(), bj.cNv, this.gDr.getUniqueId());
        p pVar = new p(frsGoodFragment.getPageContext(), bj.cNt, this.gDr.getUniqueId());
        s sVar = new s(frsGoodFragment.getPageContext(), bj.cNu, this.gDr.getUniqueId());
        x xVar2 = new x(frsGoodFragment.getPageContext(), bj.cND, this.gDr.getUniqueId());
        com.baidu.tieba.frs.m mVar2 = new com.baidu.tieba.frs.m(frsGoodFragment.getPageContext(), n.goX);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends v.a> a = c.bBC().a(frsGoodFragment.getPageContext(), this.gDr.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> b = c.bBC().b(frsGoodFragment.getPageContext(), bj.cPi, this.gDr.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.cAV().a(this.gDr, AdvertAppInfo.cIB);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.cAV().a(this.gDr, AdvertAppInfo.cIK);
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsGoodFragment.getPageContext(), bj.cNz, this.gDr.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsGoodFragment.getPageContext(), bj.cNB, this.gDr.getUniqueId());
        g gVar = new g(frsGoodFragment.getPageContext(), bj.cNA, this.gDr.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsGoodFragment.getPageContext(), bj.cNC, this.gDr.getUniqueId());
        this.apl.add(wVar);
        this.apl.add(lVar);
        this.apl.add(tVar);
        this.apl.add(rVar);
        this.apl.add(kVar);
        this.apl.add(mVar);
        this.apl.add(uVar);
        this.apl.add(xVar);
        this.apl.add(pVar);
        this.apl.add(pVar);
        this.apl.add(sVar);
        this.apl.add(mVar2);
        this.apl.add(xVar);
        this.apl.add(xVar2);
        this.apl.add(vVar);
        this.apl.add(bVar);
        this.apl.add(gVar);
        this.apl.add(hVar);
        if (a != null) {
            this.apl.add(a);
        }
        if (b != null) {
            this.apl.add(b);
        }
        this.apl.add(a2);
        this.apl.add(a3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.gDr.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.gDr, 1);
        bVar2.setExtraData(this.apl);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.apl);
        wu("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
            if (aVar instanceof y) {
                ((y) aVar).kp(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
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
        bEq();
        aq(arrayList);
        com.baidu.tieba.tbadkCore.s.o(arrayList, 1);
        ap(arrayList);
        ArrayList<m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.gqN.setData(switchThreadDataToThreadCardInfo);
        this.gDK = switchThreadDataToThreadCardInfo;
        this.fPW = arrayList;
        this.guW = frsViewData;
        bEU();
    }

    public void refreshData() {
        this.gqN.setData(this.gDK);
        notifyDataSetChanged();
    }

    private void bEq() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.apl) && this.gDr != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.gDr.getTbPageTag());
                }
            }
        }
    }

    private void bEU() {
        com.baidu.tieba.frs.d.b bFt;
        if (this.guW != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if ((aVar instanceof d) && (bFt = ((d) aVar).bFt()) != null) {
                    if (this.guW.needLog == 1) {
                        bFt.gHl = true;
                    } else {
                        bFt.gHl = false;
                    }
                    if (this.guW.getForum() != null) {
                        bFt.gHn = this.guW.getForum().getId();
                    }
                    if (this.gDr != null) {
                        if (this.gDr.gDk) {
                            bFt.gHq = 8;
                        } else {
                            bFt.gHm = 5;
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
                    if ((mVar instanceof AdvertAppInfo) && this.guV != null && !this.guV.containsValue(mVar)) {
                        this.guV.put(Integer.valueOf(i2), (bj) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bj> bFw() {
        return this.guV;
    }

    public void bFB() {
        if (this.gqN != null && this.gqN.getData() != null && this.gqN.getData().size() != 0) {
            for (m mVar : this.gqN.getData()) {
                if ((mVar instanceof bi) && ((bi) mVar).cNb.azS() != 0) {
                    ((bi) mVar).cNb.aAT();
                }
            }
        }
    }

    public void lU(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
            if (aVar instanceof com.baidu.tieba.card.x) {
                ((com.baidu.tieba.card.x) aVar).po(z ? 15 : 3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.gqN.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.gqN.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.apl != null && this.apl.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar instanceof h) {
                    ((h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.apl != null && this.apl.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        if (this.apl != null && this.apl.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
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
                if (it.next().getType() == bj.cNe) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gDr != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.gDr.registerListener(this.gDL);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gDr == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.gDJ = new ArrayList();
        ArrayList<BdUniqueId> cIK = com.baidu.tieba.tbadkCore.s.cIK();
        if (cIK == null || cIK.size() <= 0) {
            return false;
        }
        int size = cIK.size();
        for (int i = 0; i < size; i++) {
            h<ICardInfo, ? extends v.a> a = c.bBC().a(this.gDr.getPageContext(), cIK.get(i), this.gDr.getUniqueId());
            if (a != null) {
                this.apl.add(a);
                this.gDJ.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gDJ)) {
            bdTypeRecyclerView.addAdapters(this.gDJ);
        }
        return true;
    }

    public boolean p(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void wu(String str) {
        if (this.apl != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar instanceof f) {
                    ((f) aVar).wu(str);
                }
            }
        }
    }

    public List<m> getDataList() {
        return this.fPW;
    }

    public List<m> bHm() {
        return this.gDK;
    }
}
