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
    private BdTypeRecyclerView dEu;
    private l dEw;
    private p dGP;
    private d dGQ;
    private g dHW;
    private com.baidu.adp.widget.ListView.a dHY;
    private com.baidu.adp.widget.ListView.a dHZ;
    private i dHh;
    private i dHi;
    private com.baidu.tieba.frs.entelechy.a.l dHj;
    private List<com.baidu.adp.widget.ListView.a> dIa;
    private final HashMap<Integer, bb> dIg;
    private com.baidu.tieba.tbadkCore.l dIh;
    private FrsGoodFragment dQK;
    private com.baidu.adp.widget.ListView.a dQL;
    private com.baidu.adp.widget.ListView.a dQM;
    private ArrayList<h> deX;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dHk = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.a.1
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
                        ((com.baidu.tieba.frs.h) aVar).a(a.this.dQK.getPageContext(), a.this.dQK.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (a.this.mAdapters != null) {
                    a.this.mAdapters.addAll(arrayList);
                }
                if (a.this.dEu != null) {
                    a.this.dEu.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dIj = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.J(a.this.dIa)) {
                a.this.b(a.this.dEu);
                a.this.b(a.this.deX, a.this.dIh);
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.dEu = bdTypeRecyclerView;
        this.dIg = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dQK = frsGoodFragment;
        this.dHk.setPriority(1);
        this.dHk.setSelfListener(true);
        this.dQK.registerListener(this.dHk);
        this.dHh = new i(frsGoodFragment.getPageContext(), bb.aoS, this.dQK.getUniqueId());
        this.dHh.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dHW = new g(frsGoodFragment.getPageContext(), bb.aoT, this.dQK.getUniqueId());
        this.dHi = new i(frsGoodFragment.getPageContext(), bb.aoU, this.dQK.getUniqueId());
        this.dHi.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dGP = new p(frsGoodFragment.getPageContext(), bb.aoV, this.dQK.getUniqueId());
        this.dGQ = new d(frsGoodFragment.getPageContext(), bb.apa, this.dQK.getUniqueId());
        this.dEw = new l(frsGoodFragment.getPageContext(), m.dCR);
        this.dHY = c.ayW().a(frsGoodFragment.getPageContext(), bb.aqq, this.dQK.getUniqueId(), true);
        this.dHZ = c.ayW().b(frsGoodFragment.getPageContext(), bb.aqy, this.dQK.getUniqueId());
        this.dQL = r.btk().a(this.dQK, AdvertAppInfo.akK);
        this.dQM = r.btk().a(this.dQK, AdvertAppInfo.akT);
        this.dHj = new com.baidu.tieba.frs.entelechy.a.l(frsGoodFragment.getPageContext(), bb.aoZ, this.dQK.getUniqueId());
        this.mAdapters.add(this.dHh);
        this.mAdapters.add(this.dHW);
        this.mAdapters.add(this.dHh);
        this.mAdapters.add(this.dHW);
        this.mAdapters.add(this.dHi);
        this.mAdapters.add(this.dEw);
        this.mAdapters.add(this.dGP);
        this.mAdapters.add(this.dGQ);
        this.mAdapters.add(this.dHj);
        if (this.dHY != null) {
            this.mAdapters.add(this.dHY);
        }
        if (this.dHZ != null) {
            this.mAdapters.add(this.dHZ);
        }
        this.mAdapters.add(this.dQL);
        this.mAdapters.add(this.dQM);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dQK.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        jq("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof ac) {
                ((ac) aVar).fj(true);
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
        q.q(arrayList, 1);
        R(arrayList);
        this.dEu.setData(arrayList);
        this.deX = arrayList;
        this.dIh = lVar;
        aCa();
    }

    public void gX(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof ab) {
                ((ab) aVar).ii(z ? 15 : 3);
            }
        }
    }

    private void aCa() {
        com.baidu.tieba.frs.e.a aCN;
        if (this.dIh != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.e.c) && (aCN = ((com.baidu.tieba.frs.e.c) aVar).aCN()) != null) {
                    if (this.dIh.haj == 1) {
                        aCN.dTD = true;
                    } else {
                        aCN.dTD = false;
                    }
                    if (this.dIh.beT() != null) {
                        aCN.dTF = this.dIh.beT().getId();
                    }
                    if (this.dQK != null) {
                        if (this.dQK.dQT) {
                            aCN.dTI = 8;
                        } else {
                            aCN.dTE = 5;
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
                if (this.dIg != null && !this.dIg.containsValue(hVar)) {
                    this.dIg.put(Integer.valueOf(i2), (bb) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    public HashMap<Integer, bb> aCG() {
        return this.dIg;
    }

    public void aCH() {
        if (this.dEu != null && this.dEu.getData() != null && this.dEu.getData().size() != 0) {
            for (h hVar : this.dEu.getData()) {
                if ((hVar instanceof bb) && ((bb) hVar).yq() != 0) {
                    ((bb) hVar).zf();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.dEu.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.dEu.getAdapter().notifyDataSetChanged();
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
                if (it.next().getType() == bb.aoR) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dQK != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.dQK.registerListener(this.dIj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dQK == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.dIa = new ArrayList();
        ArrayList<BdUniqueId> bBo = q.bBo();
        if (bBo == null || bBo.size() <= 0) {
            return false;
        }
        int size = bBo.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends q.a> a = c.ayW().a(this.dQK.getPageContext(), bBo.get(i), this.dQK.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dIa.add(a);
            }
        }
        if (!v.J(this.dIa)) {
            bdTypeRecyclerView.addAdapters(this.dIa);
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

    private void jq(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).jq(str);
                }
            }
        }
    }
}
