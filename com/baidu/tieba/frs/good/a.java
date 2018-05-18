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
    private ArrayList<h> cHg;
    private BdTypeRecyclerView ddm;
    private i ddn;
    private i ddo;
    private l ddp;
    private p ddq;
    private d ddr;
    private j dds;
    private g dei;
    private com.baidu.adp.widget.ListView.a dek;
    private com.baidu.adp.widget.ListView.a del;
    private List<com.baidu.adp.widget.ListView.a> dem;
    private final HashMap<Integer, bd> det;
    private com.baidu.tieba.tbadkCore.l deu;
    private FrsGoodFragment dmL;
    private com.baidu.adp.widget.ListView.a dmM;
    private com.baidu.adp.widget.ListView.a dmN;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener ddt = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.good.a.1
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
                        ((f) aVar).a(a.this.dmL.getPageContext(), a.this.dmL.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (a.this.mAdapters != null) {
                    a.this.mAdapters.addAll(arrayList);
                }
                if (a.this.ddm != null) {
                    a.this.ddm.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dew = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.good.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.w(a.this.dem)) {
                a.this.b(a.this.ddm);
                a.this.b(a.this.cHg, a.this.deu);
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.ddm = bdTypeRecyclerView;
        this.det = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dmL = frsGoodFragment;
        this.ddt.setPriority(1);
        this.ddt.setSelfListener(true);
        this.dmL.registerListener(this.ddt);
        this.ddn = new i(frsGoodFragment.getPageContext(), bd.ZH, this.dmL.getUniqueId());
        this.ddn.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.dei = new g(frsGoodFragment.getPageContext(), bd.ZI, this.dmL.getUniqueId());
        this.ddo = new i(frsGoodFragment.getPageContext(), bd.ZJ, this.dmL.getUniqueId());
        this.ddo.setVoiceManager(frsGoodFragment.getVoiceManager());
        this.ddq = new p(frsGoodFragment.getPageContext(), bd.ZK, this.dmL.getUniqueId());
        this.ddr = new d(frsGoodFragment.getPageContext(), bd.ZP, this.dmL.getUniqueId());
        this.dds = new j(frsGoodFragment.getPageContext(), k.daG);
        this.dek = com.baidu.tieba.frs.a.aoJ().a(frsGoodFragment.getPageContext(), bd.aaW, this.dmL.getUniqueId(), true);
        this.del = com.baidu.tieba.frs.a.aoJ().b(frsGoodFragment.getPageContext(), bd.abf, this.dmL.getUniqueId());
        this.dmM = r.bjk().a(this.dmL, AdvertAppInfo.Vu);
        this.dmN = r.bjk().a(this.dmL, AdvertAppInfo.VD);
        this.ddp = new l(frsGoodFragment.getPageContext(), bd.ZO, this.dmL.getUniqueId());
        this.mAdapters.add(this.ddn);
        this.mAdapters.add(this.dei);
        this.mAdapters.add(this.ddn);
        this.mAdapters.add(this.dei);
        this.mAdapters.add(this.ddo);
        this.mAdapters.add(this.dds);
        this.mAdapters.add(this.ddq);
        this.mAdapters.add(this.ddr);
        this.mAdapters.add(this.ddp);
        if (this.dek != null) {
            this.mAdapters.add(this.dek);
        }
        if (this.del != null) {
            this.mAdapters.add(this.del);
        }
        this.mAdapters.add(this.dmM);
        this.mAdapters.add(this.dmN);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dmL.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        hZ("page_frs_good");
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
        this.ddm.setData(arrayList);
        this.cHg = arrayList;
        this.deu = lVar;
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
                if (this.det != null && !this.det.containsValue(hVar)) {
                    this.det.put(Integer.valueOf(i2), (bd) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    public HashMap<Integer, bd> arL() {
        return this.det;
    }

    public void arM() {
        if (this.ddm != null && this.ddm.getData() != null && this.ddm.getData().size() != 0) {
            for (h hVar : this.ddm.getData()) {
                if ((hVar instanceof bd) && ((bd) hVar).rK() != 0) {
                    ((bd) hVar).sw();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.ddm.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.ddm.getAdapter().notifyDataSetChanged();
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
        if (this.dmL != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.dmL.registerListener(this.dew);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dmL == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.dem = new ArrayList();
        ArrayList<BdUniqueId> brl = q.brl();
        if (brl == null || brl.size() <= 0) {
            return false;
        }
        int size = brl.size();
        for (int i = 0; i < size; i++) {
            f<ICardInfo, ? extends q.a> a = com.baidu.tieba.frs.a.aoJ().a(this.dmL.getPageContext(), brl.get(i), this.dmL.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dem.add(a);
            }
        }
        if (!v.w(this.dem)) {
            bdTypeRecyclerView.addAdapters(this.dem);
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

    private void hZ(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).hZ(str);
                }
            }
        }
    }
}
