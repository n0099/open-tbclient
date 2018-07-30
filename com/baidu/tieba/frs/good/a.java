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
    private ArrayList<h> cQR;
    private FrsGoodFragment dBZ;
    private com.baidu.adp.widget.ListView.a dCa;
    private com.baidu.adp.widget.ListView.a dCb;
    private BdTypeRecyclerView dqh;
    private l dqj;
    private i dsC;
    private i dsD;
    private com.baidu.tieba.frs.entelechy.a.l dsE;
    private p dsF;
    private d dsG;
    private final HashMap<Integer, bb> dtD;
    private com.baidu.tieba.tbadkCore.l dtE;
    private g dtt;
    private com.baidu.adp.widget.ListView.a dtv;
    private com.baidu.adp.widget.ListView.a dtw;
    private List<com.baidu.adp.widget.ListView.a> dtx;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dsH = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.a.1
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
                        ((com.baidu.tieba.frs.h) aVar).a(a.this.dBZ.getPageContext(), a.this.dBZ.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (a.this.mAdapters != null) {
                    a.this.mAdapters.addAll(arrayList);
                }
                if (a.this.dqh != null) {
                    a.this.dqh.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dtG = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && w.z(a.this.dtx)) {
                a.this.b(a.this.dqh);
                a.this.b(a.this.cQR, a.this.dtE);
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.dqh = bdTypeRecyclerView;
        this.dtD = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dBZ = frsGoodFragment;
        this.dsH.setPriority(1);
        this.dsH.setSelfListener(true);
        this.dBZ.registerListener(this.dsH);
        this.dsC = new i(frsGoodFragment.getPageContext(), bb.ahx, this.dBZ.getUniqueId());
        this.dsC.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dtt = new g(frsGoodFragment.getPageContext(), bb.ahy, this.dBZ.getUniqueId());
        this.dsD = new i(frsGoodFragment.getPageContext(), bb.ahz, this.dBZ.getUniqueId());
        this.dsD.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dsF = new p(frsGoodFragment.getPageContext(), bb.ahA, this.dBZ.getUniqueId());
        this.dsG = new d(frsGoodFragment.getPageContext(), bb.ahF, this.dBZ.getUniqueId());
        this.dqj = new l(frsGoodFragment.getPageContext(), m.doV);
        this.dtv = c.atJ().a(frsGoodFragment.getPageContext(), bb.aiT, this.dBZ.getUniqueId(), true);
        this.dtw = c.atJ().b(frsGoodFragment.getPageContext(), bb.ajb, this.dBZ.getUniqueId());
        this.dCa = r.bnn().a(this.dBZ, AdvertAppInfo.adn);
        this.dCb = r.bnn().a(this.dBZ, AdvertAppInfo.adw);
        this.dsE = new com.baidu.tieba.frs.entelechy.a.l(frsGoodFragment.getPageContext(), bb.ahE, this.dBZ.getUniqueId());
        this.mAdapters.add(this.dsC);
        this.mAdapters.add(this.dtt);
        this.mAdapters.add(this.dsC);
        this.mAdapters.add(this.dtt);
        this.mAdapters.add(this.dsD);
        this.mAdapters.add(this.dqj);
        this.mAdapters.add(this.dsF);
        this.mAdapters.add(this.dsG);
        this.mAdapters.add(this.dsE);
        if (this.dtv != null) {
            this.mAdapters.add(this.dtv);
        }
        if (this.dtw != null) {
            this.mAdapters.add(this.dtw);
        }
        this.mAdapters.add(this.dCa);
        this.mAdapters.add(this.dCb);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dBZ.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        iA("page_frs_good");
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
        this.dqh.setData(arrayList);
        this.cQR = arrayList;
        this.dtE = lVar;
        axf();
    }

    public void gj(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof ab) {
                ((ab) aVar).hl(z ? 15 : 3);
            }
        }
    }

    private void axf() {
        if (this.dtE != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (cVar.axh() != null) {
                        if (this.dtE.gLj == 1) {
                            cVar.axh().dED = true;
                        } else {
                            cVar.axh().dED = false;
                        }
                        if (this.dtE.aZl() != null) {
                            cVar.axh().dEF = this.dtE.aZl().getId();
                        }
                        if (this.dBZ != null) {
                            if (this.dBZ.dCi) {
                                cVar.axh().dEE = 8;
                            } else {
                                cVar.axh().dEE = 5;
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
                if (this.dtD != null && !this.dtD.containsValue(hVar)) {
                    this.dtD.put(Integer.valueOf(i2), (bb) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    public HashMap<Integer, bb> awZ() {
        return this.dtD;
    }

    public void axa() {
        if (this.dqh != null && this.dqh.getData() != null && this.dqh.getData().size() != 0) {
            for (h hVar : this.dqh.getData()) {
                if ((hVar instanceof bb) && ((bb) hVar).vf() != 0) {
                    ((bb) hVar).vS();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.dqh.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.dqh.getAdapter().notifyDataSetChanged();
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
        if (this.dBZ != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.dBZ.registerListener(this.dtG);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dBZ == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.dtx = new ArrayList();
        ArrayList<BdUniqueId> bvs = q.bvs();
        if (bvs == null || bvs.size() <= 0) {
            return false;
        }
        int size = bvs.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends q.a> a = c.atJ().a(this.dBZ.getPageContext(), bvs.get(i), this.dBZ.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dtx.add(a);
            }
        }
        if (!w.z(this.dtx)) {
            bdTypeRecyclerView.addAdapters(this.dtx);
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

    private void iA(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).iA(str);
                }
            }
        }
    }
}
