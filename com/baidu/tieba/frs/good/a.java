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
    private ArrayList<h> cFX;
    private BdTypeRecyclerView dce;
    private i dcf;
    private i dcg;
    private l dch;
    private p dci;
    private d dcj;
    private j dck;
    private g dda;
    private com.baidu.adp.widget.ListView.a ddc;
    private com.baidu.adp.widget.ListView.a ddd;
    private List<com.baidu.adp.widget.ListView.a> dde;
    private final HashMap<Integer, bd> ddk;
    private com.baidu.tieba.tbadkCore.l ddl;
    private FrsGoodFragment dlE;
    private com.baidu.adp.widget.ListView.a dlF;
    private com.baidu.adp.widget.ListView.a dlG;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dcl = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.a.1
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
                        ((f) aVar).a(a.this.dlE.getPageContext(), a.this.dlE.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (a.this.mAdapters != null) {
                    a.this.mAdapters.addAll(arrayList);
                }
                if (a.this.dce != null) {
                    a.this.dce.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener ddn = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.w(a.this.dde)) {
                a.this.b(a.this.dce);
                a.this.b(a.this.cFX, a.this.ddl);
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.dce = bdTypeRecyclerView;
        this.ddk = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dlE = frsGoodFragment;
        this.dcl.setPriority(1);
        this.dcl.setSelfListener(true);
        this.dlE.registerListener(this.dcl);
        this.dcf = new i(frsGoodFragment.getPageContext(), bd.ZH, this.dlE.getUniqueId());
        this.dcf.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dda = new g(frsGoodFragment.getPageContext(), bd.ZI, this.dlE.getUniqueId());
        this.dcg = new i(frsGoodFragment.getPageContext(), bd.ZJ, this.dlE.getUniqueId());
        this.dcg.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dci = new p(frsGoodFragment.getPageContext(), bd.ZK, this.dlE.getUniqueId());
        this.dcj = new d(frsGoodFragment.getPageContext(), bd.ZP, this.dlE.getUniqueId());
        this.dck = new j(frsGoodFragment.getPageContext(), k.cZx);
        this.ddc = com.baidu.tieba.frs.a.aoK().a(frsGoodFragment.getPageContext(), bd.aaV, this.dlE.getUniqueId(), true);
        this.ddd = com.baidu.tieba.frs.a.aoK().b(frsGoodFragment.getPageContext(), bd.abe, this.dlE.getUniqueId());
        this.dlF = r.bjl().a(this.dlE, AdvertAppInfo.Vy);
        this.dlG = r.bjl().a(this.dlE, AdvertAppInfo.VH);
        this.dch = new l(frsGoodFragment.getPageContext(), bd.ZO, this.dlE.getUniqueId());
        this.mAdapters.add(this.dcf);
        this.mAdapters.add(this.dda);
        this.mAdapters.add(this.dcf);
        this.mAdapters.add(this.dda);
        this.mAdapters.add(this.dcg);
        this.mAdapters.add(this.dck);
        this.mAdapters.add(this.dci);
        this.mAdapters.add(this.dcj);
        this.mAdapters.add(this.dch);
        if (this.ddc != null) {
            this.mAdapters.add(this.ddc);
        }
        if (this.ddd != null) {
            this.mAdapters.add(this.ddd);
        }
        this.mAdapters.add(this.dlF);
        this.mAdapters.add(this.dlG);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dlE.getUniqueId());
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
        this.dce.setData(arrayList);
        this.cFX = arrayList;
        this.ddl = lVar;
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
                if (this.ddk != null && !this.ddk.containsValue(hVar)) {
                    this.ddk.put(Integer.valueOf(i2), (bd) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    public HashMap<Integer, bd> arM() {
        return this.ddk;
    }

    public void arN() {
        if (this.dce != null && this.dce.getData() != null && this.dce.getData().size() != 0) {
            for (h hVar : this.dce.getData()) {
                if ((hVar instanceof bd) && ((bd) hVar).rL() != 0) {
                    ((bd) hVar).sx();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.dce.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.dce.getAdapter().notifyDataSetChanged();
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
        if (this.dlE != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.dlE.registerListener(this.ddn);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dlE == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.dde = new ArrayList();
        ArrayList<BdUniqueId> brn = q.brn();
        if (brn == null || brn.size() <= 0) {
            return false;
        }
        int size = brn.size();
        for (int i = 0; i < size; i++) {
            f<ICardInfo, ? extends q.a> a = com.baidu.tieba.frs.a.aoK().a(this.dlE.getPageContext(), brn.get(i), this.dlE.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dde.add(a);
            }
        }
        if (!v.w(this.dde)) {
            bdTypeRecyclerView.addAdapters(this.dde);
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
