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
import com.baidu.tbadk.core.util.v;
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
    private ArrayList<h> cGa;
    private BdTypeRecyclerView dch;
    private i dci;
    private i dcj;
    private l dck;
    private p dcl;
    private d dcm;
    private j dcn;
    private g ddd;
    private com.baidu.adp.widget.ListView.a ddf;
    private com.baidu.adp.widget.ListView.a ddg;
    private List<com.baidu.adp.widget.ListView.a> ddh;
    private final HashMap<Integer, bd> ddn;
    private com.baidu.tieba.tbadkCore.l ddo;
    private FrsGoodFragment dlH;
    private com.baidu.adp.widget.ListView.a dlI;
    private com.baidu.adp.widget.ListView.a dlJ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dco = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.a.1
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
                        ((f) aVar).a(a.this.dlH.getPageContext(), a.this.dlH.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (a.this.mAdapters != null) {
                    a.this.mAdapters.addAll(arrayList);
                }
                if (a.this.dch != null) {
                    a.this.dch.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener ddq = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.w(a.this.ddh)) {
                a.this.b(a.this.dch);
                a.this.b(a.this.cGa, a.this.ddo);
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.dch = bdTypeRecyclerView;
        this.ddn = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dlH = frsGoodFragment;
        this.dco.setPriority(1);
        this.dco.setSelfListener(true);
        this.dlH.registerListener(this.dco);
        this.dci = new i(frsGoodFragment.getPageContext(), bd.ZH, this.dlH.getUniqueId());
        this.dci.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.ddd = new g(frsGoodFragment.getPageContext(), bd.ZI, this.dlH.getUniqueId());
        this.dcj = new i(frsGoodFragment.getPageContext(), bd.ZJ, this.dlH.getUniqueId());
        this.dcj.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dcl = new p(frsGoodFragment.getPageContext(), bd.ZK, this.dlH.getUniqueId());
        this.dcm = new d(frsGoodFragment.getPageContext(), bd.ZP, this.dlH.getUniqueId());
        this.dcn = new j(frsGoodFragment.getPageContext(), k.cZA);
        this.ddf = com.baidu.tieba.frs.a.aoK().a(frsGoodFragment.getPageContext(), bd.aaV, this.dlH.getUniqueId(), true);
        this.ddg = com.baidu.tieba.frs.a.aoK().b(frsGoodFragment.getPageContext(), bd.abe, this.dlH.getUniqueId());
        this.dlI = r.bjl().a(this.dlH, AdvertAppInfo.Vy);
        this.dlJ = r.bjl().a(this.dlH, AdvertAppInfo.VH);
        this.dck = new l(frsGoodFragment.getPageContext(), bd.ZO, this.dlH.getUniqueId());
        this.mAdapters.add(this.dci);
        this.mAdapters.add(this.ddd);
        this.mAdapters.add(this.dci);
        this.mAdapters.add(this.ddd);
        this.mAdapters.add(this.dcj);
        this.mAdapters.add(this.dcn);
        this.mAdapters.add(this.dcl);
        this.mAdapters.add(this.dcm);
        this.mAdapters.add(this.dck);
        if (this.ddf != null) {
            this.mAdapters.add(this.ddf);
        }
        if (this.ddg != null) {
            this.mAdapters.add(this.ddg);
        }
        this.mAdapters.add(this.dlI);
        this.mAdapters.add(this.dlJ);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dlH.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        hY("page_frs_good");
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
        O(arrayList);
        q.n(arrayList, 1);
        M(arrayList);
        this.dch.setData(arrayList);
        this.cGa = arrayList;
        this.ddo = lVar;
    }

    private ArrayList<Integer> M(ArrayList<h> arrayList) {
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
                if (this.ddn != null && !this.ddn.containsValue(hVar)) {
                    this.ddn.put(Integer.valueOf(i2), (bd) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    public HashMap<Integer, bd> arM() {
        return this.ddn;
    }

    public void arN() {
        if (this.dch != null && this.dch.getData() != null && this.dch.getData().size() != 0) {
            for (h hVar : this.dch.getData()) {
                if ((hVar instanceof bd) && ((bd) hVar).rL() != 0) {
                    ((bd) hVar).sx();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.dch.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.dch.getAdapter().notifyDataSetChanged();
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

    private void O(ArrayList<h> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<h> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bd.ZG) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dlH != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.dlH.registerListener(this.ddq);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dlH == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.ddh = new ArrayList();
        ArrayList<BdUniqueId> brn = q.brn();
        if (brn == null || brn.size() <= 0) {
            return false;
        }
        int size = brn.size();
        for (int i = 0; i < size; i++) {
            f<ICardInfo, ? extends q.a> a = com.baidu.tieba.frs.a.aoK().a(this.dlH.getPageContext(), brn.get(i), this.dlH.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.ddh.add(a);
            }
        }
        if (!v.w(this.ddh)) {
            bdTypeRecyclerView.addAdapters(this.ddh);
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

    private void hY(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).hY(str);
                }
            }
        }
    }
}
