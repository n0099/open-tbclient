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
    private ArrayList<h> cQO;
    private FrsGoodFragment dBW;
    private com.baidu.adp.widget.ListView.a dBX;
    private com.baidu.adp.widget.ListView.a dBY;
    private BdTypeRecyclerView dqf;
    private l dqh;
    private i dsA;
    private com.baidu.tieba.frs.entelechy.a.l dsB;
    private p dsC;
    private d dsD;
    private i dsz;
    private final HashMap<Integer, bb> dtA;
    private com.baidu.tieba.tbadkCore.l dtB;
    private g dtq;
    private com.baidu.adp.widget.ListView.a dts;
    private com.baidu.adp.widget.ListView.a dtt;
    private List<com.baidu.adp.widget.ListView.a> dtu;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dsE = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.a.1
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
                        ((com.baidu.tieba.frs.h) aVar).a(a.this.dBW.getPageContext(), a.this.dBW.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (a.this.mAdapters != null) {
                    a.this.mAdapters.addAll(arrayList);
                }
                if (a.this.dqf != null) {
                    a.this.dqf.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dtD = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && w.z(a.this.dtu)) {
                a.this.b(a.this.dqf);
                a.this.b(a.this.cQO, a.this.dtB);
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.dqf = bdTypeRecyclerView;
        this.dtA = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dBW = frsGoodFragment;
        this.dsE.setPriority(1);
        this.dsE.setSelfListener(true);
        this.dBW.registerListener(this.dsE);
        this.dsz = new i(frsGoodFragment.getPageContext(), bb.ahx, this.dBW.getUniqueId());
        this.dsz.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dtq = new g(frsGoodFragment.getPageContext(), bb.ahy, this.dBW.getUniqueId());
        this.dsA = new i(frsGoodFragment.getPageContext(), bb.ahz, this.dBW.getUniqueId());
        this.dsA.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dsC = new p(frsGoodFragment.getPageContext(), bb.ahA, this.dBW.getUniqueId());
        this.dsD = new d(frsGoodFragment.getPageContext(), bb.ahF, this.dBW.getUniqueId());
        this.dqh = new l(frsGoodFragment.getPageContext(), m.doT);
        this.dts = c.atI().a(frsGoodFragment.getPageContext(), bb.aiT, this.dBW.getUniqueId(), true);
        this.dtt = c.atI().b(frsGoodFragment.getPageContext(), bb.ajb, this.dBW.getUniqueId());
        this.dBX = r.bno().a(this.dBW, AdvertAppInfo.adn);
        this.dBY = r.bno().a(this.dBW, AdvertAppInfo.adw);
        this.dsB = new com.baidu.tieba.frs.entelechy.a.l(frsGoodFragment.getPageContext(), bb.ahE, this.dBW.getUniqueId());
        this.mAdapters.add(this.dsz);
        this.mAdapters.add(this.dtq);
        this.mAdapters.add(this.dsz);
        this.mAdapters.add(this.dtq);
        this.mAdapters.add(this.dsA);
        this.mAdapters.add(this.dqh);
        this.mAdapters.add(this.dsC);
        this.mAdapters.add(this.dsD);
        this.mAdapters.add(this.dsB);
        if (this.dts != null) {
            this.mAdapters.add(this.dts);
        }
        if (this.dtt != null) {
            this.mAdapters.add(this.dtt);
        }
        this.mAdapters.add(this.dBX);
        this.mAdapters.add(this.dBY);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dBW.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        iB("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof ac) {
                ((ac) aVar).eA(true);
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
        this.dqf.setData(arrayList);
        this.cQO = arrayList;
        this.dtB = lVar;
        axe();
    }

    public void gj(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof ab) {
                ((ab) aVar).hk(z ? 15 : 3);
            }
        }
    }

    private void axe() {
        if (this.dtB != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (cVar.axg() != null) {
                        if (this.dtB.gLl == 1) {
                            cVar.axg().dEA = true;
                        } else {
                            cVar.axg().dEA = false;
                        }
                        if (this.dtB.aZg() != null) {
                            cVar.axg().dEC = this.dtB.aZg().getId();
                        }
                        if (this.dBW != null) {
                            if (this.dBW.dCf) {
                                cVar.axg().dEB = 8;
                            } else {
                                cVar.axg().dEB = 5;
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
                if (this.dtA != null && !this.dtA.containsValue(hVar)) {
                    this.dtA.put(Integer.valueOf(i2), (bb) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    public HashMap<Integer, bb> awY() {
        return this.dtA;
    }

    public void awZ() {
        if (this.dqf != null && this.dqf.getData() != null && this.dqf.getData().size() != 0) {
            for (h hVar : this.dqf.getData()) {
                if ((hVar instanceof bb) && ((bb) hVar).ve() != 0) {
                    ((bb) hVar).vR();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.dqf.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.dqf.getAdapter().notifyDataSetChanged();
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
                if (it.next().getType() == bb.ahw) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dBW != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.dBW.registerListener(this.dtD);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dBW == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.dtu = new ArrayList();
        ArrayList<BdUniqueId> bvt = q.bvt();
        if (bvt == null || bvt.size() <= 0) {
            return false;
        }
        int size = bvt.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends q.a> a = c.atI().a(this.dBW.getPageContext(), bvt.get(i), this.dBW.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dtu.add(a);
            }
        }
        if (!w.z(this.dtu)) {
            bdTypeRecyclerView.addAdapters(this.dtu);
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

    private void iB(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).iB(str);
                }
            }
        }
    }
}
