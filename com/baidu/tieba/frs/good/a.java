package com.baidu.tieba.frs.good;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.u;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.d;
import com.baidu.tieba.frs.entelechy.a.g;
import com.baidu.tieba.frs.entelechy.a.i;
import com.baidu.tieba.frs.entelechy.a.k;
import com.baidu.tieba.frs.entelechy.a.n;
import com.baidu.tieba.frs.entelechy.a.r;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private k dJJ;
    private i dJK;
    private n dJL;
    private k dJM;
    private com.baidu.tieba.frs.entelechy.a.c dJN;
    private r dJQ;
    private g dJR;
    private com.baidu.adp.widget.ListView.a dJS;
    private com.baidu.adp.widget.ListView.a dJT;
    private d dJU;
    private d dJV;
    private l dJW;
    private List<com.baidu.adp.widget.ListView.a> dJX;
    private final HashMap<Integer, bd> dKc;
    private com.baidu.tieba.tbadkCore.l dKd;
    private b dRq;
    private BdTypeRecyclerView dRr;
    private com.baidu.adp.widget.ListView.a dRs;
    private com.baidu.adp.widget.ListView.a dRt;
    private ArrayList<com.baidu.adp.widget.ListView.i> dnR;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dKf = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: com.baidu.tieba.frs.good.b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof com.baidu.tieba.frs.g) {
                        ((com.baidu.tieba.frs.g) aVar).a(a.this.dRq.getPageContext(), a.this.dRq.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (a.this.mAdapters != null) {
                    a.this.mAdapters.addAll(arrayList);
                }
                if (a.this.dRr != null) {
                    a.this.dRr.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dKg = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.E(a.this.dJX)) {
                a.this.b(a.this.dRr);
                a.this.b(a.this.dnR, a.this.dKd);
            }
        }
    };

    public a(b bVar, BdTypeRecyclerView bdTypeRecyclerView) {
        a(bVar, bdTypeRecyclerView);
        this.dRr = bdTypeRecyclerView;
        this.dKc = new HashMap<>();
    }

    public void a(b bVar, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dRq = bVar;
        this.dKf.setPriority(1);
        this.dKf.setSelfListener(true);
        this.dRq.registerListener(this.dKf);
        this.dJJ = new k(bVar.getPageContext(), bd.aOj, this.dRq.getUniqueId());
        this.dJJ.setVoiceManager(bVar.getVoiceManager());
        this.dJK = new i(bVar.getPageContext(), bd.aOk, this.dRq.getUniqueId());
        this.dJM = new k(bVar.getPageContext(), bd.aOl, this.dRq.getUniqueId());
        this.dJM.setVoiceManager(bVar.getVoiceManager());
        this.dJQ = new r(bVar.getPageContext(), bd.aOm, this.dRq.getUniqueId());
        this.dJR = new g(bVar.getPageContext(), bd.aOr, this.dRq.getUniqueId());
        this.dJW = new l(bVar.getPageContext(), m.dGy);
        this.dJU = new d(bVar.getPageContext(), bd.aOv, this.dRq.getUniqueId());
        this.dJV = new d(bVar.getPageContext(), bd.aOw, this.dRq.getUniqueId());
        this.dJS = com.baidu.tieba.frs.a.auu().a(bVar.getPageContext(), bd.aPx, this.dRq.getUniqueId(), true);
        this.dJT = com.baidu.tieba.frs.a.auu().b(bVar.getPageContext(), bd.aPE, this.dRq.getUniqueId());
        this.dRs = com.baidu.tieba.recapp.r.boe().a(this.dRq, AdvertAppInfo.aKd);
        this.dRt = com.baidu.tieba.recapp.r.boe().a(this.dRq, AdvertAppInfo.aKm);
        this.dJN = new com.baidu.tieba.frs.entelechy.a.c(bVar.getPageContext(), ar.aNF, this.dRq.getUniqueId());
        this.dJL = new n(bVar.getPageContext(), bd.aOq, this.dRq.getUniqueId());
        this.mAdapters.add(this.dJJ);
        this.mAdapters.add(this.dJK);
        this.mAdapters.add(this.dJJ);
        this.mAdapters.add(this.dJK);
        this.mAdapters.add(this.dJM);
        this.mAdapters.add(this.dJW);
        this.mAdapters.add(this.dJQ);
        this.mAdapters.add(this.dJR);
        this.mAdapters.add(this.dJU);
        this.mAdapters.add(this.dJV);
        this.mAdapters.add(this.dJN);
        this.mAdapters.add(this.dJL);
        if (this.dJS != null) {
            this.mAdapters.add(this.dJS);
        }
        if (this.dJT != null) {
            this.mAdapters.add(this.dJT);
        }
        this.mAdapters.add(this.dRs);
        this.mAdapters.add(this.dRt);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dRq.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.g) {
                ((com.baidu.tieba.frs.g) aVar).release();
            }
        }
    }

    public void b(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        b(lVar);
        N(arrayList);
        q.r(arrayList, 1);
        L(arrayList);
        this.dRr.setData(arrayList);
        this.dnR = arrayList;
        this.dKd = lVar;
    }

    private ArrayList<Integer> L(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
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
            com.baidu.adp.widget.ListView.i iVar = arrayList.get(i2);
            if (iVar instanceof AdvertAppInfo) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.dKc != null && !this.dKc.containsValue(iVar)) {
                    this.dKc.put(Integer.valueOf(i2), (bd) iVar);
                }
            }
            i = i2 + 1;
        }
    }

    public HashMap<Integer, bd> axm() {
        return this.dKc;
    }

    public void axn() {
        if (this.dRr != null && this.dRr.getData() != null && this.dRr.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.i iVar : this.dRr.getData()) {
                if ((iVar instanceof bd) && ((bd) iVar).zi() != 0) {
                    ((bd) iVar).zW();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.dRr.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.dRr.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).b(lVar);
                }
            }
        }
    }

    public void setOnAdapterItemClickListener(o oVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.g)) {
                    ((com.baidu.tieba.frs.g) aVar).setOnAdapterItemClickListener(oVar);
                }
            }
        }
    }

    private void N(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<com.baidu.adp.widget.ListView.i> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bd.aOi) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dRq != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.dRq.registerListener(this.dKg);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.b */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dRq == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.dJX = new ArrayList();
        ArrayList<BdUniqueId> bwi = q.bwi();
        if (bwi == null || bwi.size() <= 0) {
            return false;
        }
        int size = bwi.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.g<ICardInfo, ? extends r.a> a = com.baidu.tieba.frs.a.auu().a(this.dRq.getPageContext(), bwi.get(i), this.dRq.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dJX.add(a);
            }
        }
        if (!v.E(this.dJX)) {
            bdTypeRecyclerView.addAdapters(this.dJX);
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

    public void setCardShowType(int i) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof u) {
                    ((u) aVar).setCardShowType(i);
                }
            }
        }
    }
}
