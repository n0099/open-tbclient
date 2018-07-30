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
    private BdTypeRecyclerView dqh;
    private l dqj;
    private FrsDynamicFragment dsB;
    private i dsC;
    private i dsD;
    private com.baidu.tieba.frs.entelechy.a.l dsE;
    private p dsF;
    private d dsG;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dsH = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.dynamic.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof aa) && "FrsHottopicDelegateAdapter".equals(((aa) aVar).aja()) && a.this.mAdapters != null) {
                        ((aa) aVar).a(a.this.dsB.getPageContext(), a.this.dsB.getUniqueId());
                        ((aa) aVar).setFrom("c13010");
                        a.this.mAdapters.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsDynamicFragment frsDynamicFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsDynamicFragment, bdTypeRecyclerView);
        this.dqh = bdTypeRecyclerView;
    }

    public void a(FrsDynamicFragment frsDynamicFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dsB = frsDynamicFragment;
        this.dsH.setPriority(1);
        this.dsH.setSelfListener(true);
        this.dsB.registerListener(this.dsH);
        this.dsC = new i(frsDynamicFragment.getPageContext(), bb.ahx, this.dsB.getUniqueId());
        this.dsC.setVoiceManager(frsDynamicFragment.getVoiceManager());
        this.dsC.setFrom("c13010");
        this.dsD = new i(frsDynamicFragment.getPageContext(), bb.ahz, this.dsB.getUniqueId());
        this.dsD.setVoiceManager(frsDynamicFragment.getVoiceManager());
        this.dsD.setFrom("c13010");
        this.dsE = new com.baidu.tieba.frs.entelechy.a.l(frsDynamicFragment.getPageContext(), bb.ahE, this.dsB.getUniqueId());
        this.dsE.setFrom("c13010");
        this.dsF = new p(frsDynamicFragment.getPageContext(), bb.ahA, this.dsB.getUniqueId());
        this.dsF.setFrom("c13010");
        this.dsG = new d(frsDynamicFragment.getPageContext(), bb.ahF, this.dsB.getUniqueId());
        this.dsG.setFrom("c13010");
        this.dqj = new l(frsDynamicFragment.getPageContext(), m.doV);
        this.mAdapters.add(this.dsC);
        this.mAdapters.add(this.dsD);
        this.mAdapters.add(this.dsE);
        this.mAdapters.add(this.dsF);
        this.mAdapters.add(this.dsG);
        this.mAdapters.add(this.dqj);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        iA("page_frs_dynamic");
    }

    public void setData(ArrayList<h> arrayList) {
        this.dqh.setData(arrayList);
    }

    public void notifyDataSetChanged() {
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

    public void setOnAdapterItemClickListener(n nVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.h)) {
                    aVar.setOnAdapterItemClickListener(nVar);
                }
            }
        }
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

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }
}
