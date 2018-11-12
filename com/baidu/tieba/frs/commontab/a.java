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
    private BdTypeRecyclerView bNt;
    private l dFM;
    private FrsCommonTabFragment dId;
    private i dIe;
    private i dIf;
    private com.baidu.tieba.frs.entelechy.a.l dIg;
    private p dIh;
    private com.baidu.tieba.frs.entelechy.a.d dIi;
    private boolean dIj;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dIk = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof aa) && "FrsHottopicDelegateAdapter".equals(((aa) aVar).anS()) && a.this.mAdapters != null) {
                        ((aa) aVar).a(a.this.dId.getPageContext(), a.this.dId.getUniqueId());
                        if (a.this.dIj) {
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
        this.bNt = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dId = frsCommonTabFragment;
        this.dIk.setPriority(1);
        this.dIk.setSelfListener(true);
        this.dId.registerListener(this.dIk);
        this.dIe = new i(frsCommonTabFragment.getPageContext(), bb.apG, this.dId.getUniqueId());
        this.dIe.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.dIf = new i(frsCommonTabFragment.getPageContext(), bb.apI, this.dId.getUniqueId());
        this.dIf.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.dIg = new com.baidu.tieba.frs.entelechy.a.l(frsCommonTabFragment.getPageContext(), bb.apN, this.dId.getUniqueId());
        this.dIh = new p(frsCommonTabFragment.getPageContext(), bb.apJ, this.dId.getUniqueId());
        this.dIh.dIp = this.dId.dIp;
        this.dIi = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bb.apO, this.dId.getUniqueId());
        this.dIi.dIp = this.dId.dIp;
        this.dFM = new l(frsCommonTabFragment.getPageContext(), m.dEh);
        this.mAdapters.add(this.dIe);
        this.mAdapters.add(this.dIf);
        this.mAdapters.add(this.dIg);
        this.mAdapters.add(this.dIh);
        this.mAdapters.add(this.dIi);
        this.mAdapters.add(this.dFM);
        if (frsCommonTabFragment.tabId == 89) {
            this.dIj = true;
            this.dIe.setFrom("c13010");
            this.dIf.setFrom("c13010");
            this.dIg.setFrom("c13010");
            this.dIh.setFrom("c13010");
            this.dIi.setFrom("c13010");
            js("page_frs_dynamic");
        }
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        aBx();
    }

    public void setData(ArrayList<h> arrayList) {
        this.bNt.setData(arrayList);
    }

    private void aBx() {
        if (this.dId != null && !v.I(this.mAdapters)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (cVar.aCh() != null) {
                        cVar.aCh().dUJ = this.dId.dIo;
                        cVar.aCh().dUL = this.dId.forumId;
                        cVar.aCh().dUM = this.dId.tabId;
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.bNt.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    private void js(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).js(str);
                }
            }
        }
    }
}
