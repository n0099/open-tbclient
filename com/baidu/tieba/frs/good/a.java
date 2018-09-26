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
import com.baidu.tieba.frs.m;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private ArrayList<h> cWF;
    private List<com.baidu.adp.widget.ListView.a> dAa;
    private final HashMap<Integer, bb> dAg;
    private l dAh;
    private FrsGoodFragment dIM;
    private com.baidu.adp.widget.ListView.a dIN;
    private com.baidu.adp.widget.ListView.a dIO;
    private BdTypeRecyclerView dwt;
    private com.baidu.tieba.frs.l dwv;
    private p dyP;
    private d dyQ;
    private g dzW;
    private com.baidu.adp.widget.ListView.a dzY;
    private com.baidu.adp.widget.ListView.a dzZ;
    private i dzh;
    private i dzi;
    private com.baidu.tieba.frs.entelechy.a.l dzj;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dzk = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.a.1
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
                        ((com.baidu.tieba.frs.h) aVar).a(a.this.dIM.getPageContext(), a.this.dIM.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (a.this.mAdapters != null) {
                    a.this.mAdapters.addAll(arrayList);
                }
                if (a.this.dwt != null) {
                    a.this.dwt.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dAj = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.z(a.this.dAa)) {
                a.this.b(a.this.dwt);
                a.this.b(a.this.cWF, a.this.dAh);
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.dwt = bdTypeRecyclerView;
        this.dAg = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dIM = frsGoodFragment;
        this.dzk.setPriority(1);
        this.dzk.setSelfListener(true);
        this.dIM.registerListener(this.dzk);
        this.dzh = new i(frsGoodFragment.getPageContext(), bb.ajX, this.dIM.getUniqueId());
        this.dzh.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dzW = new g(frsGoodFragment.getPageContext(), bb.ajY, this.dIM.getUniqueId());
        this.dzi = new i(frsGoodFragment.getPageContext(), bb.ajZ, this.dIM.getUniqueId());
        this.dzi.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dyP = new p(frsGoodFragment.getPageContext(), bb.aka, this.dIM.getUniqueId());
        this.dyQ = new d(frsGoodFragment.getPageContext(), bb.akf, this.dIM.getUniqueId());
        this.dwv = new com.baidu.tieba.frs.l(frsGoodFragment.getPageContext(), m.duQ);
        this.dzY = c.avz().a(frsGoodFragment.getPageContext(), bb.alv, this.dIM.getUniqueId(), true);
        this.dzZ = c.avz().b(frsGoodFragment.getPageContext(), bb.alD, this.dIM.getUniqueId());
        this.dIN = r.bpV().a(this.dIM, AdvertAppInfo.afN);
        this.dIO = r.bpV().a(this.dIM, AdvertAppInfo.afW);
        this.dzj = new com.baidu.tieba.frs.entelechy.a.l(frsGoodFragment.getPageContext(), bb.ake, this.dIM.getUniqueId());
        this.mAdapters.add(this.dzh);
        this.mAdapters.add(this.dzW);
        this.mAdapters.add(this.dzh);
        this.mAdapters.add(this.dzW);
        this.mAdapters.add(this.dzi);
        this.mAdapters.add(this.dwv);
        this.mAdapters.add(this.dyP);
        this.mAdapters.add(this.dyQ);
        this.mAdapters.add(this.dzj);
        if (this.dzY != null) {
            this.mAdapters.add(this.dzY);
        }
        if (this.dzZ != null) {
            this.mAdapters.add(this.dzZ);
        }
        this.mAdapters.add(this.dIN);
        this.mAdapters.add(this.dIO);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dIM.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        jd("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof ac) {
                ((ac) aVar).eR(true);
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

    public void b(ArrayList<h> arrayList, l lVar) {
        b(lVar);
        T(arrayList);
        q.p(arrayList, 1);
        R(arrayList);
        this.dwt.setData(arrayList);
        this.cWF = arrayList;
        this.dAh = lVar;
        ayG();
    }

    public void gF(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof ab) {
                ((ab) aVar).hK(z ? 15 : 3);
            }
        }
    }

    private void ayG() {
        com.baidu.tieba.frs.e.a azt;
        if (this.dAh != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.e.c) && (azt = ((com.baidu.tieba.frs.e.c) aVar).azt()) != null) {
                    if (this.dAh.gSN == 1) {
                        azt.dLH = true;
                    } else {
                        azt.dLH = false;
                    }
                    if (this.dAh.bbH() != null) {
                        azt.dLJ = this.dAh.bbH().getId();
                    }
                    if (this.dIM != null) {
                        if (this.dIM.dIV) {
                            azt.dLM = 8;
                        } else {
                            azt.dLI = 5;
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
                if (this.dAg != null && !this.dAg.containsValue(hVar)) {
                    this.dAg.put(Integer.valueOf(i2), (bb) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    public HashMap<Integer, bb> azm() {
        return this.dAg;
    }

    public void azn() {
        if (this.dwt != null && this.dwt.getData() != null && this.dwt.getData().size() != 0) {
            for (h hVar : this.dwt.getData()) {
                if ((hVar instanceof bb) && ((bb) hVar).wh() != 0) {
                    ((bb) hVar).wW();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.dwt.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.dwt.getAdapter().notifyDataSetChanged();
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

    public void b(l lVar) {
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
                if (it.next().getType() == bb.ajW) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dIM != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.dIM.registerListener(this.dAj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dIM == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.dAa = new ArrayList();
        ArrayList<BdUniqueId> bxZ = q.bxZ();
        if (bxZ == null || bxZ.size() <= 0) {
            return false;
        }
        int size = bxZ.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends q.a> a = c.avz().a(this.dIM.getPageContext(), bxZ.get(i), this.dIM.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dAa.add(a);
            }
        }
        if (!v.z(this.dAa)) {
            bdTypeRecyclerView.addAdapters(this.dAa);
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

    private void jd(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).jd(str);
                }
            }
        }
    }
}
