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
    private BdTypeRecyclerView bRY;
    private l dPI;
    private FrsCommonTabFragment dRZ;
    private i dSa;
    private i dSb;
    private com.baidu.tieba.frs.entelechy.a.l dSc;
    private p dSd;
    private com.baidu.tieba.frs.entelechy.a.d dSe;
    private boolean dSf;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dSg = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof aa) && "FrsHottopicDelegateAdapter".equals(((aa) aVar).aqR()) && a.this.mAdapters != null) {
                        ((aa) aVar).a(a.this.dRZ.getPageContext(), a.this.dRZ.getUniqueId());
                        if (a.this.dSf) {
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
        this.bRY = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dRZ = frsCommonTabFragment;
        this.dSg.setPriority(1);
        this.dSg.setSelfListener(true);
        this.dRZ.registerListener(this.dSg);
        this.dSa = new i(frsCommonTabFragment.getPageContext(), bb.atI, this.dRZ.getUniqueId());
        this.dSa.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.dSb = new i(frsCommonTabFragment.getPageContext(), bb.atK, this.dRZ.getUniqueId());
        this.dSb.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.dSc = new com.baidu.tieba.frs.entelechy.a.l(frsCommonTabFragment.getPageContext(), bb.atP, this.dRZ.getUniqueId());
        this.dSd = new p(frsCommonTabFragment.getPageContext(), bb.atL, this.dRZ.getUniqueId());
        this.dSd.dSl = this.dRZ.dSl;
        this.dSe = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bb.atQ, this.dRZ.getUniqueId());
        this.dSe.dSl = this.dRZ.dSl;
        this.dPI = new l(frsCommonTabFragment.getPageContext(), m.dOd);
        this.mAdapters.add(this.dSa);
        this.mAdapters.add(this.dSb);
        this.mAdapters.add(this.dSc);
        this.mAdapters.add(this.dSd);
        this.mAdapters.add(this.dSe);
        this.mAdapters.add(this.dPI);
        if (frsCommonTabFragment.tabId == 89) {
            this.dSf = true;
            this.dSa.setFrom("c13010");
            this.dSb.setFrom("c13010");
            this.dSc.setFrom("c13010");
            this.dSd.setFrom("c13010");
            this.dSe.setFrom("c13010");
            kb("page_frs_dynamic");
        }
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        aEt();
    }

    public void setData(ArrayList<h> arrayList) {
        this.bRY.setData(arrayList);
    }

    private void aEt() {
        if (this.dRZ != null && !v.I(this.mAdapters)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.d) {
                    com.baidu.tieba.frs.e.d dVar = (com.baidu.tieba.frs.e.d) aVar;
                    if (dVar.aFf() != null) {
                        dVar.aFf().eeJ = this.dRZ.dSk;
                        dVar.aFf().eeL = this.dRZ.forumId;
                        dVar.aFf().eeM = this.dRZ.tabId;
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.bRY.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    private void kb(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).kb(str);
                }
            }
        }
    }
}
