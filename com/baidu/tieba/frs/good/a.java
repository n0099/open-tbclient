package com.baidu.tieba.frs.good;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.a.f;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ac;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.c;
import com.baidu.tieba.frs.entelechy.a.d;
import com.baidu.tieba.frs.entelechy.a.g;
import com.baidu.tieba.frs.entelechy.a.i;
import com.baidu.tieba.frs.entelechy.a.p;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private BdTypeRecyclerView dOX;
    private l dOZ;
    private i dRr;
    private i dRs;
    private com.baidu.tieba.frs.entelechy.a.l dRt;
    private p dRu;
    private d dRv;
    private final HashMap<Integer, bb> dSB;
    private com.baidu.tieba.tbadkCore.l dSC;
    private g dSr;
    private com.baidu.adp.widget.ListView.a dSt;
    private com.baidu.adp.widget.ListView.a dSu;
    private List<com.baidu.adp.widget.ListView.a> dSv;
    private ArrayList<h> dpB;
    private FrsGoodFragment ebg;
    private com.baidu.adp.widget.ListView.a ebh;
    private com.baidu.adp.widget.ListView.a ebi;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dRx = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.a.1
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
                    if (aVar instanceof com.baidu.tieba.frs.h) {
                        ((com.baidu.tieba.frs.h) aVar).a(a.this.ebg.getPageContext(), a.this.ebg.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (a.this.mAdapters != null) {
                    a.this.mAdapters.addAll(arrayList);
                }
                if (a.this.dOX != null) {
                    a.this.dOX.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dSF = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.I(a.this.dSv)) {
                a.this.b(a.this.dOX);
                a.this.b(a.this.dpB, a.this.dSC);
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.dOX = bdTypeRecyclerView;
        this.dSB = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.ebg = frsGoodFragment;
        this.dRx.setPriority(1);
        this.dRx.setSelfListener(true);
        this.ebg.registerListener(this.dRx);
        this.dRr = new i(frsGoodFragment.getPageContext(), bb.atg, this.ebg.getUniqueId());
        this.dRr.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dSr = new g(frsGoodFragment.getPageContext(), bb.ath, this.ebg.getUniqueId());
        this.dRs = new i(frsGoodFragment.getPageContext(), bb.ati, this.ebg.getUniqueId());
        this.dRs.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dRu = new p(frsGoodFragment.getPageContext(), bb.atj, this.ebg.getUniqueId());
        this.dRv = new d(frsGoodFragment.getPageContext(), bb.ato, this.ebg.getUniqueId());
        this.dOZ = new l(frsGoodFragment.getPageContext(), m.dNu);
        this.dSt = c.aAS().a(frsGoodFragment.getPageContext(), bb.auD, this.ebg.getUniqueId(), true);
        this.dSu = c.aAS().b(frsGoodFragment.getPageContext(), bb.auL, this.ebg.getUniqueId());
        this.ebh = r.bvk().a(this.ebg, AdvertAppInfo.aoY);
        this.ebi = r.bvk().a(this.ebg, AdvertAppInfo.aph);
        this.dRt = new com.baidu.tieba.frs.entelechy.a.l(frsGoodFragment.getPageContext(), bb.atn, this.ebg.getUniqueId());
        this.mAdapters.add(this.dRr);
        this.mAdapters.add(this.dSr);
        this.mAdapters.add(this.dRr);
        this.mAdapters.add(this.dSr);
        this.mAdapters.add(this.dRs);
        this.mAdapters.add(this.dOZ);
        this.mAdapters.add(this.dRu);
        this.mAdapters.add(this.dRv);
        this.mAdapters.add(this.dRt);
        if (this.dSt != null) {
            this.mAdapters.add(this.dSt);
        }
        if (this.dSu != null) {
            this.mAdapters.add(this.dSu);
        }
        this.mAdapters.add(this.ebh);
        this.mAdapters.add(this.ebi);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.ebg.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        jL("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof ac) {
                ((ac) aVar).fx(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    public void b(ArrayList<h> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        b(lVar);
        S(arrayList);
        q.q(arrayList, 1);
        Q(arrayList);
        this.dOX.setData(arrayList);
        this.dpB = arrayList;
        this.dSC = lVar;
        aDW();
    }

    public void hl(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof ab) {
                ((ab) aVar).iK(z ? 15 : 3);
            }
        }
    }

    private void aDW() {
        com.baidu.tieba.frs.e.b aEI;
        if (this.dSC != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.e.d) && (aEI = ((com.baidu.tieba.frs.e.d) aVar).aEI()) != null) {
                    if (this.dSC.hlK == 1) {
                        aEI.eed = true;
                    } else {
                        aEI.eed = false;
                    }
                    if (this.dSC.bgT() != null) {
                        aEI.eef = this.dSC.bgT().getId();
                    }
                    if (this.ebg != null) {
                        if (this.ebg.ebq) {
                            aEI.eei = 8;
                        } else {
                            aEI.eee = 5;
                        }
                    }
                }
            }
        }
    }

    private ArrayList<Integer> Q(ArrayList<h> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return arrayList2;
            }
            h hVar = arrayList.get(i2);
            if (hVar instanceof AdvertAppInfo) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.dSB != null && !this.dSB.containsValue(hVar)) {
                    this.dSB.put(Integer.valueOf(i2), (bb) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    public HashMap<Integer, bb> aEB() {
        return this.dSB;
    }

    public void aEC() {
        if (this.dOX != null && this.dOX.getData() != null && this.dOX.getData().size() != 0) {
            for (h hVar : this.dOX.getData()) {
                if ((hVar instanceof bb) && ((bb) hVar).zB() != 0) {
                    ((bb) hVar).Aq();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.dOX.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.dOX.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).b(lVar);
                }
            }
        }
    }

    public void setOnAdapterItemClickListener(n nVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.h)) {
                    ((com.baidu.tieba.frs.h) aVar).setOnAdapterItemClickListener(nVar);
                }
            }
        }
    }

    private void S(ArrayList<h> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<h> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bb.atf) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.ebg != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.ebg.registerListener(this.dSF);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.ebg == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.dSv = new ArrayList();
        ArrayList<BdUniqueId> bDw = q.bDw();
        if (bDw == null || bDw.size() <= 0) {
            return false;
        }
        int size = bDw.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends q.a> a = c.aAS().a(this.ebg.getPageContext(), bDw.get(i), this.ebg.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dSv.add(a);
            }
        }
        if (!v.I(this.dSv)) {
            bdTypeRecyclerView.addAdapters(this.dSv);
        }
        return true;
    }

    public boolean k(BdUniqueId bdUniqueId) {
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

    private void jL(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).jL(str);
                }
            }
        }
    }
}
