package com.baidu.tieba.frs.dynamic;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tieba.a.f;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.d;
import com.baidu.tieba.frs.entelechy.a.i;
import com.baidu.tieba.frs.entelechy.a.p;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.frs.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView dnn;
    private l dnp;
    private FrsDynamicFragment dpO;
    private i dpP;
    private i dpQ;
    private com.baidu.tieba.frs.entelechy.a.l dpR;
    private p dpS;
    private d dpT;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dpU = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.dynamic.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof aa) && "FrsHottopicDelegateAdapter".equals(((aa) aVar).aiB()) && a.this.mAdapters != null) {
                        ((aa) aVar).a(a.this.dpO.getPageContext(), a.this.dpO.getUniqueId());
                        ((aa) aVar).setFrom("c13010");
                        a.this.mAdapters.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsDynamicFragment frsDynamicFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsDynamicFragment, bdTypeRecyclerView);
        this.dnn = bdTypeRecyclerView;
    }

    public void a(FrsDynamicFragment frsDynamicFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dpO = frsDynamicFragment;
        this.dpU.setPriority(1);
        this.dpU.setSelfListener(true);
        this.dpO.registerListener(this.dpU);
        this.dpP = new i(frsDynamicFragment.getPageContext(), bc.aib, this.dpO.getUniqueId());
        this.dpP.setVoiceManager(frsDynamicFragment.getVoiceManager());
        this.dpP.setFrom("c13010");
        this.dpQ = new i(frsDynamicFragment.getPageContext(), bc.aid, this.dpO.getUniqueId());
        this.dpQ.setVoiceManager(frsDynamicFragment.getVoiceManager());
        this.dpQ.setFrom("c13010");
        this.dpR = new com.baidu.tieba.frs.entelechy.a.l(frsDynamicFragment.getPageContext(), bc.aii, this.dpO.getUniqueId());
        this.dpR.setFrom("c13010");
        this.dpS = new p(frsDynamicFragment.getPageContext(), bc.aie, this.dpO.getUniqueId());
        this.dpS.setFrom("c13010");
        this.dpT = new d(frsDynamicFragment.getPageContext(), bc.aij, this.dpO.getUniqueId());
        this.dpT.setFrom("c13010");
        this.dnp = new l(frsDynamicFragment.getPageContext(), m.dmd);
        this.mAdapters.add(this.dpP);
        this.mAdapters.add(this.dpQ);
        this.mAdapters.add(this.dpR);
        this.mAdapters.add(this.dpS);
        this.mAdapters.add(this.dpT);
        this.mAdapters.add(this.dnp);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        iD("page_frs_dynamic");
    }

    public void setData(ArrayList<h> arrayList) {
        this.dnn.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.dnn.getAdapter().notifyDataSetChanged();
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

    public void setOnAdapterItemClickListener(n nVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.h)) {
                    aVar.setOnAdapterItemClickListener(nVar);
                }
            }
        }
    }

    private void iD(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).iD(str);
                }
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
}
