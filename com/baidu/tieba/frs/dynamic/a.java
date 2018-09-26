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
    private BdTypeRecyclerView dwt;
    private l dwv;
    private p dyP;
    private d dyQ;
    private FrsDynamicFragment dzg;
    private i dzh;
    private i dzi;
    private com.baidu.tieba.frs.entelechy.a.l dzj;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dzk = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.dynamic.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof aa) && "FrsHottopicDelegateAdapter".equals(((aa) aVar).akO()) && a.this.mAdapters != null) {
                        ((aa) aVar).a(a.this.dzg.getPageContext(), a.this.dzg.getUniqueId());
                        ((aa) aVar).setFrom("c13010");
                        a.this.mAdapters.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsDynamicFragment frsDynamicFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsDynamicFragment, bdTypeRecyclerView);
        this.dwt = bdTypeRecyclerView;
    }

    public void a(FrsDynamicFragment frsDynamicFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dzg = frsDynamicFragment;
        this.dzk.setPriority(1);
        this.dzk.setSelfListener(true);
        this.dzg.registerListener(this.dzk);
        this.dzh = new i(frsDynamicFragment.getPageContext(), bb.ajX, this.dzg.getUniqueId());
        this.dzh.setVoiceManager(frsDynamicFragment.getVoiceManager());
        this.dzh.setFrom("c13010");
        this.dzi = new i(frsDynamicFragment.getPageContext(), bb.ajZ, this.dzg.getUniqueId());
        this.dzi.setVoiceManager(frsDynamicFragment.getVoiceManager());
        this.dzi.setFrom("c13010");
        this.dzj = new com.baidu.tieba.frs.entelechy.a.l(frsDynamicFragment.getPageContext(), bb.ake, this.dzg.getUniqueId());
        this.dzj.setFrom("c13010");
        this.dyP = new p(frsDynamicFragment.getPageContext(), bb.aka, this.dzg.getUniqueId());
        this.dyP.setFrom("c13010");
        this.dyQ = new d(frsDynamicFragment.getPageContext(), bb.akf, this.dzg.getUniqueId());
        this.dyQ.setFrom("c13010");
        this.dwv = new l(frsDynamicFragment.getPageContext(), m.duQ);
        this.mAdapters.add(this.dzh);
        this.mAdapters.add(this.dzi);
        this.mAdapters.add(this.dzj);
        this.mAdapters.add(this.dyP);
        this.mAdapters.add(this.dyQ);
        this.mAdapters.add(this.dwv);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        jd("page_frs_dynamic");
    }

    public void setData(ArrayList<h> arrayList) {
        this.dwt.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.dwt.getAdapter().notifyDataSetChanged();
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

    private void jd(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).jd(str);
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
