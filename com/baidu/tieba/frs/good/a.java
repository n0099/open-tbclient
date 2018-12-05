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
    private BdTypeRecyclerView dMj;
    private l dMl;
    private i dOD;
    private i dOE;
    private com.baidu.tieba.frs.entelechy.a.l dOF;
    private p dOG;
    private d dOH;
    private g dPD;
    private com.baidu.adp.widget.ListView.a dPF;
    private com.baidu.adp.widget.ListView.a dPG;
    private List<com.baidu.adp.widget.ListView.a> dPH;
    private final HashMap<Integer, bb> dPN;
    private com.baidu.tieba.tbadkCore.l dPO;
    private FrsGoodFragment dYp;
    private com.baidu.adp.widget.ListView.a dYq;
    private com.baidu.adp.widget.ListView.a dYr;
    private ArrayList<h> dmJ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dOJ = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.a.1
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
                        ((com.baidu.tieba.frs.h) aVar).a(a.this.dYp.getPageContext(), a.this.dYp.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (a.this.mAdapters != null) {
                    a.this.mAdapters.addAll(arrayList);
                }
                if (a.this.dMj != null) {
                    a.this.dMj.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dPQ = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.I(a.this.dPH)) {
                a.this.b(a.this.dMj);
                a.this.b(a.this.dmJ, a.this.dPO);
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.dMj = bdTypeRecyclerView;
        this.dPN = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dYp = frsGoodFragment;
        this.dOJ.setPriority(1);
        this.dOJ.setSelfListener(true);
        this.dYp.registerListener(this.dOJ);
        this.dOD = new i(frsGoodFragment.getPageContext(), bb.atg, this.dYp.getUniqueId());
        this.dOD.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dPD = new g(frsGoodFragment.getPageContext(), bb.ath, this.dYp.getUniqueId());
        this.dOE = new i(frsGoodFragment.getPageContext(), bb.ati, this.dYp.getUniqueId());
        this.dOE.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dOG = new p(frsGoodFragment.getPageContext(), bb.atj, this.dYp.getUniqueId());
        this.dOH = new d(frsGoodFragment.getPageContext(), bb.ato, this.dYp.getUniqueId());
        this.dMl = new l(frsGoodFragment.getPageContext(), m.dKG);
        this.dPF = c.aAd().a(frsGoodFragment.getPageContext(), bb.auD, this.dYp.getUniqueId(), true);
        this.dPG = c.aAd().b(frsGoodFragment.getPageContext(), bb.auL, this.dYp.getUniqueId());
        this.dYq = r.buz().a(this.dYp, AdvertAppInfo.aoY);
        this.dYr = r.buz().a(this.dYp, AdvertAppInfo.aph);
        this.dOF = new com.baidu.tieba.frs.entelechy.a.l(frsGoodFragment.getPageContext(), bb.atn, this.dYp.getUniqueId());
        this.mAdapters.add(this.dOD);
        this.mAdapters.add(this.dPD);
        this.mAdapters.add(this.dOD);
        this.mAdapters.add(this.dPD);
        this.mAdapters.add(this.dOE);
        this.mAdapters.add(this.dMl);
        this.mAdapters.add(this.dOG);
        this.mAdapters.add(this.dOH);
        this.mAdapters.add(this.dOF);
        if (this.dPF != null) {
            this.mAdapters.add(this.dPF);
        }
        if (this.dPG != null) {
            this.mAdapters.add(this.dPG);
        }
        this.mAdapters.add(this.dYq);
        this.mAdapters.add(this.dYr);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dYp.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        jK("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof ac) {
                ((ac) aVar).fv(true);
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
        this.dMj.setData(arrayList);
        this.dmJ = arrayList;
        this.dPO = lVar;
        aDh();
    }

    public void hi(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof ab) {
                ((ab) aVar).iJ(z ? 15 : 3);
            }
        }
    }

    private void aDh() {
        com.baidu.tieba.frs.e.a aDT;
        if (this.dPO != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.e.c) && (aDT = ((com.baidu.tieba.frs.e.c) aVar).aDT()) != null) {
                    if (this.dPO.hiz == 1) {
                        aDT.ebm = true;
                    } else {
                        aDT.ebm = false;
                    }
                    if (this.dPO.bgi() != null) {
                        aDT.ebo = this.dPO.bgi().getId();
                    }
                    if (this.dYp != null) {
                        if (this.dYp.dYz) {
                            aDT.ebr = 8;
                        } else {
                            aDT.ebn = 5;
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
                if (this.dPN != null && !this.dPN.containsValue(hVar)) {
                    this.dPN.put(Integer.valueOf(i2), (bb) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    public HashMap<Integer, bb> aDM() {
        return this.dPN;
    }

    public void aDN() {
        if (this.dMj != null && this.dMj.getData() != null && this.dMj.getData().size() != 0) {
            for (h hVar : this.dMj.getData()) {
                if ((hVar instanceof bb) && ((bb) hVar).zB() != 0) {
                    ((bb) hVar).Aq();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.dMj.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.dMj.getAdapter().notifyDataSetChanged();
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
        if (this.dYp != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.dYp.registerListener(this.dPQ);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dYp == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.dPH = new ArrayList();
        ArrayList<BdUniqueId> bCF = q.bCF();
        if (bCF == null || bCF.size() <= 0) {
            return false;
        }
        int size = bCF.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends q.a> a = c.aAd().a(this.dYp.getPageContext(), bCF.get(i), this.dYp.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dPH.add(a);
            }
        }
        if (!v.I(this.dPH)) {
            bdTypeRecyclerView.addAdapters(this.dPH);
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

    private void jK(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).jK(str);
                }
            }
        }
    }
}
