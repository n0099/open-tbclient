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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.d;
import com.baidu.tieba.frs.entelechy.a.g;
import com.baidu.tieba.frs.entelechy.a.i;
import com.baidu.tieba.frs.entelechy.a.l;
import com.baidu.tieba.frs.entelechy.a.p;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.frs.k;
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
    private ArrayList<h> cQn;
    private BdTypeRecyclerView dmB;
    private i dmC;
    private i dmD;
    private l dmE;
    private p dmF;
    private d dmG;
    private j dmH;
    private com.baidu.adp.widget.ListView.a dnA;
    private List<com.baidu.adp.widget.ListView.a> dnB;
    private final HashMap<Integer, bd> dnH;
    private com.baidu.tieba.tbadkCore.l dnI;
    private g dnx;
    private com.baidu.adp.widget.ListView.a dnz;
    private FrsGoodFragment dwd;
    private com.baidu.adp.widget.ListView.a dwe;
    private com.baidu.adp.widget.ListView.a dwf;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dmI = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.a.1
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
                    if (aVar instanceof f) {
                        ((f) aVar).a(a.this.dwd.getPageContext(), a.this.dwd.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (a.this.mAdapters != null) {
                    a.this.mAdapters.addAll(arrayList);
                }
                if (a.this.dmB != null) {
                    a.this.dmB.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dnK = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && w.z(a.this.dnB)) {
                a.this.b(a.this.dmB);
                a.this.b(a.this.cQn, a.this.dnI);
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.dmB = bdTypeRecyclerView;
        this.dnH = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dwd = frsGoodFragment;
        this.dmI.setPriority(1);
        this.dmI.setSelfListener(true);
        this.dwd.registerListener(this.dmI);
        this.dmC = new i(frsGoodFragment.getPageContext(), bd.ahJ, this.dwd.getUniqueId());
        this.dmC.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dnx = new g(frsGoodFragment.getPageContext(), bd.ahK, this.dwd.getUniqueId());
        this.dmD = new i(frsGoodFragment.getPageContext(), bd.ahL, this.dwd.getUniqueId());
        this.dmD.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dmF = new p(frsGoodFragment.getPageContext(), bd.ahM, this.dwd.getUniqueId());
        this.dmG = new d(frsGoodFragment.getPageContext(), bd.ahR, this.dwd.getUniqueId());
        this.dmH = new j(frsGoodFragment.getPageContext(), k.djW);
        this.dnz = com.baidu.tieba.frs.a.asO().a(frsGoodFragment.getPageContext(), bd.ajb, this.dwd.getUniqueId(), true);
        this.dnA = com.baidu.tieba.frs.a.asO().b(frsGoodFragment.getPageContext(), bd.ajj, this.dwd.getUniqueId());
        this.dwe = r.boj().a(this.dwd, AdvertAppInfo.adu);
        this.dwf = r.boj().a(this.dwd, AdvertAppInfo.adD);
        this.dmE = new l(frsGoodFragment.getPageContext(), bd.ahQ, this.dwd.getUniqueId());
        this.mAdapters.add(this.dmC);
        this.mAdapters.add(this.dnx);
        this.mAdapters.add(this.dmC);
        this.mAdapters.add(this.dnx);
        this.mAdapters.add(this.dmD);
        this.mAdapters.add(this.dmH);
        this.mAdapters.add(this.dmF);
        this.mAdapters.add(this.dmG);
        this.mAdapters.add(this.dmE);
        if (this.dnz != null) {
            this.mAdapters.add(this.dnz);
        }
        if (this.dnA != null) {
            this.mAdapters.add(this.dnA);
        }
        this.mAdapters.add(this.dwe);
        this.mAdapters.add(this.dwf);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dwd.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        iy("page_frs_good");
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof f) {
                ((f) aVar).release();
            }
        }
    }

    public void b(ArrayList<h> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        b(lVar);
        N(arrayList);
        q.o(arrayList, 1);
        L(arrayList);
        this.dmB.setData(arrayList);
        this.cQn = arrayList;
        this.dnI = lVar;
    }

    private ArrayList<Integer> L(ArrayList<h> arrayList) {
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
                if (this.dnH != null && !this.dnH.containsValue(hVar)) {
                    this.dnH.put(Integer.valueOf(i2), (bd) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    public HashMap<Integer, bd> avQ() {
        return this.dnH;
    }

    public void avR() {
        if (this.dmB != null && this.dmB.getData() != null && this.dmB.getData().size() != 0) {
            for (h hVar : this.dmB.getData()) {
                if ((hVar instanceof bd) && ((bd) hVar).vh() != 0) {
                    ((bd) hVar).vT();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.dmB.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.dmB.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).b(lVar);
                }
            }
        }
    }

    public void setOnAdapterItemClickListener(n nVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar != null && (aVar instanceof f)) {
                    ((f) aVar).setOnAdapterItemClickListener(nVar);
                }
            }
        }
    }

    private void N(ArrayList<h> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<h> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bd.ahI) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dwd != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.dwd.registerListener(this.dnK);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dwd == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.dnB = new ArrayList();
        ArrayList<BdUniqueId> bwn = q.bwn();
        if (bwn == null || bwn.size() <= 0) {
            return false;
        }
        int size = bwn.size();
        for (int i = 0; i < size; i++) {
            f<ICardInfo, ? extends q.a> a = com.baidu.tieba.frs.a.asO().a(this.dwd.getPageContext(), bwn.get(i), this.dwd.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dnB.add(a);
            }
        }
        if (!w.z(this.dnB)) {
            bdTypeRecyclerView.addAdapters(this.dnB);
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

    private void iy(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).iy(str);
                }
            }
        }
    }
}
