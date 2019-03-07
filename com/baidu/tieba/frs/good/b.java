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
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.c;
import com.baidu.tieba.frs.d.d;
import com.baidu.tieba.frs.entelechy.a.f;
import com.baidu.tieba.frs.entelechy.a.g;
import com.baidu.tieba.frs.entelechy.a.k;
import com.baidu.tieba.frs.entelechy.a.n;
import com.baidu.tieba.frs.entelechy.a.o;
import com.baidu.tieba.frs.entelechy.a.p;
import com.baidu.tieba.frs.entelechy.a.q;
import com.baidu.tieba.frs.entelechy.a.r;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private ArrayList<m> eAl;
    private BdTypeRecyclerView fdC;
    private final HashMap<Integer, bg> fhr;
    private FrsViewData fhs;
    private FrsGoodFragment fpH;
    private List<com.baidu.adp.widget.ListView.a> fqa;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener fgg = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((h) aVar).a(b.this.fpH.getPageContext(), b.this.fpH.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(arrayList);
                }
                if (b.this.fdC != null) {
                    b.this.fdC.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener fqb = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.T(b.this.fqa)) {
                b.this.b(b.this.fdC);
                b.this.b(b.this.eAl, b.this.fhs);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.fdC = bdTypeRecyclerView;
        this.fhr = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fpH = frsGoodFragment;
        this.fgg.setPriority(1);
        this.fgg.setSelfListener(true);
        this.fpH.registerListener(this.fgg);
        q qVar = new q(frsGoodFragment.getTbPageContext(), bg.bAS, this.fpH.getUniqueId());
        qVar.setInFrsAllThread(true);
        g gVar = new g(frsGoodFragment.getTbPageContext(), bg.bAT, this.fpH.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), bg.bAV, this.fpH.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsGoodFragment.getTbPageContext(), bg.bAW, this.fpH.getUniqueId());
        f fVar = new f(frsGoodFragment.getTbPageContext(), bg.bAX, this.fpH.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsGoodFragment.getTbPageContext(), bg.bAY, this.fpH.getUniqueId());
        r rVar = new r(frsGoodFragment.getPageContext(), bg.bBb, this.fpH.getUniqueId());
        rVar.setInFrsAllThread(true);
        k kVar = new k(frsGoodFragment.getPageContext(), bg.bAZ, this.fpH.getUniqueId());
        n nVar = new n(frsGoodFragment.getPageContext(), bg.bBa, this.fpH.getUniqueId());
        nVar.setVoiceManager(frsGoodFragment.getVoiceManager());
        r rVar2 = new r(frsGoodFragment.getPageContext(), bg.bBg, this.fpH.getUniqueId());
        l lVar = new l(frsGoodFragment.getPageContext(), com.baidu.tieba.frs.m.fbK);
        com.baidu.adp.widget.ListView.a<? extends bf, ? extends v.a> a = c.bbO().a(frsGoodFragment.getPageContext(), this.fpH.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> b = c.bbO().b(frsGoodFragment.getPageContext(), bg.bCG, this.fpH.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.bWG().a(this.fpH, AdvertAppInfo.bwk);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.bWG().a(this.fpH, AdvertAppInfo.bwt);
        p pVar = new p(frsGoodFragment.getPageContext(), bg.bBf, this.fpH.getUniqueId());
        this.mAdapters.add(qVar);
        this.mAdapters.add(gVar);
        this.mAdapters.add(oVar);
        this.mAdapters.add(mVar);
        this.mAdapters.add(fVar);
        this.mAdapters.add(hVar);
        this.mAdapters.add(rVar);
        this.mAdapters.add(kVar);
        this.mAdapters.add(kVar);
        this.mAdapters.add(nVar);
        this.mAdapters.add(lVar);
        this.mAdapters.add(rVar);
        this.mAdapters.add(rVar2);
        this.mAdapters.add(pVar);
        if (a != null) {
            this.mAdapters.add(a);
        }
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.mAdapters.add(a2);
        this.mAdapters.add(a3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.fpH.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        qM("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof aa) {
                ((aa) aVar).hS(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    public void b(ArrayList<m> arrayList, FrsViewData frsViewData) {
        if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof com.baidu.tieba.frs.m)) {
            frsViewData.setThreadList(arrayList);
        }
        b(frsViewData);
        W(arrayList);
        com.baidu.tieba.tbadkCore.q.p(arrayList, 1);
        V(arrayList);
        this.fdC.setData(frsViewData.switchThreadDataToThreadCardInfo());
        this.eAl = arrayList;
        this.fhs = frsViewData;
        bfc();
    }

    private void bfc() {
        com.baidu.tieba.frs.d.b bfz;
        if (this.fhs != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof d) && (bfz = ((d) aVar).bfz()) != null) {
                    if (this.fhs.needLog == 1) {
                        bfz.ftb = true;
                    } else {
                        bfz.ftb = false;
                    }
                    if (this.fhs.getForum() != null) {
                        bfz.ftd = this.fhs.getForum().getId();
                    }
                    if (this.fpH != null) {
                        if (this.fpH.fpA) {
                            bfz.ftg = 8;
                        } else {
                            bfz.ftc = 5;
                        }
                    }
                }
            }
        }
    }

    private void V(ArrayList<m> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    m mVar = arrayList.get(i2);
                    if ((mVar instanceof AdvertAppInfo) && this.fhr != null && !this.fhr.containsValue(mVar)) {
                        this.fhr.put(Integer.valueOf(i2), (bg) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bg> bfA() {
        return this.fhr;
    }

    public void bfF() {
        if (this.fdC != null && this.fdC.getData() != null && this.fdC.getData().size() != 0) {
            for (m mVar : this.fdC.getData()) {
                if ((mVar instanceof bf) && ((bf) mVar).threadData.YM() != 0) {
                    ((bf) mVar).threadData.ZH();
                }
            }
        }
    }

    public void jL(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof z) {
                ((z) aVar).mD(z ? 15 : 3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.fdC.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.fdC.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof h) {
                    ((h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void setOnAdapterItemClickListener(s sVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar != null && (aVar instanceof h)) {
                    ((h) aVar).setOnAdapterItemClickListener(sVar);
                }
            }
        }
    }

    private void W(ArrayList<m> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<m> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bg.bAN) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.fpH != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.fpH.registerListener(this.fqb);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.fpH == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.fqa = new ArrayList();
        ArrayList<BdUniqueId> cdD = com.baidu.tieba.tbadkCore.q.cdD();
        if (cdD == null || cdD.size() <= 0) {
            return false;
        }
        int size = cdD.size();
        for (int i = 0; i < size; i++) {
            h<ICardInfo, ? extends v.a> a = c.bbO().a(this.fpH.getPageContext(), cdD.get(i), this.fpH.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.fqa.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.T(this.fqa)) {
            bdTypeRecyclerView.addAdapters(this.fqa);
        }
        return true;
    }

    public boolean l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void qM(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).qM(str);
                }
            }
        }
    }
}
