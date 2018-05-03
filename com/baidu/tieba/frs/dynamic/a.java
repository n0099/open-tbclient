package com.baidu.tieba.frs.dynamic;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.d;
import com.baidu.tieba.frs.entelechy.a.i;
import com.baidu.tieba.frs.entelechy.a.l;
import com.baidu.tieba.frs.entelechy.a.p;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.frs.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private FrsDynamicFragment dcd;
    private BdTypeRecyclerView dce;
    private i dcf;
    private i dcg;
    private l dch;
    private p dci;
    private d dcj;
    private j dck;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dcl = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.dynamic.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof z) && "FrsHottopicDelegateAdapter".equals(((z) aVar).afC()) && a.this.mAdapters != null) {
                        ((z) aVar).a(a.this.dcd.getPageContext(), a.this.dcd.getUniqueId());
                        ((z) aVar).setFrom("c13010");
                        a.this.mAdapters.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsDynamicFragment frsDynamicFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsDynamicFragment, bdTypeRecyclerView);
        this.dce = bdTypeRecyclerView;
    }

    public void a(FrsDynamicFragment frsDynamicFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dcd = frsDynamicFragment;
        this.dcl.setPriority(1);
        this.dcl.setSelfListener(true);
        this.dcd.registerListener(this.dcl);
        this.dcf = new i(frsDynamicFragment.getPageContext(), bd.ZH, this.dcd.getUniqueId());
        this.dcf.setVoiceManager(frsDynamicFragment.getVoiceManager());
        this.dcf.setFrom("c13010");
        this.dcg = new i(frsDynamicFragment.getPageContext(), bd.ZJ, this.dcd.getUniqueId());
        this.dcg.setVoiceManager(frsDynamicFragment.getVoiceManager());
        this.dcg.setFrom("c13010");
        this.dch = new l(frsDynamicFragment.getPageContext(), bd.ZO, this.dcd.getUniqueId());
        this.dch.setFrom("c13010");
        this.dci = new p(frsDynamicFragment.getPageContext(), bd.ZK, this.dcd.getUniqueId());
        this.dci.setFrom("c13010");
        this.dcj = new d(frsDynamicFragment.getPageContext(), bd.ZP, this.dcd.getUniqueId());
        this.dcj.setFrom("c13010");
        this.dck = new j(frsDynamicFragment.getPageContext(), k.cZx);
        this.mAdapters.add(this.dcf);
        this.mAdapters.add(this.dcg);
        this.mAdapters.add(this.dch);
        this.mAdapters.add(this.dci);
        this.mAdapters.add(this.dcj);
        this.mAdapters.add(this.dck);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        hY("page_frs_dynamic");
    }

    public void setData(ArrayList<h> arrayList) {
        this.dce.setData(arrayList);
    }

    public void notifyDataSetChanged() {
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

    public void setOnAdapterItemClickListener(n nVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar != null && (aVar instanceof f)) {
                    aVar.setOnAdapterItemClickListener(nVar);
                }
            }
        }
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

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof f) {
                ((f) aVar).release();
            }
        }
    }
}
