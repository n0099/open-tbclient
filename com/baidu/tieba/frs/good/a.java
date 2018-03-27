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
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private k dJO;
    private i dJP;
    private n dJQ;
    private k dJR;
    private com.baidu.tieba.frs.entelechy.a.c dJS;
    private r dJV;
    private g dJW;
    private com.baidu.adp.widget.ListView.a dJX;
    private com.baidu.adp.widget.ListView.a dJY;
    private d dJZ;
    private d dKa;
    private l dKb;
    private List<com.baidu.adp.widget.ListView.a> dKc;
    private final HashMap<Integer, bd> dKh;
    private m dKi;
    private b dRv;
    private BdTypeRecyclerView dRw;
    private com.baidu.adp.widget.ListView.a dRx;
    private com.baidu.adp.widget.ListView.a dRy;
    private ArrayList<com.baidu.adp.widget.ListView.i> dnU;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dKk = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.a.1
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
                        ((com.baidu.tieba.frs.g) aVar).a(a.this.dRv.getPageContext(), a.this.dRv.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (a.this.mAdapters != null) {
                    a.this.mAdapters.addAll(arrayList);
                }
                if (a.this.dRw != null) {
                    a.this.dRw.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dKl = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.E(a.this.dKc)) {
                a.this.b(a.this.dRw);
                a.this.b(a.this.dnU, a.this.dKi);
            }
        }
    };

    public a(b bVar, BdTypeRecyclerView bdTypeRecyclerView) {
        a(bVar, bdTypeRecyclerView);
        this.dRw = bdTypeRecyclerView;
        this.dKh = new HashMap<>();
    }

    public void a(b bVar, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dRv = bVar;
        this.dKk.setPriority(1);
        this.dKk.setSelfListener(true);
        this.dRv.registerListener(this.dKk);
        this.dJO = new k(bVar.getPageContext(), bd.aOk, this.dRv.getUniqueId());
        this.dJO.setVoiceManager(bVar.getVoiceManager());
        this.dJP = new i(bVar.getPageContext(), bd.aOl, this.dRv.getUniqueId());
        this.dJR = new k(bVar.getPageContext(), bd.aOm, this.dRv.getUniqueId());
        this.dJR.setVoiceManager(bVar.getVoiceManager());
        this.dJV = new r(bVar.getPageContext(), bd.aOn, this.dRv.getUniqueId());
        this.dJW = new g(bVar.getPageContext(), bd.aOs, this.dRv.getUniqueId());
        this.dKb = new l(bVar.getPageContext(), com.baidu.tieba.frs.m.dGD);
        this.dJZ = new d(bVar.getPageContext(), bd.aOw, this.dRv.getUniqueId());
        this.dKa = new d(bVar.getPageContext(), bd.aOx, this.dRv.getUniqueId());
        this.dJX = com.baidu.tieba.frs.a.auv().a(bVar.getPageContext(), bd.aPy, this.dRv.getUniqueId(), true);
        this.dJY = com.baidu.tieba.frs.a.auv().b(bVar.getPageContext(), bd.aPF, this.dRv.getUniqueId());
        this.dRx = com.baidu.tieba.recapp.r.bof().a(this.dRv, AdvertAppInfo.aKe);
        this.dRy = com.baidu.tieba.recapp.r.bof().a(this.dRv, AdvertAppInfo.aKn);
        this.dJS = new com.baidu.tieba.frs.entelechy.a.c(bVar.getPageContext(), ar.aNG, this.dRv.getUniqueId());
        this.dJQ = new n(bVar.getPageContext(), bd.aOr, this.dRv.getUniqueId());
        this.mAdapters.add(this.dJO);
        this.mAdapters.add(this.dJP);
        this.mAdapters.add(this.dJO);
        this.mAdapters.add(this.dJP);
        this.mAdapters.add(this.dJR);
        this.mAdapters.add(this.dKb);
        this.mAdapters.add(this.dJV);
        this.mAdapters.add(this.dJW);
        this.mAdapters.add(this.dJZ);
        this.mAdapters.add(this.dKa);
        this.mAdapters.add(this.dJS);
        this.mAdapters.add(this.dJQ);
        if (this.dJX != null) {
            this.mAdapters.add(this.dJX);
        }
        if (this.dJY != null) {
            this.mAdapters.add(this.dJY);
        }
        this.mAdapters.add(this.dRx);
        this.mAdapters.add(this.dRy);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dRv.getUniqueId());
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

    public void b(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, m mVar) {
        b(mVar);
        N(arrayList);
        com.baidu.tieba.tbadkCore.r.r(arrayList, 1);
        L(arrayList);
        this.dRw.setData(arrayList);
        this.dnU = arrayList;
        this.dKi = mVar;
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
                if (this.dKh != null && !this.dKh.containsValue(iVar)) {
                    this.dKh.put(Integer.valueOf(i2), (bd) iVar);
                }
            }
            i = i2 + 1;
        }
    }

    public HashMap<Integer, bd> axo() {
        return this.dKh;
    }

    public void axp() {
        if (this.dRw != null && this.dRw.getData() != null && this.dRw.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.i iVar : this.dRw.getData()) {
                if ((iVar instanceof bd) && ((bd) iVar).zi() != 0) {
                    ((bd) iVar).zW();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.dRw.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.dRw.getAdapter().notifyDataSetChanged();
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

    public void b(m mVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).b(mVar);
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
                if (it.next().getType() == bd.aOj) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dRv != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.dRv.registerListener(this.dKl);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.b */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dRv == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.dKc = new ArrayList();
        ArrayList<BdUniqueId> bwn = com.baidu.tieba.tbadkCore.r.bwn();
        if (bwn == null || bwn.size() <= 0) {
            return false;
        }
        int size = bwn.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.g<ICardInfo, ? extends r.a> a = com.baidu.tieba.frs.a.auv().a(this.dRv.getPageContext(), bwn.get(i), this.dRv.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dKc.add(a);
            }
        }
        if (!v.E(this.dKc)) {
            bdTypeRecyclerView.addAdapters(this.dKc);
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
