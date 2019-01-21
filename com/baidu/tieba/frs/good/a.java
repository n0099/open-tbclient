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
    private BdTypeRecyclerView dPH;
    private l dPJ;
    private i dSb;
    private i dSc;
    private com.baidu.tieba.frs.entelechy.a.l dSd;
    private p dSe;
    private d dSf;
    private g dTb;
    private com.baidu.adp.widget.ListView.a dTd;
    private com.baidu.adp.widget.ListView.a dTe;
    private List<com.baidu.adp.widget.ListView.a> dTf;
    private final HashMap<Integer, bb> dTl;
    private com.baidu.tieba.tbadkCore.l dTm;
    private ArrayList<h> dqo;
    private FrsGoodFragment ebN;
    private com.baidu.adp.widget.ListView.a ebO;
    private com.baidu.adp.widget.ListView.a ebP;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dSh = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.a.1
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
                        ((com.baidu.tieba.frs.h) aVar).a(a.this.ebN.getPageContext(), a.this.ebN.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (a.this.mAdapters != null) {
                    a.this.mAdapters.addAll(arrayList);
                }
                if (a.this.dPH != null) {
                    a.this.dPH.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dTo = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.I(a.this.dTf)) {
                a.this.b(a.this.dPH);
                a.this.b(a.this.dqo, a.this.dTm);
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.dPH = bdTypeRecyclerView;
        this.dTl = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.ebN = frsGoodFragment;
        this.dSh.setPriority(1);
        this.dSh.setSelfListener(true);
        this.ebN.registerListener(this.dSh);
        this.dSb = new i(frsGoodFragment.getPageContext(), bb.atJ, this.ebN.getUniqueId());
        this.dSb.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dTb = new g(frsGoodFragment.getPageContext(), bb.atK, this.ebN.getUniqueId());
        this.dSc = new i(frsGoodFragment.getPageContext(), bb.atL, this.ebN.getUniqueId());
        this.dSc.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dSe = new p(frsGoodFragment.getPageContext(), bb.atM, this.ebN.getUniqueId());
        this.dSf = new d(frsGoodFragment.getPageContext(), bb.atR, this.ebN.getUniqueId());
        this.dPJ = new l(frsGoodFragment.getPageContext(), m.dOe);
        this.dTd = c.aBp().a(frsGoodFragment.getPageContext(), bb.avg, this.ebN.getUniqueId(), true);
        this.dTe = c.aBp().b(frsGoodFragment.getPageContext(), bb.avo, this.ebN.getUniqueId());
        this.ebO = r.bvT().a(this.ebN, AdvertAppInfo.apC);
        this.ebP = r.bvT().a(this.ebN, AdvertAppInfo.apL);
        this.dSd = new com.baidu.tieba.frs.entelechy.a.l(frsGoodFragment.getPageContext(), bb.atQ, this.ebN.getUniqueId());
        this.mAdapters.add(this.dSb);
        this.mAdapters.add(this.dTb);
        this.mAdapters.add(this.dSb);
        this.mAdapters.add(this.dTb);
        this.mAdapters.add(this.dSc);
        this.mAdapters.add(this.dPJ);
        this.mAdapters.add(this.dSe);
        this.mAdapters.add(this.dSf);
        this.mAdapters.add(this.dSd);
        if (this.dTd != null) {
            this.mAdapters.add(this.dTd);
        }
        if (this.dTe != null) {
            this.mAdapters.add(this.dTe);
        }
        this.mAdapters.add(this.ebO);
        this.mAdapters.add(this.ebP);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.ebN.getUniqueId());
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
        this.dPH.setData(arrayList);
        this.dqo = arrayList;
        this.dTm = lVar;
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
        if (this.dTm != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.e.d) && (aFf = ((com.baidu.tieba.frs.e.d) aVar).aFf()) != null) {
                    if (this.dTm.hmQ == 1) {
                        aFf.eeK = true;
                    } else {
                        aFf.eeK = false;
                    }
                    if (this.dTm.bhx() != null) {
                        aFf.eeM = this.dTm.bhx().getId();
                    }
                    if (this.ebN != null) {
                        if (this.ebN.ebX) {
                            aFf.eeP = 8;
                        } else {
                            aFf.eeL = 5;
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
                if (this.dTl != null && !this.dTl.containsValue(hVar)) {
                    this.dTl.put(Integer.valueOf(i2), (bb) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    public HashMap<Integer, bb> aEY() {
        return this.dTl;
    }

    public void aEZ() {
        if (this.dPH != null && this.dPH.getData() != null && this.dPH.getData().size() != 0) {
            for (h hVar : this.dPH.getData()) {
                if ((hVar instanceof bb) && ((bb) hVar).zO() != 0) {
                    ((bb) hVar).AD();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.dPH.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.dPH.getAdapter().notifyDataSetChanged();
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
                if (it.next().getType() == bb.atI) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.ebN != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.ebN.registerListener(this.dTo);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.ebN == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.dTf = new ArrayList();
        ArrayList<BdUniqueId> bEf = q.bEf();
        if (bEf == null || bEf.size() <= 0) {
            return false;
        }
        int size = bEf.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends q.a> a = c.aBp().a(this.ebN.getPageContext(), bEf.get(i), this.ebN.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dTf.add(a);
            }
        }
        if (!v.I(this.dTf)) {
            bdTypeRecyclerView.addAdapters(this.dTf);
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
