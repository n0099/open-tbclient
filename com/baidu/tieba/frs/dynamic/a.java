package com.baidu.tieba.frs.dynamic;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.bb;
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
    private BdTypeRecyclerView dqf;
    private l dqh;
    private i dsA;
    private com.baidu.tieba.frs.entelechy.a.l dsB;
    private p dsC;
    private d dsD;
    private FrsDynamicFragment dsy;
    private i dsz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dsE = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.dynamic.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof aa) && "FrsHottopicDelegateAdapter".equals(((aa) aVar).ajd()) && a.this.mAdapters != null) {
                        ((aa) aVar).a(a.this.dsy.getPageContext(), a.this.dsy.getUniqueId());
                        ((aa) aVar).setFrom("c13010");
                        a.this.mAdapters.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsDynamicFragment frsDynamicFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsDynamicFragment, bdTypeRecyclerView);
        this.dqf = bdTypeRecyclerView;
    }

    public void a(FrsDynamicFragment frsDynamicFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dsy = frsDynamicFragment;
        this.dsE.setPriority(1);
        this.dsE.setSelfListener(true);
        this.dsy.registerListener(this.dsE);
        this.dsz = new i(frsDynamicFragment.getPageContext(), bb.ahx, this.dsy.getUniqueId());
        this.dsz.setVoiceManager(frsDynamicFragment.getVoiceManager());
        this.dsz.setFrom("c13010");
        this.dsA = new i(frsDynamicFragment.getPageContext(), bb.ahz, this.dsy.getUniqueId());
        this.dsA.setVoiceManager(frsDynamicFragment.getVoiceManager());
        this.dsA.setFrom("c13010");
        this.dsB = new com.baidu.tieba.frs.entelechy.a.l(frsDynamicFragment.getPageContext(), bb.ahE, this.dsy.getUniqueId());
        this.dsB.setFrom("c13010");
        this.dsC = new p(frsDynamicFragment.getPageContext(), bb.ahA, this.dsy.getUniqueId());
        this.dsC.setFrom("c13010");
        this.dsD = new d(frsDynamicFragment.getPageContext(), bb.ahF, this.dsy.getUniqueId());
        this.dsD.setFrom("c13010");
        this.dqh = new l(frsDynamicFragment.getPageContext(), m.doT);
        this.mAdapters.add(this.dsz);
        this.mAdapters.add(this.dsA);
        this.mAdapters.add(this.dsB);
        this.mAdapters.add(this.dsC);
        this.mAdapters.add(this.dsD);
        this.mAdapters.add(this.dqh);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        iB("page_frs_dynamic");
    }

    public void setData(ArrayList<h> arrayList) {
        this.dqf.setData(arrayList);
    }

    public void notifyDataSetChanged() {
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

    public void setOnAdapterItemClickListener(n nVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.h)) {
                    aVar.setOnAdapterItemClickListener(nVar);
                }
            }
        }
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

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }
}
