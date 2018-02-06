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
    private k dJV;
    private i dJW;
    private n dJX;
    private k dJY;
    private com.baidu.tieba.frs.entelechy.a.c dJZ;
    private r dKc;
    private g dKd;
    private com.baidu.adp.widget.ListView.a dKe;
    private com.baidu.adp.widget.ListView.a dKf;
    private d dKg;
    private d dKh;
    private l dKi;
    private List<com.baidu.adp.widget.ListView.a> dKj;
    private final HashMap<Integer, bd> dKo;
    private com.baidu.tieba.tbadkCore.l dKp;
    private b dRC;
    private BdTypeRecyclerView dRD;
    private com.baidu.adp.widget.ListView.a dRE;
    private com.baidu.adp.widget.ListView.a dRF;
    private ArrayList<com.baidu.adp.widget.ListView.i> doe;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dKr = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.a.1
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
                        ((com.baidu.tieba.frs.g) aVar).a(a.this.dRC.getPageContext(), a.this.dRC.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (a.this.mAdapters != null) {
                    a.this.mAdapters.addAll(arrayList);
                }
                if (a.this.dRD != null) {
                    a.this.dRD.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dKs = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.E(a.this.dKj)) {
                a.this.b(a.this.dRD);
                a.this.b(a.this.doe, a.this.dKp);
            }
        }
    };

    public a(b bVar, BdTypeRecyclerView bdTypeRecyclerView) {
        a(bVar, bdTypeRecyclerView);
        this.dRD = bdTypeRecyclerView;
        this.dKo = new HashMap<>();
    }

    public void a(b bVar, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dRC = bVar;
        this.dKr.setPriority(1);
        this.dKr.setSelfListener(true);
        this.dRC.registerListener(this.dKr);
        this.dJV = new k(bVar.getPageContext(), bd.aOu, this.dRC.getUniqueId());
        this.dJV.setVoiceManager(bVar.getVoiceManager());
        this.dJW = new i(bVar.getPageContext(), bd.aOv, this.dRC.getUniqueId());
        this.dJY = new k(bVar.getPageContext(), bd.aOw, this.dRC.getUniqueId());
        this.dJY.setVoiceManager(bVar.getVoiceManager());
        this.dKc = new r(bVar.getPageContext(), bd.aOx, this.dRC.getUniqueId());
        this.dKd = new g(bVar.getPageContext(), bd.aOC, this.dRC.getUniqueId());
        this.dKi = new l(bVar.getPageContext(), m.dGK);
        this.dKg = new d(bVar.getPageContext(), bd.aOG, this.dRC.getUniqueId());
        this.dKh = new d(bVar.getPageContext(), bd.aOH, this.dRC.getUniqueId());
        this.dKe = com.baidu.tieba.frs.a.auv().a(bVar.getPageContext(), bd.aPI, this.dRC.getUniqueId(), true);
        this.dKf = com.baidu.tieba.frs.a.auv().b(bVar.getPageContext(), bd.aPP, this.dRC.getUniqueId());
        this.dRE = com.baidu.tieba.recapp.r.bof().a(this.dRC, AdvertAppInfo.aKo);
        this.dRF = com.baidu.tieba.recapp.r.bof().a(this.dRC, AdvertAppInfo.aKx);
        this.dJZ = new com.baidu.tieba.frs.entelechy.a.c(bVar.getPageContext(), ar.aNQ, this.dRC.getUniqueId());
        this.dJX = new n(bVar.getPageContext(), bd.aOB, this.dRC.getUniqueId());
        this.mAdapters.add(this.dJV);
        this.mAdapters.add(this.dJW);
        this.mAdapters.add(this.dJV);
        this.mAdapters.add(this.dJW);
        this.mAdapters.add(this.dJY);
        this.mAdapters.add(this.dKi);
        this.mAdapters.add(this.dKc);
        this.mAdapters.add(this.dKd);
        this.mAdapters.add(this.dKg);
        this.mAdapters.add(this.dKh);
        this.mAdapters.add(this.dJZ);
        this.mAdapters.add(this.dJX);
        if (this.dKe != null) {
            this.mAdapters.add(this.dKe);
        }
        if (this.dKf != null) {
            this.mAdapters.add(this.dKf);
        }
        this.mAdapters.add(this.dRE);
        this.mAdapters.add(this.dRF);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dRC.getUniqueId());
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
        this.dRD.setData(arrayList);
        this.doe = arrayList;
        this.dKp = lVar;
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
                if (this.dKo != null && !this.dKo.containsValue(iVar)) {
                    this.dKo.put(Integer.valueOf(i2), (bd) iVar);
                }
            }
            i = i2 + 1;
        }
    }

    public HashMap<Integer, bd> axn() {
        return this.dKo;
    }

    public void axo() {
        if (this.dRD != null && this.dRD.getData() != null && this.dRD.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.i iVar : this.dRD.getData()) {
                if ((iVar instanceof bd) && ((bd) iVar).zi() != 0) {
                    ((bd) iVar).zW();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.dRD.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.dRD.getAdapter().notifyDataSetChanged();
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
                if (it.next().getType() == bd.aOt) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dRC != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.dRC.registerListener(this.dKs);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.b */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dRC == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.dKj = new ArrayList();
        ArrayList<BdUniqueId> bwj = q.bwj();
        if (bwj == null || bwj.size() <= 0) {
            return false;
        }
        int size = bwj.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.g<ICardInfo, ? extends r.a> a = com.baidu.tieba.frs.a.auv().a(this.dRC.getPageContext(), bwj.get(i), this.dRC.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dKj.add(a);
            }
        }
        if (!v.E(this.dKj)) {
            bdTypeRecyclerView.addAdapters(this.dKj);
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
