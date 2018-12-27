package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.a.f;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
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
    private BdTypeRecyclerView bRn;
    private l dOZ;
    private FrsCommonTabFragment dRq;
    private i dRr;
    private i dRs;
    private com.baidu.tieba.frs.entelechy.a.l dRt;
    private p dRu;
    private com.baidu.tieba.frs.entelechy.a.d dRv;
    private boolean dRw;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dRx = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof aa) && "FrsHottopicDelegateAdapter".equals(((aa) aVar).aqu()) && a.this.mAdapters != null) {
                        ((aa) aVar).a(a.this.dRq.getPageContext(), a.this.dRq.getUniqueId());
                        if (a.this.dRw) {
                            ((aa) aVar).setFrom("c13010");
                        }
                        a.this.mAdapters.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsCommonTabFragment, bdTypeRecyclerView);
        this.bRn = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dRq = frsCommonTabFragment;
        this.dRx.setPriority(1);
        this.dRx.setSelfListener(true);
        this.dRq.registerListener(this.dRx);
        this.dRr = new i(frsCommonTabFragment.getPageContext(), bb.atg, this.dRq.getUniqueId());
        this.dRr.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.dRs = new i(frsCommonTabFragment.getPageContext(), bb.ati, this.dRq.getUniqueId());
        this.dRs.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.dRt = new com.baidu.tieba.frs.entelechy.a.l(frsCommonTabFragment.getPageContext(), bb.atn, this.dRq.getUniqueId());
        this.dRu = new p(frsCommonTabFragment.getPageContext(), bb.atj, this.dRq.getUniqueId());
        this.dRu.dRC = this.dRq.dRC;
        this.dRv = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bb.ato, this.dRq.getUniqueId());
        this.dRv.dRC = this.dRq.dRC;
        this.dOZ = new l(frsCommonTabFragment.getPageContext(), m.dNu);
        this.mAdapters.add(this.dRr);
        this.mAdapters.add(this.dRs);
        this.mAdapters.add(this.dRt);
        this.mAdapters.add(this.dRu);
        this.mAdapters.add(this.dRv);
        this.mAdapters.add(this.dOZ);
        if (frsCommonTabFragment.tabId == 89) {
            this.dRw = true;
            this.dRr.setFrom("c13010");
            this.dRs.setFrom("c13010");
            this.dRt.setFrom("c13010");
            this.dRu.setFrom("c13010");
            this.dRv.setFrom("c13010");
            jL("page_frs_dynamic");
        }
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        aDW();
    }

    public void setData(ArrayList<h> arrayList) {
        this.bRn.setData(arrayList);
    }

    private void aDW() {
        if (this.dRq != null && !v.I(this.mAdapters)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.d) {
                    com.baidu.tieba.frs.e.d dVar = (com.baidu.tieba.frs.e.d) aVar;
                    if (dVar.aEI() != null) {
                        dVar.aEI().eed = this.dRq.dRB;
                        dVar.aEI().eef = this.dRq.forumId;
                        dVar.aEI().eeg = this.dRq.tabId;
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.bRn.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    private void jL(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).jL(str);
                }
            }
        }
    }
}
