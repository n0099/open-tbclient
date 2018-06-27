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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes2.dex */
public class a {
    private ArrayList<h> cOi;
    private BdTypeRecyclerView dnn;
    private l dnp;
    private i dpP;
    private i dpQ;
    private com.baidu.tieba.frs.entelechy.a.l dpR;
    private p dpS;
    private d dpT;
    private g dqG;
    private com.baidu.adp.widget.ListView.a dqI;
    private com.baidu.adp.widget.ListView.a dqJ;
    private List<com.baidu.adp.widget.ListView.a> dqK;
    private final HashMap<Integer, bc> dqQ;
    private com.baidu.tieba.tbadkCore.l dqR;
    private FrsGoodFragment dzn;
    private com.baidu.adp.widget.ListView.a dzo;
    private com.baidu.adp.widget.ListView.a dzp;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dpU = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.a.1
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
                        ((com.baidu.tieba.frs.h) aVar).a(a.this.dzn.getPageContext(), a.this.dzn.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (a.this.mAdapters != null) {
                    a.this.mAdapters.addAll(arrayList);
                }
                if (a.this.dnn != null) {
                    a.this.dnn.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dqT = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && w.A(a.this.dqK)) {
                a.this.b(a.this.dnn);
                a.this.b(a.this.cOi, a.this.dqR);
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.dnn = bdTypeRecyclerView;
        this.dqQ = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dzn = frsGoodFragment;
        this.dpU.setPriority(1);
        this.dpU.setSelfListener(true);
        this.dzn.registerListener(this.dpU);
        this.dpP = new i(frsGoodFragment.getPageContext(), bc.aib, this.dzn.getUniqueId());
        this.dpP.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dqG = new g(frsGoodFragment.getPageContext(), bc.aic, this.dzn.getUniqueId());
        this.dpQ = new i(frsGoodFragment.getPageContext(), bc.aid, this.dzn.getUniqueId());
        this.dpQ.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dpS = new p(frsGoodFragment.getPageContext(), bc.aie, this.dzn.getUniqueId());
        this.dpT = new d(frsGoodFragment.getPageContext(), bc.aij, this.dzn.getUniqueId());
        this.dnp = new l(frsGoodFragment.getPageContext(), m.dmd);
        this.dqI = c.atf().a(frsGoodFragment.getPageContext(), bc.ajw, this.dzn.getUniqueId(), true);
        this.dqJ = c.atf().b(frsGoodFragment.getPageContext(), bc.ajE, this.dzn.getUniqueId());
        this.dzo = r.boJ().a(this.dzn, AdvertAppInfo.adJ);
        this.dzp = r.boJ().a(this.dzn, AdvertAppInfo.adS);
        this.dpR = new com.baidu.tieba.frs.entelechy.a.l(frsGoodFragment.getPageContext(), bc.aii, this.dzn.getUniqueId());
        this.mAdapters.add(this.dpP);
        this.mAdapters.add(this.dqG);
        this.mAdapters.add(this.dpP);
        this.mAdapters.add(this.dqG);
        this.mAdapters.add(this.dpQ);
        this.mAdapters.add(this.dnp);
        this.mAdapters.add(this.dpS);
        this.mAdapters.add(this.dpT);
        this.mAdapters.add(this.dpR);
        if (this.dqI != null) {
            this.mAdapters.add(this.dqI);
        }
        if (this.dqJ != null) {
            this.mAdapters.add(this.dqJ);
        }
        this.mAdapters.add(this.dzo);
        this.mAdapters.add(this.dzp);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dzn.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        iD("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof ac) {
                ((ac) aVar).ez(true);
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
        T(arrayList);
        q.p(arrayList, 1);
        R(arrayList);
        this.dnn.setData(arrayList);
        this.cOi = arrayList;
        this.dqR = lVar;
        awA();
    }

    public void gh(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof ab) {
                ((ab) aVar).hf(z ? 15 : 3);
            }
        }
    }

    private void awA() {
        if (this.dqR != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (cVar.awC() != null) {
                        if (this.dqR.gKm == 1) {
                            cVar.awC().dBR = true;
                        } else {
                            cVar.awC().dBR = false;
                        }
                        if (this.dqR.baT() != null) {
                            cVar.awC().dBT = this.dqR.baT().getId();
                        }
                        if (this.dzn != null) {
                            if (this.dzn.dzw) {
                                cVar.awC().dBS = 8;
                            } else {
                                cVar.awC().dBS = -1;
                            }
                        }
                    }
                }
            }
        }
    }

    private ArrayList<Integer> R(ArrayList<h> arrayList) {
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
                if (this.dqQ != null && !this.dqQ.containsValue(hVar)) {
                    this.dqQ.put(Integer.valueOf(i2), (bc) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    public HashMap<Integer, bc> awu() {
        return this.dqQ;
    }

    public void awv() {
        if (this.dnn != null && this.dnn.getData() != null && this.dnn.getData().size() != 0) {
            for (h hVar : this.dnn.getData()) {
                if ((hVar instanceof bc) && ((bc) hVar).vr() != 0) {
                    ((bc) hVar).wd();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.dnn.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.dnn.getAdapter().notifyDataSetChanged();
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

    private void T(ArrayList<h> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<h> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bc.aia) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dzn != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.dzn.registerListener(this.dqT);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dzn == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.dqK = new ArrayList();
        ArrayList<BdUniqueId> bwO = q.bwO();
        if (bwO == null || bwO.size() <= 0) {
            return false;
        }
        int size = bwO.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends q.a> a = c.atf().a(this.dzn.getPageContext(), bwO.get(i), this.dzn.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dqK.add(a);
            }
        }
        if (!w.A(this.dqK)) {
            bdTypeRecyclerView.addAdapters(this.dqK);
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

    private void iD(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).iD(str);
                }
            }
        }
    }
}
