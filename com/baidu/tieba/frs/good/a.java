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
    private BdTypeRecyclerView dPG;
    private l dPI;
    private i dSa;
    private i dSb;
    private com.baidu.tieba.frs.entelechy.a.l dSc;
    private p dSd;
    private d dSe;
    private g dTa;
    private com.baidu.adp.widget.ListView.a dTc;
    private com.baidu.adp.widget.ListView.a dTd;
    private List<com.baidu.adp.widget.ListView.a> dTe;
    private final HashMap<Integer, bb> dTk;
    private com.baidu.tieba.tbadkCore.l dTl;
    private ArrayList<h> dqn;
    private FrsGoodFragment ebM;
    private com.baidu.adp.widget.ListView.a ebN;
    private com.baidu.adp.widget.ListView.a ebO;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dSg = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.a.1
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
                        ((com.baidu.tieba.frs.h) aVar).a(a.this.ebM.getPageContext(), a.this.ebM.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (a.this.mAdapters != null) {
                    a.this.mAdapters.addAll(arrayList);
                }
                if (a.this.dPG != null) {
                    a.this.dPG.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dTn = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.I(a.this.dTe)) {
                a.this.b(a.this.dPG);
                a.this.b(a.this.dqn, a.this.dTl);
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.dPG = bdTypeRecyclerView;
        this.dTk = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.ebM = frsGoodFragment;
        this.dSg.setPriority(1);
        this.dSg.setSelfListener(true);
        this.ebM.registerListener(this.dSg);
        this.dSa = new i(frsGoodFragment.getPageContext(), bb.atI, this.ebM.getUniqueId());
        this.dSa.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dTa = new g(frsGoodFragment.getPageContext(), bb.atJ, this.ebM.getUniqueId());
        this.dSb = new i(frsGoodFragment.getPageContext(), bb.atK, this.ebM.getUniqueId());
        this.dSb.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dSd = new p(frsGoodFragment.getPageContext(), bb.atL, this.ebM.getUniqueId());
        this.dSe = new d(frsGoodFragment.getPageContext(), bb.atQ, this.ebM.getUniqueId());
        this.dPI = new l(frsGoodFragment.getPageContext(), m.dOd);
        this.dTc = c.aBp().a(frsGoodFragment.getPageContext(), bb.avf, this.ebM.getUniqueId(), true);
        this.dTd = c.aBp().b(frsGoodFragment.getPageContext(), bb.avn, this.ebM.getUniqueId());
        this.ebN = r.bvT().a(this.ebM, AdvertAppInfo.apB);
        this.ebO = r.bvT().a(this.ebM, AdvertAppInfo.apK);
        this.dSc = new com.baidu.tieba.frs.entelechy.a.l(frsGoodFragment.getPageContext(), bb.atP, this.ebM.getUniqueId());
        this.mAdapters.add(this.dSa);
        this.mAdapters.add(this.dTa);
        this.mAdapters.add(this.dSa);
        this.mAdapters.add(this.dTa);
        this.mAdapters.add(this.dSb);
        this.mAdapters.add(this.dPI);
        this.mAdapters.add(this.dSd);
        this.mAdapters.add(this.dSe);
        this.mAdapters.add(this.dSc);
        if (this.dTc != null) {
            this.mAdapters.add(this.dTc);
        }
        if (this.dTd != null) {
            this.mAdapters.add(this.dTd);
        }
        this.mAdapters.add(this.ebN);
        this.mAdapters.add(this.ebO);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.ebM.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        kb("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof ac) {
                ((ac) aVar).fA(true);
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
        this.dPG.setData(arrayList);
        this.dqn = arrayList;
        this.dTl = lVar;
        aEt();
    }

    public void ho(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof ab) {
                ((ab) aVar).iK(z ? 15 : 3);
            }
        }
    }

    private void aEt() {
        com.baidu.tieba.frs.e.b aFf;
        if (this.dTl != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.e.d) && (aFf = ((com.baidu.tieba.frs.e.d) aVar).aFf()) != null) {
                    if (this.dTl.hmP == 1) {
                        aFf.eeJ = true;
                    } else {
                        aFf.eeJ = false;
                    }
                    if (this.dTl.bhx() != null) {
                        aFf.eeL = this.dTl.bhx().getId();
                    }
                    if (this.ebM != null) {
                        if (this.ebM.ebW) {
                            aFf.eeO = 8;
                        } else {
                            aFf.eeK = 5;
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
                if (this.dTk != null && !this.dTk.containsValue(hVar)) {
                    this.dTk.put(Integer.valueOf(i2), (bb) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    public HashMap<Integer, bb> aEY() {
        return this.dTk;
    }

    public void aEZ() {
        if (this.dPG != null && this.dPG.getData() != null && this.dPG.getData().size() != 0) {
            for (h hVar : this.dPG.getData()) {
                if ((hVar instanceof bb) && ((bb) hVar).zO() != 0) {
                    ((bb) hVar).AD();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.dPG.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.dPG.getAdapter().notifyDataSetChanged();
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
                if (it.next().getType() == bb.atH) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.ebM != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.ebM.registerListener(this.dTn);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.ebM == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.dTe = new ArrayList();
        ArrayList<BdUniqueId> bEf = q.bEf();
        if (bEf == null || bEf.size() <= 0) {
            return false;
        }
        int size = bEf.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends q.a> a = c.aBp().a(this.ebM.getPageContext(), bEf.get(i), this.ebM.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dTe.add(a);
            }
        }
        if (!v.I(this.dTe)) {
            bdTypeRecyclerView.addAdapters(this.dTe);
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

    private void kb(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).kb(str);
                }
            }
        }
    }
}
