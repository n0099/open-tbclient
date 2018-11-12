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
    private BdTypeRecyclerView dFK;
    private l dFM;
    private i dIe;
    private i dIf;
    private com.baidu.tieba.frs.entelechy.a.l dIg;
    private p dIh;
    private d dIi;
    private g dJa;
    private com.baidu.adp.widget.ListView.a dJc;
    private com.baidu.adp.widget.ListView.a dJd;
    private List<com.baidu.adp.widget.ListView.a> dJe;
    private final HashMap<Integer, bb> dJk;
    private com.baidu.tieba.tbadkCore.l dJl;
    private FrsGoodFragment dRN;
    private com.baidu.adp.widget.ListView.a dRO;
    private com.baidu.adp.widget.ListView.a dRP;
    private ArrayList<h> dgc;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dIk = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.a.1
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
                        ((com.baidu.tieba.frs.h) aVar).a(a.this.dRN.getPageContext(), a.this.dRN.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (a.this.mAdapters != null) {
                    a.this.mAdapters.addAll(arrayList);
                }
                if (a.this.dFK != null) {
                    a.this.dFK.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dJn = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.I(a.this.dJe)) {
                a.this.b(a.this.dFK);
                a.this.b(a.this.dgc, a.this.dJl);
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.dFK = bdTypeRecyclerView;
        this.dJk = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dRN = frsGoodFragment;
        this.dIk.setPriority(1);
        this.dIk.setSelfListener(true);
        this.dRN.registerListener(this.dIk);
        this.dIe = new i(frsGoodFragment.getPageContext(), bb.apG, this.dRN.getUniqueId());
        this.dIe.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dJa = new g(frsGoodFragment.getPageContext(), bb.apH, this.dRN.getUniqueId());
        this.dIf = new i(frsGoodFragment.getPageContext(), bb.apI, this.dRN.getUniqueId());
        this.dIf.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dIh = new p(frsGoodFragment.getPageContext(), bb.apJ, this.dRN.getUniqueId());
        this.dIi = new d(frsGoodFragment.getPageContext(), bb.apO, this.dRN.getUniqueId());
        this.dFM = new l(frsGoodFragment.getPageContext(), m.dEh);
        this.dJc = c.ayt().a(frsGoodFragment.getPageContext(), bb.ard, this.dRN.getUniqueId(), true);
        this.dJd = c.ayt().b(frsGoodFragment.getPageContext(), bb.arl, this.dRN.getUniqueId());
        this.dRO = r.bsG().a(this.dRN, AdvertAppInfo.aly);
        this.dRP = r.bsG().a(this.dRN, AdvertAppInfo.alH);
        this.dIg = new com.baidu.tieba.frs.entelechy.a.l(frsGoodFragment.getPageContext(), bb.apN, this.dRN.getUniqueId());
        this.mAdapters.add(this.dIe);
        this.mAdapters.add(this.dJa);
        this.mAdapters.add(this.dIe);
        this.mAdapters.add(this.dJa);
        this.mAdapters.add(this.dIf);
        this.mAdapters.add(this.dFM);
        this.mAdapters.add(this.dIh);
        this.mAdapters.add(this.dIi);
        this.mAdapters.add(this.dIg);
        if (this.dJc != null) {
            this.mAdapters.add(this.dJc);
        }
        if (this.dJd != null) {
            this.mAdapters.add(this.dJd);
        }
        this.mAdapters.add(this.dRO);
        this.mAdapters.add(this.dRP);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dRN.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        js("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof ac) {
                ((ac) aVar).fu(true);
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
        this.dFK.setData(arrayList);
        this.dgc = arrayList;
        this.dJl = lVar;
        aBx();
    }

    public void hg(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof ab) {
                ((ab) aVar).iv(z ? 15 : 3);
            }
        }
    }

    private void aBx() {
        com.baidu.tieba.frs.e.a aCh;
        if (this.dJl != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.e.c) && (aCh = ((com.baidu.tieba.frs.e.c) aVar).aCh()) != null) {
                    if (this.dJl.hbG == 1) {
                        aCh.dUJ = true;
                    } else {
                        aCh.dUJ = false;
                    }
                    if (this.dJl.ber() != null) {
                        aCh.dUL = this.dJl.ber().getId();
                    }
                    if (this.dRN != null) {
                        if (this.dRN.dRX) {
                            aCh.dUO = 8;
                        } else {
                            aCh.dUK = 5;
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
                if (this.dJk != null && !this.dJk.containsValue(hVar)) {
                    this.dJk.put(Integer.valueOf(i2), (bb) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    public HashMap<Integer, bb> aCa() {
        return this.dJk;
    }

    public void aCb() {
        if (this.dFK != null && this.dFK.getData() != null && this.dFK.getData().size() != 0) {
            for (h hVar : this.dFK.getData()) {
                if ((hVar instanceof bb) && ((bb) hVar).yx() != 0) {
                    ((bb) hVar).zm();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.dFK.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.dFK.getAdapter().notifyDataSetChanged();
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
                if (it.next().getType() == bb.apF) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dRN != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.dRN.registerListener(this.dJn);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dRN == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.dJe = new ArrayList();
        ArrayList<BdUniqueId> bAK = q.bAK();
        if (bAK == null || bAK.size() <= 0) {
            return false;
        }
        int size = bAK.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends q.a> a = c.ayt().a(this.dRN.getPageContext(), bAK.get(i), this.dRN.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dJe.add(a);
            }
        }
        if (!v.I(this.dJe)) {
            bdTypeRecyclerView.addAdapters(this.dJe);
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

    private void js(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).js(str);
                }
            }
        }
    }
}
