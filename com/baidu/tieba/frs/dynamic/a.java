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
    private FrsDynamicFragment ddl;
    private BdTypeRecyclerView ddm;
    private i ddn;
    private i ddo;
    private l ddp;
    private p ddq;
    private d ddr;
    private j dds;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener ddt = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.dynamic.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof z) && "FrsHottopicDelegateAdapter".equals(((z) aVar).afC()) && a.this.mAdapters != null) {
                        ((z) aVar).a(a.this.ddl.getPageContext(), a.this.ddl.getUniqueId());
                        ((z) aVar).setFrom("c13010");
                        a.this.mAdapters.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsDynamicFragment frsDynamicFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsDynamicFragment, bdTypeRecyclerView);
        this.ddm = bdTypeRecyclerView;
    }

    public void a(FrsDynamicFragment frsDynamicFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.ddl = frsDynamicFragment;
        this.ddt.setPriority(1);
        this.ddt.setSelfListener(true);
        this.ddl.registerListener(this.ddt);
        this.ddn = new i(frsDynamicFragment.getPageContext(), bd.ZH, this.ddl.getUniqueId());
        this.ddn.setVoiceManager(frsDynamicFragment.getVoiceManager());
        this.ddn.setFrom("c13010");
        this.ddo = new i(frsDynamicFragment.getPageContext(), bd.ZJ, this.ddl.getUniqueId());
        this.ddo.setVoiceManager(frsDynamicFragment.getVoiceManager());
        this.ddo.setFrom("c13010");
        this.ddp = new l(frsDynamicFragment.getPageContext(), bd.ZO, this.ddl.getUniqueId());
        this.ddp.setFrom("c13010");
        this.ddq = new p(frsDynamicFragment.getPageContext(), bd.ZK, this.ddl.getUniqueId());
        this.ddq.setFrom("c13010");
        this.ddr = new d(frsDynamicFragment.getPageContext(), bd.ZP, this.ddl.getUniqueId());
        this.ddr.setFrom("c13010");
        this.dds = new j(frsDynamicFragment.getPageContext(), k.daG);
        this.mAdapters.add(this.ddn);
        this.mAdapters.add(this.ddo);
        this.mAdapters.add(this.ddp);
        this.mAdapters.add(this.ddq);
        this.mAdapters.add(this.ddr);
        this.mAdapters.add(this.dds);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        hZ("page_frs_dynamic");
    }

    public void setData(ArrayList<h> arrayList) {
        this.ddm.setData(arrayList);
    }

    public void notifyDataSetChanged() {
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

    public void setOnAdapterItemClickListener(n nVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar != null && (aVar instanceof f)) {
                    aVar.setOnAdapterItemClickListener(nVar);
                }
            }
        }
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

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof f) {
                ((f) aVar).release();
            }
        }
    }
}
