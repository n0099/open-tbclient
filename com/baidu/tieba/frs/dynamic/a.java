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
/* loaded from: classes6.dex */
public class a {
    private BdTypeRecyclerView dEu;
    private l dEw;
    private p dGP;
    private d dGQ;
    private FrsDynamicFragment dHg;
    private i dHh;
    private i dHi;
    private com.baidu.tieba.frs.entelechy.a.l dHj;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dHk = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.dynamic.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof aa) && "FrsHottopicDelegateAdapter".equals(((aa) aVar).aoq()) && a.this.mAdapters != null) {
                        ((aa) aVar).a(a.this.dHg.getPageContext(), a.this.dHg.getUniqueId());
                        ((aa) aVar).setFrom("c13010");
                        a.this.mAdapters.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsDynamicFragment frsDynamicFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsDynamicFragment, bdTypeRecyclerView);
        this.dEu = bdTypeRecyclerView;
    }

    public void a(FrsDynamicFragment frsDynamicFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dHg = frsDynamicFragment;
        this.dHk.setPriority(1);
        this.dHk.setSelfListener(true);
        this.dHg.registerListener(this.dHk);
        this.dHh = new i(frsDynamicFragment.getPageContext(), bb.aoS, this.dHg.getUniqueId());
        this.dHh.setVoiceManager(frsDynamicFragment.getVoiceManager());
        this.dHh.setFrom("c13010");
        this.dHi = new i(frsDynamicFragment.getPageContext(), bb.aoU, this.dHg.getUniqueId());
        this.dHi.setVoiceManager(frsDynamicFragment.getVoiceManager());
        this.dHi.setFrom("c13010");
        this.dHj = new com.baidu.tieba.frs.entelechy.a.l(frsDynamicFragment.getPageContext(), bb.aoZ, this.dHg.getUniqueId());
        this.dHj.setFrom("c13010");
        this.dGP = new p(frsDynamicFragment.getPageContext(), bb.aoV, this.dHg.getUniqueId());
        this.dGP.setFrom("c13010");
        this.dGQ = new d(frsDynamicFragment.getPageContext(), bb.apa, this.dHg.getUniqueId());
        this.dGQ.setFrom("c13010");
        this.dEw = new l(frsDynamicFragment.getPageContext(), m.dCR);
        this.mAdapters.add(this.dHh);
        this.mAdapters.add(this.dHi);
        this.mAdapters.add(this.dHj);
        this.mAdapters.add(this.dGP);
        this.mAdapters.add(this.dGQ);
        this.mAdapters.add(this.dEw);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        jq("page_frs_dynamic");
    }

    public void setData(ArrayList<h> arrayList) {
        this.dEu.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.dEu.getAdapter().notifyDataSetChanged();
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

    private void jq(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).jq(str);
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
